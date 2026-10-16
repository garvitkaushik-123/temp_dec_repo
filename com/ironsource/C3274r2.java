package com.ironsource;

import com.ironsource.Q1;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.r2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3274r2 {

    /* renamed from: a, reason: collision with root package name */
    private final V0 f3666a;
    private final AbstractC3340v0 b;
    private final com.ironsource.mediationsdk.e c;
    private final C3055e2 d;

    /* renamed from: com.ironsource.r2$a */
    public static final class a implements Q1.d {
        final /* synthetic */ InterfaceC3291s2 b;

        a(InterfaceC3291s2 interfaceC3291s2) {
            this.b = interfaceC3291s2;
        }

        @Override // com.ironsource.Q1.d
        public void a(Q1 auction) {
            Intrinsics.checkNotNullParameter(auction, "auction");
            C3274r2.this.b(auction, this.b);
        }

        @Override // com.ironsource.Q1.d
        public void a(Q1 auction, String error) {
            Intrinsics.checkNotNullParameter(auction, "auction");
            Intrinsics.checkNotNullParameter(error, "error");
            C3274r2.this.b(auction, this.b);
        }
    }

    public C3274r2(V0 adTools, AbstractC3340v0 adUnitData) {
        Intrinsics.checkNotNullParameter(adTools, "adTools");
        Intrinsics.checkNotNullParameter(adUnitData, "adUnitData");
        this.f3666a = adTools;
        this.b = adUnitData;
        C3241p2 e = adUnitData.e();
        String sessionId = IronSourceUtils.getSessionId();
        Intrinsics.checkNotNullExpressionValue(sessionId, "getSessionId()");
        com.ironsource.mediationsdk.e eVar = new com.ironsource.mediationsdk.e(new com.ironsource.mediationsdk.f(e, sessionId));
        this.c = eVar;
        this.d = new C3055e2(adTools, eVar);
    }

    public final C3055e2 b() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(Q1 q1, InterfaceC3291s2 interfaceC3291s2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("auction waterfallString = " + ((Object) q1.d().c())));
        if (!q1.g()) {
            ironLog.verbose(a("auction failed - no candidates"));
            this.f3666a.e().b().a(1005, "No candidates available for auctioning");
            interfaceC3291s2.a(C3408z0.e(this.b.b().a()), "no available ad to load");
        } else {
            this.f3666a.e().b().b(q1.d().c().toString());
            this.c.a(ContextProvider.getInstance().getApplicationContext(), a(q1, this.f3666a.f()), new b(interfaceC3291s2, q1));
        }
    }

    public void a(InterfaceC3291s2 completionListener) {
        Intrinsics.checkNotNullParameter(completionListener, "completionListener");
        IronLog.INTERNAL.verbose(a());
        this.f3666a.e().b().a(this.b.b().d());
        a(new Q1(this.f3666a, this.b), completionListener);
    }

    /* renamed from: com.ironsource.r2$b */
    public static final class b implements S1 {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ InterfaceC3291s2 f3668a;
        final /* synthetic */ Q1 b;

        b(InterfaceC3291s2 interfaceC3291s2, Q1 q1) {
            this.f3668a = interfaceC3291s2;
            this.b = q1;
        }

        @Override // com.ironsource.S1
        public void a(List<C3207n2> newWaterfall, String auctionId, C3207n2 c3207n2, JSONObject jSONObject, JSONObject jSONObject2, int i, long j, int i2, String str) {
            Intrinsics.checkNotNullParameter(newWaterfall, "newWaterfall");
            Intrinsics.checkNotNullParameter(auctionId, "auctionId");
            this.f3668a.a(newWaterfall, this.b.c(), auctionId, c3207n2, jSONObject, jSONObject2, i, j, i2, str);
        }

        @Override // com.ironsource.S1
        public void a(int i, String str, int i2, String auctionFallback, long j) {
            Intrinsics.checkNotNullParameter(auctionFallback, "auctionFallback");
            this.f3668a.a(i, str, i2, auctionFallback, j);
        }
    }

    private final void a(Q1 q1, InterfaceC3291s2 interfaceC3291s2) {
        if (!q1.f()) {
            b(q1, interfaceC3291s2);
        } else {
            q1.a(new a(interfaceC3291s2));
        }
    }

    private final com.ironsource.mediationsdk.i a(Q1 q1, int i) {
        com.ironsource.mediationsdk.i iVar = new com.ironsource.mediationsdk.i(this.b.b().a());
        iVar.b(IronSourceUtils.isEncryptedResponse());
        iVar.a(q1.d().a());
        iVar.a(q1.d().b());
        iVar.a(this.f3666a.h());
        iVar.a(i);
        iVar.a(this.f3666a.k());
        C3203mf g = this.b.b().g();
        iVar.e(g != null ? g.b() : false);
        iVar.a(this.b.b().d());
        InterfaceC3106h2 i2 = this.f3666a.i();
        if (i2 != null) {
            i2.a(iVar);
        }
        return iVar;
    }

    private final String a(String str) {
        return C3205n0.a(this.f3666a, str, (String) null, 2, (Object) null);
    }

    private final String a() {
        return C3205n0.a(this.f3666a, (String) null, (String) null, 2, (Object) null);
    }
}
