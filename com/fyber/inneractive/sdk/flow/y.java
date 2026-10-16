package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.e1;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class y implements com.fyber.inneractive.sdk.click.o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e1 f1250a;
    public final /* synthetic */ com.fyber.inneractive.sdk.util.g b;
    public final /* synthetic */ a0 c;

    public y(a0 a0Var, e1 e1Var, com.fyber.inneractive.sdk.util.g gVar) {
        this.c = a0Var;
        this.f1250a = e1Var;
        this.b = gVar;
    }

    @Override // com.fyber.inneractive.sdk.click.o
    public final void a(com.fyber.inneractive.sdk.click.b bVar) {
        a0 a0Var = this.c;
        a0Var.getClass();
        IAlog.a("%s super click result: %s", IAlog.a(a0Var), bVar);
        a0 a0Var2 = this.c;
        if (a0Var2.h == null) {
            IAlog.a("%s click handler is null. Probably cancelled", IAlog.a(a0Var2));
            return;
        }
        a0Var2.h = null;
        a0Var2.i = null;
        a0Var2.E();
        a0 a0Var3 = this.c;
        e1 e1Var = this.f1250a;
        com.fyber.inneractive.sdk.util.g gVar = this.b;
        a0Var3.getClass();
        com.fyber.inneractive.sdk.click.q qVar = bVar.f1056a;
        if (qVar == com.fyber.inneractive.sdk.click.q.OPEN_IN_EXTERNAL_APPLICATION || qVar == com.fyber.inneractive.sdk.click.q.OPEN_GOOGLE_STORE) {
            IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in external application", new Object[0]);
            ArrayList arrayList = bVar.f;
            com.fyber.inneractive.sdk.click.j jVar = (com.fyber.inneractive.sdk.click.j) arrayList.get(arrayList.size() - 1);
            com.fyber.inneractive.sdk.click.q qVar2 = jVar.c;
            if (qVar2 == com.fyber.inneractive.sdk.click.q.OPENED_IN_EXTERNAL_BROWSER) {
                a0Var3.a(jVar.f1063a, qVar2);
            }
            if (a0Var3.c != null) {
                a0Var3.D();
            }
        } else if (qVar == com.fyber.inneractive.sdk.click.q.OPENED_IN_INTERNAL_BROWSER) {
            IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in internal browser", new Object[0]);
            a0Var3.d = true;
            InneractiveInternalBrowserActivity.setInternalBrowserListener(a0Var3);
        } else if (qVar == com.fyber.inneractive.sdk.click.q.OPENED_USING_CHROME_NAVIGATE || qVar == com.fyber.inneractive.sdk.click.q.OPENED_IN_EXTERNAL_BROWSER) {
            IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in external browser", new Object[0]);
            a0Var3.a(bVar.d, bVar.f1056a);
            if (a0Var3.c != null) {
                a0Var3.D();
            }
        }
        if (a0Var3.o() == com.fyber.inneractive.sdk.ignite.m.NONE || !(TextUtils.isEmpty(bVar.c) || bVar.c.equals("IgniteGooglePlay"))) {
            a0Var3.b(bVar, e1Var, gVar);
        }
    }
}
