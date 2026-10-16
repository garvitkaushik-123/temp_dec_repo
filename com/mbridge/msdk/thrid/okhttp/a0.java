package com.mbridge.msdk.thrid.okhttp;

import com.ironsource.mediationsdk.logger.IronSourceError;
import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* compiled from: Route.java */
/* loaded from: classes6.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    final a f4806a;
    final Proxy b;
    final InetSocketAddress c;

    public a0(a aVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (aVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f4806a = aVar;
        this.b = proxy;
        this.c = inetSocketAddress;
    }

    public a a() {
        return this.f4806a;
    }

    public Proxy b() {
        return this.b;
    }

    public boolean c() {
        return this.f4806a.i != null && this.b.type() == Proxy.Type.HTTP;
    }

    public InetSocketAddress d() {
        return this.c;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        return a0Var.f4806a.equals(this.f4806a) && a0Var.b.equals(this.b) && a0Var.c.equals(this.c);
    }

    public int hashCode() {
        return ((((this.f4806a.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
    }

    public String toString() {
        return "Route{" + this.c + "}";
    }
}
