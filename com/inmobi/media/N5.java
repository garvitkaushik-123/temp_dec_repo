package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.inmobi.commons.core.configs.AdConfig;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class N5 extends We {
    public final C2562a9 e;
    public final C2603cf f;
    public final InterfaceC2971z5 g;
    public final String h;
    public final WeakReference i;
    public final Z7 j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N5(C2562a9 mAdContainer, C2603cf mViewableAd, InterfaceC2971z5 interfaceC2971z5) {
        super(mAdContainer);
        Intrinsics.checkNotNullParameter(mAdContainer, "mAdContainer");
        Intrinsics.checkNotNullParameter(mViewableAd, "mViewableAd");
        this.e = mAdContainer;
        this.f = mViewableAd;
        this.g = interfaceC2971z5;
        this.h = "N5";
        this.i = new WeakReference(mAdContainer.j());
        this.j = new Z7((byte) 0, interfaceC2971z5);
    }

    @Override // com.inmobi.media.Xe
    public final View a(View view, ViewGroup parent, boolean z) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "inflate view");
        }
        View b = this.f.b();
        Context context = (Context) this.i.get();
        if (b != null && context != null) {
            this.j.a(context, b, this.e);
        }
        return this.f.a(view, parent, z);
    }

    @Override // com.inmobi.media.Xe
    public final View b() {
        return this.f.b();
    }

    @Override // com.inmobi.media.Xe
    public final C2939x8 c() {
        return this.f.b;
    }

    @Override // com.inmobi.media.Xe
    public final void e() {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String TAG = this.h;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "stop tracking for impression");
        }
        try {
            Context context = (Context) this.i.get();
            if (context != null) {
                InterfaceC2971z5 interfaceC2971z52 = this.g;
                if (interfaceC2971z52 != null) {
                    String TAG2 = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((A5) interfaceC2971z52).a(TAG2, "stop tracking");
                }
                this.j.a(context, this.e);
            }
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z53 = this.g;
            if (interfaceC2971z53 != null) {
                String TAG3 = this.h;
                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                ((A5) interfaceC2971z53).b(TAG3, "Exception in stopTrackingForImpression with message : " + e.getMessage());
            }
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        } finally {
            this.f.getClass();
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(View childView, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
        this.f.getClass();
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
    }

    @Override // com.inmobi.media.Xe
    public final void a(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        this.f.getClass();
        Intrinsics.checkNotNullParameter(childView, "childView");
    }

    @Override // com.inmobi.media.Xe
    public final void a(Map map) {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String str = this.h;
            ((A5) interfaceC2971z5).a(str, H6.a(str, "TAG", "start tracking impression with ").append(map != null ? Integer.valueOf(map.size()) : null).append(" friendlyViews").toString());
        }
        try {
            try {
                View videoContainerView = this.f2487a.getVideoContainerView();
                C2763m9 c2763m9 = videoContainerView instanceof C2763m9 ? (C2763m9) videoContainerView : null;
                Context context = (Context) this.i.get();
                AdConfig.ViewabilityConfig viewability = this.d.getViewability();
                if (context != null && c2763m9 != null && !this.e.t) {
                    C2747l9 videoView = c2763m9.getVideoView();
                    InterfaceC2971z5 interfaceC2971z52 = this.g;
                    if (interfaceC2971z52 != null) {
                        String TAG = this.h;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                        ((A5) interfaceC2971z52).a(TAG, "start tracking");
                    }
                    this.j.a(context, videoView, this.e, viewability);
                    View b = this.f.b();
                    Object tag = videoView.getTag();
                    C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
                    if (c2597c9 != null && b != null && a(c2597c9)) {
                        InterfaceC2971z5 interfaceC2971z53 = this.g;
                        if (interfaceC2971z53 != null) {
                            String TAG2 = this.h;
                            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                            ((A5) interfaceC2971z53).a(TAG2, "start tracking inline ad");
                        }
                        Z7 z7 = this.j;
                        C2562a9 c2562a9 = this.e;
                        z7.a(context, b, c2562a9, c2562a9.b0, viewability);
                    }
                }
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z54 = this.g;
                if (interfaceC2971z54 != null) {
                    String TAG3 = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((A5) interfaceC2971z54).b(TAG3, "Exception in startTrackingForImpression with message : " + e.getMessage());
                }
                S5 s5 = S5.f2425a;
                C2640f2 event = new C2640f2(e);
                Intrinsics.checkNotNullParameter(event, "event");
                S5.d.a(event);
            }
            this.f.getClass();
        } catch (Throwable th) {
            this.f.getClass();
            throw th;
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(byte b) {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String str = this.h;
            ((A5) interfaceC2971z5).a(str, X8.a(str, "TAG", "Received event : ", b));
        }
        this.f.getClass();
    }

    @Override // com.inmobi.media.Xe
    public final void a(Context context, byte b) {
        C2603cf c2603cf;
        Intrinsics.checkNotNullParameter(context, "context");
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            String str = this.h;
            ((A5) interfaceC2971z5).c(str, X8.a(str, "TAG", "onActivityStateChanged state - ", b));
        }
        try {
            try {
                if (b == 0) {
                    Z7 z7 = this.j;
                    z7.getClass();
                    Intrinsics.checkNotNullParameter(context, "context");
                    C2662g5 c2662g5 = (C2662g5) z7.d.get(context);
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
                } else if (b == 1) {
                    Z7 z72 = this.j;
                    z72.getClass();
                    Intrinsics.checkNotNullParameter(context, "context");
                    C2662g5 c2662g52 = (C2662g5) z72.d.get(context);
                    if (c2662g52 != null) {
                        Intrinsics.checkNotNullExpressionValue(c2662g52.d, "TAG");
                        c2662g52.c.a();
                        c2662g52.e.removeCallbacksAndMessages(null);
                        c2662g52.b.clear();
                    }
                } else if (b == 2) {
                    Z7 z73 = this.j;
                    z73.getClass();
                    Intrinsics.checkNotNullParameter(context, "context");
                    InterfaceC2971z5 interfaceC2971z52 = z73.b;
                    if (interfaceC2971z52 != null) {
                        String TAG = z73.c;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                        ((A5) interfaceC2971z52).a(TAG, "Activity destroyed, removing impression tracker");
                    }
                    C2662g5 c2662g53 = (C2662g5) z73.d.remove(context);
                    if (c2662g53 != null) {
                        c2662g53.f2577a.clear();
                        c2662g53.b.clear();
                        c2662g53.c.a();
                        c2662g53.e.removeMessages(0);
                        c2662g53.c.b();
                    }
                    if (context instanceof Activity) {
                        z73.d.isEmpty();
                    }
                } else {
                    InterfaceC2971z5 interfaceC2971z53 = this.g;
                    if (interfaceC2971z53 != null) {
                        String TAG2 = this.h;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        ((A5) interfaceC2971z53).b(TAG2, "UnHandled sate ( " + ((int) b) + " ) received in onActivityStateChanged()");
                    }
                }
                c2603cf = this.f;
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z54 = this.g;
                if (interfaceC2971z54 != null) {
                    String TAG3 = this.h;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((A5) interfaceC2971z54).b(TAG3, "Exception in onActivityStateChanged with message : " + e.getMessage());
                }
                S5 s5 = S5.f2425a;
                C2640f2 event = new C2640f2(e);
                Intrinsics.checkNotNullParameter(event, "event");
                S5.d.a(event);
                c2603cf = this.f;
            }
            c2603cf.getClass();
            Intrinsics.checkNotNullParameter(context, "context");
        } catch (Throwable th) {
            this.f.getClass();
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
        Context context = (Context) this.i.get();
        View b = this.f.b();
        if (context != null && b != null) {
            this.j.a(context, b, this.e);
        }
        super.a();
        this.i.clear();
        this.f.a();
    }

    public final boolean a(C2597c9 c2597c9) {
        Object obj = c2597c9.t.get("isFullScreen");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        return this.e.f2437a == 0 && !(bool != null ? bool.booleanValue() : false);
    }
}
