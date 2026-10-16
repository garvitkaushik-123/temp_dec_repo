package io.bidmachine.util.conversion;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StringTypeConversion.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002H\u0014¨\u0006\u0007"}, d2 = {"Lio/bidmachine/util/conversion/StringTypeConversion;", "Lio/bidmachine/util/conversion/BaseTypeConversion;", "", "()V", "to", "value", "", "bidmachine-android-sdk_ca_3_4_0"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class StringTypeConversion extends BaseTypeConversion<String> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.util.conversion.BaseTypeConversion
    public String to(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.bidmachine.util.conversion.BaseTypeConversion
    public String to(Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return value.toString();
    }
}
