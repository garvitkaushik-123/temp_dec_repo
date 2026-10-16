package com.adjust.sdk;

import android.content.Context;
import android.provider.Settings;

/* loaded from: classes2.dex */
public class AndroidIdUtil {
    public static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }
}
