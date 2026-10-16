package com.mbridge.msdk.mbbid.common;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.f0;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.s0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.w0;
import com.mbridge.msdk.mbbid.out.BidConstants;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BidCommon.java */
/* loaded from: classes6.dex */
public class b extends a {

    /* renamed from: a, reason: collision with root package name */
    public static Map<String, String> f4483a = new HashMap();
    public static JSONArray b;

    public static String a(Context context, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(BidConstants.BID_FILTER_KEY_UNIT_ID, str);
        return a(context, hashMap);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004b, code lost:
    
        r14 = java.lang.System.currentTimeMillis();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        if (r12 <= 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        if ((r14 - r12) >= (r7.optInt("ttl") * 1000)) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0090, code lost:
    
        a(r19, r9, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0097, code lost:
    
        r0 = 0;
        r2 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0099, code lost:
    
        r5 = r2;
        r2 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
    
        r8 = r7.optDouble("rate");
        r0 = new java.util.Random().nextInt(100);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0079, code lost:
    
        if (r8 == 0.0d) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0081, code lost:
    
        if ((r8 * 100.0d) < r0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
    
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0086, code lost:
    
        r4 = r0;
        r2 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0085, code lost:
    
        r0 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008d, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008e, code lost:
    
        r2 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a1, code lost:
    
        r5 = r2;
        r2 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00af, code lost:
    
        if (com.mbridge.msdk.MBridgeConstans.DEBUG != false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b1, code lost:
    
        com.mbridge.msdk.foundation.tools.p0.b("BidCommon", r0.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ba, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0094, code lost:
    
        a(r19, r9, r14);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x009c, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x009d, code lost:
    
        r2 = 1;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean b(Context context, String str) {
        int i;
        int i2;
        JSONArray jSONArray = b;
        int i3 = 2;
        if (jSONArray == null || jSONArray.length() == 0) {
            a(str, 2);
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        int i4 = 0;
        while (true) {
            try {
                if (i4 >= b.length()) {
                    i2 = 0;
                    i = 0;
                    break;
                }
                JSONObject optJSONObject = b.optJSONObject(i4);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("key_tpl");
                    String optString2 = optJSONObject.optString("key_value");
                    long longValue = ((Long) w0.a(context, optString2, 0L)).longValue();
                    if (a(optString, optString2)) {
                        try {
                            break;
                        } catch (Exception e) {
                            e = e;
                            int i5 = 0;
                        }
                    }
                }
                i4++;
            } catch (Exception e2) {
                e = e2;
                i = 0;
            }
        }
        a(i3, jSONObject, i, i2);
        a(str, i3);
        return i3 != 1;
    }

    public static String a(Context context, Map<String, String> map) {
        String str;
        String str2;
        f4483a = map;
        try {
            if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                com.mbridge.msdk.foundation.controller.c.m().b(context);
            }
            if (b == null) {
                b = h.b().b(com.mbridge.msdk.foundation.controller.c.m().b()).i0();
            }
            str = SameMD5.getMD5(u0.d());
            try {
                if (b(context, str)) {
                    return "";
                }
                Map<String, String> map2 = f4483a;
                if (map2 == null || !map2.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID)) {
                    str2 = "";
                } else {
                    str2 = f4483a.get(BidConstants.BID_FILTER_KEY_UNIT_ID);
                }
                return a(context, str2, str);
            } catch (Exception unused) {
                return a(context, "", str);
            }
        } catch (Exception unused2) {
            str = "";
        }
    }

    public static String a(Context context, String str, String str2) {
        long j;
        StringBuffer stringBuffer = new StringBuffer();
        if (context != null) {
            try {
                if (com.mbridge.msdk.foundation.controller.c.m().d() == null) {
                    com.mbridge.msdk.foundation.controller.c.m().b(context);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("BidCommon", e.getMessage());
                }
            }
        }
        g d = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d == null) {
            d = h.b().a();
        }
        stringBuffer.append(f.d()).append("|");
        stringBuffer.append(a.a(1, d, context)).append("|");
        stringBuffer.append(a.a(2, d, context)).append("|");
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(l0.s()).append("|");
        stringBuffer.append(l0.t()).append("|");
        stringBuffer.append(l0.s(context)).append("|");
        stringBuffer.append(MBConfiguration.SDK_VERSION).append("|");
        stringBuffer.append(l0.n(context)).append(VastAttributes.HORIZONTAL_POSITION).append(l0.m(context)).append("|");
        stringBuffer.append(l0.i()).append("|");
        stringBuffer.append(a.a(3, d, context)).append("|");
        stringBuffer.append(u0.b(20)).append("|");
        stringBuffer.append(System.currentTimeMillis()).append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.same.a.d).append("|");
        stringBuffer.append(l0.v()).append("|");
        stringBuffer.append(l0.h()).append("|");
        stringBuffer.append(a.a(4, d, context)).append("|");
        stringBuffer.append(a.a(5, d, context)).append("|");
        stringBuffer.append(a.a(6, d, context)).append("|");
        stringBuffer.append(s0.c()).append("|");
        stringBuffer.append(s0.a()).append("|");
        try {
            j = k0.a();
        } catch (Exception unused) {
            j = 0;
        }
        if (j > 0) {
            stringBuffer.append(j).append("|");
        } else {
            stringBuffer.append("").append("|");
        }
        stringBuffer.append("|");
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)).append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c"));
        stringBuffer.append("|").append(l0.j());
        stringBuffer.append("|").append(d != null ? d.a() : "");
        stringBuffer.append("|");
        stringBuffer.append(u0.a());
        stringBuffer.append("|");
        String c = u0.c();
        if (TextUtils.isEmpty(c)) {
            c = "";
        }
        stringBuffer.append(c);
        stringBuffer.append("|");
        stringBuffer.append(u0.c(str));
        stringBuffer.append("|");
        if (d != null && d.s0() == 1 && com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            stringBuffer.append(a.a(7, d, context));
        }
        stringBuffer.append("|");
        stringBuffer.append(l0.D());
        stringBuffer.append("|");
        stringBuffer.append(l0.D(context));
        stringBuffer.append("|");
        stringBuffer.append(l0.B() + "");
        stringBuffer.append("|");
        stringBuffer.append(l0.e(com.mbridge.msdk.foundation.controller.c.m().i()) + "");
        stringBuffer.append("|");
        stringBuffer.append(l0.C());
        stringBuffer.append("|");
        stringBuffer.append(com.mbridge.msdk.foundation.controller.authoritycontroller.b.i() ? "1" : "2");
        stringBuffer.append("|");
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            stringBuffer.append(a.a(8, d, context));
        }
        stringBuffer.append("|").append("");
        stringBuffer.append("|").append("");
        stringBuffer.append("|").append("");
        stringBuffer.append("|").append("1");
        stringBuffer.append("|").append(com.mbridge.msdk.foundation.controller.authoritycontroller.c.m().c());
        stringBuffer.append("|");
        if (l0.y() != 0) {
            stringBuffer.append(l0.y() + "");
        }
        if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
            stringBuffer.append("|").append(1);
        } else {
            stringBuffer.append("|").append("");
        }
        stringBuffer.append("|").append("");
        stringBuffer.append("|").append(str2);
        stringBuffer.append("|").append(l0.r(context));
        stringBuffer.append("|").append(l0.q(context));
        stringBuffer.append("|").append(f.e());
        stringBuffer.append("|").append(f.a());
        stringBuffer.append("|").append(com.mbridge.msdk.util.c.b);
        stringBuffer.append("|").append("");
        stringBuffer.append("|").append(f0.a().b());
        stringBuffer.append("|").append(l0.k(context));
        stringBuffer.append("|").append(l0.u(context));
        stringBuffer.append("|").append(l0.o(context));
        return j0.b(stringBuffer.toString());
    }

    public static void a(Context context, String str, long j) {
        w0.b(context, str, Long.valueOf(j));
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        if (str.equals(str2)) {
            return true;
        }
        for (String str3 : str.split("-")) {
            if (!TextUtils.isEmpty(str3) && str3.length() > 2 && str3.startsWith("{") && str3.endsWith("}")) {
                String substring = str3.substring(1, str3.length() - 1);
                Map<String, String> map = f4483a;
                if (map != null && map.containsKey(substring)) {
                    String valueOf = String.valueOf(f4483a.get(substring));
                    if (!TextUtils.isEmpty(valueOf)) {
                        str = str.replace(str3, valueOf + "");
                    }
                } else if (BidConstants.BID_FILTER_KEY_NETWORK.equals(str3)) {
                    str = str.replace(str3, l0.s(com.mbridge.msdk.foundation.controller.c.m().d()) + "");
                }
            }
        }
        return str.equals(str2);
    }

    private static void a(int i, JSONObject jSONObject, int i2, int i3) {
        try {
            Context d = com.mbridge.msdk.foundation.controller.c.m().d();
            if (d != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(C3040d4.h.W, "2000122");
                jSONObject2.put("filter", i);
                jSONObject2.put("network_type", l0.s(d));
                jSONObject2.put("timeout", i2);
                if (jSONObject != null && jSONObject.length() > 0) {
                    jSONObject2.put("hitNode", jSONObject);
                }
                jSONObject2.put("hitRate", i3);
                Map<String, String> map = f4483a;
                if (map != null) {
                    if (map.containsKey(BidConstants.BID_FILTER_KEY_UNIT_ID)) {
                        jSONObject2.put(MBridgeConstans.PROPERTIES_UNIT_ID, f4483a.get(BidConstants.BID_FILTER_KEY_UNIT_ID));
                    }
                    if (f4483a.containsKey(BidConstants.BID_FILTER_KEY_PLACEMENT_ID)) {
                        jSONObject2.put("placementId", f4483a.get(BidConstants.BID_FILTER_KEY_PLACEMENT_ID));
                    }
                    if (f4483a.containsKey(BidConstants.BID_FILTER_KEY_AD_TYPE)) {
                        jSONObject2.put("adType", f4483a.get(BidConstants.BID_FILTER_KEY_AD_TYPE));
                    }
                }
                d.b().a(jSONObject2);
            }
        } catch (Throwable th) {
            p0.b("BidCommon", th.getMessage());
        }
    }

    private static void a(String str, int i) {
        e eVar = new e();
        eVar.a("filter", Integer.valueOf(i));
        eVar.a("lrid", str);
        d.b().b("2000124", eVar);
    }
}
