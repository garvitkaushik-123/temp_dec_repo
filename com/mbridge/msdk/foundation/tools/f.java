package com.mbridge.msdk.foundation.tools;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.b;
import com.mbridge.msdk.mbsignalcommon.webEnvCheck.WebEnvCheckEntry;
import org.json.JSONObject;

/* compiled from: BaseSameDiTool.java */
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public static volatile String f4362a = null;
    public static String b = null;
    public static boolean c = false;
    public static int d = 0;
    private static String e = "";
    private static boolean f = false;
    private static String g = "";
    private static boolean h = false;
    private static boolean i = false;

    /* compiled from: BaseSameDiTool.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4363a;

        a(Context context) {
            this.f4363a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID) && com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
                try {
                    Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
                    AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.f4363a);
                    f.a(advertisingIdInfo.getId());
                    f.d = advertisingIdInfo.isLimitAdTrackingEnabled() ? 1 : 0;
                    f.b(this.f4363a, advertisingIdInfo.getId(), f.d);
                } catch (Exception unused) {
                    p0.d("DomainSameDiTool", "GET ADID ERROR TRY TO GET FROM GOOGLE PLAY APP");
                    try {
                        b.C0343b a2 = new b().a(this.f4363a);
                        f.a(a2.a());
                        f.d = a2.b() ? 1 : 0;
                        f.b(this.f4363a, a2.a(), f.d);
                    } catch (Exception unused2) {
                        p0.d("DomainSameDiTool", "GET ADID FROM GOOGLE PLAY APP ERROR");
                    }
                } catch (Throwable th) {
                    p0.b("DomainSameDiTool", th.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, String str, int i2) {
        try {
            if (z0.b(str)) {
                x0.b(context, MBridgeConstans.SP_GA_ID, str);
            }
            x0.b(context, MBridgeConstans.SP_GA_ID_LIMIT, Integer.valueOf(i2));
        } catch (Exception e2) {
            p0.b("DomainSameDiTool", e2.getMessage());
        }
    }

    public static String c() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.l() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
            return TextUtils.isEmpty(b) ? "" : b;
        }
        if (!TextUtils.isEmpty(b)) {
            return !com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() ? d == 0 ? b : "" : b;
        }
        if (!c) {
            a(com.mbridge.msdk.foundation.controller.c.m().d());
            c = true;
        }
        return "";
    }

    public static String d() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.l() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
            return TextUtils.isEmpty(f4362a) ? "" : f4362a;
        }
        if (!TextUtils.isEmpty(f4362a)) {
            return !com.mbridge.msdk.foundation.controller.authoritycontroller.b.j() ? d == 0 ? f4362a : "" : f4362a;
        }
        l0.k();
        if (!c) {
            a(com.mbridge.msdk.foundation.controller.c.m().d());
            c = true;
        }
        return TextUtils.isEmpty(f4362a) ? "" : f4362a;
    }

    public static String e() {
        if (TextUtils.isEmpty(g) && !f) {
            b();
        }
        return g;
    }

    public static int a() {
        return d;
    }

    public static void a(int i2) {
        d = i2;
    }

    public static void a(Context context) {
        new Thread(new a(context)).start();
    }

    public static String b() {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.c.l() || !com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return "";
        }
        if (f) {
            return e;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            try {
                ContentResolver contentResolver = com.mbridge.msdk.foundation.controller.c.m().d().getContentResolver();
                int i2 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking");
                String string = Settings.Secure.getString(contentResolver, "advertising_id");
                jSONObject.put("status", i2);
                jSONObject.put("amazonId", string);
                String jSONObject2 = jSONObject.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    g = jSONObject2;
                    e = j0.b(jSONObject2);
                }
            } catch (Settings.SettingNotFoundException e2) {
                p0.b("DomainSameDiTool", e2.getMessage());
            }
        } catch (Throwable th) {
            p0.b("DomainSameDiTool", th.getMessage());
        }
        f = true;
        return e;
    }

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        try {
            WebEnvCheckEntry.class.getMethod("check", Context.class).invoke(WebEnvCheckEntry.class.newInstance(), context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void a(String str) {
        b = j0.b(str);
        f4362a = str;
    }

    public static boolean b(Context context) {
        try {
        } catch (Exception unused) {
            h = false;
        }
        if (i) {
            return h;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            h = context.getPackageManager().checkPermission(j0.a("DkP3hrKuHoPMH+zwL+fALkK/WQc5x5zH+TcincKNNVfWNVJcVM=="), context.getPackageName()) == 0;
        } else {
            h = true;
        }
        i = true;
        return h;
    }
}
