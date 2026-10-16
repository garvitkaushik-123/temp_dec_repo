package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import com.ironsource.C3325u2;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;

@Deprecated
/* loaded from: classes6.dex */
public class IronSourceBannerLayout extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    private ISBannerSize f3485a;
    private String b;
    private Activity c;
    private boolean d;
    private a e;

    public interface a {
        void onWindowFocusChanged(boolean z);
    }

    @Deprecated
    public IronSourceBannerLayout(Activity activity, ISBannerSize iSBannerSize) {
        super(activity);
        this.d = false;
        this.c = activity;
        this.f3485a = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
    }

    protected void a() {
        this.d = true;
        this.c = null;
        this.f3485a = null;
        this.b = null;
        this.e = null;
        removeBannerListener();
    }

    protected IronSourceBannerLayout b() {
        IronSourceBannerLayout ironSourceBannerLayout = new IronSourceBannerLayout(getContext(), this.f3485a);
        ironSourceBannerLayout.setPlacementName(this.b);
        return ironSourceBannerLayout;
    }

    @Deprecated
    public Activity getActivity() {
        return this.c;
    }

    public LevelPlayBannerListener getLevelPlayBannerListener() {
        return C3325u2.a().b();
    }

    public String getPlacementName() {
        return this.b;
    }

    public ISBannerSize getSize() {
        return this.f3485a;
    }

    public a getWindowFocusChangedListener() {
        return this.e;
    }

    public boolean isDestroyed() {
        return this.d;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        a aVar = this.e;
        if (aVar != null) {
            aVar.onWindowFocusChanged(z);
        }
    }

    public void removeBannerListener() {
        IronLog.API.info();
        C3325u2.a().a((LevelPlayBannerListener) null);
    }

    public void setBannerSize(ISBannerSize iSBannerSize) {
        this.f3485a = iSBannerSize;
    }

    @Deprecated
    public void setLevelPlayBannerListener(LevelPlayBannerListener levelPlayBannerListener) {
        IronLog.API.info();
        C3325u2.a().a(levelPlayBannerListener);
    }

    public void setPlacementName(String str) {
        this.b = str;
    }

    public void setWindowFocusChangedListener(a aVar) {
        this.e = aVar;
    }

    public IronSourceBannerLayout(Context context, ISBannerSize iSBannerSize) {
        super(context);
        this.d = false;
        this.f3485a = iSBannerSize == null ? ISBannerSize.BANNER : iSBannerSize;
    }

    public IronSourceBannerLayout(Context context) {
        super(context);
        this.d = false;
    }
}
