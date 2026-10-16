package com.ironsource;

import android.content.Context;
import com.ironsource.C3040d4;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.l8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3179l8 implements InterfaceC2983a1 {
    private static final String b = "l8";
    private static C3179l8 c;

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, F8> f3445a = Collections.synchronizedMap(new HashMap());

    /* renamed from: com.ironsource.l8$a */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ C3162k8 f3446a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;

        a(C3162k8 c3162k8, Context context, String str) {
            this.f3446a = c3162k8;
            this.b = context;
            this.c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            C3179l8.this.f3445a.put(this.c, new C3078f8(this.f3446a, this.b));
        }
    }

    public static synchronized C3179l8 a() {
        C3179l8 c3179l8;
        synchronized (C3179l8.class) {
            if (c == null) {
                c = new C3179l8();
            }
            c3179l8 = c;
        }
        return c3179l8;
    }

    private C3044d8 b(JSONObject jSONObject) {
        C3044d8 c3044d8 = new C3044d8();
        try {
            return a(jSONObject);
        } catch (Exception e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return c3044d8;
        }
    }

    private boolean d(JSONObject jSONObject) {
        return jSONObject.optBoolean(C3040d4.h.s0);
    }

    public String c(JSONObject jSONObject) throws JSONException {
        return (jSONObject == null || !jSONObject.has("adViewId")) ? (jSONObject == null || !jSONObject.has("params")) ? "" : new JSONObject(jSONObject.getString("params")).getString("adViewId") : jSONObject.getString("adViewId");
    }

    public void d(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = new JSONObject(jSONObject.getString("params")).getString("adViewId");
        if (string.isEmpty()) {
            Logger.i(b, "sendMessageToAd fail - adViewId is empty");
            throw new Exception("adViewId is empty");
        }
        if (!this.f3445a.containsKey(string)) {
            Logger.i(b, "sendMessageToAd fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        F8 f8 = this.f3445a.get(string);
        if (f8 != null) {
            f8.c(jSONObject, str, str2);
        }
    }

    private C3044d8 a(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject(jSONObject.getString(C3040d4.h.O));
            String obj = jSONObject2.get("height").toString();
            String obj2 = jSONObject2.get("width").toString();
            return new C3044d8(Integer.parseInt(obj2), Integer.parseInt(obj), jSONObject2.get("label").toString());
        } catch (Exception e) {
            C3260q4.d().a(e);
            return new C3044d8();
        }
    }

    public void b(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            if (this.f3445a.containsKey(string)) {
                F8 f8 = this.f3445a.get(string);
                String string2 = jSONObject.getString(C3040d4.h.v0);
                if (f8 != null) {
                    f8.a(string2, str, str2);
                    return;
                }
                return;
            }
            Logger.i(b, "performWebViewAction fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        Logger.i(b, "performWebViewAction fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }

    public void c(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            if (this.f3445a.containsKey(string)) {
                F8 f8 = this.f3445a.get(string);
                this.f3445a.remove(string);
                if (f8 != null) {
                    f8.a(str, str2);
                    return;
                }
                return;
            }
            Logger.i(b, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        Logger.i(b, "removeAdView fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }

    public void a(InterfaceC3095g8 interfaceC3095g8, JSONObject jSONObject, Context context, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            C3044d8 b2 = b(jSONObject);
            if (!this.f3445a.containsKey(string)) {
                C3162k8 c3162k8 = new C3162k8(interfaceC3095g8, context, string, b2);
                c3162k8.e(IronSourceStorageUtils.getNetworkStorageDir(context));
                c3162k8.b(jSONObject, str, str2);
                if (d(jSONObject)) {
                    R7.f3025a.d(new a(c3162k8, context, string));
                    return;
                } else {
                    this.f3445a.put(string, c3162k8);
                    return;
                }
            }
            Logger.i(b, "sendMessageToAd fail - collection already contain adViewId");
            throw new Exception("collection already contain adViewId");
        }
        Logger.i(b, "loadWithUrl fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }

    @Override // com.ironsource.InterfaceC2983a1
    public F8 a(String str) {
        if (str.isEmpty() || !this.f3445a.containsKey(str)) {
            return null;
        }
        return this.f3445a.get(str);
    }

    public void a(JSONObject jSONObject, String str, String str2) throws Exception {
        String string = jSONObject.getString("adViewId");
        if (!string.isEmpty()) {
            if (this.f3445a.containsKey(string)) {
                F8 f8 = this.f3445a.get(string);
                if (f8 != null) {
                    f8.a(jSONObject, str, str2);
                    return;
                }
                return;
            }
            Logger.i(b, "removeAdView fail - collection does not contain adViewId");
            throw new Exception("collection does not contain adViewId");
        }
        Logger.i(b, "removeAdView fail - adViewId is empty");
        throw new Exception("adViewId is empty");
    }
}
