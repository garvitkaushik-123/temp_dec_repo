package io.adn.sdk.internal.common.utils;

import android.net.Uri;
import com.vungle.ads.internal.model.AdPayload;
import io.adn.sdk.internal.common.model.UrlInfo;
import java.net.URLEncoder;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: Uri.kt */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u000e\u0010\u0004\u001a\u00020\u0005*\u0004\u0018\u00010\u0001H\u0000\u001a\u000e\u0010\u0006\u001a\u00020\u0007*\u0004\u0018\u00010\u0001H\u0000\u001a\u000e\u0010\b\u001a\u00020\u0007*\u0004\u0018\u00010\u0001H\u0000\u001a\f\u0010\t\u001a\u00020\u0007*\u00020\nH\u0000\u001a\u000e\u0010\u000b\u001a\u00020\u0007*\u0004\u0018\u00010\u0001H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\nH\u0000\u001a\u0010\u0010\f\u001a\u0004\u0018\u00010\n*\u0004\u0018\u00010\u0001H\u0000\u001a\f\u0010\r\u001a\u00020\u0001*\u00020\u0001H\u0000\u001a\f\u0010\u000e\u001a\u00020\u0007*\u00020\nH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0007*\u00020\nH\u0000\u001a\f\u0010\u0010\u001a\u00020\u0007*\u00020\nH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"PLAY_GOOGLE_COM", "", "MARKET_ANDROID_COM", "BLANK_URL", "analyzeUrl", "Lio/adn/sdk/internal/common/model/UrlInfo;", "isHttpUrl", "", "isIntentUrl", "isDeeplinkUrl", "Landroid/net/Uri;", "isLocalFileUrl", "toUri", "urlEncode", "isAppStoreUrl", "isExternalUrl", "isMraid", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class UriKt {
    private static final String BLANK_URL = "about:blank";
    private static final String MARKET_ANDROID_COM = "market.android.com";
    private static final String PLAY_GOOGLE_COM = "play.google.com";

    /* JADX WARN: Removed duplicated region for block: B:20:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final UrlInfo analyzeUrl(String str) {
        Object m10241constructorimpl;
        String str2;
        boolean z;
        try {
            Result.Companion companion = Result.INSTANCE;
            str2 = str;
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (str2 != null && str2.length() != 0 && !Intrinsics.areEqual(str, "about:blank")) {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (scheme != null && scheme.length() != 0) {
                z = true;
                m10241constructorimpl = Result.m10241constructorimpl(new UrlInfo(z, isHttpUrl(parse), isDeeplinkUrl(parse)));
                UrlInfo urlInfo = new UrlInfo(false, false, false);
                if (Result.m10247isFailureimpl(m10241constructorimpl)) {
                    m10241constructorimpl = urlInfo;
                }
                return (UrlInfo) m10241constructorimpl;
            }
            z = false;
            m10241constructorimpl = Result.m10241constructorimpl(new UrlInfo(z, isHttpUrl(parse), isDeeplinkUrl(parse)));
            UrlInfo urlInfo2 = new UrlInfo(false, false, false);
            if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            }
            return (UrlInfo) m10241constructorimpl;
        }
        return new UrlInfo(false, false, false);
    }

    public static final boolean isHttpUrl(String str) {
        Uri uri = toUri(str);
        if (uri == null) {
            return false;
        }
        return isHttpUrl(uri);
    }

    public static final boolean isIntentUrl(String str) {
        Uri uri = toUri(str);
        if (uri == null) {
            return false;
        }
        return Intrinsics.areEqual(uri.getScheme(), "intent");
    }

    public static final boolean isDeeplinkUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return isAppStoreUrl(uri) || !isHttpUrl(uri);
    }

    public static final boolean isLocalFileUrl(String str) {
        return str != null && StringsKt.startsWith$default(str, AdPayload.FILE_SCHEME, false, 2, (Object) null);
    }

    public static final boolean isHttpUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual("http", uri.getScheme()) || Intrinsics.areEqual("https", uri.getScheme());
    }

    public static final Uri toUri(String str) {
        Object m10241constructorimpl;
        if (str == null) {
            return null;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(Uri.parse(str));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        return (Uri) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
    }

    public static final String urlEncode(String str) {
        Object m10241constructorimpl;
        Intrinsics.checkNotNullParameter(str, "<this>");
        try {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(URLEncoder.encode(str, "UTF-8"));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = "";
        }
        return (String) m10241constructorimpl;
    }

    public static final boolean isAppStoreUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(PLAY_GOOGLE_COM, uri.getHost()) || Intrinsics.areEqual(MARKET_ANDROID_COM, uri.getHost()) || Intrinsics.areEqual("market", uri.getScheme());
    }

    public static final boolean isExternalUrl(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return isHttpUrl(uri) || isAppStoreUrl(uri);
    }

    public static final boolean isMraid(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        return Intrinsics.areEqual(uri.getScheme(), "mraid");
    }
}
