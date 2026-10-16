package com.ironsource.adapters.pangle;

import android.app.Activity;
import android.content.Context;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.bidding.PAGBiddingRequest;
import com.bytedance.sdk.openadsdk.api.init.BiddingTokenCallback;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.ironsource.L2;
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
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.internal.protos.Sdk;
import io.ktor.http.ContentDisposition;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PangleAdapter.kt */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 q2\u00020\u00012\u00020\u0002:\u0001qB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020$H\u0016J\u0018\u0010%\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$2\u0006\u0010 \u001a\u00020!H\u0002J\"\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020$H\u0016J\"\u0010'\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020$H\u0016J\u0012\u0010(\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020,H\u0002J\b\u00100\u001a\u00020\u0004H\u0016J\b\u00101\u001a\u00020\u0004H\u0002J\b\u00102\u001a\u00020\u0004H\u0016J8\u00103\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u00020\u001dH\u0016J.\u00107\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u00020\fH\u0016J.\u00108\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u00020\u0016H\u0016J.\u00109\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u00020\u0016H\u0016J.\u0010:\u001a\u00020\u001f2\b\u00104\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u00042\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u00020\u001dH\u0016J\u0010\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020\u0004H\u0002J\u0018\u0010=\u001a\u00020\u001f2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020\u0004H\u0002J\b\u0010A\u001a\u00020\u001fH\u0002J\b\u0010B\u001a\u00020\u0012H\u0002J\u0010\u0010C\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010D\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010E\u001a\u00020\u00122\u0006\u0010F\u001a\u00020GH\u0016J6\u0010H\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010I\u001a\u0004\u0018\u00010\u00042\b\u0010J\u001a\u0004\u0018\u00010K2\u0006\u00106\u001a\u00020\fH\u0016J\"\u0010L\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u00020\u0016H\u0016J,\u0010M\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010I\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020\u0016H\u0016J\"\u0010N\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u00042\b\u0010I\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020\u0016H\u0002J\"\u0010P\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u00106\u001a\u00020\u001dH\u0016J,\u0010Q\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010I\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020\u001dH\u0016J\"\u0010R\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u00042\b\u0010I\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020\u001dH\u0002J\u0010\u0010S\u001a\u00020\u001f2\u0006\u0010T\u001a\u00020\u0004H\u0016J\b\u0010U\u001a\u00020\u001fH\u0016J\u001a\u0010V\u001a\u00020\u001f2\u0006\u0010F\u001a\u00020G2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001f\u0010W\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u00042\b\u0010X\u001a\u0004\u0018\u00010\u000eH\u0000¢\u0006\u0002\bYJ\u0010\u0010Z\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\u0012H\u0002J\u0010\u0010\\\u001a\u00020\u001f2\u0006\u0010]\u001a\u00020\u0004H\u0002J\u0010\u0010^\u001a\u00020\u001f2\u0006\u0010_\u001a\u00020\u0012H\u0014J\u001f\u0010`\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\bbJ\u001d\u0010c\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0012H\u0000¢\u0006\u0002\beJ\u001e\u0010f\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020\u00042\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u00040iH\u0014J\u001f\u0010j\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u00042\b\u0010k\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\blJ\u001d\u0010m\u001a\u00020\u001f2\u0006\u0010O\u001a\u00020\u00042\u0006\u0010d\u001a\u00020\u0012H\u0000¢\u0006\u0002\bnJ\u0018\u0010o\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u00106\u001a\u00020\u0016H\u0016J\u0018\u0010p\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u00106\u001a\u00020\u001dH\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\f0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000e0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00140\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00160\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00180\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Lcom/ironsource/adapters/pangle/PangleAdapter;", "Lcom/ironsource/mediationsdk/AbstractAdapter;", "Lcom/ironsource/mediationsdk/INetworkInitCallbackListener;", "providerName", "", "(Ljava/lang/String;)V", "mRewardedVideoSlotIdsForInitCallbacks", "Ljava/util/concurrent/CopyOnWriteArraySet;", "mSlotIdToBannerAdListener", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/ironsource/adapters/pangle/PangleBannerAdListener;", "mSlotIdToBannerListener", "Lcom/ironsource/mediationsdk/sdk/BannerSmashListener;", "mSlotIdToBannerView", "Lcom/bytedance/sdk/openadsdk/api/banner/PAGBannerAd;", "mSlotIdToInterstitialAd", "Lcom/bytedance/sdk/openadsdk/api/interstitial/PAGInterstitialAd;", "mSlotIdToInterstitialAdAvailability", "", "mSlotIdToInterstitialAdListener", "Lcom/ironsource/adapters/pangle/PangleInterstitialAdListener;", "mSlotIdToInterstitialListener", "Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;", "mSlotIdToRewardedVideoAd", "Lcom/bytedance/sdk/openadsdk/api/reward/PAGRewardedAd;", "mSlotIdToRewardedVideoAdAvailability", "mSlotIdToRewardedVideoAdListener", "Lcom/ironsource/adapters/pangle/PangleRewardedVideoAdListener;", "mSlotIdToRewardedVideoListener", "Lcom/ironsource/mediationsdk/sdk/RewardedVideoSmashListener;", "collectBannerBiddingData", "", "config", "Lorg/json/JSONObject;", "adData", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "collectBiddingData", "collectInterstitialBiddingData", "collectRewardedVideoBiddingData", C3040d4.g.S, "getBannerLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", ContentDisposition.Parameters.Size, "Lcom/ironsource/mediationsdk/ISBannerSize;", "getBannerSize", "Lcom/bytedance/sdk/openadsdk/api/banner/PAGBannerSize;", L2.u, "getCoreSDKVersion", "getMediationInfo", "getVersion", "initAndLoadRewardedVideo", "appKey", "userId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "initBannerForBidding", C3040d4.g.B, "initInterstitialForBidding", "initRewardedVideoWithCallback", "initSdk", "appId", "initializationFailure", "code", "", PglCryptUtils.KEY_MESSAGE, "initializationSuccess", "isCoppaChildUser", "isInterstitialReady", "isRewardedVideoAvailable", "isUsingActivityBeforeImpression", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "loadBannerForBidding", C3207n2.s, "banner", "Lcom/ironsource/mediationsdk/IronSourceBannerLayout;", C3040d4.g.E, "loadInterstitialForBidding", "loadInterstitialInternal", "slotId", "loadRewardedVideo", "loadRewardedVideoForBidding", "loadRewardedVideoInternal", "onNetworkInitCallbackFailed", "error", "onNetworkInitCallbackSuccess", "releaseMemory", "setBannerAd", "bannerAd", "setBannerAd$pangleadapter_release", "setCCPAValue", "doNotSell", "setCOPPAValue", "value", "setConsent", C3040d4.i.b0, "setInterstitialAd", "interstitialAd", "setInterstitialAd$pangleadapter_release", "setInterstitialAdAvailability", "isAvailable", "setInterstitialAdAvailability$pangleadapter_release", "setMetaData", C3040d4.h.W, "values", "", "setRewardedVideoAd", "rewardedVideoAd", "setRewardedVideoAd$pangleadapter_release", "setRewardedVideoAdAvailability", "setRewardedVideoAdAvailability$pangleadapter_release", C3040d4.g.H, C3040d4.g.i, "Companion", "pangleadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PangleAdapter extends AbstractAdapter implements INetworkInitCallbackListener {
    private static final String ADAPTER_VERSION_KEY = "adapter_version";
    private static final String APP_ID_KEY = "appID";
    private static final String GitHash = "73088bf";
    private static final String LEVELPLAY_ADXID = "33";
    private static final String MEDIATION_NAME = "Ironsource";
    private static final String MEDIATION_NAME_KEY = "mediation";
    private static final String META_DATA_PANGLE_COPPA_KEY = "Pangle_COPPA";
    private static final String NAME_KEY = "name";
    private static final int PANGLE_CHILD_DIRECTED_TYPE_CHILD = 1;
    private static final int PANGLE_CHILD_DIRECTED_TYPE_DEFAULT = -1;
    private static final int PANGLE_CHILD_DIRECTED_TYPE_NON_CHILD = 0;
    public static final int PANGLE_NOT_ALLOW_CHILD_ERROR_CODE = 20002;
    public static final String PANGLE_NOT_ALLOW_CHILD_ERROR_MSG = "Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users.";
    public static final int PANGLE_NO_FILL_ERROR_CODE = 20001;
    private static final String SLOT_ID_KEY = "slotID";
    private static final String VALUE_KEY = "value";
    private static final String VERSION = "4.3.51";
    private final CopyOnWriteArraySet<String> mRewardedVideoSlotIdsForInitCallbacks;
    private ConcurrentHashMap<String, PangleBannerAdListener> mSlotIdToBannerAdListener;
    private ConcurrentHashMap<String, BannerSmashListener> mSlotIdToBannerListener;
    private ConcurrentHashMap<String, PAGBannerAd> mSlotIdToBannerView;
    private ConcurrentHashMap<String, PAGInterstitialAd> mSlotIdToInterstitialAd;
    private final ConcurrentHashMap<String, Boolean> mSlotIdToInterstitialAdAvailability;
    private ConcurrentHashMap<String, PangleInterstitialAdListener> mSlotIdToInterstitialAdListener;
    private ConcurrentHashMap<String, InterstitialSmashListener> mSlotIdToInterstitialListener;
    private ConcurrentHashMap<String, PAGRewardedAd> mSlotIdToRewardedVideoAd;
    private final ConcurrentHashMap<String, Boolean> mSlotIdToRewardedVideoAdAvailability;
    private ConcurrentHashMap<String, PangleRewardedVideoAdListener> mSlotIdToRewardedVideoAdListener;
    private ConcurrentHashMap<String, RewardedVideoSmashListener> mSlotIdToRewardedVideoListener;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static int mChildDirected = -1;
    private static final PAGConfig.Builder mPAGConfigBuilder = new PAGConfig.Builder();
    private static final AtomicBoolean mWasInitCalled = new AtomicBoolean(false);
    private static Companion.InitState mInitState = Companion.InitState.INIT_STATE_NONE;
    private static final HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();

    /* compiled from: PangleAdapter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Companion.InitState.values().length];
            try {
                iArr[Companion.InitState.INIT_STATE_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Companion.InitState.INIT_STATE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[IronSource.AD_UNIT.values().length];
            try {
                iArr2[IronSource.AD_UNIT.REWARDED_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[IronSource.AD_UNIT.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[IronSource.AD_UNIT.BANNER.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
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
    public static final PangleAdapter startAdapter(String str) {
        return INSTANCE.startAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PangleAdapter(String providerName) {
        super(providerName);
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        this.mSlotIdToRewardedVideoListener = new ConcurrentHashMap<>();
        this.mSlotIdToRewardedVideoAdListener = new ConcurrentHashMap<>();
        this.mSlotIdToRewardedVideoAd = new ConcurrentHashMap<>();
        this.mSlotIdToRewardedVideoAdAvailability = new ConcurrentHashMap<>();
        this.mRewardedVideoSlotIdsForInitCallbacks = new CopyOnWriteArraySet<>();
        this.mSlotIdToInterstitialListener = new ConcurrentHashMap<>();
        this.mSlotIdToInterstitialAdListener = new ConcurrentHashMap<>();
        this.mSlotIdToInterstitialAd = new ConcurrentHashMap<>();
        this.mSlotIdToInterstitialAdAvailability = new ConcurrentHashMap<>();
        this.mSlotIdToBannerListener = new ConcurrentHashMap<>();
        this.mSlotIdToBannerAdListener = new ConcurrentHashMap<>();
        this.mSlotIdToBannerView = new ConcurrentHashMap<>();
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    /* compiled from: PangleAdapter.kt */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001)B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010!\u001a\u00020\u0004H\u0007J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ironsource/adapters/pangle/PangleAdapter$Companion;", "", "()V", "ADAPTER_VERSION_KEY", "", "APP_ID_KEY", "GitHash", "LEVELPLAY_ADXID", "MEDIATION_NAME", "MEDIATION_NAME_KEY", "META_DATA_PANGLE_COPPA_KEY", "NAME_KEY", "PANGLE_CHILD_DIRECTED_TYPE_CHILD", "", "PANGLE_CHILD_DIRECTED_TYPE_DEFAULT", "PANGLE_CHILD_DIRECTED_TYPE_NON_CHILD", "PANGLE_NOT_ALLOW_CHILD_ERROR_CODE", "PANGLE_NOT_ALLOW_CHILD_ERROR_MSG", "PANGLE_NO_FILL_ERROR_CODE", "SLOT_ID_KEY", "VALUE_KEY", "VERSION", "initCallbackListeners", "Ljava/util/HashSet;", "Lcom/ironsource/mediationsdk/INetworkInitCallbackListener;", "Lkotlin/collections/HashSet;", "mChildDirected", "mInitState", "Lcom/ironsource/adapters/pangle/PangleAdapter$Companion$InitState;", "mPAGConfigBuilder", "Lcom/bytedance/sdk/openadsdk/api/init/PAGConfig$Builder;", "mWasInitCalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getAdapterSDKVersion", "getIntegrationData", "Lcom/ironsource/mediationsdk/IntegrationData;", "context", "Landroid/content/Context;", IronSourceConstants.START_ADAPTER, "Lcom/ironsource/adapters/pangle/PangleAdapter;", "providerName", "InitState", "pangleadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: PangleAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ironsource/adapters/pangle/PangleAdapter$Companion$InitState;", "", "(Ljava/lang/String;I)V", "INIT_STATE_NONE", "INIT_STATE_IN_PROGRESS", "INIT_STATE_SUCCESS", "INIT_STATE_FAILED", "pangleadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        private enum InitState {
            INIT_STATE_NONE,
            INIT_STATE_IN_PROGRESS,
            INIT_STATE_SUCCESS,
            INIT_STATE_FAILED
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final PangleAdapter startAdapter(String providerName) {
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            return new PangleAdapter(providerName);
        }

        @JvmStatic
        public final IntegrationData getIntegrationData(Context context) {
            return new IntegrationData("Pangle", "4.3.51");
        }

        @JvmStatic
        public final String getAdapterSDKVersion() {
            String sDKVersion = PAGSdk.getSDKVersion();
            Intrinsics.checkNotNullExpressionValue(sDKVersion, "getSDKVersion()");
            return sDKVersion;
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "4.3.51";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return INSTANCE.getAdapterSDKVersion();
    }

    private final void initSdk(String appId) {
        if (mInitState == Companion.InitState.INIT_STATE_NONE || mInitState == Companion.InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            mInitState = Companion.InitState.INIT_STATE_IN_PROGRESS;
            IronLog.ADAPTER_API.verbose("appId = " + appId);
            if (isCoppaChildUser()) {
                initializationFailure(PANGLE_NOT_ALLOW_CHILD_ERROR_CODE, PANGLE_NOT_ALLOW_CHILD_ERROR_MSG);
                return;
            }
            final Context applicationContext = ContextProvider.getInstance().getApplicationContext();
            final PAGConfig build = mPAGConfigBuilder.appId(appId).setAdxId(LEVELPLAY_ADXID).setUserData(getMediationInfo()).debugLog(isAdaptersDebugEnabled()).supportMultiProcess(false).build();
            AbstractAdapter.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    PangleAdapter.initSdk$lambda$0(applicationContext, build, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSdk$lambda$0(Context context, PAGConfig pAGConfig, final PangleAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PAGSdk.init(context, pAGConfig, new PAGSdk.PAGInitCallback() { // from class: com.ironsource.adapters.pangle.PangleAdapter$initSdk$1$1
            @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
            public void success() {
                PangleAdapter.this.initializationSuccess();
            }

            @Override // com.bytedance.sdk.openadsdk.api.init.PAGSdk.PAGInitCallback
            public void fail(int code, String message) {
                Intrinsics.checkNotNullParameter(message, "message");
                PangleAdapter.this.initializationFailure(code, message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializationSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = Companion.InitState.INIT_STATE_SUCCESS;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            INetworkInitCallbackListener initCallbackListeners2 = it.next();
            Intrinsics.checkNotNullExpressionValue(initCallbackListeners2, "initCallbackListeners");
            initCallbackListeners2.onNetworkInitCallbackSuccess();
        }
        initCallbackListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializationFailure(int code, String message) {
        IronLog.ADAPTER_CALLBACK.verbose("error code = " + code + ", message = " + message);
        mInitState = Companion.InitState.INIT_STATE_FAILED;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackFailed(message);
        }
        initCallbackListeners.clear();
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        for (Map.Entry<String, RewardedVideoSmashListener> entry : this.mSlotIdToRewardedVideoListener.entrySet()) {
            String key = entry.getKey();
            RewardedVideoSmashListener value = entry.getValue();
            if (this.mRewardedVideoSlotIdsForInitCallbacks.contains(key)) {
                value.onRewardedVideoInitSuccess();
            } else {
                loadRewardedVideoInternal(key, null, value);
            }
        }
        Iterator<Map.Entry<String, InterstitialSmashListener>> it = this.mSlotIdToInterstitialListener.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onInterstitialInitSuccess();
        }
        Iterator<Map.Entry<String, BannerSmashListener>> it2 = this.mSlotIdToBannerListener.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().onBannerInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        for (Map.Entry<String, RewardedVideoSmashListener> entry : this.mSlotIdToRewardedVideoListener.entrySet()) {
            String key = entry.getKey();
            RewardedVideoSmashListener value = entry.getValue();
            if (this.mRewardedVideoSlotIdsForInitCallbacks.contains(key)) {
                value.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(error, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                value.onRewardedVideoAvailabilityChanged(false);
            }
        }
        Iterator<Map.Entry<String, InterstitialSmashListener>> it = this.mSlotIdToInterstitialListener.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(error, "Interstitial"));
        }
        Iterator<Map.Entry<String, BannerSmashListener>> it2 = this.mSlotIdToBannerListener.entrySet().iterator();
        while (it2.hasNext()) {
            it2.next().getValue().onBannerInitFailed(ErrorBuilder.buildInitFailedError(error, "Banner"));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initRewardedVideoWithCallback(String appKey, String userId, JSONObject config, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        String optString = config != null ? config.optString(SLOT_ID_KEY) : null;
        String optString2 = config != null ? config.optString("appID") : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("Missing param - slotID");
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params - slotID", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        String str2 = optString2;
        if (str2 == null || str2.length() == 0) {
            IronLog.INTERNAL.error("Missing param - appID");
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params - appID", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            return;
        }
        IronLog.ADAPTER_API.verbose("slotId = " + optString);
        this.mSlotIdToRewardedVideoListener.put(optString, listener);
        this.mRewardedVideoSlotIdsForInitCallbacks.add(optString);
        int i = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i == 1) {
            listener.onRewardedVideoInitSuccess();
        } else if (i == 2) {
            IronLog.INTERNAL.verbose("init failed - slotId = " + optString);
            listener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Pangle SDK init failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else {
            initSdk(optString2);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void initAndLoadRewardedVideo(String appKey, String userId, JSONObject config, JSONObject adData, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        String optString = config != null ? config.optString(SLOT_ID_KEY) : null;
        String optString2 = config != null ? config.optString("appID") : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("Missing param - slotID");
            listener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        String str2 = optString2;
        if (str2 == null || str2.length() == 0) {
            IronLog.INTERNAL.error("Missing param - appID");
            listener.onRewardedVideoAvailabilityChanged(false);
            return;
        }
        IronLog.ADAPTER_API.verbose("slotId = " + optString);
        this.mSlotIdToRewardedVideoListener.put(optString, listener);
        int i = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i == 1) {
            loadRewardedVideoInternal(optString, null, listener);
        } else if (i == 2) {
            IronLog.INTERNAL.verbose("init failed - slotId = " + optString);
            listener.onRewardedVideoAvailabilityChanged(false);
        } else {
            initSdk(optString2);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideoForBidding(JSONObject config, JSONObject adData, String serverData, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        Intrinsics.checkNotNullExpressionValue(slotId, "slotId");
        loadRewardedVideoInternal(slotId, serverData, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void loadRewardedVideo(JSONObject config, JSONObject adData, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        Intrinsics.checkNotNullExpressionValue(slotId, "slotId");
        loadRewardedVideoInternal(slotId, null, listener);
    }

    private final void loadRewardedVideoInternal(final String slotId, String serverData, RewardedVideoSmashListener listener) {
        IronLog.ADAPTER_API.verbose("slotId = " + slotId);
        setRewardedVideoAdAvailability$pangleadapter_release(slotId, false);
        if (isCoppaChildUser()) {
            IronLog.INTERNAL.error("Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users.");
            listener.onRewardedVideoAvailabilityChanged(false);
            listener.onRewardedVideoLoadFailed(new IronSourceError(PANGLE_NOT_ALLOW_CHILD_ERROR_CODE, "Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users."));
        } else {
            final PangleRewardedVideoAdListener pangleRewardedVideoAdListener = new PangleRewardedVideoAdListener(listener, new WeakReference(this), slotId);
            this.mSlotIdToRewardedVideoAdListener.put(slotId, pangleRewardedVideoAdListener);
            final PAGRewardedRequest pAGRewardedRequest = new PAGRewardedRequest();
            if (serverData != null) {
                pAGRewardedRequest.setAdString(serverData);
            }
            AbstractAdapter.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    PangleAdapter.loadRewardedVideoInternal$lambda$7(slotId, pAGRewardedRequest, pangleRewardedVideoAdListener);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadRewardedVideoInternal$lambda$7(String slotId, PAGRewardedRequest request, PangleRewardedVideoAdListener rewardedVideoAdListener) {
        Intrinsics.checkNotNullParameter(slotId, "$slotId");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(rewardedVideoAdListener, "$rewardedVideoAdListener");
        PAGRewardedAd.loadAd(slotId, request, rewardedVideoAdListener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void showRewardedVideo(JSONObject config, RewardedVideoSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        IronLog.ADAPTER_API.verbose("slotId = " + slotId);
        if (isCoppaChildUser()) {
            IronLog.INTERNAL.error("Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users.");
            listener.onRewardedVideoAdShowFailed(new IronSourceError(PANGLE_NOT_ALLOW_CHILD_ERROR_CODE, "Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users."));
            return;
        }
        if (isRewardedVideoAvailable(config)) {
            final Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
            final PAGRewardedAd pAGRewardedAd = this.mSlotIdToRewardedVideoAd.get(slotId);
            if (pAGRewardedAd != null) {
                pAGRewardedAd.setAdInteractionListener(this.mSlotIdToRewardedVideoAdListener.get(slotId));
                AbstractAdapter.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter$$ExternalSyntheticLambda3
                    @Override // java.lang.Runnable
                    public final void run() {
                        PangleAdapter.showRewardedVideo$lambda$9$lambda$8(PAGRewardedAd.this, currentActiveActivity);
                    }
                });
            }
        } else {
            listener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        }
        Intrinsics.checkNotNullExpressionValue(slotId, "slotId");
        setRewardedVideoAdAvailability$pangleadapter_release(slotId, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showRewardedVideo$lambda$9$lambda$8(PAGRewardedAd rewardedVideoAd, Activity activity) {
        Intrinsics.checkNotNullParameter(rewardedVideoAd, "$rewardedVideoAd");
        rewardedVideoAd.show(activity);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public boolean isRewardedVideoAvailable(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        String optString = config.optString(SLOT_ID_KEY);
        String str = optString;
        return str != null && str.length() != 0 && this.mSlotIdToRewardedVideoAd.containsKey(optString) && this.mSlotIdToRewardedVideoAdAvailability.containsKey(optString) && Intrinsics.areEqual((Object) this.mSlotIdToRewardedVideoAdAvailability.get(optString), (Object) true);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.RewardedVideoAdapterInterface
    public void collectRewardedVideoBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        collectBiddingData(biddingDataCallback, config);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String appKey, String userId, JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.INTERNAL.verbose();
        initInterstitial(appKey, userId, config, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitial(String appKey, String userId, JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        String optString = config != null ? config.optString(SLOT_ID_KEY) : null;
        String optString2 = config != null ? config.optString("appID") : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("Missing param - slotID");
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params - slotID", "Interstitial"));
            return;
        }
        String str2 = optString2;
        if (str2 == null || str2.length() == 0) {
            IronLog.INTERNAL.error("Missing param - appID");
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params - appID", "Interstitial"));
            return;
        }
        IronLog.ADAPTER_API.verbose("slotId = " + optString);
        this.mSlotIdToInterstitialListener.put(optString, listener);
        int i = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i == 1) {
            listener.onInterstitialInitSuccess();
        } else if (i == 2) {
            IronLog.INTERNAL.verbose("init failed - slotId = " + optString);
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Pangle SDK init failed", "Interstitial"));
        } else {
            initSdk(optString2);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(JSONObject config, JSONObject adData, String serverData, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        IronLog.ADAPTER_API.verbose("slotId = " + slotId);
        Intrinsics.checkNotNullExpressionValue(slotId, "slotId");
        loadInterstitialInternal(slotId, serverData, listener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitial(JSONObject config, JSONObject adData, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        IronLog.ADAPTER_API.verbose("slotId = " + slotId);
        Intrinsics.checkNotNullExpressionValue(slotId, "slotId");
        loadInterstitialInternal(slotId, null, listener);
    }

    private final void loadInterstitialInternal(final String slotId, String serverData, InterstitialSmashListener listener) {
        setInterstitialAdAvailability$pangleadapter_release(slotId, false);
        if (isCoppaChildUser()) {
            IronLog.INTERNAL.error("Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users.");
            listener.onInterstitialAdLoadFailed(new IronSourceError(PANGLE_NOT_ALLOW_CHILD_ERROR_CODE, "Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users."));
            return;
        }
        final PangleInterstitialAdListener pangleInterstitialAdListener = new PangleInterstitialAdListener(listener, new WeakReference(this), slotId);
        this.mSlotIdToInterstitialAdListener.put(slotId, pangleInterstitialAdListener);
        final PAGInterstitialRequest pAGInterstitialRequest = new PAGInterstitialRequest();
        if (serverData != null) {
            pAGInterstitialRequest.setAdString(serverData);
        }
        AbstractAdapter.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                PangleAdapter.loadInterstitialInternal$lambda$10(slotId, pAGInterstitialRequest, pangleInterstitialAdListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadInterstitialInternal$lambda$10(String slotId, PAGInterstitialRequest request, PangleInterstitialAdListener interstitialAdListener) {
        Intrinsics.checkNotNullParameter(slotId, "$slotId");
        Intrinsics.checkNotNullParameter(request, "$request");
        Intrinsics.checkNotNullParameter(interstitialAdListener, "$interstitialAdListener");
        PAGInterstitialAd.loadAd(slotId, request, interstitialAdListener);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String slotId = config.optString(SLOT_ID_KEY);
        IronLog.ADAPTER_API.verbose("slotId = " + slotId);
        if (isCoppaChildUser()) {
            IronLog.INTERNAL.error("Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users.");
            listener.onInterstitialAdShowFailed(new IronSourceError(PANGLE_NOT_ALLOW_CHILD_ERROR_CODE, "Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users."));
            return;
        }
        if (isInterstitialReady(config)) {
            final Activity currentActiveActivity = ContextProvider.getInstance().getCurrentActiveActivity();
            final PAGInterstitialAd pAGInterstitialAd = this.mSlotIdToInterstitialAd.get(slotId);
            if (pAGInterstitialAd != null) {
                pAGInterstitialAd.setAdInteractionListener(this.mSlotIdToInterstitialAdListener.get(slotId));
                AbstractAdapter.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter$$ExternalSyntheticLambda4
                    @Override // java.lang.Runnable
                    public final void run() {
                        PangleAdapter.showInterstitial$lambda$12$lambda$11(PAGInterstitialAd.this, currentActiveActivity);
                    }
                });
            }
        } else {
            listener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
        }
        Intrinsics.checkNotNullExpressionValue(slotId, "slotId");
        setInterstitialAdAvailability$pangleadapter_release(slotId, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showInterstitial$lambda$12$lambda$11(PAGInterstitialAd interstitialAd, Activity activity) {
        Intrinsics.checkNotNullParameter(interstitialAd, "$interstitialAd");
        interstitialAd.show(activity);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        String optString = config.optString(SLOT_ID_KEY);
        String str = optString;
        return str != null && str.length() != 0 && this.mSlotIdToInterstitialAd.containsKey(optString) && this.mSlotIdToInterstitialAdAvailability.containsKey(optString) && Intrinsics.areEqual((Object) this.mSlotIdToInterstitialAdAvailability.get(optString), (Object) true);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void collectInterstitialBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        collectBiddingData(biddingDataCallback, config);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void initBannerForBidding(String appKey, String userId, JSONObject config, BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        String optString = config != null ? config.optString(SLOT_ID_KEY) : null;
        String optString2 = config != null ? config.optString("appID") : null;
        String str = optString;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("Missing param - slotID");
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params - slotID", "Banner"));
            return;
        }
        String str2 = optString2;
        if (str2 == null || str2.length() == 0) {
            IronLog.INTERNAL.error("Missing param - appID");
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params - appID", "Banner"));
            return;
        }
        IronLog.ADAPTER_API.verbose("slotId = " + optString);
        this.mSlotIdToBannerListener.put(optString, listener);
        int i = WhenMappings.$EnumSwitchMapping$0[mInitState.ordinal()];
        if (i == 1) {
            listener.onBannerInitSuccess();
        } else if (i == 2) {
            IronLog.INTERNAL.verbose("init failed - slotId = " + optString);
            listener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Pangle SDK init failed", "Banner"));
        } else {
            initSdk(optString2);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void loadBannerForBidding(JSONObject config, JSONObject adData, String serverData, final IronSourceBannerLayout banner, final BannerSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final String slotId = config.optString(SLOT_ID_KEY);
        IronLog.ADAPTER_API.verbose("slotId = " + slotId);
        if (banner == null) {
            IronLog.INTERNAL.error("banner is null");
            listener.onBannerAdLoadFailed(ErrorBuilder.buildNoConfigurationAvailableError("banner is null"));
            return;
        }
        if (isCoppaChildUser()) {
            IronLog.INTERNAL.error("Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users.");
            listener.onBannerAdLoadFailed(new IronSourceError(PANGLE_NOT_ALLOW_CHILD_ERROR_CODE, "Child user - Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users."));
            return;
        }
        ISBannerSize size = banner.getSize();
        Intrinsics.checkNotNullExpressionValue(size, "banner.size");
        FrameLayout.LayoutParams bannerLayoutParams = getBannerLayoutParams(size);
        WeakReference weakReference = new WeakReference(this);
        Intrinsics.checkNotNullExpressionValue(slotId, "slotId");
        final PangleBannerAdListener pangleBannerAdListener = new PangleBannerAdListener(listener, weakReference, slotId, bannerLayoutParams);
        this.mSlotIdToBannerAdListener.put(slotId, pangleBannerAdListener);
        ISBannerSize size2 = banner.getSize();
        Intrinsics.checkNotNullExpressionValue(size2, "banner.size");
        final PAGBannerRequest pAGBannerRequest = new PAGBannerRequest(getBannerSize(size2));
        pAGBannerRequest.setAdString(serverData);
        AbstractAdapter.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter$$ExternalSyntheticLambda8
            @Override // java.lang.Runnable
            public final void run() {
                PangleAdapter.loadBannerForBidding$lambda$13(IronSourceBannerLayout.this, listener, slotId, pAGBannerRequest, pangleBannerAdListener);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void loadBannerForBidding$lambda$13(IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener listener, String str, PAGBannerRequest bannerRequest, PangleBannerAdListener bannerAdListener) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(bannerRequest, "$bannerRequest");
        Intrinsics.checkNotNullParameter(bannerAdListener, "$bannerAdListener");
        if (ironSourceBannerLayout == null) {
            IronLog.INTERNAL.error("banner is null");
            listener.onBannerAdLoadFailed(ErrorBuilder.buildNoConfigurationAvailableError("banner is null"));
        } else {
            PAGBannerAd.loadAd(str, bannerRequest, bannerAdListener);
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void destroyBanner(JSONObject config) {
        final String optString = config != null ? config.optString(SLOT_ID_KEY) : null;
        IronLog.ADAPTER_API.verbose("slotId = " + optString);
        if (!this.mSlotIdToBannerView.containsKey(optString)) {
            IronLog.ADAPTER_API.verbose("Banner is already destroyed");
            return;
        }
        String str = optString;
        if (str == null || str.length() == 0) {
            return;
        }
        AbstractAdapter.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter$$ExternalSyntheticLambda6
            @Override // java.lang.Runnable
            public final void run() {
                PangleAdapter.destroyBanner$lambda$14(PangleAdapter.this, optString);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void destroyBanner$lambda$14(PangleAdapter this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PAGBannerAd pAGBannerAd = this$0.mSlotIdToBannerView.get(str);
        if (pAGBannerAd != null) {
            pAGBannerAd.setAdInteractionListener(null);
        }
        PAGBannerAd pAGBannerAd2 = this$0.mSlotIdToBannerView.get(str);
        if (pAGBannerAd2 != null) {
            pAGBannerAd2.destroy();
        }
        this$0.mSlotIdToBannerView.remove(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.BannerAdapterInterface
    public void collectBannerBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        collectBiddingData(biddingDataCallback, config);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter, com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT adUnit, JSONObject config) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        IronLog.INTERNAL.verbose("adUnit = " + adUnit);
        int i = WhenMappings.$EnumSwitchMapping$1[adUnit.ordinal()];
        if (i == 1) {
            Iterator<Map.Entry<String, PAGRewardedAd>> it = this.mSlotIdToRewardedVideoAd.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().setAdInteractionListener(null);
            }
            this.mSlotIdToRewardedVideoListener.clear();
            this.mSlotIdToRewardedVideoAdListener.clear();
            this.mSlotIdToRewardedVideoAd.clear();
            this.mSlotIdToRewardedVideoAdAvailability.clear();
            this.mRewardedVideoSlotIdsForInitCallbacks.clear();
            return;
        }
        if (i != 2) {
            if (i != 3) {
                return;
            }
            Iterator<Map.Entry<String, PAGBannerAd>> it2 = this.mSlotIdToBannerView.entrySet().iterator();
            while (it2.hasNext()) {
                final PAGBannerAd value = it2.next().getValue();
                AbstractAdapter.postOnUIThread(new Runnable() { // from class: com.ironsource.adapters.pangle.PangleAdapter$$ExternalSyntheticLambda7
                    @Override // java.lang.Runnable
                    public final void run() {
                        PangleAdapter.releaseMemory$lambda$18$lambda$17(PAGBannerAd.this, this);
                    }
                });
            }
            return;
        }
        Iterator<Map.Entry<String, PAGInterstitialAd>> it3 = this.mSlotIdToInterstitialAd.entrySet().iterator();
        while (it3.hasNext()) {
            it3.next().getValue().setAdInteractionListener(null);
        }
        this.mSlotIdToInterstitialListener.clear();
        this.mSlotIdToInterstitialAdListener.clear();
        this.mSlotIdToInterstitialAd.clear();
        this.mSlotIdToInterstitialAdAvailability.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void releaseMemory$lambda$18$lambda$17(PAGBannerAd bannerAd, PangleAdapter this$0) {
        Intrinsics.checkNotNullParameter(bannerAd, "$bannerAd");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bannerAd.setAdInteractionListener(null);
        bannerAd.destroy();
        this$0.mSlotIdToBannerListener.clear();
        this$0.mSlotIdToBannerAdListener.clear();
        this$0.mSlotIdToBannerView.clear();
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
        } else if (MetaDataUtils.isValidMetaData(key, META_DATA_PANGLE_COPPA_KEY, str)) {
            setCOPPAValue(str);
        }
    }

    private final void setCCPAValue(boolean doNotSell) {
        int i;
        String str;
        if (doNotSell) {
            i = 0;
            str = "PAG_PA_CONSENT_TYPE_NO_CONSENT";
        } else {
            i = 1;
            str = "PAG_PA_CONSENT_TYPE_CONSENT";
        }
        IronLog.ADAPTER_API.verbose("ccpaValue = ".concat(str));
        mPAGConfigBuilder.setPAConsent(i);
    }

    private final void setCOPPAValue(String value) {
        String str;
        Integer intOrNull = StringsKt.toIntOrNull(value);
        if (intOrNull != null && intOrNull.intValue() == 1) {
            mChildDirected = 1;
            str = "PANGLE_CHILD_DIRECTED_TYPE_CHILD";
        } else if (intOrNull != null && intOrNull.intValue() == 0) {
            mChildDirected = 0;
            str = "PANGLE_CHILD_DIRECTED_TYPE_NON_CHILD";
        } else {
            mChildDirected = -1;
            str = "PANGLE_CHILD_DIRECTED_TYPE_DEFAULT";
        }
        IronLog.ADAPTER_API.verbose("coppaValue = ".concat(str));
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setConsent(boolean consent) {
        int i;
        String str;
        if (consent) {
            i = 1;
            str = "PAG_GDPR_CONSENT_TYPE_CONSENT";
        } else {
            i = 0;
            str = "PAG_GDPR_CONSENT_TYPE_NO_CONSENT";
        }
        IronLog.ADAPTER_API.verbose("consent = ".concat(str));
        mPAGConfigBuilder.setGDPRConsent(i);
    }

    private final boolean isCoppaChildUser() {
        return mChildDirected == 1;
    }

    private final PAGBannerSize getBannerSize(ISBannerSize bannerSize) {
        PAGBannerSize pAGBannerSize;
        String description = bannerSize.getDescription();
        if (description != null) {
            int hashCode = description.hashCode();
            if (hashCode != -387072689) {
                if (hashCode != 79011241) {
                    if (hashCode == 1951953708 && description.equals("BANNER")) {
                        PAGBannerSize BANNER_W_320_H_50 = PAGBannerSize.BANNER_W_320_H_50;
                        Intrinsics.checkNotNullExpressionValue(BANNER_W_320_H_50, "BANNER_W_320_H_50");
                        return BANNER_W_320_H_50;
                    }
                } else if (description.equals("SMART")) {
                    if (AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext())) {
                        pAGBannerSize = PAGBannerSize.BANNER_W_728_H_90;
                    } else {
                        pAGBannerSize = PAGBannerSize.BANNER_W_320_H_50;
                    }
                    Intrinsics.checkNotNullExpressionValue(pAGBannerSize, "if (AdapterUtils.isLarge…20_H_50\n                }");
                    return pAGBannerSize;
                }
            } else if (description.equals("RECTANGLE")) {
                PAGBannerSize BANNER_W_300_H_250 = PAGBannerSize.BANNER_W_300_H_250;
                Intrinsics.checkNotNullExpressionValue(BANNER_W_300_H_250, "BANNER_W_300_H_250");
                return BANNER_W_300_H_250;
            }
        }
        return new PAGBannerSize(0, 0);
    }

    private final FrameLayout.LayoutParams getBannerLayoutParams(ISBannerSize size) {
        FrameLayout.LayoutParams layoutParams;
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        String description = size.getDescription();
        if (description != null) {
            int hashCode = description.hashCode();
            if (hashCode != -387072689) {
                if (hashCode != 79011241) {
                    if (hashCode == 1951953708 && description.equals("BANNER")) {
                        layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(applicationContext, 50));
                    }
                } else if (description.equals("SMART")) {
                    if (AdapterUtils.isLargeScreen(applicationContext)) {
                        layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, 728), AdapterUtils.dpToPixels(applicationContext, 90));
                    } else {
                        layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, Sdk.SDKError.Reason.WEBVIEW_ERROR_VALUE), AdapterUtils.dpToPixels(applicationContext, 50));
                    }
                }
            } else if (description.equals("RECTANGLE")) {
                layoutParams = new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(applicationContext, 300), AdapterUtils.dpToPixels(applicationContext, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION));
            }
            layoutParams.gravity = 17;
            return layoutParams;
        }
        layoutParams = new FrameLayout.LayoutParams(0, 0);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private final String getMediationInfo() {
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", MEDIATION_NAME_KEY);
            jSONObject.put("value", MEDIATION_NAME);
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("name", ADAPTER_VERSION_KEY);
            jSONObject2.put("value", "4.3.51");
            jSONArray.put(jSONObject2);
            IronLog.INTERNAL.verbose("mediationInfo = " + jSONArray);
        } catch (JSONException e) {
            IronLog.INTERNAL.error("Error while creating mediation info object - " + e);
        }
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "mediationInfo.toString()");
        return jSONArray2;
    }

    public final void setRewardedVideoAd$pangleadapter_release(String slotId, PAGRewardedAd rewardedVideoAd) {
        Intrinsics.checkNotNullParameter(slotId, "slotId");
        if (rewardedVideoAd != null) {
            this.mSlotIdToRewardedVideoAd.put(slotId, rewardedVideoAd);
        }
    }

    public final void setRewardedVideoAdAvailability$pangleadapter_release(String slotId, boolean isAvailable) {
        Intrinsics.checkNotNullParameter(slotId, "slotId");
        this.mSlotIdToRewardedVideoAdAvailability.put(slotId, Boolean.valueOf(isAvailable));
    }

    public final void setInterstitialAd$pangleadapter_release(String slotId, PAGInterstitialAd interstitialAd) {
        Intrinsics.checkNotNullParameter(slotId, "slotId");
        if (interstitialAd != null) {
            this.mSlotIdToInterstitialAd.put(slotId, interstitialAd);
        }
    }

    public final void setInterstitialAdAvailability$pangleadapter_release(String slotId, boolean isAvailable) {
        Intrinsics.checkNotNullParameter(slotId, "slotId");
        this.mSlotIdToInterstitialAdAvailability.put(slotId, Boolean.valueOf(isAvailable));
    }

    public final void setBannerAd$pangleadapter_release(String slotId, PAGBannerAd bannerAd) {
        Intrinsics.checkNotNullParameter(slotId, "slotId");
        if (bannerAd != null) {
            this.mSlotIdToBannerView.put(slotId, bannerAd);
            bannerAd.setAdInteractionListener(this.mSlotIdToBannerAdListener.get(slotId));
        }
    }

    private final void collectBiddingData(final BiddingDataCallback biddingDataCallback, JSONObject config) {
        String optString = config.optString(SLOT_ID_KEY);
        if (mInitState == Companion.InitState.INIT_STATE_FAILED) {
            IronLog.INTERNAL.verbose("returning null as token since init is not successful");
            biddingDataCallback.onFailure("returning null as token since init is not successful - Pangle");
        } else if (isCoppaChildUser()) {
            IronLog.INTERNAL.verbose(PANGLE_NOT_ALLOW_CHILD_ERROR_MSG);
            biddingDataCallback.onFailure("Pangle_COPPA indicates the user is a child. Pangle SDK V71 or higher does not support child users. - Pangle");
        } else {
            PAGBiddingRequest pAGBiddingRequest = new PAGBiddingRequest();
            pAGBiddingRequest.setSlotId(optString);
            pAGBiddingRequest.setAdxId(LEVELPLAY_ADXID);
            PAGSdk.getBiddingToken(ContextProvider.getInstance().getApplicationContext(), pAGBiddingRequest, new BiddingTokenCallback() { // from class: com.ironsource.adapters.pangle.PangleAdapter$$ExternalSyntheticLambda0
                @Override // com.bytedance.sdk.openadsdk.api.init.BiddingTokenCallback
                public final void onBiddingTokenCollected(String str) {
                    PangleAdapter.collectBiddingData$lambda$22(BiddingDataCallback.this, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void collectBiddingData$lambda$22(BiddingDataCallback biddingDataCallback, String bidToken) {
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
        biddingDataCallback.onFailure("Failed to receive token - Pangle");
    }
}
