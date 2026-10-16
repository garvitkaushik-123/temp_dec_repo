package com.unity3d.player;

import com.unity3d.player.UnityPlayer;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class K extends UnityPlayer.b {
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ N d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public K(N n, UnityPlayer unityPlayer, int i, int i2) {
        super();
        this.d = n;
        this.b = i;
        this.c = i2;
        Objects.requireNonNull(unityPlayer);
    }

    @Override // com.unity3d.player.UnityPlayer.b
    public final void a() {
        if (this.b == 4096) {
            UnityAccessibilityDelegate.onNodeIncremented(this.c);
        } else {
            UnityAccessibilityDelegate.onNodeDecremented(this.c);
        }
        this.d.f6482a.sendEventForVirtualViewId(this.c, 4);
    }
}
