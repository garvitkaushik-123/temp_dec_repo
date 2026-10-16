package io.adn.sdk.internal.domain.repository;

import android.app.Activity;
import io.adn.sdk.internal.domain.model.ad.AdPromotedApp;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntity;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: FullscreenAdLoader.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J&\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH¦@¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H¦@¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"Lio/adn/sdk/internal/domain/repository/FullscreenAdLoader;", "", "loadAd", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;", "bidResponse", "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "(Lio/adn/sdk/internal/domain/model/ad/BidResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadScene", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "activity", "Landroid/app/Activity;", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "loadScene-0E7RQCE", "(Landroid/app/Activity;Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPromotedApp", "", "promotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "(Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface FullscreenAdLoader {
    Object loadAd(BidResponse bidResponse, Continuation<? super FullscreenAdEntity> continuation);

    Object loadPromotedApp(AdPromotedApp adPromotedApp, Continuation<? super Unit> continuation);

    /* renamed from: loadScene-0E7RQCE */
    Object mo9481loadScene0E7RQCE(Activity activity, FullscreenAdScene fullscreenAdScene, Continuation<? super Result<? extends SceneAsset>> continuation);
}
