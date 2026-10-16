package com.fyber.inneractive.sdk.player.mediaplayer;

import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class j implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1630a;
    public final /* synthetic */ p b;

    public j(p pVar, int i) {
        this.b = pVar;
        this.f1630a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar = this.b;
        int i = this.f1630a;
        String b = pVar.b();
        long currentTimeMillis = System.currentTimeMillis();
        pVar.seekTo(i);
        IAlog.e(b + "timelog: seekTo took " + (System.currentTimeMillis() - currentTimeMillis) + " msec", new Object[0]);
    }
}
