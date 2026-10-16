package io.bidmachine.utils;

import com.explorestack.protobuf.ListValue;
import com.explorestack.protobuf.MessageLite;
import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import com.ironsource.C3040d4;
import io.bidmachine.util.UtilsKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProtoUtils.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0000\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\nH\u0000\u001a\u000e\u0010\t\u001a\u0004\u0018\u00010\b*\u00020\u000bH\u0000\u001a\u001b\u0010\f\u001a\u0004\u0018\u00010\u0006*\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\u000e\u001a\u001b\u0010\u000f\u001a\u0004\u0018\u00010\u0010*\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0000¢\u0006\u0002\u0010\u0011\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0003*\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0000\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\b*\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0000\u001a\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0004*\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0000\u001a\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00042\u0006\u0010\r\u001a\u00020\bH\u0000\u001a.\u0010\u0017\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00180\u00192\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u0002H\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u001bH\u0000\u001a\u001c\u0010\u001c\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u001c\u0010\u001c\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u001c\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0004H\u0000\u001a\u001c\u0010\u001c\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0005H\u0000\u001a\u001c\u0010\u001c\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u001c\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0007H\u0000\u001a\u001c\u0010\u001c\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\bH\u0000\u001a\f\u0010\u001d\u001a\u00020\u0016*\u00020\u0003H\u0000\u001a\f\u0010\u001d\u001a\u00020\u0016*\u00020\u0001H\u0000\u001a\f\u0010\u001d\u001a\u00020\u0016*\u00020\u0004H\u0000\u001a\f\u0010\u001d\u001a\u00020\u0016*\u00020\u0005H\u0000\u001a\f\u0010\u001d\u001a\u00020\u0016*\u00020\u0006H\u0000\u001a\f\u0010\u001d\u001a\u00020\u0016*\u00020\u0007H\u0000\u001a\f\u0010\u001d\u001a\u00020\u0016*\u00020\bH\u0000¨\u0006\u001e"}, d2 = {"addValue", "Lcom/explorestack/protobuf/ListValue$Builder;", "value", "Lcom/explorestack/protobuf/ListValue;", "Lcom/explorestack/protobuf/Struct;", "Lcom/explorestack/protobuf/Struct$Builder;", "", "", "", "encodeToStringBase64Safely", "Lcom/explorestack/protobuf/MessageLite;", "Lcom/explorestack/protobuf/MessageLite$Builder;", "getBoolean", C3040d4.h.W, "(Lcom/explorestack/protobuf/Struct;Ljava/lang/String;)Ljava/lang/Boolean;", "getDouble", "", "(Lcom/explorestack/protobuf/Struct;Ljava/lang/String;)Ljava/lang/Double;", "getListValue", "getString", "getStruct", "getValue", "Lcom/explorestack/protobuf/Value;", "mapNotNullToProtoListValue", "T", "", "transform", "Lkotlin/Function1;", "putField", "toProtoValue", "bidmachine-android-sdk_bh_3_4_0"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class ProtoUtilsKt {
    public static final String encodeToStringBase64Safely(MessageLite messageLite) {
        Intrinsics.checkNotNullParameter(messageLite, "<this>");
        try {
            byte[] byteArray = messageLite.toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray()");
            return UtilsKt.encodeToStringBase64$default(byteArray, 0, 1, null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final String encodeToStringBase64Safely(MessageLite.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        try {
            MessageLite build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "build()");
            return encodeToStringBase64Safely(build);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final Value toProtoValue(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Value build = Value.newBuilder().setStringValue(str).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…ue(this)\n        .build()");
        return build;
    }

    public static final Value toProtoValue(boolean z) {
        Value build = Value.newBuilder().setBoolValue(z).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…ue(this)\n        .build()");
        return build;
    }

    public static final Value toProtoValue(Number number) {
        Intrinsics.checkNotNullParameter(number, "<this>");
        Value.Builder newBuilder = Value.newBuilder();
        Double doubleOrDefault$default = UtilsKt.toDoubleOrDefault$default(number, null, 1, null);
        Value build = newBuilder.setNumberValue(doubleOrDefault$default != null ? doubleOrDefault$default.doubleValue() : number.doubleValue()).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…ouble())\n        .build()");
        return build;
    }

    public static final Value toProtoValue(Struct struct) {
        Intrinsics.checkNotNullParameter(struct, "<this>");
        Value build = Value.newBuilder().setStructValue(struct).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…ue(this)\n        .build()");
        return build;
    }

    public static final Value toProtoValue(Struct.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Struct build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build()");
        return toProtoValue(build);
    }

    public static final Struct.Builder putField(Struct.Builder builder, String key, String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.putFields(key, toProtoValue(value));
        return builder;
    }

    public static final Struct.Builder putField(Struct.Builder builder, String key, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        builder.putFields(key, toProtoValue(z));
        return builder;
    }

    public static final Struct.Builder putField(Struct.Builder builder, String key, Number value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.putFields(key, toProtoValue(value));
        return builder;
    }

    public static final Struct.Builder putField(Struct.Builder builder, String key, Struct.Builder value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.putFields(key, toProtoValue(value));
        return builder;
    }

    public static final Struct.Builder putField(Struct.Builder builder, String key, Struct value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.putFields(key, toProtoValue(value));
        return builder;
    }

    public static final Struct.Builder putField(Struct.Builder builder, String key, ListValue.Builder value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.putFields(key, toProtoValue(value));
        return builder;
    }

    public static final Struct.Builder putField(Struct.Builder builder, String key, ListValue value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.putFields(key, toProtoValue(value));
        return builder;
    }

    public static final Value toProtoValue(ListValue listValue) {
        Intrinsics.checkNotNullParameter(listValue, "<this>");
        Value build = Value.newBuilder().setListValue(listValue).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…ue(this)\n        .build()");
        return build;
    }

    public static final Value toProtoValue(ListValue.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        ListValue build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "build()");
        return toProtoValue(build);
    }

    public static final ListValue.Builder addValue(ListValue.Builder builder, String value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.addValues(toProtoValue(value));
        return builder;
    }

    public static final ListValue.Builder addValue(ListValue.Builder builder, boolean z) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        builder.addValues(toProtoValue(z));
        return builder;
    }

    public static final ListValue.Builder addValue(ListValue.Builder builder, Number value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.addValues(toProtoValue(value));
        return builder;
    }

    public static final ListValue.Builder addValue(ListValue.Builder builder, Struct.Builder value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.addValues(toProtoValue(value));
        return builder;
    }

    public static final ListValue.Builder addValue(ListValue.Builder builder, Struct value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.addValues(toProtoValue(value));
        return builder;
    }

    public static final ListValue.Builder addValue(ListValue.Builder builder, ListValue.Builder value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.addValues(toProtoValue(value));
        return builder;
    }

    public static final ListValue.Builder addValue(ListValue.Builder builder, ListValue value) {
        Intrinsics.checkNotNullParameter(builder, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        builder.addValues(toProtoValue(value));
        return builder;
    }

    public static final String getString(Struct struct, String key) {
        Intrinsics.checkNotNullParameter(struct, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Value value = getValue(struct, key);
        if (value != null) {
            return value.getStringValue();
        }
        return null;
    }

    public static final Boolean getBoolean(Struct struct, String key) {
        Intrinsics.checkNotNullParameter(struct, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Value value = getValue(struct, key);
        if (value != null) {
            return Boolean.valueOf(value.getBoolValue());
        }
        return null;
    }

    public static final Double getDouble(Struct struct, String key) {
        Intrinsics.checkNotNullParameter(struct, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Value value = getValue(struct, key);
        if (value != null) {
            return Double.valueOf(value.getNumberValue());
        }
        return null;
    }

    public static final Struct getStruct(Struct struct, String key) {
        Intrinsics.checkNotNullParameter(struct, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Value value = getValue(struct, key);
        if (value != null) {
            return value.getStructValue();
        }
        return null;
    }

    public static final ListValue getListValue(Struct struct, String key) {
        Intrinsics.checkNotNullParameter(struct, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Value value = getValue(struct, key);
        if (value != null) {
            return value.getListValue();
        }
        return null;
    }

    public static final Value getValue(Struct struct, String key) {
        Intrinsics.checkNotNullParameter(struct, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return struct.getFieldsMap().get(key);
    }

    public static final <T> ListValue mapNotNullToProtoListValue(List<? extends T> list, Function1<? super T, Value> transform) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ListValue.Builder newBuilder = ListValue.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Value invoke = transform.invoke(it.next());
            if (invoke != null) {
                newBuilder.addValues(invoke);
            }
        }
        ListValue build = newBuilder.build();
        Intrinsics.checkNotNullExpressionValue(build, "listValueBuilder.build()");
        return build;
    }
}
