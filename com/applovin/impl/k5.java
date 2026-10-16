package com.applovin.impl;

import android.net.Uri;
import com.applovin.impl.e0;
import com.applovin.impl.j5;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class k5 extends j5 {
    private final com.applovin.impl.sdk.ad.a q;
    private boolean r;
    private boolean s;

    class a implements e0.a {
        a() {
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri != null) {
                k5.this.q.y1();
                k5.this.q.d(uri);
            }
        }
    }

    class b implements j5.e {
        b() {
        }

        @Override // com.applovin.impl.j5.e
        public void a(String str) {
            k5.this.q.d(k5.this.d(str));
            k5.this.q.b(true);
            com.applovin.impl.sdk.o oVar = k5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                k5 k5Var = k5.this;
                k5Var.c.a(k5Var.b, "Finish caching non-video resources for ad #" + k5.this.q.getAdIdNumber());
            }
            k5 k5Var2 = k5.this;
            k5Var2.c.f(k5Var2.b, "Ad updated with cachedHTML = " + k5.this.q.s1());
        }
    }

    public k5(com.applovin.impl.sdk.ad.a aVar, com.applovin.impl.sdk.k kVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheAppLovinAd", aVar, kVar, appLovinAdLoadListener);
        this.q = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String d(String str) {
        if (k7.j(com.applovin.impl.sdk.k.o())) {
            str = k7.c(str);
        }
        if (!this.q.isOpenMeasurementEnabled()) {
            return str;
        }
        return this.f464a.e0().a(str, e2.a((AppLovinAdImpl) this.g));
    }

    private void m() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching non-optional HTML resources...");
        }
        this.q.d(d(a(this.q.s1(), this.q.c0(), this.q)));
        this.q.b(true);
        a(this.q);
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finish caching non-optional HTML resources for ad #" + this.q.getAdIdNumber());
        }
        this.c.f(this.b, "Ad HTML updated to reference locally cached non-optional resources = " + this.q.s1());
    }

    private void n() {
        Uri c;
        if (l() || (c = c(this.q.w1())) == null) {
            return;
        }
        this.q.y1();
        this.q.d(c);
    }

    private d0 o() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching HTML resources...");
        }
        return a(this.q.s1(), this.q.c0(), new b());
    }

    private e0 p() {
        return b(this.q.w1(), new a());
    }

    private void q() {
        List<String> R = this.q.R();
        if (CollectionUtils.isEmpty(R)) {
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching optional HTML resources...");
        }
        String s1 = this.q.s1();
        for (String str : R) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Caching optional resource: " + str);
            }
            int a2 = this.f464a.H().a(str, this.g);
            Map a3 = e2.a((AppLovinAdImpl) this.g);
            String a4 = this.f464a.H().a(com.applovin.impl.sdk.k.o(), str, this.q.getCachePrefix(), this.q.c0(), true, true, a2, this.i, a3);
            if (StringUtils.isValidString(a4)) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Updating HTML with cached optional resource: " + a4);
                }
                this.q.a(Uri.parse(a4));
                s1 = s1.replace(str, a4);
                this.q.d(s1);
            } else {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Failed to cache optional resource: " + str);
                }
                a(str, "cacheOptionalHtmlResource", a3);
            }
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finish caching optional HTML resources for ad #" + this.q.getAdIdNumber());
        }
    }

    public void b(boolean z) {
        this.s = z;
    }

    public void c(boolean z) {
        this.r = z;
    }

    @Override // com.applovin.impl.j5, java.lang.Runnable
    public void run() {
        super.run();
        boolean O0 = this.q.O0();
        boolean z = this.s;
        if (O0 || z) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Begin caching for streaming ad #" + this.q.getAdIdNumber() + "...");
            }
            if (((Boolean) this.f464a.a(v4.I0)).booleanValue()) {
                if (!o0.e()) {
                    a(e());
                }
                ArrayList arrayList = new ArrayList();
                if (!O0) {
                    f();
                    d0 o = o();
                    if (o != null) {
                        arrayList.add(o);
                    }
                } else if (this.r) {
                    f();
                    d0 o2 = o();
                    if (o2 != null) {
                        arrayList.add(o2);
                    }
                    e0 p = p();
                    if (p != null) {
                        arrayList.add(p);
                    }
                } else {
                    d0 o3 = o();
                    if (o3 != null) {
                        a(Arrays.asList(o3));
                    }
                    f();
                    e0 p2 = p();
                    if (p2 != null) {
                        arrayList.add(p2);
                    }
                }
                a(arrayList);
                f();
            } else {
                j();
                if (O0) {
                    if (this.r) {
                        f();
                    }
                    m();
                    if (!this.r) {
                        f();
                    }
                    n();
                } else {
                    f();
                    m();
                }
            }
        } else {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Begin processing for non-streaming ad #" + this.q.getAdIdNumber() + "...");
            }
            if (((Boolean) this.f464a.a(v4.I0)).booleanValue()) {
                ArrayList arrayList2 = new ArrayList();
                if (!o0.e()) {
                    arrayList2.addAll(e());
                }
                d0 o4 = o();
                if (o4 != null) {
                    arrayList2.add(o4);
                }
                e0 p3 = p();
                if (p3 != null) {
                    arrayList2.add(p3);
                }
                a(arrayList2);
                f();
                q();
            } else {
                j();
                m();
                n();
                f();
                q();
            }
        }
        k();
    }
}
