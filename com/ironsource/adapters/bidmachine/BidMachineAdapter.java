package com.ironsource.adapters.bidmachine;

import android.content.Context;
import com.ironsource.C3040d4;
import com.ironsource.adapters.bidmachine.banner.BidMachineBannerAdapter;
import com.ironsource.adapters.bidmachine.interstitial.BidMachineInterstitialAdapter;
import com.ironsource.adapters.bidmachine.rewardedvideo.BidMachineRewardedVideoAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import io.bidmachine.AdPlacementConfig;
import io.bidmachine.AdsFormat;
import io.bidmachine.BidMachine;
import io.bidmachine.BidTokenCallback;
import io.bidmachine.InitializationCallback;
import io.bidmachine.utils.BMError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: BidMachineAdapter.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0006\u0010\u000f\u001a\u00020\u0010J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0004J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0016H\u0002J\u0010\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0016H\u0014J\u001e\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00042\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040!H\u0014¨\u0006#"}, d2 = {"Lcom/ironsource/adapters/bidmachine/BidMachineAdapter;", "Lcom/ironsource/mediationsdk/AbstractAdapter;", "Lcom/ironsource/mediationsdk/INetworkInitCallbackListener;", "providerName", "", "(Ljava/lang/String;)V", "collectBiddingData", "", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "adsFormat", "Lio/bidmachine/AdsFormat;", "config", "Lorg/json/JSONObject;", "getCoreSDKVersion", "getInitState", "Lcom/ironsource/adapters/bidmachine/BidMachineAdapter$Companion$InitState;", "getVersion", "initSdk", BidMachineAdapter.SOURCE_ID_KEY, "initializationSuccess", "isUsingActivityBeforeImpression", "", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "setCCPAValue", "value", "setCOPPAValue", "setConsent", C3040d4.i.b0, "setMetaData", C3040d4.h.W, "values", "", "Companion", "bidmachineadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BidMachineAdapter extends AbstractAdapter implements INetworkInitCallbackListener {
    private static final String GitHash = "30c6cd2";
    private static final String META_DATA_BIDMACHINE_CCPA_CONSENT_VALUE = "1YN-";
    private static final String META_DATA_BIDMACHINE_CCPA_NO_CONSENT_VALUE = "1YY-";
    private static final String META_DATA_BIDMACHINE_COPPA_KEY = "BidMachine_COPPA";
    private static final String PLACEMENT_ID_KEY = "placementId";
    private static final String SOURCE_ID_KEY = "sourceId";
    private static final String VERSION = "4.3.16";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicBoolean mWasInitCalled = new AtomicBoolean(false);
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
    public static final BidMachineAdapter startAdapter(String str) {
        return INSTANCE.startAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BidMachineAdapter(String providerName) {
        super(providerName);
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        setRewardedVideoAdapter(new BidMachineRewardedVideoAdapter(this));
        setInterstitialAdapter(new BidMachineInterstitialAdapter(this));
        setBannerAdapter(new BidMachineBannerAdapter(this));
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    /* compiled from: BidMachineAdapter.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001#B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0004H\u0007J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u0004J\u0006\u0010\u001f\u001a\u00020\u0004J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ironsource/adapters/bidmachine/BidMachineAdapter$Companion;", "", "()V", "GitHash", "", "META_DATA_BIDMACHINE_CCPA_CONSENT_VALUE", "META_DATA_BIDMACHINE_CCPA_NO_CONSENT_VALUE", "META_DATA_BIDMACHINE_COPPA_KEY", "PLACEMENT_ID_KEY", "SOURCE_ID_KEY", "VERSION", "initCallbackListeners", "Ljava/util/HashSet;", "Lcom/ironsource/mediationsdk/INetworkInitCallbackListener;", "Lkotlin/collections/HashSet;", "mInitState", "Lcom/ironsource/adapters/bidmachine/BidMachineAdapter$Companion$InitState;", "mWasInitCalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getAdapterSDKVersion", "getIntegrationData", "Lcom/ironsource/mediationsdk/IntegrationData;", "context", "Landroid/content/Context;", "getLoadErrorAndCheckNoFill", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "Lio/bidmachine/utils/BMError;", "noFillError", "", "getPlacementIdKey", "getSourceIdKey", IronSourceConstants.START_ADAPTER, "Lcom/ironsource/adapters/bidmachine/BidMachineAdapter;", "providerName", "InitState", "bidmachineadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: BidMachineAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ironsource/adapters/bidmachine/BidMachineAdapter$Companion$InitState;", "", "(Ljava/lang/String;I)V", "INIT_STATE_NONE", "INIT_STATE_IN_PROGRESS", "INIT_STATE_SUCCESS", "bidmachineadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum InitState {
            INIT_STATE_NONE,
            INIT_STATE_IN_PROGRESS,
            INIT_STATE_SUCCESS
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BidMachineAdapter startAdapter(String providerName) {
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            return new BidMachineAdapter(providerName);
        }

        @JvmStatic
        public final IntegrationData getIntegrationData(Context context) {
            return new IntegrationData(BidMachine.NAME, "4.3.16");
        }

        @JvmStatic
        public final String getAdapterSDKVersion() {
            return "3.4.0";
        }

        public final String getSourceIdKey() {
            return BidMachineAdapter.SOURCE_ID_KEY;
        }

        public final String getPlacementIdKey() {
            return "placementId";
        }

        public final IronSourceError getLoadErrorAndCheckNoFill(BMError error, int noFillError) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (error.getCode() == 103) {
                return new IronSourceError(noFillError, error.getMessage());
            }
            return new IronSourceError(error.getCode(), error.getMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "4.3.16";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return INSTANCE.getAdapterSDKVersion();
    }

    public final void initSdk(String sourceId) {
        Intrinsics.checkNotNullParameter(sourceId, "sourceId");
        if (mInitState == Companion.InitState.INIT_STATE_NONE || mInitState == Companion.InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            mInitState = Companion.InitState.INIT_STATE_IN_PROGRESS;
            IronLog.ADAPTER_API.verbose("sourceId = " + sourceId);
            BidMachine.setLoggingEnabled(isAdaptersDebugEnabled());
            BidMachine.initialize(ContextProvider.getInstance().getApplicationContext(), sourceId, new InitializationCallback() { // from class: com.ironsource.adapters.bidmachine.BidMachineAdapter$$ExternalSyntheticLambda0
                @Override // io.bidmachine.InitializationCallback
                public final void onInitialized() {
                    BidMachineAdapter.initSdk$lambda$0(BidMachineAdapter.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSdk$lambda$0(BidMachineAdapter this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.initializationSuccess();
    }

    private final void initializationSuccess() {
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
        } else if (MetaDataUtils.isValidMetaData(key, META_DATA_BIDMACHINE_COPPA_KEY, formatValueForType)) {
            setCOPPAValue(MetaDataUtils.getMetaDataBooleanValue(formatValueForType));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setConsent(boolean consent) {
        IronLog.ADAPTER_API.verbose("consent = " + consent);
        BidMachine.setSubjectToGDPR(true);
        BidMachine.setConsentConfig(consent, null);
    }

    private final void setCCPAValue(boolean value) {
        String str;
        if (value) {
            str = META_DATA_BIDMACHINE_CCPA_NO_CONSENT_VALUE;
        } else {
            str = META_DATA_BIDMACHINE_CCPA_CONSENT_VALUE;
        }
        IronLog.ADAPTER_API.verbose("value = ".concat(str));
        BidMachine.setUSPrivacyString(str);
    }

    private final void setCOPPAValue(boolean value) {
        IronLog.ADAPTER_API.verbose("isCoppa = " + value);
        BidMachine.setCoppa(Boolean.valueOf(value));
    }

    public final void collectBiddingData(final BiddingDataCallback biddingDataCallback, AdsFormat adsFormat, JSONObject config) {
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        Intrinsics.checkNotNullParameter(adsFormat, "adsFormat");
        Intrinsics.checkNotNullParameter(config, "config");
        if (mInitState != Companion.InitState.INIT_STATE_SUCCESS) {
            IronLog.INTERNAL.verbose("returning null as token since init isn't completed");
            biddingDataCallback.onFailure("returning null as token since init isn't completed - BidMachine");
            return;
        }
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        String optString = config.optString("placementId");
        AdPlacementConfig.Builder builder = new AdPlacementConfig.Builder(adsFormat);
        String str = optString;
        if (str != null && str.length() != 0) {
            builder.withPlacementId(optString);
        }
        BidMachine.getBidToken(applicationContext, builder.build(), new BidTokenCallback() { // from class: com.ironsource.adapters.bidmachine.BidMachineAdapter$$ExternalSyntheticLambda1
            @Override // io.bidmachine.BidTokenCallback
            public final void onCollected(String str2) {
                BidMachineAdapter.collectBiddingData$lambda$1(BiddingDataCallback.this, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void collectBiddingData$lambda$1(BiddingDataCallback biddingDataCallback, String token) {
        Intrinsics.checkNotNullParameter(biddingDataCallback, "$biddingDataCallback");
        Intrinsics.checkNotNullParameter(token, "token");
        if (token.length() == 0) {
            IronLog.INTERNAL.verbose("failed to receive token - returned null/empty token");
            biddingDataCallback.onFailure("failed to receive token - returned null/empty token - BidMachine");
        } else {
            IronLog.ADAPTER_API.verbose("token = " + token);
            HashMap hashMap = new HashMap();
            hashMap.put("token", token);
            biddingDataCallback.onSuccess(hashMap);
        }
    }
}
