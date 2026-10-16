package com.unity3d.player.a;

import android.window.OnBackInvokedCallback;

/* renamed from: com.unity3d.player.a.e, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public final class C3497e implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f6527a;

    public C3497e(w wVar) {
        this.f6527a = wVar;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        Runnable runnable = this.f6527a.f6538a;
        if (runnable != null) {
            runnable.run();
        }
    }
}
