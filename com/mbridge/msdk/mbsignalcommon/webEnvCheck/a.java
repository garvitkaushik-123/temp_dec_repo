package com.mbridge.msdk.mbsignalcommon.webEnvCheck;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.webkit.WebView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.base.b;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;

/* compiled from: MBWebViewChecker.java */
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile Boolean f4563a;
    private static volatile Handler b;
    private static Boolean c;

    /* compiled from: MBWebViewChecker.java */
    /* renamed from: com.mbridge.msdk.mbsignalcommon.webEnvCheck.a$a, reason: collision with other inner class name */
    class RunnableC0364a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4564a;

        RunnableC0364a(Context context) {
            this.f4564a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.f4563a == null) {
                try {
                    Boolean unused = a.f4563a = Boolean.valueOf(a.a(this.f4564a));
                } catch (Exception unused2) {
                    Boolean unused3 = a.f4563a = Boolean.FALSE;
                }
            }
        }
    }

    public static boolean b(Context context) {
        g gVar;
        try {
            gVar = h.b().b(c.m().b());
        } catch (Exception unused) {
            gVar = null;
        }
        if (gVar != null) {
            c = Boolean.valueOf(gVar.C0());
        } else {
            c = Boolean.FALSE;
        }
        Boolean bool = c;
        if (bool == null || !bool.booleanValue()) {
            return true;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (f4563a == null) {
                try {
                    f4563a = Boolean.valueOf(a(context));
                } catch (Exception unused2) {
                    f4563a = Boolean.FALSE;
                }
            }
            if (f4563a == null) {
                f4563a = new Boolean(false);
            }
            return f4563a.booleanValue();
        }
        if (f4563a == null && b == null) {
            b = new Handler(Looper.getMainLooper());
            b.post(new RunnableC0364a(context));
        }
        if (f4563a == null) {
            return true;
        }
        return f4563a.booleanValue();
    }

    public static boolean a(Context context) {
        WebView webView;
        try {
            webView = new WebView(context);
            webView.setWebViewClient(new b());
        } catch (Exception unused) {
            webView = null;
        }
        if (webView == null) {
            return false;
        }
        a(webView);
        return true;
    }

    private static void a(WebView webView) {
        try {
            webView.destroy();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("MBWebViewChecker", "destroy webview error", e);
            }
        }
    }
}
