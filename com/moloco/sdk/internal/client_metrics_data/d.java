package com.moloco.sdk.internal.client_metrics_data;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class d {
    public static final d b = new d("SDKInit", 0, "sdk_init_time");
    public static final d c = new d("SDKPerformInitAttempt", 1, "sdk_perform_init_time_ms");
    public static final d d = new d("SDKInitHttpRequest", 2, "sdk_init_request_time_ms");
    public static final d e = new d("SDKInitCacheRead", 3, "sdk_init_cache_read_time_ms");
    public static final d f = new d("SDKInitCacheWrite", 4, "sdk_init_cache_write_time_ms");
    public static final d g = new d("SDKInitCacheClear", 5, "sdk_init_cache_clear_time_ms");
    public static final d h = new d("CreateAd", 6, "create_ad_time_ms");
    public static final d i = new d("CreateAdAwaitAdFactory", 7, "create_ad_await_ad_factory_time_ms");
    public static final d j = new d("LoadAd", 8, "load_ad_time");
    public static final d k = new d("NativePrepareAd", 9, "native_ad_load_prepare_time");
    public static final d l = new d("BidTokenFetch", 10, "bid_token_fetch_time");
    public static final d m = new d("ServerBidTokenFetch", 11, "sbt_fetch_time_ms");
    public static final d n = new d("ServerBidTokenApiFetchTime", 12, "sbt_api_fetch_time_ms");
    public static final d o = new d("ClientBidTokenBuild", 13, "bid_token_build_time_ms");
    public static final d p = new d("LoadToShow", 14, "load_to_show_time");
    public static final d q = new d("CreateToLoad", 15, "ad_create_to_load_ms");
    public static final d r = new d("WebviewLoadAd", 16, "webview_load_ad_ms");
    public static final d s = new d("WebviewEventHandled", 17, "webview_event_handled_time_ms");
    public static final d t = new d("WebviewEventHandlerLatency", 18, "webview_event_handler_latency_ms");
    public static final d u = new d("WebviewPageLoadLatency", 19, "webview_page_load_ms");
    public static final d v = new d("WebviewRequiredContentLoadLatency", 20, "webview_required_content_load_ms");
    public static final /* synthetic */ d[] w;
    public static final /* synthetic */ EnumEntries x;

    /* renamed from: a, reason: collision with root package name */
    public final String f5380a;

    static {
        d[] a2 = a();
        w = a2;
        x = EnumEntriesKt.enumEntries(a2);
    }

    public d(String str, int i2, String str2) {
        this.f5380a = str2;
    }

    public static final /* synthetic */ d[] a() {
        return new d[]{b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v};
    }

    public static EnumEntries<d> b() {
        return x;
    }

    public static d valueOf(String str) {
        return (d) Enum.valueOf(d.class, str);
    }

    public static d[] values() {
        return (d[]) w.clone();
    }

    public final String c() {
        return this.f5380a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f5380a;
    }
}
