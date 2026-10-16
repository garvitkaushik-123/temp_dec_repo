package io.adn.sdk.internal.data.repository;

import android.app.Activity;
import io.adn.sdk.internal.common.logger.Logger;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import io.adn.sdk.internal.domain.model.ad.FileContentType;
import io.adn.sdk.internal.domain.model.ad.FullscreenAdScene;
import io.adn.sdk.internal.domain.model.ad.HtmlContent;
import io.adn.sdk.internal.domain.model.ad.LoadedFile;
import io.adn.sdk.internal.domain.model.ad.LoadingStrategy;
import io.adn.sdk.internal.domain.model.ad.SceneAsset;
import io.adn.sdk.internal.domain.repository.AdFileLoader;
import io.adn.sdk.internal.domain.repository.FullscreenAdSceneLoader;
import io.adn.sdk.internal.ui.common.mraid.MraidControllerImpl;
import io.adn.sdk.internal.ui.common.mraid.MraidPlacementType;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FullscreenAdSceneLoader.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\t2\u0006\u0010\u0017\u001a\u00020\bH\u0096@¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\bH\u0016J&\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0082@¢\u0006\u0004\b\u001d\u0010\u0011J&\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\t2\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0004\b#\u0010$J.\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0082@¢\u0006\u0004\b+\u0010,J\u001e\u0010-\u001a\b\u0012\u0004\u0012\u00020&0\t2\u0006\u0010.\u001a\u00020(H\u0082@¢\u0006\u0004\b/\u00100J&\u00101\u001a\b\u0012\u0004\u0012\u00020&0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010.\u001a\u00020(H\u0082@¢\u0006\u0004\b2\u00103R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lio/adn/sdk/internal/data/repository/FullscreenAdSceneLoaderImpl;", "Lio/adn/sdk/internal/domain/repository/FullscreenAdSceneLoader;", "fileLoader", "Lio/adn/sdk/internal/domain/repository/AdFileLoader;", "<init>", "(Lio/adn/sdk/internal/domain/repository/AdFileLoader;)V", "sceneResultCache", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Result;", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset;", "loadSceneAssets", "activity", "Landroid/app/Activity;", "scene", "Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;", "loadSceneAssets-0E7RQCE", "(Landroid/app/Activity;Lio/adn/sdk/internal/domain/model/ad/FullscreenAdScene;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeSceneAssets", "", "uuid", "loadPromotedAppAsset", "Lio/adn/sdk/internal/domain/model/ad/LoadedFile;", "assetUrl", "loadPromotedAppAsset-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPromotedAppAsset", "Ljava/io/File;", "loadSceneAsset", "loadSceneAsset-0E7RQCE", "loadMediaAsset", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Media;", "url", "contentType", "Lio/adn/sdk/internal/domain/model/ad/FileContentType;", "loadMediaAsset-0E7RQCE", "(Ljava/lang/String;Lio/adn/sdk/internal/domain/model/ad/FileContentType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadHtmlAsset", "Lio/adn/sdk/internal/domain/model/ad/SceneAsset$Html;", "htmlContent", "Lio/adn/sdk/internal/domain/model/ad/HtmlContent;", "strategy", "Lio/adn/sdk/internal/domain/model/ad/LoadingStrategy;", "loadHtmlAsset-BWLJW6A", "(Landroid/app/Activity;Lio/adn/sdk/internal/domain/model/ad/HtmlContent;Lio/adn/sdk/internal/domain/model/ad/LoadingStrategy;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadHtmlAssetWithoutPreloading", AnalyticsConstants.CREATIVE_TYPE_HTML, "loadHtmlAssetWithoutPreloading-gIAlu-s", "(Lio/adn/sdk/internal/domain/model/ad/HtmlContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadHtmlAssetWithPreloading", "loadHtmlAssetWithPreloading-0E7RQCE", "(Landroid/app/Activity;Lio/adn/sdk/internal/domain/model/ad/HtmlContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class FullscreenAdSceneLoaderImpl implements FullscreenAdSceneLoader {
    public static final int $stable = 8;
    private final AdFileLoader fileLoader;
    private final ConcurrentHashMap<String, Result<SceneAsset>> sceneResultCache;

    /* compiled from: FullscreenAdSceneLoader.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoadingStrategy.values().length];
            try {
                iArr[LoadingStrategy.DownloadOnly.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadingStrategy.DownloadAndPreload.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public FullscreenAdSceneLoaderImpl(AdFileLoader fileLoader) {
        Intrinsics.checkNotNullParameter(fileLoader, "fileLoader");
        this.fileLoader = fileLoader;
        this.sceneResultCache = new ConcurrentHashMap<>();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.adn.sdk.internal.domain.repository.FullscreenAdSceneLoader
    /* renamed from: loadSceneAssets-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo9493loadSceneAssets0E7RQCE(Activity activity, FullscreenAdScene fullscreenAdScene, Continuation<? super Result<? extends SceneAsset>> continuation) {
        FullscreenAdSceneLoaderImpl$loadSceneAssets$1 fullscreenAdSceneLoaderImpl$loadSceneAssets$1;
        int i;
        Object obj;
        ConcurrentMap concurrentMap;
        Object obj2;
        String str;
        if (continuation instanceof FullscreenAdSceneLoaderImpl$loadSceneAssets$1) {
            fullscreenAdSceneLoaderImpl$loadSceneAssets$1 = (FullscreenAdSceneLoaderImpl$loadSceneAssets$1) continuation;
            if ((fullscreenAdSceneLoaderImpl$loadSceneAssets$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenAdSceneLoaderImpl$loadSceneAssets$1.label -= Integer.MIN_VALUE;
                Object obj3 = fullscreenAdSceneLoaderImpl$loadSceneAssets$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fullscreenAdSceneLoaderImpl$loadSceneAssets$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    ConcurrentHashMap<String, Result<SceneAsset>> concurrentHashMap = this.sceneResultCache;
                    String uuid = fullscreenAdScene.getUuid();
                    obj = concurrentHashMap.get(uuid);
                    if (obj == null) {
                        fullscreenAdSceneLoaderImpl$loadSceneAssets$1.L$0 = concurrentHashMap;
                        fullscreenAdSceneLoaderImpl$loadSceneAssets$1.L$1 = uuid;
                        fullscreenAdSceneLoaderImpl$loadSceneAssets$1.label = 1;
                        Object m9491loadSceneAsset0E7RQCE = m9491loadSceneAsset0E7RQCE(activity, fullscreenAdScene, fullscreenAdSceneLoaderImpl$loadSceneAssets$1);
                        if (m9491loadSceneAsset0E7RQCE == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        concurrentMap = concurrentHashMap;
                        obj2 = m9491loadSceneAsset0E7RQCE;
                        str = uuid;
                    }
                    Intrinsics.checkNotNullExpressionValue(obj, "getOrPut(...)");
                    return ((Result) obj).getValue();
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) fullscreenAdSceneLoaderImpl$loadSceneAssets$1.L$1;
                concurrentMap = (ConcurrentMap) fullscreenAdSceneLoaderImpl$loadSceneAssets$1.L$0;
                ResultKt.throwOnFailure(obj3);
                obj2 = ((Result) obj3).getValue();
                Result<SceneAsset> m10240boximpl = Result.m10240boximpl(obj2);
                Object putIfAbsent = concurrentMap.putIfAbsent(str, m10240boximpl);
                obj = putIfAbsent != null ? m10240boximpl : putIfAbsent;
                Intrinsics.checkNotNullExpressionValue(obj, "getOrPut(...)");
                return ((Result) obj).getValue();
            }
        }
        fullscreenAdSceneLoaderImpl$loadSceneAssets$1 = new FullscreenAdSceneLoaderImpl$loadSceneAssets$1(this, continuation);
        Object obj32 = fullscreenAdSceneLoaderImpl$loadSceneAssets$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fullscreenAdSceneLoaderImpl$loadSceneAssets$1.label;
        if (i != 0) {
        }
        Result<SceneAsset> m10240boximpl2 = Result.m10240boximpl(obj2);
        Object putIfAbsent2 = concurrentMap.putIfAbsent(str, m10240boximpl2);
        if (putIfAbsent2 != null) {
        }
        Intrinsics.checkNotNullExpressionValue(obj, "getOrPut(...)");
        return ((Result) obj).getValue();
    }

    @Override // io.adn.sdk.internal.domain.repository.FullscreenAdSceneLoader
    public void removeSceneAssets(String uuid) {
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        this.sceneResultCache.remove(uuid);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.adn.sdk.internal.domain.repository.FullscreenAdSceneLoader
    /* renamed from: loadPromotedAppAsset-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo9492loadPromotedAppAssetgIAlus(String str, Continuation<? super Result<LoadedFile>> continuation) {
        FullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1 fullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1;
        int i;
        if (continuation instanceof FullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1) {
            fullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1 = (FullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1) continuation;
            if ((fullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1.label -= Integer.MIN_VALUE;
                Object obj = fullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1.label;
                if (i == 0) {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return ((Result) obj).getValue();
                }
                ResultKt.throwOnFailure(obj);
                AdFileLoader adFileLoader = this.fileLoader;
                FileContentType fileContentType = FileContentType.Image;
                fullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1.label = 1;
                Object mo9478loadAdFile0E7RQCE = adFileLoader.mo9478loadAdFile0E7RQCE(str, fileContentType, fullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1);
                return mo9478loadAdFile0E7RQCE == coroutine_suspended ? coroutine_suspended : mo9478loadAdFile0E7RQCE;
            }
        }
        fullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1 = new FullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1(this, continuation);
        Object obj2 = fullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fullscreenAdSceneLoaderImpl$loadPromotedAppAsset$1.label;
        if (i == 0) {
        }
    }

    @Override // io.adn.sdk.internal.domain.repository.FullscreenAdSceneLoader
    public File getPromotedAppAsset(String assetUrl) {
        Intrinsics.checkNotNullParameter(assetUrl, "assetUrl");
        return this.fileLoader.getAdFile(assetUrl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* renamed from: loadSceneAsset-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9491loadSceneAsset0E7RQCE(Activity activity, FullscreenAdScene fullscreenAdScene, Continuation<? super Result<? extends SceneAsset>> continuation) {
        FullscreenAdSceneLoaderImpl$loadSceneAsset$1 fullscreenAdSceneLoaderImpl$loadSceneAsset$1;
        int i;
        if (continuation instanceof FullscreenAdSceneLoaderImpl$loadSceneAsset$1) {
            fullscreenAdSceneLoaderImpl$loadSceneAsset$1 = (FullscreenAdSceneLoaderImpl$loadSceneAsset$1) continuation;
            if ((fullscreenAdSceneLoaderImpl$loadSceneAsset$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenAdSceneLoaderImpl$loadSceneAsset$1.label -= Integer.MIN_VALUE;
                Object obj = fullscreenAdSceneLoaderImpl$loadSceneAsset$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fullscreenAdSceneLoaderImpl$loadSceneAsset$1.label;
                if (i == 0) {
                    if (i != 1 && i != 2 && i != 3 && i != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return ((Result) obj).getValue();
                }
                ResultKt.throwOnFailure(obj);
                if (fullscreenAdScene instanceof FullscreenAdScene.Video) {
                    String url = ((FullscreenAdScene.Video) fullscreenAdScene).getUrl();
                    FileContentType fileContentType = FileContentType.Video;
                    fullscreenAdSceneLoaderImpl$loadSceneAsset$1.label = 1;
                    Object m9490loadMediaAsset0E7RQCE = m9490loadMediaAsset0E7RQCE(url, fileContentType, fullscreenAdSceneLoaderImpl$loadSceneAsset$1);
                    if (m9490loadMediaAsset0E7RQCE != coroutine_suspended) {
                        return m9490loadMediaAsset0E7RQCE;
                    }
                } else if (fullscreenAdScene instanceof FullscreenAdScene.Image) {
                    String url2 = ((FullscreenAdScene.Image) fullscreenAdScene).getUrl();
                    FileContentType fileContentType2 = FileContentType.Image;
                    fullscreenAdSceneLoaderImpl$loadSceneAsset$1.label = 2;
                    Object m9490loadMediaAsset0E7RQCE2 = m9490loadMediaAsset0E7RQCE(url2, fileContentType2, fullscreenAdSceneLoaderImpl$loadSceneAsset$1);
                    if (m9490loadMediaAsset0E7RQCE2 != coroutine_suspended) {
                        return m9490loadMediaAsset0E7RQCE2;
                    }
                } else if (fullscreenAdScene instanceof FullscreenAdScene.Html) {
                    FullscreenAdScene.Html html = (FullscreenAdScene.Html) fullscreenAdScene;
                    HtmlContent content = html.getContent();
                    LoadingStrategy loadingStrategy = html.getConfig().getLoadingStrategy();
                    fullscreenAdSceneLoaderImpl$loadSceneAsset$1.label = 3;
                    Object m9487loadHtmlAssetBWLJW6A = m9487loadHtmlAssetBWLJW6A(activity, content, loadingStrategy, fullscreenAdSceneLoaderImpl$loadSceneAsset$1);
                    if (m9487loadHtmlAssetBWLJW6A != coroutine_suspended) {
                        return m9487loadHtmlAssetBWLJW6A;
                    }
                } else {
                    if (!(fullscreenAdScene instanceof FullscreenAdScene.PromotedAppCard)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    String iconUrl = ((FullscreenAdScene.PromotedAppCard) fullscreenAdScene).getPromotedApp().getIconUrl();
                    if (iconUrl == null) {
                        iconUrl = "";
                    }
                    FileContentType fileContentType3 = FileContentType.Image;
                    fullscreenAdSceneLoaderImpl$loadSceneAsset$1.label = 4;
                    Object m9490loadMediaAsset0E7RQCE3 = m9490loadMediaAsset0E7RQCE(iconUrl, fileContentType3, fullscreenAdSceneLoaderImpl$loadSceneAsset$1);
                    if (m9490loadMediaAsset0E7RQCE3 != coroutine_suspended) {
                        return m9490loadMediaAsset0E7RQCE3;
                    }
                }
                return coroutine_suspended;
            }
        }
        fullscreenAdSceneLoaderImpl$loadSceneAsset$1 = new FullscreenAdSceneLoaderImpl$loadSceneAsset$1(this, continuation);
        Object obj2 = fullscreenAdSceneLoaderImpl$loadSceneAsset$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fullscreenAdSceneLoaderImpl$loadSceneAsset$1.label;
        if (i == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* renamed from: loadMediaAsset-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9490loadMediaAsset0E7RQCE(String str, FileContentType fileContentType, Continuation<? super Result<SceneAsset.Media>> continuation) {
        FullscreenAdSceneLoaderImpl$loadMediaAsset$1 fullscreenAdSceneLoaderImpl$loadMediaAsset$1;
        int i;
        Object mo9478loadAdFile0E7RQCE;
        Throwable m10244exceptionOrNullimpl;
        if (continuation instanceof FullscreenAdSceneLoaderImpl$loadMediaAsset$1) {
            fullscreenAdSceneLoaderImpl$loadMediaAsset$1 = (FullscreenAdSceneLoaderImpl$loadMediaAsset$1) continuation;
            if ((fullscreenAdSceneLoaderImpl$loadMediaAsset$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenAdSceneLoaderImpl$loadMediaAsset$1.label -= Integer.MIN_VALUE;
                Object obj = fullscreenAdSceneLoaderImpl$loadMediaAsset$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fullscreenAdSceneLoaderImpl$loadMediaAsset$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AdFileLoader adFileLoader = this.fileLoader;
                    fullscreenAdSceneLoaderImpl$loadMediaAsset$1.label = 1;
                    mo9478loadAdFile0E7RQCE = adFileLoader.mo9478loadAdFile0E7RQCE(str, fileContentType, fullscreenAdSceneLoaderImpl$loadMediaAsset$1);
                    if (mo9478loadAdFile0E7RQCE == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    mo9478loadAdFile0E7RQCE = ((Result) obj).getValue();
                }
                m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(mo9478loadAdFile0E7RQCE);
                if (m10244exceptionOrNullimpl != null) {
                    Logger.INSTANCE.e("FullscreenAdSceneLoader", m10244exceptionOrNullimpl);
                }
                if (Result.m10248isSuccessimpl(mo9478loadAdFile0E7RQCE)) {
                    return Result.m10241constructorimpl(mo9478loadAdFile0E7RQCE);
                }
                Result.Companion companion = Result.INSTANCE;
                return Result.m10241constructorimpl(new SceneAsset.Media((LoadedFile) mo9478loadAdFile0E7RQCE));
            }
        }
        fullscreenAdSceneLoaderImpl$loadMediaAsset$1 = new FullscreenAdSceneLoaderImpl$loadMediaAsset$1(this, continuation);
        Object obj2 = fullscreenAdSceneLoaderImpl$loadMediaAsset$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fullscreenAdSceneLoaderImpl$loadMediaAsset$1.label;
        if (i != 0) {
        }
        m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(mo9478loadAdFile0E7RQCE);
        if (m10244exceptionOrNullimpl != null) {
        }
        if (Result.m10248isSuccessimpl(mo9478loadAdFile0E7RQCE)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: loadHtmlAsset-BWLJW6A, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9487loadHtmlAssetBWLJW6A(Activity activity, HtmlContent htmlContent, LoadingStrategy loadingStrategy, Continuation<? super Result<? extends SceneAsset.Html>> continuation) {
        FullscreenAdSceneLoaderImpl$loadHtmlAsset$1 fullscreenAdSceneLoaderImpl$loadHtmlAsset$1;
        int i;
        if (continuation instanceof FullscreenAdSceneLoaderImpl$loadHtmlAsset$1) {
            fullscreenAdSceneLoaderImpl$loadHtmlAsset$1 = (FullscreenAdSceneLoaderImpl$loadHtmlAsset$1) continuation;
            if ((fullscreenAdSceneLoaderImpl$loadHtmlAsset$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenAdSceneLoaderImpl$loadHtmlAsset$1.label -= Integer.MIN_VALUE;
                Object obj = fullscreenAdSceneLoaderImpl$loadHtmlAsset$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fullscreenAdSceneLoaderImpl$loadHtmlAsset$1.label;
                if (i == 0) {
                    if (i != 1 && i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return ((Result) obj).getValue();
                }
                ResultKt.throwOnFailure(obj);
                int i2 = WhenMappings.$EnumSwitchMapping$0[loadingStrategy.ordinal()];
                if (i2 == 1) {
                    fullscreenAdSceneLoaderImpl$loadHtmlAsset$1.label = 1;
                    Object m9489loadHtmlAssetWithoutPreloadinggIAlus = m9489loadHtmlAssetWithoutPreloadinggIAlus(htmlContent, fullscreenAdSceneLoaderImpl$loadHtmlAsset$1);
                    if (m9489loadHtmlAssetWithoutPreloadinggIAlus != coroutine_suspended) {
                        return m9489loadHtmlAssetWithoutPreloadinggIAlus;
                    }
                } else {
                    if (i2 != 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    fullscreenAdSceneLoaderImpl$loadHtmlAsset$1.label = 2;
                    Object m9488loadHtmlAssetWithPreloading0E7RQCE = m9488loadHtmlAssetWithPreloading0E7RQCE(activity, htmlContent, fullscreenAdSceneLoaderImpl$loadHtmlAsset$1);
                    if (m9488loadHtmlAssetWithPreloading0E7RQCE != coroutine_suspended) {
                        return m9488loadHtmlAssetWithPreloading0E7RQCE;
                    }
                }
                return coroutine_suspended;
            }
        }
        fullscreenAdSceneLoaderImpl$loadHtmlAsset$1 = new FullscreenAdSceneLoaderImpl$loadHtmlAsset$1(this, continuation);
        Object obj2 = fullscreenAdSceneLoaderImpl$loadHtmlAsset$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fullscreenAdSceneLoaderImpl$loadHtmlAsset$1.label;
        if (i == 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* renamed from: loadHtmlAssetWithoutPreloading-gIAlu-s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9489loadHtmlAssetWithoutPreloadinggIAlus(HtmlContent htmlContent, Continuation<? super Result<? extends SceneAsset.Html>> continuation) {
        FullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1 fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1;
        int i;
        Object mo9478loadAdFile0E7RQCE;
        MraidControllerImpl mraidControllerImpl;
        if (continuation instanceof FullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1) {
            fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1 = (FullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1) continuation;
            if ((fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1.label -= Integer.MIN_VALUE;
                Object obj = fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    MraidControllerImpl mraidControllerImpl2 = new MraidControllerImpl(MraidPlacementType.Interstitial, null, null, 6, null);
                    mraidControllerImpl2.awaitHtmlLoadEvent(htmlContent.getAwaitHtmlLoadEvent());
                    if (htmlContent instanceof HtmlContent.Downloadable) {
                        AdFileLoader adFileLoader = this.fileLoader;
                        String url = ((HtmlContent.Downloadable) htmlContent).getUrl();
                        FileContentType fileContentType = FileContentType.Html;
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1.L$0 = mraidControllerImpl2;
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1.label = 1;
                        mo9478loadAdFile0E7RQCE = adFileLoader.mo9478loadAdFile0E7RQCE(url, fileContentType, fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1);
                        if (mo9478loadAdFile0E7RQCE == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        mraidControllerImpl = mraidControllerImpl2;
                    } else {
                        if (htmlContent instanceof HtmlContent.NonDownloadable) {
                            Result.Companion companion = Result.INSTANCE;
                            return Result.m10241constructorimpl(new SceneAsset.Html.ContentBased(mraidControllerImpl2, ((HtmlContent.NonDownloadable) htmlContent).getUrl(), false));
                        }
                        if (!(htmlContent instanceof HtmlContent.Embedded)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        Result.Companion companion2 = Result.INSTANCE;
                        return Result.m10241constructorimpl(new SceneAsset.Html.ContentBased(mraidControllerImpl2, ((HtmlContent.Embedded) htmlContent).getContent(), false));
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mraidControllerImpl = (MraidControllerImpl) fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    mo9478loadAdFile0E7RQCE = ((Result) obj).getValue();
                }
                if (Result.m10248isSuccessimpl(mo9478loadAdFile0E7RQCE)) {
                    return Result.m10241constructorimpl(mo9478loadAdFile0E7RQCE);
                }
                Result.Companion companion3 = Result.INSTANCE;
                return Result.m10241constructorimpl(new SceneAsset.Html.FileBased(mraidControllerImpl, (LoadedFile) mo9478loadAdFile0E7RQCE, false));
            }
        }
        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1 = new FullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1(this, continuation);
        Object obj2 = fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fullscreenAdSceneLoaderImpl$loadHtmlAssetWithoutPreloading$1.label;
        if (i != 0) {
        }
        if (Result.m10248isSuccessimpl(mo9478loadAdFile0E7RQCE)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    /* renamed from: loadHtmlAssetWithPreloading-0E7RQCE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m9488loadHtmlAssetWithPreloading0E7RQCE(Activity activity, HtmlContent htmlContent, Continuation<? super Result<? extends SceneAsset.Html>> continuation) {
        FullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1 fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1;
        int i;
        Object mo9558load0E7RQCE;
        MraidControllerImpl mraidControllerImpl;
        Object mo9558load0E7RQCE2;
        MraidControllerImpl mraidControllerImpl2;
        Object mo9478loadAdFile0E7RQCE;
        MraidControllerImpl mraidControllerImpl3;
        Throwable m10244exceptionOrNullimpl;
        Object obj;
        LoadedFile loadedFile;
        Activity activity2 = activity;
        HtmlContent htmlContent2 = htmlContent;
        if (continuation instanceof FullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1) {
            fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1 = (FullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1) continuation;
            if ((fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.label & Integer.MIN_VALUE) != 0) {
                fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.label -= Integer.MIN_VALUE;
                Object obj2 = fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    MraidControllerImpl mraidControllerImpl4 = new MraidControllerImpl(MraidPlacementType.Interstitial, null, null, 6, null);
                    mraidControllerImpl4.awaitHtmlLoadEvent(htmlContent2.getAwaitHtmlLoadEvent());
                    if (htmlContent2 instanceof HtmlContent.Downloadable) {
                        AdFileLoader adFileLoader = this.fileLoader;
                        String url = ((HtmlContent.Downloadable) htmlContent2).getUrl();
                        FileContentType fileContentType = FileContentType.Html;
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$0 = activity2;
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$1 = mraidControllerImpl4;
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.label = 1;
                        mo9478loadAdFile0E7RQCE = adFileLoader.mo9478loadAdFile0E7RQCE(url, fileContentType, fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1);
                        if (mo9478loadAdFile0E7RQCE != coroutine_suspended) {
                            mraidControllerImpl3 = mraidControllerImpl4;
                            m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(mo9478loadAdFile0E7RQCE);
                            if (m10244exceptionOrNullimpl != null) {
                            }
                        }
                    } else if (htmlContent2 instanceof HtmlContent.Embedded) {
                        String content = ((HtmlContent.Embedded) htmlContent2).getContent();
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$0 = htmlContent2;
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$1 = mraidControllerImpl4;
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.label = 3;
                        mo9558load0E7RQCE2 = mraidControllerImpl4.mo9558load0E7RQCE(activity2, content, fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1);
                        if (mo9558load0E7RQCE2 != coroutine_suspended) {
                            mraidControllerImpl2 = mraidControllerImpl4;
                            if (Result.m10248isSuccessimpl(mo9558load0E7RQCE2)) {
                            }
                        }
                    } else {
                        if (!(htmlContent2 instanceof HtmlContent.NonDownloadable)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        String url2 = ((HtmlContent.NonDownloadable) htmlContent2).getUrl();
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$0 = htmlContent2;
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$1 = mraidControllerImpl4;
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.label = 4;
                        mo9558load0E7RQCE = mraidControllerImpl4.mo9558load0E7RQCE(activity2, url2, fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1);
                        if (mo9558load0E7RQCE != coroutine_suspended) {
                            mraidControllerImpl = mraidControllerImpl4;
                            if (Result.m10248isSuccessimpl(mo9558load0E7RQCE)) {
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    MraidControllerImpl mraidControllerImpl5 = (MraidControllerImpl) fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$1;
                    Activity activity3 = (Activity) fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    mo9478loadAdFile0E7RQCE = ((Result) obj2).getValue();
                    mraidControllerImpl3 = mraidControllerImpl5;
                    activity2 = activity3;
                    m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(mo9478loadAdFile0E7RQCE);
                    if (m10244exceptionOrNullimpl != null) {
                        LoadedFile loadedFile2 = (LoadedFile) mo9478loadAdFile0E7RQCE;
                        File file = loadedFile2.getFile();
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$0 = mraidControllerImpl3;
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$1 = loadedFile2;
                        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.label = 2;
                        Object mo9557load0E7RQCE = mraidControllerImpl3.mo9557load0E7RQCE(activity2, file, fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1);
                        if (mo9557load0E7RQCE != coroutine_suspended) {
                            obj = mo9557load0E7RQCE;
                            loadedFile = loadedFile2;
                            if (Result.m10248isSuccessimpl(obj)) {
                            }
                        }
                        return coroutine_suspended;
                    }
                    Result.Companion companion = Result.INSTANCE;
                    return Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
                }
                if (i == 2) {
                    loadedFile = (LoadedFile) fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$1;
                    mraidControllerImpl3 = (MraidControllerImpl) fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    obj = ((Result) obj2).getValue();
                    if (Result.m10248isSuccessimpl(obj)) {
                        return Result.m10241constructorimpl(obj);
                    }
                    Result.Companion companion2 = Result.INSTANCE;
                    return Result.m10241constructorimpl(new SceneAsset.Html.FileBased(mraidControllerImpl3, loadedFile, true));
                }
                if (i == 3) {
                    mraidControllerImpl2 = (MraidControllerImpl) fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$1;
                    htmlContent2 = (HtmlContent) fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$0;
                    ResultKt.throwOnFailure(obj2);
                    mo9558load0E7RQCE2 = ((Result) obj2).getValue();
                    if (Result.m10248isSuccessimpl(mo9558load0E7RQCE2)) {
                        return Result.m10241constructorimpl(mo9558load0E7RQCE2);
                    }
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m10241constructorimpl(new SceneAsset.Html.ContentBased(mraidControllerImpl2, ((HtmlContent.Embedded) htmlContent2).getContent(), true));
                }
                if (i != 4) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mraidControllerImpl = (MraidControllerImpl) fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$1;
                htmlContent2 = (HtmlContent) fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.L$0;
                ResultKt.throwOnFailure(obj2);
                mo9558load0E7RQCE = ((Result) obj2).getValue();
                if (Result.m10248isSuccessimpl(mo9558load0E7RQCE)) {
                    return Result.m10241constructorimpl(mo9558load0E7RQCE);
                }
                Result.Companion companion4 = Result.INSTANCE;
                return Result.m10241constructorimpl(new SceneAsset.Html.ContentBased(mraidControllerImpl, ((HtmlContent.NonDownloadable) htmlContent2).getUrl(), true));
            }
        }
        fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1 = new FullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1(this, continuation);
        Object obj22 = fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fullscreenAdSceneLoaderImpl$loadHtmlAssetWithPreloading$1.label;
        if (i != 0) {
        }
    }
}
