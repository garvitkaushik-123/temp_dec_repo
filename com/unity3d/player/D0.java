package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* loaded from: classes7.dex */
public final class D0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Semaphore f6468a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public D0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, Semaphore semaphore) {
        this.b = unityPlayerForActivityOrService;
        this.f6468a = semaphore;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.shutdown();
        this.f6468a.release();
    }
}
