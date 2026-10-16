package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.model.WebViewConfiguration;
import com.unity3d.ads.core.data.repository.CacheRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AndroidCacheWebViewAssets.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidCacheWebViewAssets;", "Lcom/unity3d/ads/core/domain/CacheWebViewAssets;", "cacheRepository", "Lcom/unity3d/ads/core/data/repository/CacheRepository;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "(Lcom/unity3d/ads/core/data/repository/CacheRepository;Lcom/unity3d/ads/core/data/repository/SessionRepository;)V", "_cached", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Ljava/io/File;", "cached", "", "getCached", "()Ljava/util/Map;", "getFilename", "url", "type", "invoke", "", "webviewConfiguration", "Lcom/unity3d/ads/core/data/model/WebViewConfiguration;", "(Lcom/unity3d/ads/core/data/model/WebViewConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidCacheWebViewAssets implements CacheWebViewAssets {
    private final ConcurrentHashMap<String, File> _cached;
    private final CacheRepository cacheRepository;
    private final SessionRepository sessionRepository;

    public AndroidCacheWebViewAssets(CacheRepository cacheRepository, SessionRepository sessionRepository) {
        Intrinsics.checkNotNullParameter(cacheRepository, "cacheRepository");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        this.cacheRepository = cacheRepository;
        this.sessionRepository = sessionRepository;
        this._cached = new ConcurrentHashMap<>();
    }

    @Override // com.unity3d.ads.core.domain.CacheWebViewAssets
    public Map<String, File> getCached() {
        return this._cached;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00f1, code lost:
    
        if (r9 == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x00f1 -> B:11:0x00f4). Please report as a decompilation issue!!! */
    @Override // com.unity3d.ads.core.domain.CacheWebViewAssets
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object invoke(WebViewConfiguration webViewConfiguration, Continuation<? super Unit> continuation) {
        AndroidCacheWebViewAssets$invoke$1 androidCacheWebViewAssets$invoke$1;
        int i;
        AndroidCacheWebViewAssets androidCacheWebViewAssets;
        WebViewConfiguration webViewConfiguration2;
        AndroidCacheWebViewAssets androidCacheWebViewAssets2;
        Iterator it;
        CacheResult cacheResult;
        if (continuation instanceof AndroidCacheWebViewAssets$invoke$1) {
            androidCacheWebViewAssets$invoke$1 = (AndroidCacheWebViewAssets$invoke$1) continuation;
            if ((androidCacheWebViewAssets$invoke$1.label & Integer.MIN_VALUE) != 0) {
                androidCacheWebViewAssets$invoke$1.label -= Integer.MIN_VALUE;
                Object obj = androidCacheWebViewAssets$invoke$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidCacheWebViewAssets$invoke$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.sessionRepository.getNativeConfiguration().getFeatureFlags().getShouldHandleWebviewCaching()) {
                        return Unit.INSTANCE;
                    }
                    if (webViewConfiguration.getEntryPoint().length() > 0) {
                        CacheRepository cacheRepository = this.cacheRepository;
                        String entryPoint = webViewConfiguration.getEntryPoint();
                        String type = webViewConfiguration.getType();
                        androidCacheWebViewAssets$invoke$1.L$0 = this;
                        androidCacheWebViewAssets$invoke$1.L$1 = webViewConfiguration;
                        androidCacheWebViewAssets$invoke$1.label = 1;
                        obj = cacheRepository.getWebviewFile(entryPoint, type, androidCacheWebViewAssets$invoke$1);
                        if (obj != coroutine_suspended) {
                            androidCacheWebViewAssets = this;
                        }
                        return coroutine_suspended;
                    }
                    androidCacheWebViewAssets = this;
                    webViewConfiguration2 = webViewConfiguration;
                    androidCacheWebViewAssets2 = androidCacheWebViewAssets;
                    it = webViewConfiguration.getAdditionalFiles().iterator();
                    while (it.hasNext()) {
                    }
                    return Unit.INSTANCE;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    String str = (String) androidCacheWebViewAssets$invoke$1.L$3;
                    it = (Iterator) androidCacheWebViewAssets$invoke$1.L$2;
                    webViewConfiguration2 = (WebViewConfiguration) androidCacheWebViewAssets$invoke$1.L$1;
                    androidCacheWebViewAssets2 = (AndroidCacheWebViewAssets) androidCacheWebViewAssets$invoke$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    CacheResult cacheResult2 = (CacheResult) obj;
                    if (cacheResult2 instanceof CacheResult.Success) {
                        CacheResult.Success success = (CacheResult.Success) cacheResult2;
                        if (success.getCachedFile().getFile() != null) {
                            androidCacheWebViewAssets2._cached.put(androidCacheWebViewAssets2.getFilename(str, webViewConfiguration2.getType()), success.getCachedFile().getFile());
                        }
                    }
                    while (it.hasNext()) {
                        str = (String) it.next();
                        if (str.length() > 0) {
                            CacheRepository cacheRepository2 = androidCacheWebViewAssets2.cacheRepository;
                            String type2 = webViewConfiguration2.getType();
                            androidCacheWebViewAssets$invoke$1.L$0 = androidCacheWebViewAssets2;
                            androidCacheWebViewAssets$invoke$1.L$1 = webViewConfiguration2;
                            androidCacheWebViewAssets$invoke$1.L$2 = it;
                            androidCacheWebViewAssets$invoke$1.L$3 = str;
                            androidCacheWebViewAssets$invoke$1.label = 2;
                            obj = cacheRepository2.getWebviewFile(str, type2, androidCacheWebViewAssets$invoke$1);
                        }
                    }
                    return Unit.INSTANCE;
                }
                webViewConfiguration = (WebViewConfiguration) androidCacheWebViewAssets$invoke$1.L$1;
                androidCacheWebViewAssets = (AndroidCacheWebViewAssets) androidCacheWebViewAssets$invoke$1.L$0;
                ResultKt.throwOnFailure(obj);
                cacheResult = (CacheResult) obj;
                if (cacheResult instanceof CacheResult.Success) {
                    CacheResult.Success success2 = (CacheResult.Success) cacheResult;
                    if (success2.getCachedFile().getFile() != null) {
                        androidCacheWebViewAssets._cached.put(androidCacheWebViewAssets.getFilename(webViewConfiguration.getEntryPoint(), webViewConfiguration.getType()), success2.getCachedFile().getFile());
                    }
                }
                webViewConfiguration2 = webViewConfiguration;
                androidCacheWebViewAssets2 = androidCacheWebViewAssets;
                it = webViewConfiguration.getAdditionalFiles().iterator();
                while (it.hasNext()) {
                }
                return Unit.INSTANCE;
            }
        }
        androidCacheWebViewAssets$invoke$1 = new AndroidCacheWebViewAssets$invoke$1(this, continuation);
        Object obj2 = androidCacheWebViewAssets$invoke$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidCacheWebViewAssets$invoke$1.label;
        if (i != 0) {
        }
        cacheResult = (CacheResult) obj2;
        if (cacheResult instanceof CacheResult.Success) {
        }
        webViewConfiguration2 = webViewConfiguration;
        androidCacheWebViewAssets2 = androidCacheWebViewAssets;
        it = webViewConfiguration.getAdditionalFiles().iterator();
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }

    private final String getFilename(String url, String type) {
        return type + '/' + StringsKt.substringAfterLast$default(StringsKt.substringBefore$default(url, '?', (String) null, 2, (Object) null), '/', (String) null, 2, (Object) null);
    }
}
