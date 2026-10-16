package com.bytedance.sdk.openadsdk.du.eli;

import com.bytedance.sdk.component.eli.aGH;
import com.bytedance.sdk.component.eli.dV;
import com.bytedance.sdk.openadsdk.core.qj;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os extends com.bytedance.sdk.component.eli.aGH<JSONObject, JSONObject> {
    private final WeakReference<qj> eli;

    public static void eli(dV dVVar, final qj qjVar) {
        dVVar.eli("newClickEvent", new aGH.DbA() { // from class: com.bytedance.sdk.openadsdk.du.eli.Os.1
            @Override // com.bytedance.sdk.component.eli.aGH.DbA
            public com.bytedance.sdk.component.eli.aGH eli() {
                return new Os(qj.this);
            }
        });
    }

    public Os(qj qjVar) {
        this.eli = new WeakReference<>(qjVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.eli.aGH
    public void eli(JSONObject jSONObject, com.bytedance.sdk.component.eli.MGA mga) throws Exception {
        qj qjVar = this.eli.get();
        if (qjVar == null) {
            Os();
        } else {
            qjVar.ui(jSONObject);
        }
    }
}
