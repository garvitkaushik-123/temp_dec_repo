package com.inmobi.media;

import android.webkit.WebResourceResponse;
import java.net.URLDecoder;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public abstract class qf {
    public static WebResourceResponse a(String urlRaw, InterfaceC2971z5 interfaceC2971z5) {
        String url;
        Intrinsics.checkNotNullParameter(urlRaw, "urlRaw");
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("IMResourceCacheManager", AbstractC2673h0.a("shouldInterceptRequest ", urlRaw));
        }
        try {
            url = URLDecoder.decode(StringsKt.trim((CharSequence) urlRaw).toString(), "UTF-8");
        } catch (Exception unused) {
            url = null;
        }
        if (url == null) {
            return null;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        if (StringsKt.contains$default((CharSequence) url, (CharSequence) "inmobicache=true", false, 2, (Object) null)) {
            return sf.f2706a.a(url, interfaceC2971z5);
        }
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("IMResourceCacheManager", "Cache is not enabled for URL: ".concat(url));
        }
        return null;
    }
}
