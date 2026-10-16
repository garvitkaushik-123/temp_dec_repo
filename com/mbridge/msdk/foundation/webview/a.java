package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.android.exoplayer2.C;
import com.mbridge.msdk.activity.MBCommonActivity;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import java.util.ArrayList;

/* compiled from: BackPointBrowserViewListener.java */
/* loaded from: classes6.dex */
public class a implements BrowserView.e {
    private static String o = "a";

    /* renamed from: a, reason: collision with root package name */
    private int f4399a;
    private String c;
    private boolean d;
    private BaseTrackingListener e;
    private BrowserView f;
    private CampaignEx g;
    private com.mbridge.msdk.click.a h;
    private Context i;
    private JumpLoaderResult k;
    private long n;
    private boolean b = true;
    private boolean l = false;
    private final Runnable m = new RunnableC0344a();
    private Handler j = new Handler(Looper.getMainLooper());

    /* compiled from: BackPointBrowserViewListener.java */
    /* renamed from: com.mbridge.msdk.foundation.webview.a$a, reason: collision with other inner class name */
    class RunnableC0344a implements Runnable {
        RunnableC0344a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            p0.b(a.o, "webview js！超时上限：" + a.this.f4399a + "ms");
            if (a.this.h != null && a.this.k != null) {
                a.this.k.setSuccess(false);
                a.this.k.setUrl(a.this.c);
                a.this.k.setType(2);
                a.this.k.setExceptionMsg("linktype 8 time out");
                a.this.h.a(a.this.k, a.this.g, 1, false);
            }
            a aVar = a.this;
            if (aVar.d(null, aVar.c) && !a.this.l) {
                a.this.l = true;
                a aVar2 = a.this;
                aVar2.a(aVar2.i, a.this.c, a.this.g);
            }
            if (a.this.e != null) {
                a.this.e.onFinishRedirection(a.this.g, a.this.c);
            }
        }
    }

    /* compiled from: BackPointBrowserViewListener.java */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4401a;

        b(String str) {
            this.f4401a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.h != null && a.this.k != null) {
                a.this.k.setSuccess(true);
                a.this.k.setUrl(this.f4401a);
                a.this.k.setType(2);
                a.this.h.a(a.this.k, a.this.g, 1, true);
            }
            if (a.this.e != null) {
                a.this.e.onFinishRedirection(a.this.g, this.f4401a);
            }
        }
    }

    /* compiled from: BackPointBrowserViewListener.java */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4402a;

        c(String str) {
            this.f4402a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.e != null) {
                a.this.e.onFinishRedirection(a.this.g, this.f4402a);
            }
            if (a.this.h == null || a.this.k == null) {
                return;
            }
            a.this.k.setSuccess(true);
            a.this.k.setUrl(this.f4402a);
            a.this.k.setType(2);
            a.this.h.a(a.this.k, a.this.g, 1, true);
        }
    }

    /* compiled from: BackPointBrowserViewListener.java */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4403a;
        final /* synthetic */ String b;

        d(String str, String str2) {
            this.f4403a = str;
            this.b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.e != null) {
                a.this.e.onFinishRedirection(a.this.g, this.f4403a);
            }
            if (a.this.h == null || a.this.k == null) {
                return;
            }
            a.this.k.setSuccess(false);
            a.this.k.setUrl(this.f4403a);
            a.this.k.setType(2);
            a.this.k.setExceptionMsg(this.b);
            a.this.h.a(a.this.k, a.this.g, 1, true);
        }
    }

    public a(Context context, CampaignEx campaignEx, com.mbridge.msdk.click.a aVar, BrowserView browserView, BaseTrackingListener baseTrackingListener) {
        this.f4399a = 10000;
        this.k = null;
        this.i = context;
        this.g = campaignEx;
        this.f = browserView;
        this.e = baseTrackingListener;
        g d2 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        d2 = d2 == null ? h.b().a() : d2;
        this.h = aVar;
        this.k = new JumpLoaderResult();
        this.f4399a = (int) d2.o0();
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
    public void a() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http") && !parse.getScheme().equals("https")) {
                if (parse.getScheme().equals("intent")) {
                    Intent parseUri = Intent.parseUri(str, 1);
                    try {
                        String str2 = parseUri.getPackage();
                        if (!TextUtils.isEmpty(str2)) {
                            if (this.i.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                                return false;
                            }
                        }
                    } catch (Throwable th) {
                        p0.b(o, th.getMessage());
                    }
                    try {
                        String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            Uri parse2 = Uri.parse(str);
                            if (!parse2.getScheme().equals("http")) {
                                if (!parse2.getScheme().equals("https")) {
                                    str = stringExtra;
                                }
                            }
                            return true;
                        }
                    } catch (Throwable th2) {
                        p0.b(o, th2.getMessage());
                    }
                }
                if (com.mbridge.msdk.click.c.d(this.i, str)) {
                    p0.b(o, "openDeepLink");
                    return false;
                }
            }
            return true;
        } catch (Throwable th3) {
            p0.b(o, th3.getMessage());
            return true;
        }
    }

    private boolean e(WebView webView, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http") && !parse.getScheme().equals("https")) {
                if (parse.getScheme().equals("intent")) {
                    Intent parseUri = Intent.parseUri(str, 1);
                    try {
                        String str2 = parseUri.getPackage();
                        if (!TextUtils.isEmpty(str2) && this.i.getPackageManager().getLaunchIntentForPackage(str2) != null) {
                            parseUri.setFlags(268435456);
                            this.i.startActivity(parseUri);
                            this.l = true;
                            return true;
                        }
                    } catch (Throwable th) {
                        p0.b(o, th.getMessage());
                    }
                    try {
                        String stringExtra = parseUri.getStringExtra("browser_fallback_url");
                        if (!TextUtils.isEmpty(stringExtra)) {
                            Uri parse2 = Uri.parse(str);
                            if (!parse2.getScheme().equals("http") && !parse2.getScheme().equals("https")) {
                                str = stringExtra;
                            }
                            webView.loadUrl(stringExtra);
                            return false;
                        }
                    } catch (Throwable th2) {
                        p0.b(o, th2.getMessage());
                    }
                }
                if (com.mbridge.msdk.click.c.d(this.i, str)) {
                    p0.b(o, "openDeepLink");
                    this.l = true;
                    return true;
                }
            }
            return false;
        } catch (Throwable th3) {
            p0.b(o, th3.getMessage());
            return false;
        }
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
    public void c(WebView webView, String str) {
        if (this.n == 0) {
            this.n = System.currentTimeMillis();
            if (!this.d) {
                this.d = true;
                d();
            }
        }
        this.c = str;
        this.b = true;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
    public boolean b(WebView webView, String str) {
        p0.b(o, "shouldOverrideUrlLoading1  " + str);
        this.b = false;
        if (t0.a.b(str) && t0.a.a(this.i, str, null)) {
            this.l = true;
        }
        boolean e = e(webView, str);
        if (e) {
            this.n = 0L;
            this.b = false;
            c();
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new b(str));
        }
        return e;
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
    public void a(WebView webView, String str, Bitmap bitmap) {
        if (this.n == 0) {
            this.n = System.currentTimeMillis();
            if (!this.d) {
                this.d = true;
                d();
            }
            this.l = false;
        }
        this.c = str;
        this.b = true;
    }

    private void c() {
        this.j.removeCallbacks(this.m);
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
    public void a(WebView webView, String str) {
        p0.b(o, "onPageFinished1  " + str);
        if (this.b) {
            this.n = 0L;
            this.b = false;
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new c(str));
            if (TextUtils.isEmpty(str)) {
                return;
            }
            c();
            Uri parse = Uri.parse(str);
            if ((parse.getScheme().equals("http") || parse.getScheme().equals("https")) && !this.l) {
                this.l = true;
                a(this.i, str, this.g);
            }
        }
    }

    @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
    public void a(WebView webView, int i, String str, String str2) {
        p0.d(o, str);
        c();
        com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new d(str2, str));
        if (!d(webView, str2) || this.l) {
            return;
        }
        this.l = true;
        a(this.i, str2, this.g);
    }

    private void d() {
        this.j.postDelayed(this.m, this.f4399a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, CampaignEx campaignEx) {
        if (context == null) {
            return;
        }
        if (campaignEx != null) {
            campaignEx.getCurrentLocalRid();
        }
        try {
            int i = MBCommonActivity.e;
            Intent intent = new Intent(context, (Class<?>) MBCommonActivity.class);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.mbridge.msdk.foundation.webview.b.f4404a.put(str, this.f);
            if (t0.a.d(str)) {
                str = "https://play.google.com/store/apps/details?id=" + str.replace("market://details?id=", "");
            }
            intent.putExtra("url", str);
            p0.c("url", "webview url = " + str);
            intent.setFlags(C.ENCODING_PCM_32BIT);
            intent.putExtra("mvcommon", campaignEx);
            context.startActivity(intent);
        } catch (Exception unused) {
            t0.a(context, str, this.e, campaignEx, new ArrayList());
        }
    }
}
