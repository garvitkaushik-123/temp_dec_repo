package com.ironsource;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.widget.RelativeLayout;
import com.ironsource.C3102gf;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.wf, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3372wf implements C3102gf.c, C3102gf.d, C3102gf.b {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<TestSuiteActivity> f3928a;
    private final Handler b;
    private RelativeLayout c;
    private IronSourceBannerLayout d;

    public C3372wf(TestSuiteActivity activity, Handler handler) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f3928a = new WeakReference<>(activity);
        this.b = handler;
    }

    private final TestSuiteActivity f() {
        return this.f3928a.get();
    }

    @Override // com.ironsource.C3102gf.d
    public void a(C3203mf loadAdConfig) {
        Intrinsics.checkNotNullParameter(loadAdConfig, "loadAdConfig");
        C3321tf c3321tf = C3321tf.f3849a;
        c3321tf.a(IronSource.AD_UNIT.REWARDED_VIDEO, loadAdConfig);
        c3321tf.h();
    }

    @Override // com.ironsource.C3102gf.c
    public void b(C3203mf loadAdConfig) {
        Intrinsics.checkNotNullParameter(loadAdConfig, "loadAdConfig");
        C3321tf c3321tf = C3321tf.f3849a;
        c3321tf.a(IronSource.AD_UNIT.INTERSTITIAL, loadAdConfig);
        c3321tf.g();
    }

    @Override // com.ironsource.C3102gf.d
    public void c() {
        C3321tf.f3849a.b((Activity) this.f3928a.get());
    }

    @Override // com.ironsource.C3102gf.b
    public void d() {
        IronSourceBannerLayout ironSourceBannerLayout = this.d;
        if (ironSourceBannerLayout != null) {
            C3321tf.f3849a.a(ironSourceBannerLayout);
        }
        this.b.post(new Runnable() { // from class: com.ironsource.wf$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C3372wf.a(C3372wf.this);
            }
        });
        this.d = null;
    }

    @Override // com.ironsource.C3102gf.c
    public boolean e() {
        return C3321tf.f3849a.e();
    }

    @Override // com.ironsource.C3102gf.d
    public boolean a() {
        return C3321tf.f3849a.f();
    }

    @Override // com.ironsource.C3102gf.c
    public void b() {
        C3321tf.f3849a.a((Activity) this.f3928a.get());
    }

    @Override // com.ironsource.C3102gf.b
    public void a(C3203mf loadAdConfig, String description, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadAdConfig, "loadAdConfig");
        Intrinsics.checkNotNullParameter(description, "description");
        d();
        C3321tf c3321tf = C3321tf.f3849a;
        c3321tf.a(IronSource.AD_UNIT.BANNER, loadAdConfig);
        TestSuiteActivity f = f();
        if (f != null) {
            IronSourceBannerLayout a2 = c3321tf.a(f, c3321tf.a(description, i, i2));
            this.d = a2;
            c3321tf.b(a2);
        }
    }

    @Override // com.ironsource.C3102gf.b
    public void a(double d) {
        final TestSuiteActivity f;
        if (this.c != null || (f = f()) == null) {
            return;
        }
        IronSourceBannerLayout ironSourceBannerLayout = this.d;
        if (ironSourceBannerLayout != null) {
            ironSourceBannerLayout.setLayoutParams(C3406yf.f3954a.a((Context) f));
        }
        this.c = a(f);
        this.b.post(new Runnable() { // from class: com.ironsource.wf$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                C3372wf.a(C3372wf.this, f);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3372wf this$0, TestSuiteActivity testSuiteActivity) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RelativeLayout relativeLayout = this$0.c;
        if (relativeLayout != null) {
            relativeLayout.addView(this$0.d);
        }
        testSuiteActivity.getContainer().addView(this$0.c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(C3372wf this$0) {
        RelativeLayout container;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        RelativeLayout relativeLayout = this$0.c;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
        TestSuiteActivity f = this$0.f();
        if (f != null && (container = f.getContainer()) != null) {
            container.removeView(this$0.c);
        }
        this$0.c = null;
    }

    private final RelativeLayout a(TestSuiteActivity testSuiteActivity) {
        RelativeLayout relativeLayout = new RelativeLayout(testSuiteActivity);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        return relativeLayout;
    }
}
