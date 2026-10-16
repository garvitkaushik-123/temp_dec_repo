package io.adn.sdk.internal.domain.usecase;

import android.app.Activity;
import io.adn.sdk.internal.domain.model.ad.AdPromotedApp;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.domain.repository.FullscreenAdSceneLoader;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrepareFullscreenSceneAssetsUseCase.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ&\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/usecase/PrepareFullscreenSceneAssetsUseCase;", "", "loader", "Lio/adn/sdk/internal/domain/repository/FullscreenAdSceneLoader;", "<init>", "(Lio/adn/sdk/internal/domain/repository/FullscreenAdSceneLoader;)V", "loadPromotedAppAsset", "Ljava/io/File;", "promotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "loadSceneAsset", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "activity", "Landroid/app/Activity;", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "loadSceneAsset-0E7RQCE", "(Landroid/app/Activity;Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearSceneAssets", "", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class PrepareFullscreenSceneAssetsUseCase {
    public static final int $stable = 8;
    private final FullscreenAdSceneLoader loader;

    public PrepareFullscreenSceneAssetsUseCase(FullscreenAdSceneLoader loader) {
        Intrinsics.checkNotNullParameter(loader, "loader");
        this.loader = loader;
    }

    public final File loadPromotedAppAsset(AdPromotedApp promotedApp) {
        Intrinsics.checkNotNullParameter(promotedApp, "promotedApp");
        String iconUrl = promotedApp.getIconUrl();
        if (iconUrl != null) {
            return this.loader.getPromotedAppAsset(iconUrl);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: loadSceneAsset-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9510loadSceneAsset0E7RQCE(Activity activity, FullscreenAdScene fullscreenAdScene, Continuation<? super Result<? extends SceneAsset>> continuation) {
        PrepareFullscreenSceneAssetsUseCase$loadSceneAsset$1 prepareFullscreenSceneAssetsUseCase$loadSceneAsset$1;
        int i;
        if (continuation instanceof PrepareFullscreenSceneAssetsUseCase$loadSceneAsset$1) {
            prepareFullscreenSceneAssetsUseCase$loadSceneAsset$1 = (PrepareFullscreenSceneAssetsUseCase$loadSceneAsset$1) continuation;
            if ((prepareFullscreenSceneAssetsUseCase$loadSceneAsset$1.label & Integer.MIN_VALUE) != 0) {
                prepareFullscreenSceneAssetsUseCase$loadSceneAsset$1.label -= Integer.MIN_VALUE;
                Object obj = prepareFullscreenSceneAssetsUseCase$loadSceneAsset$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = prepareFullscreenSceneAssetsUseCase$loadSceneAsset$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return ((Result) obj).getValue();
                }
                ResultKt.throwOnFailure(obj);
                FullscreenAdSceneLoader fullscreenAdSceneLoader = this.loader;
                prepareFullscreenSceneAssetsUseCase$loadSceneAsset$1.label = 1;
                Object mo9493loadSceneAssets0E7RQCE = fullscreenAdSceneLoader.mo9493loadSceneAssets0E7RQCE(activity, fullscreenAdScene, prepareFullscreenSceneAssetsUseCase$loadSceneAsset$1);
                return mo9493loadSceneAssets0E7RQCE == coroutine_suspended ? coroutine_suspended : mo9493loadSceneAssets0E7RQCE;
            }
        }
        prepareFullscreenSceneAssetsUseCase$loadSceneAsset$1 = new PrepareFullscreenSceneAssetsUseCase$loadSceneAsset$1(this, continuation);
        Object obj2 = prepareFullscreenSceneAssetsUseCase$loadSceneAsset$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = prepareFullscreenSceneAssetsUseCase$loadSceneAsset$1.label;
        if (i == 0) {
        }
    }

    public final void clearSceneAssets(FullscreenAdScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.loader.removeSceneAssets(scene.getUuid());
    }
}
