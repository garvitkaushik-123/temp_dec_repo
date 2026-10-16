package com.inmobi.media;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.iab.omid.library.inmobi.Omid;
import com.iab.omid.library.inmobi.adsession.AdSession;
import com.iab.omid.library.inmobi.adsession.FriendlyObstructionPurpose;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.ka, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2732ka extends We {
    public static final /* synthetic */ int h = 0;
    public final Xe e;
    public C2667ga f;
    public final InterfaceC2971z5 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2732ka(InterfaceC2930x adContainer, Xe mViewableAd, C2667ga c2667ga, InterfaceC2971z5 interfaceC2971z5) {
        super(adContainer);
        Intrinsics.checkNotNullParameter(adContainer, "adContainer");
        Intrinsics.checkNotNullParameter(mViewableAd, "mViewableAd");
        this.e = mViewableAd;
        this.f = c2667ga;
        this.g = interfaceC2971z5;
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
    public final View d() {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("ka", "TAG");
            ((A5) interfaceC2971z5).c("ka", "inflateView called");
        }
        return this.e.d();
    }

    @Override // com.inmobi.media.Xe
    public final void e() {
        try {
            try {
                InterfaceC2971z5 interfaceC2971z5 = this.g;
                if (interfaceC2971z5 != null) {
                    Intrinsics.checkNotNullExpressionValue("ka", "TAG");
                    ((A5) interfaceC2971z5).a("ka", "stopTrackingForImpression");
                }
                C2667ga c2667ga = this.f;
                if (c2667ga != null && C2667ga.a(c2667ga.e, (byte) 2)) {
                    AdSession adSession = c2667ga.f;
                    if (adSession != null) {
                        adSession.finish();
                    }
                    c2667ga.f = null;
                    c2667ga.e = (byte) 3;
                }
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z52 = this.g;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("ka", "TAG");
                    ((A5) interfaceC2971z52).b("ka", "Exception in stopTrackingForImpression with message : " + e.getMessage());
                }
            }
        } finally {
            this.e.e();
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(View childView, FriendlyObstructionPurpose obstructionCode) {
        Intrinsics.checkNotNullParameter(childView, "childView");
        Intrinsics.checkNotNullParameter(obstructionCode, "obstructionCode");
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("ka", "TAG");
            ((A5) interfaceC2971z5).a("ka", "addFriendlyView with obstruction code: " + obstructionCode);
        }
        C2667ga c2667ga = this.f;
        if (c2667ga != null) {
            c2667ga.a(childView, obstructionCode);
        }
        this.e.a(childView, obstructionCode);
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
                }
            } else {
                S5 s5 = S5.f2425a;
                C2640f2 event = new C2640f2(new Exception("Omid AdSession State Error currentState :: " + ((int) b) + ", expectedState :: 1"));
                Intrinsics.checkNotNullParameter(event, "event");
                S5.d.a(event);
            }
        }
        this.e.a(childView);
    }

    @Override // com.inmobi.media.Xe
    public final void a(Map map) {
        View view;
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("ka", "TAG");
            ((A5) interfaceC2971z5).a("ka", "startTrackingForImpression");
        }
        try {
            try {
                if (this.d.getViewability().getOmidConfig().isOmidEnabled()) {
                    AbstractC2780na.f2651a.getClass();
                    if (Omid.isActive()) {
                        InterfaceC2930x interfaceC2930x = this.f2487a;
                        if (interfaceC2930x instanceof T7) {
                            T7 t7 = (T7) interfaceC2930x;
                            view = t7.H;
                            if (view == null) {
                                view = t7.I;
                            }
                        } else {
                            View b = this.e.b();
                            view = b instanceof WebView ? (WebView) b : null;
                        }
                        if (view != null) {
                            InterfaceC2971z5 interfaceC2971z52 = this.g;
                            if (interfaceC2971z52 != null) {
                                Intrinsics.checkNotNullExpressionValue("ka", "TAG");
                                ((A5) interfaceC2971z52).a("ka", "creating OMSDK session");
                            }
                            C2667ga c2667ga = this.f;
                            if (c2667ga != null) {
                                c2667ga.a(view, map, (View) null);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z53 = this.g;
                if (interfaceC2971z53 != null) {
                    Intrinsics.checkNotNullExpressionValue("ka", "TAG");
                    ((A5) interfaceC2971z53).b("ka", "Exception in startTrackingForImpression with message : " + e.getMessage());
                }
            }
        } finally {
            this.e.a(map);
        }
    }

    @Override // com.inmobi.media.Xe
    public final void a(byte b) {
        this.e.a(b);
    }

    @Override // com.inmobi.media.Xe
    public final void a(Context context, byte b) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.e.a(context, b);
    }

    @Override // com.inmobi.media.Xe
    public final void a() {
        InterfaceC2971z5 interfaceC2971z5 = this.g;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("ka", "TAG");
            ((A5) interfaceC2971z5).c("ka", "destroy");
        }
        super.a();
        try {
            this.f = null;
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z52 = this.g;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("ka", "TAG");
                ((A5) interfaceC2971z52).a("ka", "Exception in destroy with message", e);
            }
        } finally {
            this.e.a();
        }
    }
}
