package com.unity3d.player;

/* renamed from: com.unity3d.player.t0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class RunnableC3548t0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f6577a;
    public final /* synthetic */ UnityPlayerForActivityOrService b;

    public RunnableC3548t0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, String str) {
        this.b = unityPlayerForActivityOrService;
        this.f6577a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.unity3d.player.a.r rVar;
        String str;
        rVar = this.b.mSoftInput;
        if (rVar == null || (str = this.f6577a) == null) {
            return;
        }
        rVar.setText(str);
    }
}
