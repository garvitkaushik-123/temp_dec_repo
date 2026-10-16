package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* compiled from: SameOptimizedController.java */
/* loaded from: classes6.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    private final Object f4378a;
    private final Object b;
    private final Object c;
    private final Object d;
    public volatile JSONObject e;
    private String f;
    private volatile ConcurrentHashMap<String, Boolean> g;
    private volatile ConcurrentHashMap<String, Integer> h;
    private volatile ConcurrentHashMap<String, String> i;
    private volatile com.mbridge.msdk.setting.g j;

    /* compiled from: SameOptimizedController.java */
    private static final class b {

        /* renamed from: a, reason: collision with root package name */
        private static final r0 f4379a = new r0();
    }

    public static r0 a() {
        return b.f4379a;
    }

    private static Integer b(String str, ConcurrentHashMap<String, Integer> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private static String c(String str, ConcurrentHashMap<String, String> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private ConcurrentHashMap<String, String> d() {
        synchronized (this.b) {
            if (this.i == null) {
                this.i = new ConcurrentHashMap<>();
            }
        }
        return this.i;
    }

    private boolean e() {
        return this.j.D() == 1;
    }

    private r0() {
        this.f4378a = new Object();
        this.b = new Object();
        this.c = new Object();
        this.d = new Object();
    }

    private int a(String str, String str2, int i) {
        if (!a(true)) {
            try {
                String optString = this.e.optString(str, "");
                if (!TextUtils.isEmpty(optString)) {
                    String a2 = j0.a(optString);
                    if (!TextUtils.isEmpty(a2)) {
                        return new JSONObject(a2).optInt(str2, i);
                    }
                }
            } catch (Exception unused) {
            }
        }
        return i;
    }

    private ConcurrentHashMap<String, Integer> c() {
        synchronized (this.f4378a) {
            if (this.h == null) {
                this.h = new ConcurrentHashMap<>();
            }
        }
        return this.h;
    }

    public int b(String str, int i) {
        Integer valueOf;
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        ConcurrentHashMap<String, Integer> c = c();
        Integer b2 = b(str, c);
        if (b2 != null) {
            return b2.intValue();
        }
        try {
            valueOf = Integer.valueOf(a(str, i));
        } catch (Exception unused) {
            valueOf = Integer.valueOf(i);
        }
        c.put(str, valueOf);
        return valueOf.intValue();
    }

    private int a(String str, int i) {
        if (!a(true)) {
            try {
                return this.e.optInt(str, i);
            } catch (Exception unused) {
            }
        }
        return i;
    }

    public String b(String str, String str2, boolean z) {
        String str3;
        String c;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        ConcurrentHashMap<String, String> d = d();
        if (z && (c = c(str, d)) != null) {
            return c;
        }
        try {
            str3 = a(str, str2, z);
        } catch (Exception unused) {
            str3 = str2;
        }
        d.put(str, str3);
        return str3;
    }

    private String a(String str, String str2, boolean z) {
        if (!a(z)) {
            try {
                return this.e.optString(str, str2);
            } catch (Exception unused) {
            }
        }
        return str2;
    }

    public boolean a(String str, boolean z) {
        try {
            return b(str, z, true);
        } catch (Exception unused) {
            return z;
        }
    }

    private static Boolean a(String str, ConcurrentHashMap<String, Boolean> concurrentHashMap) {
        try {
            return concurrentHashMap.get(str);
        } catch (Exception unused) {
            return null;
        }
    }

    private boolean a(String str, boolean z, boolean z2) {
        if (!a(z2)) {
            try {
                return this.e.optInt(str, z ? 1 : 0) != 0;
            } catch (Exception unused) {
            }
        }
        return z;
    }

    private boolean a(boolean z) {
        synchronized (this.d) {
            if (this.j == null || e() || !z) {
                try {
                    if (TextUtils.isEmpty(this.f)) {
                        String b2 = com.mbridge.msdk.foundation.controller.c.m().b();
                        this.f = b2;
                        if (TextUtils.isEmpty(b2)) {
                            this.f = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(MBridgeConstans.APP_ID);
                        }
                    }
                    this.j = com.mbridge.msdk.setting.h.b().b(this.f);
                } catch (Exception unused) {
                    this.j = null;
                }
            }
            if (this.j != null) {
                this.e = this.j.j0();
            }
        }
        return this.j == null || this.e == null;
    }

    public int b(String str, String str2, int i) {
        Integer valueOf;
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                String str3 = str + "_" + str2;
                ConcurrentHashMap<String, Integer> c = c();
                Integer b2 = b(str3, c);
                if (b2 != null) {
                    return b2.intValue();
                }
                try {
                    valueOf = Integer.valueOf(a(str, str2, i));
                } catch (Exception unused) {
                    valueOf = Integer.valueOf(i);
                }
                c.put(str3, valueOf);
                return valueOf.intValue();
            }
            return b(str2, i);
        } catch (Exception unused2) {
            return i;
        }
    }

    public boolean b(String str, boolean z, boolean z2) {
        Boolean valueOf;
        Boolean a2;
        if (TextUtils.isEmpty(str)) {
            return z;
        }
        ConcurrentHashMap<String, Boolean> b2 = b();
        if (z2 && (a2 = a(str, b2)) != null) {
            return a2.booleanValue();
        }
        try {
            valueOf = Boolean.valueOf(a(str, z, z2));
        } catch (Exception unused) {
            valueOf = Boolean.valueOf(z);
        }
        b2.put(str, valueOf);
        return valueOf.booleanValue();
    }

    private ConcurrentHashMap<String, Boolean> b() {
        synchronized (this.c) {
            if (this.g == null) {
                this.g = new ConcurrentHashMap<>();
            }
        }
        return this.g;
    }
}
