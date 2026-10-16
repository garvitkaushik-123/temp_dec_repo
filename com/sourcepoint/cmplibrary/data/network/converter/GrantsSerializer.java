package com.sourcepoint.cmplibrary.data.network.converter;

import com.sourcepoint.cmplibrary.model.exposed.GDPRPurposeGrants;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonTransformingSerializer;

/* compiled from: GrantsSerializer.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0014¨\u0006\t"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/converter/GrantsSerializer;", "Lkotlinx/serialization/json/JsonTransformingSerializer;", "", "", "Lcom/sourcepoint/cmplibrary/model/exposed/GDPRPurposeGrants;", "()V", "transformDeserialize", "Lkotlinx/serialization/json/JsonElement;", "element", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class GrantsSerializer extends JsonTransformingSerializer<Map<String, ? extends GDPRPurposeGrants>> {
    public static final GrantsSerializer INSTANCE = new GrantsSerializer();

    private GrantsSerializer() {
        super(BuiltinSerializersKt.MapSerializer(BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE), GDPRPurposeGrants.INSTANCE.serializer()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.serialization.json.JsonTransformingSerializer
    protected JsonElement transformDeserialize(JsonElement element) {
        LinkedHashMap emptyMap;
        Set<Map.Entry> entrySet;
        Intrinsics.checkNotNullParameter(element, "element");
        Map map = element instanceof Map ? (Map) element : null;
        if (map == null || (entrySet = map.entrySet()) == null) {
            emptyMap = MapsKt.emptyMap();
        } else {
            emptyMap = new LinkedHashMap();
            for (Map.Entry entry : entrySet) {
                emptyMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new JsonObject(emptyMap);
    }
}
