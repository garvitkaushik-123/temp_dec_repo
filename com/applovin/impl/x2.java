package com.applovin.impl;

import com.applovin.mediation.MaxAdFormat;
import java.util.Map;

/* loaded from: classes2.dex */
public class x2 {

    /* renamed from: a, reason: collision with root package name */
    private final String f781a;
    private final MaxAdFormat b;
    private final Map c;
    private final Map d;
    private final Map e;
    private final h f;

    public x2(String str, MaxAdFormat maxAdFormat, Map map, Map map2, Map map3, h hVar) {
        this.f781a = str;
        this.b = maxAdFormat;
        this.c = map;
        this.d = map2;
        this.e = map3;
        this.f = hVar;
    }

    protected boolean a(Object obj) {
        return obj instanceof x2;
    }

    public String b() {
        return this.f781a;
    }

    public Map c() {
        return this.e;
    }

    public Map d() {
        return this.d;
    }

    public Map e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x2)) {
            return false;
        }
        x2 x2Var = (x2) obj;
        if (!x2Var.a(this)) {
            return false;
        }
        String b = b();
        String b2 = x2Var.b();
        if (b != null ? !b.equals(b2) : b2 != null) {
            return false;
        }
        MaxAdFormat a2 = a();
        MaxAdFormat a3 = x2Var.a();
        if (a2 != null ? !a2.equals(a3) : a3 != null) {
            return false;
        }
        Map e = e();
        Map e2 = x2Var.e();
        if (e != null ? !e.equals(e2) : e2 != null) {
            return false;
        }
        Map d = d();
        Map d2 = x2Var.d();
        if (d != null ? !d.equals(d2) : d2 != null) {
            return false;
        }
        Map c = c();
        Map c2 = x2Var.c();
        if (c != null ? !c.equals(c2) : c2 != null) {
            return false;
        }
        h f = f();
        h f2 = x2Var.f();
        return f != null ? f.equals(f2) : f2 == null;
    }

    public h f() {
        return this.f;
    }

    public int hashCode() {
        String b = b();
        int hashCode = b == null ? 43 : b.hashCode();
        MaxAdFormat a2 = a();
        int hashCode2 = ((hashCode + 59) * 59) + (a2 == null ? 43 : a2.hashCode());
        Map e = e();
        int hashCode3 = (hashCode2 * 59) + (e == null ? 43 : e.hashCode());
        Map d = d();
        int hashCode4 = (hashCode3 * 59) + (d == null ? 43 : d.hashCode());
        Map c = c();
        int hashCode5 = (hashCode4 * 59) + (c == null ? 43 : c.hashCode());
        h f = f();
        return (hashCode5 * 59) + (f != null ? f.hashCode() : 43);
    }

    public String toString() {
        return "MediatedAdRequestParameters(adUnitId=" + b() + ", adFormat=" + a() + ")";
    }

    public MaxAdFormat a() {
        return this.b;
    }
}
