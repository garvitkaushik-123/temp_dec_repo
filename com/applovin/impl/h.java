package com.applovin.impl;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final int f467a;
    private final int b;
    private final int c;
    private final int d;

    public h(int i, int i2, int i3, int i4) {
        this.f467a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    protected boolean a(Object obj) {
        return obj instanceof h;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }

    public int d() {
        return this.f467a;
    }

    public Map e() {
        HashMap hashMap = new HashMap(4);
        hashMap.put("asr_num", Integer.valueOf(this.f467a));
        hashMap.put("air_num", Integer.valueOf(this.b));
        hashMap.put("fsr_num", Integer.valueOf(this.c));
        hashMap.put("fir_num", Integer.valueOf(this.d));
        return hashMap;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return hVar.a(this) && d() == hVar.d() && c() == hVar.c() && b() == hVar.b() && a() == hVar.a();
    }

    public int hashCode() {
        return ((((((d() + 59) * 59) + c()) * 59) + b()) * 59) + a();
    }

    public String toString() {
        return "AdRequestNumberInfo(adUnitSessionAdRequestNumber=" + d() + ", adUnitInstallAdRequestNumber=" + c() + ", adFormatSessionAdRequestNumber=" + b() + ", adFormatInstallAdRequestNumber=" + a() + ")";
    }

    public int a() {
        return this.d;
    }
}
