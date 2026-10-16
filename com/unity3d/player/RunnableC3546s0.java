package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.s0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3546s0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6575a = false;
    public boolean b = false;
    public final /* synthetic */ Semaphore c;
    public final /* synthetic */ UnityPlayerForActivityOrService d;
    public final /* synthetic */ UnityPlayerForActivityOrService e;

    public RunnableC3546s0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, Semaphore semaphore, UnityPlayerForActivityOrService unityPlayerForActivityOrService2) {
        this.e = unityPlayerForActivityOrService;
        this.c = semaphore;
        this.d = unityPlayerForActivityOrService2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.unity3d.player.a.r rVar;
        com.unity3d.player.a.r rVar2;
        rVar = this.e.mSoftInput;
        if (rVar != null) {
            this.d.setOnHandleFocusListener(new C3543q0(this));
            rVar2 = this.e.mSoftInput;
            rVar2.a(new C3544r0(this));
            this.e.dismissSoftInput();
        }
    }
}
