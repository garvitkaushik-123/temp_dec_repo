package com.bytedance.sdk.component.utils;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class bf {
    private static String eli;

    public static boolean eli(Context context) {
        if (context == null || context.getApplicationContext() == null) {
            return false;
        }
        return TextUtils.equals(context.getApplicationContext().getPackageName(), DbA(context));
    }

    public static String DbA(Context context) {
        if (!TextUtils.isEmpty(eli)) {
            return eli;
        }
        String eli2 = eli();
        eli = eli2;
        if (!TextUtils.isEmpty(eli2)) {
            return eli;
        }
        String DbA = DbA();
        eli = DbA;
        if (!TextUtils.isEmpty(DbA)) {
            return eli;
        }
        return eli;
    }

    private static String eli() {
        try {
            return Application.getProcessName();
        } catch (Exception unused) {
            return null;
        }
    }

    private static String DbA() {
        try {
            Method declaredMethod = Class.forName("android.app.ActivityThread", false, Application.class.getClassLoader()).getDeclaredMethod("currentProcessName", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            if (invoke instanceof String) {
                return (String) invoke;
            }
        } catch (Throwable unused) {
        }
        return null;
    }
}
