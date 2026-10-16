package com.mbridge.msdk.setting.net;

import android.content.Context;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.wrapper.e;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.p0;

/* compiled from: SettingRequestDiff.java */
/* loaded from: classes6.dex */
public class d {
    public static void a(Context context, e eVar) {
        if (eVar == null) {
            return;
        }
        try {
            eVar.a("gaid", f.d());
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b("SettingRequestDiff", e.getMessage());
            }
        }
    }
}
