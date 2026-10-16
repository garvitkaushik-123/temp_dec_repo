package com.applovin.mediation.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.b8;
import com.applovin.impl.mediation.ads.MaxAdViewImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.s;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxAdViewConfiguration;
import com.applovin.sdk.AppLovinSdk;
import com.vungle.ads.internal.protos.Sdk;

/* loaded from: classes2.dex */
public class MaxAdView extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    private MaxAdViewImpl f826a;
    private View b;
    private int c;

    public MaxAdView(String str) {
        this(str, (MaxAdViewConfiguration) null);
    }

    private void a(String str, MaxAdFormat maxAdFormat, MaxAdViewConfiguration maxAdViewConfiguration, int i, Context context) {
        View view = new View(context.getApplicationContext());
        this.b = view;
        view.setBackgroundColor(0);
        addView(this.b);
        this.b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.c = getVisibility();
        this.f826a = new MaxAdViewImpl(str.trim(), maxAdFormat, maxAdViewConfiguration, this, this.b, context);
        setGravity(i);
        if (getBackground() instanceof ColorDrawable) {
            setBackgroundColor(((ColorDrawable) getBackground()).getColor());
        }
        super.setBackgroundColor(0);
    }

    public void destroy() {
        this.f826a.logApiCall("destroy()");
        this.f826a.destroy();
    }

    public MaxAdFormat getAdFormat() {
        return this.f826a.getAdFormat();
    }

    public String getAdUnitId() {
        return this.f826a.getAdUnitId();
    }

    public String getPlacement() {
        this.f826a.logApiCall("getPlacement()");
        return this.f826a.getPlacement();
    }

    public void loadAd() {
        this.f826a.logApiCall("loadAd()");
        this.f826a.loadAd();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (isInEditMode()) {
            return;
        }
        this.f826a.logApiCall("onWindowVisibilityChanged(visibility=" + i + ")");
        if (this.f826a != null && b8.a(this.c, i)) {
            this.f826a.onWindowVisibilityChanged(i);
        }
        this.c = i;
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f826a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f826a.setAdReviewListener(maxAdReviewListener);
    }

    @Override // android.view.View
    public void setAlpha(float f) {
        this.f826a.logApiCall("setAlpha(alpha=" + f + ")");
        View view = this.b;
        if (view != null) {
            view.setAlpha(f);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.f826a.logApiCall("setBackgroundColor(color=" + i + ")");
        MaxAdViewImpl maxAdViewImpl = this.f826a;
        if (maxAdViewImpl != null) {
            maxAdViewImpl.setPublisherBackgroundColor(i);
        }
        View view = this.b;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setCustomData(String str) {
        this.f826a.logApiCall("setCustomData(value=" + str + ")");
        this.f826a.setCustomData(str);
    }

    public void setExtraParameter(String str, String str2) {
        this.f826a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f826a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdViewAdListener maxAdViewAdListener) {
        this.f826a.logApiCall("setListener(listener=" + maxAdViewAdListener + ")");
        this.f826a.setListener(maxAdViewAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f826a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f826a.setLocalExtraParameter(str, obj);
    }

    public void setPlacement(String str) {
        this.f826a.logApiCall("setPlacement(placement=" + str + ")");
        this.f826a.setPlacement(str);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f826a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f826a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f826a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f826a.setRevenueListener(maxAdRevenueListener);
    }

    public void startAutoRefresh() {
        this.f826a.logApiCall("startAutoRefresh()");
        this.f826a.startAutoRefresh();
    }

    public void stopAutoRefresh() {
        this.f826a.logApiCall("stopAutoRefresh()");
        this.f826a.stopAutoRefresh();
    }

    @Override // android.view.View
    public String toString() {
        MaxAdViewImpl maxAdViewImpl = this.f826a;
        return maxAdViewImpl != null ? maxAdViewImpl.toString() : "MaxAdView";
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat) {
        this(str, maxAdFormat, (MaxAdViewConfiguration) null);
    }

    public MaxAdView(String str, MaxAdViewConfiguration maxAdViewConfiguration) {
        this(str, s.a(k.o()), maxAdViewConfiguration);
    }

    public MaxAdView(String str, MaxAdFormat maxAdFormat, MaxAdViewConfiguration maxAdViewConfiguration) {
        super(k.o());
        a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + str + ", adFormat=" + maxAdFormat + ", configuration=" + maxAdViewConfiguration + ")");
        a(str, maxAdFormat, maxAdViewConfiguration, 49, k.o());
    }

    public MaxAdView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MaxAdFormat a2;
        String a3 = s.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adUnitId");
        String a4 = s.a(context, attributeSet, AppLovinAdView.NAMESPACE, "adFormat");
        if (StringUtils.isValidString(a4)) {
            a2 = MaxAdFormat.formatFromString(a4);
        } else {
            a2 = s.a(context);
        }
        MaxAdFormat maxAdFormat = a2;
        int attributeIntValue = attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 49);
        if (a3 != null) {
            if (!TextUtils.isEmpty(a3)) {
                if (isInEditMode()) {
                    a(context);
                    return;
                } else {
                    a(a3, maxAdFormat, null, attributeIntValue, context);
                    return;
                }
            }
            throw new IllegalArgumentException("Empty ad unit ID specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    private void a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        TextView textView = new TextView(context);
        textView.setBackgroundColor(Color.rgb(Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE, Sdk.SDKError.Reason.AD_RESPONSE_RETRY_AFTER_VALUE));
        textView.setTextColor(-16777216);
        textView.setText("AppLovin MAX Ad");
        textView.setGravity(17);
        addView(textView, i, i2);
    }

    @Deprecated
    public MaxAdView(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    @Deprecated
    public MaxAdView(String str, AppLovinSdk appLovinSdk, Context context) {
        this(str, s.a(context), context);
    }

    @Deprecated
    public MaxAdView(String str, MaxAdFormat maxAdFormat, Context context) {
        this(str, maxAdFormat, AppLovinSdk.getInstance(context), context);
    }

    @Deprecated
    public MaxAdView(String str, MaxAdFormat maxAdFormat, AppLovinSdk appLovinSdk, Context context) {
        super(context);
        a.logApiCall("MaxAdView", "MaxAdView(adUnitId=" + str + ", adFormat=" + maxAdFormat + ")");
        a(str, maxAdFormat, null, 49, context);
    }
}
