package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class g implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final g f5837a = new g("STATIC_AD_UNKNOWN_ERROR", 0);
    public static final g b = new g("STATIC_AD_WEBVIEW_DATA_WITH_DEFAULT_BASE_URL_ERROR", 1);
    public static final g c = new g("STATIC_AD_WEBVIEW_RECEIVED_ERROR", 2);
    public static final g d = new g("STATIC_AD_WEBVIEW_RENDER_PROCESS_GONE_ERROR", 3);
    public static final /* synthetic */ g[] e;
    public static final /* synthetic */ EnumEntries f;

    static {
        g[] b2 = b();
        e = b2;
        f = EnumEntriesKt.enumEntries(b2);
    }

    public g(String str, int i) {
    }

    public static final /* synthetic */ g[] b() {
        return new g[]{f5837a, b, c, d};
    }

    public static EnumEntries<g> c() {
        return f;
    }

    public static g valueOf(String str) {
        return (g) Enum.valueOf(g.class, str);
    }

    public static g[] values() {
        return (g[]) e.clone();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c
    public String a() {
        return name();
    }
}
