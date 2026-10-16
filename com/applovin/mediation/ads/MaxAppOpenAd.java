package com.applovin.mediation.ads;

import android.content.Context;
import com.applovin.impl.k7;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.k;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;

/* loaded from: classes2.dex */
public class MaxAppOpenAd {

    /* renamed from: a, reason: collision with root package name */
    private final MaxFullscreenAdImpl f827a;

    public MaxAppOpenAd(String str) {
        this(str, k.o());
    }

    public void destroy() {
        this.f827a.logApiCall("destroy()");
        this.f827a.destroy();
    }

    public String getAdUnitId() {
        return this.f827a.getAdUnitId();
    }

    public boolean isReady() {
        boolean isReady = this.f827a.isReady();
        this.f827a.logApiCall("isReady() " + isReady + " for ad unit id " + this.f827a.getAdUnitId());
        return isReady;
    }

    public void loadAd() {
        this.f827a.logApiCall("loadAd()");
        this.f827a.loadAd();
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f827a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f827a.setAdReviewListener(maxAdReviewListener);
    }

    public void setExpirationListener(MaxAdExpirationListener maxAdExpirationListener) {
        this.f827a.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.f827a.setExpirationListener(maxAdExpirationListener);
    }

    public void setExtraParameter(String str, String str2) {
        this.f827a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f827a.setExtraParameter(str, str2);
    }

    public void setListener(MaxAdListener maxAdListener) {
        this.f827a.logApiCall("setListener(listener=" + maxAdListener + ")");
        this.f827a.setListener(maxAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f827a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f827a.setLocalExtraParameter(str, obj);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f827a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f827a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f827a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f827a.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd() {
        showAd(null);
    }

    public String toString() {
        return "" + this.f827a;
    }

    @Deprecated
    public MaxAppOpenAd(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public void showAd(String str) {
        showAd(str, null);
    }

    @Deprecated
    public MaxAppOpenAd(String str, AppLovinSdk appLovinSdk) {
        this(str, appLovinSdk, k.o());
    }

    public void showAd(String str, String str2) {
        this.f827a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        k7.b(str2, "MaxAppOpenAd");
        this.f827a.showAd(str, str2, null);
    }

    private MaxAppOpenAd(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxAppOpenAd", "MaxAppOpenAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ", context=" + context + ")");
        this.f827a = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.APP_OPEN, null, "MaxAppOpenAd", appLovinSdk.a(), context);
    }
}
