package com.ironsource.adapters.voodoo;

import android.content.Context;
import com.ironsource.C3040d4;
import com.ironsource.adapters.voodoo.interstitial.VoodooInterstitialAdapter;
import com.ironsource.adapters.voodoo.rewardedvideo.VoodooRewardedVideoAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import io.adn.sdk.publisher.AdnAdError;
import io.adn.sdk.publisher.AdnAdPlacement;
import io.adn.sdk.publisher.AdnBidTokenCallback;
import io.adn.sdk.publisher.AdnInitializationCallback;
import io.adn.sdk.publisher.AdnInitializationStatus;
import io.adn.sdk.publisher.AdnMediationType;
import io.adn.sdk.publisher.AdnSdk;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: VoodooAdapter.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u001e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H\u0014J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016H\u0014J\u0016\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b¨\u0006\u001d"}, d2 = {"Lcom/ironsource/adapters/voodoo/VoodooAdapter;", "Lcom/ironsource/mediationsdk/AbstractAdapter;", "providerName", "", "<init>", "(Ljava/lang/String;)V", "getVersion", "getCoreSDKVersion", "initSdk", "", "config", "Lorg/json/JSONObject;", "initializationSuccess", "initializationFailure", "getInitState", "Lcom/ironsource/adapters/voodoo/VoodooAdapter$Companion$InitState;", "setMetaData", C3040d4.h.W, "values", "", "setConsent", C3040d4.i.b0, "", "collectBiddingData", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "adnAdPlacement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "Companion", "adn-ironsource-adapter_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class VoodooAdapter extends AbstractAdapter {
    private static final String APP_ID_KEY = "gameId";
    private static final String META_DATA_VOODOO_COPPA = "Voodoo_COPPA";
    private static final String PLACEMENT_ID_KEY = "placementId";
    private static final String VERSION = "4.25.2.1";

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
    public static final VoodooAdapter startAdapter(String str) {
        return INSTANCE.startAdapter(str);
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setConsent(boolean consent) {
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    protected void setMetaData(String key, List<String> values) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
    }

    public VoodooAdapter(String str) {
        super(str);
        IronLog.INTERNAL.verbose();
        setRewardedVideoAdapter(new VoodooRewardedVideoAdapter(this));
        setInterstitialAdapter(new VoodooInterstitialAdapter(this));
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    /* compiled from: VoodooAdapter.kt */
    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u001fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0005H\u0007J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0007J\b\u0010\u0018\u001a\u00020\u0005H\u0007J\u0006\u0010\u0019\u001a\u00020\u0005J\u0006\u0010\u001a\u001a\u00020\u0005J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ironsource/adapters/voodoo/VoodooAdapter$Companion;", "", "<init>", "()V", "VERSION", "", "PLACEMENT_ID_KEY", "APP_ID_KEY", "META_DATA_VOODOO_COPPA", "mWasInitCalled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "mInitState", "Lcom/ironsource/adapters/voodoo/VoodooAdapter$Companion$InitState;", "initCallbackListeners", "Ljava/util/HashSet;", "Lcom/ironsource/mediationsdk/INetworkInitCallbackListener;", "Lkotlin/collections/HashSet;", IronSourceConstants.START_ADAPTER, "Lcom/ironsource/adapters/voodoo/VoodooAdapter;", "providerName", "getIntegrationData", "Lcom/ironsource/mediationsdk/IntegrationData;", "context", "Landroid/content/Context;", "getAdapterSDKVersion", "getPlacementIdKey", "getAppIdKey", "getLoadAdError", "Lcom/ironsource/mediationsdk/logger/IronSourceError;", IronSourceConstants.EVENTS_ERROR_CODE, "Lio/adn/sdk/publisher/AdnAdError;", "InitState", "adn-ironsource-adapter_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* compiled from: VoodooAdapter.kt */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ironsource/adapters/voodoo/VoodooAdapter$Companion$InitState;", "", "<init>", "(Ljava/lang/String;I)V", "INIT_STATE_NONE", "INIT_STATE_IN_PROGRESS", "INIT_STATE_SUCCESS", "INIT_STATE_FAILED", "adn-ironsource-adapter_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class InitState {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ InitState[] $VALUES;
            public static final InitState INIT_STATE_NONE = new InitState("INIT_STATE_NONE", 0);
            public static final InitState INIT_STATE_IN_PROGRESS = new InitState("INIT_STATE_IN_PROGRESS", 1);
            public static final InitState INIT_STATE_SUCCESS = new InitState("INIT_STATE_SUCCESS", 2);
            public static final InitState INIT_STATE_FAILED = new InitState("INIT_STATE_FAILED", 3);

            private static final /* synthetic */ InitState[] $values() {
                return new InitState[]{INIT_STATE_NONE, INIT_STATE_IN_PROGRESS, INIT_STATE_SUCCESS, INIT_STATE_FAILED};
            }

            public static EnumEntries<InitState> getEntries() {
                return $ENTRIES;
            }

            private InitState(String str, int i) {
            }

            static {
                InitState[] $values = $values();
                $VALUES = $values;
                $ENTRIES = EnumEntriesKt.enumEntries($values);
            }

            public static InitState valueOf(String str) {
                return (InitState) Enum.valueOf(InitState.class, str);
            }

            public static InitState[] values() {
                return (InitState[]) $VALUES.clone();
            }
        }

        @JvmStatic
        public final VoodooAdapter startAdapter(String providerName) {
            Intrinsics.checkNotNullParameter(providerName, "providerName");
            return new VoodooAdapter(providerName);
        }

        @JvmStatic
        public final IntegrationData getIntegrationData(Context context) {
            return new IntegrationData("Voodoo", "4.25.2.1");
        }

        @JvmStatic
        public final String getAdapterSDKVersion() {
            return AdnSdk.getVersion();
        }

        public final String getPlacementIdKey() {
            return "placementId";
        }

        public final String getAppIdKey() {
            return "gameId";
        }

        public final IronSourceError getLoadAdError(AdnAdError errorCode) {
            Intrinsics.checkNotNullParameter(errorCode, "errorCode");
            if (Intrinsics.areEqual(AdnAdError.NoFill.INSTANCE, errorCode)) {
                return new IronSourceError(1158, errorCode.getErrorMessage());
            }
            return new IronSourceError(errorCode.getErrorCode(), errorCode.getErrorMessage());
        }
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getVersion() {
        return "4.25.2.1";
    }

    @Override // com.ironsource.mediationsdk.AbstractAdapter
    public String getCoreSDKVersion() {
        return INSTANCE.getAdapterSDKVersion();
    }

    public final void initSdk(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (mInitState == Companion.InitState.INIT_STATE_NONE || mInitState == Companion.InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            Companion companion = INSTANCE;
            mInitState = Companion.InitState.INIT_STATE_IN_PROGRESS;
            IronLog.ADAPTER_API.verbose("gameId: " + config.optString(companion.getAppIdKey()));
            AdnSdk.setVerbose(isAdaptersDebugEnabled());
            AdnSdk.setMediationType(AdnMediationType.IRONSOURCE);
            Context applicationContext = ContextProvider.getInstance().getCurrentActiveActivity().getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
            AdnSdk.initialize(applicationContext, new AdnInitializationCallback() { // from class: com.ironsource.adapters.voodoo.VoodooAdapter$initSdk$1

                /* compiled from: VoodooAdapter.kt */
                @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[AdnInitializationStatus.values().length];
                        try {
                            iArr[AdnInitializationStatus.INITIALIZED_SUCCESS.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[AdnInitializationStatus.INITIALIZED_FAILURE.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // io.adn.sdk.publisher.AdnInitializationCallback
                public void onCompletion(AdnInitializationStatus status) {
                    Intrinsics.checkNotNullParameter(status, "status");
                    int i = WhenMappings.$EnumSwitchMapping$0[status.ordinal()];
                    if (i == 1) {
                        VoodooAdapter.this.initializationSuccess();
                    } else {
                        if (i != 2) {
                            return;
                        }
                        VoodooAdapter.this.initializationFailure();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializationSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = Companion.InitState.INIT_STATE_SUCCESS;
        Iterator<T> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            ((INetworkInitCallbackListener) it.next()).onNetworkInitCallbackSuccess();
        }
        initCallbackListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initializationFailure() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = Companion.InitState.INIT_STATE_FAILED;
        Iterator<T> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            ((INetworkInitCallbackListener) it.next()).onNetworkInitCallbackFailed("Voodoo SDK init failed");
        }
        initCallbackListeners.clear();
    }

    public final Companion.InitState getInitState() {
        return mInitState;
    }

    public final void collectBiddingData(final BiddingDataCallback biddingDataCallback, AdnAdPlacement adnAdPlacement) {
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        Intrinsics.checkNotNullParameter(adnAdPlacement, "adnAdPlacement");
        if (mInitState == Companion.InitState.INIT_STATE_NONE) {
            IronLog.INTERNAL.verbose("returning null as token since init hasn't started");
            biddingDataCallback.onFailure("returning null as token since init hasn't started - Voodoo");
        } else {
            AdnSdk.getBidToken(adnAdPlacement, new AdnBidTokenCallback() { // from class: com.ironsource.adapters.voodoo.VoodooAdapter$collectBiddingData$1
                @Override // io.adn.sdk.publisher.AdnBidTokenCallback
                public void onComplete(String response) {
                    Intrinsics.checkNotNullParameter(response, "response");
                    String coreSDKVersion = VoodooAdapter.this.getCoreSDKVersion();
                    IronLog.ADAPTER_API.verbose("token = " + response + ", sdkVersion = " + coreSDKVersion);
                    HashMap hashMap = new HashMap();
                    hashMap.put("token", response);
                    hashMap.put("sdkVersion", coreSDKVersion);
                    biddingDataCallback.onSuccess(hashMap);
                }
            });
        }
    }
}
