package com.ironsource;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.L7;
import com.ironsource.Tc;
import com.ironsource.U3;
import com.ironsource.environment.StringUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.ue, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3337ue {
    protected static final boolean A = false;
    protected static final String A0 = "waitUntilAllProvidersFinishInit";
    protected static final String A1 = "providerNetworkKey";
    protected static final int B = 60;
    protected static final String B0 = "sharedManagersThread";
    protected static final String B1 = "spId";
    protected static final int C = 10000;
    protected static final String C0 = "parallelLoad";
    protected static final String C1 = "mpis";
    protected static final int D = 10000;
    protected static final String D0 = "bidderExclusive";
    protected static final String D1 = "auction";
    protected static final int E = -1;
    protected static final String E0 = "adapterTimeOutInSeconds";
    protected static final String E1 = "auctionData";
    protected static final int F = 5000;
    protected static final String F0 = "atim";
    protected static final String F1 = "auctioneerURL";
    protected static final int G = 3;
    protected static final String G0 = "bannerInterval";
    protected static final String G1 = "extAuctioneerURL";
    protected static final int H = 3;
    protected static final String H0 = "isOneFlow";
    protected static final String H1 = "objectPerWaterfall";
    protected static final int I = 3;
    protected static final String I0 = "expiredDurationInMinutes";
    protected static final String I1 = "minTimeBeforeFirstAuction";
    protected static final int J = 0;
    protected static final String J0 = "server";
    protected static final String J1 = "timeToWaitBeforeAuction";
    protected static final int K = 2;
    protected static final String K0 = "publisher";
    protected static final String K1 = "timeToWaitBeforeLoad";
    protected static final int L = 15;
    protected static final String L0 = "console";
    protected static final String L1 = "auctionRetryInterval";
    protected static final long M = 10000;
    protected static final String M0 = "sendUltraEvents";
    protected static final String M1 = "isLoadWhileShow";
    protected static final long N = 3000;
    protected static final String N0 = "sendEventsToggle";
    protected static final String N1 = "auctionTrials";
    protected static final boolean O = false;
    protected static final String O0 = "eventsCompression";
    protected static final String O1 = "auctionTimeout";
    protected static final boolean P = false;
    protected static final String P0 = "eventsCompressionLevel";
    protected static final String P1 = "auctionSavedHistory";
    protected static final int Q = 30000;
    protected static final String Q0 = "serverEventsURL";
    protected static final String Q1 = "disableLoadWhileShowSupportFor";
    protected static final int R = -1;
    protected static final String R0 = "serverEventsType";
    protected static final String R1 = "tokenPerAdapter";
    protected static final int S = 5000;
    protected static final String S0 = "backupThreshold";
    protected static final String S1 = "enableAuctionFallback";
    protected static final int T = 1;
    protected static final String T0 = "maxNumberOfEvents";
    protected static final String T1 = "timeToDeleteOldWaterfallAfterAuction";
    protected static final boolean U = false;
    protected static final String U0 = "maxEventsPerBatch";
    protected static final String U1 = "compressAuctionRequest";
    protected static final int V = 15000;
    protected static final String V0 = "optOut";
    protected static final String V1 = "compressAuctionResponse";
    protected static final int W = 15000;
    protected static final String W0 = "optIn";
    protected static final String W1 = "encryptionVersion";
    protected static final String X = "providerOrder";
    protected static final String X0 = "triggerEvents";
    protected static final String X1 = "shouldSendBannerBURLFromImpression";
    protected static final String Y = "providerSettings";
    protected static final String Y0 = "nonConnectivityEvents";
    protected static final String Y1 = "impressionTimeout";
    protected static final String Z = "configurations";
    protected static final String Z0 = "shouldSendPublisherLogsOnUIThread";
    protected static final String Z1 = "optInKeys";
    protected static final String a0 = "genericParams";
    protected static final String a1 = "pixel";
    protected static final String a2 = "tokenGenericParams";
    protected static final String b0 = "adUnits";
    protected static final String b1 = "pixelEventsUrl";
    protected static final String b2 = "compressToken";
    protected static final String c0 = "providerLoadName";
    protected static final String c1 = "pixelEventsEnabled";
    protected static final String c2 = "compressExternalToken";
    protected static final String d0 = "application";
    protected static final String d1 = "placements";
    protected static final String d2 = "instanceType";
    protected static final String e0 = "rewardedVideo";
    protected static final String e1 = "placementId";
    protected static final String e2 = "maxAdsPerSession";
    protected static final String f0 = "interstitial";
    protected static final String f1 = "placementName";
    protected static final String f2 = "reward";
    protected static final String g0 = "banner";
    protected static final String g1 = "delivery";
    protected static final String g2 = "name";
    protected static final String h0 = "nativeAd";
    protected static final String h1 = "isDefault";
    protected static final String h2 = "amount";
    protected static final String i0 = "integration";
    protected static final String i1 = "capping";
    protected static final String i2 = "bannerRefreshRate";
    protected static final String j0 = "loggers";
    protected static final String j1 = "pacing";
    protected static final String j2 = "protocolVersion";
    protected static final String k0 = "segment";
    protected static final String k1 = "enabled";
    protected static final String k2 = "adFormats";
    public static final String l = "appKey";
    protected static final String l0 = "events";
    protected static final String l1 = "maxImpressions";
    protected static final String l2 = "adUnits";
    public static final String m = "userId";
    protected static final String m0 = "crashReporter";
    protected static final String m1 = "numOfSeconds";
    protected static final String m2 = "rewarded";
    public static final String n = "response";
    protected static final String n0 = "token";
    protected static final String n1 = "unit";
    protected static final String o = "error";
    protected static final String o0 = "external";
    protected static final String o1 = "virtualItemName";
    protected static final int p = 3;
    protected static final String p0 = "mediationTypes";
    protected static final String p1 = "virtualItemCount";
    protected static final boolean q = false;
    protected static final String q0 = "providerDefaultInstance";
    protected static final String q1 = "uuidEnabled";
    protected static final boolean r = true;
    protected static final String r0 = "testSuite";
    protected static final String r1 = "abt";
    protected static final boolean s = true;
    protected static final String s0 = "controllerUrl";
    protected static final String s1 = "delayLoadFailure";
    protected static final int t = 2;
    protected static final String t0 = "AdQuality";
    protected static final String t1 = "keysToInclude";
    protected static final int u = 2;
    protected static final String u0 = "initMode";
    protected static final String u1 = "reporterURL";
    protected static final int v = 1;
    protected static final String v0 = "adq_init_blob";
    protected static final String v1 = "reporterKeyword";
    protected static final int w = 1;
    protected static final String w0 = "settings";
    protected static final String w1 = "includeANR";
    protected static final boolean x = true;
    protected static final String x0 = "collectBiddingDataTimeout";
    protected static final String x1 = "timeout";
    protected static final boolean y = false;
    protected static final String y0 = "providers";
    protected static final String y1 = "setIgnoreDebugger";
    protected static final boolean z = false;
    protected static final String z0 = "parallelInit";
    protected static final String z1 = "adSourceName";

    /* renamed from: a, reason: collision with root package name */
    private C3134id f3896a;
    private C3167kd b;
    private U3 c;
    private String d;
    private String e;
    private JSONObject f;
    private Context g;
    private a h;
    private L7.a i;
    private boolean j;
    private N5 k;

    /* renamed from: com.ironsource.ue$a */
    public enum a {
        NOT_SET("0"),
        CACHE("1"),
        SERVER("2");


        /* renamed from: a, reason: collision with root package name */
        private final String f3897a;

        a(String str) {
            this.f3897a = str;
        }

        public String b() {
            return this.f3897a;
        }
    }

    public C3337ue(Context context, String str, String str2, String str3) {
        this.h = a.NOT_SET;
        this.j = false;
        this.g = context;
        this.i = C3334ub.O().x();
        try {
            if (TextUtils.isEmpty(str3)) {
                this.f = new JSONObject();
            } else {
                this.f = new JSONObject(str3);
            }
            this.j = n();
            s();
            q();
            r();
            this.d = TextUtils.isEmpty(str) ? "" : str;
            this.e = TextUtils.isEmpty(str2) ? "" : str2;
            b(this.f);
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            a();
        }
    }

    public static a a(C3337ue c3337ue) {
        return c3337ue != null ? c3337ue.h() : a.NOT_SET;
    }

    private void b(JSONObject jSONObject) {
        this.k = new N5(jSONObject.optJSONObject(C3033ce.d));
    }

    private JSONObject c(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(str);
        }
        return null;
    }

    private C3124i3 d(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("placementId", -1);
        String optString = jSONObject.optString("placementName", "");
        boolean optBoolean = jSONObject.optBoolean(h1, false);
        Tc a3 = a(jSONObject);
        if (optInt < 0 || TextUtils.isEmpty(optString)) {
            return null;
        }
        C3124i3 c3124i3 = new C3124i3(optInt, optString, optBoolean, a3);
        if (a3 != null) {
            this.i.b(this.g, c3124i3, IronSource.AD_UNIT.BANNER);
        }
        return c3124i3;
    }

    private InterstitialPlacement e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("placementId", -1);
        String optString = jSONObject.optString("placementName", "");
        boolean optBoolean = jSONObject.optBoolean(h1, false);
        Tc a3 = a(jSONObject);
        if (optInt < 0 || TextUtils.isEmpty(optString)) {
            return null;
        }
        InterstitialPlacement interstitialPlacement = new InterstitialPlacement(optInt, optString, optBoolean, a3);
        if (a3 != null) {
            this.i.b(this.g, interstitialPlacement, IronSource.AD_UNIT.INTERSTITIAL);
        }
        return interstitialPlacement;
    }

    private String l() {
        return this.j ? "rewarded" : "rewardedVideo";
    }

    private boolean m() {
        JSONObject c;
        JSONArray optJSONArray;
        JSONObject c3 = c(this.f, "providerOrder");
        JSONArray names = c3.names();
        if (names == null) {
            return true;
        }
        JSONObject c4 = c(c(this.f, "configurations"), b());
        for (int i = 0; i < names.length(); i++) {
            String optString = names.optString(i);
            JSONArray optJSONArray2 = c3.optJSONArray(optString);
            if (optJSONArray2 != null && optJSONArray2.length() != 0 && (c = c(c4, optString)) != null && ((optJSONArray = c.optJSONArray("placements")) == null || optJSONArray.length() == 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean n() {
        int i;
        try {
            i = this.f.optInt(j2, 0);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            i = 0;
        }
        return i == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x064e A[Catch: Exception -> 0x0815, TryCatch #0 {Exception -> 0x0815, blocks: (B:3:0x0004, B:5:0x006f, B:7:0x0087, B:9:0x0093, B:10:0x00b1, B:14:0x00f6, B:16:0x015a, B:19:0x020f, B:21:0x0215, B:24:0x022f, B:27:0x0239, B:29:0x023f, B:31:0x024b, B:33:0x024e, B:37:0x0262, B:39:0x02b8, B:40:0x0345, B:43:0x0351, B:45:0x0357, B:47:0x0365, B:49:0x0368, B:54:0x0382, B:56:0x0400, B:58:0x0408, B:59:0x04bc, B:62:0x04cc, B:64:0x04d2, B:66:0x04de, B:68:0x04e1, B:73:0x0501, B:75:0x055f, B:77:0x0567, B:78:0x05df, B:81:0x05ef, B:83:0x05f5, B:85:0x0601, B:87:0x0604, B:90:0x0610, B:92:0x0617, B:95:0x0622, B:97:0x0628, B:99:0x0632, B:101:0x063a, B:102:0x063d, B:103:0x0647, B:105:0x064e, B:106:0x0665, B:108:0x066a, B:109:0x0690, B:111:0x06b8, B:114:0x06fe, B:116:0x0704, B:119:0x0710, B:120:0x0730, B:123:0x073c, B:125:0x0746, B:127:0x0755, B:128:0x0759, B:129:0x075e, B:131:0x0767, B:132:0x0770, B:134:0x07cd, B:136:0x07d5, B:138:0x07f7, B:143:0x0737, B:146:0x05d0, B:147:0x05d8, B:149:0x049d, B:150:0x04ad, B:152:0x0336, B:154:0x0222), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x066a A[Catch: Exception -> 0x0815, TryCatch #0 {Exception -> 0x0815, blocks: (B:3:0x0004, B:5:0x006f, B:7:0x0087, B:9:0x0093, B:10:0x00b1, B:14:0x00f6, B:16:0x015a, B:19:0x020f, B:21:0x0215, B:24:0x022f, B:27:0x0239, B:29:0x023f, B:31:0x024b, B:33:0x024e, B:37:0x0262, B:39:0x02b8, B:40:0x0345, B:43:0x0351, B:45:0x0357, B:47:0x0365, B:49:0x0368, B:54:0x0382, B:56:0x0400, B:58:0x0408, B:59:0x04bc, B:62:0x04cc, B:64:0x04d2, B:66:0x04de, B:68:0x04e1, B:73:0x0501, B:75:0x055f, B:77:0x0567, B:78:0x05df, B:81:0x05ef, B:83:0x05f5, B:85:0x0601, B:87:0x0604, B:90:0x0610, B:92:0x0617, B:95:0x0622, B:97:0x0628, B:99:0x0632, B:101:0x063a, B:102:0x063d, B:103:0x0647, B:105:0x064e, B:106:0x0665, B:108:0x066a, B:109:0x0690, B:111:0x06b8, B:114:0x06fe, B:116:0x0704, B:119:0x0710, B:120:0x0730, B:123:0x073c, B:125:0x0746, B:127:0x0755, B:128:0x0759, B:129:0x075e, B:131:0x0767, B:132:0x0770, B:134:0x07cd, B:136:0x07d5, B:138:0x07f7, B:143:0x0737, B:146:0x05d0, B:147:0x05d8, B:149:0x049d, B:150:0x04ad, B:152:0x0336, B:154:0x0222), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x06b8 A[Catch: Exception -> 0x0815, TryCatch #0 {Exception -> 0x0815, blocks: (B:3:0x0004, B:5:0x006f, B:7:0x0087, B:9:0x0093, B:10:0x00b1, B:14:0x00f6, B:16:0x015a, B:19:0x020f, B:21:0x0215, B:24:0x022f, B:27:0x0239, B:29:0x023f, B:31:0x024b, B:33:0x024e, B:37:0x0262, B:39:0x02b8, B:40:0x0345, B:43:0x0351, B:45:0x0357, B:47:0x0365, B:49:0x0368, B:54:0x0382, B:56:0x0400, B:58:0x0408, B:59:0x04bc, B:62:0x04cc, B:64:0x04d2, B:66:0x04de, B:68:0x04e1, B:73:0x0501, B:75:0x055f, B:77:0x0567, B:78:0x05df, B:81:0x05ef, B:83:0x05f5, B:85:0x0601, B:87:0x0604, B:90:0x0610, B:92:0x0617, B:95:0x0622, B:97:0x0628, B:99:0x0632, B:101:0x063a, B:102:0x063d, B:103:0x0647, B:105:0x064e, B:106:0x0665, B:108:0x066a, B:109:0x0690, B:111:0x06b8, B:114:0x06fe, B:116:0x0704, B:119:0x0710, B:120:0x0730, B:123:0x073c, B:125:0x0746, B:127:0x0755, B:128:0x0759, B:129:0x075e, B:131:0x0767, B:132:0x0770, B:134:0x07cd, B:136:0x07d5, B:138:0x07f7, B:143:0x0737, B:146:0x05d0, B:147:0x05d8, B:149:0x049d, B:150:0x04ad, B:152:0x0336, B:154:0x0222), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0710 A[Catch: Exception -> 0x0815, TryCatch #0 {Exception -> 0x0815, blocks: (B:3:0x0004, B:5:0x006f, B:7:0x0087, B:9:0x0093, B:10:0x00b1, B:14:0x00f6, B:16:0x015a, B:19:0x020f, B:21:0x0215, B:24:0x022f, B:27:0x0239, B:29:0x023f, B:31:0x024b, B:33:0x024e, B:37:0x0262, B:39:0x02b8, B:40:0x0345, B:43:0x0351, B:45:0x0357, B:47:0x0365, B:49:0x0368, B:54:0x0382, B:56:0x0400, B:58:0x0408, B:59:0x04bc, B:62:0x04cc, B:64:0x04d2, B:66:0x04de, B:68:0x04e1, B:73:0x0501, B:75:0x055f, B:77:0x0567, B:78:0x05df, B:81:0x05ef, B:83:0x05f5, B:85:0x0601, B:87:0x0604, B:90:0x0610, B:92:0x0617, B:95:0x0622, B:97:0x0628, B:99:0x0632, B:101:0x063a, B:102:0x063d, B:103:0x0647, B:105:0x064e, B:106:0x0665, B:108:0x066a, B:109:0x0690, B:111:0x06b8, B:114:0x06fe, B:116:0x0704, B:119:0x0710, B:120:0x0730, B:123:0x073c, B:125:0x0746, B:127:0x0755, B:128:0x0759, B:129:0x075e, B:131:0x0767, B:132:0x0770, B:134:0x07cd, B:136:0x07d5, B:138:0x07f7, B:143:0x0737, B:146:0x05d0, B:147:0x05d8, B:149:0x049d, B:150:0x04ad, B:152:0x0336, B:154:0x0222), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0734  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0746 A[Catch: Exception -> 0x0815, TryCatch #0 {Exception -> 0x0815, blocks: (B:3:0x0004, B:5:0x006f, B:7:0x0087, B:9:0x0093, B:10:0x00b1, B:14:0x00f6, B:16:0x015a, B:19:0x020f, B:21:0x0215, B:24:0x022f, B:27:0x0239, B:29:0x023f, B:31:0x024b, B:33:0x024e, B:37:0x0262, B:39:0x02b8, B:40:0x0345, B:43:0x0351, B:45:0x0357, B:47:0x0365, B:49:0x0368, B:54:0x0382, B:56:0x0400, B:58:0x0408, B:59:0x04bc, B:62:0x04cc, B:64:0x04d2, B:66:0x04de, B:68:0x04e1, B:73:0x0501, B:75:0x055f, B:77:0x0567, B:78:0x05df, B:81:0x05ef, B:83:0x05f5, B:85:0x0601, B:87:0x0604, B:90:0x0610, B:92:0x0617, B:95:0x0622, B:97:0x0628, B:99:0x0632, B:101:0x063a, B:102:0x063d, B:103:0x0647, B:105:0x064e, B:106:0x0665, B:108:0x066a, B:109:0x0690, B:111:0x06b8, B:114:0x06fe, B:116:0x0704, B:119:0x0710, B:120:0x0730, B:123:0x073c, B:125:0x0746, B:127:0x0755, B:128:0x0759, B:129:0x075e, B:131:0x0767, B:132:0x0770, B:134:0x07cd, B:136:0x07d5, B:138:0x07f7, B:143:0x0737, B:146:0x05d0, B:147:0x05d8, B:149:0x049d, B:150:0x04ad, B:152:0x0336, B:154:0x0222), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0767 A[Catch: Exception -> 0x0815, TryCatch #0 {Exception -> 0x0815, blocks: (B:3:0x0004, B:5:0x006f, B:7:0x0087, B:9:0x0093, B:10:0x00b1, B:14:0x00f6, B:16:0x015a, B:19:0x020f, B:21:0x0215, B:24:0x022f, B:27:0x0239, B:29:0x023f, B:31:0x024b, B:33:0x024e, B:37:0x0262, B:39:0x02b8, B:40:0x0345, B:43:0x0351, B:45:0x0357, B:47:0x0365, B:49:0x0368, B:54:0x0382, B:56:0x0400, B:58:0x0408, B:59:0x04bc, B:62:0x04cc, B:64:0x04d2, B:66:0x04de, B:68:0x04e1, B:73:0x0501, B:75:0x055f, B:77:0x0567, B:78:0x05df, B:81:0x05ef, B:83:0x05f5, B:85:0x0601, B:87:0x0604, B:90:0x0610, B:92:0x0617, B:95:0x0622, B:97:0x0628, B:99:0x0632, B:101:0x063a, B:102:0x063d, B:103:0x0647, B:105:0x064e, B:106:0x0665, B:108:0x066a, B:109:0x0690, B:111:0x06b8, B:114:0x06fe, B:116:0x0704, B:119:0x0710, B:120:0x0730, B:123:0x073c, B:125:0x0746, B:127:0x0755, B:128:0x0759, B:129:0x075e, B:131:0x0767, B:132:0x0770, B:134:0x07cd, B:136:0x07d5, B:138:0x07f7, B:143:0x0737, B:146:0x05d0, B:147:0x05d8, B:149:0x049d, B:150:0x04ad, B:152:0x0336, B:154:0x0222), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x07f7 A[Catch: Exception -> 0x0815, TRY_LEAVE, TryCatch #0 {Exception -> 0x0815, blocks: (B:3:0x0004, B:5:0x006f, B:7:0x0087, B:9:0x0093, B:10:0x00b1, B:14:0x00f6, B:16:0x015a, B:19:0x020f, B:21:0x0215, B:24:0x022f, B:27:0x0239, B:29:0x023f, B:31:0x024b, B:33:0x024e, B:37:0x0262, B:39:0x02b8, B:40:0x0345, B:43:0x0351, B:45:0x0357, B:47:0x0365, B:49:0x0368, B:54:0x0382, B:56:0x0400, B:58:0x0408, B:59:0x04bc, B:62:0x04cc, B:64:0x04d2, B:66:0x04de, B:68:0x04e1, B:73:0x0501, B:75:0x055f, B:77:0x0567, B:78:0x05df, B:81:0x05ef, B:83:0x05f5, B:85:0x0601, B:87:0x0604, B:90:0x0610, B:92:0x0617, B:95:0x0622, B:97:0x0628, B:99:0x0632, B:101:0x063a, B:102:0x063d, B:103:0x0647, B:105:0x064e, B:106:0x0665, B:108:0x066a, B:109:0x0690, B:111:0x06b8, B:114:0x06fe, B:116:0x0704, B:119:0x0710, B:120:0x0730, B:123:0x073c, B:125:0x0746, B:127:0x0755, B:128:0x0759, B:129:0x075e, B:131:0x0767, B:132:0x0770, B:134:0x07cd, B:136:0x07d5, B:138:0x07f7, B:143:0x0737, B:146:0x05d0, B:147:0x05d8, B:149:0x049d, B:150:0x04ad, B:152:0x0336, B:154:0x0222), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:142:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0737 A[Catch: Exception -> 0x0815, TryCatch #0 {Exception -> 0x0815, blocks: (B:3:0x0004, B:5:0x006f, B:7:0x0087, B:9:0x0093, B:10:0x00b1, B:14:0x00f6, B:16:0x015a, B:19:0x020f, B:21:0x0215, B:24:0x022f, B:27:0x0239, B:29:0x023f, B:31:0x024b, B:33:0x024e, B:37:0x0262, B:39:0x02b8, B:40:0x0345, B:43:0x0351, B:45:0x0357, B:47:0x0365, B:49:0x0368, B:54:0x0382, B:56:0x0400, B:58:0x0408, B:59:0x04bc, B:62:0x04cc, B:64:0x04d2, B:66:0x04de, B:68:0x04e1, B:73:0x0501, B:75:0x055f, B:77:0x0567, B:78:0x05df, B:81:0x05ef, B:83:0x05f5, B:85:0x0601, B:87:0x0604, B:90:0x0610, B:92:0x0617, B:95:0x0622, B:97:0x0628, B:99:0x0632, B:101:0x063a, B:102:0x063d, B:103:0x0647, B:105:0x064e, B:106:0x0665, B:108:0x066a, B:109:0x0690, B:111:0x06b8, B:114:0x06fe, B:116:0x0704, B:119:0x0710, B:120:0x0730, B:123:0x073c, B:125:0x0746, B:127:0x0755, B:128:0x0759, B:129:0x075e, B:131:0x0767, B:132:0x0770, B:134:0x07cd, B:136:0x07d5, B:138:0x07f7, B:143:0x0737, B:146:0x05d0, B:147:0x05d8, B:149:0x049d, B:150:0x04ad, B:152:0x0336, B:154:0x0222), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x072e  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0253  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0262 A[Catch: Exception -> 0x0815, TryCatch #0 {Exception -> 0x0815, blocks: (B:3:0x0004, B:5:0x006f, B:7:0x0087, B:9:0x0093, B:10:0x00b1, B:14:0x00f6, B:16:0x015a, B:19:0x020f, B:21:0x0215, B:24:0x022f, B:27:0x0239, B:29:0x023f, B:31:0x024b, B:33:0x024e, B:37:0x0262, B:39:0x02b8, B:40:0x0345, B:43:0x0351, B:45:0x0357, B:47:0x0365, B:49:0x0368, B:54:0x0382, B:56:0x0400, B:58:0x0408, B:59:0x04bc, B:62:0x04cc, B:64:0x04d2, B:66:0x04de, B:68:0x04e1, B:73:0x0501, B:75:0x055f, B:77:0x0567, B:78:0x05df, B:81:0x05ef, B:83:0x05f5, B:85:0x0601, B:87:0x0604, B:90:0x0610, B:92:0x0617, B:95:0x0622, B:97:0x0628, B:99:0x0632, B:101:0x063a, B:102:0x063d, B:103:0x0647, B:105:0x064e, B:106:0x0665, B:108:0x066a, B:109:0x0690, B:111:0x06b8, B:114:0x06fe, B:116:0x0704, B:119:0x0710, B:120:0x0730, B:123:0x073c, B:125:0x0746, B:127:0x0755, B:128:0x0759, B:129:0x075e, B:131:0x0767, B:132:0x0770, B:134:0x07cd, B:136:0x07d5, B:138:0x07f7, B:143:0x0737, B:146:0x05d0, B:147:0x05d8, B:149:0x049d, B:150:0x04ad, B:152:0x0336, B:154:0x0222), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0382 A[Catch: Exception -> 0x0815, TryCatch #0 {Exception -> 0x0815, blocks: (B:3:0x0004, B:5:0x006f, B:7:0x0087, B:9:0x0093, B:10:0x00b1, B:14:0x00f6, B:16:0x015a, B:19:0x020f, B:21:0x0215, B:24:0x022f, B:27:0x0239, B:29:0x023f, B:31:0x024b, B:33:0x024e, B:37:0x0262, B:39:0x02b8, B:40:0x0345, B:43:0x0351, B:45:0x0357, B:47:0x0365, B:49:0x0368, B:54:0x0382, B:56:0x0400, B:58:0x0408, B:59:0x04bc, B:62:0x04cc, B:64:0x04d2, B:66:0x04de, B:68:0x04e1, B:73:0x0501, B:75:0x055f, B:77:0x0567, B:78:0x05df, B:81:0x05ef, B:83:0x05f5, B:85:0x0601, B:87:0x0604, B:90:0x0610, B:92:0x0617, B:95:0x0622, B:97:0x0628, B:99:0x0632, B:101:0x063a, B:102:0x063d, B:103:0x0647, B:105:0x064e, B:106:0x0665, B:108:0x066a, B:109:0x0690, B:111:0x06b8, B:114:0x06fe, B:116:0x0704, B:119:0x0710, B:120:0x0730, B:123:0x073c, B:125:0x0746, B:127:0x0755, B:128:0x0759, B:129:0x075e, B:131:0x0767, B:132:0x0770, B:134:0x07cd, B:136:0x07d5, B:138:0x07f7, B:143:0x0737, B:146:0x05d0, B:147:0x05d8, B:149:0x049d, B:150:0x04ad, B:152:0x0336, B:154:0x0222), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0501 A[Catch: Exception -> 0x0815, TryCatch #0 {Exception -> 0x0815, blocks: (B:3:0x0004, B:5:0x006f, B:7:0x0087, B:9:0x0093, B:10:0x00b1, B:14:0x00f6, B:16:0x015a, B:19:0x020f, B:21:0x0215, B:24:0x022f, B:27:0x0239, B:29:0x023f, B:31:0x024b, B:33:0x024e, B:37:0x0262, B:39:0x02b8, B:40:0x0345, B:43:0x0351, B:45:0x0357, B:47:0x0365, B:49:0x0368, B:54:0x0382, B:56:0x0400, B:58:0x0408, B:59:0x04bc, B:62:0x04cc, B:64:0x04d2, B:66:0x04de, B:68:0x04e1, B:73:0x0501, B:75:0x055f, B:77:0x0567, B:78:0x05df, B:81:0x05ef, B:83:0x05f5, B:85:0x0601, B:87:0x0604, B:90:0x0610, B:92:0x0617, B:95:0x0622, B:97:0x0628, B:99:0x0632, B:101:0x063a, B:102:0x063d, B:103:0x0647, B:105:0x064e, B:106:0x0665, B:108:0x066a, B:109:0x0690, B:111:0x06b8, B:114:0x06fe, B:116:0x0704, B:119:0x0710, B:120:0x0730, B:123:0x073c, B:125:0x0746, B:127:0x0755, B:128:0x0759, B:129:0x075e, B:131:0x0767, B:132:0x0770, B:134:0x07cd, B:136:0x07d5, B:138:0x07f7, B:143:0x0737, B:146:0x05d0, B:147:0x05d8, B:149:0x049d, B:150:0x04ad, B:152:0x0336, B:154:0x0222), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0617 A[Catch: Exception -> 0x0815, TryCatch #0 {Exception -> 0x0815, blocks: (B:3:0x0004, B:5:0x006f, B:7:0x0087, B:9:0x0093, B:10:0x00b1, B:14:0x00f6, B:16:0x015a, B:19:0x020f, B:21:0x0215, B:24:0x022f, B:27:0x0239, B:29:0x023f, B:31:0x024b, B:33:0x024e, B:37:0x0262, B:39:0x02b8, B:40:0x0345, B:43:0x0351, B:45:0x0357, B:47:0x0365, B:49:0x0368, B:54:0x0382, B:56:0x0400, B:58:0x0408, B:59:0x04bc, B:62:0x04cc, B:64:0x04d2, B:66:0x04de, B:68:0x04e1, B:73:0x0501, B:75:0x055f, B:77:0x0567, B:78:0x05df, B:81:0x05ef, B:83:0x05f5, B:85:0x0601, B:87:0x0604, B:90:0x0610, B:92:0x0617, B:95:0x0622, B:97:0x0628, B:99:0x0632, B:101:0x063a, B:102:0x063d, B:103:0x0647, B:105:0x064e, B:106:0x0665, B:108:0x066a, B:109:0x0690, B:111:0x06b8, B:114:0x06fe, B:116:0x0704, B:119:0x0710, B:120:0x0730, B:123:0x073c, B:125:0x0746, B:127:0x0755, B:128:0x0759, B:129:0x075e, B:131:0x0767, B:132:0x0770, B:134:0x07cd, B:136:0x07d5, B:138:0x07f7, B:143:0x0737, B:146:0x05d0, B:147:0x05d8, B:149:0x049d, B:150:0x04ad, B:152:0x0336, B:154:0x0222), top: B:2:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void q() {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        JSONObject jSONObject3;
        Gd gd;
        String str7;
        String str8;
        JSONObject jSONObject4;
        String str9;
        JSONObject jSONObject5;
        C3366w9 c3366w9;
        String str10;
        String str11;
        String str12;
        Gd gd2;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        C3366w9 c3366w92;
        V2 v2;
        JSONObject jSONObject6;
        String str18;
        V2 v22;
        C3419zb c3419zb;
        boolean z2;
        JSONObject c;
        String str19;
        JSONObject c3;
        C3241p2 c3241p2;
        C3241p2 c3241p22;
        String str20;
        C3241p2 c3241p23;
        C3241p2 c3241p24;
        try {
            JSONObject c4 = c(this.f, "configurations");
            JSONObject c5 = c(c4, b());
            JSONObject c6 = c(c4, "application");
            JSONObject c7 = c(c5, l());
            JSONObject c8 = c(c5, "interstitial");
            JSONObject c9 = c(c5, "banner");
            JSONObject c10 = c(c5, "nativeAd");
            JSONObject c11 = c(c6, "events");
            JSONObject c12 = c(c6, "loggers");
            JSONObject c13 = c(c6, "token");
            JSONObject c14 = c(c6, "segment");
            JSONObject c15 = c(c6, "auction");
            JSONObject c16 = c(c6, "crashReporter");
            JSONObject c17 = c(c6, "settings");
            JSONObject c18 = c(c6, "external");
            JSONObject c19 = c(c11, a1);
            if (c6 != null) {
                jSONObject = c19;
                jSONObject2 = c4;
                IronSourceUtils.saveBooleanToSharedPrefs(this.g, "uuidEnabled", c6.optBoolean("uuidEnabled", true));
            } else {
                jSONObject = c19;
                jSONObject2 = c4;
            }
            if (c11 != null) {
                String optString = c11.optString("abt");
                if (!TextUtils.isEmpty(optString)) {
                    C3334ub.U().q().a(optString);
                    C3400y9.i().a(optString);
                    Id.i().a(optString);
                    str = optString;
                    H1 a3 = a(c11, Boolean.valueOf(c11.optBoolean("sendUltraEvents", false)));
                    String str21 = F1;
                    String str22 = "auctionTrials";
                    String str23 = P1;
                    String str24 = O1;
                    if (c7 == null) {
                        str6 = G1;
                        JSONArray optJSONArray = c7.optJSONArray("placements");
                        str4 = "placements";
                        JSONObject c20 = c(c7, "events");
                        str2 = "events";
                        JSONObject d = d(c7, y0);
                        JSONArray jSONArray = optJSONArray;
                        long optLong = c7.optLong(x0, 3000L);
                        boolean optBoolean = d.optBoolean(z0, false);
                        boolean optBoolean2 = d.optBoolean(A0, false);
                        boolean optBoolean3 = c7.optBoolean(B0, true);
                        int a4 = a(c7, c6, "parallelLoad", 2);
                        boolean a5 = a(c7, c6, "bidderExclusive", true);
                        int a6 = a(c7, c6, E0, 60);
                        int a7 = a(c7, c6, "expiredDurationInMinutes", -1);
                        int a8 = a(c7, c6, s1, 3);
                        boolean a9 = a(c7, c6, "isOneFlow", false);
                        JSONObject mergeJsons = IronSourceUtils.mergeJsons(c20, c11);
                        H1 a10 = a(mergeJsons, Boolean.valueOf(mergeJsons.optBoolean("sendUltraEvents", false)));
                        if (c15 != null) {
                            JSONObject c21 = c(c15, l());
                            String optString2 = c15.optString(E1, "");
                            String optString3 = c15.optString(str21, "");
                            String optString4 = c15.optString(str6, "");
                            str6 = str6;
                            int optInt = c15.optInt(str22, 2);
                            str22 = str22;
                            str21 = str21;
                            long optLong2 = c15.optLong(str24, 10000L);
                            int optInt2 = c15.optInt(str23, 15);
                            str24 = str24;
                            boolean optBoolean4 = c15.optBoolean(U1, false);
                            boolean optBoolean5 = c15.optBoolean(V1, false);
                            int optInt3 = c15.optInt(W1, 1);
                            boolean optBoolean6 = c15.optBoolean(R1, true);
                            boolean optBoolean7 = c21.optBoolean(S1, true);
                            int optInt4 = c21.optInt(I1, 2000);
                            str23 = str23;
                            int optInt5 = c21.optInt(L1, 30000);
                            str3 = "";
                            int optInt6 = c21.optInt(J1, 5000);
                            str5 = E1;
                            jSONObject3 = c15;
                            C3241p2 c3241p25 = new C3241p2(optString2, optString3, optString4, optInt, optInt2, optLong2, optInt4, optInt5, optInt6, c21.optInt(K1, 50), c21.optBoolean("isLoadWhileShow", true), c21.optInt(T1, 30000), optBoolean4, optBoolean5, c21.optBoolean(H1, false), optInt3, false, optBoolean6, optBoolean7);
                            JSONArray optJSONArray2 = c21.optJSONArray(Q1);
                            if (optJSONArray2 != null) {
                                for (int i = 0; i < optJSONArray2.length(); i++) {
                                    c3241p25.a(optJSONArray2.optString(i));
                                }
                            }
                            c3241p24 = c3241p25;
                        } else {
                            str5 = E1;
                            jSONObject3 = c15;
                            str3 = "";
                            c3241p24 = new C3241p2();
                        }
                        gd = new Gd(a4, a5, a6, a7, a10, c3241p24, a8, a9, optLong, optBoolean, optBoolean2, optBoolean3);
                        if (jSONArray != null) {
                            int i3 = 0;
                            while (i3 < jSONArray.length()) {
                                JSONArray jSONArray2 = jSONArray;
                                Placement g = g(jSONArray2.optJSONObject(i3));
                                if (g != null) {
                                    gd.a(g);
                                }
                                i3++;
                                jSONArray = jSONArray2;
                            }
                        }
                    } else {
                        str2 = "events";
                        str3 = "";
                        str4 = "placements";
                        str5 = E1;
                        str6 = G1;
                        jSONObject3 = c15;
                        gd = null;
                    }
                    if (c8 == null) {
                        String str25 = str4;
                        JSONArray optJSONArray3 = c8.optJSONArray(str25);
                        str7 = str2;
                        JSONObject c22 = c(c8, str7);
                        JSONObject d3 = d(c8, y0);
                        str4 = str25;
                        JSONArray jSONArray3 = optJSONArray3;
                        long optLong3 = c8.optLong(x0, 3000L);
                        boolean optBoolean8 = d3.optBoolean(z0, false);
                        boolean optBoolean9 = d3.optBoolean(A0, false);
                        boolean optBoolean10 = c8.optBoolean(B0, true);
                        int a11 = a(c8, c6, "parallelLoad", 2);
                        boolean a12 = a(c8, c6, "bidderExclusive", false);
                        int a13 = a(c8, c6, E0, 60);
                        int a14 = a(c8, c6, s1, 3);
                        boolean a15 = a(c8, c6, "isOneFlow", false);
                        H1 a16 = a(IronSourceUtils.mergeJsons(c22, c11), Boolean.FALSE);
                        if (jSONObject3 != null) {
                            jSONObject4 = jSONObject3;
                            JSONObject c23 = c(jSONObject4, "interstitial");
                            String str26 = str3;
                            str8 = str5;
                            String optString5 = jSONObject4.optString(str8, str26);
                            String str27 = str21;
                            String optString6 = jSONObject4.optString(str27, str26);
                            jSONObject5 = c6;
                            String str28 = str6;
                            String optString7 = jSONObject4.optString(str28, str26);
                            str6 = str28;
                            str3 = str26;
                            String str29 = str22;
                            int optInt7 = jSONObject4.optInt(str29, 2);
                            str22 = str29;
                            String str30 = str23;
                            str23 = str30;
                            str9 = str27;
                            str20 = str24;
                            c3241p23 = new C3241p2(optString5, optString6, optString7, optInt7, jSONObject4.optInt(str30, 15), jSONObject4.optLong(str20, 10000L), c23.optInt(I1, 2000), 0L, 0L, 0L, true, 0, jSONObject4.optBoolean(U1, false), jSONObject4.optBoolean(V1, false), true, jSONObject4.optInt(W1, 1), false, jSONObject4.optBoolean(R1, true), c23.optBoolean(S1, true));
                        } else {
                            str9 = str21;
                            str20 = str24;
                            str8 = str5;
                            jSONObject4 = jSONObject3;
                            jSONObject5 = c6;
                            c3241p23 = new C3241p2();
                        }
                        C3366w9 c3366w93 = new C3366w9(a11, a12, a13, a16, c3241p23, a14, a15, optLong3, optBoolean8, optBoolean9, optBoolean10);
                        if (jSONArray3 != null) {
                            int i4 = 0;
                            while (i4 < jSONArray3.length()) {
                                String str31 = str20;
                                JSONArray jSONArray4 = jSONArray3;
                                InterstitialPlacement e = e(jSONArray4.optJSONObject(i4));
                                if (e != null) {
                                    c3366w93.a(e);
                                }
                                i4++;
                                jSONArray3 = jSONArray4;
                                str20 = str31;
                            }
                        }
                        str24 = str20;
                        c3366w9 = c3366w93;
                    } else {
                        str7 = str2;
                        str8 = str5;
                        jSONObject4 = jSONObject3;
                        str9 = str21;
                        jSONObject5 = c6;
                        c3366w9 = null;
                    }
                    if (c9 == null) {
                        String str32 = str4;
                        JSONArray optJSONArray4 = c9.optJSONArray(str32);
                        JSONObject c24 = c(c9, str7);
                        JSONObject d4 = d(c9, y0);
                        String str33 = str22;
                        JSONArray jSONArray5 = optJSONArray4;
                        JSONObject jSONObject7 = jSONObject5;
                        String str34 = str9;
                        str10 = str7;
                        str14 = y0;
                        gd2 = gd;
                        String str35 = str8;
                        str16 = str32;
                        String str36 = str3;
                        c3366w92 = c3366w9;
                        str13 = z0;
                        long a17 = a(c9, jSONObject7, F0, 10000L);
                        int a18 = a(c9, jSONObject7, s1, 3);
                        int optInt8 = c9.optInt(G0, 60);
                        long optLong4 = c9.optLong(Y1, 15000L);
                        boolean a19 = a(c9, jSONObject7, "isOneFlow", false);
                        long optLong5 = c9.optLong(x0, 3000L);
                        boolean optBoolean11 = d4.optBoolean(str13, false);
                        boolean optBoolean12 = d4.optBoolean(A0, false);
                        boolean optBoolean13 = c9.optBoolean(B0, true);
                        H1 a20 = a(IronSourceUtils.mergeJsons(c24, c11), Boolean.FALSE);
                        if (jSONObject4 != null) {
                            JSONObject c25 = c(jSONObject4, "banner");
                            if (c25 != null) {
                                str11 = str35;
                                str17 = str36;
                                String optString8 = jSONObject4.optString(str11, str17);
                                String optString9 = jSONObject4.optString(str34, str17);
                                String str37 = str6;
                                String optString10 = jSONObject4.optString(str37, str17);
                                int optInt9 = jSONObject4.optInt(str33, 2);
                                str6 = str37;
                                String str38 = str23;
                                int optInt10 = jSONObject4.optInt(str38, 15);
                                jSONObject5 = jSONObject7;
                                str12 = str34;
                                str23 = str38;
                                String str39 = str24;
                                str24 = str39;
                                str15 = str33;
                                c3241p22 = new C3241p2(optString8, optString9, optString10, optInt9, optInt10, jSONObject4.optLong(str39, 10000L), c25.optInt(I1, 2000), c25.optInt(L1, 15000), c25.optInt(J1, 50), 0L, c25.optBoolean("isLoadWhileShow", false), 0, jSONObject4.optBoolean(U1, false), jSONObject4.optBoolean(V1, false), c25.optBoolean(H1, true), jSONObject4.optInt(W1, 1), c25.optBoolean(X1, true), jSONObject4.optBoolean(R1, true), c25.optBoolean(S1, true));
                            } else {
                                str12 = str34;
                                str11 = str35;
                                str17 = str36;
                                str15 = str33;
                                jSONObject5 = jSONObject7;
                                c3241p22 = new C3241p2();
                            }
                        } else {
                            str12 = str34;
                            str11 = str35;
                            str17 = str36;
                            str15 = str33;
                            jSONObject5 = jSONObject7;
                            c3241p22 = new C3241p2();
                        }
                        V2 v23 = new V2(1, a17, false, a20, optInt8, c3241p22, a18, a19, optLong5, optBoolean11, optBoolean12, optBoolean13, optLong4);
                        if (jSONArray5 != null) {
                            int i5 = 0;
                            while (i5 < jSONArray5.length()) {
                                JSONArray jSONArray6 = jSONArray5;
                                C3124i3 d5 = d(jSONArray6.optJSONObject(i5));
                                if (d5 != null) {
                                    v23.a(d5);
                                }
                                i5++;
                                jSONArray5 = jSONArray6;
                            }
                        }
                        v2 = v23;
                    } else {
                        String str40 = str9;
                        str10 = str7;
                        str11 = str8;
                        str12 = str40;
                        gd2 = gd;
                        str13 = z0;
                        str14 = y0;
                        str15 = str22;
                        str16 = str4;
                        str17 = str3;
                        c3366w92 = c3366w9;
                        v2 = null;
                    }
                    if (c10 == null) {
                        JSONArray optJSONArray5 = c10.optJSONArray(str16);
                        String str41 = str10;
                        JSONObject c26 = c(c10, str41);
                        JSONObject d6 = d(c10, str14);
                        String str42 = str11;
                        String str43 = str12;
                        String str44 = str15;
                        String str45 = str23;
                        String str46 = str24;
                        String str47 = str6;
                        str18 = str41;
                        v22 = v2;
                        JSONArray jSONArray7 = optJSONArray5;
                        jSONObject6 = jSONObject5;
                        long a21 = a(c10, jSONObject6, F0, 10000L);
                        int a22 = a(c10, jSONObject6, s1, 0);
                        long optLong6 = c10.optLong(x0, 3000L);
                        boolean optBoolean14 = d6.optBoolean(str13, false);
                        boolean optBoolean15 = d6.optBoolean(A0, false);
                        boolean optBoolean16 = c10.optBoolean(B0, true);
                        H1 a23 = a(IronSourceUtils.mergeJsons(c26, c11), Boolean.FALSE);
                        if (jSONObject4 != null) {
                            JSONObject c27 = c(jSONObject4, "nativeAd");
                            if (c27 != null) {
                                str11 = str42;
                                c3241p2 = new C3241p2(jSONObject4.optString(str11, str17), jSONObject4.optString(str43, str17), jSONObject4.optString(str47, str17), jSONObject4.optInt(str44, 2), jSONObject4.optInt(str45, 15), jSONObject4.optLong(str46, 10000L), c27.optInt(I1, 2000), 0L, 0L, 0L, true, 0, jSONObject4.optBoolean(U1, false), jSONObject4.optBoolean(V1, false), true, jSONObject4.optInt(W1, 1), false, jSONObject4.optBoolean(R1, true), c27.optBoolean(S1, true));
                            } else {
                                str11 = str42;
                                c3241p2 = new C3241p2();
                            }
                        } else {
                            str11 = str42;
                            c3241p2 = new C3241p2();
                        }
                        c3419zb = new C3419zb(1, a21, false, a23, c3241p2, a22, optLong6, optBoolean14, optBoolean15, optBoolean16);
                        if (jSONArray7 != null) {
                            int i6 = 0;
                            while (i6 < jSONArray7.length()) {
                                JSONArray jSONArray8 = jSONArray7;
                                Kb f = f(jSONArray8.optJSONObject(i6));
                                if (f != null) {
                                    c3419zb.a(f);
                                }
                                i6++;
                                jSONArray7 = jSONArray8;
                            }
                        }
                    } else {
                        jSONObject6 = jSONObject5;
                        str18 = str10;
                        v22 = v2;
                        c3419zb = null;
                    }
                    Kf kf = new Kf();
                    if (c13 != null) {
                        JSONArray optJSONArray6 = c13.optJSONArray(Z1);
                        if (optJSONArray6 != null) {
                            for (int i7 = 0; i7 < optJSONArray6.length(); i7++) {
                                kf.a(optJSONArray6.optString(i7));
                            }
                        }
                        JSONObject optJSONObject = c13.optJSONObject(a2);
                        if (optJSONObject != null) {
                            kf.a(optJSONObject);
                        }
                        kf.a(c13.optBoolean(b2, true));
                    }
                    Rc rc = new Rc();
                    if (jSONObject == null) {
                        JSONObject jSONObject8 = jSONObject;
                        String optString11 = jSONObject8.optString(b1, Sc.f3051a);
                        z2 = jSONObject8.optBoolean(c1, true);
                        rc.a(optString11);
                    } else {
                        z2 = true;
                    }
                    rc.b(z2);
                    if (z2) {
                        rc.b(a(c11, "optOut"));
                        rc.a(a(c11, "optIn"));
                        rc.a(c11.optBoolean("eventsCompression", false));
                        rc.a(c11.optInt("eventsCompressionLevel", -1));
                    }
                    O1 o12 = new O1(c12.optInt("server", 3), c12.optInt("publisher", 3), c12.optInt("console", 3), c12.optBoolean("shouldSendPublisherLogsOnUIThread", false));
                    E1 e12 = new E1();
                    if (c16 != null) {
                        e12.a(c16.optBoolean("enabled", false));
                        e12.c(c16.optString("reporterURL", str17));
                        e12.b(c16.optString("reporterKeyword", str17));
                        e12.c(c16.optBoolean("includeANR", false));
                        e12.a(c16.optInt("timeout", 5000));
                        e12.b(c16.optBoolean("setIgnoreDebugger", false));
                        JSONArray optJSONArray7 = c16.optJSONArray("keysToInclude");
                        if (optJSONArray7 != null) {
                            for (int i8 = 0; i8 < optJSONArray7.length(); i8++) {
                                e12.a(optJSONArray7.optString(i8));
                            }
                        }
                    }
                    C3354ve c3354ve = c14 == null ? new C3354ve(c14.optString("name", str17), c14.optString("id", Y1.f), c14.optJSONObject("custom")) : null;
                    K1 k12 = new K1(c17 == null ? c17 : new JSONObject());
                    J1 j12 = new J1();
                    if (c18 != null) {
                        JSONObject optJSONObject2 = c18.optJSONObject(p0);
                        Map hashMap = new HashMap();
                        if (optJSONObject2 != null) {
                            hashMap = IronSourceUtils.parseJsonToStringMap(optJSONObject2);
                        }
                        j12 = new J1(hashMap);
                    }
                    J1 j13 = j12;
                    C3392y1 c3392y1 = new C3392y1();
                    if (jSONObject4 != null) {
                        c3392y1 = new C3392y1(jSONObject4.optString(str11));
                    }
                    A1 a110 = new A1(o12, c3354ve, kf, jSONObject6.optBoolean("integration", false), e12, k12, j13, rc, c3392y1, str, a3);
                    JSONObject jSONObject9 = jSONObject2;
                    C3389xf h = h(jSONObject9);
                    com.ironsource.mediationsdk.adquality.a c28 = c(jSONObject9);
                    U3.a aVar = new U3.a();
                    aVar.a(gd2);
                    aVar.a(c3366w92);
                    aVar.a(v22);
                    aVar.a(c3419zb);
                    aVar.a(a110);
                    aVar.b(h);
                    aVar.a(c28);
                    U3 a24 = aVar.a();
                    this.c = a24;
                    IronLog.INTERNAL.verbose(a24.toString());
                    c = c(c11, "genericParams");
                    if (c != null && (c3 = c(c, (str19 = str18))) != null) {
                        c.remove(str19);
                        Map<String, String> parseJsonToStringMap = IronSourceUtils.parseJsonToStringMap(c3);
                        C3334ub.U().q().b(parseJsonToStringMap);
                        Id.i().b(parseJsonToStringMap);
                        C3400y9.i().b(parseJsonToStringMap);
                    }
                    if (c == null) {
                        Map<String, String> parseJsonToStringMap2 = IronSourceUtils.parseJsonToStringMap(c);
                        C3334ub.U().q().a(parseJsonToStringMap2);
                        Id.i().a(parseJsonToStringMap2);
                        C3400y9.i().a(parseJsonToStringMap2);
                        return;
                    }
                    return;
                }
            }
            str = null;
            H1 a32 = a(c11, Boolean.valueOf(c11.optBoolean("sendUltraEvents", false)));
            String str212 = F1;
            String str222 = "auctionTrials";
            String str232 = P1;
            String str242 = O1;
            if (c7 == null) {
            }
            if (c8 == null) {
            }
            if (c9 == null) {
            }
            if (c10 == null) {
            }
            Kf kf2 = new Kf();
            if (c13 != null) {
            }
            Rc rc2 = new Rc();
            if (jSONObject == null) {
            }
            rc2.b(z2);
            if (z2) {
            }
            O1 o122 = new O1(c12.optInt("server", 3), c12.optInt("publisher", 3), c12.optInt("console", 3), c12.optBoolean("shouldSendPublisherLogsOnUIThread", false));
            E1 e122 = new E1();
            if (c16 != null) {
            }
            if (c14 == null) {
            }
            K1 k122 = new K1(c17 == null ? c17 : new JSONObject());
            J1 j122 = new J1();
            if (c18 != null) {
            }
            J1 j132 = j122;
            C3392y1 c3392y12 = new C3392y1();
            if (jSONObject4 != null) {
            }
            A1 a1102 = new A1(o122, c3354ve, kf2, jSONObject6.optBoolean("integration", false), e122, k122, j132, rc2, c3392y12, str, a32);
            JSONObject jSONObject92 = jSONObject2;
            C3389xf h3 = h(jSONObject92);
            com.ironsource.mediationsdk.adquality.a c282 = c(jSONObject92);
            U3.a aVar2 = new U3.a();
            aVar2.a(gd2);
            aVar2.a(c3366w92);
            aVar2.a(v22);
            aVar2.a(c3419zb);
            aVar2.a(a1102);
            aVar2.b(h3);
            aVar2.a(c282);
            U3 a242 = aVar2.a();
            this.c = a242;
            IronLog.INTERNAL.verbose(a242.toString());
            c = c(c11, "genericParams");
            if (c != null) {
                c.remove(str19);
                Map<String, String> parseJsonToStringMap3 = IronSourceUtils.parseJsonToStringMap(c3);
                C3334ub.U().q().b(parseJsonToStringMap3);
                Id.i().b(parseJsonToStringMap3);
                C3400y9.i().b(parseJsonToStringMap3);
            }
            if (c == null) {
            }
        } catch (Exception e3) {
            C3260q4.d().a(e3);
            IronLog.INTERNAL.error(e3.toString());
        }
    }

    private void r() {
        try {
            JSONObject c = c(this.f, "providerOrder");
            JSONArray b = b(c, l());
            JSONArray b3 = b(c, "interstitial");
            JSONArray b4 = b(c, "banner");
            JSONArray b5 = b(c, "nativeAd");
            this.f3896a = new C3134id();
            if (b != null && c() != null && c().f() != null) {
                for (int i = 0; i < b.length(); i++) {
                    String optString = b.optString(i);
                    this.f3896a.d(optString);
                    NetworkSettings b6 = C3167kd.c().b(optString);
                    if (b6 != null) {
                        b6.setRewardedVideoPriority(i);
                    }
                }
            }
            if (b3 != null && c() != null && c().d() != null) {
                for (int i3 = 0; i3 < b3.length(); i3++) {
                    String optString2 = b3.optString(i3);
                    this.f3896a.b(optString2);
                    NetworkSettings b7 = C3167kd.c().b(optString2);
                    if (b7 != null) {
                        b7.setInterstitialPriority(i3);
                    }
                }
            }
            if (b4 != null) {
                for (int i4 = 0; i4 < b4.length(); i4++) {
                    String optString3 = b4.optString(i4);
                    this.f3896a.a(optString3);
                    NetworkSettings b8 = C3167kd.c().b(optString3);
                    if (b8 != null) {
                        b8.setBannerPriority(i4);
                    }
                }
            }
            if (b5 != null) {
                for (int i5 = 0; i5 < b5.length(); i5++) {
                    String optString4 = b5.optString(i5);
                    this.f3896a.c(optString4);
                    NetworkSettings b9 = C3167kd.c().b(optString4);
                    if (b9 != null) {
                        b9.setNativeAdPriority(i5);
                    }
                }
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    private void s() {
        JSONObject jSONObject;
        Iterator<String> it;
        try {
            this.b = C3167kd.c();
            JSONObject c = c(this.f, "providerSettings");
            Iterator<String> keys = c.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = c.optJSONObject(next);
                if (optJSONObject != null) {
                    boolean optBoolean = optJSONObject.optBoolean("mpis", false);
                    String optString = optJSONObject.optString("spId", "0");
                    String optString2 = optJSONObject.optString("adSourceName", null);
                    String optString3 = optJSONObject.optString("providerNetworkKey", null);
                    String optString4 = optJSONObject.optString("providerLoadName", next);
                    String optString5 = optJSONObject.optString("providerDefaultInstance", optString4);
                    JSONObject c3 = c(optJSONObject, b());
                    JSONObject c4 = c(optJSONObject, "application");
                    JSONObject c5 = c(c3, l());
                    JSONObject c6 = c(c3, "interstitial");
                    JSONObject c7 = c(c3, "banner");
                    JSONObject c8 = c(c3, "nativeAd");
                    JSONObject mergeJsons = IronSourceUtils.mergeJsons(c5, c4);
                    JSONObject mergeJsons2 = IronSourceUtils.mergeJsons(c6, c4);
                    JSONObject mergeJsons3 = IronSourceUtils.mergeJsons(c7, c4);
                    JSONObject mergeJsons4 = IronSourceUtils.mergeJsons(c8, c4);
                    if (this.b.a(next)) {
                        C3334ub.U().q().a(new C3413z5(A5.TROUBLESHOOTING_MERGE_LOCAL_SETTINGS, (JSONObject) null));
                        NetworkSettings b = this.b.b(next);
                        JSONObject rewardedVideoSettings = b.getRewardedVideoSettings();
                        JSONObject interstitialSettings = b.getInterstitialSettings();
                        JSONObject bannerSettings = b.getBannerSettings();
                        JSONObject nativeAdSettings = b.getNativeAdSettings();
                        b.setRewardedVideoSettings(IronSourceUtils.mergeJsons(rewardedVideoSettings, mergeJsons));
                        b.setInterstitialSettings(IronSourceUtils.mergeJsons(interstitialSettings, mergeJsons2));
                        b.setBannerSettings(IronSourceUtils.mergeJsons(bannerSettings, mergeJsons3));
                        b.setNativeAdSettings(IronSourceUtils.mergeJsons(nativeAdSettings, mergeJsons4));
                        b.setIsMultipleInstances(optBoolean);
                        b.setSubProviderId(optString);
                        b.setAdSourceNameForEvents(optString2);
                        b.setProviderNetworkKey(optString3);
                    } else {
                        if (b(optString4)) {
                            jSONObject = c;
                            NetworkSettings b3 = this.b.b("Mediation");
                            JSONObject rewardedVideoSettings2 = b3.getRewardedVideoSettings();
                            JSONObject interstitialSettings2 = b3.getInterstitialSettings();
                            JSONObject bannerSettings2 = b3.getBannerSettings();
                            JSONObject nativeAdSettings2 = b3.getNativeAdSettings();
                            it = keys;
                            NetworkSettings networkSettings = new NetworkSettings(next, optString4, optString5, optString3, c4, IronSourceUtils.mergeJsons(new JSONObject(rewardedVideoSettings2.toString()), mergeJsons), IronSourceUtils.mergeJsons(new JSONObject(interstitialSettings2.toString()), mergeJsons2), IronSourceUtils.mergeJsons(new JSONObject(bannerSettings2.toString()), mergeJsons3), IronSourceUtils.mergeJsons(new JSONObject(nativeAdSettings2.toString()), mergeJsons4));
                            networkSettings.setIsMultipleInstances(optBoolean);
                            networkSettings.setSubProviderId(optString);
                            networkSettings.setAdSourceNameForEvents(optString2);
                            this.b.a(networkSettings);
                        } else {
                            jSONObject = c;
                            it = keys;
                            NetworkSettings networkSettings2 = new NetworkSettings(next, optString4, optString5, optString3, c4, mergeJsons, mergeJsons2, mergeJsons3, mergeJsons4);
                            networkSettings2.setIsMultipleInstances(optBoolean);
                            networkSettings2.setSubProviderId(optString);
                            networkSettings2.setAdSourceNameForEvents(optString2);
                            this.b.a(networkSettings2);
                        }
                        c = jSONObject;
                        keys = it;
                    }
                }
            }
            this.b.b();
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
    }

    public V8 f() {
        return new V8(this.d, this.e);
    }

    public List<IronSource.AD_UNIT> g() {
        C3134id c3134id;
        C3134id c3134id2;
        C3134id c3134id3;
        C3134id c3134id4;
        if (this.f == null || this.c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (this.c.f() != null && (c3134id4 = this.f3896a) != null && !c3134id4.d().isEmpty()) {
            arrayList.add(IronSource.AD_UNIT.REWARDED_VIDEO);
        }
        if (this.c.d() != null && (c3134id3 = this.f3896a) != null && !c3134id3.b().isEmpty()) {
            arrayList.add(IronSource.AD_UNIT.INTERSTITIAL);
        }
        if (this.c.c() != null && (c3134id2 = this.f3896a) != null && !c3134id2.a().isEmpty()) {
            arrayList.add(IronSource.AD_UNIT.BANNER);
        }
        if (this.c.e() != null && (c3134id = this.f3896a) != null && !c3134id.c().isEmpty()) {
            arrayList.add(IronSource.AD_UNIT.NATIVE_AD);
        }
        return arrayList;
    }

    public a h() {
        return this.h;
    }

    public JSONObject i() {
        return this.f;
    }

    public C3134id j() {
        return this.f3896a;
    }

    public C3167kd k() {
        return this.b;
    }

    public boolean o() {
        return !TextUtils.isEmpty(c().g().b());
    }

    public boolean p() {
        JSONObject jSONObject = this.f;
        return (jSONObject == null || jSONObject.has("error") || this.f3896a == null || this.b == null || this.c == null || !m()) ? false : true;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appKey", this.d);
            jSONObject.put("userId", this.e);
            jSONObject.put(n, this.f);
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
        }
        return jSONObject.toString();
    }

    private String b() {
        return this.j ? "adFormats" : X0.c;
    }

    private Kb f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("placementId", -1);
        String optString = jSONObject.optString("placementName", "");
        boolean optBoolean = jSONObject.optBoolean(h1, false);
        Tc a3 = a(jSONObject);
        if (optInt < 0 || TextUtils.isEmpty(optString)) {
            return null;
        }
        Kb kb = new Kb(optInt, optString, optBoolean, a3);
        if (a3 != null) {
            this.i.b(this.g, kb, IronSource.AD_UNIT.NATIVE_AD);
        }
        return kb;
    }

    private C3389xf h(JSONObject jSONObject) {
        C3389xf c3389xf = new C3389xf();
        JSONObject c = c(jSONObject, "testSuite");
        if (c != null) {
            c3389xf.b(c.optString("controllerUrl"));
        }
        return c3389xf;
    }

    public U3 c() {
        return this.c;
    }

    private JSONArray b(JSONObject jSONObject, String str) {
        if (jSONObject == null) {
            return null;
        }
        if (!this.j) {
            return jSONObject.optJSONArray(str);
        }
        JSONObject c = c(jSONObject, str);
        String a3 = a(str);
        if (c == null || a3 == null) {
            return null;
        }
        return c.optJSONArray(a3);
    }

    private com.ironsource.mediationsdk.adquality.a c(JSONObject jSONObject) {
        com.ironsource.mediationsdk.adquality.a aVar = new com.ironsource.mediationsdk.adquality.a();
        JSONObject c = c(jSONObject, "AdQuality");
        if (c != null) {
            aVar.a(c.optInt("initMode", 0));
            new J9().b(c.optString("adq_init_blob"));
        }
        return aVar;
    }

    public void a(a aVar) {
        this.h = aVar;
    }

    private void a() {
        this.f = new JSONObject();
        this.d = "";
        this.e = "";
        this.f3896a = new C3134id();
        this.b = C3167kd.c();
        this.c = new U3.a().a();
        this.i = C3334ub.O().x();
        b(this.f);
    }

    private JSONObject d(JSONObject jSONObject, String str) {
        JSONObject c = c(jSONObject, str);
        return c != null ? c : new JSONObject();
    }

    public N5 e() {
        return this.k;
    }

    private boolean b(String str) {
        return this.b.a("Mediation") && StringUtils.toLowerCase("IronSource").equals(StringUtils.toLowerCase(str));
    }

    private Context d() {
        return this.g;
    }

    private String a(String str) {
        try {
            JSONObject c = c(c(c(c(this.f, "configurations"), "adFormats"), str), X0.c);
            if (c == null) {
                return null;
            }
            Iterator<String> keys = c.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject c3 = c(c, next);
                if (c3 != null && c3.optBoolean(h1)) {
                    return next;
                }
            }
            return null;
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return null;
        }
    }

    public static Kf b(C3337ue c3337ue) {
        if (c3337ue != null && c3337ue.p()) {
            return c3337ue.c().b().k();
        }
        return Kf.a();
    }

    private Placement g(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        int optInt = jSONObject.optInt("placementId", -1);
        String optString = jSONObject.optString("placementName", "");
        boolean optBoolean = jSONObject.optBoolean(h1, false);
        String optString2 = jSONObject.optString("virtualItemName", "");
        int optInt2 = jSONObject.optInt("virtualItemCount", -1);
        Tc a3 = a(jSONObject);
        if (optInt < 0 || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || optInt2 <= 0) {
            return null;
        }
        Placement placement = new Placement(optInt, optString, optBoolean, optString2, optInt2, a3);
        if (a3 != null) {
            this.i.b(this.g, placement, IronSource.AD_UNIT.REWARDED_VIDEO);
        }
        return placement;
    }

    public C3337ue(C3337ue c3337ue) {
        this.h = a.NOT_SET;
        this.j = false;
        try {
            this.g = c3337ue.d();
            this.f = new JSONObject(c3337ue.f.toString());
            this.d = c3337ue.d;
            this.e = c3337ue.e;
            this.j = c3337ue.j;
            this.f3896a = c3337ue.j();
            this.b = c3337ue.k();
            this.c = c3337ue.c();
            this.h = c3337ue.h();
            this.i = C3334ub.O().x();
            b(this.f);
        } catch (Exception e) {
            C3260q4.d().a(e);
            a();
        }
    }

    private H1 a(JSONObject jSONObject, Boolean bool) {
        int[] iArr;
        int[] iArr2;
        int[] iArr3;
        boolean optBoolean = jSONObject.optBoolean("sendEventsToggle", false);
        boolean optBoolean2 = jSONObject.optBoolean("eventsCompression", false);
        int optInt = jSONObject.optInt("eventsCompressionLevel", -1);
        String optString = jSONObject.optString("serverEventsURL", "");
        String optString2 = jSONObject.optString("serverEventsType", "");
        int optInt2 = jSONObject.optInt("backupThreshold", -1);
        int optInt3 = jSONObject.optInt("maxNumberOfEvents", -1);
        int optInt4 = jSONObject.optInt("maxEventsPerBatch", 5000);
        JSONArray optJSONArray = jSONObject.optJSONArray("optOut");
        int[] iArr4 = null;
        if (optJSONArray != null) {
            int[] iArr5 = new int[optJSONArray.length()];
            for (int i = 0; i < optJSONArray.length(); i++) {
                iArr5[i] = optJSONArray.optInt(i);
            }
            iArr = iArr5;
        } else {
            iArr = null;
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("optIn");
        if (optJSONArray2 != null) {
            int[] iArr6 = new int[optJSONArray2.length()];
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                iArr6[i3] = optJSONArray2.optInt(i3);
            }
            iArr2 = iArr6;
        } else {
            iArr2 = null;
        }
        JSONArray optJSONArray3 = jSONObject.optJSONArray("triggerEvents");
        if (optJSONArray3 != null) {
            int[] iArr7 = new int[optJSONArray3.length()];
            for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                iArr7[i4] = optJSONArray3.optInt(i4);
            }
            iArr3 = iArr7;
        } else {
            iArr3 = null;
        }
        JSONArray optJSONArray4 = jSONObject.optJSONArray("nonConnectivityEvents");
        if (optJSONArray4 != null) {
            iArr4 = new int[optJSONArray4.length()];
            for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                iArr4[i5] = optJSONArray4.optInt(i5);
            }
        }
        return new H1(bool.booleanValue(), optBoolean, optBoolean2, optInt, optString, optString2, optInt2, optInt3, optInt4, iArr, iArr2, iArr3, iArr4);
    }

    private int[] a(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        int[] iArr = new int[optJSONArray.length()];
        for (int i = 0; i < optJSONArray.length(); i++) {
            iArr[i] = optJSONArray.optInt(i);
        }
        return iArr;
    }

    private boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str, boolean z2) {
        return jSONObject.has(str) ? jSONObject.optBoolean(str, z2) : jSONObject2.has(str) ? jSONObject2.optBoolean(str, z2) : z2;
    }

    private int a(JSONObject jSONObject, JSONObject jSONObject2, String str, int i) {
        int i3 = 0;
        if (jSONObject.has(str)) {
            i3 = jSONObject.optInt(str, 0);
        } else if (jSONObject2.has(str)) {
            i3 = jSONObject2.optInt(str, 0);
        }
        return i3 == 0 ? i : i3;
    }

    private long a(JSONObject jSONObject, JSONObject jSONObject2, String str, long j) {
        long optLong;
        if (jSONObject.has(str)) {
            optLong = jSONObject.optLong(str, 0L);
        } else {
            optLong = jSONObject2.has(str) ? jSONObject2.optLong(str, 0L) : 0L;
        }
        return optLong == 0 ? j : optLong;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
    
        if (r7.toString().equals(r6) != false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Tc a(JSONObject jSONObject) {
        Xc xc = null;
        if (jSONObject == null) {
            return null;
        }
        Tc.a aVar = new Tc.a();
        aVar.a(jSONObject.optBoolean("delivery", true));
        JSONObject optJSONObject = jSONObject.optJSONObject("capping");
        if (optJSONObject != null) {
            String optString = optJSONObject.optString(n1);
            if (!TextUtils.isEmpty(optString)) {
                Xc xc2 = Xc.PER_DAY;
                if (!xc2.toString().equals(optString)) {
                    xc2 = Xc.PER_HOUR;
                }
                xc = xc2;
            }
            int optInt = optJSONObject.optInt(l1, 0);
            aVar.a(optJSONObject.optBoolean("enabled", false) && optInt > 0, xc, optInt);
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("pacing");
        if (optJSONObject2 != null) {
            int optInt2 = optJSONObject2.optInt(m1, 0);
            aVar.a(optJSONObject2.optBoolean("enabled", false) && optInt2 > 0, optInt2);
        }
        return aVar.a();
    }
}
