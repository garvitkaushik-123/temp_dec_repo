package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class Y4 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f3140a = "Y4";

    public static JSONObject a(Context context) {
        SDKUtils.loadGoogleAdvertiserInfo(context);
        String advertiserId = SDKUtils.getAdvertiserId();
        String limitAdTracking = SDKUtils.getLimitAdTracking();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(advertiserId)) {
                Logger.i(f3140a, "add AID");
                jSONObject.put("deviceIds[AID]", SDKUtils.encodeString(advertiserId));
            }
            if (!TextUtils.isEmpty(limitAdTracking)) {
                Logger.i(f3140a, "add LAT");
                jSONObject.put(C3040d4.i.M, Boolean.parseBoolean(limitAdTracking));
                return jSONObject;
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObject;
    }

    public static JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        d(context, jSONObject);
        c(jSONObject);
        b(context, jSONObject);
        g(context, jSONObject);
        e(context, jSONObject);
        b(jSONObject);
        f(context, jSONObject);
        c(context, jSONObject);
        a(context, jSONObject);
        h(context, jSONObject);
        return jSONObject;
    }

    private static void c(JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.y), SDKUtils.encodeString(String.valueOf(C3334ub.U().i().h())));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void d(Context context, JSONObject jSONObject) {
        try {
            String b = C2986a4.b(context);
            String d = C2986a4.d(context);
            if (!TextUtils.isEmpty(d)) {
                jSONObject.put(SDKUtils.encodeString("rawConnectionType"), SDKUtils.encodeString(d));
            }
            if (!TextUtils.isEmpty(b) && !b.equals("none")) {
                jSONObject.put(SDKUtils.encodeString("connectionType"), SDKUtils.encodeString(b));
            }
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.v), C2986a4.e(context));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void e(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.P), Z4.b(context).a(context));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void f(Context context, JSONObject jSONObject) {
        InterfaceC3381x7 i = C3334ub.U().i();
        try {
            if (a(C3040d4.i.k0)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.k0), i.C(context));
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void g(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString(N6.Y0), C3334ub.U().i().J(context));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void h(Context context, JSONObject jSONObject) {
        InterfaceC3381x7 i = C3334ub.U().i();
        try {
            if (a(C3040d4.i.n0)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.n0), i.h(context));
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void b(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.Y), C3334ub.U().i().k(context));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void c(Context context, JSONObject jSONObject) {
        InterfaceC3381x7 i = C3334ub.U().i();
        try {
            if (a(C3040d4.i.l0)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.l0), i.D(context));
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void b(JSONObject jSONObject) {
        InterfaceC3381x7 i = C3334ub.U().i();
        try {
            if (a(C3040d4.i.i0)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.i0), i.j());
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public static JSONObject c(Context context) {
        InterfaceC3381x7 i = C3334ub.U().i();
        Z4 b = Z4.b(context);
        JSONObject jSONObject = new JSONObject();
        try {
            String d = b.d();
            if (d != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOEM"), SDKUtils.encodeString(d));
            }
            String c = b.c();
            if (c != null) {
                jSONObject.put(SDKUtils.encodeString("deviceModel"), SDKUtils.encodeString(c));
            }
            String e = b.e();
            if (e != null) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.m), SDKUtils.encodeString(e));
            }
            String f = b.f();
            if (f != null) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.n), f.replaceAll("[^0-9/.]", ""));
            }
            String f2 = b.f();
            if (f2 != null) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.o), SDKUtils.encodeString(f2));
            }
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.p), String.valueOf(b.a()));
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.q), SDKUtils.encodeString(SDKUtils.getSDKVersion()));
            if (b.b() != null && b.b().length() > 0) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.r), SDKUtils.encodeString(b.b()));
            }
            String language = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.x), SDKUtils.encodeString(language.toUpperCase(Locale.getDefault())));
            }
            if (a(C3040d4.i.j0)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.j0), SDKUtils.encodeString(String.valueOf(i.q(context))));
            }
            String g = C1.g(context);
            if (!TextUtils.isEmpty(g)) {
                jSONObject.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(g));
            }
            String valueOf = String.valueOf(i.r());
            if (!TextUtils.isEmpty(valueOf)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.K), SDKUtils.encodeString(valueOf));
            }
            String valueOf2 = String.valueOf(i.p());
            if (!TextUtils.isEmpty(valueOf2)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.O), SDKUtils.encodeString(valueOf2));
            }
            jSONObject.put(SDKUtils.encodeString("gpi"), Lc.d(context));
            jSONObject.put("mcc", Z3.b(context));
            jSONObject.put("mnc", Z3.c(context));
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.S), Z3.f(context));
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.R), SDKUtils.encodeString(Z3.g(context)));
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.V), C1.f(context));
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.X), C1.d(context));
            jSONObject.put(SDKUtils.encodeString(C3040d4.i.W), SDKUtils.encodeString(C1.b(context)));
            jSONObject.put(SDKUtils.encodeString("stid"), Lc.c(context));
            String e2 = C1.e(context);
            if (!TextUtils.isEmpty(e2)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.c0), SDKUtils.encodeString(e2));
            }
            jSONObject.put(C3040d4.i.d0, SDKUtils.encodeString(String.valueOf(i.a())));
            jSONObject.put(C3040d4.i.e0, SDKUtils.encodeString(String.valueOf(i.m())));
            String G = i.G(context);
            if (!TextUtils.isEmpty(G)) {
                jSONObject.put("icc", G);
            }
            String d2 = i.d();
            if (!TextUtils.isEmpty(d2)) {
                jSONObject.put("tz", SDKUtils.encodeString(d2));
            }
            jSONObject.put("uxt", IronSourceStorageUtils.isUxt());
            return jSONObject;
        } catch (Exception e3) {
            C3260q4.d().a(e3);
            IronLog.INTERNAL.error(e3.toString());
            return jSONObject;
        }
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            jSONObject.put(str, SDKUtils.encodeString(str2));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static boolean a(String str) {
        return SDKUtils.getControllerConfigAsJSONObject().optBoolean(str);
    }

    private static void a(JSONObject jSONObject) {
        InterfaceC3381x7 i = C3334ub.U().i();
        try {
            a(jSONObject, C3040d4.i.H, String.valueOf(i.k()));
            a(jSONObject, C3040d4.i.I, String.valueOf(i.c()));
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private static void a(Context context, JSONObject jSONObject) {
        InterfaceC3381x7 i = C3334ub.U().i();
        try {
            if (a(C3040d4.i.m0)) {
                jSONObject.put(SDKUtils.encodeString(C3040d4.i.m0), i.e(context));
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }
}
