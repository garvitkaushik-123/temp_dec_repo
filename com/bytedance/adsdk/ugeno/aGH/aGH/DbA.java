package com.bytedance.adsdk.ugeno.aGH.aGH;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes3.dex */
public class DbA extends Os implements com.bytedance.adsdk.ugeno.eli.DbA {
    private String du;

    public DbA(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.aGH.aGH.Os
    public boolean eli(Object... objArr) {
        com.bytedance.adsdk.ugeno.DbA.Os DbA;
        com.bytedance.adsdk.ugeno.eli.eli aAs;
        if (this.ui != null && this.ui.size() > 0) {
            String str = this.ui.get("name");
            this.du = this.ui.get("state");
            if (!TextUtils.isEmpty(str) && (DbA = this.DbA.DbA(this.DbA)) != null && (aAs = DbA.MGA(str).aAs(str)) != null) {
                aAs.eli(this);
            }
        }
        return false;
    }

    @Override // com.bytedance.adsdk.ugeno.eli.DbA
    public void eli() {
        if ((TextUtils.equals(this.du, "start") || TextUtils.isEmpty(this.du)) && this.eli != null) {
            this.eli.eli(this.DbA, this.MGA, this.Os.DbA());
        }
    }

    @Override // com.bytedance.adsdk.ugeno.eli.DbA
    public void DbA() {
        if ((TextUtils.equals(this.du, CampaignEx.JSON_NATIVE_VIDEO_COMPLETE) || TextUtils.isEmpty(this.du)) && this.eli != null) {
            this.eli.eli(this.DbA, this.MGA, this.Os.DbA());
        }
    }
}
