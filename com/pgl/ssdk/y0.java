package com.pgl.ssdk;

/* loaded from: classes6.dex */
public class y0 {
    public static String a(String str) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class).invoke(null, str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
