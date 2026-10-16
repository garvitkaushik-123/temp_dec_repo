package com.mbridge.msdk.mbbanner.common.data;

/* compiled from: BannerUnitData.java */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private String f4444a;
    private String b;
    private String c = "";
    private int d;
    private int e;

    public b(String str, String str2, int i, int i2) {
        this.f4444a = str;
        this.b = str2;
        this.d = i;
        this.e = i2;
    }

    public void a(int i) {
        this.d = i;
    }

    public void b(String str) {
        this.b = str;
    }

    public int c() {
        return this.d;
    }

    public String d() {
        return this.b;
    }

    public String a() {
        return this.c;
    }

    public int b() {
        return this.e;
    }

    public void a(String str) {
        this.c = str;
    }
}
