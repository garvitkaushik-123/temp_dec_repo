package com.mbridge.msdk.foundation.tools;

import android.net.ConnectivityManager;

/* compiled from: NetManager.java */
/* loaded from: classes6.dex */
public class g0 {

    /* renamed from: a, reason: collision with root package name */
    private static ConnectivityManager f4367a;

    public static synchronized ConnectivityManager a() {
        ConnectivityManager connectivityManager;
        synchronized (g0.class) {
            try {
                if (f4367a == null && com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    f4367a = (ConnectivityManager) com.mbridge.msdk.foundation.controller.c.m().d().getSystemService("connectivity");
                }
            } catch (Exception e) {
                p0.b("NetManager", e.getMessage());
            }
            connectivityManager = f4367a;
        }
        return connectivityManager;
    }
}
