package com.mbridge.msdk.foundation.same.net.wrapper;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.tracker.network.b0;
import com.mbridge.msdk.tracker.network.j;
import com.mbridge.msdk.tracker.network.q;
import com.mbridge.msdk.tracker.network.v;

/* compiled from: MBridgeRequestListenerWrapper.java */
/* loaded from: classes6.dex */
public class i<T> implements j<T> {

    /* renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.foundation.same.net.b<T> f4306a;
    private final Handler b = new Handler(Looper.getMainLooper());

    /* compiled from: MBridgeRequestListenerWrapper.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f4307a;
        final /* synthetic */ q b;

        a(v vVar, q qVar) {
            this.f4307a = vVar;
            this.b = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (i.this.f4306a != null) {
                    i.this.f4306a.onSuccess(i.this.a(this.f4307a, this.b));
                }
            } catch (Exception e) {
                p0.b("MBridgeRequestListenerWrapper", "onResponseSuccess error", e);
            }
        }
    }

    /* compiled from: MBridgeRequestListenerWrapper.java */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ v f4308a;
        final /* synthetic */ q b;

        b(v vVar, q qVar) {
            this.f4308a = vVar;
            this.b = qVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (i.this.f4306a != null) {
                    i.this.f4306a.onError(i.this.a(this.f4308a.c, this.b));
                }
            } catch (Exception e) {
                p0.b("MBridgeRequestListenerWrapper", "onResponseError error", e);
            }
        }
    }

    public i(com.mbridge.msdk.foundation.same.net.b<T> bVar) {
        this.f4306a = bVar;
    }

    @Override // com.mbridge.msdk.tracker.network.j
    public void b(com.mbridge.msdk.tracker.network.h<T> hVar, v<T> vVar, q qVar) {
        p0.a("MBridgeRequestListenerWrapper", "onResponseError: " + vVar.c.a() + " " + vVar.c.getMessage());
        this.b.post(new b(vVar, qVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.net.e a(v<T> vVar, q qVar) {
        if (vVar == null) {
            return null;
        }
        return com.mbridge.msdk.foundation.same.net.e.a(vVar.f4963a, new com.mbridge.msdk.foundation.same.net.toolbox.a(qVar.f4947a, qVar.b, qVar.d));
    }

    @Override // com.mbridge.msdk.tracker.network.j
    public void a(com.mbridge.msdk.tracker.network.h<T> hVar, v<T> vVar, q qVar) {
        p0.a("MBridgeRequestListenerWrapper", "onResponseSuccess: " + vVar.f4963a);
        this.b.post(new a(vVar, qVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.net.exception.a a(b0 b0Var, q qVar) {
        com.mbridge.msdk.foundation.same.net.toolbox.a aVar;
        if (b0Var == null) {
            return null;
        }
        if (qVar != null) {
            aVar = new com.mbridge.msdk.foundation.same.net.toolbox.a(qVar.f4947a, qVar.b, qVar.d);
        } else {
            aVar = new com.mbridge.msdk.foundation.same.net.toolbox.a(0, null, null);
        }
        if (b0Var.a() == 0) {
            return new com.mbridge.msdk.foundation.same.net.exception.a(2, aVar, b0Var.getMessage());
        }
        if (b0Var.a() == 1) {
            return new com.mbridge.msdk.foundation.same.net.exception.a(6, aVar, b0Var.getMessage());
        }
        if (b0Var.a() == 2) {
            return new com.mbridge.msdk.foundation.same.net.exception.a(8, aVar, b0Var.getMessage());
        }
        if (b0Var.a() == 4) {
            return new com.mbridge.msdk.foundation.same.net.exception.a(880041, aVar, b0Var.getMessage());
        }
        if (b0Var.a() == 5) {
            return new com.mbridge.msdk.foundation.same.net.exception.a(8, aVar, b0Var.getMessage());
        }
        if (b0Var.a() == 6) {
            return new com.mbridge.msdk.foundation.same.net.exception.a(15, aVar, b0Var.getMessage());
        }
        if (b0Var.a() == 7) {
            return new com.mbridge.msdk.foundation.same.net.exception.a(7, aVar, b0Var.getMessage());
        }
        if (b0Var.a() == 8) {
            return new com.mbridge.msdk.foundation.same.net.exception.a(10, aVar, b0Var.getMessage());
        }
        if (b0Var.a() == 9) {
            return new com.mbridge.msdk.foundation.same.net.exception.a(4, aVar, b0Var.getMessage());
        }
        return new com.mbridge.msdk.foundation.same.net.exception.a(2, aVar, b0Var.getMessage());
    }
}
