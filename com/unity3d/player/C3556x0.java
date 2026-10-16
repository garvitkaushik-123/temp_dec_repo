package com.unity3d.player;

import com.unity3d.player.UnityPlayer;

/* renamed from: com.unity3d.player.x0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3556x0 extends UnityPlayer.b {
    public final /* synthetic */ boolean b;
    public final /* synthetic */ String c;
    public final /* synthetic */ int d;
    public final /* synthetic */ UnityPlayerForActivityOrService e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3556x0(UnityPlayerForActivityOrService unityPlayerForActivityOrService, boolean z, String str, int i) {
        super();
        this.e = unityPlayerForActivityOrService;
        this.b = z;
        this.c = str;
        this.d = i;
    }

    @Override // com.unity3d.player.UnityPlayer.b
    public final void a() {
        if (this.b) {
            this.e.nativeSoftInputCanceled();
        } else {
            String str = this.c;
            if (str != null) {
                this.e.nativeSetInputString(str);
            }
        }
        if (this.d == 1) {
            this.e.nativeSoftInputClosed();
        }
    }
}
