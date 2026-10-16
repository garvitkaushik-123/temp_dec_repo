package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f1820a;

    public s(i0 i0Var) {
        this.f1820a = i0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            i0 i0Var = this.f1820a;
            if (i0Var.V != null) {
                i0Var.getClass();
                IAlog.a("%sunregistering orientation broadcast receiver", IAlog.a(i0Var));
                this.f1820a.V.a();
            }
        } catch (IllegalArgumentException e) {
            if (e.getMessage() != null && !e.getMessage().contains("Receiver not registered")) {
                throw e;
            }
        }
        this.f1820a.V = null;
    }
}
