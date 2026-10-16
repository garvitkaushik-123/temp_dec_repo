package com.unity3d.player;

import android.view.Surface;
import java.util.concurrent.Semaphore;

/* loaded from: classes7.dex */
public final class H0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6474a;
    public final /* synthetic */ Surface b;
    public final /* synthetic */ Semaphore c;
    public final /* synthetic */ UnityPlayerForActivityOrService d;

    public H0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, int i, Surface surface, Semaphore semaphore) {
        this.d = unityPlayerForActivityOrService;
        this.f6474a = i;
        this.b = surface;
        this.c = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.nativeRecreateGfxState(this.f6474a, this.b);
        this.c.release();
    }
}
