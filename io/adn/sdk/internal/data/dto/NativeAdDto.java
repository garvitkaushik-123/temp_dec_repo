package io.adn.sdk.internal.data.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: NativeAdDto.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B%\b\u0010\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0004\u0010\nJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÇ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0012\u001a\u00020\u0007H×\u0001J\t\u0010\u0013\u001a\u00020\u0014H×\u0001J%\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0001¢\u0006\u0002\b\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001f"}, d2 = {"Lio/adn/sdk/internal/data/dto/NativeAdDto;", "", "native", "Lio/adn/sdk/internal/data/dto/NativeAdContentDto;", "<init>", "(Lio/adn/sdk/internal/data/dto/NativeAdContentDto;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILio/adn/sdk/internal/data/dto/NativeAdContentDto;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getNative", "()Lio/adn/sdk/internal/data/dto/NativeAdContentDto;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class NativeAdDto {
    private final NativeAdContentDto native;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ NativeAdDto copy$default(NativeAdDto nativeAdDto, NativeAdContentDto nativeAdContentDto, int i, Object obj) {
        if ((i & 1) != 0) {
            nativeAdContentDto = nativeAdDto.native;
        }
        return nativeAdDto.copy(nativeAdContentDto);
    }

    /* renamed from: component1, reason: from getter */
    public final NativeAdContentDto getNative() {
        return this.native;
    }

    public final NativeAdDto copy(NativeAdContentDto r2) {
        Intrinsics.checkNotNullParameter(r2, "native");
        return new NativeAdDto(r2);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NativeAdDto) && Intrinsics.areEqual(this.native, ((NativeAdDto) other).native);
    }

    public int hashCode() {
        return this.native.hashCode();
    }

    public String toString() {
        return "NativeAdDto(native=" + this.native + ')';
    }

    /* compiled from: NativeAdDto.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/NativeAdDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/NativeAdDto;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NativeAdDto> serializer() {
            return NativeAdDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NativeAdDto(int i, NativeAdContentDto nativeAdContentDto, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, NativeAdDto$$serializer.INSTANCE.getDescriptor());
        }
        this.native = nativeAdContentDto;
    }

    public NativeAdDto(NativeAdContentDto nativeAdContentDto) {
        Intrinsics.checkNotNullParameter(nativeAdContentDto, "native");
        this.native = nativeAdContentDto;
    }

    public final NativeAdContentDto getNative() {
        return this.native;
    }
}
