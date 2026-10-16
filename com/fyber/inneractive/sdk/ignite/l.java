package com.fyber.inneractive.sdk.ignite;

import android.content.Context;
import com.digitalturbine.ignite.authenticator.IgniteManager;

/* loaded from: classes4.dex */
public final class l extends IgniteManager {
    public l(Context context, k kVar, com.fyber.inneractive.sdk.ignite.events.wrappers.a aVar, boolean z, boolean z2, boolean z3, h hVar) {
        super(kVar, aVar);
        l lVar;
        com.digitalturbine.ignite.authenticator.decorator.f gVar;
        com.digitalturbine.ignite.authenticator.decorator.e eVar = new com.digitalturbine.ignite.authenticator.decorator.e(context);
        if (z && z2) {
            gVar = new com.digitalturbine.ignite.authenticator.decorator.h(new com.digitalturbine.ignite.authenticator.decorator.g(eVar, hVar), true, z3, hVar, this);
            lVar = this;
        } else if (z) {
            lVar = this;
            gVar = new com.digitalturbine.ignite.authenticator.decorator.h(eVar, false, z3, hVar, lVar);
        } else {
            lVar = this;
            gVar = z2 ? new com.digitalturbine.ignite.authenticator.decorator.g(eVar, hVar) : new com.digitalturbine.ignite.authenticator.decorator.i(eVar, hVar);
        }
        lVar.f984a = gVar;
    }
}
