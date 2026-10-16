package com.unity3d.player;

import com.unity3d.player.UnityPlayer;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class L extends UnityPlayer.b {
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(UnityPlayer unityPlayer, int i, int i2) {
        super();
        this.b = i;
        this.c = i2;
        Objects.requireNonNull(unityPlayer);
    }

    @Override // com.unity3d.player.UnityPlayer.b
    public final void a() {
        UnityAccessibilityDelegate.onNodeScrolled(this.b, this.c);
    }
}
