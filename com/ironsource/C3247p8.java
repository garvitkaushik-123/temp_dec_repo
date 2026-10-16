package com.ironsource;

/* renamed from: com.ironsource.p8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3247p8 {
    public static final int c = 1001;

    /* renamed from: a, reason: collision with root package name */
    private String f3636a;
    private int b;

    public C3247p8(int i, String str) {
        this.b = i;
        this.f3636a = str == null ? "" : str;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.f3636a;
    }

    public String toString() {
        return "error - code:" + this.b + ", message:" + this.f3636a;
    }
}
