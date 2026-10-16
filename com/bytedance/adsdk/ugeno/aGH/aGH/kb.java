package com.bytedance.adsdk.ugeno.aGH.aGH;

import android.content.Context;

/* loaded from: classes3.dex */
public class kb extends Os {
    public kb(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.aGH.Os
    public boolean eli(Object... objArr) {
        if (objArr != null && objArr.length > 0) {
            int eli = com.bytedance.adsdk.ugeno.kb.Os.eli(String.valueOf(objArr[0]), 0);
            if (this.ui == null || this.ui.isEmpty()) {
                this.eli.eli(this.DbA, this.MGA, this.Os.DbA());
            } else if (eli == com.bytedance.adsdk.ugeno.kb.Os.eli(this.ui.get("type"), 0)) {
                this.eli.eli(this.DbA, this.MGA, this.Os.DbA());
            }
        }
        return false;
    }
}
