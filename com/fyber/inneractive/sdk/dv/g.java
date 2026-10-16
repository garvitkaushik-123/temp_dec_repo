package com.fyber.inneractive.sdk.dv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class g extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        IAlog.a("DVKit: onReceive in package: %s", context.getApplicationContext().getPackageName());
        com.fyber.inneractive.sdk.factories.d.f1171a.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MOBILE_ADS, new d());
        com.fyber.inneractive.sdk.factories.i iVar = com.fyber.inneractive.sdk.factories.h.f1173a;
        iVar.f1174a.add(new e());
        com.fyber.inneractive.sdk.factories.c cVar = com.fyber.inneractive.sdk.factories.b.f1169a;
        cVar.f1170a.add(new f(this));
    }
}
