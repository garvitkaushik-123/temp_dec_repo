package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.res.Resources;

/* compiled from: ResourceUtil.java */
/* loaded from: classes6.dex */
public class h0 {
    public static int a(Context context, String str, String str2) {
        String str3 = "";
        try {
            try {
                str3 = com.mbridge.msdk.foundation.controller.c.m().h();
            } catch (Exception unused) {
                p0.b("ResourceUtil", "MBSDKContext.getInstance() is null resName:" + str);
            }
            if (z0.a(str3) && context != null) {
                str3 = context.getPackageName();
            }
            if (z0.a(str3) || context == null) {
                return -1;
            }
            return context.getResources().getIdentifier(str, str2, str3);
        } catch (Exception unused2) {
            p0.b("ResourceUtil", "Resource not found resName:" + str);
            return -1;
        }
    }

    public static boolean a(int i) {
        return (i == -1 || ((-16777216) & i) == 0 || (i & 16711680) == 0) ? false : true;
    }

    public static Resources a(Context context) {
        if (context != null) {
            try {
                return context.getResources();
            } catch (Exception e) {
                p0.b("ResourceUtil", "Resource error:" + e.getMessage());
            }
        }
        return null;
    }
}
