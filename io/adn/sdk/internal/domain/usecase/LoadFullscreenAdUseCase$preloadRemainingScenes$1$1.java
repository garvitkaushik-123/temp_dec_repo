package io.adn.sdk.internal.domain.usecase;

import android.app.Activity;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LoadFullscreenAdUseCase.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.domain.usecase.LoadFullscreenAdUseCase$preloadRemainingScenes$1$1", f = "LoadFullscreenAdUseCase.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class LoadFullscreenAdUseCase$preloadRemainingScenes$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ FullscreenAdScene $scene;
    int label;
    final /* synthetic */ LoadFullscreenAdUseCase this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoadFullscreenAdUseCase$preloadRemainingScenes$1$1(LoadFullscreenAdUseCase loadFullscreenAdUseCase, Activity activity, FullscreenAdScene fullscreenAdScene, Continuation<? super LoadFullscreenAdUseCase$preloadRemainingScenes$1$1> continuation) {
        super(2, continuation);
        this.this$0 = loadFullscreenAdUseCase;
        this.$activity = activity;
        this.$scene = fullscreenAdScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LoadFullscreenAdUseCase$preloadRemainingScenes$1$1(this.this$0, this.$activity, this.$scene, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LoadFullscreenAdUseCase$preloadRemainingScenes$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m9508loadSceneWithDiagnostics0E7RQCE;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            m9508loadSceneWithDiagnostics0E7RQCE = this.this$0.m9508loadSceneWithDiagnostics0E7RQCE(this.$activity, this.$scene, this);
            if (m9508loadSceneWithDiagnostics0E7RQCE == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((Result) obj).getValue();
        }
        return Unit.INSTANCE;
    }
}
