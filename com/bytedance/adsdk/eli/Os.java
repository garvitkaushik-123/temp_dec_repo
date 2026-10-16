package com.bytedance.adsdk.eli;

import com.bytedance.adsdk.ugeno.Os.eli;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Os implements com.bytedance.adsdk.ugeno.Os.eli {
    @Override // com.bytedance.adsdk.ugeno.Os.eli
    public eli.InterfaceC0121eli eli(String str) {
        return eli.eli(str);
    }

    static class eli implements eli.InterfaceC0121eli {
        private String DbA;
        private com.bytedance.adsdk.eli.DbA.eli eli;

        private eli(String str) {
            this.DbA = str;
            this.eli = com.bytedance.adsdk.eli.DbA.eli.eli(str);
        }

        public static eli eli(String str) {
            return new eli(str);
        }

        @Override // com.bytedance.adsdk.ugeno.Os.eli.InterfaceC0121eli
        public Object eli(JSONObject jSONObject) {
            com.bytedance.adsdk.eli.DbA.eli eliVar = this.eli;
            if (eliVar == null) {
                return this.DbA;
            }
            Object eli = eliVar.eli(jSONObject);
            if (eli instanceof String) {
                return eli;
            }
            if (eli instanceof com.bytedance.adsdk.eli.DbA.eli.eli) {
                return String.valueOf(du.eli((com.bytedance.adsdk.eli.DbA.eli.eli) eli));
            }
            return String.valueOf(eli);
        }
    }
}
