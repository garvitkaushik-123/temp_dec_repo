package com.fyber.inneractive.sdk.activities;

import com.fyber.inneractive.sdk.click.q;

/* loaded from: classes4.dex */
public final class h implements com.fyber.inneractive.sdk.click.o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f1013a;

    public h(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f1013a = inneractiveInternalBrowserActivity;
    }

    @Override // com.fyber.inneractive.sdk.click.o
    public final void a(com.fyber.inneractive.sdk.click.b bVar) {
        if (bVar.f1056a != q.FAILED) {
            InneractiveInternalBrowserActivity.a(this.f1013a, bVar);
            this.f1013a.finish();
        }
    }
}
