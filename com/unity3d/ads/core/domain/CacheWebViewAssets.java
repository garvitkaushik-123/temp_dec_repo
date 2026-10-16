package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.WebViewConfiguration;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* compiled from: CacheWebViewAssets.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH¦Bø\u0001\u0000¢\u0006\u0002\u0010\fR\u001e\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/unity3d/ads/core/domain/CacheWebViewAssets;", "", "cached", "", "", "Ljava/io/File;", "getCached", "()Ljava/util/Map;", "invoke", "", "webviewConfiguration", "Lcom/unity3d/ads/core/data/model/WebViewConfiguration;", "(Lcom/unity3d/ads/core/data/model/WebViewConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public interface CacheWebViewAssets {
    Map<String, File> getCached();

    Object invoke(WebViewConfiguration webViewConfiguration, Continuation<? super Unit> continuation);
}
