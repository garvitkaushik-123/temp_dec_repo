package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.bidder.adm.AdmParametersOuterClass$AdmParameters;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes4.dex */
public final class d1 extends s0 {
    public final String p;
    public final com.fyber.inneractive.sdk.bidder.adm.y q;
    public int r;
    public final com.fyber.inneractive.sdk.response.e s;
    public final com.fyber.inneractive.sdk.config.global.r t;
    public final com.fyber.inneractive.sdk.network.timeouts.request.a u;

    public d1(com.fyber.inneractive.sdk.bidder.adm.v vVar, String str, com.fyber.inneractive.sdk.bidder.adm.y yVar, com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.response.e eVar) {
        super(vVar, f0.c.a(), rVar);
        UnitDisplayType unitDisplayType;
        this.r = 0;
        this.o = true;
        this.p = str;
        this.q = yVar;
        this.s = eVar;
        this.t = rVar;
        UnitDisplayType unitDisplayType2 = UnitDisplayType.BANNER;
        String name = unitDisplayType2.name();
        Locale locale = Locale.US;
        String lowerCase = name.toLowerCase(locale);
        if (eVar == null || (unitDisplayType = eVar.p) == null) {
            AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = yVar.f1029a;
            if (admParametersOuterClass$AdmParameters != null) {
                lowerCase = com.fyber.inneractive.sdk.util.l1.a(String.valueOf(admParametersOuterClass$AdmParameters.getSpotId()));
            }
        } else {
            lowerCase = (unitDisplayType == UnitDisplayType.INTERSTITIAL || unitDisplayType == UnitDisplayType.REWARDED) ? unitDisplayType.name().toLowerCase(locale) : unitDisplayType2.name().toLowerCase(locale);
        }
        String str2 = IAConfigManager.O.l;
        com.fyber.inneractive.sdk.config.global.features.j jVar = (com.fyber.inneractive.sdk.config.global.features.j) rVar.a(com.fyber.inneractive.sdk.config.global.features.j.class);
        this.u = TextUtils.isEmpty(str2) ? new com.fyber.inneractive.sdk.network.timeouts.request.b(jVar, lowerCase) : new com.fyber.inneractive.sdk.network.timeouts.request.c(lowerCase, jVar, str2);
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final n0 a(l lVar, Map map, int i) {
        n0 n0Var = new n0();
        try {
            InputStream inputStream = lVar.c;
            if (inputStream != null) {
                d(System.currentTimeMillis());
                StringBuffer a2 = com.fyber.inneractive.sdk.util.t.a(inputStream);
                b(System.currentTimeMillis());
                String stringBuffer = a2.toString();
                AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.q.f1029a;
                int a3 = admParametersOuterClass$AdmParameters != null ? admParametersOuterClass$AdmParameters.getAdType().a() : com.fyber.inneractive.sdk.bidder.adm.c.OTHER.a();
                com.fyber.inneractive.sdk.bidder.adm.y yVar = this.q;
                yVar.c = stringBuffer;
                com.fyber.inneractive.sdk.response.e a4 = a(a3, null, yVar, null);
                a4.h = stringBuffer;
                n0Var.f1331a = a4;
            }
            return n0Var;
        } catch (b e) {
            e = e;
            IAlog.a("failed parse adm network request but will re-try", e, new Object[0]);
            b(System.currentTimeMillis());
            throw new r1(e);
        } catch (SocketTimeoutException e2) {
            e = e2;
            IAlog.a("failed parse adm network request but will re-try", e, new Object[0]);
            b(System.currentTimeMillis());
            throw new r1(e);
        } catch (UnknownHostException e3) {
            e = e3;
            IAlog.a("failed parse adm network request but will re-try", e, new Object[0]);
            b(System.currentTimeMillis());
            throw new r1(e);
        } catch (Exception e4) {
            b(System.currentTimeMillis());
            IAlog.a("failed parse adm network request", e4, new Object[0]);
            throw new m0(e4);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final void b(long j) {
        super.b(j);
        IAlog.a("%s : NetworkRequestMarkup : set end read timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(super.o()));
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final void c() {
        super.c();
        IAlog.a("%s : NetworkRequestMarkup cancel by timeout at retry: %d", IAlog.a(this), Integer.valueOf(this.r));
        k0 k0Var = IAConfigManager.O.s;
        this.f1337a = true;
        d1 d1Var = new d1(this);
        if ((k0Var instanceof k0) && k0Var.d(d1Var)) {
            return;
        }
        IAlog.a("%s : NetworkRequestMarkup won't retry - resolve request with `Bidding ad request passed allowed time` at retry: %d", IAlog.a(this), Integer.valueOf(this.r));
        a((Object) null, new Exception("Bidding ad request passed allowed time"), false);
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final void d(long j) {
        super.d(j);
        IAlog.a("%s : NetworkRequestMarkup : set start read timestamp", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int e() {
        return this.u.c();
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int h() {
        int o = super.o();
        com.fyber.inneractive.sdk.network.timeouts.request.a aVar = this.u;
        return ((aVar.c() + aVar.f) * this.r) + o;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final com.fyber.inneractive.sdk.config.global.r i() {
        return this.t;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final l0 k() {
        return l0.GET;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final e1 m() {
        return e1.HIGH;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final j1 n() {
        com.fyber.inneractive.sdk.network.timeouts.request.a aVar = this.u;
        return new j1(aVar.i, aVar.h);
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int o() {
        throw null;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final String p() {
        return this.p;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int q() {
        return this.u.f;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final boolean s() {
        if (this.f1337a) {
            return false;
        }
        int i = this.r + 1;
        this.r = i;
        if (i > this.u.b()) {
            IAlog.a("%s : NetworkRequestMarkup Should enable retry - FALSE, current retry: %d total retries: %d, request id: %s", IAlog.a(this), Integer.valueOf(this.r - 1), Integer.valueOf(this.u.b()), this.g);
            return false;
        }
        IAlog.a("%s : NetworkRequestMarkup Should enable retry - TRUE, current retry: %d total retries: %d, request id: %s", IAlog.a(this), Integer.valueOf(this.r - 1), Integer.valueOf(this.u.b()), this.g);
        this.u.a(this.r);
        return true;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final void c(long j) {
        super.c(j);
        IAlog.a("%s : NetworkRequestMarkup : set start connection timestamp", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final l a(String str) {
        IAlog.a("%s : NetworkRequestMarkup Ad request execution started, retry number: %d, timeouts(connection: %d read: %d)", IAlog.a(this), Integer.valueOf(this.r), Integer.valueOf(n().f1325a), Integer.valueOf(n().b));
        return super.a(str);
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final void a(long j) {
        super.a(j);
        IAlog.a("%s : NetworkRequestMarkup : set end connection timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(super.o()));
    }

    public d1(d1 d1Var) {
        super(d1Var);
        this.r = 0;
        this.o = true;
        this.p = d1Var.p;
        this.q = d1Var.q;
        this.s = d1Var.s;
        this.t = d1Var.t;
        this.u = d1Var.u;
        this.r = d1Var.r;
    }
}
