package com.mbridge.msdk.video.signal.impl;

import android.util.Base64;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import org.json.JSONObject;

/* compiled from: JSNotifyProxy.java */
/* loaded from: classes6.dex */
public class n extends f {

    /* renamed from: a, reason: collision with root package name */
    private WebView f5261a;

    public n(WebView webView) {
        this.f5261a = webView;
    }

    @Override // com.mbridge.msdk.video.signal.impl.f, com.mbridge.msdk.video.signal.g
    public void a(int i) {
        super.a(i);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", i);
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(this.f5261a, "onVideoStatusNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.f, com.mbridge.msdk.video.signal.g
    public void a(int i, String str) {
        super.a(i, str);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("type", i);
            jSONObject.put("pt", str);
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(this.f5261a, "onJSClick", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.signal.impl.f, com.mbridge.msdk.video.signal.g
    public void a(MBridgeVideoView.v vVar) {
        super.a(vVar);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(NotificationCompat.CATEGORY_PROGRESS, a(vVar.f5146a, vVar.b));
            jSONObject.put("time", String.valueOf(vVar.f5146a));
            jSONObject.put("duration", String.valueOf(vVar.b));
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(this.f5261a, "onVideoProgressNotify", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String a(int i, int i2) {
        if (i2 != 0) {
            try {
                return u0.a(Double.valueOf(i / i2)) + "";
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return i2 + "";
    }

    @Override // com.mbridge.msdk.video.signal.impl.f, com.mbridge.msdk.video.signal.g
    public void a(Object obj) {
        String str;
        super.a(obj);
        if (obj != null && (obj instanceof String)) {
            str = Base64.encodeToString(obj.toString().getBytes(), 2);
        } else {
            str = "";
        }
        com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(this.f5261a, "webviewshow", str);
    }

    @Override // com.mbridge.msdk.video.signal.impl.f, com.mbridge.msdk.video.signal.g
    public void a(int i, int i2, int i3, int i4) {
        super.a(i, i2, i3, i4);
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            String str = C3040d4.h.C;
            if (i != 2 ? i2 != 2 : i2 == 1) {
                str = C3040d4.h.D;
            }
            jSONObject2.put("orientation", str);
            jSONObject2.put("screen_width", i3);
            jSONObject2.put("screen_height", i4);
            jSONObject.put("data", jSONObject2);
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(this.f5261a, "showDataInfo", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }
}
