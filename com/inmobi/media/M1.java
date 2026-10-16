package com.inmobi.media;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.ironsource.C3040d4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public class M1 extends S0 implements Application.ActivityLifecycleCallbacks {
    public final String N;
    public final String O;
    public boolean P;
    public int Q;
    public final N1 R;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M1(Context context, Z placement, F0 f0) {
        super(context, placement, f0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.N = "M1";
        this.O = "InMobi";
        this.R = new N1();
        Intrinsics.checkNotNullExpressionValue("M1", "TAG");
        placement.l();
        a(context, placement, f0);
    }

    public static final void c(M1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 interfaceC2971z5 = this$0.j;
        if (interfaceC2971z5 != null) {
            String TAG = this$0.N;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "start loading html ad");
        }
        this$0.s0();
    }

    public static final void e(M1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.Q() != 6) {
                if (this$0.Q() == 7) {
                    this$0.Q++;
                    return;
                }
                return;
            }
            this$0.Q++;
            this$0.d((byte) 7);
            InterfaceC2971z5 interfaceC2971z5 = this$0.j;
            if (interfaceC2971z5 != null) {
                String TAG = this$0.N;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).d(TAG, "AdUnit " + this$0 + " state - ACTIVE");
            }
            InterfaceC2971z5 interfaceC2971z52 = this$0.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).c(this$0.O, "Successfully displayed banner ad for placement Id : " + this$0.I());
            }
            F0 r = this$0.r();
            if (r != null) {
                this$0.d(r);
            }
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z53 = this$0.j;
            if (interfaceC2971z53 != null) {
                String str = this$0.N;
                ((A5) interfaceC2971z53).b(str, rf.a(e, H6.a(str, "TAG", "BannerAdUnit.onAdScreenDisplayed threw unexpected error: ")));
            }
        }
    }

    public static final void f(M1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.Q() == 4) {
                this$0.d((byte) 6);
                InterfaceC2971z5 interfaceC2971z5 = this$0.j;
                if (interfaceC2971z5 != null) {
                    String TAG = this$0.N;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).d(TAG, "AdUnit " + this$0 + " state - RENDERED");
                }
            }
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z52 = this$0.j;
            if (interfaceC2971z52 != null) {
                String str = this$0.N;
                ((A5) interfaceC2971z52).b(str, rf.a(e, H6.a(str, "TAG", "BannerAdUnit.onRenderViewVisible threw unexpected error: ")));
            }
        }
    }

    public static final void g(M1 this$0) {
        LinkedList<C2672h> f;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.b0()) {
            this$0.a(System.currentTimeMillis());
            C2947y0 y = this$0.y();
            if (y != null && (f = y.f()) != null) {
                int i = 0;
                for (Object obj : f) {
                    int i2 = i + 1;
                    if (i < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    this$0.B().add(Integer.valueOf(i));
                    i = i2;
                }
            }
        }
        this$0.s0();
    }

    public boolean D0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "canProceedToLoad ", this));
        }
        if (f0()) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                String TAG = this.N;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z52).b(TAG, "Some of the dependency libraries for Banner not found");
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES), true, (short) 2007);
            return false;
        }
        if (1 == Q() || 2 == Q()) {
            AbstractC2680h7.a((byte) 1, this.O, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                String TAG2 = this.N;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z53).b(TAG2, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
            }
            if (1 == Q()) {
                a((short) 2008);
            } else {
                a((short) 2011);
            }
            return false;
        }
        if (7 != Q()) {
            InterfaceC2971z5 interfaceC2971z54 = this.j;
            if (interfaceC2971z54 != null) {
                ((A5) interfaceC2971z54).c(this.O, "Fetching a Banner ad for placement id: " + I());
            }
            e0();
            return true;
        }
        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false, (short) 2010);
        InterfaceC2971z5 interfaceC2971z55 = this.j;
        if (interfaceC2971z55 != null) {
            String str2 = this.N;
            ((A5) interfaceC2971z55).b(str2, H6.a(str2, "TAG", AbstractC2929we.j).append(I().l()).toString());
        }
        return false;
    }

    public final boolean E0() {
        return Q() == 7;
    }

    public final void F0() {
        Xe viewableAd;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).a(str, J1.a(str, "TAG", "onPause ", this));
        }
        byte Q = Q();
        if (Q == 4 || Q == 6 || Q == 7) {
            InterfaceC2930x k = k();
            Context t = t();
            if (k == null || t == null || (viewableAd = k.getViewableAd()) == null) {
                return;
            }
            viewableAd.a(t, (byte) 1);
        }
    }

    public final void G0() {
        Xe viewableAd;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).a(str, J1.a(str, "TAG", "onResume ", this));
        }
        byte Q = Q();
        if (Q == 4 || Q == 6 || Q == 7) {
            InterfaceC2930x k = k();
            Context t = t();
            if (k == null || t == null || (viewableAd = k.getViewableAd()) == null) {
                return;
            }
            viewableAd.a(t, (byte) 0);
        }
    }

    public final void H0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "registerLifeCycleCallbacks ", this));
        }
        Context t = t();
        if (t != null) {
            Uc.a(t, this);
        }
    }

    public final void I0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.N;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "renderAdPostInternetCheck");
        }
        try {
            if (o0()) {
                return;
            }
            U0 s = s();
            s.getClass();
            s.g = SystemClock.elapsedRealtime();
            d0();
            Handler D = D();
            if (D != null) {
                D.post(new Runnable() { // from class: com.inmobi.media.M1$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        M1.g(M1.this);
                    }
                });
            }
        } catch (IllegalStateException e) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                String TAG2 = this.N;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).a(TAG2, "Exception while loading ad.", e);
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2134);
        }
    }

    @Override // com.inmobi.media.S0
    public final byte J() {
        return (byte) 0;
    }

    public final void J0() {
        Application application;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "unregisterLifeCycleCallbacks ", this));
        }
        Context t = t();
        Activity activity = t instanceof Activity ? (Activity) t : null;
        if (activity == null || (application = activity.getApplication()) == null) {
            return;
        }
        application.unregisterActivityLifecycleCallbacks(this);
    }

    @Override // com.inmobi.media.S0
    public void c0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).a(str, J1.a(str, "TAG", "load ", this));
        }
        if (D0()) {
            super.c0();
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public synchronized void d(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).a(str, J1.a(str, "TAG", "onAdScreenDismissed ", this));
        }
        super.d(renderView);
        Handler D = D();
        if (D != null) {
            D.post(new Runnable() { // from class: com.inmobi.media.M1$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    M1.d(M1.this);
                }
            });
        }
    }

    @Override // com.inmobi.media.S0
    public boolean f0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 == null) {
            return false;
        }
        String str = this.N;
        ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "missingPrerequisitesForAd ", this));
        return false;
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.AbstractC2669gc
    public void i(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "onRenderViewVisible ", this));
        }
        super.i(renderView);
        Handler D = D();
        if (D != null) {
            D.post(new Runnable() { // from class: com.inmobi.media.M1$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    M1.f(M1.this);
                }
            });
        }
    }

    @Override // com.inmobi.media.S0
    public void j0() {
        if (p0()) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                String TAG = this.N;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).a(TAG, "renderAd without internet check");
            }
            I0();
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            String TAG2 = this.N;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).a(TAG2, "renderAd");
        }
        a(new K1(this), new L1(this));
    }

    @Override // com.inmobi.media.S0
    public final void m(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).a(str, J1.a(str, "TAG", "handleRenderViewSignaledAdReady ", this));
        }
        super.m(gestureDetectorOnGestureListenerC2634ec);
        if (b0() && this.g.indexOf(gestureDetectorOnGestureListenerC2634ec) > 0 && Q() == 6) {
            b((byte) 1);
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = (GestureDetectorOnGestureListenerC2634ec) this.g.get(A());
            if (gestureDetectorOnGestureListenerC2634ec2 != null) {
                gestureDetectorOnGestureListenerC2634ec2.a(true);
                return;
            }
            return;
        }
        if (Q() != 2) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                String str2 = this.N;
                ((A5) interfaceC2971z52).a(str2, H6.a(str2, "TAG", "AdUnit is not in available state, ignoring the ad ready signal - ").append((int) Q()).toString());
                return;
            }
            return;
        }
        b((byte) 1);
        d((byte) 4);
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        if (interfaceC2971z53 != null) {
            String TAG = this.N;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z53).d(TAG, "AdUnit " + this + " state - READY");
        }
        U0 s = s();
        s.getClass();
        s.i = SystemClock.elapsedRealtime();
        u0();
        z0();
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            ((A5) interfaceC2971z54).c(this.O, "Successfully loaded Banner ad markup in the WebView for placement id: " + I());
        }
        F0 r = r();
        if (r != null) {
            f(r);
        } else {
            InterfaceC2971z5 interfaceC2971z55 = this.j;
            if (interfaceC2971z55 != null) {
                String TAG2 = this.N;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z55).b(TAG2, "AdUnit listener is null");
            }
        }
        i();
    }

    @Override // com.inmobi.media.S0
    public void o(GestureDetectorOnGestureListenerC2634ec renderView) {
        int indexOf;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (b0() && (indexOf = this.g.indexOf(renderView)) > A() && renderView.F != EnumC2620df.c) {
            B().remove(Integer.valueOf(indexOf));
        } else {
            C0();
            super.o(renderView);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "onActivityCreated ", this));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "onActivityDestroyed ", this));
        }
        Context t = t();
        if (Intrinsics.areEqual(t, activity)) {
            Intrinsics.checkNotNull(t, "null cannot be cast to non-null type android.app.Activity");
            ((Activity) t).getApplication().unregisterActivityLifecycleCallbacks(this);
            g();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "onActivityPaused ", this));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "onActivityResumed ", this));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "onActivitySaveInstanceState ", this));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "onActivityStarted ", this));
        }
        if (Intrinsics.areEqual(t(), activity)) {
            G0();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "onActivityStopped ", this));
        }
        if (Intrinsics.areEqual(t(), activity)) {
            F0();
        }
    }

    @Override // com.inmobi.media.S0
    public String q() {
        return "banner";
    }

    @Override // com.inmobi.media.S0
    public GestureDetectorOnGestureListenerC2634ec w() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "htmlAdContainer getter ", this));
        }
        GestureDetectorOnGestureListenerC2634ec w = super.w();
        if (I().p() && w != null) {
            w.e();
        }
        return w;
    }

    @Override // com.inmobi.media.S0
    public void a(boolean z, InMobiAdRequestStatus status) {
        F0 r;
        Intrinsics.checkNotNullParameter(status, "status");
        super.a(z, status);
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "onDidParseAfterFetch ", this));
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).c(this.O, "Banner ad fetch successful for placement id: " + I());
        }
        if (Q() != 2 || (r = r()) == null) {
            return;
        }
        e(r);
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.InterfaceC2553a0
    public void b() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).a(str, J1.a(str, "TAG", "closeAll ", this));
        }
    }

    @Override // com.inmobi.media.S0
    public final HashMap o() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).c(str, J1.a(str, "TAG", "adSpecificRequestParams getter ", this));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("u-rt", this.P ? "1" : "0");
        hashMap.put("mk-ad-slot", I().a());
        return hashMap;
    }

    public static final void a(M1 this$0, GestureDetectorOnGestureListenerC2634ec renderView, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderView, "$renderView");
        int indexOf = this$0.g.indexOf(renderView);
        try {
            F0 r = this$0.r();
            InterfaceC2971z5 interfaceC2971z5 = this$0.j;
            if (interfaceC2971z5 != null) {
                String TAG = this$0.N;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).c(TAG, "callback onShowNextPodAd");
            }
            if (r != null) {
                r.a(i, indexOf, renderView);
            }
        } catch (Exception unused) {
            this$0.b(indexOf, false);
            this$0.g(indexOf);
        }
    }

    @Override // com.inmobi.media.S0
    public final void a(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec, short s) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).a(str, J1.a(str, "TAG", "handleRenderViewSignaledAdFailed ", this));
        }
        super.a(gestureDetectorOnGestureListenerC2634ec, s);
        if (b0()) {
            int indexOf = this.g.indexOf(gestureDetectorOnGestureListenerC2634ec);
            S0.a(this, indexOf, false, 2, null);
            if (indexOf > 0 && Q() == 6) {
                b((byte) 1);
                GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = (GestureDetectorOnGestureListenerC2634ec) this.g.get(A());
                if (gestureDetectorOnGestureListenerC2634ec2 != null) {
                    gestureDetectorOnGestureListenerC2634ec2.a(false);
                }
            }
        }
        if (Q() == 2) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).c(this.O, "Failed to load the Banner markup in the WebView for placement id: " + I());
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, s);
        }
    }

    public static final void d(M1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            if (this$0.Q() == 7) {
                int i = this$0.Q - 1;
                this$0.Q = i;
                if (i == 0) {
                    this$0.d((byte) 6);
                    F0 r = this$0.r();
                    if (r != null) {
                        r.b();
                    }
                }
            }
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z5 = this$0.j;
            if (interfaceC2971z5 != null) {
                String str = this$0.N;
                ((A5) interfaceC2971z5).b(str, rf.a(e, H6.a(str, "TAG", "BannerAdUnit.onAdScreenDismissed threw unexpected error: ")));
            }
        }
    }

    @Override // com.inmobi.media.S0
    public void g() {
        this.R.f2369a = false;
        super.g();
    }

    public final void e(boolean z) {
        InterfaceC2971z5 interfaceC2971z5;
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            String str = this.N;
            ((A5) interfaceC2971z52).a(str, J1.a(str, "TAG", "load ", this));
        }
        if (z && (interfaceC2971z5 = this.j) != null) {
            ((A5) interfaceC2971z5).c(this.O, "Initiating Banner refresh for placement id: " + I());
        }
        this.P = z;
        c0();
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.InterfaceC2553a0
    public void a(int i, GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).a(str, J1.a(str, "TAG", "loadPodAd ", this));
        }
        if (B().contains(Integer.valueOf(i)) && i > this.g.indexOf(renderView)) {
            h(i);
            Handler D = D();
            if (D != null) {
                D.post(new Runnable() { // from class: com.inmobi.media.M1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        M1.c(M1.this);
                    }
                });
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            String TAG = this.N;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z52).a(TAG, "No more ads present in pod adSet or current adSet is not pod adSet");
        }
        ArrayList arrayList = this.g;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) arrayList.get(arrayList.indexOf(renderView));
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            gestureDetectorOnGestureListenerC2634ec.a(false);
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public synchronized void e(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str = this.N;
            ((A5) interfaceC2971z5).a(str, J1.a(str, "TAG", "onAdScreenDisplayed ", this));
        }
        super.e(renderView);
        Handler D = D();
        if (D != null) {
            D.post(new Runnable() { // from class: com.inmobi.media.M1$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    M1.e(M1.this);
                }
            });
        }
    }

    public final void e(String str) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str2 = this.N;
            ((A5) interfaceC2971z5).c(str2, J1.a(str2, "TAG", "setAdSize ", this));
        }
        Z I = I();
        Intrinsics.checkNotNull(str);
        I.a(str);
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.InterfaceC2553a0
    public void a(final int i, final GestureDetectorOnGestureListenerC2634ec renderView, Context context) {
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.N;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "showPodAdAtIndex " + this + " index - " + i);
        }
        if (!b0()) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                String TAG2 = this.N;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).b(TAG2, "Cannot show an pod ad as isPod is not set.");
            }
            ArrayList arrayList = this.g;
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = (GestureDetectorOnGestureListenerC2634ec) arrayList.get(arrayList.indexOf(renderView));
            if (gestureDetectorOnGestureListenerC2634ec2 != null) {
                gestureDetectorOnGestureListenerC2634ec2.b(false);
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        if (interfaceC2971z53 != null) {
            String TAG3 = this.N;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            ((A5) interfaceC2971z53).c(TAG3, "isInValidShowPodIndex " + i + ' ' + B() + ' ' + this.g.indexOf(renderView) + ' ' + this + ' ');
        }
        if (B().contains(Integer.valueOf(i)) && i > this.g.indexOf(renderView) && this.g.get(i) != null && ((gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) this.g.get(i)) == null || gestureDetectorOnGestureListenerC2634ec.x0)) {
            super.a(i, renderView, context);
            Handler D = D();
            if (D != null) {
                D.post(new Runnable() { // from class: com.inmobi.media.M1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        M1.a(M1.this, renderView, i);
                    }
                });
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            String TAG4 = this.N;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            ((A5) interfaceC2971z54).b(TAG4, "Cannot show an pod ad with invalid index passed");
        }
        ArrayList arrayList2 = this.g;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec3 = (GestureDetectorOnGestureListenerC2634ec) arrayList2.get(arrayList2.indexOf(renderView));
        if (gestureDetectorOnGestureListenerC2634ec3 != null) {
            gestureDetectorOnGestureListenerC2634ec3.b(false);
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void a(D1 audioStatusInternal) {
        Intrinsics.checkNotNullParameter(audioStatusInternal, "audioStatusInternal");
        F0 r = r();
        if (r != null) {
            r.a(audioStatusInternal);
        }
        N1 n1 = this.R;
        n1.getClass();
        Intrinsics.checkNotNullParameter(audioStatusInternal, "audioStatusInternal");
        if (!n1.f2369a && audioStatusInternal == D1.e) {
            n1.f2369a = true;
            C2904v5 c2904v5 = C2904v5.c;
            c2904v5.f2421a = System.currentTimeMillis();
            c2904v5.b++;
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public void a(boolean z) {
        C2904v5 c2904v5 = C2904v5.c;
        Context d = Uc.d();
        if (d == null) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = C6.b;
        C6 a2 = B6.a(d, "banner_audio_pref_file");
        Intrinsics.checkNotNullParameter("user_mute_count", C3040d4.h.W);
        int i = a2.f2249a.getInt("user_mute_count", 0);
        C6.a(a2, "user_mute_count", z ? Math.max(0, i - 1) : i + 1, false, 4, (Object) null);
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.AbstractC2669gc
    public void a(GestureDetectorOnGestureListenerC2634ec renderView, boolean z) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        super.a(renderView, z);
        byte Q = Q();
        if (Q != 4 && Q != 6) {
            if (Q == 7) {
                renderView.a(z, Q() == 7 ? z ? (short) 2224 : (short) 2223 : (short) 2227);
                return;
            }
            return;
        }
        byte Q2 = Q();
        if (Q2 == 4) {
            r1 = z ? (short) 2220 : (short) 2219;
        } else if (Q2 == 6) {
            r1 = z ? (short) 2222 : (short) 2221;
        }
        m0();
        renderView.a(z, r1);
    }
}
