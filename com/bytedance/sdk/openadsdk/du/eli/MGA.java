package com.bytedance.sdk.openadsdk.du.eli;

import com.bytedance.sdk.component.eli.dV;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.qj;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class MGA extends com.bytedance.sdk.component.eli.ui<JSONObject, JSONObject> {
    private final WeakReference<qj> eli;

    public static void eli(dV dVVar, qj qjVar) {
        dVVar.eli("interactiveFinish", new MGA(qjVar));
    }

    @Override // com.bytedance.sdk.component.eli.ui
    public JSONObject eli(JSONObject jSONObject, com.bytedance.sdk.component.eli.MGA mga) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        WeakReference<qj> weakReference = this.eli;
        if (weakReference != null && weakReference.get() != null) {
            qj qjVar = this.eli.get();
            ev aGH = qjVar.aGH();
            try {
                boolean z = true;
                int i = 0;
                if (jSONObject.optInt("finish", 1) != 1) {
                    z = false;
                }
                int optInt = jSONObject.optInt("reduce_duration", -1);
                int OPT = aGH != null ? aGH.OPT() : 0;
                if (optInt >= 0 && OPT >= 0) {
                    optInt = Math.min(optInt, OPT);
                } else if (optInt < 0) {
                    optInt = OPT >= 0 ? OPT : 0;
                }
                if (z) {
                    qjVar.Os(optInt);
                } else {
                    i = -1;
                }
                jSONObject2.put("code", i);
                jSONObject2.put("reduce_duration", optInt);
                return jSONObject2;
            } catch (JSONException e) {
                Xb.Os("InteractiveFinishMethod", e.getMessage());
            }
        }
        return jSONObject2;
    }

    public MGA(qj qjVar) {
        this.eli = new WeakReference<>(qjVar);
    }
}
