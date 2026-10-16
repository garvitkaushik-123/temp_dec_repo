package com.unity3d.player;

import com.unity3d.player.UnityPlayer;

/* loaded from: classes7.dex */
public final class R0 extends UnityPlayer.b {
    public final /* synthetic */ UnityPlayerForGameActivity b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public R0(UnityPlayerForGameActivity unityPlayerForGameActivity) {
        super();
        this.b = unityPlayerForGameActivity;
    }

    @Override // com.unity3d.player.UnityPlayer.b
    public final void a() {
        this.b.nativeUnityPlayerSetRunning(true);
    }
}
