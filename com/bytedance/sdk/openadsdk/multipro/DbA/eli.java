package com.bytedance.sdk.openadsdk.multipro.DbA;

import org.json.JSONObject;

/* loaded from: classes3.dex */
public class eli {
    public boolean DbA;
    public long MGA;
    public boolean Os;
    public boolean aGH;
    public boolean eli;
    public long kb;
    public long ui;

    /* renamed from: com.bytedance.sdk.openadsdk.multipro.DbA.eli$eli, reason: collision with other inner class name */
    public interface InterfaceC0210eli {
        eli MGA();
    }

    public eli eli(boolean z) {
        this.aGH = z;
        return this;
    }

    public eli DbA(boolean z) {
        this.eli = z;
        return this;
    }

    public eli Os(boolean z) {
        this.DbA = z;
        return this;
    }

    public eli aGH(boolean z) {
        this.Os = z;
        return this;
    }

    public eli eli(long j) {
        this.ui = j;
        return this;
    }

    public eli DbA(long j) {
        this.MGA = j;
        return this;
    }

    public eli Os(long j) {
        this.kb = j;
        return this;
    }

    public JSONObject eli() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("isCompleted", this.eli);
            jSONObject.put("isFromVideoDetailPage", this.DbA);
            jSONObject.put("isFromDetailPage", this.Os);
            jSONObject.put("duration", this.ui);
            jSONObject.put("totalPlayDuration", this.MGA);
            jSONObject.put("currentPlayPosition", this.kb);
            jSONObject.put("isAutoPlay", this.aGH);
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public static eli eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        eli eliVar = new eli();
        eliVar.DbA(jSONObject.optBoolean("isCompleted"));
        eliVar.Os(jSONObject.optBoolean("isFromVideoDetailPage"));
        eliVar.aGH(jSONObject.optBoolean("isFromDetailPage"));
        eliVar.eli(jSONObject.optLong("duration"));
        eliVar.DbA(jSONObject.optLong("totalPlayDuration"));
        eliVar.Os(jSONObject.optLong("currentPlayPosition"));
        eliVar.eli(jSONObject.optBoolean("isAutoPlay"));
        return eliVar;
    }
}
