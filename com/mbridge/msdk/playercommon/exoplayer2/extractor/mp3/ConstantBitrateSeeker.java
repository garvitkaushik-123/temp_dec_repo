package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

/* loaded from: classes6.dex */
final class ConstantBitrateSeeker implements Mp3Extractor.Seeker {
    private static final int BITS_PER_BYTE = 8;
    private final int bitrate;
    private final long dataSize;
    private final long durationUs;
    private final long firstFramePosition;
    private final int frameSize;

    public ConstantBitrateSeeker(long j, long j2, MpegAudioHeader mpegAudioHeader) {
        this.firstFramePosition = j2;
        this.frameSize = mpegAudioHeader.frameSize;
        this.bitrate = mpegAudioHeader.bitrate;
        if (j == -1) {
            this.dataSize = -1L;
            this.durationUs = -9223372036854775807L;
        } else {
            this.dataSize = j - j2;
            this.durationUs = getTimeUs(j);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        long j2 = this.dataSize;
        if (j2 == -1) {
            return new SeekMap.SeekPoints(new SeekPoint(0L, this.firstFramePosition));
        }
        long j3 = this.frameSize;
        long constrainValue = Util.constrainValue((((this.bitrate * j) / 8000000) / j3) * j3, 0L, j2 - j3);
        long j4 = this.firstFramePosition + constrainValue;
        long timeUs = getTimeUs(j4);
        SeekPoint seekPoint = new SeekPoint(timeUs, j4);
        if (timeUs < j) {
            long j5 = this.dataSize;
            long j6 = this.frameSize;
            if (constrainValue != j5 - j6) {
                long j7 = j4 + j6;
                return new SeekMap.SeekPoints(seekPoint, new SeekPoint(getTimeUs(j7), j7));
            }
        }
        return new SeekMap.SeekPoints(seekPoint);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j) {
        return (Math.max(0L, j - this.firstFramePosition) * 8000000) / this.bitrate;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.dataSize != -1;
    }
}
