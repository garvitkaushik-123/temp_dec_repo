package com.bytedance.sdk.openadsdk.du.eli;

import com.bytedance.sdk.component.eli.aGH;
import com.bytedance.sdk.component.eli.dV;
import com.bytedance.sdk.openadsdk.core.qj;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli extends com.bytedance.sdk.component.eli.aGH<JSONObject, JSONObject> {
    private final WeakReference<qj> eli;

    public static void eli(dV dVVar, final qj qjVar) {
        dVVar.eli("getNetworkData", new aGH.DbA() { // from class: com.bytedance.sdk.openadsdk.du.eli.eli.1
            @Override // com.bytedance.sdk.component.eli.aGH.DbA
            public com.bytedance.sdk.component.eli.aGH eli() {
                return new eli(qj.this);
            }
        });
    }

    public eli(qj qjVar) {
        this.eli = new WeakReference<>(qjVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.eli.aGH
    public void eli(JSONObject jSONObject, com.bytedance.sdk.component.eli.MGA mga) throws Exception {
        qj qjVar = this.eli.get();
        if (qjVar == null) {
            Os();
        } else {
            qjVar.eli(jSONObject, new com.bytedance.sdk.openadsdk.nlS.aGH() { // from class: com.bytedance.sdk.openadsdk.du.eli.eli.2
                @Override // com.bytedance.sdk.openadsdk.nlS.aGH
                public void eli(boolean z, com.bytedance.sdk.openadsdk.core.model.eli eliVar) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        if (!z) {
                            eli.this.eli((eli) jSONObject2);
                        } else {
                            jSONObject2.put("creatives", qj.eli(eliVar));
                            eli.this.eli((eli) jSONObject2);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }
}
