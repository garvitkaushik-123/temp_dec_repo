package com.mbridge.msdk.playercommon.exoplayer2.audio;

import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* loaded from: classes6.dex */
final class TrimmingAudioProcessor implements AudioProcessor {
    private ByteBuffer buffer;
    private int channelCount;
    private byte[] endBuffer;
    private int endBufferSize;
    private boolean inputEnded;
    private boolean isActive;
    private ByteBuffer outputBuffer;
    private int pendingTrimStartBytes;
    private int sampleRateHz;
    private int trimEndFrames;
    private int trimStartFrames;

    public TrimmingAudioProcessor() {
        ByteBuffer byteBuffer = AudioProcessor.EMPTY_BUFFER;
        this.buffer = byteBuffer;
        this.outputBuffer = byteBuffer;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.endBuffer = new byte[0];
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor
    public boolean configure(int i, int i2, int i3) throws AudioProcessor.UnhandledFormatException {
        if (i3 != 2) {
            throw new AudioProcessor.UnhandledFormatException(i, i2, i3);
        }
        this.channelCount = i2;
        this.sampleRateHz = i;
        int i4 = this.trimEndFrames;
        this.endBuffer = new byte[i4 * i2 * 2];
        this.endBufferSize = 0;
        int i5 = this.trimStartFrames;
        this.pendingTrimStartBytes = i2 * i5 * 2;
        boolean z = this.isActive;
        boolean z2 = (i5 == 0 && i4 == 0) ? false : true;
        this.isActive = z2;
        return z != z2;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor
    public void flush() {
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        this.inputEnded = false;
        this.pendingTrimStartBytes = 0;
        this.endBufferSize = 0;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.outputBuffer;
        this.outputBuffer = AudioProcessor.EMPTY_BUFFER;
        return byteBuffer;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor
    public int getOutputChannelCount() {
        return this.channelCount;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor
    public int getOutputEncoding() {
        return 2;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor
    public int getOutputSampleRateHz() {
        return this.sampleRateHz;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor
    public boolean isActive() {
        return this.isActive;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor
    public boolean isEnded() {
        return this.inputEnded && this.outputBuffer == AudioProcessor.EMPTY_BUFFER;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor
    public void queueEndOfStream() {
        this.inputEnded = true;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor
    public void queueInput(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int min = Math.min(i, this.pendingTrimStartBytes);
        this.pendingTrimStartBytes -= min;
        byteBuffer.position(position + min);
        if (this.pendingTrimStartBytes > 0) {
            return;
        }
        int i2 = i - min;
        int length = (this.endBufferSize + i2) - this.endBuffer.length;
        if (this.buffer.capacity() < length) {
            this.buffer = ByteBuffer.allocateDirect(length).order(ByteOrder.nativeOrder());
        } else {
            this.buffer.clear();
        }
        int constrainValue = Util.constrainValue(length, 0, this.endBufferSize);
        this.buffer.put(this.endBuffer, 0, constrainValue);
        int constrainValue2 = Util.constrainValue(length - constrainValue, 0, i2);
        byteBuffer.limit(byteBuffer.position() + constrainValue2);
        this.buffer.put(byteBuffer);
        byteBuffer.limit(limit);
        int i3 = i2 - constrainValue2;
        int i4 = this.endBufferSize - constrainValue;
        this.endBufferSize = i4;
        byte[] bArr = this.endBuffer;
        System.arraycopy(bArr, constrainValue, bArr, 0, i4);
        byteBuffer.get(this.endBuffer, this.endBufferSize, i3);
        this.endBufferSize += i3;
        this.buffer.flip();
        this.outputBuffer = this.buffer;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor
    public void reset() {
        flush();
        this.buffer = AudioProcessor.EMPTY_BUFFER;
        this.channelCount = -1;
        this.sampleRateHz = -1;
        this.endBuffer = new byte[0];
    }

    public void setTrimFrameCount(int i, int i2) {
        this.trimStartFrames = i;
        this.trimEndFrames = i2;
    }
}
