package com.pgl.ssdk;

import android.content.Context;
import android.text.TextUtils;
import com.vungle.ads.internal.protos.Sdk;

/* loaded from: classes6.dex */
public class f1 {

    /* renamed from: a, reason: collision with root package name */
    public static int f6394a = 504;
    public static String b = null;
    public static String c = "";
    static boolean d;
    private static long e;
    private static Context f;

    public static void a(Context context, String str) {
        if (f == null) {
            f = context;
        }
        int i = f6394a;
        if (i == 102 || i == 202 || i == 200) {
            return;
        }
        e = System.currentTimeMillis();
        d = false;
        b = str;
        f6394a = 102;
        r0.b(new o0(context, Sdk.SDKError.Reason.MRAID_ERROR_VALUE, null));
    }

    public static void b() {
        Context context = f;
        if (context != null) {
            r0.b(new o0(context, Sdk.SDKError.Reason.MRAID_ERROR_VALUE, null));
            f6394a = 102;
            com.pgl.ssdk.ces.b.h().a();
            z.a();
        }
    }

    public static synchronized String a() {
        String str;
        synchronized (f1.class) {
            if (TextUtils.isEmpty(c)) {
                c = (String) com.pgl.ssdk.ces.a.meta(303, f, null);
            }
            str = c;
        }
        return str;
    }

    public static synchronized Object a(byte[] bArr) {
        synchronized (f1.class) {
            if (bArr == null) {
                return null;
            }
            return com.pgl.ssdk.ces.a.meta(Sdk.SDKError.Reason.INVALID_IFA_STATUS_VALUE, f, bArr);
        }
    }
}
