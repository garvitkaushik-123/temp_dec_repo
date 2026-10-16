package com.fyber.inneractive.sdk.activities;

import android.view.View;
import com.fyber.inneractive.sdk.util.r;

/* loaded from: classes4.dex */
public final class d implements View.OnSystemUiVisibilityChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InneractiveFullscreenAdActivity f1009a;

    public d(InneractiveFullscreenAdActivity inneractiveFullscreenAdActivity) {
        this.f1009a = inneractiveFullscreenAdActivity;
    }

    @Override // android.view.View.OnSystemUiVisibilityChangeListener
    public final void onSystemUiVisibilityChange(int i) {
        if ((i & 2) == 0) {
            r.b.postDelayed(this.f1009a.mHideNavigationBarTask, 3000L);
        }
    }
}
