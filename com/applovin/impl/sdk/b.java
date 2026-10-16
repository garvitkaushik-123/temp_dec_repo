package com.applovin.impl.sdk;

import com.applovin.impl.d7;
import com.applovin.impl.s1;
import com.applovin.impl.sdk.a;
import com.applovin.impl.v4;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final k f680a;
    private final WeakReference b;
    private final WeakReference c;
    private d7 d;

    private b(s1 s1Var, a.InterfaceC0101a interfaceC0101a, k kVar) {
        this.b = new WeakReference(s1Var);
        this.c = new WeakReference(interfaceC0101a);
        this.f680a = kVar;
    }

    public static b a(s1 s1Var, a.InterfaceC0101a interfaceC0101a, k kVar) {
        b bVar = new b(s1Var, interfaceC0101a, kVar);
        bVar.a(s1Var.getTimeToLiveMillis());
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        d();
        this.f680a.f().a(this);
    }

    public s1 b() {
        return (s1) this.b.get();
    }

    public void d() {
        a();
        s1 b = b();
        if (b == null) {
            return;
        }
        b.setExpired();
        a.InterfaceC0101a interfaceC0101a = (a.InterfaceC0101a) this.c.get();
        if (interfaceC0101a == null) {
            return;
        }
        interfaceC0101a.onAdExpired(b);
    }

    public void a(long j) {
        a();
        if (((Boolean) this.f680a.a(v4.a1)).booleanValue() || !this.f680a.n0().isApplicationPaused()) {
            this.d = d7.a(j, this.f680a, new Runnable() { // from class: com.applovin.impl.sdk.b$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.c();
                }
            });
        }
    }

    public void a() {
        d7 d7Var = this.d;
        if (d7Var != null) {
            d7Var.a();
            this.d = null;
        }
    }
}
