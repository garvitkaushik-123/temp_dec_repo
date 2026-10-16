package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.ui.unit.Density;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* compiled from: LazyAnimateScroll.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Landroidx/compose/foundation/gestures/ScrollScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", f = "LazyAnimateScroll.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1}, l = {182, 280}, m = "invokeSuspend", n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "minDistancePx", ToolBar.FORWARD, "$this$scroll"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "F$2", "I$0", "L$0"})
/* loaded from: classes.dex */
final class LazyAnimateScrollKt$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Density $density;
    final /* synthetic */ int $index;
    final /* synthetic */ int $numOfItemsForTeleport;
    final /* synthetic */ int $scrollOffset;
    final /* synthetic */ LazyLayoutAnimateScrollScope $this_animateScrollToItem;
    float F$0;
    float F$1;
    float F$2;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyAnimateScrollKt$animateScrollToItem$2(int i, Density density, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i2, int i3, Continuation<? super LazyAnimateScrollKt$animateScrollToItem$2> continuation) {
        super(2, continuation);
        this.$index = i;
        this.$density = density;
        this.$this_animateScrollToItem = lazyLayoutAnimateScrollScope;
        this.$scrollOffset = i2;
        this.$numOfItemsForTeleport = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2 = new LazyAnimateScrollKt$animateScrollToItem$2(this.$index, this.$density, this.$this_animateScrollToItem, this.$scrollOffset, this.$numOfItemsForTeleport, continuation);
        lazyAnimateScrollKt$animateScrollToItem$2.L$0 = obj;
        return lazyAnimateScrollKt$animateScrollToItem$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ScrollScope scrollScope, Continuation<? super Unit> continuation) {
        return ((LazyAnimateScrollKt$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c5 A[Catch: ItemFoundInScroll -> 0x0045, TryCatch #0 {ItemFoundInScroll -> 0x0045, blocks: (B:14:0x003a, B:19:0x00c1, B:21:0x00c5, B:23:0x00cd, B:25:0x00df, B:28:0x00f1, B:32:0x0135), top: B:13:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00df A[Catch: ItemFoundInScroll -> 0x0045, TryCatch #0 {ItemFoundInScroll -> 0x0045, blocks: (B:14:0x003a, B:19:0x00c1, B:21:0x00c5, B:23:0x00cd, B:25:0x00df, B:28:0x00f1, B:32:0x0135), top: B:13:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x018a  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ea  */
    /* JADX WARN: Type inference failed for: r10v6, types: [T, androidx.compose.animation.core.AnimationState] */
    /* JADX WARN: Type inference failed for: r12v1, types: [T, androidx.compose.animation.core.AnimationState] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x018a -> B:16:0x018d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        float f;
        final ScrollScope scrollScope;
        float f2;
        float mo630toPx0680j_4;
        float f3;
        float mo630toPx0680j_42;
        float f4;
        float mo630toPx0680j_43;
        Ref.BooleanRef booleanRef;
        Ref.ObjectRef objectRef;
        final float f5;
        final Ref.BooleanRef booleanRef2;
        final Ref.IntRef intRef;
        float f6;
        float f7;
        int i;
        AnimationState copy$default;
        final float itemOffset;
        final Ref.FloatRef floatRef;
        Float boxFloat;
        boolean z;
        ScrollScope scrollScope2;
        float f8;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        float f9 = 0.0f;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            ScrollScope scrollScope3 = (ScrollScope) this.L$0;
            int i3 = this.$index;
            if (!(((float) i3) >= 0.0f)) {
                throw new IllegalArgumentException(("Index should be non-negative (" + i3 + ')').toString());
            }
            try {
                Density density = this.$density;
                f2 = LazyAnimateScrollKt.TargetDistance;
                mo630toPx0680j_4 = density.mo630toPx0680j_4(f2);
                Density density2 = this.$density;
                f3 = LazyAnimateScrollKt.BoundDistance;
                mo630toPx0680j_42 = density2.mo630toPx0680j_4(f3);
                Density density3 = this.$density;
                f4 = LazyAnimateScrollKt.MinimumDistance;
                mo630toPx0680j_43 = density3.mo630toPx0680j_4(f4);
                booleanRef = new Ref.BooleanRef();
                booleanRef.element = true;
                objectRef = new Ref.ObjectRef();
                objectRef.element = AnimationStateKt.AnimationState$default(0.0f, 0.0f, 0L, 0L, false, 30, null);
            } catch (ItemFoundInScroll e) {
                e = e;
                f = 0.0f;
            }
            if (LazyAnimateScrollKt.isItemVisible(this.$this_animateScrollToItem, this.$index)) {
                f = 0.0f;
                try {
                    throw new ItemFoundInScroll(this.$this_animateScrollToItem.getVisibleItemScrollOffset(this.$index), (AnimationState) objectRef.element);
                } catch (ItemFoundInScroll e2) {
                    e = e2;
                    scrollScope = scrollScope3;
                    copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                    itemOffset = e.getItemOffset() + this.$scrollOffset;
                    floatRef = new Ref.FloatRef();
                    boxFloat = Boxing.boxFloat(itemOffset);
                    if (((Number) copy$default.getVelocity()).floatValue() == f) {
                    }
                    this.L$0 = scrollScope;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.label = 2;
                    if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, !z, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.5
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                            invoke2(animationScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                            float f10 = itemOffset;
                            float f11 = 0.0f;
                            if (f10 > 0.0f) {
                                f11 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset);
                            } else if (f10 < 0.0f) {
                                f11 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset);
                            }
                            float f12 = f11 - floatRef.element;
                            if (f12 != scrollScope.scrollBy(f12) || f11 != animationScope.getValue().floatValue()) {
                                animationScope.cancelAnimation();
                            }
                            floatRef.element += f12;
                        }
                    }, this, 2, null) != coroutine_suspended) {
                    }
                    return coroutine_suspended;
                }
            }
            int i4 = this.$index > this.$this_animateScrollToItem.getFirstVisibleItemIndex() ? 1 : 0;
            Ref.IntRef intRef2 = new Ref.IntRef();
            intRef2.element = 1;
            f5 = mo630toPx0680j_42;
            booleanRef2 = booleanRef;
            intRef = intRef2;
            f6 = mo630toPx0680j_4;
            scrollScope = scrollScope3;
            f7 = mo630toPx0680j_43;
            i = i4;
            if (booleanRef2.element) {
            }
            return Unit.INSTANCE;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            scrollScope2 = (ScrollScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            this.$this_animateScrollToItem.snapToItem(scrollScope2, this.$index, this.$scrollOffset);
            return Unit.INSTANCE;
        }
        i = this.I$0;
        f7 = this.F$2;
        float f10 = this.F$1;
        float f11 = this.F$0;
        Ref.IntRef intRef3 = (Ref.IntRef) this.L$3;
        objectRef = (Ref.ObjectRef) this.L$2;
        Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) this.L$1;
        scrollScope = (ScrollScope) this.L$0;
        try {
            ResultKt.throwOnFailure(obj);
            f = 0.0f;
            f5 = f10;
            f6 = f11;
            booleanRef2 = booleanRef3;
        } catch (ItemFoundInScroll e3) {
            e = e3;
            f = f9;
            copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
            itemOffset = e.getItemOffset() + this.$scrollOffset;
            floatRef = new Ref.FloatRef();
            boxFloat = Boxing.boxFloat(itemOffset);
            z = ((Number) copy$default.getVelocity()).floatValue() == f;
            this.L$0 = scrollScope;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, !z, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                    invoke2(animationScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                    float f102 = itemOffset;
                    float f112 = 0.0f;
                    if (f102 > 0.0f) {
                        f112 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset);
                    } else if (f102 < 0.0f) {
                        f112 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset);
                    }
                    float f12 = f112 - floatRef.element;
                    if (f12 != scrollScope.scrollBy(f12) || f112 != animationScope.getValue().floatValue()) {
                        animationScope.cancelAnimation();
                    }
                    floatRef.element += f12;
                }
            }, this, 2, null) != coroutine_suspended) {
                scrollScope2 = scrollScope;
                this.$this_animateScrollToItem.snapToItem(scrollScope2, this.$index, this.$scrollOffset);
                return Unit.INSTANCE;
            }
            return coroutine_suspended;
        }
        try {
            intRef3.element++;
            intRef = intRef3;
            f9 = f;
        } catch (ItemFoundInScroll e4) {
            e = e4;
            copy$default = AnimationStateKt.copy$default((AnimationState) e.getPreviousAnimation(), 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
            itemOffset = e.getItemOffset() + this.$scrollOffset;
            floatRef = new Ref.FloatRef();
            boxFloat = Boxing.boxFloat(itemOffset);
            if (((Number) copy$default.getVelocity()).floatValue() == f) {
            }
            this.L$0 = scrollScope;
            this.L$1 = null;
            this.L$2 = null;
            this.L$3 = null;
            this.label = 2;
            if (SuspendAnimationKt.animateTo$default(copy$default, boxFloat, null, !z, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                    invoke2(animationScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                    float f102 = itemOffset;
                    float f112 = 0.0f;
                    if (f102 > 0.0f) {
                        f112 = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), itemOffset);
                    } else if (f102 < 0.0f) {
                        f112 = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), itemOffset);
                    }
                    float f12 = f112 - floatRef.element;
                    if (f12 != scrollScope.scrollBy(f12) || f112 != animationScope.getValue().floatValue()) {
                        animationScope.cancelAnimation();
                    }
                    floatRef.element += f12;
                }
            }, this, 2, null) != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (booleanRef2.element && this.$this_animateScrollToItem.getItemCount() > 0) {
            float calculateDistanceTo = this.$this_animateScrollToItem.calculateDistanceTo(this.$index, this.$scrollOffset);
            if (Math.abs(calculateDistanceTo) >= f6) {
                f8 = i != 0 ? f6 : -f6;
            } else {
                f8 = Math.max(Math.abs(calculateDistanceTo), f7);
                if (i == 0) {
                    f8 = -f8;
                }
            }
            objectRef.element = AnimationStateKt.copy$default((AnimationState) objectRef.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
            final Ref.FloatRef floatRef2 = new Ref.FloatRef();
            AnimationState animationState = (AnimationState) objectRef.element;
            Float boxFloat2 = Boxing.boxFloat(f8);
            boolean z2 = ((Number) ((AnimationState) objectRef.element).getVelocity()).floatValue() == f9;
            float f12 = f6;
            final Ref.ObjectRef objectRef2 = objectRef;
            final float f13 = f8;
            final LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope = this.$this_animateScrollToItem;
            final int i5 = this.$index;
            final boolean z3 = i == 0;
            f = f9;
            final int i6 = this.$numOfItemsForTeleport;
            final int i7 = this.$scrollOffset;
            Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                    invoke2(animationScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                    float coerceAtLeast;
                    if (!LazyAnimateScrollKt.isItemVisible(LazyLayoutAnimateScrollScope.this, i5)) {
                        if (f13 > 0.0f) {
                            coerceAtLeast = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), f13);
                        } else {
                            coerceAtLeast = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), f13);
                        }
                        float f14 = coerceAtLeast - floatRef2.element;
                        float scrollBy = scrollScope.scrollBy(f14);
                        if (!LazyAnimateScrollKt.isItemVisible(LazyLayoutAnimateScrollScope.this, i5) && !LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend$isOvershot(z3, LazyLayoutAnimateScrollScope.this, i5, i7)) {
                            if (f14 != scrollBy) {
                                animationScope.cancelAnimation();
                                booleanRef2.element = false;
                                return;
                            }
                            floatRef2.element += f14;
                            if (z3) {
                                if (animationScope.getValue().floatValue() > f5) {
                                    animationScope.cancelAnimation();
                                }
                            } else if (animationScope.getValue().floatValue() < (-f5)) {
                                animationScope.cancelAnimation();
                            }
                            if (z3) {
                                if (intRef.element >= 2) {
                                    int lastVisibleItemIndex = i5 - LazyLayoutAnimateScrollScope.this.getLastVisibleItemIndex();
                                    int i8 = i6;
                                    if (lastVisibleItemIndex > i8) {
                                        LazyLayoutAnimateScrollScope.this.snapToItem(scrollScope, i5 - i8, 0);
                                    }
                                }
                            } else if (intRef.element >= 2) {
                                int firstVisibleItemIndex = LazyLayoutAnimateScrollScope.this.getFirstVisibleItemIndex();
                                int i9 = i5;
                                int i10 = firstVisibleItemIndex - i9;
                                int i11 = i6;
                                if (i10 > i11) {
                                    LazyLayoutAnimateScrollScope.this.snapToItem(scrollScope, i9 + i11, 0);
                                }
                            }
                        }
                    }
                    if (LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend$isOvershot(z3, LazyLayoutAnimateScrollScope.this, i5, i7)) {
                        LazyLayoutAnimateScrollScope.this.snapToItem(scrollScope, i5, i7);
                        booleanRef2.element = false;
                        animationScope.cancelAnimation();
                        return;
                    }
                    if (LazyAnimateScrollKt.isItemVisible(LazyLayoutAnimateScrollScope.this, i5)) {
                        throw new ItemFoundInScroll(LazyLayoutAnimateScrollScope.this.getVisibleItemScrollOffset(i5), objectRef2.element);
                    }
                }
            };
            float f14 = f5;
            intRef3 = intRef;
            objectRef = objectRef2;
            this.L$0 = scrollScope;
            this.L$1 = booleanRef2;
            this.L$2 = objectRef;
            this.L$3 = intRef3;
            this.F$0 = f12;
            this.F$1 = f14;
            this.F$2 = f7;
            this.I$0 = i;
            this.label = 1;
            if (SuspendAnimationKt.animateTo$default(animationState, boxFloat2, null, z2, function1, this, 2, null) != coroutine_suspended) {
                return coroutine_suspended;
            }
            f5 = f14;
            f6 = f12;
            intRef3.element++;
            intRef = intRef3;
            f9 = f;
            if (booleanRef2.element) {
                float calculateDistanceTo2 = this.$this_animateScrollToItem.calculateDistanceTo(this.$index, this.$scrollOffset);
                if (Math.abs(calculateDistanceTo2) >= f6) {
                }
                objectRef.element = AnimationStateKt.copy$default((AnimationState) objectRef.element, 0.0f, 0.0f, 0L, 0L, false, 30, (Object) null);
                final Ref.FloatRef floatRef22 = new Ref.FloatRef();
                AnimationState animationState2 = (AnimationState) objectRef.element;
                Float boxFloat22 = Boxing.boxFloat(f8);
                if (((Number) ((AnimationState) objectRef.element).getVelocity()).floatValue() == f9) {
                }
                float f122 = f6;
                final Ref.ObjectRef<AnimationState<Float, AnimationVector1D>> objectRef22 = objectRef;
                final float f132 = f8;
                final LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope2 = this.$this_animateScrollToItem;
                final int i52 = this.$index;
                if (i == 0) {
                }
                f = f9;
                final int i62 = this.$numOfItemsForTeleport;
                final int i72 = this.$scrollOffset;
                Function1<AnimationScope<Float, AnimationVector1D>, Unit> function12 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(AnimationScope<Float, AnimationVector1D> animationScope) {
                        invoke2(animationScope);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(AnimationScope<Float, AnimationVector1D> animationScope) {
                        float coerceAtLeast;
                        if (!LazyAnimateScrollKt.isItemVisible(LazyLayoutAnimateScrollScope.this, i52)) {
                            if (f132 > 0.0f) {
                                coerceAtLeast = RangesKt.coerceAtMost(animationScope.getValue().floatValue(), f132);
                            } else {
                                coerceAtLeast = RangesKt.coerceAtLeast(animationScope.getValue().floatValue(), f132);
                            }
                            float f142 = coerceAtLeast - floatRef22.element;
                            float scrollBy = scrollScope.scrollBy(f142);
                            if (!LazyAnimateScrollKt.isItemVisible(LazyLayoutAnimateScrollScope.this, i52) && !LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend$isOvershot(z3, LazyLayoutAnimateScrollScope.this, i52, i72)) {
                                if (f142 != scrollBy) {
                                    animationScope.cancelAnimation();
                                    booleanRef2.element = false;
                                    return;
                                }
                                floatRef22.element += f142;
                                if (z3) {
                                    if (animationScope.getValue().floatValue() > f5) {
                                        animationScope.cancelAnimation();
                                    }
                                } else if (animationScope.getValue().floatValue() < (-f5)) {
                                    animationScope.cancelAnimation();
                                }
                                if (z3) {
                                    if (intRef.element >= 2) {
                                        int lastVisibleItemIndex = i52 - LazyLayoutAnimateScrollScope.this.getLastVisibleItemIndex();
                                        int i8 = i62;
                                        if (lastVisibleItemIndex > i8) {
                                            LazyLayoutAnimateScrollScope.this.snapToItem(scrollScope, i52 - i8, 0);
                                        }
                                    }
                                } else if (intRef.element >= 2) {
                                    int firstVisibleItemIndex = LazyLayoutAnimateScrollScope.this.getFirstVisibleItemIndex();
                                    int i9 = i52;
                                    int i10 = firstVisibleItemIndex - i9;
                                    int i11 = i62;
                                    if (i10 > i11) {
                                        LazyLayoutAnimateScrollScope.this.snapToItem(scrollScope, i9 + i11, 0);
                                    }
                                }
                            }
                        }
                        if (LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend$isOvershot(z3, LazyLayoutAnimateScrollScope.this, i52, i72)) {
                            LazyLayoutAnimateScrollScope.this.snapToItem(scrollScope, i52, i72);
                            booleanRef2.element = false;
                            animationScope.cancelAnimation();
                            return;
                        }
                        if (LazyAnimateScrollKt.isItemVisible(LazyLayoutAnimateScrollScope.this, i52)) {
                            throw new ItemFoundInScroll(LazyLayoutAnimateScrollScope.this.getVisibleItemScrollOffset(i52), objectRef22.element);
                        }
                    }
                };
                float f142 = f5;
                intRef3 = intRef;
                objectRef = objectRef22;
                this.L$0 = scrollScope;
                this.L$1 = booleanRef2;
                this.L$2 = objectRef;
                this.L$3 = intRef3;
                this.F$0 = f122;
                this.F$1 = f142;
                this.F$2 = f7;
                this.I$0 = i;
                this.label = 1;
                if (SuspendAnimationKt.animateTo$default(animationState2, boxFloat22, null, z2, function12, this, 2, null) != coroutine_suspended) {
                }
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean invokeSuspend$isOvershot(boolean z, LazyLayoutAnimateScrollScope lazyLayoutAnimateScrollScope, int i, int i2) {
        if (z) {
            if (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() > i) {
                return true;
            }
            return lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutAnimateScrollScope.getFirstVisibleItemScrollOffset() > i2;
        }
        if (lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() < i) {
            return true;
        }
        return lazyLayoutAnimateScrollScope.getFirstVisibleItemIndex() == i && lazyLayoutAnimateScrollScope.getFirstVisibleItemScrollOffset() < i2;
    }
}
