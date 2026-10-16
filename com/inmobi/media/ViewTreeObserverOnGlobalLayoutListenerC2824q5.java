package com.inmobi.media;

import android.view.ViewTreeObserver;
import com.inmobi.ads.InMobiAudio;

/* renamed from: com.inmobi.media.q5, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class ViewTreeObserverOnGlobalLayoutListenerC2824q5 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InMobiAudio f2680a;

    public ViewTreeObserverOnGlobalLayoutListenerC2824q5(InMobiAudio inMobiAudio) {
        this.f2680a = inMobiAudio;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean b;
        try {
            this.f2680a.f = B2.b(r0.getMeasuredWidth() / U3.b());
            this.f2680a.g = B2.b(r0.getMeasuredHeight() / U3.b());
            b = this.f2680a.b();
            if (b) {
                this.f2680a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        } catch (Exception unused) {
            AbstractC2680h7.a((byte) 1, "InMobiAudio", "InMobiAudio$1.onGlobalLayout() handler threw unexpected error");
        }
    }
}
