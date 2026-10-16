package io.adn.sdk.internal.data.repository;

import android.app.Activity;
import io.adn.sdk.internal.domain.model.ad.AdPromotedApp;
import io.adn.sdk.internal.domain.model.ad.BidResponse;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdEntity;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.domain.repository.FullscreenAdLoader;
import io.adn.sdk.internal.domain.repository.FullscreenAdSceneLoader;
import io.adn.sdk.internal.domain.repository.VastLoader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: FullscreenAdLoader.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\u0016\u0010\u0017J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0096@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lio/adn/sdk/internal/data/repository/FullscreenAdLoaderImpl;", "Lio/adn/sdk/internal/domain/repository/FullscreenAdLoader;", "vastLoader", "Lio/adn/sdk/internal/domain/repository/VastLoader;", "sceneLoader", "Lio/adn/sdk/internal/domain/repository/FullscreenAdSceneLoader;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lio/adn/sdk/internal/domain/repository/VastLoader;Lio/adn/sdk/internal/domain/repository/FullscreenAdSceneLoader;Lkotlinx/coroutines/CoroutineDispatcher;)V", "loadAd", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdEntity;", "bidResponse", "Lio/adn/sdk/internal/domain/model/ad/BidResponse;", "(Lio/adn/sdk/internal/domain/model/ad/BidResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadScene", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "activity", "Landroid/app/Activity;", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "loadScene-0E7RQCE", "(Landroid/app/Activity;Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadPromotedApp", "", "promotedApp", "Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;", "(Lio/adn/sdk/internal/domain/model/ad/AdPromotedApp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdLoaderImpl implements FullscreenAdLoader {
    public static final int $stable = 8;
    private final CoroutineDispatcher ioDispatcher;
    private final FullscreenAdSceneLoader sceneLoader;
    private final VastLoader vastLoader;

    public FullscreenAdLoaderImpl(VastLoader vastLoader, FullscreenAdSceneLoader sceneLoader, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(vastLoader, "vastLoader");
        Intrinsics.checkNotNullParameter(sceneLoader, "sceneLoader");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.vastLoader = vastLoader;
        this.sceneLoader = sceneLoader;
        this.ioDispatcher = ioDispatcher;
    }

    public /* synthetic */ FullscreenAdLoaderImpl(VastLoader vastLoader, FullscreenAdSceneLoader fullscreenAdSceneLoader, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(vastLoader, fullscreenAdSceneLoader, (i & 4) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    @Override // io.adn.sdk.internal.domain.repository.FullscreenAdLoader
    public Object loadAd(BidResponse bidResponse, Continuation<? super FullscreenAdEntity> continuation) {
        return BuildersKt.withContext(this.ioDispatcher, new FullscreenAdLoaderImpl$loadAd$2(this, bidResponse, null), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.adn.sdk.internal.domain.repository.FullscreenAdLoader
    /* renamed from: loadScene-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo9481loadScene0E7RQCE(Activity activity, FullscreenAdScene fullscreenAdScene, Continuation<? super Result<? extends SceneAsset>> continuation) {
        FullscreenAdLoaderImpl$loadScene$1 fullscreenAdLoaderImpl$loadScene$1;
        int i;
        if (continuation instanceof FullscreenAdLoaderImpl$loadScene$1) {
            fullscreenAdLoaderImpl$loadScene$1 = (FullscreenAdLoaderImpl$loadScene$1) continuation;
            if ((fullscreenAdLoaderImpl$loadScene$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenAdLoaderImpl$loadScene$1.label -= Integer.MIN_VALUE;
                Object obj = fullscreenAdLoaderImpl$loadScene$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fullscreenAdLoaderImpl$loadScene$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineDispatcher coroutineDispatcher = this.ioDispatcher;
                    FullscreenAdLoaderImpl$loadScene$2 fullscreenAdLoaderImpl$loadScene$2 = new FullscreenAdLoaderImpl$loadScene$2(this, activity, fullscreenAdScene, null);
                    fullscreenAdLoaderImpl$loadScene$1.label = 1;
                    obj = BuildersKt.withContext(coroutineDispatcher, fullscreenAdLoaderImpl$loadScene$2, fullscreenAdLoaderImpl$loadScene$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((Result) obj).getValue();
            }
        }
        fullscreenAdLoaderImpl$loadScene$1 = new FullscreenAdLoaderImpl$loadScene$1(this, continuation);
        Object obj2 = fullscreenAdLoaderImpl$loadScene$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fullscreenAdLoaderImpl$loadScene$1.label;
        if (i != 0) {
        }
        return ((Result) obj2).getValue();
    }

    @Override // io.adn.sdk.internal.domain.repository.FullscreenAdLoader
    public Object loadPromotedApp(AdPromotedApp adPromotedApp, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.ioDispatcher, new FullscreenAdLoaderImpl$loadPromotedApp$2(adPromotedApp, this, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
