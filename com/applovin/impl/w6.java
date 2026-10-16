package com.applovin.impl;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.impl.sdk.utils.StringUtils;
import com.ironsource.Hd;

/* loaded from: classes2.dex */
public class w6 implements SharedPreferences.OnSharedPreferenceChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f777a;
    private final SharedPreferences b;
    private Integer c;
    private Integer d;
    private Integer e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;

    public w6(com.applovin.impl.sdk.k kVar) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(com.applovin.impl.sdk.k.o());
        this.b = defaultSharedPreferences;
        this.f777a = kVar;
        defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        this.c = a(x4.t.a());
        this.d = a(x4.u.a());
        this.e = h();
        this.f = (String) y4.a(x4.w, (Object) null, defaultSharedPreferences, false);
        this.g = (String) y4.a(x4.x, (Object) null, defaultSharedPreferences, false);
        this.h = (String) y4.a(x4.y, (Object) null, defaultSharedPreferences, false);
        this.i = (String) y4.a(x4.A, (Object) null, defaultSharedPreferences, false);
        this.j = (String) y4.a(x4.C, (Object) null, defaultSharedPreferences, false);
        b(this.g);
    }

    private Integer h() {
        String a2 = x4.v.a();
        if (this.b.contains(a2)) {
            Integer num = (Integer) y4.a(a2, null, Integer.class, this.b, false);
            if (num != null) {
                if (num.intValue() == 1 || num.intValue() == 0) {
                    return num;
                }
                this.f777a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f777a.O().b("TcfManager", "Integer value (" + num + ") for " + a2 + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
            Long l = (Long) y4.a(a2, null, Long.class, this.b, false);
            if (l != null) {
                if (l.longValue() == 1 || l.longValue() == 0) {
                    return Integer.valueOf(l.intValue());
                }
                this.f777a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f777a.O().b("TcfManager", "Long value (" + l + ") for " + a2 + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
            Boolean bool = (Boolean) y4.a(a2, null, Boolean.class, this.b, false);
            if (bool != null) {
                return Integer.valueOf(bool.booleanValue() ? 1 : 0);
            }
            String str = (String) y4.a(a2, null, String.class, this.b, false);
            if (str != null) {
                if ("1".equals(str) || "true".equals(str)) {
                    return 1;
                }
                if ("0".equals(str) || "false".equals(str)) {
                    return 0;
                }
                this.f777a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f777a.O().b("TcfManager", "String value (" + str + ") for " + a2 + " is invalid - setting GDPR Applies to null");
                }
                return null;
            }
        }
        return null;
    }

    public Boolean a(int i) {
        return z6.a(i, this.g);
    }

    public boolean b() {
        return z6.a(this.g);
    }

    public String c() {
        return this.g;
    }

    public String d() {
        return u6.a(this.c);
    }

    public Integer e() {
        return this.c;
    }

    public Integer f() {
        return this.d;
    }

    public Integer g() {
        return this.e;
    }

    public String i() {
        return a("CMP Name", d()) + a("CMP SDK ID", this.c) + a("CMP SDK Version", this.d) + a(x4.v.a(), this.e) + a(x4.w.a(), this.f) + a(x4.x.a(), this.g);
    }

    public String j() {
        return this.f;
    }

    public String k() {
        return this.h;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        if (str == null) {
            this.f777a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f777a.O().a("TcfManager", "SharedPreferences are cleared - setting all stored TC data to null");
            }
            a();
            return;
        }
        if (str.equals(x4.t.a())) {
            this.c = a(str);
            this.f777a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f777a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.c);
            }
            this.f777a.S0();
            return;
        }
        if (str.equals(x4.u.a())) {
            this.d = a(str);
            this.f777a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f777a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.d);
                return;
            }
            return;
        }
        if (str.equals(x4.v.a())) {
            this.e = h();
            this.f777a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f777a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.e);
                return;
            }
            return;
        }
        if (str.equals(x4.w.a())) {
            this.f = (String) y4.a(str, (Object) null, String.class, sharedPreferences);
            this.f777a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f777a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.f);
            }
            this.f777a.S0();
            return;
        }
        if (str.equals(x4.x.a())) {
            this.g = (String) y4.a(str, (Object) null, String.class, sharedPreferences);
            this.f777a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f777a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.g);
            }
            b(this.g);
            return;
        }
        if (str.equals(x4.y.a())) {
            this.h = (String) y4.a(str, (Object) null, String.class, sharedPreferences);
            this.f777a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f777a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.h);
                return;
            }
            return;
        }
        if (str.equals(x4.z.a())) {
            String str2 = (String) y4.a(str, (Object) null, String.class, sharedPreferences);
            this.f777a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f777a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str2);
                return;
            }
            return;
        }
        if (str.equals(x4.A.a())) {
            this.i = (String) y4.a(str, (Object) null, String.class, sharedPreferences);
            this.f777a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f777a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.i);
                return;
            }
            return;
        }
        if (str.equals(x4.B.a())) {
            String str3 = (String) y4.a(str, (Object) null, String.class, sharedPreferences);
            this.f777a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f777a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str3);
                return;
            }
            return;
        }
        if (str.equals(x4.C.a())) {
            this.j = (String) y4.a(str, (Object) null, String.class, sharedPreferences);
            this.f777a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f777a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + this.j);
                return;
            }
            return;
        }
        if (str.contains("IABTCF_PublisherRestrictions")) {
            String str4 = (String) y4.a(str, (Object) null, String.class, sharedPreferences);
            this.f777a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f777a.O().a("TcfManager", "SharedPreferences entry updated - key: " + str + ", value: " + str4);
            }
        }
    }

    private Integer a(String str) {
        if (this.b.contains(str)) {
            Integer num = (Integer) y4.a(str, null, Integer.class, this.b, false);
            if (num != null) {
                return num;
            }
            Long l = (Long) y4.a(str, null, Long.class, this.b, false);
            if (l != null && l.longValue() >= -2147483648L && l.longValue() <= 2147483647L) {
                return Integer.valueOf(l.intValue());
            }
            String str2 = (String) y4.a(str, null, String.class, this.b, false);
            if (str2 != null) {
                if (StringUtils.isNumeric(str2)) {
                    return Integer.valueOf(Integer.parseInt(str2));
                }
                this.f777a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f777a.O().b("TcfManager", "String value (" + str2 + ") for " + str + " is not numeric - storing value as null");
                }
            }
        }
        return null;
    }

    public Boolean b(int i) {
        String str = this.i;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(z6.a(str, i - 1));
    }

    public Boolean c(int i) {
        String str = this.j;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(z6.a(str, i - 1));
    }

    public Boolean d(int i) {
        String str = this.h;
        if (str == null) {
            return null;
        }
        return Boolean.valueOf(z6.a(str, i - 1));
    }

    private void b(String str) {
        this.f777a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f777a.O().a("TcfManager", "Attempting to update consent from Additional Consent string: " + str);
        }
        Boolean a2 = z6.a(Hd.c.e, str);
        if (a2 != null) {
            if (a2.booleanValue()) {
                this.f777a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f777a.O().a("TcfManager", "Found AppLovin ID in the list of consented ATP IDs - setting user consent to true");
                }
                p0.b(true, com.applovin.impl.sdk.k.o());
            } else {
                this.f777a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f777a.O().a("TcfManager", "Could not find AppLovin ID in the list of consented ATP IDs - setting user consent to false");
                }
                p0.b(false, com.applovin.impl.sdk.k.o());
            }
            this.f777a.S0();
            return;
        }
        this.f777a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f777a.O().a("TcfManager", "AC string is not valid or AppLovin was not listed on the CMP flow - no consent update");
        }
    }

    private void a() {
        this.c = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    private String a(String str, Object obj) {
        return "\n" + str + " - " + (obj != null ? obj.toString() : "No value set");
    }
}
