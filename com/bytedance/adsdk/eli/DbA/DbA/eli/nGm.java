package com.bytedance.adsdk.eli.DbA.DbA.eli;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nGm extends dV {
    private static final ThreadLocal<StringBuilder> aGH = new ThreadLocal<StringBuilder>() { // from class: com.bytedance.adsdk.eli.DbA.DbA.eli.nGm.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* renamed from: eli, reason: merged with bridge method [inline-methods] */
        public StringBuilder initialValue() {
            return new StringBuilder();
        }
    };

    public nGm() {
        super(com.bytedance.adsdk.eli.DbA.aGH.Os.PLUS);
    }

    @Override // com.bytedance.adsdk.eli.DbA.DbA.eli
    public Object eli(Map<String, JSONObject> map) {
        Object eli;
        Object eli2 = this.eli.eli(map);
        if (eli2 == null || (eli = this.DbA.eli(map)) == null) {
            return null;
        }
        if ((eli2 instanceof String) || (eli instanceof String)) {
            StringBuilder sb = aGH.get();
            sb.append(eli2).append(eli);
            String sb2 = sb.toString();
            sb.setLength(0);
            return sb2;
        }
        return com.bytedance.adsdk.eli.DbA.ui.eli.wC.eli((Number) eli2, (Number) eli);
    }
}
