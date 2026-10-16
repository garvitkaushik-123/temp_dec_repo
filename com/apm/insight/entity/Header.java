package com.apm.insight.entity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.autofill.HintConstants;
import com.adjust.sdk.Constants;
import com.apm.insight.e;
import com.apm.insight.l.k;
import com.apm.insight.l.l;
import com.apm.insight.runtime.o;
import com.ironsource.C3040d4;
import com.ironsource.C3114ha;
import com.ironsource.N6;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.Iterator;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class Header {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f238a = {"version_code", "manifest_version_code", C3114ha.b, "update_version_code"};
    private static String d = null;
    private static int e = -1;
    private static int f = -1;
    private Context b;
    private JSONObject c = new JSONObject();

    public Header(Context context) {
        this.b = context;
    }

    public static Header a(Context context) {
        Header header = new Header(context);
        JSONObject jSONObject = header.c;
        try {
            jSONObject.put(BidTokenRepositoryKt.SDK_VERSION, 20089);
            jSONObject.put("sdk_version_name", "2008-20250701130429");
        } catch (Exception unused) {
        }
        return header;
    }

    public static Header a(long j) {
        Header a2;
        o a3 = o.a();
        if (j == 0) {
            j = System.currentTimeMillis();
        }
        JSONObject a4 = a3.a(j);
        if (a4 == null || a4.length() == 0) {
            a2 = a(e.g());
            a2.c();
            try {
                a2.c.put("errHeader", 1);
            } catch (Throwable unused) {
            }
        } else {
            try {
                if (!a4.has(C3114ha.b)) {
                    a4.put(C3114ha.b, 4444);
                }
            } catch (Exception unused2) {
            }
            a2 = new Header(e.g());
        }
        b(a2);
        a2.a(a4);
        return a2;
    }

    public static Header b(Context context) {
        Header a2 = a(context);
        a(a2);
        b(a2);
        a2.c();
        a2.d();
        a2.e();
        return a2;
    }

    private static String g() {
        if (d == null) {
            try {
                StringBuilder sb = new StringBuilder();
                if (Build.SUPPORTED_ABIS.length > 0) {
                    for (int i = 0; i < Build.SUPPORTED_ABIS.length; i++) {
                        sb.append(Build.SUPPORTED_ABIS[i]);
                        if (i != Build.SUPPORTED_ABIS.length - 1) {
                            sb.append(", ");
                        }
                    }
                } else {
                    sb = new StringBuilder(Build.CPU_ABI);
                }
                if (TextUtils.isEmpty(sb.toString())) {
                    d = "unknown";
                }
                d = sb.toString();
            } catch (Exception e2) {
                com.apm.insight.a.b((Throwable) e2);
                d = "unknown";
            }
        }
        return d;
    }

    public static boolean a() {
        if (e == -1) {
            e = g().contains("64") ? 1 : 0;
        }
        return e == 1;
    }

    public static boolean b() {
        if (f == -1) {
            f = g().contains("86") ? 1 : 0;
        }
        return f == 1;
    }

    public final JSONObject a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return this.c;
        }
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                this.c.put(next, jSONObject.opt(next));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return this.c;
    }

    public final JSONObject c() {
        return a(e.a().a());
    }

    public final JSONObject a(Map<String, Object> map) {
        if (map == null) {
            return this.c;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (!this.c.has(entry.getKey())) {
                this.c.put(entry.getKey(), entry.getValue());
            }
        }
        String[] strArr = f238a;
        for (int i = 0; i < 4; i++) {
            String str = strArr[i];
            if (map.containsKey(str)) {
                try {
                    this.c.put(str, Integer.parseInt(String.valueOf(map.get(str))));
                } catch (Throwable unused) {
                    this.c.put(str, map.get(str));
                }
            }
        }
        if (map.containsKey("version_code") && !map.containsKey("manifest_version_code")) {
            try {
                this.c.put("manifest_version_code", Integer.parseInt(String.valueOf(map.get("version_code"))));
            } catch (Throwable unused2) {
            }
        }
        if (map.containsKey("iid")) {
            this.c.put("udid", map.get("iid"));
            this.c.remove("iid");
        }
        if (map.containsKey("version_name")) {
            this.c.put(BidTokenRepositoryKt.APP_VERSION, map.get("version_name"));
            this.c.remove("version_name");
        }
        return this.c;
    }

    public final JSONObject d() {
        try {
            this.c.put("device_id", e.c().a());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.c;
    }

    public final JSONObject e() {
        try {
            long f2 = e.a().f();
            if (f2 > 0) {
                this.c.put("user_id", f2);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return this.c;
    }

    public final JSONObject f() {
        return this.c;
    }

    public static boolean b(JSONObject jSONObject) {
        return jSONObject.optInt("unauthentic_version", 0) == 1;
    }

    public static boolean c(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return true;
        }
        return (jSONObject.opt(BidTokenRepositoryKt.APP_VERSION) == null && jSONObject.opt("version_name") == null) || jSONObject.opt("version_code") == null || jSONObject.opt("update_version_code") == null;
    }

    public static boolean d(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            String optString = jSONObject.optString(C3114ha.b);
            if (TextUtils.isEmpty(optString)) {
                return true;
            }
            try {
                return Integer.parseInt(optString) <= 0;
            } catch (Throwable unused) {
            }
        }
        return true;
    }

    public static void addRuntimeHeader(JSONObject jSONObject) {
        try {
            jSONObject.put("access", k.a(e.g()));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) e.g().getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            if (telephonyManager != null) {
                String networkOperatorName = telephonyManager.getNetworkOperatorName();
                if (!TextUtils.isEmpty(networkOperatorName)) {
                    jSONObject.put(N6.P0, networkOperatorName);
                }
                String networkOperator = telephonyManager.getNetworkOperator();
                if (TextUtils.isEmpty(networkOperator)) {
                    return;
                }
                jSONObject.put("mcc_mnc", networkOperator);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }

    public static Header a(Header header) {
        addRuntimeHeader(header.c);
        return header;
    }

    public static void b(Header header) {
        if (header == null) {
            return;
        }
        addOtherHeader(header.c);
    }

    public static void addOtherHeader(JSONObject jSONObject) {
        Object obj;
        if (jSONObject == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        try {
            if (com.apm.insight.l.d.b()) {
                sb.append("MIUI-");
            } else if (com.apm.insight.l.d.c()) {
                sb.append("FLYME-");
            } else {
                String a2 = com.apm.insight.l.d.a();
                if (com.apm.insight.l.d.a(a2)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(a2)) {
                    sb.append(a2).append("-");
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
            if (sb.length() > 0) {
                jSONObject.put("rom", sb.toString());
            }
            jSONObject.put("rom_version", l.a());
        } catch (Throwable unused) {
        }
        try {
            DisplayMetrics displayMetrics = e.g().getResources().getDisplayMetrics();
            int i = displayMetrics.densityDpi;
            if (i == 120) {
                obj = "ldpi";
            } else if (i == 240) {
                obj = "hdpi";
            } else if (i == 320) {
                obj = "xhdpi";
            } else {
                obj = "mdpi";
            }
            jSONObject.put("density_dpi", i);
            jSONObject.put("display_density", obj);
            jSONObject.put("resolution", displayMetrics.heightPixels + VastAttributes.HORIZONTAL_POSITION + displayMetrics.widthPixels);
        } catch (Exception unused2) {
        }
        try {
            String language = e.g().getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put("language", language);
            }
            int rawOffset = TimeZone.getDefault().getRawOffset() / Constants.ONE_HOUR;
            if (rawOffset < -12) {
                rawOffset = -12;
            }
            if (rawOffset > 12) {
                rawOffset = 12;
            }
            jSONObject.put("timezone", rawOffset);
        } catch (Exception unused3) {
        }
        try {
            jSONObject.put(N6.F, C3040d4.d);
            jSONObject.put("device_id", e.c().a());
            String str = Build.VERSION.RELEASE;
            if (!str.contains(".")) {
                str = str + ".0";
            }
            jSONObject.put("os_version", str);
            jSONObject.put("os_api", Build.VERSION.SDK_INT);
            String str2 = Build.MODEL;
            String str3 = Build.BRAND;
            if (str2 == null) {
                str2 = str3;
            } else if (str3 != null && !str2.contains(str3)) {
                str2 = str3 + ' ' + str2;
            }
            jSONObject.put(BidTokenRepositoryKt.DEVICE_MODEL, str2);
            jSONObject.put("device_brand", Build.BRAND);
            jSONObject.put(BidTokenRepositoryKt.DEVICE_MANUFACTURER, Build.MANUFACTURER);
            jSONObject.put("cpu_abi", g());
            Context g = e.g();
            String packageName = g.getPackageName();
            jSONObject.put("package", packageName);
            PackageInfo packageInfo = g.getPackageManager().getPackageInfo(packageName, 0);
            if (packageInfo.applicationInfo != null) {
                int i2 = packageInfo.applicationInfo.labelRes;
                if (i2 > 0) {
                    jSONObject.put("display_name", g.getString(i2));
                } else {
                    jSONObject.put("display_name", g.getPackageManager().getApplicationLabel(packageInfo.applicationInfo));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        d.a(jSONObject);
    }
}
