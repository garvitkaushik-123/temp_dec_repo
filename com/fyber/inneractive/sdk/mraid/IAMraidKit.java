package com.fyber.inneractive.sdk.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.flow.o0;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public class IAMraidKit extends BroadcastReceiver {
    private static final com.fyber.inneractive.sdk.util.u sProvider = new a();

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isMRaidSpotContent(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof o0);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IAlog.a("IAMraidKit: onReceive in package: %s", context.getApplicationContext().getPackageName());
        com.fyber.inneractive.sdk.util.u uVar = sProvider;
        IAConfigManager.O.J.put(uVar.getType(), uVar);
        b bVar = new b();
        com.fyber.inneractive.sdk.factories.f fVar = com.fyber.inneractive.sdk.factories.d.f1171a;
        fVar.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_HTML, bVar);
        fVar.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MRAID, bVar);
        com.fyber.inneractive.sdk.factories.i iVar = com.fyber.inneractive.sdk.factories.h.f1173a;
        iVar.f1174a.add(new c(this));
        com.fyber.inneractive.sdk.factories.c cVar = com.fyber.inneractive.sdk.factories.b.f1169a;
        cVar.f1170a.add(new d(this));
    }
}
