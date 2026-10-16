package com.mbridge.msdk.tracker.network.toolbox;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.foundation.same.net.MBridgeHostnameVerifier;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.u;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.x;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okhttp.z;
import com.mbridge.msdk.tracker.network.p;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: OKHttpStack.java */
/* loaded from: classes6.dex */
public class m extends a {

    /* renamed from: a, reason: collision with root package name */
    private final t f4958a = a();

    private static x a(com.mbridge.msdk.tracker.network.t tVar) {
        byte[] b;
        if (tVar == null || (b = tVar.b()) == null) {
            return null;
        }
        return x.a(null, b);
    }

    @Override // com.mbridge.msdk.tracker.network.toolbox.a
    public g a(com.mbridge.msdk.tracker.network.t<?> tVar, Map<String, String> map) throws IOException {
        p h = tVar.h();
        if (this.f4958a != null) {
            int q = tVar.q() <= 0 ? 30000 : tVar.q();
            long r = tVar.r();
            String a2 = tVar.g() == 0 ? d.a(tVar.t(), tVar) : tVar.t();
            if (h != null) {
                h.f(a2);
                long j = q;
                h.e(j);
                h.f(j);
                h.j(j);
                h.a(tVar.n());
            }
            a(tVar, h);
            ArrayList arrayList = new ArrayList();
            arrayList.add(u.HTTP_1_1);
            arrayList.add(u.HTTP_2);
            t.b a3 = this.f4958a.s().a(arrayList).a(new MBridgeHostnameVerifier(a2));
            long j2 = q;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            t.b a4 = a3.d(j2, timeUnit).b(j2, timeUnit).a(h == null ? com.mbridge.msdk.thrid.okhttp.m.f4879a : new j(h.H(), h.b(), h)).e(j2, timeUnit).a(Math.max(r, 0L), timeUnit);
            a(h, a4);
            w.a aVar = new w.a();
            for (Map.Entry<String, String> entry : tVar.f().entrySet()) {
                aVar.a(entry.getKey(), entry.getValue());
            }
            aVar.a(HttpHeaders.CONNECTION, "close");
            a(aVar, tVar);
            y d = a4.a().a(aVar.b(a2).a()).d();
            com.mbridge.msdk.thrid.okhttp.p m = d.m();
            ArrayList arrayList2 = new ArrayList();
            int b = m.b();
            for (int i = 0; i < b; i++) {
                String a5 = m.a(i);
                String b2 = m.b(i);
                if (a5 != null) {
                    arrayList2.add(new com.mbridge.msdk.tracker.network.g(a5, b2));
                }
            }
            z d2 = d.d();
            if (d2 == null) {
                return new g(d.k(), arrayList2);
            }
            return new g(d.k(), arrayList2, a(d2), d2.d());
        }
        throw new IOException("okhttp client is null");
    }

    private static void a(p pVar, t.b bVar) {
        if (pVar == null || bVar == null) {
            return;
        }
        try {
            bVar.a(new OKHTTPEventListener(pVar));
        } catch (Exception unused) {
        }
    }

    private static void a(com.mbridge.msdk.tracker.network.t<?> tVar, p pVar) {
        if (pVar == null || tVar == null) {
            return;
        }
        try {
            pVar.g(tVar.m());
        } catch (Exception unused) {
        }
    }

    private int a(z zVar) {
        if (zVar == null) {
            return 0;
        }
        if (zVar.h() > 2147483647L) {
            return -1;
        }
        return (int) zVar.h();
    }

    private t a() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        com.mbridge.msdk.thrid.okhttp.l lVar = new com.mbridge.msdk.thrid.okhttp.l(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, timeUnit, new SynchronousQueue(), com.mbridge.msdk.thrid.okhttp.internal.c.a("OkHttp Dispatcher", false)));
        lVar.b(50);
        lVar.a(256);
        t.b bVar = new t.b();
        bVar.d(30L, timeUnit);
        bVar.b(30L, timeUnit);
        bVar.e(30L, timeUnit);
        bVar.a(true);
        bVar.a(new com.mbridge.msdk.thrid.okhttp.h(32, 5L, TimeUnit.MINUTES));
        bVar.a(lVar);
        return bVar.a();
    }

    private static void a(w.a aVar, com.mbridge.msdk.tracker.network.t<?> tVar) throws IOException {
        switch (tVar.g()) {
            case 0:
                aVar.c();
                return;
            case 1:
                x a2 = a(tVar);
                if (a2 != null) {
                    aVar.c(a2);
                    return;
                }
                throw new IOException("can't create request body for post");
            case 2:
                x a3 = a(tVar);
                if (a3 != null) {
                    aVar.d(a3);
                    return;
                }
                throw new IOException("can't create request body for put");
            case 3:
                aVar.b();
                return;
            case 4:
                aVar.d();
                return;
            case 5:
                aVar.a("OPTIONS", (x) null);
                return;
            case 6:
                aVar.a("TRACE", (x) null);
                return;
            case 7:
                x a4 = a(tVar);
                if (a4 != null) {
                    aVar.b(a4);
                    return;
                }
                throw new IOException("can't create request body for patch");
            default:
                throw new IllegalStateException("Unknown method type.");
        }
    }
}
