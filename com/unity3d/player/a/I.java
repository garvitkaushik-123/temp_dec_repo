package com.unity3d.player.a;

import android.view.ViewTreeObserver;

/* loaded from: classes7.dex */
public final class I implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.unity3d.player.D f6515a;

    public I(com.unity3d.player.D d) {
        this.f6515a = d;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f6515a.reportSoftInputArea();
    }
}
