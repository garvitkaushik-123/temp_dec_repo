package com.inmobi.media;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.exifinterface.media.ExifInterface;
import com.inmobi.ads.rendering.InMobiAdActivity;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.TelemetryConfig;
import com.ironsource.C3040d4;
import com.vungle.ads.internal.Constants;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public class T7 implements InterfaceC2930x, Application.ActivityLifecycleCallbacks {
    public boolean A;
    public int B;
    public T7 C;
    public boolean D;
    public C2613d8 E;
    public String F;
    public Intent G;
    public GestureDetectorOnGestureListenerC2634ec H;
    public GestureDetectorOnGestureListenerC2634ec I;
    public T7 J;
    public byte K;
    public S7 L;
    public final A M;
    public final P7 N;
    public final L7 O;
    public final Q7 P;
    public final K7 Q;
    public LinkedHashMap R;
    public final String S;
    public final O7 T;

    /* renamed from: a, reason: collision with root package name */
    public final byte f2437a;
    public final C2811p8 b;
    public final String c;
    public final Set d;
    public final long e;
    public final boolean f;
    public final String g;
    public final C2625e3 h;
    public final S6 i;
    public final InterfaceC2971z5 j;
    public final Lazy k;
    public final R7 l;
    public final String m;
    public final HashSet n;
    public final ArrayList o;
    public We p;
    public D8 q;
    public boolean r;
    public final AdConfig s;
    public boolean t;
    public boolean u;
    public T7 v;
    public P0 w;
    public WeakReference x;
    public int y;
    public WeakReference z;

    public T7(Context context, byte b, C2811p8 mNativeDataModel, String impressionId, Set set, AdConfig adConfig, long j, boolean z, String creativeId, C2625e3 c2625e3, S6 s6, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(mNativeDataModel, "mNativeDataModel");
        Intrinsics.checkNotNullParameter(impressionId, "impressionId");
        Intrinsics.checkNotNullParameter(adConfig, "adConfig");
        Intrinsics.checkNotNullParameter(creativeId, "creativeId");
        this.f2437a = b;
        this.b = mNativeDataModel;
        this.c = impressionId;
        this.d = set;
        this.e = j;
        this.f = z;
        this.g = creativeId;
        this.h = c2625e3;
        this.i = s6;
        this.j = interfaceC2971z5;
        this.k = LazyKt.lazy(N7.f2372a);
        this.l = new R7(this);
        this.m = "T7";
        this.n = new HashSet();
        this.o = new ArrayList();
        this.s = adConfig;
        this.v = this;
        this.x = new WeakReference(null);
        this.y = -1;
        this.N = new P7(this);
        this.O = new L7(this);
        this.P = new Q7(this);
        this.Q = new K7(this);
        this.x = new WeakReference(context);
        Uc.a(context, this);
        C2681h8 c2681h8 = mNativeDataModel.e;
        if (c2681h8 != null) {
            c2681h8.y = System.currentTimeMillis();
        }
        this.K = (byte) -1;
        this.M = A.f2225a;
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.T7$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                T7.a(T7.this);
            }
        });
        this.S = "native";
        this.T = new O7(this);
    }

    public final C2613d8 a(C2811p8 c2811p8, C2613d8 asset) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        if (c2811p8 == null) {
            return null;
        }
        String str = asset.h;
        if (str.length() == 0) {
            asset.k = (byte) 0;
            return asset;
        }
        String[] strArr = (String[]) new Regex("\\|").split(str, 0).toArray(new String[0]);
        if (strArr.length == 1) {
            asset.k = a(strArr[0]);
            return asset;
        }
        C2613d8 m = c2811p8.m(strArr[0]);
        if (m == null) {
            return a(c2811p8.g, asset);
        }
        if (Intrinsics.areEqual(m, asset)) {
            return null;
        }
        m.k = a(strArr[1]);
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String str2 = this.m;
            ((A5) interfaceC2971z5).a(str2, H6.a(str2, "TAG", "Referenced asset (").append(m.b).append(')').toString());
        }
        return m;
    }

    public final C2613d8 b(C2811p8 c2811p8, C2613d8 c2613d8) {
        InterfaceC2971z5 interfaceC2971z5;
        if (c2811p8 == null) {
            return null;
        }
        String str = c2613d8.p;
        String str2 = c2613d8.q;
        C2613d8 a2 = a(c2613d8, c2811p8, str);
        if (a2 == null) {
            a2 = a(c2613d8, c2811p8, str2);
        }
        if (a2 != null && (interfaceC2971z5 = this.j) != null) {
            String str3 = this.m;
            ((A5) interfaceC2971z5).a(str3, H6.a(str3, "TAG", "Referenced asset (").append(a2.b).append(')').toString());
        }
        return a2;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public final boolean c() {
        return this.t;
    }

    public final Context d() {
        Activity f = f();
        return f != null ? f : (Context) this.x.get();
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public final void e() {
    }

    public final Activity f() {
        WeakReference weakReference = this.z;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public final View g() {
        We we = this.p;
        if (we != null) {
            return we.b();
        }
        return null;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public final AdConfig getAdConfig() {
        return this.s;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public final String getAdType() {
        return this.S;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public String getCreativeId() {
        return this.g;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public final Object getDataModel() {
        return this.b;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public InterfaceC2914w getFullScreenEventsListener() {
        return this.N;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public String getImpressionId() {
        return this.c;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public final String getMarkupType() {
        return "inmobiJson";
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public final byte getPlacementType() {
        return this.f2437a;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public View getVideoContainerView() {
        return null;
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public Xe getViewableAd() {
        Context j = j();
        if (this.p == null && j != null) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                String TAG = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).c(TAG, "fireLoadedAndServedBeacons");
            }
            C2681h8 c2681h8 = this.b.e;
            if (c2681h8 != null) {
                HashMap a2 = a(c2681h8);
                a((byte) 1, a2);
                a((byte) 2, a2);
            }
            this.p = new M5(j, this, new C2586bf(this, this.H, this.j), this.j);
            Set<C2833qe> set = this.d;
            if (set != null) {
                for (C2833qe c2833qe : set) {
                    try {
                        if (c2833qe.f2687a == 3) {
                            InterfaceC2971z5 interfaceC2971z52 = this.j;
                            if (interfaceC2971z52 != null) {
                                String TAG2 = this.m;
                                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                                ((A5) interfaceC2971z52).a(TAG2, "OMID tracker");
                            }
                            Object obj = c2833qe.b.get("omidAdSession");
                            C2667ga c2667ga = obj instanceof C2667ga ? (C2667ga) obj : null;
                            We we = this.p;
                            if (c2667ga == null || we == null) {
                                InterfaceC2971z5 interfaceC2971z53 = this.j;
                                if (interfaceC2971z53 != null) {
                                    String TAG3 = this.m;
                                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                                    ((A5) interfaceC2971z53).b(TAG3, "Did not find a OMID ad session; the OMID decorator will not be applied.");
                                }
                            } else {
                                this.p = this.K == 0 ? new C2732ka(this, we, c2667ga, this.j) : new C2748la(this, we, c2667ga, this.j);
                            }
                        }
                    } catch (Exception e) {
                        InterfaceC2971z5 interfaceC2971z54 = this.j;
                        if (interfaceC2971z54 != null) {
                            String str = this.m;
                            ((A5) interfaceC2971z54).b(str, rf.a(e, H6.a(str, "TAG", "Exception occurred while creating the Display viewable ad : ")));
                        }
                        S5 s5 = S5.f2425a;
                        S5.d.a(AbstractC2920w5.a(e, "event"));
                    }
                }
            }
        }
        return this.p;
    }

    public final D8 h() {
        We we = this.p;
        C2939x8 c = we != null ? we.c() : null;
        C2939x8 c2939x8 = c instanceof C2939x8 ? c : null;
        if (c2939x8 != null) {
            this.q = c2939x8.e;
        }
        return this.q;
    }

    public ef i() {
        return this.T;
    }

    public final Context j() {
        return (1 == this.f2437a || k()) ? f() : (Context) this.x.get();
    }

    public boolean k() {
        return this.f2437a == 0 && f() != null;
    }

    public void l() {
        We we;
        C2572b1 c2572b1;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, C3040d4.h.t0);
        }
        this.u = true;
        T8 a2 = a(g());
        if (a2 != null) {
            a2.b();
        }
        D8 h = h();
        if (h != null && (c2572b1 = h.l) != null) {
            c2572b1.a();
        }
        Context d = d();
        if (d == null || (we = this.p) == null) {
            return;
        }
        we.a(d, (byte) 1);
    }

    public final void m() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "reportFirstPageRendered");
        }
        C2681h8 b = this.b.b(0);
        if (this.n.contains(0) || b == null || this.t) {
            return;
        }
        this.n.add(0);
        b.y = System.currentTimeMillis();
        if (!this.r) {
            this.o.add(b);
            return;
        }
        HashMap a2 = a(b);
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            String TAG2 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).a(TAG2, "Page-view impression record request");
        }
        b.a("page_view", a2, (L7) null, this.j);
    }

    public boolean n() {
        return false;
    }

    public final void o() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.T7$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                T7.d(T7.this);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "onActivityDestroyed");
        }
        We we = this.p;
        if (we != null) {
            we.a(activity, (byte) 2);
        }
        C2625e3 c2625e3 = this.h;
        if (c2625e3 != null) {
            c2625e3.b();
        }
        Context context = (Context) this.x.get();
        if (context instanceof Activity) {
            ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        We we;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(d(), activity)) {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                String TAG = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).c(TAG, C3040d4.h.u0);
            }
            this.u = false;
            T8 a2 = a(g());
            if (a2 != null) {
                a2.c();
            }
            p();
            Context d = d();
            if (d == null || (we = this.p) == null) {
                return;
            }
            we.a(d, (byte) 0);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual(d(), activity)) {
            l();
        }
    }

    public final void p() {
        C2572b1 c2572b1;
        D8 h = h();
        if (h == null || (c2572b1 = h.l) == null || c2572b1.c) {
            return;
        }
        c2572b1.c = true;
        c2572b1.a(c2572b1.b);
    }

    public final void q() {
        P0 p0;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "unlockRewards");
        }
        if (n()) {
            this.A = true;
            HashMap rewards = this.b.h;
            if (rewards == null || (p0 = this.w) == null) {
                return;
            }
            Intrinsics.checkNotNullParameter(rewards, "rewards");
            InterfaceC2971z5 interfaceC2971z52 = p0.f2390a.j;
            if (interfaceC2971z52 != null) {
                String e = S0.e();
                Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
                ((A5) interfaceC2971z52).a(e, "onAdRewardsUnlocked");
            }
            if (p0.f2390a.Z()) {
                return;
            }
            F0 f0 = (F0) p0.b.get();
            if (f0 != null) {
                f0.b(new HashMap(rewards));
                return;
            }
            InterfaceC2971z5 interfaceC2971z53 = p0.f2390a.j;
            if (interfaceC2971z53 != null) {
                ((A5) interfaceC2971z53).b("InMobi", "Listener was garbage collected.Unable to give callback");
            }
        }
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public final void setFullScreenActivityContext(Activity activity) {
        this.z = new WeakReference(activity);
    }

    public static final void d(T7 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.A = true;
        this$0.b((C2613d8) null);
    }

    public void c(C2613d8 asset) {
        T8 a2;
        ValueAnimator valueAnimator;
        Intrinsics.checkNotNullParameter(asset, "asset");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "triggerAssetAction");
        }
        byte b = asset.k;
        if (b == 0 || b == 5) {
            return;
        }
        if (b == 2) {
            this.A = true;
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.H;
            if (gestureDetectorOnGestureListenerC2634ec != null && gestureDetectorOnGestureListenerC2634ec != null) {
                InterfaceC2971z5 interfaceC2971z52 = gestureDetectorOnGestureListenerC2634ec.i;
                if (interfaceC2971z52 != null) {
                    String TAG2 = GestureDetectorOnGestureListenerC2634ec.a1;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((A5) interfaceC2971z52).a(TAG2, "skipToInterActive");
                }
                gestureDetectorOnGestureListenerC2634ec.c("window.imraid.broadcastEvent('skip');");
            }
            T8 a3 = a(g());
            if (a3 != null) {
                a3.b();
            }
            b(asset);
            C2625e3 c2625e3 = this.h;
            if (c2625e3 == null || c2625e3.g.get()) {
                return;
            }
            c2625e3.d.h = 1;
            Intrinsics.checkNotNull(c2625e3.c);
            return;
        }
        if (b == 3) {
            try {
                GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this.H;
                if (gestureDetectorOnGestureListenerC2634ec2 != null) {
                    InterfaceC2971z5 interfaceC2971z53 = gestureDetectorOnGestureListenerC2634ec2.i;
                    if (interfaceC2971z53 != null) {
                        String TAG3 = GestureDetectorOnGestureListenerC2634ec.a1;
                        Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                        ((A5) interfaceC2971z53).a(TAG3, "replayToInterActive");
                    }
                    gestureDetectorOnGestureListenerC2634ec2.c("window.imraid.broadcastEvent('replay');");
                }
                View g = g();
                if (g != null) {
                    ViewParent parent = g.getParent();
                    ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup != null) {
                        viewGroup.removeView(g);
                    }
                }
                T7 t7 = this.v;
                T7 t72 = t7 instanceof T7 ? t7 : null;
                if (t72 != null && (a2 = a(t72.g())) != null && (valueAnimator = a2.n) != null && valueAnimator.isRunning()) {
                    valueAnimator.setCurrentPlayTime(a2.f * 1000);
                    a2.l = 360 * 1.0f;
                    a2.invalidate();
                }
                if (!Intrinsics.areEqual("VIDEO", asset.c)) {
                    InterfaceC2971z5 interfaceC2971z54 = this.j;
                    if (interfaceC2971z54 != null) {
                        String TAG4 = this.m;
                        Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                        ((A5) interfaceC2971z54).b(TAG4, "Action 3 not valid for asset of type: " + asset.c);
                        return;
                    }
                    return;
                }
                if (t7 instanceof C2562a9) {
                    View videoContainerView = ((C2562a9) t7).getVideoContainerView();
                    C2763m9 c2763m9 = videoContainerView instanceof C2763m9 ? (C2763m9) videoContainerView : null;
                    if (c2763m9 != null) {
                        C2747l9 videoView = c2763m9.getVideoView();
                        Object tag = videoView.getTag();
                        C2597c9 c2597c9 = tag instanceof C2597c9 ? (C2597c9) tag : null;
                        if (c2597c9 != null) {
                            if (c2597c9.c()) {
                                videoView.k();
                            } else {
                                videoView.c();
                            }
                        } else if (1 == this.f2437a) {
                            videoView.k();
                        } else {
                            videoView.c();
                        }
                        if (c2597c9 != null) {
                            a(c2597c9);
                        }
                        videoView.start();
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z55 = this.j;
                if (interfaceC2971z55 != null) {
                    String str = this.m;
                    ((A5) interfaceC2971z55).b(str, rf.a(e, H6.a(str, "TAG", "Encountered unexpected error in handling replay action on video: ")));
                }
                AbstractC2680h7.a((byte) 2, "InMobi", "SDK encountered unexpected error in replaying video");
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
                return;
            }
        }
        if (b == 1) {
            try {
                GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec3 = this.H;
                if (gestureDetectorOnGestureListenerC2634ec3 != null) {
                    InterfaceC2971z5 interfaceC2971z56 = gestureDetectorOnGestureListenerC2634ec3.i;
                    if (interfaceC2971z56 != null) {
                        String TAG5 = GestureDetectorOnGestureListenerC2634ec.a1;
                        Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                        ((A5) interfaceC2971z56).a(TAG5, "closeToInterActive");
                    }
                    gestureDetectorOnGestureListenerC2634ec3.c("window.imraid.broadcastEvent('close');");
                }
                a();
                return;
            } catch (Exception e2) {
                InterfaceC2971z5 interfaceC2971z57 = this.j;
                if (interfaceC2971z57 != null) {
                    String str2 = this.m;
                    ((A5) interfaceC2971z57).b(str2, rf.a(e2, H6.a(str2, "TAG", "Encountered unexpected error in handling exit action on video: ")));
                }
                AbstractC2680h7.a((byte) 2, "InMobi", "SDK encountered unexpected error in exiting video");
                S5 s52 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e2, "event"));
                return;
            }
        }
        if (b != 4) {
            this.A = true;
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec4 = this.H;
            if (gestureDetectorOnGestureListenerC2634ec4 != null && gestureDetectorOnGestureListenerC2634ec4 != null) {
                InterfaceC2971z5 interfaceC2971z58 = gestureDetectorOnGestureListenerC2634ec4.i;
                if (interfaceC2971z58 != null) {
                    String TAG6 = GestureDetectorOnGestureListenerC2634ec.a1;
                    Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
                    ((A5) interfaceC2971z58).a(TAG6, "skipToInterActive");
                }
                gestureDetectorOnGestureListenerC2634ec4.c("window.imraid.broadcastEvent('skip');");
            }
            T8 a4 = a(g());
            if (a4 != null) {
                a4.b();
            }
            b(asset);
            return;
        }
        try {
            if (this.f2437a == 0) {
                InterfaceC2971z5 interfaceC2971z59 = this.j;
                if (interfaceC2971z59 != null) {
                    String TAG7 = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG7, "TAG");
                    ((A5) interfaceC2971z59).c(TAG7, "launchFullscreen");
                }
                T7 c = c(this);
                if (c == null) {
                    return;
                }
                P0 p0 = c.w;
                if (p0 != null) {
                    p0.e();
                }
                A a5 = this.M;
                int hashCode = hashCode();
                M7 m7 = new M7(this, c);
                a5.getClass();
                A.a(hashCode, m7);
            }
        } catch (Exception e3) {
            InterfaceC2971z5 interfaceC2971z510 = this.j;
            if (interfaceC2971z510 != null) {
                String str3 = this.m;
                ((A5) interfaceC2971z510).b(str3, rf.a(e3, H6.a(str3, "TAG", "Encountered unexpected error in handling fullscreen action ")));
            }
            AbstractC2680h7.a((byte) 2, "InMobi", "SDK encountered unexpected error in launching fullscreen ad");
            S5 s53 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e3, "event"));
        }
    }

    public void b(View view) {
        P0 p0;
        if (this.r || this.t) {
            return;
        }
        this.r = true;
        C2625e3 c2625e3 = this.h;
        if (c2625e3 != null) {
            c2625e3.a();
        }
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "A viewable impression is reported on ad view.");
        }
        C2681h8 c2681h8 = this.b.e;
        if (c2681h8 != null) {
            c2681h8.a("Impression", a(c2681h8), this.O, this.j);
        }
        m();
        Iterator it = this.o.iterator();
        while (it.hasNext()) {
            C2613d8 c2613d8 = (C2613d8) it.next();
            HashMap a2 = a(c2613d8);
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                String TAG2 = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).a(TAG2, "Page-view impression record request");
            }
            c2613d8.a("page_view", a2, (L7) null, this.j);
        }
        this.o.clear();
        We we = this.p;
        if (we != null) {
            we.a((byte) 0);
        }
        T7 c = c(this);
        if (c == null || (p0 = c.w) == null) {
            return;
        }
        p0.f();
    }

    public static final void b(T7 it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        A a2 = it.M;
        int hashCode = it.hashCode();
        Q7 q7 = it.P;
        a2.getClass();
        A.a(hashCode, q7);
    }

    public final void b(C2613d8 c2613d8) {
        Xe viewableAd;
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "showEndCard");
        }
        T7 t7 = this.J;
        if (t7 != null && g() != null) {
            try {
                View g = g();
                ViewGroup viewGroup = g instanceof ViewGroup ? (ViewGroup) g : null;
                View a2 = (viewGroup == null || (viewableAd = t7.getViewableAd()) == null) ? null : viewableAd.a(null, viewGroup, false);
                if (a2 != null) {
                    if (viewGroup != null) {
                        viewGroup.addView(a2);
                    }
                    a2.setClickable(true);
                    t7.p();
                    if (c2613d8 instanceof C2597c9) {
                        Ve d = ((C2597c9) c2613d8).d();
                        Le le = d != null ? ((Ue) d).j : null;
                        if (le == null) {
                            return;
                        }
                        le.g = true;
                        return;
                    }
                    return;
                }
                InterfaceC2971z5 interfaceC2971z52 = this.j;
                if (interfaceC2971z52 != null) {
                    String TAG2 = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                    ((A5) interfaceC2971z52).b(TAG2, "Could not inflate the end card. Closing the ad");
                }
                a();
                return;
            } catch (Exception e) {
                InterfaceC2971z5 interfaceC2971z53 = this.j;
                if (interfaceC2971z53 != null) {
                    String TAG3 = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((A5) interfaceC2971z53).a(TAG3, "Failed to show end card Exception", e);
                }
                a();
                S5 s5 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
                return;
            }
        }
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            String TAG4 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
            ((A5) interfaceC2971z54).b(TAG4, "End card container is null; end card will not be shown");
        }
        AbstractC2680h7.a((byte) 2, "InMobi", "Failed to show end card");
        a();
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public void b() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "destroyContainer");
        }
        if (this.t) {
            return;
        }
        this.t = true;
        C2625e3 c2625e3 = this.h;
        if (c2625e3 != null) {
            c2625e3.b();
        }
        this.y = -1;
        T7 t7 = this.C;
        if (t7 != null) {
            t7.a();
        }
        this.w = null;
        D8 h = h();
        if (h != null) {
            C2572b1 c2572b1 = h.l;
            Iterator it = c2572b1.b.iterator();
            while (it.hasNext()) {
                ((C2554a1) it.next()).f2512a.cancel();
            }
            c2572b1.b.clear();
            h.n = true;
            h.i.clear();
            h.p = null;
            L8 l8 = h.j;
            if (l8 != null) {
                l8.destroy();
            }
            h.j = null;
        }
        this.q = null;
        this.o.clear();
        We we = this.p;
        if (we != null) {
            we.e();
        }
        We we2 = this.p;
        if (we2 != null) {
            we2.a();
        }
        Context context = (Context) this.x.get();
        if (context instanceof Activity) {
            ((Activity) context).getApplication().unregisterActivityLifecycleCallbacks(this);
        }
        this.x.clear();
        WeakReference weakReference = this.z;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.H = null;
        T7 t72 = this.J;
        if (t72 != null) {
            t72.b();
        }
        this.J = null;
        A a2 = this.M;
        int hashCode = hashCode();
        a2.getClass();
        SparseArray sparseArray = A.b;
        sparseArray.remove(hashCode);
        Intrinsics.checkNotNullExpressionValue(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "TAG");
        sparseArray.size();
    }

    public final void a(Context context) {
        this.x = new WeakReference(context);
        Uc.a(context, this);
    }

    public static final void a(T7 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        A a2 = this$0.M;
        int hashCode = this$0.hashCode();
        Q7 q7 = this$0.P;
        a2.getClass();
        A.a(hashCode, q7);
    }

    @Override // com.inmobi.media.InterfaceC2930x
    public final void a(byte b, Map map) {
        C2681h8 c2681h8;
        if (this.t || b == 0 || b == 3) {
            return;
        }
        if (b == 1) {
            C2681h8 c2681h82 = this.b.e;
            if (c2681h82 != null) {
                InterfaceC2971z5 interfaceC2971z5 = this.j;
                if (interfaceC2971z5 != null) {
                    String TAG = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).a(TAG, "reportAdLoad");
                }
                c2681h82.a("load", (HashMap) map, (L7) null, this.j);
                return;
            }
            return;
        }
        if (b != 2 || (c2681h8 = this.b.e) == null) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            String TAG2 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).a(TAG2, "reportAdServed");
        }
        c2681h8.a("client_fill", (HashMap) map, (L7) null, this.j);
    }

    public final void a(View view, C2613d8 asset) {
        String str;
        P0 p0;
        Intrinsics.checkNotNullParameter(asset, "asset");
        if (this.t) {
            return;
        }
        m();
        C2613d8 b = b(this.b, asset);
        if (b != null) {
            HashMap a2 = a(b);
            a(b, a2);
            if (!Intrinsics.areEqual(b, asset)) {
                a(asset, a2);
            }
        } else {
            InterfaceC2971z5 interfaceC2971z5 = this.j;
            if (interfaceC2971z5 != null) {
                String TAG = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                ((A5) interfaceC2971z5).b(TAG, "Couldn't find an asset reference for this asset click URL");
            }
            a(asset, a(asset));
        }
        T7 c = c(this);
        if (c == null) {
            return;
        }
        String str2 = asset.p;
        if (str2 != null) {
            int length = str2.length() - 1;
            int i = 0;
            boolean z = false;
            while (i <= length) {
                boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i++;
                } else {
                    z = true;
                }
            }
            str = I7.a(length, 1, str2, i);
        } else {
            str = null;
        }
        if (B2.a(str) && (p0 = c.w) != null) {
            p0.a();
        }
        C2613d8 a3 = a(this.b, asset);
        if (a3 != null) {
            if (view != null && Intrinsics.areEqual("VIDEO", a3.c) && 5 == a3.k) {
                view.setVisibility(4);
                asset.v = 4;
            }
            c(a3);
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.j;
        if (interfaceC2971z52 != null) {
            String TAG2 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
            ((A5) interfaceC2971z52).b(TAG2, "Couldn't find an asset reference for this asset action! Ignoring the asset action ...");
        }
    }

    public final C2613d8 a(C2613d8 c2613d8, C2811p8 c2811p8, String str) {
        if (AbstractC2968z2.a((Context) this.x.get(), str) || str == null || str.length() == 0) {
            return c2613d8;
        }
        String[] strArr = (String[]) new Regex("\\|").split(str, 0).toArray(new String[0]);
        C2613d8 m = c2811p8.m(strArr[0]);
        if (m == null) {
            return b(c2811p8.g, c2613d8);
        }
        if (Intrinsics.areEqual(m, c2613d8)) {
            return null;
        }
        if (strArr.length <= 2) {
            m.l = (byte) 1;
            return m;
        }
        m.l = AbstractC2762m8.a(strArr[2]);
        return m;
    }

    public static T7 c(T7 t7) {
        if (t7 == null) {
            return null;
        }
        if (t7.f() != null || Intrinsics.areEqual(t7, t7.v)) {
            return t7;
        }
        T7 t72 = t7.v;
        return c(t72 instanceof T7 ? t72 : null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:37:0x008f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte a(String str) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String lowerCase = str.toLowerCase(US);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        int length = lowerCase.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) lowerCase.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        String a2 = I7.a(length, 1, lowerCase, i);
        switch (a2.hashCode()) {
            case -934641255:
                return !a2.equals("reload") ? (byte) 0 : (byte) 3;
            case -934524953:
                if (a2.equals("replay")) {
                    return (byte) 3;
                }
                break;
            case 0:
                a2.equals("");
            case 3127582:
                if (a2.equals("exit")) {
                    return (byte) 1;
                }
                break;
            case 3443508:
                if (a2.equals("play")) {
                    return (byte) 5;
                }
                break;
            case 3532159:
                if (a2.equals("skip")) {
                    return (byte) 2;
                }
                break;
            case 110066619:
                if (a2.equals(Constants.TEMPLATE_TYPE_FULLSCREEN)) {
                    return (byte) 4;
                }
                break;
        }
    }

    public final void a(C2613d8 asset, boolean z) {
        Intrinsics.checkNotNullParameter(asset, "asset");
        C2811p8 c2811p8 = this.b;
        if (!c2811p8.q || this.t) {
            return;
        }
        C2613d8 b = b(c2811p8, asset);
        if (b != null) {
            HashMap a2 = a(b);
            String str = asset.g;
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            b.g = str;
            String str2 = null;
            R6 r6 = ((TelemetryConfig.LandingPageConfig) this.k.getValue()).getNativeEnabled() ? new R6(this.i, J6.a(b.p), 0, 12) : null;
            J6.a(F6.d, r6, (Integer) null, 12);
            if (Intrinsics.areEqual("VIDEO", b.c) || b.f) {
                InterfaceC2971z5 interfaceC2971z5 = this.j;
                if (interfaceC2971z5 != null) {
                    String TAG = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).a(TAG, "Asset interaction requested");
                }
                String str3 = b.g;
                We we = this.p;
                if (we != null) {
                    we.a((byte) 4);
                }
                if (Intrinsics.areEqual("NO_ACTION", str3)) {
                    J6.a(F6.e, r6, (Integer) 10, 8);
                    return;
                }
                String str4 = b.p;
                if (2 == b.l) {
                    Intrinsics.checkNotNull(b, "null cannot be cast to non-null type com.inmobi.ads.modelsv2.NativeVideoAsset");
                    Ve d = ((C2597c9) b).d();
                    Le le = d != null ? ((Ue) d).j : null;
                    String str5 = le != null ? le.c : null;
                    if (str5 != null) {
                        int length = str5.length() - 1;
                        int i = 0;
                        boolean z2 = false;
                        while (i <= length) {
                            boolean z3 = Intrinsics.compare((int) str5.charAt(!z2 ? i : length), 32) <= 0;
                            if (z2) {
                                if (!z3) {
                                    break;
                                } else {
                                    length--;
                                }
                            } else if (z3) {
                                i++;
                            } else {
                                z2 = true;
                            }
                        }
                        str2 = I7.a(length, 1, str5, i);
                    }
                    if (B2.a(str2)) {
                        str4 = str5;
                    }
                }
                if (!AbstractC2968z2.a(d(), str4)) {
                    InterfaceC2971z5 interfaceC2971z52 = this.j;
                    if (interfaceC2971z52 != null) {
                        String TAG2 = this.m;
                        Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                        ((A5) interfaceC2971z52).b(TAG2, "Invalid url:" + str4 + " will use fallback");
                    }
                    str4 = b.q;
                    if (!AbstractC2968z2.a(d(), str4)) {
                        InterfaceC2971z5 interfaceC2971z53 = this.j;
                        if (interfaceC2971z53 != null) {
                            String str6 = this.m;
                            ((A5) interfaceC2971z53).b(str6, I6.a(str6, "TAG", "Invalid fallback url:", str4));
                        }
                        J6.a(F6.e, r6, (Integer) 3, 8);
                        return;
                    }
                }
                boolean z4 = T9.f2439a;
                Intrinsics.checkNotNull(str4);
                String a3 = T9.a(str4, a2);
                C2625e3 c2625e3 = this.h;
                if (c2625e3 != null && !c2625e3.g.get()) {
                    c2625e3.d.g = 1;
                    Intrinsics.checkNotNull(c2625e3.c);
                }
                if (this.D && !z) {
                    T7 c = c(this);
                    if (c == null) {
                        return;
                    }
                    P0 p0 = c.w;
                    if (p0 != null) {
                        if (Intrinsics.areEqual("INAPP", str3) && AbstractC2968z2.a(a3)) {
                            p0.e();
                        } else {
                            p0.g();
                        }
                    }
                    this.E = b;
                    this.F = a3;
                    return;
                }
                a(b, str3, a3, r6);
                return;
            }
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.j;
        if (interfaceC2971z54 != null) {
            String TAG3 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            ((A5) interfaceC2971z54).b(TAG3, "Couldn't find an asset reference for this asset click URL");
        }
    }

    public final void a(C2613d8 c2613d8, HashMap hashMap) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "Click impression record requested");
        }
        if (2 == c2613d8.l) {
            C2597c9 c2597c9 = c2613d8 instanceof C2597c9 ? (C2597c9) c2613d8 : null;
            Ve d = c2597c9 != null ? c2597c9.d() : null;
            Le le = d != null ? ((Ue) d).j : null;
            if ((le != null ? le.c : null) != null && c2613d8.p != null) {
                if (le.f.isEmpty()) {
                    return;
                }
                Iterator it = le.a("click").iterator();
                while (it.hasNext()) {
                    C2613d8.a((U8) it.next(), hashMap, (L7) null, this.j);
                }
                return;
            }
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                String TAG2 = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).a(TAG2, "reportAdClick");
            }
            c2613d8.a("click", hashMap, (L7) null, this.j);
            return;
        }
        InterfaceC2971z5 interfaceC2971z53 = this.j;
        if (interfaceC2971z53 != null) {
            String TAG3 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
            ((A5) interfaceC2971z53).a(TAG3, "reportAdClick");
        }
        c2613d8.a("click", hashMap, (L7) null, this.j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0032, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0025, code lost:
    
        if (kotlin.text.StringsKt.equals("card_scrollable", r1.b, true) != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final HashMap a(C2613d8 child) {
        C2681h8 c2681h8;
        Intrinsics.checkNotNullParameter(child, "asset");
        HashMap hashMap = new HashMap(4);
        if (this.t) {
            return hashMap;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        if (child instanceof C2681h8) {
            c2681h8 = (C2681h8) child;
        }
        C2681h8 c2681h82 = child.r;
        if (c2681h82 instanceof C2681h8) {
            c2681h8 = c2681h82;
            while (true) {
                if (c2681h8 == null) {
                    c2681h8 = null;
                    break;
                }
                if (StringsKt.equals("card_scrollable", c2681h8.b, true)) {
                    break;
                }
                c2681h8 = c2681h8.r;
                if (c2681h8 instanceof C2681h8) {
                }
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (c2681h8 != null) {
                long j = c2681h8.y;
                if (j != 0) {
                    currentTimeMillis = j;
                }
            }
            C2681h8 c2681h83 = this.b.e;
            hashMap.put("$LTS", String.valueOf(c2681h83 != null ? c2681h83.y : 0L));
            hashMap.put("$STS", String.valueOf(currentTimeMillis));
            hashMap.put("$TS", String.valueOf(System.currentTimeMillis()));
            Object obj = this.b.t;
            if (obj == null) {
                obj = new HashMap();
            }
            hashMap.putAll(obj);
            return hashMap;
        }
        c2681h8 = null;
    }

    public static T8 a(View view) {
        View findViewWithTag = view != null ? view.findViewWithTag("timerView") : null;
        if (findViewWithTag instanceof T8) {
            return (T8) findViewWithTag;
        }
        return null;
    }

    public final void a(C2597c9 c2597c9) {
        Ve d = c2597c9.d();
        Le le = d != null ? ((Ue) d).j : null;
        if (le == null || !le.g) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).a(TAG, "Invoking close end card trackers.");
        }
        Iterator it = le.a("closeEndCard").iterator();
        while (it.hasNext()) {
            C2613d8.a((U8) it.next(), a((C2613d8) c2597c9), (L7) null, this.j);
        }
        le.g = false;
    }

    public final void a() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "dismissCurrentViewContainer");
        }
        if (this.t) {
            return;
        }
        try {
            T7 container = c(this);
            if (container == null) {
                return;
            }
            container.q();
            SparseArray sparseArray = InMobiAdActivity.k;
            Intrinsics.checkNotNullParameter(container, "container");
            InMobiAdActivity.k.remove(container.hashCode());
            if (container instanceof C2562a9) {
                View videoContainerView = container.getVideoContainerView();
                C2763m9 c2763m9 = videoContainerView instanceof C2763m9 ? (C2763m9) videoContainerView : null;
                if (c2763m9 != null) {
                    C2747l9 videoView = c2763m9.getVideoView();
                    Object tag = videoView.getTag();
                    if (tag instanceof C2597c9) {
                        HashMap hashMap = ((C2597c9) tag).t;
                        hashMap.put("seekPosition", Integer.valueOf(videoView.getCurrentPosition()));
                        hashMap.put("lastMediaVolume", Integer.valueOf(videoView.getVolume()));
                        C2613d8 c2613d8 = ((C2597c9) tag).w;
                        if (c2613d8 instanceof C2597c9) {
                            ((C2597c9) c2613d8).a((C2597c9) tag);
                        }
                        a((C2597c9) tag);
                    }
                }
            }
            WeakReference weakReference = container.z;
            Activity activity = weakReference != null ? (Activity) weakReference.get() : null;
            if (activity instanceof InMobiAdActivity) {
                ((InMobiAdActivity) activity).e = true;
                ((InMobiAdActivity) activity).finish();
                int i = this.y;
                if (i != -1) {
                    ((InMobiAdActivity) activity).overridePendingTransition(0, i);
                }
            }
            final T7 t7 = this.v;
            if (!(t7 instanceof T7)) {
                t7 = null;
            }
            if (t7 != null) {
                t7.C = null;
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.T7$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        T7.b(T7.this);
                    }
                });
            }
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                String str = this.m;
                ((A5) interfaceC2971z52).b(str, rf.a(e, H6.a(str, "TAG", "Encountered unexpected error in handling exit action on video: ")));
            }
            AbstractC2680h7.a((byte) 2, "InMobi", "SDK encountered unexpected error in exiting video");
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public final void a(C2613d8 asset, String interactionMode, String url, R6 r6) {
        Unit unit;
        P0 p0;
        Unit unit2;
        Intrinsics.checkNotNullParameter(asset, "asset");
        Intrinsics.checkNotNullParameter(interactionMode, "interactionMode");
        Intrinsics.checkNotNullParameter(url, "url");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String TAG = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
            ((A5) interfaceC2971z5).c(TAG, "openUrl");
        }
        if (Intrinsics.areEqual("EMBEDDED", interactionMode)) {
            if (r6 != null) {
                r6.g = "IN_CUSTOM";
            }
            Integer a2 = a(url, asset, r6);
            if (a2 != null) {
                J6.a(F6.g, r6, Integer.valueOf(a2.intValue()), 8);
                unit2 = Unit.INSTANCE;
            } else {
                unit2 = null;
            }
            if (unit2 == null) {
                J6.a(F6.f, r6, (Integer) null, 12);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual("INAPP", interactionMode)) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                String TAG2 = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).c(TAG2, "openUrlInCCT");
            }
            Context context = (Context) this.x.get();
            if (context == null) {
                return;
            }
            if (f() == null && (p0 = this.w) != null) {
                p0.e();
            }
            String a3 = AbstractC2934x3.a(context);
            try {
                boolean cctEnabled = this.s.getCctEnabled();
                if (a3 != null && cctEnabled) {
                    new C2724k2(url, null, context, this.Q, this.l, r6, "NATIVE").a();
                    return;
                }
                InterfaceC2971z5 interfaceC2971z53 = this.j;
                if (interfaceC2971z53 != null) {
                    String TAG3 = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG3, "TAG");
                    ((A5) interfaceC2971z53).a(TAG3, "ChromeCustomTab fallback to Embedded");
                }
                if (r6 != null) {
                    r6.g = "IN_CUSTOM";
                }
                Integer a4 = a(url, asset, r6);
                if (a4 != null) {
                    J6.a(F6.g, r6, Integer.valueOf(a4.intValue()), 8);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    J6.a(F6.f, r6, (Integer) null, 12);
                    return;
                }
                return;
            } catch (Exception e) {
                try {
                    AbstractC2968z2.a(context, url, this.l, "NATIVE");
                    if (r6 != null) {
                        r6.g = "EX_NATIVE";
                    }
                    J6.a(F6.f, r6, (Integer) null, 12);
                } catch (Exception e2) {
                    InterfaceC2971z5 interfaceC2971z54 = this.j;
                    if (interfaceC2971z54 != null) {
                        String TAG4 = this.m;
                        Intrinsics.checkNotNullExpressionValue(TAG4, "TAG");
                        ((A5) interfaceC2971z54).a(TAG4, "Exception occurred while opening External ", e2);
                    }
                    J6.a(F6.g, r6, (Integer) 9, 8);
                }
                InterfaceC2971z5 interfaceC2971z55 = this.j;
                if (interfaceC2971z55 != null) {
                    String TAG5 = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG5, "TAG");
                    ((A5) interfaceC2971z55).a(TAG5, "Fallback to External while opening cct", e);
                    return;
                }
                return;
            }
        }
        String str = asset.q;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(asset, "asset");
        InterfaceC2971z5 interfaceC2971z56 = this.j;
        if (interfaceC2971z56 != null) {
            String TAG6 = this.m;
            Intrinsics.checkNotNullExpressionValue(TAG6, "TAG");
            ((A5) interfaceC2971z56).c(TAG6, "openUrlUsingExternalBrowser");
        }
        if (this.x.get() == null) {
            return;
        }
        if (r6 != null) {
            r6.g = "EX_NATIVE";
        }
        String a5 = AbstractC2968z2.a((Context) this.x.get(), this.l, url, str);
        if (a5 != null) {
            T7 c = c(this);
            if (c == null) {
                return;
            }
            P0 p02 = c.w;
            if (!this.D && p02 != null) {
                p02.g();
            }
            if (Intrinsics.areEqual(a5, str)) {
                asset.a("TRACKER_EVENT_TYPE_FALLBACK_URL", a(asset), (L7) null, this.j);
            }
            J6.a(F6.f, r6, (Integer) null, 12);
            return;
        }
        J6.a(F6.g, r6, (Integer) 6, 8);
    }

    public final Integer a(String url, C2613d8 asset, R6 r6) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(asset, "asset");
        try {
            Context context = (Context) this.x.get();
            if (context == null) {
                return 7;
            }
            if (AbstractC2968z2.a(url)) {
                InterfaceC2971z5 interfaceC2971z5 = this.j;
                if (interfaceC2971z5 != null) {
                    String TAG = this.m;
                    Intrinsics.checkNotNullExpressionValue(TAG, "TAG");
                    ((A5) interfaceC2971z5).c(TAG, "openUrlUsingEmbeddedBrowser");
                }
                InMobiAdActivity.l = null;
                S7 s7 = this.L;
                if (s7 == null) {
                    s7 = new S7(this);
                    this.L = s7;
                }
                InMobiAdActivity.m = s7;
                Intent intent = new Intent(context, (Class<?>) InMobiAdActivity.class);
                intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 100);
                intent.putExtra("com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL", url);
                intent.putExtra("placementId", this.e);
                intent.putExtra("creativeId", getCreativeId());
                intent.putExtra("impressionId", getImpressionId());
                intent.putExtra("allowAutoRedirection", this.f);
                if (r6 != null) {
                    intent.putExtra("lpTelemetryControlInfo", r6);
                }
                if (asset.i) {
                    intent.putExtra("supportLockScreen", true);
                }
                Uc.f2453a.a(context, intent);
                return null;
            }
            return 10;
        } catch (Exception e) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                String TAG2 = this.m;
                Intrinsics.checkNotNullExpressionValue(TAG2, "TAG");
                ((A5) interfaceC2971z52).a(TAG2, "Error while opening Embedded Browser", e);
            }
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
            return 9;
        }
    }
}
