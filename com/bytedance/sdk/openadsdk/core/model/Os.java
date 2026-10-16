package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.openadsdk.AdSlot;
import com.google.firebase.messaging.Constants;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os {
    public int DbA;
    public String MGA;
    public int Os = 1;
    public ArrayList<Integer> aGH;
    public String eli;
    public int kb;
    public AdSlot ui;

    public String eli() {
        return this.eli;
    }

    public void eli(String str) {
        this.eli = str;
    }

    public int DbA() {
        return this.DbA;
    }

    public void eli(int i) {
        this.DbA = i;
    }

    public int Os() {
        return this.Os;
    }

    public void DbA(int i) {
        this.Os = i;
    }

    public AdSlot aGH() {
        return this.ui;
    }

    public void eli(AdSlot adSlot) {
        this.ui = adSlot;
    }

    public ArrayList<Integer> ui() {
        return this.aGH;
    }

    public void eli(ArrayList<Integer> arrayList) {
        this.aGH = arrayList;
    }

    public void DbA(String str) {
        this.MGA = str;
    }

    public void Os(int i) {
        this.kb = i;
    }

    public static void eli(Os os) {
        int DbA;
        if (os == null || os.aGH() == null || (DbA = os.DbA()) >= 0 || DbA == -8) {
            return;
        }
        com.bytedance.sdk.openadsdk.Dfc.Os.eli();
        com.bytedance.sdk.openadsdk.Dfc.Os.eli("rd_client_custom_error", false, new com.bytedance.sdk.openadsdk.Dfc.DbA() { // from class: com.bytedance.sdk.openadsdk.core.model.Os.1
            @Override // com.bytedance.sdk.openadsdk.Dfc.DbA
            public com.bytedance.sdk.openadsdk.Dfc.eli.Os getLogStats() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Constants.MessagePayloadKeys.FROM, Os.this.Os());
                jSONObject.put("err_code", Os.this.DbA());
                jSONObject.put("err_msg", Os.this.MGA);
                jSONObject.put("ext_from", Os.this.kb);
                jSONObject.put("server_res_str", Os.this.eli());
                if (Os.this.ui() != null && Os.this.ui().size() > 0) {
                    jSONObject.put("mate_unavailable_code_list", new JSONArray((Collection) Os.this.ui()).toString());
                }
                new Object[]{"rd_client_custom_error = ", jSONObject};
                return com.bytedance.sdk.openadsdk.Dfc.eli.aGH.DbA().eli("rd_client_custom_error").eli(Os.this.aGH().getDurationSlotType()).DbA(jSONObject.toString());
            }
        });
    }
}
