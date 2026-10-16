package com.ironsource.adapters.vungle;

import android.content.Context;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.C3040d4;
import com.ironsource.adapters.vungle.banner.VungleBannerAdapter;
import com.ironsource.adapters.vungle.interstitial.VungleInterstitialAdapter;
import com.ironsource.adapters.vungle.rewardedvideo.VungleRewardedVideoAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.vungle.ads.BidTokenCallback;
import com.vungle.ads.VungleAds;
import com.vungle.ads.VunglePrivacySettings;
import com.vungle.ads.VungleWrapperFramework;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VungleAdapter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0004H\u0016J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u0004H\u0016J\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0013H\u0014J\u001e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eH\u0014¨\u0006 "}, d2 = {"Lcom/ironsource/adapters/vungle/VungleAdapter;", "Lcom/ironsource/mediationsdk/AbstractAdapter;", "Lcom/ironsource/mediationsdk/INetworkInitCallbackListener;", "providerName", "", "(Ljava/lang/String;)V", "collectBiddingData", "", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "getCoreSDKVersion", "getInitState", "Lcom/ironsource/adapters/vungle/VungleAdapter$Companion$InitState;", "getVersion", "initSDK", "context", "Landroid/content/Context;", InneractiveMediationDefs.REMOTE_KEY_APP_ID, "isUsingActivityBeforeImpression", "", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "setCCPAValue", "value", "setCOPPAValue", "setConsent", C3040d4.i.b0, "setMetaData", C3040d4.h.W, "values", "", "Companion", "vungleadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VungleAdapter extends AbstractAdapter implements INetworkInitCallbackListener {
    public static final String APP_ID = "AppID";
    private static final String GitHash = "357f4d8";
    private static final String META_DATA_VUNGLE_CONSENT_MESSAGE_VERSION = "1.0.0";
    private static final String META_DATA_VUNGLE_COPPA_KEY = "Vungle_COPPA";
    public static final String PLACEMENT_ID = "PlacementId";
    private static final String VERSION = "4.3.31";
    private static final String VUNGLE_KEYWORD = "Vungle";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static AtomicBoolean isInitiated = new AtomicBoolean(false);
    private static Companion.InitState mInitState = Companion.InitState.INIT_STATE_NONE;
    private static final HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();

    @JvmStatic
    public static final String getAdapterSDKVersion() {
        return INSTANCE.getAdapterSDKVersion();
    }

    @JvmStatic
    public static final IntegrationData getIntegrationData(Context context) {
        return INSTANCE.getIntegrationData(context);
    }

    @JvmStatic
    public static final VungleAdapter startAdapter(String str) {
        return INSTANCE.startAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VungleAdapter(String providerName) {
        super(providerName);
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        setRewardedVideoAdapter(new VungleRewardedVideoAdapter(this));
        setInterstitialAdapter(new VungleInterstitialAdapter(this));
        setBannerAdapter(new VungleBannerAdapter(this));
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    /* compiled from: VungleAdapter.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001!B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u0004H\u0007J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\""}, d2 = {"Lcom/ironsource/adapters/vungle/VungleAdapter$Companion;", "", "()V", "APP_ID", "", "GitHash", "META_DATA_VUNGLE_CONSENT_MESSAGE_VERSION", "META_DATA_VUNGLE_COPPA_KEY", "PLACEMENT_ID", "VERSION", "VUNGLE_KEYWORD", "initCallbackListeners", "Ljava/util/HashSet;", "Lcom/ironsource/mediationsdk/INetworkInitCallbackListener;", "Lkotlin/collections/HashSet;", "getInitCallbackListeners$vungleadapter_release", "()Ljava/util/HashSet;", "isInitiated", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mInitState", "Lcom/ironsource/adapters/vungle/VungleAdapter$Companion$InitState;", "getMInitState$vungleadapter_release", "()Lcom/ironsource/adapters/vungle/VungleAdapter$Companion$InitState;", "setMInitState$vungleadapter_release", "(Lcom/ironsource/adapters/vungle/VungleAdapter$Companion$InitState;)V", "getAdapterSDKVersion", "getIntegrationData", "Lcom/ironsource/mediationsdk/IntegrationData;", "context", "Landroid/content/Context;", IronSourceConstants.START_ADAPTER, "Lcom/ironsource/adapters/vungle/VungleAdapter;", "providerName", "InitState", "vungleadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: VungleAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ironsource/adapters/vungle/VungleAdapter$Companion$InitState;", "", "(Ljava/lang/String;I)V", "INIT_STATE_NONE", "INIT_STATE_IN_PROGRESS", "INIT_STATE_SUCCESS", "INIT_STATE_FAILED", "vungleadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum InitState {
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

        public final InitState getMInitState$vungleadapter_release() {
            return VungleAdapter.mInitState;
        }

        public final void setMInitState$vungleadapter_release(InitState initState) {
            Intrinsics.checkNotNullParameter(initState, "<set-?>");
            VungleAdapter.mInitState = initState;
        }

        public final HashSet<INetworkInitCallbackListener> getInitCallbackListeners$vungleadapter_release() {
            return VungleAdapter.initCallbackListeners;
        }

        @JvmStatic
        public final VungleAdapter startAdapter(String providerName) {
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            return new VungleAdapter(providerName);
        }

        @JvmStatic
        public final IntegrationData getIntegrationData(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new IntegrationData("Vungle", "4.3.31");
        }

        @JvmStatic
        public final String getAdapterSDKVersion() {
            return VungleAds.INSTANCE.getSdkVersion();
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "4.3.31";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return INSTANCE.getAdapterSDKVersion();
    }

    public final void initSDK(Context context, String appID) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appID, "appID");
        if (mInitState == Companion.InitState.INIT_STATE_NONE || mInitState == Companion.InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (isInitiated.compareAndSet(false, true)) {
            IronLog.ADAPTER_API.verbose("appId = " + appID);
            mInitState = Companion.InitState.INIT_STATE_IN_PROGRESS;
            VungleAds.INSTANCE.setIntegrationName(VungleWrapperFramework.ironsource, "4.3.31");
            VungleAds.INSTANCE.init(context, appID, new VungleInitListener());
        }
    }

    public final Companion.InitState getInitState() {
        return mInitState;
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
        String formatValueForType = MetaDataUtils.formatValueForType(str, MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN);
        Intrinsics.checkNotNullExpressionValue(formatValueForType, "formatValueForType(\n    …A_VALUE_BOOLEAN\n        )");
        if (MetaDataUtils.isValidCCPAMetaData(key, str)) {
            setCCPAValue(MetaDataUtils.getMetaDataBooleanValue(str));
        } else if (MetaDataUtils.isValidMetaData(key, META_DATA_VUNGLE_COPPA_KEY, formatValueForType)) {
            setCOPPAValue(MetaDataUtils.getMetaDataBooleanValue(formatValueForType));
        }
    }

    private final void setCCPAValue(boolean value) {
        boolean z = !value;
        IronLog.ADAPTER_API.verbose("ccpa = " + z);
        VunglePrivacySettings.setCCPAStatus(z);
    }

    private final void setCOPPAValue(boolean value) {
        IronLog.ADAPTER_API.verbose("coppa = " + value);
        VunglePrivacySettings.setCOPPAStatus(value);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setConsent(boolean consent) {
        IronLog.ADAPTER_API.verbose("gdpr = " + consent);
        VunglePrivacySettings.setGDPRStatus(consent, META_DATA_VUNGLE_CONSENT_MESSAGE_VERSION);
    }

    public final void collectBiddingData(final BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        VungleAds.Companion companion = VungleAds.INSTANCE;
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getInstance().applicationContext");
        companion.getBiddingToken(applicationContext, new BidTokenCallback() { // from class: com.ironsource.adapters.vungle.VungleAdapter$collectBiddingData$1
            @Override // com.vungle.ads.BidTokenCallback
            public void onBidTokenCollected(String bidToken) {
                Intrinsics.checkNotNullParameter(bidToken, "bidToken");
                HashMap hashMap = new HashMap();
                String coreSDKVersion = VungleAdapter.this.getCoreSDKVersion();
                IronLog.ADAPTER_API.verbose("sdkVersion = " + coreSDKVersion + ", token = " + bidToken);
                hashMap.put("sdkVersion", coreSDKVersion);
                hashMap.put("token", bidToken);
                biddingDataCallback.onSuccess(hashMap);
            }

            @Override // com.vungle.ads.BidTokenCallback
            public void onBidTokenError(String errorMessage) {
                Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
                biddingDataCallback.onFailure("failed to receive token - Vungle , error = " + errorMessage);
            }
        });
    }
}
