package io.adn.sdk.internal.data.dto;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: NativeAdDto.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0006\u0010\fJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÇ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010\u0017\u001a\u00020\tH×\u0001J\t\u0010\u0018\u001a\u00020\u0003H×\u0001J%\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0001¢\u0006\u0002\b R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006#"}, d2 = {"Lio/adn/sdk/internal/data/dto/NativeAdImageDto;", "", "url", "", "ext", "Lio/adn/sdk/internal/data/dto/NativeAdAssetExtDto;", "<init>", "(Ljava/lang/String;Lio/adn/sdk/internal/data/dto/NativeAdAssetExtDto;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lio/adn/sdk/internal/data/dto/NativeAdAssetExtDto;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getUrl", "()Ljava/lang/String;", "getExt", "()Lio/adn/sdk/internal/data/dto/NativeAdAssetExtDto;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class NativeAdImageDto {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final NativeAdAssetExtDto ext;
    private final String url;

    public static /* synthetic */ NativeAdImageDto copy$default(NativeAdImageDto nativeAdImageDto, String str, NativeAdAssetExtDto nativeAdAssetExtDto, int i, Object obj) {
        if ((i & 1) != 0) {
            str = nativeAdImageDto.url;
        }
        if ((i & 2) != 0) {
            nativeAdAssetExtDto = nativeAdImageDto.ext;
        }
        return nativeAdImageDto.copy(str, nativeAdAssetExtDto);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    /* renamed from: component2, reason: from getter */
    public final NativeAdAssetExtDto getExt() {
        return this.ext;
    }

    public final NativeAdImageDto copy(String url, NativeAdAssetExtDto ext) {
        Intrinsics.checkNotNullParameter(url, "url");
        return new NativeAdImageDto(url, ext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeAdImageDto)) {
            return false;
        }
        NativeAdImageDto nativeAdImageDto = (NativeAdImageDto) other;
        return Intrinsics.areEqual(this.url, nativeAdImageDto.url) && Intrinsics.areEqual(this.ext, nativeAdImageDto.ext);
    }

    public int hashCode() {
        int hashCode = this.url.hashCode() * 31;
        NativeAdAssetExtDto nativeAdAssetExtDto = this.ext;
        return hashCode + (nativeAdAssetExtDto == null ? 0 : nativeAdAssetExtDto.hashCode());
    }

    public String toString() {
        return "NativeAdImageDto(url=" + this.url + ", ext=" + this.ext + ')';
    }

    /* compiled from: NativeAdDto.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/NativeAdImageDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/NativeAdImageDto;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NativeAdImageDto> serializer() {
            return NativeAdImageDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NativeAdImageDto(int i, String str, NativeAdAssetExtDto nativeAdAssetExtDto, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, NativeAdImageDto$$serializer.INSTANCE.getDescriptor());
        }
        this.url = str;
        this.ext = nativeAdAssetExtDto;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$adn_sdk_release(NativeAdImageDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.url);
        output.encodeNullableSerializableElement(serialDesc, 1, NativeAdAssetExtDto$$serializer.INSTANCE, self.ext);
    }

    public NativeAdImageDto(String url, NativeAdAssetExtDto nativeAdAssetExtDto) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.url = url;
        this.ext = nativeAdAssetExtDto;
    }

    public final String getUrl() {
        return this.url;
    }

    public final NativeAdAssetExtDto getExt() {
        return this.ext;
    }
}
