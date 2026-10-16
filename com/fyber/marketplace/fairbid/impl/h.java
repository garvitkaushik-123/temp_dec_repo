package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final String f1839a;
    public final com.fyber.inneractive.sdk.response.a b;
    public final Map c;

    public h(JSONObject jSONObject, com.fyber.inneractive.sdk.response.a aVar, Map map) {
        try {
            this.f1839a = jSONObject.getJSONObject("ad").optString("markup");
        } catch (JSONException e) {
            IAlog.a("Failed extracting markup", e, new Object[0]);
        }
        this.b = aVar;
        this.c = map;
    }
}
