package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.ironsource.C3040d4;
import io.bidmachine.rendering.model.EventTaskParams;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class w0 {

    /* renamed from: a, reason: collision with root package name */
    private final JSONObject f774a;

    public enum a {
        NEUTRAL,
        POSITIVE,
        NEGATIVE
    }

    private w0(JSONObject jSONObject) {
        this.f774a = jSONObject;
    }

    public static w0 a(JSONObject jSONObject, com.applovin.impl.sdk.k kVar) {
        String string = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "title", (JSONObject) null), C3040d4.h.W, null);
        if ("TOS".equalsIgnoreCase(string) && kVar.y().h() == null) {
            return null;
        }
        if ("PP".equalsIgnoreCase(string) && kVar.y().f() == null) {
            return null;
        }
        return new w0(jSONObject);
    }

    public String b() {
        return JsonUtils.getString(this.f774a, "event", null);
    }

    public a c() {
        String string = JsonUtils.getString(this.f774a, "style", null);
        return EventTaskParams.STATE_GROUP_DEFAULT.equalsIgnoreCase(string) ? a.POSITIVE : ("destructive".equalsIgnoreCase(string) || "cancel".equalsIgnoreCase(string)) ? a.NEGATIVE : a.NEUTRAL;
    }

    public String d() {
        JSONObject jSONObject = JsonUtils.getJSONObject(this.f774a, "title", (JSONObject) null);
        return com.applovin.impl.sdk.k.a(JsonUtils.getString(jSONObject, C3040d4.h.W, ""), JsonUtils.optList(JsonUtils.getJSONArray(jSONObject, "replacements", null), null));
    }

    public String toString() {
        return "ConsentFlowStateAlertAction{title=" + d() + ", destinationStateId=" + a() + ", event=" + b() + "}";
    }

    public int a() {
        return JsonUtils.getInt(this.f774a, "destination_state_id", -1);
    }
}
