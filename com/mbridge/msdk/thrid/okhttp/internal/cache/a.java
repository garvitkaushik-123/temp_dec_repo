package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.internal.cache.b;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.u;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okhttp.z;
import java.io.IOException;

/* compiled from: CacheInterceptor.java */
/* loaded from: classes6.dex */
public final class a implements r {
    public a(c cVar) {
    }

    static boolean b(String str) {
        return (HttpHeaders.CONNECTION.equalsIgnoreCase(str) || HttpHeaders.KEEP_ALIVE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHENTICATE.equalsIgnoreCase(str) || HttpHeaders.PROXY_AUTHORIZATION.equalsIgnoreCase(str) || HttpHeaders.TE.equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || HttpHeaders.TRANSFER_ENCODING.equalsIgnoreCase(str) || HttpHeaders.UPGRADE.equalsIgnoreCase(str)) ? false : true;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        b c = new b.a(System.currentTimeMillis(), aVar.d(), null).c();
        w wVar = c.f4823a;
        y yVar = c.b;
        if (wVar == null && yVar == null) {
            return new y.a().a(aVar.d()).a(u.HTTP_1_1).a(504).a("Unsatisfiable Request (only-if-cached)").a(com.mbridge.msdk.thrid.okhttp.internal.c.c).b(-1L).a(System.currentTimeMillis()).a();
        }
        if (wVar == null) {
            return yVar.o().a(a(yVar)).a();
        }
        y a2 = aVar.a(wVar);
        if (yVar != null) {
            if (a2.k() == 304) {
                yVar.o().a(a(yVar.m(), a2.m())).b(a2.s()).a(a2.q()).a(a(yVar)).c(a(a2)).a();
                a2.d().close();
                throw null;
            }
            com.mbridge.msdk.thrid.okhttp.internal.c.a(yVar.d());
        }
        return a2.o().a(a(yVar)).c(a(a2)).a();
    }

    private static y a(y yVar) {
        return (yVar == null || yVar.d() == null) ? yVar : yVar.o().a((z) null).a();
    }

    private static p a(p pVar, p pVar2) {
        p.a aVar = new p.a();
        int b = pVar.b();
        for (int i = 0; i < b; i++) {
            String a2 = pVar.a(i);
            String b2 = pVar.b(i);
            if ((!HttpHeaders.WARNING.equalsIgnoreCase(a2) || !b2.startsWith("1")) && (a(a2) || !b(a2) || pVar2.b(a2) == null)) {
                com.mbridge.msdk.thrid.okhttp.internal.a.f4819a.a(aVar, a2, b2);
            }
        }
        int b3 = pVar2.b();
        for (int i2 = 0; i2 < b3; i2++) {
            String a3 = pVar2.a(i2);
            if (!a(a3) && b(a3)) {
                com.mbridge.msdk.thrid.okhttp.internal.a.f4819a.a(aVar, a3, pVar2.b(i2));
            }
        }
        return aVar.a();
    }

    static boolean a(String str) {
        return HttpHeaders.CONTENT_LENGTH.equalsIgnoreCase(str) || HttpHeaders.CONTENT_ENCODING.equalsIgnoreCase(str) || "Content-Type".equalsIgnoreCase(str);
    }
}
