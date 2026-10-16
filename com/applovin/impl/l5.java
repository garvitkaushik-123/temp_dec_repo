package com.applovin.impl;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.impl.e0;
import com.applovin.impl.j5;
import com.applovin.impl.l7;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t7;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes2.dex */
class l5 extends j5 {
    private final l7 q;

    class a implements e0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t7 f532a;

        a(t7 t7Var) {
            this.f532a = t7Var;
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri != null) {
                this.f532a.a(uri);
                l5.this.q.b(true);
                return;
            }
            com.applovin.impl.sdk.o oVar = l5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                l5 l5Var = l5.this;
                l5Var.c.b(l5Var.b, "Failed to cache static companion ad");
            }
        }
    }

    class b implements j5.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t7 f533a;

        b(t7 t7Var) {
            this.f533a = t7Var;
        }

        @Override // com.applovin.impl.j5.e
        public void a(String str) {
            this.f533a.a(str);
            l5.this.q.b(true);
        }
    }

    class c implements j5.e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ t7 f534a;

        c(t7 t7Var) {
            this.f534a = t7Var;
        }

        @Override // com.applovin.impl.j5.e
        public void a(String str) {
            this.f534a.a(str);
            l5.this.q.b(true);
        }
    }

    class d implements e0.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ z7 f535a;

        d(z7 z7Var) {
            this.f535a = z7Var;
        }

        @Override // com.applovin.impl.e0.a
        public void a(Uri uri) {
            if (uri != null) {
                com.applovin.impl.sdk.o oVar = l5.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    l5 l5Var = l5.this;
                    l5Var.c.a(l5Var.b, "Video file successfully cached into: " + uri);
                }
                this.f535a.a(uri);
                return;
            }
            com.applovin.impl.sdk.o oVar2 = l5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                l5 l5Var2 = l5.this;
                l5Var2.c.b(l5Var2.b, "Failed to cache video file: " + this.f535a);
            }
        }
    }

    class e implements j5.e {
        e() {
        }

        @Override // com.applovin.impl.j5.e
        public void a(String str) {
            if (l5.this.q.isOpenMeasurementEnabled()) {
                str = l5.this.f464a.e0().a(str, e2.a((AppLovinAdImpl) l5.this.g));
            }
            l5.this.q.d(str);
            com.applovin.impl.sdk.o oVar = l5.this.c;
            if (com.applovin.impl.sdk.o.a()) {
                l5 l5Var = l5.this;
                l5Var.c.a(l5Var.b, "Finish caching HTML template " + l5.this.q.u1() + " for ad #" + l5.this.q.getAdIdNumber());
            }
        }
    }

    public l5(l7 l7Var, com.applovin.impl.sdk.k kVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        super("TaskCacheVastAd", l7Var, kVar, appLovinAdLoadListener);
        this.q = l7Var;
    }

    private String d(String str) {
        for (String str2 : StringUtils.getRegexMatches(StringUtils.match(str, (String) this.f464a.a(v4.X4)), 1)) {
            if (!TextUtils.isEmpty(str2)) {
                Uri a2 = a(str2, Collections.emptyList(), false);
                if (a2 != null) {
                    str = str.replace(str2, a2.toString());
                    this.g.a(a2);
                } else if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Failed to cache JavaScript resource: " + str2);
                }
            }
        }
        return str;
    }

    private void m() {
        if (l()) {
            return;
        }
        if (!this.q.G1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Companion ad caching disabled. Skipping...");
                return;
            }
            return;
        }
        o7 s1 = this.q.s1();
        if (s1 == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "No companion ad provided. Skipping...");
                return;
            }
            return;
        }
        t7 e2 = s1.e();
        if (e2 == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to retrieve non-video resources from companion ad. Skipping...");
                return;
            }
            return;
        }
        Uri c2 = e2.c();
        String uri = c2 != null ? c2.toString() : "";
        String b2 = e2.b();
        if (!URLUtil.isValidUrl(uri) && !StringUtils.isValidString(b2)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.k(this.b, "Companion ad does not have any resources attached. Skipping...");
                return;
            }
            return;
        }
        if (e2.d() == t7.a.STATIC) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Caching static companion ad at " + uri + "...");
            }
            Uri a2 = a(uri, Collections.emptyList(), false);
            if (a2 != null) {
                e2.a(a2);
                this.q.b(true);
                return;
            } else {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Failed to cache static companion ad");
                    return;
                }
                return;
            }
        }
        if (e2.d() != t7.a.HTML) {
            if (e2.d() == t7.a.IFRAME && com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Skip caching of iFrame resource...");
                return;
            }
            return;
        }
        if (!StringUtils.isValidString(uri)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Caching provided HTML for companion ad. No fetch required. HTML: " + b2);
            }
            if (((Boolean) this.f464a.a(v4.W4)).booleanValue()) {
                b2 = d(b2);
            }
            e2.a(a(b2, Collections.emptyList(), this.q));
            this.q.b(true);
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Begin caching HTML companion ad. Fetching from " + uri + "...");
        }
        String c3 = c(uri, null, false);
        if (!StringUtils.isValidString(c3)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to load companion ad resources from " + uri);
            }
        } else {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "HTML fetched. Caching HTML now...");
            }
            e2.a(a(c3, Collections.emptyList(), this.q));
            this.q.b(true);
        }
    }

    private void n() {
        if (l() || !x7.a(this.q)) {
            return;
        }
        String u1 = this.q.u1();
        if (!StringUtils.isValidString(u1)) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to load HTML template");
                return;
            }
            return;
        }
        String a2 = a(u1, this.q.c0(), this.g);
        if (this.q.isOpenMeasurementEnabled()) {
            a2 = this.f464a.e0().a(a2, e2.a((AppLovinAdImpl) this.g));
        }
        this.q.d(a2);
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finish caching HTML template " + this.q.u1() + " for ad #" + this.q.getAdIdNumber());
        }
    }

    private void o() {
        z7 C1;
        Uri e2;
        if (l()) {
            return;
        }
        if (!this.q.H1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Video caching disabled. Skipping...");
            }
        } else {
            if (this.q.B1() == null || (C1 = this.q.C1()) == null || (e2 = C1.e()) == null) {
                return;
            }
            Uri b2 = b(e2.toString(), Collections.emptyList(), false);
            if (b2 != null) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Video file successfully cached into: " + b2);
                }
                C1.a(b2);
            } else if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to cache video file: " + C1);
            }
        }
    }

    private c0 p() {
        if (!this.q.G1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Companion ad caching disabled. Skipping...");
            }
            return null;
        }
        o7 s1 = this.q.s1();
        if (s1 == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "No companion ad provided. Skipping...");
            }
            return null;
        }
        t7 e2 = s1.e();
        if (e2 == null) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Failed to retrieve non-video resources from companion ad. Skipping...");
            }
            return null;
        }
        Uri c2 = e2.c();
        String uri = c2 != null ? c2.toString() : "";
        String b2 = e2.b();
        if (URLUtil.isValidUrl(uri) || StringUtils.isValidString(b2)) {
            if (e2.d() == t7.a.STATIC) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Caching static companion ad at " + uri + "...");
                }
                return new e0(uri, this.q, Collections.emptyList(), false, this.i, this.f464a, new a(e2));
            }
            if (e2.d() == t7.a.HTML) {
                if (!StringUtils.isValidString(uri)) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.a(this.b, "Caching provided HTML for companion ad. No fetch required. HTML: " + b2);
                    }
                    return a(b2, Collections.emptyList(), new c(e2));
                }
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Begin caching HTML companion ad. Fetching from " + uri + "...");
                }
                String c3 = c(uri, null, false);
                if (StringUtils.isValidString(c3)) {
                    if (com.applovin.impl.sdk.o.a()) {
                        this.c.a(this.b, "HTML fetched. Caching HTML now...");
                    }
                    return a(c3, Collections.emptyList(), new b(e2));
                }
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Unable to load companion ad resources from " + uri);
                }
            } else if (e2.d() == t7.a.IFRAME && com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Skip caching of iFrame resource...");
            }
        } else if (com.applovin.impl.sdk.o.a()) {
            this.c.k(this.b, "Companion ad does not have any resources attached. Skipping...");
        }
        return null;
    }

    @Override // com.applovin.impl.j5
    void f() {
        this.q.getAdEventTracker().h();
        super.f();
    }

    protected d0 q() {
        if (!TextUtils.isEmpty(this.q.u1())) {
            return a(this.q.u1(), this.q.c0(), new e());
        }
        if (!com.applovin.impl.sdk.o.a()) {
            return null;
        }
        this.c.a(this.b, "Unable to load HTML template");
        return null;
    }

    protected e0 r() {
        z7 C1;
        Uri e2;
        if (!this.q.H1()) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Video caching disabled. Skipping...");
            }
            return null;
        }
        if (this.q.B1() == null || (C1 = this.q.C1()) == null || (e2 = C1.e()) == null) {
            return null;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Caching video file " + C1 + " creative...");
        }
        return a(e2.toString(), Collections.emptyList(), false, new d(C1));
    }

    @Override // com.applovin.impl.j5, java.lang.Runnable
    public void run() {
        super.run();
        boolean O0 = this.q.O0();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Begin caching for VAST " + (O0 ? "streaming " : "") + "ad #" + this.g.getAdIdNumber() + "...");
        }
        if (O0) {
            if (((Boolean) this.f464a.a(v4.I0)).booleanValue()) {
                if (!o0.e()) {
                    a(e());
                }
                if (this.q.E1()) {
                    f();
                    ArrayList arrayList = new ArrayList();
                    c0 p = p();
                    if (p != null) {
                        arrayList.add(p);
                    }
                    d0 q = q();
                    if (q != null) {
                        arrayList.add(q);
                    }
                    e0 r = r();
                    if (r != null) {
                        arrayList.add(r);
                    }
                    a(arrayList);
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    if (this.q.v1() == l7.c.COMPANION_AD) {
                        c0 p2 = p();
                        if (p2 != null) {
                            arrayList2.add(p2);
                        }
                        d0 q2 = q();
                        if (q2 != null) {
                            arrayList2.add(q2);
                        }
                        a(arrayList2);
                        f();
                        e0 r2 = r();
                        if (r2 != null) {
                            arrayList3.add(r2);
                        }
                        a(arrayList3);
                    } else {
                        e0 r3 = r();
                        if (r3 != null) {
                            arrayList2.add(r3);
                        }
                        a(arrayList2);
                        f();
                        c0 p3 = p();
                        if (p3 != null) {
                            arrayList3.add(p3);
                        }
                        d0 q3 = q();
                        if (q3 != null) {
                            arrayList3.add(q3);
                        }
                        a(arrayList3);
                    }
                }
            } else {
                j();
                if (this.q.E1()) {
                    f();
                }
                l7.c v1 = this.q.v1();
                l7.c cVar = l7.c.COMPANION_AD;
                if (v1 == cVar) {
                    m();
                    n();
                    a(this.q);
                } else {
                    o();
                }
                if (!this.q.E1()) {
                    f();
                }
                if (this.q.v1() == cVar) {
                    o();
                } else {
                    m();
                    n();
                    a(this.q);
                }
            }
        } else if (((Boolean) this.f464a.a(v4.I0)).booleanValue()) {
            ArrayList arrayList4 = new ArrayList();
            if (!o0.e()) {
                arrayList4.addAll(e());
            }
            c0 p4 = p();
            if (p4 != null) {
                arrayList4.add(p4);
            }
            e0 r4 = r();
            if (r4 != null) {
                arrayList4.add(r4);
            }
            d0 q4 = q();
            if (q4 != null) {
                arrayList4.add(q4);
            }
            a(arrayList4);
            f();
        } else {
            j();
            m();
            o();
            n();
            a(this.q);
            f();
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finished caching VAST ad #" + this.q.getAdIdNumber());
        }
        this.q.F1();
        k();
    }

    @Override // com.applovin.impl.j5
    void a(int i) {
        this.q.getAdEventTracker().f();
        super.a(i);
    }
}
