package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NestedScrollModifier.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J#\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J(\u0010!\u001a\u00020\"2\u0006\u0010\u001d\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\"2\u0006\u0010#\u001a\u00020$ø\u0001\u0000¢\u0006\u0004\b%\u0010&J\u001b\u0010'\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0004\b(\u0010)J \u0010*\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\"2\u0006\u0010#\u001a\u00020$ø\u0001\u0000¢\u0006\u0004\b+\u0010,R\"\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00148@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u001a\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006-"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "", "()V", "calculateNestedScrollScope", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "getCalculateNestedScrollScope$ui_release", "()Lkotlin/jvm/functions/Function0;", "setCalculateNestedScrollScope$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "coroutineScope", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "modifierLocalNode", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "getModifierLocalNode$ui_release", "()Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "setModifierLocalNode$ui_release", "(Landroidx/compose/ui/modifier/ModifierLocalModifierNode;)V", "parent", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getParent$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scope", "getScope$ui_release", "setScope$ui_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "dispatchPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "dispatchPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchPostScroll-DzOQY0M", "(JJI)J", "dispatchPreFling", "dispatchPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPreScroll", "dispatchPreScroll-OzD1aCk", "(JI)J", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedScrollDispatcher {
    public static final int $stable = 8;
    private Function0<? extends CoroutineScope> calculateNestedScrollScope = new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$calculateNestedScrollScope$1
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CoroutineScope invoke() {
            return NestedScrollDispatcher.this.getScope();
        }
    };
    private ModifierLocalModifierNode modifierLocalNode;
    private CoroutineScope scope;

    /* renamed from: getModifierLocalNode$ui_release, reason: from getter */
    public final ModifierLocalModifierNode getModifierLocalNode() {
        return this.modifierLocalNode;
    }

    public final void setModifierLocalNode$ui_release(ModifierLocalModifierNode modifierLocalModifierNode) {
        this.modifierLocalNode = modifierLocalModifierNode;
    }

    public final Function0<CoroutineScope> getCalculateNestedScrollScope$ui_release() {
        return this.calculateNestedScrollScope;
    }

    public final void setCalculateNestedScrollScope$ui_release(Function0<? extends CoroutineScope> function0) {
        this.calculateNestedScrollScope = function0;
    }

    /* renamed from: getScope$ui_release, reason: from getter */
    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final void setScope$ui_release(CoroutineScope coroutineScope) {
        this.scope = coroutineScope;
    }

    public final CoroutineScope getCoroutineScope() {
        CoroutineScope invoke = this.calculateNestedScrollScope.invoke();
        if (invoke != null) {
            return invoke;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    public final NestedScrollConnection getParent$ui_release() {
        ModifierLocalModifierNode modifierLocalModifierNode = this.modifierLocalNode;
        return modifierLocalModifierNode != null ? (NestedScrollNode) modifierLocalModifierNode.getCurrent(NestedScrollNodeKt.getModifierLocalNestedScroll()) : null;
    }

    /* renamed from: dispatchPreScroll-OzD1aCk, reason: not valid java name */
    public final long m5092dispatchPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parent$ui_release = getParent$ui_release();
        return parent$ui_release != null ? parent$ui_release.mo718onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m3838getZeroF1C5BW0();
    }

    /* renamed from: dispatchPostScroll-DzOQY0M, reason: not valid java name */
    public final long m5090dispatchPostScrollDzOQY0M(long consumed, long available, int source) {
        NestedScrollConnection parent$ui_release = getParent$ui_release();
        return parent$ui_release != null ? parent$ui_release.mo717onPostScrollDzOQY0M(consumed, available, source) : Offset.INSTANCE.m3838getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: dispatchPreFling-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m5091dispatchPreFlingQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        NestedScrollDispatcher$dispatchPreFling$1 nestedScrollDispatcher$dispatchPreFling$1;
        int i;
        long m6635getZero9UxMQ8M;
        if (continuation instanceof NestedScrollDispatcher$dispatchPreFling$1) {
            nestedScrollDispatcher$dispatchPreFling$1 = (NestedScrollDispatcher$dispatchPreFling$1) continuation;
            if ((nestedScrollDispatcher$dispatchPreFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPreFling$1.label -= Integer.MIN_VALUE;
                Object obj = nestedScrollDispatcher$dispatchPreFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = nestedScrollDispatcher$dispatchPreFling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NestedScrollConnection parent$ui_release = getParent$ui_release();
                    if (parent$ui_release == null) {
                        m6635getZero9UxMQ8M = Velocity.INSTANCE.m6635getZero9UxMQ8M();
                        return Velocity.m6615boximpl(m6635getZero9UxMQ8M);
                    }
                    nestedScrollDispatcher$dispatchPreFling$1.label = 1;
                    obj = parent$ui_release.mo958onPreFlingQWom1Mo(j, nestedScrollDispatcher$dispatchPreFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                m6635getZero9UxMQ8M = ((Velocity) obj).getPackedValue();
                return Velocity.m6615boximpl(m6635getZero9UxMQ8M);
            }
        }
        nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuation);
        Object obj2 = nestedScrollDispatcher$dispatchPreFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nestedScrollDispatcher$dispatchPreFling$1.label;
        if (i != 0) {
        }
        m6635getZero9UxMQ8M = ((Velocity) obj2).getPackedValue();
        return Velocity.m6615boximpl(m6635getZero9UxMQ8M);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: dispatchPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m5089dispatchPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$1;
        int i;
        long m6635getZero9UxMQ8M;
        if (continuation instanceof NestedScrollDispatcher$dispatchPostFling$1) {
            nestedScrollDispatcher$dispatchPostFling$1 = (NestedScrollDispatcher$dispatchPostFling$1) continuation;
            if ((nestedScrollDispatcher$dispatchPostFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPostFling$1.label -= Integer.MIN_VALUE;
                NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$12 = nestedScrollDispatcher$dispatchPostFling$1;
                Object obj = nestedScrollDispatcher$dispatchPostFling$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = nestedScrollDispatcher$dispatchPostFling$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    NestedScrollConnection parent$ui_release = getParent$ui_release();
                    if (parent$ui_release == null) {
                        m6635getZero9UxMQ8M = Velocity.INSTANCE.m6635getZero9UxMQ8M();
                        return Velocity.m6615boximpl(m6635getZero9UxMQ8M);
                    }
                    nestedScrollDispatcher$dispatchPostFling$12.label = 1;
                    obj = parent$ui_release.mo716onPostFlingRZ2iAVY(j, j2, nestedScrollDispatcher$dispatchPostFling$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                m6635getZero9UxMQ8M = ((Velocity) obj).getPackedValue();
                return Velocity.m6615boximpl(m6635getZero9UxMQ8M);
            }
        }
        nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, continuation);
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$122 = nestedScrollDispatcher$dispatchPostFling$1;
        Object obj2 = nestedScrollDispatcher$dispatchPostFling$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = nestedScrollDispatcher$dispatchPostFling$122.label;
        if (i != 0) {
        }
        m6635getZero9UxMQ8M = ((Velocity) obj2).getPackedValue();
        return Velocity.m6615boximpl(m6635getZero9UxMQ8M);
    }
}
