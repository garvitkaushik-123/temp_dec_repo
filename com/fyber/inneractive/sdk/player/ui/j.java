package com.fyber.inneractive.sdk.player.ui;

import com.fyber.inneractive.sdk.player.controller.z;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.s1;

/* loaded from: classes4.dex */
public final class j implements s1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1644a;
    public final /* synthetic */ l b;

    public j(l lVar, int i) {
        this.b = lVar;
        this.f1644a = i;
    }

    @Override // com.fyber.inneractive.sdk.util.s1
    public final void a() {
        if (this.b.h) {
            IAlog.a("Autoclick is aborted - app in background", new Object[0]);
        } else {
            IAlog.a("Autoclick is triggered", new Object[0]);
            ((z) this.b.g).a(this.f1644a, l.I);
        }
        this.b.p();
    }
}
