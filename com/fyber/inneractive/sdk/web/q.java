package com.fyber.inneractive.sdk.web;

import android.view.KeyEvent;
import android.view.View;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public final class q implements View.OnKeyListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i0 f1815a;

    public q(i0 i0Var) {
        this.f1815a = i0Var;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (i != 4 || !this.f1815a.p()) {
            return false;
        }
        IAlog.e("back button pressed while ad is expanded, ad will be collapsed.", new Object[0]);
        this.f1815a.o();
        return true;
    }
}
