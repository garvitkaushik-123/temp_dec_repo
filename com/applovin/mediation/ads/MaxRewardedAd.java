package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.k7;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.MaxRewardedAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.k;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class MaxRewardedAd implements MaxFullscreenAdImpl.a {
    private static final Map b = new HashMap();
    private static final Object c = new Object();
    private static WeakReference d = new WeakReference(null);

    /* renamed from: a, reason: collision with root package name */
    private final MaxRewardedAdImpl f829a;

    private MaxRewardedAd(String str, AppLovinSdk appLovinSdk, Context context) {
        this.f829a = new MaxRewardedAdImpl(str.trim(), MaxAdFormat.REWARDED, this, "MaxRewardedAd", appLovinSdk.a(), context);
    }

    public static MaxRewardedAd getInstance(String str) {
        return getInstance(str, k.o());
    }

    public void destroy() {
        this.f829a.logApiCall("destroy()");
        synchronized (c) {
            b.remove(this.f829a.getAdUnitId());
        }
        this.f829a.destroy();
    }

    @Override // com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.a
    public Activity getActivity() {
        this.f829a.logApiCall("getActivity()");
        return (Activity) d.get();
    }

    public String getAdUnitId() {
        return this.f829a.getAdUnitId();
    }

    public boolean isReady() {
        boolean isReady = this.f829a.isReady();
        this.f829a.logApiCall("isReady() " + isReady + " for ad unit id " + this.f829a.getAdUnitId());
        return isReady;
    }

    public void loadAd() {
        this.f829a.logApiCall("loadAd()");
        this.f829a.loadAd();
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        this.f829a.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.f829a.setAdReviewListener(maxAdReviewListener);
    }

    public void setExpirationListener(MaxAdExpirationListener maxAdExpirationListener) {
        this.f829a.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.f829a.setExpirationListener(maxAdExpirationListener);
    }

    public void setExtraParameter(String str, String str2) {
        this.f829a.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.f829a.setExtraParameter(str, str2);
    }

    public void setListener(MaxRewardedAdListener maxRewardedAdListener) {
        this.f829a.logApiCall("setListener(listener=" + maxRewardedAdListener + ")");
        this.f829a.setListener(maxRewardedAdListener);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        this.f829a.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.f829a.setLocalExtraParameter(str, obj);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        this.f829a.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.f829a.setRequestListener(maxAdRequestListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        this.f829a.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.f829a.setRevenueListener(maxAdRevenueListener);
    }

    public void showAd(Activity activity) {
        showAd((String) null, activity);
    }

    public String toString() {
        return "" + this.f829a;
    }

    @Deprecated
    public static MaxRewardedAd getInstance(String str, Context context) {
        return getInstance(str, AppLovinSdk.getInstance(context), context);
    }

    public void showAd(String str, Activity activity) {
        showAd(str, (String) null, activity);
    }

    @Deprecated
    public static MaxRewardedAd getInstance(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxRewardedAd", "getInstance(adUnitId=" + str + ", sdk=" + appLovinSdk + ", context=" + context + ")");
        if (str != null) {
            if (TextUtils.isEmpty(str)) {
                throw new IllegalArgumentException("Empty ad unit ID specified");
            }
            if (context == null) {
                throw new IllegalArgumentException("No context specified");
            }
            if (appLovinSdk != null) {
                if (context instanceof Activity) {
                    d = new WeakReference((Activity) context);
                }
                synchronized (c) {
                    Map map = b;
                    MaxRewardedAd maxRewardedAd = (MaxRewardedAd) map.get(str);
                    if (maxRewardedAd != null) {
                        return maxRewardedAd;
                    }
                    MaxRewardedAd maxRewardedAd2 = new MaxRewardedAd(str, appLovinSdk, context);
                    map.put(str, maxRewardedAd2);
                    return maxRewardedAd2;
                }
            }
            throw new IllegalArgumentException("No sdk specified");
        }
        throw new IllegalArgumentException("No ad unit ID specified");
    }

    public void showAd(String str, String str2, Activity activity) {
        this.f829a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", activity=" + activity + ")");
        k7.b(str2, "MaxRewardedAd");
        this.f829a.showAd(str, str2, activity);
    }

    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        showAd((String) null, viewGroup, lifecycle, activity);
    }

    public void showAd(String str, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        showAd(str, null, viewGroup, lifecycle, activity);
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        this.f829a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ", activity=" + activity + ")");
        this.f829a.showAd(str, str2, viewGroup, lifecycle, activity);
    }

    @Deprecated
    public void showAd() {
        showAd((String) null);
    }

    @Deprecated
    public void showAd(String str) {
        showAd(str, (String) null);
    }

    @Deprecated
    public void showAd(String str, String str2) {
        this.f829a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        k7.b(str2, "MaxRewardedAd");
        this.f829a.showAd(str, str2, getActivity());
    }

    @Deprecated
    public void showAd(ViewGroup viewGroup, Lifecycle lifecycle) {
        showAd((String) null, viewGroup, lifecycle);
    }

    @Deprecated
    public void showAd(String str, ViewGroup viewGroup, Lifecycle lifecycle) {
        showAd(str, (String) null, viewGroup, lifecycle);
    }

    @Deprecated
    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle) {
        this.f829a.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ", containerView=" + viewGroup + ", lifecycle=" + lifecycle + ")");
        this.f829a.showAd(str, str2, viewGroup, lifecycle, getActivity());
    }
}
