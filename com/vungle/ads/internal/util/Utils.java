package com.vungle.ads.internal.util;

import android.webkit.URLUtil;
import kotlin.Metadata;

/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¨\u0006\b"}, d2 = {"Lcom/vungle/ads/internal/util/Utils;", "", "()V", "isOSVersionInvalid", "", "isUrlValid", "url", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class Utils {
    public static final Utils INSTANCE = new Utils();

    public final boolean isOSVersionInvalid() {
        return false;
    }

    private Utils() {
    }

    public final boolean isUrlValid(String url) {
        String str = url;
        if (str == null || str.length() == 0) {
            return false;
        }
        return URLUtil.isHttpsUrl(url) || URLUtil.isHttpUrl(url);
    }
}
