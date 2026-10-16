package com.unity3d.player;

import android.content.DialogInterface;

/* renamed from: com.unity3d.player.d0, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class DialogInterfaceOnClickListenerC3517d0 implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UnityPlayer f6549a;

    public DialogInterfaceOnClickListenerC3517d0(UnityPlayer unityPlayer) {
        this.f6549a = unityPlayer;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.f6549a.finish();
    }
}
