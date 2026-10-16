package com.ironsource.mediationsdk;

import android.app.Activity;
import android.text.TextUtils;
import com.ironsource.A3;
import com.ironsource.V9;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.lang.ref.WeakReference;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public abstract class a<Listener extends AdapterAdListener> extends BaseAdAdapter<u, Listener> implements AdapterAdFullScreenInterface<Listener>, AdapterBannerInterface<Listener>, AdapterNativeAdInterface<Listener>, AdapterBindAdViewInterface, A3 {

    /* renamed from: a, reason: collision with root package name */
    protected AbstractAdapter f3490a;
    protected WeakReference<Listener> b;

    public a(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        super(ad_unit, networkSettings, uuid);
        this.b = new WeakReference<>(null);
        this.f3490a = abstractAdapter;
    }

    public static a<?> a(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit, UUID uuid) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return new z(abstractAdapter, networkSettings, uuid);
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return new o(abstractAdapter, networkSettings, uuid);
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return new j(abstractAdapter, networkSettings, uuid);
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return new t(abstractAdapter, networkSettings, uuid);
        }
        IronLog.INTERNAL.error("ad unit not supported - " + ad_unit);
        return null;
    }

    protected abstract void a(JSONObject jSONObject, JSONObject jSONObject2, AdData adData);

    protected abstract IronSource.AD_UNIT b();

    protected void b(JSONObject jSONObject) {
        b("disposeAd");
    }

    protected boolean c(JSONObject jSONObject) {
        b("isAdAvailable");
        return false;
    }

    @Override // com.ironsource.A3
    public void collectBiddingData(AdData adData, BiddingDataCallback biddingDataCallback) {
        a(V9.a(adData.getConfiguration()), V9.a(adData.getAdUnitData()), biddingDataCallback);
    }

    public void d(JSONObject jSONObject) {
        b("onAdViewWillBind");
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface
    public void destroyAd(AdData adData) {
        a(V9.a(adData.getConfiguration()));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface
    public void disposeAd(AdData adData) {
        b(V9.a(adData.getConfiguration()));
    }

    public void e(JSONObject jSONObject) {
        b("onAdViewWillBind");
    }

    protected void f(JSONObject jSONObject) {
        b("showAd");
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface
    public boolean isAdAvailable(AdData adData) {
        return c(V9.a(adData.getConfiguration()));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface, com.ironsource.mediationsdk.adunit.adapter.internal.AdapterNativeAdInterface
    public void loadAd(AdData adData, Activity activity, Listener listener) {
        a(adData, listener);
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface
    public void onAdViewBound(AdData adData) {
        d(V9.a(adData.getConfiguration()));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBindAdViewInterface
    public void onAdViewWillBind(AdData adData) {
        e(V9.a(adData.getConfiguration()));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter
    public void releaseMemory() {
        IronLog.INTERNAL.verbose(a());
        AbstractAdapter abstractAdapter = this.f3490a;
        if (abstractAdapter != null) {
            abstractAdapter.releaseMemory(b(), new JSONObject());
            this.f3490a = null;
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface
    public void showAd(AdData adData, Listener listener) {
        this.b = new WeakReference<>(listener);
        f(V9.a(adData.getConfiguration()));
    }

    private void b(String str) {
        IronLog.INTERNAL.error(a("Method '" + str + "' is not supported for " + getClass().getName()));
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBannerInterface
    public void loadAd(AdData adData, Activity activity, ISBannerSize iSBannerSize, Listener listener) {
        a(adData, listener);
    }

    protected void a(JSONObject jSONObject) {
        b("destroyAd");
    }

    protected void a(JSONObject jSONObject, JSONObject jSONObject2, BiddingDataCallback biddingDataCallback) {
        b("collectBiddingData");
    }

    protected String a(String str) {
        String ad_unit = b().toString();
        return TextUtils.isEmpty(str) ? ad_unit : ad_unit + " - " + str;
    }

    protected String a() {
        return a((String) null);
    }

    private void a(AdData adData, Listener listener) {
        this.b = new WeakReference<>(listener);
        a(V9.a(adData.getConfiguration()), V9.a(adData.getAdUnitData()), adData);
    }
}
