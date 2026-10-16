package com.bytedance.sdk.openadsdk.core.aAs.ui.DbA;

import android.content.Context;

/* loaded from: classes3.dex */
public class Os extends com.bytedance.adsdk.ugeno.aGH.aGH.Os {
    private boolean du;

    public Os(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.aGH.Os
    public boolean eli(Object... objArr) {
        if (this.ui == null || this.ui.isEmpty()) {
            return false;
        }
        long longValue = ((Long) objArr[0]).longValue() / 1000;
        long longValue2 = ((Long) objArr[1]).longValue() / 1000;
        if (longValue <= 0) {
            this.du = false;
        }
        if (this.ui.containsKey("percent")) {
            float eli = com.bytedance.adsdk.ugeno.kb.Os.eli(this.ui.get("percent"), -1.0f);
            if (eli >= 0.0f && longValue >= (eli / 100.0f) * longValue2 && !this.du) {
                this.du = true;
                if (this.eli != null) {
                    this.eli.eli(this.DbA, this.MGA, this.Os.DbA());
                }
            }
        } else if (longValue >= com.bytedance.adsdk.ugeno.kb.Os.eli(this.ui.get("interval"), -1) && !this.du) {
            this.du = true;
            if (this.eli != null) {
                this.eli.eli(this.DbA, this.MGA, this.Os.DbA());
            }
        }
        return true;
    }
}
