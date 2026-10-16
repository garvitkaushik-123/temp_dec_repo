package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FocusTraversal.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0007\u001a\u00020\b*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u000e\u0010\u000f\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0000\u001a\u000e\u0010\u0010\u001a\u0004\u0018\u00010\u0001*\u00020\u0001H\u0002\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0001H\u0000\u001a:\u0010\u0013\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0015H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0018"}, d2 = {"activeChild", "Landroidx/compose/ui/focus/FocusTargetNode;", "getActiveChild", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusTargetNode;", "isEligibleForFocusSearch", "", "(Landroidx/compose/ui/focus/FocusTargetNode;)Z", "customFocusSearch", "Landroidx/compose/ui/focus/FocusRequester;", "focusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "customFocusSearch--OM-vw8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/focus/FocusRequester;", "findActiveFocusNode", "findNonDeactivatedParent", "focusRect", "Landroidx/compose/ui/geometry/Rect;", "focusSearch", "onFound", "Lkotlin/Function1;", "focusSearch-sMXa3k8", "(Landroidx/compose/ui/focus/FocusTargetNode;ILandroidx/compose/ui/unit/LayoutDirection;Lkotlin/jvm/functions/Function1;)Z", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusTraversalKt {

    /* compiled from: FocusTraversal.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LayoutDirection.values().length];
            try {
                iArr[LayoutDirection.Ltr.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LayoutDirection.Rtl.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[FocusStateImpl.values().length];
            try {
                iArr2[FocusStateImpl.Active.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[FocusStateImpl.ActiveParent.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[FocusStateImpl.Captured.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[FocusStateImpl.Inactive.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* renamed from: customFocusSearch--OM-vw8, reason: not valid java name */
    public static final FocusRequester m3774customFocusSearchOMvw8(FocusTargetNode focusTargetNode, int i, LayoutDirection layoutDirection) {
        FocusRequester end;
        FocusRequester focusRequester;
        FocusRequester start;
        FocusProperties fetchFocusProperties$ui_release = focusTargetNode.fetchFocusProperties$ui_release();
        if (FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3752getNextdhqQ8s())) {
            return fetchFocusProperties$ui_release.getNext();
        }
        if (FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3753getPreviousdhqQ8s())) {
            return fetchFocusProperties$ui_release.getPrevious();
        }
        if (FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3755getUpdhqQ8s())) {
            return fetchFocusProperties$ui_release.getUp();
        }
        if (FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3748getDowndhqQ8s())) {
            return fetchFocusProperties$ui_release.getDown();
        }
        if (FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3751getLeftdhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                start = fetchFocusProperties$ui_release.getStart();
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                start = fetchFocusProperties$ui_release.getEnd();
            }
            focusRequester = start != FocusRequester.INSTANCE.getDefault() ? start : null;
            return focusRequester == null ? fetchFocusProperties$ui_release.getLeft() : focusRequester;
        }
        if (FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3754getRightdhqQ8s())) {
            int i3 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i3 == 1) {
                end = fetchFocusProperties$ui_release.getEnd();
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                end = fetchFocusProperties$ui_release.getStart();
            }
            focusRequester = end != FocusRequester.INSTANCE.getDefault() ? end : null;
            return focusRequester == null ? fetchFocusProperties$ui_release.getRight() : focusRequester;
        }
        if (FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3749getEnterdhqQ8s())) {
            return fetchFocusProperties$ui_release.getEnter().invoke(FocusDirection.m3739boximpl(i));
        }
        if (FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3750getExitdhqQ8s())) {
            return fetchFocusProperties$ui_release.getExit().invoke(FocusDirection.m3739boximpl(i));
        }
        throw new IllegalStateException("invalid FocusDirection".toString());
    }

    /* renamed from: focusSearch-sMXa3k8, reason: not valid java name */
    public static final boolean m3775focusSearchsMXa3k8(FocusTargetNode focusTargetNode, int i, LayoutDirection layoutDirection, Function1<? super FocusTargetNode, Boolean> function1) {
        int m3754getRightdhqQ8s;
        Boolean m3787twoDimensionalFocusSearchOMvw8;
        if (FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3752getNextdhqQ8s()) ? true : FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3753getPreviousdhqQ8s())) {
            return OneDimensionalFocusSearchKt.m3778oneDimensionalFocusSearchOMvw8(focusTargetNode, i, function1);
        }
        if (FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3751getLeftdhqQ8s()) ? true : FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3754getRightdhqQ8s()) ? true : FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3755getUpdhqQ8s()) ? true : FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3748getDowndhqQ8s())) {
            Boolean m3787twoDimensionalFocusSearchOMvw82 = TwoDimensionalFocusSearchKt.m3787twoDimensionalFocusSearchOMvw8(focusTargetNode, i, function1);
            if (m3787twoDimensionalFocusSearchOMvw82 != null) {
                return m3787twoDimensionalFocusSearchOMvw82.booleanValue();
            }
            return false;
        }
        if (FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3749getEnterdhqQ8s())) {
            int i2 = WhenMappings.$EnumSwitchMapping$0[layoutDirection.ordinal()];
            if (i2 == 1) {
                m3754getRightdhqQ8s = FocusDirection.INSTANCE.m3754getRightdhqQ8s();
            } else {
                if (i2 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                m3754getRightdhqQ8s = FocusDirection.INSTANCE.m3751getLeftdhqQ8s();
            }
            FocusTargetNode findActiveFocusNode = findActiveFocusNode(focusTargetNode);
            if (findActiveFocusNode == null || (m3787twoDimensionalFocusSearchOMvw8 = TwoDimensionalFocusSearchKt.m3787twoDimensionalFocusSearchOMvw8(findActiveFocusNode, m3754getRightdhqQ8s, function1)) == null) {
                return false;
            }
            return m3787twoDimensionalFocusSearchOMvw8.booleanValue();
        }
        if (FocusDirection.m3742equalsimpl0(i, FocusDirection.INSTANCE.m3750getExitdhqQ8s())) {
            FocusTargetNode findActiveFocusNode2 = findActiveFocusNode(focusTargetNode);
            FocusTargetNode findNonDeactivatedParent = findActiveFocusNode2 != null ? findNonDeactivatedParent(findActiveFocusNode2) : null;
            if (findNonDeactivatedParent == null || Intrinsics.areEqual(findNonDeactivatedParent, focusTargetNode)) {
                return false;
            }
            return function1.invoke(findNonDeactivatedParent).booleanValue();
        }
        throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) FocusDirection.m3744toStringimpl(i))).toString());
    }

    public static final Rect focusRect(FocusTargetNode focusTargetNode) {
        NodeCoordinator coordinator$ui_release = focusTargetNode.getCoordinator();
        if (coordinator$ui_release != null) {
            NodeCoordinator nodeCoordinator = coordinator$ui_release;
            Rect localBoundingBoxOf = LayoutCoordinatesKt.findRootCoordinates(nodeCoordinator).localBoundingBoxOf(nodeCoordinator, false);
            if (localBoundingBoxOf != null) {
                return localBoundingBoxOf;
            }
        }
        return Rect.INSTANCE.getZero();
    }

    public static final boolean isEligibleForFocusSearch(FocusTargetNode focusTargetNode) {
        LayoutNode layoutNode;
        NodeCoordinator coordinator$ui_release;
        LayoutNode layoutNode2;
        NodeCoordinator coordinator$ui_release2 = focusTargetNode.getCoordinator();
        return (coordinator$ui_release2 == null || (layoutNode = coordinator$ui_release2.getLayoutNode()) == null || !layoutNode.isPlaced() || (coordinator$ui_release = focusTargetNode.getCoordinator()) == null || (layoutNode2 = coordinator$ui_release.getLayoutNode()) == null || !layoutNode2.isAttached()) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x003d, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final FocusTargetNode getActiveChild(FocusTargetNode focusTargetNode) {
        if (!focusTargetNode.getNode().getIsAttached()) {
            return null;
        }
        FocusTargetNode focusTargetNode2 = focusTargetNode;
        int m5539constructorimpl = NodeKind.m5539constructorimpl(1024);
        if (!focusTargetNode2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitChildren called on an unattached node".toString());
        }
        MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = focusTargetNode2.getNode().getChild();
        if (child == null) {
            DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode2.getNode());
        } else {
            mutableVector.add(child);
        }
        while (mutableVector.isNotEmpty()) {
            Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
            if ((node.getAggregateChildKindSet() & m5539constructorimpl) == 0) {
                DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
            } else {
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet() & m5539constructorimpl) != 0) {
                        MutableVector mutableVector2 = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
                                if (focusTargetNode3.getNode().getIsAttached()) {
                                    int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode3.getFocusState().ordinal()];
                                    if (i == 1 || i == 2 || i == 3) {
                                        return focusTargetNode3;
                                    }
                                }
                            } else if ((node.getKindSet() & m5539constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i2 = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m5539constructorimpl) != 0) {
                                        i2++;
                                        if (i2 == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector2 == null) {
                                                mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector2 != null) {
                                                    mutableVector2.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector2 != null) {
                                                mutableVector2.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i2 == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector2);
                        }
                    } else {
                        node = node.getChild();
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x0051, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final FocusTargetNode findActiveFocusNode(FocusTargetNode focusTargetNode) {
        int i = WhenMappings.$EnumSwitchMapping$1[focusTargetNode.getFocusState().ordinal()];
        if (i != 1) {
            if (i == 2) {
                FocusTargetNode focusTargetNode2 = focusTargetNode;
                int m5539constructorimpl = NodeKind.m5539constructorimpl(1024);
                if (!focusTargetNode2.getNode().getIsAttached()) {
                    throw new IllegalStateException("visitChildren called on an unattached node".toString());
                }
                MutableVector mutableVector = new MutableVector(new Modifier.Node[16], 0);
                Modifier.Node child = focusTargetNode2.getNode().getChild();
                if (child == null) {
                    DelegatableNodeKt.addLayoutNodeChildren(mutableVector, focusTargetNode2.getNode());
                } else {
                    mutableVector.add(child);
                }
                while (mutableVector.isNotEmpty()) {
                    Modifier.Node node = (Modifier.Node) mutableVector.removeAt(mutableVector.getSize() - 1);
                    if ((node.getAggregateChildKindSet() & m5539constructorimpl) == 0) {
                        DelegatableNodeKt.addLayoutNodeChildren(mutableVector, node);
                    } else {
                        while (true) {
                            if (node == null) {
                                break;
                            }
                            if ((node.getKindSet() & m5539constructorimpl) != 0) {
                                MutableVector mutableVector2 = null;
                                while (node != null) {
                                    if (node instanceof FocusTargetNode) {
                                        FocusTargetNode findActiveFocusNode = findActiveFocusNode((FocusTargetNode) node);
                                        if (findActiveFocusNode != null) {
                                            return findActiveFocusNode;
                                        }
                                    } else if ((node.getKindSet() & m5539constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                        int i2 = 0;
                                        for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                            if ((delegate.getKindSet() & m5539constructorimpl) != 0) {
                                                i2++;
                                                if (i2 == 1) {
                                                    node = delegate;
                                                } else {
                                                    if (mutableVector2 == null) {
                                                        mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                                    }
                                                    if (node != null) {
                                                        if (mutableVector2 != null) {
                                                            mutableVector2.add(node);
                                                        }
                                                        node = null;
                                                    }
                                                    if (mutableVector2 != null) {
                                                        mutableVector2.add(delegate);
                                                    }
                                                }
                                            }
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                    node = DelegatableNodeKt.pop(mutableVector2);
                                }
                            } else {
                                node = node.getChild();
                            }
                        }
                    }
                }
                return null;
            }
            if (i != 3) {
                if (i == 4) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
        return focusTargetNode;
    }

    private static final FocusTargetNode findNonDeactivatedParent(FocusTargetNode focusTargetNode) {
        NodeChain nodes;
        FocusTargetNode focusTargetNode2 = focusTargetNode;
        int m5539constructorimpl = NodeKind.m5539constructorimpl(1024);
        if (!focusTargetNode2.getNode().getIsAttached()) {
            throw new IllegalStateException("visitAncestors called on an unattached node".toString());
        }
        Modifier.Node parent = focusTargetNode2.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(focusTargetNode2);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m5539constructorimpl) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m5539constructorimpl) != 0) {
                        Modifier.Node node = parent;
                        MutableVector mutableVector = null;
                        while (node != null) {
                            if (node instanceof FocusTargetNode) {
                                FocusTargetNode focusTargetNode3 = (FocusTargetNode) node;
                                if (focusTargetNode3.fetchFocusProperties$ui_release().getCanFocus()) {
                                    return focusTargetNode3;
                                }
                            } else if ((node.getKindSet() & m5539constructorimpl) != 0 && (node instanceof DelegatingNode)) {
                                int i = 0;
                                for (Modifier.Node delegate = ((DelegatingNode) node).getDelegate(); delegate != null; delegate = delegate.getChild()) {
                                    if ((delegate.getKindSet() & m5539constructorimpl) != 0) {
                                        i++;
                                        if (i == 1) {
                                            node = delegate;
                                        } else {
                                            if (mutableVector == null) {
                                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                            }
                                            if (node != null) {
                                                if (mutableVector != null) {
                                                    mutableVector.add(node);
                                                }
                                                node = null;
                                            }
                                            if (mutableVector != null) {
                                                mutableVector.add(delegate);
                                            }
                                        }
                                    }
                                }
                                if (i == 1) {
                                }
                            }
                            node = DelegatableNodeKt.pop(mutableVector);
                        }
                    }
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return null;
    }
}
