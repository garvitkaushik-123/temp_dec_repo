package com.fyber.inneractive.sdk.metrics;

import android.app.Application;
import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.o;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.t;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f1275a;
    public final /* synthetic */ Map b;
    public final /* synthetic */ c c;

    public b(c cVar, g gVar, Map map) {
        this.c = cVar;
        this.f1275a = gVar;
        this.b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        UnitDisplayType unitDisplayType;
        int a2;
        int a3;
        String str;
        IAlog.a("MetricCreativeReporter: sendMetricEvent()", new Object[0]);
        c cVar = this.c;
        UnitDisplayType unitDisplayType2 = cVar.c;
        if (unitDisplayType2 == null || !(unitDisplayType2 == (unitDisplayType = UnitDisplayType.BANNER) || unitDisplayType2 == UnitDisplayType.MRECT || unitDisplayType2.isFullscreenUnit())) {
            UnitDisplayType unitDisplayType3 = cVar.c;
            IAlog.a("Unit display type %s is not supported for metric event", unitDisplayType3 != null ? unitDisplayType3.value() : "");
            return;
        }
        IAlog.a("MetricCreativeReporter: sendMetricEvent(), collectorData: data: %s", this.f1275a.toString());
        o oVar = IAConfigManager.O.u.b;
        UnitDisplayType unitDisplayType4 = this.c.c;
        if (unitDisplayType4 == unitDisplayType || unitDisplayType4 == UnitDisplayType.MRECT) {
            String a4 = oVar.a("ad_metrics_interval_banner", c.g);
            String a5 = oVar.a("ad_metrics_limit_banner", c.h);
            a2 = t.a(a4, 24);
            a3 = t.a(a5, 3);
            str = "LastSentMetricsBanner";
        } else {
            String a6 = oVar.a("ad_metrics_interval_interstitial", c.i);
            String a7 = oVar.a("ad_metrics_limit_interstitial", c.j);
            a2 = t.a(a6, 24);
            a3 = t.a(a7, 3);
            str = "LastSentMetricsInterstitial";
        }
        Application application = com.fyber.inneractive.sdk.util.o.f1770a;
        if (application != null) {
            SharedPreferences sharedPreferences = application.getSharedPreferences("IAConfigPrefs", 0);
            JSONArray jSONArray = new JSONArray();
            try {
                jSONArray = new JSONArray(sharedPreferences.getString(str, "[]"));
            } catch (JSONException unused) {
            }
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            if (oVar.a(false, this.c.f1274a) && !a.a(a2, a3, jSONArray, copyOnWriteArrayList)) {
                copyOnWriteArrayList.add(Long.valueOf(System.currentTimeMillis()));
                c cVar2 = this.c;
                InneractiveAdRequest inneractiveAdRequest = cVar2.e;
                com.fyber.inneractive.sdk.response.e eVar = cVar2.d;
                Map map = this.b;
                try {
                    u uVar = u.METRIC_MEASUREMENTS_EVENT;
                    JSONArray jSONArray2 = cVar2.f;
                    w wVar = new w(eVar);
                    wVar.c = uVar;
                    wVar.f1340a = inneractiveAdRequest;
                    wVar.d = jSONArray2;
                    JSONObject jSONObject = new JSONObject();
                    for (String str2 : map.keySet()) {
                        Object obj = map.get(str2);
                        try {
                            jSONObject.put(str2, obj);
                        } catch (Exception unused2) {
                            IAlog.f("Got exception adding param to json object: %s, %s", str2, obj);
                        }
                    }
                    wVar.f.put(jSONObject);
                    wVar.a((String) null);
                } catch (Exception unused3) {
                }
            }
            sharedPreferences.edit().putString(str, new JSONArray((Collection) copyOnWriteArrayList).toString()).apply();
        }
    }
}
