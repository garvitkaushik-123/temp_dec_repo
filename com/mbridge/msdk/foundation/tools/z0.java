package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;

/* compiled from: StringUtils.java */
/* loaded from: classes6.dex */
public class z0 {
    public static boolean a(String str) {
        return str == null || TextUtils.isEmpty(str.trim()) || "null".equals(str);
    }

    public static boolean b(String str) {
        return (str == null || TextUtils.isEmpty(str.trim()) || "null".equals(str)) ? false : true;
    }
}
