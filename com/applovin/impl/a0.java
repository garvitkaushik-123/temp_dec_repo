package com.applovin.impl;

/* loaded from: classes2.dex */
public class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final String f358a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final boolean g;

    public a0(String str, int i) {
        this.e = str;
        this.f = i;
        String[] split = str.split(",");
        boolean z = split.length == 3 || split.length == 4;
        this.g = z;
        if (z) {
            this.f358a = a(split[0]);
            this.b = a(split[1]);
            this.c = a(split[2]);
            this.d = split.length == 4 ? a(split[3]) : "";
            return;
        }
        this.f358a = "";
        this.b = "";
        this.c = "";
        this.d = "";
    }

    protected boolean a(Object obj) {
        return obj instanceof a0;
    }

    public String b() {
        return this.f358a;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.e;
    }

    public String e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a0)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        if (!a0Var.a((Object) this)) {
            return false;
        }
        String b = b();
        String b2 = a0Var.b();
        if (b != null ? !b.equals(b2) : b2 != null) {
            return false;
        }
        String c = c();
        String c2 = a0Var.c();
        if (c != null ? !c.equals(c2) : c2 != null) {
            return false;
        }
        String e = e();
        String e2 = a0Var.e();
        if (e != null ? !e.equals(e2) : e2 != null) {
            return false;
        }
        String a2 = a();
        String a3 = a0Var.a();
        return a2 != null ? a2.equals(a3) : a3 == null;
    }

    public int f() {
        return this.f;
    }

    public boolean g() {
        return this.f358a.equals("applovin.com");
    }

    public boolean h() {
        return this.g;
    }

    public int hashCode() {
        String b = b();
        int hashCode = b == null ? 43 : b.hashCode();
        String c = c();
        int hashCode2 = ((hashCode + 59) * 59) + (c == null ? 43 : c.hashCode());
        String e = e();
        int hashCode3 = (hashCode2 * 59) + (e == null ? 43 : e.hashCode());
        String a2 = a();
        return (hashCode3 * 59) + (a2 != null ? a2.hashCode() : 43);
    }

    public String toString() {
        return "AppAdsTxtEntry(domainName=" + b() + ", publisherId=" + c() + ", relationship=" + e() + ", certificateAuthorityId=" + a() + ", rawValue=" + d() + ", rowNumber=" + f() + ", valid=" + h() + ")";
    }

    public String a() {
        return this.d;
    }

    public boolean a(a0 a0Var) {
        if (!a0Var.b().equals(this.f358a) || !a0Var.c().equals(this.b) || !a0Var.e().equals(this.c)) {
            return false;
        }
        if (a0Var.a().equals("")) {
            return true;
        }
        return a0Var.a().equals(this.d);
    }

    private String a(String str) {
        return str.replace((char) 173, ' ').trim();
    }

    public a0(String str) {
        this(str, -1);
    }
}
