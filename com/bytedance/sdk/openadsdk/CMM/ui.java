package com.bytedance.sdk.openadsdk.CMM;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class ui implements aGH {
    private aGH DbA;
    Handler eli = null;

    ui(aGH agh) {
        this.DbA = agh;
    }

    @Override // com.bytedance.sdk.openadsdk.CMM.aGH
    public ExecutorService eli() {
        aGH agh = this.DbA;
        if (agh == null || agh.eli() == null) {
            return Executors.newCachedThreadPool();
        }
        return this.DbA.eli();
    }

    @Override // com.bytedance.sdk.openadsdk.CMM.aGH
    public Context DbA() {
        aGH agh = this.DbA;
        if (agh == null || agh.DbA() == null) {
            return wC();
        }
        return this.DbA.DbA();
    }

    @Override // com.bytedance.sdk.openadsdk.CMM.aGH
    public String Os() {
        aGH agh = this.DbA;
        if (agh == null || TextUtils.isEmpty(agh.Os())) {
            return "null";
        }
        return this.DbA.Os();
    }

    @Override // com.bytedance.sdk.openadsdk.CMM.aGH
    public Handler aGH() {
        aGH agh = this.DbA;
        if (agh == null || agh.kb() == null) {
            Handler handler = new Handler(eli("pag_strategy", -1).getLooper());
            this.eli = handler;
            return handler;
        }
        return this.DbA.aGH();
    }

    @Override // com.bytedance.sdk.openadsdk.CMM.aGH
    public String ui() {
        aGH agh = this.DbA;
        if (agh != null) {
            return agh.ui();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.CMM.aGH
    public JSONObject MGA() {
        aGH agh = this.DbA;
        if (agh != null) {
            return agh.MGA();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.CMM.aGH
    public Map<String, String> kb() {
        aGH agh = this.DbA;
        if (agh == null || agh.kb() == null) {
            return new HashMap();
        }
        return this.DbA.kb();
    }

    @Override // com.bytedance.sdk.openadsdk.CMM.aGH
    public JSONObject eli(JSONObject jSONObject) {
        aGH agh = this.DbA;
        return agh != null ? agh.eli(jSONObject) : jSONObject;
    }

    @Override // com.bytedance.sdk.openadsdk.CMM.aGH
    public HandlerThread eli(String str, int i) {
        HandlerThread eli;
        aGH agh = this.DbA;
        if (agh != null && (eli = agh.eli(str, i)) != null) {
            return eli;
        }
        HandlerThread handlerThread = new HandlerThread("pag_strategy", -1);
        handlerThread.start();
        return handlerThread;
    }

    private Context wC() {
        try {
            Method method = Class.forName("android.app.ActivityThread").getMethod("currentActivityThread", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(null, new Object[0]);
            return (Application) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
        } catch (Throwable unused) {
            return null;
        }
    }
}
