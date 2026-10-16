package com.ironsource.adapters.moloco;

import android.content.Context;
import com.ironsource.C3040d4;
import com.ironsource.adapters.moloco.banner.MolocoBannerAdapter;
import com.ironsource.adapters.moloco.interstitial.MolocoInterstitialAdapter;
import com.ironsource.adapters.moloco.rewardedvideo.MolocoRewardedVideoAdapter;
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
import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.Initialization;
import com.moloco.sdk.publisher.MediationInfo;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.MolocoAdError;
import com.moloco.sdk.publisher.MolocoBidTokenListener;
import com.moloco.sdk.publisher.MolocoInitStatus;
import com.moloco.sdk.publisher.MolocoInitializationListener;
import com.moloco.sdk.publisher.init.MolocoInitParams;
import com.moloco.sdk.publisher.privacy.MolocoPrivacy;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MolocoAdapter.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0001\u001fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\b\u0010\n\u001a\u00020\u0004H\u0016J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\u0004H\u0016J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0004J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0013H\u0014J\u001e\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00042\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001eH\u0014¨\u0006 "}, d2 = {"Lcom/ironsource/adapters/moloco/MolocoAdapter;", "Lcom/ironsource/mediationsdk/AbstractAdapter;", "Lcom/ironsource/mediationsdk/INetworkInitCallbackListener;", "providerName", "", "(Ljava/lang/String;)V", "collectBiddingData", "", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "getCoreSDKVersion", "getInitState", "Lcom/ironsource/adapters/moloco/MolocoAdapter$Companion$InitState;", "getVersion", "initSdk", "appKey", "initializationFailure", "initializationSuccess", "isUsingActivityBeforeImpression", "", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", "setCCPAValue", "value", "setCOPPAValue", "setConsent", C3040d4.i.b0, "setMetaData", C3040d4.h.W, "values", "", "Companion", "molocoadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MolocoAdapter extends AbstractAdapter implements INetworkInitCallbackListener {
    private static final String AD_UNIT_ID = "adUnitId";
    private static final String APP_KEY = "appKey";
    private static final String GitHash = "e835070";
    public static final String INVALID_CONFIGURATION = "invalid configuration";
    private static final String META_DATA_MOLOCO_COPPA_KEY = "Moloco_COPPA";
    private static final String VERSION = "4.3.21";

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MediationInfo mediationInfo = new MediationInfo("LevelPlay");
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
    public static final MolocoAdapter startAdapter(String str) {
        return INSTANCE.startAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT adUnit) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        return false;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MolocoAdapter(String providerName) {
        super(providerName);
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        setRewardedVideoAdapter(new MolocoRewardedVideoAdapter(this));
        setBannerAdapter(new MolocoBannerAdapter(this));
        setInterstitialAdapter(new MolocoInterstitialAdapter(this));
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    /* compiled from: MolocoAdapter.kt */
    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001%B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0004J\b\u0010\u0015\u001a\u00020\u0004H\u0007J\u0006\u0010\u0016\u001a\u00020\u0004J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0016\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020\u0013J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ironsource/adapters/moloco/MolocoAdapter$Companion;", "", "()V", "AD_UNIT_ID", "", "APP_KEY", "GitHash", "INVALID_CONFIGURATION", "META_DATA_MOLOCO_COPPA_KEY", "VERSION", "initCallbackListeners", "Ljava/util/HashSet;", "Lcom/ironsource/mediationsdk/INetworkInitCallbackListener;", "Lkotlin/collections/HashSet;", "mInitState", "Lcom/ironsource/adapters/moloco/MolocoAdapter$Companion$InitState;", "mWasInitCalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mediationInfo", "Lcom/moloco/sdk/publisher/MediationInfo;", "getAdUnitIdKey", "getAdapterSDKVersion", "getAppKey", "getIntegrationData", "Lcom/ironsource/mediationsdk/IntegrationData;", "context", "Landroid/content/Context;", "getLoadErrorAndCheckNoFill", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", "error", "Lcom/moloco/sdk/publisher/MolocoAdError;", "noFillError", "", "getMediationInfo", IronSourceConstants.START_ADAPTER, "Lcom/ironsource/adapters/moloco/MolocoAdapter;", "providerName", "InitState", "molocoadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: MolocoAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ironsource/adapters/moloco/MolocoAdapter$Companion$InitState;", "", "(Ljava/lang/String;I)V", "INIT_STATE_NONE", "INIT_STATE_IN_PROGRESS", "INIT_STATE_SUCCESS", "INIT_STATE_FAILED", "molocoadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public enum InitState {
            INIT_STATE_NONE,
            INIT_STATE_IN_PROGRESS,
            INIT_STATE_SUCCESS,
            INIT_STATE_FAILED
        }

        /* compiled from: MolocoAdapter.kt */
        @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[MolocoAdError.ErrorType.values().length];
                try {
                    iArr[MolocoAdError.ErrorType.AD_LOAD_FAILED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MolocoAdapter startAdapter(String providerName) {
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            return new MolocoAdapter(providerName);
        }

        @JvmStatic
        public final IntegrationData getIntegrationData(Context context) {
            return new IntegrationData("Moloco", "4.3.21");
        }

        @JvmStatic
        public final String getAdapterSDKVersion() {
            return com.moloco.sdk.BuildConfig.SDK_VERSION_NAME;
        }

        public final String getAppKey() {
            return "appKey";
        }

        public final String getAdUnitIdKey() {
            return "adUnitId";
        }

        public final MediationInfo getMediationInfo() {
            return MolocoAdapter.mediationInfo;
        }

        public final IronSourceError getLoadErrorAndCheckNoFill(MolocoAdError error, int noFillError) {
            Intrinsics.checkNotNullParameter(error, "error");
            if (WhenMappings.$EnumSwitchMapping$0[error.getErrorType().ordinal()] == 1) {
                return new IronSourceError(noFillError, error.getDescription());
            }
            return new IronSourceError(MolocoAdError.ErrorType.AD_LOAD_FAILED.getErrorCode(), error.getDescription());
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "4.3.21";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return INSTANCE.getAdapterSDKVersion();
    }

    public final void initSdk(String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        if (mInitState == Companion.InitState.INIT_STATE_NONE || mInitState == Companion.InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            mInitState = Companion.InitState.INIT_STATE_IN_PROGRESS;
            IronLog.ADAPTER_API.verbose("appKey: " + appKey);
            MolocoLogger.setLogEnabled(isAdaptersDebugEnabled());
            Context context = ContextProvider.getInstance().getCurrentActiveActivity().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            Moloco.initialize(new MolocoInitParams(context, appKey, mediationInfo), new MolocoInitializationListener() { // from class: com.ironsource.adapters.moloco.MolocoAdapter$$ExternalSyntheticLambda1
                @Override // com.moloco.sdk.publisher.MolocoInitializationListener
                public final void onMolocoInitializationStatus(MolocoInitStatus molocoInitStatus) {
                    MolocoAdapter.initSdk$lambda$0(MolocoAdapter.this, molocoInitStatus);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initSdk$lambda$0(MolocoAdapter this$0, MolocoInitStatus molocoInitStatus) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(molocoInitStatus, "molocoInitStatus");
        String description = molocoInitStatus.getDescription();
        if (molocoInitStatus.getInitialization() == Initialization.SUCCESS) {
            IronLog.ADAPTER_API.verbose("Initialization success " + description);
            this$0.initializationSuccess();
        } else {
            IronLog.ADAPTER_API.verbose("Initialization failed " + description);
            this$0.initializationFailure();
        }
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

    private final void initializationFailure() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = Companion.InitState.INIT_STATE_FAILED;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            INetworkInitCallbackListener initCallbackListeners2 = it.next();
            Intrinsics.checkNotNullExpressionValue(initCallbackListeners2, "initCallbackListeners");
            initCallbackListeners2.onNetworkInitCallbackFailed("Moloco sdk init failed");
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
        Intrinsics.checkNotNullExpressionValue(formatValueForType, "formatValueForType(value….META_DATA_VALUE_BOOLEAN)");
        if (MetaDataUtils.isValidCCPAMetaData(key, str)) {
            setCCPAValue(MetaDataUtils.getMetaDataBooleanValue(str));
        } else if (MetaDataUtils.isValidMetaData(key, META_DATA_MOLOCO_COPPA_KEY, formatValueForType)) {
            setCOPPAValue(MetaDataUtils.getMetaDataBooleanValue(formatValueForType));
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setConsent(boolean consent) {
        IronLog.ADAPTER_API.verbose("consent = " + consent);
        MolocoPrivacy.setPrivacy(new MolocoPrivacy.PrivacySettings(Boolean.valueOf(consent), null, null));
    }

    private final void setCCPAValue(boolean value) {
        IronLog.ADAPTER_API.verbose("value = " + value);
        MolocoPrivacy.setPrivacy(new MolocoPrivacy.PrivacySettings(null, null, Boolean.valueOf(value)));
    }

    private final void setCOPPAValue(boolean value) {
        IronLog.ADAPTER_API.verbose("isCoppa = " + value);
        MolocoPrivacy.setPrivacy(new MolocoPrivacy.PrivacySettings(null, Boolean.valueOf(value), null));
    }

    public final void collectBiddingData(final BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        if (mInitState != Companion.InitState.INIT_STATE_SUCCESS) {
            IronLog.INTERNAL.verbose("returning null as token since init isn't completed");
            biddingDataCallback.onFailure("returning null as token since init isn't completed - Moloco");
            return;
        }
        Moloco.getBidRequestEndpoint();
        MediationInfo mediationInfo2 = mediationInfo;
        Context applicationContext = ContextProvider.getInstance().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getInstance().applicationContext");
        Moloco.getBidToken(mediationInfo2, applicationContext, new MolocoBidTokenListener() { // from class: com.ironsource.adapters.moloco.MolocoAdapter$$ExternalSyntheticLambda0
            @Override // com.moloco.sdk.publisher.MolocoBidTokenListener
            public final void onBidTokenResult(String str, MolocoAdError.ErrorType errorType) {
                MolocoAdapter.collectBiddingData$lambda$1(BiddingDataCallback.this, str, errorType);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void collectBiddingData$lambda$1(BiddingDataCallback biddingDataCallback, String bidToken, MolocoAdError.ErrorType errorType) {
        Intrinsics.checkNotNullParameter(biddingDataCallback, "$biddingDataCallback");
        Intrinsics.checkNotNullParameter(bidToken, "bidToken");
        if (errorType == null) {
            HashMap hashMap = new HashMap();
            IronLog.ADAPTER_API.verbose("token = " + bidToken);
            hashMap.put("token", bidToken);
            biddingDataCallback.onSuccess(hashMap);
            return;
        }
        biddingDataCallback.onFailure("failed to receive token - Moloco, errorCode = " + errorType.getErrorCode() + ", error = " + errorType.getDescription());
    }
}
