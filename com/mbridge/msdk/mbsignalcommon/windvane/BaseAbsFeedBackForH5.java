package com.mbridge.msdk.mbsignalcommon.windvane;

import android.text.TextUtils;
import android.util.Base64;
import android.webkit.WebView;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.tools.p0;
import io.bidmachine.iab.vast.tags.VastAttributes;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class BaseAbsFeedBackForH5 extends g {
    private static int e = 0;
    private static int f = 1;
    private String d = "AbsFeedBackForH5";

    public void callbackExcep(Object obj, String str) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", f);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, str);
            jSONObject.put("data", new JSONObject());
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            p0.a(this.d, e2.getMessage());
        }
    }

    public void callbackSuccess(Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", e);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, "");
            jSONObject.put("data", new JSONObject());
            f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e2) {
            callbackExcep(obj, e2.getMessage());
            p0.a(this.d, e2.getMessage());
        }
    }

    public void callbackSuccessWithData(Object obj, JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("code", e);
            jSONObject2.put(PglCryptUtils.KEY_MESSAGE, "");
            jSONObject2.put("data", jSONObject);
            f.a().b(obj, Base64.encodeToString(jSONObject2.toString().getBytes(), 2));
        } catch (Exception e2) {
            callbackExcep(obj, e2.getMessage());
            p0.a(this.d, e2.getMessage());
        }
    }

    public void feedbackLayoutOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("width", -1);
                int optInt2 = jSONObject.optInt("height", -1);
                int optInt3 = jSONObject.optInt("left", -1);
                int optInt4 = jSONObject.optInt("top", -1);
                double optDouble = jSONObject.optDouble(VastAttributes.OPACITY, 1.0d);
                int optInt5 = jSONObject.optInt("radius", 20);
                String optString = jSONObject.optString("fontColor", "");
                String optString2 = jSONObject.optString("bgColor", "");
                com.mbridge.msdk.foundation.feedback.b.b().a(jSONObject.optString(C3040d4.h.W, ""), optInt, optInt2, optInt5, optInt3, optInt4, (float) optDouble, optString, optString2, (float) jSONObject.optDouble("fontSize", -1.0d), jSONObject.optJSONArray(VastAttributes.PADDING));
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                com.mbridge.msdk.foundation.feedback.b.b().a(jSONObject.optString(C3040d4.h.W, ""), optInt == 1 ? 8 : 0, aVar.b);
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    public void feedbackPopupOperate(Object obj, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                int optInt = jSONObject.optInt("view_visible", 1);
                com.mbridge.msdk.foundation.feedback.b.b().a(jSONObject.optString(C3040d4.h.W, ""), optInt, new a(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b));
            }
            callbackSuccess(obj);
        } catch (Throwable th) {
            callbackExcep(obj, th.getMessage());
            th.printStackTrace();
        }
    }

    class a implements com.mbridge.msdk.foundation.feedback.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WindVaneWebView f4565a;

        a(WindVaneWebView windVaneWebView) {
            this.f4565a = windVaneWebView;
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 1);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(BaseAbsFeedBackForH5.this.d, th.getMessage(), th);
                str = "";
            }
            f.a().a((WebView) this.f4565a, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            String str;
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(BaseAbsFeedBackForH5.this.d, th.getMessage(), th);
                str = "";
            }
            f.a().a((WebView) this.f4565a, "onFeedbackAlertStatusNotify", Base64.encodeToString(str.getBytes(), 2));
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            String str2;
            try {
                JSONObject jSONObject = new JSONObject();
                if (com.mbridge.msdk.foundation.controller.c.m().d() != null) {
                    jSONObject.put("status", 2);
                }
                str2 = jSONObject.toString();
            } catch (Throwable th) {
                p0.b(BaseAbsFeedBackForH5.this.d, th.getMessage(), th);
                str2 = "";
            }
            f.a().a((WebView) this.f4565a, "onFeedbackAlertStatusNotify", Base64.encodeToString(str2.getBytes(), 2));
        }
    }
}
