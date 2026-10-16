package com.mbridge.msdk.mbsignalcommon.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import org.json.JSONObject;

/* compiled from: BaseCommonBannerSignalCommunicationImp.java */
/* loaded from: classes6.dex */
public abstract class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public static final String f4553a = "a";

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void a(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void b(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
        Context d = com.mbridge.msdk.foundation.controller.c.m().d();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (d == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                    d = windVaneWebView.getContext();
                }
            } catch (Exception unused) {
            }
        }
        if (d == null) {
            f.a().b(obj, d.a(1));
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("netstat", l0.s(d));
            String jSONObject2 = jSONObject.toString();
            if (!TextUtils.isEmpty(jSONObject2)) {
                jSONObject2 = Base64.encodeToString(jSONObject2.getBytes(), 2);
            }
            f.a().b(obj, jSONObject2);
        } catch (Throwable unused2) {
            f.a().b(obj, d.a(1));
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void c(Object obj, String str) {
        try {
            if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
                f.a().a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b);
            }
        } catch (Throwable th) {
            p0.b(f4553a, "onSignalCommunication", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void handlerH5Exception(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void increaseOfferFrequence(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                d.a(obj, new JSONObject(str));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void install(Object obj, String str) {
    }

    @Override // com.mbridge.msdk.mbsignalcommon.communication.b
    public void openURL(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
        Context d = com.mbridge.msdk.foundation.controller.c.m().d();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (d == null) {
            try {
                if ((obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) && (windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b) != null) {
                    d = windVaneWebView.getContext();
                }
            } catch (Exception unused) {
            }
        }
        if (d == null) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                com.mbridge.msdk.click.c.c(d, optString);
            } else if (optInt == 2) {
                com.mbridge.msdk.click.c.e(d, optString);
            }
        } catch (Throwable unused2) {
        }
    }
}
