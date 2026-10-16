package com.ironsource;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class V4 {
    public static final int h = 0;
    public static final int i = 1;
    public static final int j = 2;
    public static final int k = 3;
    public static final int l = -1;

    /* renamed from: a, reason: collision with root package name */
    private String f3088a;
    private String b;
    private int c;
    private Map<String, String> d;
    private int e;
    private boolean f;
    private B9 g;

    public V4(String str, String str2, Map<String, String> map, InterfaceC3268qc interfaceC3268qc) {
        this.c = -1;
        this.b = str;
        this.f3088a = str2;
        this.d = map;
        this.e = 0;
        this.f = false;
        this.g = null;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public synchronized void b(int i2) {
        this.e = i2;
    }

    public B9 c() {
        return this.g;
    }

    public boolean d() {
        return this.f;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.f3088a;
    }

    public Map<String, String> g() {
        return this.d;
    }

    public String h() {
        return this.b;
    }

    public InterfaceC3268qc i() {
        if (this.g != null) {
            return c().b();
        }
        return null;
    }

    public int j() {
        return this.c;
    }

    public boolean k() {
        Map<String, String> map = this.d;
        if (map == null || !map.containsKey("rewarded")) {
            return false;
        }
        return Boolean.parseBoolean(this.d.get("rewarded"));
    }

    public boolean a(int i2) {
        return this.c == i2;
    }

    public Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("demandSourceId", this.b);
        hashMap.put("demandSourceName", this.f3088a);
        Map<String, String> map = this.d;
        if (map != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public void c(int i2) {
        this.c = i2;
    }

    public void a() {
        Map<String, String> map = this.d;
        if (map != null) {
            map.clear();
        }
        this.d = null;
    }

    public V4(B9 b9) {
        this(b9.e(), b9.g(), b9.a(), b9.b());
        this.g = b9;
    }
}
