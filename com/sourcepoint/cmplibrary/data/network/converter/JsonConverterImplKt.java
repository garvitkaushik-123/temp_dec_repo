package com.sourcepoint.cmplibrary.data.network.converter;

import com.sourcepoint.cmplibrary.data.network.converter.JsonConverter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;

/* compiled from: JsonConverterImpl.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0000\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, d2 = {"converter", "Lkotlinx/serialization/json/Json;", "Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter$Companion;", "getConverter", "(Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter$Companion;)Lkotlinx/serialization/json/Json;", "converter$delegate", "Lkotlin/Lazy;", "create", "Lcom/sourcepoint/cmplibrary/data/network/converter/JsonConverter;", "cmplibrary_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class JsonConverterImplKt {
    private static final Lazy converter$delegate = LazyKt.lazy(new Function0<Json>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt$converter$2
        @Override // kotlin.jvm.functions.Function0
        public final Json invoke() {
            return JsonKt.Json$default(null, new Function1<JsonBuilder, Unit>() { // from class: com.sourcepoint.cmplibrary.data.network.converter.JsonConverterImplKt$converter$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
                    invoke2(jsonBuilder);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(JsonBuilder Json) {
                    Intrinsics.checkNotNullParameter(Json, "$this$Json");
                    Json.setEncodeDefaults(true);
                    Json.setIgnoreUnknownKeys(true);
                    Json.setLenient(true);
                    Json.setAllowStructuredMapKeys(true);
                    Json.setExplicitNulls(false);
                    Json.setPrettyPrint(true);
                    Json.setPrettyPrintIndent("  ");
                    Json.setCoerceInputValues(true);
                    Json.setUseArrayPolymorphism(true);
                    Json.setAllowSpecialFloatingPointValues(true);
                }
            }, 1, null);
        }
    });

    public static final JsonConverter create(JsonConverter.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return new JsonConverterImpl();
    }

    public static final Json getConverter(JsonConverter.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return (Json) converter$delegate.getValue();
    }
}
