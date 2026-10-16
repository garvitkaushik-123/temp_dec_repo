package com.fyber.inneractive.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import java.lang.ref.WeakReference;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b1 extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference f1752a;

    public b1(Looper looper, com.fyber.inneractive.sdk.network.f fVar) {
        super(looper);
        this.f1752a = new WeakReference(fVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v20, types: [org.json.JSONObject] */
    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        String str;
        super.handleMessage(message);
        c1 c1Var = (c1) t.a(this.f1752a);
        if (c1Var != null) {
            com.fyber.inneractive.sdk.network.f fVar = (com.fyber.inneractive.sdk.network.f) c1Var;
            int i = message.what;
            if (i == 12312329 || i == 20150330) {
                if (fVar.f && fVar.f1318a.size() > 0) {
                    while (true) {
                        str = null;
                        if (fVar.f1318a.size() <= 0) {
                            break;
                        }
                        try {
                            str = (JSONObject) fVar.f1318a.poll();
                        } catch (Throwable unused) {
                        }
                        if (str != null) {
                            fVar.b.put(str);
                        }
                    }
                    if (fVar.b.length() > 0) {
                        JSONArray jSONArray = fVar.b;
                        int i2 = com.fyber.inneractive.sdk.config.k.f1102a;
                        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
                        String str2 = TextUtils.isEmpty(property) ? "https://" + IAConfigManager.O.i.f : Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(property).matches() ? "https://" + property + "/simpleM2M/Event" : "https://" + property + ".inner-active.mobi/simpleM2M/Event";
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            str = jSONArray.toString();
                        } catch (Throwable unused2) {
                        }
                        if (str != null) {
                            IAConfigManager.O.s.b(new com.fyber.inneractive.sdk.network.v0(new com.fyber.inneractive.sdk.network.e(str2, jSONArray, currentTimeMillis), str2, str));
                        }
                        fVar.b = new JSONArray();
                    }
                }
                b1 b1Var = fVar.d;
                if (b1Var != null) {
                    b1Var.removeMessages(12312329);
                    long j = fVar.e * 1000;
                    b1 b1Var2 = fVar.d;
                    if (b1Var2 != null) {
                        b1Var2.post(new com.fyber.inneractive.sdk.network.c(fVar, 12312329, j));
                    }
                }
            }
        }
    }
}
