package com.fyber.inneractive.sdk;

import android.app.Activity;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.dv.i;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.network.w;

/* loaded from: classes4.dex */
public abstract class a extends com.fyber.inneractive.sdk.dv.a {
    public com.fyber.inneractive.sdk.dv.interstitial.a j;

    public a(s0 s0Var, r rVar, i iVar) {
        super(s0Var, rVar, iVar);
        this.j = null;
    }

    public abstract void a(com.fyber.inneractive.sdk.dv.interstitial.a aVar, Activity activity);

    public final void h() {
        try {
            new w(u.EVENT_READY_ON_CLIENT, this.f1249a, (i) this.b).a((String) null);
        } catch (Exception unused) {
        }
    }
}
