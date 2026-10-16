package com.fyber.inneractive.sdk.ui;

import android.view.View;
import com.fyber.inneractive.sdk.activities.InneractiveFullscreenAdActivity;

/* loaded from: classes4.dex */
public final class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveFullscreenAdActivity f1739a;

    public a(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        this.f1739a = inneractiveFullscreenAdActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1739a.dismissAd(true);
    }
}
