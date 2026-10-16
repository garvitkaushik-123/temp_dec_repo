package com.mbridge.msdk.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.ironsource.Y1;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.c0;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.z0;
import io.bidmachine.iab.vast.tags.VastAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: BaseSetting.java */
/* loaded from: classes6.dex */
public class b {
    public static int c1 = 1500;
    private boolean D0;
    private long F;
    private JSONArray F0;
    private JSONObject G0;
    private ArrayList<Integer> H;
    private d I;
    private long I0;
    private C0384b J;
    private long N0;
    private HashMap<String, String> O;
    private boolean O0;
    private String P;
    private int U;
    private String U0;
    private String X;
    private Map<String, String> Y;
    private int a1;
    private String b1;
    private int h0;
    private String k0;
    private int l;
    private String l0;
    private List<com.mbridge.msdk.foundation.entity.a> n;
    private int o0;
    private long p;
    private int p0;
    private com.mbridge.msdk.setting.a q;
    private int q0;
    private String r;
    private int r0;
    private Map<String, a> s;
    private boolean t;
    private int u;
    private long u0;
    private long v0;

    /* renamed from: a, reason: collision with root package name */
    private boolean f4697a = false;
    private JSONArray b = new JSONArray();
    private JSONArray c = new JSONArray();
    private String d = "";
    private int e = 0;
    private int f = 0;
    private int g = 2;
    private int h = 0;
    private String i = "";
    private String j = "";
    private String k = "";
    private int m = 0;
    private int o = 0;
    private int v = 1;
    private boolean w = false;
    private String x = "";
    private String y = "";
    private String z = "";
    private String A = "";
    private String B = "";
    private int C = 120;
    private String D = com.mbridge.msdk.foundation.same.net.utils.d.h().i;
    private String E = com.mbridge.msdk.foundation.same.net.utils.d.h().m;
    private int G = c1;
    private int K = 0;
    private long L = 86400;
    private int M = 0;
    private int N = 3;
    private boolean Q = true;
    private int R = 0;
    private boolean S = false;
    private boolean T = false;
    private int V = 0;
    private int W = 0;
    private String Z = "1.0";
    private int a0 = 30;
    private int b0 = 9377;
    private int c0 = 0;
    private int d0 = 5;
    private int e0 = 1;
    private int f0 = 8000;
    private String g0 = "";
    private int i0 = 10;
    private int j0 = 120;
    private String m0 = "";
    private String n0 = "";
    private String s0 = "";
    private String t0 = "";
    private List<Integer> w0 = new ArrayList();
    private int x0 = 3;
    private int y0 = 0;
    private int z0 = 3;
    private int A0 = 0;
    private int B0 = 10;
    private int C0 = 600;
    private int E0 = 0;
    private String H0 = "";
    private int J0 = 8000;
    private int K0 = 1;
    private long L0 = 10;
    private int M0 = 3;
    private int P0 = 1;
    private int Q0 = 1;
    private int R0 = 1;
    private int S0 = 1;
    private String T0 = "";
    private int V0 = 1300;
    private int W0 = 0;
    private int X0 = 0;
    private long Y0 = 3600;
    private String Z0 = "";

    /* compiled from: BaseSetting.java */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private List<String> f4698a;
        private List<String> b;
        private List<String> c;
        private List<String> d;

        public List<String> a() {
            return this.f4698a;
        }

        public List<String> b() {
            return this.b;
        }

        public List<String> c() {
            return this.c;
        }

        public List<String> d() {
            return this.d;
        }

        public void a(JSONObject jSONObject) {
            try {
                JSONArray optJSONArray = jSONObject.optJSONArray(VastAttributes.HORIZONTAL_POSITION);
                if (optJSONArray != null) {
                    this.c = c0.a(optJSONArray);
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray(VastAttributes.VERTICAL_POSITION);
                if (optJSONArray2 != null) {
                    this.d = c0.a(optJSONArray2);
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("width");
                if (optJSONArray3 != null) {
                    this.b = c0.a(optJSONArray3);
                }
                JSONArray optJSONArray4 = jSONObject.optJSONArray("height");
                if (optJSONArray4 != null) {
                    this.f4698a = c0.a(optJSONArray4);
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String a(Context context, String str) {
        try {
            g d = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d != null && d.G() != null) {
                String host = Uri.parse(str).getHost();
                Iterator<Map.Entry<String, String>> it = d.G().entrySet().iterator();
                while (it.hasNext()) {
                    String key = it.next().getKey();
                    if (!TextUtils.isEmpty(host) && host.contains(key)) {
                        String str2 = d.G().get(key);
                        return TextUtils.isEmpty(str2) ? "" : str2.replace("{gaid}", com.mbridge.msdk.foundation.tools.f.d());
                    }
                }
                return "";
            }
            return "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public long A() {
        return this.L;
    }

    public boolean A0() {
        return this.Q;
    }

    public int B() {
        return this.N;
    }

    public boolean B0() {
        return this.t;
    }

    public HashMap<String, String> C() {
        return this.O;
    }

    public boolean C0() {
        return this.w;
    }

    public void D(int i) {
        this.a1 = i;
    }

    public boolean D0() {
        return this.S;
    }

    public int E() {
        return this.U;
    }

    public boolean E0() {
        return this.f4697a;
    }

    public int F() {
        return this.V;
    }

    public boolean F0() {
        return (TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.z) || TextUtils.isEmpty(this.A) || TextUtils.isEmpty(this.x)) ? false : true;
    }

    public Map<String, String> G() {
        return this.Y;
    }

    public boolean G0() {
        return (TextUtils.isEmpty(this.B) || TextUtils.isEmpty(this.z) || TextUtils.isEmpty(this.A) || TextUtils.isEmpty(this.y)) ? false : true;
    }

    public JSONArray H() {
        return this.b;
    }

    public boolean H0() {
        return this.T;
    }

    public JSONArray I() {
        return this.c;
    }

    public boolean I0() {
        return this.D0;
    }

    public String J() {
        return this.Z;
    }

    public boolean J0() {
        return this.O0;
    }

    public int K() {
        return this.e0;
    }

    public void K0() {
        String language = Locale.getDefault().getLanguage();
        if (!G0()) {
            if (TextUtils.isEmpty(language) || !language.equals("zh")) {
                this.B = "Confirm to close? ";
                this.z = "You will not be rewarded after closing the window";
                this.A = "Close it";
                this.y = "Continue";
            } else {
                this.B = "确认关闭？";
                this.z = "关闭后您将不会获得任何奖励噢~ ";
                this.A = "确认关闭";
                this.y = "继续观看";
            }
        }
        if (F0()) {
            return;
        }
        if (TextUtils.isEmpty(language) || !language.equals("zh")) {
            this.B = "Confirm to close? ";
            this.z = "You will not be rewarded after closing the window";
            this.A = "Close it";
            this.x = "Continue";
            return;
        }
        this.B = "确认关闭？";
        this.z = "关闭后您将不会获得任何奖励噢~ ";
        this.A = "确认关闭";
        this.x = "继续试玩";
    }

    public int L() {
        return this.f0;
    }

    public int M() {
        return this.h0;
    }

    public int N() {
        return this.j0;
    }

    public String O() {
        return this.k0;
    }

    public String P() {
        return this.l0;
    }

    public String Q() {
        return this.Z0;
    }

    public long R() {
        return this.Y0;
    }

    public int S() {
        return this.a1;
    }

    public String T() {
        return this.m0;
    }

    public String U() {
        return this.n0;
    }

    public int V() {
        return this.o0;
    }

    public int W() {
        return this.p0;
    }

    public int X() {
        return this.q0;
    }

    public int Y() {
        return this.r0;
    }

    public long Z() {
        return this.u0;
    }

    public long a0() {
        if (this.v0 <= 0) {
            this.v0 = 7200L;
        }
        return this.v0;
    }

    public void b(Map<String, String> map) {
        this.Y = map;
    }

    public int b0() {
        return this.x0;
    }

    public void c(int i) {
        this.e = i;
    }

    public int c0() {
        return this.y0;
    }

    public void d(long j) {
        this.Y0 = j;
    }

    public int d0() {
        return this.z0;
    }

    public void e(int i) {
        this.g = i;
    }

    public int e0() {
        return this.A0;
    }

    public void f(int i) {
        this.h = i;
    }

    public int f0() {
        return this.B0;
    }

    public void g(int i) {
        this.l = i;
    }

    public int g0() {
        return this.C0;
    }

    public void h(int i) {
        this.m = i;
    }

    public int h0() {
        return this.E0;
    }

    public void i(int i) {
        this.o = i;
    }

    public JSONArray i0() {
        return this.F0;
    }

    public com.mbridge.msdk.setting.a j() {
        return this.q;
    }

    public JSONObject j0() {
        return this.G0;
    }

    public String k() {
        return this.r;
    }

    public String k0() {
        return this.H0;
    }

    public Map<String, a> l() {
        return this.s;
    }

    public long l0() {
        return this.I0;
    }

    public int m() {
        return this.u;
    }

    public int m0() {
        return this.J0;
    }

    public int n() {
        return this.v;
    }

    public int n0() {
        return this.K0;
    }

    public String o() {
        return this.x;
    }

    public long o0() {
        return this.L0 * 1000;
    }

    public String p() {
        return this.y;
    }

    public int p0() {
        return this.M0;
    }

    public String q() {
        return this.z;
    }

    public long q0() {
        return this.N0;
    }

    public String r() {
        return this.A;
    }

    public int r0() {
        return this.P0;
    }

    public String s() {
        return this.B;
    }

    public int s0() {
        return this.Q0;
    }

    public void t(String str) {
        this.Z0 = str;
    }

    public int t0() {
        return this.R0;
    }

    public String toString() {
        return " cfc=" + this.u + " getpf=" + this.L + " rurl=" + this.D0;
    }

    public String u() {
        return this.D;
    }

    public int u0() {
        return this.S0;
    }

    public String v() {
        return this.E;
    }

    public String v0() {
        return this.T0;
    }

    public long w() {
        return this.F;
    }

    public String w0() {
        return this.U0;
    }

    public ArrayList<Integer> x() {
        return this.H;
    }

    public int x0() {
        return this.V0;
    }

    public d y() {
        return this.I;
    }

    public int y0() {
        return this.W0;
    }

    public C0384b z() {
        return this.J;
    }

    public int z0() {
        return this.X0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x04da A[Catch: Exception -> 0x053f, TryCatch #10 {Exception -> 0x053f, blocks: (B:101:0x04b8, B:103:0x04da, B:104:0x04dc, B:106:0x04e1, B:107:0x04e3, B:109:0x04e8, B:110:0x04ea, B:112:0x04ef, B:113:0x04f1, B:116:0x04fd), top: B:100:0x04b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x04e1 A[Catch: Exception -> 0x053f, TryCatch #10 {Exception -> 0x053f, blocks: (B:101:0x04b8, B:103:0x04da, B:104:0x04dc, B:106:0x04e1, B:107:0x04e3, B:109:0x04e8, B:110:0x04ea, B:112:0x04ef, B:113:0x04f1, B:116:0x04fd), top: B:100:0x04b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04e8 A[Catch: Exception -> 0x053f, TryCatch #10 {Exception -> 0x053f, blocks: (B:101:0x04b8, B:103:0x04da, B:104:0x04dc, B:106:0x04e1, B:107:0x04e3, B:109:0x04e8, B:110:0x04ea, B:112:0x04ef, B:113:0x04f1, B:116:0x04fd), top: B:100:0x04b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x04ef A[Catch: Exception -> 0x053f, TryCatch #10 {Exception -> 0x053f, blocks: (B:101:0x04b8, B:103:0x04da, B:104:0x04dc, B:106:0x04e1, B:107:0x04e3, B:109:0x04e8, B:110:0x04ea, B:112:0x04ef, B:113:0x04f1, B:116:0x04fd), top: B:100:0x04b8 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0562  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0593  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05af A[Catch: Exception -> 0x05d2, TryCatch #8 {Exception -> 0x05d2, blocks: (B:9:0x0016, B:12:0x006c, B:16:0x00c0, B:34:0x0175, B:35:0x0178, B:37:0x0286, B:38:0x02c2, B:41:0x02e0, B:43:0x02fd, B:45:0x0303, B:46:0x0309, B:48:0x030f, B:50:0x0315, B:52:0x031c, B:55:0x031f, B:57:0x0325, B:58:0x032f, B:60:0x0393, B:62:0x039b, B:65:0x03a2, B:67:0x03a8, B:68:0x03b0, B:70:0x03b6, B:73:0x03c2, B:76:0x03c8, B:90:0x0457, B:99:0x04a2, B:120:0x0548, B:126:0x056c, B:137:0x05a3, B:139:0x05af, B:140:0x05ba, B:142:0x05c6, B:148:0x05a0, B:149:0x0598, B:151:0x0588, B:154:0x0569, B:162:0x0499, B:189:0x038a, B:191:0x028c, B:193:0x0297, B:195:0x029d, B:196:0x02a3, B:198:0x02a9, B:200:0x02bf, B:211:0x00bb, B:212:0x0068, B:122:0x055a, B:125:0x0565, B:165:0x033b, B:166:0x034d, B:168:0x0353, B:171:0x035f, B:174:0x0369, B:177:0x0377, B:184:0x037f, B:186:0x0385, B:130:0x058b, B:133:0x0594, B:92:0x0472, B:95:0x0483, B:98:0x048e, B:136:0x059b, B:128:0x057e), top: B:8:0x0016, inners: #1, #2, #3, #4, #9, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x05c6 A[Catch: Exception -> 0x05d2, TRY_LEAVE, TryCatch #8 {Exception -> 0x05d2, blocks: (B:9:0x0016, B:12:0x006c, B:16:0x00c0, B:34:0x0175, B:35:0x0178, B:37:0x0286, B:38:0x02c2, B:41:0x02e0, B:43:0x02fd, B:45:0x0303, B:46:0x0309, B:48:0x030f, B:50:0x0315, B:52:0x031c, B:55:0x031f, B:57:0x0325, B:58:0x032f, B:60:0x0393, B:62:0x039b, B:65:0x03a2, B:67:0x03a8, B:68:0x03b0, B:70:0x03b6, B:73:0x03c2, B:76:0x03c8, B:90:0x0457, B:99:0x04a2, B:120:0x0548, B:126:0x056c, B:137:0x05a3, B:139:0x05af, B:140:0x05ba, B:142:0x05c6, B:148:0x05a0, B:149:0x0598, B:151:0x0588, B:154:0x0569, B:162:0x0499, B:189:0x038a, B:191:0x028c, B:193:0x0297, B:195:0x029d, B:196:0x02a3, B:198:0x02a9, B:200:0x02bf, B:211:0x00bb, B:212:0x0068, B:122:0x055a, B:125:0x0565, B:165:0x033b, B:166:0x034d, B:168:0x0353, B:171:0x035f, B:174:0x0369, B:177:0x0377, B:184:0x037f, B:186:0x0385, B:130:0x058b, B:133:0x0594, B:92:0x0472, B:95:0x0483, B:98:0x048e, B:136:0x059b, B:128:0x057e), top: B:8:0x0016, inners: #1, #2, #3, #4, #9, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:145:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0564  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x048d  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x033b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x028c A[Catch: Exception -> 0x05d2, TryCatch #8 {Exception -> 0x05d2, blocks: (B:9:0x0016, B:12:0x006c, B:16:0x00c0, B:34:0x0175, B:35:0x0178, B:37:0x0286, B:38:0x02c2, B:41:0x02e0, B:43:0x02fd, B:45:0x0303, B:46:0x0309, B:48:0x030f, B:50:0x0315, B:52:0x031c, B:55:0x031f, B:57:0x0325, B:58:0x032f, B:60:0x0393, B:62:0x039b, B:65:0x03a2, B:67:0x03a8, B:68:0x03b0, B:70:0x03b6, B:73:0x03c2, B:76:0x03c8, B:90:0x0457, B:99:0x04a2, B:120:0x0548, B:126:0x056c, B:137:0x05a3, B:139:0x05af, B:140:0x05ba, B:142:0x05c6, B:148:0x05a0, B:149:0x0598, B:151:0x0588, B:154:0x0569, B:162:0x0499, B:189:0x038a, B:191:0x028c, B:193:0x0297, B:195:0x029d, B:196:0x02a3, B:198:0x02a9, B:200:0x02bf, B:211:0x00bb, B:212:0x0068, B:122:0x055a, B:125:0x0565, B:165:0x033b, B:166:0x034d, B:168:0x0353, B:171:0x035f, B:174:0x0369, B:177:0x0377, B:184:0x037f, B:186:0x0385, B:130:0x058b, B:133:0x0594, B:92:0x0472, B:95:0x0483, B:98:0x048e, B:136:0x059b, B:128:0x057e), top: B:8:0x0016, inners: #1, #2, #3, #4, #9, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0286 A[Catch: Exception -> 0x05d2, TryCatch #8 {Exception -> 0x05d2, blocks: (B:9:0x0016, B:12:0x006c, B:16:0x00c0, B:34:0x0175, B:35:0x0178, B:37:0x0286, B:38:0x02c2, B:41:0x02e0, B:43:0x02fd, B:45:0x0303, B:46:0x0309, B:48:0x030f, B:50:0x0315, B:52:0x031c, B:55:0x031f, B:57:0x0325, B:58:0x032f, B:60:0x0393, B:62:0x039b, B:65:0x03a2, B:67:0x03a8, B:68:0x03b0, B:70:0x03b6, B:73:0x03c2, B:76:0x03c8, B:90:0x0457, B:99:0x04a2, B:120:0x0548, B:126:0x056c, B:137:0x05a3, B:139:0x05af, B:140:0x05ba, B:142:0x05c6, B:148:0x05a0, B:149:0x0598, B:151:0x0588, B:154:0x0569, B:162:0x0499, B:189:0x038a, B:191:0x028c, B:193:0x0297, B:195:0x029d, B:196:0x02a3, B:198:0x02a9, B:200:0x02bf, B:211:0x00bb, B:212:0x0068, B:122:0x055a, B:125:0x0565, B:165:0x033b, B:166:0x034d, B:168:0x0353, B:171:0x035f, B:174:0x0369, B:177:0x0377, B:184:0x037f, B:186:0x0385, B:130:0x058b, B:133:0x0594, B:92:0x0472, B:95:0x0483, B:98:0x048e, B:136:0x059b, B:128:0x057e), top: B:8:0x0016, inners: #1, #2, #3, #4, #9, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x030f A[Catch: Exception -> 0x05d2, TryCatch #8 {Exception -> 0x05d2, blocks: (B:9:0x0016, B:12:0x006c, B:16:0x00c0, B:34:0x0175, B:35:0x0178, B:37:0x0286, B:38:0x02c2, B:41:0x02e0, B:43:0x02fd, B:45:0x0303, B:46:0x0309, B:48:0x030f, B:50:0x0315, B:52:0x031c, B:55:0x031f, B:57:0x0325, B:58:0x032f, B:60:0x0393, B:62:0x039b, B:65:0x03a2, B:67:0x03a8, B:68:0x03b0, B:70:0x03b6, B:73:0x03c2, B:76:0x03c8, B:90:0x0457, B:99:0x04a2, B:120:0x0548, B:126:0x056c, B:137:0x05a3, B:139:0x05af, B:140:0x05ba, B:142:0x05c6, B:148:0x05a0, B:149:0x0598, B:151:0x0588, B:154:0x0569, B:162:0x0499, B:189:0x038a, B:191:0x028c, B:193:0x0297, B:195:0x029d, B:196:0x02a3, B:198:0x02a9, B:200:0x02bf, B:211:0x00bb, B:212:0x0068, B:122:0x055a, B:125:0x0565, B:165:0x033b, B:166:0x034d, B:168:0x0353, B:171:0x035f, B:174:0x0369, B:177:0x0377, B:184:0x037f, B:186:0x0385, B:130:0x058b, B:133:0x0594, B:92:0x0472, B:95:0x0483, B:98:0x048e, B:136:0x059b, B:128:0x057e), top: B:8:0x0016, inners: #1, #2, #3, #4, #9, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0325 A[Catch: Exception -> 0x05d2, TryCatch #8 {Exception -> 0x05d2, blocks: (B:9:0x0016, B:12:0x006c, B:16:0x00c0, B:34:0x0175, B:35:0x0178, B:37:0x0286, B:38:0x02c2, B:41:0x02e0, B:43:0x02fd, B:45:0x0303, B:46:0x0309, B:48:0x030f, B:50:0x0315, B:52:0x031c, B:55:0x031f, B:57:0x0325, B:58:0x032f, B:60:0x0393, B:62:0x039b, B:65:0x03a2, B:67:0x03a8, B:68:0x03b0, B:70:0x03b6, B:73:0x03c2, B:76:0x03c8, B:90:0x0457, B:99:0x04a2, B:120:0x0548, B:126:0x056c, B:137:0x05a3, B:139:0x05af, B:140:0x05ba, B:142:0x05c6, B:148:0x05a0, B:149:0x0598, B:151:0x0588, B:154:0x0569, B:162:0x0499, B:189:0x038a, B:191:0x028c, B:193:0x0297, B:195:0x029d, B:196:0x02a3, B:198:0x02a9, B:200:0x02bf, B:211:0x00bb, B:212:0x0068, B:122:0x055a, B:125:0x0565, B:165:0x033b, B:166:0x034d, B:168:0x0353, B:171:0x035f, B:174:0x0369, B:177:0x0377, B:184:0x037f, B:186:0x0385, B:130:0x058b, B:133:0x0594, B:92:0x0472, B:95:0x0483, B:98:0x048e, B:136:0x059b, B:128:0x057e), top: B:8:0x0016, inners: #1, #2, #3, #4, #9, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03a8 A[Catch: Exception -> 0x05d2, TryCatch #8 {Exception -> 0x05d2, blocks: (B:9:0x0016, B:12:0x006c, B:16:0x00c0, B:34:0x0175, B:35:0x0178, B:37:0x0286, B:38:0x02c2, B:41:0x02e0, B:43:0x02fd, B:45:0x0303, B:46:0x0309, B:48:0x030f, B:50:0x0315, B:52:0x031c, B:55:0x031f, B:57:0x0325, B:58:0x032f, B:60:0x0393, B:62:0x039b, B:65:0x03a2, B:67:0x03a8, B:68:0x03b0, B:70:0x03b6, B:73:0x03c2, B:76:0x03c8, B:90:0x0457, B:99:0x04a2, B:120:0x0548, B:126:0x056c, B:137:0x05a3, B:139:0x05af, B:140:0x05ba, B:142:0x05c6, B:148:0x05a0, B:149:0x0598, B:151:0x0588, B:154:0x0569, B:162:0x0499, B:189:0x038a, B:191:0x028c, B:193:0x0297, B:195:0x029d, B:196:0x02a3, B:198:0x02a9, B:200:0x02bf, B:211:0x00bb, B:212:0x0068, B:122:0x055a, B:125:0x0565, B:165:0x033b, B:166:0x034d, B:168:0x0353, B:171:0x035f, B:174:0x0369, B:177:0x0377, B:184:0x037f, B:186:0x0385, B:130:0x058b, B:133:0x0594, B:92:0x0472, B:95:0x0483, B:98:0x048e, B:136:0x059b, B:128:0x057e), top: B:8:0x0016, inners: #1, #2, #3, #4, #9, #11 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x048b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static g b(JSONObject jSONObject) {
        g gVar;
        int i;
        long optLong;
        int optInt;
        JSONArray optJSONArray;
        String optString;
        JSONArray optJSONArray2;
        String optString2;
        String optString3;
        int optInt2;
        int optInt3;
        int optInt4;
        int optInt5;
        int optInt6;
        int parseInt;
        int i2;
        ArrayList arrayList;
        int i3;
        ArrayList arrayList2 = null;
        if (jSONObject == null) {
            return null;
        }
        try {
            gVar = new g();
        } catch (Exception e) {
            e = e;
        }
        try {
            gVar.c(jSONObject);
            gVar.f(jSONObject.optString("cc"));
            gVar.s(jSONObject.optString("mv_wildcard", "<mvpackage>mbridge</mvpackage>"));
            gVar.j(jSONObject.optInt("cfc"));
            gVar.c(jSONObject.optLong("getpf"));
            gVar.b(jSONObject.optLong("current_time"));
            gVar.b(jSONObject.optBoolean("cfb"));
            gVar.a(jSONObject.optLong("awct"));
            gVar.e(jSONObject.optLong(CampaignEx.JSON_KEY_PLCT) == 0 ? 3600L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCT));
            gVar.g(jSONObject.optBoolean("rurl"));
            gVar.i(jSONObject.optLong("uct"));
            gVar.h(jSONObject.optBoolean("ujds"));
            gVar.G(jSONObject.optInt("n2"));
            gVar.H(jSONObject.optInt("n3"));
            gVar.r(jSONObject.optInt("is_startup_crashsystem", 1));
            gVar.F(jSONObject.optInt("pcrn"));
            gVar.f(jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB) == 0 ? 7200L : jSONObject.optLong(CampaignEx.JSON_KEY_PLCTB));
            gVar.F(jSONObject.optInt("pcrn", 100));
            gVar.E(jSONObject.optInt("opent", 1));
            gVar.g(jSONObject.optLong("sfct", 1800L));
            gVar.U(jSONObject.optInt("upgd", 1));
            gVar.V(jSONObject.optInt("upsrl", 1));
            gVar.T(jSONObject.optInt("updevid", 1));
            gVar.O(jSONObject.optInt("sc", 0));
            gVar.S(jSONObject.optInt("up_tips", 1));
            int i4 = -1;
            gVar.s(jSONObject.optInt("iseu", -1));
            gVar.p(jSONObject.optString("jm_unit"));
            try {
                JSONArray optJSONArray3 = jSONObject.optJSONArray("atf");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    arrayList2 = new ArrayList();
                    int i5 = 0;
                    while (i5 < optJSONArray3.length()) {
                        String optString4 = optJSONArray3.optString(i5);
                        if (z0.b(optString4)) {
                            JSONObject jSONObject2 = new JSONObject(optString4);
                            i = i4;
                            try {
                                arrayList2.add(new com.mbridge.msdk.foundation.entity.a(jSONObject2.optInt("adtype"), jSONObject2.optString("unitid")));
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                gVar.g(jSONObject.optInt("adct", 259200));
                                gVar.k(jSONObject.optString("confirm_title", ""));
                                gVar.i(jSONObject.optString("confirm_description", ""));
                                gVar.j(jSONObject.optString("confirm_t", ""));
                                gVar.h(jSONObject.optString("confirm_c_rv", ""));
                                gVar.g(jSONObject.optString("confirm_c_play", ""));
                                gVar.c(jSONObject.optString("adchoice_icon", ""));
                                gVar.d(jSONObject.optString("adchoice_link", ""));
                                gVar.e(jSONObject.optString("adchoice_size", ""));
                                gVar.w(jSONObject.optString("platform_logo", ""));
                                gVar.x(jSONObject.optString("platform_name", ""));
                                gVar.a(a(jSONObject.optString("cdnate_cfg", "")));
                                gVar.i(jSONObject.optInt("atrqt", 0));
                                gVar.t(jSONObject.optInt("iupdid", 0));
                                gVar.C(jSONObject.optInt("mcs", 120));
                                gVar.b(jSONObject.optString("ab_id", ""));
                                gVar.y(jSONObject.optString("rid", ""));
                                gVar.q(jSONObject.optString("log_rate", Y1.f));
                                gVar.v(jSONObject.optString("omsdkjs_url", ""));
                                gVar.u(jSONObject.optString("omsdkjs_h5_url", ""));
                                gVar.J(jSONObject.optInt("rty_tk_clk", 0));
                                gVar.L(jSONObject.optInt("rty_tk_imp", 0));
                                gVar.K(jSONObject.optInt("rty_cnt", 3));
                                gVar.N(jSONObject.optInt("rty_to", 600));
                                gVar.M(jSONObject.optInt("rty_inr", 10));
                                gVar.n(jSONObject.optString("dns"));
                                gVar.v(jSONObject.optString("omsdkjs_url", ""));
                                gVar.u(jSONObject.optString("omsdkjs_h5_url", ""));
                                optLong = jSONObject.optLong("tcto");
                                if (optLong != 0) {
                                }
                                gVar.r(jSONObject.optString("mraid_js"));
                                gVar.B(jSONObject.optString("web_env_url"));
                                optInt = jSONObject.optInt("alrbs", 0);
                                if (optInt <= 2) {
                                }
                                optInt = 0;
                                gVar.h(optInt);
                                gVar.e(jSONObject.optBoolean("GDPR_area", false));
                                gVar.l(jSONObject.optInt("ct", 120));
                                optJSONArray = jSONObject.optJSONArray("ercd");
                                if (optJSONArray != null) {
                                    arrayList = new ArrayList();
                                    while (i3 < optJSONArray.length()) {
                                    }
                                    if (arrayList.size() > 0) {
                                    }
                                }
                                optString = jSONObject.optString("hst");
                                if (!TextUtils.isEmpty(optString)) {
                                }
                                optJSONArray2 = jSONObject.optJSONArray("refactor_switch");
                                if (optJSONArray2 != null) {
                                    while (i2 < optJSONArray2.length()) {
                                    }
                                }
                                int optInt7 = jSONObject.optInt("lqcnt", 30);
                                int optInt8 = jSONObject.optInt("lqto", 5);
                                int optInt9 = jSONObject.optInt("lqswt", 0);
                                int optInt10 = jSONObject.optInt("lqtype", 1);
                                gVar.x(optInt8);
                                gVar.u(optInt7);
                                gVar.w(optInt9);
                                gVar.y(optInt10);
                                gVar.a(jSONObject.optJSONArray("lg_bl"));
                                gVar.b(jSONObject.optJSONArray("lg_wl"));
                                gVar.X(jSONObject.optInt("lg_wl_rt"));
                                gVar.P(jSONObject.optInt("srml", 8000));
                                gVar.z(jSONObject.optInt("lrml", 8000));
                                gVar.W(jSONObject.optInt("wgl_d_ms", 1300));
                                gVar.m(jSONObject.optInt("dp_ct", c1));
                                parseInt = Integer.parseInt(j0.a(jSONObject.optString("lqpt")));
                                if (parseInt > 0) {
                                    gVar.v(parseInt);
                                }
                                gVar.Y(jSONObject.optInt("wvddt", 0));
                                gVar.l(jSONObject.optString("hst_st", ""));
                                gVar.m(jSONObject.optString("hst_st_t", ""));
                                int optInt11 = jSONObject.optInt("l", 3);
                                if (jSONObject.optInt(CampaignEx.JSON_KEY_AD_K, 0) != 1) {
                                }
                                if (jSONObject.optInt("m", 1) != 1) {
                                }
                                gVar.I(optInt11);
                                gVar.f(r2);
                                gVar.a(r3);
                                gVar.n(jSONObject.optInt("fbk_swt", 0));
                                gVar.a(C0384b.a(jSONObject.optJSONObject("fbk")));
                                optInt2 = jSONObject.optInt("ad_connection_timeout", com.mbridge.msdk.foundation.same.a.o);
                                optInt3 = jSONObject.optInt("ad_read_timeout", com.mbridge.msdk.foundation.same.a.q);
                                optInt4 = jSONObject.optInt("ad_write_timeout", com.mbridge.msdk.foundation.same.a.s);
                                optInt5 = jSONObject.optInt("ad_retry_count", com.mbridge.msdk.foundation.same.a.r);
                                if (optInt2 <= 0) {
                                }
                                gVar.c(optInt2);
                                if (optInt3 <= 0) {
                                }
                                gVar.d(optInt3);
                                if (optInt4 <= 0) {
                                }
                                gVar.f(optInt4);
                                if (optInt5 < 0) {
                                }
                                gVar.e(optInt5);
                                optInt6 = jSONObject.optInt("max_download_task_size", 10);
                                if (optInt6 <= 0) {
                                }
                                gVar.B(optInt6);
                                gVar.A(jSONObject.optInt("max_bitmap_cache_size", 10));
                                gVar.R(jSONObject.optInt("t_t", 3));
                                gVar.p(jSONObject.optInt("h_t", 3));
                                gVar.o(jSONObject.optInt("gtp"));
                                gVar.d(jSONObject.optLong("i_i_t", 3600L));
                                gVar.t(jSONObject.optString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I, ""));
                                gVar.D(jSONObject.optInt("n_c_u_p", 0));
                                gVar.o(jSONObject.optString("http_track_url", ""));
                                gVar.Q(jSONObject.optInt("st_net", 1));
                                gVar.A(jSONObject.optString("vtag", ""));
                                gVar.c(jSONObject.optInt("check_webview", 0) == 0);
                                gVar.z(jSONObject.optString("swxid"));
                                gVar.c(jSONObject.optJSONArray("sdk_filters"));
                                gVar.k(jSONObject.optInt("ch_nv_im_cb", 1));
                                gVar.d(jSONObject.optInt("do_us_fi_re", 1) != 0);
                                a(jSONObject);
                                optString2 = jSONObject.optString("bcp");
                                if (!TextUtils.isEmpty(optString2)) {
                                }
                                optString3 = jSONObject.optString("monitor");
                                if (!TextUtils.isEmpty(optString3)) {
                                }
                            }
                        } else {
                            i = i4;
                        }
                        i5++;
                        i4 = i;
                    }
                }
                i = i4;
                if (arrayList2 != null) {
                    gVar.a((List<com.mbridge.msdk.foundation.entity.a>) arrayList2);
                }
            } catch (Exception e3) {
                e = e3;
                i = i4;
            }
            gVar.g(jSONObject.optInt("adct", 259200));
            gVar.k(jSONObject.optString("confirm_title", ""));
            gVar.i(jSONObject.optString("confirm_description", ""));
            gVar.j(jSONObject.optString("confirm_t", ""));
            gVar.h(jSONObject.optString("confirm_c_rv", ""));
            gVar.g(jSONObject.optString("confirm_c_play", ""));
            gVar.c(jSONObject.optString("adchoice_icon", ""));
            gVar.d(jSONObject.optString("adchoice_link", ""));
            gVar.e(jSONObject.optString("adchoice_size", ""));
            gVar.w(jSONObject.optString("platform_logo", ""));
            gVar.x(jSONObject.optString("platform_name", ""));
            gVar.a(a(jSONObject.optString("cdnate_cfg", "")));
            gVar.i(jSONObject.optInt("atrqt", 0));
            gVar.t(jSONObject.optInt("iupdid", 0));
            gVar.C(jSONObject.optInt("mcs", 120));
            gVar.b(jSONObject.optString("ab_id", ""));
            gVar.y(jSONObject.optString("rid", ""));
            gVar.q(jSONObject.optString("log_rate", Y1.f));
            gVar.v(jSONObject.optString("omsdkjs_url", ""));
            gVar.u(jSONObject.optString("omsdkjs_h5_url", ""));
            gVar.J(jSONObject.optInt("rty_tk_clk", 0));
            gVar.L(jSONObject.optInt("rty_tk_imp", 0));
            gVar.K(jSONObject.optInt("rty_cnt", 3));
            gVar.N(jSONObject.optInt("rty_to", 600));
            gVar.M(jSONObject.optInt("rty_inr", 10));
            gVar.n(jSONObject.optString("dns"));
            gVar.v(jSONObject.optString("omsdkjs_url", ""));
            gVar.u(jSONObject.optString("omsdkjs_h5_url", ""));
            optLong = jSONObject.optLong("tcto");
            if (optLong != 0) {
                gVar.h(10L);
            } else {
                gVar.h(optLong);
                JSONArray optJSONArray4 = jSONObject.optJSONArray("jt");
                if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                    HashMap hashMap = new HashMap();
                    for (int i6 = 0; i6 < optJSONArray4.length(); i6++) {
                        JSONObject optJSONObject = optJSONArray4.optJSONObject(i6);
                        hashMap.put(optJSONObject.optString(C3040d4.i.D), optJSONObject.optString("format"));
                    }
                    gVar.b(hashMap);
                }
            }
            gVar.r(jSONObject.optString("mraid_js"));
            gVar.B(jSONObject.optString("web_env_url"));
            optInt = jSONObject.optInt("alrbs", 0);
            if (optInt <= 2 || optInt < 0) {
                optInt = 0;
            }
            gVar.h(optInt);
            gVar.e(jSONObject.optBoolean("GDPR_area", false));
            gVar.l(jSONObject.optInt("ct", 120));
            optJSONArray = jSONObject.optJSONArray("ercd");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                arrayList = new ArrayList();
                for (i3 = 0; i3 < optJSONArray.length(); i3++) {
                    int optInt12 = optJSONArray.optInt(i3);
                    if (optInt12 != 0) {
                        arrayList.add(Integer.valueOf(optInt12));
                    }
                }
                if (arrayList.size() > 0) {
                    arrayList.add(Integer.valueOf(i));
                    gVar.a((ArrayList<Integer>) arrayList);
                }
            }
            optString = jSONObject.optString("hst");
            if (!TextUtils.isEmpty(optString)) {
                try {
                    JSONObject jSONObject3 = new JSONObject(j0.a(optString));
                    Iterator<String> keys = jSONObject3.keys();
                    HashMap hashMap2 = new HashMap();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(jSONObject3.optString(next)) && !TextUtils.isEmpty(j0.a(jSONObject3.optString(next)))) {
                            hashMap2.put(next, jSONObject3.optString(next));
                        }
                    }
                    if (hashMap2.size() > 0) {
                        gVar.a((HashMap<String, String>) hashMap2);
                    }
                } catch (Exception e4) {
                    p0.b("SETTING", e4.getMessage());
                }
            }
            optJSONArray2 = jSONObject.optJSONArray("refactor_switch");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                for (i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    JSONObject jSONObject4 = optJSONArray2.getJSONObject(i2);
                    Iterator<String> keys2 = jSONObject4.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        if (!TextUtils.isEmpty(next2) && jSONObject4.getBoolean(next2)) {
                            gVar.a(Integer.parseInt(next2));
                        }
                    }
                }
            }
            try {
                int optInt72 = jSONObject.optInt("lqcnt", 30);
                int optInt82 = jSONObject.optInt("lqto", 5);
                int optInt92 = jSONObject.optInt("lqswt", 0);
                int optInt102 = jSONObject.optInt("lqtype", 1);
                gVar.x(optInt82);
                gVar.u(optInt72);
                gVar.w(optInt92);
                gVar.y(optInt102);
                gVar.a(jSONObject.optJSONArray("lg_bl"));
                gVar.b(jSONObject.optJSONArray("lg_wl"));
                gVar.X(jSONObject.optInt("lg_wl_rt"));
                gVar.P(jSONObject.optInt("srml", 8000));
                gVar.z(jSONObject.optInt("lrml", 8000));
                gVar.W(jSONObject.optInt("wgl_d_ms", 1300));
                gVar.m(jSONObject.optInt("dp_ct", c1));
                parseInt = Integer.parseInt(j0.a(jSONObject.optString("lqpt")));
                if (parseInt > 0 && parseInt < 65535) {
                    gVar.v(parseInt);
                }
            } catch (Exception unused) {
            }
            gVar.Y(jSONObject.optInt("wvddt", 0));
            gVar.l(jSONObject.optString("hst_st", ""));
            gVar.m(jSONObject.optString("hst_st_t", ""));
            try {
                int optInt112 = jSONObject.optInt("l", 3);
                boolean z = jSONObject.optInt(CampaignEx.JSON_KEY_AD_K, 0) != 1;
                boolean z2 = jSONObject.optInt("m", 1) != 1;
                gVar.I(optInt112);
                gVar.f(z);
                gVar.a(z2);
            } catch (Exception e5) {
                p0.b("Setting", e5.getMessage());
            }
            gVar.n(jSONObject.optInt("fbk_swt", 0));
            gVar.a(C0384b.a(jSONObject.optJSONObject("fbk")));
            try {
                optInt2 = jSONObject.optInt("ad_connection_timeout", com.mbridge.msdk.foundation.same.a.o);
                optInt3 = jSONObject.optInt("ad_read_timeout", com.mbridge.msdk.foundation.same.a.q);
                optInt4 = jSONObject.optInt("ad_write_timeout", com.mbridge.msdk.foundation.same.a.s);
                optInt5 = jSONObject.optInt("ad_retry_count", com.mbridge.msdk.foundation.same.a.r);
                if (optInt2 <= 0) {
                    optInt2 = com.mbridge.msdk.foundation.same.a.o;
                }
                gVar.c(optInt2);
                if (optInt3 <= 0) {
                    optInt3 = com.mbridge.msdk.foundation.same.a.q;
                }
                gVar.d(optInt3);
                if (optInt4 <= 0) {
                    optInt4 = com.mbridge.msdk.foundation.same.a.s;
                }
                gVar.f(optInt4);
                if (optInt5 < 0) {
                    optInt5 = com.mbridge.msdk.foundation.same.a.r;
                }
                gVar.e(optInt5);
                optInt6 = jSONObject.optInt("max_download_task_size", 10);
                if (optInt6 <= 0) {
                    optInt6 = 10;
                }
                gVar.B(optInt6);
                gVar.A(jSONObject.optInt("max_bitmap_cache_size", 10));
                gVar.R(jSONObject.optInt("t_t", 3));
                gVar.p(jSONObject.optInt("h_t", 3));
                gVar.o(jSONObject.optInt("gtp"));
                gVar.d(jSONObject.optLong("i_i_t", 3600L));
                gVar.t(jSONObject.optString(com.mbridge.msdk.foundation.entity.b.JSON_KEY_C_I, ""));
                gVar.D(jSONObject.optInt("n_c_u_p", 0));
            } catch (Exception unused2) {
            }
            try {
                gVar.o(jSONObject.optString("http_track_url", ""));
            } catch (Exception unused3) {
            }
            gVar.Q(jSONObject.optInt("st_net", 1));
            gVar.A(jSONObject.optString("vtag", ""));
            try {
                gVar.c(jSONObject.optInt("check_webview", 0) == 0);
            } catch (Exception unused4) {
                gVar.c(false);
            }
            gVar.z(jSONObject.optString("swxid"));
            gVar.c(jSONObject.optJSONArray("sdk_filters"));
            try {
                gVar.k(jSONObject.optInt("ch_nv_im_cb", 1));
            } catch (Exception unused5) {
                gVar.k(1);
            }
            try {
                gVar.d(jSONObject.optInt("do_us_fi_re", 1) != 0);
            } catch (Exception unused6) {
                gVar.d(true);
            }
            try {
                a(jSONObject);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            optString2 = jSONObject.optString("bcp");
            if (!TextUtils.isEmpty(optString2)) {
                gVar.a(com.mbridge.msdk.setting.a.a(j0.a(optString2)));
            }
            optString3 = jSONObject.optString("monitor");
            if (!TextUtils.isEmpty(optString3)) {
                return gVar;
            }
            gVar.a(d.a(j0.a(optString3)));
            return gVar;
        } catch (Exception e7) {
            e = e7;
            arrayList2 = gVar;
            e.printStackTrace();
            return arrayList2;
        }
    }

    public void A(int i) {
        if (i > 0) {
            this.i0 = i;
        }
    }

    public void B(int i) {
        this.h0 = i;
    }

    public void C(int i) {
        this.j0 = i;
    }

    public int D() {
        return this.R;
    }

    public void E(int i) {
        this.o0 = i;
    }

    public void F(int i) {
        this.p0 = i;
    }

    public void G(int i) {
        this.q0 = i;
    }

    public void H(int i) {
        this.r0 = i;
    }

    public void I(int i) {
        this.x0 = i;
    }

    public void J(int i) {
        this.y0 = i;
    }

    public void K(int i) {
        this.z0 = i;
    }

    public void L(int i) {
        this.A0 = i;
    }

    public void M(int i) {
        this.B0 = i;
    }

    public void N(int i) {
        this.C0 = i;
    }

    public void O(int i) {
        this.E0 = i;
    }

    public void P(int i) {
        this.J0 = i;
    }

    public void Q(int i) {
        this.K0 = i;
    }

    public void R(int i) {
        this.M0 = i;
    }

    public void S(int i) {
        this.P0 = i;
    }

    public void T(int i) {
        this.Q0 = i;
    }

    public void U(int i) {
        this.R0 = i;
    }

    public void V(int i) {
        this.S0 = i;
    }

    public void W(int i) {
        this.V0 = i;
    }

    public void X(int i) {
        this.W0 = i;
    }

    public void Y(int i) {
        this.X0 = i;
    }

    public void c(String str) {
        this.i = str;
    }

    public void d(int i) {
        this.f = i;
    }

    public void e(String str) {
        this.k = str;
    }

    public int f() {
        return this.m;
    }

    public List<com.mbridge.msdk.foundation.entity.a> g() {
        return this.n;
    }

    public int h() {
        return this.o;
    }

    public long i() {
        return this.p;
    }

    public void j(int i) {
        this.u = i;
    }

    public void k(int i) {
        this.v = i;
    }

    public void l(int i) {
        this.C = i;
    }

    public void m(String str) {
        this.E = str;
    }

    public void n(int i) {
        this.K = i;
    }

    public void o(int i) {
        this.M = i;
        com.mbridge.msdk.foundation.same.net.utils.d.h().d(i);
    }

    public void p(int i) {
        this.N = i;
    }

    public void q(int i) {
        this.R = i;
    }

    public void r(int i) {
        this.U = i;
    }

    public void s(int i) {
        this.V = i;
    }

    public int t() {
        return this.C;
    }

    public void u(int i) {
        this.a0 = i;
    }

    public void v(int i) {
        this.b0 = i;
        com.mbridge.msdk.foundation.same.net.utils.d.h().b(i);
        com.mbridge.msdk.foundation.same.net.utils.d.h().c(i);
    }

    public void w(int i) {
        this.c0 = i;
    }

    public void x(int i) {
        this.d0 = i;
    }

    public void y(int i) {
        this.e0 = i;
    }

    public void z(int i) {
        this.f0 = i;
    }

    public void A(String str) {
        this.T0 = str;
    }

    public void B(String str) {
        this.U0 = str;
    }

    public String c() {
        return this.j;
    }

    public void d(String str) {
        this.j = str;
    }

    public int e() {
        return this.l;
    }

    public void f(String str) {
        this.r = str;
    }

    public void g(String str) {
        this.x = str;
    }

    public void h(String str) {
        this.y = str;
    }

    public void i(String str) {
        this.z = str;
    }

    public void j(String str) {
        this.A = str;
    }

    public void k(String str) {
        this.B = str;
    }

    public void l(String str) {
        this.D = str;
    }

    public void m(int i) {
        this.G = i;
        com.mbridge.msdk.click.utils.a.d = i;
    }

    public void n(String str) {
        this.b1 = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        e.a().b(j0.a(str));
    }

    public void p(String str) {
        this.X = str;
    }

    public void q(String str) {
        this.Z = str;
    }

    public void r(String str) {
        this.k0 = str;
    }

    public void s(String str) {
        this.l0 = str;
    }

    public void t(int i) {
        this.W = i;
    }

    public void u(String str) {
        this.m0 = str;
    }

    public void w(String str) {
        this.s0 = str;
    }

    public void x(String str) {
        this.t0 = str;
    }

    public void y(String str) {
        this.H0 = str;
    }

    public void z(String str) {
        if (TextUtils.isEmpty(this.g0)) {
            return;
        }
        this.g0 = str;
        if (TextUtils.isEmpty(com.mbridge.msdk.foundation.controller.c.m().i())) {
            com.mbridge.msdk.foundation.controller.c.m().d(this.g0);
        }
    }

    public void c(long j) {
        this.L = j;
    }

    public String d() {
        return this.k;
    }

    public void e(long j) {
        this.u0 = j;
    }

    public void f(long j) {
        this.v0 = j;
    }

    public void g(long j) {
        this.I0 = j;
    }

    public void h(long j) {
        this.L0 = j;
    }

    public void i(long j) {
        this.N0 = j;
    }

    public void o(String str) {
        this.P = str;
    }

    public void c(JSONArray jSONArray) {
        this.F0 = jSONArray;
    }

    public void d(boolean z) {
        this.S = z;
    }

    public void e(boolean z) {
        this.f4697a = z;
    }

    public void f(boolean z) {
        this.T = z;
    }

    public void g(boolean z) {
        this.D0 = z;
    }

    public void h(boolean z) {
        this.O0 = z;
    }

    public void v(String str) {
        this.n0 = str;
    }

    public void c(JSONObject jSONObject) {
        this.G0 = jSONObject;
    }

    public void c(boolean z) {
        this.w = z;
    }

    /* compiled from: BaseSetting.java */
    /* renamed from: com.mbridge.msdk.setting.b$b, reason: collision with other inner class name */
    public static class C0384b {

        /* renamed from: a, reason: collision with root package name */
        private String f4699a;
        private JSONArray b;
        private String c;
        private String d;
        private String e;
        private String f;

        public static C0384b a(JSONObject jSONObject) {
            if (jSONObject == null) {
                jSONObject = new JSONObject();
            }
            C0384b c0384b = new C0384b();
            Context d = com.mbridge.msdk.foundation.controller.c.m().d();
            c0384b.f = jSONObject.optString("title", d.getString(h0.a(d, "mbridge_cm_feedback_dialog_title", "string")));
            c0384b.f4699a = jSONObject.optString("cancel", d.getString(h0.a(d, "mbridge_cm_feedback_dialog_close_close", "string")));
            c0384b.d = jSONObject.optString("submit", d.getString(h0.a(d, "mbridge_cm_feedback_dialog_close_submit", "string")));
            c0384b.e = jSONObject.optString("submit_notice", d.getString(h0.a(d, "mbridge_cm_feedback_dialog_submit_notice", "string")));
            c0384b.c = jSONObject.optString("privacy", d.getString(h0.a(d, "mbridge_cm_feedback_dialog_privacy_des", "string")));
            JSONArray optJSONArray = jSONObject.optJSONArray("content");
            c0384b.b = optJSONArray;
            if (optJSONArray == null) {
                JSONArray jSONArray = new JSONArray();
                c0384b.b = jSONArray;
                jSONArray.put(d.getString(h0.a(d, "mbridge_cm_feedback_dialog_content_not_play", "string")));
                c0384b.b.put(d.getString(h0.a(d, "mbridge_cm_feedback_dialog_content_sound_problems", "string")));
                c0384b.b.put(d.getString(h0.a(d, "mbridge_cm_feedback_dialog_content_misleading", "string")));
                c0384b.b.put(d.getString(h0.a(d, "mbridge_cm_feedback_dialog_content_fraud", "string")));
                c0384b.b.put(d.getString(h0.a(d, "mbridge_cm_feedback_dialog_content_por_violence", "string")));
                c0384b.b.put(d.getString(h0.a(d, "mbridge_cm_feedback_dialog_content_other", "string")));
            }
            return c0384b;
        }

        public JSONArray b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public String d() {
            return this.d;
        }

        public String e() {
            return this.e;
        }

        public String f() {
            return this.f;
        }

        public String a() {
            return this.f4699a;
        }
    }

    public static Map<String, a> a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a aVar = new a();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    aVar.a(optJSONObject);
                }
                hashMap.put(next, aVar);
            }
            return hashMap;
        } catch (JSONException e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
            return null;
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            return null;
        }
    }

    public void a(int i) {
        this.w0.add(Integer.valueOf(i));
    }

    private static void a(JSONObject jSONObject) {
        FastKV fastKV = null;
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            try {
                fastKV = new FastKV.Builder(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), j0.a("H+tU+FeXHM==")).build();
            } catch (Exception unused) {
            }
        }
        if (fastKV != null) {
            try {
                Context d = com.mbridge.msdk.foundation.controller.c.m().d();
                if (jSONObject == null || d == null) {
                    return;
                }
                String optString = jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                if (!TextUtils.isEmpty(optString) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.V, optString)) {
                    com.mbridge.msdk.foundation.same.a.V = optString;
                    com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                    try {
                        fastKV.putString(j0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    } catch (Exception unused2) {
                    }
                }
                String optString2 = jSONObject.optString("c");
                if (TextUtils.isEmpty(optString2) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.g, optString2)) {
                    return;
                }
                com.mbridge.msdk.foundation.same.a.g = optString2;
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c", com.mbridge.msdk.foundation.same.a.g);
                try {
                    fastKV.putString(j0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                    return;
                } catch (Exception unused3) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            Context d2 = com.mbridge.msdk.foundation.controller.c.m().d();
            if (jSONObject == null || d2 == null) {
                return;
            }
            String optString3 = jSONObject.optString(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
            if (!TextUtils.isEmpty(optString3) && !TextUtils.equals(com.mbridge.msdk.foundation.same.a.V, optString3)) {
                com.mbridge.msdk.foundation.same.a.V = optString3;
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                SharedPreferences sharedPreferences = d2.getSharedPreferences(j0.a("H+tU+FeXHM=="), 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(j0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    edit.apply();
                }
            }
            String optString4 = jSONObject.optString("c");
            if (TextUtils.isEmpty(optString4) || TextUtils.equals(com.mbridge.msdk.foundation.same.a.g, optString4)) {
                return;
            }
            com.mbridge.msdk.foundation.same.a.g = optString4;
            com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c", com.mbridge.msdk.foundation.same.a.g);
            SharedPreferences sharedPreferences2 = d2.getSharedPreferences(j0.a("H+tU+FeXHM=="), 0);
            if (sharedPreferences2 != null) {
                SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                edit2.putString(j0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                edit2.apply();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String a() {
        return this.d;
    }

    public void a(List<com.mbridge.msdk.foundation.entity.a> list) {
        this.n = list;
    }

    public void a(long j) {
        this.p = j;
    }

    public void a(com.mbridge.msdk.setting.a aVar) {
        this.q = aVar;
    }

    public void a(Map<String, a> map) {
        this.s = map;
    }

    public void a(ArrayList<Integer> arrayList) {
        this.H = arrayList;
    }

    public void a(d dVar) {
        this.I = dVar;
    }

    public void a(C0384b c0384b) {
        this.J = c0384b;
    }

    public void a(HashMap<String, String> hashMap) {
        this.O = hashMap;
    }

    public void a(JSONArray jSONArray) {
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            jSONArray.put("2000088");
        }
        this.b = jSONArray;
    }

    public void a(boolean z) {
        this.Q = z;
    }

    public void b(String str) {
        this.d = str;
    }

    public String b() {
        return this.i;
    }

    public void b(long j) {
        this.F = j;
    }

    public void b(JSONArray jSONArray) {
        if (jSONArray == null) {
            jSONArray = new JSONArray();
            jSONArray.put("2000041");
            jSONArray.put("2000042");
            jSONArray.put("2000032");
            jSONArray.put("2000079");
        }
        this.c = jSONArray;
    }

    public void b(boolean z) {
        this.t = z;
    }

    public boolean b(int i) {
        return this.w0.contains(Integer.valueOf(i));
    }
}
