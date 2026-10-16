package com.bytedance.adsdk.eli.DbA.DbA.eli;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aAs implements com.bytedance.adsdk.eli.DbA.DbA.eli {
    private String DbA;
    private com.bytedance.adsdk.eli.DbA.eli.eli Os;
    private com.bytedance.adsdk.eli.DbA.DbA.eli[] eli;

    public aAs(String str) {
        this.DbA = str;
    }

    public void eli(com.bytedance.adsdk.eli.DbA.DbA.eli[] eliVarArr) {
        this.eli = eliVarArr;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public Object eli(Map<String, JSONObject> map) {
        com.bytedance.adsdk.eli.DbA.eli.eli eliVar = new com.bytedance.adsdk.eli.DbA.eli.eli();
        this.Os = eliVar;
        eliVar.eli(this.DbA);
        Object[] objArr = new Object[this.eli.length];
        int i = 0;
        while (true) {
            com.bytedance.adsdk.eli.DbA.DbA.eli[] eliVarArr = this.eli;
            if (i < eliVarArr.length) {
                com.bytedance.adsdk.eli.DbA.DbA.eli eliVar2 = eliVarArr[i];
                if (eliVar2 != null) {
                    objArr[i] = eliVar2.eli(map);
                }
                i++;
            } else {
                this.Os.eli(objArr);
                return com.bytedance.adsdk.eli.du.eli(this.DbA).eli(map.get("default_key"), objArr);
            }
        }
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public com.bytedance.adsdk.eli.DbA.aGH.ui eli() {
        return com.bytedance.adsdk.eli.DbA.aGH.DbA.METHOD;
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public String DbA() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.DbA).append("(");
        com.bytedance.adsdk.eli.DbA.DbA.eli[] eliVarArr = this.eli;
        if (eliVarArr != null && eliVarArr.length > 0) {
            int i = 0;
            while (true) {
                com.bytedance.adsdk.eli.DbA.DbA.eli[] eliVarArr2 = this.eli;
                if (i >= eliVarArr2.length) {
                    break;
                }
                sb.append(eliVarArr2[i].DbA()).append(",");
                i++;
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
