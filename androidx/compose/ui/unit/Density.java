package androidx.compose.ui.unit;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.Metadata;
import kotlin.math.MathKt;

/* compiled from: Density.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0016\u0010\b\u001a\u00020\t*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\b\u001a\u00020\t*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\n*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0010\u001a\u00020\n*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0013J\u0016\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0017ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\nH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0012J\u0016\u0010\u0019\u001a\u00020\u0003*\u00020\rH\u0017ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\f\u0010\u001d\u001a\u00020\u001e*\u00020\u001fH\u0017J\u0016\u0010 \u001a\u00020\u0016*\u00020\u0015H\u0017ø\u0001\u0000¢\u0006\u0004\b!\u0010\u0018J\u0019\u0010\"\u001a\u00020\r*\u00020\u0003H\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u0019\u0010\"\u001a\u00020\r*\u00020\tH\u0017ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010%R\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0002\u0082\u0002\u0011\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0004\b!0\u0001¨\u0006&À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/FontScaling;", "density", "", "getDensity$annotations", "()V", "getDensity", "()F", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "(J)F", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(F)J", "(I)J", "ui-unit_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface Density extends FontScaling {
    float getDensity();

    /* compiled from: Density.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getDensity$annotations() {
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m6377toDpGaN1DYA(Density density, long j) {
            return Density.super.mo625toDpGaN1DYA(j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m6384toSp0xMU5do(Density density, float f) {
            return Density.super.mo632toSp0xMU5do(f);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m6382toPx0680j_4(Density density, float f) {
            return Density.super.mo630toPx0680j_4(f);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m6376roundToPx0680j_4(Density density, float f) {
            return Density.super.mo624roundToPx0680j_4(f);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m6381toPxR2X_6o(Density density, long j) {
            return Density.super.mo629toPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m6375roundToPxR2X_6o(Density density, long j) {
            return Density.super.mo623roundToPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6379toDpu2uoSUM(Density density, int i) {
            return Density.super.mo627toDpu2uoSUM(i);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6386toSpkPz2Gy4(Density density, int i) {
            return Density.super.mo634toSpkPz2Gy4(i);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m6378toDpu2uoSUM(Density density, float f) {
            return Density.super.mo626toDpu2uoSUM(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m6385toSpkPz2Gy4(Density density, float f) {
            return Density.super.mo633toSpkPz2Gy4(f);
        }

        @Deprecated
        public static Rect toRect(Density density, DpRect dpRect) {
            return Density.super.toRect(dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m6383toSizeXkaWNTQ(Density density, long j) {
            return Density.super.mo631toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m6380toDpSizekrfVVM(Density density, long j) {
            return Density.super.mo628toDpSizekrfVVM(j);
        }
    }

    /* renamed from: toPx-0680j_4 */
    default float mo630toPx0680j_4(float f) {
        return f * getDensity();
    }

    /* renamed from: roundToPx-0680j_4 */
    default int mo624roundToPx0680j_4(float f) {
        float mo630toPx0680j_4 = mo630toPx0680j_4(f);
        if (Float.isInfinite(mo630toPx0680j_4)) {
            return Integer.MAX_VALUE;
        }
        return MathKt.roundToInt(mo630toPx0680j_4);
    }

    /* renamed from: toPx--R2X_6o */
    default float mo629toPxR2X_6o(long j) {
        if (!TextUnitType.m6608equalsimpl0(TextUnit.m6579getTypeUIouoOA(j), TextUnitType.INSTANCE.m6613getSpUIouoOA())) {
            throw new IllegalStateException("Only Sp can convert to Px".toString());
        }
        return mo630toPx0680j_4(mo625toDpGaN1DYA(j));
    }

    /* renamed from: roundToPx--R2X_6o */
    default int mo623roundToPxR2X_6o(long j) {
        return MathKt.roundToInt(mo629toPxR2X_6o(j));
    }

    /* renamed from: toDp-u2uoSUM */
    default float mo627toDpu2uoSUM(int i) {
        return Dp.m6389constructorimpl(i / getDensity());
    }

    /* renamed from: toSp-kPz2Gy4 */
    default long mo634toSpkPz2Gy4(int i) {
        return mo632toSp0xMU5do(mo627toDpu2uoSUM(i));
    }

    /* renamed from: toDp-u2uoSUM */
    default float mo626toDpu2uoSUM(float f) {
        return Dp.m6389constructorimpl(f / getDensity());
    }

    /* renamed from: toSp-kPz2Gy4 */
    default long mo633toSpkPz2Gy4(float f) {
        return mo632toSp0xMU5do(mo626toDpu2uoSUM(f));
    }

    default Rect toRect(DpRect dpRect) {
        return new Rect(mo630toPx0680j_4(dpRect.m6472getLeftD9Ej5fM()), mo630toPx0680j_4(dpRect.m6474getTopD9Ej5fM()), mo630toPx0680j_4(dpRect.m6473getRightD9Ej5fM()), mo630toPx0680j_4(dpRect.m6471getBottomD9Ej5fM()));
    }

    /* renamed from: toSize-XkaWNTQ */
    default long mo631toSizeXkaWNTQ(long j) {
        if (j != DpSize.INSTANCE.m6496getUnspecifiedMYxV2XQ()) {
            return SizeKt.Size(mo630toPx0680j_4(DpSize.m6487getWidthD9Ej5fM(j)), mo630toPx0680j_4(DpSize.m6485getHeightD9Ej5fM(j)));
        }
        return Size.INSTANCE.m3899getUnspecifiedNHjbRc();
    }

    /* renamed from: toDpSize-k-rfVVM */
    default long mo628toDpSizekrfVVM(long j) {
        if (j != Size.INSTANCE.m3899getUnspecifiedNHjbRc()) {
            return DpKt.m6411DpSizeYgX7TsA(mo626toDpu2uoSUM(Size.m3891getWidthimpl(j)), mo626toDpu2uoSUM(Size.m3888getHeightimpl(j)));
        }
        return DpSize.INSTANCE.m6496getUnspecifiedMYxV2XQ();
    }
}
