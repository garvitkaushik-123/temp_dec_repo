package com.mbridge.msdk.tracker.network.toolbox;

import android.text.TextUtils;
import com.mbridge.msdk.tracker.network.t;

/* compiled from: Common.java */
/* loaded from: classes6.dex */
public class d {
    public static String a(String str, t<?> tVar) {
        if (TextUtils.isEmpty(str) || tVar == null) {
            return "";
        }
        byte[] b = tVar.b();
        return (b == null || b.length == 0) ? str : str.endsWith("?") ? str + new String(b) : str + "?" + new String(b);
    }
}
