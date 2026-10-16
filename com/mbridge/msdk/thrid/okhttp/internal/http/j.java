package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.google.common.net.HttpHeaders;
import com.mbridge.msdk.thrid.okhttp.a0;
import com.mbridge.msdk.thrid.okhttp.n;
import com.mbridge.msdk.thrid.okhttp.q;
import com.mbridge.msdk.thrid.okhttp.r;
import com.mbridge.msdk.thrid.okhttp.t;
import com.mbridge.msdk.thrid.okhttp.w;
import com.mbridge.msdk.thrid.okhttp.x;
import com.mbridge.msdk.thrid.okhttp.y;
import com.mbridge.msdk.thrid.okhttp.z;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: RetryAndFollowUpInterceptor.java */
/* loaded from: classes6.dex */
public final class j implements r {

    /* renamed from: a, reason: collision with root package name */
    private final t f4839a;
    private final boolean b;
    private volatile com.mbridge.msdk.thrid.okhttp.internal.connection.g c;
    private Object d;
    private volatile boolean e;

    public j(t tVar, boolean z) {
        this.f4839a = tVar;
        this.b = z;
    }

    public void a() {
        this.e = true;
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar = this.c;
        if (gVar != null) {
            gVar.a();
        }
    }

    public boolean b() {
        return this.e;
    }

    public void a(Object obj) {
        this.d = obj;
    }

    @Override // com.mbridge.msdk.thrid.okhttp.r
    public y a(r.a aVar) throws IOException {
        y a2;
        w a3;
        w d = aVar.d();
        g gVar = (g) aVar;
        com.mbridge.msdk.thrid.okhttp.d e = gVar.e();
        n g = gVar.g();
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar2 = new com.mbridge.msdk.thrid.okhttp.internal.connection.g(this.f4839a.f(), a(d.g()), e, g, this.d);
        this.c = gVar2;
        com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar3 = gVar2;
        int i = 0;
        y yVar = null;
        w wVar = d;
        while (!this.e) {
            try {
                try {
                    a2 = gVar.a(wVar, gVar3, null, null);
                    if (yVar != null) {
                        a2 = a2.o().d(yVar.o().a((z) null).a()).a();
                    }
                    try {
                        a3 = a(a2, gVar3.h());
                    } catch (IOException e2) {
                        gVar3.f();
                        throw e2;
                    }
                } catch (Throwable th) {
                    gVar3.a((IOException) null);
                    gVar3.f();
                    throw th;
                }
            } catch (com.mbridge.msdk.thrid.okhttp.internal.connection.e e3) {
                if (!a(e3.b(), gVar3, false, wVar)) {
                    throw e3.a();
                }
            } catch (IOException e4) {
                if (!a(e4, gVar3, !(e4 instanceof com.mbridge.msdk.thrid.okhttp.internal.http2.a), wVar)) {
                    throw e4;
                }
            }
            if (a3 == null) {
                gVar3.f();
                return a2;
            }
            com.mbridge.msdk.thrid.okhttp.internal.c.a(a2.d());
            int i2 = i + 1;
            if (i2 <= 20) {
                a3.a();
                if (!a(a2, a3.g())) {
                    gVar3.f();
                    com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar4 = new com.mbridge.msdk.thrid.okhttp.internal.connection.g(this.f4839a.f(), a(a3.g()), e, g, this.d);
                    this.c = gVar4;
                    yVar = a2;
                    gVar3 = gVar4;
                } else {
                    if (gVar3.b() != null) {
                        throw new IllegalStateException("Closing the body of " + a2 + " didn't close its backing stream. Bad interceptor?");
                    }
                    yVar = a2;
                }
                wVar = a3;
                i = i2;
            } else {
                gVar3.f();
                throw new ProtocolException("Too many follow-up requests: " + i2);
            }
        }
        gVar3.f();
        throw new IOException("Canceled");
    }

    private com.mbridge.msdk.thrid.okhttp.a a(q qVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        com.mbridge.msdk.thrid.okhttp.e eVar;
        if (qVar.h()) {
            sSLSocketFactory = this.f4839a.B();
            hostnameVerifier = this.f4839a.o();
            eVar = this.f4839a.c();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            eVar = null;
        }
        return new com.mbridge.msdk.thrid.okhttp.a(qVar.g(), qVar.j(), this.f4839a.k(), this.f4839a.A(), sSLSocketFactory, hostnameVerifier, eVar, this.f4839a.w(), this.f4839a.v(), this.f4839a.u(), this.f4839a.g(), this.f4839a.x());
    }

    private boolean a(IOException iOException, com.mbridge.msdk.thrid.okhttp.internal.connection.g gVar, boolean z, w wVar) {
        gVar.a(iOException);
        if (this.f4839a.z()) {
            return !(z && a(iOException, wVar)) && a(iOException, z) && gVar.d();
        }
        return false;
    }

    private boolean a(IOException iOException, w wVar) {
        wVar.a();
        return iOException instanceof FileNotFoundException;
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        return iOException instanceof InterruptedIOException ? (iOException instanceof SocketTimeoutException) && !z : (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) ? false : true;
    }

    private w a(y yVar, a0 a0Var) throws IOException {
        String b;
        q e;
        if (yVar != null) {
            int k = yVar.k();
            String e2 = yVar.r().e();
            if (k == 307 || k == 308) {
                if (!e2.equals("GET") && !e2.equals("HEAD")) {
                    return null;
                }
            } else {
                if (k == 401) {
                    return this.f4839a.a().a(a0Var, yVar);
                }
                if (k == 503) {
                    if ((yVar.p() == null || yVar.p().k() != 503) && a(yVar, Integer.MAX_VALUE) == 0) {
                        return yVar.r();
                    }
                    return null;
                }
                if (k == 407) {
                    if (a0Var.b().type() == Proxy.Type.HTTP) {
                        return this.f4839a.w().a(a0Var, yVar);
                    }
                    throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                }
                if (k == 408) {
                    if (!this.f4839a.z()) {
                        return null;
                    }
                    yVar.r().a();
                    if ((yVar.p() == null || yVar.p().k() != 408) && a(yVar, 0) <= 0) {
                        return yVar.r();
                    }
                    return null;
                }
                switch (k) {
                    case 300:
                    case MRAID_ERROR_VALUE:
                    case INVALID_IFA_STATUS_VALUE:
                    case 303:
                        break;
                    default:
                        return null;
                }
            }
            if (!this.f4839a.m() || (b = yVar.b("Location")) == null || (e = yVar.r().g().e(b)) == null) {
                return null;
            }
            if (!e.l().equals(yVar.r().g().l()) && !this.f4839a.n()) {
                return null;
            }
            w.a f = yVar.r().f();
            if (f.a(e2)) {
                boolean c = f.c(e2);
                if (f.b(e2)) {
                    f.a("GET", (x) null);
                } else {
                    f.a(e2, c ? yVar.r().a() : null);
                }
                if (!c) {
                    f.a(HttpHeaders.TRANSFER_ENCODING);
                    f.a(HttpHeaders.CONTENT_LENGTH);
                    f.a("Content-Type");
                }
            }
            if (!a(yVar, e)) {
                f.a(HttpHeaders.AUTHORIZATION);
            }
            return f.a(e).a();
        }
        throw new IllegalStateException();
    }

    private int a(y yVar, int i) {
        String b = yVar.b("Retry-After");
        if (b == null) {
            return i;
        }
        if (b.matches("\\d+")) {
            return Integer.valueOf(b).intValue();
        }
        return Integer.MAX_VALUE;
    }

    private boolean a(y yVar, q qVar) {
        q g = yVar.r().g();
        return g.g().equals(qVar.g()) && g.j() == qVar.j() && g.l().equals(qVar.l());
    }
}
