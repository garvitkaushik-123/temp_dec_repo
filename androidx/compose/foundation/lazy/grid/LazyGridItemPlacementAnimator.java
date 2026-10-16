package androidx.compose.foundation.lazy.grid;

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

/* compiled from: LazyGridItemPlacementAnimator.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0004J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00042\b\b\u0002\u0010\u001e\u001a\u00020\tH\u0002JL\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020*J\u0006\u0010+\u001a\u00020\u001bJ\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\u00020\u0013*\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006-"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "movingAwayKeys", "Landroidx/collection/MutableScatterSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;)Z", "getAnimation", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", C3040d4.h.W, "placeableIndex", "initializeAnimation", "", "item", "mainAxisOffset", "itemInfo", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "spanLayoutProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridSpanLayoutProvider;", "isVertical", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "reset", "startAnimationsIfNeeded", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridItemPlacementAnimator {
    public static final int $stable = 8;
    private int firstVisibleIndex;
    private final MutableScatterMap<Object, ItemInfo> keyToItemInfoMap = ScatterMapKt.mutableScatterMapOf();
    private LazyLayoutKeyIndexMap keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
    private final MutableScatterSet<Object> movingAwayKeys = ScatterSetKt.mutableScatterSetOf();
    private final List<LazyGridMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyGridMeasuredItem> movingAwayToEndBound = new ArrayList();

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ void initializeAnimation$default(LazyGridItemPlacementAnimator lazyGridItemPlacementAnimator, LazyGridMeasuredItem lazyGridMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            ItemInfo itemInfo2 = lazyGridItemPlacementAnimator.keyToItemInfoMap.get(lazyGridMeasuredItem.getKey());
            Intrinsics.checkNotNull(itemInfo2);
            itemInfo = itemInfo2;
        }
        lazyGridItemPlacementAnimator.initializeAnimation(lazyGridMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(LazyGridMeasuredItem item, int mainAxisOffset, ItemInfo itemInfo) {
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

    private final void startAnimationsIfNeeded(LazyGridMeasuredItem item) {
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

    private final boolean getHasAnimations(LazyGridMeasuredItem lazyGridMeasuredItem) {
        LazyLayoutAnimationSpecsNode specs;
        int placeablesCount = lazyGridMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            specs = LazyGridItemPlacementAnimatorKt.getSpecs(lazyGridMeasuredItem.getParentData(i));
            if (specs != null) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0252, code lost:
    
        if (r5 == (-1)) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0254, code lost:
    
        if (r5 != r1) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0256, code lost:
    
        r15 = r1;
        r24 = java.lang.Math.max(r2, r4.getMainAxisSize());
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x026a, code lost:
    
        r25 = r3;
        initializeAnimation$default(r41, r4, r10 + r25, null, 4, null);
        startAnimationsIfNeeded(r4);
        r14 = r14 + 1;
        r1 = r15;
        r2 = r24;
        r3 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0262, code lost:
    
        r3 = r3 + r2;
        r24 = r4.getMainAxisSize();
        r15 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x024e, code lost:
    
        r5 = r4.getColumn();
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0280, code lost:
    
        r1 = r41.movingAwayKeys;
        r2 = r1.elements;
        r1 = r1.metadata;
        r3 = r1.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
    
        r41.firstVisibleIndex = r3;
        r9 = r41.keyIndexMap;
        r41.keyIndexMap = r46.getKeyIndexMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x028b, code lost:
    
        if (r3 < 0) goto L142;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x028d, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x028e, code lost:
    
        r11 = r1[r4];
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0298, code lost:
    
        if (((((~r11) << 7) & r11) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L139;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x029a, code lost:
    
        r5 = 8 - ((~(r4 - r3)) >>> 31);
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02a4, code lost:
    
        if (r14 >= r5) goto L189;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x02aa, code lost:
    
        if ((r11 & r22) >= r20) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x02ac, code lost:
    
        r15 = r2[(r4 << 3) + r14];
        r9 = r41.keyToItemInfoMap.get(r15);
        kotlin.jvm.internal.Intrinsics.checkNotNull(r9);
        r9 = r9;
        r24 = r1;
        r1 = r41.keyIndexMap.getIndex(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x02c4, code lost:
    
        if (r1 != r8) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0046, code lost:
    
        if (r48 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x02c6, code lost:
    
        r41.keyToItemInfoMap.remove(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x033d, code lost:
    
        r25 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x033f, code lost:
    
        r11 = r11 >> 8;
        r14 = r14 + 1;
        r1 = r24;
        r2 = r25;
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x02cd, code lost:
    
        if (r48 == false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x02cf, code lost:
    
        r26 = r1;
        r27 = androidx.compose.ui.unit.Constraints.INSTANCE.m6355fixedWidthOenEA2s(r9.getCrossAxisSize());
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x02e8, code lost:
    
        r1 = androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider.m1020getAndMeasure3p2s80s$default(r46, r26, 0, r27, 2, null);
        r25 = r2;
        r8 = r26;
        r1.setNonScrollableItem(true);
        r9 = r9.getAnimations();
        r2 = r9.length;
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0306, code lost:
    
        if (r9 >= r2) goto L195;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0308, code lost:
    
        r27 = r9[r9];
        r28 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x030c, code lost:
    
        if (r27 == null) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        r10 = r44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x030e, code lost:
    
        r2 = r27.isPlacementAnimationInProgress();
        r27 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x0315, code lost:
    
        if (r2 != true) goto L197;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x032d, code lost:
    
        if (r8 >= r41.firstVisibleIndex) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x032f, code lost:
    
        r41.movingAwayToStartBound.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0335, code lost:
    
        r41.movingAwayToEndBound.add(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004d, code lost:
    
        if (r48 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x031a, code lost:
    
        r9 = r27 + 1;
        r2 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x0318, code lost:
    
        r27 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0323, code lost:
    
        if (r8 != r13.getIndex(r15)) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0325, code lost:
    
        r41.keyToItemInfoMap.remove(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02dc, code lost:
    
        r26 = r1;
        r27 = androidx.compose.ui.unit.Constraints.INSTANCE.m6354fixedHeightOenEA2s(r9.getCrossAxisSize());
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x033b, code lost:
    
        r24 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x004f, code lost:
    
        r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(0, r42);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x034c, code lost:
    
        r24 = r1;
        r25 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0352, code lost:
    
        if (r5 != 8) goto L187;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x035b, code lost:
    
        if (r4 == r3) goto L188;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x035d, code lost:
    
        r4 = r4 + 1;
        r1 = r24;
        r2 = r25;
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0355, code lost:
    
        r24 = r1;
        r25 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0367, code lost:
    
        r1 = r41.movingAwayToStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x036e, code lost:
    
        if (r1.size() <= 1) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0058, code lost:
    
        r1 = r41.keyToItemInfoMap;
        r5 = r1.keys;
        r1 = r1.metadata;
        r11 = r1.length - 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0370, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$2(r41));
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x037a, code lost:
    
        r1 = r41.movingAwayToStartBound;
        r2 = r1.size();
        r3 = 0;
        r4 = -1;
        r5 = 0;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0384, code lost:
    
        if (r3 >= r2) goto L198;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0386, code lost:
    
        r20 = r1.get(r3);
        r9 = r47.getLineIndexOfItem(r20.getIndex());
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0397, code lost:
    
        if (r9 == (-1)) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0399, code lost:
    
        if (r9 != r4) goto L151;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x039b, code lost:
    
        r5 = java.lang.Math.max(r5, r20.getMainAxisSize());
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x03ab, code lost:
    
        r21 = (0 - r8) - r20.getMainAxisSize();
        r9 = r41.keyToItemInfoMap.get(r20.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r9);
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem.position$default(r20, r21, r9.getCrossAxisOffset(), r43, r44, 0, 0, 48, null);
        r45.add(r20);
        startAnimationsIfNeeded(r20);
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x03a4, code lost:
    
        r8 = r8 + r5;
        r5 = r20.getMainAxisSize();
        r4 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (r11 < 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03e0, code lost:
    
        r1 = r41.movingAwayToEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x03e7, code lost:
    
        if (r1.size() <= 1) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x03e9, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$2(r41));
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x03f3, code lost:
    
        r1 = r41.movingAwayToEndBound;
        r2 = r1.size();
        r3 = 0;
        r8 = 0;
        r11 = -1;
        r19 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x03fe, code lost:
    
        if (r8 >= r2) goto L201;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x0400, code lost:
    
        r32 = r1.get(r8);
        r4 = r47.getLineIndexOfItem(r32.getIndex());
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x0411, code lost:
    
        if (r4 == (-1)) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0413, code lost:
    
        if (r4 != r11) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x006c, code lost:
    
        r12 = 0;
        r20 = 128;
        r22 = 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x0415, code lost:
    
        r3 = java.lang.Math.max(r3, r32.getMainAxisSize());
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0425, code lost:
    
        r4 = r41.keyToItemInfoMap.get(r32.getKey());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r4);
        androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem.position$default(r32, r10 + r19, r4.getCrossAxisOffset(), r43, r44, 0, 0, 48, null);
        r45.add(r32);
        startAnimationsIfNeeded(r32);
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x041e, code lost:
    
        r19 = r19 + r3;
        r3 = r32.getMainAxisSize();
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x0454, code lost:
    
        r41.movingInFromStartBound.clear();
        r41.movingInFromEndBound.clear();
        r41.movingAwayToStartBound.clear();
        r41.movingAwayToEndBound.clear();
        r41.movingAwayKeys.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x046d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0071, code lost:
    
        r14 = r1[r12];
        r13 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x00b6, code lost:
    
        r25 = r1;
        r26 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x00c4, code lost:
    
        r26 = r3;
        r13 = r9;
        r20 = 128;
        r22 = 255;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x0054, code lost:
    
        r3 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r42, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x004b, code lost:
    
        r10 = r43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x003b, code lost:
    
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007e, code lost:
    
        if (((((~r14) << 7) & r14) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0080, code lost:
    
        r8 = 8 - ((~(r12 - r11)) >>> 31);
        r9 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0088, code lost:
    
        if (r9 >= r8) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008e, code lost:
    
        if ((r14 & 255) >= 128) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0090, code lost:
    
        r25 = r1;
        r26 = r3;
        r41.movingAwayKeys.add(r5[(r12 << 3) + r9]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00a4, code lost:
    
        r14 = r14 >> 8;
        r9 = r9 + 1;
        r1 = r25;
        r3 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a0, code lost:
    
        r25 = r1;
        r26 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ad, code lost:
    
        r25 = r1;
        r26 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b3, code lost:
    
        if (r8 != 8) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00ba, code lost:
    
        if (r12 == r11) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00bc, code lost:
    
        r12 = r12 + 1;
        r9 = r13;
        r1 = r25;
        r3 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cb, code lost:
    
        r1 = r45.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d0, code lost:
    
        r8 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d1, code lost:
    
        if (r3 >= r1) goto L173;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00d3, code lost:
    
        r4 = r45.get(r3);
        r41.movingAwayKeys.remove(r4.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e6, code lost:
    
        if (getHasAnimations(r4) == false) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e8, code lost:
    
        r5 = r41.keyToItemInfoMap.get(r4.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f4, code lost:
    
        if (r5 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f6, code lost:
    
        r5 = new androidx.compose.foundation.lazy.grid.ItemInfo(r4.getCrossAxisSize(), r4.getCrossAxisOffset());
        r5.updateAnimation(r4, r49);
        r41.keyToItemInfoMap.set(r4.getKey(), r5);
        r11 = r13.getIndex(r4.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0119, code lost:
    
        if (r11 == (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x011f, code lost:
    
        if (r4.getIndex() == r11) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0121, code lost:
    
        if (r11 >= r2) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0123, code lost:
    
        r41.movingInFromStartBound.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0145, code lost:
    
        r24 = r1;
        r15 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x01b8, code lost:
    
        r3 = r3 + 1;
        r2 = r15;
        r1 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0129, code lost:
    
        r41.movingInFromEndBound.add(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x012f, code lost:
    
        r11 = r4.getOffset();
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0137, code lost:
    
        if (r4.getIsVertical() == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0139, code lost:
    
        r8 = androidx.compose.ui.unit.IntOffset.m6518getYimpl(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0142, code lost:
    
        initializeAnimation(r4, r8, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x013e, code lost:
    
        r8 = androidx.compose.ui.unit.IntOffset.m6517getXimpl(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x014a, code lost:
    
        r8 = r5.getAnimations();
        r11 = r8.length;
        r12 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0152, code lost:
    
        if (r12 >= r11) goto L177;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0154, code lost:
    
        r14 = r8[r12];
        r24 = r1;
        r15 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0159, code lost:
    
        if (r14 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x015b, code lost:
    
        r28 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x016b, code lost:
    
        if (androidx.compose.ui.unit.IntOffset.m6516equalsimpl0(r14.getRawOffset(), androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.INSTANCE.m1033getNotInitializednOccac()) != false) goto L179;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x016d, code lost:
    
        r1 = r14.getRawOffset();
        r14.m1032setRawOffsetgyyYBs(androidx.compose.ui.unit.IntOffsetKt.IntOffset(androidx.compose.ui.unit.IntOffset.m6517getXimpl(r1) + androidx.compose.ui.unit.IntOffset.m6517getXimpl(r26), androidx.compose.ui.unit.IntOffset.m6518getYimpl(r1) + androidx.compose.ui.unit.IntOffset.m6518getYimpl(r26)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x018d, code lost:
    
        r12 = r12 + 1;
        r2 = r15;
        r1 = r24;
        r8 = r28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x018b, code lost:
    
        r28 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0197, code lost:
    
        r24 = r1;
        r15 = r2;
        r5.setCrossAxisSize(r4.getCrossAxisSize());
        r5.setCrossAxisOffset(r4.getCrossAxisOffset());
        startAnimationsIfNeeded(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01ac, code lost:
    
        r24 = r1;
        r15 = r2;
        r41.keyToItemInfoMap.remove(r4.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01bf, code lost:
    
        r1 = r41.movingInFromStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x01c6, code lost:
    
        if (r1.size() <= 1) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x01c8, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortByDescending$1(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x01d2, code lost:
    
        r11 = r41.movingInFromStartBound;
        r12 = r11.size();
        r1 = -1;
        r2 = 0;
        r3 = 0;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01dc, code lost:
    
        if (r14 >= r12) goto L181;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x002c, code lost:
    
        r2 = r41.firstVisibleIndex;
        r3 = (androidx.compose.foundation.lazy.grid.LazyGridMeasuredItem) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) r45);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01de, code lost:
    
        r4 = r11.get(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01e4, code lost:
    
        if (r48 == false) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01e6, code lost:
    
        r5 = r4.getRow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01ef, code lost:
    
        if (r5 == (-1)) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01f1, code lost:
    
        if (r5 != r1) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01f3, code lost:
    
        r15 = r1;
        r24 = java.lang.Math.max(r2, r4.getMainAxisSize());
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0207, code lost:
    
        r25 = r3;
        initializeAnimation$default(r41, r4, (0 - r25) - r4.getMainAxisSize(), null, 4, null);
        startAnimationsIfNeeded(r4);
        r14 = r14 + 1;
        r1 = r15;
        r2 = r24;
        r3 = r25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01ff, code lost:
    
        r3 = r3 + r2;
        r24 = r4.getMainAxisSize();
        r15 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0034, code lost:
    
        if (r3 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01eb, code lost:
    
        r5 = r4.getColumn();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0223, code lost:
    
        r1 = r41.movingInFromEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0229, code lost:
    
        if (r1.size() <= 1) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x022b, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.grid.LazyGridItemPlacementAnimator$onMeasured$$inlined$sortBy$1(r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0235, code lost:
    
        r11 = r41.movingInFromEndBound;
        r12 = r11.size();
        r1 = -1;
        r2 = 0;
        r3 = 0;
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x023f, code lost:
    
        if (r14 >= r12) goto L184;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0241, code lost:
    
        r4 = r11.get(r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0247, code lost:
    
        if (r48 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0249, code lost:
    
        r5 = r4.getRow();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0036, code lost:
    
        r3 = r3.getIndex();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<LazyGridMeasuredItem> positionedItems, LazyGridMeasuredItemProvider itemProvider, LazyGridSpanLayoutProvider spanLayoutProvider, boolean isVertical, CoroutineScope coroutineScope) {
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
