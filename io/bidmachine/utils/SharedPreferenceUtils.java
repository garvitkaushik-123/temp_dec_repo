package io.bidmachine.utils;

import android.content.SharedPreferences;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class SharedPreferenceUtils {
    public static String optString(SharedPreferences sharedPreferences, String key, String defValue) {
        try {
            if (sharedPreferences.contains(key)) {
                String string = sharedPreferences.getString(key, defValue);
                if (string != null) {
                    return string;
                }
            }
        } catch (Exception unused) {
        }
        return defValue;
    }

    public static int optInt(SharedPreferences sharedPreferences, String key, int defValue) {
        try {
            if (sharedPreferences.contains(key)) {
                return sharedPreferences.getInt(key, defValue);
            }
        } catch (Exception unused) {
        }
        return defValue;
    }

    public static long optLong(SharedPreferences sharedPreferences, String key, long defValue) {
        try {
            if (sharedPreferences.contains(key)) {
                return sharedPreferences.getLong(key, defValue);
            }
        } catch (Exception unused) {
        }
        return defValue;
    }

    public static void putString(SharedPreferences sharedPreferences, String key, String value) {
        if (value == null) {
            remove(sharedPreferences, key);
        } else {
            sharedPreferences.edit().putString(key, value).apply();
        }
    }

    public static void putInt(SharedPreferences sharedPreferences, String key, Integer value) {
        if (value == null) {
            remove(sharedPreferences, key);
        } else {
            sharedPreferences.edit().putInt(key, value.intValue()).apply();
        }
    }

    public static void putLong(SharedPreferences sharedPreferences, String key, Long value) {
        if (value == null) {
            remove(sharedPreferences, key);
        } else {
            sharedPreferences.edit().putLong(key, value.longValue()).apply();
        }
    }

    public static void remove(SharedPreferences sharedPreferences, String key) {
        sharedPreferences.edit().remove(key).apply();
    }

    public static void remove(SharedPreferences sharedPreferences, String... keys) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        for (String str : keys) {
            edit.remove(str);
        }
        edit.apply();
    }

    public static void clear(SharedPreferences sharedPreferences) {
        Iterator<String> it = sharedPreferences.getAll().keySet().iterator();
        while (it.hasNext()) {
            sharedPreferences.edit().remove(it.next()).apply();
        }
    }
}
