package com.fyber.inneractive.sdk.network;

import android.os.Process;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class h0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f1321a;

    public h0(k0 k0Var) {
        this.f1321a = k0Var;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:11|12|(1:16)|17|(2:19|(1:21)(1:72))|73|(9:(15:75|24|(1:26)|27|28|(9:32|(1:38)|39|40|41|42|44|45|46)|66|(3:34|36|38)|39|40|41|42|44|45|46)|(10:30|32|(0)|39|40|41|42|44|45|46)|39|40|41|42|44|45|46)|23|24|(0)|27|28|66|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
    
        if ((r3 != null ? r3.booleanValue() : true) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00c5, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00c6, code lost:
    
        com.fyber.inneractive.sdk.util.IAlog.a("failed fetching cache data", r3, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00cf, code lost:
    
        if (r2.f1337a == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00d1, code lost:
    
        r2.a((java.lang.Object) null, r3, true);
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d7  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        s0 s0Var;
        boolean z;
        a aVar;
        n0 n0Var;
        Throwable th;
        o0 o0Var;
        k0 k0Var = this.f1321a;
        k0Var.getClass();
        Process.setThreadPriority(10);
        while (k0Var.b) {
            n0 n0Var2 = null;
            try {
                s0Var = (s0) k0Var.f1326a.take();
            } catch (InterruptedException unused) {
                if (!k0Var.b) {
                    Thread.currentThread().interrupt();
                }
                s0Var = null;
            }
            if (s0Var != null && !s0Var.f1337a) {
                g1 g1Var = g1.RUNNING;
                s0Var.f = g1Var;
                if (g1Var == g1.QUEUED_FOR_RETRY && (o0Var = s0Var.d) != null) {
                    o0Var.a("sdkRequestEndedButWillBeRetried");
                }
                if (s0Var.o) {
                    Boolean c = ((com.fyber.inneractive.sdk.config.global.features.k) IAConfigManager.O.M.a(com.fyber.inneractive.sdk.config.global.features.k.class)).c("should_manage_request_watchdog");
                }
                try {
                    try {
                        try {
                            if (!s0Var.t()) {
                                z = false;
                                IAlog.a("%s : NetworkExecutorImpl : should enabled watchdog : %s", IAlog.a(k0Var), Boolean.valueOf(z));
                                if (z) {
                                    h1 h1Var = k0Var.f;
                                    Thread currentThread = Thread.currentThread();
                                    h1Var.getClass();
                                    IAlog.a("%s : NetworkRequestWatchdog : register request: %s", IAlog.a(h1Var), s0Var.g);
                                    int q = s0Var.q();
                                    j1 n = s0Var.n();
                                    l1 l1Var = new l1(s0Var, currentThread, n.f1325a + n.b + q);
                                    h1Var.f1322a.putIfAbsent(s0Var.g, l1Var);
                                    com.fyber.inneractive.sdk.util.r.b.postDelayed(l1Var.d, l1Var.c);
                                }
                                if (!s0Var.f1337a && s0Var.f() != null) {
                                    aVar = s0Var.g();
                                    if (aVar != null && aVar.b != null && !s0Var.f1337a) {
                                        s0Var.a(aVar.b, (Exception) null, true);
                                    }
                                    l a2 = k0Var.a(s0Var, aVar);
                                    n0Var = k0Var.a(s0Var, a2);
                                    k0.a(s0Var, a2, n0Var);
                                    k0.a(s0Var, n0Var);
                                    k0.a(s0Var);
                                    k0Var.c(s0Var);
                                }
                                aVar = null;
                                if (aVar != null) {
                                    s0Var.a(aVar.b, (Exception) null, true);
                                }
                                l a22 = k0Var.a(s0Var, aVar);
                                n0Var = k0Var.a(s0Var, a22);
                                k0.a(s0Var, a22, n0Var);
                                k0.a(s0Var, n0Var);
                                k0.a(s0Var);
                                k0Var.c(s0Var);
                            }
                            if (!s0Var.f1337a) {
                                aVar = s0Var.g();
                                if (aVar != null) {
                                }
                                l a222 = k0Var.a(s0Var, aVar);
                                n0Var = k0Var.a(s0Var, a222);
                                k0.a(s0Var, a222, n0Var);
                                k0.a(s0Var, n0Var);
                                k0.a(s0Var);
                                k0Var.c(s0Var);
                            }
                            k0.a(s0Var, a222, n0Var);
                            k0.a(s0Var, n0Var);
                            k0.a(s0Var);
                            k0Var.c(s0Var);
                        } catch (Throwable th2) {
                            th = th2;
                            k0.a(s0Var, n0Var);
                            k0.a(s0Var);
                            k0Var.c(s0Var);
                            throw th;
                        }
                    } catch (r1 unused2) {
                        n0Var2 = n0Var;
                        n0Var = n0Var2;
                        k0.a(s0Var, n0Var);
                        k0.a(s0Var);
                        k0Var.c(s0Var);
                    } catch (Exception e) {
                        e = e;
                        if (!s0Var.f1337a) {
                            s0Var.a((Object) null, e, false);
                        }
                        k0.a(s0Var, n0Var);
                        k0.a(s0Var);
                        k0Var.c(s0Var);
                    }
                    l a2222 = k0Var.a(s0Var, aVar);
                    n0Var = k0Var.a(s0Var, a2222);
                } catch (r1 unused3) {
                } catch (Exception e2) {
                    e = e2;
                    n0Var = null;
                } catch (Throwable th3) {
                    n0Var = null;
                    th = th3;
                }
                z = true;
                IAlog.a("%s : NetworkExecutorImpl : should enabled watchdog : %s", IAlog.a(k0Var), Boolean.valueOf(z));
                if (z) {
                }
                aVar = null;
                if (aVar != null) {
                }
            }
        }
    }
}
