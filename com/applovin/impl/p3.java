package com.applovin.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class p3 {
    private static final Set c = new HashSet();
    private static final Map d = new HashMap();
    public static final p3 e;
    public static final p3 f;
    public static final p3 g;

    /* renamed from: a, reason: collision with root package name */
    private String f618a;
    private Set b;

    public enum a {
        SESSION("session"),
        INSTALL("install");


        /* renamed from: a, reason: collision with root package name */
        private final String f619a;

        a(String str) {
            this.f619a = str;
        }

        public String b() {
            return this.f619a;
        }
    }

    public interface b {
        Object a(Object obj);
    }

    static {
        a aVar = a.SESSION;
        e = a("ars", aVar, a.INSTALL);
        f = a("ar", aVar);
        g = a("ttdasi_ms", aVar);
    }

    private p3(String str, Set set) {
        this.f618a = str;
        this.b = set;
    }

    protected boolean a(Object obj) {
        return obj instanceof p3;
    }

    public Set b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p3)) {
            return false;
        }
        p3 p3Var = (p3) obj;
        if (!p3Var.a(this)) {
            return false;
        }
        String a2 = a();
        String a3 = p3Var.a();
        if (a2 != null ? !a2.equals(a3) : a3 != null) {
            return false;
        }
        Set b2 = b();
        Set b3 = p3Var.b();
        return b2 != null ? b2.equals(b3) : b3 == null;
    }

    public int hashCode() {
        String a2 = a();
        int hashCode = a2 == null ? 43 : a2.hashCode();
        Set b2 = b();
        return ((hashCode + 59) * 59) + (b2 != null ? b2.hashCode() : 43);
    }

    public String toString() {
        return this.f618a;
    }

    public String a() {
        return this.f618a;
    }

    private static p3 a(String str, a... aVarArr) {
        Set set = c;
        if (!set.contains(str)) {
            p3 p3Var = new p3(str, new HashSet(Arrays.asList(aVarArr)));
            set.add(str);
            d.put(str, p3Var);
            return p3Var;
        }
        throw new IllegalArgumentException("Key has already been used: " + str);
    }

    public boolean a(a aVar) {
        return this.b.contains(aVar);
    }

    public static p3 a(String str) {
        return (p3) d.get(str);
    }
}
