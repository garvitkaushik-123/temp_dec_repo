package com.mbridge.msdk.mbbanner.common.communication;

import android.util.Base64;
import android.webkit.WebView;
import com.google.android.gms.ads.AdError;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import io.bidmachine.rendering.model.EventTaskParams;
import java.util.HashMap;
import org.json.JSONObject;

/* compiled from: BannerCallJS.java */
/* loaded from: classes6.dex */
public class a {
    public static void a(WebView webView) {
        p0.b("BannerCallJS", "fireOnJSBridgeConnected");
        f.a().a(webView);
    }

    public static void a(WebView webView, float f, float f2) {
        p0.b("BannerCallJS", "fireOnBannerWebViewShow");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("startX", f);
            jSONObject.put("startY", f2);
            jSONObject.put("scale", u0.d(c.m().d()));
            f.a().a(webView, "webviewshow", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Throwable th) {
            p0.b("BannerCallJS", "fireOnBannerWebViewShow", th);
        }
    }

    public static void a(WebView webView, int i, int i2) {
        p0.b("BannerCallJS", "fireOnBannerViewSizeChange");
        try {
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().c(webView, i, i2);
        } catch (Throwable th) {
            p0.b("BannerCallJS", "fireOnBannerViewSizeChange", th);
        }
    }

    public static void a(WebView webView, int i, int i2, int i3, int i4) {
        String str;
        p0.b("BannerCallJS", "transInfoForMraid");
        try {
            int i5 = c.m().d().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            if (i5 == 2) {
                str = C3040d4.h.C;
            } else {
                str = i5 == 1 ? C3040d4.h.D : AdError.UNDEFINED_DOMAIN;
            }
            jSONObject.put("orientation", str);
            jSONObject.put("locked", "true");
            float n = l0.n(c.m().d());
            float m = l0.m(c.m().d());
            HashMap v = l0.v(c.m().d());
            int intValue = ((Integer) v.get("width")).intValue();
            int intValue2 = ((Integer) v.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", "inline");
            hashMap.put("state", EventTaskParams.STATE_GROUP_DEFAULT);
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            float f = i;
            float f2 = i2;
            float f3 = i3;
            float f4 = i4;
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, f, f2, f3, f4);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, f, f2, f3, f4);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(webView, n, m);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, intValue, intValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView, hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(webView);
        } catch (Throwable th) {
            p0.b("BannerCallJS", "transInfoForMraid", th);
        }
    }
}
