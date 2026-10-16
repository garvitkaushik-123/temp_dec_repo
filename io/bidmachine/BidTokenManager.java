package io.bidmachine;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.explorestack.protobuf.Any;
import com.explorestack.protobuf.Message;
import com.explorestack.protobuf.StringValue;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import com.explorestack.protobuf.adcom.Placement;
import io.bidmachine.banner.BannerRequest;
import io.bidmachine.banner.BannerSize;
import io.bidmachine.core.Logger;
import io.bidmachine.core.Utils;
import io.bidmachine.interstitial.InterstitialRequest;
import io.bidmachine.measurer.OMSDKSettings;
import io.bidmachine.nativead.NativeRequest;
import io.bidmachine.protobuf.RequestTokenPayload;
import io.bidmachine.protobuf.ResponsePayload;
import io.bidmachine.protobuf.TokenConfiguration;
import io.bidmachine.protobuf.headerbidding.HeaderBiddingPlacement;
import io.bidmachine.protobuf.sdk.App;
import io.bidmachine.protobuf.sdk.Placement;
import io.bidmachine.protobuf.sdk.SDK;
import io.bidmachine.protobuf.sdk.User;
import io.bidmachine.rewarded.RewardedRequest;
import io.bidmachine.tracking.TrackingObject;
import io.bidmachine.utils.BMError;
import io.bidmachine.utils.lazy.LazyValue;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes7.dex */
class BidTokenManager {
    private static final int DEFAULT_EXPIRATION_SEC = 300;
    private static final String TAG = "BidTokenManager";
    private static final TrackingObject TRACKING_OBJECT = new BidMachineTrackingObject();
    private static final Map<AdsFormat, TokenConfiguration> TOKEN_CONFIGURATION_MAP = new ConcurrentHashMap();
    private static final Map<String, BidToken> STORED_BID_TOKEN = new ConcurrentHashMap();

    BidTokenManager() {
    }

    static String createBidToken(Context context, AdPlacementConfig adPlacementConfig) {
        AdsFormat adsFormat = adPlacementConfig.getAdsFormat();
        RequestTokenPayload createRequestTokenPayload = createRequestTokenPayload(context, adPlacementConfig);
        if (createRequestTokenPayload == null) {
            sendFailEvent(adsFormat, BMError.internal("Failed to create RequestTokenPayload"));
            return "";
        }
        try {
            String encodeToString = Base64.encodeToString(createRequestTokenPayload.toByteArray(), 2);
            sendSuccessEvent(adsFormat);
            return encodeToString;
        } catch (Exception e) {
            sendFailEvent(adsFormat, BMError.throwable("Failed to encode RequestTokenPayload", e));
            removeBidToken(createRequestTokenPayload.getTokenHashValue());
            return "";
        }
    }

    private static RequestTokenPayload createRequestTokenPayload(Context context, AdPlacementConfig adPlacementConfig) {
        try {
            AdsFormat adsFormat = adPlacementConfig.getAdsFormat();
            BidMachineImpl bidMachineImpl = BidMachineImpl.get();
            RequestTokenPayload.Builder newBuilder = RequestTokenPayload.newBuilder();
            final Placement.Builder placementBuilder = newBuilder.getPlacementBuilder();
            placementBuilder.setAdType(adsFormat.getAdsType().getName());
            Utils.ifNotNull(adPlacementConfig.getPlacementId(), new Executable() { // from class: io.bidmachine.BidTokenManager$$ExternalSyntheticLambda0
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    Placement.Builder.this.setPlacementId(StringValue.of((String) obj));
                }
            });
            Utils.ifNotNull(adPlacementConfig.getCustomParams(), new Executable() { // from class: io.bidmachine.BidTokenManager$$ExternalSyntheticLambda1
                @Override // io.bidmachine.Executable
                public final void execute(Object obj) {
                    BidTokenManager.lambda$createRequestTokenPayload$1(Placement.Builder.this, (CustomParams) obj);
                }
            });
            App.Builder newBuilder2 = App.newBuilder();
            bidMachineImpl.getAppParams().build(context, newBuilder2);
            newBuilder.setAppData(newBuilder2);
            User.Builder createUserBuilder = createUserBuilder(bidMachineImpl);
            if (createUserBuilder != null) {
                newBuilder.setUserData(createUserBuilder);
            }
            SDK.Builder sdkver = SDK.newBuilder().setSdk(BidMachine.NAME).setSdkver("3.4.0");
            OMSDKSettings.fill(sdkver);
            newBuilder.setPlacementData(sdkver);
            bidMachineImpl.getDeviceParams().build(context, newBuilder, bidMachineImpl.getUserRestrictionParams());
            bidMachineImpl.getSessionParams().build(context, newBuilder, adsFormat);
            processAdNetworks(context, newBuilder, adsFormat);
            Struct.Builder newBuilder3 = Struct.newBuilder();
            Struct privateStruct = ExtraParamsManager.get().getPrivateStruct(context);
            if (privateStruct != null) {
                newBuilder3.putAllFields(privateStruct.getFieldsMap());
            }
            if (newBuilder3.getFieldsCount() > 0) {
                newBuilder.setExt(newBuilder3.build());
            }
            return newBuilder.build();
        } catch (Throwable th) {
            Logger.w(th);
            return null;
        }
    }

    static /* synthetic */ void lambda$createRequestTokenPayload$1(Placement.Builder builder, CustomParams customParams) {
        Struct.Builder newBuilder = Struct.newBuilder();
        customParams.fillStructBuilder(newBuilder);
        if (newBuilder.getFieldsCount() > 0) {
            builder.setCustomData(newBuilder);
        }
    }

    private static User.Builder createUserBuilder(BidMachineImpl bidMachine) {
        try {
            UserRestrictionParams userRestrictionParams = bidMachine.getUserRestrictionParams();
            User.Builder newBuilder = User.newBuilder();
            userRestrictionParams.fill(newBuilder);
            return newBuilder;
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void processAdNetworks(Context context, RequestTokenPayload.Builder requestTokenPayloadBuilder, AdsFormat adsFormat) {
        if (adsFormat == null) {
            return;
        }
        try {
            AdRequest<?, ?, ?> mapToAdRequest = mapToAdRequest(adsFormat);
            if (mapToAdRequest == null) {
                return;
            }
            NetworkRegistry.registerAndInitializeCoreNetworks(context);
            TokenConfiguration obtainTokenConfiguration = obtainTokenConfiguration(adsFormat);
            HeaderBiddingPlacement.Builder newBuilder = HeaderBiddingPlacement.newBuilder();
            AnonymousClass1 anonymousClass1 = null;
            for (Message.Builder builder : mapToAdRequest.collectPlacementFormats(context, obtainTokenConfiguration.getAdNetworksList(), null)) {
                if (builder instanceof Placement.DisplayPlacement.Builder) {
                    fillHeaderBiddingPlacementBuilder(newBuilder, ((Placement.DisplayPlacement.Builder) builder).getExtProtoList());
                } else if (builder instanceof Placement.VideoPlacement.Builder) {
                    fillHeaderBiddingPlacementBuilder(newBuilder, ((Placement.VideoPlacement.Builder) builder).getExtProtoList());
                }
            }
            if (newBuilder.getAdUnitsList().isEmpty()) {
                return;
            }
            final BidToken bidToken = new BidToken(mapToAdRequest, obtainTokenConfiguration.getExpirationTime(), new BidTokenExpirationListener(anonymousClass1));
            storeBidToken(bidToken);
            requestTokenPayloadBuilder.getPlacementBuilder().setHbPlacement(newBuilder);
            requestTokenPayloadBuilder.setTokenHashValue(bidToken.getId());
            Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidTokenManager$$ExternalSyntheticLambda2
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("BidTokenId - %s", BidToken.this.getId());
                    return format;
                }
            });
        } catch (Throwable unused) {
            removeBidToken(requestTokenPayloadBuilder.getTokenHashValue());
        }
    }

    private static TokenConfiguration obtainTokenConfiguration(AdsFormat adsFormat) {
        TokenConfiguration tokenConfiguration = getTokenConfiguration(adsFormat);
        if (tokenConfiguration == null) {
            tokenConfiguration = getTokenConfiguration(adsFormat.getParent());
        }
        return tokenConfiguration == null ? TokenConfiguration.newBuilder().setExpirationTime(300).build() : tokenConfiguration;
    }

    private static void fillHeaderBiddingPlacementBuilder(HeaderBiddingPlacement.Builder headerBiddingPlacementBuilder, List<Any> extList) {
        Iterator<Any> it = extList.iterator();
        while (it.hasNext()) {
            try {
                headerBiddingPlacementBuilder.addAllAdUnits(((HeaderBiddingPlacement) it.next().unpack(HeaderBiddingPlacement.class)).getAdUnitsList());
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: io.bidmachine.BidTokenManager$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$bidmachine$AdsFormat;

        static {
            int[] iArr = new int[AdsFormat.values().length];
            $SwitchMap$io$bidmachine$AdsFormat = iArr;
            try {
                iArr[AdsFormat.Banner.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.Banner_320x50.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.Banner_300x250.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.Banner_728x90.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.Interstitial.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.InterstitialStatic.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.InterstitialVideo.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.Rewarded.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.RewardedStatic.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.RewardedVideo.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$io$bidmachine$AdsFormat[AdsFormat.Native.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private static AdRequest<?, ?, ?> mapToAdRequest(AdsFormat adsFormat) {
        switch (AnonymousClass1.$SwitchMap$io$bidmachine$AdsFormat[adsFormat.ordinal()]) {
            case 1:
            case 2:
                return new BannerRequest.Builder().setSize(BannerSize.Size_320x50).build();
            case 3:
                return new BannerRequest.Builder().setSize(BannerSize.Size_300x250).build();
            case 4:
                return new BannerRequest.Builder().setSize(BannerSize.Size_728x90).build();
            case 5:
                return new InterstitialRequest.Builder().setAdContentType(AdContentType.All).build();
            case 6:
                return new InterstitialRequest.Builder().setAdContentType(AdContentType.Static).build();
            case 7:
                return new InterstitialRequest.Builder().setAdContentType(AdContentType.Video).build();
            case 8:
                return new RewardedRequest.Builder().setAdContentType(AdContentType.All).build();
            case 9:
                return new RewardedRequest.Builder().setAdContentType(AdContentType.Static).build();
            case 10:
                return new RewardedRequest.Builder().setAdContentType(AdContentType.Video).build();
            case 11:
                return new NativeRequest.Builder().setMediaAssetTypes(MediaAssetType.All).build();
            default:
                return null;
        }
    }

    private static void sendSuccessEvent(AdsFormat adsFormat) {
        trackEvent(adsFormat, null);
    }

    private static void sendFailEvent(AdsFormat adsFormat, BMError bmError) {
        trackEvent(adsFormat, bmError);
    }

    private static void trackEvent(AdsFormat adsFormat, BMError bmError) {
        TRACKING_OBJECT.eventFinish(TrackEventType.GetBidToken, adsFormat != null ? adsFormat.getAdsType() : null, null, bmError);
    }

    static void storeBidToken(BidToken bidToken) {
        STORED_BID_TOKEN.put(bidToken.getId(), bidToken);
        bidToken.startExpiration();
    }

    static BidToken removeBidToken(BidToken bidToken) {
        return removeBidToken(bidToken.getId());
    }

    static BidToken removeBidToken(String bidTokenId) {
        BidToken remove = STORED_BID_TOKEN.remove(bidTokenId);
        if (remove != null) {
            remove.stopExpiration();
        }
        return remove;
    }

    static <T extends AdRequest<?, ?, ?>> T findPreparedAdRequest(ResponsePayload responsePayload) {
        if (responsePayload == null) {
            return null;
        }
        final String findTokenIdFromResponsePayload = findTokenIdFromResponsePayload(responsePayload);
        Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidTokenManager$$ExternalSyntheticLambda3
            @Override // io.bidmachine.utils.lazy.LazyValue
            public final Object get() {
                String format;
                format = String.format("BidTokenId from bidPayload - %s", findTokenIdFromResponsePayload);
                return format;
            }
        });
        if (TextUtils.isEmpty(findTokenIdFromResponsePayload)) {
            return null;
        }
        BidToken removeBidToken = removeBidToken(findTokenIdFromResponsePayload);
        if (removeBidToken == null) {
            Logger.d(TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidTokenManager$$ExternalSyntheticLambda4
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("BidToken is null by bidTokenId - %s", findTokenIdFromResponsePayload);
                    return format;
                }
            });
            return null;
        }
        return (T) removeBidToken.getAdRequest();
    }

    private static String findTokenIdFromResponsePayload(ResponsePayload bidPayload) {
        try {
            Value value = bidPayload.getResponseCache().getResponse().getExt().getFieldsMap().get("tokenHashValue");
            if (value == null) {
                return null;
            }
            return value.getStringValue();
        } catch (Throwable unused) {
            return null;
        }
    }

    static void setupTokenConfigurations(List<TokenConfiguration> tokenConfigurationList) {
        TOKEN_CONFIGURATION_MAP.clear();
        if (tokenConfigurationList != null) {
            for (TokenConfiguration tokenConfiguration : tokenConfigurationList) {
                AdsFormat byRemoteName = AdsFormat.byRemoteName(tokenConfiguration.getType());
                if (byRemoteName != null) {
                    TOKEN_CONFIGURATION_MAP.put(byRemoteName, tokenConfiguration);
                }
            }
        }
    }

    static TokenConfiguration getTokenConfiguration(AdsFormat adsFormat) {
        if (adsFormat == null) {
            return null;
        }
        return TOKEN_CONFIGURATION_MAP.get(adsFormat);
    }

    static Map<String, BidToken> getStoredBidToken() {
        return STORED_BID_TOKEN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class BidTokenExpirationListener implements ExpirationListener<BidToken> {
        private BidTokenExpirationListener() {
        }

        /* synthetic */ BidTokenExpirationListener(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // io.bidmachine.ExpirationListener
        public void onExpired(final BidToken bidToken) {
            Logger.d(BidTokenManager.TAG, (LazyValue<String>) new LazyValue() { // from class: io.bidmachine.BidTokenManager$BidTokenExpirationListener$$ExternalSyntheticLambda0
                @Override // io.bidmachine.utils.lazy.LazyValue
                public final Object get() {
                    String format;
                    format = String.format("BidToken expired - %s", BidToken.this.getId());
                    return format;
                }
            });
            BidTokenManager.removeBidToken(bidToken);
            bidToken.destroyAdRequest();
        }
    }
}
