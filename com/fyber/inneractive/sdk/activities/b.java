package com.fyber.inneractive.sdk.activities;

import android.window.OnBackInvokedCallback;

/* loaded from: classes4.dex */
public final class b implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveBaseActivity f1007a;

    public b(InneractiveBaseActivity inneractiveBaseActivity) {
        this.f1007a = inneractiveBaseActivity;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        this.f1007a.onBackPressed();
    }
}
