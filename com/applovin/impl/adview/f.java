package com.applovin.impl.adview;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;
import com.applovin.impl.adview.e;
import com.applovin.impl.m1;
import com.applovin.impl.sdk.o;
import com.applovin.impl.v4;
import com.applovin.sdk.AppLovinSdkUtils;

/* loaded from: classes2.dex */
class f extends Dialog implements m1 {

    /* renamed from: a, reason: collision with root package name */
    private final Activity f387a;
    private final com.applovin.impl.sdk.k b;
    private final o c;
    private final b d;
    private final com.applovin.impl.sdk.ad.a e;
    private RelativeLayout f;
    private e g;

    class a implements Animation.AnimationListener {
        a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            f.this.g.setClickable(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    f(com.applovin.impl.sdk.ad.a aVar, b bVar, Activity activity, com.applovin.impl.sdk.k kVar) {
        super(activity, R.style.Theme.Translucent.NoTitleBar);
        if (aVar == null) {
            throw new IllegalArgumentException("No ad specified");
        }
        if (bVar == null) {
            throw new IllegalArgumentException("No main view specified");
        }
        if (kVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        }
        this.b = kVar;
        this.c = kVar.O();
        this.f387a = activity;
        this.d = bVar;
        this.e = aVar;
        requestWindowFeature(1);
        setCancelable(false);
    }

    private void d() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(13);
        this.d.setLayoutParams(layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(this.f387a);
        this.f = relativeLayout;
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f.setBackgroundColor(-1157627904);
        this.f.addView(this.d);
        if (!this.e.x1()) {
            a(this.e.r1());
            g();
        }
        setContentView(this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f.removeView(this.d);
        super.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        try {
            if (this.g == null) {
                a();
            }
            this.g.setVisibility(0);
            this.g.bringToFront();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(300L);
            alphaAnimation.setAnimationListener(new a());
            this.g.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            if (o.a()) {
                this.c.a("ExpandedAdDialog", "Unable to fade in close button", th);
            }
            a();
        }
    }

    private void g() {
        this.f387a.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.f$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                f.this.f();
            }
        });
    }

    public b c() {
        return this.d;
    }

    @Override // com.applovin.impl.m1
    public void dismiss(String str) {
        this.f387a.runOnUiThread(new Runnable() { // from class: com.applovin.impl.adview.f$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                f.this.e();
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        this.d.a("javascript:al_onBackPressed();");
        dismiss("expanded_ad_dialog_back_button");
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        d();
    }

    @Override // android.app.Dialog
    protected void onStart() {
        super.onStart();
        try {
            Window window = getWindow();
            if (window != null) {
                window.setFlags(this.f387a.getWindow().getAttributes().flags, this.f387a.getWindow().getAttributes().flags);
                window.addFlags(16777216);
            } else if (o.a()) {
                this.c.b("ExpandedAdDialog", "Unable to turn on hardware acceleration - window is null");
            }
        } catch (Throwable th) {
            if (o.a()) {
                this.c.a("ExpandedAdDialog", "Setting window flags failed.", th);
            }
        }
    }

    private void a() {
        this.d.a("javascript:al_onCloseTapped();");
        dismiss("expanded_ad_dialog_close_button");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (this.g.isClickable()) {
            this.g.performClick();
        }
    }

    private void a(e.a aVar) {
        if (this.g != null) {
            if (o.a()) {
                this.c.k("ExpandedAdDialog", "Attempting to create duplicate close button");
                return;
            }
            return;
        }
        e a2 = e.a(aVar, this.f387a);
        this.g = a2;
        a2.setVisibility(8);
        this.g.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.f$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.this.a(view);
            }
        });
        this.g.setClickable(false);
        int a3 = a(((Integer) this.b.a(v4.x1)).intValue());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a3, a3);
        layoutParams.addRule(10);
        com.applovin.impl.sdk.k kVar = this.b;
        v4 v4Var = v4.A1;
        layoutParams.addRule(((Boolean) kVar.a(v4Var)).booleanValue() ? 9 : 11);
        this.g.a(a3);
        int a4 = a(((Integer) this.b.a(v4.z1)).intValue());
        int a5 = a(((Integer) this.b.a(v4.y1)).intValue());
        layoutParams.setMargins(a5, a4, a5, 0);
        this.f.addView(this.g, layoutParams);
        this.g.bringToFront();
        int a6 = a(((Integer) this.b.a(v4.B1)).intValue());
        View view = new View(this.f387a);
        view.setBackgroundColor(0);
        int i = a3 + a6;
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
        layoutParams2.addRule(10);
        layoutParams2.addRule(((Boolean) this.b.a(v4Var)).booleanValue() ? 9 : 11);
        layoutParams2.setMargins(a5 - a(5), a4 - a(5), a5 - a(5), 0);
        view.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.adview.f$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                f.this.b(view2);
            }
        });
        this.f.addView(view, layoutParams2);
        view.bringToFront();
    }

    public com.applovin.impl.sdk.ad.a b() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        a();
    }

    private int a(int i) {
        return AppLovinSdkUtils.dpToPx(this.f387a, i);
    }
}
