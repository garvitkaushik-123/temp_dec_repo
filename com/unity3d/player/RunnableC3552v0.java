package com.unity3d.player;

/* renamed from: com.unity3d.player.v0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3552v0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f6581a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public RunnableC3552v0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, boolean z) {
        this.b = unityPlayerForActivityOrService;
        this.f6581a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.unity3d.player.a.r rVar;
        rVar = this.b.mSoftInput;
        if (rVar != null) {
            rVar.setHideInputField(this.f6581a);
        }
    }
}
