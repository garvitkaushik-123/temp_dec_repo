package com.bytedance.sdk.openadsdk.du.eli;

import android.view.ViewGroup;
import com.bytedance.sdk.component.eli.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nro;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.utils.cyF;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Dfc extends com.bytedance.sdk.component.eli.ui<JSONObject, JSONObject> {
    private String DbA;
    private qj Os;
    private ev aGH;
    private com.bytedance.sdk.component.FC.MGA eli;

    public static void eli(dV dVVar, com.bytedance.sdk.component.FC.MGA mga, qj qjVar, ev evVar) {
        dVVar.eli("closeWebview", new Dfc(mga, "closeWebview", qjVar, evVar));
        dVVar.eli("makeVisible", new Dfc(mga, "makeVisible", qjVar, evVar));
        dVVar.eli("getCurrentVisibleState", new Dfc(mga, "getCurrentVisibleState", qjVar, evVar));
    }

    public Dfc(com.bytedance.sdk.component.FC.MGA mga, String str, qj qjVar, ev evVar) {
        this.eli = mga;
        this.DbA = str;
        this.Os = qjVar;
        this.aGH = evVar;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.component.eli.ui
    public JSONObject eli(JSONObject jSONObject, com.bytedance.sdk.component.eli.MGA mga) throws Exception {
        JSONObject jSONObject2;
        jSONObject2 = new JSONObject();
        String str = this.DbA;
        str.hashCode();
        switch (str) {
            case "getCurrentVisibleState":
                ev evVar = this.aGH;
                if (evVar != null) {
                    jSONObject2.put("visibleState", !nro.eli(this.eli, 20, evVar.bBQ(), false) ? 1 : 0);
                }
                return jSONObject2;
            case "closeWebview":
                cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.du.eli.Dfc.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (Dfc.this.eli != null) {
                            Dfc.this.eli.setVisibility(8);
                            ViewGroup viewGroup = (ViewGroup) Dfc.this.eli.getParent();
                            if (viewGroup != null) {
                                viewGroup.removeView(Dfc.this.eli);
                            }
                        }
                    }
                });
                jSONObject2.put("success", true);
                return jSONObject2;
            case "makeVisible":
                if (this.eli != null) {
                    jSONObject2.put("success", true);
                    cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.du.eli.Dfc.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (Dfc.this.eli != null) {
                                Dfc.this.eli.setVisibility(0);
                            }
                        }
                    });
                    return jSONObject2;
                }
                jSONObject2.put("success", false);
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
