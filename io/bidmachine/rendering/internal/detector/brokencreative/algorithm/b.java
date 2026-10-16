package io.bidmachine.rendering.internal.detector.brokencreative.algorithm;

import io.bidmachine.rendering.model.BrokenCreativeAlgorithmParams;
import io.bidmachine.rendering.model.BrokenCreativeAlgorithmType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/b;", "", "<init>", "()V", "Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;", "algorithmParams", "Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/a;", "a", "(Lio/bidmachine/rendering/model/BrokenCreativeAlgorithmParams;)Lio/bidmachine/rendering/internal/detector/brokencreative/algorithm/a;", "bidmachine-android-sdk_bi_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f7055a = new b();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BrokenCreativeAlgorithmType.values().length];
            try {
                iArr[BrokenCreativeAlgorithmType.ColorHistogram.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BrokenCreativeAlgorithmType.BrightnessVariance.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BrokenCreativeAlgorithmType.EdgeDetection.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private b() {
    }

    public final io.bidmachine.rendering.internal.detector.brokencreative.algorithm.a a(BrokenCreativeAlgorithmParams algorithmParams) {
        Intrinsics.checkNotNullParameter(algorithmParams, "algorithmParams");
        int i = a.$EnumSwitchMapping$0[algorithmParams.getType().ordinal()];
        if (i == 1) {
            return new d(algorithmParams);
        }
        if (i == 2) {
            return new c(algorithmParams);
        }
        if (i == 3) {
            return new e(algorithmParams);
        }
        throw new NoWhenBranchMatchedException();
    }
}
