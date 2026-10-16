package com.applovin.impl;

import com.applovin.impl.b6;
import com.applovin.impl.l7;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.HashSet;

/* loaded from: classes2.dex */
class i6 extends g5 {
    private final p7 g;
    private final AppLovinAdLoadListener h;

    i6(p7 p7Var, AppLovinAdLoadListener appLovinAdLoadListener, com.applovin.impl.sdk.k kVar) {
        super("TaskRenderVastAd", kVar);
        this.h = appLovinAdLoadListener;
        this.g = p7Var;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Rendering VAST ad...");
        }
        int size = this.g.a().size();
        HashSet hashSet = new HashSet(size);
        HashSet hashSet2 = new HashSet(size);
        String str = "";
        u7 u7Var = null;
        y7 y7Var = null;
        o7 o7Var = null;
        n7 n7Var = null;
        String str2 = "";
        for (m8 m8Var : this.g.a()) {
            m8 b = m8Var.b(x7.b(m8Var) ? "Wrapper" : "InLine");
            if (b != null) {
                m8 b2 = b.b("AdSystem");
                if (b2 != null) {
                    u7Var = u7.a(b2, u7Var, this.f464a);
                }
                str = x7.a(b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.i, str);
                str2 = x7.a(b, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.k.j, str2);
                x7.a(b.a("Impression"), hashSet, this.g, this.f464a);
                m8 c = b.c("ViewableImpression");
                if (c != null) {
                    x7.a(c.a("Viewable"), hashSet, this.g, this.f464a);
                }
                m8 b3 = b.b("AdVerifications");
                if (b3 != null) {
                    n7Var = n7.a(b3, n7Var, this.g, this.f464a);
                }
                x7.a(b.a("Error"), hashSet2, this.g, this.f464a);
                m8 c2 = b.c("Creatives");
                if (c2 != null) {
                    for (m8 m8Var2 : c2.b()) {
                        m8 c3 = m8Var2.c("Linear");
                        if (c3 != null) {
                            y7Var = y7.a(c3, y7Var, this.g, this.f464a);
                        } else {
                            m8 b4 = m8Var2.b("CompanionAds");
                            if (b4 != null) {
                                m8 b5 = b4.b("Companion");
                                if (b5 != null) {
                                    o7Var = o7.a(b5, o7Var, this.g, this.f464a);
                                }
                            } else if (com.applovin.impl.sdk.o.a()) {
                                this.c.b(this.b, "Received and will skip rendering for an unidentified creative: " + m8Var2);
                            }
                        }
                    }
                }
            } else if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Did not find wrapper or inline response for node: " + m8Var);
            }
        }
        l7 a2 = new l7.b().a(this.f464a).a(this.g.b()).b(this.g.e()).a(this.g.c()).b(str).a(str2).a(u7Var).a(y7Var).a(o7Var).a(n7Var).b(hashSet).a(n7Var).a(hashSet2).a();
        q7 c4 = x7.c(a2);
        if (c4 != null) {
            x7.a(this.g, this.h, c4, -6, this.f464a);
            return;
        }
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Finished rendering VAST ad: " + a2);
        }
        a2.getAdEventTracker().e();
        this.f464a.r0().a((g5) new l5(a2, this.f464a, this.h), b6.b.CACHING);
    }
}
