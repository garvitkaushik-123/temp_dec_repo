package io.adn.sdk.internal.data.mapper;

import io.adn.sdk.internal.data.api.local.AppInfoApi;
import io.adn.sdk.internal.data.api.local.LocalDataSource;
import io.adn.sdk.internal.data.api.local.SystemInfoApi;
import io.adn.sdk.internal.data.dto.DiagnosticEventBody;
import io.adn.sdk.internal.domain.model.analytics.DiagnosticEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonPrimitive;

/* compiled from: DiagnosticEventMapper.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u001a\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a&\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000b*\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\r0\u000bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"SCHEMA", "", "NAME", "OS_NAME", "mapToDiagnosticEventBody", "Lio/adn/sdk/internal/data/dto/DiagnosticEventBody;", "event", "Lio/adn/sdk/internal/domain/model/analytics/DiagnosticEvent;", "local", "Lio/adn/sdk/internal/data/api/local/LocalDataSource;", "toJsonPrimitives", "", "Lkotlinx/serialization/json/JsonPrimitive;", "", "adn-sdk_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class DiagnosticEventMapperKt {
    private static final String NAME = "sdk_diagnostic";
    private static final String OS_NAME = "android";
    private static final String SCHEMA = "v0.2";

    public static final DiagnosticEventBody mapToDiagnosticEventBody(DiagnosticEvent event, LocalDataSource local) {
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(local, "local");
        SystemInfoApi systemInfo = local.getSystemInfo();
        AppInfoApi appInfo = local.getAppInfo();
        String id = event.getId();
        String name = event.getName();
        String creationDate = event.getCreationDate();
        String appBundleId = appInfo.getAppBundleId();
        return new DiagnosticEventBody(id, NAME, SCHEMA, creationDate, name, systemInfo.getModel(), appInfo.getAppVersion(), appBundleId, "4.25.2", systemInfo.getOsVersion(), "android", "34", false, event.getBidId(), event.getSdkInitDate(), event.getSdkSessionId(), event.getAdPlacement(), local.getExternalData().getMediationType().getValue(), toJsonPrimitives(event.getTags()));
    }

    private static final Map<String, JsonPrimitive> toJsonPrimitives(Map<String, ? extends Object> map) {
        JsonPrimitive JsonPrimitive;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
        for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
            Object key = entry2.getKey();
            Object value = entry2.getValue();
            if (value instanceof String) {
                JsonPrimitive = JsonElementKt.JsonPrimitive((String) value);
            } else if (value instanceof Number) {
                JsonPrimitive = JsonElementKt.JsonPrimitive((Number) value);
            } else {
                JsonPrimitive = value instanceof Boolean ? JsonElementKt.JsonPrimitive((Boolean) value) : JsonElementKt.JsonPrimitive(String.valueOf(value));
            }
            linkedHashMap3.put(key, JsonPrimitive);
        }
        return linkedHashMap3;
    }
}
