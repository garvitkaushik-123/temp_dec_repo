package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1794a;

    public d(i1 i1Var) {
        this.f1794a = i1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i iVar = this.f1794a;
        if (iVar.k) {
            IAlog.a("No user web action detected for : %s blocking.", iVar.l);
            i iVar2 = this.f1794a;
            String c = iVar2.l.c();
            String a2 = this.f1794a.l.a();
            j1 j1Var = iVar2.g;
            if (j1Var != null) {
                j1Var.a(c, a2);
            }
            IAlog.d("AD_AUTO_CLICK_DETECTED", new Object[0]);
            this.f1794a.l.b();
            this.f1794a.i();
        } else {
            IAlog.a("User web action detected for: %s", iVar.l);
            this.f1794a.l.d();
        }
        this.f1794a.l = null;
    }
}
