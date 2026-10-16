package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterMapKt;
import androidx.collection.ScatterSetKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import com.ironsource.C3040d4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyStaggeredGridItemPlacementAnimator.kt */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0004J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\tH\u0002JL\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00132\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)J\u0006\u0010*\u001a\u00020\u001bJ\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006,"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/staggeredgrid/ItemInfo;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasuredItem;)Z", "getAnimation", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", C3040d4.h.W, "placeableIndex", "initializeAnimation", "", "item", "mainAxisOffset", "itemInfo", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "isVertical", "laneCount", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "reset", "startAnimationsIfNeeded", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridItemPlacementAnimator {
    public static final int $stable = 8;
    private int firstVisibleIndex;
    private final MutableScatterMap<Object, ItemInfo> keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
    private final MutableScatterSet<Object> movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyStaggeredGridMeasuredItem> movingAwayToEndBound = new ArrayList();

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ void initializeAnimation$default(LazyStaggeredGridItemPlacementAnimator lazyStaggeredGridItemPlacementAnimator, LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            ItemInfo itemInfo2 = lazyStaggeredGridItemPlacementAnimator.keyToItemInfoMap.get(lazyStaggeredGridMeasuredItem.getKey());
            Intrinsics.checkNotNull(itemInfo2);
            itemInfo = itemInfo2;
        }
        lazyStaggeredGridItemPlacementAnimator.initializeAnimation(lazyStaggeredGridMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(LazyStaggeredGridMeasuredItem item, int mainAxisOffset, ItemInfo itemInfo) {
        long m6513copyiSbpLlY$default;
        long offset = item.getOffset();
        if (item.getIsVertical()) {
            m6513copyiSbpLlY$default = IntOffset.m6513copyiSbpLlY$default(offset, 0, mainAxisOffset, 1, null);
        } else {
            m6513copyiSbpLlY$default = IntOffset.m6513copyiSbpLlY$default(offset, mainAxisOffset, 0, 2, null);
        }
        for (LazyLayoutAnimation lazyLayoutAnimation : itemInfo.getAnimations()) {
            if (lazyLayoutAnimation != null) {
                long offset2 = item.getOffset();
                long IntOffset = IntOffsetKt.IntOffset(IntOffset.m6517getXimpl(offset2) - IntOffset.m6517getXimpl(offset), IntOffset.m6518getYimpl(offset2) - IntOffset.m6518getYimpl(offset));
                lazyLayoutAnimation.m1032setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m6517getXimpl(m6513copyiSbpLlY$default) + IntOffset.m6517getXimpl(IntOffset), IntOffset.m6518getYimpl(m6513copyiSbpLlY$default) + IntOffset.m6518getYimpl(IntOffset)));
            }
        }
    }

    private final void startAnimationsIfNeeded(LazyStaggeredGridMeasuredItem item) {
        ItemInfo itemInfo = this.keyToItemInfoMap.get(item.getKey());
        Intrinsics.checkNotNull(itemInfo);
        for (LazyLayoutAnimation lazyLayoutAnimation : itemInfo.getAnimations()) {
            if (lazyLayoutAnimation != null) {
                long offset = item.getOffset();
                long rawOffset = lazyLayoutAnimation.getRawOffset();
                if (!IntOffset.m6516equalsimpl0(rawOffset, LazyLayoutAnimation.INSTANCE.m1033getNotInitializednOccac()) && !IntOffset.m6516equalsimpl0(rawOffset, offset)) {
                    lazyLayoutAnimation.m1027animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m6517getXimpl(offset) - IntOffset.m6517getXimpl(rawOffset), IntOffset.m6518getYimpl(offset) - IntOffset.m6518getYimpl(rawOffset)));
                }
                lazyLayoutAnimation.m1032setRawOffsetgyyYBs(offset);
            }
        }
    }

    public final LazyLayoutAnimation getAnimation(Object key, int placeableIndex) {
        ItemInfo itemInfo;
        LazyLayoutAnimation[] animations;
        if (this.keyToItemInfoMap.isEmpty() || (itemInfo = this.keyToItemInfoMap.get(key)) == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[placeableIndex];
    }

    private final boolean getHasAnimations(LazyStaggeredGridMeasuredItem lazyStaggeredGridMeasuredItem) {
        LazyLayoutAnimationSpecsNode specs;
        int placeablesCount = lazyStaggeredGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            specs = LazyStaggeredGridItemPlacementAnimatorKt.getSpecs(lazyStaggeredGridMeasuredItem.getParentData(i));
            if (specs != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x029d, code lost:
    
        if (r3 < 0) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x029f, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02a1, code lost:
    
        r11 = r1[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x02ab, code lost:
    
        if (((((~r11) << 7) & r11) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x02ad, code lost:
    
        r5 = 8 - ((~(r4 - r3)) >>> 31);
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x02b8, code lost:
    
        if (r8 >= r5) goto L171;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02be, code lost:
    
        if ((r11 & r20) >= r33) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x02c0, code lost:
    
        r14 = r2[(r4 << 3) + r8];
        r15 = r32.keyToItemInfoMap.get(r14);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r15);
        r15 = r15;
        r10 = r32.keyIndexMap.getIndex(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x02d6, code lost:
    
        if (r10 != r7) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
    
        r32.firstVisibleIndex = r4;
        r8 = r32.keyIndexMap;
        r32.keyIndexMap = r37.getKeyIndexMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02d8, code lost:
    
        r32.keyToItemInfoMap.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x02de, code lost:
    
        r23 = r1;
        r24 = r2;
        r1 = r37.m1084getAndMeasurejy6DScQ(r10, androidx.compose.foundation.lazy.staggeredgrid.SpanRange.m1089constructorimpl(r15.getLane(), r15.getSpan()));
        r1.setNonScrollableItem(true);
        r15 = r15.getAnimations();
        r2 = r15.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02ff, code lost:
    
        if (r7 >= r2) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0301, code lost:
    
        r25 = r15[r7];
        r27 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0305, code lost:
    
        if (r25 == null) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0307, code lost:
    
        r2 = r25.isPlacementAnimationInProgress();
        r25 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x030e, code lost:
    
        if (r2 != true) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0326, code lost:
    
        if (r10 >= r32.firstVisibleIndex) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
    
        if (r38 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0328, code lost:
    
        r32.movingAwayToStartBound.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0338, code lost:
    
        r11 = r11 >> 8;
        r8 = r8 + 1;
        r1 = r23;
        r2 = r24;
        r7 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x032e, code lost:
    
        r32.movingAwayToEndBound.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0313, code lost:
    
        r7 = r25 + 1;
        r2 = r27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0311, code lost:
    
        r25 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        r9 = r35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x031c, code lost:
    
        if (r10 != r13.getIndex(r14)) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x031e, code lost:
    
        r32.keyToItemInfoMap.remove(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0334, code lost:
    
        r23 = r1;
        r24 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0345, code lost:
    
        r23 = r1;
        r24 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x034b, code lost:
    
        if (r5 != 8) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0354, code lost:
    
        if (r4 == r3) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
    
        if (r38 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0356, code lost:
    
        r4 = r4 + 1;
        r1 = r23;
        r2 = r24;
        r7 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x034e, code lost:
    
        r23 = r1;
        r24 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0368, code lost:
    
        if (r32.movingAwayToStartBound.isEmpty() != false) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x036a, code lost:
    
        r1 = r32.movingAwayToStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0371, code lost:
    
        if (r1.size() <= 1) goto L137;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0373, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2(r32));
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x037d, code lost:
    
        r1 = r32.movingAwayToStartBound;
        r2 = r1.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r4 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(0, r33);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0385, code lost:
    
        if (r3 >= r2) goto L180;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0387, code lost:
    
        r4 = r1.get(r3);
        r5 = r4.getLane();
        r26[r5] = r26[r5] + r4.getMainAxisSize();
        r7 = 0 - r26[r4.getLane()];
        r5 = r32.keyToItemInfoMap.get(r4.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r4.position(r7, r5.getCrossAxisOffset(), r9);
        r36.add(r4);
        startAnimationsIfNeeded(r4);
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x03c1, code lost:
    
        kotlin.collections.ArraysKt.fill$default(r26, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x03d6, code lost:
    
        if (r32.movingAwayToEndBound.isEmpty() != false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x03d8, code lost:
    
        r1 = r32.movingAwayToEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x03df, code lost:
    
        if (r1.size() <= 1) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x03e1, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2(r32));
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x03eb, code lost:
    
        r1 = r32.movingAwayToEndBound;
        r2 = r1.size();
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        r1 = r32.keyToItemInfoMap;
        r10 = r1.keys;
        r1 = r1.metadata;
        r11 = r1.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x03f3, code lost:
    
        if (r7 >= r2) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x03f5, code lost:
    
        r3 = r1.get(r7);
        r4 = r26[r3.getLane()] + r9;
        r5 = r3.getLane();
        r26[r5] = r26[r5] + r3.getMainAxisSize();
        r5 = r32.keyToItemInfoMap.get(r3.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
        r3.position(r4, r5.getCrossAxisOffset(), r9);
        r36.add(r3);
        startAnimationsIfNeeded(r3);
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x042e, code lost:
    
        r32.movingInFromStartBound.clear();
        r32.movingInFromEndBound.clear();
        r32.movingAwayToStartBound.clear();
        r32.movingAwayToEndBound.clear();
        r32.movingAwayKeys.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0447, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0237, code lost:
    
        r26 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x00ba, code lost:
    
        r23 = r1;
        r24 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x00c8, code lost:
    
        r24 = r4;
        r13 = r8;
        r33 = 128;
        r20 = 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006c, code lost:
    
        if (r11 < 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0054, code lost:
    
        r4 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r33, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x004b, code lost:
    
        r9 = r34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x003b, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006e, code lost:
    
        r12 = 0;
        r33 = 128;
        r20 = 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0074, code lost:
    
        r14 = r1[r12];
        r13 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0081, code lost:
    
        if (((((~r14) << 7) & r14) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0083, code lost:
    
        r7 = 8 - ((~(r12 - r11)) >>> 31);
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008c, code lost:
    
        if (r8 >= r7) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0092, code lost:
    
        if ((r14 & 255) >= 128) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0094, code lost:
    
        r23 = r1;
        r24 = r4;
        r32.movingAwayKeys.add(r10[(r12 << 3) + r8]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a8, code lost:
    
        r14 = r14 >> 8;
        r8 = r8 + 1;
        r1 = r23;
        r4 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a4, code lost:
    
        r23 = r1;
        r24 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00b1, code lost:
    
        r23 = r1;
        r24 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b7, code lost:
    
        if (r7 != 8) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00be, code lost:
    
        if (r12 == r11) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c0, code lost:
    
        r12 = r12 + 1;
        r8 = r13;
        r1 = r23;
        r4 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cf, code lost:
    
        r1 = r36.size();
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d5, code lost:
    
        r7 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d6, code lost:
    
        if (r4 >= r1) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d8, code lost:
    
        r5 = r36.get(r4);
        r32.movingAwayKeys.remove(r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00eb, code lost:
    
        if (getHasAnimations(r5) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ed, code lost:
    
        r8 = r32.keyToItemInfoMap.get(r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f9, code lost:
    
        if (r8 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fb, code lost:
    
        r8 = new androidx.compose.foundation.lazy.staggeredgrid.ItemInfo(r5.getLane(), r5.getSpan(), r5.getCrossAxisOffset());
        r8.updateAnimation(r5, r40);
        r32.keyToItemInfoMap.set(r5.getKey(), r8);
        r11 = r13.getIndex(r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0122, code lost:
    
        if (r11 == (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0128, code lost:
    
        if (r5.getIndex() == r11) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x012a, code lost:
    
        if (r11 >= r3) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x012c, code lost:
    
        r32.movingInFromStartBound.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x014e, code lost:
    
        r15 = r3;
        r22 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01c9, code lost:
    
        r4 = r22 + 1;
        r3 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0132, code lost:
    
        r32.movingInFromEndBound.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0138, code lost:
    
        r11 = r5.mo1069getOffsetnOccac();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0140, code lost:
    
        if (r5.isVertical() == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0142, code lost:
    
        r7 = androidx.compose.ui.unit.IntOffset.m6518getYimpl(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x014b, code lost:
    
        initializeAnimation(r5, r7, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0147, code lost:
    
        r7 = androidx.compose.ui.unit.IntOffset.m6517getXimpl(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0153, code lost:
    
        r7 = r8.getAnimations();
        r11 = r7.length;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x015c, code lost:
    
        if (r12 >= r11) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x015e, code lost:
    
        r14 = r7[r12];
        r15 = r3;
        r22 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0163, code lost:
    
        if (r14 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0165, code lost:
    
        r38 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0175, code lost:
    
        if (androidx.compose.ui.unit.IntOffset.m6516equalsimpl0(r14.getRawOffset(), androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.INSTANCE.m1033getNotInitializednOccac()) != false) goto L164;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0177, code lost:
    
        r3 = r14.getRawOffset();
        r14.m1032setRawOffsetgyyYBs(androidx.compose.ui.unit.IntOffsetKt.IntOffset(androidx.compose.ui.unit.IntOffset.m6517getXimpl(r3) + androidx.compose.ui.unit.IntOffset.m6517getXimpl(r24), androidx.compose.ui.unit.IntOffset.m6518getYimpl(r3) + androidx.compose.ui.unit.IntOffset.m6518getYimpl(r24)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0197, code lost:
    
        r12 = r12 + 1;
        r11 = r38;
        r3 = r15;
        r4 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0195, code lost:
    
        r38 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01a1, code lost:
    
        r15 = r3;
        r22 = r4;
        r8.setLane(r5.getLane());
        r8.setSpan(r5.getSpan());
        r8.setCrossAxisOffset(r5.getCrossAxisOffset());
        startAnimationsIfNeeded(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01bd, code lost:
    
        r15 = r3;
        r22 = r4;
        r32.keyToItemInfoMap.remove(r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01ce, code lost:
    
        r8 = new int[r39];
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01d2, code lost:
    
        if (r1 >= r39) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01d4, code lost:
    
        r8[r1] = 0;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        r3 = r32.firstVisibleIndex;
        r4 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasuredItem) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) r36);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01e2, code lost:
    
        if (r32.movingInFromStartBound.isEmpty() != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01e4, code lost:
    
        r1 = r32.movingInFromStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ea, code lost:
    
        if (r1.size() <= 1) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01ec, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01f6, code lost:
    
        r11 = r32.movingInFromStartBound;
        r12 = r11.size();
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01fe, code lost:
    
        if (r14 >= r12) goto L167;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0200, code lost:
    
        r1 = r11.get(r14);
        r2 = r1.getLane();
        r8[r2] = r8[r2] + r1.getMainAxisSize();
        initializeAnimation$default(r32, r1, 0 - r8[r1.getLane()], null, 4, null);
        startAnimationsIfNeeded(r1);
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0227, code lost:
    
        r26 = r8;
        kotlin.collections.ArraysKt.fill$default(r26, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (r4 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0241, code lost:
    
        if (r32.movingInFromEndBound.isEmpty() != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0243, code lost:
    
        r1 = r32.movingInFromEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0249, code lost:
    
        if (r1.size() <= 1) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x024b, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0255, code lost:
    
        r8 = r32.movingInFromEndBound;
        r11 = r8.size();
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x025d, code lost:
    
        if (r12 >= r11) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x025f, code lost:
    
        r1 = r8.get(r12);
        r2 = r26[r1.getLane()] + r9;
        r3 = r1.getLane();
        r26[r3] = r26[r3] + r1.getMainAxisSize();
        initializeAnimation$default(r32, r1, r2, null, 4, null);
        startAnimationsIfNeeded(r1);
        r12 = r12 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0285, code lost:
    
        kotlin.collections.ArraysKt.fill$default(r26, 0, 0, 0, 6, (java.lang.Object) null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0292, code lost:
    
        r1 = r32.movingAwayKeys;
        r2 = r1.elements;
        r1 = r1.metadata;
        r3 = r1.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        r4 = r4.getIndex();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<LazyStaggeredGridMeasuredItem> positionedItems, LazyStaggeredGridMeasureProvider itemProvider, boolean isVertical, int laneCount, CoroutineScope coroutineScope) {
        int size = positionedItems.size();
        int i = 0;
        while (true) {
            if (i < size) {
                if (getHasAnimations(positionedItems.get(i))) {
                    break;
                } else {
                    i++;
                }
            } else if (this.keyToItemInfoMap.isEmpty()) {
                reset();
                return;
            }
        }
    }
}
