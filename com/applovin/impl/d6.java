package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import com.applovin.impl.b6;
import com.applovin.impl.mediation.MaxAdWaterfallInfoImpl;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.MaxNetworkResponseInfoImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxErrorCode;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class d6 extends g5 {
    private static final AtomicBoolean o = new AtomicBoolean();
    private final x2 g;
    private final JSONObject h;
    private final List i;
    private final a.InterfaceC0097a j;
    private final WeakReference k;
    private final String l;
    private long m;
    private final List n;

    private class b extends g5 {
        private final long g;
        private final int h;
        private final v2 i;
        private final List j;

        class a extends f3 {
            final /* synthetic */ MaxAdFormat b;
            final /* synthetic */ String c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(a.InterfaceC0097a interfaceC0097a, MaxAdFormat maxAdFormat, String str) {
                super(interfaceC0097a);
                this.b = maxAdFormat;
                this.c = str;
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoadFailed(String str, MaxError maxError) {
                long elapsedRealtime = SystemClock.elapsedRealtime() - b.this.g;
                com.applovin.impl.sdk.o unused = b.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    b.this.c.a(b.this.b, "Ad failed to load in " + elapsedRealtime + " ms for " + this.b.getLabel() + " ad unit " + str + " with error: " + maxError);
                }
                b.this.b("failed to load ad: " + maxError.getCode());
                b bVar = b.this;
                bVar.a(bVar.i, MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD, elapsedRealtime, maxError);
                if (b.this.h >= b.this.j.size() - 1) {
                    d6.this.b(new MaxErrorImpl(-5001, "MAX returned eligible ads from mediated networks, but all ads failed to load. Inspect getWaterfall() for more info."));
                } else {
                    b bVar2 = b.this;
                    b.this.f464a.r0().a((g5) new b(bVar2.h + 1, b.this.j), b6.b.MEDIATION);
                }
            }

            @Override // com.applovin.mediation.MaxAdListener
            public void onAdLoaded(MaxAd maxAd) {
                b.this.b("loaded ad");
                long elapsedRealtime = SystemClock.elapsedRealtime() - b.this.g;
                com.applovin.impl.sdk.o unused = b.this.c;
                if (com.applovin.impl.sdk.o.a()) {
                    b.this.c.a(b.this.b, "Ad loaded in " + elapsedRealtime + "ms for " + this.b.getLabel() + " ad unit " + this.c);
                }
                v2 v2Var = (v2) maxAd;
                b.this.a(v2Var, MaxNetworkResponseInfo.AdLoadState.AD_LOADED, elapsedRealtime, null);
                int i = b.this.h;
                while (true) {
                    i++;
                    if (i >= b.this.j.size()) {
                        d6.this.b(v2Var);
                        return;
                    } else {
                        b bVar = b.this;
                        bVar.a((v2) bVar.j.get(i), MaxNetworkResponseInfo.AdLoadState.AD_LOAD_NOT_ATTEMPTED, -1L, null);
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(String str) {
        }

        @Override // java.lang.Runnable
        public void run() {
            String b = d6.this.g.b();
            MaxAdFormat a2 = d6.this.g.a();
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Loading ad " + (this.h + 1) + " of " + this.j.size() + " from " + this.i.c() + " for " + a2.getLabel() + " ad unit " + b);
            }
            b("started to load ad");
            Context context = (Context) d6.this.k.get();
            Activity v0 = context instanceof Activity ? (Activity) context : this.f464a.v0();
            this.f464a.a0().b(this.i);
            this.f464a.X().loadThirdPartyMediatedAd(b, this.i, v0, new a(d6.this.j, a2, b));
        }

        private b(int i, List list) {
            super(d6.this.b, d6.this.f464a, d6.this.g.b());
            this.g = SystemClock.elapsedRealtime();
            this.h = i;
            this.i = (v2) list.get(i);
            this.j = list;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(v2 v2Var, MaxNetworkResponseInfo.AdLoadState adLoadState, long j, MaxError maxError) {
            d6.this.n.add(new MaxNetworkResponseInfoImpl(adLoadState, t3.a(v2Var.b()), v2Var.F(), v2Var.U(), j, v2Var.C(), maxError));
        }
    }

    public d6(x2 x2Var, JSONObject jSONObject, Context context, com.applovin.impl.sdk.k kVar, a.InterfaceC0097a interfaceC0097a) {
        super("TaskProcessMediationWaterfall", kVar, x2Var.b());
        this.g = x2Var;
        this.h = jSONObject;
        this.j = interfaceC0097a;
        this.k = new WeakReference(context);
        this.l = JsonUtils.getString(jSONObject, "mcode", "");
        JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS, new JSONArray());
        this.i = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            this.i.add(v2.a(x2Var, JsonUtils.getJSONObject(jSONArray, i, (JSONObject) null), jSONObject, kVar));
        }
        this.n = new ArrayList(this.i.size());
    }

    @Override // java.lang.Runnable
    public void run() {
        final MaxErrorImpl maxErrorImpl;
        this.m = SystemClock.elapsedRealtime();
        int i = 0;
        if (this.h.optBoolean("is_testing", false) && !this.f464a.t0().c() && o.compareAndSet(false, true)) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.d6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    d6.this.e();
                }
            });
        }
        String b2 = this.g.b();
        MaxAdFormat a2 = this.g.a();
        if (this.i.size() > 0) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Starting waterfall for " + a2.getLabel() + " ad unit " + b2 + " with " + this.i.size() + " ad(s)...");
            }
            this.f464a.r0().a(new b(i, this.i));
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.k(this.b, "No ads were returned from the server for " + a2.getLabel() + " ad unit " + b2);
        }
        k7.a(b2, a2, this.h, this.f464a);
        JSONObject jSONObject = JsonUtils.getJSONObject(this.h, "settings", new JSONObject());
        long j = JsonUtils.getLong(jSONObject, "alfdcs", 0L);
        if (t3.a(this.h, b2, this.f464a)) {
            maxErrorImpl = new MaxErrorImpl(MaxErrorCode.INVALID_AD_UNIT_ID, "Ad Unit ID " + b2 + " is invalid or disabled.\nMake sure to use an Ad Unit ID from the MAX dashboard that is enabled and configured for the current application.\nFor more information, see https://developers.applovin.com/en/getting-started#step-2-create-an-ad-unit\nNote: New ad units cannot load ads until 30-60 minutes after they are created");
            if (k7.c(this.f464a) && ((Boolean) this.f464a.a(v4.o6)).booleanValue()) {
                j = 0;
            }
        } else {
            maxErrorImpl = new MaxErrorImpl(204, "MAX returned no eligible ads from any mediated networks for this app/device");
        }
        if (j <= 0) {
            b(maxErrorImpl);
            return;
        }
        long millis = TimeUnit.SECONDS.toMillis(j);
        Runnable runnable = new Runnable() { // from class: com.applovin.impl.d6$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                d6.this.b(maxErrorImpl);
            }
        };
        if (JsonUtils.getBoolean(jSONObject, "alfdcs_iba", Boolean.FALSE).booleanValue()) {
            g0.a(millis, this.f464a, runnable);
        } else {
            AppLovinSdkUtils.runOnUiThreadDelayed(runnable, millis);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        k7.a("MAX SDK Not Initialized In Test Mode", "Test ads may not load. Please force close and restart the app if you experience issues.", this.f464a.v0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(v2 v2Var) {
        this.f464a.a0().c(v2Var);
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.m;
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d(this.b, "Waterfall loaded in " + elapsedRealtime + "ms from " + v2Var.c() + " for " + this.g.a().getLabel() + " ad unit " + this.g.b());
        }
        v2Var.a(new MaxAdWaterfallInfoImpl(v2Var, elapsedRealtime, this.n, this.l));
        q2.f(this.j, v2Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(MaxError maxError) {
        ArrayList arrayList = new ArrayList(this.n.size());
        for (MaxNetworkResponseInfo maxNetworkResponseInfo : this.n) {
            if (maxNetworkResponseInfo.getAdLoadState() == MaxNetworkResponseInfo.AdLoadState.FAILED_TO_LOAD) {
                arrayList.add(maxNetworkResponseInfo);
            }
        }
        if (arrayList.size() > 0) {
            StringBuilder sb = new StringBuilder("======FAILED AD LOADS======\n");
            int i = 0;
            while (i < arrayList.size()) {
                MaxNetworkResponseInfo maxNetworkResponseInfo2 = (MaxNetworkResponseInfo) arrayList.get(i);
                i++;
                sb.append(i).append(") ").append(maxNetworkResponseInfo2.getMediatedNetwork().getName()).append("\n..code: ").append(maxNetworkResponseInfo2.getError().getCode()).append("\n..message: ").append(maxNetworkResponseInfo2.getError().getMessage()).append("\n");
            }
            ((MaxErrorImpl) maxError).setAdLoadFailureInfo(sb.toString());
        }
        String b2 = this.g.b();
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.m;
        if (com.applovin.impl.sdk.o.a()) {
            this.c.d(this.b, "Waterfall failed in " + elapsedRealtime + "ms for " + this.g.a().getLabel() + " ad unit " + b2 + " with error: " + maxError);
        }
        ((MaxErrorImpl) maxError).setWaterfall(new MaxAdWaterfallInfoImpl(null, JsonUtils.getString(this.h, "waterfall_name", ""), JsonUtils.getString(this.h, "waterfall_test_name", ""), elapsedRealtime, this.n, this.g, JsonUtils.optList(JsonUtils.getJSONArray(this.h, "mwf_info_urls", null), Collections.EMPTY_LIST), this.l, JsonUtils.getString(this.h, "event_id", "")));
        q2.a(this.j, b2, maxError);
    }
}
