package com.mbridge.msdk.foundation.same.net.wrapper;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.browser.trusted.sharing.ShareTarget;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.DomainNameUtils;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.out.CustomInfoManager;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.tracker.network.k;
import com.mbridge.msdk.tracker.network.l;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: CommonAsyncHttpRequest.java */
/* loaded from: classes6.dex */
public class c {
    private static final String TAG = "c";
    protected Context mContext;

    public c(Context context) {
        if (context == null) {
            this.mContext = com.mbridge.msdk.foundation.controller.c.m().d();
        } else {
            this.mContext = context.getApplicationContext();
        }
    }

    private String asUrlParams(Map<String, String> map) {
        if (map != null && map.size() != 0) {
            StringBuilder sb = new StringBuilder();
            try {
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        String str2 = map.get(str);
                        if (TextUtils.isEmpty(str2)) {
                            str2 = "";
                        }
                        sb.append(C3040d4.i.c).append(str).append(C3040d4.i.b).append(str2);
                    }
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b(TAG, e.getMessage());
                }
                sb = null;
            }
            if (sb != null && sb.length() > 0) {
                return sb.toString();
            }
        }
        return null;
    }

    private static com.mbridge.msdk.tracker.network.h<?> createRequest(int i, int i2, String str, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        if (i == 0) {
            return new k(i2, str, str2, j, new i(bVar));
        }
        if (i != 1) {
            return null;
        }
        return new com.mbridge.msdk.tracker.network.i(i2, str, str2, j, new i(bVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x009e A[Catch: Exception -> 0x00eb, TRY_ENTER, TryCatch #1 {Exception -> 0x00eb, blocks: (B:23:0x009e, B:25:0x00a4, B:43:0x00af, B:47:0x00d0, B:52:0x00ef), top: B:21:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ed  */
    /* JADX WARN: Type inference failed for: r11v6, types: [com.mbridge.msdk.tracker.network.h, com.mbridge.msdk.tracker.network.t] */
    /* JADX WARN: Type inference failed for: r12v12, types: [com.mbridge.msdk.tracker.network.u] */
    /* JADX WARN: Type inference failed for: r13v8, types: [java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x01a3 -> B:48:0x01fc). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x01e3 -> B:48:0x01fc). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void post(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z, boolean z2, String str2, long j) {
        e eVar2;
        String str3;
        e eVar3;
        com.mbridge.msdk.setting.a j2;
        String str4;
        int i2;
        ?? createRequest;
        int i3;
        String str5;
        int i4;
        String str6;
        eVar = eVar;
        if (eVar == null) {
            try {
                eVar = new e();
            } catch (Exception e) {
                p0.a(TAG, e.getMessage());
                eVar2 = eVar;
            }
        }
        addExtraParams(str, eVar);
        f.k(eVar);
        com.mbridge.msdk.foundation.same.net.e a2 = com.mbridge.msdk.foundation.same.net.utils.c.b().a(eVar);
        eVar2 = eVar;
        eVar2 = eVar;
        if (a2 != null && bVar != null) {
            bVar.onSuccess(a2);
            return;
        }
        p0.c(TAG, "post url = " + str);
        String str7 = "";
        if (str.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().d)) {
            com.mbridge.msdk.setting.g d = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d != null) {
                i4 = d.K();
                try {
                    str6 = eVar2.a().get("data");
                    if (!z2) {
                        try {
                            if (!com.mbridge.msdk.foundation.same.report.b.a(d, str6)) {
                                return;
                            }
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            str5 = d.k();
                            i3 = d.y0();
                            eVar2.a("a_stid", d.a());
                            eVar2.a("country_code", str5);
                            if (i4 != 2) {
                            }
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                    str6 = "";
                }
                str5 = d.k();
                i3 = d.y0();
                eVar2.a("a_stid", d.a());
            } else {
                i3 = 0;
                str5 = "UNKNOWN";
                i4 = 1;
                str6 = "";
            }
            eVar2.a("country_code", str5);
            try {
                if (i4 != 2) {
                    i = i;
                    str = str;
                    eVar2 = eVar2;
                    if (!TextUtils.isEmpty(str6)) {
                        i = i;
                        str = str;
                        eVar2 = eVar2;
                        if (com.mbridge.msdk.foundation.same.report.b.a(d, str6)) {
                            if (i3 == 1 || i3 == 3) {
                                com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().j, com.mbridge.msdk.foundation.same.net.utils.d.h().n, eVar2.toString(), false, bVar);
                                i = i;
                                str = str;
                                eVar2 = eVar2;
                            }
                        } else if (z2) {
                            if (i3 == 1 || i3 == 3) {
                                com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().j, com.mbridge.msdk.foundation.same.net.utils.d.h().n, eVar2.toString(), false, bVar);
                                i = i;
                                str = str;
                                eVar2 = eVar2;
                            }
                        }
                    }
                } else if (i4 == 1) {
                    com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().j, com.mbridge.msdk.foundation.same.net.utils.d.h().n, eVar2.toString(), false, bVar);
                    i = i;
                    str = str;
                    eVar2 = eVar2;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (str.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().h)) {
            com.mbridge.msdk.setting.g d2 = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d2 != null && (j2 = d2.j()) != null && j2.h() == 1) {
                com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().l, com.mbridge.msdk.foundation.same.net.utils.d.h().p, eVar2.toString(), false, bVar);
                return;
            }
        } else {
            boolean contains = str.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().d0);
            str = str;
            if (contains) {
                if (eVar2 != null) {
                    str = str + "?" + eVar2.toString();
                }
                JSONArray b = com.mbridge.msdk.foundation.db.middle.b.a().b();
                if (b != null) {
                    String jSONArray = b.toString();
                    e eVar4 = new e();
                    eVar4.a(e.k, jSONArray);
                    str3 = str;
                    eVar3 = eVar4;
                    i2 = i;
                    str4 = str;
                    createRequest = createRequest(i2, 1, str3, bVar, str2, j);
                    i = createRequest;
                    str = str4;
                    eVar2 = eVar3;
                    if (createRequest != 0) {
                        if (eVar3 != null && eVar3.a() != null) {
                            String str8 = eVar3.a().get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                            if (TextUtils.isEmpty(str8)) {
                                str8 = str7;
                            }
                            createRequest.a("local_id", str8);
                            String str9 = eVar3.a().get("ad_type");
                            if (!TextUtils.isEmpty(str9)) {
                                str7 = str9;
                            }
                            createRequest.a("ad_type", str7);
                            createRequest.a(eVar3.a());
                        }
                        createRequest.d(canTrack());
                        ?? r13 = ShareTarget.ENCODING_TYPE_URL_ENCODED;
                        createRequest.b("Content-Type", ShareTarget.ENCODING_TYPE_URL_ENCODED);
                        ?? b2 = l.a().b();
                        b2.a(createRequest);
                        i = createRequest;
                        str = b2;
                        eVar2 = r13;
                    }
                }
            }
        }
        str3 = str;
        i2 = i;
        str4 = str;
        eVar3 = eVar2;
        createRequest = createRequest(i2, 1, str3, bVar, str2, j);
        i = createRequest;
        str = str4;
        eVar2 = eVar3;
        if (createRequest != 0) {
        }
    }

    public void addExtraParams(String str, e eVar) {
        if (eVar == null) {
            p0.b(TAG, "addExtraParams error, params is null,frame work error");
            return;
        }
        String a2 = Aa.a();
        if (a2 == null) {
            a2 = "";
        }
        eVar.a("channel", a2);
        eVar.a("band_width", com.mbridge.msdk.foundation.same.net.a.b().a() + "");
        eVar.a("open", com.mbridge.msdk.foundation.same.a.S);
        if (com.mbridge.msdk.util.b.a() && !TextUtils.isEmpty(str) && str.contains("setting")) {
            String b = Aa.b();
            if (!TextUtils.isEmpty(b)) {
                eVar.a("keyword", b);
            }
        }
        String str2 = eVar.a().get(MBridgeConstans.PROPERTIES_UNIT_ID);
        if (str2 != null) {
            String customInfoByUnitId = CustomInfoManager.getInstance().getCustomInfoByUnitId(str2, str);
            if (!TextUtils.isEmpty(customInfoByUnitId)) {
                eVar.a("ch_info", customInfoByUnitId);
            }
            com.mbridge.msdk.setting.l e = com.mbridge.msdk.setting.h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), str2);
            if (e != null && !TextUtils.isEmpty(e.a())) {
                eVar.a("u_stid", e.a());
            }
        }
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.b.i()) {
            eVar.a("dev_source", "2");
        }
        if (DomainNameUtils.getInstance().isExcludeCNDomain()) {
            eVar.a("re_domain", "1");
        }
    }

    protected boolean canTrack() {
        return true;
    }

    public void choiceV3OrV5BySetting(int i, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str, long j) {
        e eVar2;
        com.mbridge.msdk.setting.g b = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
        int p0 = TextUtils.isEmpty(str) ? b.p0() : b.B();
        String a2 = com.mbridge.msdk.foundation.same.net.utils.d.h().a(str, p0);
        if (p0 < 2) {
            postV5(i, a2, eVar, bVar, "campaign", j);
            return;
        }
        if (p0 % 2 == 0) {
            if (eVar == null) {
                eVar = new e();
            }
            eVar2 = eVar;
            JSONArray b2 = com.mbridge.msdk.foundation.db.middle.b.a().b();
            if (b2 != null) {
                String jSONArray = b2.toString();
                int i2 = com.mbridge.msdk.foundation.same.net.utils.d.h().i();
                if (i2 > 0 && jSONArray.length() > i2) {
                    post(i, a2, eVar2, bVar, "campaign", j);
                    return;
                }
                eVar2.a(e.k, jSONArray);
            }
        } else {
            eVar2 = eVar;
        }
        getLoadOrSetting(i, a2, eVar2, bVar, "campaign", j);
    }

    public void get(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        get(i, str, eVar, bVar, false, false, str2, j);
    }

    public void getCampaign(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, long j) {
        e eVar2;
        try {
            com.mbridge.msdk.setting.g b = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
            int p0 = TextUtils.isEmpty(str) ? b.p0() : b.B();
            String a2 = com.mbridge.msdk.foundation.same.net.utils.d.h().a(str, p0);
            if (p0 < 2) {
                postV5(i, a2, eVar, bVar, true, "campaign", j);
                return;
            }
            if (p0 % 2 == 0) {
                if (eVar == null) {
                    eVar = new e();
                }
                eVar2 = eVar;
                JSONArray b2 = com.mbridge.msdk.foundation.db.middle.b.a().b();
                if (b2 != null) {
                    String jSONArray = b2.toString();
                    int i2 = com.mbridge.msdk.foundation.same.net.utils.d.h().i();
                    if (i2 > 0 && jSONArray.length() > i2) {
                        post(i, a2, eVar2, bVar, true, false, "campaign", j);
                        return;
                    }
                    eVar2.a(e.k, jSONArray);
                }
            } else {
                eVar2 = eVar;
            }
            get(i, a2, eVar2, bVar, true, true, "campaign", j);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b(TAG, e.getMessage());
            }
        }
    }

    public void getLoadOrSetting(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        getLoadOrSetting(i, str, eVar, bVar, true, str2, j);
    }

    public void postFocusReport(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        post(i, str, eVar, bVar, false, true, str2, j);
    }

    public void postV5(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        String str3 = eVar.a().get("sign");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        eVar.a("ts", currentTimeMillis + "");
        eVar.a("st", SameMD5.getMD5(currentTimeMillis + str3));
        post(i, str, eVar, bVar, false, false, str2, j);
    }

    public void get(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z, boolean z2, String str2, long j) {
        if (eVar == null) {
            try {
                eVar = new e();
            } catch (Exception e) {
                p0.a(TAG, e.getMessage());
            }
        }
        addExtraParams(str, eVar);
        f.k(eVar);
        String str3 = eVar.a().get("sign");
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        eVar.a("ts", currentTimeMillis + "");
        if (com.mbridge.msdk.util.b.a()) {
            eVar.a("st", SameMD5.getMD5(str3 + currentTimeMillis));
        } else {
            eVar.a("st", SameMD5.getMD5(currentTimeMillis + str3));
        }
        com.mbridge.msdk.foundation.same.net.e a2 = com.mbridge.msdk.foundation.same.net.utils.c.b().a(eVar);
        if (a2 != null && bVar != null) {
            bVar.onSuccess(a2);
            return;
        }
        if (str.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().i) && com.mbridge.msdk.foundation.same.net.utils.d.h().s) {
            try {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("uri", com.mbridge.msdk.foundation.same.net.utils.d.h().m + Uri.parse(str).getPath());
                    jSONObject.put("data", eVar.b());
                } catch (Throwable th) {
                    p0.b(TAG, th.getMessage());
                }
                com.mbridge.msdk.foundation.same.net.f.b().a(com.mbridge.msdk.foundation.same.net.utils.d.h().m, com.mbridge.msdk.foundation.same.net.utils.d.h().q, jSONObject.toString(), true, bVar);
                return;
            } catch (Throwable th2) {
                p0.b(TAG, th2.getMessage());
            }
        }
        String str4 = str + "?" + eVar.toString();
        com.mbridge.msdk.setting.g b = com.mbridge.msdk.setting.h.b().b(com.mbridge.msdk.foundation.controller.c.m().b());
        if (str4.length() >= b.m0() && str4.contains(com.mbridge.msdk.foundation.same.net.utils.d.h().i)) {
            post(i, str, eVar, bVar, z2, false, str2, j);
            return;
        }
        e eVar2 = eVar;
        if (str4.length() >= b.L() && z) {
            post(i, str, eVar2, bVar, z2, false, str2, j);
            return;
        }
        com.mbridge.msdk.tracker.network.h<?> createRequest = createRequest(i, 0, str, bVar, str2, j);
        if (createRequest != null) {
            if (eVar2.a() != null) {
                String str5 = eVar2.a().get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
                if (TextUtils.isEmpty(str5)) {
                    str5 = "";
                }
                createRequest.a("local_id", str5);
                String str6 = eVar2.a().get("ad_type");
                createRequest.a("ad_type", TextUtils.isEmpty(str6) ? "" : str6);
                createRequest.a(eVar2.a());
            }
            createRequest.d(canTrack());
            l.a().b().a(createRequest);
        }
    }

    public void getLoadOrSetting(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z, String str2, long j) {
        get(i, str, eVar, bVar, z, false, str2, j);
    }

    public void postV5(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, boolean z, String str2, long j) {
        String str3 = eVar.a().get("sign");
        if (str3 == null) {
            str3 = "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        eVar.a("ts", currentTimeMillis + "");
        eVar.a("st", SameMD5.getMD5(currentTimeMillis + str3));
        post(i, str, eVar, bVar, z, false, str2, j);
    }

    public void get(int i, String str, Map<String, String> map, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(MBridgeConstans.APP_ID, com.mbridge.msdk.foundation.controller.c.m().b());
        map.put(BidTokenRepositoryKt.SDK_VERSION, MBConfiguration.SDK_VERSION);
        map.put(N6.H, "1");
        String asUrlParams = asUrlParams(map);
        if (!TextUtils.isEmpty(asUrlParams)) {
            str = str + "?" + asUrlParams;
        }
        String str3 = str;
        if (MBridgeConstans.DEBUG) {
            p0.a("AppletsModel", "get wx scheme url = " + str3);
        }
        com.mbridge.msdk.tracker.network.h<?> createRequest = createRequest(i, 0, str3, bVar, str2, j);
        if (createRequest != null) {
            String str4 = map.get(CampaignEx.JSON_KEY_LOCAL_REQUEST_ID);
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            createRequest.a("local_id", str4);
            String str5 = map.get("ad_type");
            createRequest.a("ad_type", TextUtils.isEmpty(str5) ? "" : str5);
            createRequest.a(map);
            createRequest.d(canTrack());
            l.a().b().a(createRequest);
        }
    }

    public void post(int i, String str, e eVar, com.mbridge.msdk.foundation.same.net.b bVar, String str2, long j) {
        post(i, str, eVar, bVar, false, false, str2, j);
    }
}
