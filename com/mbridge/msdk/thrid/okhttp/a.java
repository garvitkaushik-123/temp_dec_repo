package com.mbridge.msdk.thrid.okhttp;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.mbridge.msdk.thrid.okhttp.q;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: Address.java */
/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    final q f4805a;
    final m b;
    final SocketFactory c;
    final b d;
    final List<u> e;
    final List<i> f;
    final ProxySelector g;

    @Nullable
    final Proxy h;

    @Nullable
    final SSLSocketFactory i;

    @Nullable
    final HostnameVerifier j;

    @Nullable
    final e k;

    public a(String str, int i, m mVar, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable e eVar, b bVar, @Nullable Proxy proxy, List<u> list, List<i> list2, ProxySelector proxySelector) {
        this.f4805a = new q.a().e(sSLSocketFactory != null ? "https" : "http").b(str).a(i).a();
        if (mVar == null) {
            throw new NullPointerException("dns == null");
        }
        this.b = mVar;
        if (socketFactory == null) {
            throw new NullPointerException("socketFactory == null");
        }
        this.c = socketFactory;
        if (bVar == null) {
            throw new NullPointerException("proxyAuthenticator == null");
        }
        this.d = bVar;
        if (list == null) {
            throw new NullPointerException("protocols == null");
        }
        this.e = com.mbridge.msdk.thrid.okhttp.internal.c.a(list);
        if (list2 == null) {
            throw new NullPointerException("connectionSpecs == null");
        }
        this.f = com.mbridge.msdk.thrid.okhttp.internal.c.a(list2);
        if (proxySelector == null) {
            throw new NullPointerException("proxySelector == null");
        }
        this.g = proxySelector;
        this.h = proxy;
        this.i = sSLSocketFactory;
        this.j = hostnameVerifier;
        this.k = eVar;
    }

    @Nullable
    public e a() {
        return this.k;
    }

    public List<i> b() {
        return this.f;
    }

    public m c() {
        return this.b;
    }

    @Nullable
    public HostnameVerifier d() {
        return this.j;
    }

    public List<u> e() {
        return this.e;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f4805a.equals(aVar.f4805a) && a(aVar);
    }

    @Nullable
    public Proxy f() {
        return this.h;
    }

    public b g() {
        return this.d;
    }

    public ProxySelector h() {
        return this.g;
    }

    public int hashCode() {
        int hashCode = (((((((((((this.f4805a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.b.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        Proxy proxy = this.h;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        e eVar = this.k;
        return hashCode4 + (eVar != null ? eVar.hashCode() : 0);
    }

    public SocketFactory i() {
        return this.c;
    }

    @Nullable
    public SSLSocketFactory j() {
        return this.i;
    }

    public q k() {
        return this.f4805a;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("Address{").append(this.f4805a.g()).append(":").append(this.f4805a.j());
        if (this.h != null) {
            append.append(", proxy=").append(this.h);
        } else {
            append.append(", proxySelector=").append(this.g);
        }
        append.append("}");
        return append.toString();
    }

    boolean a(a aVar) {
        return this.b.equals(aVar.b) && this.d.equals(aVar.d) && this.e.equals(aVar.e) && this.f.equals(aVar.f) && this.g.equals(aVar.g) && com.mbridge.msdk.thrid.okhttp.internal.c.a(this.h, aVar.h) && com.mbridge.msdk.thrid.okhttp.internal.c.a(this.i, aVar.i) && com.mbridge.msdk.thrid.okhttp.internal.c.a(this.j, aVar.j) && com.mbridge.msdk.thrid.okhttp.internal.c.a(this.k, aVar.k) && k().j() == aVar.k().j();
    }
}
