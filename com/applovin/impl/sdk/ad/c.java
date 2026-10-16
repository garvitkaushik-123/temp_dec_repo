package com.applovin.impl.sdk.ad;

import android.os.Bundle;
import com.applovin.impl.c4;
import com.applovin.impl.sdk.k;
import com.applovin.impl.u;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c extends AppLovinAdImpl {
    private AppLovinAd d;
    private final u e;

    public c(u uVar, k kVar) {
        super(new JSONObject(), new JSONObject(), kVar);
        this.e = uVar;
    }

    private AppLovinAd d() {
        return (AppLovinAd) this.sdk.i().f(this.e);
    }

    private String e() {
        u adZone = getAdZone();
        if (adZone == null || adZone.i()) {
            return null;
        }
        return adZone.e();
    }

    public void a(AppLovinAd appLovinAd) {
        this.d = appLovinAd;
    }

    public AppLovinAd c() {
        AppLovinAd appLovinAd = this.d;
        return appLovinAd != null ? appLovinAd : d();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        AppLovinAd c = c();
        return c != null ? c.equals(obj) : super.equals(obj);
    }

    public AppLovinAd f() {
        return this.d;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public c4 getAdEventTracker() {
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.impl.sdk.AppLovinAdBase
    public long getAdIdNumber() {
        AppLovinAd c = c();
        if (c instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) c).getAdIdNumber();
        }
        return 0L;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public u getAdZone() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) c();
        return appLovinAdImpl != null ? appLovinAdImpl.getAdZone() : this.e;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase
    public long getCreatedAtMillis() {
        AppLovinAd c = c();
        if (c instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) c).getCreatedAtMillis();
        }
        return 0L;
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public Bundle getDirectDownloadParameters() {
        return new Bundle();
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public String getDirectDownloadToken() {
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public String getMediationServeId() {
        AppLovinAd c = c();
        if (c instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) c).getMediationServeId();
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public String getOpenMeasurementContentUrl() {
        return null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public String getOpenMeasurementCustomReferenceData() {
        return null;
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public List getOpenMeasurementVerificationScriptResources() {
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public JSONObject getOriginalFullResponse() {
        AppLovinAd c = c();
        if (c instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) c).getOriginalFullResponse();
        }
        return null;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public AppLovinAdSize getSize() {
        return getAdZone().f();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public AppLovinAdType getType() {
        return getAdZone().g();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl, com.applovin.sdk.AppLovinAd
    public String getZoneId() {
        if (this.e.i()) {
            return null;
        }
        return this.e.e();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public int hashCode() {
        AppLovinAd c = c();
        return c != null ? c.hashCode() : super.hashCode();
    }

    @Override // com.applovin.impl.sdk.array.ArrayDirectDownloadAd
    public boolean isDirectDownloadEnabled() {
        return false;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean isExpired() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) c();
        return appLovinAdImpl != null && appLovinAdImpl.isExpired();
    }

    @Override // com.applovin.impl.sdk.AppLovinAdBase, com.applovin.impl.b4
    public boolean isOpenMeasurementEnabled() {
        return false;
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public boolean isVideoAd() {
        AppLovinAd c = c();
        return (c instanceof AppLovinAdImpl) && ((AppLovinAdImpl) c).isVideoAd();
    }

    @Override // com.applovin.impl.sdk.ad.AppLovinAdImpl
    public String toString() {
        return "AppLovinAd{ #" + getAdIdNumber() + ", adType=" + getType() + ", adSize=" + getSize() + ", zoneId='" + e() + "'}";
    }
}
