package io.adn.sdk.internal.domain.repository;

import android.app.Activity;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.LoadedFile;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* compiled from: FullscreenAdSceneLoader.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH¦@¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0006\u0010\u0011\u001a\u00020\u000eH¦@¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0011\u001a\u00020\u000eH&¨\u0006\u0016"}, d2 = {"Lio/adn/sdk/internal/domain/repository/FullscreenAdSceneLoader;", "", "loadSceneAssets", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "activity", "Landroid/app/Activity;", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "loadSceneAssets-0E7RQCE", "(Landroid/app/Activity;Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeSceneAssets", "", "uuid", "", "loadPromotedAppAsset", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "assetUrl", "loadPromotedAppAsset-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPromotedAppAsset", "Ljava/io/File;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface FullscreenAdSceneLoader {
    File getPromotedAppAsset(String assetUrl);

    /* renamed from: loadPromotedAppAsset-gIAlu-s */
    Object mo9492loadPromotedAppAssetgIAlus(String str, Continuation<? super Result<LoadedFile>> continuation);

    /* renamed from: loadSceneAssets-0E7RQCE */
    Object mo9493loadSceneAssets0E7RQCE(Activity activity, FullscreenAdScene fullscreenAdScene, Continuation<? super Result<? extends SceneAsset>> continuation);

    void removeSceneAssets(String uuid);
}
