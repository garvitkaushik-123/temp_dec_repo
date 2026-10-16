package com.fyber.inneractive.sdk.config;

import android.content.ContentResolver;
import android.content.Context;
import android.provider.Settings;

/* loaded from: classes4.dex */
public abstract class n {
    public static void a(Context context, w wVar) {
        String str = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            r2 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking") != 0;
            if (!r2) {
                str = Settings.Secure.getString(contentResolver, "advertising_id");
            }
        } catch (Settings.SettingNotFoundException unused) {
        }
        if (str != null) {
            synchronized (wVar) {
                v vVar = wVar.b;
                vVar.f1129a = str;
                vVar.b = r2;
                vVar.c = true;
            }
        }
    }
}
