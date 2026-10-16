package com.ironsource.adapters.moloco.interstitial;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.C3040d4;
import com.ironsource.C3207n2;
import com.ironsource.N6;
import com.ironsource.adapters.moloco.MolocoAdapter;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.moloco.sdk.publisher.InterstitialAd;
import com.moloco.sdk.publisher.Moloco;
import com.moloco.sdk.publisher.MolocoAdError;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: MolocoInterstitialAdapter.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\r\u0010\u0014\u001a\u00020\u000eH\u0000¢\u0006\u0002\b\u0015J,\u0010\u0016\u001a\u00020\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J,\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u001e\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u0012\u0010\u001f\u001a\u00020\u000e2\b\u0010 \u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010!\u001a\u00020\u000eH\u0016J\u001a\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ironsource/adapters/moloco/interstitial/MolocoInterstitialAdapter;", "Lcom/ironsource/mediationsdk/adapter/AbstractInterstitialAdapter;", "Lcom/ironsource/adapters/moloco/MolocoAdapter;", N6.F1, "(Lcom/ironsource/adapters/moloco/MolocoAdapter;)V", "mAd", "Lcom/moloco/sdk/publisher/InterstitialAd;", "mAdLoadListener", "Lcom/ironsource/adapters/moloco/interstitial/MolocoInterstitialAdLoadListener;", "mAdShowListener", "Lcom/ironsource/adapters/moloco/interstitial/MolocoInterstitialAdShowListener;", "mListener", "Lcom/ironsource/mediationsdk/sdk/InterstitialSmashListener;", "collectInterstitialBiddingData", "", "config", "Lorg/json/JSONObject;", "adData", "biddingDataCallback", "Lcom/ironsource/mediationsdk/bidding/BiddingDataCallback;", "destroyInterstitialAd", "destroyInterstitialAd$molocoadapter_release", "initInterstitialForBidding", "appKey", "", "userId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isInterstitialReady", "", "loadInterstitialForBidding", C3207n2.s, "onNetworkInitCallbackFailed", "error", "onNetworkInitCallbackSuccess", "releaseMemory", "adUnit", "Lcom/ironsource/mediationsdk/IronSource$AD_UNIT;", C3040d4.g.H, "molocoadapter_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MolocoInterstitialAdapter extends AbstractInterstitialAdapter<MolocoAdapter> {
    private InterstitialAd mAd;
    private MolocoInterstitialAdLoadListener mAdLoadListener;
    private MolocoInterstitialAdShowListener mAdShowListener;
    private InterstitialSmashListener mListener;

    /* compiled from: MolocoInterstitialAdapter.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MolocoAdapter.Companion.InitState.values().length];
            try {
                iArr[MolocoAdapter.Companion.InitState.INIT_STATE_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MolocoAdapter.Companion.InitState.INIT_STATE_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MolocoAdapter.Companion.InitState.INIT_STATE_NONE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MolocoAdapter.Companion.InitState.INIT_STATE_IN_PROGRESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MolocoInterstitialAdapter(MolocoAdapter adapter) {
        super(adapter);
        Intrinsics.checkNotNullParameter(adapter, "adapter");
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void initInterstitialForBidding(String appKey, String userId, JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        String configStringValueFromKey = getConfigStringValueFromKey(config, MolocoAdapter.INSTANCE.getAdUnitIdKey());
        String configStringValueFromKey2 = getConfigStringValueFromKey(config, MolocoAdapter.INSTANCE.getAppKey());
        if (configStringValueFromKey.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(configStringValueFromKey));
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(configStringValueFromKey), "Interstitial"));
            return;
        }
        if (configStringValueFromKey2.length() == 0) {
            IronLog.INTERNAL.error(getAdUnitIdMissingErrorString(configStringValueFromKey2));
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(getAdUnitIdMissingErrorString(configStringValueFromKey2), "Interstitial"));
            return;
        }
        IronLog.ADAPTER_API.verbose("adUnitId = " + configStringValueFromKey + ", appKey = " + configStringValueFromKey2);
        this.mListener = listener;
        int i = WhenMappings.$EnumSwitchMapping$0[getAdapter().getInitState().ordinal()];
        if (i == 1) {
            listener.onInterstitialInitSuccess();
            return;
        }
        if (i == 2) {
            listener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Moloco sdk init failed", "Interstitial"));
        } else if (i == 3 || i == 4) {
            getAdapter().initSdk(configStringValueFromKey2);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackSuccess() {
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialInitSuccess();
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractAdUnitAdapter, com.ironsource.mediationsdk.INetworkInitCallbackListener
    public void onNetworkInitCallbackFailed(String error) {
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener != null) {
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(error, "Interstitial"));
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void loadInterstitialForBidding(JSONObject config, JSONObject adData, final String serverData, final InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        String str = serverData;
        if (str == null || str.length() == 0) {
            IronLog.INTERNAL.error("serverData is empty");
            listener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError("serverData is empty"));
        } else {
            this.mAdLoadListener = new MolocoInterstitialAdLoadListener(listener, new WeakReference(this));
            Moloco.createInterstitial$default(MolocoAdapter.INSTANCE.getMediationInfo(), getConfigStringValueFromKey(config, MolocoAdapter.INSTANCE.getAdUnitIdKey()), null, new Function2<InterstitialAd, MolocoAdError.AdCreateError, Unit>() { // from class: com.ironsource.adapters.moloco.interstitial.MolocoInterstitialAdapter$loadInterstitialForBidding$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(InterstitialAd interstitialAd, MolocoAdError.AdCreateError adCreateError) {
                    invoke2(interstitialAd, adCreateError);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(InterstitialAd interstitialAd, MolocoAdError.AdCreateError adCreateError) {
                    InterstitialAd interstitialAd2;
                    MolocoInterstitialAdLoadListener molocoInterstitialAdLoadListener;
                    InterstitialSmashListener interstitialSmashListener;
                    if (adCreateError != null) {
                        interstitialSmashListener = MolocoInterstitialAdapter.this.mListener;
                        if (interstitialSmashListener != null) {
                            interstitialSmashListener.onInterstitialAdLoadFailed(new IronSourceError(adCreateError.getErrorCode(), adCreateError.getDescription()));
                            return;
                        }
                        return;
                    }
                    Unit unit = null;
                    if (interstitialAd != null) {
                        MolocoInterstitialAdapter molocoInterstitialAdapter = MolocoInterstitialAdapter.this;
                        String str2 = serverData;
                        molocoInterstitialAdapter.mAd = interstitialAd;
                        interstitialAd2 = molocoInterstitialAdapter.mAd;
                        if (interstitialAd2 != null) {
                            molocoInterstitialAdLoadListener = molocoInterstitialAdapter.mAdLoadListener;
                            interstitialAd2.load(str2, molocoInterstitialAdLoadListener);
                            unit = Unit.INSTANCE;
                        }
                    }
                    if (unit == null) {
                        listener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError(MolocoAdapter.INVALID_CONFIGURATION));
                    }
                }
            }, 4, null);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void showInterstitial(JSONObject config, InterstitialSmashListener listener) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(listener, "listener");
        IronLog.ADAPTER_API.verbose();
        if (!isInterstitialReady(config)) {
            listener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
            return;
        }
        MolocoInterstitialAdShowListener molocoInterstitialAdShowListener = new MolocoInterstitialAdShowListener(listener, new WeakReference(this));
        this.mAdShowListener = molocoInterstitialAdShowListener;
        InterstitialAd interstitialAd = this.mAd;
        if (interstitialAd != null) {
            interstitialAd.show(molocoInterstitialAdShowListener);
        }
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public boolean isInterstitialReady(JSONObject config) {
        Intrinsics.checkNotNullParameter(config, "config");
        InterstitialAd interstitialAd = this.mAd;
        return (interstitialAd == null || interstitialAd == null || !interstitialAd.isLoaded()) ? false : true;
    }

    @Override // com.ironsource.mediationsdk.adapter.AbstractInterstitialAdapter, com.ironsource.mediationsdk.sdk.InterstitialAdapterInterface
    public void collectInterstitialBiddingData(JSONObject config, JSONObject adData, BiddingDataCallback biddingDataCallback) {
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(biddingDataCallback, "biddingDataCallback");
        getAdapter().collectBiddingData(biddingDataCallback);
    }

    @Override // com.ironsource.mediationsdk.sdk.ReleaseMemoryAdapterInterface
    public void releaseMemory(IronSource.AD_UNIT adUnit, JSONObject config) {
        Intrinsics.checkNotNullParameter(adUnit, "adUnit");
        IronLog.INTERNAL.verbose();
        destroyInterstitialAd$molocoadapter_release();
        this.mAdLoadListener = null;
        this.mAdShowListener = null;
        this.mListener = null;
    }

    public final void destroyInterstitialAd$molocoadapter_release() {
        InterstitialAd interstitialAd = this.mAd;
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        this.mAd = null;
    }
}
