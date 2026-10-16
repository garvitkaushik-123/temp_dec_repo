package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class f extends com.fyber.inneractive.sdk.metrics.a {
    public static final String e = String.valueOf(24);
    public static final String f = String.valueOf(1);
    public final com.fyber.inneractive.sdk.response.e b;
    public final InneractiveAdRequest c;
    public final JSONArray d;

    public f(com.fyber.inneractive.sdk.response.e eVar, InneractiveAdRequest inneractiveAdRequest, String str, JSONArray jSONArray) {
        super(str);
        this.b = eVar;
        this.c = inneractiveAdRequest;
        this.d = jSONArray;
    }
}
