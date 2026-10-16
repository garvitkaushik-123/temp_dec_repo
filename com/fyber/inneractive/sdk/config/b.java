package com.fyber.inneractive.sdk.config;

import android.os.Handler;
import android.os.Message;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r1;
import com.fyber.inneractive.sdk.util.t1;

/* loaded from: classes4.dex */
public final class b implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f1070a;

    public b(e eVar) {
        this.f1070a = eVar;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what != 123) {
            return false;
        }
        e eVar = this.f1070a;
        if (eVar.f1080a.compareAndSet(false, true)) {
            if (eVar.f1080a.get() && eVar.c != null) {
                IAlog.a("startCounting", new Object[0]);
                t1 t1Var = eVar.c;
                t1Var.getClass();
                r1 r1Var = new r1(t1Var);
                t1Var.c = r1Var;
                t1Var.d = false;
                r1Var.sendEmptyMessage(1932593528);
            }
            IAlog.a("Pause signal", new Object[0]);
        }
        return true;
    }
}
