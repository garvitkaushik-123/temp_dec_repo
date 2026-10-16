package com.unity3d.player;

import com.unity3d.player.UnityPlayer;

/* renamed from: com.unity3d.player.n0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3537n0 extends UnityPlayer.b {
    public final /* synthetic */ boolean b;
    public final /* synthetic */ C3539o0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3537n0(C3539o0 c3539o0, boolean z) {
        super();
        this.c = c3539o0;
        this.b = z;
    }

    @Override // com.unity3d.player.UnityPlayer.b
    public final void a() {
        UnityPlayer.permissionResponseToNative(this.c.f6570a, this.b);
    }
}
