package com.fyber.inneractive.sdk.util;

import com.google.android.gms.measurement.AppMeasurement;

/* loaded from: classes4.dex */
public abstract class h1 {
    public static boolean a(String str) {
        int i = com.fyber.inneractive.sdk.config.k.f1102a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.response");
        return property != null && property.trim().length() > 0 && str != null && str.toLowerCase().startsWith("fyberInternalTesting".toLowerCase()) && str.contains(AppMeasurement.CRASH_ORIGIN);
    }
}
