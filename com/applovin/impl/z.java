package com.applovin.impl;

import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private final Map f807a;
    private final List b;

    public z(Map map, List list) {
        this.f807a = map;
        this.b = list;
    }

    protected boolean a(Object obj) {
        return obj instanceof z;
    }

    public List b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        if (!zVar.a(this)) {
            return false;
        }
        Map a2 = a();
        Map a3 = zVar.a();
        if (a2 != null ? !a2.equals(a3) : a3 != null) {
            return false;
        }
        List b = b();
        List b2 = zVar.b();
        return b != null ? b.equals(b2) : b2 == null;
    }

    public int hashCode() {
        Map a2 = a();
        int hashCode = a2 == null ? 43 : a2.hashCode();
        List b = b();
        return ((hashCode + 59) * 59) + (b != null ? b.hashCode() : 43);
    }

    public String toString() {
        return "AppAdsTxt(domainEntries=" + a() + ", invalidEntries=" + b() + ")";
    }

    public Map a() {
        return this.f807a;
    }
}
