package com.pgl.ssdk;

import android.content.Context;
import android.os.LocaleList;
import android.provider.Settings;
import java.lang.reflect.Method;
import java.util.TimeZone;

/* loaded from: classes6.dex */
public class d0 {

    /* renamed from: a, reason: collision with root package name */
    private static double f6388a = -1.0d;

    public static String b() {
        String str;
        try {
            str = TimeZone.getDefault().getDisplayName(false, 0);
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }

    public static String c() {
        return "";
    }

    public static String c(Context context) {
        return "";
    }

    public static String a() {
        return LocaleList.getDefault().get(0).getLanguage();
    }

    public static String b(Context context) {
        double d = f6388a;
        double d2 = 0.0d;
        if (d >= 0.0d) {
            return Integer.toString((int) d);
        }
        try {
            Class<?> cls = Class.forName("com.android.internal.os.PowerProfile");
            Object newInstance = cls.getConstructor(Context.class).newInstance(context);
            Method declaredMethod = cls.getDeclaredMethod("getAveragePower", String.class);
            declaredMethod.setAccessible(true);
            d2 = ((Double) declaredMethod.invoke(newInstance, "battery.capacity")).doubleValue();
        } catch (Throwable unused) {
        }
        f6388a = d2;
        return Integer.toString((int) d2);
    }

    public static String a(Context context) {
        String str;
        try {
            str = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
            str = null;
        }
        return str == null ? "" : str.trim();
    }
}
