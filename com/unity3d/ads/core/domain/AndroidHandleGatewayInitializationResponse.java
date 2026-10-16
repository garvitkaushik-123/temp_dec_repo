package com.unity3d.ads.core.domain;

import com.ironsource.C3337ue;
import com.unity3d.ads.core.data.manager.TransactionEventManager;
import com.unity3d.ads.core.data.model.exception.GatewayException;
import com.unity3d.ads.core.data.repository.SessionRepository;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import gatewayprotocol.v1.NativeConfigurationOuterClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidHandleGatewayInitializationResponse.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidHandleGatewayInitializationResponse;", "Lcom/unity3d/ads/core/domain/HandleGatewayInitializationResponse;", "transactionEventManager", "Lcom/unity3d/ads/core/data/manager/TransactionEventManager;", "triggerInitializationCompletedRequest", "Lcom/unity3d/ads/core/domain/TriggerInitializationCompletedRequest;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "sdkScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/unity3d/ads/core/data/manager/TransactionEventManager;Lcom/unity3d/ads/core/domain/TriggerInitializationCompletedRequest;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lkotlinx/coroutines/CoroutineScope;)V", "invoke", "", C3337ue.n, "Lgatewayprotocol/v1/InitializationResponseOuterClass$InitializationResponse;", "(Lgatewayprotocol/v1/InitializationResponseOuterClass$InitializationResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidHandleGatewayInitializationResponse implements HandleGatewayInitializationResponse {
    private final CoroutineScope sdkScope;
    private final SessionRepository sessionRepository;
    private final TransactionEventManager transactionEventManager;
    private final TriggerInitializationCompletedRequest triggerInitializationCompletedRequest;

    public AndroidHandleGatewayInitializationResponse(TransactionEventManager transactionEventManager, TriggerInitializationCompletedRequest triggerInitializationCompletedRequest, SessionRepository sessionRepository, CoroutineScope sdkScope) {
        Intrinsics.checkNotNullParameter(transactionEventManager, "transactionEventManager");
        Intrinsics.checkNotNullParameter(triggerInitializationCompletedRequest, "triggerInitializationCompletedRequest");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(sdkScope, "sdkScope");
        this.transactionEventManager = transactionEventManager;
        this.triggerInitializationCompletedRequest = triggerInitializationCompletedRequest;
        this.sessionRepository = sessionRepository;
        this.sdkScope = sdkScope;
    }

    @Override // com.unity3d.ads.core.domain.HandleGatewayInitializationResponse
    public Object invoke(InitializationResponseOuterClass.InitializationResponse initializationResponse, Continuation<? super Unit> continuation) {
        String universalRequestUrl;
        if (initializationResponse.hasError()) {
            String errorText = initializationResponse.getError().getErrorText();
            Intrinsics.checkNotNullExpressionValue(errorText, "response.error.errorText");
            throw new GatewayException(errorText, new IllegalStateException(initializationResponse.getError().getErrorText()), "gateway_initialization", initializationResponse.getError().getErrorText());
        }
        SessionRepository sessionRepository = this.sessionRepository;
        NativeConfigurationOuterClass.NativeConfiguration nativeConfiguration = initializationResponse.getNativeConfiguration();
        Intrinsics.checkNotNullExpressionValue(nativeConfiguration, "response.nativeConfiguration");
        sessionRepository.setNativeConfiguration(nativeConfiguration);
        if (initializationResponse.hasUniversalRequestUrl() && (universalRequestUrl = initializationResponse.getUniversalRequestUrl()) != null && universalRequestUrl.length() != 0) {
            SessionRepository sessionRepository2 = this.sessionRepository;
            String universalRequestUrl2 = initializationResponse.getUniversalRequestUrl();
            Intrinsics.checkNotNullExpressionValue(universalRequestUrl2, "response.universalRequestUrl");
            sessionRepository2.setGatewayUrl(universalRequestUrl2);
        }
        List<InitializationResponseOuterClass.AdFormat> scarEligibleFormats = this.sessionRepository.getScarEligibleFormats();
        List<InitializationResponseOuterClass.AdFormat> scarEligibleFormatsList = initializationResponse.getScarEligibleFormatsList();
        Intrinsics.checkNotNullExpressionValue(scarEligibleFormatsList, "response.scarEligibleFormatsList");
        scarEligibleFormats.addAll(scarEligibleFormatsList);
        if (initializationResponse.getTriggerInitializationCompletedRequest()) {
            BuildersKt__Builders_commonKt.launch$default(this.sdkScope, null, null, new AndroidHandleGatewayInitializationResponse$invoke$2(this, null), 3, null);
        }
        if (initializationResponse.getNativeConfiguration().getEnableIapEvent()) {
            this.transactionEventManager.invoke();
        }
        return Unit.INSTANCE;
    }
}
