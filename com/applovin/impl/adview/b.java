package com.applovin.impl.adview;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebSettings;
import com.applovin.impl.e2;
import com.applovin.impl.j0;
import com.applovin.impl.k7;
import com.applovin.impl.l7;
import com.applovin.impl.l8;
import com.applovin.impl.o0;
import com.applovin.impl.o7;
import com.applovin.impl.r4;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t;
import com.applovin.impl.t7;
import com.applovin.impl.v4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public class b extends j0 {
    private static final Set j = Collections.newSetFromMap(new WeakHashMap());
    private static final Object k = new Object();
    private final o c;
    private final com.applovin.impl.sdk.k d;
    private com.applovin.impl.sdk.ad.b e;
    private boolean f;
    private boolean g;
    private final List h;
    private final Object i;

    class a extends r4 {
        a() {
        }

        @Override // com.applovin.impl.r4
        protected Map a() {
            return CollectionUtils.hashMap("name", "AdWebView");
        }
    }

    public b(c cVar, com.applovin.impl.sdk.k kVar, Context context) {
        super(context);
        this.h = new ArrayList();
        this.i = new Object();
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified.");
        }
        this.d = kVar;
        this.c = kVar.O();
        Integer num = (Integer) kVar.a(v4.u6);
        if (num.intValue() > 0) {
            synchronized (k) {
                Set set = j;
                set.add(this);
                k7.a("AdWebView", set.size(), num.intValue(), kVar.E());
            }
        }
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(cVar != null ? cVar : new a());
        setWebChromeClient(new t(cVar != null ? cVar.d() : null, kVar));
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
        if (o0.j() && ((Boolean) kVar.a(v4.N5)).booleanValue()) {
            setWebViewRenderProcessClient(new d(kVar).a());
        }
        setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.adview.b$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean a2;
                a2 = b.a(view, motionEvent);
                return a2;
            }
        });
        setOnLongClickListener(new View.OnLongClickListener() { // from class: com.applovin.impl.adview.b$$ExternalSyntheticLambda1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean a2;
                a2 = b.this.a(view);
                return a2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(View view, MotionEvent motionEvent) {
        if (view.hasFocus()) {
            return false;
        }
        view.requestFocus();
        return false;
    }

    private void b() {
        synchronized (this.i) {
            Iterator it = this.h.iterator();
            while (it.hasNext()) {
                l8.a(this, (String) it.next(), "AdWebView", this.d);
            }
            this.h.clear();
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public void computeScroll() {
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.f = true;
        this.g = false;
        super.destroy();
    }

    public com.applovin.impl.sdk.ad.b getCurrentAd() {
        return this.e;
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
    }

    public void setAdHtmlLoaded(boolean z) {
        this.g = z;
        if (z && ((Boolean) this.d.a(v4.m6)).booleanValue()) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(View view) {
        if (!o.a()) {
            return true;
        }
        this.c.a("AdWebView", "Received a LongClick event.");
        return true;
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        String str;
        if (!this.f) {
            this.e = bVar;
            try {
                applySettings(bVar);
                if (k7.a(bVar.getSize())) {
                    setVisibility(0);
                }
                bVar.a(SystemClock.elapsedRealtime());
                if (bVar instanceof com.applovin.impl.sdk.ad.a) {
                    loadDataWithBaseURL(bVar.k(), ((com.applovin.impl.sdk.ad.a) bVar).s1(), "text/html", null, "");
                    if (o.a()) {
                        this.c.a("AdWebView", "AppLovinAd rendered");
                        return;
                    }
                    return;
                }
                if (bVar instanceof l7) {
                    l7 l7Var = (l7) bVar;
                    o7 s1 = l7Var.s1();
                    if (s1 != null) {
                        t7 e = s1.e();
                        Uri c = e.c();
                        if (c != null) {
                            str = c.toString();
                        } else {
                            str = "";
                        }
                        String b = e.b();
                        String u1 = l7Var.u1();
                        if (!StringUtils.isValidString(str) && !StringUtils.isValidString(b)) {
                            if (o.a()) {
                                this.c.b("AdWebView", "Unable to load companion ad. No resources provided.");
                                return;
                            }
                            return;
                        }
                        if (e.d() == t7.a.STATIC) {
                            if (o.a()) {
                                this.c.a("AdWebView", "Rendering WebView for static VAST ad");
                            }
                            String a2 = a((String) this.d.a(v4.D4), str);
                            if (l7Var.J1() && l7Var.isOpenMeasurementEnabled() && l7Var.K1()) {
                                a2 = this.d.e0().a(a2, e2.a((AppLovinAdImpl) bVar));
                            }
                            loadDataWithBaseURL(bVar.k(), a2, "text/html", null, "");
                            return;
                        }
                        if (e.d() == t7.a.HTML) {
                            if (StringUtils.isValidString(b)) {
                                String a3 = a(u1, b);
                                String str2 = StringUtils.isValidString(a3) ? a3 : b;
                                if (o.a()) {
                                    this.c.a("AdWebView", "Rendering WebView for HTML VAST ad with resourceContents: " + str2);
                                }
                                loadDataWithBaseURL(bVar.k(), str2, "text/html", null, "");
                                return;
                            }
                            if (StringUtils.isValidString(str)) {
                                if (o.a()) {
                                    this.c.a("AdWebView", "Preparing to load HTML VAST ad resourceUri");
                                }
                                a(str, bVar.k(), u1, this.d, l7Var);
                                return;
                            }
                            return;
                        }
                        String str3 = str;
                        if (e.d() == t7.a.IFRAME) {
                            if (StringUtils.isValidString(str3)) {
                                if (o.a()) {
                                    this.c.a("AdWebView", "Preparing to load iFrame VAST ad resourceUri");
                                }
                                a(str3, bVar.k(), u1, this.d, l7Var);
                                return;
                            } else {
                                if (StringUtils.isValidString(b)) {
                                    String a4 = a(u1, b);
                                    String str4 = StringUtils.isValidString(a4) ? a4 : b;
                                    if (o.a()) {
                                        this.c.a("AdWebView", "Rendering WebView for iFrame VAST ad with resourceContents: " + str4);
                                    }
                                    loadDataWithBaseURL(bVar.k(), str4, "text/html", null, "");
                                    return;
                                }
                                return;
                            }
                        }
                        if (o.a()) {
                            this.c.b("AdWebView", "Failed to render VAST companion ad of invalid type");
                            return;
                        }
                        return;
                    }
                    if (o.a()) {
                        this.c.a("AdWebView", "No companion ad provided.");
                        return;
                    }
                    return;
                }
                return;
            } catch (Throwable th) {
                throw new RuntimeException("Unable to render AppLovin ad (" + (bVar != null ? String.valueOf(bVar.getAdIdNumber()) : "null") + ") - " + th);
            }
        }
        o.h("AdWebView", "Ad can not be loaded in a destroyed webview");
    }

    public void a(String str) {
        if (((Boolean) this.d.a(v4.m6)).booleanValue()) {
            if (this.g) {
                l8.a(this, str, "AdWebView", this.d);
                return;
            }
            synchronized (this.h) {
                this.h.add(str);
            }
            return;
        }
        l8.a(this, str, "AdWebView", this.d);
    }

    private void a(String str, String str2, String str3, com.applovin.impl.sdk.k kVar, l7 l7Var) {
        String a2 = a(str3, str);
        if (StringUtils.isValidString(a2)) {
            if (o.a()) {
                this.c.a("AdWebView", "Rendering webview for VAST ad with resourceContents : " + a2);
            }
            loadDataWithBaseURL(str2, a2, "text/html", null, "");
            return;
        }
        String a3 = a((String) kVar.a(v4.E4), str);
        if (StringUtils.isValidString(a3)) {
            if (l7Var.J1() && l7Var.isOpenMeasurementEnabled()) {
                a3 = kVar.e0().a(a3, e2.a((AppLovinAdImpl) l7Var));
            }
            if (o.a()) {
                this.c.a("AdWebView", "Rendering webview for VAST ad with resourceContents : " + a3);
            }
            loadDataWithBaseURL(str2, a3, "text/html", null, "");
            return;
        }
        if (o.a()) {
            this.c.a("AdWebView", "Rendering webview for VAST ad with resourceURL : " + str);
        }
        loadUrl(str);
    }

    private String a(String str, String str2) {
        if (StringUtils.isValidString(str)) {
            return str.replace("{SOURCE}", str2);
        }
        return null;
    }
}
