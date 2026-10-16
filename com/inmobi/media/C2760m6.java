package com.inmobi.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.SparseArray;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.TelemetryConfig;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.m6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2760m6 extends S0 {
    public int N;
    public boolean O;
    public Nd P;
    public Function0 Q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2760m6(Context context, Z adPlacement, F0 f0) {
        super(context, adPlacement, f0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adPlacement, "adPlacement");
        this.P = new Nd();
        Intrinsics.checkNotNullExpressionValue("m6", "TAG");
        adPlacement.l();
        a(context, adPlacement, f0);
        c("activity");
    }

    public static final void c(C2760m6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(this$0.r());
    }

    public static final void d(C2760m6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b(this$0.r());
    }

    public static final /* synthetic */ String e() {
        return "m6";
    }

    public final boolean D0() {
        if (f0()) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                ((A5) interfaceC2971z5).a("m6", "Some of the dependency libraries for Interstitial not found");
            }
            a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES), true, (short) 2007);
            return false;
        }
        F0 r = r();
        if (r == null) {
            return false;
        }
        byte Q = Q();
        if (Q == 1) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b("InMobiInterstitial", AbstractC2929we.n + I());
            }
            a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD), false, (short) 2008);
        } else if (Q == 7 || Q == 6) {
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).b("InMobiInterstitial", AbstractC2929we.j + I());
            }
            a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false, (short) 2010);
        } else {
            if (Q != 2) {
                if (4 == Q()) {
                    if (!W()) {
                        InterfaceC2971z5 interfaceC2971z54 = this.j;
                        if (interfaceC2971z54 != null) {
                            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                            ((A5) interfaceC2971z54).a("m6", "An ad is ready with the ad unit. Signaling ad load success ...");
                        }
                        F0 r2 = r();
                        if (r2 == null) {
                            InterfaceC2971z5 interfaceC2971z55 = this.j;
                            if (interfaceC2971z55 != null) {
                                ((A5) interfaceC2971z55).b("InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
                            }
                        } else {
                            e(r2);
                            f(r2);
                        }
                        return false;
                    }
                    g();
                }
                e0();
                return true;
            }
            if (Intrinsics.areEqual(AnalyticsConstants.CREATIVE_TYPE_HTML, E()) || Intrinsics.areEqual("htmlUrl", E())) {
                InterfaceC2971z5 interfaceC2971z56 = this.j;
                if (interfaceC2971z56 != null) {
                    ((A5) interfaceC2971z56).b("InMobiInterstitial", AbstractC2929we.n + I());
                }
                a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.REPETITIVE_LOAD), false, (short) 2011);
            } else {
                e(r);
            }
        }
        return false;
    }

    public final boolean E0() {
        InterfaceC2971z5 interfaceC2971z5;
        C2672h m = m();
        if (m == null) {
            return false;
        }
        AdConfig j = j();
        Intrinsics.checkNotNull(j);
        boolean a2 = m.a(j.getCacheConfig(q()).getTimeToLive());
        if (a2 && (interfaceC2971z5 = this.j) != null) {
            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
            ((A5) interfaceC2971z5).b("m6", "Top ad has expired, failing show of ad.");
        }
        return !a2;
    }

    @Override // com.inmobi.media.S0
    public Integer F() {
        AdConfig j = j();
        if (j != null) {
            return Integer.valueOf(j.getMinimumRefreshInterval());
        }
        return null;
    }

    public final void F0() {
        InterfaceC2930x k = k();
        if (k == null) {
            return;
        }
        this.O = true;
        k.e();
    }

    public final Nd G0() {
        return this.P;
    }

    public final boolean H0() {
        return Q() == 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0058, code lost:
    
        r0 = D();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r0 == null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        r0.post(new com.inmobi.media.m6$$ExternalSyntheticLambda0(r6));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0066, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void I0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
            ((A5) interfaceC2971z5).a("m6", "renderAdPostInternetCheck");
        }
        k0();
        try {
            if (o0()) {
                return;
            }
            U0 s = s();
            s.getClass();
            s.g = SystemClock.elapsedRealtime();
            d0();
            String E = E();
            int hashCode = E.hashCode();
            if (hashCode != -1084172778) {
                if (hashCode != 3213227) {
                }
            } else if (E.equals("inmobiJson")) {
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                    ((A5) interfaceC2971z52).a("m6", "Waiting for Vast Processing");
                    return;
                }
                return;
            }
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                ((A5) interfaceC2971z53).a("m6", "Cannot handle markupType: " + E());
            }
        } catch (IllegalStateException e) {
            InterfaceC2971z5 interfaceC2971z54 = this.j;
            if (interfaceC2971z54 != null) {
                Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                ((A5) interfaceC2971z54).a("m6", "Exception while loading ad.", e);
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2134);
        }
    }

    @Override // com.inmobi.media.S0
    public final byte J() {
        return (byte) 1;
    }

    public boolean J0() {
        return 2 == Q();
    }

    public final void K0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).c(e, "submitAdNotReady " + this);
        }
        Nd nd = this.P;
        U0 s = s();
        C2672h b = this.A ? b(this.x) : m();
        String p = b != null ? b.p() : null;
        C2947y0 y = y();
        Boolean o = y != null ? y.o() : null;
        String E = E();
        byte Q = Q();
        W adNotReadyMetadata = new W(s, p, o, E, Q);
        nd.getClass();
        Intrinsics.checkNotNullParameter(adNotReadyMetadata, "adNotReadyMetadata");
        HashMap hashMap = new HashMap();
        long j = s.c;
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        hashMap.put("latency", Long.valueOf(SystemClock.elapsedRealtime() - j));
        hashMap.put(IronSourceConstants.EVENTS_ERROR_CODE, Short.valueOf(Q == 0 ? (short) 2204 : Q == 1 ? (short) 2205 : Q == 2 ? (short) 2206 : Q == 3 ? (short) 2207 : Q == 6 ? (short) 2208 : Q == 7 ? (short) 2209 : Q == 8 ? (short) 2242 : (short) 2210));
        if (E != null) {
            hashMap.put("markupType", E);
        }
        if (p != null) {
            hashMap.put("creativeType", "\"" + p + '\"');
        }
        if (o != null) {
            hashMap.put("isRewarded", o);
        }
        String a2 = s.a();
        if (a2.length() > 0) {
            hashMap.put("metadataBlob", a2);
        }
        hashMap.put("adType", s.f2445a.q());
        hashMap.put("networkType", L3.q());
        hashMap.put("plId", Long.valueOf(s.f2445a.I().l()));
        hashMap.put("isAdLoaded", Boolean.valueOf(nd.f2376a));
        String m = s.f2445a.I().m();
        if (m != null) {
            hashMap.put("plType", m);
        }
        Pd pd = Pd.f2401a;
        Pd.b("AdNotReady", hashMap, Td.f2443a);
    }

    public final void L0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).a("InMobiInterstitial", "Successfully loaded Interstitial ad markup in the WebView for placement id: " + I());
        }
        i();
        r0();
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.InterfaceC2553a0
    public void a(int i, GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
    }

    public final short b(Context context) {
        try {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                ((A5) interfaceC2971z5).a("m6", ">>> Starting InMobiAdActivity to display interstitial ad ...");
            }
            InterfaceC2930x container = k();
            if (container == null) {
                return (short) 2155;
            }
            if (Intrinsics.areEqual("unknown", container.getMarkupType())) {
                return (short) 2156;
            }
            SparseArray sparseArray = InMobiAdActivity.k;
            Intrinsics.checkNotNullParameter(container, "container");
            int hashCode = container.hashCode();
            InMobiAdActivity.k.put(hashCode, container);
            Intent intent = new Intent(context, (Class<?>) InMobiAdActivity.class);
            InterfaceC2971z5 obj = this.j;
            if (obj != null) {
                String uuid = UUID.randomUUID().toString();
                Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
                HashMap hashMap = AbstractC2759m5.f2639a;
                String key = uuid.toString();
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(obj, "obj");
                AbstractC2759m5.f2639a.put(key, new WeakReference(obj));
                intent.putExtra("loggerCacheKey", uuid.toString());
            }
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_INDEX", hashCode);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
            String E = E();
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_CONTAINER_TYPE", Intrinsics.areEqual(E, AnalyticsConstants.CREATIVE_TYPE_HTML) ? 200 : Intrinsics.areEqual(E, "htmlUrl") ? 202 : 201);
            intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_IS_FULL_SCREEN", true);
            if (context == null) {
                return (short) 2157;
            }
            if (b0()) {
                if (C() == -1) {
                    a(System.currentTimeMillis());
                }
                if (z() > 0) {
                    intent.setFlags(603979776);
                }
            }
            Uc.f2453a.a(context, intent);
            return (short) 0;
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).b("InMobiInterstitial", "Cannot show ad; SDK encountered an unexpected error");
            }
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return (short) 2154;
        }
    }

    @Override // com.inmobi.media.S0
    public void c0() {
        if (D0()) {
            super.c0();
        }
    }

    @Override // com.inmobi.media.S0
    public void g() {
        super.g();
        this.Q = null;
    }

    public final void h(F0 f0) {
        short b = b(t());
        if (f0 == null) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("InMobiInterstitial", "Listener was garbage collected.Unable to give callback");
                return;
            }
            return;
        }
        if (b != 0) {
            a(true, b);
        } else {
            f0.e();
        }
    }

    public final void i(F0 f0) {
        if (f0 == null) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
            }
            a(true, (short) 2151);
            return;
        }
        Function0 function0 = this.Q;
        if (function0 != null) {
            function0.invoke();
            return;
        }
        if (Q() == 8) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                ((A5) interfaceC2971z52).b("m6", "unload has been called on this ad. Dont show. ");
            }
            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
            AbstractC2680h7.a((byte) 2, "m6", "Failed to show Ad as creative has called unload() on the Ad");
            a(true, (short) 2239);
            return;
        }
        if (!H0()) {
            AbstractC2680h7.a((byte) 2, "InMobiInterstitial", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                ((A5) interfaceC2971z53).b("m6", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            }
            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
            AbstractC2680h7.a((byte) 1, "m6", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
            a(true, (short) 2152);
            return;
        }
        g(f0);
        d((byte) 6);
        if (!Intrinsics.areEqual(AnalyticsConstants.CREATIVE_TYPE_HTML, E()) && !Intrinsics.areEqual("htmlUrl", E())) {
            A v = v();
            int hashCode = hashCode();
            C2644f6 c2644f6 = new C2644f6(this, f0);
            v.getClass();
            A.a(hashCode, c2644f6);
            return;
        }
        if (!W()) {
            h(f0);
            return;
        }
        b(f0, (short) 2153);
        InterfaceC2930x k = k();
        if (k != null) {
            k.b();
        }
    }

    public final void j(final F0 f0) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            i(f0);
        } else {
            int i = AbstractC2970z4.f2771a;
            ((ExecutorC2793o7) AbstractC2970z4.d.getValue()).f2659a.post(new Runnable() { // from class: com.inmobi.media.m6$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    C2760m6.a(C2760m6.this, f0);
                }
            });
        }
    }

    @Override // com.inmobi.media.S0
    public void j0() {
        if (p0()) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                ((A5) interfaceC2971z5).a("m6", "renderAd without internet check");
            }
            I0();
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
            ((A5) interfaceC2971z52).a("m6", "renderAd");
        }
        a(new C2728k6(this), new C2744l6(this));
    }

    @Override // com.inmobi.media.S0
    public void k0() {
        super.k0();
        this.N = 0;
    }

    @Override // com.inmobi.media.S0
    public void m(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec) {
        super.m(gestureDetectorOnGestureListenerC2634ec);
        if (!b0()) {
            if (Q() == 2) {
                b((byte) 1);
                L0();
                return;
            }
            return;
        }
        int indexOf = this.g.indexOf(gestureDetectorOnGestureListenerC2634ec);
        if (indexOf < A()) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                ((A5) interfaceC2971z5).a("m6", "Ignoring loaded ad with index " + indexOf + " as current rendering index is " + A());
                return;
            }
            return;
        }
        B().add(Integer.valueOf(indexOf));
        for (int i = 0; i < indexOf; i++) {
            if (this.g.get(i) != null) {
                return;
            }
        }
        if (Q() == 2) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).a("m6", X8.a("m6", "TAG", "Providing success based on index ", indexOf));
            }
            b((byte) 1);
            i(indexOf);
            L0();
        }
    }

    @Override // com.inmobi.media.S0
    public void o(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (!b0()) {
            C0();
        } else if (!a(renderView)) {
            C0();
        }
        super.o(renderView);
    }

    @Override // com.inmobi.media.S0
    public String q() {
        return "int";
    }

    @Override // com.inmobi.media.S0
    public void q0() {
        F0 r = r();
        if (r != null) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                ((A5) interfaceC2971z5).a("m6", "callback - onFetchSuccess");
            }
            e(r);
            return;
        }
        b((short) 2188);
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
            ((A5) interfaceC2971z52).b("m6", "listener is null");
        }
    }

    @Override // com.inmobi.media.S0
    public void r0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
            ((A5) interfaceC2971z5).d("m6", "AdUnit " + this + " state - READY");
        }
        d((byte) 4);
        U0 s = s();
        s.getClass();
        s.i = SystemClock.elapsedRealtime();
        u0();
        z0();
        this.P.f2376a = true;
        F0 r = r();
        if (r == null || !r.a()) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
            ((A5) interfaceC2971z52).a("m6", "signaling Success");
        }
        f(r);
    }

    @Override // com.inmobi.media.S0
    public GestureDetectorOnGestureListenerC2634ec w() {
        GestureDetectorOnGestureListenerC2634ec w = super.w();
        if (this.O && w != null) {
            w.e();
        }
        return w;
    }

    public static final void e(C2760m6 this$0) {
        LinkedList<C2672h> f;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.s0();
        if (this$0.b0()) {
            C2947y0 y = this$0.y();
            int size = (y == null || (f = y.f()) == null) ? 0 : f.size();
            for (int i = 1; i < size; i++) {
                this$0.h(this$0.z() + 1);
                this$0.s0();
            }
        }
    }

    @Override // com.inmobi.media.S0
    public void c(String monetizationContext) {
        Intrinsics.checkNotNullParameter(monetizationContext, "monetizationContext");
        super.c("activity");
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public synchronized void d(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        super.d(renderView);
        Handler D = D();
        if (D != null) {
            D.post(new Runnable() { // from class: com.inmobi.media.m6$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    C2760m6.c(C2760m6.this);
                }
            });
        }
    }

    public final void a(Nd nd) {
        Intrinsics.checkNotNullParameter(nd, "<set-?>");
        this.P = nd;
    }

    @Override // com.inmobi.media.S0
    public void a(byte[] bArr) {
        if (D0()) {
            super.a(bArr);
        }
    }

    public static final void a(C2760m6 this$0, F0 f0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.i(f0);
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public synchronized void e(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        super.e(renderView);
        Handler D = D();
        if (D != null) {
            D.post(new Runnable() { // from class: com.inmobi.media.m6$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    C2760m6.d(C2760m6.this);
                }
            });
        }
    }

    public static final void a(final C2760m6 this$0, GestureDetectorOnGestureListenerC2634ec renderView, Context context) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(renderView, "$renderView");
        final int indexOf = this$0.g.indexOf(renderView);
        ArrayList list = this$0.g;
        Intrinsics.checkNotNullParameter(list, "list");
        if (indexOf < 0 || indexOf >= list.size()) {
            return;
        }
        short b = this$0.b(context);
        if (b != 0) {
            this$0.g(indexOf);
        }
        this$0.b(indexOf, b == 0);
        Handler D = this$0.D();
        if (D != null) {
            D.post(new Runnable() { // from class: com.inmobi.media.m6$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    C2760m6.a(C2760m6.this, indexOf);
                }
            });
        }
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.InterfaceC2553a0
    public void a(GestureDetectorOnGestureListenerC2634ec renderView, Context context) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).c(e, "closeCurrentPodAd " + this);
        }
        if (b0()) {
            Integer higher = B().higher(Integer.valueOf(this.g.indexOf(renderView)));
            if (higher != null) {
                a(higher.intValue(), renderView, context);
            } else {
                b();
            }
        }
    }

    @Override // com.inmobi.media.S0
    public void a(F0 f0) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            ((A5) interfaceC2971z5).c("m6", H6.a("m6", "TAG", "handleAdScreenDismissed ").append((int) Q()).toString());
        }
        if (Q() == 7) {
            int i = this.N - 1;
            this.N = i;
            if (i == 1) {
                d((byte) 6);
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                    ((A5) interfaceC2971z52).d("m6", "AdUnit " + this + " state - RENDERED");
                    return;
                }
                return;
            }
            return;
        }
        if (Q() == 6 || Q() == 8) {
            this.N--;
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).a("InMobiInterstitial", "Interstitial ad dismissed for placement id: " + I());
            }
            if (f0 != null) {
                f0.b();
                return;
            }
            InterfaceC2971z5 interfaceC2971z54 = this.j;
            if (interfaceC2971z54 != null) {
                ((A5) interfaceC2971z54).c("InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
            }
        }
    }

    @Override // com.inmobi.media.S0
    public void b(F0 f0) {
        if (Q() == 6) {
            int i = this.N + 1;
            this.N = i;
            if (i == 1) {
                InterfaceC2971z5 interfaceC2971z5 = this.j;
                if (interfaceC2971z5 != null) {
                    ((A5) interfaceC2971z5).a("InMobiInterstitial", "Successfully displayed Interstitial for placement id: " + I());
                }
                if (f0 != null) {
                    b((byte) 4);
                    d(f0);
                    return;
                }
                return;
            }
            d((byte) 7);
            return;
        }
        if (Q() == 7) {
            this.N++;
        }
    }

    public final void b(F0 f0, short s) {
        a(true, s);
        d((byte) 0);
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.InterfaceC2553a0
    public void b() {
        if (b0()) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                ((A5) interfaceC2971z5).a("m6", "Closing the ad as closeAll is called");
            }
            Handler D = D();
            if (D != null) {
                D.post(new Runnable() { // from class: com.inmobi.media.m6$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2760m6.b(C2760m6.this);
                    }
                });
            }
        }
    }

    public static final void b(C2760m6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 interfaceC2971z5 = this$0.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("S0", "TAG");
            ((A5) interfaceC2971z5).a("S0", "clearAdPods " + this$0);
        }
        if (this$0.A) {
            this$0.h();
            this$0.g.clear();
            this$0.w = 0;
            this$0.x = 0;
            this$0.z.clear();
        }
        InterfaceC2971z5 interfaceC2971z52 = this$0.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).c("InMobiInterstitial", "Interstitial ad dismissed for placement id: " + this$0.I());
        }
        if (this$0.r() != null) {
            F0 r = this$0.r();
            if (r != null) {
                r.b();
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = this$0.j;
        if (interfaceC2971z53 != null) {
            ((A5) interfaceC2971z53).c("InMobiInterstitial", "Listener was garbage collected. Unable to give callback");
        }
    }

    @Override // com.inmobi.media.S0
    public void a(boolean z, InMobiAdRequestStatus status) {
        String placementType;
        Intrinsics.checkNotNullParameter(status, "status");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
            ((A5) interfaceC2971z5).c("m6", "onDidParseAfterFetch - parsingResult - " + z);
        }
        super.a(z, status);
        if (Q() == 2) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                ((A5) interfaceC2971z52).a("InMobiInterstitial", "Interstitial ad successfully fetched for placement id: " + I());
            }
            if (Intrinsics.areEqual(E(), "inmobiJson") && (placementType = I().m()) != null) {
                EnumC2560a7 enumC2560a7 = Cb.f2253a;
                InterfaceC2971z5 interfaceC2971z53 = this.j;
                Intrinsics.checkNotNullParameter("intNative", "logType");
                Intrinsics.checkNotNullParameter(placementType, "placementType");
                TelemetryConfig.LoggingConfig loggingConfig = Cb.d.getLoggingConfig();
                if (interfaceC2971z53 != null) {
                    EnumC2560a7 logLevel = Cb.a("intNative", placementType, loggingConfig);
                    double b = Cb.b("intNative", placementType, loggingConfig);
                    C2955y5 config = new C2955y5(logLevel, b);
                    Intrinsics.checkNotNullParameter(config, "config");
                    Objects.toString(config);
                    Ab ab = ((A5) interfaceC2971z53).f2231a;
                    if (ab != null) {
                        Intrinsics.checkNotNullParameter(config, "config");
                        Objects.toString(config);
                        Objects.toString(ab.i);
                        if (!ab.i.get()) {
                            C2595c7 c2595c7 = ab.e;
                            c2595c7.getClass();
                            Intrinsics.checkNotNullParameter(logLevel, "logLevel");
                            c2595c7.f2534a = logLevel;
                            ab.f.f2400a = b;
                        }
                    }
                }
            }
            q0();
        }
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.Te
    public void a(C2672h ad, boolean z, short s) {
        Intrinsics.checkNotNullParameter(ad, "ad");
        if (!z) {
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, s);
            return;
        }
        try {
            super.a(ad, z, s);
        } catch (IllegalStateException e) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                ((A5) interfaceC2971z5).b("m6", H6.a("m6", "TAG", "Exception while onVastProcessCompleted : ").append(e.getMessage()).toString());
            }
        }
        C2672h m = m();
        if (m == null) {
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 55);
        } else if (m.G()) {
            b(true);
            V();
        } else {
            a(m);
        }
    }

    @Override // com.inmobi.media.S0
    public void a(Z placement, boolean z) {
        Intrinsics.checkNotNullParameter(placement, "placement");
        super.a(placement, z);
        if (!z) {
            if (Intrinsics.areEqual(I(), placement)) {
                if (2 == Q() || 4 == Q()) {
                    d((byte) 0);
                    InterfaceC2971z5 interfaceC2971z5 = this.j;
                    if (interfaceC2971z5 != null) {
                        Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                        ((A5) interfaceC2971z5).d("m6", "AdUnit " + this + " state - CREATED");
                    }
                    b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_NO_LONGER_AVAILABLE), false, (short) 0);
                    return;
                }
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(I(), placement) && 2 == Q()) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                ((A5) interfaceC2971z52).a("m6", "Asset are ready now");
            }
            if (a0()) {
                c(true);
                f();
            } else {
                r0();
            }
        }
    }

    @Override // com.inmobi.media.S0
    public void a(GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec, short s) {
        super.a(gestureDetectorOnGestureListenerC2634ec, s);
        if (b0()) {
            int indexOf = this.g.indexOf(gestureDetectorOnGestureListenerC2634ec);
            boolean z = false;
            S0.a(this, indexOf, false, 2, null);
            int size = this.g.size();
            boolean z2 = true;
            boolean z3 = true;
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = z2;
                    i = -1;
                    break;
                }
                if (i != indexOf && this.g.get(i) != null) {
                    if (B().contains(Integer.valueOf(i))) {
                        break;
                    }
                    z2 = false;
                    z3 = false;
                }
                i++;
            }
            if (i != -1) {
                if (z3 && Q() == 2) {
                    b((byte) 1);
                    i(i);
                    InterfaceC2971z5 interfaceC2971z5 = this.j;
                    if (interfaceC2971z5 != null) {
                        ((A5) interfaceC2971z5).a("m6", H6.a("m6", "TAG", "Providing success based on currIndex ").append(A()).append(" as ").append(indexOf).append(" failed").toString());
                    }
                    L0();
                    return;
                }
                return;
            }
            if (z && Q() == 2) {
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    ((A5) interfaceC2971z52).a("InMobiInterstitial", "Failed to load the Interstitial markup in the WebView for placement id: " + I());
                }
                b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, s);
                return;
            }
            return;
        }
        if (Q() == 2) {
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).a("InMobiInterstitial", "Failed to load the Interstitial markup in the WebView for placement id: " + I());
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, s);
        }
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.InterfaceC2553a0
    public void a(int i, final GestureDetectorOnGestureListenerC2634ec renderView, final Context context) {
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (!b0()) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                ((A5) interfaceC2971z5).a("m6", "Cannot show an pod ad as isPod is not set.");
                return;
            }
            return;
        }
        if (B().contains(Integer.valueOf(i)) && i > this.g.indexOf(renderView) && i < this.g.size() && this.g.get(i) != null && ((gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) this.g.get(i)) == null || gestureDetectorOnGestureListenerC2634ec.x0)) {
            if (context == null) {
                context = t();
            }
            super.a(i, renderView, context);
            Handler D = D();
            if (D != null) {
                D.post(new Runnable() { // from class: com.inmobi.media.m6$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2760m6.a(C2760m6.this, renderView, context);
                    }
                });
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
            ((A5) interfaceC2971z52).a("m6", "Cannot show an pod ad with invalid index passed");
        }
        b(this.g.indexOf(renderView), false);
    }

    public static final void a(C2760m6 this$0, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(i, false);
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.InterfaceC2553a0
    public boolean a(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (b0()) {
            if (B().higher(Integer.valueOf(this.g.indexOf(renderView))) != null) {
                return true;
            }
        }
        return false;
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.InterfaceC2636ee
    public void a(byte b) {
        if (b == 1) {
            if (b0()) {
                if (Q() == 2) {
                    if (B().isEmpty()) {
                        InterfaceC2971z5 interfaceC2971z5 = this.j;
                        if (interfaceC2971z5 != null) {
                            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                            ((A5) interfaceC2971z5).b("m6", "RenderView time out, none of the ad provided success");
                        }
                        h();
                        b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 2139);
                        return;
                    }
                    b((byte) 1);
                    InterfaceC2971z5 interfaceC2971z52 = this.j;
                    if (interfaceC2971z52 != null) {
                        ((A5) interfaceC2971z52).a("m6", H6.a("m6", "TAG", "RenderView time out, providing success based on ").append(B().first()).toString());
                    }
                    Integer first = B().first();
                    Intrinsics.checkNotNullExpressionValue(first, "first(...)");
                    i(first.intValue());
                    L0();
                    int size = this.g.size();
                    for (int i = 0; i < size; i++) {
                        if (!B().contains(Integer.valueOf(i))) {
                            S0.a(this, i, false, 2, null);
                        }
                    }
                    return;
                }
                h();
                return;
            }
            super.a(b);
            return;
        }
        super.a(b);
    }

    @Override // com.inmobi.media.S0, com.inmobi.media.AbstractC2669gc
    public void a(GestureDetectorOnGestureListenerC2634ec renderView, boolean z) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        super.a(renderView, z);
        byte Q = Q();
        if (Q == 4) {
            this.Q = new C2712j6(this, z ? (short) 2220 : (short) 2219);
            return;
        }
        if (Q != 6) {
            if (Q == 7) {
                short s = z ? (short) 2224 : (short) 2223;
                AbstractC2680h7.a((byte) 2, "InMobiInterstitial", "RenderProcess of the WebView has crashed. Please create another adUnit");
                InterfaceC2971z5 interfaceC2971z5 = this.j;
                if (interfaceC2971z5 != null) {
                    Intrinsics.checkNotNullExpressionValue("m6", "TAG");
                    ((A5) interfaceC2971z5).b("m6", "RenderProcess of the WebView has crashed. Please create another adUnit");
                }
                renderView.a(z, s);
                Activity fullScreenActivity = renderView.getFullScreenActivity();
                if (fullScreenActivity != null) {
                    InterfaceC2971z5 interfaceC2971z52 = renderView.i;
                    if (interfaceC2971z52 != null) {
                        String TAG = GestureDetectorOnGestureListenerC2634ec.a1;
                        Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                        ((A5) interfaceC2971z52).c(TAG, "fullScreenActivity is not null and finishing");
                    }
                    fullScreenActivity.finish();
                }
                a(r());
                return;
            }
            return;
        }
        short s2 = z ? (short) 2222 : (short) 2221;
        AbstractC2680h7.a((byte) 2, "InMobiInterstitial", "RenderProcess of the WebView has crashed. Please create another adUnit");
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        if (interfaceC2971z53 != null) {
            Intrinsics.checkNotNullExpressionValue("m6", "TAG");
            ((A5) interfaceC2971z53).b("m6", "RenderProcess of the WebView has crashed. Please create another adUnit");
        }
        Activity fullScreenActivity2 = renderView.getFullScreenActivity();
        if (fullScreenActivity2 != null) {
            InterfaceC2971z5 interfaceC2971z54 = renderView.i;
            if (interfaceC2971z54 != null) {
                String TAG2 = GestureDetectorOnGestureListenerC2634ec.a1;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z54).c(TAG2, "fullScreenActivity is not null and finishing");
            }
            fullScreenActivity2.finish();
        }
        if (this.N == 0) {
            a(true, s2);
        } else {
            renderView.a(z, s2);
            a(r());
        }
    }
}
