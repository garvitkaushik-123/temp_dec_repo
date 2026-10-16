package com.fyber.inneractive.sdk.network;

import android.app.Application;
import android.os.HandlerThread;
import java.util.concurrent.LinkedBlockingQueue;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class f implements com.fyber.inneractive.sdk.util.c1 {
    public com.fyber.inneractive.sdk.util.b1 d;
    public int e;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedBlockingQueue f1318a = new LinkedBlockingQueue();
    public JSONArray b = new JSONArray();
    public boolean f = false;
    public boolean g = false;
    public final HandlerThread c = new HandlerThread("EventCollectorHandlerThread", 0);

    public final void a(Application application) {
        if (!this.g) {
            this.g = true;
            this.c.start();
            com.fyber.inneractive.sdk.util.b1 b1Var = new com.fyber.inneractive.sdk.util.b1(this.c.getLooper(), this);
            this.d = b1Var;
            this.f = true;
            this.e = 30;
            if (b1Var.hasMessages(12312329)) {
                this.d.removeMessages(12312329);
            }
            long j = this.e * 1000;
            com.fyber.inneractive.sdk.util.b1 b1Var2 = this.d;
            if (b1Var2 != null) {
                b1Var2.post(new c(this, 12312329, j));
            }
        }
        application.registerActivityLifecycleCallbacks(new d(this));
    }
}
