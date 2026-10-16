package com.ironsource;

/* renamed from: com.ironsource.d8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3044d8 {

    /* renamed from: a, reason: collision with root package name */
    private int f3252a;
    private int b;
    private String c;

    public C3044d8() {
        this.f3252a = 0;
        this.b = 0;
        this.c = "";
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.f3252a;
    }

    public boolean d() {
        return this.b > 0 && this.f3252a > 0;
    }

    public boolean e() {
        return this.b == 0 && this.f3252a == 0;
    }

    public String toString() {
        return this.c;
    }

    public C3044d8(int i, int i2, String str) {
        this.f3252a = i;
        this.b = i2;
        this.c = str;
    }
}
