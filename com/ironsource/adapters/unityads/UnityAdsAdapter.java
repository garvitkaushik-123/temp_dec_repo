package com.ironsource.adapters.unityads;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.ironsource.N6;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.ads.AdFormat;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.ads.metadata.PlayerMetaData;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.http.ContentDisposition;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: UnityAdsAdapter.kt */
@Metadata(d1 = {"\u0000Ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010 \n\u0002\b\u0007\u0018\u0000 u2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001uB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\"\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J$\u0010$\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J$\u0010%\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0012\u0010*\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010+\u001a\u0004\u0018\u00010)2\u0006\u0010(\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0011H\u0002J\"\u0010.\u001a\u00020\r2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u000103H\u0002J\b\u00104\u001a\u00020\u0005H\u0016J\u0010\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u001dH\u0016J\u0012\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;H\u0002J\u000e\u0010<\u001a\u0002092\u0006\u0010:\u001a\u00020=J\u000e\u0010>\u001a\u0002092\u0006\u0010:\u001a\u00020?J\b\u0010@\u001a\u00020\u0005H\u0016J:\u0010A\u001a\u00020\u001b2\b\u0010B\u001a\u0004\u0018\u00010\u00052\b\u0010C\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u00010DH\u0016J0\u0010E\u001a\u00020\u001b2\b\u0010B\u001a\u0004\u0018\u00010\u00052\b\u0010C\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u000103H\u0016J0\u0010F\u001a\u00020\u001b2\b\u0010B\u001a\u0004\u0018\u00010\u00052\b\u0010C\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u001c\u0010G\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u000103H\u0002J0\u0010H\u001a\u00020\u001b2\b\u0010B\u001a\u0004\u0018\u00010\u00052\b\u0010C\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u00010IH\u0016J0\u0010J\u001a\u00020\u001b2\b\u0010B\u001a\u0004\u0018\u00010\u00052\b\u0010C\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u00010IH\u0016J\u001c\u0010K\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u00010IH\u0002J0\u0010L\u001a\u00020\u001b2\b\u0010B\u001a\u0004\u0018\u00010\u00052\b\u0010C\u001a\u0004\u0018\u00010\u00052\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u00010DH\u0016J\u0010\u0010M\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010N\u001a\u00020\u00112\u0006\u0010(\u001a\u00020,H\u0002J\u0012\u0010O\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010P\u001a\u00020\u00112\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010Q\u001a\u00020\u00112\u0006\u0010R\u001a\u00020SH\u0016J0\u0010T\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u000103H\u0016J:\u0010U\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010V\u001a\u0004\u0018\u00010\u00052\b\u0010/\u001a\u0004\u0018\u0001002\b\u00102\u001a\u0004\u0018\u000103H\u0016J0\u0010W\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010V\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u000103H\u0002J&\u0010X\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u00010IH\u0016J0\u0010Y\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010V\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010IH\u0016J&\u0010Z\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010V\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010IH\u0002J&\u0010[\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u00010DH\u0016J0\u0010\\\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010V\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010DH\u0016J&\u0010]\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010V\u001a\u0004\u0018\u00010\u00052\b\u00102\u001a\u0004\u0018\u00010DH\u0002J\b\u0010^\u001a\u00020\u001bH\u0016J\u001c\u0010_\u001a\u00020\u001b2\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010`\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010a\u001a\u00020\u001b2\u0006\u0010:\u001a\u00020\u0005H\u0016J\b\u0010b\u001a\u00020\u001bH\u0016J\u001a\u0010c\u001a\u00020\u001b2\u0006\u0010R\u001a\u00020S2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010d\u001a\u00020\u001b2\u0006\u0010e\u001a\u00020\u0011H\u0002J\u0010\u0010f\u001a\u00020\u001b2\u0006\u0010e\u001a\u00020\u0011H\u0002J\u0010\u0010g\u001a\u00020\u001b2\u0006\u0010h\u001a\u00020\u0011H\u0014J\u001d\u0010i\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00052\u0006\u0010j\u001a\u00020\u0011H\u0000¢\u0006\u0002\bkJ\u001e\u0010l\u001a\u00020\u001b2\u0006\u0010m\u001a\u00020\u00052\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00050oH\u0014J\u001d\u0010p\u001a\u00020\u001b2\u0006\u00101\u001a\u00020\u00052\u0006\u0010j\u001a\u00020\u0011H\u0000¢\u0006\u0002\bqJ\u0018\u0010r\u001a\u00020\u001b2\u0006\u0010m\u001a\u00020\u00052\u0006\u0010e\u001a\u00020\u0011H\u0002J\u001c\u0010s\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u00010IH\u0016J\u001c\u0010t\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u00102\u001a\u0004\u0018\u00010DH\u0016R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00030\bj\b\u0012\u0004\u0012\u00020\u0003`\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00110\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00160\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006v"}, d2 = {"Lcom/ironsource/adapters/unityads/UnityAdsAdapter;", "Lcom/ironsource/mediationsdk/AbstractAdapter;", "Lcom/unity3d/ads/IUnityAdsInitializationListener;", "Lcom/ironsource/mediationsdk/INetworkInitCallbackListener;", "providerName", "", "(Ljava/lang/String;)V", "initCallbackListeners", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "interstitialPlacementIdToLoadedAdObjectId", "Ljava/util/concurrent/ConcurrentHashMap;", "placementIdToBannerAd", "Lcom/unity3d/services/banners/BannerView;", "placementIdToBannerAdListener", "Lcom/ironsource/adapters/unityads/UnityAdsBannerAdListener;", "placementIdToInterstitialAdAvailability", "", "placementIdToInterstitialAdListener", "Lcom/ironsource/adapters/unityads/UnityAdsInterstitialAdListener;", "placementIdToRewardedVideoAdAvailability", "placementIdToRewardedVideoAdListener", "Lcom/ironsource/adapters/unityads/UnityAdsRewardedVideoAdListener;", "rewardedVideoPlacementIdToLoadedAdObjectId", "unityAdsStorageLock", "", "collectBannerBiddingData", "", "config", "Lorg/json/JSONObject;", "adData", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "collectBiddingData", "adFormat", "Lcom/unity3d/ads/AdFormat;", "collectInterstitialBiddingData", "collectRewardedVideoBiddingData", "createLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", ContentDisposition.Parameters.Size, "Lcom/unity3d/services/banners/UnityBannerSize;", C3040d4.g.S, "getBannerSize", "Lcom/ironsource/mediationsdk/ISBannerSize;", "isLargeScreen", "getBannerView", "banner", "Lcom/ironsource/mediationsdk/IronSourceBannerLayout;", "placementId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "getCoreSDKVersion", "getLoadWhileShowSupportState", "Lcom/ironsource/mediationsdk/LoadWhileShowSupportState;", "mAdUnitSettings", "getUnityAdsInitializationErrorCode", "", "error", "Lcom/unity3d/ads/UnityAds$UnityAdsInitializationError;", "getUnityAdsLoadErrorCode", "Lcom/unity3d/ads/UnityAds$UnityAdsLoadError;", "getUnityAdsShowErrorCode", "Lcom/unity3d/ads/UnityAds$UnityAdsShowError;", "getVersion", "initAndLoadRewardedVideo", "appKey", "userId", "Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;", "initBannerForBidding", "initBanners", "initBannersInternal", C3040d4.g.B, "Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;", "initInterstitialForBidding", "initInterstitialInternal", "initRewardedVideoWithCallback", "initSDK", "isBannerSizeSupported", "isInterstitialReady", "isRewardedVideoAvailable", "isUsingActivityBeforeImpression", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", C3040d4.g.N, "loadBannerForBidding", C3207n2.s, "loadBannerInternal", C3040d4.g.E, "loadInterstitialForBidding", "loadInterstitialInternal", "loadRewardedVideo", "loadRewardedVideoForBidding", "loadRewardedVideoInternal", "onInitializationComplete", "onInitializationFailed", PglCryptUtils.KEY_MESSAGE, "onNetworkInitCallbackFailed", "onNetworkInitCallbackSuccess", "releaseMemory", "setCCPAValue", "value", "setCOPPAValue", "setConsent", C3040d4.i.b0, "setInterstitialAdAvailability", "isAvailable", "setInterstitialAdAvailability$unityadsadapter_release", "setMetaData", C3040d4.h.W, "values", "", "setRewardedVideoAdAvailability", "setRewardedVideoAdAvailability$unityadsadapter_release", "setUnityAdsMetaData", C3040d4.g.H, C3040d4.g.i, "Companion", "unityadsadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class UnityAdsAdapter extends AbstractAdapter implements IUnityAdsInitializationListener, INetworkInitCallbackListener {
    private static final String ADAPTER_VERSION_KEY = "adapter_version";
    private static final String CONSENT_CCPA = "privacy.consent";
    private static final String CONSENT_GDPR = "gdpr.consent";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String GAME_DESIGNATION = "mode";
    private static final String GAME_ID = "sourceId";
    private static final String GitHash = "5760627";
    private static final String LWS_SUPPORT_STATE = "isSupportedLWS";
    private static final String MEDIATION_NAME = "ironSource";
    private static final String MIXED_AUDIENCE = "mixed";
    private static final String PLACEMENT_ID = "zoneId";
    private static final String UADS_INIT_BLOB = "uads_init_blob";
    private static final String UADS_TRAITS = "traits";
    private static final String UNITYADS_COPPA = "user.nonBehavioral";
    private static final String UNITYADS_METADATA_COPPA_KEY = "unityads_coppa";
    private static final String VERSION = "4.3.59";
    private final HashSet<INetworkInitCallbackListener> initCallbackListeners;
    private final ConcurrentHashMap<String, String> interstitialPlacementIdToLoadedAdObjectId;
    private final ConcurrentHashMap<String, BannerView> placementIdToBannerAd;
    private final ConcurrentHashMap<String, UnityAdsBannerAdListener> placementIdToBannerAdListener;
    private final ConcurrentHashMap<String, Boolean> placementIdToInterstitialAdAvailability;
    private final ConcurrentHashMap<String, UnityAdsInterstitialAdListener> placementIdToInterstitialAdListener;
    private final ConcurrentHashMap<String, Boolean> placementIdToRewardedVideoAdAvailability;
    private final ConcurrentHashMap<String, UnityAdsRewardedVideoAdListener> placementIdToRewardedVideoAdListener;
    private final ConcurrentHashMap<String, String> rewardedVideoPlacementIdToLoadedAdObjectId;
    private final Object unityAdsStorageLock;

    /* compiled from: UnityAdsAdapter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IronSource.AD_UNIT.values().length];
            try {
                iArr[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final String getAdapterSDKVersion() {
        return INSTANCE.getAdapterSDKVersion();
    }

    @JvmStatic
    public static final IntegrationData getIntegrationData(Context context) {
        return INSTANCE.getIntegrationData(context);
    }

    @JvmStatic
    public static final UnityAdsAdapter startAdapter(String str) {
        return INSTANCE.startAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UnityAdsAdapter(String providerName) {
        super(providerName);
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        this.placementIdToRewardedVideoAdListener = new ConcurrentHashMap<>();
        this.rewardedVideoPlacementIdToLoadedAdObjectId = new ConcurrentHashMap<>();
        this.placementIdToRewardedVideoAdAvailability = new ConcurrentHashMap<>();
        this.placementIdToInterstitialAdListener = new ConcurrentHashMap<>();
        this.interstitialPlacementIdToLoadedAdObjectId = new ConcurrentHashMap<>();
        this.placementIdToInterstitialAdAvailability = new ConcurrentHashMap<>();
        this.placementIdToBannerAdListener = new ConcurrentHashMap<>();
        this.placementIdToBannerAd = new ConcurrentHashMap<>();
        this.initCallbackListeners = new HashSet<>();
        this.unityAdsStorageLock = new Object();
    }

    /* compiled from: UnityAdsAdapter.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/ironsource/adapters/unityads/UnityAdsAdapter$Companion;", "", "()V", "ADAPTER_VERSION_KEY", "", "CONSENT_CCPA", "CONSENT_GDPR", "GAME_DESIGNATION", "GAME_ID", "GitHash", "LWS_SUPPORT_STATE", "MEDIATION_NAME", "MIXED_AUDIENCE", "PLACEMENT_ID", "UADS_INIT_BLOB", "UADS_TRAITS", "UNITYADS_COPPA", "UNITYADS_METADATA_COPPA_KEY", "VERSION", "getAdapterSDKVersion", "getIntegrationData", "Lcom/ironsource/mediationsdk/IntegrationData;", "context", "Landroid/content/Context;", IronSourceConstants.START_ADAPTER, "Lcom/ironsource/adapters/unityads/UnityAdsAdapter;", "providerName", "unityadsadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UnityAdsAdapter startAdapter(String providerName) {
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            return new UnityAdsAdapter(providerName);
        }

        @JvmStatic
        public final IntegrationData getIntegrationData(Context context) {
            return new IntegrationData(N6.G1, "4.3.59");
        }

        @JvmStatic
        public final String getAdapterSDKVersion() {
            return UnityAds.getVersion();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "4.3.59";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return INSTANCE.getAdapterSDKVersion();
    }

    private final void initSDK(JSONObject config) {
        String optString = config.optString(GAME_ID);
        IronLog.ADAPTER_API.verbose("gameId = " + optString);
        if (!UnityAds.isInitialized()) {
            this.initCallbackListeners.add(this);
        }
        synchronized (this.unityAdsStorageLock) {
            MediationMetaData mediationMetaData = new MediationMetaData(ContextProvider.getInstance().getApplicationContext());
            mediationMetaData.setName(MEDIATION_NAME);
            mediationMetaData.setVersion(LevelPlay.getSdkVersion());
            mediationMetaData.set(ADAPTER_VERSION_KEY, "4.3.59");
            if (config.has(UADS_INIT_BLOB)) {
                mediationMetaData.set(UADS_INIT_BLOB, config.optString(UADS_INIT_BLOB));
            }
            if (config.has("traits")) {
                mediationMetaData.set("traits", config.optJSONObject("traits"));
            }
            mediationMetaData.commit();
            Unit unit = Unit.INSTANCE;
        }
        UnityAds.setDebugMode(isAdaptersDebugEnabled());
        UnityAds.initialize(ContextProvider.getInstance().getApplicationContext(), optString, false, this);
    }

    @Override // com.unity3d.ads.IUnityAdsInitializationListener
    public void onInitializationComplete() {
        IronLog.ADAPTER_CALLBACK.verbose();
        Iterator<T> it = this.initCallbackListeners.iterator();
        while (it.hasNext()) {
            ((INetworkInitCallbackListener) it.next()).onNetworkInitCallbackSuccess();
        }
        this.initCallbackListeners.clear();
    }

    @Override // com.unity3d.ads.IUnityAdsInitializationListener
    public void onInitializationFailed(UnityAds.UnityAdsInitializationError error, String message) {
        String str = getUnityAdsInitializationErrorCode(error) + message;
        IronLog.ADAPTER_CALLBACK.verbose("initError = " + str);
        Iterator<T> it = this.initCallbackListeners.iterator();
        while (it.hasNext()) {
            ((INetworkInitCallbackListener) it.next()).onNetworkInitCallbackFailed(str);
        }
        this.initCallbackListeners.clear();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        IronLog.ADAPTER_CALLBACK.verbose();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String appKey, String userId, JSONObject config, RewardedVideoSmashListener listener) {
        String optString = config != null ? config.optString(PLACEMENT_ID) : null;
        String optString2 = config != null ? config.optString(GAME_ID) : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (listener != null) {
                listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params - zoneId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            return;
        }
        String str2 = optString2;
        if (str2 == null || str2.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - sourceId");
            if (listener != null) {
                listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params - sourceId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        if (!UnityAds.isInitialized()) {
            initSDK(config);
        }
        if (listener != null) {
            listener.onRewardedVideoInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initAndLoadRewardedVideo(String appKey, String userId, JSONObject config, JSONObject adData, RewardedVideoSmashListener listener) {
        String optString = config != null ? config.optString(PLACEMENT_ID) : null;
        String optString2 = config != null ? config.optString(GAME_ID) : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (listener != null) {
                listener.onRewardedVideoAvailabilityChanged(false);
                return;
            }
            return;
        }
        String str2 = optString2;
        if (str2 == null || str2.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - sourceId");
            if (listener != null) {
                listener.onRewardedVideoAvailabilityChanged(false);
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        if (!UnityAds.isInitialized()) {
            initSDK(config);
        }
        loadRewardedVideoInternal(config, null, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject config, JSONObject adData, String serverData, RewardedVideoSmashListener listener) {
        loadRewardedVideoInternal(config, serverData, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideo(JSONObject config, JSONObject adData, RewardedVideoSmashListener listener) {
        loadRewardedVideoInternal(config, null, listener);
    }

    private final void loadRewardedVideoInternal(JSONObject config, String serverData, RewardedVideoSmashListener listener) {
        String optString = config != null ? config.optString(PLACEMENT_ID) : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (listener != null) {
                listener.onRewardedVideoLoadFailed(ErrorBuilder.buildLoadFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, getProviderName(), "Missing params - zoneId"));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        setRewardedVideoAdAvailability$unityadsadapter_release(optString, false);
        UnityAdsRewardedVideoAdListener unityAdsRewardedVideoAdListener = new UnityAdsRewardedVideoAdListener(listener, new WeakReference(this), optString);
        this.placementIdToRewardedVideoAdListener.put(optString, unityAdsRewardedVideoAdListener);
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        unityAdsLoadOptions.setObjectId(uuid);
        String str2 = serverData;
        if (str2 != null && str2.length() != 0) {
            unityAdsLoadOptions.setAdMarkup(serverData);
        }
        this.rewardedVideoPlacementIdToLoadedAdObjectId.put(optString, uuid);
        UnityAds.load(optString, unityAdsLoadOptions, unityAdsRewardedVideoAdListener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject config, RewardedVideoSmashListener listener) {
        String optString = config != null ? config.optString(PLACEMENT_ID) : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (listener != null) {
                listener.onRewardedVideoAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, "Missing params - zoneId"));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        if (isRewardedVideoAvailable(config)) {
            String dynamicUserId = getDynamicUserId();
            if (dynamicUserId != null && dynamicUserId.length() != 0) {
                synchronized (this.unityAdsStorageLock) {
                    PlayerMetaData playerMetaData = new PlayerMetaData(ContextProvider.getInstance().getApplicationContext());
                    playerMetaData.setServerId(getDynamicUserId());
                    playerMetaData.commit();
                    Unit unit = Unit.INSTANCE;
                }
            }
            UnityAdsRewardedVideoAdListener unityAdsRewardedVideoAdListener = this.placementIdToRewardedVideoAdListener.get(optString);
            String str2 = this.rewardedVideoPlacementIdToLoadedAdObjectId.get(optString);
            UnityAdsShowOptions unityAdsShowOptions = new UnityAdsShowOptions();
            unityAdsShowOptions.setObjectId(str2);
            UnityAds.show(ContextProvider.getInstance().getCurrentActiveActivity(), optString, unityAdsShowOptions, unityAdsRewardedVideoAdListener);
        } else if (listener != null) {
            listener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        setRewardedVideoAdAvailability$unityadsadapter_release(optString, false);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject config) {
        String optString = config != null ? config.optString(PLACEMENT_ID) : null;
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        String str = optString;
        return str != null && str.length() != 0 && this.placementIdToRewardedVideoAdAvailability.containsKey(optString) && Intrinsics.areEqual((Object) this.placementIdToRewardedVideoAdAvailability.get(optString), (Object) true);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void collectRewardedVideoBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        collectBiddingData(AdFormat.REWARDED, config, biddingDataCallback);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public LoadWhileShowSupportState getLoadWhileShowSupportState(JSONObject mAdUnitSettings) {
        Intrinsics.checkNotNullParameter(mAdUnitSettings, "mAdUnitSettings");
        return !mAdUnitSettings.optBoolean(LWS_SUPPORT_STATE, true) ? LoadWhileShowSupportState.NONE : LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String appKey, String userId, JSONObject config, InterstitialSmashListener listener) {
        initInterstitialInternal(config, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitial(String appKey, String userId, JSONObject config, InterstitialSmashListener listener) {
        initInterstitialInternal(config, listener);
    }

    private final void initInterstitialInternal(JSONObject config, InterstitialSmashListener listener) {
        String optString = config != null ? config.optString(PLACEMENT_ID) : null;
        String optString2 = config != null ? config.optString(GAME_ID) : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (listener != null) {
                listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params - zoneId", "Interstitial"));
                return;
            }
            return;
        }
        String str2 = optString2;
        if (str2 == null || str2.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - sourceId");
            if (listener != null) {
                listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params - sourceId", "Interstitial"));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        if (!UnityAds.isInitialized()) {
            initSDK(config);
        }
        if (listener != null) {
            listener.onInterstitialInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(JSONObject config, JSONObject adData, String serverData, InterstitialSmashListener listener) {
        loadInterstitialInternal(config, serverData, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitial(JSONObject config, JSONObject adData, InterstitialSmashListener listener) {
        loadInterstitialInternal(config, null, listener);
    }

    private final void loadInterstitialInternal(JSONObject config, String serverData, InterstitialSmashListener listener) {
        String optString = config != null ? config.optString(PLACEMENT_ID) : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (listener != null) {
                listener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("Interstitial", getProviderName(), "Missing params - zoneId"));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        setInterstitialAdAvailability$unityadsadapter_release(optString, false);
        UnityAdsInterstitialAdListener unityAdsInterstitialAdListener = new UnityAdsInterstitialAdListener(listener, new WeakReference(this), optString);
        this.placementIdToInterstitialAdListener.put(optString, unityAdsInterstitialAdListener);
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        unityAdsLoadOptions.setObjectId(uuid);
        String str2 = serverData;
        if (str2 != null && str2.length() != 0) {
            unityAdsLoadOptions.setAdMarkup(serverData);
        }
        this.interstitialPlacementIdToLoadedAdObjectId.put(optString, uuid);
        UnityAds.load(optString, unityAdsLoadOptions, unityAdsInterstitialAdListener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(JSONObject config, InterstitialSmashListener listener) {
        String optString = config != null ? config.optString(PLACEMENT_ID) : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (listener != null) {
                listener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", "Missing params - zoneId"));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        if (isInterstitialReady(config)) {
            UnityAdsInterstitialAdListener unityAdsInterstitialAdListener = this.placementIdToInterstitialAdListener.get(optString);
            String str2 = this.interstitialPlacementIdToLoadedAdObjectId.get(optString);
            UnityAdsShowOptions unityAdsShowOptions = new UnityAdsShowOptions();
            unityAdsShowOptions.setObjectId(str2);
            UnityAds.show(ContextProvider.getInstance().getCurrentActiveActivity(), optString, unityAdsShowOptions, unityAdsInterstitialAdListener);
        } else if (listener != null) {
            listener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
        }
        setInterstitialAdAvailability$unityadsadapter_release(optString, false);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject config) {
        String optString = config != null ? config.optString(PLACEMENT_ID) : null;
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        String str = optString;
        return str != null && str.length() != 0 && this.placementIdToInterstitialAdAvailability.containsKey(optString) && Intrinsics.areEqual((Object) this.placementIdToInterstitialAdAvailability.get(optString), (Object) true);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void collectInterstitialBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        collectBiddingData(AdFormat.INTERSTITIAL, config, biddingDataCallback);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String appKey, String userId, JSONObject config, BannerSmashListener listener) {
        initBannersInternal(config, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBanners(String appKey, String userId, JSONObject config, BannerSmashListener listener) {
        initBannersInternal(config, listener);
    }

    private final void initBannersInternal(JSONObject config, BannerSmashListener listener) {
        String optString = config != null ? config.optString(PLACEMENT_ID) : null;
        String optString2 = config != null ? config.optString(GAME_ID) : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (listener != null) {
                listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params - zoneId", "Banner"));
                return;
            }
            return;
        }
        String str2 = optString2;
        if (str2 == null || str2.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - sourceId");
            if (listener != null) {
                listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params - sourceId", "Banner"));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        if (!UnityAds.isInitialized()) {
            initSDK(config);
        }
        if (listener != null) {
            listener.onBannerInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject config, JSONObject adData, String serverData, IronSourceBannerLayout banner, BannerSmashListener listener) {
        loadBannerInternal(config, banner, serverData, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBanner(JSONObject config, JSONObject adData, IronSourceBannerLayout banner, BannerSmashListener listener) {
        loadBannerInternal(config, banner, null, listener);
    }

    private final void loadBannerInternal(JSONObject config, IronSourceBannerLayout banner, String serverData, BannerSmashListener listener) {
        String optString = config != null ? config.optString(PLACEMENT_ID) : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.ADAPTER_API.error("Missing param - zoneId");
            if (listener != null) {
                listener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Banner", getProviderName(), "Missing params - zoneId"));
                return;
            }
            return;
        }
        if (banner == null) {
            IronLog.ADAPTER_API.error("banner is null");
            if (listener != null) {
                listener.onBannerAdLoadFailed(ErrorBuilder.buildNoConfigurationAvailableError("banner is null"));
                return;
            }
            return;
        }
        ISBannerSize size = banner.getSize();
        Intrinsics.checkNotNullExpressionValue(size, "banner.size");
        if (!isBannerSizeSupported(size)) {
            IronLog.ADAPTER_API.error("size not supported, size = " + banner.getSize().getDescription());
            if (listener != null) {
                listener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getProviderName()));
                return;
            }
            return;
        }
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        BannerView bannerView = getBannerView(banner, optString, listener);
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        unityAdsLoadOptions.setObjectId(uuid);
        String str2 = serverData;
        if (str2 != null && str2.length() != 0) {
            unityAdsLoadOptions.setAdMarkup(serverData);
        }
        bannerView.load(unityAdsLoadOptions);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject config) {
        String optString = config != null ? config.optString(PLACEMENT_ID) : null;
        IronLog.ADAPTER_API.verbose("placementId = " + optString);
        if (this.placementIdToBannerAd.get(optString) != null) {
            BannerView bannerView = this.placementIdToBannerAd.get(optString);
            if (bannerView != null) {
                bannerView.destroy();
            }
            TypeIntrinsics.asMutableMap(this.placementIdToBannerAd).remove(optString);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void collectBannerBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        collectBiddingData(AdFormat.BANNER, config, biddingDataCallback);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT adUnit, JSONObject config) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        IronLog.INTERNAL.verbose("adUnit = " + adUnit);
        int i = WhenMappings.$EnumSwitchMapping$0[adUnit.ordinal()];
        if (i == 1) {
            this.placementIdToRewardedVideoAdListener.clear();
            this.rewardedVideoPlacementIdToLoadedAdObjectId.clear();
            this.placementIdToRewardedVideoAdAvailability.clear();
        } else if (i == 2) {
            this.placementIdToInterstitialAdListener.clear();
            this.interstitialPlacementIdToLoadedAdObjectId.clear();
            this.placementIdToInterstitialAdAvailability.clear();
        } else {
            if (i != 3) {
                return;
            }
            for (BannerView bannerView : this.placementIdToBannerAd.values()) {
                if (bannerView != null) {
                    bannerView.destroy();
                }
            }
            this.placementIdToBannerAdListener.clear();
            this.placementIdToBannerAd.clear();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setConsent(boolean consent) {
        IronLog.ADAPTER_API.verbose("setConsent = " + consent);
        setUnityAdsMetaData(CONSENT_GDPR, consent);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setMetaData(String key, List<String> values) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
        if (values.isEmpty()) {
            return;
        }
        String str = values.get(0);
        IronLog.ADAPTER_API.verbose("key = " + key + ", value = " + str);
        if (MetaDataUtils.isValidCCPAMetaData(key, str)) {
            setCCPAValue(MetaDataUtils.getMetaDataBooleanValue(str));
            return;
        }
        String formatValueForType = MetaDataUtils.formatValueForType(str, MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN);
        if (MetaDataUtils.isValidMetaData(key, UNITYADS_METADATA_COPPA_KEY, formatValueForType)) {
            setCOPPAValue(MetaDataUtils.getMetaDataBooleanValue(formatValueForType));
        }
    }

    private final void setUnityAdsMetaData(String key, boolean value) {
        IronLog.INTERNAL.verbose("key = " + key + ", value = " + value);
        synchronized (this.unityAdsStorageLock) {
            com.unity3d.ads.metadata.MetaData metaData = new com.unity3d.ads.metadata.MetaData(ContextProvider.getInstance().getApplicationContext());
            metaData.set(key, Boolean.valueOf(value));
            if (Intrinsics.areEqual(key, "user.nonBehavioral")) {
                metaData.set("mode", MIXED_AUDIENCE);
            }
            metaData.commit();
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void setCOPPAValue(boolean value) {
        IronLog.ADAPTER_API.verbose("value = " + value);
        setUnityAdsMetaData("user.nonBehavioral", value);
    }

    private final void setCCPAValue(boolean value) {
        IronLog.ADAPTER_API.verbose("value = " + value);
        setUnityAdsMetaData(CONSENT_CCPA, !value);
    }

    private final void collectBiddingData(AdFormat adFormat, JSONObject config, final BiddingDataCallback biddingDataCallback) {
        UnityAds.getToken(new TokenConfiguration(adFormat, null, 2, null), new IUnityAdsTokenListener() { // from class: com.ironsource.adapters.unityads.UnityAdsAdapter$$ExternalSyntheticLambda0
            @Override // com.unity3d.ads.IUnityAdsTokenListener
            public final void onUnityAdsTokenReady(String str) {
                UnityAdsAdapter.collectBiddingData$lambda$7(BiddingDataCallback.this, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void collectBiddingData$lambda$7(BiddingDataCallback biddingDataCallback, String bidToken) {
        Intrinsics.checkNotNullParameter(biddingDataCallback, "$biddingDataCallback");
        String str = bidToken;
        if (str != null && str.length() != 0) {
            IronLog.ADAPTER_API.verbose("token = " + bidToken);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Intrinsics.checkNotNullExpressionValue(bidToken, "bidToken");
            linkedHashMap.put("token", bidToken);
            biddingDataCallback.onSuccess(linkedHashMap);
            return;
        }
        biddingDataCallback.onFailure("Failed to receive token - UnityAds");
    }

    private final boolean isBannerSizeSupported(ISBannerSize size) {
        String description = size.getDescription();
        if (description == null) {
            return false;
        }
        switch (description.hashCode()) {
            case -387072689:
                return description.equals("RECTANGLE");
            case 72205083:
                return description.equals("LARGE");
            case 79011241:
                return description.equals("SMART");
            case 1951953708:
                return description.equals("BANNER");
            default:
                return false;
        }
    }

    private final UnityBannerSize getBannerSize(ISBannerSize size, boolean isLargeScreen) {
        String description = size.getDescription();
        if (description == null) {
            return null;
        }
        switch (description.hashCode()) {
            case -387072689:
                if (description.equals("RECTANGLE")) {
                    return new UnityBannerSize(300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                }
                return null;
            case 72205083:
                if (!description.equals("LARGE")) {
                    return null;
                }
                break;
            case 79011241:
                if (description.equals("SMART")) {
                    return isLargeScreen ? new UnityBannerSize(728, 90) : new UnityBannerSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
                }
                return null;
            case 1951953708:
                if (!description.equals("BANNER")) {
                    return null;
                }
                break;
            default:
                return null;
        }
        return new UnityBannerSize(Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
    }

    private final BannerView getBannerView(IronSourceBannerLayout banner, String placementId, BannerSmashListener listener) {
        if (this.placementIdToBannerAd.get(placementId) != null) {
            BannerView bannerView = this.placementIdToBannerAd.get(placementId);
            if (bannerView != null) {
                bannerView.destroy();
            }
            this.placementIdToBannerAd.remove(placementId);
        }
        ISBannerSize size = banner.getSize();
        Intrinsics.checkNotNullExpressionValue(size, "banner.size");
        BannerView bannerView2 = new BannerView(ContextProvider.getInstance().getCurrentActiveActivity(), placementId, getBannerSize(size, AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext())));
        UnityAdsBannerAdListener unityAdsBannerAdListener = new UnityAdsBannerAdListener(listener, new WeakReference(this), placementId);
        this.placementIdToBannerAdListener.put(placementId, unityAdsBannerAdListener);
        bannerView2.setListener(unityAdsBannerAdListener);
        this.placementIdToBannerAd.put(placementId, bannerView2);
        return bannerView2;
    }

    public final FrameLayout.LayoutParams createLayoutParams(UnityBannerSize size) {
        Intrinsics.checkNotNullParameter(size, "size");
        return new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(ContextProvider.getInstance().getApplicationContext(), size.getWidth()), -2, 17);
    }

    private final int getUnityAdsInitializationErrorCode(UnityAds.UnityAdsInitializationError error) {
        if (error == null) {
            return 510;
        }
        for (UnityAds.UnityAdsInitializationError unityAdsInitializationError : UnityAds.UnityAdsInitializationError.values()) {
            if (StringsKt.equals(unityAdsInitializationError.name(), error.toString(), true)) {
                return UnityAds.UnityAdsInitializationError.valueOf(error.toString()).ordinal();
            }
        }
        return 510;
    }

    public final int getUnityAdsLoadErrorCode(UnityAds.UnityAdsLoadError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        for (UnityAds.UnityAdsLoadError unityAdsLoadError : UnityAds.UnityAdsLoadError.values()) {
            if (StringsKt.equals(unityAdsLoadError.name(), error.toString(), true)) {
                return UnityAds.UnityAdsLoadError.valueOf(error.toString()).ordinal();
            }
        }
        return 510;
    }

    public final int getUnityAdsShowErrorCode(UnityAds.UnityAdsShowError error) {
        Intrinsics.checkNotNullParameter(error, "error");
        for (UnityAds.UnityAdsShowError unityAdsShowError : UnityAds.UnityAdsShowError.values()) {
            if (StringsKt.equals(unityAdsShowError.name(), error.toString(), true)) {
                return UnityAds.UnityAdsShowError.valueOf(error.toString()).ordinal();
            }
        }
        return 510;
    }

    public final void setRewardedVideoAdAvailability$unityadsadapter_release(String placementId, boolean isAvailable) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        this.placementIdToRewardedVideoAdAvailability.put(placementId, Boolean.valueOf(isAvailable));
    }

    public final void setInterstitialAdAvailability$unityadsadapter_release(String placementId, boolean isAvailable) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        this.placementIdToInterstitialAdAvailability.put(placementId, Boolean.valueOf(isAvailable));
    }
}
