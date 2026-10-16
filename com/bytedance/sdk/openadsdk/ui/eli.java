package com.bytedance.sdk.openadsdk.ui;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.wC.wC;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.factory.IADLoader;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenRequest;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.bytedance.sdk.openadsdk.component.kb;
import com.bytedance.sdk.openadsdk.component.reward.NU;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.eli.DbA.ui;
import com.bytedance.sdk.openadsdk.eli.ui.DbA;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dZ;

/* loaded from: classes3.dex */
public class eli implements IADTypeLoaderFactory {
    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGAppOpenRequest, PAGAppOpenAdLoadListener> createOpenAdLoader() {
        return new IADLoader<PAGAppOpenRequest, PAGAppOpenAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ui.eli.1
            private int DbA;

            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGAppOpenRequest pAGAppOpenRequest, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.eli.eli.eli(str, pAGAppOpenRequest, pAGAppOpenAdLoadListener)) {
                    return;
                }
                AdSlot.Builder builder = new AdSlot.Builder();
                com.bytedance.sdk.openadsdk.eli.eli.eli(builder, pAGAppOpenRequest);
                if (!TextUtils.isEmpty(pAGAppOpenRequest.getAdString())) {
                    builder.withBid(pAGAppOpenRequest.getAdString());
                }
                final AdSlot build = builder.setCodeId(str).setRequestExtraMap(pAGAppOpenRequest.getExtraInfo()).build();
                if (pAGAppOpenRequest != null) {
                    this.DbA = pAGAppOpenRequest.getTimeout();
                }
                final com.bytedance.sdk.openadsdk.eli.aGH.eli eliVar = new com.bytedance.sdk.openadsdk.eli.aGH.eli(pAGAppOpenAdLoadListener);
                com.bytedance.sdk.openadsdk.eli.eli.eli(new wC("loadSplashAd") { // from class: com.bytedance.sdk.openadsdk.ui.eli.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            if (!dV.aGH().nn() && dZ.Ue()) {
                                eliVar.onError(-18, "Blind mode does not allow requesting ads");
                                return;
                            }
                            if (com.bytedance.sdk.openadsdk.eli.eli.eli(eliVar)) {
                                return;
                            }
                            AdSlot adSlot = build;
                            if (adSlot == null) {
                                eliVar.onError(-4, "adslot is null");
                            } else {
                                adSlot.setDurationSlotType(3);
                                kb.eli(dV.eli()).eli(build, eliVar, AnonymousClass1.this.DbA);
                            }
                        } catch (Throwable th) {
                            Xb.eli("ADNFactory", "open component maybe not exist, please check", th);
                        }
                    }
                }, eliVar, build);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGBannerRequest, PAGBannerAdLoadListener> createBannerAdLoader() {
        return new IADLoader<PAGBannerRequest, PAGBannerAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ui.eli.2
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, final PAGBannerRequest pAGBannerRequest, PAGBannerAdLoadListener pAGBannerAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.eli.eli.eli(str, pAGBannerRequest, pAGBannerAdLoadListener)) {
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
                com.bytedance.sdk.openadsdk.eli.eli.eli(codeId, pAGBannerRequest);
                if (!TextUtils.isEmpty(pAGBannerRequest.getAdString())) {
                    codeId.withBid(pAGBannerRequest.getAdString());
                }
                final PAGBannerSize adSize = pAGBannerRequest != null ? pAGBannerRequest.getAdSize() : null;
                if (adSize != null) {
                    if (adSize.getType() == 3) {
                        codeId.setExpressViewAcceptedSize(adSize.getWidth(), adSize.getMaxHeight());
                    } else {
                        codeId.setExpressViewAcceptedSize(adSize.getWidth(), adSize.getHeight());
                    }
                    codeId.setBannerType(adSize.getType());
                }
                final AdSlot build = codeId.setRequestExtraMap(pAGBannerRequest.getExtraInfo()).build();
                final com.bytedance.sdk.openadsdk.eli.eli.eli eliVar = new com.bytedance.sdk.openadsdk.eli.eli.eli(pAGBannerAdLoadListener);
                com.bytedance.sdk.openadsdk.eli.eli.eli(new wC("loadBannerExpressAd") { // from class: com.bytedance.sdk.openadsdk.ui.eli.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dV.aGH().nn() && dZ.Ue()) {
                            eliVar.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.eli.eli.eli(eliVar)) {
                            return;
                        }
                        PAGBannerSize pAGBannerSize = adSize;
                        if (pAGBannerSize != null && ((pAGBannerSize.getType() == 2 || adSize.getType() == 3) && TextUtils.isEmpty(pAGBannerRequest.getAdString()))) {
                            int aGH = SSo.aGH(dV.eli());
                            int kb = SSo.kb(dV.eli());
                            int height = adSize.getType() == 2 ? adSize.getHeight() : adSize.getMaxHeight();
                            if (adSize.getWidth() > aGH || adSize.getWidth() <= 0 || height > kb || height < 0) {
                                eliVar.onError(-19, "The banner size invalid width=" + adSize.getWidth() + ",height=" + height);
                                return;
                            }
                        }
                        AdSlot adSlot = build;
                        if (adSlot == null) {
                            eliVar.onError(-4, "adslot is null");
                        } else {
                            adSlot.setDurationSlotType(1);
                            com.bytedance.sdk.openadsdk.core.wC.kb.eli(dV.eli()).eli(build, 1, eliVar);
                        }
                    }
                }, eliVar, build);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGNativeRequest, PAGNativeAdLoadListener> createNativeAdLoader() {
        return new IADLoader<PAGNativeRequest, PAGNativeAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ui.eli.3
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGNativeRequest pAGNativeRequest, PAGNativeAdLoadListener pAGNativeAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.eli.eli.eli(str, pAGNativeRequest, pAGNativeAdLoadListener)) {
                    return;
                }
                final ui uiVar = new ui(pAGNativeAdLoadListener);
                AdSlot.Builder withBid = new AdSlot.Builder().setCodeId(str).withBid(pAGNativeRequest != null ? pAGNativeRequest.getAdString() : null);
                com.bytedance.sdk.openadsdk.eli.eli.eli(withBid, pAGNativeRequest);
                final AdSlot build = withBid.setRequestExtraMap(pAGNativeRequest.getExtraInfo()).build();
                com.bytedance.sdk.openadsdk.eli.eli.eli(new wC("loadFeedAd") { // from class: com.bytedance.sdk.openadsdk.ui.eli.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dV.aGH().nn() && dZ.Ue()) {
                            uiVar.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.eli.eli.eli(uiVar)) {
                            return;
                        }
                        AdSlot adSlot = build;
                        if (adSlot == null) {
                            uiVar.onError(-4, "adslot is null");
                            return;
                        }
                        try {
                            adSlot.setDurationSlotType(5);
                            com.bytedance.sdk.openadsdk.component.DbA.eli.eli().eli(dV.eli(), build, uiVar);
                        } catch (Throwable unused) {
                        }
                    }
                }, uiVar, build);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGRewardedRequest, PAGRewardedAdLoadListener> createRewardAdLoader() {
        return new IADLoader<PAGRewardedRequest, PAGRewardedAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ui.eli.4
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGRewardedRequest pAGRewardedRequest, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.eli.eli.eli(str, pAGRewardedRequest, pAGRewardedAdLoadListener)) {
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
                if (!TextUtils.isEmpty(pAGRewardedRequest.getAdString())) {
                    codeId.withBid(pAGRewardedRequest.getAdString());
                }
                com.bytedance.sdk.openadsdk.eli.eli.eli(codeId, pAGRewardedRequest);
                final AdSlot build = codeId.setRequestExtraMap(pAGRewardedRequest.getExtraInfo()).build();
                final DbA dbA = new DbA(pAGRewardedAdLoadListener);
                com.bytedance.sdk.openadsdk.eli.eli.eli(new wC("loadRewardVideoAd") { // from class: com.bytedance.sdk.openadsdk.ui.eli.4.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dV.aGH().nn() && dZ.Ue()) {
                            dbA.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.eli.eli.eli(dbA)) {
                            return;
                        }
                        AdSlot adSlot = build;
                        if (adSlot == null) {
                            dbA.onError(-4, "adslot is null");
                            return;
                        }
                        try {
                            adSlot.setDurationSlotType(7);
                            NU.eli(dV.eli()).eli(build, new com.bytedance.sdk.openadsdk.component.reward.kb(dbA));
                        } catch (Throwable unused) {
                        }
                    }
                }, dbA, build);
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory
    public IADLoader<PAGInterstitialRequest, PAGInterstitialAdLoadListener> createInterstitialAdLoader() {
        return new IADLoader<PAGInterstitialRequest, PAGInterstitialAdLoadListener>() { // from class: com.bytedance.sdk.openadsdk.ui.eli.5
            @Override // com.bytedance.sdk.openadsdk.api.factory.IADLoader
            /* renamed from: eli, reason: merged with bridge method [inline-methods] */
            public void loadAd(String str, PAGInterstitialRequest pAGInterstitialRequest, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
                if (com.bytedance.sdk.openadsdk.eli.eli.eli(str, pAGInterstitialRequest, pAGInterstitialAdLoadListener)) {
                    return;
                }
                AdSlot.Builder codeId = new AdSlot.Builder().setRequestExtraMap(pAGInterstitialRequest.getExtraInfo()).setCodeId(str);
                com.bytedance.sdk.openadsdk.eli.eli.eli(codeId, pAGInterstitialRequest);
                if (!TextUtils.isEmpty(pAGInterstitialRequest.getAdString())) {
                    codeId.withBid(pAGInterstitialRequest.getAdString());
                }
                final AdSlot build = codeId.build();
                final com.bytedance.sdk.openadsdk.eli.Os.eli eliVar = new com.bytedance.sdk.openadsdk.eli.Os.eli(pAGInterstitialAdLoadListener);
                com.bytedance.sdk.openadsdk.eli.eli.eli(new wC("loadInterstitialAd") { // from class: com.bytedance.sdk.openadsdk.ui.eli.5.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dV.aGH().nn() && dZ.Ue()) {
                            eliVar.onError(-18, "Blind mode does not allow requesting ads");
                            return;
                        }
                        if (com.bytedance.sdk.openadsdk.eli.eli.eli(eliVar)) {
                            return;
                        }
                        AdSlot adSlot = build;
                        if (adSlot == null) {
                            eliVar.onError(-4, "adslot is null");
                            return;
                        }
                        try {
                            adSlot.setDurationSlotType(8);
                            com.bytedance.sdk.openadsdk.component.reward.ui.eli(dV.eli()).eli(build, new com.bytedance.sdk.openadsdk.component.Os.DbA(eliVar));
                        } catch (Throwable unused) {
                        }
                    }
                }, eliVar, build);
            }
        };
    }
}
