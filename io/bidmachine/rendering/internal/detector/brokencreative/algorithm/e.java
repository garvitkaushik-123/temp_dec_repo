package io.bidmachine.rendering.internal.detector.brokencreative.algorithm;

import android.graphics.Bitmap;
import io.bidmachine.rendering.model.BrokenCreativeAlgorithmParams;
import io.bidmachine.util.Utils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\n\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002¢\u0006\u0004\b\n\u0010\u000fJ\u0019\u0010\n\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u0011¨\u0006\u0012"}, d2 = {"Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/e;", "Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/a;", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;", "algorithmParams", "<init>", "(Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;)V", "Landroid/graphics/Bitmap;", "image", "", "threshold", "a", "(Landroid/graphics/Bitmap;F)Ljava/lang/Float;", "", "sourceColor", "targetColor", "(II)F", "", "(Landroid/graphics/Bitmap;)Ljava/lang/Boolean;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class e extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(BrokenCreativeAlgorithmParams algorithmParams) {
        super(algorithmParams);
        Intrinsics.checkNotNullParameter(algorithmParams, "algorithmParams");
    }

    @Override // io.bidmachine.rendering.internal.detector.brokencreative.algorithm.a
    public Boolean a(Bitmap image) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(image, "image");
        Float a2 = a(image, getAlgorithmParams().getThreshold());
        if (a2 != null) {
            bool = Boolean.valueOf(a2.floatValue() <= getAlgorithmParams().getThreshold());
        } else {
            bool = null;
        }
        a(a2, bool);
        return bool;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00bc A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Float a(Bitmap image, float threshold) {
        IntRange intRange;
        float f;
        int i;
        float a2;
        int i2 = 1;
        IntRange until = RangesKt.until(1, image.getWidth() - 1);
        IntRange until2 = RangesKt.until(1, image.getHeight() - 1);
        int count = CollectionsKt.count(until) * CollectionsKt.count(until2);
        Float f2 = null;
        if (count <= 0) {
            return null;
        }
        int[] iArr = new int[image.getWidth()];
        float[] fArr = new float[image.getWidth()];
        float f3 = count;
        float f4 = threshold * f3;
        int first = until2.getFirst();
        int last = until2.getLast();
        int i3 = 0;
        if (first <= last) {
            int i4 = 0;
            int i5 = first;
            while (true) {
                int[] iArr2 = iArr;
                image.getPixels(iArr2, 0, image.getWidth(), 0, i5, image.getWidth(), 1);
                int first2 = until.getFirst();
                int last2 = until.getLast();
                if (first2 <= last2) {
                    Float f5 = f2;
                    while (true) {
                        int b = b(iArr2[first2]);
                        int a3 = a(image, first2, i5 - 1);
                        int a4 = a(image, first2, i5 + 1);
                        if (i5 == i2) {
                            f = a(b, a3);
                        } else {
                            f = fArr[first2];
                        }
                        fArr[first2] = a(b, a4);
                        intRange = until;
                        if (f + r11 <= 0.2d) {
                            int a5 = a(image, first2 - 1, i5);
                            int a6 = a(image, first2 + 1, i5);
                            if (f5 != null) {
                                a2 = f5.floatValue();
                            } else {
                                a2 = a(b, a5);
                            }
                            Float valueOf = Float.valueOf(a(b, a6));
                            if (a2 + r7 <= 0.2d) {
                                f5 = valueOf;
                                i = i4;
                                if (i > f4) {
                                    if (first2 == last2) {
                                        i4 = i;
                                        break;
                                    }
                                    first2++;
                                    i4 = i;
                                    until = intRange;
                                    i2 = 1;
                                } else {
                                    return Float.valueOf(1.0f);
                                }
                            } else {
                                f5 = valueOf;
                            }
                        }
                        i4++;
                        i = i4;
                        if (i > f4) {
                        }
                    }
                } else {
                    intRange = until;
                }
                if (i5 == last) {
                    i3 = i4;
                    break;
                }
                i5++;
                iArr = iArr2;
                until = intRange;
                i2 = 1;
                f2 = null;
            }
        }
        return Float.valueOf(i3 / f3);
    }

    private final float a(int sourceColor, int targetColor) {
        float redToRatio = Utils.redToRatio(sourceColor) - Utils.redToRatio(targetColor);
        float greenToRatio = Utils.greenToRatio(sourceColor) - Utils.greenToRatio(targetColor);
        float blueToRatio = Utils.blueToRatio(sourceColor) - Utils.blueToRatio(targetColor);
        return (float) Math.sqrt((redToRatio * redToRatio) + (greenToRatio * greenToRatio) + (blueToRatio * blueToRatio));
    }
}
