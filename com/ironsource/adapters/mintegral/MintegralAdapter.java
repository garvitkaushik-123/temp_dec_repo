package com.ironsource.adapters.mintegral;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.ironsource.L2;
import com.ironsource.Y1;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.net.Aa;
import com.mbridge.msdk.mbbid.out.BidConstants;
import com.mbridge.msdk.mbbid.out.BidManager;
import com.mbridge.msdk.newinterstitial.out.MBBidNewInterstitialHandler;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBBidRewardVideoHandler;
import com.mbridge.msdk.out.MBConfiguration;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.out.SDKInitStatusListener;
import com.mbridge.msdk.system.MBridgeSDKImpl;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.http.ContentDisposition;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* compiled from: MintegralAdapter.kt */
@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010!\n\u0002\b\u0004\u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001eB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010!\u001a\u00020\"2\u0006\u0010'\u001a\u00020$H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016J\u0012\u0010,\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J(\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020/\u0018\u00010.2\u0006\u0010*\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010+H\u0016J\u0010\u00101\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u00020\u0005J\u0010\u00103\u001a\u0004\u0018\u00010\u00102\u0006\u00102\u001a\u00020\u0005J&\u00104\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020/\u0018\u00010.2\u0006\u0010*\u001a\u00020+2\u0006\u00105\u001a\u00020\u0005H\u0002J\b\u00106\u001a\u00020\u0005H\u0016J(\u00107\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020/\u0018\u00010.2\u0006\u0010*\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010+H\u0016J(\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020/\u0018\u00010.2\u0006\u0010*\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010+H\u0016J\b\u00109\u001a\u00020\u0005H\u0016J,\u0010:\u001a\u00020)2\b\u0010;\u001a\u0004\u0018\u00010\u00052\b\u0010<\u001a\u0004\u0018\u00010\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010=\u001a\u00020\u0014H\u0016J,\u0010>\u001a\u00020)2\b\u0010;\u001a\u0004\u0018\u00010\u00052\b\u0010<\u001a\u0004\u0018\u00010\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010=\u001a\u00020\u0019H\u0016J,\u0010?\u001a\u00020)2\b\u0010;\u001a\u0004\u0018\u00010\u00052\b\u0010<\u001a\u0004\u0018\u00010\u00052\u0006\u0010*\u001a\u00020+2\u0006\u0010=\u001a\u00020\u001fH\u0016J\u0018\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020\u00052\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0018\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\u0005H\u0002J\u0010\u0010F\u001a\u00020\b2\u0006\u00102\u001a\u00020\u0005H\u0002J\u0010\u0010G\u001a\u00020\b2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010H\u001a\u00020\b2\u0006\u0010*\u001a\u00020+H\u0016J\u0010\u0010I\u001a\u00020\b2\u0006\u0010J\u001a\u00020KH\u0016J6\u0010L\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010+2\b\u0010M\u001a\u0004\u0018\u00010\u00052\b\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010=\u001a\u00020\u0014H\u0016J,\u0010P\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010+2\b\u0010M\u001a\u0004\u0018\u00010\u00052\u0006\u0010=\u001a\u00020\u0019H\u0016J,\u0010Q\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\b\u00100\u001a\u0004\u0018\u00010+2\b\u0010M\u001a\u0004\u0018\u00010\u00052\u0006\u0010=\u001a\u00020\u001fH\u0016J\u0010\u0010R\u001a\u00020\u00052\u0006\u0010J\u001a\u00020KH\u0002J\u0010\u0010S\u001a\u00020)2\u0006\u0010T\u001a\u00020\u0005H\u0016J\b\u0010U\u001a\u00020)H\u0016J\u0012\u0010V\u001a\u00020)2\b\u0010W\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010X\u001a\u00020)H\u0016J\u001a\u0010Y\u001a\u00020)2\u0006\u0010J\u001a\u00020K2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010Z\u001a\u00020)2\u0006\u0010[\u001a\u00020\bH\u0002J\u0010\u0010\\\u001a\u00020)2\u0006\u0010E\u001a\u00020\bH\u0002J\b\u0010]\u001a\u00020)H\u0002J\u0010\u0010^\u001a\u00020)2\u0006\u0010_\u001a\u00020\bH\u0014J\u001e\u0010`\u001a\u00020)2\u0006\u0010D\u001a\u00020\u00052\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00050bH\u0014J\u0018\u0010c\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010=\u001a\u00020\u0019H\u0016J\u0018\u0010d\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010=\u001a\u00020\u001fH\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00140\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00190\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001d0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u001f0\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006f"}, d2 = {"Lcom/ironsource/adapters/mintegral/MintegralAdapter;", "Lcom/ironsource/mediationsdk/AbstractAdapter;", "Lcom/ironsource/mediationsdk/INetworkInitCallbackListener;", "Lcom/mbridge/msdk/out/SDKInitStatusListener;", "providerName", "", "(Ljava/lang/String;)V", "consentCollectingUserData", "", "Ljava/lang/Boolean;", "coppaUserData", "doNotSellCollectingUserData", "mBannerPlacementIdToAdListener", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/ironsource/adapters/mintegral/MintegralBannerListener;", "mBannerPlacementIdToAdView", "Lcom/mbridge/msdk/out/MBBannerView;", "mBannerPlacementIdToLayout", "Landroid/widget/FrameLayout$LayoutParams;", "mBannerPlacementIdToSmashListener", "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "mInterstitialPlacementId", "mInterstitialPlacementIdToAdListener", "Lcom/ironsource/adapters/mintegral/MintegralInterstitialListener;", "mInterstitialPlacementIdToSmashListener", "Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;", "mRewardedVideoAd", "Lcom/mbridge/msdk/out/MBBidRewardVideoHandler;", "mRewardedVideoPlacementIdToAdListener", "Lcom/ironsource/adapters/mintegral/MintegralRewardedVideoListener;", "mRewardedVideoPlacementIdToSmashListener", "Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;", "createBannerLayoutParams", "context", "Landroid/content/Context;", ContentDisposition.Parameters.Size, "Lcom/ironsource/mediationsdk/ISBannerSize;", "createBannerSize", "Lcom/mbridge/msdk/out/BannerSize;", L2.u, C3040d4.g.S, "", "config", "Lorg/json/JSONObject;", "disposeInterstitialAd", "getBannerBiddingData", "", "", "adData", "getBannerLayoutParams", "placementId", "getBannerView", "getBiddingData", "adType", "getCoreSDKVersion", "getInterstitialBiddingData", "getRewardedVideoBiddingData", "getVersion", "initBannerForBidding", "ironsourceAppKey", "userId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initInterstitialForBidding", "initRewardedVideoWithCallback", "initSdk", MintegralAdapter.APP_ID_KEY, "appKey", "isCOPPAMetaData", C3040d4.h.W, "value", "isInterstitialPlacementIdExist", "isInterstitialReady", "isRewardedVideoAvailable", "isUsingActivityBeforeImpression", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "loadBannerForBidding", C3207n2.s, "banner", "Lcom/ironsource/mediationsdk/IronSourceBannerLayout;", "loadInterstitialForBidding", "loadRewardedVideoForBidding", "mapToMintegralType", "onInitFail", "errorMsg", "onInitSuccess", "onNetworkInitCallbackFailed", "error", "onNetworkInitCallbackSuccess", "releaseMemory", "setCCPAValue", "ccpa", "setCOPPAValue", "setChannelCode", "setConsent", C3040d4.i.b0, "setMetaData", "values", "", C3040d4.g.H, C3040d4.g.i, "Companion", "mintegraladapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MintegralAdapter extends AbstractAdapter implements INetworkInitCallbackListener, SDKInitStatusListener {
    private static final String APP_ID_KEY = "appId";
    private static final String APP_KEY = "appKey";
    private static final String GitHash = "ab3d8a8";
    private static final String META_DATA_MINTEGRAL_COPPA_KEY = "Mintegral_COPPA";
    public static final int MINTEGRAL_NO_FILL_ERROR_CODE = 708;
    private static final String NETWORK_NAME = "Mintegral";
    private static final String PLACEMENT_ID_KEY = "placementId";
    private static final String UNIT_ID_KEY = "unitId";
    private static final String VERSION = "4.3.47";
    private Boolean consentCollectingUserData;
    private Boolean coppaUserData;
    private Boolean doNotSellCollectingUserData;
    private final ConcurrentHashMap<String, MintegralBannerListener> mBannerPlacementIdToAdListener;
    private final ConcurrentHashMap<String, MBBannerView> mBannerPlacementIdToAdView;
    private final ConcurrentHashMap<String, FrameLayout.LayoutParams> mBannerPlacementIdToLayout;
    private ConcurrentHashMap<String, BannerSmashListener> mBannerPlacementIdToSmashListener;
    private String mInterstitialPlacementId;
    private final ConcurrentHashMap<String, MintegralInterstitialListener> mInterstitialPlacementIdToAdListener;
    private ConcurrentHashMap<String, InterstitialSmashListener> mInterstitialPlacementIdToSmashListener;
    private MBBidRewardVideoHandler mRewardedVideoAd;
    private final ConcurrentHashMap<String, MintegralRewardedVideoListener> mRewardedVideoPlacementIdToAdListener;
    private ConcurrentHashMap<String, RewardedVideoSmashListener> mRewardedVideoPlacementIdToSmashListener;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicBoolean mDidCallInit = new AtomicBoolean(false);
    private static Companion.EInitState mInitState = Companion.EInitState.NOT_INIT;
    private static final HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();
    private static MintegralAdHolder<MBBidNewInterstitialHandler> mInterstitialAds = new MintegralAdHolder<>();

    /* compiled from: MintegralAdapter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Companion.EInitState.values().length];
            try {
                iArr[Companion.EInitState.INIT_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.EInitState.INIT_FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Companion.EInitState.NOT_INIT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Companion.EInitState.INIT_IN_PROGRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[IronSource.AD_UNIT.values().length];
            try {
                iArr2[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$1 = iArr2;
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
    public static final MintegralAdapter startAdapter(String str) {
        return INSTANCE.startAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MintegralAdapter(String providerName) {
        super(providerName);
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        this.mRewardedVideoPlacementIdToSmashListener = new ConcurrentHashMap<>();
        this.mRewardedVideoPlacementIdToAdListener = new ConcurrentHashMap<>();
        this.mInterstitialPlacementIdToSmashListener = new ConcurrentHashMap<>();
        this.mInterstitialPlacementIdToAdListener = new ConcurrentHashMap<>();
        this.mBannerPlacementIdToSmashListener = new ConcurrentHashMap<>();
        this.mBannerPlacementIdToAdListener = new ConcurrentHashMap<>();
        this.mBannerPlacementIdToAdView = new ConcurrentHashMap<>();
        this.mBannerPlacementIdToLayout = new ConcurrentHashMap<>();
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    /* compiled from: MintegralAdapter.kt */
    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0007J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/ironsource/adapters/mintegral/MintegralAdapter$Companion;", "", "()V", "APP_ID_KEY", "", "APP_KEY", "GitHash", "META_DATA_MINTEGRAL_COPPA_KEY", "MINTEGRAL_NO_FILL_ERROR_CODE", "", "NETWORK_NAME", "PLACEMENT_ID_KEY", "UNIT_ID_KEY", "VERSION", "initCallbackListeners", "Ljava/util/HashSet;", "Lcom/ironsource/mediationsdk/INetworkInitCallbackListener;", "Lkotlin/collections/HashSet;", "mDidCallInit", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mInitState", "Lcom/ironsource/adapters/mintegral/MintegralAdapter$Companion$EInitState;", "mInterstitialAds", "Lcom/ironsource/adapters/mintegral/MintegralAdHolder;", "Lcom/mbridge/msdk/newinterstitial/out/MBBidNewInterstitialHandler;", "getAdapterSDKVersion", "getIntegrationData", "Lcom/ironsource/mediationsdk/IntegrationData;", "context", "Landroid/content/Context;", IronSourceConstants.START_ADAPTER, "Lcom/ironsource/adapters/mintegral/MintegralAdapter;", "providerName", "EInitState", "mintegraladapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: MintegralAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ironsource/adapters/mintegral/MintegralAdapter$Companion$EInitState;", "", "(Ljava/lang/String;I)V", "NOT_INIT", "INIT_IN_PROGRESS", "INIT_SUCCESS", "INIT_FAIL", "mintegraladapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private enum EInitState {
            NOT_INIT,
            INIT_IN_PROGRESS,
            INIT_SUCCESS,
            INIT_FAIL
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MintegralAdapter startAdapter(String providerName) {
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            return new MintegralAdapter(providerName);
        }

        @JvmStatic
        public final IntegrationData getIntegrationData(Context context) {
            return new IntegrationData(MintegralAdapter.NETWORK_NAME, "4.3.47");
        }

        @JvmStatic
        public final String getAdapterSDKVersion() {
            return MBConfiguration.SDK_VERSION;
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "4.3.47";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return INSTANCE.getAdapterSDKVersion();
    }

    private final void initSdk(String appId, String appKey) {
        Unit unit;
        Application application;
        if (mInitState == Companion.EInitState.NOT_INIT || mInitState == Companion.EInitState.INIT_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mDidCallInit.compareAndSet(false, true)) {
            mInitState = Companion.EInitState.INIT_IN_PROGRESS;
            if (isAdaptersDebugEnabled()) {
                MBridgeConstans.DEBUG = true;
            }
            MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
            Intrinsics.checkNotNullExpressionValue(mBridgeSDK, "getMBridgeSDK()");
            MBridgeSDKImpl mBridgeSDKImpl = mBridgeSDK;
            Map<String, String> mBConfigurationMap = mBridgeSDKImpl.getMBConfigurationMap(appId, appKey);
            setChannelCode();
            Boolean bool = this.consentCollectingUserData;
            if (bool != null) {
                setConsent(bool.booleanValue());
            }
            Boolean bool2 = this.doNotSellCollectingUserData;
            if (bool2 != null) {
                setCCPAValue(bool2.booleanValue());
            }
            IronLog.ADAPTER_API.verbose(getProviderName() + " initSDK with appId=" + appId + " and appKey=" + appKey);
            Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
            if (currentActiveActivity == null || (application = currentActiveActivity.getApplication()) == null) {
                unit = null;
            } else {
                mBridgeSDKImpl.init(mBConfigurationMap, application, (SDKInitStatusListener) this);
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                mBridgeSDKImpl.init(mBConfigurationMap, ContextProvider.getInstance().getApplicationContext(), this);
            }
        }
    }

    @Override // com.mbridge.msdk.out.SDKInitStatusListener
    public void onInitFail(String errorMsg) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        IronLog.ADAPTER_CALLBACK.verbose("error= " + errorMsg);
        mInitState = Companion.EInitState.INIT_FAIL;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            INetworkInitCallbackListener initCallbackListeners2 = it.next();
            Intrinsics.checkNotNullExpressionValue(initCallbackListeners2, "initCallbackListeners");
            initCallbackListeners2.onNetworkInitCallbackFailed("SDK failed to init.");
        }
        initCallbackListeners.clear();
    }

    @Override // com.mbridge.msdk.out.SDKInitStatusListener
    public void onInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = Companion.EInitState.INIT_SUCCESS;
        Boolean bool = this.coppaUserData;
        if (bool != null) {
            setCOPPAValue(bool.booleanValue());
        }
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            INetworkInitCallbackListener initCallbackListeners2 = it.next();
            Intrinsics.checkNotNullExpressionValue(initCallbackListeners2, "initCallbackListeners");
            initCallbackListeners2.onNetworkInitCallbackSuccess();
        }
        initCallbackListeners.clear();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String error) {
        for (Map.Entry<String, RewardedVideoSmashListener> entry : this.mRewardedVideoPlacementIdToSmashListener.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry, "mRewardedVideoPlacementIdToSmashListener.entries");
            entry.getValue().onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("failed to init: " + error, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        for (Map.Entry<String, InterstitialSmashListener> entry2 : this.mInterstitialPlacementIdToSmashListener.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry2, "mInterstitialPlacementIdToSmashListener.entries");
            entry2.getValue().onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("failed to init: " + error, "Interstitial"));
        }
        for (Map.Entry<String, BannerSmashListener> entry3 : this.mBannerPlacementIdToSmashListener.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry3, "mBannerPlacementIdToSmashListener.entries");
            entry3.getValue().onBannerInitFailed(ErrorBuilder.buildInitFailedError("failed to init: " + error, "Banner"));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        for (Map.Entry<String, RewardedVideoSmashListener> entry : this.mRewardedVideoPlacementIdToSmashListener.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry, "mRewardedVideoPlacementIdToSmashListener.entries");
            entry.getValue().onRewardedVideoInitSuccess();
        }
        for (Map.Entry<String, InterstitialSmashListener> entry2 : this.mInterstitialPlacementIdToSmashListener.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry2, "mInterstitialPlacementIdToSmashListener.entries");
            entry2.getValue().onInterstitialInitSuccess();
        }
        for (Map.Entry<String, BannerSmashListener> entry3 : this.mBannerPlacementIdToSmashListener.entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry3, "mBannerPlacementIdToSmashListener.entries");
            entry3.getValue().onBannerInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String ironsourceAppKey, String userId, JSONObject config, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String appId = config.optString(APP_ID_KEY);
        String appKey = config.optString("appKey");
        String placementId = config.optString("placementId");
        String str = appId;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("Missing appId");
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params: appId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        String str2 = appKey;
        if (str2 == null || str2.length() == 0) {
            IronLog.INTERNAL.error("Missing appKey");
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params: appKey", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        String str3 = placementId;
        if (str3 == null || str3.length() == 0) {
            IronLog.INTERNAL.error("Missing placementId");
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params: placementId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        ConcurrentHashMap<String, RewardedVideoSmashListener> concurrentHashMap = this.mRewardedVideoPlacementIdToSmashListener;
        Intrinsics.checkNotNullExpressionValue(placementId, "placementId");
        concurrentHashMap.put(placementId, listener);
        int i = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i == 1) {
            listener.onRewardedVideoInitSuccess();
        } else {
            if (i == 2) {
                listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("SDK failed to init.", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                return;
            }
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            Intrinsics.checkNotNullExpressionValue(appKey, "appKey");
            initSdk(appId, appKey);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject config, JSONObject adData, String serverData, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String placementId = config.optString("placementId");
        String optString = config.optString("unitId");
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("Missing unitId");
            listener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        MBBidRewardVideoHandler mBBidRewardVideoHandler = new MBBidRewardVideoHandler(ContextProvider.getInstance().getApplicationContext(), placementId, optString);
        Intrinsics.checkNotNullExpressionValue(placementId, "placementId");
        MintegralRewardedVideoListener mintegralRewardedVideoListener = new MintegralRewardedVideoListener(placementId, new WeakReference(listener), new WeakReference(this), config);
        this.mRewardedVideoPlacementIdToAdListener.put(placementId, mintegralRewardedVideoListener);
        mBBidRewardVideoHandler.setRewardVideoListener(mintegralRewardedVideoListener);
        this.mRewardedVideoAd = mBBidRewardVideoHandler;
        IronLog.ADAPTER_API.verbose("load rewarded video with placementId=" + placementId + " unitId=" + optString + " serverData=" + serverData);
        mBBidRewardVideoHandler.loadFromBid(serverData);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject config, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String optString = config.optString("placementId");
        if (isRewardedVideoAvailable(config)) {
            IronLog.ADAPTER_API.verbose("show rewarded video with placementId = " + optString);
            MBBidRewardVideoHandler mBBidRewardVideoHandler = this.mRewardedVideoAd;
            if (mBBidRewardVideoHandler != null) {
                mBBidRewardVideoHandler.showFromBid();
                return;
            }
            return;
        }
        listener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        MBBidRewardVideoHandler mBBidRewardVideoHandler = this.mRewardedVideoAd;
        return mBBidRewardVideoHandler != null && mBBidRewardVideoHandler.isBidReady();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public Map<String, Object> getRewardedVideoBiddingData(JSONObject config, JSONObject adData) {
        Intrinsics.checkNotNullParameter(config, "config");
        return getBiddingData(config, mapToMintegralType(IronSource.AD_UNIT.REWARDED_VIDEO));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String ironsourceAppKey, String userId, JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String appId = config.optString(APP_ID_KEY);
        String appKey = config.optString("appKey");
        String placementId = config.optString("placementId");
        String str = appId;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("Missing appId");
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params: appId", "Interstitial"));
            return;
        }
        String str2 = appKey;
        if (str2 == null || str2.length() == 0) {
            IronLog.INTERNAL.error("Missing appKey");
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params: appKey", "Interstitial"));
            return;
        }
        String str3 = placementId;
        if (str3 == null || str3.length() == 0) {
            IronLog.INTERNAL.error("Missing placementId");
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params: placementId", "Interstitial"));
            return;
        }
        ConcurrentHashMap<String, InterstitialSmashListener> concurrentHashMap = this.mInterstitialPlacementIdToSmashListener;
        Intrinsics.checkNotNullExpressionValue(placementId, "placementId");
        concurrentHashMap.put(placementId, listener);
        int i = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i == 1) {
            listener.onInterstitialInitSuccess();
        } else {
            if (i == 2) {
                listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("SDK failed to init.", "Interstitial"));
                return;
            }
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            Intrinsics.checkNotNullExpressionValue(appKey, "appKey");
            initSdk(appId, appKey);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(JSONObject config, JSONObject adData, String serverData, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String placementId = config.optString("placementId");
        String optString = config.optString("unitId");
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("Missing unitId");
            listener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("Missing params: unitId"));
            return;
        }
        Intrinsics.checkNotNullExpressionValue(placementId, "placementId");
        if (isInterstitialPlacementIdExist(placementId)) {
            IronLog.INTERNAL.info("Interstitial load request skipped. An interstitial ad with the same configuration is currently in use.");
            listener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("Interstitial load request skipped. An interstitial ad with the same configuration is currently in use."));
            return;
        }
        MBBidNewInterstitialHandler mBBidNewInterstitialHandler = new MBBidNewInterstitialHandler(ContextProvider.getInstance().getApplicationContext(), placementId, optString);
        MintegralInterstitialListener mintegralInterstitialListener = new MintegralInterstitialListener(placementId, new WeakReference(listener), new WeakReference(this), config);
        this.mInterstitialPlacementIdToAdListener.put(placementId, mintegralInterstitialListener);
        mBBidNewInterstitialHandler.setInterstitialVideoListener(mintegralInterstitialListener);
        this.mInterstitialPlacementId = placementId;
        mInterstitialAds.storeAd(this, mBBidNewInterstitialHandler);
        IronLog.ADAPTER_API.verbose("load interstitial with placementId=" + placementId + " unitId=" + optString + " serverData=" + serverData);
        mBBidNewInterstitialHandler.loadFromBid(serverData);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String optString = config.optString("placementId");
        if (isInterstitialReady(config)) {
            IronLog.ADAPTER_API.verbose("show interstitial with placementId = " + optString);
            MBBidNewInterstitialHandler retrieveAd = mInterstitialAds.retrieveAd(this);
            if (retrieveAd != null) {
                retrieveAd.showFromBid();
                return;
            }
            return;
        }
        disposeInterstitialAd(config);
        listener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void disposeInterstitialAd(JSONObject config) {
        IronLog.ADAPTER_API.verbose("Dispose interstitial ad of " + getProviderName() + ", placementId = " + (config != null ? config.optString("placementId") : null));
        mInterstitialAds.removeAd(this);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        String placementId = config.optString("placementId");
        MBBidNewInterstitialHandler retrieveAd = mInterstitialAds.retrieveAd(this);
        if (retrieveAd == null || !retrieveAd.isBidReady()) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(placementId, "placementId");
        return isInterstitialPlacementIdExist(placementId);
    }

    private final boolean isInterstitialPlacementIdExist(String placementId) {
        Set<MintegralAdapter> adapters = mInterstitialAds.getAdapters();
        if ((adapters instanceof Collection) && adapters.isEmpty()) {
            return false;
        }
        Iterator<T> it = adapters.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((MintegralAdapter) it.next()).mInterstitialPlacementId, placementId)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public Map<String, Object> getInterstitialBiddingData(JSONObject config, JSONObject adData) {
        Intrinsics.checkNotNullParameter(config, "config");
        return getBiddingData(config, mapToMintegralType(IronSource.AD_UNIT.INTERSTITIAL));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String ironsourceAppKey, String userId, JSONObject config, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String appId = config.optString(APP_ID_KEY);
        String appKey = config.optString("appKey");
        String placementId = config.optString("placementId");
        String str = appId;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("Missing appId");
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params: appId", "Banner"));
            return;
        }
        String str2 = appKey;
        if (str2 == null || str2.length() == 0) {
            IronLog.INTERNAL.error("Missing appKey");
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params: appKey", "Banner"));
            return;
        }
        String str3 = placementId;
        if (str3 == null || str3.length() == 0) {
            IronLog.INTERNAL.error("Missing placementId");
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params: placementId", "Banner"));
            return;
        }
        ConcurrentHashMap<String, BannerSmashListener> concurrentHashMap = this.mBannerPlacementIdToSmashListener;
        Intrinsics.checkNotNullExpressionValue(placementId, "placementId");
        concurrentHashMap.put(placementId, listener);
        int i = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i == 1) {
            listener.onBannerInitSuccess();
        } else {
            if (i == 2) {
                listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("SDK failed to init.", "Banner"));
                return;
            }
            Intrinsics.checkNotNullExpressionValue(appId, "appId");
            Intrinsics.checkNotNullExpressionValue(appKey, "appKey");
            initSdk(appId, appKey);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject config, JSONObject adData, String serverData, IronSourceBannerLayout banner, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String placementId = config.optString("placementId");
        String optString = config.optString("unitId");
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("Missing unitId");
            listener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Missing params: unitId"));
            return;
        }
        if (banner == null || banner.getSize() == null) {
            IronLog.INTERNAL.verbose("banner is null");
            listener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("IronSourceBannerLayout is null"));
            return;
        }
        Context context = ContextProvider.getInstance().getApplicationContext();
        MBBannerView mBBannerView = new MBBannerView(ContextProvider.getInstance().getApplicationContext());
        ConcurrentHashMap<String, MBBannerView> concurrentHashMap = this.mBannerPlacementIdToAdView;
        Intrinsics.checkNotNullExpressionValue(placementId, "placementId");
        concurrentHashMap.put(placementId, mBBannerView);
        ConcurrentHashMap<String, FrameLayout.LayoutParams> concurrentHashMap2 = this.mBannerPlacementIdToLayout;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ISBannerSize size = banner.getSize();
        Intrinsics.checkNotNullExpressionValue(size, "banner.size");
        concurrentHashMap2.put(placementId, createBannerLayoutParams(context, size));
        ISBannerSize size2 = banner.getSize();
        Intrinsics.checkNotNullExpressionValue(size2, "banner.size");
        BannerSize createBannerSize = createBannerSize(context, size2);
        mBBannerView.init(createBannerSize, placementId, optString);
        mBBannerView.setRefreshTime(0);
        mBBannerView.setAllowShowCloseBtn(false);
        MintegralBannerListener mintegralBannerListener = new MintegralBannerListener(placementId, new WeakReference(listener), new WeakReference(this));
        this.mBannerPlacementIdToAdListener.put(placementId, mintegralBannerListener);
        mBBannerView.setBannerAdListener(mintegralBannerListener);
        IronLog.ADAPTER_API.verbose("load banner with size " + createBannerSize.getWidth() + "X" + createBannerSize.getHeight() + " placementId=" + placementId + " unitId=" + optString + " serverData=" + serverData);
        mBBannerView.loadFromBid(serverData);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        final String optString = config.optString("placementId");
        String str = optString;
        if (str == null || str.length() == 0) {
            return;
        }
        AbstractAdapter.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.mintegral.MintegralAdapter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                MintegralAdapter.destroyBanner$lambda$6(optString, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void destroyBanner$lambda$6(String str, MintegralAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IronLog.ADAPTER_API.verbose("release banner placementId = " + str);
        MBBannerView mBBannerView = this$0.mBannerPlacementIdToAdView.get(str);
        if (mBBannerView != null) {
            mBBannerView.release();
        }
        this$0.mBannerPlacementIdToAdView.remove(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public Map<String, Object> getBannerBiddingData(JSONObject config, JSONObject adData) {
        Intrinsics.checkNotNullParameter(config, "config");
        return getBiddingData(config, mapToMintegralType(IronSource.AD_UNIT.BANNER));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT adUnit, JSONObject config) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        int i = WhenMappings.$EnumSwitchMapping$1[adUnit.ordinal()];
        if (i == 1) {
            this.mRewardedVideoPlacementIdToSmashListener.clear();
            this.mRewardedVideoPlacementIdToAdListener.clear();
            this.mRewardedVideoAd = null;
            return;
        }
        if (i == 2) {
            disposeInterstitialAd(config);
            this.mInterstitialPlacementIdToSmashListener.clear();
            this.mInterstitialPlacementIdToAdListener.clear();
        } else {
            if (i != 3) {
                return;
            }
            for (MBBannerView mBBannerView : this.mBannerPlacementIdToAdView.values()) {
                IronLog.ADAPTER_API.verbose("cleaning BN memory");
                mBBannerView.release();
                this.mBannerPlacementIdToAdView.clear();
            }
            this.mBannerPlacementIdToSmashListener.clear();
            this.mBannerPlacementIdToLayout.clear();
            this.mBannerPlacementIdToAdListener.clear();
            this.mBannerPlacementIdToAdView.clear();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setConsent(boolean consent) {
        int i = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i == 3) {
            this.consentCollectingUserData = Boolean.valueOf(consent);
        } else {
            if (i != 4) {
                return;
            }
            MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
            Intrinsics.checkNotNullExpressionValue(mBridgeSDK, "getMBridgeSDK()");
            IronLog.ADAPTER_API.verbose("setConsentStatus consentStatus = " + (consent ? 1 : 0));
            mBridgeSDK.setConsentStatus(ContextProvider.getInstance().getApplicationContext(), consent ? 1 : 0);
        }
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
        Intrinsics.checkNotNullExpressionValue(formatValueForType, "formatValueForType(value….META_DATA_VALUE_BOOLEAN)");
        if (isCOPPAMetaData(key, formatValueForType)) {
            setCOPPAValue(MetaDataUtils.getMetaDataBooleanValue(formatValueForType));
        }
    }

    private final void setCCPAValue(boolean ccpa) {
        int i = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i == 3) {
            this.doNotSellCollectingUserData = Boolean.valueOf(ccpa);
        } else {
            if (i != 4) {
                return;
            }
            MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
            Intrinsics.checkNotNullExpressionValue(mBridgeSDK, "getMBridgeSDK()");
            IronLog.ADAPTER_API.verbose("setDoNotTrackStatus with ccpa = " + ccpa);
            mBridgeSDK.setDoNotTrackStatus(ContextProvider.getInstance().getApplicationContext(), ccpa);
        }
    }

    private final boolean isCOPPAMetaData(String key, String value) {
        return StringsKt.equals(key, META_DATA_MINTEGRAL_COPPA_KEY, true) && value.length() > 0;
    }

    private final void setCOPPAValue(boolean value) {
        IronLog.ADAPTER_API.verbose("value = " + value);
        if (WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()] == 1) {
            MBridgeSDKImpl mBridgeSDK = MBridgeSDKFactory.getMBridgeSDK();
            Intrinsics.checkNotNullExpressionValue(mBridgeSDK, "getMBridgeSDK()");
            IronLog.ADAPTER_API.verbose("set coppa value = " + value);
            mBridgeSDK.setCoppaStatus(ContextProvider.getInstance().getApplicationContext(), value);
            return;
        }
        this.coppaUserData = Boolean.valueOf(value);
    }

    public final MBBannerView getBannerView(String placementId) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        return this.mBannerPlacementIdToAdView.get(placementId);
    }

    public final FrameLayout.LayoutParams getBannerLayoutParams(String placementId) {
        Intrinsics.checkNotNullParameter(placementId, "placementId");
        return this.mBannerPlacementIdToLayout.get(placementId);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final BannerSize createBannerSize(Context context, ISBannerSize bannerSize) {
        String description = bannerSize.getDescription();
        if (description != null) {
            switch (description.hashCode()) {
                case -387072689:
                    if (description.equals("RECTANGLE")) {
                        return new BannerSize(2, 300, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
                    }
                    break;
                case 72205083:
                    if (description.equals("LARGE")) {
                        return new BannerSize(1, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 90);
                    }
                    break;
                case 79011241:
                    if (description.equals("SMART")) {
                        return AdapterUtils.isLargeScreen(context) ? new BannerSize(3, 728, 90) : new BannerSize(4, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
                    }
                    break;
                case 1951953708:
                    if (description.equals("BANNER")) {
                        return new BannerSize(4, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE, 50);
                    }
                    break;
                case 1999208305:
                    if (description.equals("CUSTOM")) {
                        return new BannerSize(5, bannerSize.getWidth(), bannerSize.getHeight());
                    }
                    break;
            }
        }
        return new BannerSize(5, bannerSize.getWidth(), bannerSize.getHeight());
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private final FrameLayout.LayoutParams createBannerLayoutParams(Context context, ISBannerSize size) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, 0);
        String description = size.getDescription();
        if (description != null) {
            switch (description.hashCode()) {
                case -387072689:
                    if (description.equals("RECTANGLE")) {
                        layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, 300), AdapterUtils.dpToPixels(context, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
                        break;
                    }
                    break;
                case 72205083:
                    if (description.equals("LARGE")) {
                        layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(context, 90));
                        break;
                    }
                    break;
                case 79011241:
                    if (description.equals("SMART")) {
                        layoutParams = AdapterUtils.isLargeScreen(context) ? new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, 728), AdapterUtils.dpToPixels(context, 90)) : new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(context, 50));
                        break;
                    }
                    break;
                case 1951953708:
                    if (description.equals("BANNER")) {
                        layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(context, 50));
                        break;
                    }
                    break;
                case 1999208305:
                    if (description.equals("CUSTOM")) {
                        layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(context, size.getWidth()), AdapterUtils.dpToPixels(context, size.getHeight()));
                        break;
                    }
                    break;
            }
        }
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private final String mapToMintegralType(IronSource.AD_UNIT adUnit) {
        int i = WhenMappings.$EnumSwitchMapping$1[adUnit.ordinal()];
        if (i == 1) {
            String BID_FILTER_VALUE_AD_TYPE_REWARD_VIDEO = BidConstants.BID_FILTER_VALUE_AD_TYPE_REWARD_VIDEO;
            Intrinsics.checkNotNullExpressionValue(BID_FILTER_VALUE_AD_TYPE_REWARD_VIDEO, "BID_FILTER_VALUE_AD_TYPE_REWARD_VIDEO");
            return BID_FILTER_VALUE_AD_TYPE_REWARD_VIDEO;
        }
        if (i == 2) {
            String BID_FILTER_VALUE_AD_TYPE_INTERSTITIAL_VIDEO = BidConstants.BID_FILTER_VALUE_AD_TYPE_INTERSTITIAL_VIDEO;
            Intrinsics.checkNotNullExpressionValue(BID_FILTER_VALUE_AD_TYPE_INTERSTITIAL_VIDEO, "BID_FILTER_VALUE_AD_TYPE_INTERSTITIAL_VIDEO");
            return BID_FILTER_VALUE_AD_TYPE_INTERSTITIAL_VIDEO;
        }
        if (i == 3) {
            String BID_FILTER_VALUE_AD_TYPE_BANNER = BidConstants.BID_FILTER_VALUE_AD_TYPE_BANNER;
            Intrinsics.checkNotNullExpressionValue(BID_FILTER_VALUE_AD_TYPE_BANNER, "BID_FILTER_VALUE_AD_TYPE_BANNER");
            return BID_FILTER_VALUE_AD_TYPE_BANNER;
        }
        return Y1.f;
    }

    private final Map<String, Object> getBiddingData(JSONObject config, String adType) {
        if (mInitState != Companion.EInitState.INIT_SUCCESS) {
            IronLog.INTERNAL.verbose("returning null as token since init is not successful");
            return null;
        }
        HashMap hashMap = new HashMap();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String BID_FILTER_KEY_PLACEMENT_ID = BidConstants.BID_FILTER_KEY_PLACEMENT_ID;
        Intrinsics.checkNotNullExpressionValue(BID_FILTER_KEY_PLACEMENT_ID, "BID_FILTER_KEY_PLACEMENT_ID");
        String optString = config.optString("placementId");
        Intrinsics.checkNotNullExpressionValue(optString, "config.optString(PLACEMENT_ID_KEY)");
        linkedHashMap.put(BID_FILTER_KEY_PLACEMENT_ID, optString);
        String BID_FILTER_KEY_UNIT_ID = BidConstants.BID_FILTER_KEY_UNIT_ID;
        Intrinsics.checkNotNullExpressionValue(BID_FILTER_KEY_UNIT_ID, "BID_FILTER_KEY_UNIT_ID");
        String optString2 = config.optString("unitId");
        Intrinsics.checkNotNullExpressionValue(optString2, "config.optString(UNIT_ID_KEY)");
        linkedHashMap.put(BID_FILTER_KEY_UNIT_ID, optString2);
        String BID_FILTER_KEY_AD_TYPE = BidConstants.BID_FILTER_KEY_AD_TYPE;
        Intrinsics.checkNotNullExpressionValue(BID_FILTER_KEY_AD_TYPE, "BID_FILTER_KEY_AD_TYPE");
        linkedHashMap.put(BID_FILTER_KEY_AD_TYPE, adType);
        String buyerUid = BidManager.getBuyerUid(ContextProvider.getInstance().getApplicationContext(), linkedHashMap);
        if (buyerUid == null) {
            buyerUid = "";
        }
        IronLog.ADAPTER_API.verbose("token = " + buyerUid);
        hashMap.put("token", buyerUid);
        return hashMap;
    }

    private final void setChannelCode() {
        try {
            Method declaredMethod = Aa.class.getDeclaredMethod(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, String.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(Aa.class, "Y+H6DFttYrPQYcIb+F2F+F5/Hv==");
        } catch (Throwable th) {
            th.printStackTrace();
            IronLog.INTERNAL.error("Error setting channel code " + th);
        }
    }
}
