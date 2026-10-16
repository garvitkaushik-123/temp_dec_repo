package com.bytedance.sdk.openadsdk.du.eli;

import com.bytedance.sdk.component.eli.aGH;
import com.bytedance.sdk.component.eli.dV;
import com.bytedance.sdk.openadsdk.core.qj;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA extends com.bytedance.sdk.component.eli.aGH<JSONObject, JSONObject> {
    private final WeakReference<qj> eli;

    public static void eli(dV dVVar, final qj qjVar) {
        dVVar.eli("interstitial_webview_close", new aGH.DbA() { // from class: com.bytedance.sdk.openadsdk.du.eli.DbA.1
            @Override // com.bytedance.sdk.component.eli.aGH.DbA
            public com.bytedance.sdk.component.eli.aGH eli() {
                return new DbA(qj.this);
            }
        });
    }

    public DbA(qj qjVar) {
        this.eli = new WeakReference<>(qjVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.component.eli.aGH
    public void eli(JSONObject jSONObject, com.bytedance.sdk.component.eli.MGA mga) throws Exception {
        com.bytedance.sdk.openadsdk.core.FC.DbA().dV();
        qj qjVar = this.eli.get();
        if (qjVar == null) {
            Os();
        } else {
            qjVar.wC();
        }
    }
}
