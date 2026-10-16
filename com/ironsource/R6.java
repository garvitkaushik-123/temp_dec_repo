package com.ironsource;

import android.content.Context;
import com.ironsource.N6;
import com.ironsource.environment.ContextProvider;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class R6 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3024a = "adunit_data";

    public void a(String str, Object obj) {
        O6.b().b(str, obj);
    }

    public void a(Map<String, Object> map) {
        O6.b().a(map);
    }

    public void a(String str, JSONArray jSONArray) {
        O6.b().a(str, jSONArray);
    }

    public void a(String str, JSONObject jSONObject) {
        O6.b().a(str, jSONObject);
    }

    public void a(Context context) {
        O6.b().c(context);
    }

    public void a(String str, Object obj, N6.a aVar) {
        try {
            String name = aVar.name();
            O6 b = O6.b();
            JSONObject optJSONObject = b.b(ContextProvider.getInstance().getApplicationContext()).optJSONObject(f3024a);
            if (optJSONObject == null) {
                b.b(f3024a, new JSONObject().put(name, new JSONObject().put(str, obj)));
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(name);
            if (optJSONObject2 == null) {
                b.b(f3024a, optJSONObject.put(name, new JSONObject().put(str, obj)));
            } else {
                b.b(f3024a, optJSONObject.put(name, optJSONObject2.put(str, obj)));
            }
        } catch (JSONException e) {
            C3260q4.d().a(e);
        }
    }

    public void a(String str, N6.a aVar) {
        JSONObject optJSONObject;
        try {
            String name = aVar.name();
            O6 b = O6.b();
            JSONObject optJSONObject2 = b.b(ContextProvider.getInstance().getApplicationContext()).optJSONObject(f3024a);
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject(name)) == null || optJSONObject.remove(str) == null) {
                return;
            }
            b.b(f3024a, optJSONObject2.put(name, optJSONObject));
        } catch (JSONException e) {
            C3260q4.d().a(e);
        }
    }
}
