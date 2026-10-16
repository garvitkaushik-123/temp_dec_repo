package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import com.ironsource.C3057e4;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J.\u0010\u001b\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0016J\u0010\u0010%\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0017\u0010&\u001a\u00020\b2\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\"0(H\u0082\bJ.\u0010)\u001a\u00020\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\bH\u0016J\u001a\u0010*\u001a\u00020\b2\b\u0010+\u001a\u0004\u0018\u00010\r2\u0006\u0010,\u001a\u00020\rH\u0002J\u0006\u0010-\u001a\u00020\"J\b\u0010.\u001a\u00020/H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", "(Landroidx/compose/ui/Modifier$Node;)V", C3057e4.f, "Landroidx/compose/ui/layout/LayoutCoordinates;", "hasExited", "", "isIn", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "vec", "Landroidx/compose/runtime/collection/MutableVector;", "", "getVec", "()Landroidx/compose/runtime/collection/MutableVector;", "wasIn", "buildCache", "changes", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", "", "clearCache", "dispatchCancel", "dispatchFinalEventPass", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchMainEventPass", "hasPositionChanged", "oldEvent", "newEvent", "markIsIn", "toString", "", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Node extends NodeParent {
    public static final int $stable = 8;
    private LayoutCoordinates coordinates;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private boolean wasIn;
    private final PointerIdArray pointerIds = new PointerIdArray();
    private final LongSparseArray<PointerInputChange> relevantChanges = new LongSparseArray<>(2);
    private boolean isIn = true;
    private boolean hasExited = true;
    private final MutableVector<Long> vec = new MutableVector<>(new Long[16], 0);

    public Node(Modifier.Node node) {
        this.modifierNode = node;
    }

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    public final MutableVector<Long> getVec() {
        return this.vec;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v29, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v30, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v31 */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean buildCache(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        int i;
        PointerInputChange pointerInputChange;
        boolean z;
        int m5161getExit7fucELk;
        boolean z2;
        boolean buildCache = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        boolean z3 = true;
        if (!this.modifierNode.getIsAttached()) {
            return true;
        }
        DelegatingNode delegatingNode = this.modifierNode;
        int m5539constructorimpl = NodeKind.m5539constructorimpl(16);
        MutableVector mutableVector = null;
        while (true) {
            i = 0;
            if (delegatingNode == 0) {
                break;
            }
            if (delegatingNode instanceof PointerInputModifierNode) {
                this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) delegatingNode);
            } else if ((delegatingNode.getKindSet() & m5539constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNode.getDelegate();
                int i2 = 0;
                delegatingNode = delegatingNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m5539constructorimpl) != 0) {
                        i2++;
                        if (i2 == 1) {
                            delegatingNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNode != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(delegatingNode);
                                }
                                delegatingNode = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNode = delegatingNode;
                }
                if (i2 == 1) {
                }
            }
            delegatingNode = DelegatableNodeKt.pop(mutableVector);
        }
        int size = changes.size();
        int i3 = 0;
        while (i3 < size) {
            long keyAt = changes.keyAt(i3);
            PointerInputChange valueAt = changes.valueAt(i3);
            if (this.pointerIds.contains(keyAt)) {
                ArrayList arrayList = new ArrayList(valueAt.getHistorical().size());
                List<HistoricalChange> historical = valueAt.getHistorical();
                int size2 = historical.size();
                z2 = z3;
                int i4 = i;
                while (i4 < size2) {
                    HistoricalChange historicalChange = historical.get(i4);
                    long uptimeMillis = historicalChange.getUptimeMillis();
                    LayoutCoordinates layoutCoordinates = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates);
                    arrayList.add(new HistoricalChange(uptimeMillis, layoutCoordinates.mo5341localPositionOfR5De75A(parentCoordinates, historicalChange.getPosition()), historicalChange.getOriginalEventPosition(), null));
                    i4++;
                    keyAt = keyAt;
                }
                LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                long mo5341localPositionOfR5De75A = layoutCoordinates2.mo5341localPositionOfR5De75A(parentCoordinates, valueAt.getPreviousPosition());
                LayoutCoordinates layoutCoordinates3 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates3);
                longSparseArray.put(keyAt, PointerInputChange.m5197copyOHpmEuE$default(valueAt, 0L, 0L, layoutCoordinates3.mo5341localPositionOfR5De75A(parentCoordinates, valueAt.getPosition()), false, 0L, mo5341localPositionOfR5De75A, false, 0, arrayList, 0L, 731, null));
            } else {
                z2 = z3;
            }
            i3++;
            z3 = z2;
            i = 0;
        }
        boolean z4 = z3;
        if (this.relevantChanges.isEmpty()) {
            this.pointerIds.clear();
            getChildren().clear();
            return z4;
        }
        int size3 = this.pointerIds.getSize();
        while (true) {
            size3--;
            if (-1 >= size3) {
                break;
            }
            if (!changes.containsKey(this.pointerIds.m5302get_I2yYro(size3))) {
                this.pointerIds.removeAt(size3);
            }
        }
        ArrayList arrayList2 = new ArrayList(this.relevantChanges.size());
        int size4 = this.relevantChanges.size();
        for (int i5 = 0; i5 < size4; i5++) {
            arrayList2.add(this.relevantChanges.valueAt(i5));
        }
        PointerEvent pointerEvent = new PointerEvent(arrayList2, internalPointerEvent);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size5 = changes2.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size5) {
                pointerInputChange = null;
                break;
            }
            PointerInputChange pointerInputChange2 = changes2.get(i6);
            if (internalPointerEvent.m5136issuesEnterExitEvent0FcD4WY(pointerInputChange2.getId())) {
                pointerInputChange = pointerInputChange2;
                break;
            }
            i6++;
        }
        PointerInputChange pointerInputChange3 = pointerInputChange;
        if (pointerInputChange3 != null) {
            if (!isInBounds) {
                z = false;
                this.isIn = false;
            } else {
                z = false;
                if (!this.isIn && (pointerInputChange3.getPressed() || pointerInputChange3.getPreviousPressed())) {
                    Intrinsics.checkNotNull(this.coordinates);
                    this.isIn = !PointerEventKt.m5151isOutOfBoundsO0kMr_c(pointerInputChange3, r3.mo5340getSizeYbymL2g());
                }
            }
            if (this.isIn != this.wasIn && (PointerEventType.m5156equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5162getMove7fucELk()) || PointerEventType.m5156equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5160getEnter7fucELk()) || PointerEventType.m5156equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5161getExit7fucELk()))) {
                if (this.isIn) {
                    m5161getExit7fucELk = PointerEventType.INSTANCE.m5160getEnter7fucELk();
                } else {
                    m5161getExit7fucELk = PointerEventType.INSTANCE.m5161getExit7fucELk();
                }
                pointerEvent.m5150setTypeEhbLWgg$ui_release(m5161getExit7fucELk);
            } else if (PointerEventType.m5156equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5160getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                pointerEvent.m5150setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m5162getMove7fucELk());
            } else if (PointerEventType.m5156equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5161getExit7fucELk()) && this.isIn && pointerInputChange3.getPressed()) {
                pointerEvent.m5150setTypeEhbLWgg$ui_release(PointerEventType.INSTANCE.m5162getMove7fucELk());
            }
        } else {
            z = false;
        }
        boolean z5 = (buildCache || !PointerEventType.m5156equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5162getMove7fucELk()) || hasPositionChanged(this.pointerEvent, pointerEvent)) ? z4 : z;
        this.pointerEvent = pointerEvent;
        return z5;
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m3819equalsimpl0(oldEvent.getChanges().get(i).getPosition(), newEvent.getChanges().get(i).getPosition())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        block.invoke();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Node[] content = children.getContent();
            int i = 0;
            do {
                content[i].dispatchCancel();
                i++;
            } while (i < size);
        }
        DelegatingNode delegatingNode = this.modifierNode;
        int m5539constructorimpl = NodeKind.m5539constructorimpl(16);
        MutableVector mutableVector = null;
        while (delegatingNode != 0) {
            if (delegatingNode instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) delegatingNode).onCancelPointerInput();
            } else if ((delegatingNode.getKindSet() & m5539constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNode.getDelegate();
                int i2 = 0;
                delegatingNode = delegatingNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m5539constructorimpl) != 0) {
                        i2++;
                        if (i2 == 1) {
                            delegatingNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNode != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(delegatingNode);
                                }
                                delegatingNode = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNode = delegatingNode;
                }
                if (i2 == 1) {
                }
            }
            delegatingNode = DelegatableNodeKt.pop(mutableVector);
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            if (!pointerInputChange.getPressed() && (!internalPointerEvent.m5136issuesEnterExitEvent0FcD4WY(pointerInputChange.getId()) || !this.isIn)) {
                this.pointerIds.m5303remove0FcD4WY(pointerInputChange.getId());
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m5156equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5161getExit7fucELk());
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        MutableVector<Node> children;
        int size;
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates);
        long mo5340getSizeYbymL2g = layoutCoordinates.mo5340getSizeYbymL2g();
        DelegatingNode delegatingNode = this.modifierNode;
        int m5539constructorimpl = NodeKind.m5539constructorimpl(16);
        MutableVector mutableVector = null;
        while (delegatingNode != 0) {
            if (delegatingNode instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) delegatingNode).mo496onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, mo5340getSizeYbymL2g);
            } else if ((delegatingNode.getKindSet() & m5539constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNode.getDelegate();
                int i = 0;
                delegatingNode = delegatingNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m5539constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            delegatingNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNode != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(delegatingNode);
                                }
                                delegatingNode = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNode = delegatingNode;
                }
                if (i == 1) {
                }
            }
            delegatingNode = DelegatableNodeKt.pop(mutableVector);
        }
        if (this.modifierNode.getIsAttached() && (size = (children = getChildren()).getSize()) > 0) {
            Node[] content = children.getContent();
            int i2 = 0;
            do {
                Node node = content[i2];
                LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                node.dispatchMainEventPass(longSparseArray, layoutCoordinates2, internalPointerEvent, isInBounds);
                i2++;
            } while (i2 < size);
        }
        if (this.modifierNode.getIsAttached()) {
            DelegatingNode delegatingNode2 = this.modifierNode;
            int m5539constructorimpl2 = NodeKind.m5539constructorimpl(16);
            MutableVector mutableVector2 = null;
            while (delegatingNode2 != 0) {
                if (delegatingNode2 instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) delegatingNode2).mo496onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, mo5340getSizeYbymL2g);
                } else if ((delegatingNode2.getKindSet() & m5539constructorimpl2) != 0 && (delegatingNode2 instanceof DelegatingNode)) {
                    Modifier.Node delegate2 = delegatingNode2.getDelegate();
                    int i3 = 0;
                    delegatingNode2 = delegatingNode2;
                    while (delegate2 != null) {
                        if ((delegate2.getKindSet() & m5539constructorimpl2) != 0) {
                            i3++;
                            if (i3 == 1) {
                                delegatingNode2 = delegate2;
                            } else {
                                if (mutableVector2 == null) {
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (delegatingNode2 != 0) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(delegatingNode2);
                                    }
                                    delegatingNode2 = 0;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(delegate2);
                                }
                            }
                        }
                        delegate2 = delegate2.getChild();
                        delegatingNode2 = delegatingNode2;
                    }
                    if (i3 == 1) {
                    }
                }
                delegatingNode2 = DelegatableNodeKt.pop(mutableVector2);
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> children;
        int size;
        boolean z = false;
        int i = 0;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.modifierNode.getIsAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long mo5340getSizeYbymL2g = layoutCoordinates.mo5340getSizeYbymL2g();
            DelegatingNode delegatingNode = this.modifierNode;
            int m5539constructorimpl = NodeKind.m5539constructorimpl(16);
            MutableVector mutableVector = null;
            while (delegatingNode != 0) {
                if (delegatingNode instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) delegatingNode).mo496onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, mo5340getSizeYbymL2g);
                } else if ((delegatingNode.getKindSet() & m5539constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                    Modifier.Node delegate = delegatingNode.getDelegate();
                    int i2 = 0;
                    delegatingNode = delegatingNode;
                    while (delegate != null) {
                        if ((delegate.getKindSet() & m5539constructorimpl) != 0) {
                            i2++;
                            if (i2 == 1) {
                                delegatingNode = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (delegatingNode != 0) {
                                    if (mutableVector != null) {
                                        mutableVector.add(delegatingNode);
                                    }
                                    delegatingNode = 0;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate);
                                }
                            }
                        }
                        delegate = delegate.getChild();
                        delegatingNode = delegatingNode;
                    }
                    if (i2 == 1) {
                    }
                }
                delegatingNode = DelegatableNodeKt.pop(mutableVector);
            }
            if (this.modifierNode.getIsAttached() && (size = (children = getChildren()).getSize()) > 0) {
                Node[] content = children.getContent();
                do {
                    content[i].dispatchFinalEventPass(internalPointerEvent);
                    i++;
                } while (i < size);
            }
            z = true;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }
}
