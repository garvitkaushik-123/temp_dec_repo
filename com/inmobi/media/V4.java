package com.inmobi.media;

import android.app.Activity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.inmobi.ads.rendering.InMobiAdActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class V4 extends P {
    public final WeakReference e;
    public final InterfaceC2930x f;
    public final RelativeLayout g;
    public boolean h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public V4(WeakReference activityRef, InterfaceC2930x adContainer, RelativeLayout adBackgroundView) {
        super(adBackgroundView);
        Intrinsics.checkNotNullParameter(activityRef, "activityRef");
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(adBackgroundView, "adBackgroundView");
        this.e = activityRef;
        this.f = adContainer;
        this.g = adBackgroundView;
    }

    @Override // com.inmobi.media.P
    public final void a(EnumC2813pa orientation) {
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        Intrinsics.checkNotNullParameter(orientation, "orientation");
        this.b = orientation;
        InterfaceC2930x interfaceC2930x = this.f;
        Intrinsics.checkNotNull(interfaceC2930x, "null cannot be cast to non-null type com.inmobi.ads.containers.RenderView");
        ((GestureDetectorOnGestureListenerC2634ec) interfaceC2930x).getWebViewFactory().a(new U4(orientation));
    }

    @Override // com.inmobi.media.P
    public final void b() {
        Activity activity = (Activity) this.e.get();
        if (!(activity instanceof InMobiAdActivity) ? false : ((InMobiAdActivity) activity).e) {
            try {
                InterfaceC2914w fullScreenEventsListener = this.f.getFullScreenEventsListener();
                if (fullScreenEventsListener != null) {
                    fullScreenEventsListener.b(null);
                }
            } catch (Exception unused) {
                AbstractC2680h7.a((byte) 2, "InMobi", "SDK encountered unexpected error while finishing fullscreen view");
            }
        } else {
            InterfaceC2930x interfaceC2930x = this.f;
            Intrinsics.checkNotNull(interfaceC2930x, "null cannot be cast to non-null type com.inmobi.ads.containers.RenderView");
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) interfaceC2930x;
            gestureDetectorOnGestureListenerC2634ec.setFullScreenActivityContext(null);
            try {
                gestureDetectorOnGestureListenerC2634ec.i();
            } catch (Exception unused2) {
                AbstractC2680h7.a((byte) 2, "InMobi", "SDK encountered unexpected error in processing close request");
            }
            SparseArray sparseArray = InMobiAdActivity.k;
            InterfaceC2930x container = this.f;
            Intrinsics.checkNotNullParameter(container, "container");
            InMobiAdActivity.k.remove(container.hashCode());
        }
        this.f.b();
    }

    @Override // com.inmobi.media.P
    public final void c() {
        if (this.h) {
            return;
        }
        try {
            this.h = true;
            InterfaceC2914w fullScreenEventsListener = this.f.getFullScreenEventsListener();
            if (fullScreenEventsListener != null) {
                fullScreenEventsListener.a(null);
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.inmobi.media.P
    public final void d() {
    }

    @Override // com.inmobi.media.P
    public final void f() {
        this.g.setBackgroundColor(0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(10);
        Xe viewableAd = this.f.getViewableAd();
        View d = viewableAd != null ? viewableAd.d() : null;
        if (d != null) {
            ViewParent parent = d.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(d);
            }
            this.g.addView(d, layoutParams);
        }
    }

    @Override // com.inmobi.media.P
    public final void g() {
        if (1 == this.f.getPlacementType()) {
            try {
                HashMap hashMap = new HashMap();
                Xe viewableAd = this.f.getViewableAd();
                if (viewableAd != null) {
                    viewableAd.a(hashMap);
                }
            } catch (Exception unused) {
                InterfaceC2914w fullScreenEventsListener = this.f.getFullScreenEventsListener();
                if (fullScreenEventsListener != null) {
                    fullScreenEventsListener.a();
                }
            }
        }
    }

    @Override // com.inmobi.media.P
    public final void a() {
        InterfaceC2930x interfaceC2930x = this.f;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec ? (GestureDetectorOnGestureListenerC2634ec) interfaceC2930x : null;
        if (gestureDetectorOnGestureListenerC2634ec == null) {
            return;
        }
        gestureDetectorOnGestureListenerC2634ec.getWebViewFactory().a(T4.f2436a);
        if (gestureDetectorOnGestureListenerC2634ec.H) {
            return;
        }
        try {
            gestureDetectorOnGestureListenerC2634ec.i();
        } catch (Exception unused) {
            AbstractC2680h7.a((byte) 2, "InMobi", "SDK encountered unexpected error in processing close request");
        }
    }
}
