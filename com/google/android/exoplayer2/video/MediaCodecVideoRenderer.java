package com.google.android.exoplayer2.video;

import adn.analytics.Analytics;
import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecDecoderException;
import com.google.android.exoplayer2.mediacodec.MediaCodecInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.DebugViewProvider;
import com.google.android.exoplayer2.util.Effect;
import com.google.android.exoplayer2.util.FrameInfo;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MediaFormatUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Size;
import com.google.android.exoplayer2.util.SurfaceInfo;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.util.VideoFrameProcessingException;
import com.google.android.exoplayer2.util.VideoFrameProcessor;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.gms.common.Scopes;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableList;
import com.ironsource.D5;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.core.di.ServiceProvider;
import io.bidmachine.iab.vast.tags.VastAttributes;
import io.bidmachine.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import io.bidmachine.media3.extractor.ts.TsExtractor;
import io.ktor.util.date.GMTDateParser;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@Deprecated
/* loaded from: classes4.dex */
public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final int HEVC_MAX_INPUT_SIZE_THRESHOLD = 2097152;
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    private final Context context;
    private VideoSize decodedVideoSize;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private Surface displaySurface;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseHelper frameReleaseHelper;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    private long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastBufferPresentationTimeUs;
    private long lastFrameReleaseTimeNs;
    private long lastRenderRealtimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private PlaceholderSurface placeholderSurface;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private VideoSize reportedVideoSize;
    private int scalingMode;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private int videoFrameProcessingOffsetCount;
    private final VideoFrameProcessorManager videoFrameProcessorManager;

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    private static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, 0L);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j) {
        this(context, mediaCodecSelector, j, null, null, 0);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, false, handler, videoRendererEventListener, i, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context, factory, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, float f) {
        super(2, factory, mediaCodecSelector, z, f);
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        Context applicationContext = context.getApplicationContext();
        this.context = applicationContext;
        VideoFrameReleaseHelper videoFrameReleaseHelper = new VideoFrameReleaseHelper(applicationContext);
        this.frameReleaseHelper = videoFrameReleaseHelper;
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.videoFrameProcessorManager = new VideoFrameProcessorManager(videoFrameReleaseHelper, this);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.joiningDeadlineMs = -9223372036854775807L;
        this.scalingMode = 1;
        this.decodedVideoSize = VideoSize.UNKNOWN;
        this.tunnelingAudioSessionId = 0;
        clearReportedVideoSize();
    }

    @Override // com.google.android.exoplayer2.Renderer, com.google.android.exoplayer2.RendererCapabilities
    public String getName() {
        return TAG;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int supportsFormat(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        boolean z;
        int i = 0;
        if (!MimeTypes.isVideo(format.sampleMimeType)) {
            return RendererCapabilities.create(0);
        }
        boolean z2 = format.drmInitData != null;
        List<MediaCodecInfo> decoderInfos = getDecoderInfos(this.context, mediaCodecSelector, format, z2, false);
        if (z2 && decoderInfos.isEmpty()) {
            decoderInfos = getDecoderInfos(this.context, mediaCodecSelector, format, false, false);
        }
        if (decoderInfos.isEmpty()) {
            return RendererCapabilities.create(1);
        }
        if (!supportsFormatDrm(format)) {
            return RendererCapabilities.create(2);
        }
        MediaCodecInfo mediaCodecInfo = decoderInfos.get(0);
        boolean isFormatSupported = mediaCodecInfo.isFormatSupported(format);
        if (!isFormatSupported) {
            for (int i2 = 1; i2 < decoderInfos.size(); i2++) {
                MediaCodecInfo mediaCodecInfo2 = decoderInfos.get(i2);
                if (mediaCodecInfo2.isFormatSupported(format)) {
                    z = false;
                    isFormatSupported = true;
                    mediaCodecInfo = mediaCodecInfo2;
                    break;
                }
            }
        }
        z = true;
        int i3 = isFormatSupported ? 4 : 3;
        int i4 = mediaCodecInfo.isSeamlessAdaptationSupported(format) ? 16 : 8;
        int i5 = mediaCodecInfo.hardwareAccelerated ? 64 : 0;
        int i6 = z ? 128 : 0;
        if (Util.SDK_INT >= 26 && "video/dolby-vision".equals(format.sampleMimeType) && !Api26.doesDisplaySupportDolbyVision(this.context)) {
            i6 = 256;
        }
        if (isFormatSupported) {
            List<MediaCodecInfo> decoderInfos2 = getDecoderInfos(this.context, mediaCodecSelector, format, z2, true);
            if (!decoderInfos2.isEmpty()) {
                MediaCodecInfo mediaCodecInfo3 = MediaCodecUtil.getDecoderInfosSortedByFormatSupport(decoderInfos2, format).get(0);
                if (mediaCodecInfo3.isFormatSupported(format) && mediaCodecInfo3.isSeamlessAdaptationSupported(format)) {
                    i = 32;
                }
            }
        }
        return RendererCapabilities.create(i3, i4, i, i5, i6);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.getDecoderInfosSortedByFormatSupport(getDecoderInfos(this.context, mediaCodecSelector, format, z, this.tunneling), format);
    }

    private static List<MediaCodecInfo> getDecoderInfos(Context context, MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        if (format.sampleMimeType == null) {
            return ImmutableList.of();
        }
        if (Util.SDK_INT >= 26 && "video/dolby-vision".equals(format.sampleMimeType) && !Api26.doesDisplaySupportDolbyVision(context)) {
            List<MediaCodecInfo> alternativeDecoderInfos = MediaCodecUtil.getAlternativeDecoderInfos(mediaCodecSelector, format, z, z2);
            if (!alternativeDecoderInfos.isEmpty()) {
                return alternativeDecoderInfos;
            }
        }
        return MediaCodecUtil.getDecoderInfosSoftMatch(mediaCodecSelector, format, z, z2);
    }

    private static final class Api26 {
        private Api26() {
        }

        public static boolean doesDisplaySupportDolbyVision(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService("display");
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display != null && display.isHdr()) {
                for (int i : display.getHdrCapabilities().getSupportedHdrTypes()) {
                    if (i == 1) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        boolean z3 = getConfiguration().tunneling;
        Assertions.checkState((z3 && this.tunnelingAudioSessionId == 0) ? false : true);
        if (this.tunneling != z3) {
            this.tunneling = z3;
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.mayRenderFirstFrameAfterEnableIfNotStarted = z2;
        this.renderedFirstFrameAfterEnable = false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        if (this.videoFrameProcessorManager.isEnabled()) {
            this.videoFrameProcessorManager.flush();
        }
        clearRenderedFirstFrame();
        this.frameReleaseHelper.onPositionReset();
        this.lastBufferPresentationTimeUs = -9223372036854775807L;
        this.initialPositionUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isEnded() {
        boolean isEnded = super.isEnded();
        return this.videoFrameProcessorManager.isEnabled() ? isEnded & this.videoFrameProcessorManager.releasedLastFrame() : isEnded;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public boolean isReady() {
        PlaceholderSurface placeholderSurface;
        if (super.isReady() && ((!this.videoFrameProcessorManager.isEnabled() || this.videoFrameProcessorManager.isReady()) && (this.renderedFirstFrameAfterReset || (((placeholderSurface = this.placeholderSurface) != null && this.displaySurface == placeholderSurface) || getCodec() == null || this.tunneling)))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        }
        if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
            return true;
        }
        this.joiningDeadlineMs = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.totalVideoFrameProcessingOffsetUs = 0L;
        this.videoFrameProcessingOffsetCount = 0;
        this.frameReleaseHelper.onStarted();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        this.frameReleaseHelper.onStopped();
        super.onStopped();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onDisabled() {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
            this.eventDispatcher.videoSizeChanged(VideoSize.UNKNOWN);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.BaseRenderer
    protected void onReset() {
        try {
            super.onReset();
        } finally {
            if (this.videoFrameProcessorManager.isEnabled()) {
                this.videoFrameProcessorManager.reset();
            }
            if (this.placeholderSurface != null) {
                releasePlaceholderSurface();
            }
        }
    }

    @Override // com.google.android.exoplayer2.BaseRenderer, com.google.android.exoplayer2.PlayerMessage.Target
    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        Surface surface;
        if (i == 1) {
            setOutput(obj);
            return;
        }
        if (i == 7) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
            return;
        }
        if (i == 10) {
            int intValue = ((Integer) obj).intValue();
            if (this.tunnelingAudioSessionId != intValue) {
                this.tunnelingAudioSessionId = intValue;
                if (this.tunneling) {
                    releaseCodec();
                    return;
                }
                return;
            }
            return;
        }
        if (i == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodecAdapter codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
                return;
            }
            return;
        }
        if (i == 5) {
            this.frameReleaseHelper.setChangeFrameRateStrategy(((Integer) obj).intValue());
            return;
        }
        if (i == 13) {
            this.videoFrameProcessorManager.setVideoEffects((List) Assertions.checkNotNull(obj));
            return;
        }
        if (i == 14) {
            Size size = (Size) Assertions.checkNotNull(obj);
            if (size.getWidth() == 0 || size.getHeight() == 0 || (surface = this.displaySurface) == null) {
                return;
            }
            this.videoFrameProcessorManager.setOutputSurfaceInfo(surface, size);
            return;
        }
        super.handleMessage(i, obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.android.exoplayer2.video.MediaCodecVideoRenderer] */
    /* JADX WARN: Type inference failed for: r5v10, types: [android.view.Surface] */
    private void setOutput(Object obj) throws ExoPlaybackException {
        PlaceholderSurface placeholderSurface = obj instanceof Surface ? (Surface) obj : null;
        if (placeholderSurface == null) {
            PlaceholderSurface placeholderSurface2 = this.placeholderSurface;
            if (placeholderSurface2 != null) {
                placeholderSurface = placeholderSurface2;
            } else {
                MediaCodecInfo codecInfo = getCodecInfo();
                if (codecInfo != null && shouldUsePlaceholderSurface(codecInfo)) {
                    placeholderSurface = PlaceholderSurface.newInstanceV17(this.context, codecInfo.secure);
                    this.placeholderSurface = placeholderSurface;
                }
            }
        }
        if (this.displaySurface != placeholderSurface) {
            this.displaySurface = placeholderSurface;
            this.frameReleaseHelper.onSurfaceChanged(placeholderSurface);
            this.haveReportedFirstFrameRenderedForCurrentSurface = false;
            int state = getState();
            MediaCodecAdapter codec = getCodec();
            if (codec != null && !this.videoFrameProcessorManager.isEnabled()) {
                if (Util.SDK_INT >= 23 && placeholderSurface != null && !this.codecNeedsSetOutputSurfaceWorkaround) {
                    setOutputSurfaceV23(codec, placeholderSurface);
                } else {
                    releaseCodec();
                    maybeInitCodecOrBypass();
                }
            }
            if (placeholderSurface != null && placeholderSurface != this.placeholderSurface) {
                maybeRenotifyVideoSizeChanged();
                clearRenderedFirstFrame();
                if (state == 2) {
                    setJoiningDeadlineMs();
                }
                if (this.videoFrameProcessorManager.isEnabled()) {
                    this.videoFrameProcessorManager.setOutputSurfaceInfo(placeholderSurface, Size.UNKNOWN);
                    return;
                }
                return;
            }
            clearReportedVideoSize();
            clearRenderedFirstFrame();
            if (this.videoFrameProcessorManager.isEnabled()) {
                this.videoFrameProcessorManager.clearOutputSurfaceInfo();
                return;
            }
            return;
        }
        if (placeholderSurface == null || placeholderSurface == this.placeholderSurface) {
            return;
        }
        maybeRenotifyVideoSizeChanged();
        maybeRenotifyRenderedFirstFrame();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.displaySurface != null || shouldUsePlaceholderSurface(mediaCodecInfo);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f) {
        Surface surface;
        PlaceholderSurface placeholderSurface = this.placeholderSurface;
        if (placeholderSurface != null && placeholderSurface.secure != mediaCodecInfo.secure) {
            releasePlaceholderSurface();
        }
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues, f, this.deviceNeedsNoPostProcessWorkaround, this.tunneling ? this.tunnelingAudioSessionId : 0);
        if (this.displaySurface == null) {
            if (!shouldUsePlaceholderSurface(mediaCodecInfo)) {
                throw new IllegalStateException();
            }
            if (this.placeholderSurface == null) {
                this.placeholderSurface = PlaceholderSurface.newInstanceV17(this.context, mediaCodecInfo.secure);
            }
            this.displaySurface = this.placeholderSurface;
        }
        if (this.videoFrameProcessorManager.isEnabled()) {
            mediaFormat = this.videoFrameProcessorManager.amendMediaFormatKeys(mediaFormat);
        }
        if (this.videoFrameProcessorManager.isEnabled()) {
            surface = this.videoFrameProcessorManager.getInputSurface();
        } else {
            surface = this.displaySurface;
        }
        return MediaCodecAdapter.Configuration.createForVideoDecoding(mediaCodecInfo, mediaFormat, format, surface, mediaCrypto);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        DecoderReuseEvaluation canReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i = canReuseCodec.discardReasons;
        if (format2.width > this.codecMaxValues.width || format2.height > this.codecMaxValues.height) {
            i |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            i |= 64;
        }
        int i2 = i;
        return new DecoderReuseEvaluation(mediaCodecInfo.name, format, format2, i2 != 0 ? 0 : canReuseCodec.result, i2);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public void render(long j, long j2) throws ExoPlaybackException {
        super.render(j, j2);
        if (this.videoFrameProcessorManager.isEnabled()) {
            this.videoFrameProcessorManager.releaseProcessedFrames(j, j2);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.buffersInCodecCount = 0;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.Renderer
    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        super.setPlaybackSpeed(f, f2);
        this.frameReleaseHelper.onPlaybackSpeed(f);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x007a, code lost:
    
        if (r3.equals("video/av01") == false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getCodecMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        int intValue;
        int i = format.width;
        int i2 = format.height;
        if (i == -1 || i2 == -1) {
            return -1;
        }
        String str = format.sampleMimeType;
        char c = 1;
        if ("video/dolby-vision".equals(str)) {
            Pair<Integer, Integer> codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format);
            str = (codecProfileAndLevel == null || !((intValue = ((Integer) codecProfileAndLevel.first).intValue()) == 512 || intValue == 1 || intValue == 2)) ? "video/hevc" : "video/avc";
        }
        str.hashCode();
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662735862:
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 3:
            case 5:
                return getMaxSampleSize(i * i2, 2);
            case 2:
                return Math.max(2097152, getMaxSampleSize(i * i2, 2));
            case 4:
                if ("BRAVIA 4K 2015".equals(Util.MODEL) || ("Amazon".equals(Util.MANUFACTURER) && ("KFSOWI".equals(Util.MODEL) || ("AFTS".equals(Util.MODEL) && mediaCodecInfo.secure)))) {
                    return -1;
                }
                return getMaxSampleSize(Util.ceilDivide(i, 16) * Util.ceilDivide(i2, 16) * 256, 2);
            case 6:
                return getMaxSampleSize(i * i2, 4);
            default:
                return -1;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        float f2 = -1.0f;
        for (Format format2 : formatArr) {
            float f3 = format2.frameRate;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onReadyToInitializeCodec(Format format) throws ExoPlaybackException {
        if (this.videoFrameProcessorManager.isEnabled()) {
            return;
        }
        this.videoFrameProcessorManager.maybeEnable(format, getOutputStreamOffsetUs());
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23((MediaCodecAdapter) Assertions.checkNotNull(getCodec()));
        }
        this.videoFrameProcessorManager.onCodecInitialized(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecReleased(String str) {
        this.eventDispatcher.decoderReleased(str);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onCodecError(Exception exc) {
        Log.e(TAG, "Video codec error", exc);
        this.eventDispatcher.videoCodecError(exc);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation onInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged(formatHolder.format, onInputFormatChanged);
        return onInputFormatChanged;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (!this.tunneling) {
            this.buffersInCodecCount++;
        }
        if (Util.SDK_INT >= 23 || !this.tunneling) {
            return;
        }
        onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onOutputFormatChanged(Format format, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        int i;
        int i2;
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
        int i3 = 0;
        if (this.tunneling) {
            i2 = format.width;
            i = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
            if (z) {
                integer = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
            } else {
                integer = mediaFormat.getInteger("width");
            }
            if (z) {
                integer2 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
            } else {
                integer2 = mediaFormat.getInteger("height");
            }
            int i4 = integer;
            i = integer2;
            i2 = i4;
        }
        float f = format.pixelWidthHeightRatio;
        if (codecAppliesRotation()) {
            if (format.rotationDegrees == 90 || format.rotationDegrees == 270) {
                f = 1.0f / f;
                int i5 = i;
                i = i2;
                i2 = i5;
            }
        } else if (!this.videoFrameProcessorManager.isEnabled()) {
            i3 = format.rotationDegrees;
        }
        this.decodedVideoSize = new VideoSize(i2, i, i3, f);
        this.frameReleaseHelper.onFormatChanged(format.frameRate);
        if (this.videoFrameProcessorManager.isEnabled()) {
            this.videoFrameProcessorManager.setInputFormat(format.buildUpon().setWidth(i2).setHeight(i).setRotationDegrees(i3).setPixelWidthHeightRatio(f).build());
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b == -75 && s == 60 && s2 == 1 && b2 == 4) {
                    if (b3 == 0 || b3 == 1) {
                        byte[] bArr = new byte[byteBuffer.remaining()];
                        byteBuffer.get(bArr);
                        byteBuffer.position(0);
                        setHdr10PlusInfoV29(getCodec(), bArr);
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean processOutputBuffer(long j, long j2, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        long j4;
        boolean z3;
        long j5;
        boolean z4;
        Assertions.checkNotNull(mediaCodecAdapter);
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j;
        }
        if (j3 != this.lastBufferPresentationTimeUs) {
            if (!this.videoFrameProcessorManager.isEnabled()) {
                this.frameReleaseHelper.onNextFrame(j3);
            }
            this.lastBufferPresentationTimeUs = j3;
        }
        long outputStreamOffsetUs = j3 - getOutputStreamOffsetUs();
        if (z && !z2) {
            skipOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
            return true;
        }
        boolean z5 = getState() == 2;
        long calculateEarlyTimeUs = calculateEarlyTimeUs(j, j2, SystemClock.elapsedRealtime() * 1000, j3, z5);
        if (this.displaySurface == this.placeholderSurface) {
            if (!isBufferLate(calculateEarlyTimeUs)) {
                return false;
            }
            skipOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
            updateVideoFrameProcessingOffsetCounters(calculateEarlyTimeUs);
            return true;
        }
        if (shouldForceRender(j, calculateEarlyTimeUs)) {
            if (!this.videoFrameProcessorManager.isEnabled()) {
                z4 = true;
            } else {
                if (!this.videoFrameProcessorManager.maybeRegisterFrame(format, outputStreamOffsetUs, z2)) {
                    return false;
                }
                z4 = false;
            }
            renderOutputBufferNow(mediaCodecAdapter, format, i, outputStreamOffsetUs, z4);
            updateVideoFrameProcessingOffsetCounters(calculateEarlyTimeUs);
            return true;
        }
        if (z5 && j != this.initialPositionUs) {
            long nanoTime = System.nanoTime();
            long adjustReleaseTime = this.frameReleaseHelper.adjustReleaseTime((calculateEarlyTimeUs * 1000) + nanoTime);
            if (!this.videoFrameProcessorManager.isEnabled()) {
                calculateEarlyTimeUs = (adjustReleaseTime - nanoTime) / 1000;
            }
            if (this.joiningDeadlineMs != -9223372036854775807L) {
                j4 = calculateEarlyTimeUs;
                z3 = true;
            } else {
                j4 = calculateEarlyTimeUs;
                z3 = false;
            }
            long j6 = j4;
            if (shouldDropBuffersToKeyframe(j6, j2, z2) && maybeDropBuffersToKeyframe(j, z3)) {
                return false;
            }
            if (shouldDropOutputBuffer(j6, j2, z2)) {
                if (z3) {
                    skipOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
                } else {
                    dropOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
                }
                updateVideoFrameProcessingOffsetCounters(j6);
                return true;
            }
            if (this.videoFrameProcessorManager.isEnabled()) {
                this.videoFrameProcessorManager.releaseProcessedFrames(j, j2);
                if (!this.videoFrameProcessorManager.maybeRegisterFrame(format, outputStreamOffsetUs, z2)) {
                    return false;
                }
                renderOutputBufferNow(mediaCodecAdapter, format, i, outputStreamOffsetUs, false);
                return true;
            }
            if (Util.SDK_INT >= 21) {
                if (j6 < ServiceProvider.SCAR_SIGNALS_FETCH_TIMEOUT) {
                    if (adjustReleaseTime == this.lastFrameReleaseTimeNs) {
                        skipOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
                        j5 = adjustReleaseTime;
                    } else {
                        notifyFrameMetadataListener(outputStreamOffsetUs, adjustReleaseTime, format);
                        renderOutputBufferV21(mediaCodecAdapter, i, outputStreamOffsetUs, adjustReleaseTime);
                        j5 = adjustReleaseTime;
                    }
                    updateVideoFrameProcessingOffsetCounters(j6);
                    this.lastFrameReleaseTimeNs = j5;
                    return true;
                }
            } else if (j6 < 30000) {
                if (j6 > 11000) {
                    try {
                        Thread.sleep((j6 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        return false;
                    }
                }
                notifyFrameMetadataListener(outputStreamOffsetUs, adjustReleaseTime, format);
                renderOutputBuffer(mediaCodecAdapter, i, outputStreamOffsetUs);
                updateVideoFrameProcessingOffsetCounters(j6);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean shouldForceRender(long j, long j2) {
        boolean z = getState() == 2;
        return this.joiningDeadlineMs == -9223372036854775807L && j >= getOutputStreamOffsetUs() && ((this.renderedFirstFrameAfterEnable ? !this.renderedFirstFrameAfterReset : !(!z && !this.mayRenderFirstFrameAfterEnableIfNotStarted)) || (z && shouldForceRenderOutputBuffer(j2, (SystemClock.elapsedRealtime() * 1000) - this.lastRenderRealtimeUs)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long calculateEarlyTimeUs(long j, long j2, long j3, long j4, boolean z) {
        long playbackSpeed = (long) ((j4 - j) / getPlaybackSpeed());
        return z ? playbackSpeed - (j3 - j2) : playbackSpeed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyFrameMetadataListener(long j, long j2, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, getCodecOutputMediaFormat());
        }
    }

    protected void onProcessedTunneledBuffer(long j) throws ExoPlaybackException {
        updateOutputFormatForTime(j);
        maybeNotifyVideoSizeChanged(this.decodedVideoSize);
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onProcessedOutputBuffer(long j) {
        super.onProcessedOutputBuffer(j);
        if (this.tunneling) {
            return;
        }
        this.buffersInCodecCount--;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        clearRenderedFirstFrame();
    }

    protected boolean shouldDropOutputBuffer(long j, long j2, boolean z) {
        return isBufferLate(j) && !z;
    }

    protected boolean shouldDropBuffersToKeyframe(long j, long j2, boolean z) {
        return isBufferVeryLate(j) && !z;
    }

    protected boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return isBufferLate(j) && j2 > SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    protected void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    protected void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(0, 1);
    }

    protected boolean maybeDropBuffersToKeyframe(long j, boolean z) throws ExoPlaybackException {
        int skipSource = skipSource(j);
        if (skipSource == 0) {
            return false;
        }
        if (z) {
            this.decoderCounters.skippedInputBufferCount += skipSource;
            this.decoderCounters.skippedOutputBufferCount += this.buffersInCodecCount;
        } else {
            this.decoderCounters.droppedToKeyframeCount++;
            updateDroppedBufferCounters(skipSource, this.buffersInCodecCount);
        }
        flushOrReinitializeCodec();
        if (this.videoFrameProcessorManager.isEnabled()) {
            this.videoFrameProcessorManager.flush();
        }
        return true;
    }

    protected void updateDroppedBufferCounters(int i, int i2) {
        this.decoderCounters.droppedInputBufferCount += i;
        int i3 = i + i2;
        this.decoderCounters.droppedBufferCount += i3;
        this.droppedFrames += i3;
        this.consecutiveDroppedFrameCount += i3;
        this.decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedBufferCount);
        int i4 = this.maxDroppedFramesToNotify;
        if (i4 <= 0 || this.droppedFrames < i4) {
            return;
        }
        maybeNotifyDroppedFrames();
    }

    protected void updateVideoFrameProcessingOffsetCounters(long j) {
        this.decoderCounters.addVideoFrameProcessingOffset(j);
        this.totalVideoFrameProcessingOffsetUs += j;
        this.videoFrameProcessingOffsetCount++;
    }

    protected Pair<ColorInfo, ColorInfo> experimentalGetVideoFrameProcessorColorConfiguration(ColorInfo colorInfo) {
        if (!ColorInfo.isTransferHdr(colorInfo)) {
            return Pair.create(ColorInfo.SDR_BT709_LIMITED, ColorInfo.SDR_BT709_LIMITED);
        }
        if (colorInfo.colorTransfer == 7) {
            return Pair.create(colorInfo, colorInfo.buildUpon().setColorTransfer(6).build());
        }
        return Pair.create(colorInfo, colorInfo);
    }

    private void renderOutputBufferNow(MediaCodecAdapter mediaCodecAdapter, Format format, int i, long j, boolean z) {
        long nanoTime;
        long j2;
        if (this.videoFrameProcessorManager.isEnabled()) {
            nanoTime = this.videoFrameProcessorManager.getCorrectedFramePresentationTimeUs(j, getOutputStreamOffsetUs()) * 1000;
        } else {
            nanoTime = System.nanoTime();
        }
        long j3 = nanoTime;
        if (z) {
            j2 = j;
            notifyFrameMetadataListener(j2, j3, format);
        } else {
            j2 = j;
        }
        if (Util.SDK_INT >= 21) {
            renderOutputBufferV21(mediaCodecAdapter, i, j2, j3);
        } else {
            renderOutputBuffer(mediaCodecAdapter, i, j2);
        }
    }

    protected void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (this.videoFrameProcessorManager.isEnabled()) {
            return;
        }
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        maybeNotifyVideoSizeChanged(this.decodedVideoSize);
        maybeNotifyRenderedFirstFrame();
    }

    protected void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (this.videoFrameProcessorManager.isEnabled()) {
            return;
        }
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        maybeNotifyVideoSizeChanged(this.decodedVideoSize);
        maybeNotifyRenderedFirstFrame();
    }

    private boolean shouldUsePlaceholderSurface(MediaCodecInfo mediaCodecInfo) {
        if (Util.SDK_INT < 23 || this.tunneling || codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name)) {
            return false;
        }
        return !mediaCodecInfo.secure || PlaceholderSurface.isSecureSupported(this.context);
    }

    private void releasePlaceholderSurface() {
        Surface surface = this.displaySurface;
        PlaceholderSurface placeholderSurface = this.placeholderSurface;
        if (surface == placeholderSurface) {
            this.displaySurface = null;
        }
        placeholderSurface.release();
        this.placeholderSurface = null;
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        MediaCodecAdapter codec;
        this.renderedFirstFrameAfterReset = false;
        if (Util.SDK_INT < 23 || !this.tunneling || (codec = getCodec()) == null) {
            return;
        }
        this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
    }

    void maybeNotifyRenderedFirstFrame() {
        this.renderedFirstFrameAfterEnable = true;
        if (this.renderedFirstFrameAfterReset) {
            return;
        }
        this.renderedFirstFrameAfterReset = true;
        this.eventDispatcher.renderedFirstFrame(this.displaySurface);
        this.haveReportedFirstFrameRenderedForCurrentSurface = true;
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.haveReportedFirstFrameRenderedForCurrentSurface) {
            this.eventDispatcher.renderedFirstFrame(this.displaySurface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedVideoSize = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void maybeNotifyVideoSizeChanged(VideoSize videoSize) {
        if (videoSize.equals(VideoSize.UNKNOWN) || videoSize.equals(this.reportedVideoSize)) {
            return;
        }
        this.reportedVideoSize = videoSize;
        this.eventDispatcher.videoSizeChanged(videoSize);
    }

    private void maybeRenotifyVideoSizeChanged() {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null) {
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int i = this.videoFrameProcessingOffsetCount;
        if (i != 0) {
            this.eventDispatcher.reportVideoFrameProcessingOffset(this.totalVideoFrameProcessingOffsetUs, i);
            this.totalVideoFrameProcessingOffsetUs = 0L;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private static void setHdr10PlusInfoV29(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.setParameters(bundle);
    }

    protected void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.setOutputSurface(surface);
    }

    private static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    protected MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues, float f, boolean z, int i) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("width", format.width);
        mediaFormat.setInteger("height", format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if ("video/dolby-vision".equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, Scopes.PROFILE, ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues.width);
        mediaFormat.setInteger("max-height", codecMaxValues.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            configureTunnelingV21(mediaFormat, i);
        }
        return mediaFormat;
    }

    protected CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize;
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (maxInputSize != -1 && (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format)) != -1) {
                maxInputSize = Math.min((int) (maxInputSize * INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR), codecMaxInputSize);
            }
            return new CodecMaxValues(i, i2, maxInputSize);
        }
        int length = formatArr.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            Format format2 = formatArr[i3];
            if (format.colorInfo != null && format2.colorInfo == null) {
                format2 = format2.buildUpon().setColorInfo(format.colorInfo).build();
            }
            if (mediaCodecInfo.canReuseCodec(format, format2).result != 0) {
                z |= format2.width == -1 || format2.height == -1;
                i = Math.max(i, format2.width);
                i2 = Math.max(i2, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z) {
            Log.w(TAG, "Resolutions unknown. Codec max resolution: " + i + VastAttributes.HORIZONTAL_POSITION + i2);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i = Math.max(i, codecMaxSize.x);
                i2 = Math.max(i2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.buildUpon().setWidth(i).setHeight(i2).build()));
                Log.w(TAG, "Codec max resolution adjusted to: " + i + VastAttributes.HORIZONTAL_POSITION + i2);
            }
        }
        return new CodecMaxValues(i, i2, maxInputSize);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected MediaCodecDecoderException createDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.displaySurface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class VideoFrameProcessorManager {
        private static final long EARLY_THRESHOLD_US = 50000;
        private Pair<Long, Format> currentFrameFormat;
        private Pair<Surface, Size> currentSurfaceAndSize;
        private final VideoFrameReleaseHelper frameReleaseHelper;
        private Handler handler;
        private Format inputFormat;
        private boolean pendingOutputSizeChange;
        private boolean processedLastFrame;
        private boolean registeredLastFrame;
        private boolean releasedLastFrame;
        private final MediaCodecVideoRenderer renderer;
        private CopyOnWriteArrayList<Effect> videoEffects;
        private VideoFrameProcessor videoFrameProcessor;
        private final ArrayDeque<Long> processedFramesTimestampsUs = new ArrayDeque<>();
        private final ArrayDeque<Pair<Long, Format>> pendingFrameFormats = new ArrayDeque<>();
        private int videoFrameProcessorMaxPendingFrameCount = -1;
        private boolean canEnableFrameProcessing = true;
        private long lastCodecBufferPresentationTimestampUs = -9223372036854775807L;
        private VideoSize processedFrameSize = VideoSize.UNKNOWN;
        private long pendingOutputSizeChangeNotificationTimeUs = -9223372036854775807L;
        private long initialStreamOffsetUs = -9223372036854775807L;

        public VideoFrameProcessorManager(VideoFrameReleaseHelper videoFrameReleaseHelper, MediaCodecVideoRenderer mediaCodecVideoRenderer) {
            this.frameReleaseHelper = videoFrameReleaseHelper;
            this.renderer = mediaCodecVideoRenderer;
        }

        public void setVideoEffects(List<Effect> list) {
            CopyOnWriteArrayList<Effect> copyOnWriteArrayList = this.videoEffects;
            if (copyOnWriteArrayList == null) {
                this.videoEffects = new CopyOnWriteArrayList<>(list);
            } else {
                copyOnWriteArrayList.clear();
                this.videoEffects.addAll(list);
            }
        }

        public boolean isEnabled() {
            return this.videoFrameProcessor != null;
        }

        public boolean isReady() {
            Pair<Surface, Size> pair = this.currentSurfaceAndSize;
            return pair == null || !((Size) pair.second).equals(Size.UNKNOWN);
        }

        public boolean releasedLastFrame() {
            return this.releasedLastFrame;
        }

        public void flush() {
            Assertions.checkStateNotNull(this.videoFrameProcessor);
            this.videoFrameProcessor.flush();
            this.processedFramesTimestampsUs.clear();
            this.handler.removeCallbacksAndMessages(null);
            if (this.registeredLastFrame) {
                this.registeredLastFrame = false;
                this.processedLastFrame = false;
                this.releasedLastFrame = false;
            }
        }

        public boolean maybeEnable(final Format format, long j) throws ExoPlaybackException {
            Assertions.checkState(!isEnabled());
            if (!this.canEnableFrameProcessing) {
                return false;
            }
            if (this.videoEffects == null) {
                this.canEnableFrameProcessing = false;
                return false;
            }
            this.handler = Util.createHandlerForCurrentLooper();
            Pair<ColorInfo, ColorInfo> experimentalGetVideoFrameProcessorColorConfiguration = this.renderer.experimentalGetVideoFrameProcessorColorConfiguration(format.colorInfo);
            try {
                if (!MediaCodecVideoRenderer.codecAppliesRotation() && format.rotationDegrees != 0) {
                    this.videoEffects.add(0, VideoFrameProcessorAccessor.createRotationEffect(format.rotationDegrees));
                }
                VideoFrameProcessor.Factory frameProcessorFactory = VideoFrameProcessorAccessor.getFrameProcessorFactory();
                Context context = this.renderer.context;
                List<Effect> list = (List) Assertions.checkNotNull(this.videoEffects);
                DebugViewProvider debugViewProvider = DebugViewProvider.NONE;
                ColorInfo colorInfo = (ColorInfo) experimentalGetVideoFrameProcessorColorConfiguration.first;
                ColorInfo colorInfo2 = (ColorInfo) experimentalGetVideoFrameProcessorColorConfiguration.second;
                final Handler handler = this.handler;
                Objects.requireNonNull(handler);
                VideoFrameProcessor create = frameProcessorFactory.create(context, list, debugViewProvider, colorInfo, colorInfo2, false, new Executor() { // from class: com.google.android.exoplayer2.video.MediaCodecVideoRenderer$VideoFrameProcessorManager$$ExternalSyntheticLambda0
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        handler.post(runnable);
                    }
                }, new VideoFrameProcessor.Listener() { // from class: com.google.android.exoplayer2.video.MediaCodecVideoRenderer.VideoFrameProcessorManager.1
                    @Override // com.google.android.exoplayer2.util.VideoFrameProcessor.Listener
                    public void onOutputSizeChanged(int i, int i2) {
                        Assertions.checkStateNotNull(VideoFrameProcessorManager.this.inputFormat);
                        VideoFrameProcessorManager.this.processedFrameSize = new VideoSize(i, i2, 0, 1.0f);
                        VideoFrameProcessorManager.this.pendingOutputSizeChange = true;
                    }

                    @Override // com.google.android.exoplayer2.util.VideoFrameProcessor.Listener
                    public void onOutputFrameAvailableForRendering(long j2) {
                        if (VideoFrameProcessorManager.this.registeredLastFrame) {
                            Assertions.checkState(VideoFrameProcessorManager.this.lastCodecBufferPresentationTimestampUs != -9223372036854775807L);
                        }
                        VideoFrameProcessorManager.this.processedFramesTimestampsUs.add(Long.valueOf(j2));
                        if (VideoFrameProcessorManager.this.registeredLastFrame && j2 >= VideoFrameProcessorManager.this.lastCodecBufferPresentationTimestampUs) {
                            VideoFrameProcessorManager.this.processedLastFrame = true;
                        }
                        if (VideoFrameProcessorManager.this.pendingOutputSizeChange) {
                            VideoFrameProcessorManager.this.pendingOutputSizeChange = false;
                            VideoFrameProcessorManager.this.pendingOutputSizeChangeNotificationTimeUs = j2;
                        }
                    }

                    @Override // com.google.android.exoplayer2.util.VideoFrameProcessor.Listener
                    public void onError(VideoFrameProcessingException videoFrameProcessingException) {
                        VideoFrameProcessorManager.this.renderer.setPendingPlaybackException(VideoFrameProcessorManager.this.renderer.createRendererException(videoFrameProcessingException, format, 7001));
                    }

                    @Override // com.google.android.exoplayer2.util.VideoFrameProcessor.Listener
                    public void onEnded() {
                        throw new IllegalStateException();
                    }
                });
                this.videoFrameProcessor = create;
                create.registerInputStream(1);
                this.initialStreamOffsetUs = j;
                Pair<Surface, Size> pair = this.currentSurfaceAndSize;
                if (pair != null) {
                    Size size = (Size) pair.second;
                    this.videoFrameProcessor.setOutputSurfaceInfo(new SurfaceInfo((Surface) this.currentSurfaceAndSize.first, size.getWidth(), size.getHeight()));
                }
                setInputFormat(format);
                return true;
            } catch (Exception e) {
                throw this.renderer.createRendererException(e, format, 7000);
            }
        }

        public long getCorrectedFramePresentationTimeUs(long j, long j2) {
            Assertions.checkState(this.initialStreamOffsetUs != -9223372036854775807L);
            return (j + j2) - this.initialStreamOffsetUs;
        }

        public Surface getInputSurface() {
            return ((VideoFrameProcessor) Assertions.checkNotNull(this.videoFrameProcessor)).getInputSurface();
        }

        public void setOutputSurfaceInfo(Surface surface, Size size) {
            Pair<Surface, Size> pair = this.currentSurfaceAndSize;
            if (pair != null && ((Surface) pair.first).equals(surface) && ((Size) this.currentSurfaceAndSize.second).equals(size)) {
                return;
            }
            this.currentSurfaceAndSize = Pair.create(surface, size);
            if (isEnabled()) {
                ((VideoFrameProcessor) Assertions.checkNotNull(this.videoFrameProcessor)).setOutputSurfaceInfo(new SurfaceInfo(surface, size.getWidth(), size.getHeight()));
            }
        }

        public void clearOutputSurfaceInfo() {
            ((VideoFrameProcessor) Assertions.checkNotNull(this.videoFrameProcessor)).setOutputSurfaceInfo(null);
            this.currentSurfaceAndSize = null;
        }

        public void setInputFormat(Format format) {
            ((VideoFrameProcessor) Assertions.checkNotNull(this.videoFrameProcessor)).setInputFrameInfo(new FrameInfo.Builder(format.width, format.height).setPixelWidthHeightRatio(format.pixelWidthHeightRatio).build());
            this.inputFormat = format;
            if (this.registeredLastFrame) {
                this.registeredLastFrame = false;
                this.processedLastFrame = false;
                this.releasedLastFrame = false;
            }
        }

        public MediaFormat amendMediaFormatKeys(MediaFormat mediaFormat) {
            if (Util.SDK_INT >= 29 && this.renderer.context.getApplicationContext().getApplicationInfo().targetSdkVersion >= 29) {
                mediaFormat.setInteger("allow-frame-drop", 0);
            }
            return mediaFormat;
        }

        public void onCodecInitialized(String str) {
            this.videoFrameProcessorMaxPendingFrameCount = Util.getMaxPendingFramesCountForMediaCodecDecoders(this.renderer.context, str, false);
        }

        public boolean maybeRegisterFrame(Format format, long j, boolean z) {
            Assertions.checkStateNotNull(this.videoFrameProcessor);
            Assertions.checkState(this.videoFrameProcessorMaxPendingFrameCount != -1);
            if (this.videoFrameProcessor.getPendingInputFrameCount() >= this.videoFrameProcessorMaxPendingFrameCount) {
                return false;
            }
            this.videoFrameProcessor.registerInputFrame();
            Pair<Long, Format> pair = this.currentFrameFormat;
            if (pair == null) {
                this.currentFrameFormat = Pair.create(Long.valueOf(j), format);
            } else if (!Util.areEqual(format, pair.second)) {
                this.pendingFrameFormats.add(Pair.create(Long.valueOf(j), format));
            }
            if (z) {
                this.registeredLastFrame = true;
                this.lastCodecBufferPresentationTimestampUs = j;
            }
            return true;
        }

        public void releaseProcessedFrames(long j, long j2) {
            Assertions.checkStateNotNull(this.videoFrameProcessor);
            while (!this.processedFramesTimestampsUs.isEmpty()) {
                boolean z = false;
                boolean z2 = this.renderer.getState() == 2;
                long longValue = ((Long) Assertions.checkNotNull(this.processedFramesTimestampsUs.peek())).longValue();
                long j3 = longValue + this.initialStreamOffsetUs;
                long calculateEarlyTimeUs = this.renderer.calculateEarlyTimeUs(j, j2, SystemClock.elapsedRealtime() * 1000, j3, z2);
                if (this.processedLastFrame && this.processedFramesTimestampsUs.size() == 1) {
                    z = true;
                }
                if (this.renderer.shouldForceRender(j, calculateEarlyTimeUs)) {
                    releaseProcessedFrameInternal(-1L, z);
                    return;
                }
                if (!z2 || j == this.renderer.initialPositionUs || calculateEarlyTimeUs > 50000) {
                    return;
                }
                this.frameReleaseHelper.onNextFrame(j3);
                long adjustReleaseTime = this.frameReleaseHelper.adjustReleaseTime(System.nanoTime() + (calculateEarlyTimeUs * 1000));
                if (this.renderer.shouldDropOutputBuffer((adjustReleaseTime - System.nanoTime()) / 1000, j2, z)) {
                    releaseProcessedFrameInternal(-2L, z);
                } else {
                    if (!this.pendingFrameFormats.isEmpty() && j3 > ((Long) this.pendingFrameFormats.peek().first).longValue()) {
                        this.currentFrameFormat = this.pendingFrameFormats.remove();
                    }
                    this.renderer.notifyFrameMetadataListener(longValue, adjustReleaseTime, (Format) this.currentFrameFormat.second);
                    if (this.pendingOutputSizeChangeNotificationTimeUs >= j3) {
                        this.pendingOutputSizeChangeNotificationTimeUs = -9223372036854775807L;
                        this.renderer.maybeNotifyVideoSizeChanged(this.processedFrameSize);
                    }
                    releaseProcessedFrameInternal(adjustReleaseTime, z);
                }
            }
        }

        public void reset() {
            ((VideoFrameProcessor) Assertions.checkNotNull(this.videoFrameProcessor)).release();
            this.videoFrameProcessor = null;
            Handler handler = this.handler;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            CopyOnWriteArrayList<Effect> copyOnWriteArrayList = this.videoEffects;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.clear();
            }
            this.processedFramesTimestampsUs.clear();
            this.canEnableFrameProcessing = true;
        }

        private void releaseProcessedFrameInternal(long j, boolean z) {
            Assertions.checkStateNotNull(this.videoFrameProcessor);
            this.videoFrameProcessor.renderOutputFrame(j);
            this.processedFramesTimestampsUs.remove();
            this.renderer.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
            if (j != -2) {
                this.renderer.maybeNotifyRenderedFirstFrame();
            }
            if (z) {
                this.releasedLastFrame = true;
            }
        }

        private static final class VideoFrameProcessorAccessor {
            private static Method buildScaleAndRotateTransformationMethod;
            private static Method buildVideoFrameProcessorFactoryMethod;
            private static Constructor<?> scaleAndRotateTransformationBuilderConstructor;
            private static Method setRotationMethod;
            private static Constructor<?> videoFrameProcessorFactoryBuilderConstructor;

            private VideoFrameProcessorAccessor() {
            }

            public static Effect createRotationEffect(float f) throws Exception {
                prepare();
                Object newInstance = scaleAndRotateTransformationBuilderConstructor.newInstance(new Object[0]);
                setRotationMethod.invoke(newInstance, Float.valueOf(f));
                return (Effect) Assertions.checkNotNull(buildScaleAndRotateTransformationMethod.invoke(newInstance, new Object[0]));
            }

            public static VideoFrameProcessor.Factory getFrameProcessorFactory() throws Exception {
                prepare();
                return (VideoFrameProcessor.Factory) Assertions.checkNotNull(buildVideoFrameProcessorFactoryMethod.invoke(videoFrameProcessorFactoryBuilderConstructor.newInstance(new Object[0]), new Object[0]));
            }

            @EnsuresNonNull({"scaleAndRotateTransformationBuilderConstructor", "setRotationMethod", "buildScaleAndRotateTransformationMethod", "videoFrameProcessorFactoryBuilderConstructor", "buildVideoFrameProcessorFactoryMethod"})
            private static void prepare() throws Exception {
                if (scaleAndRotateTransformationBuilderConstructor == null || setRotationMethod == null || buildScaleAndRotateTransformationMethod == null) {
                    Class<?> cls = Class.forName("com.google.android.exoplayer2.effect.ScaleAndRotateTransformation$Builder");
                    scaleAndRotateTransformationBuilderConstructor = cls.getConstructor(new Class[0]);
                    setRotationMethod = cls.getMethod("setRotationDegrees", Float.TYPE);
                    buildScaleAndRotateTransformationMethod = cls.getMethod("build", new Class[0]);
                }
                if (videoFrameProcessorFactoryBuilderConstructor == null || buildVideoFrameProcessorFactoryMethod == null) {
                    Class<?> cls2 = Class.forName("com.google.android.exoplayer2.effect.DefaultVideoFrameProcessor$Factory$Builder");
                    videoFrameProcessorFactoryBuilderConstructor = cls2.getConstructor(new Class[0]);
                    buildVideoFrameProcessorFactoryMethod = cls2.getMethod("build", new Class[0]);
                }
            }
        }
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = i2 / i;
        for (int i3 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i4 = (int) (i3 * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i5, i3);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                try {
                    int ceilDivide = Util.ceilDivide(i3, 16) * 16;
                    int ceilDivide2 = Util.ceilDivide(i4, 16) * 16;
                    if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i6 = z ? ceilDivide2 : ceilDivide;
                        if (!z) {
                            ceilDivide = ceilDivide2;
                        }
                        return new Point(i6, ceilDivide);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    protected static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize != -1) {
            int size = format.initializationData.size();
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                i += format.initializationData.get(i2).length;
            }
            return format.maxInputSize + i;
        }
        return getCodecMaxInputSize(mediaCodecInfo, format);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean codecAppliesRotation() {
        return Util.SDK_INT >= 21;
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Util.MANUFACTURER);
    }

    protected boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                deviceNeedsSetOutputSurfaceWorkaround = evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    protected Surface getSurface() {
        return this.displaySurface;
    }

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    private static int getMaxSampleSize(int i, int i2) {
        return (i * 3) / (i2 * 2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:448:0x0848, code lost:
    
        if (r0.equals("PGN528") == false) goto L91;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        boolean z;
        boolean z2;
        char c = 7;
        if (Util.SDK_INT <= 28) {
            String str = Util.DEVICE;
            str.hashCode();
            switch (str.hashCode()) {
                case -1339091551:
                    if (str.equals("dangal")) {
                        z2 = false;
                        break;
                    }
                    z2 = -1;
                    break;
                case -1220081023:
                    if (str.equals("dangalFHD")) {
                        z2 = true;
                        break;
                    }
                    z2 = -1;
                    break;
                case -1220066608:
                    if (str.equals("dangalUHD")) {
                        z2 = 2;
                        break;
                    }
                    z2 = -1;
                    break;
                case -1012436106:
                    if (str.equals("oneday")) {
                        z2 = 3;
                        break;
                    }
                    z2 = -1;
                    break;
                case -760312546:
                    if (str.equals("aquaman")) {
                        z2 = 4;
                        break;
                    }
                    z2 = -1;
                    break;
                case -64886864:
                    if (str.equals("magnolia")) {
                        z2 = 5;
                        break;
                    }
                    z2 = -1;
                    break;
                case 3415681:
                    if (str.equals("once")) {
                        z2 = 6;
                        break;
                    }
                    z2 = -1;
                    break;
                case 825323514:
                    if (str.equals("machuca")) {
                        z2 = 7;
                        break;
                    }
                    z2 = -1;
                    break;
                default:
                    z2 = -1;
                    break;
            }
            switch (z2) {
            }
            return true;
        }
        if (Util.SDK_INT <= 27 && "HWEML".equals(Util.DEVICE)) {
            return true;
        }
        String str2 = Util.MODEL;
        str2.hashCode();
        switch (str2.hashCode()) {
            case -349662828:
                if (str2.equals("AFTJMST12")) {
                    z = false;
                    break;
                }
                z = -1;
                break;
            case -321033677:
                if (str2.equals("AFTKMST12")) {
                    z = true;
                    break;
                }
                z = -1;
                break;
            case 2006354:
                if (str2.equals("AFTA")) {
                    z = 2;
                    break;
                }
                z = -1;
                break;
            case 2006367:
                if (str2.equals("AFTN")) {
                    z = 3;
                    break;
                }
                z = -1;
                break;
            case 2006371:
                if (str2.equals("AFTR")) {
                    z = 4;
                    break;
                }
                z = -1;
                break;
            case 1785421873:
                if (str2.equals("AFTEU011")) {
                    z = 5;
                    break;
                }
                z = -1;
                break;
            case 1785421876:
                if (str2.equals("AFTEU014")) {
                    z = 6;
                    break;
                }
                z = -1;
                break;
            case 1798172390:
                if (str2.equals("AFTSO001")) {
                    z = 7;
                    break;
                }
                z = -1;
                break;
            case 2119412532:
                if (str2.equals("AFTEUFF014")) {
                    z = 8;
                    break;
                }
                z = -1;
                break;
            default:
                z = -1;
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
            case true:
                break;
            default:
                if (Util.SDK_INT <= 26) {
                    String str3 = Util.DEVICE;
                    str3.hashCode();
                    switch (str3.hashCode()) {
                        case -2144781245:
                            if (str3.equals("GIONEE_SWW1609")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case -2144781185:
                            if (str3.equals("GIONEE_SWW1627")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        case -2144781160:
                            if (str3.equals("GIONEE_SWW1631")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case -2097309513:
                            if (str3.equals("K50a40")) {
                                c = 3;
                                break;
                            }
                            c = 65535;
                            break;
                        case -2022874474:
                            if (str3.equals("CP8676_I02")) {
                                c = 4;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1978993182:
                            if (str3.equals("NX541J")) {
                                c = 5;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1978990237:
                            if (str3.equals("NX573J")) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1936688988:
                            break;
                        case -1936688066:
                            if (str3.equals("PGN610")) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1936688065:
                            if (str3.equals("PGN611")) {
                                c = '\t';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1931988508:
                            if (str3.equals("AquaPowerM")) {
                                c = '\n';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1885099851:
                            if (str3.equals("RAIJIN")) {
                                c = 11;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1696512866:
                            if (str3.equals("XT1663")) {
                                c = '\f';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1680025915:
                            if (str3.equals("ComioS1")) {
                                c = '\r';
                                break;
                            }
                            c = 65535;
                            break;
                        case -1615810839:
                            if (str3.equals("Phantom6")) {
                                c = 14;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1600724499:
                            if (str3.equals("pacificrim")) {
                                c = 15;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1554255044:
                            if (str3.equals("vernee_M5")) {
                                c = 16;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1481772737:
                            if (str3.equals("panell_dl")) {
                                c = 17;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1481772730:
                            if (str3.equals("panell_ds")) {
                                c = 18;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1481772729:
                            if (str3.equals("panell_dt")) {
                                c = 19;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1320080169:
                            if (str3.equals("GiONEE_GBL7319")) {
                                c = 20;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1217592143:
                            if (str3.equals("BRAVIA_ATV2")) {
                                c = 21;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1180384755:
                            if (str3.equals("iris60")) {
                                c = 22;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1139198265:
                            if (str3.equals("Slate_Pro")) {
                                c = 23;
                                break;
                            }
                            c = 65535;
                            break;
                        case -1052835013:
                            if (str3.equals("namath")) {
                                c = 24;
                                break;
                            }
                            c = 65535;
                            break;
                        case -993250464:
                            if (str3.equals("A10-70F")) {
                                c = 25;
                                break;
                            }
                            c = 65535;
                            break;
                        case -993250458:
                            if (str3.equals("A10-70L")) {
                                c = 26;
                                break;
                            }
                            c = 65535;
                            break;
                        case -965403638:
                            if (str3.equals("s905x018")) {
                                c = 27;
                                break;
                            }
                            c = 65535;
                            break;
                        case -958336948:
                            if (str3.equals("ELUGA_Ray_X")) {
                                c = 28;
                                break;
                            }
                            c = 65535;
                            break;
                        case -879245230:
                            if (str3.equals("tcl_eu")) {
                                c = 29;
                                break;
                            }
                            c = 65535;
                            break;
                        case -842500323:
                            if (str3.equals("nicklaus_f")) {
                                c = 30;
                                break;
                            }
                            c = 65535;
                            break;
                        case -821392978:
                            if (str3.equals("A7000-a")) {
                                c = 31;
                                break;
                            }
                            c = 65535;
                            break;
                        case -797483286:
                            if (str3.equals("SVP-DTV15")) {
                                c = ' ';
                                break;
                            }
                            c = 65535;
                            break;
                        case -794946968:
                            if (str3.equals("watson")) {
                                c = '!';
                                break;
                            }
                            c = 65535;
                            break;
                        case -788334647:
                            if (str3.equals("whyred")) {
                                c = '\"';
                                break;
                            }
                            c = 65535;
                            break;
                        case -782144577:
                            if (str3.equals("OnePlus5T")) {
                                c = '#';
                                break;
                            }
                            c = 65535;
                            break;
                        case -575125681:
                            if (str3.equals("GiONEE_CBL7513")) {
                                c = Typography.dollar;
                                break;
                            }
                            c = 65535;
                            break;
                        case -521118391:
                            if (str3.equals("GIONEE_GBL7360")) {
                                c = '%';
                                break;
                            }
                            c = 65535;
                            break;
                        case -430914369:
                            if (str3.equals("Pixi4-7_3G")) {
                                c = Typography.amp;
                                break;
                            }
                            c = 65535;
                            break;
                        case -290434366:
                            if (str3.equals("taido_row")) {
                                c = '\'';
                                break;
                            }
                            c = 65535;
                            break;
                        case -282781963:
                            if (str3.equals("BLACK-1X")) {
                                c = '(';
                                break;
                            }
                            c = 65535;
                            break;
                        case -277133239:
                            if (str3.equals("Z12_PRO")) {
                                c = ')';
                                break;
                            }
                            c = 65535;
                            break;
                        case -173639913:
                            if (str3.equals("ELUGA_A3_Pro")) {
                                c = GMTDateParser.ANY;
                                break;
                            }
                            c = 65535;
                            break;
                        case -56598463:
                            if (str3.equals("woods_fn")) {
                                c = '+';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2126:
                            if (str3.equals("C1")) {
                                c = AbstractJsonLexerKt.COMMA;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2564:
                            if (str3.equals("Q5")) {
                                c = '-';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2715:
                            if (str3.equals("V1")) {
                                c = '.';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2719:
                            if (str3.equals("V5")) {
                                c = '/';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3091:
                            if (str3.equals("b5")) {
                                c = '0';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3483:
                            if (str3.equals("mh")) {
                                c = '1';
                                break;
                            }
                            c = 65535;
                            break;
                        case 73405:
                            if (str3.equals("JGZ")) {
                                c = '2';
                                break;
                            }
                            c = 65535;
                            break;
                        case 75537:
                            if (str3.equals("M04")) {
                                c = '3';
                                break;
                            }
                            c = 65535;
                            break;
                        case 75739:
                            if (str3.equals("M5c")) {
                                c = '4';
                                break;
                            }
                            c = 65535;
                            break;
                        case 76779:
                            if (str3.equals("MX6")) {
                                c = '5';
                                break;
                            }
                            c = 65535;
                            break;
                        case 78669:
                            if (str3.equals("P85")) {
                                c = '6';
                                break;
                            }
                            c = 65535;
                            break;
                        case 79305:
                            if (str3.equals("PLE")) {
                                c = '7';
                                break;
                            }
                            c = 65535;
                            break;
                        case 80618:
                            if (str3.equals("QX1")) {
                                c = '8';
                                break;
                            }
                            c = 65535;
                            break;
                        case 88274:
                            if (str3.equals("Z80")) {
                                c = '9';
                                break;
                            }
                            c = 65535;
                            break;
                        case 98846:
                            if (str3.equals("cv1")) {
                                c = AbstractJsonLexerKt.COLON;
                                break;
                            }
                            c = 65535;
                            break;
                        case 98848:
                            if (str3.equals("cv3")) {
                                c = ';';
                                break;
                            }
                            c = 65535;
                            break;
                        case 99329:
                            if (str3.equals("deb")) {
                                c = Typography.less;
                                break;
                            }
                            c = 65535;
                            break;
                        case 101481:
                            if (str3.equals("flo")) {
                                c = D5.T;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1513190:
                            if (str3.equals("1601")) {
                                c = Typography.greater;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1514184:
                            if (str3.equals("1713")) {
                                c = '?';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1514185:
                            if (str3.equals("1714")) {
                                c = '@';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2133089:
                            if (str3.equals("F01H")) {
                                c = 'A';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2133091:
                            if (str3.equals("F01J")) {
                                c = 'B';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2133120:
                            if (str3.equals("F02H")) {
                                c = 'C';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2133151:
                            if (str3.equals("F03H")) {
                                c = 'D';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2133182:
                            if (str3.equals("F04H")) {
                                c = 'E';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2133184:
                            if (str3.equals("F04J")) {
                                c = 'F';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2436959:
                            if (str3.equals("P681")) {
                                c = 'G';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2463773:
                            if (str3.equals("Q350")) {
                                c = 'H';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2464648:
                            if (str3.equals("Q427")) {
                                c = 'I';
                                break;
                            }
                            c = 65535;
                            break;
                        case 2689555:
                            if (str3.equals("XE2X")) {
                                c = 'J';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3154429:
                            if (str3.equals("fugu")) {
                                c = 'K';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3284551:
                            if (str3.equals("kate")) {
                                c = 'L';
                                break;
                            }
                            c = 65535;
                            break;
                        case 3351335:
                            if (str3.equals("mido")) {
                                c = GMTDateParser.MONTH;
                                break;
                            }
                            c = 65535;
                            break;
                        case 3386211:
                            if (str3.equals("p212")) {
                                c = 'N';
                                break;
                            }
                            c = 65535;
                            break;
                        case 41325051:
                            if (str3.equals("MEIZU_M5")) {
                                c = 'O';
                                break;
                            }
                            c = 65535;
                            break;
                        case 51349633:
                            if (str3.equals("601LV")) {
                                c = 'P';
                                break;
                            }
                            c = 65535;
                            break;
                        case 51350594:
                            if (str3.equals("602LV")) {
                                c = 'Q';
                                break;
                            }
                            c = 65535;
                            break;
                        case 55178625:
                            if (str3.equals("Aura_Note_2")) {
                                c = 'R';
                                break;
                            }
                            c = 65535;
                            break;
                        case 61542055:
                            if (str3.equals("A1601")) {
                                c = 'S';
                                break;
                            }
                            c = 65535;
                            break;
                        case 65355429:
                            if (str3.equals("E5643")) {
                                c = 'T';
                                break;
                            }
                            c = 65535;
                            break;
                        case 66214468:
                            if (str3.equals("F3111")) {
                                c = 'U';
                                break;
                            }
                            c = 65535;
                            break;
                        case 66214470:
                            if (str3.equals("F3113")) {
                                c = 'V';
                                break;
                            }
                            c = 65535;
                            break;
                        case 66214473:
                            if (str3.equals("F3116")) {
                                c = 'W';
                                break;
                            }
                            c = 65535;
                            break;
                        case 66215429:
                            if (str3.equals("F3211")) {
                                c = 'X';
                                break;
                            }
                            c = 65535;
                            break;
                        case 66215431:
                            if (str3.equals("F3213")) {
                                c = GMTDateParser.YEAR;
                                break;
                            }
                            c = 65535;
                            break;
                        case 66215433:
                            if (str3.equals("F3215")) {
                                c = 'Z';
                                break;
                            }
                            c = 65535;
                            break;
                        case 66216390:
                            if (str3.equals("F3311")) {
                                c = AbstractJsonLexerKt.BEGIN_LIST;
                                break;
                            }
                            c = 65535;
                            break;
                        case 76402249:
                            if (str3.equals("PRO7S")) {
                                c = AbstractJsonLexerKt.STRING_ESC;
                                break;
                            }
                            c = 65535;
                            break;
                        case 76404105:
                            if (str3.equals("Q4260")) {
                                c = AbstractJsonLexerKt.END_LIST;
                                break;
                            }
                            c = 65535;
                            break;
                        case 76404911:
                            if (str3.equals("Q4310")) {
                                c = '^';
                                break;
                            }
                            c = 65535;
                            break;
                        case 80963634:
                            if (str3.equals("V23GB")) {
                                c = '_';
                                break;
                            }
                            c = 65535;
                            break;
                        case 82882791:
                            if (str3.equals("X3_HK")) {
                                c = '`';
                                break;
                            }
                            c = 65535;
                            break;
                        case 98715550:
                            if (str3.equals("i9031")) {
                                c = 'a';
                                break;
                            }
                            c = 65535;
                            break;
                        case 101370885:
                            if (str3.equals("l5460")) {
                                c = 'b';
                                break;
                            }
                            c = 65535;
                            break;
                        case 102844228:
                            if (str3.equals("le_x6")) {
                                c = 'c';
                                break;
                            }
                            c = 65535;
                            break;
                        case 165221241:
                            if (str3.equals("A2016a40")) {
                                c = GMTDateParser.DAY_OF_MONTH;
                                break;
                            }
                            c = 65535;
                            break;
                        case 182191441:
                            if (str3.equals("CPY83_I00")) {
                                c = 'e';
                                break;
                            }
                            c = 65535;
                            break;
                        case 245388979:
                            if (str3.equals("marino_f")) {
                                c = 'f';
                                break;
                            }
                            c = 65535;
                            break;
                        case 287431619:
                            if (str3.equals("griffin")) {
                                c = 'g';
                                break;
                            }
                            c = 65535;
                            break;
                        case 307593612:
                            if (str3.equals("A7010a48")) {
                                c = GMTDateParser.HOURS;
                                break;
                            }
                            c = 65535;
                            break;
                        case 308517133:
                            if (str3.equals("A7020a48")) {
                                c = 'i';
                                break;
                            }
                            c = 65535;
                            break;
                        case 316215098:
                            if (str3.equals("TB3-730F")) {
                                c = 'j';
                                break;
                            }
                            c = 65535;
                            break;
                        case 316215116:
                            if (str3.equals("TB3-730X")) {
                                c = 'k';
                                break;
                            }
                            c = 65535;
                            break;
                        case 316246811:
                            if (str3.equals("TB3-850F")) {
                                c = 'l';
                                break;
                            }
                            c = 65535;
                            break;
                        case 316246818:
                            if (str3.equals("TB3-850M")) {
                                c = GMTDateParser.MINUTES;
                                break;
                            }
                            c = 65535;
                            break;
                        case 407160593:
                            if (str3.equals("Pixi5-10_4G")) {
                                c = 'n';
                                break;
                            }
                            c = 65535;
                            break;
                        case 507412548:
                            if (str3.equals("QM16XE_U")) {
                                c = 'o';
                                break;
                            }
                            c = 65535;
                            break;
                        case 793982701:
                            if (str3.equals("GIONEE_WBL5708")) {
                                c = 'p';
                                break;
                            }
                            c = 65535;
                            break;
                        case 794038622:
                            if (str3.equals("GIONEE_WBL7365")) {
                                c = 'q';
                                break;
                            }
                            c = 65535;
                            break;
                        case 794040393:
                            if (str3.equals("GIONEE_WBL7519")) {
                                c = 'r';
                                break;
                            }
                            c = 65535;
                            break;
                        case 835649806:
                            if (str3.equals("manning")) {
                                c = GMTDateParser.SECONDS;
                                break;
                            }
                            c = 65535;
                            break;
                        case 917340916:
                            if (str3.equals("A7000plus")) {
                                c = 't';
                                break;
                            }
                            c = 65535;
                            break;
                        case 958008161:
                            if (str3.equals("j2xlteins")) {
                                c = AbstractJsonLexerKt.UNICODE_ESC;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1060579533:
                            if (str3.equals("panell_d")) {
                                c = 'v';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1150207623:
                            if (str3.equals("LS-5017")) {
                                c = 'w';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1176899427:
                            if (str3.equals("itel_S41")) {
                                c = 'x';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1280332038:
                            if (str3.equals("hwALE-H")) {
                                c = 'y';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1306947716:
                            if (str3.equals("EverStar_S")) {
                                c = GMTDateParser.ZONE;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1349174697:
                            if (str3.equals("htc_e56ml_dtul")) {
                                c = AbstractJsonLexerKt.BEGIN_OBJ;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1522194893:
                            if (str3.equals("woods_f")) {
                                c = '|';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1691543273:
                            if (str3.equals("CPH1609")) {
                                c = AbstractJsonLexerKt.END_OBJ;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1691544261:
                            if (str3.equals("CPH1715")) {
                                c = '~';
                                break;
                            }
                            c = 65535;
                            break;
                        case 1709443163:
                            if (str3.equals("iball8735_9806")) {
                                c = Ascii.MAX;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1865889110:
                            if (str3.equals("santoni")) {
                                c = 128;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1906253259:
                            if (str3.equals("PB2-670M")) {
                                c = 129;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1977196784:
                            if (str3.equals("Infinix-X572")) {
                                c = 130;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2006372676:
                            if (str3.equals("BRAVIA_ATV3_4K")) {
                                c = 131;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2019281702:
                            if (str3.equals("DM-01K")) {
                                c = 132;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2029784656:
                            if (str3.equals("HWBLN-H")) {
                                c = 133;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2030379515:
                            if (str3.equals("HWCAM-H")) {
                                c = 134;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2033393791:
                            if (str3.equals("ASUS_X00AD_2")) {
                                c = 135;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2047190025:
                            if (str3.equals("ELUGA_Note")) {
                                c = 136;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2047252157:
                            if (str3.equals("ELUGA_Prim")) {
                                c = 137;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2048319463:
                            if (str3.equals("HWVNS-H")) {
                                c = 138;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2048855701:
                            if (str3.equals("HWWAS-H")) {
                                c = 139;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    switch (c) {
                        default:
                            String str4 = Util.MODEL;
                            str4.hashCode();
                            if (!str4.equals("JSN-L21")) {
                            }
                            break;
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case '\b':
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                        case 30:
                        case 31:
                        case ' ':
                        case '!':
                        case '\"':
                        case '#':
                        case '$':
                        case '%':
                        case '&':
                        case '\'':
                        case '(':
                        case ')':
                        case '*':
                        case '+':
                        case ',':
                        case '-':
                        case '.':
                        case '/':
                        case '0':
                        case '1':
                        case '2':
                        case '3':
                        case '4':
                        case '5':
                        case '6':
                        case '7':
                        case '8':
                        case '9':
                        case ':':
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                        case '?':
                        case '@':
                        case 'A':
                        case 'B':
                        case 'C':
                        case 'D':
                        case 'E':
                        case 'F':
                        case 'G':
                        case TokenParametersOuterClass$TokenParameters.MEDIAMUTED_FIELD_NUMBER /* 72 */:
                        case TokenParametersOuterClass$TokenParameters.APPSETID_FIELD_NUMBER /* 73 */:
                        case 'J':
                        case 'K':
                        case 'L':
                        case Analytics.AnalyticsData.COUNT_IMP_FIELD_NUMBER /* 77 */:
                        case 'N':
                        case Analytics.AnalyticsData.EXTRA_SIGNALS_FIELD_NUMBER /* 79 */:
                        case Analytics.AnalyticsData.BOOT_TIME_FIELD_NUMBER /* 80 */:
                        case 'Q':
                        case 'R':
                        case 'S':
                        case 'T':
                        case 'U':
                        case 'V':
                        case 'W':
                        case 'X':
                        case 'Y':
                        case 'Z':
                        case '[':
                        case '\\':
                        case ']':
                        case MBSupportMuteAdType.REWARD_VIDEO /* 94 */:
                        case '_':
                        case '`':
                        case 'a':
                        case 'b':
                        case 'c':
                        case 'd':
                        case 'e':
                        case 'f':
                        case 'g':
                        case 'h':
                        case 'i':
                        case 'j':
                        case 'k':
                        case 'l':
                        case 'm':
                        case 'n':
                        case 'o':
                        case 'p':
                        case 'q':
                        case 'r':
                        case 's':
                        case 't':
                        case ASSET_FAILED_STATUS_CODE_VALUE:
                        case PROTOBUF_SERIALIZATION_ERROR_VALUE:
                        case JSON_ENCODE_ERROR_VALUE:
                        case 'x':
                        case TPAT_ERROR_VALUE:
                        case INVALID_ADS_ENDPOINT_VALUE:
                        case INVALID_RI_ENDPOINT_VALUE:
                        case INVALID_LOG_ERROR_ENDPOINT_VALUE:
                        case INVALID_METRICS_ENDPOINT_VALUE:
                        case '~':
                        case 127:
                        case 128:
                        case 129:
                        case 130:
                        case MRAID_JS_WRITE_FAILED_VALUE:
                        case OMSDK_DOWNLOAD_JS_ERROR_VALUE:
                        case OMSDK_JS_WRITE_FAILED_VALUE:
                        case 134:
                        case 135:
                        case 136:
                        case TPAT_RETRY_FAILED_VALUE:
                        case 138:
                        case TsExtractor.TS_STREAM_TYPE_DTS_UHD /* 139 */:
                            return true;
                    }
                }
                break;
        }
        return true;
    }

    private final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {
        private static final int HANDLE_FRAME_RENDERED = 0;
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.handler = createHandlerForCurrentLooper;
            mediaCodecAdapter.setOnFrameRenderedListener(this, createHandlerForCurrentLooper);
        }

        @Override // com.google.android.exoplayer2.mediacodec.MediaCodecAdapter.OnFrameRenderedListener
        public void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j, long j2) {
            if (Util.SDK_INT < 30) {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (j >> 32), (int) j));
            } else {
                handleFrameRendered(j);
            }
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        private void handleFrameRendered(long j) {
            if (this != MediaCodecVideoRenderer.this.tunnelingOnFrameRenderedListener || MediaCodecVideoRenderer.this.getCodec() == null) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                MediaCodecVideoRenderer.this.onProcessedTunneledEndOfStream();
                return;
            }
            try {
                MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j);
            } catch (ExoPlaybackException e) {
                MediaCodecVideoRenderer.this.setPendingPlaybackException(e);
            }
        }
    }
}
