package com.fyber.inneractive.sdk.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.factories.h;
import com.fyber.inneractive.sdk.factories.i;
import com.fyber.inneractive.sdk.player.cache.m;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.s;
import com.fyber.inneractive.sdk.util.u;

/* loaded from: classes4.dex */
public class IAVideoKit extends BroadcastReceiver {
    private static final u sProvider = new a();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        u uVar = sProvider;
        IAConfigManager.O.J.put(uVar.getType(), uVar);
        m mVar = m.f;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            mVar.getClass();
            IAlog.f("context is null, would not start the video cache.", new Object[0]);
        } else if (!mVar.c || !s.a()) {
            mVar.f1355a = applicationContext;
            new Thread(mVar.e, "VideoCache").start();
        }
        IAlog.a("IAVideoKit: onReceive in package: %s", context.getApplicationContext().getPackageName());
        com.fyber.inneractive.sdk.factories.d.f1171a.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST, new b());
        i iVar = h.f1173a;
        iVar.f1174a.add(new c());
        com.fyber.inneractive.sdk.factories.c cVar = com.fyber.inneractive.sdk.factories.b.f1169a;
        cVar.f1170a.add(new d());
    }
}
