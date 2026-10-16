package androidx.compose.material3.carousel;

import androidx.annotation.FloatRange;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

/* compiled from: Arrangement.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0002R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u0015"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement;", "", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "", "smallSize", "", "smallCount", "mediumSize", "mediumCount", "largeSize", "largeCount", "(IFIFIFI)V", "getLargeSize", "()F", "getMediumSize", "getSmallSize", "cost", "targetLargeSize", "isValid", "", "Companion", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Arrangement {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float MediumItemFlexPercentage = 0.1f;
    private final int largeCount;
    private final float largeSize;
    private final int mediumCount;
    private final float mediumSize;
    private final int priority;
    private final int smallCount;
    private final float smallSize;

    public Arrangement(int i, float f, int i2, float f2, int i3, float f3, int i4) {
        this.priority = i;
        this.smallSize = f;
        this.smallCount = i2;
        this.mediumSize = f2;
        this.mediumCount = i3;
        this.largeSize = f3;
        this.largeCount = i4;
    }

    public final float getSmallSize() {
        return this.smallSize;
    }

    public final float getMediumSize() {
        return this.mediumSize;
    }

    public final float getLargeSize() {
        return this.largeSize;
    }

    private final boolean isValid() {
        int i = this.largeCount;
        if (i <= 0 || this.smallCount <= 0 || this.mediumCount <= 0) {
            return i <= 0 || this.smallCount <= 0 || this.largeSize > this.smallSize;
        }
        float f = this.largeSize;
        float f2 = this.mediumSize;
        return f > f2 && f2 > this.smallSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float cost(float targetLargeSize) {
        if (isValid()) {
            return Math.abs(targetLargeSize - this.largeSize) * this.priority;
        }
        return Float.MAX_VALUE;
    }

    /* compiled from: Arrangement.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002JH\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0012JP\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Landroidx/compose/material3/carousel/Arrangement$Companion;", "", "()V", "MediumItemFlexPercentage", "", "calculateLargeSize", "availableSpace", "smallCount", "", "smallSize", "mediumCount", "largeCount", "findLowestCostArrangement", "Landroidx/compose/material3/carousel/Arrangement;", "targetSmallSize", "smallSizeRange", "Landroidx/annotation/FloatRange;", "smallCounts", "", "targetMediumSize", "mediumCounts", "targetLargeSize", "largeCounts", "fit", HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, "mediumSize", "largeSize", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float calculateLargeSize(float availableSpace, int smallCount, float smallSize, int mediumCount, int largeCount) {
            float f = mediumCount / 2.0f;
            return (availableSpace - ((smallCount + f) * smallSize)) / (largeCount + f);
        }

        private Companion() {
        }

        public final Arrangement findLowestCostArrangement(float availableSpace, float targetSmallSize, FloatRange smallSizeRange, int[] smallCounts, float targetMediumSize, int[] mediumCounts, float targetLargeSize, int[] largeCounts) {
            Arrangement arrangement = null;
            int i = 1;
            for (int i2 : largeCounts) {
                int length = mediumCounts.length;
                int i3 = 0;
                while (i3 < length) {
                    int i4 = mediumCounts[i3];
                    int length2 = smallCounts.length;
                    int i5 = 0;
                    while (i5 < length2) {
                        int i6 = i3;
                        Arrangement arrangement2 = arrangement;
                        int i7 = length;
                        int i8 = length2;
                        int i9 = i5;
                        Arrangement fit = fit(i, availableSpace, smallCounts[i5], targetSmallSize, smallSizeRange, i4, targetMediumSize, i2, targetLargeSize);
                        if (arrangement2 != null && fit.cost(targetLargeSize) >= arrangement2.cost(targetLargeSize)) {
                            arrangement = arrangement2;
                        } else {
                            if (fit.cost(targetLargeSize) == 0.0f) {
                                return fit;
                            }
                            arrangement = fit;
                        }
                        i++;
                        i5 = i9 + 1;
                        length = i7;
                        i3 = i6;
                        length2 = i8;
                    }
                    i3++;
                }
            }
            return arrangement;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0077  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x007d  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0047  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final Arrangement fit(int priority, float availableSpace, int smallCount, float smallSize, FloatRange smallSizeRange, int mediumCount, float mediumSize, int largeCount, float largeSize) {
            float max;
            float f;
            Companion companion;
            float f2;
            int i;
            int i2;
            float calculateLargeSize;
            float f3;
            float f4;
            float coerceIn = RangesKt.coerceIn(smallSize, (float) smallSizeRange.from(), (float) smallSizeRange.to());
            float f5 = largeCount;
            float f6 = mediumCount;
            float f7 = smallCount;
            float f8 = availableSpace - (((largeSize * f5) + (mediumSize * f6)) + (coerceIn * f7));
            if (smallCount > 0 && f8 > 0.0f) {
                max = Math.min(f8 / f7, ((float) smallSizeRange.to()) - coerceIn);
            } else {
                if (smallCount > 0 && f8 < 0.0f) {
                    max = Math.max(f8 / f7, ((float) smallSizeRange.from()) - coerceIn);
                }
                if (smallCount <= 0) {
                    f = coerceIn;
                    f2 = availableSpace;
                    i = smallCount;
                    i2 = largeCount;
                    companion = this;
                } else {
                    f = 0.0f;
                    companion = this;
                    f2 = availableSpace;
                    i = smallCount;
                    i2 = largeCount;
                }
                calculateLargeSize = companion.calculateLargeSize(f2, i, f, mediumCount, i2);
                float f9 = f;
                f3 = (calculateLargeSize + f9) / 2.0f;
                if (mediumCount > 0 && calculateLargeSize != largeSize) {
                    f4 = (largeSize - calculateLargeSize) * f5;
                    float min = Math.min(Math.abs(f4), 0.1f * f3 * f6);
                    if (f4 <= 0.0f) {
                        f3 -= min / f6;
                        calculateLargeSize += min / f5;
                    } else {
                        f3 += min / f6;
                        calculateLargeSize -= min / f5;
                    }
                }
                return new Arrangement(priority, f9, smallCount, f3, mediumCount, calculateLargeSize, largeCount);
            }
            coerceIn += max;
            if (smallCount <= 0) {
            }
            calculateLargeSize = companion.calculateLargeSize(f2, i, f, mediumCount, i2);
            float f92 = f;
            f3 = (calculateLargeSize + f92) / 2.0f;
            if (mediumCount > 0) {
                f4 = (largeSize - calculateLargeSize) * f5;
                float min2 = Math.min(Math.abs(f4), 0.1f * f3 * f6);
                if (f4 <= 0.0f) {
                }
            }
            return new Arrangement(priority, f92, smallCount, f3, mediumCount, calculateLargeSize, largeCount);
        }
    }
}
