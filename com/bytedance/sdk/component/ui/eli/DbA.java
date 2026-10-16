package com.bytedance.sdk.component.ui.eli;

import com.bytedance.sdk.component.ui.FC;
import com.bytedance.sdk.component.ui.nlS;
import com.bytedance.sdk.component.utils.aqO;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class DbA {
    public static nlS eli() {
        return new nlS() { // from class: com.bytedance.sdk.component.ui.eli.DbA.1
            private WeakHashMap<String, String> eli = new WeakHashMap<>();

            @Override // com.bytedance.sdk.component.ui.nlS
            public String eli(FC fc) {
                return eli(fc.eli() + "#width=" + fc.DbA() + "#height=" + fc.Os() + "#scaletype=" + fc.aGH() + "#bitmapConfig=" + fc.ui());
            }

            @Override // com.bytedance.sdk.component.ui.nlS
            public String DbA(FC fc) {
                return eli(fc.eli());
            }

            private String eli(String str) {
                String str2 = this.eli.get(str);
                if (str2 != null) {
                    return str2;
                }
                String eli = aqO.eli(str);
                this.eli.put(str, eli);
                return eli;
            }
        };
    }
}
