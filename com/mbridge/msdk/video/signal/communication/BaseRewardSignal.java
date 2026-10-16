package com.mbridge.msdk.video.signal.communication;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.communication.d;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.impl.k;
import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class BaseRewardSignal extends BaseRewardSignalDiff {
    protected BaseIRewardCommunication g;

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void cai(Object obj, String str) {
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            try {
                String optString = new JSONObject(str).optString(HandleInvocationsFromAdViewer.KEY_PACKAGE_NAME);
                if (TextUtils.isEmpty(optString)) {
                    d.a(obj, "packageName is empty");
                }
                int i = u0.c(c.m().d(), optString) ? 1 : 2;
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", d.b);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i);
                    jSONObject.put("data", jSONObject2);
                    f.a().b(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    d.a(obj, e.getMessage());
                    p0.a("JS-Reward-Brigde", e.getMessage());
                }
            } catch (JSONException e2) {
                d.a(obj, "exception: " + e2.getLocalizedMessage());
                p0.b("JS-Reward-Brigde", "cai", e2);
            }
        } catch (Throwable th) {
            d.a(obj, "exception: " + th.getLocalizedMessage());
            p0.b("JS-Reward-Brigde", "cai", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void getEndScreenInfo(Object obj, String str) {
        try {
            BaseIRewardCommunication baseIRewardCommunication = this.g;
            if (baseIRewardCommunication != null) {
                baseIRewardCommunication.getEndScreenInfo(obj, str);
                p0.b("JS-Reward-Brigde", "getEndScreenInfo factory is true");
                return;
            }
            p0.b("JS-Reward-Brigde", "getEndScreenInfo factory is null");
            if (obj != null) {
                WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
                if (!(windVaneWebView instanceof WindVaneWebView) || windVaneWebView.getWebViewListener() == null) {
                    return;
                }
                ((com.mbridge.msdk.mbsignalcommon.listener.a) windVaneWebView.getWebViewListener()).a(obj);
            }
        } catch (Throwable th) {
            p0.b("JS-Reward-Brigde", "getEndScreenInfo", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void handlerPlayableException(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.g.handlerPlayableException(obj, str);
        } catch (Throwable th) {
            p0.b("JS-Reward-Brigde", "handlerPlayableException", th);
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.g
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        boolean z;
        super.initialize(context, windVaneWebView);
        try {
            z = IJSFactory.class.isInstance(context);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            z = false;
        }
        try {
            if (z) {
                this.g = (BaseIRewardCommunication) BaseRewardSignalH5.class.newInstance();
                BaseRewardSignalH5.class.getMethod(MobileAdsBridgeBase.initializeMethodName, Context.class, WindVaneWebView.class).invoke(this.g, context, windVaneWebView);
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof BaseIRewardCommunication)) {
                this.g = (BaseIRewardCommunication) windVaneWebView.getObject();
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void install(Object obj, String str) {
        try {
            BaseIRewardCommunication baseIRewardCommunication = this.g;
            if (baseIRewardCommunication != null) {
                baseIRewardCommunication.install(obj, str);
                return;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (obj != null) {
                com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
                if (aVar.b.getObject() instanceof k) {
                    ((k) aVar.b.getObject()).click(1, str);
                    p0.b("JS-Reward-Brigde", "JSCommon install jump success");
                }
            }
            p0.b("JS-Reward-Brigde", "JSCommon install failed");
        } catch (Throwable th) {
            p0.b("JS-Reward-Brigde", "install", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void notifyCloseBtn(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.g.notifyCloseBtn(obj, str);
        } catch (Throwable th) {
            p0.b("JS-Reward-Brigde", "notifyCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void openURL(Object obj, String str) {
        p0.b("JS-Reward-Brigde", "openURL:" + str);
        if (TextUtils.isEmpty(str)) {
            d.a(obj, "params is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            int optInt = jSONObject.optInt("type");
            if (optInt == 1) {
                com.mbridge.msdk.click.c.c(this.f4571a, optString);
            } else if (optInt == 2) {
                com.mbridge.msdk.click.c.e(this.f4571a, optString);
            }
        } catch (JSONException e) {
            p0.b("JS-Reward-Brigde", e.getMessage());
        } catch (Throwable th) {
            p0.b("JS-Reward-Brigde", th.getMessage());
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void setOrientation(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.g.setOrientation(obj, str);
        } catch (Throwable th) {
            p0.b("JS-Reward-Brigde", "setOrientation", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void toggleCloseBtn(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.g.toggleCloseBtn(obj, str);
        } catch (Throwable th) {
            p0.b("JS-Reward-Brigde", "toggleCloseBtn", th);
        }
    }

    @Override // com.mbridge.msdk.video.signal.communication.BaseIRewardCommunication
    public void triggerCloseBtn(Object obj, String str) {
        try {
            if (this.g == null || TextUtils.isEmpty(str)) {
                return;
            }
            this.g.triggerCloseBtn(obj, str);
        } catch (Throwable th) {
            p0.b("JS-Reward-Brigde", "triggerCloseBtn", th);
            f.a().b(obj, a(-1));
        }
    }

    private String a(int i) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i);
            String jSONObject2 = jSONObject.toString();
            return !TextUtils.isEmpty(jSONObject2) ? Base64.encodeToString(jSONObject2.getBytes(), 2) : "";
        } catch (Throwable unused) {
            p0.b("JS-Reward-Brigde", "code to string is error");
            return "";
        }
    }

    @Override // com.mbridge.msdk.mbsignalcommon.windvane.g
    public void initialize(Object obj, WindVaneWebView windVaneWebView) {
        boolean z;
        super.initialize(obj, windVaneWebView);
        try {
            z = IJSFactory.class.isInstance(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            z = false;
        }
        try {
            if (z) {
                this.g = (BaseIRewardCommunication) BaseRewardSignalH5.class.newInstance();
                BaseRewardSignalH5.class.getMethod(MobileAdsBridgeBase.initializeMethodName, Object.class, WindVaneWebView.class).invoke(this.g, obj, windVaneWebView);
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof BaseIRewardCommunication)) {
                this.g = (BaseIRewardCommunication) windVaneWebView.getObject();
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }
}
