package io.bidmachine;

import com.explorestack.protobuf.Struct;
import com.ironsource.C3040d4;
import io.bidmachine.models.ICustomParams;
import io.bidmachine.utils.ProtoUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomParams.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u000bH\u0016J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\fH\u0016J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\rH\u0016J\u0018\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u001c\u0010\u000e\u001a\u00020\u00002\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0001R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lio/bidmachine/CustomParams;", "Lio/bidmachine/models/ICustomParams;", "()V", "customMap", "", "", "", "addParam", C3040d4.h.W, "value", "", "", "", "", "addParams", "params", "", "fillStructBuilder", "", "builder", "Lcom/explorestack/protobuf/Struct$Builder;", "bidmachine-android-sdk_bh_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class CustomParams implements ICustomParams<CustomParams> {
    private final Map<String, Object> customMap = new LinkedHashMap();

    @Override // io.bidmachine.models.ICustomParams
    public /* bridge */ /* synthetic */ CustomParams addParams(Map map) {
        return addParams((Map<String, String>) map);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ICustomParams
    public CustomParams addParam(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        this.customMap.put(key, value);
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ICustomParams
    public CustomParams addParam(String key, int value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.customMap.put(key, Integer.valueOf(value));
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ICustomParams
    public CustomParams addParam(String key, float value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.customMap.put(key, Float.valueOf(value));
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ICustomParams
    public CustomParams addParam(String key, double value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.customMap.put(key, Double.valueOf(value));
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ICustomParams
    public CustomParams addParam(String key, boolean value) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.customMap.put(key, Boolean.valueOf(value));
        return this;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // io.bidmachine.models.ICustomParams
    public CustomParams addParams(Map<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        this.customMap.putAll(params);
        return this;
    }

    public final void fillStructBuilder(Struct.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        ProtoUtils.fillStructWithPrimitiveValues(builder, this.customMap);
    }
}
