package com.fyber.inneractive.sdk.activities;

import android.view.View;

/* loaded from: classes4.dex */
public final class l implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveInternalBrowserActivity f1017a;

    public l(InneractiveInternalBrowserActivity inneractiveInternalBrowserActivity) {
        this.f1017a = inneractiveInternalBrowserActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1017a.finish();
    }
}
