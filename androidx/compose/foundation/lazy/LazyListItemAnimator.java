package androidx.compose.foundation.lazy;

import androidx.compose.foundation.lazy.layout.LazyLayoutAnimation;
import androidx.compose.foundation.lazy.layout.LazyLayoutAnimationSpecsNode;
import androidx.compose.foundation.lazy.layout.LazyLayoutKeyIndexMap;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import com.ironsource.C3040d4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyListItemAnimator.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001:\u0001.B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0004J\"\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00042\b\b\u0002\u0010\u001f\u001a\u00020\tH\u0002JT\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020\u00142\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020\u001cJ\u0010\u0010-\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u000bj\b\u0012\u0004\u0012\u00020\u0001`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0013\u001a\u00020\u0014*\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemAnimator;", "", "()V", "firstVisibleIndex", "", "keyIndexMap", "Landroidx/compose/foundation/lazy/layout/LazyLayoutKeyIndexMap;", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/LazyListItemAnimator$ItemInfo;", "movingAwayKeys", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "movingAwayToEndBound", "", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "movingAwayToStartBound", "movingInFromEndBound", "movingInFromStartBound", "hasAnimations", "", "getHasAnimations", "(Landroidx/compose/foundation/lazy/LazyListMeasuredItem;)Z", "getAnimation", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", C3040d4.h.W, "placeableIndex", "initializeAnimation", "", "item", "mainAxisOffset", "itemInfo", "onMeasured", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "itemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "isVertical", "isLookingAhead", "hasLookaheadOccurred", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "reset", "startPlacementAnimationsIfNeeded", "ItemInfo", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListItemAnimator {
    public static final int $stable = 8;
    private int firstVisibleIndex;
    private LazyLayoutKeyIndexMap keyIndexMap;
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    private final LinkedHashSet<Object> movingAwayKeys = new LinkedHashSet<>();
    private final List<LazyListMeasuredItem> movingInFromStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingInFromEndBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToStartBound = new ArrayList();
    private final List<LazyListMeasuredItem> movingAwayToEndBound = new ArrayList();

    /* JADX WARN: Code restructure failed: missing block: B:100:0x023c, code lost:
    
        r16 = r12[r13];
        r29 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0240, code lost:
    
        if (r16 == null) goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0246, code lost:
    
        if (r16.isPlacementAnimationInProgress() != r11) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0261, code lost:
    
        if (r3 >= r21.firstVisibleIndex) goto L109;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0263, code lost:
    
        r21.movingAwayToStartBound.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0269, code lost:
    
        r21.movingAwayToEndBound.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0048, code lost:
    
        r21.firstVisibleIndex = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0249, code lost:
    
        r13 = r13 + 1;
        r1 = r29;
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x024f, code lost:
    
        r29 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0251, code lost:
    
        if (r9 == null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0257, code lost:
    
        if (r3 != r9.getIndex(r2)) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0259, code lost:
    
        r21.keyToItemInfoMap.remove(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x004a, code lost:
    
        if (r27 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0272, code lost:
    
        r1 = r21.movingAwayToStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0279, code lost:
    
        if (r1.size() <= 1) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x027b, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortByDescending$2(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0285, code lost:
    
        r1 = r21.movingAwayToStartBound;
        r2 = r1.size();
        r3 = 0;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x028d, code lost:
    
        if (r13 >= r2) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x028f, code lost:
    
        r4 = r1.get(r13);
        r3 = r3 + r4.getSizeWithSpacings();
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x029a, code lost:
    
        if (r28 == false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x029c, code lost:
    
        r5 = ((androidx.compose.foundation.lazy.LazyListMeasuredItem) kotlin.collections.CollectionsKt.first((java.util.List) r25)).getOffset() - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x004c, code lost:
    
        r12 = r24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02aa, code lost:
    
        r4.position(r5, r23, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02ad, code lost:
    
        if (r14 == false) goto L165;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x02af, code lost:
    
        startPlacementAnimationsIfNeeded(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02b2, code lost:
    
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02a8, code lost:
    
        r5 = 0 - r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02b5, code lost:
    
        r1 = r21.movingAwayToEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02bc, code lost:
    
        if (r1.size() <= 1) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004f, code lost:
    
        if (r27 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02be, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortBy$2(r10));
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02c8, code lost:
    
        r1 = r21.movingAwayToEndBound;
        r2 = r1.size();
        r3 = 0;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02d0, code lost:
    
        if (r13 >= r2) goto L166;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02d2, code lost:
    
        r4 = r1.get(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02d8, code lost:
    
        if (r28 == false) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02da, code lost:
    
        r5 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) kotlin.collections.CollectionsKt.last((java.util.List) r25);
        r9 = (r5.getOffset() + r5.getSizeWithSpacings()) + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x02ed, code lost:
    
        r3 = r3 + r4.getSizeWithSpacings();
        r4.position(r9, r23, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x02f5, code lost:
    
        if (r14 == false) goto L168;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x02f7, code lost:
    
        startPlacementAnimationsIfNeeded(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0051, code lost:
    
        r4 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(0, r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x02fa, code lost:
    
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x02eb, code lost:
    
        r9 = r20 + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02fd, code lost:
    
        r1 = r21.movingAwayToStartBound;
        kotlin.collections.CollectionsKt.reverse(r1);
        r2 = kotlin.Unit.INSTANCE;
        r25.addAll(0, r1);
        r25.addAll(r21.movingAwayToEndBound);
        r21.movingInFromStartBound.clear();
        r21.movingInFromEndBound.clear();
        r21.movingAwayToStartBound.clear();
        r21.movingAwayToEndBound.clear();
        r21.movingAwayKeys.clear();
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x032a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0061, code lost:
    
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x0056, code lost:
    
        r4 = androidx.compose.ui.unit.IntOffsetKt.IntOffset(r22, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x004e, code lost:
    
        r12 = r23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
    
        if (r28 != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0047, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
    
        if (r29 != false) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:
    
        r21.movingAwayKeys.addAll(r21.keyToItemInfoMap.keySet());
        r1 = r25.size();
        r16 = r4;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0076, code lost:
    
        if (r15 >= r1) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0078, code lost:
    
        r5 = r25.get(r15);
        r21.movingAwayKeys.remove(r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008b, code lost:
    
        if (getHasAnimations(r5) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008d, code lost:
    
        r11 = r21.keyToItemInfoMap.get(r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0099, code lost:
    
        if (r11 != null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x009b, code lost:
    
        r11 = new androidx.compose.foundation.lazy.LazyListItemAnimator.ItemInfo();
        r11.updateAnimation(r5, r2);
        r21.keyToItemInfoMap.put(r5.getKey(), r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00ac, code lost:
    
        if (r9 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ae, code lost:
    
        r4 = r9.getIndex(r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00bc, code lost:
    
        if (r5.getIndex() == r4) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00bf, code lost:
    
        if (r4 == (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c1, code lost:
    
        if (r4 >= r3) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c3, code lost:
    
        r21.movingInFromStartBound.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0161, code lost:
    
        r27 = r1;
        r18 = r3;
        r20 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0177, code lost:
    
        r15 = r15 + 1;
        r1 = r27;
        r2 = r30;
        r3 = r18;
        r12 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ca, code lost:
    
        r21.movingInFromEndBound.add(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00d1, code lost:
    
        r18 = r5.m991getOffsetBjo55l4(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00da, code lost:
    
        if (r5.getIsVertical() == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00dc, code lost:
    
        r13 = androidx.compose.ui.unit.IntOffset.m6518getYimpl(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e5, code lost:
    
        initializeAnimation(r5, r13, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e9, code lost:
    
        if (r4 != (-1)) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00eb, code lost:
    
        if (r9 == null) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ed, code lost:
    
        r4 = r11.getAnimations();
        r5 = r4.length;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f3, code lost:
    
        if (r13 >= r5) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f5, code lost:
    
        r11 = r4[r13];
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f7, code lost:
    
        if (r11 == null) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f9, code lost:
    
        r11.animateAppearance();
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00fc, code lost:
    
        r13 = r13 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00e1, code lost:
    
        r13 = androidx.compose.ui.unit.IntOffset.m6517getXimpl(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b7, code lost:
    
        r4 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ff, code lost:
    
        if (r14 == false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0101, code lost:
    
        r11.updateAnimation(r5, r2);
        r4 = r11.getAnimations();
        r11 = r4.length;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010a, code lost:
    
        if (r13 >= r11) goto L148;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010c, code lost:
    
        r27 = r1;
        r1 = r4[r13];
        r18 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0112, code lost:
    
        if (r1 == null) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0114, code lost:
    
        r29 = r11;
        r20 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0126, code lost:
    
        if (androidx.compose.ui.unit.IntOffset.m6516equalsimpl0(r1.getRawOffset(), androidx.compose.foundation.lazy.layout.LazyLayoutAnimation.INSTANCE.m1033getNotInitializednOccac()) != false) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0128, code lost:
    
        r2 = r1.getRawOffset();
        r1.m1032setRawOffsetgyyYBs(androidx.compose.ui.unit.IntOffsetKt.IntOffset(androidx.compose.ui.unit.IntOffset.m6517getXimpl(r2) + androidx.compose.ui.unit.IntOffset.m6517getXimpl(r16), androidx.compose.ui.unit.IntOffset.m6518getYimpl(r2) + androidx.compose.ui.unit.IntOffset.m6518getYimpl(r16)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x014a, code lost:
    
        r13 = r13 + 1;
        r1 = r27;
        r11 = r29;
        r3 = r18;
        r12 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0146, code lost:
    
        r29 = r11;
        r20 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0157, code lost:
    
        r27 = r1;
        r18 = r3;
        r20 = r12;
        startPlacementAnimationsIfNeeded(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0168, code lost:
    
        r27 = r1;
        r18 = r3;
        r20 = r12;
        r21.keyToItemInfoMap.remove(r5.getKey());
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0184, code lost:
    
        r20 = r12;
        r13 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0187, code lost:
    
        if (r14 == false) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0189, code lost:
    
        if (r9 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x018b, code lost:
    
        r1 = r21.movingInFromStartBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0192, code lost:
    
        if (r1.size() <= 1) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0194, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortByDescending$1(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x019e, code lost:
    
        r11 = r21.movingInFromStartBound;
        r12 = r11.size();
        r1 = 0;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0038, code lost:
    
        r3 = r21.firstVisibleIndex;
        r4 = (androidx.compose.foundation.lazy.LazyListMeasuredItem) kotlin.collections.CollectionsKt.firstOrNull((java.util.List) r25);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a6, code lost:
    
        if (r15 >= r12) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01a8, code lost:
    
        r2 = r11.get(r15);
        r16 = r1 + r2.getSizeWithSpacings();
        initializeAnimation$default(r21, r2, 0 - r16, null, 4, null);
        startPlacementAnimationsIfNeeded(r2);
        r15 = r15 + 1;
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01c5, code lost:
    
        r1 = r21.movingInFromEndBound;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01cc, code lost:
    
        if (r1.size() <= 1) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01ce, code lost:
    
        kotlin.collections.CollectionsKt.sortWith(r1, new androidx.compose.foundation.lazy.LazyListItemAnimator$onMeasured$$inlined$sortBy$1(r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01d8, code lost:
    
        r11 = r21.movingInFromEndBound;
        r12 = r11.size();
        r1 = 0;
        r15 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01e0, code lost:
    
        if (r15 >= r12) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01e2, code lost:
    
        r2 = r11.get(r15);
        r3 = r1;
        r16 = r3 + r2.getSizeWithSpacings();
        initializeAnimation$default(r21, r2, r20 + r3, null, 4, null);
        startPlacementAnimationsIfNeeded(r2);
        r15 = r15 + 1;
        r1 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0040, code lost:
    
        if (r4 == null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0200, code lost:
    
        r1 = r21.movingAwayKeys.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x020c, code lost:
    
        if (r1.hasNext() == false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x020e, code lost:
    
        r2 = r1.next();
        r3 = r10.getIndex(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0216, code lost:
    
        if (r3 != r13) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0218, code lost:
    
        r21.keyToItemInfoMap.remove(r2);
        r29 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x026e, code lost:
    
        r1 = r29;
        r13 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0222, code lost:
    
        r5 = r26.getAndMeasure(r3);
        r11 = true;
        r5.setNonScrollableItem(true);
        r12 = ((androidx.compose.foundation.lazy.LazyListItemAnimator.ItemInfo) kotlin.collections.MapsKt.getValue(r21.keyToItemInfoMap, r2)).getAnimations();
        r15 = r12.length;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x023a, code lost:
    
        if (r13 >= r15) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0042, code lost:
    
        r4 = r4.getIndex();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasured(int consumedScroll, int layoutWidth, int layoutHeight, List<LazyListMeasuredItem> positionedItems, LazyListMeasuredItemProvider itemProvider, boolean isVertical, boolean isLookingAhead, boolean hasLookaheadOccurred, CoroutineScope coroutineScope) {
        CoroutineScope coroutineScope2 = coroutineScope;
        final LazyLayoutKeyIndexMap lazyLayoutKeyIndexMap = this.keyIndexMap;
        final LazyLayoutKeyIndexMap keyIndexMap = itemProvider.getKeyIndexMap();
        this.keyIndexMap = keyIndexMap;
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

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyIndexMap = LazyLayoutKeyIndexMap.INSTANCE;
        this.firstVisibleIndex = -1;
    }

    static /* synthetic */ void initializeAnimation$default(LazyListItemAnimator lazyListItemAnimator, LazyListMeasuredItem lazyListMeasuredItem, int i, ItemInfo itemInfo, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            itemInfo = (ItemInfo) MapsKt.getValue(lazyListItemAnimator.keyToItemInfoMap, lazyListMeasuredItem.getKey());
        }
        lazyListItemAnimator.initializeAnimation(lazyListMeasuredItem, i, itemInfo);
    }

    private final void initializeAnimation(LazyListMeasuredItem item, int mainAxisOffset, ItemInfo itemInfo) {
        long m6513copyiSbpLlY$default;
        int i = 0;
        long m991getOffsetBjo55l4 = item.m991getOffsetBjo55l4(0);
        if (item.getIsVertical()) {
            m6513copyiSbpLlY$default = IntOffset.m6513copyiSbpLlY$default(m991getOffsetBjo55l4, 0, mainAxisOffset, 1, null);
        } else {
            m6513copyiSbpLlY$default = IntOffset.m6513copyiSbpLlY$default(m991getOffsetBjo55l4, mainAxisOffset, 0, 2, null);
        }
        LazyLayoutAnimation[] animations = itemInfo.getAnimations();
        int length = animations.length;
        int i2 = 0;
        while (i < length) {
            LazyLayoutAnimation lazyLayoutAnimation = animations[i];
            int i3 = i2 + 1;
            if (lazyLayoutAnimation != null) {
                long m991getOffsetBjo55l42 = item.m991getOffsetBjo55l4(i2);
                long IntOffset = IntOffsetKt.IntOffset(IntOffset.m6517getXimpl(m991getOffsetBjo55l42) - IntOffset.m6517getXimpl(m991getOffsetBjo55l4), IntOffset.m6518getYimpl(m991getOffsetBjo55l42) - IntOffset.m6518getYimpl(m991getOffsetBjo55l4));
                lazyLayoutAnimation.m1032setRawOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m6517getXimpl(m6513copyiSbpLlY$default) + IntOffset.m6517getXimpl(IntOffset), IntOffset.m6518getYimpl(m6513copyiSbpLlY$default) + IntOffset.m6518getYimpl(IntOffset)));
            }
            i++;
            i2 = i3;
        }
    }

    private final void startPlacementAnimationsIfNeeded(LazyListMeasuredItem item) {
        LazyLayoutAnimation[] animations = ((ItemInfo) MapsKt.getValue(this.keyToItemInfoMap, item.getKey())).getAnimations();
        int length = animations.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            LazyLayoutAnimation lazyLayoutAnimation = animations[i];
            int i3 = i2 + 1;
            if (lazyLayoutAnimation != null) {
                long m991getOffsetBjo55l4 = item.m991getOffsetBjo55l4(i2);
                long rawOffset = lazyLayoutAnimation.getRawOffset();
                if (!IntOffset.m6516equalsimpl0(rawOffset, LazyLayoutAnimation.INSTANCE.m1033getNotInitializednOccac()) && !IntOffset.m6516equalsimpl0(rawOffset, m991getOffsetBjo55l4)) {
                    lazyLayoutAnimation.m1027animatePlacementDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m6517getXimpl(m991getOffsetBjo55l4) - IntOffset.m6517getXimpl(rawOffset), IntOffset.m6518getYimpl(m991getOffsetBjo55l4) - IntOffset.m6518getYimpl(rawOffset)));
                }
                lazyLayoutAnimation.m1032setRawOffsetgyyYBs(m991getOffsetBjo55l4);
            }
            i++;
            i2 = i3;
        }
    }

    public final LazyLayoutAnimation getAnimation(Object key, int placeableIndex) {
        LazyLayoutAnimation[] animations;
        ItemInfo itemInfo = this.keyToItemInfoMap.get(key);
        if (itemInfo == null || (animations = itemInfo.getAnimations()) == null) {
            return null;
        }
        return animations[placeableIndex];
    }

    private final boolean getHasAnimations(LazyListMeasuredItem lazyListMeasuredItem) {
        LazyLayoutAnimationSpecsNode specs;
        int placeablesCount = lazyListMeasuredItem.getPlaceablesCount();
        for (int i = 0; i < placeablesCount; i++) {
            specs = LazyListItemAnimatorKt.getSpecs(lazyListMeasuredItem.getParentData(i));
            if (specs != null) {
                return true;
            }
        }
        return false;
    }

    /* compiled from: LazyListItemAnimator.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR0\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00042\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemAnimator$ItemInfo;", "", "()V", "<set-?>", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "animations", "getAnimations", "()[Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "[Landroidx/compose/foundation/lazy/layout/LazyLayoutAnimation;", "updateAnimation", "", "positionedItem", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ItemInfo {
        private LazyLayoutAnimation[] animations;

        public ItemInfo() {
            LazyLayoutAnimation[] lazyLayoutAnimationArr;
            lazyLayoutAnimationArr = LazyListItemAnimatorKt.EmptyArray;
            this.animations = lazyLayoutAnimationArr;
        }

        public final LazyLayoutAnimation[] getAnimations() {
            return this.animations;
        }

        public final void updateAnimation(LazyListMeasuredItem positionedItem, CoroutineScope coroutineScope) {
            LazyLayoutAnimationSpecsNode specs;
            int length = this.animations.length;
            for (int placeablesCount = positionedItem.getPlaceablesCount(); placeablesCount < length; placeablesCount++) {
                LazyLayoutAnimation lazyLayoutAnimation = this.animations[placeablesCount];
                if (lazyLayoutAnimation != null) {
                    lazyLayoutAnimation.stopAnimations();
                }
            }
            if (this.animations.length != positionedItem.getPlaceablesCount()) {
                Object[] copyOf = Arrays.copyOf(this.animations, positionedItem.getPlaceablesCount());
                Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                this.animations = (LazyLayoutAnimation[]) copyOf;
            }
            int placeablesCount2 = positionedItem.getPlaceablesCount();
            for (int i = 0; i < placeablesCount2; i++) {
                specs = LazyListItemAnimatorKt.getSpecs(positionedItem.getParentData(i));
                if (specs == null) {
                    LazyLayoutAnimation lazyLayoutAnimation2 = this.animations[i];
                    if (lazyLayoutAnimation2 != null) {
                        lazyLayoutAnimation2.stopAnimations();
                    }
                    this.animations[i] = null;
                } else {
                    LazyLayoutAnimation lazyLayoutAnimation3 = this.animations[i];
                    if (lazyLayoutAnimation3 == null) {
                        lazyLayoutAnimation3 = new LazyLayoutAnimation(coroutineScope);
                        this.animations[i] = lazyLayoutAnimation3;
                    }
                    lazyLayoutAnimation3.setAppearanceSpec(specs.getAppearanceSpec());
                    lazyLayoutAnimation3.setPlacementSpec(specs.getPlacementSpec());
                }
            }
        }
    }
}
