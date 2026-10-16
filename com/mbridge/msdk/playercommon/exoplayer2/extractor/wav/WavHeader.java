package com.mbridge.msdk.playercommon.exoplayer2.extractor.wav;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

/* loaded from: classes6.dex */
final class WavHeader implements SeekMap {
    private final int averageBytesPerSecond;
    private final int bitsPerSample;
    private final int blockAlignment;
    private long dataSize;
    private long dataStartPosition;
    private final int encoding;
    private final int numChannels;
    private final int sampleRateHz;

    public WavHeader(int i, int i2, int i3, int i4, int i5, int i6) {
        this.numChannels = i;
        this.sampleRateHz = i2;
        this.averageBytesPerSecond = i3;
        this.blockAlignment = i4;
        this.bitsPerSample = i5;
        this.encoding = i6;
    }

    public int getBitrate() {
        return this.sampleRateHz * this.bitsPerSample * this.numChannels;
    }

    public int getBytesPerFrame() {
        return this.blockAlignment;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return ((this.dataSize / this.blockAlignment) * 1000000) / this.sampleRateHz;
    }

    public int getEncoding() {
        return this.encoding;
    }

    public int getNumChannels() {
        return this.numChannels;
    }

    public int getSampleRateHz() {
        return this.sampleRateHz;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        long j2 = this.blockAlignment;
        long constrainValue = Util.constrainValue((((this.averageBytesPerSecond * j) / 1000000) / j2) * j2, 0L, this.dataSize - j2);
        long j3 = this.dataStartPosition + constrainValue;
        long timeUs = getTimeUs(j3);
        SeekPoint seekPoint = new SeekPoint(timeUs, j3);
        if (timeUs < j) {
            long j4 = this.dataSize;
            long j5 = this.blockAlignment;
            if (constrainValue != j4 - j5) {
                long j6 = j3 + j5;
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j6), j6));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    public long getTimeUs(long j) {
        return (Math.max(0L, j - this.dataStartPosition) * 1000000) / this.averageBytesPerSecond;
    }

    public boolean hasDataBounds() {
        return (this.dataStartPosition == 0 || this.dataSize == 0) ? false : true;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }

    public void setDataBounds(long j, long j2) {
        this.dataStartPosition = j;
        this.dataSize = j2;
    }
}
