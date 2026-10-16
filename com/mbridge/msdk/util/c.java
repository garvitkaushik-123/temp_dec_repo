package com.mbridge.msdk.util;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.GoogleApiAvailability;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.r0;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: CronetEnvironmentCheckUtil.java */
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f4979a = false;
    public static String b = "";

    public static void a() {
        if (c()) {
            try {
                Class.forName("com.google.android.gms.common.GoogleApiAvailability");
                GoogleApiAvailability.getInstance().getApkVersion(com.mbridge.msdk.foundation.controller.c.m().d());
                GoogleApiAvailability.getInstance().verifyGooglePlayServicesIsAvailable(com.mbridge.msdk.foundation.controller.c.m().d(), 11925000);
                try {
                    String b2 = b();
                    boolean isEmpty = TextUtils.isEmpty(b2);
                    f4979a = !isEmpty;
                    if (isEmpty) {
                        return;
                    }
                    b = b2;
                } catch (Throwable th) {
                    p0.b("CronetEnvCheckUtil", th.getMessage());
                }
            } catch (Throwable th2) {
                p0.b("CronetEnvCheckUtil", th2.getMessage());
                f4979a = false;
            }
        }
    }

    private static String b() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Pair.create(1, "org.chromium.net.impl.JavaCronetProvider"));
        arrayList.add(Pair.create(2, "org.chromium.net.impl.NativeCronetProvider"));
        arrayList.add(Pair.create(3, "com.google.android.gms.net.PlayServicesCronetProvider"));
        arrayList.add(Pair.create(4, "com.google.android.gms.net.GmsCoreCronetProvider"));
        try {
            StringBuilder sb = new StringBuilder();
            ClassLoader classLoader = com.mbridge.msdk.foundation.controller.c.m().d().getClassLoader();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                try {
                    if (!TextUtils.isEmpty(classLoader.loadClass((String) pair.second).getConstructor(Context.class).newInstance(com.mbridge.msdk.foundation.controller.c.m().d()).getClass().getName())) {
                        if (sb.length() > 0) {
                            sb.append(",");
                        }
                        sb.append(pair.first);
                    }
                } catch (Throwable th) {
                    p0.b("CronetEnvCheckUtil", th.getMessage());
                }
            }
            return sb.toString();
        } catch (Throwable th2) {
            p0.b("CronetEnvCheckUtil", th2.getMessage());
            return "";
        }
    }

    public static boolean c() {
        return r0.a().a("cronet_env_check", false);
    }
}
