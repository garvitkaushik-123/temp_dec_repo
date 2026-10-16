package com.mbridge.msdk.thrid.okhttp.internal.tls;

import java.security.cert.X509Certificate;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.security.auth.x500.X500Principal;

/* compiled from: BasicTrustRootIndex.java */
/* loaded from: classes6.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name */
    private final Map<X500Principal, Set<X509Certificate>> f4874a = new LinkedHashMap();

    public b(X509Certificate... x509CertificateArr) {
        for (X509Certificate x509Certificate : x509CertificateArr) {
            X500Principal subjectX500Principal = x509Certificate.getSubjectX500Principal();
            Set<X509Certificate> set = this.f4874a.get(subjectX500Principal);
            if (set == null) {
                set = new LinkedHashSet<>(1);
                this.f4874a.put(subjectX500Principal, set);
            }
            set.add(x509Certificate);
        }
    }

    @Override // com.mbridge.msdk.thrid.okhttp.internal.tls.e
    public X509Certificate a(X509Certificate x509Certificate) {
        Set<X509Certificate> set = this.f4874a.get(x509Certificate.getIssuerX500Principal());
        if (set == null) {
            return null;
        }
        for (X509Certificate x509Certificate2 : set) {
            try {
                x509Certificate.verify(x509Certificate2.getPublicKey());
                return x509Certificate2;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof b) && ((b) obj).f4874a.equals(this.f4874a);
    }

    public int hashCode() {
        return this.f4874a.hashCode();
    }
}
