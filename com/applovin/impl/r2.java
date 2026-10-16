package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class r2 implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    private final String f643a;
    private final String b;
    private final boolean c;
    private final b3 d;

    r2(String str, String str2, boolean z, b3 b3Var) {
        this.f643a = str;
        this.b = str2;
        this.c = z;
        this.d = b3Var;
    }

    public String a() {
        return this.b;
    }

    public List b() {
        List l = this.d.l();
        return (l == null || l.isEmpty()) ? Collections.singletonList(this.f643a) : l;
    }

    public String c() {
        return this.f643a;
    }

    public b3 d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            r2 r2Var = (r2) obj;
            String str = this.f643a;
            if (str == null ? r2Var.f643a != null : !str.equals(r2Var.f643a)) {
                return false;
            }
            String str2 = this.b;
            if (str2 == null ? r2Var.b != null : !str2.equals(r2Var.b)) {
                return false;
            }
            if (this.c == r2Var.c) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        String str = this.f643a;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.c ? 1 : 0);
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(r2 r2Var) {
        return this.b.compareToIgnoreCase(r2Var.b);
    }
}
