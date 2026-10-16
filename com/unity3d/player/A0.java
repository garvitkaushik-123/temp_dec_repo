package com.unity3d.player;

import com.unity3d.player.UnityPlayer;

/* loaded from: classes7.dex */
public final class A0 extends UnityPlayer.b {
    public final /* synthetic */ boolean b;
    public final /* synthetic */ UnityPlayerForActivityOrService c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public A0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, boolean z) {
        super();
        this.c = unityPlayerForActivityOrService;
        this.b = z;
    }

    @Override // com.unity3d.player.UnityPlayer.b
    public final void a() {
        this.c.nativeSetKeyboardIsVisible(this.b);
    }
}
