package com.inmobi.media;

import android.view.View;

/* loaded from: classes4.dex */
public final class Q4 implements InterfaceC2610d5 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S4 f2405a;

    public Q4(S4 s4) {
        this.f2405a = s4;
    }

    @Override // com.inmobi.media.InterfaceC2610d5
    public final void a(View view, Object obj) {
        if (view instanceof GestureDetectorOnGestureListenerC2634ec) {
            InterfaceC2971z5 interfaceC2971z5 = this.f2405a.f;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).a("HtmlAdTracker", "fireImpression");
            }
            ((GestureDetectorOnGestureListenerC2634ec) view).m();
        }
    }
}
