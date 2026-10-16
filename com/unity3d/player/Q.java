package com.unity3d.player;

import com.unity3d.player.UnityPlayer;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class Q extends UnityPlayer.b {
    public final /* synthetic */ boolean b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q(UnityPlayer unityPlayer, boolean z) {
        super();
        this.b = z;
        Objects.requireNonNull(unityPlayer);
    }

    @Override // com.unity3d.player.UnityPlayer.b
    public final void a() {
        UnityAccessibilityDelegate.onClosedCaptioningStatusChanged(this.b);
    }
}
