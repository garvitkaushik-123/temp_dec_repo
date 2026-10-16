package com.mbridge.msdk.foundation.same.net;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;

/* compiled from: LoadUrlTool.java */
/* loaded from: classes6.dex */
public class d {
    public static String a(String str) {
        String b = b(str);
        return TextUtils.isEmpty(b) ? "" : b1.a(b);
    }

    public static String b(String str) {
        g b = h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
        return com.mbridge.msdk.foundation.same.net.utils.d.h().a(str, TextUtils.isEmpty(str) ? b.p0() : b.B());
    }
}
