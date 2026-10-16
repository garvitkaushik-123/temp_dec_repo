package com.fyber.inneractive.sdk.network;

import android.os.Build;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.C3033ce;
import com.ironsource.C3040d4;
import com.ironsource.N6;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class p0 extends s0 implements o {
    public final InneractiveAdRequest p;
    public HashMap q;
    public StringBuffer r;
    public final com.fyber.inneractive.sdk.serverapi.d s;
    public com.fyber.inneractive.sdk.dv.j t;
    public boolean u;
    public final com.fyber.inneractive.sdk.network.timeouts.request.a v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(q qVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.config.global.r rVar) {
        super(qVar, f0.c.a(), rVar);
        com.fyber.inneractive.sdk.serverapi.c cVar = new com.fyber.inneractive.sdk.serverapi.c(rVar);
        this.t = null;
        this.u = false;
        this.o = true;
        this.p = inneractiveAdRequest;
        this.s = cVar;
        if (inneractiveAdRequest != null) {
            String a2 = com.fyber.inneractive.sdk.util.l1.a(inneractiveAdRequest.getSpotId());
            String mediationName = inneractiveAdRequest.getMediationName();
            com.fyber.inneractive.sdk.config.global.features.j jVar = (com.fyber.inneractive.sdk.config.global.features.j) rVar.a(com.fyber.inneractive.sdk.config.global.features.j.class);
            this.v = TextUtils.isEmpty(mediationName) ? new com.fyber.inneractive.sdk.network.timeouts.request.b(jVar, a2) : new com.fyber.inneractive.sdk.network.timeouts.request.d(a2, jVar, mediationName);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.o
    public final StringBuffer a() {
        return this.r;
    }

    @Override // com.fyber.inneractive.sdk.network.o
    public final Map b() {
        return this.q;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final void c() {
        super.c();
        IAlog.a("%s : NetworkRequestAd cancel by timeout - resolve request with no fill", IAlog.a(this));
        this.f1337a = true;
        a((Object) null, (Exception) new i1("no fill", 204), false);
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final byte[] d() {
        JSONArray jSONArray;
        byte[] bArr = new byte[0];
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            com.fyber.inneractive.sdk.config.global.r rVar = ((com.fyber.inneractive.sdk.serverapi.c) this.s).f1731a;
            if (rVar != null) {
                jSONArray = com.fyber.inneractive.sdk.config.global.g.a(rVar.b, true);
                IAlog.a("%s: active experiments json set = %s", "SupportedFeaturesProvider", jSONArray);
            } else {
                jSONArray = null;
            }
            if (jSONArray != null && jSONArray.length() > 0) {
                jSONObject2.put(C3033ce.d, jSONArray);
                jSONObject.put("sdk_experiments", jSONObject2);
            }
            UnitDisplayType a2 = com.fyber.inneractive.sdk.serverapi.b.a(this.p.getSpotId());
            IAConfigManager iAConfigManager = IAConfigManager.O;
            JSONArray a3 = iAConfigManager.x.a(a2);
            if (a3 != null && a3.length() > 0) {
                jSONObject.put("user_sessions", a3);
            }
            int a4 = iAConfigManager.u.b.a("dv_enabled_v3", 0, 0);
            if (a2 != null && a4 == 1) {
                com.fyber.inneractive.sdk.dv.j a5 = iAConfigManager.G.a(a2);
                this.t = a5;
                if (a5 != null) {
                    jSONObject.put("gdem_signal", a5.f1146a.getQuery());
                }
            }
            com.fyber.inneractive.sdk.topics.b bVar = iAConfigManager.F;
            if (bVar != null && IAConfigManager.f()) {
                Object b = bVar.b();
                if (b != null) {
                    jSONObject.put("topics", b);
                }
                Object a6 = bVar.a();
                if (a6 != null) {
                    jSONObject.put("encrypted_topics", a6);
                }
            }
            String jSONObject3 = jSONObject.toString();
            bArr = jSONObject3.getBytes(StandardCharsets.UTF_8);
            IAlog.a("request json body - %s", jSONObject3);
            IAlog.d("request json body - %s", jSONObject3);
            return bArr;
        } catch (Exception unused) {
            IAlog.a("Failed building body for ad request!", new Object[0]);
            return bArr;
        }
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int e() {
        return 0;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int h() {
        return o();
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final Map j() {
        int i = com.fyber.inneractive.sdk.config.k.f1102a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.response");
        if (TextUtils.isEmpty(property)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("mockadnetworkresponseid", property);
        IAlog.a("NetworkRequestAd: Adding mock response header - %s", property);
        return hashMap;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final l0 k() {
        return l0.POST;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final e1 m() {
        return e1.HIGH;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final j1 n() {
        com.fyber.inneractive.sdk.network.timeouts.request.a aVar = this.v;
        return new j1(aVar.i, aVar.h);
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final String p() {
        String str;
        String str2;
        int i = com.fyber.inneractive.sdk.config.k.f1102a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        String str3 = TextUtils.isEmpty(property) ? "https://" + IAConfigManager.O.i.e : Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(property).matches() ? "https://" + property + "/simpleM2M/clientRequestEnhancedXmlAd" : "https://" + property + ".inner-active.mobi/simpleM2M/clientRequestEnhancedXmlAd";
        InneractiveAdRequest inneractiveAdRequest = this.p;
        com.fyber.inneractive.sdk.serverapi.d dVar = this.s;
        q0 q0Var = new q0(inneractiveAdRequest, dVar);
        q0Var.f1334a = new HashMap();
        q0Var.a("fromSDK", Boolean.toString(true));
        q0Var.a("po", System.getProperty("ia.testEnvironmentConfiguration.number"));
        q0Var.a("secure", !com.fyber.inneractive.sdk.util.s.a() || IAConfigManager.O.q ? "1" : "0");
        q0Var.a("spotid", inneractiveAdRequest.getSpotId());
        String property2 = System.getProperty("ia.testEnvironmentConfiguration.chosenUnitId");
        if (property2 == null) {
            property2 = inneractiveAdRequest.getSelectedUnitConfig() == null ? null : ((com.fyber.inneractive.sdk.config.r0) inneractiveAdRequest.getSelectedUnitConfig()).f1114a;
        }
        q0Var.a("uid", property2);
        IAConfigManager iAConfigManager = IAConfigManager.O;
        if (TextUtils.isEmpty(iAConfigManager.n)) {
            q0Var.a("med", iAConfigManager.l);
        } else {
            q0Var.a("med", iAConfigManager.l + "_" + iAConfigManager.n);
        }
        dVar.getClass();
        q0Var.a(InneractiveMediationDefs.GENDER_FEMALE, Integer.toString(372));
        com.fyber.inneractive.sdk.serverapi.c cVar = (com.fyber.inneractive.sdk.serverapi.c) dVar;
        List list = com.fyber.inneractive.sdk.serverapi.c.d;
        if (!list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf((Integer) it.next()));
            }
            q0Var.a("protocols", com.fyber.inneractive.sdk.util.o.a(arrayList));
        }
        List list2 = com.fyber.inneractive.sdk.serverapi.c.c;
        if (!list2.isEmpty()) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = list2.iterator();
            while (it2.hasNext()) {
                arrayList2.add(String.valueOf((Integer) it2.next()));
            }
            q0Var.a("api", com.fyber.inneractive.sdk.util.o.a(arrayList2));
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            q0Var.a("zip", iAConfigManager.j.getZipCode());
        }
        q0Var.a("a", Integer.toString(iAConfigManager.j.getAge()));
        InneractiveUserConfig.Gender gender = iAConfigManager.j.getGender();
        if (InneractiveUserConfig.Gender.MALE.equals(gender)) {
            q0Var.a("g", "m");
        } else if (InneractiveUserConfig.Gender.FEMALE.equals(gender)) {
            q0Var.a("g", InneractiveMediationDefs.GENDER_FEMALE);
        }
        q0Var.a("t", Long.toString(System.currentTimeMillis()));
        StringBuilder sb = new StringBuilder("2.2.0-Android-8.3.8");
        if (!TextUtils.isEmpty(InneractiveAdManager.getDevPlatform())) {
            sb.append('-').append(InneractiveAdManager.getDevPlatform());
        }
        q0Var.a("v", sb.toString());
        Boolean d = iAConfigManager.D.d();
        if (d != null) {
            q0Var.a("gdpr_privacy_consent", d.booleanValue() ? "1" : "0");
        }
        com.fyber.inneractive.sdk.config.g gVar = iAConfigManager.D;
        if (gVar != null) {
            Boolean bool = com.fyber.inneractive.sdk.util.o.f1770a == null ? null : gVar.i;
            if (bool != null) {
                q0Var.a("lgpd_consent", bool.booleanValue() ? "1" : "0");
            }
            Boolean bool2 = iAConfigManager.D.j;
            if (bool2 != null && bool2.booleanValue()) {
                q0Var.a("coppaApplies", "1");
            }
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            String property3 = System.getProperty("ia.testEnvironmentConfiguration.device");
            com.fyber.inneractive.sdk.config.v vVar = com.fyber.inneractive.sdk.config.u.f1127a.b;
            String str4 = vVar != null ? vVar.c : false ? "amazonId" : "aaid";
            if (TextUtils.isEmpty(property3)) {
                com.fyber.inneractive.sdk.config.v vVar2 = com.fyber.inneractive.sdk.config.u.f1127a.b;
                property3 = vVar2 != null ? vVar2.f1129a : null;
            }
            q0Var.a(str4, property3);
        }
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            com.fyber.inneractive.sdk.config.v vVar3 = com.fyber.inneractive.sdk.config.u.f1127a.b;
            q0Var.a("dnt", Boolean.toString(vVar3 != null ? vVar3.b : false));
        }
        q0Var.a("dml", com.fyber.inneractive.sdk.util.k.j());
        int c = com.fyber.inneractive.sdk.util.o.c(com.fyber.inneractive.sdk.util.o.e());
        int c2 = com.fyber.inneractive.sdk.util.o.c(com.fyber.inneractive.sdk.util.o.d());
        if (c > 0 && c2 > 0) {
            q0Var.a("w", Integer.toString(c));
            q0Var.a("h", Integer.toString(c2));
        }
        int c3 = com.fyber.inneractive.sdk.util.o.c();
        q0Var.a("o", c3 == 1 ? "p" : c3 == 2 ? "l" : "u");
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            q0Var.a("ciso", com.fyber.inneractive.sdk.util.k.i());
            String str5 = cVar.b;
            q0Var.a("mcc", str5 == null ? "" : str5.substring(0, Math.min(3, str5.length())));
            String str6 = cVar.b;
            q0Var.a("mnc", str6 == null ? "" : str6.substring(Math.min(3, str6.length())));
            com.fyber.inneractive.sdk.util.x0 a2 = com.fyber.inneractive.sdk.util.x0.a();
            IAlog.a("ExchangeRequestParamsProvider: getNetwork : type: %s value: %s", a2, a2.b());
            q0Var.a("nt", a2.b());
            q0Var.a("crn", cVar.a());
        }
        q0Var.a(N6.F, C3040d4.d);
        q0Var.a("lng", iAConfigManager.o);
        ArrayList arrayList3 = iAConfigManager.p;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            q0Var.a("in_lng", com.fyber.inneractive.sdk.util.o.a(arrayList3));
        }
        q0Var.a("bid", com.fyber.inneractive.sdk.util.o.f1770a.getPackageName());
        q0Var.a("appv", com.fyber.inneractive.sdk.util.k.l());
        com.fyber.inneractive.sdk.config.g gVar2 = iAConfigManager.D;
        if (gVar2.d == null) {
            gVar2.e = gVar2.h();
        }
        if (com.fyber.inneractive.sdk.util.o.f1770a == null) {
            str = null;
        } else {
            str = gVar2.d;
            if (str == null) {
                str = gVar2.e;
            }
        }
        q0Var.a("gdpr_consent_data", str);
        com.fyber.inneractive.sdk.config.g gVar3 = iAConfigManager.D;
        if (com.fyber.inneractive.sdk.util.o.f1770a == null) {
            gVar3.getClass();
            str2 = null;
        } else {
            str2 = gVar3.h;
        }
        q0Var.a("us_privacy", str2);
        q0Var.a("mute_video", Boolean.toString(iAConfigManager.k));
        q0Var.a("osv", Build.VERSION.RELEASE);
        com.fyber.inneractive.sdk.ignite.l lVar = iAConfigManager.E.p;
        q0Var.a("ignitep", lVar != null ? lVar.f984a.d() : null);
        com.fyber.inneractive.sdk.ignite.l lVar2 = iAConfigManager.E.p;
        q0Var.a("ignitev", lVar2 != null ? lVar2.f984a.i() : null);
        HashMap hashMap = new HashMap();
        cVar.a(inneractiveAdRequest.getSpotId(), hashMap);
        for (Map.Entry entry : hashMap.entrySet()) {
            q0Var.a((String) entry.getKey(), (String) entry.getValue());
        }
        if (InneractiveAdManager.isCurrentUserAChild()) {
            q0Var.a("childMode", "1");
        }
        com.fyber.inneractive.sdk.ignite.l lVar3 = IAConfigManager.O.E.p;
        q0Var.a("odt", lVar3 != null ? lVar3.getOdt() : "");
        String a3 = com.fyber.inneractive.sdk.util.d1.a(str3, q0Var.f1334a);
        if (!this.u) {
            IAlog.d("%s %s", "AD_REQUEST", a3);
            this.u = true;
        }
        return a3;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final int q() {
        return this.v.f;
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final boolean s() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009b A[Catch: Exception -> 0x00aa, TryCatch #1 {Exception -> 0x00aa, blocks: (B:30:0x0077, B:32:0x007b, B:34:0x0091, B:38:0x009b, B:39:0x00a1), top: B:29:0x0077 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00a0  */
    @Override // com.fyber.inneractive.sdk.network.s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final n0 a(l lVar, Map map, int i) {
        StringBuffer stringBuffer;
        String str;
        List list;
        if (map != null) {
            HashMap hashMap = new HashMap();
            for (String str2 : map.keySet()) {
                if (str2 != null && (list = (List) map.get(str2)) != null && list.size() > 0) {
                    hashMap.put(str2.toLowerCase(Locale.US), (String) list.get(0));
                }
            }
            this.q = hashMap;
        }
        InputStream inputStream = lVar == null ? null : lVar.c;
        super.d(System.currentTimeMillis());
        IAlog.a("%s : NetworkRequestAd : set start read timestamp", IAlog.a(this));
        if (inputStream != null) {
            try {
                stringBuffer = com.fyber.inneractive.sdk.util.t.a(inputStream);
            } catch (Exception e) {
                IAlog.a("failed create response builder in network request ad", e, new Object[0]);
                stringBuffer = null;
            }
            this.r = stringBuffer;
        }
        b(System.currentTimeMillis());
        n0 n0Var = new n0();
        try {
            HashMap hashMap2 = this.q;
            if (hashMap2 != null) {
                str = (String) hashMap2.get(n.RETURNED_AD_TYPE.key.toLowerCase(Locale.US));
                if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                    n0Var.f1331a = a(str == null ? Integer.parseInt(str) : 6, this, null, this.t);
                    return n0Var;
                }
            }
            str = null;
            n0Var.f1331a = a(str == null ? Integer.parseInt(str) : 6, this, null, this.t);
            return n0Var;
        } catch (Exception e2) {
            b(System.currentTimeMillis());
            IAlog.a("failed parse ad network request", e2, new Object[0]);
            throw new m0(e2);
        }
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final void b(long j) {
        super.b(j);
        IAlog.a("%s : NetworkRequestAd : set end read timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(o()));
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final void c(long j) {
        super.c(j);
        IAlog.a("%s : NetworkRequestAd : set start connection timestamp", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final l a(String str) {
        IAlog.a("%s: NetworkRequestAd Ad request execution started, timeouts(connection: %d read: %d)", IAlog.a(this), Integer.valueOf(n().f1325a), Integer.valueOf(n().b));
        return super.a(str);
    }

    @Override // com.fyber.inneractive.sdk.network.s0
    public final void a(long j) {
        super.a(j);
        IAlog.a("%s : NetworkRequestAd : set end connection timestamp, total execution time: %d", IAlog.a(this), Integer.valueOf(o()));
    }
}
