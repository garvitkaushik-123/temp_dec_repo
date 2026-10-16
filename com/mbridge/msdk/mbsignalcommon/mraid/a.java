package com.mbridge.msdk.mbsignalcommon.mraid;

import android.webkit.WebView;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: CallMraidJS.java */
/* loaded from: classes6.dex */
public class a {

    /* compiled from: CallMraidJS.java */
    /* renamed from: com.mbridge.msdk.mbsignalcommon.mraid.a$a, reason: collision with other inner class name */
    private static class C0363a {

        /* renamed from: a, reason: collision with root package name */
        private static final a f4559a = new a();
    }

    public static a a() {
        return C0363a.f4559a;
    }

    public void b(WebView webView, float f, float f2) {
        a(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setScreenSize(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2)));
    }

    public void c(WebView webView, float f, float f2) {
        a(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.notifySizeChangeEvent(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2)));
    }

    public void a(WebView webView) {
        a(webView, "javascript:window.mraidbridge.fireReadyEvent();");
    }

    public void b(WebView webView, float f, float f2, float f3, float f4) {
        a(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setDefaultPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
    }

    public void a(WebView webView, Map<String, Object> map) {
        if (map == null || map.size() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            try {
                jSONObject.put(entry.getKey(), entry.getValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        String jSONObject2 = jSONObject.toString();
        try {
            jSONObject2 = URLEncoder.encode(jSONObject2, "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        a(webView, String.format("javascript:window.mraidbridge.fireChangeEvent(%s);", jSONObject2));
    }

    public void c(WebView webView, String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(webView, String.format("javascript:window.mraidbridge.setIsViewable(%s);", str));
    }

    public void b(WebView webView, String str) {
        try {
            str = URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(webView, String.format("javascript:window.mraidbridge.nativeCallComplete('%s');", str));
    }

    public void a(WebView webView, String str, String str2) {
        try {
            str2 = URLEncoder.encode(str2, "UTF-8");
            str = URLEncoder.encode(str, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        a(webView, String.format("javascript:window.mraidbridge.fireErrorEvent('%1s', '%2s');", str2, str));
    }

    public void a(WebView webView, double d) {
        a(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.audioVolumeChange(%s);", Double.valueOf(d)));
    }

    public void a(WebView webView, float f, float f2) {
        a(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setMaxSize(%.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2)));
    }

    public void a(WebView webView, float f, float f2, float f3, float f4) {
        a(webView, String.format(Locale.CHINA, "javascript:window.mraidbridge.setCurrentPosition(%.1f, %.1f, %.1f, %.1f);", Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
    }

    private void a(WebView webView, String str) {
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
