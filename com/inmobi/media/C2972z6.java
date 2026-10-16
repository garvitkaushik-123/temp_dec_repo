package com.inmobi.media;

import android.app.Activity;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.widget.RelativeLayout;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.z6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2972z6 extends P {
    public final WeakReference e;
    public final InterfaceC2930x f;
    public final RelativeLayout g;
    public boolean h;
    public boolean i;
    public C2747l9 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2972z6(WeakReference activityRef, InterfaceC2930x adContainer, RelativeLayout adBackgroundView) {
        super(adBackgroundView);
        Intrinsics.checkNotNullParameter(activityRef, "activityRef");
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(adBackgroundView, "adBackgroundView");
        this.e = activityRef;
        this.f = adContainer;
        this.g = adBackgroundView;
    }

    public static final void a(C2972z6 this$0, C2597c9 c2597c9) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.f.getPlacementType() == 1) {
            Object obj = c2597c9.t.get("didCompleteQ4");
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) obj).booleanValue()) {
                return;
            }
        }
        C2747l9 c2747l9 = this$0.j;
        if (c2747l9 != null) {
            c2747l9.start();
        }
    }

    @Override // com.inmobi.media.P
    public final void b() {
        C2747l9 c2747l9;
        Activity activity = (Activity) this.e.get();
        if (!(activity instanceof InMobiAdActivity) ? false : ((InMobiAdActivity) activity).e) {
            InterfaceC2930x interfaceC2930x = this.f;
            if (interfaceC2930x instanceof C2562a9) {
                View videoContainerView = ((C2562a9) interfaceC2930x).getVideoContainerView();
                C2763m9 c2763m9 = videoContainerView instanceof C2763m9 ? (C2763m9) videoContainerView : null;
                if (c2763m9 != null) {
                    Object tag = c2763m9.getVideoView().getTag();
                    Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                    a((C2597c9) tag);
                }
            } else if (interfaceC2930x instanceof T7) {
                a((C2597c9) null);
            }
        } else {
            InterfaceC2930x interfaceC2930x2 = this.f;
            if (interfaceC2930x2 instanceof C2562a9) {
                C2747l9 c2747l92 = this.j;
                Object tag2 = c2747l92 != null ? c2747l92.getTag() : null;
                C2597c9 c2597c9 = tag2 instanceof C2597c9 ? (C2597c9) tag2 : null;
                if (c2597c9 != null) {
                    if (1 == ((T7) interfaceC2930x2).f2437a && (c2747l9 = this.j) != null) {
                        c2747l9.f();
                    }
                    a(c2597c9);
                }
            } else if (interfaceC2930x2 instanceof T7) {
                a((C2597c9) null);
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
        InterfaceC2930x interfaceC2930x = this.f;
        if (interfaceC2930x instanceof C2562a9) {
            C2747l9 c2747l9 = this.j;
            Object tag = c2747l9 != null ? c2747l9.getTag() : null;
            final C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
            if (c2597c9 != null && this.h) {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.inmobi.media.z6$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2972z6.a(C2972z6.this, c2597c9);
                    }
                }, 50L);
            }
            try {
                if (!this.i) {
                    this.i = true;
                    InterfaceC2914w fullScreenEventsListener = this.f.getFullScreenEventsListener();
                    if (fullScreenEventsListener != null) {
                        fullScreenEventsListener.a(c2597c9);
                    }
                }
            } catch (Exception e) {
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
            }
        } else if (interfaceC2930x instanceof T7) {
            try {
                if (!this.i) {
                    this.i = true;
                    InterfaceC2914w fullScreenEventsListener2 = interfaceC2930x.getFullScreenEventsListener();
                    if (fullScreenEventsListener2 != null) {
                        fullScreenEventsListener2.a(null);
                    }
                }
            } catch (Exception e2) {
                S5 s52 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e2, "event"));
            }
        }
        this.h = false;
    }

    @Override // com.inmobi.media.P
    public final void d() {
        this.h = true;
        C2747l9 c2747l9 = this.j;
        if (c2747l9 != null) {
            c2747l9.pause();
        }
    }

    @Override // com.inmobi.media.P
    public final void f() {
        C2681h8 c2681h8;
        C2630e8 c2630e8;
        byte placementType = this.f.getPlacementType();
        this.g.setBackgroundColor(-16777216);
        Object dataModel = this.f.getDataModel();
        C2743l5 c2743l5 = null;
        C2811p8 c2811p8 = dataModel instanceof C2811p8 ? (C2811p8) dataModel : null;
        Point point = (c2811p8 == null || (c2681h8 = c2811p8.e) == null || (c2630e8 = c2681h8.d) == null) ? null : c2630e8.f2560a;
        Xe viewableAd = this.f.getViewableAd();
        int i = 0;
        View a2 = viewableAd != null ? viewableAd.a(null, this.g, false) : null;
        InterfaceC2930x interfaceC2930x = this.f;
        if (interfaceC2930x instanceof C2562a9) {
            View videoContainerView = ((C2562a9) interfaceC2930x).getVideoContainerView();
            C2763m9 c2763m9 = videoContainerView instanceof C2763m9 ? (C2763m9) videoContainerView : null;
            if (c2763m9 != null) {
                C2747l9 videoView = c2763m9.getVideoView();
                this.j = videoView;
                if (videoView != null) {
                    videoView.requestFocus();
                }
                C2747l9 c2747l9 = this.j;
                Object tag = c2747l9 != null ? c2747l9.getTag() : null;
                Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                C2597c9 c2597c9 = (C2597c9) tag;
                C2613d8 c2613d8 = c2597c9.w;
                if (c2613d8 != null) {
                    Intrinsics.checkNotNull(c2613d8, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                    c2597c9.a((C2597c9) c2613d8);
                }
                if (placementType == 0) {
                    c2597c9.t.put("placementType", (byte) 0);
                } else {
                    c2597c9.t.put("placementType", (byte) 1);
                }
            }
        }
        if (a2 != null) {
            Intrinsics.checkNotNull(point);
            this.g.addView(a2, new RelativeLayout.LayoutParams(point.x, point.y));
        }
        Activity activity = (Activity) this.e.get();
        if (activity == null || c2811p8 == null) {
            return;
        }
        byte b = c2811p8.b;
        if (b == 1) {
            i = 1;
        } else if (b != 2) {
            i = activity.getRequestedOrientation();
        }
        if (activity instanceof InMobiAdActivity) {
            C2743l5 c2743l52 = ((InMobiAdActivity) activity).f2223a;
            if (c2743l52 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
            } else {
                c2743l5 = c2743l52;
            }
            c2743l5.f2629a.setRequestedOrientation(i);
        }
    }

    @Override // com.inmobi.media.P
    public final void g() {
        try {
            AdConfig adConfig = this.f.getAdConfig();
            Xe viewableAd = this.f.getViewableAd();
            if ((viewableAd != null ? viewableAd.b() : null) != null) {
                InterfaceC2930x interfaceC2930x = this.f;
                if (!(interfaceC2930x instanceof C2562a9)) {
                    if (interfaceC2930x instanceof T7) {
                        try {
                            viewableAd.a((Map) null);
                            return;
                        } catch (Exception unused) {
                            InterfaceC2914w fullScreenEventsListener = this.f.getFullScreenEventsListener();
                            if (fullScreenEventsListener != null) {
                                fullScreenEventsListener.a();
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                C2747l9 c2747l9 = this.j;
                Object tag = c2747l9 != null ? c2747l9.getTag() : null;
                C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
                if (c2597c9 != null) {
                    AdConfig.ViewabilityConfig viewability = adConfig.getViewability();
                    int videoImpressionMinTimeViewed = viewability.getVideoImpressionMinTimeViewed();
                    HashMap hashMap = c2597c9.F;
                    Object obj = hashMap != null ? hashMap.get("time") : null;
                    if (obj instanceof Integer) {
                        videoImpressionMinTimeViewed = ((Number) obj).intValue();
                    }
                    viewability.setVideoImpressionMinTimeViewed(videoImpressionMinTimeViewed);
                    viewableAd.a((Map) null);
                }
            }
        } catch (Exception e) {
            InterfaceC2914w fullScreenEventsListener2 = this.f.getFullScreenEventsListener();
            if (fullScreenEventsListener2 != null) {
                fullScreenEventsListener2.a();
            }
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    @Override // com.inmobi.media.P
    public final void a() {
        if (this.f.c()) {
            return;
        }
        InterfaceC2930x interfaceC2930x = this.f;
        if (interfaceC2930x instanceof C2562a9) {
            if (((C2562a9) interfaceC2930x).b.c) {
                return;
            }
            Activity activity = (Activity) this.e.get();
            if (activity instanceof InMobiAdActivity) {
                ((InMobiAdActivity) activity).e = true;
            }
            C2747l9 c2747l9 = this.j;
            if (c2747l9 == null) {
                Activity activity2 = (Activity) this.e.get();
                if (activity2 == null) {
                    return;
                }
                activity2.finish();
                return;
            }
            Object tag = c2747l9.getTag();
            C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
            if (c2597c9 != null) {
                if (1 == ((T7) interfaceC2930x).f2437a) {
                    c2747l9.f();
                }
                try {
                    Object obj = c2597c9.t.get("isFullScreen");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Boolean");
                    if (((Boolean) obj).booleanValue()) {
                        c2597c9.t.put("seekPosition", Integer.valueOf(c2747l9.getCurrentPosition()));
                        ((C2562a9) interfaceC2930x).b(c2597c9);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    AbstractC2680h7.a((byte) 2, "InMobi", "SDK encountered unexpected error in closing video");
                    S5 s5 = S5.f2425a;
                    S5.d.a(AbstractC2920w5.a(e, "event"));
                    return;
                }
            }
            return;
        }
        if (interfaceC2930x instanceof T7) {
            T7 t7 = (T7) interfaceC2930x;
            if (t7.b.c) {
                return;
            }
            t7.a();
            return;
        }
        Activity activity3 = (Activity) this.e.get();
        if (activity3 == null) {
            return;
        }
        activity3.finish();
    }

    public final void a(C2597c9 c2597c9) {
        try {
            InterfaceC2914w fullScreenEventsListener = this.f.getFullScreenEventsListener();
            if (fullScreenEventsListener != null) {
                fullScreenEventsListener.b(c2597c9);
            }
        } catch (Exception e) {
            AbstractC2680h7.a((byte) 2, "InMobi", "SDK encountered unexpected error while finishing fullscreen view");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }
}
