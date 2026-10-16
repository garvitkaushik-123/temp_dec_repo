package com.unity3d.player;

/* renamed from: com.unity3d.player.u0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3550u0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6579a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public RunnableC3550u0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, int i) {
        this.b = unityPlayerForActivityOrService;
        this.f6579a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.unity3d.player.a.r rVar;
        rVar = this.b.mSoftInput;
        if (rVar != null) {
            rVar.setCharacterLimit(this.f6579a);
        }
    }
}
