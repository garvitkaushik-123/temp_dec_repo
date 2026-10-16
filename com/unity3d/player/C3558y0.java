package com.unity3d.player;

import com.unity3d.player.UnityPlayer;

/* renamed from: com.unity3d.player.y0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3558y0 extends UnityPlayer.b {
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ UnityPlayerForActivityOrService d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3558y0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, int i, int i2) {
        super();
        this.d = unityPlayerForActivityOrService;
        this.b = i;
        this.c = i2;
    }

    @Override // com.unity3d.player.UnityPlayer.b
    public final void a() {
        this.d.nativeSetInputSelection(this.b, this.c);
    }
}
