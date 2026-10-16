package com.bytedance.sdk.component.MGA.eli.eli.eli;

import android.text.TextUtils;
import android.util.Base64;

/* loaded from: classes3.dex */
public class MGA {
    public static String eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return Base64.encodeToString(str.getBytes(), 10);
    }

    public static String DbA(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return new String(Base64.decode(str, 10));
    }
}
