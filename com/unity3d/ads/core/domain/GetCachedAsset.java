package com.unity3d.ads.core.domain;

import android.content.Context;
import android.net.Uri;
import android.webkit.WebResourceResponse;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.unity3d.ads.core.data.model.CacheResult;
import com.unity3d.ads.core.data.repository.CacheRepository;
import com.unity3d.ads.core.extensions.StringExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;

/* compiled from: GetCachedAsset.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u001d\u0010\u000e\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0086\u0002J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/unity3d/ads/core/domain/GetCachedAsset;", "", "cacheRepository", "Lcom/unity3d/ads/core/data/repository/CacheRepository;", "context", "Landroid/content/Context;", "cacheWebViewAssets", "Lcom/unity3d/ads/core/domain/CacheWebViewAssets;", "(Lcom/unity3d/ads/core/data/repository/CacheRepository;Landroid/content/Context;Lcom/unity3d/ads/core/domain/CacheWebViewAssets;)V", "getBundledAsset", "Landroid/webkit/WebResourceResponse;", "uri", "Landroid/net/Uri;", "getCachedAsset", "invoke", "webviewType", "", "tryGetWebViewAsset", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class GetCachedAsset {
    private final CacheRepository cacheRepository;
    private final CacheWebViewAssets cacheWebViewAssets;
    private final Context context;

    public GetCachedAsset(CacheRepository cacheRepository, Context context, CacheWebViewAssets cacheWebViewAssets) {
        Intrinsics.checkNotNullParameter(cacheRepository, "cacheRepository");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cacheWebViewAssets, "cacheWebViewAssets");
        this.cacheRepository = cacheRepository;
        this.context = context;
        this.cacheWebViewAssets = cacheWebViewAssets;
    }

    public static /* synthetic */ WebResourceResponse invoke$default(GetCachedAsset getCachedAsset, Uri uri, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return getCachedAsset.invoke(uri, str);
    }

    public final WebResourceResponse invoke(Uri uri, String webviewType) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(webviewType, "webviewType");
        String host = uri.getHost();
        if (host != null) {
            int hashCode = host.hashCode();
            if (hashCode != -1921537799) {
                if (hashCode == -1920242293 && host.equals(UnityAdsConstants.DefaultUrls.AD_CACHE_DOMAIN)) {
                    return getCachedAsset(uri);
                }
            } else if (host.equals(UnityAdsConstants.DefaultUrls.AD_ASSET_DOMAIN)) {
                return getBundledAsset(uri);
            }
        }
        return tryGetWebViewAsset(uri, webviewType);
    }

    private final WebResourceResponse getBundledAsset(Uri uri) {
        String substringAfter$default = StringsKt.substringAfter$default(String.valueOf(uri.getPath()), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null);
        try {
            InputStream open = this.context.getAssets().open(substringAfter$default);
            Intrinsics.checkNotNullExpressionValue(open, "context.assets.open(fileName)");
            return new WebResourceResponse(StringExtensionsKt.guessMimeType(substringAfter$default), null, open);
        } catch (Exception unused) {
            return null;
        }
    }

    private final WebResourceResponse getCachedAsset(Uri uri) {
        Object runBlocking$default;
        File file;
        Object m10241constructorimpl;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new GetCachedAsset$getCachedAsset$result$1(this, StringsKt.substringAfterLast$default(uri2, RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null), null), 1, null);
        CacheResult cacheResult = (CacheResult) runBlocking$default;
        if (!(cacheResult instanceof CacheResult.Success) || (file = ((CacheResult.Success) cacheResult).getCachedFile().getFile()) == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            GetCachedAsset getCachedAsset = this;
            m10241constructorimpl = Result.m10241constructorimpl(new FileInputStream(file));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = null;
        }
        FileInputStream fileInputStream = (FileInputStream) m10241constructorimpl;
        if (fileInputStream == null) {
            return null;
        }
        String filePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(filePath, "filePath");
        String guessMimeType = StringExtensionsKt.guessMimeType(filePath);
        String str = guessMimeType;
        if (str != null && !StringsKt.isBlank(str)) {
            return new WebResourceResponse(guessMimeType, null, fileInputStream);
        }
        return null;
    }

    private final WebResourceResponse tryGetWebViewAsset(Uri uri, String webviewType) {
        Object m10241constructorimpl;
        StringBuilder append = new StringBuilder().append(webviewType).append('/');
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        String sb = append.append(StringsKt.substringAfterLast$default(StringsKt.substringBefore$default(uri2, "?", (String) null, 2, (Object) null), RemoteSettings.FORWARD_SLASH_STRING, (String) null, 2, (Object) null)).toString();
        File file = this.cacheWebViewAssets.getCached().get(sb);
        if (file != null) {
            try {
                Result.Companion companion = Result.INSTANCE;
                GetCachedAsset getCachedAsset = this;
                m10241constructorimpl = Result.m10241constructorimpl(new FileInputStream(file));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                m10241constructorimpl = null;
            }
            FileInputStream fileInputStream = (FileInputStream) m10241constructorimpl;
            if (fileInputStream == null) {
                return null;
            }
            String guessMimeType = StringExtensionsKt.guessMimeType(sb);
            String str = guessMimeType;
            if (str != null && !StringsKt.isBlank(str)) {
                return new WebResourceResponse(guessMimeType, null, fileInputStream);
            }
        }
        return null;
    }
}
