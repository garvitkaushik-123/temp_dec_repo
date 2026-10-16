package com.ironsource;

import android.content.Context;
import com.ironsource.N6;
import com.ironsource.environment.ContextProvider;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class P6 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2992a = "adunit_data";

    public JSONObject a(List<String> list) throws JSONException {
        return a(ContextProvider.getInstance().getApplicationContext(), list);
    }

    public JSONObject a(Context context, String[] strArr) throws JSONException {
        return a(a(O6.b().b(context)), strArr);
    }

    public JSONObject a(List<String> list, N6.a aVar) throws JSONException {
        return a(a(ContextProvider.getInstance().getApplicationContext(), aVar), (String[]) list.toArray(new String[list.size()]));
    }

    private JSONObject a(Context context, List<String> list) throws JSONException {
        return a(a(O6.b().b(context)), (String[]) list.toArray(new String[list.size()]));
    }

    public JSONObject a(String[] strArr) throws JSONException {
        return a(a(O6.b().b(ContextProvider.getInstance().getApplicationContext())), strArr);
    }

    private JSONObject a(Context context, N6.a aVar) throws JSONException {
        String name = aVar.name();
        JSONObject b = O6.b().b(context);
        JSONObject optJSONObject = b.optJSONObject(f2992a);
        JSONObject a2 = a(b);
        if (optJSONObject != null && optJSONObject.optJSONObject(name) != null) {
            JSONObject jSONObject = optJSONObject.getJSONObject(name);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a2.putOpt(next, jSONObject.opt(next));
            }
        }
        return a2;
    }

    private JSONObject a(JSONObject jSONObject, String[] strArr) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        for (String str : strArr) {
            if (jSONObject.has(str)) {
                jSONObject2.put(str, jSONObject.opt(str));
            }
        }
        return jSONObject2;
    }

    private JSONObject a(JSONObject jSONObject) {
        jSONObject.remove(f2992a);
        return jSONObject;
    }
}
