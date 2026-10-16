package com.fyber.marketplace.fairbid.impl;

import android.text.TextUtils;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadError;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAdLoadListener;
import com.fyber.marketplace.fairbid.bridge.MarketplaceAuctionParameters;
import com.fyber.marketplace.fairbid.bridge.MarketplaceBridgeAd;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public abstract class e {
    k adSpot;
    MarketplaceAuctionParameters mMarketplaceAuctionParameters;
    private h mMarketplaceAuctionResponse;
    private boolean mMuted;
    protected String mPlacementId;
    protected com.fyber.inneractive.sdk.dv.j mWrapperQueryInfo;

    public e(String str, JSONObject jSONObject, Map map, boolean z, MarketplaceAuctionParameters marketplaceAuctionParameters) {
        Map<String, String> lowerCaseHeaders = lowerCaseHeaders(map);
        com.fyber.inneractive.sdk.response.a responseAdType = getResponseAdType(lowerCaseHeaders);
        this.mMarketplaceAuctionParameters = marketplaceAuctionParameters;
        this.mPlacementId = str;
        if (responseAdType != null) {
            this.mMarketplaceAuctionResponse = new h(jSONObject, responseAdType, lowerCaseHeaders);
        }
        this.mMuted = z;
    }

    public static void access$000(e eVar, InneractiveUnitController inneractiveUnitController, MarketplaceAdLoadListener marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.e eVar2, com.fyber.inneractive.sdk.interfaces.c cVar) {
        eVar.getClass();
        if (eVar2 == null || cVar == null) {
            return;
        }
        r.b.post(new c(eVar, inneractiveUnitController, marketplaceAdLoadListener, eVar2, cVar));
    }

    public com.fyber.inneractive.sdk.interfaces.c getAdContentLoader(MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.a aVar) {
        com.fyber.inneractive.sdk.factories.e eVar = (com.fyber.inneractive.sdk.factories.e) com.fyber.inneractive.sdk.factories.d.f1171a.f1172a.get(aVar);
        com.fyber.inneractive.sdk.interfaces.c a2 = eVar != null ? eVar.a() : null;
        if (a2 != null) {
            return a2;
        }
        notifyFailToListener(MarketplaceAdLoadError.UNSUPPORTED_AD_TYPE, marketplaceAdLoadListener);
        return null;
    }

    public com.fyber.inneractive.sdk.response.a getResponseAdType(Map<String, String> map) {
        String str = map.get(com.fyber.inneractive.sdk.network.n.RETURNED_AD_TYPE.a().toLowerCase(Locale.ENGLISH));
        if (str == null) {
            return null;
        }
        try {
            return com.fyber.inneractive.sdk.response.a.a(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public abstract void internalOnAdLoaded(e eVar, k kVar);

    public abstract boolean isFullscreen();

    public boolean isMuted() {
        return this.mMuted;
    }

    public void loadAd(InneractiveUnitController<?> inneractiveUnitController, MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener) {
        h hVar = this.mMarketplaceAuctionResponse;
        if (hVar == null) {
            notifyFailToListener(MarketplaceAdLoadError.FAILED_TO_PARSE_AD_CONTENT, marketplaceAdLoadListener);
            return;
        }
        com.fyber.inneractive.sdk.response.a aVar = hVar.b;
        String str = hVar.f1839a;
        Map map = hVar.c;
        if (aVar == null || str == null || map.isEmpty()) {
            notifyFailToListener(MarketplaceAdLoadError.FAILED_TO_PARSE_AD_CONTENT, marketplaceAdLoadListener);
        } else {
            r.f1777a.execute(new a(this, marketplaceAdLoadListener, aVar, str, map, inneractiveUnitController));
        }
    }

    public Map<String, String> lowerCaseHeaders(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            for (String str : map.keySet()) {
                hashMap.put(TextUtils.isEmpty(str) ? str : str.toLowerCase(Locale.ENGLISH), map.get(str));
            }
        }
        return hashMap;
    }

    public void notifyFailToListener(MarketplaceAdLoadError marketplaceAdLoadError, MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener) {
        if (isFullscreen()) {
            IAlog.a("Firing Event 801 - AdLoadFailed - errorCode - %s", marketplaceAdLoadError.getErrorMessage());
            w wVar = new w(t.IA_AD_LOAD_FAILED, (InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null);
            JSONObject jSONObject = new JSONObject();
            String obj = marketplaceAdLoadError.toString();
            try {
                jSONObject.put(PglCryptUtils.KEY_MESSAGE, obj);
            } catch (Exception unused) {
                IAlog.f("Got exception adding param to json object: %s, %s", PglCryptUtils.KEY_MESSAGE, obj);
            }
            String errorMessage = marketplaceAdLoadError.getErrorMessage();
            try {
                jSONObject.put("extra_description", errorMessage);
            } catch (Exception unused2) {
                IAlog.f("Got exception adding param to json object: %s, %s", "extra_description", errorMessage);
            }
            wVar.f.put(jSONObject);
            wVar.a((String) null);
        }
        marketplaceAdLoadListener.onAdLoadFailed(marketplaceAdLoadError);
    }

    public com.fyber.inneractive.sdk.response.e parseResponseData(MarketplaceAdLoadListener<? extends MarketplaceBridgeAd> marketplaceAdLoadListener, com.fyber.inneractive.sdk.response.a aVar, String str, Map<String, String> map) {
        com.fyber.inneractive.sdk.factories.e eVar = (com.fyber.inneractive.sdk.factories.e) com.fyber.inneractive.sdk.factories.d.f1171a.f1172a.get(aVar);
        com.fyber.inneractive.sdk.response.b b = eVar != null ? eVar.b() : null;
        IAlog.a("IA Exchange response handler: final headers: %s", map);
        if (b != null) {
            d dVar = new d(map, str);
            b.f1726a = b.a();
            b.c = new com.fyber.inneractive.sdk.response.k(dVar);
        }
        try {
            com.fyber.inneractive.sdk.response.e a2 = b.a(str);
            com.fyber.inneractive.sdk.dv.j jVar = this.mWrapperQueryInfo;
            if (jVar != null) {
                a2.u = jVar;
            }
            InneractiveErrorCode b2 = a2.b();
            if (b2 == null) {
                return a2;
            }
            notifyFailToListener(MarketplaceAdLoadError.RESPONSE_VALIDATION_FAILED, marketplaceAdLoadListener);
            IAlog.a("failed parsing response data with error: %s", b2.toString());
            return null;
        } catch (Exception e) {
            notifyFailToListener(MarketplaceAdLoadError.FAILED_TO_PARSE_AD_CONTENT, marketplaceAdLoadListener);
            if (e.getMessage() != null) {
                IAlog.a("failed parsing response data with error: %s", e.getMessage());
            }
            return null;
        }
    }

    public void setQueryInfo(com.fyber.inneractive.sdk.dv.j jVar) {
        this.mWrapperQueryInfo = jVar;
    }
}
