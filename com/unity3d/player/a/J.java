package com.unity3d.player.a;

import android.content.DialogInterface;
import com.unity3d.player.M0;

/* loaded from: classes7.dex */
public final class J implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.unity3d.player.D f6516a;

    public J(com.unity3d.player.D d) {
        this.f6516a = d;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        M0 m0 = this.f6516a.f;
        if (m0 != null) {
            m0.a();
        }
    }
}
