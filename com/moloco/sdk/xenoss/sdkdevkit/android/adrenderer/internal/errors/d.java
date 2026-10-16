package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public static final d f5834a = new d("MRAID_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR", 0);
    public static final d b = new d("MRAID_WEBVIEW_CLIENT_RENDER_PROCESS_GONE_ERROR", 1);
    public static final d c = new d("MRAID_WEBVIEW_LOAD_DATA_WITH_BASE_URL_ERROR", 2);
    public static final d d = new d("MRAID_WEBVIEW_PAGE_DIDNT_LOAD_ERROR", 3);
    public static final d e = new d("MRAID_WEBVIEW_INTERNAL_TIMEOUT_ERROR", 4);
    public static final d f = new d("MRAID_FULLSCREEN_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR", 5);
    public static final d g = new d("MRAID_FULLSCREEN_WEBVIEW_CLIENT_RENDER_PROCESS_GONE_ERROR", 6);
    public static final d h = new d("MRAID_FULLSCREEN_WEBVIEW_LOAD_DATA_WITH_BASE_URL_ERROR", 7);
    public static final d i = new d("MRAID_FULLSCREEN_WEBVIEW_PAGE_DIDNT_LOAD_ERROR", 8);
    public static final d j = new d("MRAID_FULLSCREEN_AD_ACTIVITY_SHOW_FAILED_ERROR", 9);
    public static final d k = new d("MRAID_BANNER_WEBVIEW_CLIENT_UNRECOVERABLE_ERROR", 10);
    public static final d l = new d("MRAID_BANNER_WEBVIEW_CLIENT_RENDER_PROCESS_GONE_ERROR", 11);
    public static final d m = new d("MRAID_BANNER_WEBVIEW_LOAD_DATA_WITH_BASE_URL_ERROR", 12);
    public static final d n = new d("MRAID_BANNER_WEBVIEW_PAGE_DIDNT_LOAD_ERROR", 13);
    public static final /* synthetic */ d[] o;
    public static final /* synthetic */ EnumEntries p;

    static {
        d[] b2 = b();
        o = b2;
        p = EnumEntriesKt.enumEntries(b2);
    }

    public d(String str, int i2) {
    }

    public static final /* synthetic */ d[] b() {
        return new d[]{f5834a, b, c, d, e, f, g, h, i, j, k, l, m, n};
    }

    public static EnumEntries<d> c() {
        return p;
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) o.clone();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.errors.c
    public String a() {
        return name();
    }
}
