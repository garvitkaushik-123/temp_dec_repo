package com.unity3d.player;

import android.view.WindowInsets;
import com.unity3d.player.UnityPlayer;

/* renamed from: com.unity3d.player.p0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3541p0 extends UnityPlayer.b {
    public final /* synthetic */ WindowInsets b;
    public final /* synthetic */ C0 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3541p0(C0 c0, WindowInsets windowInsets) {
        super();
        this.c = c0;
        this.b = windowInsets;
    }

    @Override // com.unity3d.player.UnityPlayer.b
    public final void a() {
        this.c.f6466a.nativeOnApplyWindowInsets(this.b);
    }
}
