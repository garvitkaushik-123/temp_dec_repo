package com.fyber.inneractive.sdk.network;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.util.IAlog;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public final class k0 {
    public static final g0 g = new g0();

    /* renamed from: a, reason: collision with root package name */
    public final PriorityBlockingQueue f1326a = new PriorityBlockingQueue(100, new j0());
    public volatile boolean b = false;
    public final Handler c = new Handler(Looper.getMainLooper());
    public final ThreadPoolExecutor d = new ThreadPoolExecutor(6, 6, 1000, TimeUnit.SECONDS, new LinkedBlockingQueue(100), g);
    public final h0 e = new h0(this);
    public final h1 f = new h1();

    public static void a(s0 s0Var, l lVar, n0 n0Var) {
        try {
            if (s0Var.f1337a || s0Var.f() == null || n0Var == null || lVar == null || lVar.f1328a != 200) {
                return;
            }
            s0Var.a(n0Var, s0Var.f(), lVar.e);
        } catch (Exception e) {
            IAlog.a("Failed cache network response data", e, new Object[0]);
        }
    }

    public final void b(s0 s0Var) {
        o0 o0Var;
        if (!this.f1326a.offer(s0Var)) {
            IAlog.a("Request queue is full! current request is dropped! %s", s0Var.p());
            return;
        }
        g1 g1Var = g1.QUEUED;
        s0Var.f = g1Var;
        if (g1Var != g1.QUEUED_FOR_RETRY || (o0Var = s0Var.d) == null) {
            return;
        }
        o0Var.a("sdkRequestEndedButWillBeRetried");
    }

    public final void c(s0 s0Var) {
        h1 h1Var = this.f;
        h1Var.getClass();
        String str = s0Var.g;
        IAlog.a("%s : NetworkRequestWatchdog : finalize request: %s", IAlog.a(h1Var), str);
        l1 l1Var = (l1) h1Var.f1322a.get(str);
        if (l1Var != null) {
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(l1Var.d);
        }
        h1Var.f1322a.remove(str);
    }

    public final boolean d(s0 s0Var) {
        if (!s0Var.s()) {
            return false;
        }
        s0Var.f = g1.QUEUED_FOR_RETRY;
        o0 o0Var = s0Var.d;
        if (o0Var != null) {
            o0Var.a("sdkRequestEndedButWillBeRetried");
        }
        long e = s0Var.e();
        IAlog.e("retryNetworkRequest queue up in main thread - %s with delay of %d", s0Var.getClass().getName(), Long.valueOf(e));
        this.c.postDelayed(new i0(this, s0Var), e);
        return true;
    }

    public static void a(s0 s0Var, n0 n0Var) {
        try {
            if (s0Var.f1337a || n0Var == null) {
                return;
            }
            s0Var.a(n0Var.f1331a, (Exception) null, false);
        } catch (Exception e) {
            IAlog.a("failed notifying the listener request complete", e, new Object[0]);
            if (s0Var.f1337a) {
                return;
            }
            s0Var.a((Object) null, e, false);
        }
    }

    public final n0 a(s0 s0Var, l lVar) {
        if (lVar != null) {
            try {
                if (!s0Var.f1337a) {
                    int i = lVar.f1328a;
                    if (i != 200 && (i < 300 || i >= 304)) {
                        if (i == 304) {
                            s0Var.a((Object) null, (Exception) new g(), false);
                            return null;
                        }
                        s0Var.a((Object) null, (Exception) new i1(lVar.b, lVar.f1328a), false);
                        return null;
                    }
                    return s0Var.a(lVar, lVar.d, i);
                }
            } catch (r1 e) {
                IAlog.a("failed parsing network request but will retry", e, new Object[0]);
                if (d(s0Var)) {
                    throw e;
                }
                throw new q1(e);
            } catch (Exception e2) {
                IAlog.a("failed parsing network request", e2, new Object[0]);
                throw e2;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final l a(s0 s0Var, a aVar) {
        String str;
        try {
            if (s0Var.f1337a) {
                return null;
            }
            if (aVar != null) {
                str = aVar.f1310a;
            } else {
                str = "";
            }
            a();
            return s0Var.a(str);
        } catch (b e) {
            e = e;
            IAlog.a("failed sending network request", e, new Object[0]);
            if (d(s0Var)) {
                throw new r1(e);
            }
            throw new q1(e);
        } catch (r1 e2) {
            IAlog.a("failed sending network request but will retry", e2, new Object[0]);
            if (d(s0Var)) {
                throw e2;
            }
            throw new q1(e2);
        } catch (SocketTimeoutException e3) {
            e = e3;
            IAlog.a("failed sending network request", e, new Object[0]);
            if (d(s0Var)) {
            }
        } catch (UnknownHostException e4) {
            e = e4;
            IAlog.a("failed sending network request", e, new Object[0]);
            if (d(s0Var)) {
            }
        } catch (Exception e5) {
            IAlog.a("failed sending network request", e5, new Object[0]);
            throw e5;
        }
    }

    public static void a(s0 s0Var) {
        o0 o0Var;
        try {
            l lVar = s0Var.e;
            if (lVar != null) {
                lVar.a();
            }
            s0Var.c.getClass();
        } catch (Exception unused) {
        }
        g1 g1Var = g1.DONE;
        s0Var.f = g1Var;
        if (g1Var != g1.QUEUED_FOR_RETRY || (o0Var = s0Var.d) == null) {
            return;
        }
        o0Var.a("sdkRequestEndedButWillBeRetried");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003e, code lost:
    
        if (r2.isConnectedOrConnecting() != false) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a() {
        Boolean c = ((com.fyber.inneractive.sdk.config.global.features.k) IAConfigManager.O.M.a(com.fyber.inneractive.sdk.config.global.features.k.class)).c("should_use_is_network_connected");
        boolean z = false;
        if (c != null ? c.booleanValue() : false) {
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) com.fyber.inneractive.sdk.util.o.f1770a.getSystemService("connectivity");
                NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
                if (com.fyber.inneractive.sdk.util.o.a("android.permission.ACCESS_NETWORK_STATE") && activeNetworkInfo != null) {
                }
            } catch (Throwable unused) {
                IAlog.b("Error retrieved when trying to get the network state - Perhaps you forgot to declare android.permission.ACCESS_NETWORK_STATE in your Android manifest file.", new Object[0]);
            }
            if (z) {
                throw new b("No network connection");
            }
            return;
        }
        return;
        z = true;
        if (z) {
        }
    }
}
