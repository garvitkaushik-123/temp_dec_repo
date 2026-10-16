package com.ironsource.environment;

import android.content.Context;
import android.content.SharedPreferences;

@Deprecated
/* loaded from: classes6.dex */
public class IronSourceSharedPreferencesUtilities {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3279a = "_preferences";

    static void a(Context context, String str, String str2, boolean z) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putBoolean(str2, z);
        edit.apply();
    }

    public static boolean getBooleanFromSharedPrefs(Context context, String str, String str2, boolean z) {
        return context == null ? z : context.getSharedPreferences(str, 0).getBoolean(str2, z);
    }

    public static String getDefaultSharedPrefName(Context context, String str) {
        return context == null ? str : context.getPackageName() + f3279a;
    }

    public static int getIntFromDefaultSharedPrefs(Context context, String str, int i) {
        return a(context, getDefaultSharedPrefName(context, ""), str, i);
    }

    public static String getStringFromDefaultSharedPrefs(Context context, String str, String str2) {
        return getStringFromSharedPrefs(context, getDefaultSharedPrefName(context, ""), str, str2);
    }

    public static String getStringFromSharedPrefs(Context context, String str, String str2, String str3) {
        return context == null ? str3 : context.getSharedPreferences(str, 0).getString(str2, str3);
    }

    public static void saveIntToSharedPrefs(Context context, String str, String str2, int i) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putInt(str2, i);
        edit.apply();
    }

    public static void saveStringToSharedPrefs(Context context, String str, String str2, String str3) {
        if (context == null) {
            return;
        }
        SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
        edit.putString(str2, str3);
        edit.apply();
    }

    static int a(Context context, String str, String str2, int i) {
        return context == null ? i : context.getSharedPreferences(str, 0).getInt(str2, i);
    }
}
