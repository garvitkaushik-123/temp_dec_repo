package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.services.core.configuration.InitializeEventsMetricSender;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.metrics.Metric;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CommonCheckForGameIdAndTestModeChanges.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096\u0002J,\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000f2\u0006\u0010\u0010\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/unity3d/ads/core/domain/CommonCheckForGameIdAndTestModeChanges;", "Lcom/unity3d/ads/core/domain/CheckForGameIdAndTestModeChanges;", "getGameId", "Lcom/unity3d/ads/core/domain/GetGameId;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lcom/unity3d/ads/core/domain/GetGameId;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "invoke", "", "legacy", "", "sendDiagnostic", "event", "", "tags", "", "isLegacy", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class CommonCheckForGameIdAndTestModeChanges implements CheckForGameIdAndTestModeChanges {
    private final GetGameId getGameId;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    public CommonCheckForGameIdAndTestModeChanges(GetGameId getGameId, SendDiagnosticEvent sendDiagnosticEvent) {
        Intrinsics.checkNotNullParameter(getGameId, "getGameId");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent, "sendDiagnosticEvent");
        this.getGameId = getGameId;
        this.sendDiagnosticEvent = sendDiagnosticEvent;
    }

    @Override // com.unity3d.ads.core.domain.CheckForGameIdAndTestModeChanges
    public void invoke(boolean legacy) {
        String invoke = this.getGameId.invoke();
        if (invoke == null) {
            invoke = "null";
        }
        String previousGameId = ClientProperties.getPreviousGameId();
        if (previousGameId == null) {
            previousGameId = "null";
        }
        Map<String, String> mapOf = MapsKt.mapOf(TuplesKt.to("previous_game_id", previousGameId), TuplesKt.to("game_id", invoke));
        if (Intrinsics.areEqual(previousGameId, "null")) {
            return;
        }
        if (!Intrinsics.areEqual(invoke, previousGameId)) {
            sendDiagnostic("native_initialize_game_id_changed", mapOf, legacy);
        } else {
            sendDiagnostic("native_initialize_game_id_same", mapOf, legacy);
        }
        boolean isTestMode = SdkProperties.isTestMode();
        boolean previousTestMode = SdkProperties.getPreviousTestMode();
        Map<String, String> mapOf2 = MapsKt.mapOf(TuplesKt.to("previous_test_mode", String.valueOf(previousTestMode)), TuplesKt.to("test_mode", String.valueOf(isTestMode)));
        if (isTestMode != previousTestMode) {
            sendDiagnostic("native_initialize_test_mode_changed", mapOf2, legacy);
        } else {
            sendDiagnostic("native_initialize_test_mode_same", mapOf2, legacy);
        }
    }

    private final void sendDiagnostic(String event, Map<String, String> tags, boolean isLegacy) {
        if (isLegacy) {
            InitializeEventsMetricSender.getInstance().sendMetric(new Metric(event, tags, null, 4, null));
        } else {
            SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, event, null, tags, null, null, null, 58, null);
        }
    }
}
