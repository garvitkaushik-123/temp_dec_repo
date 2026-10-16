package com.inmobi.media;

import android.content.Context;
import android.content.SharedPreferences;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.RootConfig;
import com.inmobi.sdk.InMobiSdk;
import io.bidmachine.IABSharedPreference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class G4 {

    /* renamed from: a, reason: collision with root package name */
    public static final G4 f2291a = new G4();
    public static JSONObject b;
    public static JSONObject c;
    public static JSONObject d;
    public static RootConfig e;

    /* JADX WARN: Removed duplicated region for block: B:19:0x00e1 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0071 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0048 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final JSONObject c() {
        JSONObject jSONObject;
        String str;
        int i;
        JSONObject jSONObject2;
        String str2;
        String str3;
        Context d2 = Uc.d();
        SharedPreferences sharedPreferences = d2 != null ? d2.getSharedPreferences((d2 != null ? d2.getPackageName() : null) + "_preferences", 0) : null;
        if (sharedPreferences != null) {
            try {
                Intrinsics.checkNotNullExpressionValue("G4", "TAG");
                str = sharedPreferences.getString("IABTCF_TCString", null);
            } catch (Exception unused) {
                str = null;
            }
            try {
                i = sharedPreferences.getInt("IABTCF_gdprApplies", -1);
            } catch (Exception unused2) {
                i = -1;
                if (str != null) {
                }
                jSONObject2 = null;
                if (jSONObject2 == null) {
                }
                if (jSONObject2 != null) {
                }
                jSONObject = c;
                if (jSONObject == null) {
                }
            }
            if (str != null) {
                try {
                    jSONObject2 = new JSONObject();
                    jSONObject2.put(InMobiSdk.IM_GDPR_CONSENT_IAB, str);
                    if (i != -1) {
                        jSONObject2.put(InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, String.valueOf(i));
                    }
                } catch (JSONException unused3) {
                }
                if (jSONObject2 == null) {
                    try {
                        Intrinsics.checkNotNullExpressionValue("G4", "TAG");
                        str2 = sharedPreferences.getString(IABSharedPreference.IAB_CONSENT_STRING, null);
                        try {
                            str3 = sharedPreferences.getString(IABSharedPreference.IAB_SUBJECT_TO_GDPR, null);
                        } catch (Exception unused4) {
                            str3 = null;
                            if (str2 != null) {
                            }
                            jSONObject2 = null;
                            if (jSONObject2 != null) {
                            }
                            jSONObject = c;
                            if (jSONObject == null) {
                            }
                        }
                    } catch (Exception unused5) {
                        str2 = null;
                    }
                    if (str2 != null) {
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(InMobiSdk.IM_GDPR_CONSENT_IAB, str2);
                            if (str3 != null) {
                                jSONObject3.put(InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, str3);
                            }
                            jSONObject2 = jSONObject3;
                        } catch (JSONException unused6) {
                        }
                    }
                    jSONObject2 = null;
                }
                if (jSONObject2 != null) {
                    return jSONObject2;
                }
            }
            jSONObject2 = null;
            if (jSONObject2 == null) {
            }
            if (jSONObject2 != null) {
            }
        }
        jSONObject = c;
        if (jSONObject == null) {
            return b;
        }
        if (b != null) {
            jSONObject = new JSONObject();
            JSONObject jSONObject4 = c;
            Iterator<String> keys = jSONObject4 != null ? jSONObject4.keys() : null;
            if (keys != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    try {
                        JSONObject jSONObject5 = c;
                        jSONObject.put(next, jSONObject5 != null ? jSONObject5.opt(next) : null);
                    } catch (JSONException unused7) {
                    }
                }
            }
            JSONObject jSONObject6 = b;
            Iterator<String> keys2 = jSONObject6 != null ? jSONObject6.keys() : null;
            if (keys2 != null) {
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    try {
                        JSONObject jSONObject7 = b;
                        jSONObject.put(next2, jSONObject7 != null ? jSONObject7.opt(next2) : null);
                    } catch (JSONException unused8) {
                    }
                }
            }
        }
        return jSONObject;
    }

    @JvmStatic
    public static /* synthetic */ void d() {
    }

    public static final byte e() {
        JSONObject c2 = c();
        if (c2 == null) {
            return (byte) -1;
        }
        if (c2.has(InMobiSdk.IM_GDPR_CONSENT_IAB)) {
            return (byte) 1;
        }
        if (!c2.has(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE)) {
            return (byte) -1;
        }
        try {
            return c2.getBoolean(InMobiSdk.IM_GDPR_CONSENT_AVAILABLE) ? (byte) 1 : (byte) 0;
        } catch (JSONException unused) {
            return (byte) -1;
        }
    }

    @JvmStatic
    public static /* synthetic */ void f() {
    }

    @JvmStatic
    public static final void h() {
        HashMap hashMap = D3.f2258a;
        Config a2 = D3.a(Uc.b(), "root");
        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig");
        e = (RootConfig) a2;
    }

    @JvmStatic
    public static final void i() {
        b = null;
        c = null;
        d = null;
        e = null;
    }

    public final void a(JSONObject jSONObject) {
        d = jSONObject;
    }

    public final JSONObject b() {
        return d;
    }

    public final JSONObject g() {
        return b;
    }

    public final void j() {
        LinkedHashMap linkedHashMap = O2.f2380a;
        e = (RootConfig) AbstractC2808p5.a("root", "null cannot be cast to non-null type com.inmobi.commons.core.configs.RootConfig", null);
    }

    public static /* synthetic */ boolean a(G4 g4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return g4.a(z);
    }

    public static final void b(JSONObject jSONObject) {
        if (jSONObject != null) {
            b = jSONObject;
        }
    }

    public final boolean a(boolean z) {
        if (e == null) {
            j();
        }
        byte e2 = e();
        RootConfig rootConfig = e;
        return e2 == 1 || Intrinsics.areEqual(rootConfig != null ? Boolean.valueOf(rootConfig.shouldTransmitRequest()) : null, Boolean.TRUE) || z;
    }

    public final boolean a() {
        return a(this, false, 1, null);
    }

    @JvmStatic
    public static final void c(JSONObject jSONObject) {
        if (jSONObject != null) {
            c = jSONObject;
        }
    }
}
