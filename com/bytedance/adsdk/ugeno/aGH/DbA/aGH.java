package com.bytedance.adsdk.ugeno.aGH.DbA;

import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.aGH.MGA;

/* loaded from: classes3.dex */
public class aGH extends eli {
    @Override // com.bytedance.adsdk.ugeno.aGH.DbA.eli
    public void DbA() {
    }

    public aGH(com.bytedance.adsdk.ugeno.DbA.Os os, String str, MGA.eli eliVar) {
        super(os, str, eliVar);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.DbA.eli
    public void eli() {
        com.bytedance.adsdk.ugeno.DbA.Os DbA;
        com.bytedance.adsdk.ugeno.eli.eli aAs;
        if (this.MGA == null || this.MGA.size() <= 0) {
            return;
        }
        String str = this.MGA.get("name");
        if (TextUtils.isEmpty(str) || (DbA = this.Os.DbA(this.Os)) == null || (aAs = DbA.MGA(str).aAs(str)) == null) {
            return;
        }
        aAs.DbA();
        aAs.eli(new com.bytedance.adsdk.ugeno.eli.DbA() { // from class: com.bytedance.adsdk.ugeno.aGH.DbA.aGH.1
            @Override // com.bytedance.adsdk.ugeno.eli.DbA
            public void eli() {
            }

            @Override // com.bytedance.adsdk.ugeno.eli.DbA
            public void DbA() {
                aGH.this.Os();
            }
        });
    }
}
