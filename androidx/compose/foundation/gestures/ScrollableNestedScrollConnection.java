package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J#\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012J*\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\"\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "scrollingLogic", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "enabled", "", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Z)V", "getEnabled", "()Z", "setEnabled", "(Z)V", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollingLogic;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    private boolean enabled;
    private final ScrollingLogic scrollingLogic;

    public ScrollableNestedScrollConnection(ScrollingLogic scrollingLogic, boolean z) {
        this.scrollingLogic = scrollingLogic;
        this.enabled = z;
    }

    public final ScrollingLogic getScrollingLogic() {
        return this.scrollingLogic;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final void setEnabled(boolean z) {
        this.enabled = z;
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk, reason: not valid java name */
    public long mo718onPreScrollOzD1aCk(long available, int source) {
        if (NestedScrollSource.m5096equalsimpl0(source, NestedScrollSource.INSTANCE.m5102getFlingWNlRxjI())) {
            this.scrollingLogic.registerNestedFling(true);
        }
        return Offset.INSTANCE.m3838getZeroF1C5BW0();
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long mo717onPostScrollDzOQY0M(long consumed, long available, int source) {
        if (this.enabled) {
            return this.scrollingLogic.m722performRawScrollMKHz9U(available);
        }
        return Offset.INSTANCE.m3838getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo716onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        ScrollableNestedScrollConnection$onPostFling$1 scrollableNestedScrollConnection$onPostFling$1;
        int i;
        long m6635getZero9UxMQ8M;
        ScrollableNestedScrollConnection scrollableNestedScrollConnection;
        if (continuation instanceof ScrollableNestedScrollConnection$onPostFling$1) {
            scrollableNestedScrollConnection$onPostFling$1 = (ScrollableNestedScrollConnection$onPostFling$1) continuation;
            if ((scrollableNestedScrollConnection$onPostFling$1.label & Integer.MIN_VALUE) != 0) {
                scrollableNestedScrollConnection$onPostFling$1.label -= Integer.MIN_VALUE;
                Object obj = scrollableNestedScrollConnection$onPostFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = scrollableNestedScrollConnection$onPostFling$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.enabled) {
                        ScrollingLogic scrollingLogic = this.scrollingLogic;
                        scrollableNestedScrollConnection$onPostFling$1.L$0 = this;
                        scrollableNestedScrollConnection$onPostFling$1.J$0 = j2;
                        scrollableNestedScrollConnection$onPostFling$1.label = 1;
                        obj = scrollingLogic.m720doFlingAnimationQWom1Mo(j2, scrollableNestedScrollConnection$onPostFling$1);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        scrollableNestedScrollConnection = this;
                    } else {
                        m6635getZero9UxMQ8M = Velocity.INSTANCE.m6635getZero9UxMQ8M();
                        scrollableNestedScrollConnection = this;
                        Velocity m6615boximpl = Velocity.m6615boximpl(m6635getZero9UxMQ8M);
                        m6615boximpl.getPackedValue();
                        scrollableNestedScrollConnection.scrollingLogic.registerNestedFling(false);
                        return m6615boximpl;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j2 = scrollableNestedScrollConnection$onPostFling$1.J$0;
                    scrollableNestedScrollConnection = (ScrollableNestedScrollConnection) scrollableNestedScrollConnection$onPostFling$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                m6635getZero9UxMQ8M = Velocity.m6627minusAH228Gc(j2, ((Velocity) obj).getPackedValue());
                Velocity m6615boximpl2 = Velocity.m6615boximpl(m6635getZero9UxMQ8M);
                m6615boximpl2.getPackedValue();
                scrollableNestedScrollConnection.scrollingLogic.registerNestedFling(false);
                return m6615boximpl2;
            }
        }
        scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, continuation);
        Object obj2 = scrollableNestedScrollConnection$onPostFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = scrollableNestedScrollConnection$onPostFling$1.label;
        if (i != 0) {
        }
        m6635getZero9UxMQ8M = Velocity.m6627minusAH228Gc(j2, ((Velocity) obj2).getPackedValue());
        Velocity m6615boximpl22 = Velocity.m6615boximpl(m6635getZero9UxMQ8M);
        m6615boximpl22.getPackedValue();
        scrollableNestedScrollConnection.scrollingLogic.registerNestedFling(false);
        return m6615boximpl22;
    }
}
