package com.inmobi.media;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import com.inmobi.ads.InMobiAdRequestStatus;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.c8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2596c8 extends S0 {
    public static final /* synthetic */ int Q = 0;
    public WeakReference N;
    public boolean O;
    public int P;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2596c8(Context context, Z placement, V8 v8) {
        super(context, placement, v8);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placement, "placement");
        Intrinsics.checkNotNullExpressionValue("c8", "TAG");
        placement.l();
        a(context, placement, v8);
    }

    public final void D0() {
        try {
            super.g();
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("c8", rf.a(e, H6.a("c8", "TAG", "SDK encountered unexpected error in destroying native ad unit; ")));
            }
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public final void E0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z5).a("c8", "renderAdPostInternetCheck");
        }
        k0();
        try {
            if (!o0()) {
                U0 s = s();
                s.getClass();
                s.g = SystemClock.elapsedRealtime();
                d0();
                return;
            }
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z52).b("c8", "render ad is blocked");
            }
        } catch (IllegalStateException e) {
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z53).a("c8", "Exception while loading ad.", e);
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2134);
        }
    }

    @Override // com.inmobi.media.S0
    public final byte J() {
        return (byte) 0;
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.InterfaceC2553a0
    public final void a(int i, GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.InterfaceC2553a0
    public final void b() {
    }

    @Override // com.inmobi.media.S0
    public final void b(F0 f0) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z5).c("c8", "handleAdScreenDisplayed");
        }
        if (Q() == 4) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z52).d("c8", "AdUnit " + this + " state change - RENDERED");
            }
            d((byte) 6);
        } else if (Q() == 6) {
            this.P++;
        }
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        if (interfaceC2971z53 != null) {
            ((A5) interfaceC2971z53).a("InMobi", "Successfully displayed fullscreen for placement id: " + I());
        }
        if (this.P == 0) {
            if (f0 != null) {
                InterfaceC2971z5 interfaceC2971z54 = this.j;
                if (interfaceC2971z54 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z54).a("c8", "callback - onAdDisplayed");
                }
                d(f0);
                return;
            }
            InterfaceC2971z5 interfaceC2971z55 = this.j;
            if (interfaceC2971z55 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z55).b("c8", "listener is null. cannot give AdDisplayed callback");
            }
        }
    }

    @Override // com.inmobi.media.S0
    public final void c0() {
        if (Z()) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z5).b("c8", "Ad unit is already destroyed! Returning ...");
                return;
            }
            return;
        }
        F0 r = r();
        if (f0()) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z52).b("c8", "Some of the dependency libraries for InMobiNative not found");
            }
            if (r != null) {
                r.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES));
                return;
            }
            return;
        }
        if (1 == Q() || 2 == Q()) {
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z53).b("c8", "An ad load is already in progress");
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            ((A5) interfaceC2971z54).a("c8", H6.a("c8", "TAG", "Fetching a Native ad for placement id: ").append(I()).toString());
        }
        if (4 == Q()) {
            if (!W()) {
                InterfaceC2971z5 interfaceC2971z55 = this.j;
                if (interfaceC2971z55 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z55).a("c8", "An ad is ready with the ad unit. Signaling ad load success ...");
                }
                if (r != null) {
                    Context t = t();
                    InterfaceC2971z5 interfaceC2971z56 = this.j;
                    if (interfaceC2971z56 != null) {
                        Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                        ((A5) interfaceC2971z56).c("c8", "setContainerContext");
                    }
                    InterfaceC2930x k = k();
                    if (k instanceof T7) {
                        ((T7) k).a(t);
                    }
                    InterfaceC2971z5 interfaceC2971z57 = this.j;
                    if (interfaceC2971z57 != null) {
                        Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                        ((A5) interfaceC2971z57).a("c8", "callback - onFetchSuccess");
                    }
                    InterfaceC2971z5 interfaceC2971z58 = this.j;
                    if (interfaceC2971z58 != null) {
                        Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                        ((A5) interfaceC2971z58).a("c8", "callback - onLoadSuccess");
                    }
                    e(r);
                    f(r);
                    return;
                }
                return;
            }
            InterfaceC2971z5 interfaceC2971z59 = this.j;
            if (interfaceC2971z59 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z59).b("c8", "ad is expired - destroy");
            }
            D0();
        }
        e0();
        super.c0();
    }

    @Override // com.inmobi.media.S0
    public final void j0() {
        if (p0()) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z5).a("c8", "renderAd without internet check");
            }
            E0();
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z52).a("c8", "renderAd");
        }
        a(new C2561a8(this), new C2579b8(this));
    }

    @Override // com.inmobi.media.S0
    public final HashMap o() {
        HashMap hashMap = new HashMap();
        hashMap.put("a-parentViewWidth", String.valueOf(U3.d().f2459a));
        hashMap.put("a-productVersion", "NS-1.0.0-20160411");
        hashMap.put("trackerType", "url_ping");
        return hashMap;
    }

    @Override // com.inmobi.media.S0
    public final String q() {
        return "native";
    }

    @Override // com.inmobi.media.S0
    public final void r0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z5).c("c8", "signalSuccess");
        }
        A v = v();
        int hashCode = hashCode();
        E8 e8 = new E8(this);
        v.getClass();
        A.a(hashCode, e8);
    }

    @Override // com.inmobi.media.S0
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.a(context);
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z5).c("c8", "setContainerContext");
        }
        InterfaceC2930x k = k();
        if (k instanceof T7) {
            ((T7) k).a(context);
        }
    }

    public final View a(View view, ViewGroup parent, int i) {
        View view2;
        Intrinsics.checkNotNullParameter(parent, "parent");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z5).c("c8", "getAdView");
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            if (!G4.f2291a.a()) {
                D0();
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z52).b("c8", "dropping because of GDPR");
                }
                return null;
            }
            if (W()) {
                InterfaceC2971z5 interfaceC2971z53 = this.j;
                if (interfaceC2971z53 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z53).a("c8", "Ad has expired.");
                }
                D0();
                return null;
            }
            if (Q() != 4 && Q() != 6) {
                InterfaceC2971z5 interfaceC2971z54 = this.j;
                if (interfaceC2971z54 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z54).b("c8", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling getPrimaryView().");
                }
                AbstractC2680h7.a((byte) 1, "InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling getPrimaryView().");
                InterfaceC2971z5 interfaceC2971z55 = this.j;
                if (interfaceC2971z55 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z55).b("c8", "Ad Load is not complete");
                }
                WeakReference weakReference = this.N;
                if (weakReference == null || (view2 = (View) weakReference.get()) == null) {
                    return null;
                }
                View view3 = new View(Uc.d());
                view3.setLayoutParams(view2.getLayoutParams());
                return view3;
            }
            T7 G = G();
            if (G != null) {
                boolean z = this.O;
                InterfaceC2971z5 interfaceC2971z56 = G.j;
                if (interfaceC2971z56 != null) {
                    String TAG = G.m;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z56).c(TAG, "showOnLockScreen - " + z);
                }
                G.D = z;
                G.B = i;
                final Xe viewableAd = G.getViewableAd();
                r4 = viewableAd != null ? viewableAd.a(view, parent, true) : null;
                this.N = new WeakReference(r4);
                Handler D = D();
                if (D != null) {
                    D.post(new Runnable() { // from class: com.inmobi.media.c8$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            C2596c8.a(C2596c8.this, viewableAd);
                        }
                    });
                }
            }
            return r4;
        }
        InterfaceC2971z5 interfaceC2971z57 = this.j;
        if (interfaceC2971z57 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z57).b("c8", "getPrimaryView called on background thread");
        }
        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.CALLED_FROM_WRONG_THREAD), false, (short) 2150);
        return null;
    }

    public static final void a(C2596c8 this$0, Xe xe) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 interfaceC2971z5 = this$0.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z5).a("c8", "start tracking for impression");
        }
        if (xe != null) {
            xe.a((Map) null);
        }
    }

    @Override // com.inmobi.media.S0
    public final void a(C2947y0 adSet) {
        Intrinsics.checkNotNullParameter(adSet, "adSet");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z5).c("c8", "handleAdFetchSuccessful");
        }
        if (Q() == 1) {
            e(adSet);
        }
        if (!Intrinsics.areEqual(AnalyticsConstants.CREATIVE_TYPE_HTML, E()) && !Intrinsics.areEqual("htmlUrl", E()) && !Intrinsics.areEqual("unknown", E())) {
            super.a(adSet);
            return;
        }
        a(I(), new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), (short) 57);
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z52).b("c8", "invalid markup. fetch failed");
        }
    }

    @Override // com.inmobi.media.S0
    public final void a(F0 f0) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z5).c("c8", "handleAdScreenDismissed");
        }
        if (Q() == 6) {
            int i = this.P;
            if (i > 0) {
                this.P = i - 1;
            } else {
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z52).d("c8", "AdUnit " + this + " state - READY");
                }
                d((byte) 4);
            }
        }
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        if (interfaceC2971z53 != null) {
            ((A5) interfaceC2971z53).a("InMobi", "Successfully dismissed fullscreen for placement id: " + I());
        }
        if (this.P == 0 && Q() == 4) {
            if (f0 != null) {
                InterfaceC2971z5 interfaceC2971z54 = this.j;
                if (interfaceC2971z54 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z54).a("c8", "callback - onAdDismissed");
                }
                f0.b();
            } else {
                InterfaceC2971z5 interfaceC2971z55 = this.j;
                if (interfaceC2971z55 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z55).b("c8", "Listener was garbage collected. Unable to give callback");
                }
            }
            InterfaceC2971z5 interfaceC2971z56 = this.j;
            if (interfaceC2971z56 != null) {
                ((A5) interfaceC2971z56).a();
            }
        }
    }

    @Override // com.inmobi.media.S0
    public final void a(Z placement, boolean z) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z5).c("c8", "handleAssetAvailabilityChanged");
        }
        super.a(placement, z);
        if (!z) {
            if (Intrinsics.areEqual(I(), placement)) {
                if (2 == Q() || 4 == Q()) {
                    d((byte) 0);
                    InterfaceC2971z5 interfaceC2971z52 = this.j;
                    if (interfaceC2971z52 != null) {
                        Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                        ((A5) interfaceC2971z52).d("c8", "AdUnit " + this + " state - CREATED");
                    }
                    F0 r = r();
                    if (r != null) {
                        r.a(this, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE));
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual(I(), placement) || 2 != Q() || r() == null || t() == null) {
            return;
        }
        if (a0()) {
            c(true);
            f();
        } else {
            r0();
        }
    }

    @Override // com.inmobi.media.S0
    public final void a(boolean z, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z5).c("c8", "onDidParseAfterFetch");
        }
        super.a(z, status);
        if (Q() == 2) {
            F0 r = r();
            if (r != null) {
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z52).a("c8", "callback - onFetchSuccess");
                }
                e(r);
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        if (interfaceC2971z53 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z53).b("c8", "invalid state - ignore parse callback");
        }
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.Te
    public final void a(C2672h ad, boolean z, short s) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("c8", "TAG");
            ((A5) interfaceC2971z5).c("c8", "onVastProcessCompleted");
        }
        try {
            if (!z) {
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    ((A5) interfaceC2971z52).b("c8", X8.a("c8", "TAG", "VAST processing failed - ", s));
                }
                b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, s);
                return;
            }
            try {
                super.a(ad, z, s);
            } catch (IllegalStateException e) {
                InterfaceC2971z5 interfaceC2971z53 = this.j;
                if (interfaceC2971z53 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z53).b("c8", "Exception while onVastProcessCompleted : " + e.getMessage());
                }
            }
            C2672h m = m();
            if (m == null) {
                InterfaceC2971z5 interfaceC2971z54 = this.j;
                if (interfaceC2971z54 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z54).b("c8", "current ad is null. failing");
                }
                b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 55);
                return;
            }
            if (T() == 0) {
                if (!m.G()) {
                    InterfaceC2971z5 interfaceC2971z55 = this.j;
                    if (interfaceC2971z55 != null) {
                        Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                        ((A5) interfaceC2971z55).c("c8", "start OMID session for HTML ad");
                    }
                    a(true, (GestureDetectorOnGestureListenerC2634ec) null);
                }
            } else {
                InterfaceC2971z5 interfaceC2971z56 = this.j;
                if (interfaceC2971z56 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z56).c("c8", "start OMID session for current AD");
                }
                a(m);
            }
            if (m.G()) {
                b(true);
                InterfaceC2971z5 interfaceC2971z57 = this.j;
                if (interfaceC2971z57 != null) {
                    Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                    ((A5) interfaceC2971z57).c("c8", "handleInterActive");
                }
                V();
            }
        } catch (Exception e2) {
            InterfaceC2971z5 interfaceC2971z58 = this.j;
            if (interfaceC2971z58 != null) {
                Intrinsics.checkNotNullExpressionValue("c8", "TAG");
                ((A5) interfaceC2971z58).a("c8", "Exception while loading ad.", e2);
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 13);
        }
    }
}
