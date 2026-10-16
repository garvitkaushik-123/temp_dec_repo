package com.ironsource.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.B9;
import com.ironsource.C3247p8;
import com.ironsource.C3260q4;
import com.ironsource.C3348v8;
import com.ironsource.C3365w8;
import com.ironsource.F5;
import com.ironsource.F9;
import com.ironsource.InterfaceC3352vc;
import com.ironsource.K9;
import com.ironsource.N9;
import com.ironsource.sdk.controller.e;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class IronSourceNetwork {

    /* renamed from: a, reason: collision with root package name */
    static final String f3696a = "IronSourceNetwork";
    private static K9 b;
    private static List<InterfaceC3352vc> c = new ArrayList();
    private static N9 d;

    private static void a(Context context, JSONObject jSONObject, String str, String str2, Map<String, String> map) throws Exception {
        if (jSONObject != null) {
            F5 a2 = C3365w8.a(jSONObject);
            if (a2.a()) {
                C3348v8.a(a2, C3365w8.a(context, str, str2, map));
            }
        }
    }

    public static synchronized void addInitListener(InterfaceC3352vc interfaceC3352vc) {
        synchronized (IronSourceNetwork.class) {
            N9 n9 = d;
            if (n9 == null) {
                c.add(interfaceC3352vc);
            } else if (n9.b()) {
                interfaceC3352vc.onSuccess();
            } else {
                interfaceC3352vc.onFail(d.a());
            }
        }
    }

    public static synchronized void destroyAd(B9 b9) throws Exception {
        synchronized (IronSourceNetwork.class) {
            a();
            b.b(b9);
        }
    }

    public static synchronized e getControllerManager() {
        e a2;
        synchronized (IronSourceNetwork.class) {
            a2 = b.a();
        }
        return a2;
    }

    public static String getVersion() {
        return SDKUtils.getSDKVersion();
    }

    public static synchronized void initSDK(Context context, String str, String str2, Map<String, String> map) {
        synchronized (IronSourceNetwork.class) {
            if (TextUtils.isEmpty(str)) {
                Logger.e(f3696a, "applicationKey is NULL");
                return;
            }
            if (b == null) {
                SDKUtils.setInitSDKParams(map);
                try {
                    a(context, SDKUtils.getNetworkConfiguration().optJSONObject("events"), str2, str, map);
                } catch (Exception e) {
                    C3260q4.d().a(e);
                    Logger.e(f3696a, "Failed to init event tracker: " + e.getMessage());
                }
                b = F9.a(context, str, str2);
            }
        }
    }

    public static synchronized boolean isAdAvailableForInstance(B9 b9) {
        synchronized (IronSourceNetwork.class) {
            K9 k9 = b;
            if (k9 == null) {
                return false;
            }
            return k9.a(b9);
        }
    }

    public static synchronized void loadAd(B9 b9, Map<String, String> map) throws Exception {
        synchronized (IronSourceNetwork.class) {
            a();
            b.a(b9, map);
        }
    }

    public static synchronized void loadAdView(Activity activity, B9 b9, Map<String, String> map) throws Exception {
        synchronized (IronSourceNetwork.class) {
            a();
            b.b(activity, b9, map);
        }
    }

    public static void onPause(Activity activity) {
        K9 k9 = b;
        if (k9 == null) {
            return;
        }
        k9.onPause(activity);
    }

    public static void onResume(Activity activity) {
        K9 k9 = b;
        if (k9 == null) {
            return;
        }
        k9.onResume(activity);
    }

    public static synchronized void release(Activity activity) {
        synchronized (IronSourceNetwork.class) {
            K9 k9 = b;
            if (k9 == null) {
                return;
            }
            k9.a(activity);
        }
    }

    public static synchronized void showAd(Activity activity, B9 b9, Map<String, String> map) throws Exception {
        synchronized (IronSourceNetwork.class) {
            a();
            b.a(activity, b9, map);
        }
    }

    public static synchronized void updateInitFailed(C3247p8 c3247p8) {
        synchronized (IronSourceNetwork.class) {
            d = new N9(c3247p8);
            Iterator<InterfaceC3352vc> it = c.iterator();
            while (it.hasNext()) {
                it.next().onFail(c3247p8);
            }
            c.clear();
        }
    }

    public static synchronized void updateInitSucceeded() {
        synchronized (IronSourceNetwork.class) {
            d = new N9();
            Iterator<InterfaceC3352vc> it = c.iterator();
            while (it.hasNext()) {
                it.next().onSuccess();
            }
            c.clear();
        }
    }

    private static synchronized void a() throws Exception {
        synchronized (IronSourceNetwork.class) {
            if (b == null) {
                throw new NullPointerException("Call initSDK first");
            }
        }
    }
}
