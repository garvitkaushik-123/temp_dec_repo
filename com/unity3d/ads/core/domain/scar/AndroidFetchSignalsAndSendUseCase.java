package com.unity3d.ads.core.domain.scar;

import com.google.protobuf.ByteString;
import com.unity3d.ads.TokenConfiguration;
import com.unity3d.ads.core.data.manager.ScarManager;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.extensions.AdFormatExtensions;
import gatewayprotocol.v1.InitializationResponseOuterClass;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: AndroidFetchSignalsAndSendUseCase.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0002J\u0014\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00140\u0013H\u0002J+\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/unity3d/ads/core/domain/scar/AndroidFetchSignalsAndSendUseCase;", "Lcom/unity3d/ads/core/domain/scar/FetchSignalsAndSendUseCase;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "scarManager", "Lcom/unity3d/ads/core/data/manager/ScarManager;", "handleGetTokenRequest", "Lcom/unity3d/ads/core/domain/scar/HandleGetTokenRequest;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lkotlinx/coroutines/CoroutineScope;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/manager/ScarManager;Lcom/unity3d/ads/core/domain/scar/HandleGetTokenRequest;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "getRequestedSignalFormats", "", "Lgatewayprotocol/v1/InitializationResponseOuterClass$AdFormat;", "tokenConfiguration", "Lcom/unity3d/ads/TokenConfiguration;", "getTags", "", "", "invoke", "", "tokenNumber", "", "tokenId", "Lcom/google/protobuf/ByteString;", "(ILcom/google/protobuf/ByteString;Lcom/unity3d/ads/TokenConfiguration;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AndroidFetchSignalsAndSendUseCase implements FetchSignalsAndSendUseCase {
    private final HandleGetTokenRequest handleGetTokenRequest;
    private final ScarManager scarManager;
    private final CoroutineScope scope;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    public AndroidFetchSignalsAndSendUseCase(CoroutineScope scope, SessionRepository sessionRepository, ScarManager scarManager, HandleGetTokenRequest handleGetTokenRequest, SendDiagnosticEvent sendDiagnosticEvent) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(sessionRepository, "sessionRepository");
        Intrinsics.checkNotNullParameter(scarManager, "scarManager");
        Intrinsics.checkNotNullParameter(handleGetTokenRequest, "handleGetTokenRequest");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.scope = scope;
        this.sessionRepository = sessionRepository;
        this.scarManager = scarManager;
        this.handleGetTokenRequest = handleGetTokenRequest;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    @Override // com.unity3d.ads.core.domain.scar.FetchSignalsAndSendUseCase
    public Object invoke(int i, ByteString byteString, TokenConfiguration tokenConfiguration, Continuation<? super Unit> continuation) {
        BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new AndroidFetchSignalsAndSendUseCase$invoke$2(this, tokenConfiguration, i, byteString, null), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<InitializationResponseOuterClass.AdFormat> getRequestedSignalFormats(TokenConfiguration tokenConfiguration) {
        List<InitializationResponseOuterClass.AdFormat> listOf;
        if (tokenConfiguration == null) {
            return this.sessionRepository.getScarEligibleFormats();
        }
        InitializationResponseOuterClass.AdFormat protoAdFormat = AdFormatExtensions.toProtoAdFormat(tokenConfiguration.getAdFormat());
        if (!this.sessionRepository.getScarEligibleFormats().contains(protoAdFormat)) {
            protoAdFormat = null;
        }
        return (protoAdFormat == null || (listOf = CollectionsKt.listOf(protoAdFormat)) == null) ? CollectionsKt.emptyList() : listOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, String> getTags() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<InitializationResponseOuterClass.AdFormat> scarEligibleFormats = this.sessionRepository.getScarEligibleFormats();
        if (scarEligibleFormats.contains(InitializationResponseOuterClass.AdFormat.AD_FORMAT_BANNER)) {
            linkedHashMap.put("banner", "true");
        }
        if (scarEligibleFormats.contains(InitializationResponseOuterClass.AdFormat.AD_FORMAT_REWARDED)) {
            linkedHashMap.put("rewarded", "true");
        }
        if (scarEligibleFormats.contains(InitializationResponseOuterClass.AdFormat.AD_FORMAT_INTERSTITIAL)) {
            linkedHashMap.put("interstitial", "true");
        }
        return linkedHashMap;
    }
}
