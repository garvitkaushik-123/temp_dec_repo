package com.unity3d.player;

/* renamed from: com.unity3d.player.w0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3554w0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6583a;
    public final /* synthetic */ int b;
    public final /* synthetic */ UnityPlayerForActivityOrService c;

    public RunnableC3554w0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, int i, int i2) {
        this.c = unityPlayerForActivityOrService;
        this.f6583a = i;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.unity3d.player.a.r rVar;
        rVar = this.c.mSoftInput;
        if (rVar != null) {
            rVar.setSelection(this.f6583a, this.b);
        }
    }
}
