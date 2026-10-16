package com.moloco.sdk.internal.client_metrics_data;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes6.dex */
public final class a {
    public static final /* synthetic */ a[] M;
    public static final /* synthetic */ EnumEntries N;
    public final String O;

    /* renamed from: a, reason: collision with root package name */
    public static final a f5377a = new a("SDKInitAttempt", 0, "sdk_init_attempt");
    public static final a b = new a("SDKInitSuccess", 1, "sdk_init_success");
    public static final a c = new a("SDKInitFailure", 2, "sdk_init_failure");
    public static final a d = new a("SDKPerformInitAttempt", 3, "sdk_perform_init_attempt");
    public static final a e = new a("SDKFetchInitAttempt", 4, "sdk_fetch_init_attempt");
    public static final a f = new a("SDKInitCacheRead", 5, "sdk_init_cache_read");
    public static final a g = new a("SDKInitCacheWrite", 6, "sdk_init_cache_write");
    public static final a h = new a("SDKInitCacheClear", 7, "sdk_init_cache_clear");
    public static final a i = new a("CreateAd", 8, "create_ad");
    public static final a j = new a("LoadAdAttempt", 9, "load_ad_attempted");
    public static final a k = new a("LoadAdSuccess", 10, "load_ad_success");
    public static final a l = new a("LoadAdFailed", 11, "load_ad_failed");
    public static final a m = new a("NativeAdLoadAdAttempted", 12, "native_ad_load_attempted");
    public static final a n = new a("NativeLoadAd", 13, "native_ad_load");
    public static final a o = new a("BidTokenGetRequest", 14, "bid_token_get_request");
    public static final a p = new a("BidTokenGetResponse", 15, "bid_token_get_response");
    public static final a q = new a("BidTokenFetch", 16, "bid_token_fetch");
    public static final a r = new a("BidTokenDurationTimeoutOneSecond", 17, "bid_token_duration_crossed_1s");
    public static final a s = new a("BidTokenDurationTimeoutThreeSecond", 18, "bid_token_duration_crossed_3s");
    public static final a t = new a("ServerBidTokenFetch", 19, "sbt_fetch");
    public static final a u = new a("ServerBidTokenCached", 20, "sbt_cached");
    public static final a v = new a("ServerBidTokenApiFetch", 21, "sbt_api_fetch");
    public static final a w = new a("ServerBidTokenAsyncRefresh", 22, "sbt_async_fetch");
    public static final a x = new a("ClientBidTokenBuild", 23, "bid_token_build");
    public static final a y = new a("ClientBidTokenCached", 24, "cbt_cached");
    public static final a z = new a("ShowAdAttempt", 25, "show_ad_attempted");
    public static final a A = new a("ShowAdSuccess", 26, "show_ad_success");
    public static final a B = new a("ShowAdFailed", 27, "show_ad_failed");
    public static final a C = new a("AdClicked", 28, "ad_clicked");
    public static final a D = new a("CrashDetected", 29, "crash_detected");
    public static final a E = new a("WebviewLoadAd", 30, "webview_load_ad");
    public static final a F = new a("WebviewHtmlAdError", 31, "webview_html_ad_error");
    public static final a G = new a("WebviewEventHandled", 32, "webview_event_handled");
    public static final a H = new a("WebviewEventMultipleHandlers", 33, "webview_event_multiple_handlers");
    public static final a I = new a("WebviewPageLoadStart", 34, "webview_page_load_start");
    public static final a J = new a("WebviewPageLoadEnd", 35, "webview_page_load_end");
    public static final a K = new a("WebviewPageLoadFinishCallback", 36, "webview_page_load_finish_callback");
    public static final a L = new a("WebviewRequiredContentLoaded", 37, "webview_required_content_loaded");

    static {
        a[] a2 = a();
        M = a2;
        N = EnumEntriesKt.enumEntries(a2);
    }

    public a(String str, int i2, String str2) {
        this.O = str2;
    }

    public static final /* synthetic */ a[] a() {
        return new a[]{f5377a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, A, B, C, D, E, F, G, H, I, J, K, L};
    }

    public static EnumEntries<a> b() {
        return N;
    }

    public static a valueOf(String str) {
        return (a) Enum.valueOf(a.class, str);
    }

    public static a[] values() {
        return (a[]) M.clone();
    }

    public final String c() {
        return this.O;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.O;
    }
}
