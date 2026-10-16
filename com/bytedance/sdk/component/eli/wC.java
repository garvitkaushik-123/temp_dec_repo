package com.bytedance.sdk.component.eli;

import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
class wC {
    private nlS eli;

    static wC eli(nlS nls) {
        return new wC(nls);
    }

    private wC(nlS nls) {
        this.eli = nls;
    }

    <T> T eli(String str, Type type) throws JSONException {
        eli(str);
        if (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) {
            return (T) new JSONObject(str);
        }
        return (T) this.eli.eli(str, type);
    }

    <T> String eli(T t) {
        String obj;
        if (t == null) {
            return "{}";
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            obj = t.toString();
        } else {
            obj = this.eli.eli(t);
        }
        eli(obj);
        return obj;
    }

    private static void eli(String str) {
        if (str.startsWith("{") && str.endsWith("}")) {
            return;
        }
        FC.eli(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(String.valueOf(str))));
    }
}
