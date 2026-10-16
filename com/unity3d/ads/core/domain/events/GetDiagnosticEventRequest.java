package com.unity3d.ads.core.domain.events;

import com.google.protobuf.ByteString;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.unity3d.ads.core.domain.GetSharedDataTimestamps;
import gatewayprotocol.v1.DiagnosticEventKt;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: GetDiagnosticEventRequest.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J~\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r2\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0086\u0002¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/unity3d/ads/core/domain/events/GetDiagnosticEventRequest;", "", "getSharedDataTimestamps", "Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;", "(Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;)V", "uniqueId", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "invoke", "Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticEvent;", C3040d4.h.j0, "", "tags", "", "intTags", "value", "", CampaignEx.JSON_KEY_HB, "", "opportunityId", "Lcom/google/protobuf/ByteString;", "placement", "adType", "Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticAdType;", "tokenNumber", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Double;Ljava/lang/Boolean;Lcom/google/protobuf/ByteString;Ljava/lang/String;Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticAdType;Ljava/lang/Integer;)Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticEvent;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class GetDiagnosticEventRequest {
    private final GetSharedDataTimestamps getSharedDataTimestamps;
    private final MutableStateFlow<Integer> uniqueId;

    public GetDiagnosticEventRequest(GetSharedDataTimestamps getSharedDataTimestamps) {
        Intrinsics.checkNotNullParameter(getSharedDataTimestamps, "getSharedDataTimestamps");
        this.getSharedDataTimestamps = getSharedDataTimestamps;
        this.uniqueId = StateFlowKt.MutableStateFlow(-1);
    }

    public final DiagnosticEventRequestOuterClass.DiagnosticEvent invoke(String eventName, Map<String, String> tags, Map<String, Integer> intTags, Double value, Boolean hb, ByteString opportunityId, String placement, DiagnosticEventRequestOuterClass.DiagnosticAdType adType, Integer tokenNumber) {
        Integer value2;
        Integer valueOf;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        DiagnosticEventKt.Dsl.Companion companion = DiagnosticEventKt.Dsl.INSTANCE;
        DiagnosticEventRequestOuterClass.DiagnosticEvent.Builder newBuilder = DiagnosticEventRequestOuterClass.DiagnosticEvent.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        DiagnosticEventKt.Dsl _create = companion._create(newBuilder);
        MutableStateFlow<Integer> mutableStateFlow = this.uniqueId;
        do {
            value2 = mutableStateFlow.getValue();
            valueOf = Integer.valueOf(value2.intValue() + 1);
        } while (!mutableStateFlow.compareAndSet(value2, valueOf));
        _create.setEventId(valueOf.intValue());
        _create.setEventType(DiagnosticEventRequestOuterClass.DiagnosticEventType.DIAGNOSTIC_EVENT_TYPE_CUSTOM);
        _create.setTimestamps(this.getSharedDataTimestamps.invoke());
        _create.setCustomEventType(eventName);
        if (tags != null) {
            _create.putAllStringTags(_create.getStringTagsMap(), tags);
        }
        if (intTags != null) {
            _create.putAllIntTags(_create.getIntTagsMap(), intTags);
        }
        if (value != null) {
            _create.setTimeValue(value.doubleValue());
        }
        if (hb != null) {
            _create.setIsHeaderBidding(hb.booleanValue());
        }
        if (opportunityId != null) {
            _create.setImpressionOpportunityId(opportunityId);
        }
        if (placement != null) {
            _create.setPlacementId(placement);
        }
        if (adType != null) {
            _create.setAdType(adType);
        }
        if (tokenNumber != null) {
            _create.setHeaderBiddingTokenNumber(tokenNumber.intValue());
        }
        return _create._build();
    }
}
