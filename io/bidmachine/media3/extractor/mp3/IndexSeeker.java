package io.bidmachine.media3.extractor.mp3;

import io.bidmachine.media3.common.util.Util;
import io.bidmachine.media3.extractor.IndexSeekMap;
import io.bidmachine.media3.extractor.SeekMap;
import java.math.RoundingMode;

/* loaded from: classes7.dex */
final class IndexSeeker implements Seeker {
    static final long MIN_TIME_BETWEEN_POINTS_US = 100000;
    private final int averageBitrate;
    private final long dataEndPosition;
    private final IndexSeekMap indexSeekMap;

    public IndexSeeker(long j, long j2, long j3) {
        this.indexSeekMap = new IndexSeekMap(new long[]{j2}, new long[]{0}, j);
        this.dataEndPosition = j3;
        int i = -2147483647;
        if (j != -9223372036854775807L) {
            long scaleLargeValue = Util.scaleLargeValue(j2 - j3, 8L, j, RoundingMode.HALF_UP);
            if (scaleLargeValue > 0 && scaleLargeValue <= 2147483647L) {
                i = (int) scaleLargeValue;
            }
            this.averageBitrate = i;
            return;
        }
        this.averageBitrate = -2147483647;
    }

    @Override // io.bidmachine.media3.extractor.mp3.Seeker
    public long getTimeUs(long j) {
        return this.indexSeekMap.getTimeUs(j);
    }

    @Override // io.bidmachine.media3.extractor.mp3.Seeker
    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    @Override // io.bidmachine.media3.extractor.SeekMap
    public boolean isSeekable() {
        return this.indexSeekMap.isSeekable();
    }

    @Override // io.bidmachine.media3.extractor.SeekMap
    public long getDurationUs() {
        return this.indexSeekMap.getDurationUs();
    }

    @Override // io.bidmachine.media3.extractor.SeekMap
    public SeekMap.SeekPoints getSeekPoints(long j) {
        return this.indexSeekMap.getSeekPoints(j);
    }

    @Override // io.bidmachine.media3.extractor.mp3.Seeker
    public int getAverageBitrate() {
        return this.averageBitrate;
    }

    public void maybeAddSeekPoint(long j, long j2) {
        if (isTimeUsInIndex(j)) {
            return;
        }
        this.indexSeekMap.addSeekPoint(j, j2);
    }

    public boolean isTimeUsInIndex(long j) {
        return this.indexSeekMap.isTimeUsInIndex(j, 100000L);
    }

    void setDurationUs(long j) {
        this.indexSeekMap.setDurationUs(j);
    }
}
