package com.unity3d.player;

/* loaded from: classes7.dex */
public final class J0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForActivityOrService f6478a;

    public J0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f6478a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6478a.nativeResume();
    }
}
