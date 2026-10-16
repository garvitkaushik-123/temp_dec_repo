package io.adn.sdk.internal.data.repository;

import adn.analytics.AdnDataConverter;
import adn.analytics.ProtoConversionResult;
import io.adn.sdk.internal.common.utils.ConversionsKt;
import io.adn.sdk.internal.common.utils.DateKt;
import io.adn.sdk.internal.common.utils.JsonKt;
import io.adn.sdk.internal.data.api.local.AdvertisingIdsApi;
import io.adn.sdk.internal.data.api.local.LocalDataSource;
import io.adn.sdk.internal.data.api.local.SystemInfoApi;
import io.adn.sdk.internal.data.service.NetworkStatusService;
import io.adn.sdk.internal.domain.diagnostic.DiagnosticReporter;
import io.adn.sdk.internal.domain.error.AdError;
import io.adn.sdk.internal.domain.error.AdException;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEventBuilder;
import io.adn.sdk.internal.domain.model.privacy.AdvertisingInfo;
import io.adn.sdk.internal.domain.model.privacy.AdvertisingInfoKt;
import io.adn.sdk.internal.domain.model.privacy.PrivacyInfo;
import io.adn.sdk.internal.domain.repository.BidTokenRepository;
import io.adn.sdk.internal.domain.repository.ExternalDataSource;
import io.adn.sdk.publisher.AdnAdPlacement;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: BidTokenRepository.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\t\b\u0001\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0016\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0096@¢\u0006\u0002\u0010\u0015J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u001e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0082@¢\u0006\u0002\u0010\u001dJ\u0018\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0017H\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0012\u0010 \u001a\u00020\u001a2\b\u0010!\u001a\u0004\u0018\u00010\u0012H\u0002J&\u0010\"\u001a\u00020\u001a2\u0006\u0010#\u001a\u00020\u001a2\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0002J\b\u0010'\u001a\u00020(H\u0002J\u0016\u0010)\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010+J\u0016\u0010,\u001a\u00020-2\u0006\u0010#\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010+J\u001e\u0010.\u001a\u00020-2\u0006\u0010#\u001a\u00020\u001a2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001200H\u0002J\u0010\u00101\u001a\u00020-2\u0006\u0010#\u001a\u00020\u001aH\u0002J\u0016\u00102\u001a\u00020-2\u0006\u0010#\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010+J\u0016\u00103\u001a\u00020-2\u0006\u0010#\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010+J\u0016\u00104\u001a\u00020-2\u0006\u0010#\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010+J\u0010\u00105\u001a\u00020\u00122\u0006\u00106\u001a\u00020\u001aH\u0002J\u0016\u00107\u001a\u00020-2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001200H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lio/adn/sdk/internal/data/repository/BidTokenRepositoryImpl;", "Lio/adn/sdk/internal/domain/repository/BidTokenRepository;", "local", "Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "networkStatus", "Lio/adn/sdk/internal/data/service/NetworkStatusService;", "adnDataConverter", "Ladn/analytics/AdnDataConverter;", "diagnosticReporter", "Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;", "<init>", "(Lio/adn/sdk/internal/data/api/local/LocalDataSource;Lio/adn/sdk/internal/data/service/NetworkStatusService;Ladn/analytics/AdnDataConverter;Lio/adn/sdk/internal/domain/diagnostic/DiagnosticReporter;)V", "tokenIndex", "Ljava/util/concurrent/atomic/AtomicInteger;", "interstitialTokenIndex", "rewardedTokenIndex", "nativeTokenIndex", "buildBidToken", "", "placement", "Lio/adn/sdk/publisher/AdnAdPlacement;", "(Lio/adn/sdk/publisher/AdnAdPlacement;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGlobalTokenIndex", "", "getPlacementTokenIndex", "createTokenJSONObject", "Lorg/json/JSONObject;", "globalIndex", "placementIndex", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBaseTokenData", "collectPublisherSignals", "parsePublisherSignalsJson", "publisherSignalsJson", "addPublisherSignalsMap", "jsonObject", "signalsMap", "", "", "canUsePersonalizedData", "", "addPersonalizedData", "baseData", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addSystemInfo", "", "addKeyboardLanguages", "languages", "", "addPrivacyInfo", "addLimitAdTrackingFlag", "addAppSetIdScope", "addAdvertisingInfo", "serializeToProtobufBase64", "jsonData", "reportProtoConversionError", "errors", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class BidTokenRepositoryImpl implements BidTokenRepository {
    public static final int $stable = 8;
    private final AdnDataConverter adnDataConverter;
    private final DiagnosticReporter diagnosticReporter;
    private final AtomicInteger interstitialTokenIndex;
    private final LocalDataSource local;
    private final AtomicInteger nativeTokenIndex;
    private final NetworkStatusService networkStatus;
    private final AtomicInteger rewardedTokenIndex;
    private final AtomicInteger tokenIndex;

    /* compiled from: BidTokenRepository.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AdnAdPlacement.values().length];
            try {
                iArr[AdnAdPlacement.INTERSTITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AdnAdPlacement.REWARDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AdnAdPlacement.NATIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public BidTokenRepositoryImpl(LocalDataSource local, NetworkStatusService networkStatus, AdnDataConverter adnDataConverter, DiagnosticReporter diagnosticReporter) {
        Intrinsics.checkNotNullParameter(local, "local");
        Intrinsics.checkNotNullParameter(networkStatus, "networkStatus");
        Intrinsics.checkNotNullParameter(adnDataConverter, "adnDataConverter");
        Intrinsics.checkNotNullParameter(diagnosticReporter, "diagnosticReporter");
        this.local = local;
        this.networkStatus = networkStatus;
        this.adnDataConverter = adnDataConverter;
        this.diagnosticReporter = diagnosticReporter;
        this.tokenIndex = new AtomicInteger(0);
        this.interstitialTokenIndex = new AtomicInteger(0);
        this.rewardedTokenIndex = new AtomicInteger(0);
        this.nativeTokenIndex = new AtomicInteger(0);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.adn.sdk.internal.domain.repository.BidTokenRepository
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object buildBidToken(AdnAdPlacement adnAdPlacement, Continuation<? super String> continuation) {
        BidTokenRepositoryImpl$buildBidToken$1 bidTokenRepositoryImpl$buildBidToken$1;
        int i;
        BidTokenRepositoryImpl bidTokenRepositoryImpl;
        if (continuation instanceof BidTokenRepositoryImpl$buildBidToken$1) {
            bidTokenRepositoryImpl$buildBidToken$1 = (BidTokenRepositoryImpl$buildBidToken$1) continuation;
            if ((bidTokenRepositoryImpl$buildBidToken$1.label & Integer.MIN_VALUE) != 0) {
                bidTokenRepositoryImpl$buildBidToken$1.label -= Integer.MIN_VALUE;
                Object obj = bidTokenRepositoryImpl$buildBidToken$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bidTokenRepositoryImpl$buildBidToken$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    int globalTokenIndex = getGlobalTokenIndex();
                    int placementTokenIndex = getPlacementTokenIndex(adnAdPlacement);
                    bidTokenRepositoryImpl$buildBidToken$1.L$0 = this;
                    bidTokenRepositoryImpl$buildBidToken$1.label = 1;
                    obj = createTokenJSONObject(globalTokenIndex, placementTokenIndex, bidTokenRepositoryImpl$buildBidToken$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    bidTokenRepositoryImpl = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    bidTokenRepositoryImpl = (BidTokenRepositoryImpl) bidTokenRepositoryImpl$buildBidToken$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return bidTokenRepositoryImpl.serializeToProtobufBase64((JSONObject) obj);
            }
        }
        bidTokenRepositoryImpl$buildBidToken$1 = new BidTokenRepositoryImpl$buildBidToken$1(this, continuation);
        Object obj2 = bidTokenRepositoryImpl$buildBidToken$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bidTokenRepositoryImpl$buildBidToken$1.label;
        if (i != 0) {
        }
        return bidTokenRepositoryImpl.serializeToProtobufBase64((JSONObject) obj2);
    }

    private final int getGlobalTokenIndex() {
        return this.tokenIndex.incrementAndGet();
    }

    private final int getPlacementTokenIndex(AdnAdPlacement placement) {
        int i = WhenMappings.$EnumSwitchMapping$0[placement.ordinal()];
        if (i == 1) {
            return this.interstitialTokenIndex.incrementAndGet();
        }
        if (i == 2) {
            return this.rewardedTokenIndex.incrementAndGet();
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return this.nativeTokenIndex.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x007a, code lost:
    
        if (r9 != r1) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object createTokenJSONObject(int i, int i2, Continuation<? super JSONObject> continuation) {
        BidTokenRepositoryImpl$createTokenJSONObject$1 bidTokenRepositoryImpl$createTokenJSONObject$1;
        int i3;
        BidTokenRepositoryImpl bidTokenRepositoryImpl;
        JSONObject jSONObject;
        BidTokenRepositoryImpl bidTokenRepositoryImpl2;
        JSONObject jSONObject2;
        if (continuation instanceof BidTokenRepositoryImpl$createTokenJSONObject$1) {
            bidTokenRepositoryImpl$createTokenJSONObject$1 = (BidTokenRepositoryImpl$createTokenJSONObject$1) continuation;
            if ((bidTokenRepositoryImpl$createTokenJSONObject$1.label & Integer.MIN_VALUE) != 0) {
                bidTokenRepositoryImpl$createTokenJSONObject$1.label -= Integer.MIN_VALUE;
                Object obj = bidTokenRepositoryImpl$createTokenJSONObject$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = bidTokenRepositoryImpl$createTokenJSONObject$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    JSONObject mergeWith = JsonKt.mergeWith(createBaseTokenData(i, i2), collectPublisherSignals());
                    addPrivacyInfo(mergeWith);
                    bidTokenRepositoryImpl$createTokenJSONObject$1.L$0 = this;
                    bidTokenRepositoryImpl$createTokenJSONObject$1.L$1 = mergeWith;
                    bidTokenRepositoryImpl$createTokenJSONObject$1.label = 1;
                    if (addLimitAdTrackingFlag(mergeWith, bidTokenRepositoryImpl$createTokenJSONObject$1) != coroutine_suspended) {
                        bidTokenRepositoryImpl = this;
                        jSONObject = mergeWith;
                    }
                    return coroutine_suspended;
                }
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    JSONObject jSONObject3 = (JSONObject) bidTokenRepositoryImpl$createTokenJSONObject$1.L$1;
                    BidTokenRepositoryImpl bidTokenRepositoryImpl3 = (BidTokenRepositoryImpl) bidTokenRepositoryImpl$createTokenJSONObject$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    jSONObject2 = jSONObject3;
                    bidTokenRepositoryImpl2 = bidTokenRepositoryImpl3;
                    Object obj2 = jSONObject2;
                    if (bidTokenRepositoryImpl2.canUsePersonalizedData()) {
                        bidTokenRepositoryImpl$createTokenJSONObject$1.L$0 = null;
                        bidTokenRepositoryImpl$createTokenJSONObject$1.L$1 = null;
                        bidTokenRepositoryImpl$createTokenJSONObject$1.label = 3;
                        Object addPersonalizedData = bidTokenRepositoryImpl2.addPersonalizedData(jSONObject2, bidTokenRepositoryImpl$createTokenJSONObject$1);
                        obj2 = addPersonalizedData;
                        if (addPersonalizedData == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    return obj2;
                }
                JSONObject jSONObject4 = (JSONObject) bidTokenRepositoryImpl$createTokenJSONObject$1.L$1;
                BidTokenRepositoryImpl bidTokenRepositoryImpl4 = (BidTokenRepositoryImpl) bidTokenRepositoryImpl$createTokenJSONObject$1.L$0;
                ResultKt.throwOnFailure(obj);
                jSONObject = jSONObject4;
                bidTokenRepositoryImpl = bidTokenRepositoryImpl4;
                bidTokenRepositoryImpl$createTokenJSONObject$1.L$0 = bidTokenRepositoryImpl;
                bidTokenRepositoryImpl$createTokenJSONObject$1.L$1 = jSONObject;
                bidTokenRepositoryImpl$createTokenJSONObject$1.label = 2;
                Object addAppSetIdScope = bidTokenRepositoryImpl.addAppSetIdScope(jSONObject, bidTokenRepositoryImpl$createTokenJSONObject$1);
                jSONObject2 = jSONObject;
                bidTokenRepositoryImpl2 = bidTokenRepositoryImpl;
            }
        }
        bidTokenRepositoryImpl$createTokenJSONObject$1 = new BidTokenRepositoryImpl$createTokenJSONObject$1(this, continuation);
        Object obj3 = bidTokenRepositoryImpl$createTokenJSONObject$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = bidTokenRepositoryImpl$createTokenJSONObject$1.label;
        if (i3 != 0) {
        }
        bidTokenRepositoryImpl$createTokenJSONObject$1.L$0 = bidTokenRepositoryImpl;
        bidTokenRepositoryImpl$createTokenJSONObject$1.L$1 = jSONObject;
        bidTokenRepositoryImpl$createTokenJSONObject$1.label = 2;
        Object addAppSetIdScope2 = bidTokenRepositoryImpl.addAppSetIdScope(jSONObject, bidTokenRepositoryImpl$createTokenJSONObject$1);
        jSONObject2 = jSONObject;
        bidTokenRepositoryImpl2 = bidTokenRepositoryImpl;
    }

    private final JSONObject createBaseTokenData(int globalIndex, int placementIndex) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("global_token_index", globalIndex);
        jSONObject.put(BidTokenRepositoryKt.TOKEN_INDEX, placementIndex);
        jSONObject.put(BidTokenRepositoryKt.UTC_DATE, DateKt.utcNow());
        jSONObject.put(BidTokenRepositoryKt.LOCAL_DATE, DateKt.now());
        jSONObject.put(BidTokenRepositoryKt.SDK_VERSION, "4.25.2");
        jSONObject.put(BidTokenRepositoryKt.APP_VERSION, this.local.getAppInfo().getAppVersion());
        jSONObject.put("test_mode", ConversionsKt.toInt(this.local.getExternalData().getIsTestMode()));
        jSONObject.put("orientation", this.local.getSystemInfo().orientation());
        jSONObject.put(BidTokenRepositoryKt.DEVICE_MODEL, this.local.getSystemInfo().getModel());
        jSONObject.put(BidTokenRepositoryKt.DEVICE_MANUFACTURER, this.local.getSystemInfo().getManufacturer());
        return jSONObject;
    }

    private final JSONObject collectPublisherSignals() {
        Object m10241constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            BidTokenRepositoryImpl bidTokenRepositoryImpl = this;
            ExternalDataSource externalData = this.local.getExternalData();
            m10241constructorimpl = Result.m10241constructorimpl(addPublisherSignalsMap(parsePublisherSignalsJson(externalData.getPublisherSignalsJson()), externalData.publisherSignalsMap()));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        JSONObject jSONObject = new JSONObject();
        if (Result.m10247isFailureimpl(m10241constructorimpl)) {
            m10241constructorimpl = jSONObject;
        }
        return (JSONObject) m10241constructorimpl;
    }

    private final JSONObject parsePublisherSignalsJson(String publisherSignalsJson) {
        return publisherSignalsJson != null ? new JSONObject(publisherSignalsJson) : new JSONObject();
    }

    private final boolean canUsePersonalizedData() {
        return this.local.getExternalData().getPrivacyInfo().canUseData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0063 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object addPersonalizedData(JSONObject jSONObject, Continuation<? super JSONObject> continuation) {
        BidTokenRepositoryImpl$addPersonalizedData$1 bidTokenRepositoryImpl$addPersonalizedData$1;
        int i;
        BidTokenRepositoryImpl bidTokenRepositoryImpl;
        if (continuation instanceof BidTokenRepositoryImpl$addPersonalizedData$1) {
            bidTokenRepositoryImpl$addPersonalizedData$1 = (BidTokenRepositoryImpl$addPersonalizedData$1) continuation;
            if ((bidTokenRepositoryImpl$addPersonalizedData$1.label & Integer.MIN_VALUE) != 0) {
                bidTokenRepositoryImpl$addPersonalizedData$1.label -= Integer.MIN_VALUE;
                Object obj = bidTokenRepositoryImpl$addPersonalizedData$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bidTokenRepositoryImpl$addPersonalizedData$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    bidTokenRepositoryImpl$addPersonalizedData$1.L$0 = this;
                    bidTokenRepositoryImpl$addPersonalizedData$1.L$1 = jSONObject;
                    bidTokenRepositoryImpl$addPersonalizedData$1.label = 1;
                    if (addSystemInfo(jSONObject, bidTokenRepositoryImpl$addPersonalizedData$1) != coroutine_suspended) {
                        bidTokenRepositoryImpl = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    JSONObject jSONObject2 = (JSONObject) bidTokenRepositoryImpl$addPersonalizedData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return jSONObject2;
                }
                jSONObject = (JSONObject) bidTokenRepositoryImpl$addPersonalizedData$1.L$1;
                bidTokenRepositoryImpl = (BidTokenRepositoryImpl) bidTokenRepositoryImpl$addPersonalizedData$1.L$0;
                ResultKt.throwOnFailure(obj);
                bidTokenRepositoryImpl$addPersonalizedData$1.L$0 = jSONObject;
                bidTokenRepositoryImpl$addPersonalizedData$1.L$1 = null;
                bidTokenRepositoryImpl$addPersonalizedData$1.label = 2;
                return bidTokenRepositoryImpl.addAdvertisingInfo(jSONObject, bidTokenRepositoryImpl$addPersonalizedData$1) != coroutine_suspended ? coroutine_suspended : jSONObject;
            }
        }
        bidTokenRepositoryImpl$addPersonalizedData$1 = new BidTokenRepositoryImpl$addPersonalizedData$1(this, continuation);
        Object obj2 = bidTokenRepositoryImpl$addPersonalizedData$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bidTokenRepositoryImpl$addPersonalizedData$1.label;
        if (i != 0) {
        }
        bidTokenRepositoryImpl$addPersonalizedData$1.L$0 = jSONObject;
        bidTokenRepositoryImpl$addPersonalizedData$1.L$1 = null;
        bidTokenRepositoryImpl$addPersonalizedData$1.label = 2;
        if (bidTokenRepositoryImpl.addAdvertisingInfo(jSONObject, bidTokenRepositoryImpl$addPersonalizedData$1) != coroutine_suspended2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object addSystemInfo(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        BidTokenRepositoryImpl$addSystemInfo$1 bidTokenRepositoryImpl$addSystemInfo$1;
        int i;
        JSONObject jSONObject2;
        SystemInfoApi systemInfoApi;
        String str;
        BidTokenRepositoryImpl bidTokenRepositoryImpl;
        JSONObject jSONObject3;
        if (continuation instanceof BidTokenRepositoryImpl$addSystemInfo$1) {
            bidTokenRepositoryImpl$addSystemInfo$1 = (BidTokenRepositoryImpl$addSystemInfo$1) continuation;
            if ((bidTokenRepositoryImpl$addSystemInfo$1.label & Integer.MIN_VALUE) != 0) {
                bidTokenRepositoryImpl$addSystemInfo$1.label -= Integer.MIN_VALUE;
                Object obj = bidTokenRepositoryImpl$addSystemInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bidTokenRepositoryImpl$addSystemInfo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    SystemInfoApi systemInfo = this.local.getSystemInfo();
                    jSONObject.put(BidTokenRepositoryKt.AIRPLANE_MODE_ENABLE, systemInfo.isAirplaneModeEnabled());
                    NetworkStatusService networkStatusService = this.networkStatus;
                    bidTokenRepositoryImpl$addSystemInfo$1.L$0 = this;
                    bidTokenRepositoryImpl$addSystemInfo$1.L$1 = jSONObject;
                    bidTokenRepositoryImpl$addSystemInfo$1.L$2 = systemInfo;
                    bidTokenRepositoryImpl$addSystemInfo$1.L$3 = jSONObject;
                    bidTokenRepositoryImpl$addSystemInfo$1.L$4 = jSONObject;
                    bidTokenRepositoryImpl$addSystemInfo$1.L$5 = "connectivity";
                    bidTokenRepositoryImpl$addSystemInfo$1.L$6 = jSONObject;
                    bidTokenRepositoryImpl$addSystemInfo$1.label = 1;
                    Object currentConnectionType = networkStatusService.currentConnectionType(bidTokenRepositoryImpl$addSystemInfo$1);
                    if (currentConnectionType == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    jSONObject2 = jSONObject;
                    systemInfoApi = systemInfo;
                    obj = currentConnectionType;
                    str = "connectivity";
                    bidTokenRepositoryImpl = this;
                    jSONObject3 = jSONObject2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    jSONObject = (JSONObject) bidTokenRepositoryImpl$addSystemInfo$1.L$6;
                    str = (String) bidTokenRepositoryImpl$addSystemInfo$1.L$5;
                    jSONObject2 = (JSONObject) bidTokenRepositoryImpl$addSystemInfo$1.L$4;
                    systemInfoApi = (SystemInfoApi) bidTokenRepositoryImpl$addSystemInfo$1.L$2;
                    jSONObject3 = (JSONObject) bidTokenRepositoryImpl$addSystemInfo$1.L$1;
                    bidTokenRepositoryImpl = (BidTokenRepositoryImpl) bidTokenRepositoryImpl$addSystemInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                jSONObject.put(str, obj);
                jSONObject2.put(BidTokenRepositoryKt.BATTERY, systemInfoApi.batteryLevel());
                jSONObject2.put(BidTokenRepositoryKt.BATTERY_SAVER_ENABLE, systemInfoApi.isBatterySaverEnabled());
                jSONObject2.put(BidTokenRepositoryKt.BATT_CHARGE, systemInfoApi.isBatteryCharging());
                jSONObject2.put("bluetooth", systemInfoApi.isBluetoothEnabled());
                jSONObject2.put(BidTokenRepositoryKt.DARK_MODE_ENABLE, systemInfoApi.isNightModeEnabled());
                jSONObject2.put(BidTokenRepositoryKt.AVAILABLE_DISK_SPACE, systemInfoApi.availableDiskSpaceInMB());
                jSONObject2.put(BidTokenRepositoryKt.TOTAL_DISK_SPACE, systemInfoApi.totalDiskSpaceInMB());
                jSONObject2.put(BidTokenRepositoryKt.DO_NOT_DIST, systemInfoApi.doNotDisturbStatus());
                jSONObject2.put(BidTokenRepositoryKt.HEADSET, systemInfoApi.hasHeadset());
                jSONObject2.put(BidTokenRepositoryKt.SOUND_ENABLE, systemInfoApi.isSoundEnabled());
                jSONObject2.put(BidTokenRepositoryKt.PPI, systemInfoApi.getPpi());
                jSONObject2.put(BidTokenRepositoryKt.IS_WALKING, systemInfoApi.isWalking());
                jSONObject2.put("boot_time", systemInfoApi.bootTime());
                bidTokenRepositoryImpl.addKeyboardLanguages(jSONObject3, systemInfoApi.keyboardLanguages());
                return Unit.INSTANCE;
            }
        }
        bidTokenRepositoryImpl$addSystemInfo$1 = new BidTokenRepositoryImpl$addSystemInfo$1(this, continuation);
        Object obj2 = bidTokenRepositoryImpl$addSystemInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bidTokenRepositoryImpl$addSystemInfo$1.label;
        if (i != 0) {
        }
        jSONObject.put(str, obj2);
        jSONObject2.put(BidTokenRepositoryKt.BATTERY, systemInfoApi.batteryLevel());
        jSONObject2.put(BidTokenRepositoryKt.BATTERY_SAVER_ENABLE, systemInfoApi.isBatterySaverEnabled());
        jSONObject2.put(BidTokenRepositoryKt.BATT_CHARGE, systemInfoApi.isBatteryCharging());
        jSONObject2.put("bluetooth", systemInfoApi.isBluetoothEnabled());
        jSONObject2.put(BidTokenRepositoryKt.DARK_MODE_ENABLE, systemInfoApi.isNightModeEnabled());
        jSONObject2.put(BidTokenRepositoryKt.AVAILABLE_DISK_SPACE, systemInfoApi.availableDiskSpaceInMB());
        jSONObject2.put(BidTokenRepositoryKt.TOTAL_DISK_SPACE, systemInfoApi.totalDiskSpaceInMB());
        jSONObject2.put(BidTokenRepositoryKt.DO_NOT_DIST, systemInfoApi.doNotDisturbStatus());
        jSONObject2.put(BidTokenRepositoryKt.HEADSET, systemInfoApi.hasHeadset());
        jSONObject2.put(BidTokenRepositoryKt.SOUND_ENABLE, systemInfoApi.isSoundEnabled());
        jSONObject2.put(BidTokenRepositoryKt.PPI, systemInfoApi.getPpi());
        jSONObject2.put(BidTokenRepositoryKt.IS_WALKING, systemInfoApi.isWalking());
        jSONObject2.put("boot_time", systemInfoApi.bootTime());
        bidTokenRepositoryImpl.addKeyboardLanguages(jSONObject3, systemInfoApi.keyboardLanguages());
        return Unit.INSTANCE;
    }

    private final void addKeyboardLanguages(JSONObject jsonObject, List<String> languages) {
        jsonObject.put("keyboard_lang", new JSONArray((Collection) languages));
    }

    private final void addPrivacyInfo(JSONObject jsonObject) {
        PrivacyInfo privacyInfo = this.local.getExternalData().getPrivacyInfo();
        jsonObject.put("do_not_sell", ConversionsKt.toInt(privacyInfo.getDoNotSell()));
        jsonObject.put(BidTokenRepositoryKt.ADS_CONSENT_GIVEN, ConversionsKt.toInt(privacyInfo.getHasUserConsent()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object addLimitAdTrackingFlag(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        BidTokenRepositoryImpl$addLimitAdTrackingFlag$1 bidTokenRepositoryImpl$addLimitAdTrackingFlag$1;
        int i;
        Boolean limitAdTrackingEnabled;
        if (continuation instanceof BidTokenRepositoryImpl$addLimitAdTrackingFlag$1) {
            bidTokenRepositoryImpl$addLimitAdTrackingFlag$1 = (BidTokenRepositoryImpl$addLimitAdTrackingFlag$1) continuation;
            if ((bidTokenRepositoryImpl$addLimitAdTrackingFlag$1.label & Integer.MIN_VALUE) != 0) {
                bidTokenRepositoryImpl$addLimitAdTrackingFlag$1.label -= Integer.MIN_VALUE;
                Object obj = bidTokenRepositoryImpl$addLimitAdTrackingFlag$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bidTokenRepositoryImpl$addLimitAdTrackingFlag$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AdvertisingIdsApi advertisingIds = this.local.getAdvertisingIds();
                    bidTokenRepositoryImpl$addLimitAdTrackingFlag$1.L$0 = jSONObject;
                    bidTokenRepositoryImpl$addLimitAdTrackingFlag$1.label = 1;
                    obj = advertisingIds.getAdvertisingInfo(bidTokenRepositoryImpl$addLimitAdTrackingFlag$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    jSONObject = (JSONObject) bidTokenRepositoryImpl$addLimitAdTrackingFlag$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                AdvertisingInfo advertisingInfo = (AdvertisingInfo) obj;
                JsonKt.putIfNotNull(jSONObject, "limit_ad_tracking", (advertisingInfo != null || (limitAdTrackingEnabled = advertisingInfo.getLimitAdTrackingEnabled()) == null) ? null : Boxing.boxInt(ConversionsKt.toInt(limitAdTrackingEnabled.booleanValue())));
                jSONObject.put("idfa_authorization_status", AdvertisingInfoKt.authorizationStatus(advertisingInfo));
                return Unit.INSTANCE;
            }
        }
        bidTokenRepositoryImpl$addLimitAdTrackingFlag$1 = new BidTokenRepositoryImpl$addLimitAdTrackingFlag$1(this, continuation);
        Object obj2 = bidTokenRepositoryImpl$addLimitAdTrackingFlag$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bidTokenRepositoryImpl$addLimitAdTrackingFlag$1.label;
        if (i != 0) {
        }
        AdvertisingInfo advertisingInfo2 = (AdvertisingInfo) obj2;
        JsonKt.putIfNotNull(jSONObject, "limit_ad_tracking", (advertisingInfo2 != null || (limitAdTrackingEnabled = advertisingInfo2.getLimitAdTrackingEnabled()) == null) ? null : Boxing.boxInt(ConversionsKt.toInt(limitAdTrackingEnabled.booleanValue())));
        jSONObject.put("idfa_authorization_status", AdvertisingInfoKt.authorizationStatus(advertisingInfo2));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object addAppSetIdScope(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        BidTokenRepositoryImpl$addAppSetIdScope$1 bidTokenRepositoryImpl$addAppSetIdScope$1;
        int i;
        if (continuation instanceof BidTokenRepositoryImpl$addAppSetIdScope$1) {
            bidTokenRepositoryImpl$addAppSetIdScope$1 = (BidTokenRepositoryImpl$addAppSetIdScope$1) continuation;
            if ((bidTokenRepositoryImpl$addAppSetIdScope$1.label & Integer.MIN_VALUE) != 0) {
                bidTokenRepositoryImpl$addAppSetIdScope$1.label -= Integer.MIN_VALUE;
                Object obj = bidTokenRepositoryImpl$addAppSetIdScope$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bidTokenRepositoryImpl$addAppSetIdScope$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AdvertisingIdsApi advertisingIds = this.local.getAdvertisingIds();
                    bidTokenRepositoryImpl$addAppSetIdScope$1.L$0 = jSONObject;
                    bidTokenRepositoryImpl$addAppSetIdScope$1.label = 1;
                    obj = advertisingIds.getAdvertisingInfo(bidTokenRepositoryImpl$addAppSetIdScope$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    jSONObject = (JSONObject) bidTokenRepositoryImpl$addAppSetIdScope$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                AdvertisingInfo advertisingInfo = (AdvertisingInfo) obj;
                JsonKt.putIfNotNull(jSONObject, "appset_id_scope", advertisingInfo == null ? advertisingInfo.getAppSetIdScope() : null);
                return Unit.INSTANCE;
            }
        }
        bidTokenRepositoryImpl$addAppSetIdScope$1 = new BidTokenRepositoryImpl$addAppSetIdScope$1(this, continuation);
        Object obj2 = bidTokenRepositoryImpl$addAppSetIdScope$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bidTokenRepositoryImpl$addAppSetIdScope$1.label;
        if (i != 0) {
        }
        AdvertisingInfo advertisingInfo2 = (AdvertisingInfo) obj2;
        JsonKt.putIfNotNull(jSONObject, "appset_id_scope", advertisingInfo2 == null ? advertisingInfo2.getAppSetIdScope() : null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object addAdvertisingInfo(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        BidTokenRepositoryImpl$addAdvertisingInfo$1 bidTokenRepositoryImpl$addAdvertisingInfo$1;
        int i;
        if (continuation instanceof BidTokenRepositoryImpl$addAdvertisingInfo$1) {
            bidTokenRepositoryImpl$addAdvertisingInfo$1 = (BidTokenRepositoryImpl$addAdvertisingInfo$1) continuation;
            if ((bidTokenRepositoryImpl$addAdvertisingInfo$1.label & Integer.MIN_VALUE) != 0) {
                bidTokenRepositoryImpl$addAdvertisingInfo$1.label -= Integer.MIN_VALUE;
                Object obj = bidTokenRepositoryImpl$addAdvertisingInfo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bidTokenRepositoryImpl$addAdvertisingInfo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    AdvertisingIdsApi advertisingIds = this.local.getAdvertisingIds();
                    bidTokenRepositoryImpl$addAdvertisingInfo$1.L$0 = jSONObject;
                    bidTokenRepositoryImpl$addAdvertisingInfo$1.label = 1;
                    obj = advertisingIds.getAdvertisingInfo(bidTokenRepositoryImpl$addAdvertisingInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    jSONObject = (JSONObject) bidTokenRepositoryImpl$addAdvertisingInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                AdvertisingInfo advertisingInfo = (AdvertisingInfo) obj;
                JsonKt.putIfNotNull(jSONObject, "gaid", advertisingInfo == null ? advertisingInfo.getAdvertisingId() : null);
                JsonKt.putIfNotNull(jSONObject, BidTokenRepositoryKt.APPSET_ID, advertisingInfo != null ? advertisingInfo.getAppSetId() : null);
                return Unit.INSTANCE;
            }
        }
        bidTokenRepositoryImpl$addAdvertisingInfo$1 = new BidTokenRepositoryImpl$addAdvertisingInfo$1(this, continuation);
        Object obj2 = bidTokenRepositoryImpl$addAdvertisingInfo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bidTokenRepositoryImpl$addAdvertisingInfo$1.label;
        if (i != 0) {
        }
        AdvertisingInfo advertisingInfo2 = (AdvertisingInfo) obj2;
        JsonKt.putIfNotNull(jSONObject, "gaid", advertisingInfo2 == null ? advertisingInfo2.getAdvertisingId() : null);
        JsonKt.putIfNotNull(jSONObject, BidTokenRepositoryKt.APPSET_ID, advertisingInfo2 != null ? advertisingInfo2.getAppSetId() : null);
        return Unit.INSTANCE;
    }

    private final String serializeToProtobufBase64(JSONObject jsonData) {
        ProtoConversionResult convertToProto = this.adnDataConverter.convertToProto(jsonData);
        if (!convertToProto.getErrors().isEmpty()) {
            reportProtoConversionError(convertToProto.getErrors());
        }
        return convertToProto.getProtobufBase64();
    }

    private final void reportProtoConversionError(List<String> errors) {
        try {
            Result.Companion companion = Result.INSTANCE;
            BidTokenRepositoryImpl bidTokenRepositoryImpl = this;
            AdException adException = new AdException(AdError.ProtoFieldConversionError, CollectionsKt.joinToString$default(errors, "; ", null, null, 0, null, null, 62, null));
            this.diagnosticReporter.reportFailure(new DiagnosticEventBuilder.TokenGeneration(), adException);
            Result.m10241constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    private final JSONObject addPublisherSignalsMap(JSONObject jsonObject, Map<String, ? extends Object> signalsMap) {
        if (signalsMap != null) {
            for (Map.Entry<String, ? extends Object> entry : signalsMap.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }
        }
        return jsonObject;
    }
}
