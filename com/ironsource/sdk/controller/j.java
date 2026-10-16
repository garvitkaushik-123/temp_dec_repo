package com.ironsource.sdk.controller;

import com.ironsource.C3009ba;
import com.ironsource.C3026ca;
import com.ironsource.C3247p8;
import com.ironsource.C3260q4;
import com.ironsource.C3382x8;
import com.ironsource.InterfaceC2992aa;
import com.ironsource.InterfaceC3386xc;
import com.ironsource.V5;
import com.ironsource.X5;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import org.json.JSONObject;

/* loaded from: classes6.dex */
class j {

    /* renamed from: a, reason: collision with root package name */
    private final String f3747a;
    private final X5 b;

    j(String str, X5 x5) {
        this.f3747a = str;
        this.b = x5;
    }

    private C3382x8 b(JSONObject jSONObject, String str) throws Exception {
        if (!jSONObject.has(V5.c.c) || !jSONObject.has(V5.c.b)) {
            throw new Exception(V5.a.f3089a);
        }
        String string = jSONObject.getString(V5.c.c);
        return new C3382x8(IronSourceStorageUtils.buildAbsolutePathToDirInCache(str, string), jSONObject.getString(V5.c.b));
    }

    void a(JSONObject jSONObject, InterfaceC2992aa interfaceC2992aa) {
        char c;
        C3009ba c3009ba = new C3009ba(jSONObject);
        C3026ca c3026ca = new C3026ca(interfaceC2992aa);
        try {
            String b = c3009ba.b();
            JSONObject c2 = c3009ba.c();
            C3382x8 b2 = b(c2, this.f3747a);
            IronSourceStorageUtils.ensurePathSafety(b2, this.f3747a);
            switch (b.hashCode()) {
                case -2073025383:
                    if (b.equals(V5.b.f3090a)) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case -1137024519:
                    if (b.equals(V5.b.c)) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -318115535:
                    if (b.equals(V5.b.e)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case 537556755:
                    if (b.equals(V5.b.f)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 1764172231:
                    if (b.equals(V5.b.b)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1953259713:
                    if (b.equals(V5.b.d)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            if (c == 0) {
                this.b.a(b2, c2.optString(V5.c.f3091a), c2.optInt("connectionTimeout"), c2.optInt("readTimeout"), a(c3009ba, c3026ca));
                return;
            }
            if (c == 1) {
                this.b.a(b2);
                c3026ca.b(c3009ba, a(c3009ba, b2.a()));
                return;
            }
            if (c == 2) {
                this.b.b(b2);
                c3026ca.b(c3009ba, a(c3009ba, b2.a()));
                return;
            }
            if (c == 3) {
                c3026ca.b(c3009ba, a(c3009ba, this.b.c(b2)));
                return;
            }
            if (c == 4) {
                c3026ca.b(c3009ba, a(c3009ba, this.b.d(b2)));
            } else {
                if (c != 5) {
                    return;
                }
                this.b.a(b2, c2.optJSONObject(V5.c.g));
                c3026ca.b(c3009ba, a(c3009ba, b2.a()));
            }
        } catch (Exception e) {
            C3260q4.d().a(e);
            c3026ca.a(c3009ba, a(c3009ba, e.getMessage()));
        }
    }

    class a implements InterfaceC3386xc {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C3026ca f3748a;
        final /* synthetic */ C3009ba b;

        a(C3026ca c3026ca, C3009ba c3009ba) {
            this.f3748a = c3026ca;
            this.b = c3009ba;
        }

        @Override // com.ironsource.InterfaceC3386xc
        public void a(C3382x8 c3382x8) {
            try {
                C3026ca c3026ca = this.f3748a;
                C3009ba c3009ba = this.b;
                c3026ca.b(c3009ba, j.this.a(c3009ba, c3382x8.a()));
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }

        @Override // com.ironsource.InterfaceC3386xc
        public void a(C3382x8 c3382x8, C3247p8 c3247p8) {
            try {
                C3026ca c3026ca = this.f3748a;
                C3009ba c3009ba = this.b;
                c3026ca.a(c3009ba, j.this.a(c3009ba, c3247p8.b()));
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    private InterfaceC3386xc a(C3009ba c3009ba, C3026ca c3026ca) {
        return new a(c3026ca, c3009ba);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(C3009ba c3009ba, JSONObject jSONObject) {
        try {
            return c3009ba.e().put("result", jSONObject);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return new JSONObject();
        }
    }

    private JSONObject a(C3009ba c3009ba, long j) {
        try {
            return c3009ba.e().put("result", j);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return new JSONObject();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject a(C3009ba c3009ba, String str) {
        try {
            return c3009ba.e().put("errMsg", str);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return new JSONObject();
        }
    }

    private C3382x8 a(JSONObject jSONObject, String str) throws Exception {
        if (jSONObject.has(V5.c.d)) {
            return new C3382x8(IronSourceStorageUtils.buildAbsolutePathToDirInCache(str, jSONObject.getString(V5.c.d)));
        }
        throw new Exception(V5.a.b);
    }
}
