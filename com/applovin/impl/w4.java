package com.applovin.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAdFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class w4 {

    /* renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.k f776a;
    protected final Context b;
    protected final SharedPreferences c;
    private final Map d = new HashMap();
    private final Object e = new Object();

    public w4(com.applovin.impl.sdk.k kVar) {
        this.f776a = kVar;
        Context o = com.applovin.impl.sdk.k.o();
        this.b = o;
        this.c = o.getSharedPreferences("com.applovin.sdk.1", 0);
        try {
            Class.forName(v4.class.getName());
            Class.forName(o3.class.getName());
        } catch (Throwable unused) {
        }
        d();
    }

    private void d() {
        String b = ((Boolean) y4.a(x4.i, Boolean.FALSE, com.applovin.impl.sdk.k.o())).booleanValue() ? "" : b();
        synchronized (this.e) {
            for (v4 v4Var : v4.c()) {
                try {
                    Object a2 = this.f776a.a(b + v4Var.b(), null, v4Var.a().getClass(), this.c);
                    if (a2 != null) {
                        this.d.put(v4Var.b(), a2);
                    }
                } catch (Throwable th) {
                    com.applovin.impl.sdk.o.c("SettingsManager", "Unable to load \"" + v4Var.b() + "\"", th);
                    this.f776a.E().a("SettingsManager", "initSettings", th);
                }
            }
        }
    }

    public Object a(v4 v4Var) {
        if (v4Var == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        synchronized (this.e) {
            Object obj = this.d.get(v4Var.b());
            if (obj == null) {
                return v4Var.a();
            }
            return v4Var.a(obj);
        }
    }

    public List b(v4 v4Var) {
        ArrayList arrayList = new ArrayList(6);
        Iterator it = c(v4Var).iterator();
        while (it.hasNext()) {
            arrayList.add(MaxAdFormat.formatFromString((String) it.next()));
        }
        return arrayList;
    }

    public List c(v4 v4Var) {
        return CollectionUtils.explode((String) a(v4Var));
    }

    public void e() {
        Boolean bool = (Boolean) y4.a(x4.i, Boolean.FALSE, com.applovin.impl.sdk.k.o());
        String b = b();
        synchronized (this.e) {
            SharedPreferences.Editor edit = this.c.edit();
            for (v4 v4Var : v4.c()) {
                Object obj = this.d.get(v4Var.b());
                if (obj != null) {
                    String b2 = v4Var.b();
                    this.f776a.a(b + v4Var.b(), obj, edit);
                    if (bool.booleanValue()) {
                        this.f776a.a(b2, obj, edit);
                    }
                }
            }
            if (((Boolean) this.f776a.a(v4.t6)).booleanValue()) {
                y4.a(edit);
            } else {
                edit.apply();
            }
        }
    }

    public boolean c() {
        return this.f776a.o0().isVerboseLoggingEnabled() || ((Boolean) a(v4.k)).booleanValue();
    }

    private String b() {
        return "com.applovin.sdk." + k7.f(this.f776a.j0()) + ".";
    }

    public void a(v4 v4Var, Object obj) {
        if (v4Var == null) {
            throw new IllegalArgumentException("No setting type specified");
        }
        if (obj != null) {
            synchronized (this.e) {
                this.d.put(v4Var.b(), obj);
            }
            return;
        }
        throw new IllegalArgumentException("No new value specified");
    }

    public void a(JSONObject jSONObject) {
        synchronized (this.e) {
            boolean booleanValue = JsonUtils.getBoolean(jSONObject, v4.v.b(), Boolean.FALSE).booleanValue();
            HashMap hashMap = booleanValue ? new HashMap() : null;
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && next.length() > 0) {
                    try {
                        v4 a2 = v4.a(next);
                        if (a2 != null) {
                            Object a3 = booleanValue ? a(a2) : null;
                            Object a4 = a(next, jSONObject, a2.a());
                            this.d.put(a2.b(), a4);
                            if (a2 == v4.w5) {
                                this.d.put(v4.x5.b(), Long.valueOf(System.currentTimeMillis()));
                            }
                            if (booleanValue && !a4.equals(a3)) {
                                hashMap.put(a2, a3);
                            }
                        }
                    } catch (JSONException e) {
                        com.applovin.impl.sdk.o.c("SettingsManager", "Unable to parse JSON settingsValues array", e);
                        this.f776a.E().a("SettingsManager", "loadSettingsException", e);
                    } catch (Throwable th) {
                        com.applovin.impl.sdk.o.c("SettingsManager", "Unable to convert setting object ", th);
                        this.f776a.E().a("SettingsManager", "loadSettingsThrowable", th);
                    }
                }
            }
            if (booleanValue && hashMap.size() > 0) {
                s2 s2Var = new s2();
                s2Var.a("========== UPDATED SETTINGS ==========");
                for (v4 v4Var : hashMap.keySet()) {
                    s2Var.a(v4Var.b(), a(v4Var) + " (" + hashMap.get(v4Var) + ")");
                }
                s2Var.a("========== END ==========");
                this.f776a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f776a.O().a("SettingsManager", s2Var.toString());
                }
            }
            y4.b(x4.i, (Boolean) a(v4.H6), com.applovin.impl.sdk.k.o());
        }
    }

    public void a() {
        synchronized (this.e) {
            this.d.clear();
        }
        this.f776a.a(this.c);
    }

    private static Object a(String str, JSONObject jSONObject, Object obj) {
        if (obj instanceof Boolean) {
            return Boolean.valueOf(jSONObject.getBoolean(str));
        }
        if (obj instanceof Float) {
            return Float.valueOf((float) jSONObject.getDouble(str));
        }
        if (obj instanceof Double) {
            return Double.valueOf(jSONObject.getDouble(str));
        }
        if (obj instanceof Integer) {
            return Integer.valueOf(jSONObject.getInt(str));
        }
        if (obj instanceof Long) {
            return Long.valueOf(jSONObject.getLong(str));
        }
        if (obj instanceof String) {
            return jSONObject.getString(str);
        }
        throw new RuntimeException("SDK Error: unknown value type: " + obj.getClass());
    }
}
