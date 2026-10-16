package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.protobuf.ByteString;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.LoadResult;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.domain.AwaitInitialization;
import com.unity3d.ads.core.domain.GetInitializationState;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import gatewayprotocol.v1.AdRequestOuterClass;
import gatewayprotocol.v1.HeaderBiddingAdMarkupOuterClass;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: LegacyLoadUseCase.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/unity3d/ads/core/data/model/LoadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$loadResult$1", f = "LegacyLoadUseCase.kt", i = {1, 1}, l = {127, 134, 135}, m = "invokeSuspend", n = {"opportunityIdByteString", "headerBiddingAdMarkup"}, s = {"L$0", "L$1"})
/* loaded from: classes7.dex */
final class LegacyLoadUseCase$invoke$loadResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LoadResult>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ AdRequestOuterClass.BannerSize $gatewayBannerSize;
    final /* synthetic */ UnityAdsLoadOptions $loadOptions;
    final /* synthetic */ String $opportunityId;
    final /* synthetic */ String $placement;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ LegacyLoadUseCase this$0;

    /* compiled from: LegacyLoadUseCase.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InitializationState.values().length];
            try {
                iArr[InitializationState.INITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InitializationState.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InitializationState.NOT_INITIALIZED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[InitializationState.INITIALIZING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LegacyLoadUseCase$invoke$loadResult$1(String str, String str2, LegacyLoadUseCase legacyLoadUseCase, Context context, AdRequestOuterClass.BannerSize bannerSize, UnityAdsLoadOptions unityAdsLoadOptions, Continuation<? super LegacyLoadUseCase$invoke$loadResult$1> continuation) {
        super(2, continuation);
        this.$placement = str;
        this.$opportunityId = str2;
        this.this$0 = legacyLoadUseCase;
        this.$context = context;
        this.$gatewayBannerSize = bannerSize;
        this.$loadOptions = unityAdsLoadOptions;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LegacyLoadUseCase$invoke$loadResult$1(this.$placement, this.$opportunityId, this.this$0, this.$context, this.$gatewayBannerSize, this.$loadOptions, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LoadResult> continuation) {
        return ((LegacyLoadUseCase$invoke$loadResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x014d, code lost:
    
        if (r2 == r1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0182, code lost:
    
        if (r2 == r1) goto L54;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ec  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        AdRepository adRepository;
        String str;
        HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup;
        GetInitializationState getInitializationState;
        Load load;
        Object invoke;
        AwaitInitialization awaitInitialization;
        Object invoke$default;
        ByteString byteString;
        HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup2;
        int i;
        Load load2;
        Object invoke2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$placement == null) {
                return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INVALID_ARGUMENT, LoadResult.MSG_PLACEMENT_NULL, null, "placement_null", null, false, 52, null);
            }
            UUID fromString = UUID.fromString(this.$opportunityId);
            Intrinsics.checkNotNullExpressionValue(fromString, "fromString(opportunityId)");
            ByteString byteString2 = ProtobufExtensionsKt.toByteString(fromString);
            this.this$0.opportunity = byteString2;
            adRepository = this.this$0.adRepository;
            if (adRepository.hasOpportunityId(byteString2)) {
                new LoadResult.Failure(UnityAds.UnityAdsLoadError.INVALID_ARGUMENT, LoadResult.MSG_OPPORTUNITY_ID_USED, null, "opportunity_id_used", null, false, 52, null);
            }
            LegacyLoadUseCase legacyLoadUseCase = this.this$0;
            str = legacyLoadUseCase.adMarkup;
            headerBiddingAdMarkup = legacyLoadUseCase.getHeaderBiddingAdMarkup(str);
            if (headerBiddingAdMarkup != null) {
                getInitializationState = this.this$0.getInitializationState;
                int i3 = WhenMappings.$EnumSwitchMapping$0[GetInitializationState.DefaultImpls.invoke$default(getInitializationState, false, 1, null).ordinal()];
                if (i3 == 1) {
                    load = this.this$0.load;
                    this.label = 1;
                    invoke = load.invoke(this.$context, this.$placement, byteString2, headerBiddingAdMarkup, this.$gatewayBannerSize, this.$loadOptions, this);
                } else {
                    if (i3 == 2 || i3 == 3) {
                        return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INITIALIZE_FAILED, LoadResult.MSG_NOT_INITIALIZED, null, "not_initialized", null, false, 52, null);
                    }
                    if (i3 == 4) {
                        awaitInitialization = this.this$0.awaitInitialization;
                        this.L$0 = byteString2;
                        this.L$1 = headerBiddingAdMarkup;
                        this.label = 2;
                        invoke$default = AwaitInitialization.DefaultImpls.invoke$default(awaitInitialization, 0L, this, 1, null);
                        if (invoke$default != coroutine_suspended) {
                            byteString = byteString2;
                            headerBiddingAdMarkup2 = headerBiddingAdMarkup;
                            InitializationState initializationState = (InitializationState) invoke$default;
                            if (initializationState != null) {
                            }
                            if (i == 1) {
                            }
                        }
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                return coroutine_suspended;
            }
            return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INTERNAL_ERROR, LoadResult.MSG_AD_MARKUP_PARSING, null, "invalid_admarkup", null, false, 52, null);
        }
        if (i2 == 1) {
            ResultKt.throwOnFailure(obj);
            invoke = obj;
            return (LoadResult) invoke;
        }
        if (i2 != 2) {
            if (i2 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            invoke2 = obj;
            return (LoadResult) invoke2;
        }
        HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup headerBiddingAdMarkup3 = (HeaderBiddingAdMarkupOuterClass.HeaderBiddingAdMarkup) this.L$1;
        ByteString byteString3 = (ByteString) this.L$0;
        ResultKt.throwOnFailure(obj);
        headerBiddingAdMarkup2 = headerBiddingAdMarkup3;
        byteString = byteString3;
        invoke$default = obj;
        InitializationState initializationState2 = (InitializationState) invoke$default;
        i = initializationState2 != null ? -1 : WhenMappings.$EnumSwitchMapping$0[initializationState2.ordinal()];
        if (i == 1) {
            if (i == 2) {
                return new LoadResult.Failure(UnityAds.UnityAdsLoadError.INITIALIZE_FAILED, LoadResult.MSG_NOT_INITIALIZED, null, "not_initialized", null, false, 52, null);
            }
            return new LoadResult.Failure(UnityAds.UnityAdsLoadError.TIMEOUT, LoadResult.MSG_TIMEOUT + this.$placement, null, "timeout_initialization", null, false, 52, null);
        }
        load2 = this.this$0.load;
        this.L$0 = null;
        this.L$1 = null;
        this.label = 3;
        invoke2 = load2.invoke(this.$context, this.$placement, byteString, headerBiddingAdMarkup2, this.$gatewayBannerSize, this.$loadOptions, this);
    }
}
