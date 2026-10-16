package com.unity3d.ads.core.domain.events;

import gatewayprotocol.v1.DiagnosticEventRequestKt;
import gatewayprotocol.v1.DiagnosticEventRequestOuterClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetDiagnosticEventBatchRequest.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0086\u0002¨\u0006\b"}, d2 = {"Lcom/unity3d/ads/core/domain/events/GetDiagnosticEventBatchRequest;", "", "()V", "invoke", "Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticEventRequest;", "diagnosticEvents", "", "Lgatewayprotocol/v1/DiagnosticEventRequestOuterClass$DiagnosticEvent;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class GetDiagnosticEventBatchRequest {
    public final DiagnosticEventRequestOuterClass.DiagnosticEventRequest invoke(List<DiagnosticEventRequestOuterClass.DiagnosticEvent> diagnosticEvents) {
        Intrinsics.checkNotNullParameter(diagnosticEvents, "diagnosticEvents");
        DiagnosticEventRequestKt.Dsl.Companion companion = DiagnosticEventRequestKt.Dsl.INSTANCE;
        DiagnosticEventRequestOuterClass.DiagnosticEventRequest.Builder newBuilder = DiagnosticEventRequestOuterClass.DiagnosticEventRequest.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        DiagnosticEventRequestKt.Dsl _create = companion._create(newBuilder);
        _create.addAllBatch(_create.getBatch(), diagnosticEvents);
        return _create._build();
    }
}
