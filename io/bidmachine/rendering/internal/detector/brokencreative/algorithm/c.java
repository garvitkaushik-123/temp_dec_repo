package io.bidmachine.rendering.internal.detector.brokencreative.algorithm;

import android.graphics.Bitmap;
import io.bidmachine.rendering.model.BrokenCreativeAlgorithmParams;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/c;", "Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/a;", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;", "algorithmParams", "<init>", "(Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;)V", "Landroid/graphics/Bitmap;", "image", "", "c", "(Landroid/graphics/Bitmap;)F", "", "a", "(Landroid/graphics/Bitmap;)Ljava/lang/Boolean;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class c extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(BrokenCreativeAlgorithmParams algorithmParams) {
        super(algorithmParams);
        Intrinsics.checkNotNullParameter(algorithmParams, "algorithmParams");
    }

    private final float c(Bitmap image) {
        float f;
        float f2;
        IntRange until = RangesKt.until(0, image.getWidth());
        IntRange until2 = RangesKt.until(0, image.getHeight());
        int count = CollectionsKt.count(until) * CollectionsKt.count(until2);
        int[] iArr = new int[image.getWidth()];
        int first = until2.getFirst();
        int last = until2.getLast();
        if (first <= last) {
            int i = first;
            f = 0.0f;
            f2 = 0.0f;
            while (true) {
                Bitmap bitmap = image;
                bitmap.getPixels(iArr, 0, image.getWidth(), 0, i, image.getWidth(), 1);
                int first2 = until.getFirst();
                int last2 = until.getLast();
                if (first2 <= last2) {
                    while (true) {
                        float a2 = a(iArr[first2]);
                        f += a2;
                        f2 += a2 * a2;
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
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        float f3 = count;
        float f4 = f / f3;
        float f5 = (f2 / f3) - (f4 * f4);
        if (f5 < 0.0f) {
            return 0.0f;
        }
        return (float) Math.sqrt(f5);
    }

    @Override // io.bidmachine.rendering.internal.detector.brokencreative.algorithm.a
    public Boolean a(Bitmap image) {
        Intrinsics.checkNotNullParameter(image, "image");
        float c = c(image);
        boolean z = c <= getAlgorithmParams().getThreshold();
        a(Float.valueOf(c), Boolean.valueOf(z));
        return Boolean.valueOf(z);
    }
}
