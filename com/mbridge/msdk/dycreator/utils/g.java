package com.mbridge.msdk.dycreator.utils;

import android.util.Log;

/* compiled from: Logger.java */
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f4179a = false;

    public static void a(String str) {
        if (f4179a) {
            new SecurityManager();
            Log.e(new Throwable().getStackTrace()[1].getFileName(), str);
        }
    }
}
