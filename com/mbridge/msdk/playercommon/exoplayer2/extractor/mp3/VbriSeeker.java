package com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.MpegAudioHeader;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekPoint;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

/* loaded from: classes6.dex */
final class VbriSeeker implements Mp3Extractor.Seeker {
    private static final String TAG = "VbriSeeker";
    private final long durationUs;
    private final long[] positions;
    private final long[] timesUs;

    private VbriSeeker(long[] jArr, long[] jArr2, long j) {
        this.timesUs = jArr;
        this.positions = jArr2;
        this.durationUs = j;
    }

    public static VbriSeeker create(long j, long j2, MpegAudioHeader mpegAudioHeader, ParsableByteArray parsableByteArray) {
        int readUnsignedByte;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.skipBytes(10);
        int readInt = parsableByteArray2.readInt();
        if (readInt <= 0) {
            return null;
        }
        int i = mpegAudioHeader.sampleRate;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(readInt, (i >= 32000 ? 1152 : 576) * 1000000, i);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray2.readUnsignedShort();
        int readUnsignedShort3 = parsableByteArray2.readUnsignedShort();
        parsableByteArray2.skipBytes(2);
        long j3 = j2 + mpegAudioHeader.frameSize;
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        int i2 = 0;
        long j4 = j2;
        while (i2 < readUnsignedShort) {
            long j5 = j3;
            jArr[i2] = (i2 * scaleLargeTimestamp) / readUnsignedShort;
            jArr2[i2] = Math.max(j4, j5);
            if (readUnsignedShort3 == 1) {
                readUnsignedByte = parsableByteArray2.readUnsignedByte();
            } else if (readUnsignedShort3 == 2) {
                readUnsignedByte = parsableByteArray2.readUnsignedShort();
            } else if (readUnsignedShort3 == 3) {
                readUnsignedByte = parsableByteArray2.readUnsignedInt24();
            } else {
                if (readUnsignedShort3 != 4) {
                    return null;
                }
                readUnsignedByte = parsableByteArray2.readUnsignedIntToInt();
            }
            j4 += readUnsignedByte * readUnsignedShort2;
            i2++;
            parsableByteArray2 = parsableByteArray;
            j3 = j5;
            readUnsignedShort = readUnsignedShort;
        }
        if (j != -1 && j != j4) {
            Log.w(TAG, "VBRI data size mismatch: " + j + ", " + j4);
        }
        return new VbriSeeker(jArr, jArr2, scaleLargeTimestamp);
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.durationUs;
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        int binarySearchFloor = Util.binarySearchFloor(this.timesUs, j, true, true);
        SeekPoint seekPoint = new SeekPoint(this.timesUs[binarySearchFloor], this.positions[binarySearchFloor]);
        if (seekPoint.timeUs >= j || binarySearchFloor == this.timesUs.length - 1) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        int i = binarySearchFloor + 1;
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(this.timesUs[i], this.positions[i]));
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.mp3.Mp3Extractor.Seeker
    public long getTimeUs(long j) {
        return this.timesUs[Util.binarySearchFloor(this.positions, j, true, true)];
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
