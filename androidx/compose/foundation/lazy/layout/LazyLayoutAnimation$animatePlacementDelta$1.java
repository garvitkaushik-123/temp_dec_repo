package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.SpringSpec;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import com.vungle.ads.internal.protos.Sdk;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyLayoutAnimation.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animatePlacementDelta$1", f = "LazyLayoutAnimation.kt", i = {0}, l = {127, Sdk.SDKError.Reason.OMSDK_JS_WRITE_FAILED_VALUE}, m = "invokeSuspend", n = {"finalSpec"}, s = {"L$0"})
/* loaded from: classes.dex */
final class LazyLayoutAnimation$animatePlacementDelta$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<IntOffset> $spec;
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutAnimation$animatePlacementDelta$1(LazyLayoutAnimation lazyLayoutAnimation, FiniteAnimationSpec<IntOffset> finiteAnimationSpec, long j, Continuation<? super LazyLayoutAnimation$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutAnimation;
        this.$spec = finiteAnimationSpec;
        this.$totalDelta = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutAnimation$animatePlacementDelta$1(this.this$0, this.$spec, this.$totalDelta, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutAnimation$animatePlacementDelta$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x00b9, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r5, r6, r7, null, new androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animatePlacementDelta$1.AnonymousClass1(), r13, 4, null) == r0) goto L29;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Animatable animatable;
        SpringSpec springSpec;
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec;
        Animatable animatable2;
        Animatable animatable3;
        SpringSpec springSpec2;
        Animatable animatable4;
        Animatable animatable5;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            animatable = this.this$0.placementDeltaAnimation;
            if (animatable.isRunning()) {
                FiniteAnimationSpec<IntOffset> finiteAnimationSpec2 = this.$spec;
                if (!(finiteAnimationSpec2 instanceof SpringSpec)) {
                    springSpec2 = LazyLayoutAnimationKt.InterruptionSpec;
                } else {
                    springSpec2 = (SpringSpec) finiteAnimationSpec2;
                }
                springSpec = springSpec2;
            } else {
                springSpec = this.$spec;
            }
            finiteAnimationSpec = springSpec;
            animatable2 = this.this$0.placementDeltaAnimation;
            if (!animatable2.isRunning()) {
                animatable3 = this.this$0.placementDeltaAnimation;
                this.L$0 = finiteAnimationSpec;
                this.label = 1;
                if (animatable3.snapTo(IntOffset.m6508boximpl(this.$totalDelta), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.this$0.setPlacementAnimationInProgress(false);
                return Unit.INSTANCE;
            }
            finiteAnimationSpec = (FiniteAnimationSpec) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        animatable4 = this.this$0.placementDeltaAnimation;
        long packedValue = ((IntOffset) animatable4.getValue()).getPackedValue();
        long j = this.$totalDelta;
        final long IntOffset = IntOffsetKt.IntOffset(IntOffset.m6517getXimpl(packedValue) - IntOffset.m6517getXimpl(j), IntOffset.m6518getYimpl(packedValue) - IntOffset.m6518getYimpl(j));
        animatable5 = this.this$0.placementDeltaAnimation;
        IntOffset m6508boximpl = IntOffset.m6508boximpl(IntOffset);
        FiniteAnimationSpec<IntOffset> finiteAnimationSpec3 = finiteAnimationSpec;
        final LazyLayoutAnimation lazyLayoutAnimation = this.this$0;
        this.L$0 = null;
        this.label = 2;
    }
}
