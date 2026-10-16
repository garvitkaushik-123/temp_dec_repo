package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.inmobi.Omid;
import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.inmobi.adsession.media.VastProperties;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.ma, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2764ma extends We {
    public final We e;
    public C2667ga f;
    public final VastProperties g;
    public final InterfaceC2971z5 h;
    public final String i;
    public final float j;
    public final WeakReference k;
    public WeakReference l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2764ma(Context context, We mViewableAd, C2562a9 adContainer, C2667ga c2667ga, VastProperties mVastProperties, InterfaceC2971z5 interfaceC2971z5) {
        super(adContainer);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mViewableAd, "mViewableAd");
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(mVastProperties, "mVastProperties");
        this.e = mViewableAd;
        this.f = c2667ga;
        this.g = mVastProperties;
        this.h = interfaceC2971z5;
        this.i = "ma";
        this.j = 1.0f;
        this.k = new WeakReference(context);
    }

    @Override // com.inmobi.media.Xe
    public final View a(View view, ViewGroup parent, boolean z) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        return this.e.a(view, parent, z);
    }

    @Override // com.inmobi.media.Xe
    public final View b() {
        return this.e.b();
    }

    @Override // com.inmobi.media.Xe
    public final C2939x8 c() {
        return this.e.c();
    }

    @Override // com.inmobi.media.Xe
    public final View d() {
        return this.e.d();
    }

    @Override // com.inmobi.media.Xe
    public final void e() {
        try {
            InterfaceC2930x interfaceC2930x = this.f2487a;
            if ((interfaceC2930x instanceof C2562a9) && !((C2562a9) interfaceC2930x).k()) {
                C2667ga c2667ga = this.f;
                if (c2667ga != null && C2667ga.a(c2667ga.e, (byte) 2)) {
                    AdSession adSession = c2667ga.f;
                    if (adSession != null) {
                        adSession.finish();
                    }
                    c2667ga.f = null;
                    c2667ga.e = (byte) 3;
                }
                InterfaceC2971z5 interfaceC2971z5 = this.h;
                if (interfaceC2971z5 != null) {
                    String TAG = this.i;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    StringBuilder sb = new StringBuilder("Unregistered VideoView to OMID AdSession : ");
                    C2667ga c2667ga2 = this.f;
                    ((A5) interfaceC2971z5).a(TAG, sb.append(c2667ga2 != null ? c2667ga2.hashCode() : 0).toString());
                }
            }
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z52 = this.h;
            if (interfaceC2971z52 != null) {
                String TAG2 = this.i;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).b(TAG2, "Exception in stopTrackingForImpression with message : " + e.getMessage());
            }
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        } finally {
            this.e.e();
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(View childView, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
        C2667ga c2667ga = this.f;
        if (c2667ga != null) {
            c2667ga.a(childView, obstructionCode);
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(View childView) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        C2667ga c2667ga = this.f;
        if (c2667ga != null) {
            Intrinsics.checkNotNullParameter(childView, "childView");
            byte b = c2667ga.e;
            if (b > 0) {
                AdSession adSession = c2667ga.f;
                if (adSession != null) {
                    adSession.removeFriendlyObstruction(childView);
                    return;
                }
                return;
            }
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(new Exception("Omid AdSession State Error currentState :: " + ((int) b) + ", expectedState :: 1"));
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(Map map) {
        try {
            InterfaceC2971z5 interfaceC2971z5 = this.h;
            if (interfaceC2971z5 != null) {
                String TAG = this.i;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).c(TAG, "startTrackingForImpression");
            }
            if (this.d.getViewability().getOmidConfig().isOmidEnabled()) {
                AbstractC2780na.f2651a.getClass();
                if (Omid.isActive()) {
                    InterfaceC2971z5 interfaceC2971z52 = this.h;
                    if (interfaceC2971z52 != null) {
                        String TAG2 = this.i;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        ((A5) interfaceC2971z52).a(TAG2, "OMID enabled and OM SDK initialised");
                    }
                    InterfaceC2930x interfaceC2930x = this.f2487a;
                    if (interfaceC2930x instanceof C2562a9) {
                        View videoContainerView = ((C2562a9) interfaceC2930x).getVideoContainerView();
                        C2763m9 c2763m9 = videoContainerView instanceof C2763m9 ? (C2763m9) videoContainerView : null;
                        if (c2763m9 instanceof View) {
                            C2631e9 mediaController = c2763m9.getVideoView().getMediaController();
                            this.l = new WeakReference(c2763m9);
                            InterfaceC2971z5 interfaceC2971z53 = this.h;
                            if (interfaceC2971z53 != null) {
                                String TAG3 = this.i;
                                Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                                ((A5) interfaceC2971z53).a(TAG3, "creating new OM SDK ad session");
                            }
                            C2667ga c2667ga = this.f;
                            if (c2667ga != null) {
                                c2667ga.a(c2763m9, mediaController != null ? mediaController.getFriendlyViews() : null, this.e.b());
                            }
                            InterfaceC2971z5 interfaceC2971z54 = this.h;
                            if (interfaceC2971z54 != null) {
                                String TAG4 = this.i;
                                Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                                StringBuilder sb = new StringBuilder("Registered ad view with OMID Video AdSession ");
                                C2667ga c2667ga2 = this.f;
                                ((A5) interfaceC2971z54).a(TAG4, sb.append(c2667ga2 != null ? c2667ga2.hashCode() : 0).toString());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z55 = this.h;
            if (interfaceC2971z55 != null) {
                String TAG5 = this.i;
                Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                ((A5) interfaceC2971z55).b(TAG5, "Exception in startTrackingForImpression with message : " + e.getMessage());
            }
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        } finally {
            this.e.a(map);
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(byte b) {
        try {
            InterfaceC2971z5 interfaceC2971z5 = this.h;
            if (interfaceC2971z5 != null) {
                String TAG = this.i;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).a(TAG, "onAdView - event - " + ((int) b));
            }
            float f = this.j;
            int i = 0;
            if (b == 13) {
                f = 0.0f;
            } else if (b != 14) {
                if (b == 6) {
                    InterfaceC2930x interfaceC2930x = this.f2487a;
                    if (interfaceC2930x instanceof C2562a9) {
                        View videoContainerView = ((C2562a9) interfaceC2930x).getVideoContainerView();
                        C2763m9 c2763m9 = videoContainerView instanceof C2763m9 ? (C2763m9) videoContainerView : null;
                        if (c2763m9 != null) {
                            i = c2763m9.getVideoView().getDuration();
                            Object tag = c2763m9.getVideoView().getTag();
                            f = a(tag instanceof C2597c9 ? (C2597c9) tag : null);
                        }
                    }
                } else if (b == 5) {
                    InterfaceC2930x interfaceC2930x2 = this.f2487a;
                    if ((interfaceC2930x2 instanceof C2562a9) && ((C2562a9) interfaceC2930x2).k()) {
                        return;
                    }
                }
            }
            C2667ga c2667ga = this.f;
            if (c2667ga != null) {
                c2667ga.a(b, i, f, this.g);
            }
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z52 = this.h;
            if (interfaceC2971z52 != null) {
                String TAG2 = this.i;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).b(TAG2, "Exception in onAdEvent with message : " + e.getMessage());
            }
            S5 s5 = S5.f2425a;
            C2640f2 event = new C2640f2(e);
            Intrinsics.checkNotNullParameter(event, "event");
            S5.d.a(event);
        } finally {
            this.e.a(b);
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(Context context, byte b) {
        Intrinsics.checkNotNullParameter(context, "context");
        InterfaceC2971z5 interfaceC2971z5 = this.h;
        if (interfaceC2971z5 != null) {
            String str = this.i;
            ((A5) interfaceC2971z5).c(str, X8.a(str, "TAG", "onActivityStateChanged - state - ", b));
        }
        this.e.a(context, b);
    }

    @Override // com.inmobi.media.Xe
    public final void a() {
        super.a();
        InterfaceC2971z5 interfaceC2971z5 = this.h;
        if (interfaceC2971z5 != null) {
            String TAG = this.i;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "destroy");
        }
        try {
            try {
                this.k.clear();
                WeakReference weakReference = this.l;
                if (weakReference != null) {
                    weakReference.clear();
                }
                this.f = null;
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z52 = this.h;
                if (interfaceC2971z52 != null) {
                    String TAG2 = this.i;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((A5) interfaceC2971z52).b(TAG2, "Exception in destroy with message : " + e.getMessage());
                }
                S5 s5 = S5.f2425a;
                C2640f2 event = new C2640f2(e);
                Intrinsics.checkNotNullParameter(event, "event");
                S5.d.a(event);
            }
        } finally {
            this.e.a();
        }
    }

    public final float a(C2597c9 c2597c9) {
        if (c2597c9 == null) {
            return 0.0f;
        }
        Object obj = c2597c9.t.get("currentMediaVolume");
        Integer num = obj instanceof Integer ? (Integer) obj : null;
        Object obj2 = c2597c9.t.get("lastMediaVolume");
        Integer num2 = obj2 instanceof Integer ? (Integer) obj2 : null;
        if (num == null || num2 == null || num.intValue() <= 0 || num2.intValue() != 0) {
            return 0.0f;
        }
        return this.j;
    }
}
