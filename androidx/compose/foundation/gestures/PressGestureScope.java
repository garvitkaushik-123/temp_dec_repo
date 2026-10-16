package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: TapGestureDetector.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0003"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "awaitRelease", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryAwaitRelease", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PressGestureScope extends Density {
    Object awaitRelease(Continuation<? super Unit> continuation);

    Object tryAwaitRelease(Continuation<? super Boolean> continuation);

    /* compiled from: TapGestureDetector.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
        public static int m702roundToPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo623roundToPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: roundToPx-0680j_4, reason: not valid java name */
        public static int m703roundToPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo624roundToPx0680j_4(f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m704toDpGaN1DYA(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo625toDpGaN1DYA(j);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m705toDpu2uoSUM(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo626toDpu2uoSUM(f);
        }

        @Deprecated
        /* renamed from: toDp-u2uoSUM, reason: not valid java name */
        public static float m706toDpu2uoSUM(PressGestureScope pressGestureScope, int i) {
            return PressGestureScope.super.mo627toDpu2uoSUM(i);
        }

        @Deprecated
        /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
        public static long m707toDpSizekrfVVM(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo628toDpSizekrfVVM(j);
        }

        @Deprecated
        /* renamed from: toPx--R2X_6o, reason: not valid java name */
        public static float m708toPxR2X_6o(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo629toPxR2X_6o(j);
        }

        @Deprecated
        /* renamed from: toPx-0680j_4, reason: not valid java name */
        public static float m709toPx0680j_4(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo630toPx0680j_4(f);
        }

        @Deprecated
        public static Rect toRect(PressGestureScope pressGestureScope, DpRect dpRect) {
            return PressGestureScope.super.toRect(dpRect);
        }

        @Deprecated
        /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
        public static long m710toSizeXkaWNTQ(PressGestureScope pressGestureScope, long j) {
            return PressGestureScope.super.mo631toSizeXkaWNTQ(j);
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m711toSp0xMU5do(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo632toSp0xMU5do(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m712toSpkPz2Gy4(PressGestureScope pressGestureScope, float f) {
            return PressGestureScope.super.mo633toSpkPz2Gy4(f);
        }

        @Deprecated
        /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
        public static long m713toSpkPz2Gy4(PressGestureScope pressGestureScope, int i) {
            return PressGestureScope.super.mo634toSpkPz2Gy4(i);
        }
    }
}
