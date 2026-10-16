package io.bidmachine.media3.common.util;

import io.bidmachine.media3.common.audio.SpeedProvider;

/* loaded from: classes7.dex */
public class SpeedProviderUtil {
    private SpeedProviderUtil() {
    }

    public static long getDurationAfterSpeedProviderApplied(SpeedProvider speedProvider, long j) {
        long j2 = 0;
        double d = 0.0d;
        while (j2 < j) {
            long nextSpeedChangeTimeUs = speedProvider.getNextSpeedChangeTimeUs(j2);
            if (nextSpeedChangeTimeUs == -9223372036854775807L) {
                nextSpeedChangeTimeUs = Long.MAX_VALUE;
            }
            d += (Math.min(nextSpeedChangeTimeUs, j) - j2) / speedProvider.getSpeed(j2);
            j2 = nextSpeedChangeTimeUs;
        }
        return (long) Math.floor(d);
    }

    public static float getSampleAlignedSpeed(SpeedProvider speedProvider, long j, int i) {
        Assertions.checkArgument(j >= 0);
        Assertions.checkArgument(i > 0);
        return speedProvider.getSpeed(Util.sampleCountToDurationUs(j, i));
    }

    public static long getNextSpeedChangeSamplePosition(SpeedProvider speedProvider, long j, int i) {
        Assertions.checkArgument(j >= 0);
        Assertions.checkArgument(i > 0);
        long nextSpeedChangeTimeUs = speedProvider.getNextSpeedChangeTimeUs(Util.sampleCountToDurationUs(j, i));
        if (nextSpeedChangeTimeUs == -9223372036854775807L) {
            return -1L;
        }
        return Util.durationUsToSampleCount(nextSpeedChangeTimeUs, i);
    }
}
