package com.fyber.inneractive.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public final class r1 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f1779a;

    public r1(t1 t1Var) {
        super(Looper.getMainLooper());
        this.f1779a = new WeakReference(t1Var);
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        super.handleMessage(message);
        t1 t1Var = (t1) this.f1779a.get();
        if (t1Var == null || message.what != 1932593528 || t1Var.d) {
            return;
        }
        t1Var.a(message.getWhen());
    }
}
