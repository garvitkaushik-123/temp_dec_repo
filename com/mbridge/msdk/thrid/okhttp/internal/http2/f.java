package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.u;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okhttp.z;
import com.mbridge.msdk.thrid.okio.s;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* compiled from: Http2Codec.java */
/* loaded from: classes6.dex */
public final class f implements com.mbridge.msdk.thrid.okhttp.internal.http.c {
    private static final List<String> f = com.mbridge.msdk.thrid.okhttp.internal.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority");
    private static final List<String> g = com.mbridge.msdk.thrid.okhttp.internal.c.a("connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade");

    /* renamed from: a, reason: collision with root package name */
    private final r.a f4851a;
    final com.mbridge.msdk.thrid.okhttp.internal.connection.g b;
    private final g c;
    private i d;
    private final u e;

    /* compiled from: Http2Codec.java */
    class a extends com.mbridge.msdk.thrid.okio.h {
        boolean b;
        long c;

        a(s sVar) {
            super(sVar);
            this.b = false;
            this.c = 0L;
        }

        private void a(IOException iOException) {
            if (this.b) {
                return;
            }
            this.b = true;
            f fVar = f.this;
            fVar.b.a(false, fVar, this.c, iOException);
        }

        @Override // com.mbridge.msdk.thrid.okio.s
        public long b(com.mbridge.msdk.thrid.okio.c cVar, long j) throws IOException {
            try {
                long b = d().b(cVar, j);
                if (b > 0) {
                    this.c += b;
                }
                return b;
            } catch (IOException e) {
                a(e);
                throw e;
            }
        }

        @Override // com.mbridge.msdk.thrid.okio.h, com.mbridge.msdk.thrid.okio.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            super.close();
            a(null);
        }
    }

    public f(t tVar, r.a aVar, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, g gVar2) {
        this.f4851a = aVar;
        this.b = gVar;
        this.c = gVar2;
        List<u> u = tVar.u();
        u uVar = u.H2_PRIOR_KNOWLEDGE;
        this.e = u.contains(uVar) ? uVar : u.HTTP_2;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public com.mbridge.msdk.thrid.okio.r a(w wVar, long j) {
        return this.d.d();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void b() throws IOException {
        this.c.flush();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void cancel() {
        i iVar = this.d;
        if (iVar != null) {
            iVar.c(b.CANCEL);
        }
    }

    public static List<c> b(w wVar) {
        p c = wVar.c();
        ArrayList arrayList = new ArrayList(c.b() + 4);
        arrayList.add(new c(c.f, wVar.e()));
        arrayList.add(new c(c.g, com.mbridge.msdk.thrid.okhttp.internal.http.i.a(wVar.g())));
        String a2 = wVar.a(HttpHeaders.HOST);
        if (a2 != null) {
            arrayList.add(new c(c.i, a2));
        }
        arrayList.add(new c(c.h, wVar.g().l()));
        int b = c.b();
        for (int i = 0; i < b; i++) {
            com.mbridge.msdk.thrid.okio.f c2 = com.mbridge.msdk.thrid.okio.f.c(c.a(i).toLowerCase(Locale.US));
            if (!f.contains(c2.h())) {
                arrayList.add(new c(c2, c.b(i)));
            }
        }
        return arrayList;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void a(w wVar) throws IOException {
        if (this.d != null) {
            return;
        }
        i a2 = this.c.a(b(wVar), wVar.a() != null);
        this.d = a2;
        com.mbridge.msdk.thrid.okio.t h = a2.h();
        long b = this.f4851a.b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h.a(b, timeUnit);
        this.d.l().a(this.f4851a.c(), timeUnit);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public void a() throws IOException {
        this.d.d().close();
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public y.a a(boolean z) throws IOException {
        y.a a2 = a(this.d.j(), this.e);
        if (z && com.mbridge.msdk.thrid.okhttp.internal.a.f4819a.a(a2) == 100) {
            return null;
        }
        return a2;
    }

    public static y.a a(p pVar, u uVar) throws IOException {
        p.a aVar = new p.a();
        int b = pVar.b();
        com.mbridge.msdk.thrid.okhttp.internal.http.k kVar = null;
        for (int i = 0; i < b; i++) {
            String a2 = pVar.a(i);
            String b2 = pVar.b(i);
            if (a2.equals(":status")) {
                kVar = com.mbridge.msdk.thrid.okhttp.internal.http.k.a("HTTP/1.1 " + b2);
            } else if (!g.contains(a2)) {
                com.mbridge.msdk.thrid.okhttp.internal.a.f4819a.a(aVar, a2, b2);
            }
        }
        if (kVar != null) {
            return new y.a().a(uVar).a(kVar.b).a(kVar.c).a(aVar.a());
        }
        throw new ProtocolException("Expected ':status' header not present");
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http.c
    public z a(y yVar) throws IOException {
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar = this.b;
        gVar.f.responseBodyStart(gVar.e);
        return new com.mbridge.msdk.thrid.okhttp.internal.http.h(yVar.b("Content-Type"), com.mbridge.msdk.thrid.okhttp.internal.http.e.a(yVar), com.mbridge.msdk.thrid.okio.l.a(new a(this.d.e())));
    }
}
