package com.mbridge.msdk.playercommon.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.util.Log;
import com.ironsource.C3040d4;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.PlaybackParameters;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioTrackPositionTracker;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import com.vungle.ads.internal.protos.Sdk;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/* loaded from: classes6.dex */
public final class DefaultAudioSink implements AudioSink {
    private static final int BUFFER_MULTIPLICATION_FACTOR = 4;
    private static final int ERROR_BAD_VALUE = -2;
    private static final long MAX_BUFFER_DURATION_US = 750000;
    private static final long MIN_BUFFER_DURATION_US = 250000;
    private static final int MODE_STATIC = 0;
    private static final int MODE_STREAM = 1;
    private static final long PASSTHROUGH_BUFFER_DURATION_US = 250000;
    private static final int START_IN_SYNC = 1;
    private static final int START_NEED_SYNC = 2;
    private static final int START_NOT_SET = 0;
    private static final int STATE_INITIALIZED = 1;
    private static final String TAG = "AudioTrack";
    private static final int WRITE_NON_BLOCKING = 1;
    public static boolean enablePreV21AudioSessionWorkaround = false;
    public static boolean failOnSpuriousAudioTimestamp = false;
    private AudioProcessor[] activeAudioProcessors;
    private PlaybackParameters afterDrainPlaybackParameters;
    private AudioAttributes audioAttributes;
    private final AudioCapabilities audioCapabilities;
    private final AudioProcessorChain audioProcessorChain;
    private int audioSessionId;
    private AudioTrack audioTrack;
    private final AudioTrackPositionTracker audioTrackPositionTracker;
    private ByteBuffer avSyncHeader;
    private int bufferSize;
    private int bytesUntilNextAvSync;
    private boolean canApplyPlaybackParameters;
    private final ChannelMappingAudioProcessor channelMappingAudioProcessor;
    private int drainingAudioProcessorIndex;
    private final boolean enableConvertHighResIntPcmToFloat;
    private int framesPerEncodedSample;
    private boolean handledEndOfStream;
    private ByteBuffer inputBuffer;
    private int inputSampleRate;
    private boolean isInputPcm;
    private AudioTrack keepSessionIdAudioTrack;
    private long lastFeedElapsedRealtimeMs;
    private AudioSink.Listener listener;
    private ByteBuffer outputBuffer;
    private ByteBuffer[] outputBuffers;
    private int outputChannelConfig;
    private int outputEncoding;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private int pcmFrameSize;
    private PlaybackParameters playbackParameters;
    private final ArrayDeque<PlaybackParametersCheckpoint> playbackParametersCheckpoints;
    private long playbackParametersOffsetUs;
    private long playbackParametersPositionUs;
    private boolean playing;
    private byte[] preV21OutputBuffer;
    private int preV21OutputBufferOffset;
    private boolean processingEnabled;
    private final ConditionVariable releasingConditionVariable;
    private boolean shouldConvertHighResIntPcmToFloat;
    private int startMediaTimeState;
    private long startMediaTimeUs;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private final AudioProcessor[] toFloatPcmAvailableAudioProcessors;
    private final AudioProcessor[] toIntPcmAvailableAudioProcessors;
    private final TrimmingAudioProcessor trimmingAudioProcessor;
    private boolean tunneling;
    private float volume;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    public interface AudioProcessorChain {
        PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters);

        AudioProcessor[] getAudioProcessors();

        long getMediaDuration(long j);

        long getSkippedOutputFrameCount();
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {
        private final AudioProcessor[] audioProcessors;
        private final SilenceSkippingAudioProcessor silenceSkippingAudioProcessor;
        private final SonicAudioProcessor sonicAudioProcessor;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            AudioProcessor[] audioProcessorArr2 = (AudioProcessor[]) Arrays.copyOf(audioProcessorArr, audioProcessorArr.length + 2);
            this.audioProcessors = audioProcessorArr2;
            SilenceSkippingAudioProcessor silenceSkippingAudioProcessor = new SilenceSkippingAudioProcessor();
            this.silenceSkippingAudioProcessor = silenceSkippingAudioProcessor;
            SonicAudioProcessor sonicAudioProcessor = new SonicAudioProcessor();
            this.sonicAudioProcessor = sonicAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters) {
            this.silenceSkippingAudioProcessor.setEnabled(playbackParameters.skipSilence);
            return new PlaybackParameters(this.sonicAudioProcessor.setSpeed(playbackParameters.speed), this.sonicAudioProcessor.setPitch(playbackParameters.pitch), playbackParameters.skipSilence);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public AudioProcessor[] getAudioProcessors() {
            return this.audioProcessors;
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getMediaDuration(long j) {
            return this.sonicAudioProcessor.scaleDurationForSpeedup(j);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getSkippedOutputFrameCount() {
            return this.silenceSkippingAudioProcessor.getSkippedFrames();
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    private static final class PlaybackParametersCheckpoint {
        private final long mediaTimeUs;
        private final PlaybackParameters playbackParameters;
        private final long positionUs;

        private PlaybackParametersCheckpoint(PlaybackParameters playbackParameters, long j, long j2) {
            this.playbackParameters = playbackParameters;
            this.mediaTimeUs = j;
            this.positionUs = j2;
        }
    }

    private final class PositionTrackerListener implements AudioTrackPositionTracker.Listener {
        private PositionTrackerListener() {
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onInvalidLatency(long j) {
            Log.w(DefaultAudioSink.TAG, "Ignoring impossibly large audio latency: " + j);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onPositionFramesMismatch(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + DefaultAudioSink.this.getSubmittedFrames() + ", " + DefaultAudioSink.this.getWrittenFrames();
            if (DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            Log.w(DefaultAudioSink.TAG, str);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onSystemTimeUsMismatch(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + DefaultAudioSink.this.getSubmittedFrames() + ", " + DefaultAudioSink.this.getWrittenFrames();
            if (DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                throw new InvalidAudioTrackTimestampException(str);
            }
            Log.w(DefaultAudioSink.TAG, str);
        }

        @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onUnderrun(int i, long j) {
            if (DefaultAudioSink.this.listener != null) {
                DefaultAudioSink.this.listener.onUnderrun(i, j, SystemClock.elapsedRealtime() - DefaultAudioSink.this.lastFeedElapsedRealtimeMs);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    private @interface StartMediaTimeState {
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArr) {
        this(audioCapabilities, audioProcessorArr, false);
    }

    private long applySkipping(long j) {
        return j + framesToDurationUs(this.audioProcessorChain.getSkippedOutputFrameCount());
    }

    private long applySpeedup(long j) {
        long j2;
        long mediaDurationForPlayoutDuration;
        PlaybackParametersCheckpoint playbackParametersCheckpoint = null;
        while (!this.playbackParametersCheckpoints.isEmpty() && j >= this.playbackParametersCheckpoints.getFirst().positionUs) {
            playbackParametersCheckpoint = this.playbackParametersCheckpoints.remove();
        }
        if (playbackParametersCheckpoint != null) {
            this.playbackParameters = playbackParametersCheckpoint.playbackParameters;
            this.playbackParametersPositionUs = playbackParametersCheckpoint.positionUs;
            this.playbackParametersOffsetUs = playbackParametersCheckpoint.mediaTimeUs - this.startMediaTimeUs;
        }
        if (this.playbackParameters.speed == 1.0f) {
            return (j + this.playbackParametersOffsetUs) - this.playbackParametersPositionUs;
        }
        if (this.playbackParametersCheckpoints.isEmpty()) {
            j2 = this.playbackParametersOffsetUs;
            mediaDurationForPlayoutDuration = this.audioProcessorChain.getMediaDuration(j - this.playbackParametersPositionUs);
        } else {
            j2 = this.playbackParametersOffsetUs;
            mediaDurationForPlayoutDuration = Util.getMediaDurationForPlayoutDuration(j - this.playbackParametersPositionUs, this.playbackParameters.speed);
        }
        return j2 + mediaDurationForPlayoutDuration;
    }

    private AudioTrack createAudioTrackV21() {
        android.media.AudioAttributes build = this.tunneling ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : this.audioAttributes.getAudioAttributesV21();
        AudioFormat build2 = new AudioFormat.Builder().setChannelMask(this.outputChannelConfig).setEncoding(this.outputEncoding).setSampleRate(this.outputSampleRate).build();
        int i = this.audioSessionId;
        if (i == 0) {
            i = 0;
        }
        return new AudioTrack(build, build2, this.bufferSize, 1, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0032 -> B:7:0x0012). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean drainAudioProcessorsToEndOfStream() throws AudioSink.WriteException {
        boolean z;
        int i;
        AudioProcessor[] audioProcessorArr;
        if (this.drainingAudioProcessorIndex == -1) {
            this.drainingAudioProcessorIndex = this.processingEnabled ? 0 : this.activeAudioProcessors.length;
            z = true;
            i = this.drainingAudioProcessorIndex;
            audioProcessorArr = this.activeAudioProcessors;
            if (i < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i];
                if (z) {
                    audioProcessor.queueEndOfStream();
                }
                processBuffers(-9223372036854775807L);
                if (!audioProcessor.isEnded()) {
                    return false;
                }
                this.drainingAudioProcessorIndex++;
                z = true;
                i = this.drainingAudioProcessorIndex;
                audioProcessorArr = this.activeAudioProcessors;
                if (i < audioProcessorArr.length) {
                    ByteBuffer byteBuffer = this.outputBuffer;
                    if (byteBuffer != null) {
                        writeBuffer(byteBuffer, -9223372036854775807L);
                        if (this.outputBuffer != null) {
                            return false;
                        }
                    }
                    this.drainingAudioProcessorIndex = -1;
                    return true;
                }
            }
        } else {
            z = false;
            i = this.drainingAudioProcessorIndex;
            audioProcessorArr = this.activeAudioProcessors;
            if (i < audioProcessorArr.length) {
            }
        }
    }

    private long durationUsToFrames(long j) {
        return (j * this.outputSampleRate) / 1000000;
    }

    private void flushAudioProcessors() {
        int i = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.activeAudioProcessors;
            if (i >= audioProcessorArr.length) {
                return;
            }
            AudioProcessor audioProcessor = audioProcessorArr[i];
            audioProcessor.flush();
            this.outputBuffers[i] = audioProcessor.getOutput();
            i++;
        }
    }

    private long framesToDurationUs(long j) {
        return (j * 1000000) / this.outputSampleRate;
    }

    private AudioProcessor[] getAvailableAudioProcessors() {
        return this.shouldConvertHighResIntPcmToFloat ? this.toFloatPcmAvailableAudioProcessors : this.toIntPcmAvailableAudioProcessors;
    }

    private static int getFramesPerEncodedSample(int i, ByteBuffer byteBuffer) {
        if (i == 7 || i == 8) {
            return DtsUtil.parseDtsAudioSampleCount(byteBuffer);
        }
        if (i == 5) {
            return Ac3Util.getAc3SyncframeAudioSampleCount();
        }
        if (i == 6) {
            return Ac3Util.parseEAc3SyncframeAudioSampleCount(byteBuffer);
        }
        if (i != 14) {
            throw new IllegalStateException("Unexpected audio encoding: " + i);
        }
        int findTrueHdSyncframeOffset = Ac3Util.findTrueHdSyncframeOffset(byteBuffer);
        if (findTrueHdSyncframeOffset == -1) {
            return 0;
        }
        return Ac3Util.parseTrueHdSyncframeAudioSampleCount(byteBuffer, findTrueHdSyncframeOffset) * 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getSubmittedFrames() {
        return this.isInputPcm ? this.submittedPcmBytes / this.pcmFrameSize : this.submittedEncodedFrames;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long getWrittenFrames() {
        return this.isInputPcm ? this.writtenPcmBytes / this.outputPcmFrameSize : this.writtenEncodedFrames;
    }

    private void initialize() throws AudioSink.InitializationException {
        this.releasingConditionVariable.block();
        AudioTrack initializeAudioTrack = initializeAudioTrack();
        this.audioTrack = initializeAudioTrack;
        int audioSessionId = initializeAudioTrack.getAudioSessionId();
        if (enablePreV21AudioSessionWorkaround && Util.SDK_INT < 21) {
            AudioTrack audioTrack = this.keepSessionIdAudioTrack;
            if (audioTrack != null && audioSessionId != audioTrack.getAudioSessionId()) {
                releaseKeepSessionIdAudioTrack();
            }
            if (this.keepSessionIdAudioTrack == null) {
                this.keepSessionIdAudioTrack = initializeKeepSessionIdAudioTrack(audioSessionId);
            }
        }
        if (this.audioSessionId != audioSessionId) {
            this.audioSessionId = audioSessionId;
            AudioSink.Listener listener = this.listener;
            if (listener != null) {
                listener.onAudioSessionId(audioSessionId);
            }
        }
        this.playbackParameters = this.canApplyPlaybackParameters ? this.audioProcessorChain.applyPlaybackParameters(this.playbackParameters) : PlaybackParameters.DEFAULT;
        setupAudioProcessors();
        this.audioTrackPositionTracker.setAudioTrack(this.audioTrack, this.outputEncoding, this.outputPcmFrameSize, this.bufferSize);
        setVolumeInternal();
    }

    private AudioTrack initializeAudioTrack() throws AudioSink.InitializationException {
        AudioTrack audioTrack;
        if (Util.SDK_INT >= 21) {
            audioTrack = createAudioTrackV21();
        } else {
            int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(this.audioAttributes.usage);
            audioTrack = this.audioSessionId == 0 ? new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1) : new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1, this.audioSessionId);
        }
        int state = audioTrack.getState();
        if (state == 1) {
            return audioTrack;
        }
        try {
            audioTrack.release();
        } catch (Exception unused) {
        }
        throw new AudioSink.InitializationException(state, this.outputSampleRate, this.outputChannelConfig, this.bufferSize);
    }

    private AudioTrack initializeKeepSessionIdAudioTrack(int i) {
        return new AudioTrack(3, 4000, 4, 2, 2, 0, i);
    }

    private long inputFramesToDurationUs(long j) {
        return (j * 1000000) / this.inputSampleRate;
    }

    private boolean isInitialized() {
        return this.audioTrack != null;
    }

    private void processBuffers(long j) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.activeAudioProcessors.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.outputBuffers[i - 1];
            } else {
                byteBuffer = this.inputBuffer;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (i == length) {
                writeBuffer(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.activeAudioProcessors[i];
                audioProcessor.queueInput(byteBuffer);
                ByteBuffer output = audioProcessor.getOutput();
                this.outputBuffers[i] = output;
                if (output.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    private void releaseKeepSessionIdAudioTrack() {
        final AudioTrack audioTrack = this.keepSessionIdAudioTrack;
        if (audioTrack == null) {
            return;
        }
        this.keepSessionIdAudioTrack = null;
        new Thread() { // from class: com.mbridge.msdk.playercommon.exoplayer2.audio.DefaultAudioSink.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                audioTrack.release();
            }
        }.start();
    }

    private void setVolumeInternal() {
        if (isInitialized()) {
            if (Util.SDK_INT >= 21) {
                setVolumeInternalV21(this.audioTrack, this.volume);
            } else {
                setVolumeInternalV3(this.audioTrack, this.volume);
            }
        }
    }

    private static void setVolumeInternalV21(AudioTrack audioTrack, float f) {
        audioTrack.setVolume(f);
    }

    private static void setVolumeInternalV3(AudioTrack audioTrack, float f) {
        audioTrack.setStereoVolume(f, f);
    }

    private void setupAudioProcessors() {
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : getAvailableAudioProcessors()) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.activeAudioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.outputBuffers = new ByteBuffer[size];
        flushAudioProcessors();
    }

    private void writeBuffer(ByteBuffer byteBuffer, long j) throws AudioSink.WriteException {
        DefaultAudioSink defaultAudioSink;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.outputBuffer;
            int i = 0;
            if (byteBuffer2 != null) {
                Assertions.checkArgument(byteBuffer2 == byteBuffer);
            } else {
                this.outputBuffer = byteBuffer;
                if (Util.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.preV21OutputBuffer;
                    if (bArr == null || bArr.length < remaining) {
                        this.preV21OutputBuffer = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.preV21OutputBuffer, 0, remaining);
                    byteBuffer.position(position);
                    this.preV21OutputBufferOffset = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (Util.SDK_INT < 21) {
                int availableBufferSize = this.audioTrackPositionTracker.getAvailableBufferSize(this.writtenPcmBytes);
                if (availableBufferSize > 0) {
                    i = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, Math.min(remaining2, availableBufferSize));
                    if (i > 0) {
                        this.preV21OutputBufferOffset += i;
                        byteBuffer.position(byteBuffer.position() + i);
                    }
                }
                defaultAudioSink = this;
            } else if (this.tunneling) {
                Assertions.checkState(j != -9223372036854775807L);
                defaultAudioSink = this;
                i = defaultAudioSink.writeNonBlockingWithAvSyncV21(this.audioTrack, byteBuffer, remaining2, j);
            } else {
                defaultAudioSink = this;
                i = writeNonBlockingV21(defaultAudioSink.audioTrack, byteBuffer, remaining2);
            }
            defaultAudioSink.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
            if (i < 0) {
                throw new AudioSink.WriteException(i);
            }
            boolean z = defaultAudioSink.isInputPcm;
            if (z) {
                defaultAudioSink.writtenPcmBytes += i;
            }
            if (i == remaining2) {
                if (!z) {
                    defaultAudioSink.writtenEncodedFrames += defaultAudioSink.framesPerEncodedSample;
                }
                defaultAudioSink.outputBuffer = null;
            }
        }
    }

    private static int writeNonBlockingV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int i) {
        return audioTrack.write(byteBuffer, i, 1);
    }

    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack, ByteBuffer byteBuffer, int i, long j) {
        if (this.avSyncHeader == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.avSyncHeader = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.avSyncHeader.putInt(1431633921);
        }
        if (this.bytesUntilNextAvSync == 0) {
            this.avSyncHeader.putInt(4, i);
            this.avSyncHeader.putLong(8, j * 1000);
            this.avSyncHeader.position(0);
            this.bytesUntilNextAvSync = i;
        }
        int remaining = this.avSyncHeader.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.avSyncHeader, remaining, 1);
            if (write < 0) {
                this.bytesUntilNextAvSync = 0;
                return write;
            }
            if (write < remaining) {
                return 0;
            }
        }
        int writeNonBlockingV21 = writeNonBlockingV21(audioTrack, byteBuffer, i);
        if (writeNonBlockingV21 < 0) {
            this.bytesUntilNextAvSync = 0;
            return writeNonBlockingV21;
        }
        this.bytesUntilNextAvSync -= writeNonBlockingV21;
        return writeNonBlockingV21;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0130  */
    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void configure(int i, int i2, int i3, int i4, int[] iArr, int i5, int i6) throws AudioSink.ConfigurationException {
        int i7;
        boolean z;
        int i8;
        boolean z2;
        int i9;
        int i10;
        int i11;
        int i12;
        this.inputSampleRate = i3;
        this.isInputPcm = Util.isEncodingPcm(i);
        this.shouldConvertHighResIntPcmToFloat = this.enableConvertHighResIntPcmToFloat && isEncodingSupported(1073741824) && Util.isEncodingHighResolutionIntegerPcm(i);
        if (this.isInputPcm) {
            this.pcmFrameSize = Util.getPcmFrameSize(i, i2);
        }
        int i13 = 4;
        if (this.isInputPcm) {
            i7 = i;
            if (i7 != 4) {
                z = true;
                this.canApplyPlaybackParameters = (z || this.shouldConvertHighResIntPcmToFloat) ? false : true;
                if (z) {
                    i8 = i3;
                    z2 = false;
                    i9 = i2;
                } else {
                    this.trimmingAudioProcessor.setTrimFrameCount(i5, i6);
                    this.channelMappingAudioProcessor.setChannelMap(iArr);
                    i8 = i3;
                    z2 = false;
                    i9 = i2;
                    for (AudioProcessor audioProcessor : getAvailableAudioProcessors()) {
                        try {
                            z2 |= audioProcessor.configure(i8, i9, i7);
                            if (audioProcessor.isActive()) {
                                i9 = audioProcessor.getOutputChannelCount();
                                i8 = audioProcessor.getOutputSampleRateHz();
                                i7 = audioProcessor.getOutputEncoding();
                            }
                        } catch (AudioProcessor.UnhandledFormatException e) {
                            throw new AudioSink.ConfigurationException(e);
                        }
                    }
                }
                i10 = 252;
                switch (i9) {
                    case 1:
                        break;
                    case 2:
                        i13 = 12;
                        break;
                    case 3:
                        i13 = 28;
                        break;
                    case 4:
                        i13 = 204;
                        break;
                    case 5:
                        i13 = Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE;
                        break;
                    case 6:
                        i13 = 252;
                        break;
                    case 7:
                        i13 = 1276;
                        break;
                    case 8:
                        i13 = C.CHANNEL_OUT_7POINT1_SURROUND;
                        break;
                    default:
                        throw new AudioSink.ConfigurationException("Unsupported channel count: " + i9);
                }
                i11 = Util.SDK_INT;
                if (i11 <= 23 && "foster".equals(Util.DEVICE) && "NVIDIA".equals(Util.MANUFACTURER)) {
                    if (i9 != 3 && i9 != 5) {
                        if (i9 == 7) {
                            i10 = C.CHANNEL_OUT_7POINT1_SURROUND;
                        }
                    }
                    i12 = (i11 <= 25 || !"fugu".equals(Util.DEVICE) || this.isInputPcm || i9 != 1) ? i10 : 12;
                    if (z2 && isInitialized() && this.outputEncoding == i7 && this.outputSampleRate == i8 && this.outputChannelConfig == i12) {
                        return;
                    }
                    reset();
                    this.processingEnabled = z;
                    this.outputSampleRate = i8;
                    this.outputChannelConfig = i12;
                    this.outputEncoding = i7;
                    this.outputPcmFrameSize = !this.isInputPcm ? Util.getPcmFrameSize(i7, i9) : -1;
                    if (i4 == 0) {
                        this.bufferSize = i4;
                        return;
                    }
                    if (this.isInputPcm) {
                        int minBufferSize = AudioTrack.getMinBufferSize(i8, i12, this.outputEncoding);
                        Assertions.checkState(minBufferSize != -2);
                        this.bufferSize = Util.constrainValue(minBufferSize * 4, ((int) durationUsToFrames(250000L)) * this.outputPcmFrameSize, (int) Math.max(minBufferSize, durationUsToFrames(MAX_BUFFER_DURATION_US) * this.outputPcmFrameSize));
                        return;
                    }
                    int i14 = this.outputEncoding;
                    if (i14 == 5 || i14 == 6) {
                        this.bufferSize = 20480;
                        return;
                    } else if (i14 == 7) {
                        this.bufferSize = 49152;
                        return;
                    } else {
                        this.bufferSize = 294912;
                        return;
                    }
                }
                i10 = i13;
                if (i11 <= 25) {
                }
                if (z2) {
                }
                reset();
                this.processingEnabled = z;
                this.outputSampleRate = i8;
                this.outputChannelConfig = i12;
                this.outputEncoding = i7;
                this.outputPcmFrameSize = !this.isInputPcm ? Util.getPcmFrameSize(i7, i9) : -1;
                if (i4 == 0) {
                }
            }
        } else {
            i7 = i;
        }
        z = false;
        this.canApplyPlaybackParameters = (z || this.shouldConvertHighResIntPcmToFloat) ? false : true;
        if (z) {
        }
        i10 = 252;
        switch (i9) {
        }
        i11 = Util.SDK_INT;
        if (i11 <= 23) {
            if (i9 != 3) {
                if (i9 == 7) {
                }
            }
            if (i11 <= 25) {
            }
            if (z2) {
            }
            reset();
            this.processingEnabled = z;
            this.outputSampleRate = i8;
            this.outputChannelConfig = i12;
            this.outputEncoding = i7;
            this.outputPcmFrameSize = !this.isInputPcm ? Util.getPcmFrameSize(i7, i9) : -1;
            if (i4 == 0) {
            }
        }
        i10 = i13;
        if (i11 <= 25) {
        }
        if (z2) {
        }
        reset();
        this.processingEnabled = z;
        this.outputSampleRate = i8;
        this.outputChannelConfig = i12;
        this.outputEncoding = i7;
        this.outputPcmFrameSize = !this.isInputPcm ? Util.getPcmFrameSize(i7, i9) : -1;
        if (i4 == 0) {
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        if (this.tunneling) {
            this.tunneling = false;
            this.audioSessionId = 0;
            reset();
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public void enableTunnelingV21(int i) {
        Assertions.checkState(Util.SDK_INT >= 21);
        if (this.tunneling && this.audioSessionId == i) {
            return;
        }
        this.tunneling = true;
        this.audioSessionId = i;
        reset();
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        if (!isInitialized() || this.startMediaTimeState == 0) {
            return Long.MIN_VALUE;
        }
        return this.startMediaTimeUs + applySkipping(applySpeedup(Math.min(this.audioTrackPositionTracker.getCurrentPositionUs(z), framesToDurationUs(getWrittenFrames()))));
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer, long j) throws AudioSink.InitializationException, AudioSink.WriteException {
        boolean z;
        ByteBuffer byteBuffer2 = this.inputBuffer;
        Assertions.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!isInitialized()) {
            initialize();
            if (this.playing) {
                play();
            }
        }
        if (!this.audioTrackPositionTracker.mayHandleBuffer(getWrittenFrames())) {
            return false;
        }
        if (this.inputBuffer != null) {
            z = false;
        } else {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (!this.isInputPcm && this.framesPerEncodedSample == 0) {
                int framesPerEncodedSample = getFramesPerEncodedSample(this.outputEncoding, byteBuffer);
                this.framesPerEncodedSample = framesPerEncodedSample;
                if (framesPerEncodedSample == 0) {
                    return true;
                }
            }
            if (this.afterDrainPlaybackParameters == null) {
                z = false;
            } else {
                if (!drainAudioProcessorsToEndOfStream()) {
                    return false;
                }
                PlaybackParameters playbackParameters = this.afterDrainPlaybackParameters;
                this.afterDrainPlaybackParameters = null;
                z = false;
                this.playbackParametersCheckpoints.add(new PlaybackParametersCheckpoint(this.audioProcessorChain.applyPlaybackParameters(playbackParameters), Math.max(0L, j), framesToDurationUs(getWrittenFrames())));
                setupAudioProcessors();
            }
            if (this.startMediaTimeState == 0) {
                this.startMediaTimeUs = Math.max(0L, j);
                this.startMediaTimeState = 1;
            } else {
                long inputFramesToDurationUs = this.startMediaTimeUs + inputFramesToDurationUs(getSubmittedFrames());
                if (this.startMediaTimeState == 1 && Math.abs(inputFramesToDurationUs - j) > 200000) {
                    Log.e(TAG, "Discontinuity detected [expected " + inputFramesToDurationUs + ", got " + j + C3040d4.i.e);
                    this.startMediaTimeState = 2;
                }
                if (this.startMediaTimeState == 2) {
                    this.startMediaTimeUs += j - inputFramesToDurationUs;
                    this.startMediaTimeState = 1;
                    AudioSink.Listener listener = this.listener;
                    if (listener != null) {
                        listener.onPositionDiscontinuity();
                    }
                }
            }
            if (this.isInputPcm) {
                this.submittedPcmBytes += byteBuffer.remaining();
            } else {
                this.submittedEncodedFrames += this.framesPerEncodedSample;
            }
            this.inputBuffer = byteBuffer;
        }
        if (this.processingEnabled) {
            processBuffers(j);
        } else {
            writeBuffer(this.inputBuffer, j);
        }
        if (!this.inputBuffer.hasRemaining()) {
            this.inputBuffer = null;
            return true;
        }
        if (!this.audioTrackPositionTracker.isStalled(getWrittenFrames())) {
            return z;
        }
        Log.w(TAG, "Resetting stalled audio track");
        reset();
        return true;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        if (this.startMediaTimeState == 1) {
            this.startMediaTimeState = 2;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return isInitialized() && this.audioTrackPositionTracker.hasPendingData(getWrittenFrames());
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public boolean isEncodingSupported(int i) {
        if (Util.isEncodingPcm(i)) {
            return i != 4 || Util.SDK_INT >= 21;
        }
        AudioCapabilities audioCapabilities = this.audioCapabilities;
        return audioCapabilities != null && audioCapabilities.supportsEncoding(i);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        if (isInitialized()) {
            return this.handledEndOfStream && !hasPendingData();
        }
        return true;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public void pause() {
        this.playing = false;
        if (isInitialized() && this.audioTrackPositionTracker.pause()) {
            this.audioTrack.pause();
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public void play() {
        this.playing = true;
        if (isInitialized()) {
            this.audioTrackPositionTracker.start();
            this.audioTrack.play();
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.handledEndOfStream && isInitialized() && drainAudioProcessorsToEndOfStream()) {
            this.audioTrackPositionTracker.handleEndOfStream(getWrittenFrames());
            this.audioTrack.stop();
            this.bytesUntilNextAvSync = 0;
            this.handledEndOfStream = true;
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public void release() {
        reset();
        releaseKeepSessionIdAudioTrack();
        for (AudioProcessor audioProcessor : this.toIntPcmAvailableAudioProcessors) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.toFloatPcmAvailableAudioProcessors) {
            audioProcessor2.reset();
        }
        this.audioSessionId = 0;
        this.playing = false;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public void reset() {
        if (isInitialized()) {
            this.submittedPcmBytes = 0L;
            this.submittedEncodedFrames = 0L;
            this.writtenPcmBytes = 0L;
            this.writtenEncodedFrames = 0L;
            this.framesPerEncodedSample = 0;
            PlaybackParameters playbackParameters = this.afterDrainPlaybackParameters;
            if (playbackParameters != null) {
                this.playbackParameters = playbackParameters;
                this.afterDrainPlaybackParameters = null;
            } else if (!this.playbackParametersCheckpoints.isEmpty()) {
                this.playbackParameters = this.playbackParametersCheckpoints.getLast().playbackParameters;
            }
            this.playbackParametersCheckpoints.clear();
            this.playbackParametersOffsetUs = 0L;
            this.playbackParametersPositionUs = 0L;
            this.inputBuffer = null;
            this.outputBuffer = null;
            flushAudioProcessors();
            this.handledEndOfStream = false;
            this.drainingAudioProcessorIndex = -1;
            this.avSyncHeader = null;
            this.bytesUntilNextAvSync = 0;
            this.startMediaTimeState = 0;
            if (this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            final AudioTrack audioTrack = this.audioTrack;
            this.audioTrack = null;
            this.audioTrackPositionTracker.reset();
            this.releasingConditionVariable.close();
            new Thread() { // from class: com.mbridge.msdk.playercommon.exoplayer2.audio.DefaultAudioSink.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        audioTrack.flush();
                        audioTrack.release();
                    } finally {
                        DefaultAudioSink.this.releasingConditionVariable.open();
                    }
                }
            }.start();
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public void setAudioAttributes(AudioAttributes audioAttributes) {
        if (this.audioAttributes.equals(audioAttributes)) {
            return;
        }
        this.audioAttributes = audioAttributes;
        if (this.tunneling) {
            return;
        }
        reset();
        this.audioSessionId = 0;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i) {
        if (this.audioSessionId != i) {
            this.audioSessionId = i;
            reset();
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public void setListener(AudioSink.Listener listener) {
        this.listener = listener;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public PlaybackParameters setPlaybackParameters(PlaybackParameters playbackParameters) {
        if (isInitialized() && !this.canApplyPlaybackParameters) {
            PlaybackParameters playbackParameters2 = PlaybackParameters.DEFAULT;
            this.playbackParameters = playbackParameters2;
            return playbackParameters2;
        }
        PlaybackParameters playbackParameters3 = this.afterDrainPlaybackParameters;
        if (playbackParameters3 == null) {
            playbackParameters3 = !this.playbackParametersCheckpoints.isEmpty() ? this.playbackParametersCheckpoints.getLast().playbackParameters : this.playbackParameters;
        }
        if (!playbackParameters.equals(playbackParameters3)) {
            if (isInitialized()) {
                this.afterDrainPlaybackParameters = playbackParameters;
            } else {
                this.playbackParameters = this.audioProcessorChain.applyPlaybackParameters(playbackParameters);
            }
        }
        return this.playbackParameters;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioSink
    public void setVolume(float f) {
        if (this.volume != f) {
            this.volume = f;
            setVolumeInternal();
        }
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities, AudioProcessor[] audioProcessorArr, boolean z) {
        this(audioCapabilities, new DefaultAudioProcessorChain(audioProcessorArr), z);
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities, AudioProcessorChain audioProcessorChain, boolean z) {
        this.audioCapabilities = audioCapabilities;
        this.audioProcessorChain = (AudioProcessorChain) Assertions.checkNotNull(audioProcessorChain);
        this.enableConvertHighResIntPcmToFloat = z;
        this.releasingConditionVariable = new ConditionVariable(true);
        this.audioTrackPositionTracker = new AudioTrackPositionTracker(new PositionTrackerListener());
        ChannelMappingAudioProcessor channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.channelMappingAudioProcessor = channelMappingAudioProcessor;
        TrimmingAudioProcessor trimmingAudioProcessor = new TrimmingAudioProcessor();
        this.trimmingAudioProcessor = trimmingAudioProcessor;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new ResamplingAudioProcessor(), channelMappingAudioProcessor, trimmingAudioProcessor);
        Collections.addAll(arrayList, audioProcessorChain.getAudioProcessors());
        this.toIntPcmAvailableAudioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[arrayList.size()]);
        this.toFloatPcmAvailableAudioProcessors = new AudioProcessor[]{new FloatResamplingAudioProcessor()};
        this.volume = 1.0f;
        this.startMediaTimeState = 0;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        this.playbackParameters = PlaybackParameters.DEFAULT;
        this.drainingAudioProcessorIndex = -1;
        this.activeAudioProcessors = new AudioProcessor[0];
        this.outputBuffers = new ByteBuffer[0];
        this.playbackParametersCheckpoints = new ArrayDeque<>();
    }
}
