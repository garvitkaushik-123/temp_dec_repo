package com.ironsource.mediationsdk.logger;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3260q4;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes6.dex */
class c {

    /* renamed from: a, reason: collision with root package name */
    private IronSourceLogger.IronSourceTag f3547a;
    private String b;
    private String c;
    private int d;

    public c(IronSourceLogger.IronSourceTag ironSourceTag, String str, String str2, int i) {
        this.f3547a = ironSourceTag;
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    public int a() {
        return this.d;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", this.b);
            jSONObject.put("tag", this.f3547a);
            jSONObject.put("level", this.d);
            jSONObject.put(PglCryptUtils.KEY_MESSAGE, this.c);
            return jSONObject;
        } catch (JSONException e) {
            C3260q4.d().a(e);
            IronLog.INTERNAL.error(e.toString());
            return jSONObject;
        }
    }
}
