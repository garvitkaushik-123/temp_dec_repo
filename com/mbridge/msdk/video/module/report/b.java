package com.mbridge.msdk.video.module.report;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.metrics.d;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.p0;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: VideoViewReport.java */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, ArrayList<String>> f5160a = new HashMap<>();

    public static void a(String str) {
        f5160a.remove(str);
    }

    public static void b(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().e() == null) {
            return;
        }
        d.b().a("2000143", campaignEx);
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().e(), false, false);
    }

    public static void c(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().n() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().n(), false, false);
    }

    public static void d(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().k() == null) {
            return;
        }
        d.b().a("2000141", campaignEx);
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().k(), false, false);
    }

    public static void e(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().m() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().m(), false, false);
    }

    public static void f(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().s() == null) {
            return;
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().s(), false, false);
    }

    public static void a(Context context, CampaignEx campaignEx) {
        if (campaignEx == null || campaignEx.getNativeVideoTracking() == null || campaignEx.getNativeVideoTracking().d() == null) {
            return;
        }
        String campaignUnitId = campaignEx.getCampaignUnitId();
        ArrayList<String> arrayList = f5160a.get(campaignUnitId);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            f5160a.put(campaignUnitId, arrayList);
        }
        if (arrayList.contains(campaignEx.getId())) {
            return;
        }
        try {
            d.b().a("2000142", campaignEx);
        } catch (Exception unused) {
        }
        com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().d(), false, false);
        arrayList.add(campaignEx.getId());
    }

    public static void a(Context context, CampaignEx campaignEx, int i, int i2) {
        String str;
        try {
            String[] h = campaignEx.getNativeVideoTracking().h();
            if (campaignEx.getNativeVideoTracking() == null || h == null) {
                return;
            }
            String[] strArr = new String[h.length];
            for (int i3 = 0; i3 < h.length; i3++) {
                String str2 = h[i3];
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("endscreen_type", i);
                String jSONObject2 = jSONObject.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    jSONObject2 = j0.b(jSONObject2);
                }
                if (!TextUtils.isEmpty(jSONObject2)) {
                    str2 = str2 + "&value=" + URLEncoder.encode(jSONObject2);
                }
                if (campaignEx.getSpareOfferFlag() == 1) {
                    str = str2 + "&to=1&cbt=" + campaignEx.getCbt() + "&tmorl=" + i2;
                } else {
                    str = str2 + "&to=0&cbt=" + campaignEx.getCbt() + "&tmorl=" + i2;
                }
                strArr[i3] = str;
            }
            try {
                e eVar = new e();
                eVar.a("type", Integer.valueOf(i));
                d.b().a("2000144", campaignEx, eVar);
                d.b().a("2000147", campaignEx, eVar);
            } catch (Exception unused) {
            }
            com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), strArr, false, true);
        } catch (Throwable unused2) {
            p0.b("VideoViewReport", "reportEndcardshowData error");
        }
    }

    public static void a(Context context, CampaignEx campaignEx, int i, int i2, int i3) {
        String str;
        if (i2 == 0 || context == null || campaignEx == null) {
            return;
        }
        try {
            List<Map<Integer, String>> o = campaignEx.getNativeVideoTracking().o();
            int i4 = ((i + 1) * 100) / i2;
            if (o != null) {
                int i5 = 0;
                int i6 = 0;
                while (i5 < o.size()) {
                    Map<Integer, String> map = o.get(i5);
                    if (map != null && map.size() > 0) {
                        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                        int i7 = i5;
                        while (it.hasNext()) {
                            Map.Entry<Integer, String> next = it.next();
                            int intValue = next.getKey().intValue();
                            String value = next.getValue();
                            if (campaignEx.getSpareOfferFlag() == 1) {
                                str = value + "&to=1&cbt=" + campaignEx.getCbt() + "&tmorl=" + i3;
                            } else {
                                str = value + "&to=0&cbt=" + campaignEx.getCbt() + "&tmorl=" + i3;
                            }
                            if (intValue <= i4 && !TextUtils.isEmpty(str)) {
                                String[] strArr = {str};
                                if (i6 < 1) {
                                    i6++;
                                    try {
                                        e eVar = new e();
                                        eVar.a("percent", Integer.valueOf(intValue));
                                        d.b().a("2000140", campaignEx, eVar);
                                    } catch (Exception unused) {
                                    }
                                }
                                int i8 = i6;
                                com.mbridge.msdk.click.a.a(context, campaignEx, campaignEx.getCampaignUnitId(), strArr, false, true);
                                it.remove();
                                o.remove(i7);
                                i7--;
                                i6 = i8;
                            }
                        }
                        i5 = i7;
                    }
                    i5++;
                }
            }
        } catch (Throwable unused2) {
            p0.b("VideoViewReport", "reportPlayPercentageData error");
        }
    }

    public static void a(CampaignEx campaignEx, Map<Integer, String> map, String str, int i) {
        if (campaignEx == null || map == null) {
            return;
        }
        try {
            if (map.size() > 0) {
                Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry<Integer, String> next = it.next();
                    Integer key = next.getKey();
                    String value = next.getValue();
                    if (i == key.intValue() && !TextUtils.isEmpty(value)) {
                        CampaignEx campaignEx2 = campaignEx;
                        String str2 = str;
                        com.mbridge.msdk.click.a.a(c.m().d(), campaignEx2, str2, value, false, false);
                        it.remove();
                        campaignEx = campaignEx2;
                        str = str2;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (campaignEx.getAdUrlList() == null || campaignEx.getAdUrlList().size() <= 0) {
                    return;
                }
                for (String str2 : campaignEx.getAdUrlList()) {
                    if (!TextUtils.isEmpty(str2)) {
                        CampaignEx campaignEx2 = campaignEx;
                        String str3 = str;
                        com.mbridge.msdk.click.a.a(c.m().d(), campaignEx2, str3, str2, false, false);
                        campaignEx = campaignEx2;
                        str = str3;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void a(CampaignEx campaignEx, com.mbridge.msdk.videocommon.entity.c cVar, String str, String str2, String str3) {
        if (campaignEx == null || cVar == null) {
            return;
        }
        try {
            com.mbridge.msdk.video.module.request.b bVar = new com.mbridge.msdk.video.module.request.b(c.m().d());
            com.mbridge.msdk.foundation.same.net.wrapper.e eVar = new com.mbridge.msdk.foundation.same.net.wrapper.e();
            eVar.a("user_id", j0.b(str2));
            eVar.a("cb_type", "1");
            eVar.a("reward_name", cVar.c());
            eVar.a("reward_amount", cVar.a() + "");
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            eVar.a("click_id", campaignEx.getRequestIdNotice());
            if (!TextUtils.isEmpty(str3)) {
                eVar.a("extra", str3);
            }
            bVar.addExtraParams("", eVar);
            String a2 = a(campaignEx.getHost() + "/addReward?", eVar);
            p0.b("VideoViewReport", "rewardUrl:" + a2);
            com.mbridge.msdk.click.a.a(c.m().d(), campaignEx, campaignEx.getCampaignUnitId(), a2, false, false);
        } catch (Throwable th) {
            p0.b("VideoViewReport", th.getMessage(), th);
        }
    }

    private static String a(String str, com.mbridge.msdk.foundation.same.net.wrapper.e eVar) {
        if (eVar == null) {
            return "";
        }
        String trim = eVar.b().trim();
        if (TextUtils.isEmpty(trim)) {
            return "";
        }
        if (!str.endsWith("?") && !str.endsWith(C3040d4.i.c)) {
            str = str + (str.contains("?") ? C3040d4.i.c : "?");
        }
        return str + trim;
    }
}
