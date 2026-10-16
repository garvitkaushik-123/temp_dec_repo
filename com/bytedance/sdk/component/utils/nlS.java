package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.content.res.Configuration;
import java.util.Locale;

/* loaded from: classes3.dex */
public class nlS {
    private static Context eli;

    public static void eli(Context context, String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        try {
            eli = context.createConfigurationContext(DbA(context, str, str2));
        } catch (Throwable th) {
            th.getMessage();
        }
        ev.eli(eli);
    }

    private static Configuration DbA(Context context, String str, String str2) {
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(str, str2));
        return configuration;
    }
}
