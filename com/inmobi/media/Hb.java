package com.inmobi.media;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Hb implements ef {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ GestureDetectorOnGestureListenerC2634ec f2307a;

    public Hb(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        this.f2307a = gestureDetectorOnGestureListenerC2634ec;
    }

    @Override // com.inmobi.media.ef
    public final void a(View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof GestureDetectorOnGestureListenerC2634ec) {
            if (this.f2307a.hasWindowFocus()) {
                this.f2307a.c(z);
            } else {
                this.f2307a.c(false);
            }
        }
    }
}
