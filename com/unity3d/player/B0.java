package com.unity3d.player;

/* loaded from: classes7.dex */
public final class B0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayerForActivityOrService f6464a;

    public B0(UnityPlayerForActivityOrService unityPlayerForActivityOrService) {
        this.f6464a = unityPlayerForActivityOrService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6464a.destroy();
    }
}
