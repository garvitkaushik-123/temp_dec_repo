package adn.analytics;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConversionResult.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Ladn/analytics/ProtoConversionResult;", "", "protobufBase64", "", "errors", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getProtobufBase64", "()Ljava/lang/String;", "getErrors", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "adn-protos"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ProtoConversionResult {
    private final List<String> errors;
    private final String protobufBase64;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProtoConversionResult copy$default(ProtoConversionResult protoConversionResult, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = protoConversionResult.protobufBase64;
        }
        if ((i & 2) != 0) {
            list = protoConversionResult.errors;
        }
        return protoConversionResult.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProtobufBase64() {
        return this.protobufBase64;
    }

    public final List<String> component2() {
        return this.errors;
    }

    public final ProtoConversionResult copy(String protobufBase64, List<String> errors) {
        Intrinsics.checkNotNullParameter(protobufBase64, "protobufBase64");
        Intrinsics.checkNotNullParameter(errors, "errors");
        return new ProtoConversionResult(protobufBase64, errors);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProtoConversionResult)) {
            return false;
        }
        ProtoConversionResult protoConversionResult = (ProtoConversionResult) other;
        return Intrinsics.areEqual(this.protobufBase64, protoConversionResult.protobufBase64) && Intrinsics.areEqual(this.errors, protoConversionResult.errors);
    }

    public int hashCode() {
        return (this.protobufBase64.hashCode() * 31) + this.errors.hashCode();
    }

    public String toString() {
        return "ProtoConversionResult(protobufBase64=" + this.protobufBase64 + ", errors=" + this.errors + ")";
    }

    public ProtoConversionResult(String protobufBase64, List<String> errors) {
        Intrinsics.checkNotNullParameter(protobufBase64, "protobufBase64");
        Intrinsics.checkNotNullParameter(errors, "errors");
        this.protobufBase64 = protobufBase64;
        this.errors = errors;
    }

    public final String getProtobufBase64() {
        return this.protobufBase64;
    }

    public final List<String> getErrors() {
        return this.errors;
    }
}
