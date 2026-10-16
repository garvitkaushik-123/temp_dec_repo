package com.bytedance.sdk.openadsdk.du.eli;

import com.bytedance.sdk.component.eli.aGH;
import com.bytedance.sdk.component.eli.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.qj;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class du extends com.bytedance.sdk.component.eli.aGH<JSONObject, JSONObject> {
    private ev DbA;
    private long Os;
    private HashSet<Integer> aGH = new HashSet<>();
    private WeakReference<qj> eli;

    public static void eli(dV dVVar, final qj qjVar, final ev evVar) {
        dVVar.eli("requestDelayCallback", new aGH.DbA() { // from class: com.bytedance.sdk.openadsdk.du.eli.du.1
            @Override // com.bytedance.sdk.component.eli.aGH.DbA
            public com.bytedance.sdk.component.eli.aGH eli() {
                return new du(qj.this, evVar);
            }
        });
    }

    public du(qj qjVar, ev evVar) {
        this.eli = new WeakReference<>(qjVar);
        this.DbA = evVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.eli.aGH
    public void eli(JSONObject jSONObject, com.bytedance.sdk.component.eli.MGA mga) throws Exception {
        qj qjVar = this.eli.get();
        if (qjVar == null || jSONObject == null) {
            Os();
            return;
        }
        qjVar.eli(new com.bytedance.sdk.openadsdk.nlS.DbA() { // from class: com.bytedance.sdk.openadsdk.du.eli.du.2
            @Override // com.bytedance.sdk.openadsdk.nlS.DbA
            public void eli(int i) {
                du.this.aGH.add(Integer.valueOf(i));
                if (du.this.aGH.size() >= du.this.Os) {
                    try {
                        du.this.eli((du) new JSONObject());
                        du.this.aGH.clear();
                    } catch (Exception e) {
                        e.getMessage();
                    }
                }
            }
        });
        if (jSONObject.optInt("delay", -1) < 0) {
            return;
        }
        this.Os = r2 / 1000;
    }
}
