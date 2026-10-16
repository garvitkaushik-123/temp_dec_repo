package io.bidmachine.media3.exoplayer.video;

import android.graphics.Bitmap;
import android.media.MediaFormat;
import android.view.Surface;
import io.bidmachine.media3.common.Effect;
import io.bidmachine.media3.common.Format;
import io.bidmachine.media3.common.VideoSize;
import io.bidmachine.media3.common.util.Assertions;
import io.bidmachine.media3.common.util.Clock;
import io.bidmachine.media3.common.util.Size;
import io.bidmachine.media3.common.util.TimestampIterator;
import io.bidmachine.media3.exoplayer.ExoPlaybackException;
import io.bidmachine.media3.exoplayer.Renderer;
import io.bidmachine.media3.exoplayer.video.DefaultVideoSink;
import io.bidmachine.media3.exoplayer.video.VideoFrameRenderControl;
import io.bidmachine.media3.exoplayer.video.VideoSink;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
final class DefaultVideoSink implements VideoSink {
    private long bufferTimestampAdjustmentUs;
    private final Clock clock;
    private Format inputFormat;
    private VideoSink.Listener listener;
    private Executor listenerExecutor;
    private Surface outputSurface;
    private long streamStartPositionUs;
    private final Queue<VideoSink.VideoFrameHandler> videoFrameHandlers;
    private VideoFrameMetadataListener videoFrameMetadataListener;
    private final VideoFrameReleaseControl videoFrameReleaseControl;
    private final VideoFrameRenderControl videoFrameRenderControl;

    static /* synthetic */ void lambda$new$0(Runnable runnable) {
    }

    static /* synthetic */ void lambda$new$1(long j, long j2, Format format, MediaFormat mediaFormat) {
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public boolean initialize(Format format) {
        return true;
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public boolean isInitialized() {
        return true;
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void release() {
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void signalEndOfInput() {
    }

    public DefaultVideoSink(VideoFrameReleaseControl videoFrameReleaseControl, Clock clock) {
        this.videoFrameReleaseControl = videoFrameReleaseControl;
        videoFrameReleaseControl.setClock(clock);
        this.clock = clock;
        this.videoFrameRenderControl = new VideoFrameRenderControl(new FrameRendererImpl(), videoFrameReleaseControl);
        this.videoFrameHandlers = new ArrayDeque();
        this.inputFormat = new Format.Builder().build();
        this.streamStartPositionUs = -9223372036854775807L;
        this.listener = VideoSink.Listener.NO_OP;
        this.listenerExecutor = new Executor() { // from class: io.bidmachine.media3.exoplayer.video.DefaultVideoSink$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                DefaultVideoSink.lambda$new$0(runnable);
            }
        };
        this.videoFrameMetadataListener = new VideoFrameMetadataListener() { // from class: io.bidmachine.media3.exoplayer.video.DefaultVideoSink$$ExternalSyntheticLambda1
            @Override // io.bidmachine.media3.exoplayer.video.VideoFrameMetadataListener
            public final void onVideoFrameAboutToBeRendered(long j, long j2, Format format, MediaFormat mediaFormat) {
                DefaultVideoSink.lambda$new$1(j, j2, format, mediaFormat);
            }
        };
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void onRendererEnabled(boolean z) {
        this.videoFrameReleaseControl.onEnabled(z);
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void onRendererDisabled() {
        this.videoFrameReleaseControl.onDisabled();
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void onRendererStarted() {
        this.videoFrameReleaseControl.onStarted();
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void onRendererStopped() {
        this.videoFrameReleaseControl.onStopped();
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void setListener(VideoSink.Listener listener, Executor executor) {
        this.listener = listener;
        this.listenerExecutor = executor;
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void flush(boolean z) {
        if (z) {
            this.videoFrameReleaseControl.reset();
        }
        this.videoFrameRenderControl.flush();
        this.videoFrameHandlers.clear();
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public boolean isReady(boolean z) {
        return this.videoFrameReleaseControl.isReady(z);
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void signalEndOfCurrentInputStream() {
        this.videoFrameRenderControl.signalEndOfInput();
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public boolean isEnded() {
        return this.videoFrameRenderControl.isEnded();
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public Surface getInputSurface() {
        return (Surface) Assertions.checkStateNotNull(this.outputSurface);
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        this.videoFrameMetadataListener = videoFrameMetadataListener;
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void setPlaybackSpeed(float f) {
        this.videoFrameReleaseControl.setPlaybackSpeed(f);
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void setVideoEffects(List<Effect> list) {
        throw new UnsupportedOperationException();
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void setStreamTimestampInfo(long j, long j2) {
        if (j != this.streamStartPositionUs) {
            this.videoFrameRenderControl.onStreamStartPositionChanged(j);
            this.streamStartPositionUs = j;
        }
        this.bufferTimestampAdjustmentUs = j2;
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void setOutputSurfaceInfo(Surface surface, Size size) {
        this.outputSurface = surface;
        this.videoFrameReleaseControl.setOutputSurface(surface);
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void clearOutputSurfaceInfo() {
        this.outputSurface = null;
        this.videoFrameReleaseControl.setOutputSurface(null);
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void setChangeFrameRateStrategy(int i) {
        this.videoFrameReleaseControl.setChangeFrameRateStrategy(i);
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void enableMayRenderStartOfStream() {
        this.videoFrameReleaseControl.allowReleaseFirstFrameBeforeStarted();
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void onInputStreamChanged(int i, Format format, List<Effect> list) {
        Assertions.checkState(list.isEmpty());
        if (format.width != this.inputFormat.width || format.height != this.inputFormat.height) {
            this.videoFrameRenderControl.onVideoSizeChanged(format.width, format.height);
        }
        if (format.frameRate != this.inputFormat.frameRate) {
            this.videoFrameReleaseControl.setFrameRate(format.frameRate);
        }
        this.inputFormat = format;
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public boolean handleInputFrame(long j, boolean z, VideoSink.VideoFrameHandler videoFrameHandler) {
        this.videoFrameHandlers.add(videoFrameHandler);
        this.videoFrameRenderControl.onFrameAvailableForRendering(j - this.bufferTimestampAdjustmentUs);
        return true;
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public boolean handleInputBitmap(Bitmap bitmap, TimestampIterator timestampIterator) {
        throw new UnsupportedOperationException();
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void render(long j, long j2) throws VideoSink.VideoSinkException {
        try {
            this.videoFrameRenderControl.render(j, j2);
        } catch (ExoPlaybackException e) {
            throw new VideoSink.VideoSinkException(e, this.inputFormat);
        }
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void setWakeupListener(Renderer.WakeupListener wakeupListener) {
        throw new UnsupportedOperationException();
    }

    @Override // io.bidmachine.media3.exoplayer.video.VideoSink
    public void join(boolean z) {
        this.videoFrameReleaseControl.join(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    final class FrameRendererImpl implements VideoFrameRenderControl.FrameRenderer {
        private Format outputFormat;

        private FrameRendererImpl() {
        }

        @Override // io.bidmachine.media3.exoplayer.video.VideoFrameRenderControl.FrameRenderer
        public void onVideoSizeChanged(final VideoSize videoSize) {
            this.outputFormat = new Format.Builder().setWidth(videoSize.width).setHeight(videoSize.height).setSampleMimeType("video/raw").build();
            DefaultVideoSink.this.listenerExecutor.execute(new Runnable() { // from class: io.bidmachine.media3.exoplayer.video.DefaultVideoSink$FrameRendererImpl$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultVideoSink.FrameRendererImpl.this.m9857x113faaf9(videoSize);
                }
            });
        }

        /* renamed from: lambda$onVideoSizeChanged$0$io-bidmachine-media3-exoplayer-video-DefaultVideoSink$FrameRendererImpl, reason: not valid java name */
        /* synthetic */ void m9857x113faaf9(VideoSize videoSize) {
            DefaultVideoSink.this.listener.onVideoSizeChanged(DefaultVideoSink.this, videoSize);
        }

        @Override // io.bidmachine.media3.exoplayer.video.VideoFrameRenderControl.FrameRenderer
        public void renderFrame(long j, long j2, boolean z) {
            if (z && DefaultVideoSink.this.outputSurface != null) {
                DefaultVideoSink.this.listenerExecutor.execute(new Runnable() { // from class: io.bidmachine.media3.exoplayer.video.DefaultVideoSink$FrameRendererImpl$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultVideoSink.FrameRendererImpl.this.m9858x5b425ea0();
                    }
                });
            }
            Format format = this.outputFormat;
            if (format == null) {
                format = new Format.Builder().build();
            }
            DefaultVideoSink.this.videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j2, DefaultVideoSink.this.clock.nanoTime(), format, null);
            ((VideoSink.VideoFrameHandler) DefaultVideoSink.this.videoFrameHandlers.remove()).render(j);
        }

        /* renamed from: lambda$renderFrame$1$io-bidmachine-media3-exoplayer-video-DefaultVideoSink$FrameRendererImpl, reason: not valid java name */
        /* synthetic */ void m9858x5b425ea0() {
            DefaultVideoSink.this.listener.onFirstFrameRendered(DefaultVideoSink.this);
        }

        @Override // io.bidmachine.media3.exoplayer.video.VideoFrameRenderControl.FrameRenderer
        public void dropFrame() {
            DefaultVideoSink.this.listenerExecutor.execute(new Runnable() { // from class: io.bidmachine.media3.exoplayer.video.DefaultVideoSink$FrameRendererImpl$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    DefaultVideoSink.FrameRendererImpl.this.m9856x20287fe8();
                }
            });
            ((VideoSink.VideoFrameHandler) DefaultVideoSink.this.videoFrameHandlers.remove()).skip();
        }

        /* renamed from: lambda$dropFrame$2$io-bidmachine-media3-exoplayer-video-DefaultVideoSink$FrameRendererImpl, reason: not valid java name */
        /* synthetic */ void m9856x20287fe8() {
            DefaultVideoSink.this.listener.onFrameDropped(DefaultVideoSink.this);
        }
    }
}
