package com.mbridge.msdk.foundation.entity;

import android.content.Context;
import android.os.Build;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.system.NoProGuard;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class CampaignUnit extends b implements Serializable, NoProGuard {
    private static final String TAG = "CampaignUnit";

    @Override // com.mbridge.msdk.foundation.entity.b
    public String assembCParams() {
        String str;
        String str2;
        StringBuffer stringBuffer = this.cParams;
        if (stringBuffer != null && stringBuffer.length() > 0) {
            return this.cParams.toString();
        }
        try {
            String d = com.mbridge.msdk.foundation.tools.f.d();
            Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
            String r = l0.r(d2);
            String q = l0.q(d2);
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                str2 = String.valueOf(l0.s(d2));
                str = l0.n(d2) + VastAttributes.HORIZONTAL_POSITION + l0.m(d2);
            } else {
                str = "";
                str2 = str;
            }
            this.cParams = this.cParams.append(getAdType()).append("|").append(nullToEmpty("1")).append("|").append(nullToEmpty(Build.VERSION.RELEASE)).append("|").append(nullToEmpty(MBConfiguration.SDK_VERSION)).append("|").append(nullToEmpty(l0.n())).append("|").append(nullToEmpty(str)).append("|").append(nullToEmpty(Integer.valueOf(l0.F(com.mbridge.msdk.foundation.controller.c.m().d())))).append("|").append(nullToEmpty(l0.p(com.mbridge.msdk.foundation.controller.c.m().d()))).append("|").append(nullToEmpty(str2)).append("|").append(nullToEmpty(q)).append(nullToEmpty(r)).append("|").append("|").append("|").append("|").append(nullToEmpty(d)).append("|").append(nullToEmpty("")).append("|").append(nullToEmpty(l0.s())).append("|").append(nullToEmpty("")).append("|").append("").append("|").append(nullToEmpty("")).append("|").append(nullToEmpty(com.mbridge.msdk.foundation.same.a.V + "," + com.mbridge.msdk.foundation.same.a.g)).append("|").append(l0.j()).append("|");
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                p0.b(TAG, th.getMessage(), th);
            }
        }
        return this.cParams.toString();
    }
}
