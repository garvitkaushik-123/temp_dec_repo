package com.fyber.inneractive.sdk.util;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes4.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f1787a = new CopyOnWriteArrayList();
    public boolean b;
    public Context c;
    public w d;

    public static void a(z zVar, Context context, Intent intent) {
        boolean z;
        synchronized (zVar) {
            try {
                z = ((KeyguardManager) context.getSystemService("keyguard")).isKeyguardLocked();
            } catch (Exception unused) {
                IAlog.a("%sFailed to get lock screen status", IAlog.a(zVar));
                z = false;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                zVar.b = true;
            } else if (("android.intent.action.SCREEN_ON".equals(intent.getAction()) && !z) || "android.intent.action.USER_PRESENT".equals(intent.getAction())) {
                zVar.b = false;
            }
            IAlog.a("%sNew screen state is locked: %s. number of listeners: %d", IAlog.a(zVar), Boolean.valueOf(zVar.b), Integer.valueOf(zVar.f1787a.size()));
            Iterator it = zVar.f1787a.iterator();
            while (it.hasNext()) {
                y yVar = (y) it.next();
                boolean z2 = zVar.b;
                com.fyber.inneractive.sdk.renderers.k kVar = (com.fyber.inneractive.sdk.renderers.k) yVar;
                kVar.getClass();
                IAlog.a("%sgot onLockScreenStateChanged with: %s", IAlog.a(kVar), Boolean.valueOf(z2));
                if (z2) {
                    kVar.c(false);
                    com.fyber.inneractive.sdk.renderers.d dVar = kVar.y;
                    if (dVar != null && dVar.g) {
                        dVar.g = false;
                        r.b.removeCallbacks(dVar.j);
                    }
                } else {
                    kVar.K();
                    com.fyber.inneractive.sdk.renderers.d dVar2 = kVar.y;
                    if (dVar2 != null && !dVar2.h && !dVar2.g && dVar2.f != 0) {
                        dVar2.f = 0L;
                        dVar2.g = true;
                        dVar2.a();
                    }
                }
            }
        }
    }
}
