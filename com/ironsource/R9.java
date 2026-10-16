package com.ironsource;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.ironsource.C3230o8;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class R9 {
    private static final String b = "R9";
    private static final String c = "supersonic_shared_preferen";
    private static final String d = "version";
    private static final String e = "back_button_state";
    private static final String f = "search_keys";
    private static final String g = "^\\d+_\\d+$";
    private static R9 h;

    /* renamed from: a, reason: collision with root package name */
    private SharedPreferences f3028a;

    private R9(Context context) {
        this.f3028a = context.getSharedPreferences("supersonic_shared_preferen", 0);
    }

    public static synchronized R9 a(Context context) {
        R9 r9;
        synchronized (R9.class) {
            if (h == null) {
                h = new R9(context);
            }
            r9 = h;
        }
        return r9;
    }

    public static synchronized R9 e() {
        R9 r9;
        synchronized (R9.class) {
            r9 = h;
        }
        return r9;
    }

    public C3230o8.a b() {
        int parseInt = Integer.parseInt(this.f3028a.getString(e, "2"));
        return parseInt == 0 ? C3230o8.a.None : parseInt == 1 ? C3230o8.a.Device : parseInt == 2 ? C3230o8.a.Controller : C3230o8.a.Controller;
    }

    public void c(String str) {
        SharedPreferences.Editor edit = this.f3028a.edit();
        edit.putString(e, str);
        edit.apply();
    }

    public List<String> d() {
        String string = this.f3028a.getString(f, null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            Nd nd = new Nd(string);
            if (nd.a(C3040d4.h.R)) {
                try {
                    arrayList.addAll(nd.a((JSONArray) nd.b(C3040d4.h.R)));
                    return arrayList;
                } catch (JSONException e2) {
                    C3260q4.d().a(e2);
                    IronLog.INTERNAL.error(e2.toString());
                }
            }
        }
        return arrayList;
    }

    public void e(String str) {
        SharedPreferences.Editor edit = this.f3028a.edit();
        edit.putString(f, str);
        edit.apply();
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor edit = this.f3028a.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public String c() {
        return this.f3028a.getString("version", Y1.f);
    }

    public String a(String str) {
        String string = this.f3028a.getString(str, null);
        return string != null ? string : "{}";
    }

    private boolean b(String str) {
        return str.matches(g);
    }

    public boolean a(String str, String str2, String str3) {
        String string = this.f3028a.getString("ssaUserData", null);
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.isNull(str2)) {
                return false;
            }
            JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
            if (jSONObject2.isNull(str3)) {
                return false;
            }
            jSONObject2.getJSONObject(str3).put("timestamp", str);
            SharedPreferences.Editor edit = this.f3028a.edit();
            edit.putString("ssaUserData", jSONObject.toString());
            edit.apply();
            return true;
        } catch (JSONException e2) {
            C3260q4.d().a(e2);
            IronLog.INTERNAL.error(e2.toString());
            return false;
        }
    }

    public void d(String str) {
        if (c().equalsIgnoreCase(str)) {
            return;
        }
        SharedPreferences.Editor edit = this.f3028a.edit();
        edit.putString("version", str);
        edit.apply();
    }

    public ArrayList<String> a() {
        ArrayList<String> arrayList = new ArrayList<>();
        String[] strArr = (String[]) this.f3028a.getAll().keySet().toArray(new String[0]);
        SharedPreferences.Editor edit = this.f3028a.edit();
        for (String str : strArr) {
            if (b(str)) {
                arrayList.add(str);
                edit.remove(str);
            }
        }
        edit.apply();
        return arrayList;
    }
}
