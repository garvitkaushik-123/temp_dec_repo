package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class V9 {
    public static boolean a(String str) {
        try {
            new JSONObject(str);
            return true;
        } catch (JSONException unused) {
            return false;
        }
    }

    public static List<String> b(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        return arrayList;
    }

    public static JSONObject a(JSONObject... jSONObjectArr) {
        JSONObject jSONObject = new JSONObject();
        if (jSONObjectArr != null) {
            for (JSONObject jSONObject2 : jSONObjectArr) {
                if (jSONObject2 != null) {
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        try {
                            jSONObject.put(next, jSONObject2.get(next));
                        } catch (JSONException e) {
                            C3260q4.d().a(e);
                            IronLog.INTERNAL.error(e.toString());
                        }
                    }
                }
            }
        }
        return jSONObject;
    }

    public static Object b(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof JSONArray) && !(obj instanceof JSONObject) && !obj.equals(JSONObject.NULL)) {
            try {
                if (obj instanceof Collection) {
                    return new JSONArray((Collection) obj);
                }
                if (obj.getClass().isArray()) {
                    return new JSONArray((Collection) Arrays.asList(obj));
                }
                if (obj instanceof Map) {
                    return new JSONObject((Map) obj);
                }
                if (!(obj instanceof Boolean) && !(obj instanceof Byte) && !(obj instanceof Character) && !(obj instanceof Double) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof String)) {
                    if (obj instanceof Enum) {
                        return obj.toString();
                    }
                    if (obj.getClass().getPackage().getName().startsWith("java.")) {
                        return obj.toString();
                    }
                }
            } catch (Exception e) {
                C3260q4.d().a(e);
                return null;
            }
        }
        return obj;
    }

    public static Map<String, Object> a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    hashMap.put(next, a(jSONObject.get(next)));
                } catch (JSONException e) {
                    C3260q4.d().a(e);
                    IronLog.INTERNAL.error(String.format("Could not put value in map: %s, %s", next, e.getMessage()));
                }
            }
        }
        return hashMap;
    }

    public static List<Object> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                arrayList.add(a(jSONArray.get(i)));
            } catch (JSONException e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(String.format("Could not put value into list: %s", e.getMessage()));
            }
        }
        return arrayList;
    }

    private static Object a(Object obj) {
        if (obj instanceof JSONObject) {
            return a((JSONObject) obj);
        }
        return obj instanceof JSONArray ? a((JSONArray) obj) : obj;
    }

    public static JSONObject a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    jSONObject.put(entry.getKey(), b(entry.getValue()));
                } catch (JSONException e) {
                    C3260q4.d().a(e);
                    IronLog.INTERNAL.error(String.format("Could not map entry to object: %s, %s", entry.getKey(), entry.getValue()));
                }
            }
        }
        return jSONObject;
    }
}
