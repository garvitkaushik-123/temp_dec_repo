package com.fyber.inneractive.sdk.network;

import android.util.Log;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import com.google.common.net.HttpHeaders;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes4.dex */
public abstract class s0 {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f1337a;
    public final e0 b;
    public final h c;
    public o0 d;
    public l e;
    public volatile g1 f;
    public final String g;
    public final com.fyber.inneractive.sdk.config.global.r h;
    public long i;
    public long j;
    public int k;
    public boolean l;
    public boolean m;
    public final Object n;
    public boolean o;

    public s0(e0 e0Var, h hVar, com.fyber.inneractive.sdk.config.global.r rVar) {
        this.f1337a = false;
        this.f = g1.INITIAL;
        this.i = 0L;
        this.j = 0L;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = new Object();
        this.o = false;
        this.b = e0Var;
        this.c = hVar;
        this.g = UUID.randomUUID().toString();
        this.h = rVar;
    }

    public abstract n0 a(l lVar, Map map, int i);

    public void a(n0 n0Var, String str, String str2) {
    }

    public void b(long j) {
        synchronized (this.n) {
            if (this.m) {
                this.k = (int) ((j - this.i) + this.k);
                this.m = false;
            }
        }
    }

    public void c() {
        boolean z;
        synchronized (this.n) {
            z = this.l;
        }
        if (z) {
            a(System.currentTimeMillis());
        } else if (r()) {
            b(System.currentTimeMillis());
        }
    }

    public byte[] d() {
        return null;
    }

    public abstract int e();

    public String f() {
        return null;
    }

    public a g() {
        return null;
    }

    public int h() {
        return this.k;
    }

    public com.fyber.inneractive.sdk.config.global.r i() {
        return this.h;
    }

    public Map j() {
        return null;
    }

    public abstract l0 k();

    public String l() {
        return "application/json; charset=utf-8";
    }

    public abstract e1 m();

    public j1 n() {
        IAConfigManager iAConfigManager = IAConfigManager.O;
        return new j1(iAConfigManager.u.b.a("connect_timeout", 5000, 1), iAConfigManager.u.b.a("read_timeout", 5000, 1));
    }

    public int o() {
        int i;
        synchronized (this.n) {
            i = this.k;
        }
        return i;
    }

    public abstract String p();

    public int q() {
        Integer a2;
        com.fyber.inneractive.sdk.config.global.r rVar = this.h;
        if (rVar == null || (a2 = ((com.fyber.inneractive.sdk.config.global.features.k) rVar.a(com.fyber.inneractive.sdk.config.global.features.k.class)).a("watchdog_buffer_time_ms")) == null) {
            return 500;
        }
        return a2.intValue();
    }

    public final boolean r() {
        boolean z;
        synchronized (this.n) {
            z = this.m;
        }
        return z;
    }

    public abstract boolean s();

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean t() {
        boolean z;
        if (this.o) {
            com.fyber.inneractive.sdk.config.global.features.k kVar = (com.fyber.inneractive.sdk.config.global.features.k) IAConfigManager.O.M.a(com.fyber.inneractive.sdk.config.global.features.k.class);
            Boolean c = kVar.c("should_add_request_watchdog");
            if (!(c != null ? c.booleanValue() : false)) {
                Boolean c2 = kVar.c("should_report_request_watchdog");
                if (!(c2 != null ? c2.booleanValue() : false)) {
                    z = false;
                    if (!z) {
                        return true;
                    }
                }
            }
            z = true;
            if (!z) {
            }
        }
        return false;
    }

    public l a(String str) {
        try {
            o0 o0Var = this.d;
            if (o0Var != null) {
                o0Var.a("sdkInitNetworkRequest");
            }
            this.e = this.c.a(this, com.fyber.inneractive.sdk.util.o.h(), str);
            o0 o0Var2 = this.d;
            if (o0Var2 != null) {
                o0Var2.a("sdkGotServerResponse");
            }
            return this.e;
        } catch (b e) {
            IAlog.a("failed start network request", e, new Object[0]);
            throw e;
        } catch (o1 e2) {
            IAlog.a("failed read network response", e2, new Object[0]);
            throw e2;
        } catch (Exception e3) {
            IAlog.a("failed start network request", e3, new Object[0]);
            throw e3;
        }
    }

    public void d(long j) {
        synchronized (this.n) {
            if (!this.m) {
                this.m = true;
                this.i = j;
            }
        }
    }

    public void c(long j) {
        synchronized (this.n) {
            if (!this.l) {
                this.l = true;
                this.j = j;
            }
        }
    }

    public final void a(Object obj, Exception exc, boolean z) {
        o0 o0Var;
        if (!z) {
            g1 g1Var = g1.RESOLVED;
            this.f = g1Var;
            if (g1Var == g1.QUEUED_FOR_RETRY && (o0Var = this.d) != null) {
                o0Var.a("sdkRequestEndedButWillBeRetried");
            }
        }
        com.fyber.inneractive.sdk.util.r.b.post(new r0(this, obj, exc, z));
    }

    public final com.fyber.inneractive.sdk.response.e a(int i, o oVar, com.fyber.inneractive.sdk.response.j jVar, com.fyber.inneractive.sdk.dv.j jVar2) {
        try {
            com.fyber.inneractive.sdk.response.a a2 = com.fyber.inneractive.sdk.response.a.a(i);
            if (a2 == null) {
                a2 = com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MRAID;
            }
            com.fyber.inneractive.sdk.factories.f fVar = com.fyber.inneractive.sdk.factories.d.f1171a;
            com.fyber.inneractive.sdk.factories.e eVar = (com.fyber.inneractive.sdk.factories.e) fVar.f1172a.get(a2);
            com.fyber.inneractive.sdk.response.b b = eVar != null ? eVar.b() : null;
            if (b == null) {
                IAlog.f("Received ad type %s does not have an appropriate parser!", Integer.valueOf(i));
                if (fVar.f1172a.size() == 0) {
                    Log.e("Inneractive_error", "Critical error raised while fetching an ad - please make sure you have added all the required fyber libraries (ia-mraid-kit, ia-video-kit) to your project");
                }
                throw new m0("Could not find parser for ad type " + i);
            }
            IAlog.a("Received ad type %s - Got parser! %s", Integer.valueOf(i), b);
            if (jVar != null) {
                b.c = jVar;
            }
            b.f1726a = b.a();
            if (oVar != null) {
                b.c = new com.fyber.inneractive.sdk.response.k(oVar);
            }
            com.fyber.inneractive.sdk.response.e a3 = b.a(null);
            a3.K = h();
            if (jVar2 != null) {
                a3.u = jVar2;
            }
            o0 o0Var = this.d;
            if (o0Var != null) {
                o0Var.a("sdkParsedResponse");
            }
            return a3;
        } catch (Exception e) {
            IAlog.a("failed parse ad network request", e, new Object[0]);
            throw new m0(e);
        }
    }

    public s0(s0 s0Var) {
        this.f1337a = false;
        this.f = g1.INITIAL;
        this.i = 0L;
        this.j = 0L;
        this.k = 0;
        this.l = false;
        this.m = false;
        this.n = new Object();
        this.o = false;
        this.b = s0Var.b;
        this.c = s0Var.c;
        this.g = UUID.randomUUID().toString();
        this.h = s0Var.h;
        this.k = s0Var.k;
        this.i = s0Var.i;
        this.j = s0Var.j;
    }

    public static int a(Map map) {
        List list = map != null ? (List) map.get(HttpHeaders.CONTENT_LENGTH) : null;
        if (list != null) {
            return com.fyber.inneractive.sdk.util.t.a((String) list.get(0), -1);
        }
        return -1;
    }

    public void a(long j) {
        synchronized (this.n) {
            if (this.l) {
                this.k = (int) ((j - this.j) + this.k);
                this.l = false;
            }
        }
    }
}
