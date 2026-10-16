package com.ironsource;

import android.util.Base64;
import com.ironsource.mediationsdk.logger.IronLog;

/* loaded from: classes6.dex */
public class M6 {
    public static String a(String str) {
        try {
            return new String(Base64.decode(str, 0), "UTF-8");
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return "";
        }
    }

    static String b(String str) {
        return Base64.encodeToString(str.getBytes(), 10);
    }
}
