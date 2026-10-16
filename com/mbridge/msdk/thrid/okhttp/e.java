package com.mbridge.msdk.thrid.okhttp;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: CertificatePinner.java */
/* loaded from: classes6.dex */
public final class e {
    public static final e c = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final Set<b> f4811a;

    @Nullable
    private final com.mbridge.msdk.thrid.okhttp.internal.tls.c b;

    /* compiled from: CertificatePinner.java */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final List<b> f4812a = new ArrayList();

        public e a() {
            return new e(new LinkedHashSet(this.f4812a), null);
        }
    }

    /* compiled from: CertificatePinner.java */
    static final class b {

        /* renamed from: a, reason: collision with root package name */
        final String f4813a;
        final String b;
        final String c;
        final com.mbridge.msdk.thrid.okio.f d;

        boolean a(String str) {
            if (!this.f4813a.startsWith("*.")) {
                return str.equals(this.b);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 != this.b.length()) {
                return false;
            }
            String str2 = this.b;
            return str.regionMatches(false, indexOf + 1, str2, 0, str2.length());
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f4813a.equals(bVar.f4813a) && this.c.equals(bVar.c) && this.d.equals(bVar.d);
        }

        public int hashCode() {
            return ((((this.f4813a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
        }

        public String toString() {
            return this.c + this.d.a();
        }
    }

    e(Set<b> set, @Nullable com.mbridge.msdk.thrid.okhttp.internal.tls.c cVar) {
        this.f4811a = set;
        this.b = cVar;
    }

    static com.mbridge.msdk.thrid.okio.f b(X509Certificate x509Certificate) {
        return com.mbridge.msdk.thrid.okio.f.a(x509Certificate.getPublicKey().getEncoded()).d();
    }

    public void a(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<b> a2 = a(str);
        if (a2.isEmpty()) {
            return;
        }
        com.mbridge.msdk.thrid.okhttp.internal.tls.c cVar = this.b;
        if (cVar != null) {
            list = cVar.a(list, str);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i);
            int size2 = a2.size();
            com.mbridge.msdk.thrid.okio.f fVar = null;
            com.mbridge.msdk.thrid.okio.f fVar2 = null;
            for (int i2 = 0; i2 < size2; i2++) {
                b bVar = a2.get(i2);
                if (bVar.c.equals("sha256/")) {
                    if (fVar == null) {
                        fVar = b(x509Certificate);
                    }
                    if (bVar.d.equals(fVar)) {
                        return;
                    }
                } else {
                    if (!bVar.c.equals("sha1/")) {
                        throw new AssertionError("unsupported hashAlgorithm: " + bVar.c);
                    }
                    if (fVar2 == null) {
                        fVar2 = a(x509Certificate);
                    }
                    if (bVar.d.equals(fVar2)) {
                        return;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size3 = list.size();
        for (int i3 = 0; i3 < size3; i3++) {
            X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
            sb.append("\n    ").append(a((Certificate) x509Certificate2)).append(": ").append(x509Certificate2.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ").append(str).append(":");
        int size4 = a2.size();
        for (int i4 = 0; i4 < size4; i4++) {
            sb.append("\n    ").append(a2.get(i4));
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return com.mbridge.msdk.thrid.okhttp.internal.c.a(this.b, eVar.b) && this.f4811a.equals(eVar.f4811a);
    }

    public int hashCode() {
        com.mbridge.msdk.thrid.okhttp.internal.tls.c cVar = this.b;
        return ((cVar != null ? cVar.hashCode() : 0) * 31) + this.f4811a.hashCode();
    }

    List<b> a(String str) {
        List<b> emptyList = Collections.emptyList();
        for (b bVar : this.f4811a) {
            if (bVar.a(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(bVar);
            }
        }
        return emptyList;
    }

    e a(@Nullable com.mbridge.msdk.thrid.okhttp.internal.tls.c cVar) {
        return com.mbridge.msdk.thrid.okhttp.internal.c.a(this.b, cVar) ? this : new e(this.f4811a, cVar);
    }

    public static String a(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + b((X509Certificate) certificate).a();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    static com.mbridge.msdk.thrid.okio.f a(X509Certificate x509Certificate) {
        return com.mbridge.msdk.thrid.okio.f.a(x509Certificate.getPublicKey().getEncoded()).c();
    }
}
