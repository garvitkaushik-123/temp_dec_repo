package com.ironsource;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class B9 {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f2805a;
    private String b;
    private String c;
    private boolean d;
    private C3044d8 e;
    private Map<String, String> f;
    private InterfaceC3268qc g;
    private String h;
    private boolean i;
    private boolean j;

    B9(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, String str3, Map<String, String> map, InterfaceC3268qc interfaceC3268qc, C3044d8 c3044d8) {
        this.b = str;
        this.c = str2;
        this.f2805a = z;
        this.d = z2;
        this.f = map;
        this.g = interfaceC3268qc;
        this.e = c3044d8;
        this.i = z3;
        this.j = z4;
        this.h = str3;
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("instanceId", this.b);
        hashMap.put("instanceName", this.c);
        hashMap.put("rewarded", Boolean.toString(this.f2805a));
        hashMap.put("inAppBidding", Boolean.toString(this.d));
        hashMap.put("isOneFlow", Boolean.toString(this.i));
        hashMap.put(C3040d4.r, String.valueOf(2));
        C3044d8 c3044d8 = this.e;
        hashMap.put("width", c3044d8 != null ? Integer.toString(c3044d8.c()) : "0");
        C3044d8 c3044d82 = this.e;
        hashMap.put("height", c3044d82 != null ? Integer.toString(c3044d82.a()) : "0");
        C3044d8 c3044d83 = this.e;
        hashMap.put("label", c3044d83 != null ? c3044d83.b() : "");
        hashMap.put(C3040d4.v, Boolean.toString(i()));
        if (this.j) {
            hashMap.put("isMultipleAdObjects", "true");
        }
        String str = this.h;
        if (str != null) {
            hashMap.put("adUnitId", str);
        }
        Map<String, String> map = this.f;
        if (map != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public final InterfaceC3268qc b() {
        return this.g;
    }

    public String c() {
        return this.h;
    }

    public Map<String, String> d() {
        return this.f;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.c.replaceAll("IronSource_", "");
    }

    public String g() {
        return this.c;
    }

    public C3044d8 h() {
        return this.e;
    }

    public boolean i() {
        return h() != null && h().d();
    }

    public boolean j() {
        return this.d;
    }

    public boolean k() {
        return j() || m();
    }

    public boolean l() {
        return this.j;
    }

    public boolean m() {
        return this.i;
    }

    public boolean n() {
        return this.f2805a;
    }

    public void a(InterfaceC3268qc interfaceC3268qc) {
        this.g = interfaceC3268qc;
    }

    public void a(String str) {
        this.h = str;
    }
}
