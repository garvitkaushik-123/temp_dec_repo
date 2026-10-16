package com.fyber.inneractive.sdk.flow;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class u0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f1241a;
    public final r0 b;
    public final InneractiveAdRequest c;
    public final com.fyber.inneractive.sdk.response.g d;
    public final com.fyber.inneractive.sdk.model.vast.b e;
    public final JSONArray f;
    public final com.fyber.inneractive.sdk.config.global.features.u g;

    public u0(Context context, r0 r0Var) {
        com.fyber.inneractive.sdk.config.global.features.u uVar;
        JSONArray jSONArray;
        com.fyber.inneractive.sdk.config.global.r rVar = r0Var.c;
        InneractiveAdRequest inneractiveAdRequest = r0Var.f1249a;
        com.fyber.inneractive.sdk.response.g gVar = (com.fyber.inneractive.sdk.response.g) r0Var.b;
        com.fyber.inneractive.sdk.model.vast.b bVar = gVar.O;
        if (rVar != null) {
            uVar = (com.fyber.inneractive.sdk.config.global.features.u) rVar.a(com.fyber.inneractive.sdk.config.global.features.u.class);
            jSONArray = rVar.b();
        } else {
            uVar = null;
            jSONArray = null;
        }
        this.f1241a = context;
        this.b = r0Var;
        this.c = inneractiveAdRequest;
        this.d = gVar;
        this.e = bVar;
        this.g = uVar;
        this.f = jSONArray;
    }
}
