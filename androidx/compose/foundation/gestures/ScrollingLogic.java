package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: Scrollable.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000f\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0019H\u0086@ø\u0001\u0000¢\u0006\u0004\b \u0010\u001cJ\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u000e\u0010&\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020\tJ\u0006\u0010(\u001a\u00020\tJ8\u0010)\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ$\u0010*\u001a\u00020\"*\u00020+2\u0006\u0010,\u001a\u00020\"2\u0006\u0010-\u001a\u00020.ø\u0001\u0000¢\u0006\u0004\b/\u00100J\u0014\u00101\u001a\u00020\"*\u00020\"ø\u0001\u0000¢\u0006\u0004\b2\u0010%J\n\u00101\u001a\u000203*\u000203J\u0014\u00104\u001a\u00020\"*\u00020\"ø\u0001\u0000¢\u0006\u0004\b5\u0010%J\u0014\u00106\u001a\u00020\u0019*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b7\u0010%J\u0014\u00108\u001a\u000203*\u00020\"ø\u0001\u0000¢\u0006\u0004\b9\u0010:J\u0014\u00108\u001a\u000203*\u00020\u0019ø\u0001\u0000¢\u0006\u0004\b;\u0010:J\u0017\u0010<\u001a\u00020\"*\u000203ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b=\u0010>J\u001c\u0010)\u001a\u00020\u0019*\u00020\u00192\u0006\u0010?\u001a\u000203ø\u0001\u0000¢\u0006\u0004\b@\u0010AR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006B"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollingLogic;", "", "scrollableState", "Landroidx/compose/foundation/gestures/ScrollableState;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "overscrollEffect", "Landroidx/compose/foundation/OverscrollEffect;", "reverseDirection", "", "flingBehavior", "Landroidx/compose/foundation/gestures/FlingBehavior;", "nestedScrollDispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "(Landroidx/compose/foundation/gestures/ScrollableState;Landroidx/compose/foundation/gestures/Orientation;Landroidx/compose/foundation/OverscrollEffect;ZLandroidx/compose/foundation/gestures/FlingBehavior;Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;)V", "isNestedFlinging", "Landroidx/compose/runtime/MutableState;", "getScrollableState", "()Landroidx/compose/foundation/gestures/ScrollableState;", "setScrollableState", "(Landroidx/compose/foundation/gestures/ScrollableState;)V", "shouldDispatchOverscroll", "getShouldDispatchOverscroll", "()Z", "doFlingAnimation", "Landroidx/compose/ui/unit/Velocity;", "available", "doFlingAnimation-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDragStopped", "", "initialVelocity", "onDragStopped-sF-c-tU", "performRawScroll", "Landroidx/compose/ui/geometry/Offset;", "scroll", "performRawScroll-MK-Hz9U", "(J)J", "registerNestedFling", "isFlinging", "shouldScrollImmediately", "update", "dispatchScroll", "Landroidx/compose/foundation/gestures/ScrollScope;", "initialAvailableDelta", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "dispatchScroll-3eAAhYA", "(Landroidx/compose/foundation/gestures/ScrollScope;JI)J", "reverseIfNeeded", "reverseIfNeeded-MK-Hz9U", "", "singleAxisOffset", "singleAxisOffset-MK-Hz9U", "singleAxisVelocity", "singleAxisVelocity-AH228Gc", "toFloat", "toFloat-k-4lQ0M", "(J)F", "toFloat-TH1AsA0", "toOffset", "toOffset-tuRUvjQ", "(F)J", "newValue", "update-QWom1Mo", "(JF)J", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class ScrollingLogic {
    private FlingBehavior flingBehavior;
    private final MutableState<Boolean> isNestedFlinging = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
    private NestedScrollDispatcher nestedScrollDispatcher;
    private Orientation orientation;
    private OverscrollEffect overscrollEffect;
    private boolean reverseDirection;
    private ScrollableState scrollableState;

    public ScrollingLogic(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean z, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        this.scrollableState = scrollableState;
        this.orientation = orientation;
        this.overscrollEffect = overscrollEffect;
        this.reverseDirection = z;
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
    }

    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    public final void setScrollableState(ScrollableState scrollableState) {
        this.scrollableState = scrollableState;
    }

    /* renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m728toOffsettuRUvjQ(float f) {
        if (f == 0.0f) {
            return Offset.INSTANCE.m3838getZeroF1C5BW0();
        }
        return this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f, 0.0f) : OffsetKt.Offset(0.0f, f);
    }

    /* renamed from: singleAxisOffset-MK-Hz9U, reason: not valid java name */
    public final long m724singleAxisOffsetMKHz9U(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3816copydBAh8RU$default(j, 0.0f, 0.0f, 1, null) : Offset.m3816copydBAh8RU$default(j, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m727toFloatk4lQ0M(long j) {
        return this.orientation == Orientation.Horizontal ? Offset.m3822getXimpl(j) : Offset.m3823getYimpl(j);
    }

    /* renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m726toFloatTH1AsA0(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6624getXimpl(j) : Velocity.m6625getYimpl(j);
    }

    /* renamed from: singleAxisVelocity-AH228Gc, reason: not valid java name */
    public final long m725singleAxisVelocityAH228Gc(long j) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6620copyOhffZ5M$default(j, 0.0f, 0.0f, 1, null) : Velocity.m6620copyOhffZ5M$default(j, 0.0f, 0.0f, 2, null);
    }

    /* renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m729updateQWom1Mo(long j, float f) {
        return this.orientation == Orientation.Horizontal ? Velocity.m6620copyOhffZ5M$default(j, f, 0.0f, 2, null) : Velocity.m6620copyOhffZ5M$default(j, 0.0f, f, 1, null);
    }

    public final float reverseIfNeeded(float f) {
        return this.reverseDirection ? f * (-1) : f;
    }

    /* renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m723reverseIfNeededMKHz9U(long j) {
        return this.reverseDirection ? Offset.m3829timestuRUvjQ(j, -1.0f) : j;
    }

    /* renamed from: dispatchScroll-3eAAhYA, reason: not valid java name */
    public final long m719dispatchScroll3eAAhYA(final ScrollScope scrollScope, long j, final int i) {
        Function1<Offset, Offset> function1 = new Function1<Offset, Offset>() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$dispatchScroll$performScroll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Offset invoke(Offset offset) {
                return Offset.m3811boximpl(m730invokeMKHz9U(offset.getPackedValue()));
            }

            /* renamed from: invoke-MK-Hz9U, reason: not valid java name */
            public final long m730invokeMKHz9U(long j2) {
                NestedScrollDispatcher nestedScrollDispatcher;
                NestedScrollDispatcher nestedScrollDispatcher2;
                nestedScrollDispatcher = ScrollingLogic.this.nestedScrollDispatcher;
                long m5092dispatchPreScrollOzD1aCk = nestedScrollDispatcher.m5092dispatchPreScrollOzD1aCk(j2, i);
                long m3826minusMKHz9U = Offset.m3826minusMKHz9U(j2, m5092dispatchPreScrollOzD1aCk);
                ScrollingLogic scrollingLogic = ScrollingLogic.this;
                float m727toFloatk4lQ0M = scrollingLogic.m727toFloatk4lQ0M(scrollingLogic.m723reverseIfNeededMKHz9U(scrollingLogic.m724singleAxisOffsetMKHz9U(m3826minusMKHz9U)));
                ScrollingLogic scrollingLogic2 = ScrollingLogic.this;
                long m723reverseIfNeededMKHz9U = scrollingLogic2.m723reverseIfNeededMKHz9U(scrollingLogic2.m728toOffsettuRUvjQ(scrollScope.scrollBy(m727toFloatk4lQ0M)));
                long m3826minusMKHz9U2 = Offset.m3826minusMKHz9U(m3826minusMKHz9U, m723reverseIfNeededMKHz9U);
                nestedScrollDispatcher2 = ScrollingLogic.this.nestedScrollDispatcher;
                return Offset.m3827plusMKHz9U(Offset.m3827plusMKHz9U(m5092dispatchPreScrollOzD1aCk, m723reverseIfNeededMKHz9U), nestedScrollDispatcher2.m5090dispatchPostScrollDzOQY0M(m723reverseIfNeededMKHz9U, m3826minusMKHz9U2, i));
            }
        };
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        if (NestedScrollSource.m5096equalsimpl0(i, NestedScrollSource.INSTANCE.m5104getWheelWNlRxjI())) {
            return function1.invoke(Offset.m3811boximpl(j)).getPackedValue();
        }
        if (overscrollEffect != null && getShouldDispatchOverscroll()) {
            return overscrollEffect.mo508applyToScrollRhakbz0(j, i, function1);
        }
        return function1.invoke(Offset.m3811boximpl(j)).getPackedValue();
    }

    private final boolean getShouldDispatchOverscroll() {
        return this.scrollableState.getCanScrollForward() || this.scrollableState.getCanScrollBackward();
    }

    /* renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m722performRawScrollMKHz9U(long scroll) {
        if (this.scrollableState.isScrollInProgress()) {
            return Offset.INSTANCE.m3838getZeroF1C5BW0();
        }
        return m728toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m727toFloatk4lQ0M(scroll)))));
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
    
        if (r2.mo507applyToFlingBMRW4eQ(r7, r9, r0) == r1) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
    
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0071, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
    
        if (r9.invoke(r7, r0) == r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: onDragStopped-sF-c-tU, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m721onDragStoppedsFctU(long j, Continuation<? super Unit> continuation) {
        ScrollingLogic$onDragStopped$1 scrollingLogic$onDragStopped$1;
        int i;
        ScrollingLogic scrollingLogic;
        if (continuation instanceof ScrollingLogic$onDragStopped$1) {
            scrollingLogic$onDragStopped$1 = (ScrollingLogic$onDragStopped$1) continuation;
            if ((scrollingLogic$onDragStopped$1.label & Integer.MIN_VALUE) != 0) {
                scrollingLogic$onDragStopped$1.label -= Integer.MIN_VALUE;
                Object obj = scrollingLogic$onDragStopped$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = scrollingLogic$onDragStopped$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    registerNestedFling(true);
                    long m725singleAxisVelocityAH228Gc = m725singleAxisVelocityAH228Gc(j);
                    ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this, null);
                    OverscrollEffect overscrollEffect = this.overscrollEffect;
                    if (overscrollEffect != null && getShouldDispatchOverscroll()) {
                        scrollingLogic$onDragStopped$1.L$0 = this;
                        scrollingLogic$onDragStopped$1.label = 1;
                    } else {
                        Velocity m6615boximpl = Velocity.m6615boximpl(m725singleAxisVelocityAH228Gc);
                        scrollingLogic$onDragStopped$1.L$0 = this;
                        scrollingLogic$onDragStopped$1.label = 2;
                    }
                } else {
                    if (i != 1 && i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    scrollingLogic = (ScrollingLogic) scrollingLogic$onDragStopped$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                scrollingLogic.registerNestedFling(false);
                return Unit.INSTANCE;
            }
        }
        scrollingLogic$onDragStopped$1 = new ScrollingLogic$onDragStopped$1(this, continuation);
        Object obj2 = scrollingLogic$onDragStopped$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = scrollingLogic$onDragStopped$1.label;
        if (i != 0) {
        }
        scrollingLogic.registerNestedFling(false);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m720doFlingAnimationQWom1Mo(long j, Continuation<? super Velocity> continuation) {
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$1;
        int i;
        Ref.LongRef longRef;
        if (continuation instanceof ScrollingLogic$doFlingAnimation$1) {
            scrollingLogic$doFlingAnimation$1 = (ScrollingLogic$doFlingAnimation$1) continuation;
            if ((scrollingLogic$doFlingAnimation$1.label & Integer.MIN_VALUE) != 0) {
                scrollingLogic$doFlingAnimation$1.label -= Integer.MIN_VALUE;
                ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$12 = scrollingLogic$doFlingAnimation$1;
                Object obj = scrollingLogic$doFlingAnimation$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = scrollingLogic$doFlingAnimation$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Ref.LongRef longRef2 = new Ref.LongRef();
                    longRef2.element = j;
                    ScrollableState scrollableState = this.scrollableState;
                    ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this, longRef2, j, null);
                    scrollingLogic$doFlingAnimation$12.L$0 = longRef2;
                    scrollingLogic$doFlingAnimation$12.label = 1;
                    if (ScrollableState.scroll$default(scrollableState, null, scrollingLogic$doFlingAnimation$2, scrollingLogic$doFlingAnimation$12, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    longRef = longRef2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    longRef = (Ref.LongRef) scrollingLogic$doFlingAnimation$12.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return Velocity.m6615boximpl(longRef.element);
            }
        }
        scrollingLogic$doFlingAnimation$1 = new ScrollingLogic$doFlingAnimation$1(this, continuation);
        ScrollingLogic$doFlingAnimation$1 scrollingLogic$doFlingAnimation$122 = scrollingLogic$doFlingAnimation$1;
        Object obj2 = scrollingLogic$doFlingAnimation$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = scrollingLogic$doFlingAnimation$122.label;
        if (i != 0) {
        }
        return Velocity.m6615boximpl(longRef.element);
    }

    public final boolean shouldScrollImmediately() {
        if (this.scrollableState.isScrollInProgress() || this.isNestedFlinging.getValue().booleanValue()) {
            return true;
        }
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        return overscrollEffect != null ? overscrollEffect.isInProgress() : false;
    }

    public final void registerNestedFling(boolean isFlinging) {
        this.isNestedFlinging.setValue(Boolean.valueOf(isFlinging));
    }

    public final void update(ScrollableState scrollableState, Orientation orientation, OverscrollEffect overscrollEffect, boolean reverseDirection, FlingBehavior flingBehavior, NestedScrollDispatcher nestedScrollDispatcher) {
        this.scrollableState = scrollableState;
        this.orientation = orientation;
        this.overscrollEffect = overscrollEffect;
        this.reverseDirection = reverseDirection;
        this.flingBehavior = flingBehavior;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
    }
}
