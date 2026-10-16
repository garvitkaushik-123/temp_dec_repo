package com.sourcepoint.cmplibrary.data.network.model.optimized.includeData;

import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementBuildersKt;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectBuilder;

/* compiled from: IncludeData.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u00012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000¨\u0006\u0007"}, d2 = {"buildIncludeData", "Lkotlinx/serialization/json/JsonObject;", "gppDataValue", "Lkotlinx/serialization/json/JsonElement;", "encodeToString", "", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/includeData/IncludeDataGppParam;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class IncludeDataKt {
    public static final String encodeToString(IncludeDataGppParam includeDataGppParam) {
        Intrinsics.checkNotNullParameter(includeDataGppParam, "<this>");
        Json converter = JsonConverterImplKt.getConverter(JsonConverter.INSTANCE);
        converter.getSerializersModule();
        return converter.encodeToString(IncludeDataGppParam.INSTANCE.serializer(), includeDataGppParam);
    }

    public static /* synthetic */ JsonObject buildIncludeData$default(JsonElement jsonElement, int i, Object obj) {
        if ((i & 1) != 0) {
            jsonElement = null;
        }
        return buildIncludeData(jsonElement);
    }

    public static final JsonObject buildIncludeData(JsonElement jsonElement) {
        JsonObjectBuilder jsonObjectBuilder = new JsonObjectBuilder();
        JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, "TCData", new Function1<JsonObjectBuilder, Unit>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.includeData.IncludeDataKt$buildIncludeData$1$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                invoke2(jsonObjectBuilder2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonObjectBuilder putJsonObject) {
                Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                JsonElementBuildersKt.put(putJsonObject, "type", "RecordString");
            }
        });
        JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, "campaigns", new Function1<JsonObjectBuilder, Unit>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.includeData.IncludeDataKt$buildIncludeData$1$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                invoke2(jsonObjectBuilder2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonObjectBuilder putJsonObject) {
                Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                JsonElementBuildersKt.put(putJsonObject, "type", "RecordString");
            }
        });
        JsonElementBuildersKt.putJsonObject(jsonObjectBuilder, "webConsentPayload", new Function1<JsonObjectBuilder, Unit>() { // from class: com.sourcepoint.cmplibrary.data.network.model.optimized.includeData.IncludeDataKt$buildIncludeData$1$3
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(JsonObjectBuilder jsonObjectBuilder2) {
                invoke2(jsonObjectBuilder2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(JsonObjectBuilder putJsonObject) {
                Intrinsics.checkNotNullParameter(putJsonObject, "$this$putJsonObject");
                JsonElementBuildersKt.put(putJsonObject, "type", "RecordString");
            }
        });
        if (jsonElement == null) {
            jsonElement = JsonElementKt.JsonPrimitive((Boolean) true);
        }
        jsonObjectBuilder.put("GPPData", jsonElement);
        JsonElementBuildersKt.put(jsonObjectBuilder, "categories", (Boolean) true);
        return jsonObjectBuilder.build();
    }
}
