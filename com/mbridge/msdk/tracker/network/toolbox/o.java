package com.mbridge.msdk.tracker.network.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.tracker.network.u;
import com.mbridge.msdk.tracker.network.w;

/* compiled from: Volley.java */
/* loaded from: classes6.dex */
public class o {
    public static u a(com.mbridge.msdk.tracker.network.m mVar, w wVar, int i, com.mbridge.msdk.tracker.network.b bVar) {
        if (mVar == null) {
            mVar = new b(new h());
        }
        if (wVar == null) {
            wVar = new com.mbridge.msdk.tracker.network.f(new Handler(Looper.getMainLooper()));
        }
        if (i <= 0) {
            i = 4;
        }
        if (bVar == null) {
            bVar = new l();
        }
        return new u(mVar, wVar, i, bVar);
    }
}
