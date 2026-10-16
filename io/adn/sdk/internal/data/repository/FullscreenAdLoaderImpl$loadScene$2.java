package io.adn.sdk.internal.data.repository;

import android.app.Activity;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.domain.repository.FullscreenAdSceneLoader;
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

/* compiled from: FullscreenAdLoader.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.FullscreenAdLoaderImpl$loadScene$2", f = "FullscreenAdLoader.kt", i = {}, l = {31}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class FullscreenAdLoaderImpl$loadScene$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends SceneAsset>>, Object> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ FullscreenAdScene $scene;
    int label;
    final /* synthetic */ FullscreenAdLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenAdLoaderImpl$loadScene$2(FullscreenAdLoaderImpl fullscreenAdLoaderImpl, Activity activity, FullscreenAdScene fullscreenAdScene, Continuation<? super FullscreenAdLoaderImpl$loadScene$2> continuation) {
        super(2, continuation);
        this.this$0 = fullscreenAdLoaderImpl;
        this.$activity = activity;
        this.$scene = fullscreenAdScene;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FullscreenAdLoaderImpl$loadScene$2(this.this$0, this.$activity, this.$scene, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends SceneAsset>> continuation) {
        return ((FullscreenAdLoaderImpl$loadScene$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FullscreenAdSceneLoader fullscreenAdSceneLoader;
        Object mo9493loadSceneAssets0E7RQCE;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            fullscreenAdSceneLoader = this.this$0.sceneLoader;
            this.label = 1;
            mo9493loadSceneAssets0E7RQCE = fullscreenAdSceneLoader.mo9493loadSceneAssets0E7RQCE(this.$activity, this.$scene, this);
            if (mo9493loadSceneAssets0E7RQCE == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            mo9493loadSceneAssets0E7RQCE = ((Result) obj).getValue();
        }
        return Result.m10240boximpl(mo9493loadSceneAssets0E7RQCE);
    }
}
