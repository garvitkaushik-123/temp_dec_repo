package com.ironsource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class Nd {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f2969a;

    public Nd() {
        this.f2969a = new JSONObject();
    }

    private void f(String str) {
        try {
            this.f2969a = new JSONObject(str);
        } catch (Exception e) {
            C3260q4.d().a(e);
            this.f2969a = new JSONObject();
        }
    }

    public JSONObject a() {
        return this.f2969a;
    }

    public Object b(String str) {
        try {
            return a().get(str);
        } catch (JSONException e) {
            C3260q4.d().a(e);
            return null;
        }
    }

    public boolean c(String str) {
        return this.f2969a.optBoolean(str);
    }

    public String d(String str) {
        return this.f2969a.optString(str, null);
    }

    public boolean e(String str) {
        return a().isNull(str);
    }

    public String toString() {
        JSONObject jSONObject = this.f2969a;
        return jSONObject == null ? "" : jSONObject.toString();
    }

    public boolean a(String str) {
        return a().has(str);
    }

    public Nd(String str) {
        f(str);
    }

    public String a(String str, String str2) {
        return this.f2969a.optString(str, str2);
    }

    public static Object b(Object obj) throws JSONException {
        if (obj instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            Map map = (Map) obj;
            for (Object obj2 : map.keySet()) {
                if (obj2 != null) {
                    jSONObject.put(obj2.toString(), b(map.get(obj2)));
                }
            }
            return jSONObject;
        }
        if (!(obj instanceof Iterable)) {
            return obj;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator it = ((Iterable) obj).iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }

    public int a(String str, int i) {
        return this.f2969a.optInt(str, i);
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject.names() == null;
    }

    public List a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(a(jSONArray.get(i)));
        }
        return arrayList;
    }

    public void a(String str, JSONObject jSONObject) {
        try {
            this.f2969a.put(str, jSONObject);
        } catch (Exception e) {
            C3260q4.d().a(e);
        }
    }

    private Object a(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        if (obj instanceof JSONObject) {
            return b((JSONObject) obj);
        }
        return obj instanceof JSONArray ? a((JSONArray) obj) : obj;
    }

    public void b(String str, String str2) {
        try {
            this.f2969a.put(str, str2);
        } catch (Exception e) {
            C3260q4.d().a(e);
        }
    }

    private Map<String, Object> b(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, a(jSONObject.get(next)));
        }
        return hashMap;
    }
}
