package com.fyber.inneractive.sdk.web;

import android.window.OnBackInvokedCallback;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class t implements OnBackInvokedCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f1822a;

    public t(i0 i0Var) {
        this.f1822a = i0Var;
    }

    @Override // android.window.OnBackInvokedCallback
    public final void onBackInvoked() {
        i0 i0Var = this.f1822a;
        if (i0Var.p()) {
            IAlog.e("back button pressed while ad is expanded, ad will be collapsed.", new Object[0]);
            i0Var.o();
        }
    }
}
