package androidx.compose.ui.unit;

import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* compiled from: Constraints.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\b\u001a5\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0007\u001a\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0003H\u0002\u001a\u001c\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\f\u001a\u00020\u0001ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u001e\u0010\u000b\u001a\u00020\u000f*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000e\u001a\u001e\u0010\u0012\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001e\u0010\u0016\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0015\u001a\u001e\u0010\u0019\u001a\u00020\u001a*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u000fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a*\u0010\u001d\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b \u0010!\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {androidx.constraintlayout.widget.Constraints.TAG, "Landroidx/compose/ui/unit/Constraints;", "minWidth", "", "maxWidth", "minHeight", "maxHeight", "(IIII)J", "addMaxWithMinimum", "max", "value", "constrain", "otherConstraints", "constrain-N9IONVI", "(JJ)J", "Landroidx/compose/ui/unit/IntSize;", ContentDisposition.Parameters.Size, "constrain-4WqzIAM", "constrainHeight", "height", "constrainHeight-K40F9xA", "(JI)I", "constrainWidth", "width", "constrainWidth-K40F9xA", "isSatisfiedBy", "", "isSatisfiedBy-4WqzIAM", "(JJ)Z", "offset", "horizontal", "vertical", "offset-NN6Ew-U", "(JII)J", "ui-unit_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConstraintsKt {
    public static /* synthetic */ long Constraints$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = 0;
        }
        if ((i5 & 2) != 0) {
            i2 = Integer.MAX_VALUE;
        }
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return Constraints(i, i2, i3, i4);
    }

    public static final long Constraints(int i, int i2, int i3, int i4) {
        if (i2 < i) {
            throw new IllegalArgumentException(("maxWidth(" + i2 + ") must be >= than minWidth(" + i + ')').toString());
        }
        if (i4 < i3) {
            throw new IllegalArgumentException(("maxHeight(" + i4 + ") must be >= than minHeight(" + i3 + ')').toString());
        }
        if (i < 0 || i3 < 0) {
            throw new IllegalArgumentException(("minWidth(" + i + ") and minHeight(" + i3 + ") must be >= 0").toString());
        }
        return Constraints.INSTANCE.m6352createConstraintsZbe2FdA$ui_unit_release(i, i2, i3, i4);
    }

    /* renamed from: constrain-N9IONVI, reason: not valid java name */
    public static final long m6357constrainN9IONVI(long j, long j2) {
        return Constraints(RangesKt.coerceIn(Constraints.m6347getMinWidthimpl(j2), Constraints.m6347getMinWidthimpl(j), Constraints.m6345getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m6345getMaxWidthimpl(j2), Constraints.m6347getMinWidthimpl(j), Constraints.m6345getMaxWidthimpl(j)), RangesKt.coerceIn(Constraints.m6346getMinHeightimpl(j2), Constraints.m6346getMinHeightimpl(j), Constraints.m6344getMaxHeightimpl(j)), RangesKt.coerceIn(Constraints.m6344getMaxHeightimpl(j2), Constraints.m6346getMinHeightimpl(j), Constraints.m6344getMaxHeightimpl(j)));
    }

    /* renamed from: constrain-4WqzIAM, reason: not valid java name */
    public static final long m6356constrain4WqzIAM(long j, long j2) {
        return IntSizeKt.IntSize(RangesKt.coerceIn(IntSize.m6559getWidthimpl(j2), Constraints.m6347getMinWidthimpl(j), Constraints.m6345getMaxWidthimpl(j)), RangesKt.coerceIn(IntSize.m6558getHeightimpl(j2), Constraints.m6346getMinHeightimpl(j), Constraints.m6344getMaxHeightimpl(j)));
    }

    /* renamed from: constrainWidth-K40F9xA, reason: not valid java name */
    public static final int m6359constrainWidthK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m6347getMinWidthimpl(j), Constraints.m6345getMaxWidthimpl(j));
    }

    /* renamed from: constrainHeight-K40F9xA, reason: not valid java name */
    public static final int m6358constrainHeightK40F9xA(long j, int i) {
        return RangesKt.coerceIn(i, Constraints.m6346getMinHeightimpl(j), Constraints.m6344getMaxHeightimpl(j));
    }

    /* renamed from: isSatisfiedBy-4WqzIAM, reason: not valid java name */
    public static final boolean m6360isSatisfiedBy4WqzIAM(long j, long j2) {
        int m6347getMinWidthimpl = Constraints.m6347getMinWidthimpl(j);
        int m6345getMaxWidthimpl = Constraints.m6345getMaxWidthimpl(j);
        int m6559getWidthimpl = IntSize.m6559getWidthimpl(j2);
        if (m6347getMinWidthimpl > m6559getWidthimpl || m6559getWidthimpl > m6345getMaxWidthimpl) {
            return false;
        }
        int m6346getMinHeightimpl = Constraints.m6346getMinHeightimpl(j);
        int m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j);
        int m6558getHeightimpl = IntSize.m6558getHeightimpl(j2);
        return m6346getMinHeightimpl <= m6558getHeightimpl && m6558getHeightimpl <= m6344getMaxHeightimpl;
    }

    /* renamed from: offset-NN6Ew-U$default, reason: not valid java name */
    public static /* synthetic */ long m6362offsetNN6EwU$default(long j, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m6361offsetNN6EwU(j, i, i2);
    }

    /* renamed from: offset-NN6Ew-U, reason: not valid java name */
    public static final long m6361offsetNN6EwU(long j, int i, int i2) {
        return Constraints(RangesKt.coerceAtLeast(Constraints.m6347getMinWidthimpl(j) + i, 0), addMaxWithMinimum(Constraints.m6345getMaxWidthimpl(j), i), RangesKt.coerceAtLeast(Constraints.m6346getMinHeightimpl(j) + i2, 0), addMaxWithMinimum(Constraints.m6344getMaxHeightimpl(j), i2));
    }

    private static final int addMaxWithMinimum(int i, int i2) {
        return i == Integer.MAX_VALUE ? i : RangesKt.coerceAtLeast(i + i2, 0);
    }
}
