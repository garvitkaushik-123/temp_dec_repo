package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyGridMeasure.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\bH\u0083\b\u001a\u008c\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001aõ\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042/\u00105\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002080\b¢\u0006\u0002\b9\u0012\u0004\u0012\u00020:06H\u0000ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006="}, d2 = {"calculateExtraItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "pinnedItems", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "itemConstraints", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/Constraints;", "filter", "", "calculateItemsOffsets", "", "lines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "placementAnimator", "Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-W2FL7xs", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* renamed from: measureLazyGrid-W2FL7xs, reason: not valid java name */
    public static final LazyGridMeasureResult m1017measureLazyGridW2FL7xs(int i, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider, List<Integer> list, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        boolean z3;
        int i8;
        int i9;
        LazyGridMeasuredLine lazyGridMeasuredLine;
        int m6359constrainWidthK40F9xA;
        int m6344getMaxHeightimpl;
        ArrayList arrayList;
        LazyGridMeasuredLine lazyGridMeasuredLine2;
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        int i10;
        int i11;
        List<Integer> list2 = list;
        if (i3 < 0) {
            throw new IllegalArgumentException("negative beforeContentPadding".toString());
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("negative afterContentPadding".toString());
        }
        if (i <= 0) {
            return new LazyGridMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(Constraints.m6347getMinWidthimpl(j)), Integer.valueOf(Constraints.m6346getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), false, CollectionsKt.emptyList(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
        }
        int roundToInt = MathKt.roundToInt(f);
        int i12 = i7 - roundToInt;
        if (i6 == 0 && i12 < 0) {
            roundToInt += i12;
            i12 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i13 = i12;
        int i14 = -i3;
        int i15 = (i5 < 0 ? i5 : 0) + i14;
        int i16 = i13 + i15;
        int i17 = i6;
        while (i16 < 0 && i17 > 0) {
            i17--;
            LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(i17);
            arrayDeque.add(0, andMeasure);
            i16 += andMeasure.getMainAxisSizeWithSpacings();
        }
        if (i16 < i15) {
            roundToInt += i16;
            i16 = i15;
        }
        int i18 = i16 - i15;
        int i19 = i2 + i4;
        int i20 = roundToInt;
        int coerceAtLeast = RangesKt.coerceAtLeast(i19, 0);
        int i21 = -i18;
        int i22 = i17;
        int i23 = 0;
        boolean z4 = false;
        while (true) {
            z3 = true;
            if (i23 >= arrayDeque.size()) {
                break;
            }
            if (i21 >= coerceAtLeast) {
                arrayDeque.remove(i23);
                z4 = true;
            } else {
                i22++;
                i21 += ((LazyGridMeasuredLine) arrayDeque.get(i23)).getMainAxisSizeWithSpacings();
                i23++;
            }
        }
        int i24 = i22;
        boolean z5 = z4;
        int i25 = i22;
        while (i24 < i && (i21 < coerceAtLeast || i21 <= 0 || arrayDeque.isEmpty())) {
            int i26 = coerceAtLeast;
            LazyGridMeasuredLine andMeasure2 = lazyGridMeasuredLineProvider.getAndMeasure(i24);
            if (andMeasure2.isEmpty()) {
                break;
            }
            int mainAxisSizeWithSpacings = i21 + andMeasure2.getMainAxisSizeWithSpacings();
            if (mainAxisSizeWithSpacings <= i15) {
                i10 = i24;
                i11 = mainAxisSizeWithSpacings;
                if (((LazyGridMeasuredItem) ArraysKt.last(andMeasure2.getItems())).getIndex() != i - 1) {
                    i18 -= andMeasure2.getMainAxisSizeWithSpacings();
                    i25 = i10 + 1;
                    z5 = true;
                    i24 = i10 + 1;
                    coerceAtLeast = i26;
                    i21 = i11;
                }
            } else {
                i10 = i24;
                i11 = mainAxisSizeWithSpacings;
            }
            arrayDeque.add(andMeasure2);
            i24 = i10 + 1;
            coerceAtLeast = i26;
            i21 = i11;
        }
        if (i21 < i2) {
            int i27 = i2 - i21;
            i18 -= i27;
            i21 += i27;
            while (i18 < i3 && i25 > 0) {
                i25--;
                LazyGridMeasuredLine andMeasure3 = lazyGridMeasuredLineProvider.getAndMeasure(i25);
                arrayDeque.add(0, andMeasure3);
                i18 += andMeasure3.getMainAxisSizeWithSpacings();
            }
            i8 = 0;
            i9 = i20 + i27;
            if (i18 < 0) {
                i9 += i18;
                i21 += i18;
                i18 = 0;
            }
        } else {
            i8 = 0;
            i9 = i20;
        }
        float f2 = (MathKt.getSign(MathKt.roundToInt(f)) != MathKt.getSign(i9) || Math.abs(MathKt.roundToInt(f)) < Math.abs(i9)) ? f : i9;
        if (i18 < 0) {
            throw new IllegalArgumentException("negative initial offset".toString());
        }
        int i28 = -i18;
        LazyGridMeasuredLine lazyGridMeasuredLine3 = (LazyGridMeasuredLine) arrayDeque.first();
        LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(lazyGridMeasuredLine3.getItems());
        int index = lazyGridMeasuredItem2 != null ? lazyGridMeasuredItem2.getIndex() : i8;
        LazyGridMeasuredLine lazyGridMeasuredLine4 = (LazyGridMeasuredLine) arrayDeque.lastOrNull();
        int index2 = (lazyGridMeasuredLine4 == null || (items = lazyGridMeasuredLine4.getItems()) == null || (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.lastOrNull(items)) == null) ? i8 : lazyGridMeasuredItem.getIndex();
        int size = list2.size();
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        int i29 = 0;
        while (i29 < size) {
            int i30 = i29;
            int intValue = list2.get(i29).intValue();
            if (intValue < 0 || intValue >= index) {
                lazyGridMeasuredLine2 = lazyGridMeasuredLine3;
            } else {
                LazyGridMeasuredItem m1020getAndMeasure3p2s80s$default = LazyGridMeasuredItemProvider.m1020getAndMeasure3p2s80s$default(lazyGridMeasuredItemProvider, intValue, 0, lazyGridMeasuredLineProvider.m1023itemConstraintsOenEA2s(intValue), 2, null);
                if (arrayList3 == null) {
                    arrayList3 = new ArrayList();
                }
                lazyGridMeasuredLine2 = lazyGridMeasuredLine3;
                List list3 = arrayList3;
                list3.add(m1020getAndMeasure3p2s80s$default);
                arrayList3 = list3;
            }
            i29 = i30 + 1;
            lazyGridMeasuredLine3 = lazyGridMeasuredLine2;
        }
        LazyGridMeasuredLine lazyGridMeasuredLine5 = lazyGridMeasuredLine3;
        if (arrayList3 == null) {
            arrayList3 = CollectionsKt.emptyList();
        }
        List list4 = arrayList3;
        int size2 = list2.size();
        int i31 = 0;
        while (i31 < size2) {
            int intValue2 = list2.get(i31).intValue();
            int i32 = size2;
            if (index2 + 1 <= intValue2 && intValue2 < i) {
                LazyGridMeasuredItem m1020getAndMeasure3p2s80s$default2 = LazyGridMeasuredItemProvider.m1020getAndMeasure3p2s80s$default(lazyGridMeasuredItemProvider, intValue2, 0, lazyGridMeasuredLineProvider.m1023itemConstraintsOenEA2s(intValue2), 2, null);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                List list5 = arrayList2;
                list5.add(m1020getAndMeasure3p2s80s$default2);
                arrayList2 = list5;
            }
            i31++;
            size2 = i32;
            list2 = list;
        }
        if (arrayList2 == null) {
            arrayList2 = CollectionsKt.emptyList();
        }
        List list6 = arrayList2;
        if (i3 > 0 || i5 < 0) {
            int size3 = arrayDeque.size();
            lazyGridMeasuredLine = lazyGridMeasuredLine5;
            int i33 = 0;
            while (i33 < size3) {
                int i34 = size3;
                int mainAxisSizeWithSpacings2 = ((LazyGridMeasuredLine) arrayDeque.get(i33)).getMainAxisSizeWithSpacings();
                if (i18 == 0 || mainAxisSizeWithSpacings2 > i18 || i33 == CollectionsKt.getLastIndex(arrayDeque)) {
                    break;
                }
                i18 -= mainAxisSizeWithSpacings2;
                i33++;
                lazyGridMeasuredLine = (LazyGridMeasuredLine) arrayDeque.get(i33);
                size3 = i34;
            }
        } else {
            lazyGridMeasuredLine = lazyGridMeasuredLine5;
        }
        int i35 = i18;
        if (z) {
            m6359constrainWidthK40F9xA = Constraints.m6345getMaxWidthimpl(j);
        } else {
            m6359constrainWidthK40F9xA = ConstraintsKt.m6359constrainWidthK40F9xA(j, i21);
        }
        int i36 = m6359constrainWidthK40F9xA;
        if (z) {
            m6344getMaxHeightimpl = ConstraintsKt.m6358constrainHeightK40F9xA(j, i21);
        } else {
            m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(j);
        }
        int i37 = m6344getMaxHeightimpl;
        int i38 = i21;
        final List<LazyGridMeasuredItem> calculateItemsOffsets = calculateItemsOffsets(arrayDeque, list4, list6, i36, i37, i38, i2, i28, z, vertical, horizontal, z2, density);
        lazyGridItemPlacementAnimator.onMeasured((int) f2, i36, i37, calculateItemsOffsets, lazyGridMeasuredItemProvider, lazyGridSpanLayoutProvider, z, coroutineScope);
        if (index2 == i - 1 && i38 <= i2) {
            z3 = false;
        }
        MeasureResult invoke = function3.invoke(Integer.valueOf(i36), Integer.valueOf(i37), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$5
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
                List<LazyGridMeasuredItem> list7 = calculateItemsOffsets;
                int size4 = list7.size();
                for (int i39 = 0; i39 < size4; i39++) {
                    list7.get(i39).place(placementScope);
                }
                ObservableScopeInvalidator.m1047attachToScopeimpl(mutableState);
            }
        });
        if (list4.isEmpty() && list6.isEmpty()) {
            arrayList = calculateItemsOffsets;
        } else {
            ArrayList arrayList4 = new ArrayList(calculateItemsOffsets.size());
            int size4 = calculateItemsOffsets.size();
            for (int i39 = 0; i39 < size4; i39++) {
                LazyGridMeasuredItem lazyGridMeasuredItem3 = calculateItemsOffsets.get(i39);
                int index3 = lazyGridMeasuredItem3.getIndex();
                if (index <= index3 && index3 <= index2) {
                    arrayList4.add(lazyGridMeasuredItem3);
                }
            }
            arrayList = arrayList4;
        }
        return new LazyGridMeasureResult(lazyGridMeasuredLine, i35, z3, f2, invoke, z5, arrayList, i14, i19, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = i2;
        int i7 = z ? i6 : i;
        int i8 = 0;
        boolean z3 = i3 < Math.min(i7, i4);
        if (z3 && i5 != 0) {
            throw new IllegalStateException("non-zero firstLineScrollOffset".toString());
        }
        int size = list.size();
        int i9 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            i9 += list.get(i10).getItems().length;
        }
        ArrayList arrayList = new ArrayList(i9);
        if (z3) {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no items".toString());
            }
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i11 = 0; i11 < size2; i11++) {
                iArr[i11] = list.get(calculateItemsOffsets$reverseAware(i11, z2, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            for (int i12 = 0; i12 < size2; i12++) {
                iArr2[i12] = 0;
            }
            if (z) {
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalArrangement".toString());
                }
                vertical.arrange(density, i7, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalArrangement".toString());
                }
                horizontal.arrange(density, i7, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i13 = iArr2[first];
                    LazyGridMeasuredLine lazyGridMeasuredLine = list.get(calculateItemsOffsets$reverseAware(first, z2, size2));
                    if (z2) {
                        i13 = (i7 - i13) - lazyGridMeasuredLine.getMainAxisSize();
                    }
                    CollectionsKt.addAll(arrayList, lazyGridMeasuredLine.position(i13, i, i6));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size() - 1;
            if (size3 >= 0) {
                int i14 = i5;
                while (true) {
                    int i15 = size3 - 1;
                    LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(size3);
                    i14 -= lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                    LazyGridMeasuredItem.position$default(lazyGridMeasuredItem, i14, 0, i, i6, 0, 0, 48, null);
                    arrayList.add(lazyGridMeasuredItem);
                    if (i15 < 0) {
                        break;
                    }
                    size3 = i15;
                }
            }
            int size4 = list.size();
            int i16 = i5;
            for (int i17 = 0; i17 < size4; i17++) {
                LazyGridMeasuredLine lazyGridMeasuredLine2 = list.get(i17);
                CollectionsKt.addAll(arrayList, lazyGridMeasuredLine2.position(i16, i, i6));
                i16 += lazyGridMeasuredLine2.getMainAxisSizeWithSpacings();
            }
            int size5 = list3.size();
            int i18 = i16;
            while (i8 < size5) {
                LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i8);
                LazyGridMeasuredItem.position$default(lazyGridMeasuredItem2, i18, 0, i, i6, 0, 0, 48, null);
                arrayList.add(lazyGridMeasuredItem2);
                i18 += lazyGridMeasuredItem2.getMainAxisSizeWithSpacings();
                i8++;
                i6 = i2;
            }
        }
        return arrayList;
    }

    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, Function1<? super Integer, Constraints> function1, Function1<? super Integer, Boolean> function12) {
        LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider2;
        int size = list.size();
        ArrayList arrayList = null;
        int i = 0;
        while (i < size) {
            int intValue = list.get(i).intValue();
            if (function12.invoke(Integer.valueOf(intValue)).booleanValue()) {
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
                LazyGridMeasuredItem m1020getAndMeasure3p2s80s$default = LazyGridMeasuredItemProvider.m1020getAndMeasure3p2s80s$default(lazyGridMeasuredItemProvider2, intValue, 0, function1.invoke(Integer.valueOf(intValue)).getValue(), 2, null);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(m1020getAndMeasure3p2s80s$default);
            } else {
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
            }
            i++;
            lazyGridMeasuredItemProvider = lazyGridMeasuredItemProvider2;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }
}
