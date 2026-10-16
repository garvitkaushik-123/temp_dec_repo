package com.unity3d.player;

import com.unity3d.player.UnityPlayer;

/* renamed from: com.unity3d.player.o0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3539o0 implements IPermissionRequestCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final long f6570a;
    public final /* synthetic */ UnityPlayer b;

    public C3539o0(long j, UnityPlayer unityPlayer) {
        this.b = unityPlayer;
        this.f6570a = j;
    }

    @Override // com.unity3d.player.IPermissionRequestCallbacks
    public final void onPermissionResult(String[] strArr, int[] iArr) {
        int length = iArr.length;
        boolean z = false;
        if (length != 0) {
            if (length == 1) {
                if (iArr[0] == 1) {
                    z = true;
                }
            } else {
                com.unity3d.player.a.t.Log(6, "Only a single permission request is supported");
                return;
            }
        }
        if (this.f6570a == 0) {
            return;
        }
        this.b.invokeOnMainThread((UnityPlayer.b) new C3537n0(this, z));
    }
}
