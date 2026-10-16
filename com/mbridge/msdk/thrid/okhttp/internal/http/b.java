package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okio.l;
import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: CallServerInterceptor.java */
/* loaded from: classes6.dex */
public final class b implements r {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f4834a;

    /* compiled from: CallServerInterceptor.java */
    static final class a extends com.mbridge.msdk.thrid.okio.g {
        long b;

        a(com.mbridge.msdk.thrid.okio.r rVar) {
            super(rVar);
        }

        @Override // com.mbridge.msdk.thrid.okio.g, com.mbridge.msdk.thrid.okio.r
        public void a(com.mbridge.msdk.thrid.okio.c cVar, long j) throws IOException {
            super.a(cVar, j);
            this.b += j;
        }
    }

    public b(boolean z) {
        this.f4834a = z;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        g gVar = (g) aVar;
        c h = gVar.h();
        com.mbridge.msdk.thrid.okhttp.internal.connection.g i = gVar.i();
        com.mbridge.msdk.thrid.okhttp.internal.connection.c cVar = (com.mbridge.msdk.thrid.okhttp.internal.connection.c) gVar.f();
        w d = gVar.d();
        long currentTimeMillis = System.currentTimeMillis();
        gVar.g().requestHeadersStart(gVar.e());
        h.a(d);
        gVar.g().requestHeadersEnd(gVar.e(), d);
        y.a aVar2 = null;
        if (f.a(d.e()) && d.a() != null) {
            if ("100-continue".equalsIgnoreCase(d.a(HttpHeaders.EXPECT))) {
                h.b();
                gVar.g().responseHeadersStart(gVar.e());
                aVar2 = h.a(true);
            }
            if (aVar2 == null) {
                gVar.g().requestBodyStart(gVar.e());
                a aVar3 = new a(h.a(d, d.a().a()));
                com.mbridge.msdk.thrid.okio.d a2 = l.a(aVar3);
                d.a().a(a2);
                a2.close();
                gVar.g().requestBodyEnd(gVar.e(), aVar3.b);
            } else if (!cVar.f()) {
                i.e();
            }
        }
        h.a();
        if (aVar2 == null) {
            gVar.g().responseHeadersStart(gVar.e());
            aVar2 = h.a(false);
        }
        y a3 = aVar2.a(d).a(i.c().b()).b(currentTimeMillis).a(System.currentTimeMillis()).a();
        int k = a3.k();
        if (k == 100) {
            a3 = h.a(false).a(d).a(i.c().b()).b(currentTimeMillis).a(System.currentTimeMillis()).a();
            k = a3.k();
        }
        gVar.g().responseHeadersEnd(gVar.e(), a3);
        y a4 = (this.f4834a && k == 101) ? a3.o().a(com.mbridge.msdk.thrid.okhttp.internal.c.c).a() : a3.o().a(h.a(a3)).a();
        if ("close".equalsIgnoreCase(a4.r().a(HttpHeaders.CONNECTION)) || "close".equalsIgnoreCase(a4.b(HttpHeaders.CONNECTION))) {
            i.e();
        }
        if ((k == 204 || k == 205) && a4.d().h() > 0) {
            throw new ProtocolException("HTTP " + k + " had non-zero Content-Length: " + a4.d().h());
        }
        return a4;
    }
}
