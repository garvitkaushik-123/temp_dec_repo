package com.fyber.inneractive.sdk.metrics;

import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;
import java.util.HashMap;
import org.json.JSONArray;

/* loaded from: classes4.dex */
public final class c extends a {
    public static final String g = String.valueOf(24);
    public static final String h = String.valueOf(3);
    public static final String i = String.valueOf(24);
    public static final String j = String.valueOf(3);
    public final String b;
    public final UnitDisplayType c;
    public final com.fyber.inneractive.sdk.response.e d;
    public final InneractiveAdRequest e;
    public final JSONArray f;

    public c(com.fyber.inneractive.sdk.response.e eVar, InneractiveAdRequest inneractiveAdRequest, String str, UnitDisplayType unitDisplayType, JSONArray jSONArray) {
        super("send_metric_report");
        this.d = eVar;
        this.e = inneractiveAdRequest;
        this.b = str;
        this.c = unitDisplayType;
        this.f = jSONArray;
    }

    public final void a() {
        d dVar = d.d;
        g a2 = dVar.a(this.b);
        HashMap j2 = a2.j();
        if (!a2.a()) {
            IAlog.a("MetricCreativeReporter: Metric data not valid, data: %s", dVar.a(this.b).toString());
            return;
        }
        dVar.f1276a.remove(this.b);
        r.f1777a.execute(new b(this, a2, j2));
    }
}
