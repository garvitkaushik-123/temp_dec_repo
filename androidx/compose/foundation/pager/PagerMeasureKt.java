package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayout;
import androidx.compose.foundation.gestures.snapping.SnapPositionInLayoutKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: PagerMeasure.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a@\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\u001aH\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0002\u001a@\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0016H\u0002\u001a\u0017\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0082\b\u001a\u008c\u0001\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u001f*\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010&\u001a\u00020\b2\u0006\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\b2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\bH\u0002\u001aj\u0010\u0015\u001a\u00020\u0006*\u00020 2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010)\u001a\u00020*2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010+\u001a\u00020\u00012\u0006\u0010/\u001a\u00020\bH\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001aé\u0001\u0010?\u001a\u00020@*\u00020 2\u0006\u0010A\u001a\u00020\b2\u0006\u00103\u001a\u0002042\u0006\u0010B\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u0002022\u0006\u0010)\u001a\u00020*2\b\u00109\u001a\u0004\u0018\u00010:2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010+\u001a\u00020\u00012\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\b0\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020G2/\u0010H\u001a+\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020J\u0012\u0004\u0012\u00020\u001a0\u0016¢\u0006\u0002\bK\u0012\u0004\u0012\u00020L0IH\u0000ø\u0001\u0000¢\u0006\u0004\bM\u0010N\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006O"}, d2 = {"DEBUG", "", "MaxPageOffset", "", "MinPageOffset", "calculateNewCurrentPage", "Landroidx/compose/foundation/pager/MeasuredPage;", "viewportSize", "", "visiblePagesInfo", "", "beforeContentPadding", "afterContentPadding", "itemSize", "snapPositionInLayout", "Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;", "createPagesAfterList", "currentLastPage", "pagesCount", "beyondBoundsPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", FirebaseAnalytics.Param.INDEX, "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "pageCount", "mainAxisAvailableSize", "currentPage", "currentPageOffset", "constraints", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-_JDW0YA", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPositionInLayout;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerMeasureKt {
    private static final boolean DEBUG = false;
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* renamed from: measurePager-_JDW0YA, reason: not valid java name */
    public static final PagerMeasureResult m1112measurePager_JDW0YA(final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, final PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, long j, final Orientation orientation, final Alignment.Vertical vertical, final Alignment.Horizontal horizontal, final boolean z, final long j2, final int i8, int i9, List<Integer> list, SnapPositionInLayout snapPositionInLayout, final MutableState<Unit> mutableState, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        ArrayList arrayList;
        List<MeasuredPage> list2;
        int i16;
        int i17;
        if (i3 < 0) {
            throw new IllegalArgumentException("negative beforeContentPadding".toString());
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("negative afterContentPadding".toString());
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(i8 + i5, 0);
        if (i <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), i8, i5, i4, orientation, -i3, i2 + i4, false, i9, null, null, 0.0f, 0, false, function3.invoke(Integer.valueOf(Constraints.m6347getMinWidthimpl(j)), Integer.valueOf(Constraints.m6346getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), false);
        }
        Orientation orientation2 = orientation;
        final long Constraints$default = ConstraintsKt.Constraints$default(0, orientation2 == Orientation.Vertical ? Constraints.m6345getMaxWidthimpl(j) : i8, 0, orientation2 != Orientation.Vertical ? Constraints.m6344getMaxHeightimpl(j) : i8, 5, null);
        int i18 = i6;
        int i19 = i7;
        while (i18 > 0 && i19 > 0) {
            i18--;
            i19 -= coerceAtLeast;
        }
        int i20 = i19 * (-1);
        if (i18 >= i) {
            i18 = i - 1;
            i20 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i21 = -i3;
        int i22 = (i5 < 0 ? i5 : 0) + i21;
        int i23 = i20 + i22;
        int i24 = 0;
        while (i23 < 0 && i18 > 0) {
            int i25 = i18 - 1;
            MeasuredPage m1111getAndMeasureSGf7dI0 = m1111getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i25, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation2, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
            arrayDeque.add(0, m1111getAndMeasureSGf7dI0);
            i24 = Math.max(i24, m1111getAndMeasureSGf7dI0.getCrossAxisSize());
            i23 += coerceAtLeast;
            orientation2 = orientation;
            i18 = i25;
        }
        if (i23 < i22) {
            i23 = i22;
        }
        int i26 = i23 - i22;
        int i27 = i2 + i4;
        int coerceAtLeast2 = RangesKt.coerceAtLeast(i27, 0);
        int i28 = -i26;
        int i29 = i18;
        int i30 = i29;
        int i31 = 0;
        boolean z2 = false;
        while (i31 < arrayDeque.size()) {
            if (i28 >= coerceAtLeast2) {
                arrayDeque.remove(i31);
                z2 = true;
            } else {
                i30++;
                i28 += coerceAtLeast;
                i31++;
            }
        }
        int i32 = i30;
        int i33 = i24;
        boolean z3 = z2;
        while (i32 < i && (i28 < coerceAtLeast2 || i28 <= 0 || arrayDeque.isEmpty())) {
            int i34 = i32;
            MeasuredPage m1111getAndMeasureSGf7dI02 = m1111getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i34, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
            int i35 = coerceAtLeast2;
            int i36 = i26;
            int i37 = i - 1;
            i28 += i34 == i37 ? i8 : coerceAtLeast;
            if (i28 > i22 || i34 == i37) {
                i33 = Math.max(i33, m1111getAndMeasureSGf7dI02.getCrossAxisSize());
                arrayDeque.add(m1111getAndMeasureSGf7dI02);
                i17 = i29;
                i26 = i36;
            } else {
                i17 = i34 + 1;
                i26 = i36 - coerceAtLeast;
                z3 = true;
            }
            i29 = i17;
            i32 = i34 + 1;
            coerceAtLeast2 = i35;
        }
        int i38 = i32;
        int i39 = i26;
        if (i28 < i2) {
            int i40 = i2 - i28;
            i13 = i39 - i40;
            int i41 = i28 + i40;
            int i42 = i33;
            int i43 = i29;
            while (i13 < i3 && i43 > 0) {
                int i44 = i43 - 1;
                MeasuredPage m1111getAndMeasureSGf7dI03 = m1111getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i44, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
                arrayDeque.add(0, m1111getAndMeasureSGf7dI03);
                i42 = Math.max(i42, m1111getAndMeasureSGf7dI03.getCrossAxisSize());
                i13 += coerceAtLeast;
                i43 = i44;
            }
            if (i13 < 0) {
                int i45 = i41 + i13;
                i11 = i42;
                i12 = i43;
                i10 = i45;
                i13 = 0;
            } else {
                i11 = i42;
                i12 = i43;
                i10 = i41;
            }
        } else {
            int i46 = i33;
            i10 = i28;
            i11 = i46;
            i12 = i29;
            i13 = i39;
        }
        if (i13 < 0) {
            throw new IllegalArgumentException("invalid currentFirstPageScrollOffset".toString());
        }
        int i47 = -i13;
        MeasuredPage measuredPage = (MeasuredPage) arrayDeque.first();
        if (i3 > 0 || i5 < 0) {
            i14 = i38;
            int size = arrayDeque.size();
            i15 = i11;
            int i48 = 0;
            while (i48 < size && i13 != 0 && coerceAtLeast <= i13) {
                int i49 = size;
                if (i48 == CollectionsKt.getLastIndex(arrayDeque)) {
                    break;
                }
                i13 -= coerceAtLeast;
                i48++;
                measuredPage = (MeasuredPage) arrayDeque.get(i48);
                size = i49;
            }
        } else {
            i14 = i38;
            i15 = i11;
        }
        int i50 = i13;
        MeasuredPage measuredPage2 = measuredPage;
        List<MeasuredPage> createPagesBeforeList = createPagesBeforeList(i12, i9, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i51) {
                MeasuredPage m1111getAndMeasureSGf7dI04;
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = LazyLayoutMeasureScope.this;
                m1111getAndMeasureSGf7dI04 = PagerMeasureKt.m1111getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i51, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z, i8);
                return m1111getAndMeasureSGf7dI04;
            }
        });
        int size2 = createPagesBeforeList.size();
        int i51 = i15;
        int i52 = 0;
        while (i52 < size2) {
            i51 = Math.max(i51, createPagesBeforeList.get(i52).getCrossAxisSize());
            i52++;
            createPagesBeforeList = createPagesBeforeList;
        }
        List<MeasuredPage> list3 = createPagesBeforeList;
        List<MeasuredPage> createPagesAfterList = createPagesAfterList(((MeasuredPage) arrayDeque.last()).getIndex(), i, i9, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i53) {
                MeasuredPage m1111getAndMeasureSGf7dI04;
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = LazyLayoutMeasureScope.this;
                m1111getAndMeasureSGf7dI04 = PagerMeasureKt.m1111getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i53, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z, i8);
                return m1111getAndMeasureSGf7dI04;
            }
        });
        int size3 = createPagesAfterList.size();
        int i53 = 0;
        while (i53 < size3) {
            i51 = Math.max(i51, createPagesAfterList.get(i53).getCrossAxisSize());
            i53++;
            createPagesAfterList = createPagesAfterList;
        }
        List<MeasuredPage> list4 = createPagesAfterList;
        boolean z4 = Intrinsics.areEqual(measuredPage2, arrayDeque.first()) && list3.isEmpty() && list4.isEmpty();
        int m6359constrainWidthK40F9xA = ConstraintsKt.m6359constrainWidthK40F9xA(j, orientation == Orientation.Vertical ? i51 : i10);
        if (orientation == Orientation.Vertical) {
            i51 = i10;
        }
        int m6358constrainHeightK40F9xA = ConstraintsKt.m6358constrainHeightK40F9xA(j, i51);
        int i54 = i14;
        final List<MeasuredPage> calculatePagesOffsets = calculatePagesOffsets(lazyLayoutMeasureScope, arrayDeque, list3, list4, m6359constrainWidthK40F9xA, m6358constrainHeightK40F9xA, i10, i2, i47, orientation, z, lazyLayoutMeasureScope, i5, i8);
        int i55 = i10;
        if (z4) {
            arrayList = calculatePagesOffsets;
        } else {
            ArrayList arrayList2 = new ArrayList(calculatePagesOffsets.size());
            int size4 = calculatePagesOffsets.size();
            for (int i56 = 0; i56 < size4; i56++) {
                MeasuredPage measuredPage3 = calculatePagesOffsets.get(i56);
                MeasuredPage measuredPage4 = measuredPage3;
                if (measuredPage4.getIndex() >= ((MeasuredPage) arrayDeque.first()).getIndex() && measuredPage4.getIndex() <= ((MeasuredPage) arrayDeque.last()).getIndex()) {
                    arrayList2.add(measuredPage3);
                }
            }
            arrayList = arrayList2;
        }
        if (orientation == Orientation.Vertical) {
            list2 = arrayList;
            i16 = m6358constrainHeightK40F9xA;
        } else {
            list2 = arrayList;
            i16 = m6359constrainWidthK40F9xA;
        }
        MeasuredPage calculateNewCurrentPage = calculateNewCurrentPage(i16, list2, i3, i4, coerceAtLeast, snapPositionInLayout);
        return new PagerMeasureResult(list2, i8, i5, i4, orientation, i21, i27, z, i9, measuredPage2, calculateNewCurrentPage, coerceAtLeast == 0 ? 0.0f : RangesKt.coerceIn((-(calculateNewCurrentPage != null ? calculateNewCurrentPage.getOffset() : 0)) / coerceAtLeast, -0.5f, 0.5f), i50, i54 < i || i55 > i2, function3.invoke(Integer.valueOf(m6359constrainWidthK40F9xA), Integer.valueOf(m6358constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                List<MeasuredPage> list5 = calculatePagesOffsets;
                int size5 = list5.size();
                for (int i57 = 0; i57 < size5; i57++) {
                    list5.get(i57).place(placementScope);
                }
                ObservableScopeInvalidator.m1047attachToScopeimpl(mutableState);
            }
        }), z3);
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i2, int i3, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int min = Math.min(i3 + i, i2 - 1);
        int i4 = i + 1;
        ArrayList arrayList = null;
        if (i4 <= min) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i4)));
                if (i4 == min) {
                    break;
                }
                i4++;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int intValue = list.get(i5).intValue();
            if (min + 1 <= intValue && intValue < i2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i, int i2, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (max <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i3)));
                if (i3 == max) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int intValue = list.get(i4).intValue();
            if (intValue < max) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m1111getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int i2) {
        return new MeasuredPage(i, i2, lazyLayoutMeasureScope.mo1043measure0kLqBqw(i, j), j2, pagerLazyLayoutItemProvider.getKey(i), orientation, horizontal, vertical, layoutDirection, z, null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i, int i2, int i3, int i4, int i5, Orientation orientation, boolean z, Density density, int i6, int i7) {
        int i8 = i5;
        int i9 = i7 + i6;
        int i10 = orientation == Orientation.Vertical ? i2 : i;
        boolean z2 = i3 < Math.min(i10, i4);
        if (z2 && i8 != 0) {
            throw new IllegalStateException(("non-zero pagesScrollOffset=" + i8).toString());
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z2) {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("No extra pages".toString());
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i11 = 0; i11 < size; i11++) {
                iArr[i11] = i7;
            }
            int[] iArr2 = new int[size];
            for (int i12 = 0; i12 < size; i12++) {
                iArr2[i12] = 0;
            }
            Arrangement.HorizontalOrVertical m791spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m791spacedBy0680j_4(lazyLayoutMeasureScope.mo627toDpu2uoSUM(i6));
            if (orientation == Orientation.Vertical) {
                m791spacedBy0680j_4.arrange(density, i10, iArr, iArr2);
            } else {
                m791spacedBy0680j_4.arrange(density, i10, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i13 = iArr2[first];
                    MeasuredPage measuredPage = list.get(calculatePagesOffsets$reverseAware(first, z, size));
                    if (z) {
                        i13 = (i10 - i13) - measuredPage.getSize();
                    }
                    measuredPage.position(i13, i, i2);
                    arrayList.add(measuredPage);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size2 = list2.size();
            int i14 = i8;
            for (int i15 = 0; i15 < size2; i15++) {
                MeasuredPage measuredPage2 = list2.get(i15);
                i14 -= i9;
                measuredPage2.position(i14, i, i2);
                arrayList.add(measuredPage2);
            }
            int size3 = list.size();
            for (int i16 = 0; i16 < size3; i16++) {
                MeasuredPage measuredPage3 = list.get(i16);
                measuredPage3.position(i8, i, i2);
                arrayList.add(measuredPage3);
                i8 += i9;
            }
            int size4 = list3.size();
            for (int i17 = 0; i17 < size4; i17++) {
                MeasuredPage measuredPage4 = list3.get(i17);
                measuredPage4.position(i8, i, i2);
                arrayList.add(measuredPage4);
                i8 += i9;
            }
        }
        return arrayList;
    }

    private static final MeasuredPage calculateNewCurrentPage(int i, List<MeasuredPage> list, int i2, int i3, int i4, SnapPositionInLayout snapPositionInLayout) {
        MeasuredPage measuredPage;
        if (list.isEmpty()) {
            measuredPage = null;
        } else {
            MeasuredPage measuredPage2 = list.get(0);
            MeasuredPage measuredPage3 = measuredPage2;
            float f = -Math.abs(SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage3.getOffset(), measuredPage3.getIndex(), snapPositionInLayout));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i5 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    MeasuredPage measuredPage4 = list.get(i5);
                    MeasuredPage measuredPage5 = measuredPage4;
                    float f2 = -Math.abs(SnapPositionInLayoutKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage5.getOffset(), measuredPage5.getIndex(), snapPositionInLayout));
                    if (Float.compare(f, f2) < 0) {
                        measuredPage2 = measuredPage4;
                        f = f2;
                    }
                    if (i5 == lastIndex) {
                        break;
                    }
                    i5++;
                }
            }
            measuredPage = measuredPage2;
        }
        return measuredPage;
    }
}
