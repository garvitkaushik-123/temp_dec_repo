package com.applovin.impl;

import android.R;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.core.net.MailTo;
import androidx.webkit.internal.AssetHelper;
import com.applovin.creative.MaxCreativeDebuggerActivity;
import com.applovin.creative.MaxCreativeDebuggerDisplayedAdActivity;
import com.applovin.impl.d;
import com.applovin.impl.l1;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.C3040d4;
import com.unity3d.ads.core.domain.AndroidInitializeBoldSDK;
import com.vungle.ads.internal.protos.Sdk;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class d1 implements l1.a {
    private static WeakReference m;
    private static final AtomicBoolean n = new AtomicBoolean();

    /* renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f429a;
    private final Context b;
    private final c1 e;
    private l1 g;
    private d7 h;
    private int i;
    private boolean j;
    private long k;
    private boolean l;
    private final List c = new ArrayList(10);
    private final Object d = new Object();
    private WeakReference f = new WeakReference(null);

    class a extends com.applovin.impl.b {
        a() {
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof MaxCreativeDebuggerActivity) {
                com.applovin.impl.sdk.o.g("AppLovinSdk", "Started Creative Debugger");
                if (!d1.this.h() || d1.m.get() != activity) {
                    MaxCreativeDebuggerActivity maxCreativeDebuggerActivity = (MaxCreativeDebuggerActivity) activity;
                    WeakReference unused = d1.m = new WeakReference(maxCreativeDebuggerActivity);
                    maxCreativeDebuggerActivity.a(d1.this.e, d1.this.f429a.e());
                }
                d1.n.set(false);
            }
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof MaxCreativeDebuggerActivity) {
                com.applovin.impl.sdk.o.g("AppLovinSdk", "Creative Debugger destroyed");
                WeakReference unused = d1.m = null;
            }
        }
    }

    class b implements d.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f431a;

        b(Object obj) {
            this.f431a = obj;
        }

        @Override // com.applovin.impl.d.b
        public void a(MaxCreativeDebuggerDisplayedAdActivity maxCreativeDebuggerDisplayedAdActivity) {
            maxCreativeDebuggerDisplayedAdActivity.a(new p1(this.f431a, d1.this.f429a.I().b()), d1.this.f429a);
            d1.n.set(false);
        }
    }

    public d1(com.applovin.impl.sdk.k kVar) {
        this.f429a = kVar;
        Context o = com.applovin.impl.sdk.k.o();
        this.b = o;
        this.e = new c1(o);
    }

    private void e(Object obj) {
        com.applovin.impl.sdk.o.g("AppLovinSdk", "Starting Creative Debugger for current fullscreen ad...");
        d.a(this.b, MaxCreativeDebuggerDisplayedAdActivity.class, this.f429a.e(), new b(obj));
    }

    private Drawable f() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.rgb(5, Sdk.SDKError.Reason.MRAID_JS_WRITE_FAILED_VALUE, 170));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setShape(1);
        gradientDrawable2.setColor(Color.rgb(2, 98, 127));
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        WeakReference weakReference = m;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i() {
        long seconds = TimeUnit.MILLISECONDS.toSeconds(SystemClock.elapsedRealtime() - this.k);
        if (this.k == 0 || seconds < 10) {
            return;
        }
        this.f429a.E().a(c2.d, "showingMediationDebuggerFromHoldingCreativeDebuggerButton");
        this.f429a.Y0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        this.i = 0;
    }

    private void m() {
        this.f429a.e().a(new a());
    }

    public boolean g() {
        return ((Boolean) this.f429a.a(v4.i1)).booleanValue() && this.f429a.o0().isCreativeDebuggerEnabled();
    }

    public void k() {
        l1 l1Var = this.g;
        if (l1Var != null) {
            l1Var.b();
        }
    }

    public void l() {
        if (g()) {
            this.j = ((Boolean) this.f429a.a(v4.j1)).booleanValue();
            if (this.g == null) {
                this.g = new l1(this.f429a, this);
            }
            this.g.a();
        }
    }

    public void n() {
        ArrayList arrayList;
        if (h() || !n.compareAndSet(false, true)) {
            com.applovin.impl.sdk.o.h("AppLovinSdk", "Creative Debugger is already showing");
            return;
        }
        Object a2 = this.f429a.I().a();
        if (a2 != null) {
            e(a2);
            return;
        }
        synchronized (this.d) {
            arrayList = new ArrayList(this.c);
        }
        this.e.a(arrayList, this.f429a);
        if (!this.l) {
            m();
            this.l = true;
        }
        com.applovin.impl.sdk.o.g("AppLovinSdk", "Starting Creative Debugger...");
        d.a(this.b, MaxCreativeDebuggerActivity.class);
    }

    @Override // com.applovin.impl.l1.a
    public void b() {
        if (this.i == 0) {
            this.h = d7.a(TimeUnit.SECONDS.toMillis(3L), this.f429a, new Runnable() { // from class: com.applovin.impl.d1$$ExternalSyntheticLambda3
                @Override // java.lang.Runnable
                public final void run() {
                    d1.this.j();
                }
            });
        }
        int i = this.i;
        if (i % 2 == 0) {
            this.i = i + 1;
        }
    }

    public void d(Object obj) {
        if (g() && obj != null) {
            if (!t3.a(obj) || c(obj)) {
                if (t3.b(obj) && c(obj)) {
                    return;
                }
                synchronized (this.d) {
                    this.c.add(0, new p1(obj, System.currentTimeMillis()));
                    if (this.c.size() > 10) {
                        this.c.remove(r6.size() - 1);
                    }
                }
            }
        }
    }

    private boolean c(Object obj) {
        MaxAdFormat format;
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            format = ((com.applovin.impl.sdk.ad.b) obj).getAdZone().d();
        } else {
            format = obj instanceof v2 ? ((v2) obj).getFormat() : null;
        }
        return format != null && format.isFullscreenAd();
    }

    @Override // com.applovin.impl.l1.a
    public void a() {
        int i = this.i;
        if (i % 2 == 1) {
            this.i = i + 1;
        }
        if (this.i / 2 == 2) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.d1$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    d1.this.e();
                }
            });
            this.i = 0;
            this.h.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (g() && this.f.get() == null && !h()) {
            Activity b2 = this.f429a.e().b();
            if (b2 == null) {
                this.f429a.O();
                if (com.applovin.impl.sdk.o.a()) {
                    this.f429a.O().b("AppLovinSdk", "Failed to display Creative Debugger button");
                }
            } else {
                View findViewById = b2.findViewById(R.id.content);
                if (findViewById instanceof FrameLayout) {
                    final FrameLayout frameLayout = (FrameLayout) findViewById;
                    final View a2 = a(frameLayout, b2);
                    frameLayout.addView(a2);
                    AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                    alphaAnimation.setDuration(150L);
                    a2.startAnimation(alphaAnimation);
                    final ViewTreeObserver viewTreeObserver = findViewById.getViewTreeObserver();
                    final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.applovin.impl.d1$$ExternalSyntheticLambda1
                        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                        public final void onGlobalLayout() {
                            d1.this.a(a2, frameLayout);
                        }
                    };
                    viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
                    AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.d1$$ExternalSyntheticLambda2
                        @Override // java.lang.Runnable
                        public final void run() {
                            d1.this.a(a2, frameLayout, viewTreeObserver, onGlobalLayoutListener);
                        }
                    }, TimeUnit.SECONDS.toMillis(5L));
                    this.f = new WeakReference(a2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, FrameLayout frameLayout) {
        if (view.getParent() != null || this.f.get() == null) {
            return;
        }
        frameLayout.addView(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view, FrameLayout frameLayout, ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (this.k > 0 && this.j) {
            view.setVisibility(4);
        } else {
            b(view, frameLayout);
        }
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    private void b(View view, FrameLayout frameLayout) {
        if (this.j) {
            view.setOnTouchListener(null);
            this.k = 0L;
        }
        frameLayout.removeView(view);
        this.f = new WeakReference(null);
    }

    public String b(Object obj) {
        JSONObject a2;
        if (obj instanceof com.applovin.impl.sdk.ad.b) {
            return ((com.applovin.impl.sdk.ad.b) obj).getOriginalFullResponse().toString();
        }
        if (!(obj instanceof v2)) {
            return null;
        }
        String E = ((v2) obj).E();
        return (!t3.b(obj) || (a2 = new k(E, this.f429a).a()) == null) ? E : a2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View, android.widget.ImageButton, android.widget.ImageView] */
    private View a(final FrameLayout frameLayout, Activity activity) {
        Button button;
        int dpToPx = AppLovinSdkUtils.dpToPx(activity, 40);
        int i = dpToPx / 10;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx, 8388629);
        layoutParams.setMargins(i, i, i, i);
        try {
            ?? imageButton = new ImageButton(activity);
            imageButton.setImageDrawable(activity.getResources().getDrawable(com.applovin.sdk.R.drawable.applovin_ic_white_small));
            imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageButton.setPadding(i, i, i, i * 2);
            button = imageButton;
        } catch (Throwable unused) {
            Button button2 = new Button(activity);
            button2.setText("ⓘ");
            button2.setTextColor(-1);
            button2.setAllCaps(false);
            button2.setTextSize(2, 20.0f);
            button2.setPadding(0, 0, 0, 0);
            button = button2;
        }
        button.setLayoutParams(layoutParams);
        button.setBackground(f());
        if (this.j) {
            button.setOnTouchListener(new View.OnTouchListener() { // from class: com.applovin.impl.d1$$ExternalSyntheticLambda4
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean a2;
                    a2 = d1.this.a(frameLayout, view, motionEvent);
                    return a2;
                }
            });
        } else {
            button.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.d1$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    d1.this.a(view);
                }
            });
        }
        if (o0.e()) {
            button.setElevation(AppLovinSdkUtils.dpToPx(activity, 5));
        }
        return button;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean a(FrameLayout frameLayout, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.k = SystemClock.elapsedRealtime();
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.d1$$ExternalSyntheticLambda6
                @Override // java.lang.Runnable
                public final void run() {
                    d1.this.i();
                }
            }, TimeUnit.SECONDS.toMillis(10L));
        } else if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            if (view.getVisibility() == 0) {
                this.k = 0L;
                n();
            } else {
                b(view, frameLayout);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [java.io.Serializable, java.lang.Object[]] */
    public void a(p1 p1Var, Context context, boolean z) {
        Object a2 = p1Var.a();
        String a3 = a(p1Var);
        s2 s2Var = new s2();
        if (z) {
            s2Var.b("Please describe the issue you had with this ad:\n\n\n\n");
        }
        s2Var.b(a3);
        String b2 = this.f429a.z().b(a2);
        if (b2 != null) {
            s2Var.a("\nBid Response:\n");
            s2Var.a(b2);
        }
        String str = "AppLovin Ad Report";
        Intent createChooser = Intent.createChooser(new Intent("android.intent.action.SEND").setType(AssetHelper.DEFAULT_MIME_TYPE).putExtra("android.intent.extra.SUBJECT", a2 instanceof com.applovin.impl.sdk.ad.b ? "AppLovin Ad Report" : "MAX Ad Report").putExtra("android.intent.extra.TEXT", s2Var.toString()).setPackage(null), "Share Ad Report");
        if (z) {
            try {
                Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse(MailTo.MAILTO_SCHEME));
                if (!(a2 instanceof com.applovin.impl.sdk.ad.b)) {
                    str = "MAX Ad Report";
                }
                Intent intent2 = intent.putExtra("android.intent.extra.SUBJECT", str).putExtra("android.intent.extra.TEXT", s2Var.toString()).setPackage("com.google.android.gm");
                String str2 = this.f429a.o0().getExtraParameters().get("creative_debugger_email_recipients");
                if (StringUtils.isValidString(str2)) {
                    intent2.putExtra("android.intent.extra.EMAIL", (Serializable) CollectionUtils.explode(str2).toArray());
                }
                context.startActivity(intent2);
                return;
            } catch (ActivityNotFoundException unused) {
                context.startActivity(createChooser);
                return;
            }
        }
        context.startActivity(createChooser);
    }

    public String a(p1 p1Var) {
        Object a2 = p1Var.a();
        s2 s2Var = new s2();
        s2Var.b("Ad Info:\n");
        if (a2 instanceof com.applovin.impl.sdk.ad.b) {
            com.applovin.impl.sdk.ad.b bVar = (com.applovin.impl.sdk.ad.b) a2;
            s2Var.a(AndroidInitializeBoldSDK.MSG_NETWORK, "APPLOVIN").a(bVar).b(bVar);
        } else if (a2 instanceof v2) {
            s2Var.a((v2) a2);
        }
        s2Var.a(this.f429a);
        s2Var.a("Epoch Timestamp (ms)", Long.valueOf(p1Var.b()));
        s2Var.a("\nDebug Info:\n").a("Platform", "fireos".equals(this.f429a.B().y()) ? "Fire OS" : C3040d4.d).a("AppLovin SDK Version", AppLovinSdk.VERSION).a("Plugin Version", this.f429a.a(v4.I3)).a("App Package Name", this.b.getPackageName()).a("Device", String.format("%s %s (%s)", Build.BRAND, Build.MODEL, Build.DEVICE)).a("OS Version", Build.VERSION.RELEASE).a("AppLovin Random Token", this.f429a.i0()).a("Ad Review Version", j.b()).a(a(a2)).a("User ID", this.f429a.x0().e() != null ? this.f429a.x0().e() : "None").a("MD", this.f429a.a(v4.t));
        return s2Var.toString();
    }

    private Bundle a(Object obj) {
        this.f429a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f429a.O().a("CreativeDebuggerService", "Retrieving Ad Review info for ad: " + obj);
        }
        String a2 = k7.a(obj);
        Bundle a3 = this.f429a.j().a(a2);
        this.f429a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f429a.O().a("CreativeDebuggerService", "Serve id: " + a2);
        }
        this.f429a.O();
        if (com.applovin.impl.sdk.o.a()) {
            this.f429a.O().a("CreativeDebuggerService", "Public data: " + a3);
        }
        if (a3 == null) {
            return null;
        }
        for (String str : a3.keySet()) {
            Object obj2 = a3.get(str);
            a3.remove(str);
            BundleUtils.put(StringUtils.toHumanReadableString(str), obj2, a3);
        }
        return a3;
    }
}
