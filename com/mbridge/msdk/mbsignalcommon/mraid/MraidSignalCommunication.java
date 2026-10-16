package com.mbridge.msdk.mbsignalcommon.mraid;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid.n;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class MraidSignalCommunication extends BaseMraidSignalCommunication {
    public static final /* synthetic */ int h = 0;
    private b g;

    public void close(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b, "close");
        }
        try {
            p0.b("MraidSignalCommunication", "MRAID close");
            b bVar = this.g;
            if (bVar != null) {
                bVar.close();
            }
        } catch (Throwable th) {
            p0.b("MraidSignalCommunication", "MRAID close", th);
        }
    }

    public void expand(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
            windVaneWebView = aVar.b;
            a.a().b(aVar.b, n.e);
        } else {
            windVaneWebView = null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("url");
            String optString2 = jSONObject.optString("shouldUseCustomClose");
            p0.b("MraidSignalCommunication", "MRAID expand " + optString + " " + optString2);
            if ((windVaneWebView != null && System.currentTimeMillis() - windVaneWebView.lastTouchTime > com.mbridge.msdk.click.utils.a.d && com.mbridge.msdk.click.utils.a.a(this.g.getMraidCampaign(), windVaneWebView.getUrl(), com.mbridge.msdk.click.utils.a.c)) || TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || this.g == null) {
                return;
            }
            this.g.expand(optString, optString2.toLowerCase().equals("true"));
        } catch (Throwable th) {
            p0.b("MraidSignalCommunication", "MRAID expand", th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.mbridge.msdk.mbsignalcommon.windvane.g
    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof b) {
                this.g = (b) context;
                return;
            }
            if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof b)) {
                this.g = (b) windVaneWebView.getObject();
            }
            if (windVaneWebView.getMraidObject() == null || !(windVaneWebView.getMraidObject() instanceof b)) {
                return;
            }
            this.g = (b) windVaneWebView.getMraidObject();
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void open(Object obj, String str) {
        WindVaneWebView windVaneWebView;
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            com.mbridge.msdk.mbsignalcommon.windvane.a aVar = (com.mbridge.msdk.mbsignalcommon.windvane.a) obj;
            windVaneWebView = aVar.b;
            a.a().b(aVar.b, "open");
        } else {
            windVaneWebView = null;
        }
        try {
            String optString = new JSONObject(str).optString("url");
            p0.b("MraidSignalCommunication", "MRAID Open " + optString);
            if (this.g == null || TextUtils.isEmpty(optString)) {
                return;
            }
            if (windVaneWebView == null || System.currentTimeMillis() - windVaneWebView.lastTouchTime <= com.mbridge.msdk.click.utils.a.d || !com.mbridge.msdk.click.utils.a.a(this.g.getMraidCampaign(), windVaneWebView.getUrl(), com.mbridge.msdk.click.utils.a.f4062a)) {
                this.g.open(optString);
            }
        } catch (Throwable th) {
            p0.b("MraidSignalCommunication", "MRAID Open", th);
        }
    }

    public void setOrientationProperties(Object obj, String str) {
        String str2;
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b, "setOrientationProperties");
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("allowOrientationChange");
            String optString2 = jSONObject.optString("forceOrientation");
            p0.b("MraidSignalCommunication", "MRAID setOrientationProperties");
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2) || this.g == null) {
                return;
            }
            optString.toLowerCase().equals("true");
            String lowerCase = optString2.toLowerCase();
            int hashCode = lowerCase.hashCode();
            if (hashCode == 729267099) {
                str2 = C3040d4.h.D;
            } else if (hashCode != 1430647483) {
                return;
            } else {
                str2 = C3040d4.h.C;
            }
            lowerCase.equals(str2);
        } catch (Throwable th) {
            p0.b("MraidSignalCommunication", "MRAID setOrientationProperties", th);
        }
    }

    public void unload(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b, "unload");
        }
        try {
            p0.b("MraidSignalCommunication", "MRAID unload");
            b bVar = this.g;
            if (bVar != null) {
                bVar.unload();
            }
        } catch (Throwable th) {
            p0.b("MraidSignalCommunication", "MRAID unload", th);
        }
    }

    public void useCustomClose(Object obj, String str) {
        if (obj instanceof com.mbridge.msdk.mbsignalcommon.windvane.a) {
            a.a().b(((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b, "useCustomClose");
        }
        try {
            String optString = new JSONObject(str).optString("shouldUseCustomClose");
            p0.b("MraidSignalCommunication", "MRAID useCustomClose " + optString);
            if (TextUtils.isEmpty(optString) || this.g == null) {
                return;
            }
            this.g.useCustomClose(optString.toLowerCase().equals("true"));
        } catch (Throwable th) {
            p0.b("MraidSignalCommunication", "MRAID useCustomClose", th);
        }
    }
}
