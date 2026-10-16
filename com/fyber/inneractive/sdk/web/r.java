package com.fyber.inneractive.sdk.web;

import android.content.Context;
import android.content.IntentFilter;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f1817a;

    public r(i0 i0Var) {
        this.f1817a = i0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i0 i0Var = this.f1817a;
        if (i0Var.V == null) {
            try {
                i0Var.getClass();
                IAlog.a("%sregistering orientation broadcast receiver", IAlog.a(i0Var));
                this.f1817a.V = new e0(this.f1817a);
                if (com.fyber.inneractive.sdk.util.o.a(this.f1817a.b) != null) {
                    i0 i0Var2 = this.f1817a;
                    e0 e0Var = i0Var2.V;
                    Context a2 = com.fyber.inneractive.sdk.util.o.a(i0Var2.b);
                    i0 i0Var3 = e0Var.c;
                    i0Var3.getClass();
                    IAlog.a("%sregister screen broadcast receiver", IAlog.a(i0Var3));
                    e0Var.f1797a = a2;
                    a2.registerReceiver(e0Var, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
                }
            } catch (Exception e) {
                i0 i0Var4 = this.f1817a;
                i0Var4.getClass();
                IAlog.f("%sfailed registering orientation broadcast recevier", IAlog.a(i0Var4));
                if (IAlog.f1749a >= 3) {
                    e.printStackTrace();
                }
            }
        }
    }
}
