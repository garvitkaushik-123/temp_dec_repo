package com.fyber.inneractive.sdk.player.controller;

import android.view.View;

/* loaded from: classes4.dex */
public final class c0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f1358a;

    public c0(e0 e0Var) {
        this.f1358a = e0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1358a.b.dismiss();
        v vVar = this.f1358a.f1362a;
        vVar.b.d(vVar.f1374a);
    }
}
