package com.inmobi.ads.rendering;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import com.inmobi.commons.core.configs.AdConfig;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.media.A5;
import com.inmobi.media.AbstractC2669gc;
import com.inmobi.media.AbstractC2680h7;
import com.inmobi.media.AbstractC2759m5;
import com.inmobi.media.AbstractC2920w5;
import com.inmobi.media.B2;
import com.inmobi.media.C2592c4;
import com.inmobi.media.C2677h4;
import com.inmobi.media.C2711j5;
import com.inmobi.media.C2743l5;
import com.inmobi.media.C2775n5;
import com.inmobi.media.C2844ra;
import com.inmobi.media.C2950y3;
import com.inmobi.media.Cc;
import com.inmobi.media.D3;
import com.inmobi.media.Df;
import com.inmobi.media.Gb;
import com.inmobi.media.GestureDetectorOnGestureListenerC2634ec;
import com.inmobi.media.InterfaceC2914w;
import com.inmobi.media.InterfaceC2930x;
import com.inmobi.media.InterfaceC2971z5;
import com.inmobi.media.L3;
import com.inmobi.media.P;
import com.inmobi.media.R6;
import com.inmobi.media.S5;
import com.inmobi.media.U3;
import com.inmobi.media.Uc;
import com.inmobi.media.Y3;
import com.inmobi.media.tf;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.entity.b;
import io.bidmachine.rendering.model.EventTaskParams;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/inmobi/ads/rendering/InMobiAdActivity;", "Landroid/app/Activity;", "<init>", "()V", "com/inmobi/media/m5", "media_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class InMobiAdActivity extends Activity {
    public static final SparseArray k = new SparseArray();
    public static GestureDetectorOnGestureListenerC2634ec l;
    public static AbstractC2669gc m;

    /* renamed from: a, reason: collision with root package name */
    public C2743l5 f2223a;
    public C2711j5 b;
    public GestureDetectorOnGestureListenerC2634ec c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public InterfaceC2971z5 h;
    public Df i;
    public OnBackInvokedCallback j;

    public static final void a(InMobiAdActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a();
    }

    public static final boolean b(InMobiAdActivity this$0, View view, MotionEvent motionEvent) {
        C2592c4 c2592c4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 1) {
            if (motionEvent.getAction() == 0) {
                view.setBackgroundColor(-16711681);
            }
            return true;
        }
        view.setBackgroundColor(-7829368);
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this$0.c;
        if (gestureDetectorOnGestureListenerC2634ec != null && (c2592c4 = gestureDetectorOnGestureListenerC2634ec.z0) != null) {
            C2592c4.a(c2592c4, 6, true, null, 12);
        }
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this$0.c;
        if (gestureDetectorOnGestureListenerC2634ec2 != null) {
            gestureDetectorOnGestureListenerC2634ec2.reload();
        }
        return true;
    }

    public static final boolean c(InMobiAdActivity this$0, View view, MotionEvent motionEvent) {
        C2592c4 c2592c4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 1) {
            if (motionEvent.getAction() == 0) {
                view.setBackgroundColor(-16711681);
            }
            return true;
        }
        view.setBackgroundColor(-7829368);
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this$0.c;
        if (gestureDetectorOnGestureListenerC2634ec == null || !gestureDetectorOnGestureListenerC2634ec.canGoBack()) {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this$0.c;
            if (gestureDetectorOnGestureListenerC2634ec2 != null && (c2592c4 = gestureDetectorOnGestureListenerC2634ec2.z0) != null) {
                C2592c4.a(c2592c4, 5, true, null, 12);
            }
            this$0.e = true;
            this$0.finish();
        } else {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec3 = this$0.c;
            if (gestureDetectorOnGestureListenerC2634ec3 != null) {
                gestureDetectorOnGestureListenerC2634ec3.goBack();
            }
        }
        return true;
    }

    public static final boolean d(InMobiAdActivity this$0, View view, MotionEvent motionEvent) {
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() != 1) {
            if (motionEvent.getAction() == 0) {
                view.setBackgroundColor(-16711681);
            }
            return true;
        }
        view.setBackgroundColor(-7829368);
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = this$0.c;
        if (gestureDetectorOnGestureListenerC2634ec2 != null && gestureDetectorOnGestureListenerC2634ec2.canGoForward() && (gestureDetectorOnGestureListenerC2634ec = this$0.c) != null) {
            gestureDetectorOnGestureListenerC2634ec.goForward();
        }
        return true;
    }

    @Override // android.app.Activity
    public final void onBackPressed() {
        a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        InterfaceC2971z5 interfaceC2971z5 = this.h;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((A5) interfaceC2971z5).c("InMobiAdActivity", "onConfigChanged");
        }
        super.onConfigurationChanged(newConfig);
        C2743l5 c2743l5 = this.f2223a;
        if (c2743l5 != null) {
            if (c2743l5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                c2743l5 = null;
            }
            c2743l5.b();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:119:0x013d, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007e, code lost:
    
        if (r4 == null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ec A[Catch: Exception -> 0x026b, TryCatch #1 {Exception -> 0x026b, blocks: (B:65:0x01d5, B:68:0x01e7, B:71:0x01f1, B:74:0x01f7, B:103:0x01ec, B:104:0x01e4), top: B:64:0x01d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01e4 A[Catch: Exception -> 0x026b, TryCatch #1 {Exception -> 0x026b, blocks: (B:65:0x01d5, B:68:0x01e7, B:71:0x01f1, B:74:0x01f7, B:103:0x01ec, B:104:0x01e4), top: B:64:0x01d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x020d A[Catch: Exception -> 0x0269, TryCatch #3 {Exception -> 0x0269, blocks: (B:78:0x0203, B:79:0x0209, B:81:0x020d, B:82:0x0212, B:84:0x023b, B:85:0x0243, B:87:0x0247, B:88:0x024a, B:90:0x024e, B:91:0x0253), top: B:77:0x0203 }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x023b A[Catch: Exception -> 0x0269, TryCatch #3 {Exception -> 0x0269, blocks: (B:78:0x0203, B:79:0x0209, B:81:0x020d, B:82:0x0212, B:84:0x023b, B:85:0x0243, B:87:0x0247, B:88:0x024a, B:90:0x024e, B:91:0x0253), top: B:77:0x0203 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0247 A[Catch: Exception -> 0x0269, TryCatch #3 {Exception -> 0x0269, blocks: (B:78:0x0203, B:79:0x0209, B:81:0x020d, B:82:0x0212, B:84:0x023b, B:85:0x0243, B:87:0x0247, B:88:0x024a, B:90:0x024e, B:91:0x0253), top: B:77:0x0203 }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x024e A[Catch: Exception -> 0x0269, TryCatch #3 {Exception -> 0x0269, blocks: (B:78:0x0203, B:79:0x0209, B:81:0x020d, B:82:0x0212, B:84:0x023b, B:85:0x0243, B:87:0x0247, B:88:0x024a, B:90:0x024e, B:91:0x0253), top: B:77:0x0203 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x027c  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onCreate(Bundle bundle) {
        int i;
        R6 r6;
        AdConfig adConfig;
        Unit unit;
        AbstractC2669gc abstractC2669gc;
        String str;
        String str2;
        InterfaceC2971z5 interfaceC2971z5;
        AbstractC2669gc abstractC2669gc2;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec3;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec4;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec5;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec6;
        C2743l5 c2743l5;
        AdConfig adConfig2;
        Object obj;
        InMobiAdActivity inMobiAdActivity = this;
        super.onCreate(bundle);
        InterfaceC2971z5 interfaceC2971z52 = inMobiAdActivity.h;
        if (interfaceC2971z52 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((A5) interfaceC2971z52).a("InMobiAdActivity", "onCreate called");
        }
        if (!Uc.q()) {
            inMobiAdActivity.finish();
            InterfaceC2971z5 interfaceC2971z53 = inMobiAdActivity.h;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
                ((A5) interfaceC2971z53).b("InMobiAdActivity", "session not found. close");
            }
            AbstractC2680h7.a((byte) 2, "InMobi", "Session not found, AdActivity will be closed");
            return;
        }
        inMobiAdActivity.f = false;
        if (Build.VERSION.SDK_INT >= 29) {
            U3.b(inMobiAdActivity);
        }
        inMobiAdActivity.d = inMobiAdActivity.getIntent().getIntExtra("com.inmobi.ads.rendering.InMobiAdActivity.EXTRA_AD_ACTIVITY_TYPE", 102);
        inMobiAdActivity.f2223a = new C2743l5(inMobiAdActivity);
        String key = inMobiAdActivity.getIntent().getStringExtra("loggerCacheKey");
        if (key != null) {
            HashMap hashMap = AbstractC2759m5.f2639a;
            Intrinsics.checkNotNullParameter(key, "key");
            try {
                WeakReference weakReference = (WeakReference) AbstractC2759m5.f2639a.get(key);
                obj = weakReference != null ? weakReference.get() : null;
            } catch (ClassCastException unused) {
            }
        }
        i = inMobiAdActivity.d;
        if (i == 100) {
            if (i != 102) {
                return;
            }
            C2711j5 orientationListener = new C2711j5(inMobiAdActivity);
            InterfaceC2971z5 logger = inMobiAdActivity.h;
            if (logger != null) {
                Intrinsics.checkNotNullParameter(logger, "logger");
                orientationListener.h = logger;
            }
            C2743l5 c2743l52 = inMobiAdActivity.f2223a;
            if (c2743l52 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                c2743l52 = null;
            }
            c2743l52.getClass();
            Intrinsics.checkNotNullParameter(orientationListener, "orientationListener");
            c2743l52.b.add(orientationListener);
            c2743l52.a();
            inMobiAdActivity.b = orientationListener;
            Intent intent = inMobiAdActivity.getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
            orientationListener.a(intent, k);
            return;
        }
        String stringExtra = inMobiAdActivity.getIntent().getStringExtra("com.inmobi.ads.rendering.InMobiAdActivity.IN_APP_BROWSER_URL");
        long longExtra = inMobiAdActivity.getIntent().getLongExtra("placementId", Long.MIN_VALUE);
        long longExtra2 = inMobiAdActivity.getIntent().getLongExtra("viewTouchTimestamp", -1L);
        boolean booleanExtra = inMobiAdActivity.getIntent().getBooleanExtra("allowAutoRedirection", false);
        String stringExtra2 = inMobiAdActivity.getIntent().getStringExtra("impressionId");
        String stringExtra3 = inMobiAdActivity.getIntent().getStringExtra("creativeId");
        boolean booleanExtra2 = inMobiAdActivity.getIntent().getBooleanExtra("supportLockScreen", false);
        try {
        } catch (Exception unused2) {
            r6 = null;
        }
        if (Build.VERSION.SDK_INT >= 33) {
            r6 = (R6) inMobiAdActivity.getIntent().getParcelableExtra("lpTelemetryControlInfo", R6.class);
        } else {
            Parcelable parcelableExtra = inMobiAdActivity.getIntent().getParcelableExtra("lpTelemetryControlInfo");
            if (parcelableExtra instanceof R6) {
                r6 = (R6) parcelableExtra;
            }
            r6 = null;
        }
        if (booleanExtra2) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            inMobiAdActivity.getWindow().requestFeature(1);
            if (L3.f2348a.w()) {
                inMobiAdActivity.setShowWhenLocked(true);
            } else {
                inMobiAdActivity.getWindow().addFlags(524288);
            }
        }
        AbstractC2669gc abstractC2669gc3 = GestureDetectorOnGestureListenerC2634ec.Z0;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec7 = l;
        if (gestureDetectorOnGestureListenerC2634ec7 != null) {
            abstractC2669gc3 = gestureDetectorOnGestureListenerC2634ec7.getListener();
            adConfig = gestureDetectorOnGestureListenerC2634ec7.getAdConfig();
            unit = Unit.INSTANCE;
        } else {
            adConfig = null;
            unit = null;
        }
        try {
            try {
                try {
                    if (unit == null) {
                        HashMap hashMap2 = D3.f2258a;
                        Config a2 = D3.a(Uc.b(), b.JSON_KEY_ADS);
                        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.AdConfig");
                        adConfig = (AdConfig) a2;
                        abstractC2669gc = m;
                        if (abstractC2669gc != null) {
                            Intrinsics.checkNotNull(abstractC2669gc);
                            AdConfig adConfig3 = adConfig;
                            long j = longExtra2 + 4;
                            InterfaceC2971z5 interfaceC2971z54 = inMobiAdActivity.h;
                            abstractC2669gc2 = abstractC2669gc;
                            R6 r62 = r6;
                            str2 = "TAG";
                            str = "InMobiAdActivity";
                            inMobiAdActivity = this;
                            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec8 = new GestureDetectorOnGestureListenerC2634ec(inMobiAdActivity, (byte) 1, null, stringExtra2, true, null, j, null, interfaceC2971z54, new Cc(EventTaskParams.STATE_GROUP_DEFAULT, "browser"), new tf(interfaceC2971z54), null, 164);
                            inMobiAdActivity.c = gestureDetectorOnGestureListenerC2634ec8;
                            gestureDetectorOnGestureListenerC2634ec8.setPlacementId(longExtra);
                            gestureDetectorOnGestureListenerC2634ec = inMobiAdActivity.c;
                            if (gestureDetectorOnGestureListenerC2634ec == null) {
                                gestureDetectorOnGestureListenerC2634ec.setCreativeId(stringExtra3);
                            }
                            gestureDetectorOnGestureListenerC2634ec2 = inMobiAdActivity.c;
                            if (gestureDetectorOnGestureListenerC2634ec2 == null) {
                                gestureDetectorOnGestureListenerC2634ec2.setAllowAutoRedirection(booleanExtra);
                            }
                            gestureDetectorOnGestureListenerC2634ec3 = inMobiAdActivity.c;
                            if (gestureDetectorOnGestureListenerC2634ec3 == null) {
                                if (adConfig3 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("adConfig");
                                    adConfig2 = null;
                                } else {
                                    adConfig2 = adConfig3;
                                }
                                abstractC2669gc = abstractC2669gc2;
                                try {
                                    gestureDetectorOnGestureListenerC2634ec3.a(abstractC2669gc, adConfig2);
                                } catch (Exception e) {
                                    e = e;
                                    interfaceC2971z5 = inMobiAdActivity.h;
                                    if (interfaceC2971z5 != null) {
                                    }
                                    S5 s5 = S5.f2425a;
                                    S5.d.a(AbstractC2920w5.a(e, "event"));
                                    abstractC2669gc.c();
                                    inMobiAdActivity.finish();
                                    return;
                                }
                            } else {
                                abstractC2669gc = abstractC2669gc2;
                            }
                            gestureDetectorOnGestureListenerC2634ec4 = inMobiAdActivity.c;
                            if (gestureDetectorOnGestureListenerC2634ec4 != null) {
                                gestureDetectorOnGestureListenerC2634ec4.setLandingPageTelemetryControlInfoOnWebViewClient(r62);
                            }
                            RelativeLayout relativeLayout = new RelativeLayout(inMobiAdActivity);
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                            layoutParams.addRule(10);
                            layoutParams.addRule(2, 65533);
                            relativeLayout.setBackgroundColor(-1);
                            relativeLayout.addView(inMobiAdActivity.c, layoutParams);
                            inMobiAdActivity.a(relativeLayout);
                            inMobiAdActivity.setContentView(relativeLayout);
                            gestureDetectorOnGestureListenerC2634ec5 = inMobiAdActivity.c;
                            if (gestureDetectorOnGestureListenerC2634ec5 != null) {
                                Intrinsics.checkNotNull(stringExtra);
                                gestureDetectorOnGestureListenerC2634ec5.loadUrl(stringExtra);
                            }
                            gestureDetectorOnGestureListenerC2634ec6 = inMobiAdActivity.c;
                            if (gestureDetectorOnGestureListenerC2634ec6 != null) {
                                gestureDetectorOnGestureListenerC2634ec6.setFullScreenActivityContext(inMobiAdActivity);
                            }
                            c2743l5 = inMobiAdActivity.f2223a;
                            if (c2743l5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                                c2743l5 = null;
                            }
                            GestureDetectorOnGestureListenerC2634ec orientationListener2 = inMobiAdActivity.c;
                            Intrinsics.checkNotNull(orientationListener2);
                            c2743l5.getClass();
                            Intrinsics.checkNotNullParameter(orientationListener2, "orientationListener");
                            c2743l5.b.add(orientationListener2);
                            c2743l5.a();
                            return;
                        }
                    }
                    GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec82 = new GestureDetectorOnGestureListenerC2634ec(inMobiAdActivity, (byte) 1, null, stringExtra2, true, null, j, null, interfaceC2971z54, new Cc(EventTaskParams.STATE_GROUP_DEFAULT, "browser"), new tf(interfaceC2971z54), null, 164);
                    inMobiAdActivity.c = gestureDetectorOnGestureListenerC2634ec82;
                    gestureDetectorOnGestureListenerC2634ec82.setPlacementId(longExtra);
                    gestureDetectorOnGestureListenerC2634ec = inMobiAdActivity.c;
                    if (gestureDetectorOnGestureListenerC2634ec == null) {
                    }
                    gestureDetectorOnGestureListenerC2634ec2 = inMobiAdActivity.c;
                    if (gestureDetectorOnGestureListenerC2634ec2 == null) {
                    }
                    gestureDetectorOnGestureListenerC2634ec3 = inMobiAdActivity.c;
                    if (gestureDetectorOnGestureListenerC2634ec3 == null) {
                    }
                    gestureDetectorOnGestureListenerC2634ec4 = inMobiAdActivity.c;
                    if (gestureDetectorOnGestureListenerC2634ec4 != null) {
                    }
                    RelativeLayout relativeLayout2 = new RelativeLayout(inMobiAdActivity);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                    layoutParams2.addRule(10);
                    layoutParams2.addRule(2, 65533);
                    relativeLayout2.setBackgroundColor(-1);
                    relativeLayout2.addView(inMobiAdActivity.c, layoutParams2);
                    inMobiAdActivity.a(relativeLayout2);
                    inMobiAdActivity.setContentView(relativeLayout2);
                    gestureDetectorOnGestureListenerC2634ec5 = inMobiAdActivity.c;
                    if (gestureDetectorOnGestureListenerC2634ec5 != null) {
                    }
                    gestureDetectorOnGestureListenerC2634ec6 = inMobiAdActivity.c;
                    if (gestureDetectorOnGestureListenerC2634ec6 != null) {
                    }
                    c2743l5 = inMobiAdActivity.f2223a;
                    if (c2743l5 == null) {
                    }
                    GestureDetectorOnGestureListenerC2634ec orientationListener22 = inMobiAdActivity.c;
                    Intrinsics.checkNotNull(orientationListener22);
                    c2743l5.getClass();
                    Intrinsics.checkNotNullParameter(orientationListener22, "orientationListener");
                    c2743l5.b.add(orientationListener22);
                    c2743l5.a();
                    return;
                } catch (Exception e2) {
                    e = e2;
                    abstractC2669gc = abstractC2669gc2;
                }
                abstractC2669gc2 = abstractC2669gc;
                R6 r622 = r6;
                str2 = "TAG";
                str = "InMobiAdActivity";
                inMobiAdActivity = this;
            } catch (Exception e3) {
                e = e3;
                inMobiAdActivity = this;
                str = "InMobiAdActivity";
                str2 = "TAG";
                interfaceC2971z5 = inMobiAdActivity.h;
                if (interfaceC2971z5 != null) {
                    String str3 = str;
                    Intrinsics.checkNotNullExpressionValue(str3, str2);
                    ((A5) interfaceC2971z5).a(str3, "Exception while initializing In-App browser", e);
                }
                S5 s52 = S5.f2425a;
                S5.d.a(AbstractC2920w5.a(e, "event"));
                abstractC2669gc.c();
                inMobiAdActivity.finish();
                return;
            }
            InterfaceC2971z5 interfaceC2971z542 = inMobiAdActivity.h;
        } catch (Exception e4) {
            e = e4;
        }
        abstractC2669gc = abstractC2669gc3;
        AdConfig adConfig32 = adConfig;
        long j2 = longExtra2 + 4;
        obj = null;
        inMobiAdActivity.h = (InterfaceC2971z5) obj;
        i = inMobiAdActivity.d;
        if (i == 100) {
        }
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        C2711j5 c2711j5;
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec;
        C2592c4 c2592c4;
        InterfaceC2914w fullScreenEventsListener;
        InterfaceC2971z5 interfaceC2971z5 = this.h;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((A5) interfaceC2971z5).c("InMobiAdActivity", "onDestroy");
        }
        int i = this.d;
        if (100 == i) {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = l;
            if (gestureDetectorOnGestureListenerC2634ec2 != null) {
                GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
                gestureDetectorOnGestureListenerC2634ec2.a(Gb.a("IN_CUSTOM_BROWSER", "onClose"));
            }
        } else if (102 == i && (c2711j5 = this.b) != null && c2711j5.e != null && c2711j5 != null) {
            GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
            c2711j5.a(Gb.a("IN_CUSTOM_EXPAND", "onClose"));
        }
        if (this.e) {
            int i2 = this.d;
            if (100 == i2) {
                GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec3 = this.c;
                if (gestureDetectorOnGestureListenerC2634ec3 != null && (fullScreenEventsListener = gestureDetectorOnGestureListenerC2634ec3.getFullScreenEventsListener()) != null) {
                    try {
                        fullScreenEventsListener.b(this.c);
                        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec4 = this.c;
                        Intrinsics.checkNotNull(gestureDetectorOnGestureListenerC2634ec4);
                        gestureDetectorOnGestureListenerC2634ec4.b();
                        C2743l5 c2743l5 = this.f2223a;
                        if (c2743l5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                            c2743l5 = null;
                        }
                        GestureDetectorOnGestureListenerC2634ec orientationListener = this.c;
                        Intrinsics.checkNotNull(orientationListener);
                        c2743l5.getClass();
                        Intrinsics.checkNotNullParameter(orientationListener, "orientationListener");
                        c2743l5.b.remove(orientationListener);
                        c2743l5.a();
                        this.c = null;
                    } catch (Exception unused) {
                    }
                }
            } else if (102 == i2) {
                C2711j5 orientationListener2 = this.b;
                if (orientationListener2 != null) {
                    C2743l5 c2743l52 = this.f2223a;
                    if (c2743l52 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                        c2743l52 = null;
                    }
                    c2743l52.getClass();
                    Intrinsics.checkNotNullParameter(orientationListener2, "orientationListener");
                    c2743l52.b.remove(orientationListener2);
                    c2743l52.a();
                    P p = orientationListener2.c;
                    if (p != null) {
                        p.b();
                    }
                    RelativeLayout relativeLayout = orientationListener2.d;
                    if (relativeLayout != null) {
                        relativeLayout.removeAllViews();
                    }
                    Y3 y3 = orientationListener2.e;
                    if (y3 != null) {
                        C2677h4 c2677h4 = y3.c;
                        if (c2677h4 != null) {
                            c2677h4.destroy();
                        }
                        y3.c = null;
                        y3.d = null;
                        y3.e = null;
                        Df df = y3.g;
                        if (df != null) {
                            df.a();
                        }
                        y3.removeAllViews();
                    }
                    orientationListener2.f2609a.clear();
                    orientationListener2.b = null;
                    orientationListener2.c = null;
                    orientationListener2.d = null;
                    orientationListener2.e = null;
                }
                this.b = null;
            }
        } else {
            int i3 = this.d;
            if (100 != i3 && 102 == i3) {
                C2711j5 orientationListener3 = this.b;
                if (orientationListener3 != null) {
                    C2743l5 c2743l53 = this.f2223a;
                    if (c2743l53 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
                        c2743l53 = null;
                    }
                    c2743l53.getClass();
                    Intrinsics.checkNotNullParameter(orientationListener3, "orientationListener");
                    c2743l53.b.remove(orientationListener3);
                    c2743l53.a();
                    P p2 = orientationListener3.c;
                    if (p2 != null) {
                        p2.b();
                    }
                    RelativeLayout relativeLayout2 = orientationListener3.d;
                    if (relativeLayout2 != null) {
                        relativeLayout2.removeAllViews();
                    }
                    Y3 y32 = orientationListener3.e;
                    if (y32 != null) {
                        C2677h4 c2677h42 = y32.c;
                        if (c2677h42 != null) {
                            c2677h42.destroy();
                        }
                        y32.c = null;
                        y32.d = null;
                        y32.e = null;
                        Df df2 = y32.g;
                        if (df2 != null) {
                            df2.a();
                        }
                        y32.removeAllViews();
                    }
                    orientationListener3.f2609a.clear();
                    orientationListener3.b = null;
                    orientationListener3.c = null;
                    orientationListener3.d = null;
                    orientationListener3.e = null;
                }
                this.b = null;
            }
            if (100 == this.d && (gestureDetectorOnGestureListenerC2634ec = this.c) != null && (c2592c4 = gestureDetectorOnGestureListenerC2634ec.z0) != null) {
                C2592c4.a(c2592c4, 9, true, null, 12);
            }
        }
        Df df3 = this.i;
        if (df3 != null) {
            df3.a();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z) {
        C2711j5 c2711j5;
        C2743l5 c2743l5;
        InterfaceC2971z5 interfaceC2971z5 = this.h;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((A5) interfaceC2971z5).c("InMobiAdActivity", "multiWindow mode - " + z);
        }
        super.onMultiWindowModeChanged(z);
        if (z || (c2711j5 = this.b) == null) {
            return;
        }
        InterfaceC2930x interfaceC2930x = c2711j5.b;
        C2743l5 c2743l52 = null;
        C2844ra orientationProperties = (interfaceC2930x == null || !(interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec)) ? null : ((GestureDetectorOnGestureListenerC2634ec) interfaceC2930x).getOrientationProperties();
        if (orientationProperties == null || (c2743l5 = this.f2223a) == null) {
            return;
        }
        if (c2743l5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orientationHandler");
        } else {
            c2743l52 = c2743l5;
        }
        c2743l52.a(orientationProperties);
    }

    @Override // android.app.Activity
    public final void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        InterfaceC2971z5 interfaceC2971z5 = this.h;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((A5) interfaceC2971z5).c("InMobiAdActivity", "onNewIntent");
        }
        super.onNewIntent(intent);
        this.f = false;
        this.c = null;
        setIntent(intent);
        C2711j5 c2711j5 = this.b;
        if (c2711j5 != null) {
            SparseArray adContainers = k;
            Intrinsics.checkNotNullParameter(intent, "intent");
            Intrinsics.checkNotNullParameter(adContainers, "adContainers");
            c2711j5.a(intent, adContainers);
            P p = c2711j5.c;
            if (p != null) {
                p.g();
            }
        }
    }

    @Override // android.app.Activity
    public final void onPause() {
        C2711j5 c2711j5;
        super.onPause();
        int i = this.d;
        if (100 == i) {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = l;
            if (gestureDetectorOnGestureListenerC2634ec != null) {
                GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
                gestureDetectorOnGestureListenerC2634ec.a(Gb.a("IN_CUSTOM_BROWSER", "onHidden"));
                return;
            }
            return;
        }
        if (102 != i || (c2711j5 = this.b) == null || c2711j5.e == null || c2711j5 == null) {
            return;
        }
        GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
        c2711j5.a(Gb.a("IN_CUSTOM_EXPAND", "onHidden"));
    }

    @Override // android.app.Activity
    public final void onResume() {
        P p;
        InterfaceC2914w fullScreenEventsListener;
        InterfaceC2971z5 interfaceC2971z5 = this.h;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((A5) interfaceC2971z5).c("InMobiAdActivity", C3040d4.h.u0);
        }
        super.onResume();
        if (this.e) {
            return;
        }
        int i = this.d;
        if (100 == i) {
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.c;
            if (gestureDetectorOnGestureListenerC2634ec != null && (fullScreenEventsListener = gestureDetectorOnGestureListenerC2634ec.getFullScreenEventsListener()) != null) {
                try {
                    if (!this.f) {
                        this.f = true;
                        fullScreenEventsListener.a(this.c);
                    }
                } catch (Exception unused) {
                }
            }
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec2 = l;
            if (gestureDetectorOnGestureListenerC2634ec2 != null) {
                GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
                gestureDetectorOnGestureListenerC2634ec2.a(Gb.a("IN_CUSTOM_BROWSER", "onVisible"));
                return;
            }
            return;
        }
        if (102 == i) {
            C2711j5 c2711j5 = this.b;
            if (c2711j5 != null && (p = c2711j5.c) != null) {
                p.c();
            }
            C2711j5 c2711j52 = this.b;
            if (c2711j52 == null || c2711j52.e == null || c2711j52 == null) {
                return;
            }
            GestureDetectorOnGestureListenerC2634ec.Y0.getClass();
            c2711j52.a(Gb.a("IN_CUSTOM_EXPAND", "onVisible"));
        }
    }

    @Override // android.app.Activity
    public final void onStart() {
        C2711j5 c2711j5;
        Window window;
        InterfaceC2971z5 interfaceC2971z5 = this.h;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((A5) interfaceC2971z5).c("InMobiAdActivity", "onStart");
        }
        super.onStart();
        L3 l3 = L3.f2348a;
        if (l3.B()) {
            if (this.j == null) {
                this.j = new OnBackInvokedCallback() { // from class: com.inmobi.ads.rendering.InMobiAdActivity$$ExternalSyntheticLambda4
                    @Override // android.window.OnBackInvokedCallback
                    public final void onBackInvoked() {
                        InMobiAdActivity.a(InMobiAdActivity.this);
                    }
                };
            }
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            OnBackInvokedCallback onBackInvokedCallback = this.j;
            if (onBackInvokedCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backInvokedCallback");
                onBackInvokedCallback = null;
            }
            onBackInvokedDispatcher.registerOnBackInvokedCallback(0, onBackInvokedCallback);
        }
        if (this.e || 102 != this.d || (c2711j5 = this.b) == null) {
            return;
        }
        P p = c2711j5.c;
        if (p != null) {
            p.g();
        }
        InterfaceC2930x interfaceC2930x = c2711j5.b;
        if (interfaceC2930x != null) {
            if ((interfaceC2930x instanceof GestureDetectorOnGestureListenerC2634ec ? ((GestureDetectorOnGestureListenerC2634ec) interfaceC2930x).S0 : false) && !l3.z() && l3.F()) {
                Object obj = c2711j5.f2609a.get();
                InMobiAdActivity inMobiAdActivity = obj instanceof InMobiAdActivity ? (InMobiAdActivity) obj : null;
                if (inMobiAdActivity == null || (window = inMobiAdActivity.getWindow()) == null) {
                    return;
                }
                window.getDecorView().setSystemUiVisibility(5638);
            }
        }
    }

    @Override // android.app.Activity
    public final void onStop() {
        C2711j5 c2711j5;
        P p;
        InterfaceC2971z5 interfaceC2971z5 = this.h;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((A5) interfaceC2971z5).c("InMobiAdActivity", "onStop");
        }
        super.onStop();
        if (L3.f2348a.B() && this.j != null) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            OnBackInvokedCallback onBackInvokedCallback = this.j;
            if (onBackInvokedCallback == null) {
                Intrinsics.throwUninitializedPropertyAccessException("backInvokedCallback");
                onBackInvokedCallback = null;
            }
            onBackInvokedDispatcher.unregisterOnBackInvokedCallback(onBackInvokedCallback);
        }
        if (this.e || (c2711j5 = this.b) == null || (p = c2711j5.c) == null) {
            return;
        }
        p.d();
    }

    public final void a(RelativeLayout relativeLayout) {
        float f = U3.d().c;
        LinearLayout linearLayout = new LinearLayout(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) (48 * f));
        linearLayout.setOrientation(0);
        linearLayout.setId(65533);
        linearLayout.setWeightSum(100.0f);
        linearLayout.setBackgroundResource(R.drawable.bottom_bar);
        linearLayout.setBackgroundColor(-7829368);
        relativeLayout.setBackgroundColor(-7829368);
        layoutParams.addRule(12);
        if (B2.a(this)) {
            Df df = this.i;
            if (df != null) {
                df.a();
            }
            this.i = new Df(this, new C2775n5(layoutParams), this.h);
        }
        relativeLayout.addView(linearLayout, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
        layoutParams2.weight = 25.0f;
        C2950y3 c2950y3 = new C2950y3(this, (byte) 2, this.h);
        c2950y3.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.ads.rendering.InMobiAdActivity$$ExternalSyntheticLambda0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return InMobiAdActivity.a(InMobiAdActivity.this, view, motionEvent);
            }
        });
        linearLayout.addView(c2950y3, layoutParams2);
        C2950y3 c2950y32 = new C2950y3(this, (byte) 3, this.h);
        c2950y32.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.ads.rendering.InMobiAdActivity$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return InMobiAdActivity.b(InMobiAdActivity.this, view, motionEvent);
            }
        });
        linearLayout.addView(c2950y32, layoutParams2);
        C2950y3 c2950y33 = new C2950y3(this, (byte) 4, this.h);
        c2950y33.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.ads.rendering.InMobiAdActivity$$ExternalSyntheticLambda2
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return InMobiAdActivity.c(InMobiAdActivity.this, view, motionEvent);
            }
        });
        linearLayout.addView(c2950y33, layoutParams2);
        C2950y3 c2950y34 = new C2950y3(this, (byte) 6, this.h);
        c2950y34.setOnTouchListener(new View.OnTouchListener() { // from class: com.inmobi.ads.rendering.InMobiAdActivity$$ExternalSyntheticLambda3
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return InMobiAdActivity.d(InMobiAdActivity.this, view, motionEvent);
            }
        });
        linearLayout.addView(c2950y34, layoutParams2);
    }

    @Override // android.app.Activity
    public final void onMultiWindowModeChanged(boolean z, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onMultiWindowModeChanged(z, newConfig);
        onMultiWindowModeChanged(z);
    }

    public static final boolean a(InMobiAdActivity this$0, View view, MotionEvent motionEvent) {
        C2592c4 c2592c4;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (motionEvent.getAction() == 1) {
            view.setBackgroundColor(-7829368);
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this$0.c;
            if (gestureDetectorOnGestureListenerC2634ec != null && (c2592c4 = gestureDetectorOnGestureListenerC2634ec.z0) != null) {
                C2592c4.a(c2592c4, 5, true, null, 12);
            }
            this$0.e = true;
            this$0.finish();
            return true;
        }
        if (motionEvent.getAction() == 0) {
            view.setBackgroundColor(-16711681);
        }
        return true;
    }

    public final void a() {
        C2592c4 c2592c4;
        P p;
        InterfaceC2971z5 interfaceC2971z5 = this.h;
        if (interfaceC2971z5 != null) {
            Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
            ((A5) interfaceC2971z5).c("InMobiAdActivity", "onBackPressed");
        }
        int i = this.d;
        if (i == 102) {
            InterfaceC2971z5 interfaceC2971z52 = this.h;
            if (interfaceC2971z52 != null) {
                Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
                ((A5) interfaceC2971z52).c("InMobiAdActivity", "back pressed on ad");
            }
            C2711j5 c2711j5 = this.b;
            if (c2711j5 == null || (p = c2711j5.c) == null) {
                return;
            }
            p.a();
            return;
        }
        if (i == 100) {
            InterfaceC2971z5 interfaceC2971z53 = this.h;
            if (interfaceC2971z53 != null) {
                Intrinsics.checkNotNullExpressionValue("InMobiAdActivity", "TAG");
                ((A5) interfaceC2971z53).c("InMobiAdActivity", "back pressed in browser");
            }
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this.c;
            if (gestureDetectorOnGestureListenerC2634ec != null && (c2592c4 = gestureDetectorOnGestureListenerC2634ec.z0) != null) {
                C2592c4.a(c2592c4, 7, true, null, 12);
            }
            this.e = true;
            finish();
        }
    }
}
