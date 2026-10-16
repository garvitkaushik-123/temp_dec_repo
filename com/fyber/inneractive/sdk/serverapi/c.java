package com.fyber.inneractive.sdk.serverapi;

import android.telephony.TelephonyManager;
import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.util.k;
import com.fyber.inneractive.sdk.util.o;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public final class c implements d {
    public static final List c = Arrays.asList(5);
    public static final List d = Arrays.asList(Integer.valueOf(com.fyber.inneractive.sdk.rtb.data.types.a.VAST_2_0.a()), Integer.valueOf(com.fyber.inneractive.sdk.rtb.data.types.a.VAST_2_0_WRAPPER.a()));

    /* renamed from: a, reason: collision with root package name */
    public r f1731a;
    public final String b;

    public c(r rVar) {
        String str;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) o.f1770a.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
            str = telephonyManager.getNetworkOperator();
            if (telephonyManager.getPhoneType() == 2 && k.n()) {
                str = telephonyManager.getSimOperator();
            }
        } catch (Exception unused) {
            str = null;
        }
        this.b = str;
        this.f1731a = rVar;
    }

    public final String a() {
        try {
            return ((TelephonyManager) o.f1770a.getSystemService(HintConstants.AUTOFILL_HINT_PHONE)).getNetworkOperatorName();
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a(String str, HashMap hashMap) {
        String str2;
        a aVar = b.f1730a;
        try {
            Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
            str2 = "unity3d";
        } catch (Throwable unused) {
            str2 = "native";
        }
        hashMap.put("frmn", str2);
        hashMap.put(BidTokenRepositoryKt.HEADSET, a(b.m()));
        hashMap.put("is_muted", a(b.k()));
        hashMap.put("btry_c", a(b.i()));
        hashMap.put("btry_l", b.b());
        hashMap.put("bt_con", a(b.g()));
        Long e = b.e();
        hashMap.put("tod", e == null ? "" : String.valueOf(e));
        hashMap.put("apnm", a(b.f()));
        hashMap.put("dnd", a(b.l()));
        IAConfigManager iAConfigManager = IAConfigManager.O;
        hashMap.put("lng", iAConfigManager.o);
        String a2 = iAConfigManager.x.a(b.a(str), "LAST_DOMAIN_SHOWED");
        if (!TextUtils.isEmpty(a2) && a2.contains(",")) {
            a2 = a2.split(",")[0];
        }
        hashMap.put("ldomain", a2);
        hashMap.put("lbundle", iAConfigManager.x.a(b.a(str), "LAST_APP_BUNDLE_ID"));
        String a3 = iAConfigManager.x.a(b.a(str), "LAST_CLICKED");
        if (TextUtils.equals(a3, "0")) {
            a3 = "";
        }
        hashMap.put("lclick", a3);
        String a4 = iAConfigManager.x.a(b.a(str), "LAST_VAST_SKIPED");
        if (TextUtils.equals(a4, "0")) {
            a4 = "";
        }
        hashMap.put("v_lskip", a4);
        UnitDisplayType a5 = b.a(str);
        hashMap.put("v_lclicktype", a5.isFullscreenUnit() ? iAConfigManager.x.a(a5, "LAST_VAST_CLICKED_TYPE") : "");
        hashMap.put("sdur", String.valueOf(b.c()));
        hashMap.put("userid", iAConfigManager.D.g);
        hashMap.put("low_power_mode", a(b.n()));
        hashMap.put("dark_mode", a(b.h()));
        hashMap.put("d_api", b.d());
        hashMap.put("media_muted", a(b.j()));
        Integer a6 = b.a();
        hashMap.put("asv", a6 != null ? String.valueOf(a6) : "");
    }

    public static String a(Boolean bool) {
        return bool != null ? bool.booleanValue() ? "1" : "0" : "";
    }
}
