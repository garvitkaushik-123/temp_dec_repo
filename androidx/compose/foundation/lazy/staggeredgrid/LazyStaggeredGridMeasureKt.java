package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntSizeKt;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3040d4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0017\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0082\b\u001a5\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u0002H\n0\u000e¢\u0006\u0002\b\u000fH\u0083\b¢\u0006\u0002\u0010\u0010\u001aR\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00050\u000e2!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00010\u000e2\u0006\u0010\u001a\u001a\u00020\u0001H\u0083\b\u001a;\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012*\u00020\u00142\u0012\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\"\u001a\u001d\u0010#\u001a\u00020\b*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u001e0\u001dH\u0002¢\u0006\u0002\u0010$\u001a\u001c\u0010%\u001a\u00020\u0005*\u00020\u00142\u0006\u0010&\u001a\u00020 2\u0006\u0010'\u001a\u00020\u0003H\u0002\u001a7\u0010(\u001a\u00020\u0005\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u00122\b\b\u0002\u0010)\u001a\u00020\u00012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\b\u001a\u001c\u0010+\u001a\u00020\u0003*\u00020\u00142\u0006\u0010,\u001a\u00020\u00032\u0006\u0010-\u001a\u00020\u0003H\u0002\u001a+\u0010.\u001a\u00020\u0005*\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\bø\u0001\u0000¢\u0006\u0004\b0\u00101\u001a\f\u00102\u001a\u00020\u0003*\u00020 H\u0002\u001a2\u00103\u001a\u00020\u0003\"\u0004\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u001d2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u00020\u00030\u000eH\u0082\b¢\u0006\u0002\u00104\u001a\u0016\u00105\u001a\u00020\u0003*\u00020 2\b\b\u0002\u00106\u001a\u00020\u0003H\u0000\u001a\u001e\u00107\u001a\u00020\u0003*\u00020 2\u0006\u00108\u001a\u00020/H\u0002ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a,\u0010;\u001a\u00020<*\u00020\u00142\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020 2\u0006\u0010?\u001a\u00020 2\u0006\u0010@\u001a\u00020\u0001H\u0003\u001a\u0084\u0001\u0010A\u001a\u00020<*\u00020\f2\u0006\u0010B\u001a\u00020C2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00030\u00122\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u00012\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\u00032\u0006\u0010P\u001a\u00020\u00032\u0006\u0010Q\u001a\u00020\u00032\u0006\u0010R\u001a\u00020\u00032\u0006\u0010S\u001a\u00020TH\u0001ø\u0001\u0000¢\u0006\u0004\bU\u0010V\u001a\u0014\u0010W\u001a\u00020\u0005*\u00020 2\u0006\u0010X\u001a\u00020\u0003H\u0002\u001a!\u0010Y\u001a\u00020 *\u00020 2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0082\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Z"}, d2 = {"DebugLoggingEnabled", "", "Unset", "", "debugLog", "", PglCryptUtils.KEY_MESSAGE, "Lkotlin/Function0;", "", "withDebugLogging", "T", "scope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "calculateExtraItems", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", C3040d4.h.L, "filter", "Lkotlin/ParameterName;", "name", "itemIndex", "beforeVisibleBounds", "calculateVisibleItems", "measuredItems", "", "Lkotlin/collections/ArrayDeque;", "itemScrollOffsets", "", "mainAxisLayoutSize", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;[Lkotlin/collections/ArrayDeque;[II)Ljava/util/List;", "debugRender", "([Lkotlin/collections/ArrayDeque;)Ljava/lang/String;", "ensureIndicesInRange", "indices", "itemCount", "fastForEach", "reverse", "action", "findPreviousItemIndex", "item", "lane", "forEach", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "forEach-nIS5qE8", "(JLkotlin/jvm/functions/Function1;)V", "indexOfMaxValue", "indexOfMinBy", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)I", "indexOfMinValue", "minBound", "maxInRange", "indexRange", "maxInRange-jy6DScQ", "([IJ)I", "measure", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "initialScrollDelta", "initialItemIndices", "initialItemOffsets", "canRestartMeasure", "measureStaggeredGrid", "state", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "reverseLayout", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "mainAxisAvailableSize", "mainAxisSpacing", "beforeContentPadding", "afterContentPadding", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "measureStaggeredGrid-sdzDtKU", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZZJIIIILkotlinx/coroutines/CoroutineScope;)Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureResult;", "offsetBy", "delta", "transform", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasureKt {
    private static final boolean DebugLoggingEnabled = false;
    private static final int Unset = Integer.MIN_VALUE;

    private static final void debugLog(Function0<String> function0) {
    }

    private static final <T> T withDebugLogging(LazyLayoutMeasureScope lazyLayoutMeasureScope, Function1<? super LazyLayoutMeasureScope, ? extends T> function1) {
        return function1.invoke(lazyLayoutMeasureScope);
    }

    private static final String debugRender(ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr) {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: measureStaggeredGrid-sdzDtKU, reason: not valid java name */
    public static final LazyStaggeredGridMeasureResult m1080measureStaggeredGridsdzDtKU(LazyLayoutMeasureScope lazyLayoutMeasureScope, LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, boolean z2, long j2, int i, int i2, int i3, int i4, CoroutineScope coroutineScope) {
        T t;
        int m1079maxInRangejy6DScQ;
        T t2;
        int i5;
        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext = new LazyStaggeredGridMeasureContext(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i3, i4, z2, i2, coroutineScope, null);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Snapshot createNonObservableSnapshot = Snapshot.INSTANCE.createNonObservableSnapshot();
        try {
            Snapshot makeCurrent = createNonObservableSnapshot.makeCurrent();
            try {
                int[] updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyStaggeredGridState.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyStaggeredGridItemProvider, lazyStaggeredGridState.getScrollPosition().getIndices());
                int[] scrollOffsets = lazyStaggeredGridState.getScrollPosition().getScrollOffsets();
                if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length == lazyStaggeredGridMeasureContext.getLaneCount()) {
                    t = updateScrollPositionIfTheFirstItemWasMoved$foundation_release;
                } else {
                    lazyStaggeredGridMeasureContext.getLaneInfo().reset();
                    int laneCount = lazyStaggeredGridMeasureContext.getLaneCount();
                    int[] iArr = new int[laneCount];
                    int i6 = 0;
                    while (i6 < laneCount) {
                        if (i6 >= updateScrollPositionIfTheFirstItemWasMoved$foundation_release.length || (m1079maxInRangejy6DScQ = updateScrollPositionIfTheFirstItemWasMoved$foundation_release[i6]) == -1) {
                            m1079maxInRangejy6DScQ = i6 == 0 ? 0 : m1079maxInRangejy6DScQ(iArr, SpanRange.m1089constructorimpl(0, i6)) + 1;
                        }
                        iArr[i6] = m1079maxInRangejy6DScQ;
                        lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[i6], i6);
                        i6++;
                    }
                    t = iArr;
                }
                objectRef.element = t;
                if (scrollOffsets.length == lazyStaggeredGridMeasureContext.getLaneCount()) {
                    t2 = scrollOffsets;
                } else {
                    int laneCount2 = lazyStaggeredGridMeasureContext.getLaneCount();
                    int[] iArr2 = new int[laneCount2];
                    int i7 = 0;
                    while (i7 < laneCount2) {
                        if (i7 < scrollOffsets.length) {
                            i5 = scrollOffsets[i7];
                        } else {
                            i5 = i7 == 0 ? 0 : iArr2[i7 - 1];
                        }
                        iArr2[i7] = i5;
                        i7++;
                    }
                    t2 = iArr2;
                }
                objectRef2.element = t2;
                Unit unit = Unit.INSTANCE;
                createNonObservableSnapshot.dispose();
                return measure(lazyStaggeredGridMeasureContext, MathKt.roundToInt(lazyStaggeredGridState.getScrollToBeConsumed()), (int[]) objectRef.element, (int[]) objectRef2.element, true);
            } finally {
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
            }
        } catch (Throwable th) {
            createNonObservableSnapshot.dispose();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:233:0x0554, code lost:
    
        if (r10[r14] > r7) goto L254;
     */
    /* JADX WARN: Code restructure failed: missing block: B:341:0x02f6, code lost:
    
        r7 = indexOfMinValue$default(r8, 0, 1, null);
        r9 = indexOfMaxValue(r28);
     */
    /* JADX WARN: Code restructure failed: missing block: B:342:0x0301, code lost:
    
        if (r7 == r9) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:344:0x0307, code lost:
    
        if (r8[r7] != r8[r9]) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:345:0x0309, code lost:
    
        r7 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:346:0x030b, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:347:0x030c, code lost:
    
        r9 = r28[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x030f, code lost:
    
        if (r9 != (-1)) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:349:0x0311, code lost:
    
        r9 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0312, code lost:
    
        r9 = findPreviousItemIndex(r0, r9, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x0316, code lost:
    
        if (r9 >= 0) goto L174;
     */
    /* JADX WARN: Code restructure failed: missing block: B:352:0x0359, code lost:
    
        r10 = r28;
        r11 = r31;
        r25 = r1;
        r42 = r2;
        r1 = r0.m1076getSpanRangelOCCd4c(r0.getItemProvider(), r9, r7);
        r7 = r0.getLaneInfo();
        r14 = r3;
        r30 = r4;
        r3 = (int) (r1 & 4294967295L);
        r26 = r15;
        r14 = (int) (r1 >> 32);
        r15 = r3 - r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:353:0x037e, code lost:
    
        if (r15 == 1) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0380, code lost:
    
        r23 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:355:0x0385, code lost:
    
        if (r23 == false) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:356:0x0387, code lost:
    
        r4 = -2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:357:0x038a, code lost:
    
        r7.setLane(r9, r4);
        r4 = r0.getMeasuredItemProvider().m1084getAndMeasurejy6DScQ(r9, r1);
        r1 = m1079maxInRangejy6DScQ(r8, r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x039a, code lost:
    
        if (r15 == 1) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:359:0x039c, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:360:0x039f, code lost:
    
        if (r2 == false) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:361:0x03a1, code lost:
    
        r2 = r0.getLaneInfo().getGaps(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:363:0x03ab, code lost:
    
        if (r14 >= r3) goto L424;
     */
    /* JADX WARN: Code restructure failed: missing block: B:365:0x03af, code lost:
    
        if (r8[r14] == r1) goto L192;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x03b1, code lost:
    
        r25 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:367:0x03b3, code lost:
    
        r27[r14].addFirst(r4);
        r10[r14] = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:368:0x03ba, code lost:
    
        if (r2 != null) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:369:0x03bc, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:371:0x03c0, code lost:
    
        r8[r14] = (r4.getSizeWithSpacings() + r1) + r7;
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:372:0x03be, code lost:
    
        r7 = r2[r14];
     */
    /* JADX WARN: Code restructure failed: missing block: B:376:0x03aa, code lost:
    
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:377:0x039e, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x0389, code lost:
    
        r4 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:379:0x0383, code lost:
    
        r23 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:381:0x0318, code lost:
    
        r10 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x031a, code lost:
    
        if (r1 != false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:384:0x0320, code lost:
    
        if (measure$lambda$38$misalignedStart(r10, r0, r8, r7) == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:385:0x034d, code lost:
    
        r11 = r31;
        r42 = r2;
        r28 = r3;
        r30 = r4;
        r26 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:393:0x0322, code lost:
    
        if (r44 == false) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x0324, code lost:
    
        r0.getLaneInfo().reset();
        r1 = r10.length;
        r2 = new int[r1];
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:395:0x032f, code lost:
    
        if (r3 >= r1) goto L428;
     */
    /* JADX WARN: Code restructure failed: missing block: B:396:0x0331, code lost:
    
        r2[r3] = -1;
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:398:0x0338, code lost:
    
        r1 = r8.length;
        r3 = new int[r1];
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:399:0x033c, code lost:
    
        if (r4 >= r1) goto L429;
     */
    /* JADX WARN: Code restructure failed: missing block: B:400:0x033e, code lost:
    
        r3[r4] = r8[r7];
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:403:0x034c, code lost:
    
        return measure(r0, r31, r2, r3, false);
     */
    /* JADX WARN: Removed duplicated region for block: B:253:0x060a  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x063c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final LazyStaggeredGridMeasureResult measure(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int[] iArr, int[] iArr2, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr3;
        int[] iArr4;
        int i6;
        int i7;
        int[] iArr5;
        int i8;
        int i9;
        int i10;
        List list;
        int[] iArr6;
        int i11;
        boolean z2;
        int i12;
        int i13;
        int[] iArr7;
        int i14;
        int m6359constrainWidthK40F9xA;
        int m6344getMaxHeightimpl;
        List list2;
        boolean z3;
        boolean z4;
        boolean z5;
        List<Integer> list3;
        int[] iArr8;
        List list4;
        boolean z6;
        int i15;
        int[] iArr9;
        int i16;
        boolean z7;
        int i17;
        int[] iArr10;
        boolean z8;
        final LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
        LazyLayoutMeasureScope measureScope = lazyStaggeredGridMeasureContext2.getMeasureScope();
        int itemCount = lazyStaggeredGridMeasureContext2.getItemProvider().getItemCount();
        if (itemCount <= 0 || lazyStaggeredGridMeasureContext2.getLaneCount() == 0) {
            return new LazyStaggeredGridMeasureResult(iArr, iArr2, 0.0f, MeasureScope.layout$default(measureScope, Constraints.m6347getMinWidthimpl(lazyStaggeredGridMeasureContext.getConstraints()), Constraints.m6346getMinHeightimpl(lazyStaggeredGridMeasureContext.getConstraints()), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }, 4, null), false, lazyStaggeredGridMeasureContext.getIsVertical(), false, itemCount, CollectionsKt.emptyList(), IntSizeKt.IntSize(Constraints.m6347getMinWidthimpl(lazyStaggeredGridMeasureContext.getConstraints()), Constraints.m6346getMinHeightimpl(lazyStaggeredGridMeasureContext.getConstraints())), -lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getBeforeContentPadding(), lazyStaggeredGridMeasureContext.getAfterContentPadding(), lazyStaggeredGridMeasureContext.getMainAxisSpacing(), null);
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        String str = "copyOf(this, size)";
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        int[] copyOf2 = Arrays.copyOf(iArr2, iArr2.length);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, size)");
        ensureIndicesInRange(lazyStaggeredGridMeasureContext2, copyOf, itemCount);
        offsetBy(copyOf2, -i);
        int laneCount = lazyStaggeredGridMeasureContext2.getLaneCount();
        ArrayDeque[] arrayDequeArr = new ArrayDeque[laneCount];
        for (int i18 = 0; i18 < laneCount; i18++) {
            arrayDequeArr[i18] = new ArrayDeque(16);
        }
        offsetBy(copyOf2, -lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        boolean z9 = false;
        while (true) {
            if (!measure$lambda$38$hasSpaceBeforeFirst(copyOf, copyOf2, lazyStaggeredGridMeasureContext2)) {
                i2 = 0;
                i3 = -1;
                break;
            }
            i3 = indexOfMaxValue(copyOf);
            int i19 = copyOf[i3];
            int length = copyOf2.length;
            i2 = 0;
            for (int i20 = 0; i20 < length; i20++) {
                if (copyOf[i20] != copyOf[i3]) {
                    int i21 = copyOf2[i20];
                    int i22 = copyOf2[i3];
                    if (i21 < i22) {
                        copyOf2[i20] = i22;
                    }
                }
            }
            int findPreviousItemIndex = findPreviousItemIndex(lazyStaggeredGridMeasureContext2, i19, i3);
            if (findPreviousItemIndex < 0) {
                break;
            }
            long m1076getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext2.m1076getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), findPreviousItemIndex, i3);
            boolean z10 = z9;
            int i23 = (int) (m1076getSpanRangelOCCd4c & 4294967295L);
            int i24 = itemCount;
            int i25 = (int) (m1076getSpanRangelOCCd4c >> 32);
            int i26 = i23 - i25;
            lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(findPreviousItemIndex, i26 != 1 ? -2 : i25);
            LazyStaggeredGridMeasuredItem m1084getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1084getAndMeasurejy6DScQ(findPreviousItemIndex, m1076getSpanRangelOCCd4c);
            int m1079maxInRangejy6DScQ = m1079maxInRangejy6DScQ(copyOf2, m1076getSpanRangelOCCd4c);
            int[] gaps = i26 != 1 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(findPreviousItemIndex) : null;
            boolean z11 = z10;
            while (i25 < i23) {
                copyOf[i25] = findPreviousItemIndex;
                int sizeWithSpacings = m1079maxInRangejy6DScQ + m1084getAndMeasurejy6DScQ.getSizeWithSpacings() + (gaps == null ? 0 : gaps[i25]);
                copyOf2[i25] = sizeWithSpacings;
                if (lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + sizeWithSpacings <= 0) {
                    z11 = true;
                }
                i25++;
            }
            z9 = z11;
            itemCount = i24;
        }
        boolean z12 = z9;
        int i27 = itemCount;
        int i28 = -lazyStaggeredGridMeasureContext2.getBeforeContentPadding();
        int i29 = copyOf2[i2];
        if (i29 < i28) {
            i4 = i + i29;
            offsetBy(copyOf2, i28 - i29);
        } else {
            i4 = i;
        }
        offsetBy(copyOf2, lazyStaggeredGridMeasureContext2.getBeforeContentPadding());
        int i30 = -1;
        if (i3 == -1) {
            i3 = ArraysKt.indexOf(copyOf, i2);
        }
        if (i3 != -1 && measure$lambda$38$misalignedStart(copyOf, lazyStaggeredGridMeasureContext2, copyOf2, i3) && z) {
            lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
            int length2 = copyOf.length;
            int[] iArr11 = new int[length2];
            int i31 = 0;
            while (i31 < length2) {
                iArr11[i31] = i30;
                i31++;
                i30 = -1;
            }
            int length3 = copyOf2.length;
            int[] iArr12 = new int[length3];
            for (int i32 = 0; i32 < length3; i32++) {
                iArr12[i32] = copyOf2[i3];
            }
            return measure(lazyStaggeredGridMeasureContext2, i4, iArr11, iArr12, false);
        }
        int[] copyOf3 = Arrays.copyOf(copyOf, copyOf.length);
        Intrinsics.checkNotNullExpressionValue(copyOf3, "copyOf(this, size)");
        int length4 = copyOf2.length;
        int[] iArr13 = new int[length4];
        for (int i33 = 0; i33 < length4; i33++) {
            iArr13[i33] = -copyOf2[i33];
        }
        int mainAxisSpacing = i28 + lazyStaggeredGridMeasureContext2.getMainAxisSpacing();
        int coerceAtLeast = RangesKt.coerceAtLeast(lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() + lazyStaggeredGridMeasureContext2.getAfterContentPadding(), 0);
        int i34 = i28;
        boolean z13 = z12;
        int indexOfMinValue$default = indexOfMinValue$default(copyOf3, 0, 1, null);
        int i35 = 0;
        for (int i36 = -1; indexOfMinValue$default != i36 && i35 < lazyStaggeredGridMeasureContext2.getLaneCount(); i36 = -1) {
            int i37 = copyOf3[indexOfMinValue$default];
            int indexOfMinValue = indexOfMinValue(copyOf3, i37);
            i35++;
            if (i37 >= 0) {
                long m1076getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext2.m1076getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), i37, indexOfMinValue$default);
                int i38 = i27;
                LazyStaggeredGridMeasuredItem m1084getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1084getAndMeasurejy6DScQ(i37, m1076getSpanRangelOCCd4c2);
                ArrayDeque[] arrayDequeArr2 = arrayDequeArr;
                int[] iArr14 = copyOf;
                int[] iArr15 = copyOf2;
                int i39 = (int) (m1076getSpanRangelOCCd4c2 & 4294967295L);
                int i40 = i4;
                int[] iArr16 = copyOf3;
                int i41 = (int) (m1076getSpanRangelOCCd4c2 >> 32);
                int i42 = i39 - i41;
                lazyStaggeredGridMeasureContext2.getLaneInfo().setLane(i37, i42 != 1 ? -2 : i41);
                int m1079maxInRangejy6DScQ2 = m1079maxInRangejy6DScQ(iArr13, m1076getSpanRangelOCCd4c2);
                for (int i43 = i41; i43 < i39; i43++) {
                    iArr13[i43] = m1084getAndMeasurejy6DScQ2.getSizeWithSpacings() + m1079maxInRangejy6DScQ2;
                    iArr16[i43] = i37;
                    arrayDequeArr2[i43].addLast(m1084getAndMeasurejy6DScQ2);
                }
                if (m1079maxInRangejy6DScQ2 >= mainAxisSpacing || iArr13[i41] > mainAxisSpacing) {
                    z8 = z13;
                } else {
                    m1084getAndMeasurejy6DScQ2.setVisible(false);
                    z8 = true;
                }
                i35 = i42 != 1 ? lazyStaggeredGridMeasureContext2.getLaneCount() : i35;
                z13 = z8;
                indexOfMinValue$default = indexOfMinValue;
                i27 = i38;
                arrayDequeArr = arrayDequeArr2;
                copyOf = iArr14;
                copyOf2 = iArr15;
                copyOf3 = iArr16;
                i4 = i40;
            } else {
                indexOfMinValue$default = indexOfMinValue;
            }
        }
        int[] iArr17 = copyOf;
        int[] iArr18 = copyOf2;
        ArrayDeque[] arrayDequeArr3 = arrayDequeArr;
        int i44 = i4;
        int[] iArr19 = copyOf3;
        loop9: while (true) {
            int i45 = i27;
            int i46 = 0;
            while (true) {
                if (i46 < length4) {
                    int i47 = iArr13[i46];
                    if (i47 < coerceAtLeast || i47 <= 0) {
                        break;
                    }
                    i46++;
                } else {
                    for (int i48 = 0; i48 < laneCount; i48++) {
                        if (!arrayDequeArr3[i48].isEmpty()) {
                            i27 = i45;
                            i5 = 1;
                            break loop9;
                        }
                    }
                }
            }
            i5 = 1;
            int indexOfMinValue$default2 = indexOfMinValue$default(iArr13, 0, 1, null);
            int maxOrThrow = ArraysKt.maxOrThrow(iArr19) + 1;
            i27 = i45;
            if (maxOrThrow >= i27) {
                break;
            }
            boolean z14 = z13;
            int i49 = i34;
            int i50 = coerceAtLeast;
            int[] iArr20 = iArr18;
            int[] iArr21 = iArr19;
            int i51 = i44;
            long m1076getSpanRangelOCCd4c3 = lazyStaggeredGridMeasureContext2.m1076getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), maxOrThrow, indexOfMinValue$default2);
            String str2 = str;
            int i52 = (int) (m1076getSpanRangelOCCd4c3 & 4294967295L);
            int i53 = laneCount;
            int i54 = (int) (m1076getSpanRangelOCCd4c3 >> 32);
            int i55 = i52 - i54;
            lazyStaggeredGridMeasureContext.getLaneInfo().setLane(maxOrThrow, i55 != 1 ? -2 : i54);
            LazyStaggeredGridMeasuredItem m1084getAndMeasurejy6DScQ3 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1084getAndMeasurejy6DScQ(maxOrThrow, m1076getSpanRangelOCCd4c3);
            int m1079maxInRangejy6DScQ3 = m1079maxInRangejy6DScQ(iArr13, m1076getSpanRangelOCCd4c3);
            if (i55 != 1) {
                iArr10 = lazyStaggeredGridMeasureContext.getLaneInfo().getGaps(maxOrThrow);
                if (iArr10 == null) {
                    iArr10 = new int[lazyStaggeredGridMeasureContext.getLaneCount()];
                }
            } else {
                iArr10 = null;
            }
            for (int i56 = i54; i56 < i52; i56++) {
                if (iArr10 != null) {
                    iArr10[i56] = m1079maxInRangejy6DScQ3 - iArr13[i56];
                }
                iArr21[i56] = maxOrThrow;
                iArr13[i56] = m1079maxInRangejy6DScQ3 + m1084getAndMeasurejy6DScQ3.getSizeWithSpacings();
                arrayDequeArr3[i56].addLast(m1084getAndMeasurejy6DScQ3);
            }
            lazyStaggeredGridMeasureContext.getLaneInfo().setGaps(maxOrThrow, iArr10);
            if (m1079maxInRangejy6DScQ3 < mainAxisSpacing && iArr13[i54] <= mainAxisSpacing) {
                m1084getAndMeasurejy6DScQ3.setVisible(false);
            }
            lazyStaggeredGridMeasureContext2 = lazyStaggeredGridMeasureContext;
            i34 = i49;
            iArr19 = iArr21;
            iArr18 = iArr20;
            coerceAtLeast = i50;
            z13 = z14;
            i44 = i51;
            str = str2;
            laneCount = i53;
        }
        int i57 = 0;
        while (i57 < laneCount) {
            ArrayDeque arrayDeque = arrayDequeArr3[i57];
            while (arrayDeque.size() > i5 && !((LazyStaggeredGridMeasuredItem) arrayDeque.first()).getIsVisible()) {
                LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem = (LazyStaggeredGridMeasuredItem) arrayDeque.removeFirst();
                int[] gaps2 = lazyStaggeredGridMeasuredItem.getSpan() != i5 ? lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem.getIndex()) : null;
                iArr18[i57] = iArr18[i57] - (lazyStaggeredGridMeasuredItem.getSizeWithSpacings() + (gaps2 == null ? 0 : gaps2[i57]));
                i5 = 1;
            }
            LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem2 = (LazyStaggeredGridMeasuredItem) arrayDeque.firstOrNull();
            iArr17[i57] = lazyStaggeredGridMeasuredItem2 != null ? lazyStaggeredGridMeasuredItem2.getIndex() : -1;
            i57++;
            i5 = 1;
        }
        int[] iArr22 = iArr19;
        int length5 = iArr22.length;
        int i58 = 0;
        while (true) {
            if (i58 >= length5) {
                break;
            }
            if (iArr22[i58] == i27 - 1) {
                offsetBy(iArr13, -lazyStaggeredGridMeasureContext2.getMainAxisSpacing());
                break;
            }
            i58++;
        }
        int i59 = 0;
        while (true) {
            if (i59 < length4) {
                if (iArr13[i59] >= lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                    i7 = coerceAtLeast;
                    iArr5 = iArr22;
                    i8 = i27;
                    iArr4 = iArr17;
                    iArr3 = iArr18;
                    i10 = i44;
                    list = null;
                    break;
                }
                i59++;
            } else {
                int mainAxisAvailableSize = lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize() - iArr13[indexOfMaxValue(iArr13)];
                iArr3 = iArr18;
                offsetBy(iArr3, -mainAxisAvailableSize);
                offsetBy(iArr13, mainAxisAvailableSize);
                boolean z15 = false;
                loop25: while (true) {
                    int length6 = iArr3.length;
                    int i60 = 0;
                    while (true) {
                        if (i60 >= length6) {
                            iArr4 = iArr17;
                            i6 = i44;
                            i7 = coerceAtLeast;
                            iArr5 = iArr22;
                            i8 = i27;
                            i9 = mainAxisAvailableSize;
                            break loop25;
                        }
                        if (iArr3[i60] < lazyStaggeredGridMeasureContext2.getBeforeContentPadding()) {
                            break;
                        }
                        i60++;
                        iArr17 = iArr17;
                    }
                    coerceAtLeast = i12;
                    i44 = i11;
                    z15 = z2;
                    i27 = i14;
                    mainAxisAvailableSize = i13;
                    iArr22 = iArr7;
                    iArr17 = iArr6;
                }
                if (z15 && z) {
                    lazyStaggeredGridMeasureContext2.getLaneInfo().reset();
                    return measure(lazyStaggeredGridMeasureContext2, i6, iArr4, iArr3, false);
                }
                i10 = i6 + i9;
                list = null;
                int i61 = iArr3[indexOfMinValue$default(iArr3, 0, 1, null)];
                if (i61 < 0) {
                    i10 += i61;
                    offsetBy(iArr13, i61);
                    offsetBy(iArr3, -i61);
                }
            }
        }
        float scrollToBeConsumed = (MathKt.getSign(MathKt.roundToInt(lazyStaggeredGridMeasureContext2.getState().getScrollToBeConsumed())) != MathKt.getSign(i10) || Math.abs(MathKt.roundToInt(lazyStaggeredGridMeasureContext2.getState().getScrollToBeConsumed())) < Math.abs(i10)) ? lazyStaggeredGridMeasureContext2.getState().getScrollToBeConsumed() : i10;
        int[] copyOf4 = Arrays.copyOf(iArr3, iArr3.length);
        Intrinsics.checkNotNullExpressionValue(copyOf4, str);
        int length7 = copyOf4.length;
        for (int i62 = 0; i62 < length7; i62++) {
            copyOf4[i62] = -copyOf4[i62];
        }
        if (lazyStaggeredGridMeasureContext2.getBeforeContentPadding() > lazyStaggeredGridMeasureContext2.getMainAxisSpacing()) {
            for (int i63 = 0; i63 < laneCount; i63++) {
                ArrayDeque arrayDeque2 = arrayDequeArr3[i63];
                int size = arrayDeque2.size();
                int i64 = 0;
                while (i64 < size) {
                    LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem3 = (LazyStaggeredGridMeasuredItem) arrayDeque2.get(i64);
                    int[] gaps3 = lazyStaggeredGridMeasureContext2.getLaneInfo().getGaps(lazyStaggeredGridMeasuredItem3.getIndex());
                    int sizeWithSpacings2 = lazyStaggeredGridMeasuredItem3.getSizeWithSpacings() + (gaps3 == null ? 0 : gaps3[i63]);
                    if (i64 != CollectionsKt.getLastIndex(arrayDeque2) && (i17 = iArr3[i63]) != 0 && i17 >= sizeWithSpacings2) {
                        iArr3[i63] = i17 - sizeWithSpacings2;
                        i64++;
                        iArr4[i63] = ((LazyStaggeredGridMeasuredItem) arrayDeque2.get(i64)).getIndex();
                    }
                }
            }
        }
        int beforeContentPadding = lazyStaggeredGridMeasureContext2.getBeforeContentPadding() + lazyStaggeredGridMeasureContext2.getAfterContentPadding();
        if (lazyStaggeredGridMeasureContext2.getIsVertical()) {
            m6359constrainWidthK40F9xA = Constraints.m6345getMaxWidthimpl(lazyStaggeredGridMeasureContext2.getConstraints());
        } else {
            m6359constrainWidthK40F9xA = ConstraintsKt.m6359constrainWidthK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), ArraysKt.maxOrThrow(iArr13) + beforeContentPadding);
        }
        int i65 = m6359constrainWidthK40F9xA;
        if (lazyStaggeredGridMeasureContext2.getIsVertical()) {
            m6344getMaxHeightimpl = ConstraintsKt.m6358constrainHeightK40F9xA(lazyStaggeredGridMeasureContext2.getConstraints(), ArraysKt.maxOrThrow(iArr13) + beforeContentPadding);
        } else {
            m6344getMaxHeightimpl = Constraints.m6344getMaxHeightimpl(lazyStaggeredGridMeasureContext2.getConstraints());
        }
        int i66 = m6344getMaxHeightimpl;
        int min = (Math.min(lazyStaggeredGridMeasureContext2.getIsVertical() ? i66 : i65, lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) - lazyStaggeredGridMeasureContext2.getBeforeContentPadding()) + lazyStaggeredGridMeasureContext2.getAfterContentPadding();
        int i67 = copyOf4[0];
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int size2 = pinnedItems.size() - 1;
        if (size2 >= 0) {
            int i68 = size2;
            int i69 = i67;
            list2 = list;
            while (true) {
                int i70 = i68 - 1;
                int intValue = pinnedItems.get(i68).intValue();
                int lane = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(intValue);
                if (lane == -2 || lane == -1) {
                    for (int i71 : iArr4) {
                        if (!(i71 > intValue)) {
                            z7 = false;
                            break;
                        }
                    }
                    z7 = true;
                }
                if (z7) {
                    List list5 = list2;
                    long m1076getSpanRangelOCCd4c4 = lazyStaggeredGridMeasureContext2.m1076getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), intValue, 0);
                    ArrayList arrayList = list5 == null ? new ArrayList() : list5;
                    LazyStaggeredGridMeasuredItem m1084getAndMeasurejy6DScQ4 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1084getAndMeasurejy6DScQ(intValue, m1076getSpanRangelOCCd4c4);
                    i69 -= m1084getAndMeasurejy6DScQ4.getSizeWithSpacings();
                    m1084getAndMeasurejy6DScQ4.position(i69, 0, min);
                    arrayList.add(m1084getAndMeasurejy6DScQ4);
                    list2 = arrayList;
                }
                if (i70 < 0) {
                    break;
                }
                i68 = i70;
            }
        } else {
            list2 = null;
        }
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        List<LazyStaggeredGridMeasuredItem> calculateVisibleItems = calculateVisibleItems(lazyStaggeredGridMeasureContext2, arrayDequeArr3, copyOf4, min);
        int i72 = copyOf4[0];
        List<Integer> pinnedItems2 = lazyStaggeredGridMeasureContext2.getPinnedItems();
        int size3 = pinnedItems2.size();
        int i73 = 0;
        ArrayList arrayList2 = null;
        while (i73 < size3) {
            int intValue2 = pinnedItems2.get(i73).intValue();
            int i74 = i8;
            if (intValue2 >= i74) {
                list4 = list2;
                list3 = pinnedItems2;
            } else {
                int lane2 = lazyStaggeredGridMeasureContext2.getLaneInfo().getLane(intValue2);
                list3 = pinnedItems2;
                if (lane2 != -2 && lane2 != -1) {
                    list4 = list2;
                    if (iArr5[lane2] < intValue2) {
                        iArr8 = iArr5;
                    }
                } else {
                    iArr8 = iArr5;
                    int length8 = iArr8.length;
                    list4 = list2;
                    int i75 = 0;
                    while (i75 < length8) {
                        int i76 = i75;
                        if (!(iArr8[i76] < intValue2)) {
                            z6 = false;
                            break;
                        }
                        i75 = i76 + 1;
                    }
                }
                z6 = true;
                if (z6) {
                    i15 = size3;
                    iArr9 = iArr4;
                    i16 = i73;
                } else {
                    iArr9 = iArr4;
                    i16 = i73;
                    long m1076getSpanRangelOCCd4c5 = lazyStaggeredGridMeasureContext2.m1076getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext2.getItemProvider(), intValue2, 0);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    i15 = size3;
                    List list6 = arrayList2;
                    LazyStaggeredGridMeasuredItem m1084getAndMeasurejy6DScQ5 = lazyStaggeredGridMeasureContext2.getMeasuredItemProvider().m1084getAndMeasurejy6DScQ(intValue2, m1076getSpanRangelOCCd4c5);
                    m1084getAndMeasurejy6DScQ5.position(i72, 0, min);
                    i72 += m1084getAndMeasurejy6DScQ5.getSizeWithSpacings();
                    list6.add(m1084getAndMeasurejy6DScQ5);
                    arrayList2 = list6;
                }
                i73 = i16 + 1;
                pinnedItems2 = list3;
                iArr5 = iArr8;
                i8 = i74;
                list2 = list4;
                size3 = i15;
                iArr4 = iArr9;
            }
            iArr8 = iArr5;
            z6 = false;
            if (z6) {
            }
            i73 = i16 + 1;
            pinnedItems2 = list3;
            iArr5 = iArr8;
            i8 = i74;
            list2 = list4;
            size3 = i15;
            iArr4 = iArr9;
        }
        List list7 = list2;
        int[] iArr23 = iArr4;
        int i77 = i8;
        int[] iArr24 = iArr5;
        if (arrayList2 == null) {
            arrayList2 = CollectionsKt.emptyList();
        }
        final ArrayList arrayList3 = new ArrayList();
        arrayList3.addAll(list7);
        arrayList3.addAll(calculateVisibleItems);
        arrayList3.addAll(arrayList2);
        lazyStaggeredGridMeasureContext2.getState().getPlacementAnimator().onMeasured((int) scrollToBeConsumed, i65, i66, arrayList3, lazyStaggeredGridMeasureContext2.getMeasuredItemProvider(), lazyStaggeredGridMeasureContext2.getIsVertical(), lazyStaggeredGridMeasureContext2.getLaneCount(), lazyStaggeredGridMeasureContext2.getCoroutineScope());
        int i78 = 0;
        while (true) {
            if (i78 >= length4) {
                z3 = false;
                break;
            }
            if (iArr13[i78] > lazyStaggeredGridMeasureContext2.getMainAxisAvailableSize()) {
                z3 = true;
                break;
            }
            i78++;
        }
        if (!z3) {
            int length9 = iArr24.length;
            int i79 = 0;
            while (true) {
                if (i79 >= length9) {
                    z5 = true;
                    break;
                }
                if (!(iArr24[i79] < i77 + (-1))) {
                    z5 = false;
                    break;
                }
                i79++;
            }
            if (!z5) {
                z4 = false;
                return new LazyStaggeredGridMeasureResult(iArr23, iArr3, scrollToBeConsumed, MeasureScope.layout$default(measureScope, i65, i66, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$29
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
                        List<LazyStaggeredGridMeasuredItem> list8 = arrayList3;
                        LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = lazyStaggeredGridMeasureContext2;
                        int size4 = list8.size();
                        for (int i80 = 0; i80 < size4; i80++) {
                            list8.get(i80).place(placementScope, lazyStaggeredGridMeasureContext3);
                        }
                        ObservableScopeInvalidator.m1047attachToScopeimpl(lazyStaggeredGridMeasureContext2.getState().m1087getPlacementScopeInvalidatorzYiylxw$foundation_release());
                    }
                }, 4, null), z4, lazyStaggeredGridMeasureContext2.getIsVertical(), z13, i77, calculateVisibleItems, IntSizeKt.IntSize(i65, i66), i34, i7, lazyStaggeredGridMeasureContext2.getBeforeContentPadding(), lazyStaggeredGridMeasureContext2.getAfterContentPadding(), lazyStaggeredGridMeasureContext2.getMainAxisSpacing(), null);
            }
        }
        z4 = true;
        return new LazyStaggeredGridMeasureResult(iArr23, iArr3, scrollToBeConsumed, MeasureScope.layout$default(measureScope, i65, i66, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureKt$measure$1$29
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
                List<LazyStaggeredGridMeasuredItem> list8 = arrayList3;
                LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext3 = lazyStaggeredGridMeasureContext2;
                int size4 = list8.size();
                for (int i80 = 0; i80 < size4; i80++) {
                    list8.get(i80).place(placementScope, lazyStaggeredGridMeasureContext3);
                }
                ObservableScopeInvalidator.m1047attachToScopeimpl(lazyStaggeredGridMeasureContext2.getState().m1087getPlacementScopeInvalidatorzYiylxw$foundation_release());
            }
        }, 4, null), z4, lazyStaggeredGridMeasureContext2.getIsVertical(), z13, i77, calculateVisibleItems, IntSizeKt.IntSize(i65, i66), i34, i7, lazyStaggeredGridMeasureContext2.getBeforeContentPadding(), lazyStaggeredGridMeasureContext2.getAfterContentPadding(), lazyStaggeredGridMeasureContext2.getMainAxisSpacing(), null);
    }

    private static final boolean measure$lambda$38$hasSpaceBeforeFirst(int[] iArr, int[] iArr2, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            if (iArr2[i] < Math.max(-lazyStaggeredGridMeasureContext.getMainAxisSpacing(), 0) && i2 > 0) {
                return true;
            }
        }
        return false;
    }

    private static final boolean measure$lambda$38$misalignedStart(int[] iArr, LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr2, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i2], i2) == -1 && iArr2[i2] != iArr2[i]) {
                return true;
            }
        }
        int length2 = iArr.length;
        for (int i3 = 0; i3 < length2; i3++) {
            if (findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[i3], i3) != -1 && iArr2[i3] >= iArr2[i]) {
                return true;
            }
        }
        int lane = lazyStaggeredGridMeasureContext.getLaneInfo().getLane(0);
        return (lane == 0 || lane == -1 || lane == -2) ? false : true;
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateVisibleItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, ArrayDeque<LazyStaggeredGridMeasuredItem>[] arrayDequeArr, int[] iArr, int i) {
        int i2 = 0;
        for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque : arrayDequeArr) {
            i2 += arrayDeque.size();
        }
        ArrayList arrayList = new ArrayList(i2);
        while (true) {
            for (ArrayDeque<LazyStaggeredGridMeasuredItem> arrayDeque2 : arrayDequeArr) {
                if (!arrayDeque2.isEmpty()) {
                    int length = arrayDequeArr.length;
                    int i3 = -1;
                    int i4 = Integer.MAX_VALUE;
                    for (int i5 = 0; i5 < length; i5++) {
                        LazyStaggeredGridMeasuredItem firstOrNull = arrayDequeArr[i5].firstOrNull();
                        int index = firstOrNull != null ? firstOrNull.getIndex() : Integer.MAX_VALUE;
                        if (i4 > index) {
                            i3 = i5;
                            i4 = index;
                        }
                    }
                    LazyStaggeredGridMeasuredItem removeFirst = arrayDequeArr[i3].removeFirst();
                    if (removeFirst.getLane() == i3) {
                        long m1089constructorimpl = SpanRange.m1089constructorimpl(removeFirst.getLane(), removeFirst.getSpan());
                        int m1079maxInRangejy6DScQ = m1079maxInRangejy6DScQ(iArr, m1089constructorimpl);
                        int i6 = lazyStaggeredGridMeasureContext.getResolvedSlots().getPositions()[i3];
                        if (removeFirst.getPlaceablesCount() != 0) {
                            removeFirst.position(m1079maxInRangejy6DScQ, i6, i);
                            arrayList.add(removeFirst);
                            int i7 = (int) (m1089constructorimpl & 4294967295L);
                            for (int i8 = (int) (m1089constructorimpl >> 32); i8 < i7; i8++) {
                                iArr[i8] = removeFirst.getSizeWithSpacings() + m1079maxInRangejy6DScQ;
                            }
                        }
                    }
                }
            }
            return arrayList;
        }
    }

    private static final List<LazyStaggeredGridMeasuredItem> calculateExtraItems(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, Function1<? super LazyStaggeredGridMeasuredItem, Unit> function1, Function1<? super Integer, Boolean> function12, boolean z) {
        List<Integer> pinnedItems = lazyStaggeredGridMeasureContext.getPinnedItems();
        ArrayList arrayList = null;
        if (z) {
            int size = pinnedItems.size() - 1;
            if (size >= 0) {
                while (true) {
                    int i = size - 1;
                    int intValue = pinnedItems.get(size).intValue();
                    if (function12.invoke(Integer.valueOf(intValue)).booleanValue()) {
                        long m1076getSpanRangelOCCd4c = lazyStaggeredGridMeasureContext.m1076getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue, 0);
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        LazyStaggeredGridMeasuredItem m1084getAndMeasurejy6DScQ = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1084getAndMeasurejy6DScQ(intValue, m1076getSpanRangelOCCd4c);
                        function1.invoke(m1084getAndMeasurejy6DScQ);
                        arrayList.add(m1084getAndMeasurejy6DScQ);
                    }
                    if (i < 0) {
                        break;
                    }
                    size = i;
                }
            }
        } else {
            int size2 = pinnedItems.size();
            for (int i2 = 0; i2 < size2; i2++) {
                int intValue2 = pinnedItems.get(i2).intValue();
                if (function12.invoke(Integer.valueOf(intValue2)).booleanValue()) {
                    long m1076getSpanRangelOCCd4c2 = lazyStaggeredGridMeasureContext.m1076getSpanRangelOCCd4c(lazyStaggeredGridMeasureContext.getItemProvider(), intValue2, 0);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyStaggeredGridMeasuredItem m1084getAndMeasurejy6DScQ2 = lazyStaggeredGridMeasureContext.getMeasuredItemProvider().m1084getAndMeasurejy6DScQ(intValue2, m1076getSpanRangelOCCd4c2);
                    function1.invoke(m1084getAndMeasurejy6DScQ2);
                    arrayList.add(m1084getAndMeasurejy6DScQ2);
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* renamed from: forEach-nIS5qE8, reason: not valid java name */
    private static final void m1078forEachnIS5qE8(long j, Function1<? super Integer, Unit> function1) {
        int i = (int) (j & 4294967295L);
        for (int i2 = (int) (j >> 32); i2 < i; i2++) {
            function1.invoke(Integer.valueOf(i2));
        }
    }

    private static final void offsetBy(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
    }

    /* renamed from: maxInRange-jy6DScQ, reason: not valid java name */
    private static final int m1079maxInRangejy6DScQ(int[] iArr, long j) {
        int i = (int) (j & 4294967295L);
        int i2 = Integer.MIN_VALUE;
        for (int i3 = (int) (j >> 32); i3 < i; i3++) {
            i2 = Math.max(i2, iArr[i3]);
        }
        return i2;
    }

    public static /* synthetic */ int indexOfMinValue$default(int[] iArr, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = Integer.MIN_VALUE;
        }
        return indexOfMinValue(iArr, i);
    }

    public static final int indexOfMinValue(int[] iArr, int i) {
        int length = iArr.length;
        int i2 = -1;
        int i3 = Integer.MAX_VALUE;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = i + 1;
            int i6 = iArr[i4];
            if (i5 <= i6 && i6 < i3) {
                i2 = i4;
                i3 = i6;
            }
        }
        return i2;
    }

    private static final <T> int indexOfMinBy(T[] tArr, Function1<? super T, Integer> function1) {
        int length = tArr.length;
        int i = -1;
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int intValue = function1.invoke(tArr[i3]).intValue();
            if (i2 > intValue) {
                i = i3;
                i2 = intValue;
            }
        }
        return i;
    }

    private static final int indexOfMaxValue(int[] iArr) {
        int length = iArr.length;
        int i = -1;
        int i2 = Integer.MIN_VALUE;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i2 < i4) {
                i = i3;
                i2 = i4;
            }
        }
        return i;
    }

    private static final int[] transform(int[] iArr, Function1<? super Integer, Integer> function1) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            iArr[i] = function1.invoke(Integer.valueOf(iArr[i])).intValue();
        }
        return iArr;
    }

    private static final void ensureIndicesInRange(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int[] iArr, int i) {
        int length = iArr.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i2 = length - 1;
            while (true) {
                if (iArr[length] < i && lazyStaggeredGridMeasureContext.getLaneInfo().assignedToLane(iArr[length], length)) {
                    break;
                } else {
                    iArr[length] = findPreviousItemIndex(lazyStaggeredGridMeasureContext, iArr[length], length);
                }
            }
            if (iArr[length] >= 0 && !lazyStaggeredGridMeasureContext.isFullSpan(lazyStaggeredGridMeasureContext.getItemProvider(), iArr[length])) {
                lazyStaggeredGridMeasureContext.getLaneInfo().setLane(iArr[length], length);
            }
            if (i2 < 0) {
                return;
            } else {
                length = i2;
            }
        }
    }

    private static final int findPreviousItemIndex(LazyStaggeredGridMeasureContext lazyStaggeredGridMeasureContext, int i, int i2) {
        return lazyStaggeredGridMeasureContext.getLaneInfo().findPreviousItemIndex(i, i2);
    }

    private static final <T> void fastForEach(List<? extends T> list, boolean z, Function1<? super T, Unit> function1) {
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i = size - 1;
                function1.invoke(list.get(size));
                if (i < 0) {
                    return;
                } else {
                    size = i;
                }
            }
        } else {
            int size2 = list.size();
            for (int i2 = 0; i2 < size2; i2++) {
                function1.invoke(list.get(i2));
            }
        }
    }

    static /* synthetic */ void fastForEach$default(List list, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        if (z) {
            int size = list.size() - 1;
            if (size < 0) {
                return;
            }
            while (true) {
                int i2 = size - 1;
                function1.invoke(list.get(size));
                if (i2 < 0) {
                    return;
                } else {
                    size = i2;
                }
            }
        } else {
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                function1.invoke(list.get(i3));
            }
        }
    }
}
