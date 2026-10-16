package com.unity3d.player;

/* loaded from: classes7.dex */
public final class G0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForActivityOrService f6473a;

    public G0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f6473a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6473a.nativeSendSurfaceChangedEvent();
    }
}
