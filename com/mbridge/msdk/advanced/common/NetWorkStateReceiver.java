package com.mbridge.msdk.advanced.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.webkit.WebView;
import androidx.autofill.HintConstants;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class NetWorkStateReceiver extends BroadcastReceiver {
    private static final String c = "NetWorkStateReceiver";

    /* renamed from: a, reason: collision with root package name */
    private WebView f3977a;
    private int b;

    public NetWorkStateReceiver(WebView webView) {
        this.f3977a = webView;
    }

    public void a() {
        this.f3977a = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                a(this.f3977a, 0);
                return;
            }
            if (!com.mbridge.msdk.foundation.same.a.z) {
                a(this.f3977a, 0);
                return;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                a(this.f3977a, 0);
                return;
            }
            if (activeNetworkInfo.getState() != NetworkInfo.State.CONNECTING && activeNetworkInfo.getState() != NetworkInfo.State.DISCONNECTING) {
                if (activeNetworkInfo.getType() == 1) {
                    a(this.f3977a, 9);
                    return;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
                if (telephonyManager == null) {
                    a(this.f3977a, 0);
                    return;
                }
                int networkType = telephonyManager.getNetworkType();
                this.b = networkType;
                int c2 = l0.c(networkType);
                this.b = c2;
                a(this.f3977a, c2);
            }
        } catch (Throwable th) {
            p0.a(c, th.getMessage());
        }
    }

    public void a(WebView webView, int i) {
        if (webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("netstat", i);
                f.a().a(webView, "onNetstatChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Throwable th) {
                p0.a(c, th.getMessage());
            }
        }
    }
}
