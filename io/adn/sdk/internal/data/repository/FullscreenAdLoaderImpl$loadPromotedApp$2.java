package io.adn.sdk.internal.data.repository;

import io.adn.sdk.internal.domain.model.ad.AdPromotedApp;
import io.adn.sdk.internal.domain.model.ad.LoadedFile;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "io.adn.sdk.internal.data.repository.FullscreenAdLoaderImpl$loadPromotedApp$2", f = "FullscreenAdLoader.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
final class FullscreenAdLoaderImpl$loadPromotedApp$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends LoadedFile>>, Object> {
    final /* synthetic */ AdPromotedApp $promotedApp;
    int label;
    final /* synthetic */ FullscreenAdLoaderImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FullscreenAdLoaderImpl$loadPromotedApp$2(AdPromotedApp adPromotedApp, FullscreenAdLoaderImpl fullscreenAdLoaderImpl, Continuation<? super FullscreenAdLoaderImpl$loadPromotedApp$2> continuation) {
        super(2, continuation);
        this.$promotedApp = adPromotedApp;
        this.this$0 = fullscreenAdLoaderImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FullscreenAdLoaderImpl$loadPromotedApp$2(this.$promotedApp, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends LoadedFile>> continuation) {
        return invoke2(coroutineScope, (Continuation<? super Result<LoadedFile>>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<? super Result<LoadedFile>> continuation) {
        return ((FullscreenAdLoaderImpl$loadPromotedApp$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        FullscreenAdSceneLoader fullscreenAdSceneLoader;
        Object mo9492loadPromotedAppAssetgIAlus;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String iconUrl = this.$promotedApp.getIconUrl();
            if (iconUrl == null) {
                return null;
            }
            fullscreenAdSceneLoader = this.this$0.sceneLoader;
            this.label = 1;
            mo9492loadPromotedAppAssetgIAlus = fullscreenAdSceneLoader.mo9492loadPromotedAppAssetgIAlus(iconUrl, this);
            if (mo9492loadPromotedAppAssetgIAlus == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            mo9492loadPromotedAppAssetgIAlus = ((Result) obj).getValue();
        }
        return Result.m10240boximpl(mo9492loadPromotedAppAssetgIAlus);
    }
}
