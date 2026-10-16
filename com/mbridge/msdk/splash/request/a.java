package com.mbridge.msdk.splash.request;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.out.MBridgeIds;
import io.bidmachine.iab.vast.tags.VastAttributes;

/* compiled from: BaseSplashV3Params.java */
/* loaded from: classes6.dex */
public class a {
    public static com.mbridge.msdk.foundation.same.net.wrapper.e a(Context context, MBridgeIds mBridgeIds, f fVar) {
        String b = com.mbridge.msdk.foundation.controller.c.m().b();
        String md5 = SameMD5.getMD5(com.mbridge.msdk.foundation.controller.c.m().b() + com.mbridge.msdk.foundation.controller.c.m().c());
        com.mbridge.msdk.foundation.same.net.wrapper.e eVar = new com.mbridge.msdk.foundation.same.net.wrapper.e();
        String a2 = com.mbridge.msdk.foundation.same.buffer.b.a(mBridgeIds.getUnitId(), "splash");
        String a3 = u0.a(context, mBridgeIds.getUnitId());
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, MBridgeConstans.APP_ID, b);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, MBridgeConstans.PROPERTIES_UNIT_ID, mBridgeIds.getUnitId());
        if (!TextUtils.isEmpty(mBridgeIds.getPlacementId())) {
            com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, MBridgeConstans.PLACEMENT_ID, mBridgeIds.getPlacementId());
        }
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "sign", md5);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "req_type", fVar.d() + "");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "ad_num", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "tnum", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "only_impression", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "ping_mode", "1");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, com.mbridge.msdk.foundation.same.net.wrapper.e.g, a2);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, com.mbridge.msdk.foundation.same.net.wrapper.e.h, a3);
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, com.mbridge.msdk.foundation.same.net.wrapper.e.i, fVar.e());
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "ad_type", "297");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, "offset", fVar.c() + "");
        com.mbridge.msdk.foundation.same.net.utils.b.a(eVar, com.mbridge.msdk.foundation.entity.b.JSON_KEY_UNIT_SIZE, fVar.b() + VastAttributes.HORIZONTAL_POSITION + fVar.a());
        return eVar;
    }
}
