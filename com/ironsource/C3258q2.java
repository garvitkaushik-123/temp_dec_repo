package com.ironsource;

import android.text.TextUtils;
import com.ironsource.C3258q2;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ironsource.q2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3258q2 extends ig {
    private final V0 e;
    private final AbstractC3340v0 f;
    private final C3274r2 g;
    private final Fc h;
    private InterfaceC3291s2 i;

    /* renamed from: com.ironsource.q2$a */
    public static final class a implements InterfaceC3291s2 {
        final /* synthetic */ C b;
        final /* synthetic */ jg c;

        a(C c, jg jgVar) {
            this.b = c;
            this.c = jgVar;
        }

        @Override // com.ironsource.InterfaceC3291s2
        public void a(final List<C3207n2> newWaterfall, final Map<String, G> adInstancePayloads, final String auctionId, final C3207n2 c3207n2, final JSONObject jSONObject, final JSONObject jSONObject2, final int i, final long j, final int i2, final String str) {
            Intrinsics.checkNotNullParameter(newWaterfall, "newWaterfall");
            Intrinsics.checkNotNullParameter(adInstancePayloads, "adInstancePayloads");
            Intrinsics.checkNotNullParameter(auctionId, "auctionId");
            V0 v0 = C3258q2.this.e;
            final C3258q2 c3258q2 = C3258q2.this;
            final C c = this.b;
            final jg jgVar = this.c;
            v0.a(new Runnable() { // from class: com.ironsource.q2$a$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    C3258q2.a.a(C3258q2.this, c, jgVar, newWaterfall, adInstancePayloads, auctionId, c3207n2, jSONObject, jSONObject2, i, j, i2, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(C3258q2 this$0, C adInstanceFactory, jg waterfallFetcherListener, List newWaterfall, Map adInstancePayloads, String auctionId, C3207n2 c3207n2, JSONObject jSONObject, JSONObject jSONObject2, int i, long j, int i2, String str) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(adInstanceFactory, "$adInstanceFactory");
            Intrinsics.checkNotNullParameter(waterfallFetcherListener, "$waterfallFetcherListener");
            Intrinsics.checkNotNullParameter(newWaterfall, "$newWaterfall");
            Intrinsics.checkNotNullParameter(adInstancePayloads, "$adInstancePayloads");
            Intrinsics.checkNotNullParameter(auctionId, "$auctionId");
            this$0.i = null;
            this$0.a(adInstanceFactory, waterfallFetcherListener, newWaterfall, adInstancePayloads, auctionId, c3207n2, jSONObject, jSONObject2, i, j, i2, str);
        }

        @Override // com.ironsource.InterfaceC3291s2
        public void a(final int i, final String str, final int i2, final String auctionFallback, final long j) {
            Intrinsics.checkNotNullParameter(auctionFallback, "auctionFallback");
            V0 v0 = C3258q2.this.e;
            final C3258q2 c3258q2 = C3258q2.this;
            final C c = this.b;
            final jg jgVar = this.c;
            v0.a(new Runnable() { // from class: com.ironsource.q2$a$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C3258q2.a.a(C3258q2.this, c, jgVar, i, str, i2, auctionFallback, j);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(C3258q2 this$0, C adInstanceFactory, jg waterfallFetcherListener, int i, String str, int i2, String auctionFallback, long j) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(adInstanceFactory, "$adInstanceFactory");
            Intrinsics.checkNotNullParameter(waterfallFetcherListener, "$waterfallFetcherListener");
            Intrinsics.checkNotNullParameter(auctionFallback, "$auctionFallback");
            this$0.i = null;
            this$0.a(adInstanceFactory, waterfallFetcherListener, i, str, i2, auctionFallback, j);
        }

        @Override // com.ironsource.InterfaceC3291s2
        public void a(int i, String errorReason) {
            Intrinsics.checkNotNullParameter(errorReason, "errorReason");
            this.c.a(i, errorReason);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3258q2(V0 adTools, AbstractC3340v0 adUnitData) {
        super(adTools, adUnitData);
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        this.e = adTools;
        this.f = adUnitData;
        C3274r2 c3274r2 = new C3274r2(adTools, adUnitData);
        this.g = c3274r2;
        this.h = c3274r2.b();
    }

    @Override // com.ironsource.ig
    public Fc a() {
        return this.h;
    }

    @Override // com.ironsource.ig
    public void a(C adInstanceFactory, jg waterfallFetcherListener) {
        Intrinsics.checkNotNullParameter(adInstanceFactory, "adInstanceFactory");
        Intrinsics.checkNotNullParameter(waterfallFetcherListener, "waterfallFetcherListener");
        a aVar = new a(adInstanceFactory, waterfallFetcherListener);
        this.g.a(aVar);
        this.i = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(C c, jg jgVar, List<C3207n2> list, Map<String, G> map, String str, C3207n2 c3207n2, JSONObject jSONObject, JSONObject jSONObject2, int i, long j, int i2, String str2) {
        IronLog.INTERNAL.verbose(C3205n0.a(this.e, (String) null, (String) null, 3, (Object) null));
        C3156k2 c3156k2 = new C3156k2(str, jSONObject, c3207n2, i, "");
        if (!TextUtils.isEmpty(str2)) {
            this.e.e().h().a(i2, str2);
        }
        a(jSONObject2);
        kg a2 = a(list, map, c3156k2, c);
        this.e.e().a(new U1(c3156k2));
        this.e.e().b().a(j, this.f.v() + ";wtf=" + a2.c());
        this.e.e().b().c(a2.d());
        a(a2, jgVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(C c, jg jgVar, int i, String str, int i2, String str2, long j) {
        IronLog.INTERNAL.verbose(C3205n0.a(this.e, "Auction failed (error " + i + " - " + str + ")", (String) null, 2, (Object) null));
        boolean n = this.f.e().n();
        String a2 = Y1.f3135a.a(n);
        C3156k2 c3156k2 = new C3156k2(a2, null, null, i2, str2);
        B5 e = this.e.e();
        e.a(new U1(c3156k2));
        e.b().a(j, i, str);
        if (n) {
            a(c, jgVar, i2, str2, a2);
        } else {
            a(jgVar);
        }
    }

    private final void a(kg kgVar, jg jgVar) {
        this.e.h().a(kgVar);
        jgVar.a(kgVar);
    }

    private final void a(JSONObject jSONObject) {
        int i;
        try {
            if (jSONObject == null) {
                this.f.b(false);
                IronLog.INTERNAL.verbose(C3205n0.a(this.e, "loading configuration from auction response is null, using the following: " + this.f.v(), (String) null, 2, (Object) null));
                return;
            }
            try {
                if (jSONObject.has(com.ironsource.mediationsdk.d.x) && (i = jSONObject.getInt(com.ironsource.mediationsdk.d.x)) > 0) {
                    this.f.a(i);
                }
                if (jSONObject.has(com.ironsource.mediationsdk.d.y)) {
                    this.f.a(jSONObject.getBoolean(com.ironsource.mediationsdk.d.y));
                }
                this.f.b(jSONObject.optBoolean(com.ironsource.mediationsdk.d.z, false));
            } catch (JSONException e) {
                C3260q4.d().a(e);
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("failed to update loading configuration for" + this.f.b().a() + " Error: " + e.getMessage());
                ironLog.verbose(C3205n0.a(this.e, this.f.v(), (String) null, 2, (Object) null));
            }
        } finally {
            IronLog.INTERNAL.verbose(C3205n0.a(this.e, this.f.v(), (String) null, 2, (Object) null));
        }
    }

    private final void a(C c, jg jgVar, int i, String str, String str2) {
        IronLog.INTERNAL.verbose(C3205n0.a(this.e, "Moving to fallback waterfall", (String) null, 2, (Object) null));
        new C3217nc(this.e, this.f).a(jgVar, i, str, str2, c);
    }

    private final void a(jg jgVar) {
        jgVar.a(509, "Mediation No fill");
    }
}
