package com.fyber.inneractive.sdk.util;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public InneractiveAdSpot f1750a;
    public boolean c;
    public boolean b = false;
    public long d = 0;
    public long e = 0;
    public long f = 0;

    public final void a(boolean z) {
        this.c = z;
        if (this.b) {
            IAlog.a("%s%s timer could not start. Timer is in action!", "AdExperienceLatency: ", z ? "skip" : "close");
            return;
        }
        IAlog.a("%s%s timer started", "AdExperienceLatency: ", z ? "skip" : "close");
        this.d = System.currentTimeMillis();
        this.b = true;
    }

    public final void a(String str) {
        com.fyber.inneractive.sdk.config.global.r rVar;
        if (this.b) {
            long currentTimeMillis = (System.currentTimeMillis() - this.d) - this.f;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            long seconds = timeUnit.toSeconds(currentTimeMillis);
            long millis = timeUnit.toMillis(currentTimeMillis - TimeUnit.SECONDS.toMillis(seconds));
            Locale locale = Locale.US;
            String str2 = seconds + "." + millis;
            InneractiveAdSpot inneractiveAdSpot = this.f1750a;
            com.fyber.inneractive.sdk.flow.x adContent = inneractiveAdSpot != null ? inneractiveAdSpot.getAdContent() : null;
            com.fyber.inneractive.sdk.network.u uVar = this.c ? com.fyber.inneractive.sdk.network.u.USER_SKIP_ACTION_LATENCY : com.fyber.inneractive.sdk.network.u.USER_CLOSE_ACTION_LATENCY;
            InneractiveAdRequest inneractiveAdRequest = adContent != null ? adContent.f1249a : null;
            com.fyber.inneractive.sdk.response.e c = adContent != null ? adContent.c() : null;
            JSONArray b = (adContent == null || (rVar = adContent.c) == null) ? null : rVar.b();
            com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(c);
            wVar.c = uVar;
            wVar.f1340a = inneractiveAdRequest;
            wVar.d = b;
            JSONObject jSONObject = new JSONObject();
            String str3 = this.c ? "skip_action_latency" : "close_action_latency";
            try {
                jSONObject.put(str3, str2);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", str3, str2);
            }
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put("origin", str);
                } catch (Exception unused2) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "origin", str);
                }
            }
            wVar.f.put(jSONObject);
            wVar.a((String) null);
            this.d = 0L;
            this.e = 0L;
            this.f = 0L;
            this.b = false;
        }
    }
}
