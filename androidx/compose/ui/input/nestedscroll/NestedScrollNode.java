package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NestedScrollNode.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J#\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J*\u0010$\u001a\u00020%2\u0006\u0010 \u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0096@ø\u0001\u0000¢\u0006\u0004\b+\u0010,J\"\u0010-\u001a\u00020%2\u0006\u0010!\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\b\u00100\u001a\u00020\u001cH\u0002J\u0012\u00101\u001a\u00020\u001c2\b\u00102\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u00103\u001a\u00020\u001cH\u0002J\u001f\u00104\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0000¢\u0006\u0002\b5R\u001a\u0010\u0005\u001a\u00020\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\nR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00066"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/ui/node/DelegatableNode;", "Landroidx/compose/ui/Modifier$Node;", "connection", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "setConnection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "parentConnection", "getParentConnection", "parentModifierLocal", "getParentModifierLocal", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "resolvedDispatcher", "onAttach", "", "onDetach", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "resetDispatcherFields", "updateDispatcher", "newDispatcher", "updateDispatcherFields", "updateNode", "updateNode$ui_release", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedScrollNode extends Modifier.Node implements ModifierLocalModifierNode, NestedScrollConnection, DelegatableNode {
    public static final int $stable = 8;
    private NestedScrollConnection connection;
    private final ModifierLocalMap providedValues;
    private NestedScrollDispatcher resolvedDispatcher;

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    public final void setConnection(NestedScrollConnection nestedScrollConnection) {
        this.connection = nestedScrollConnection;
    }

    public NestedScrollNode(NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher) {
        this.connection = nestedScrollConnection;
        this.resolvedDispatcher = nestedScrollDispatcher == null ? new NestedScrollDispatcher() : nestedScrollDispatcher;
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(NestedScrollNodeKt.getModifierLocalNestedScroll(), this));
    }

    private final NestedScrollNode getParentModifierLocal() {
        if (getIsAttached()) {
            return (NestedScrollNode) getCurrent(NestedScrollNodeKt.getModifierLocalNestedScroll());
        }
        return null;
    }

    private final NestedScrollConnection getParentConnection() {
        if (getIsAttached()) {
            return (NestedScrollConnection) getCurrent(NestedScrollNodeKt.getModifierLocalNestedScroll());
        }
        return null;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope nestedCoroutineScope;
        NestedScrollNode parentModifierLocal = getParentModifierLocal();
        if (parentModifierLocal != null && (nestedCoroutineScope = parentModifierLocal.getNestedCoroutineScope()) != null) {
            return nestedCoroutineScope;
        }
        CoroutineScope scope = this.resolvedDispatcher.getScope();
        if (scope != null) {
            return scope;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo718onPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parentConnection = getParentConnection();
        long mo718onPreScrollOzD1aCk = parentConnection != null ? parentConnection.mo718onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m3838getZeroF1C5BW0();
        return Offset.m3827plusMKHz9U(mo718onPreScrollOzD1aCk, this.connection.mo718onPreScrollOzD1aCk(Offset.m3826minusMKHz9U(available, mo718onPreScrollOzD1aCk), source));
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo717onPostScrollDzOQY0M(long consumed, long available, int source) {
        long m3838getZeroF1C5BW0;
        long mo717onPostScrollDzOQY0M = this.connection.mo717onPostScrollDzOQY0M(consumed, available, source);
        NestedScrollConnection parentConnection = getParentConnection();
        if (parentConnection != null) {
            m3838getZeroF1C5BW0 = parentConnection.mo717onPostScrollDzOQY0M(Offset.m3827plusMKHz9U(consumed, mo717onPostScrollDzOQY0M), Offset.m3826minusMKHz9U(available, mo717onPostScrollDzOQY0M), source);
        } else {
            m3838getZeroF1C5BW0 = Offset.INSTANCE.m3838getZeroF1C5BW0();
        }
        return Offset.m3827plusMKHz9U(mo717onPostScrollDzOQY0M, m3838getZeroF1C5BW0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x007a, code lost:
    
        if (r11 == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo958onPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPreFling$1 nestedScrollNode$onPreFling$1;
        int i;
        long m6635getZero9UxMQ8M;
        NestedScrollNode nestedScrollNode;
        long j2;
        if (continuation instanceof NestedScrollNode$onPreFling$1) {
            nestedScrollNode$onPreFling$1 = (NestedScrollNode$onPreFling$1) continuation;
            if ((nestedScrollNode$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPreFling$1.label -= Integer.MIN_VALUE;
                Object obj = nestedScrollNode$onPreFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = nestedScrollNode$onPreFling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NestedScrollConnection parentConnection = getParentConnection();
                    if (parentConnection != null) {
                        nestedScrollNode$onPreFling$1.L$0 = this;
                        nestedScrollNode$onPreFling$1.J$0 = j;
                        nestedScrollNode$onPreFling$1.label = 1;
                        obj = parentConnection.mo958onPreFlingQWom1Mo(j, nestedScrollNode$onPreFling$1);
                        if (obj != coroutine_suspended) {
                            nestedScrollNode = this;
                        }
                        return coroutine_suspended;
                    }
                    m6635getZero9UxMQ8M = Velocity.INSTANCE.m6635getZero9UxMQ8M();
                    nestedScrollNode = this;
                    long j3 = m6635getZero9UxMQ8M;
                    long j4 = j;
                    j2 = j3;
                    NestedScrollConnection nestedScrollConnection = nestedScrollNode.connection;
                    long m6627minusAH228Gc = Velocity.m6627minusAH228Gc(j4, j2);
                    nestedScrollNode$onPreFling$1.L$0 = null;
                    nestedScrollNode$onPreFling$1.J$0 = j2;
                    nestedScrollNode$onPreFling$1.label = 2;
                    obj = nestedScrollConnection.mo958onPreFlingQWom1Mo(m6627minusAH228Gc, nestedScrollNode$onPreFling$1);
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        j2 = nestedScrollNode$onPreFling$1.J$0;
                        ResultKt.throwOnFailure(obj);
                        return Velocity.m6615boximpl(Velocity.m6628plusAH228Gc(j2, ((Velocity) obj).getPackedValue()));
                    }
                    j = nestedScrollNode$onPreFling$1.J$0;
                    nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPreFling$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                m6635getZero9UxMQ8M = ((Velocity) obj).getPackedValue();
                long j32 = m6635getZero9UxMQ8M;
                long j42 = j;
                j2 = j32;
                NestedScrollConnection nestedScrollConnection2 = nestedScrollNode.connection;
                long m6627minusAH228Gc2 = Velocity.m6627minusAH228Gc(j42, j2);
                nestedScrollNode$onPreFling$1.L$0 = null;
                nestedScrollNode$onPreFling$1.J$0 = j2;
                nestedScrollNode$onPreFling$1.label = 2;
                obj = nestedScrollConnection2.mo958onPreFlingQWom1Mo(m6627minusAH228Gc2, nestedScrollNode$onPreFling$1);
            }
        }
        nestedScrollNode$onPreFling$1 = new NestedScrollNode$onPreFling$1(this, continuation);
        Object obj2 = nestedScrollNode$onPreFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nestedScrollNode$onPreFling$1.label;
        if (i != 0) {
        }
        m6635getZero9UxMQ8M = ((Velocity) obj2).getPackedValue();
        long j322 = m6635getZero9UxMQ8M;
        long j422 = j;
        j2 = j322;
        NestedScrollConnection nestedScrollConnection22 = nestedScrollNode.connection;
        long m6627minusAH228Gc22 = Velocity.m6627minusAH228Gc(j422, j2);
        nestedScrollNode$onPreFling$1.L$0 = null;
        nestedScrollNode$onPreFling$1.J$0 = j2;
        nestedScrollNode$onPreFling$1.label = 2;
        obj2 = nestedScrollConnection22.mo958onPreFlingQWom1Mo(m6627minusAH228Gc22, nestedScrollNode$onPreFling$1);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo716onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$1;
        int i;
        NestedScrollNode nestedScrollNode;
        long j3;
        long j4;
        long packedValue;
        NestedScrollConnection parentConnection;
        long m6635getZero9UxMQ8M;
        long j5;
        if (continuation instanceof NestedScrollNode$onPostFling$1) {
            nestedScrollNode$onPostFling$1 = (NestedScrollNode$onPostFling$1) continuation;
            if ((nestedScrollNode$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollNode$onPostFling$1.label -= Integer.MIN_VALUE;
                NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$12 = nestedScrollNode$onPostFling$1;
                Object obj = nestedScrollNode$onPostFling$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = nestedScrollNode$onPostFling$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NestedScrollConnection nestedScrollConnection = this.connection;
                    nestedScrollNode$onPostFling$12.L$0 = this;
                    nestedScrollNode$onPostFling$12.J$0 = j;
                    nestedScrollNode$onPostFling$12.J$1 = j2;
                    nestedScrollNode$onPostFling$12.label = 1;
                    obj = nestedScrollConnection.mo716onPostFlingRZ2iAVY(j, j2, nestedScrollNode$onPostFling$12);
                    if (obj != coroutine_suspended) {
                        nestedScrollNode = this;
                        j3 = j;
                        j4 = j2;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j5 = nestedScrollNode$onPostFling$12.J$0;
                    ResultKt.throwOnFailure(obj);
                    m6635getZero9UxMQ8M = ((Velocity) obj).getPackedValue();
                    packedValue = j5;
                    return Velocity.m6615boximpl(Velocity.m6628plusAH228Gc(packedValue, m6635getZero9UxMQ8M));
                }
                j4 = nestedScrollNode$onPostFling$12.J$1;
                j3 = nestedScrollNode$onPostFling$12.J$0;
                nestedScrollNode = (NestedScrollNode) nestedScrollNode$onPostFling$12.L$0;
                ResultKt.throwOnFailure(obj);
                packedValue = ((Velocity) obj).getPackedValue();
                parentConnection = nestedScrollNode.getParentConnection();
                if (parentConnection == null) {
                    long m6628plusAH228Gc = Velocity.m6628plusAH228Gc(j3, packedValue);
                    long m6627minusAH228Gc = Velocity.m6627minusAH228Gc(j4, packedValue);
                    nestedScrollNode$onPostFling$12.L$0 = null;
                    nestedScrollNode$onPostFling$12.J$0 = packedValue;
                    nestedScrollNode$onPostFling$12.label = 2;
                    obj = parentConnection.mo716onPostFlingRZ2iAVY(m6628plusAH228Gc, m6627minusAH228Gc, nestedScrollNode$onPostFling$12);
                    if (obj != coroutine_suspended) {
                        j5 = packedValue;
                        m6635getZero9UxMQ8M = ((Velocity) obj).getPackedValue();
                        packedValue = j5;
                        return Velocity.m6615boximpl(Velocity.m6628plusAH228Gc(packedValue, m6635getZero9UxMQ8M));
                    }
                    return coroutine_suspended;
                }
                m6635getZero9UxMQ8M = Velocity.INSTANCE.m6635getZero9UxMQ8M();
                return Velocity.m6615boximpl(Velocity.m6628plusAH228Gc(packedValue, m6635getZero9UxMQ8M));
            }
        }
        nestedScrollNode$onPostFling$1 = new NestedScrollNode$onPostFling$1(this, continuation);
        NestedScrollNode$onPostFling$1 nestedScrollNode$onPostFling$122 = nestedScrollNode$onPostFling$1;
        Object obj2 = nestedScrollNode$onPostFling$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nestedScrollNode$onPostFling$122.label;
        if (i != 0) {
        }
        packedValue = ((Velocity) obj2).getPackedValue();
        parentConnection = nestedScrollNode.getParentConnection();
        if (parentConnection == null) {
        }
    }

    private final void updateDispatcher(NestedScrollDispatcher newDispatcher) {
        resetDispatcherFields();
        if (newDispatcher == null) {
            this.resolvedDispatcher = new NestedScrollDispatcher();
        } else if (!Intrinsics.areEqual(newDispatcher, this.resolvedDispatcher)) {
            this.resolvedDispatcher = newDispatcher;
        }
        if (getIsAttached()) {
            updateDispatcherFields();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        updateDispatcherFields();
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        resetDispatcherFields();
    }

    private final void updateDispatcherFields() {
        this.resolvedDispatcher.setModifierLocalNode$ui_release(this);
        this.resolvedDispatcher.setCalculateNestedScrollScope$ui_release(new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollNode$updateDispatcherFields$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                CoroutineScope nestedCoroutineScope;
                nestedCoroutineScope = NestedScrollNode.this.getNestedCoroutineScope();
                return nestedCoroutineScope;
            }
        });
        this.resolvedDispatcher.setScope$ui_release(getCoroutineScope());
    }

    private final void resetDispatcherFields() {
        if (this.resolvedDispatcher.getModifierLocalNode() == this) {
            this.resolvedDispatcher.setModifierLocalNode$ui_release(null);
        }
    }

    public final void updateNode$ui_release(NestedScrollConnection connection, NestedScrollDispatcher dispatcher) {
        this.connection = connection;
        updateDispatcher(dispatcher);
    }
}
