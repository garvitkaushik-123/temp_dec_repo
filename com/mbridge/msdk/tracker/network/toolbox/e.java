package com.mbridge.msdk.tracker.network.toolbox;

import com.mbridge.msdk.tracker.network.t;

/* compiled from: DefaultCacheKeyGenerator.java */
/* loaded from: classes6.dex */
public class e implements com.mbridge.msdk.tracker.network.c {
    @Override // com.mbridge.msdk.tracker.network.c
    public String a(t<?> tVar) {
        String t = tVar.t();
        int g = tVar.g();
        return g == 0 ? t : Integer.toString(g) + '-' + t;
    }
}
