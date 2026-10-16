package com.ironsource.mediationsdk.demandOnly;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ironsource.C3308t2;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.logger.IronLog;

/* loaded from: classes6.dex */
public class ISDemandOnlyBannerLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private View f3506a;
    private ISBannerSize b;
    private String c;
    private Activity d;
    private boolean e;
    private C3308t2 f;

    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ View f3507a;
        final /* synthetic */ FrameLayout.LayoutParams b;

        a(View view, FrameLayout.LayoutParams layoutParams) {
            this.f3507a = view;
            this.b = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            ISDemandOnlyBannerLayout.this.removeAllViews();
            ViewParent parent = this.f3507a.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f3507a);
            }
            ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout = ISDemandOnlyBannerLayout.this;
            View view = this.f3507a;
            iSDemandOnlyBannerLayout.f3506a = view;
            iSDemandOnlyBannerLayout.addView(view, 0, this.b);
        }
    }

    public ISDemandOnlyBannerLayout(Activity activity, ISBannerSize iSBannerSize) {
        super(activity);
        this.e = false;
        this.d = activity;
        this.b = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
        this.f = new C3308t2();
    }

    protected void a() {
        this.e = true;
        this.d = null;
        this.b = null;
        this.c = null;
        this.f3506a = null;
        removeBannerListener();
    }

    public Activity getActivity() {
        return this.d;
    }

    public ISDemandOnlyBannerListener getBannerDemandOnlyListener() {
        return this.f.a();
    }

    public View getBannerView() {
        return this.f3506a;
    }

    public C3308t2 getListener() {
        return this.f;
    }

    public String getPlacementName() {
        return this.c;
    }

    public ISBannerSize getSize() {
        return this.b;
    }

    public boolean isDestroyed() {
        return this.e;
    }

    public void removeBannerListener() {
        IronLog.API.info();
        this.f.b((C3308t2) null);
    }

    public void setBannerDemandOnlyListener(ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
        IronLog.API.info();
        this.f.b((C3308t2) iSDemandOnlyBannerListener);
    }

    public void setPlacementName(String str) {
        this.c = str;
    }

    void a(View view, FrameLayout.LayoutParams layoutParams) {
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(view, layoutParams));
    }

    private ISDemandOnlyBannerLayout(Context context) {
        super(context);
        this.e = false;
    }
}
