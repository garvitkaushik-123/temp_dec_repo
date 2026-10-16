package com.fyber.inneractive.sdk.player.mediaplayer;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f1627a;

    public g(p pVar) {
        this.f1627a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p.b(this.f1627a);
        Handler handler = this.f1627a.o;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f1627a.o = null;
        }
        this.f1627a.n = null;
        Looper.myLooper().quit();
    }
}
