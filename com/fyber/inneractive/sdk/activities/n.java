package com.fyber.inneractive.sdk.activities;

import android.view.View;

/* loaded from: classes4.dex */
public final class n implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveRichMediaVideoPlayerActivityCore f1019a;

    public n(InneractiveRichMediaVideoPlayerActivityCore inneractiveRichMediaVideoPlayerActivityCore) {
        this.f1019a = inneractiveRichMediaVideoPlayerActivityCore;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f1019a.finish();
    }
}
