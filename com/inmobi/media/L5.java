package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.inmobi.commons.core.configs.AdConfig;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class L5 extends Xe {
    public final C2569af e;
    public final S4 f;
    public final InterfaceC2971z5 g;
    public final String h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L5(GestureDetectorOnGestureListenerC2634ec container, C2569af mViewableAd, S4 htmlAdTracker, InterfaceC2971z5 interfaceC2971z5) {
        super(container);
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(mViewableAd, "mViewableAd");
        Intrinsics.checkNotNullParameter(htmlAdTracker, "htmlAdTracker");
        this.e = mViewableAd;
        this.f = htmlAdTracker;
        this.g = interfaceC2971z5;
        this.h = "L5";
    }

    @Override // com.inmobi.media.Xe
    public final View a(View view, ViewGroup parent, boolean z) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View b = this.e.b();
        if (b != null) {
            this.f.a(b);
            this.f.b(b);
        }
        C2569af c2569af = this.e;
        c2569af.getClass();
        Intrinsics.checkNotNullParameter(parent, "parent");
        return c2569af.d();
    }

    @Override // com.inmobi.media.Xe
    public final void a(byte b) {
    }

    @Override // com.inmobi.media.Xe
    public final View b() {
        return this.e.b();
    }

    @Override // com.inmobi.media.Xe
    public final C2939x8 c() {
        return this.e.b;
    }

    @Override // com.inmobi.media.Xe
    public final View d() {
        return this.e.d();
    }

    @Override // com.inmobi.media.Xe
    public final void e() {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "stopTrackingForImpression");
        }
        View b = this.e.b();
        if (b != null) {
            this.f.a(b);
            this.e.getClass();
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(Map map) {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String str = this.h;
            ((A5) interfaceC2971z5).a(str, H6.a(str, "TAG", "startTrackingForImpression with ").append(map != null ? Integer.valueOf(map.size()) : null).append(" friendly views").toString());
        }
        View token = this.e.b();
        if (token != null) {
            InterfaceC2971z5 interfaceC2971z52 = this.g;
            if (interfaceC2971z52 != null) {
                String TAG = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z52).a(TAG, "start tracking");
            }
            AdConfig.ViewabilityConfig viewabilityConfig = this.d.getViewability();
            InterfaceC2930x interfaceC2930x = this.f2487a;
            Intrinsics.checkNotNull(interfaceC2930x, "null cannot be cast to non-null type com.inmobi.ads.containers.RenderView");
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) interfaceC2930x;
            gestureDetectorOnGestureListenerC2634ec.setFriendlyViews(map);
            S4 s4 = this.f;
            s4.getClass();
            Intrinsics.checkNotNullParameter(token, "view");
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(viewabilityConfig, "viewabilityConfig");
            InterfaceC2971z5 interfaceC2971z53 = s4.f;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).c("HtmlAdTracker", "startTrackingForImpression");
            }
            if (s4.f2424a == 0) {
                InterfaceC2971z5 interfaceC2971z54 = s4.f;
                if (interfaceC2971z54 != null) {
                    ((A5) interfaceC2971z54).b("HtmlAdTracker", "impression type is loaded. return");
                }
            } else if (!Intrinsics.areEqual(s4.b, "video") && !Intrinsics.areEqual(s4.b, "audio")) {
                byte b = s4.f2424a;
                C2662g5 c2662g5 = s4.g;
                if (c2662g5 == null) {
                    InterfaceC2971z5 interfaceC2971z55 = s4.f;
                    if (interfaceC2971z55 != null) {
                        ((A5) interfaceC2971z55).c("HtmlAdTracker", "creating Visibility Tracker for " + ((int) b));
                    }
                    X4 x4 = new X4(viewabilityConfig, b, s4.f);
                    InterfaceC2971z5 interfaceC2971z56 = s4.f;
                    if (interfaceC2971z56 != null) {
                        ((A5) interfaceC2971z56).c("HtmlAdTracker", "creating Impression Tracker for " + ((int) b));
                    }
                    C2662g5 c2662g52 = new C2662g5(viewabilityConfig, x4, s4.j);
                    s4.g = c2662g52;
                    c2662g5 = c2662g52;
                }
                InterfaceC2971z5 interfaceC2971z57 = s4.f;
                if (interfaceC2971z57 != null) {
                    ((A5) interfaceC2971z57).c("HtmlAdTracker", "impression tracker add view");
                }
                c2662g5.a(token, token, s4.d, s4.c);
            } else {
                InterfaceC2971z5 interfaceC2971z58 = s4.f;
                if (interfaceC2971z58 != null) {
                    ((A5) interfaceC2971z58).b("HtmlAdTracker", "creative type is video and audio. return");
                }
            }
            this.f.a(token, token, gestureDetectorOnGestureListenerC2634ec.getVISIBILITY_CHANGE_LISTENER(), viewabilityConfig, false);
            this.e.getClass();
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(View childView, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
        if (childView instanceof C2750lc) {
            InterfaceC2971z5 interfaceC2971z5 = this.g;
            if (interfaceC2971z5 != null) {
                String TAG = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).a(TAG, "Ignoring RenderViewSibling as friendly view");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.g;
        if (interfaceC2971z52 != null) {
            String str = this.h;
            ((A5) interfaceC2971z52).a(str, H6.a(str, "TAG", "Adding friendly view: ").append(childView.getClass().getSimpleName()).append(" with obstruction code: ").append(obstructionCode).toString());
        }
        this.e.a(childView, obstructionCode);
    }

    @Override // com.inmobi.media.Xe
    public final void a(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        if (childView instanceof C2750lc) {
            return;
        }
        this.e.a(childView);
    }

    @Override // com.inmobi.media.Xe
    public final void a(Context context, byte b) {
        C2569af c2569af;
        Intrinsics.checkNotNullParameter(context, "context");
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String str = this.h;
            ((A5) interfaceC2971z5).a(str, X8.a(str, "TAG", "onActivityStateChanged - state - ", b));
        }
        try {
            try {
                if (b == 0) {
                    S4 s4 = this.f;
                    InterfaceC2971z5 interfaceC2971z52 = s4.f;
                    if (interfaceC2971z52 != null) {
                        ((A5) interfaceC2971z52).c("HtmlAdTracker", "onActivityStarted");
                    }
                    C2662g5 c2662g5 = s4.g;
                    if (c2662g5 != null) {
                        Intrinsics.checkNotNullExpressionValue(c2662g5.d, "TAG");
                        for (Map.Entry entry : c2662g5.f2577a.entrySet()) {
                            View view = (View) entry.getKey();
                            C2627e5 c2627e5 = (C2627e5) entry.getValue();
                            c2662g5.c.a(view, c2627e5.f2557a, c2627e5.b);
                        }
                        if (!c2662g5.e.hasMessages(0)) {
                            c2662g5.e.postDelayed(c2662g5.f, c2662g5.g);
                        }
                        c2662g5.c.f();
                    }
                    X4 x4 = s4.h;
                    if (x4 != null) {
                        x4.f();
                    }
                } else if (b == 1) {
                    S4 s42 = this.f;
                    InterfaceC2971z5 interfaceC2971z53 = s42.f;
                    if (interfaceC2971z53 != null) {
                        ((A5) interfaceC2971z53).c("HtmlAdTracker", "onActivityStopped");
                    }
                    C2662g5 c2662g52 = s42.g;
                    if (c2662g52 != null) {
                        Intrinsics.checkNotNullExpressionValue(c2662g52.d, "TAG");
                        c2662g52.c.a();
                        c2662g52.e.removeCallbacksAndMessages(null);
                        c2662g52.b.clear();
                    }
                    X4 x42 = s42.h;
                    if (x42 != null) {
                        x42.e();
                    }
                } else if (b == 2) {
                    S4 s43 = this.f;
                    InterfaceC2971z5 interfaceC2971z54 = s43.f;
                    if (interfaceC2971z54 != null) {
                        ((A5) interfaceC2971z54).c("HtmlAdTracker", "onActivityDestroyed");
                    }
                    C2662g5 c2662g53 = s43.g;
                    if (c2662g53 != null) {
                        c2662g53.f2577a.clear();
                        c2662g53.b.clear();
                        c2662g53.c.a();
                        c2662g53.e.removeMessages(0);
                        c2662g53.c.b();
                    }
                    s43.g = null;
                    X4 x43 = s43.h;
                    if (x43 != null) {
                        x43.b();
                    }
                    s43.h = null;
                } else {
                    Intrinsics.checkNotNullExpressionValue(this.h, "TAG");
                }
                c2569af = this.e;
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z55 = this.g;
                if (interfaceC2971z55 != null) {
                    String TAG = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z55).b(TAG, "Exception in onActivityStateChanged with message : " + e.getMessage());
                }
                S5 s5 = S5.f2425a;
                C2640f2 event = new C2640f2(e);
                Intrinsics.checkNotNullParameter(event, "event");
                S5.d.a(event);
                c2569af = this.e;
            }
            c2569af.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
        } catch (Throwable th) {
            this.e.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
            throw th;
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a() {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "destroy");
        }
        View b = this.e.b();
        if (b != null) {
            this.f.a(b);
            this.f.b(b);
        }
        super.a();
        this.e.a();
    }
}
