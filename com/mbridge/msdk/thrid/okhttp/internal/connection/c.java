package com.mbridge.msdk.thrid.okhttp.internal.connection;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.a0;
import com.mbridge.msdk.thrid.okhttp.h;
import com.mbridge.msdk.thrid.okhttp.i;
import com.mbridge.msdk.thrid.okhttp.internal.http2.g;
import com.mbridge.msdk.thrid.okhttp.n;
import com.mbridge.msdk.thrid.okhttp.o;
import com.mbridge.msdk.thrid.okhttp.q;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.u;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.x;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okio.l;
import com.mbridge.msdk.thrid.okio.s;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: RealConnection.java */
/* loaded from: classes6.dex */
public final class c extends g.j implements com.mbridge.msdk.thrid.okhttp.g {
    private final h b;
    private final a0 c;
    private Socket d;
    private Socket e;
    private o f;
    private u g;
    private com.mbridge.msdk.thrid.okhttp.internal.http2.g h;
    private com.mbridge.msdk.thrid.okio.e i;
    private com.mbridge.msdk.thrid.okio.d j;
    public boolean k;
    public int l;
    public int m = 1;
    public final List<Reference<g>> n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public c(h hVar, a0 a0Var) {
        this.b = hVar;
        this.c = a0Var;
    }

    private w e() throws IOException {
        w a2 = new w.a().a(this.c.a().k()).a("CONNECT", (x) null).b(HttpHeaders.HOST, com.mbridge.msdk.thrid.okhttp.internal.c.a(this.c.a().k(), true)).b("Proxy-Connection", HttpHeaders.KEEP_ALIVE).b("User-Agent", com.mbridge.msdk.thrid.okhttp.internal.d.a()).a();
        w a3 = this.c.a().g().a(this.c, new y.a().a(a2).a(u.HTTP_1_1).a(407).a("Preemptive Authenticate").a(com.mbridge.msdk.thrid.okhttp.internal.c.c).b(-1L).a(-1L).b(HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive").a());
        return a3 != null ? a3 : a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ee A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x013b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x012e  */
    /* JADX WARN: Type inference failed for: r1v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v3, types: [com.mbridge.msdk.thrid.okhttp.u, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, int i2, int i3, int i4, boolean z, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar) {
        n nVar2;
        com.mbridge.msdk.thrid.okhttp.d dVar2;
        IOException iOException;
        if (this.g != null) {
            throw new IllegalStateException("already connected");
        }
        List<i> b = this.c.a().b();
        b bVar = new b(b);
        if (this.c.a().j() != null) {
            List<u> e = this.c.a().e();
            ?? r1 = u.H2_PRIOR_KNOWLEDGE;
            boolean contains = e.contains(r1);
            nVar2 = r1;
            if (contains) {
                throw new e(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
            }
        } else {
            if (!b.contains(i.j)) {
                throw new e(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String g = this.c.a().k().g();
            ?? b2 = com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().b(g);
            nVar2 = b2;
            if (b2 == 0) {
                throw new e(new UnknownServiceException("CLEARTEXT communication to " + g + " not permitted by network security policy"));
            }
        }
        e eVar = null;
        do {
            try {
                try {
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (IOException e3) {
                e = e3;
                dVar2 = dVar;
                nVar2 = nVar;
            }
            try {
                if (this.c.c()) {
                    try {
                        a(i, i2, i3, dVar, nVar);
                        dVar2 = dVar;
                        nVar2 = nVar;
                        if (this.d == null) {
                            if (!this.c.c() && this.d == null) {
                                throw new e(new ProtocolException("Too many tunnel connections attempted: 21"));
                            }
                            if (this.h == null) {
                                synchronized (this.b) {
                                    this.m = this.h.k();
                                }
                                return;
                            }
                            return;
                        }
                    } catch (IOException e4) {
                        e = e4;
                        dVar2 = dVar;
                        nVar2 = nVar;
                        iOException = e;
                        com.mbridge.msdk.thrid.okhttp.internal.c.a(this.e);
                        com.mbridge.msdk.thrid.okhttp.internal.c.a(this.d);
                        this.e = null;
                        this.d = null;
                        this.i = null;
                        this.j = null;
                        this.f = null;
                        this.g = null;
                        this.h = null;
                        nVar2.connectFailed(dVar2, this.c.d(), this.c.b(), null, iOException);
                        if (eVar != null) {
                        }
                        if (z) {
                        }
                    }
                } else {
                    dVar2 = dVar;
                    n nVar3 = nVar;
                    a(i, i2, dVar2, nVar3);
                    nVar2 = nVar3;
                }
                a(bVar, i4, dVar2, nVar2);
                nVar2.connectEnd(dVar2, this.c.d(), this.c.b(), this.g);
                if (!this.c.c()) {
                }
                if (this.h == null) {
                }
            } catch (IOException e5) {
                e = e5;
                iOException = e;
                com.mbridge.msdk.thrid.okhttp.internal.c.a(this.e);
                com.mbridge.msdk.thrid.okhttp.internal.c.a(this.d);
                this.e = null;
                this.d = null;
                this.i = null;
                this.j = null;
                this.f = null;
                this.g = null;
                this.h = null;
                nVar2.connectFailed(dVar2, this.c.d(), this.c.b(), null, iOException);
                if (eVar != null) {
                    eVar = new e(iOException);
                } else {
                    eVar.a(iOException);
                }
                if (z) {
                    throw eVar;
                }
            }
        } while (bVar.a(iOException));
        throw eVar;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.g
    public o b() {
        return this.f;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.g
    public a0 c() {
        return this.c;
    }

    public void d() {
        com.mbridge.msdk.thrid.okhttp.internal.c.a(this.d);
    }

    public boolean f() {
        return this.h != null;
    }

    public Socket g() {
        return this.e;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("Connection{").append(this.c.a().k().g()).append(":").append(this.c.a().k().j()).append(", proxy=").append(this.c.b()).append(" hostAddress=").append(this.c.d()).append(" cipherSuite=");
        o oVar = this.f;
        return append.append(oVar != null ? oVar.a() : "none").append(" protocol=").append(this.g).append(AbstractJsonLexerKt.END_OBJ).toString();
    }

    private void a(int i, int i2, int i3, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar) throws IOException {
        w e = e();
        q g = e.g();
        for (int i4 = 0; i4 < 21; i4++) {
            a(i, i2, dVar, nVar);
            e = a(i2, i3, e, g);
            if (e == null) {
                return;
            }
            com.mbridge.msdk.thrid.okhttp.internal.c.a(this.d);
            this.d = null;
            this.j = null;
            this.i = null;
            nVar.connectEnd(dVar, this.c.d(), this.c.b(), null);
        }
    }

    private void a(int i, int i2, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar) throws IOException {
        Proxy b = this.c.b();
        this.d = (b.type() == Proxy.Type.DIRECT || b.type() == Proxy.Type.HTTP) ? this.c.a().i().createSocket() : new Socket(b);
        nVar.connectStart(dVar, this.c.d(), b);
        this.d.setSoTimeout(i2);
        try {
            com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(this.d, this.c.d(), i);
            try {
                this.i = l.a(l.b(this.d));
                this.j = l.a(l.a(this.d));
            } catch (NullPointerException e) {
                if ("throw with null exception".equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.c.d());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    private void a(b bVar, int i, com.mbridge.msdk.thrid.okhttp.d dVar, n nVar) throws IOException {
        if (this.c.a().j() == null) {
            List<u> e = this.c.a().e();
            u uVar = u.H2_PRIOR_KNOWLEDGE;
            if (e.contains(uVar)) {
                this.e = this.d;
                this.g = uVar;
                a(i);
                return;
            } else {
                this.e = this.d;
                this.g = u.HTTP_1_1;
                return;
            }
        }
        nVar.secureConnectStart(dVar);
        a(bVar);
        nVar.secureConnectEnd(dVar, this.f);
        if (this.g == u.HTTP_2) {
            a(i);
        }
    }

    private void a(int i) throws IOException {
        this.e.setSoTimeout(0);
        com.mbridge.msdk.thrid.okhttp.internal.http2.g a2 = new g.h(true).a(this.e, this.c.a().k().g(), this.i, this.j).a(this).a(i).a();
        this.h = a2;
        a2.m();
    }

    private void a(b bVar) throws IOException {
        SSLSocket sSLSocket;
        com.mbridge.msdk.thrid.okhttp.a a2 = this.c.a();
        SSLSocket sSLSocket2 = null;
        try {
            try {
                sSLSocket = (SSLSocket) a2.j().createSocket(this.d, a2.k().g(), a2.k().j(), true);
            } catch (AssertionError e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            i a3 = bVar.a(sSLSocket);
            if (a3.c()) {
                com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(sSLSocket, a2.k().g(), a2.e());
            }
            sSLSocket.startHandshake();
            SSLSession session = sSLSocket.getSession();
            o a4 = o.a(session);
            if (!a2.d().verify(a2.k().g(), session)) {
                List<Certificate> b = a4.b();
                if (!b.isEmpty()) {
                    X509Certificate x509Certificate = (X509Certificate) b.get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + a2.k().g() + " not verified:\n    certificate: " + com.mbridge.msdk.thrid.okhttp.e.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + com.mbridge.msdk.thrid.okhttp.internal.tls.d.a(x509Certificate));
                }
                throw new SSLPeerUnverifiedException("Hostname " + a2.k().g() + " not verified (no certificates)");
            }
            a2.a().a(a2.k().g(), a4.b());
            String b2 = a3.c() ? com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().b(sSLSocket) : null;
            this.e = sSLSocket;
            this.i = l.a(l.b(sSLSocket));
            this.j = l.a(l.a(this.e));
            this.f = a4;
            this.g = b2 != null ? u.a(b2) : u.HTTP_1_1;
            com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(sSLSocket);
        } catch (AssertionError e2) {
            e = e2;
            if (!com.mbridge.msdk.thrid.okhttp.internal.c.a(e)) {
                throw e;
            }
            throw new IOException(e);
        } catch (Throwable th2) {
            th = th2;
            sSLSocket2 = sSLSocket;
            if (sSLSocket2 != null) {
                com.mbridge.msdk.thrid.okhttp.internal.platform.g.d().a(sSLSocket2);
            }
            com.mbridge.msdk.thrid.okhttp.internal.c.a((Socket) sSLSocket2);
            throw th;
        }
    }

    private w a(int i, int i2, w wVar, q qVar) throws IOException {
        String str = "CONNECT " + com.mbridge.msdk.thrid.okhttp.internal.c.a(qVar, true) + " HTTP/1.1";
        while (true) {
            com.mbridge.msdk.thrid.okhttp.internal.http1.a aVar = new com.mbridge.msdk.thrid.okhttp.internal.http1.a(null, null, this.i, this.j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.i.b().a(i, timeUnit);
            this.j.b().a(i2, timeUnit);
            aVar.a(wVar.c(), str);
            aVar.a();
            y a2 = aVar.a(false).a(wVar).a();
            long a3 = com.mbridge.msdk.thrid.okhttp.internal.http.e.a(a2);
            if (a3 == -1) {
                a3 = 0;
            }
            s b = aVar.b(a3);
            com.mbridge.msdk.thrid.okhttp.internal.c.b(b, Integer.MAX_VALUE, timeUnit);
            b.close();
            int k = a2.k();
            if (k == 200) {
                if (this.i.a().f() && this.j.a().f()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
            if (k == 407) {
                w a4 = this.c.a().g().a(this.c, a2);
                if (a4 != null) {
                    if ("close".equalsIgnoreCase(a2.b(HttpHeaders.CONNECTION))) {
                        return a4;
                    }
                    wVar = a4;
                } else {
                    throw new IOException("Failed to authenticate with proxy");
                }
            } else {
                throw new IOException("Unexpected response code for CONNECT: " + a2.k());
            }
        }
    }

    public boolean a(com.mbridge.msdk.thrid.okhttp.a aVar, @Nullable a0 a0Var) {
        if (this.n.size() >= this.m || this.k || !com.mbridge.msdk.thrid.okhttp.internal.a.f4819a.a(this.c.a(), aVar)) {
            return false;
        }
        if (aVar.k().g().equals(c().a().k().g())) {
            return true;
        }
        if (this.h == null || a0Var == null || a0Var.b().type() != Proxy.Type.DIRECT || this.c.b().type() != Proxy.Type.DIRECT || !this.c.d().equals(a0Var.d()) || a0Var.a().d() != com.mbridge.msdk.thrid.okhttp.internal.tls.d.f4875a || !a(aVar.k())) {
            return false;
        }
        try {
            aVar.a().a(aVar.k().g(), b().b());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean a(q qVar) {
        if (qVar.j() != this.c.a().k().j()) {
            return false;
        }
        if (qVar.g().equals(this.c.a().k().g())) {
            return true;
        }
        return this.f != null && com.mbridge.msdk.thrid.okhttp.internal.tls.d.f4875a.a(qVar.g(), (X509Certificate) this.f.b().get(0));
    }

    public com.mbridge.msdk.thrid.okhttp.internal.http.c a(t tVar, r.a aVar, g gVar) throws SocketException {
        if (this.h != null) {
            return new com.mbridge.msdk.thrid.okhttp.internal.http2.f(tVar, aVar, gVar, this.h);
        }
        this.e.setSoTimeout(aVar.b());
        com.mbridge.msdk.thrid.okio.t b = this.i.b();
        long b2 = aVar.b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        b.a(b2, timeUnit);
        this.j.b().a(aVar.c(), timeUnit);
        return new com.mbridge.msdk.thrid.okhttp.internal.http1.a(tVar, gVar, this.i, this.j);
    }

    public boolean a(boolean z) {
        if (this.e.isClosed() || this.e.isInputShutdown() || this.e.isOutputShutdown()) {
            return false;
        }
        com.mbridge.msdk.thrid.okhttp.internal.http2.g gVar = this.h;
        if (gVar != null) {
            return gVar.f(System.nanoTime());
        }
        if (z) {
            try {
                int soTimeout = this.e.getSoTimeout();
                try {
                    this.e.setSoTimeout(1);
                    return !this.i.f();
                } finally {
                    this.e.setSoTimeout(soTimeout);
                }
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.g.j
    public void a(com.mbridge.msdk.thrid.okhttp.internal.http2.i iVar) throws IOException {
        iVar.a(com.mbridge.msdk.thrid.okhttp.internal.http2.b.REFUSED_STREAM);
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.http2.g.j
    public void a(com.mbridge.msdk.thrid.okhttp.internal.http2.g gVar) {
        synchronized (this.b) {
            this.m = gVar.k();
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.g
    public u a() {
        return this.g;
    }
}
