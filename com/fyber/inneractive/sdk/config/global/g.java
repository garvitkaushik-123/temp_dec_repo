package com.fyber.inneractive.sdk.config.global;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class g {
    public static JSONArray a(Map map, boolean z) {
        d dVar;
        JSONArray jSONArray = new JSONArray();
        try {
            for (com.fyber.inneractive.sdk.config.global.features.h hVar : map.values()) {
                hVar.getClass();
                ArrayList arrayList = new ArrayList(hVar.c.values());
                HashMap hashMap = hVar.d;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    JSONObject jSONObject = new JSONObject();
                    String str = bVar != null ? bVar.f1086a : null;
                    if (!TextUtils.isEmpty(str)) {
                        k kVar = (k) hashMap.get(str);
                        jSONObject.put("id", str);
                        if (kVar != null) {
                            jSONObject.put("v", kVar.b);
                        } else {
                            jSONObject.put("v", "control");
                        }
                        if (z) {
                            Iterator it2 = bVar.d.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = (d) it2.next();
                                if (c.class.equals(dVar.getClass())) {
                                    break;
                                }
                            }
                            if (dVar != null && ((c) dVar).b) {
                                HashSet hashSet = ((c) dVar).f1087a;
                                JSONArray jSONArray2 = new JSONArray();
                                Iterator it3 = hashSet.iterator();
                                while (it3.hasNext()) {
                                    jSONArray2.put((Long) it3.next());
                                }
                                if (jSONArray2.length() > 0) {
                                    jSONObject.put("d", jSONArray2);
                                }
                            }
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            }
            return jSONArray;
        } catch (JSONException e) {
            IAlog.a("ExperimentParamBuilder: Json exception during experiments Json build!", new Object[0]);
            if (IAlog.f1749a <= 3) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
