package com.fyber.inneractive.sdk.flow;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r1;
import com.fyber.inneractive.sdk.util.t1;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class n0 extends a0 implements com.fyber.inneractive.sdk.interfaces.f {
    public com.fyber.inneractive.sdk.interfaces.e k;
    public Runnable l;
    public t1 m;
    public Runnable n;
    public t1 o;
    public long r;
    public k0 v;
    public boolean p = false;
    public boolean q = false;
    public boolean s = false;
    public boolean t = false;
    public final com.fyber.inneractive.sdk.util.a u = new com.fyber.inneractive.sdk.util.a();

    public abstract boolean G();

    public final void H() {
        if (this.l == null) {
            long K = K();
            this.r = K;
            this.l = new j0(this, K);
            IAlog.a("%senabling close with delay %d", IAlog.a(this), Long.valueOf(this.r));
            x xVar = this.b;
            boolean b = xVar != null ? b(xVar) : false;
            if (b && !G()) {
                if (b) {
                    com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
                    if (eVar != null) {
                        eVar.showCloseCountdown();
                    }
                    k0 k0Var = new k0(this, this.r + 100);
                    this.v = k0Var;
                    k0Var.start();
                    return;
                }
                return;
            }
            if (this.q) {
                return;
            }
            this.q = true;
            t1 t1Var = new t1(TimeUnit.MILLISECONDS, this.r);
            this.m = t1Var;
            t1Var.e = new l0(this);
            r1 r1Var = new r1(t1Var);
            t1Var.c = r1Var;
            t1Var.d = false;
            r1Var.sendEmptyMessage(1932593528);
        }
    }

    public abstract int I();

    public abstract int J();

    public abstract long K();

    public abstract boolean L();

    public abstract long a(long j);

    public void a(com.fyber.inneractive.sdk.interfaces.e eVar, Activity activity) {
        if (this.f1175a == null) {
            IAlog.f("%sYou must set the spot to render before calling renderAd", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("No spot ad to render");
        }
        if (eVar != null) {
            this.k = eVar;
        } else {
            IAlog.f("%srenderAd called with a null activity!", IAlog.a(this));
            throw new InneractiveUnitController.AdDisplayError("Activity is null");
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public void b(boolean z) {
    }

    public abstract boolean b(x xVar);

    public final void c(boolean z) {
        com.fyber.inneractive.sdk.network.w wVar;
        if (this.b == null) {
            com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.MRAID_CUSTOM_CLOSE_DETECTED;
            wVar = new com.fyber.inneractive.sdk.network.w((com.fyber.inneractive.sdk.response.e) null);
            wVar.c = uVar;
            wVar.f1340a = null;
            wVar.d = null;
        } else {
            com.fyber.inneractive.sdk.network.u uVar2 = com.fyber.inneractive.sdk.network.u.MRAID_CUSTOM_CLOSE_DETECTED;
            x xVar = this.b;
            InneractiveAdRequest inneractiveAdRequest = xVar.f1249a;
            com.fyber.inneractive.sdk.response.e c = xVar.c();
            JSONArray b = this.b.c.b();
            wVar = new com.fyber.inneractive.sdk.network.w(c);
            wVar.c = uVar2;
            wVar.f1340a = inneractiveAdRequest;
            wVar.d = b;
        }
        JSONObject jSONObject = new JSONObject();
        Boolean valueOf = Boolean.valueOf(z);
        try {
            jSONObject.put("fyber_close_enabled", valueOf);
        } catch (Exception unused) {
            IAlog.f("Got exception adding param to json object: %s, %s", "fyber_close_enabled", valueOf);
        }
        wVar.f.put(jSONObject);
        wVar.a((String) null);
    }

    public final void d(boolean z) {
        com.fyber.inneractive.sdk.network.w wVar;
        this.p = true;
        if (z) {
            if (this.b == null) {
                com.fyber.inneractive.sdk.network.u uVar = com.fyber.inneractive.sdk.network.u.FAIL_SAFE_ACTIVATED;
                wVar = new com.fyber.inneractive.sdk.network.w((com.fyber.inneractive.sdk.response.e) null);
                wVar.c = uVar;
                wVar.f1340a = null;
                wVar.d = null;
            } else {
                com.fyber.inneractive.sdk.network.u uVar2 = com.fyber.inneractive.sdk.network.u.FAIL_SAFE_ACTIVATED;
                x xVar = this.b;
                InneractiveAdRequest inneractiveAdRequest = xVar.f1249a;
                com.fyber.inneractive.sdk.response.e c = xVar.c();
                JSONArray b = this.b.c.b();
                wVar = new com.fyber.inneractive.sdk.network.w(c);
                wVar.c = uVar2;
                wVar.f1340a = inneractiveAdRequest;
                wVar.d = b;
            }
            JSONObject jSONObject = new JSONObject();
            Boolean valueOf = Boolean.valueOf(L());
            try {
                jSONObject.put("is_endcard", valueOf);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", "is_endcard", valueOf);
            }
            wVar.f.put(jSONObject);
            wVar.a((String) null);
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar != null) {
            eVar.showCloseButton(z, J(), I());
            if (z) {
                return;
            }
            com.fyber.inneractive.sdk.util.a aVar = this.u;
            aVar.d = 0L;
            aVar.e = 0L;
            aVar.f = 0L;
            aVar.b = false;
            aVar.a(false);
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.a0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public void destroy() {
        Runnable runnable = this.l;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable);
            this.l = null;
        }
        Runnable runnable2 = this.n;
        if (runnable2 != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(runnable2);
            this.n = null;
        }
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar != null) {
            eVar.destroy();
        }
        this.k = null;
        k0 k0Var = this.v;
        if (k0Var != null) {
            k0Var.cancel();
            this.v = null;
        }
        t1 t1Var = this.o;
        if (t1Var != null) {
            t1Var.e = null;
            this.o = null;
        }
        t1 t1Var2 = this.m;
        if (t1Var2 != null) {
            t1Var2.e = null;
            this.m = null;
        }
        super.destroy();
    }

    @Override // com.fyber.inneractive.sdk.flow.a0, com.fyber.inneractive.sdk.external.InneractiveAdRenderer
    public final void initialize(InneractiveAdSpot inneractiveAdSpot) {
        super.initialize(inneractiveAdSpot);
        this.u.f1750a = inneractiveAdSpot;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public void m() {
        t1 t1Var = this.m;
        if (t1Var != null) {
            t1Var.d = false;
            t1Var.a(SystemClock.uptimeMillis());
        }
        t1 t1Var2 = this.o;
        if (t1Var2 != null) {
            t1Var2.d = false;
            t1Var2.a(SystemClock.uptimeMillis());
        }
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public void r() {
        t1 t1Var = this.m;
        if (t1Var != null) {
            t1Var.d = true;
            r1 r1Var = t1Var.c;
            if (r1Var != null) {
                r1Var.removeMessages(1932593528);
            }
        }
        t1 t1Var2 = this.o;
        if (t1Var2 != null) {
            t1Var2.d = true;
            r1 r1Var2 = t1Var2.c;
            if (r1Var2 != null) {
                r1Var2.removeMessages(1932593528);
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final View x() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar != null) {
            return eVar.getLayout();
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final int y() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar == null || eVar.getLayout() == null) {
            return 1;
        }
        return this.k.getLayout().getHeight();
    }

    @Override // com.fyber.inneractive.sdk.flow.a0
    public final int z() {
        com.fyber.inneractive.sdk.interfaces.e eVar = this.k;
        if (eVar == null || eVar.getLayout() == null) {
            return 1;
        }
        return this.k.getLayout().getWidth();
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public boolean b(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        IAlog.f("InneractiveFullscreenAdRendererImpl : registerObserver: %s doesnt support Store Promo", getClass().getName());
        return false;
    }

    @Override // com.fyber.inneractive.sdk.interfaces.f
    public void a(com.fyber.inneractive.sdk.flow.storepromo.observer.a aVar) {
        IAlog.f("InneractiveFullscreenAdRendererImpl : unregisterObserver: %s doesnt support Store Promo", getClass().getName());
    }
}
