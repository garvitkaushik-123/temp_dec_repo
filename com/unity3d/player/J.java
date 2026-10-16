package com.unity3d.player;

import com.unity3d.player.UnityPlayer;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class J extends UnityPlayer.b {
    public final /* synthetic */ int b;
    public final /* synthetic */ N c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J(N n, UnityPlayer unityPlayer, int i) {
        super();
        this.c = n;
        this.b = i;
        Objects.requireNonNull(unityPlayer);
    }

    @Override // com.unity3d.player.UnityPlayer.b
    public final void a() {
        boolean onNodeInvoked;
        onNodeInvoked = UnityAccessibilityDelegate.onNodeInvoked(this.b);
        if (onNodeInvoked) {
            this.c.f6482a.sendEventForVirtualViewId(this.b, 1);
        }
    }
}
