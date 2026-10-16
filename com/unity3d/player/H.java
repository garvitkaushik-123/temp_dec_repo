package com.unity3d.player;

import com.unity3d.player.UnityPlayer;
import java.util.Objects;

/* loaded from: classes7.dex */
public final class H extends UnityPlayer.b {
    public final /* synthetic */ int b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H(UnityPlayer unityPlayer, int i) {
        super();
        this.b = i;
        Objects.requireNonNull(unityPlayer);
    }

    @Override // com.unity3d.player.UnityPlayer.b
    public final void a() {
        UnityAccessibilityDelegate.onNodeFocusChanged(this.b, true);
    }
}
