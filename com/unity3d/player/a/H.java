package com.unity3d.player.a;

import android.content.DialogInterface;

/* loaded from: classes7.dex */
public final class H implements DialogInterface.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.unity3d.player.D f6514a;

    public H(com.unity3d.player.D d) {
        this.f6514a = d;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        this.f6514a.invokeOnClose();
    }
}
