package io.bidmachine.tracking;

import com.explorestack.protobuf.Struct;
import com.explorestack.protobuf.Value;
import com.ironsource.C3040d4;
import io.bidmachine.utils.ProtoUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventData.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000f\u001a\u00020\u00002\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0016\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\nJ\u0016\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0006J\u001c\u0010\u0019\u001a\u00020\u00002\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011J\u0010\u0010\u001a\u001a\u00020\u00002\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0015\u0010\u001b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u001cR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\n@BX\u0086\u000e¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lio/bidmachine/tracking/EventData;", "", "()V", "customParamsBuilder", "Lcom/explorestack/protobuf/Struct$Builder;", "<set-?>", "", "networkName", "getNetworkName", "()Ljava/lang/String;", "", "price", "getPrice", "()Ljava/lang/Double;", "Ljava/lang/Double;", "addCustomParams", "customParams", "", "getCustomParams", "Lcom/explorestack/protobuf/Struct;", "obtainCustomParamsBuilder", "setCustomParam", C3040d4.h.W, "value", "", "setCustomParams", "setNetworkName", "setPrice", "(Ljava/lang/Double;)Lio/bidmachine/tracking/EventData;", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class EventData {
    private Struct.Builder customParamsBuilder;
    private String networkName;
    private Double price;

    public final String getNetworkName() {
        return this.networkName;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final Struct getCustomParams() {
        Struct.Builder builder = this.customParamsBuilder;
        if (builder != null) {
            return builder.build();
        }
        return null;
    }

    public final EventData setNetworkName(String networkName) {
        this.networkName = networkName;
        return this;
    }

    public final EventData setPrice(Double price) {
        this.price = price;
        return this;
    }

    public final EventData addCustomParams(Map<String, ? extends Object> customParams) {
        Struct.Builder obtainCustomParamsBuilder = obtainCustomParamsBuilder();
        if (customParams != null) {
            for (Map.Entry<String, ? extends Object> entry : customParams.entrySet()) {
                Value valueOrNull = ProtoUtils.toValueOrNull(entry.getValue());
                if (valueOrNull != null) {
                    obtainCustomParamsBuilder.putFields(entry.getKey(), valueOrNull);
                }
            }
        }
        return this;
    }

    public final EventData setCustomParams(Map<String, ? extends Object> customParams) {
        this.customParamsBuilder = ProtoUtils.toStructBuilderOrNull(customParams);
        return this;
    }

    public final EventData setCustomParam(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        obtainCustomParamsBuilder().putFields(key, Value.newBuilder().setStringValue(value).build());
        return this;
    }

    public final EventData setCustomParam(String key, double value) {
        Intrinsics.checkNotNullParameter(key, "key");
        obtainCustomParamsBuilder().putFields(key, Value.newBuilder().setNumberValue(value).build());
        return this;
    }

    public final EventData setCustomParam(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        obtainCustomParamsBuilder().putFields(key, Value.newBuilder().setBoolValue(value).build());
        return this;
    }

    private final Struct.Builder obtainCustomParamsBuilder() {
        Struct.Builder builder = this.customParamsBuilder;
        if (builder != null) {
            return builder;
        }
        Struct.Builder newBuilder = Struct.newBuilder();
        this.customParamsBuilder = newBuilder;
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder().also {\n    …amsBuilder = it\n        }");
        return newBuilder;
    }
}
