package com.ironsource.mediationsdk;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.vungle.ads.internal.protos.Sdk;

/* loaded from: classes6.dex */
public class ISBannerSize {

    /* renamed from: a, reason: collision with root package name */
    private final int f3482a;
    private final int b;
    private final String c;
    public ISContainerParams containerParams;
    private boolean d;
    public static final ISBannerSize BANNER = l.a("BANNER", Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
    public static final ISBannerSize LARGE = l.a("LARGE", Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 90);
    public static final ISBannerSize RECTANGLE = l.a("RECTANGLE", 300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
    protected static final ISBannerSize e = l.a();
    public static final ISBannerSize SMART = l.a("SMART", 0, 0);

    public ISBannerSize(int i, int i2) {
        this("CUSTOM", i, i2);
    }

    public static int getMaximalAdaptiveHeight(int i) {
        return l.b(i);
    }

    public String getDescription() {
        return this.c;
    }

    public int getHeight() {
        return this.b;
    }

    public int getWidth() {
        return this.f3482a;
    }

    public boolean isAdaptive() {
        return this.d;
    }

    public boolean isSmart() {
        return this.c.equals("SMART");
    }

    public void setAdaptive(boolean z) {
        this.d = z;
    }

    public void setContainerParams(ISContainerParams iSContainerParams) {
        if (l.a(iSContainerParams, this.f3482a, this.b)) {
            this.containerParams = iSContainerParams;
        }
    }

    public ISBannerSize(String str, int i, int i2) {
        this.c = str;
        this.f3482a = i;
        this.b = i2;
        this.containerParams = new ISContainerParams(i, i2);
    }
}
