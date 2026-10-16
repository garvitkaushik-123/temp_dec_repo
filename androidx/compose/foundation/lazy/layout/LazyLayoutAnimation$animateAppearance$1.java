package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LazyLayoutAnimation.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$1", f = "LazyLayoutAnimation.kt", i = {}, l = {155, 156}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes.dex */
final class LazyLayoutAnimation$animateAppearance$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ FiniteAnimationSpec<Float> $spec;
    int label;
    final /* synthetic */ LazyLayoutAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazyLayoutAnimation$animateAppearance$1(LazyLayoutAnimation lazyLayoutAnimation, FiniteAnimationSpec<Float> finiteAnimationSpec, Continuation<? super LazyLayoutAnimation$animateAppearance$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutAnimation;
        this.$spec = finiteAnimationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutAnimation$animateAppearance$1(this.this$0, this.$spec, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LazyLayoutAnimation$animateAppearance$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0063, code lost:
    
        if (androidx.compose.animation.core.Animatable.animateTo$default(r4, r5, r6, null, new androidx.compose.foundation.lazy.layout.LazyLayoutAnimation$animateAppearance$1.AnonymousClass1(), r12, 4, null) == r0) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Animatable animatable;
        Animatable animatable2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                animatable = this.this$0.visibilityAnimation;
                this.label = 1;
                if (animatable.snapTo(Boxing.boxFloat(0.0f), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    this.this$0.setAppearanceAnimationInProgress(false);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            animatable2 = this.this$0.visibilityAnimation;
            Float boxFloat = Boxing.boxFloat(1.0f);
            FiniteAnimationSpec<Float> finiteAnimationSpec = this.$spec;
            final LazyLayoutAnimation lazyLayoutAnimation = this.this$0;
            this.label = 2;
        } catch (Throwable th) {
            this.this$0.setAppearanceAnimationInProgress(false);
            throw th;
        }
    }
}
