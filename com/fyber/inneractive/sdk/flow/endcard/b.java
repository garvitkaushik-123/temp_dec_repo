package com.fyber.inneractive.sdk.flow.endcard;

import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.u0;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public abstract class b implements n {

    /* renamed from: a, reason: collision with root package name */
    public final String f1184a = IAlog.a(this);
    public JSONArray b = null;
    public final u0 c;
    public n d;
    public int e;
    public int f;

    public b(int i, u0 u0Var) {
        this.c = u0Var;
        this.f = i;
    }

    public abstract void a(ViewGroup viewGroup, com.fyber.inneractive.sdk.player.ui.b bVar);

    public void a(JSONArray jSONArray) {
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.n
    public final View b() {
        return f().b();
    }

    public abstract n c();

    public com.fyber.inneractive.sdk.player.ui.c d() {
        com.fyber.inneractive.sdk.config.global.features.u uVar = this.c.g;
        com.fyber.inneractive.sdk.player.ui.c cVar = new com.fyber.inneractive.sdk.player.ui.c();
        cVar.f1640a = l();
        cVar.f = i();
        boolean b = b(uVar);
        Integer valueOf = Integer.valueOf(a(uVar));
        if (b) {
            cVar.d = valueOf;
        }
        return cVar;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.n
    public void destroy() {
        e();
        n nVar = this.d;
        if (nVar != null) {
            nVar.destroy();
            this.d = null;
        }
    }

    public void e() {
        a();
    }

    public final n f() {
        if (this.d == null) {
            this.d = c();
        }
        return this.d;
    }

    public abstract com.fyber.inneractive.sdk.util.g g();

    public abstract l h();

    public abstract com.fyber.inneractive.sdk.model.vast.i i();

    public boolean j() {
        return false;
    }

    public boolean k() {
        return false;
    }

    public abstract boolean l();

    public void m() {
        IAlog.a("%s loading success for %s", i(), this.f1184a);
    }

    public static boolean b(com.fyber.inneractive.sdk.config.global.features.u uVar) {
        if (uVar != null) {
            Boolean c = uVar.c("shouldEnableEndCardAutoClick");
            if (c != null ? c.booleanValue() : false) {
                return true;
            }
        }
        return false;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.n
    public final void a() {
        n nVar = this.d;
        if (nVar != null) {
            nVar.a();
        }
    }

    public void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        IAlog.a("%s loading failed for %s", inneractiveInfrastructureError.getCause(), i(), this.f1184a);
    }

    public static int a(com.fyber.inneractive.sdk.config.global.features.u uVar) {
        if (uVar != null) {
            Integer a2 = uVar.a("autoClickDelay");
            int intValue = a2 != null ? a2.intValue() : 3;
            if (intValue >= 0 && intValue <= 10) {
                return intValue;
            }
        }
        return 3;
    }
}
