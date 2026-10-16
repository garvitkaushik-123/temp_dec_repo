package com.mbridge.msdk.thrid.okhttp;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

/* compiled from: Handshake.java */
/* loaded from: classes6.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f4881a;
    private final f b;
    private final List<Certificate> c;
    private final List<Certificate> d;

    private o(b0 b0Var, f fVar, List<Certificate> list, List<Certificate> list2) {
        this.f4881a = b0Var;
        this.b = fVar;
        this.c = list;
        this.d = list2;
    }

    public static o a(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        }
        if ("SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
        f a2 = f.a(cipherSuite);
        String protocol = sSLSession.getProtocol();
        if (protocol == null) {
            throw new IllegalStateException("tlsVersion == null");
        }
        if ("NONE".equals(protocol)) {
            throw new IOException("tlsVersion == NONE");
        }
        b0 a3 = b0.a(protocol);
        try {
            certificateArr = sSLSession.getPeerCertificates();
        } catch (SSLPeerUnverifiedException unused) {
            certificateArr = null;
        }
        List a4 = certificateArr != null ? com.mbridge.msdk.thrid.okhttp.internal.c.a(certificateArr) : Collections.emptyList();
        Certificate[] localCertificates = sSLSession.getLocalCertificates();
        return new o(a3, a2, a4, localCertificates != null ? com.mbridge.msdk.thrid.okhttp.internal.c.a(localCertificates) : Collections.emptyList());
    }

    public List<Certificate> b() {
        return this.c;
    }

    public b0 c() {
        return this.f4881a;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        return this.f4881a.equals(oVar.f4881a) && this.b.equals(oVar.b) && this.c.equals(oVar.c) && this.d.equals(oVar.d);
    }

    public int hashCode() {
        return ((((((this.f4881a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public f a() {
        return this.b;
    }
}
