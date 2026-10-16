package io.bidmachine.rendering.internal.detector.brokencreative.algorithm;

import android.graphics.Bitmap;
import io.bidmachine.rendering.model.BrokenCreativeAlgorithmParams;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\u000f¨\u0006\u0010"}, d2 = {"Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/d;", "Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/a;", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;", "algorithmParams", "<init>", "(Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;)V", "Landroid/graphics/Bitmap;", "image", "", "c", "(Landroid/graphics/Bitmap;)F", "threshold", "a", "(Landroid/graphics/Bitmap;F)F", "", "(Landroid/graphics/Bitmap;)Ljava/lang/Boolean;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class d extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(BrokenCreativeAlgorithmParams algorithmParams) {
        super(algorithmParams);
        Intrinsics.checkNotNullParameter(algorithmParams, "algorithmParams");
    }

    private final float c(Bitmap image) {
        IntRange until = RangesKt.until(0, image.getWidth());
        IntRange until2 = RangesKt.until(0, image.getHeight());
        int count = CollectionsKt.count(until) * CollectionsKt.count(until2);
        int[] iArr = new int[image.getWidth()];
        HashMap hashMap = new HashMap();
        int first = until2.getFirst();
        int last = until2.getLast();
        if (first <= last) {
            int i = first;
            while (true) {
                Bitmap bitmap = image;
                bitmap.getPixels(iArr, 0, image.getWidth(), 0, i, image.getWidth(), 1);
                int first2 = until.getFirst();
                int last2 = until.getLast();
                if (first2 <= last2) {
                    while (true) {
                        int i2 = iArr[first2];
                        Integer valueOf = Integer.valueOf(i2);
                        Integer num = (Integer) hashMap.get(Integer.valueOf(i2));
                        hashMap.put(valueOf, Integer.valueOf((num != null ? num.intValue() : 0) + 1));
                        if (first2 == last2) {
                            break;
                        }
                        first2++;
                    }
                }
                if (i == last) {
                    break;
                }
                i++;
                image = bitmap;
            }
        }
        return (((Integer) CollectionsKt.maxOrNull((Iterable) hashMap.values())) != null ? r14.intValue() : 0) / count;
    }

    @Override // io.bidmachine.rendering.internal.detector.brokencreative.algorithm.a
    public Boolean a(Bitmap image) {
        Intrinsics.checkNotNullParameter(image, "image");
        float threshold = getAlgorithmParams().getThreshold();
        float a2 = threshold > 0.5f ? a(image, threshold) : c(image);
        boolean z = a2 >= threshold;
        a(Float.valueOf(a2), Boolean.valueOf(z));
        return Boolean.valueOf(z);
    }

    private final float a(Bitmap image, float threshold) {
        int i;
        int i2;
        int i3 = 0;
        IntRange until = RangesKt.until(0, image.getWidth());
        IntRange until2 = RangesKt.until(0, image.getHeight());
        int count = CollectionsKt.count(until) * CollectionsKt.count(until2);
        int[] iArr = new int[image.getWidth()];
        int first = until2.getFirst();
        int last = until2.getLast();
        if (first <= last) {
            i2 = 0;
            int i4 = first;
            i = 0;
            while (true) {
                image.getPixels(iArr, 0, image.getWidth(), 0, i4, image.getWidth(), 1);
                int first2 = until.getFirst();
                int last2 = until.getLast();
                if (first2 <= last2) {
                    while (true) {
                        int i5 = iArr[first2];
                        if (i == 0) {
                            i2 = i5;
                            i = 1;
                        } else {
                            i = i5 == i2 ? i + 1 : i - 1;
                        }
                        if (first2 == last2) {
                            break;
                        }
                        first2++;
                    }
                }
                if (i4 == last) {
                    break;
                }
                i4++;
            }
        } else {
            i = 0;
            i2 = 0;
        }
        float f = count;
        if (i < ((2 * threshold) - 1) * f) {
            return 0.0f;
        }
        int first3 = until2.getFirst();
        int last3 = until2.getLast();
        if (first3 <= last3) {
            int i6 = first3;
            while (true) {
                image.getPixels(iArr, 0, image.getWidth(), 0, i6, image.getWidth(), 1);
                int first4 = until.getFirst();
                int last4 = until.getLast();
                if (first4 <= last4) {
                    while (true) {
                        if (iArr[first4] == i2) {
                            i3++;
                        }
                        if (first4 == last4) {
                            break;
                        }
                        first4++;
                    }
                }
                if (i6 == last3) {
                    break;
                }
                i6++;
            }
        }
        return i3 / f;
    }
}
