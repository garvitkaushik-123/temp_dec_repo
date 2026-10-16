package com.unity3d.player;

import android.graphics.Rect;
import com.unity3d.player.UnityPlayer;

/* renamed from: com.unity3d.player.z0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3560z0 extends UnityPlayer.b {
    public final /* synthetic */ Rect b;
    public final /* synthetic */ UnityPlayerForActivityOrService c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3560z0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, Rect rect) {
        super();
        this.c = unityPlayerForActivityOrService;
        this.b = rect;
    }

    @Override // com.unity3d.player.UnityPlayer.b
    public final void a() {
        UnityPlayerForActivityOrService unityPlayerForActivityOrService = this.c;
        Rect rect = this.b;
        unityPlayerForActivityOrService.nativeSetInputArea(rect.left, rect.top, rect.right, rect.bottom);
    }
}
