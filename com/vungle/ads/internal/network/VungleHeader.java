package com.vungle.ads.internal.network;

import android.os.Build;
import com.ironsource.C3040d4;
import com.vungle.ads.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VungleHeader.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0006\u0010\u0010\u001a\u00020\u0011R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/vungle/ads/internal/network/VungleHeader;", "", "()V", "appId", "", "getAppId", "()Ljava/lang/String;", "setAppId", "(Ljava/lang/String;)V", C3040d4.i.W, "getAppVersion", "setAppVersion", "headerUa", "getHeaderUa", "setHeaderUa", "defaultHeader", "reset", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class VungleHeader {
    public static final VungleHeader INSTANCE;
    private static String appId;
    private static String appVersion;
    private static String headerUa;

    private VungleHeader() {
    }

    static {
        VungleHeader vungleHeader = new VungleHeader();
        INSTANCE = vungleHeader;
        headerUa = vungleHeader.defaultHeader();
    }

    public final String getHeaderUa() {
        return headerUa;
    }

    public final void setHeaderUa(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        headerUa = str;
    }

    public final String getAppId() {
        return appId;
    }

    public final void setAppId(String str) {
        appId = str;
    }

    public final String getAppVersion() {
        return appVersion;
    }

    public final void setAppVersion(String str) {
        appVersion = str;
    }

    private final String defaultHeader() {
        return (Intrinsics.areEqual("Amazon", Build.MANUFACTURER) ? "VungleAmazon/" : "VungleDroid/").concat(BuildConfig.VERSION_NAME);
    }

    public final void reset() {
        headerUa = defaultHeader();
    }
}
