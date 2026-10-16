package io.adn.sdk.internal.data.dto;

import io.bidmachine.iab.vast.tags.VastAttributes;
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
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 42\u00020\u0001:\u000234BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eBS\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\r\u0010\u0012J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003JM\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÇ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010(\u001a\u00020\u0003H×\u0001J\t\u0010)\u001a\u00020*H×\u0001J%\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u000201H\u0001¢\u0006\u0002\b2R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00065"}, d2 = {"Lio/adn/sdk/internal/data/dto/NativeAdAssetDto;", "", "id", "", VastAttributes.REQUIRED, "title", "Lio/adn/sdk/internal/data/dto/NativeAdTitleDto;", "img", "Lio/adn/sdk/internal/data/dto/NativeAdImageDto;", "data", "Lio/adn/sdk/internal/data/dto/NativeAdDataDto;", "video", "Lio/adn/sdk/internal/data/dto/NativeAdVideoDto;", "<init>", "(IILio/adn/sdk/internal/data/dto/NativeAdTitleDto;Lio/adn/sdk/internal/data/dto/NativeAdImageDto;Lio/adn/sdk/internal/data/dto/NativeAdDataDto;Lio/adn/sdk/internal/data/dto/NativeAdVideoDto;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IIILio/adn/sdk/internal/data/dto/NativeAdTitleDto;Lio/adn/sdk/internal/data/dto/NativeAdImageDto;Lio/adn/sdk/internal/data/dto/NativeAdDataDto;Lio/adn/sdk/internal/data/dto/NativeAdVideoDto;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()I", "getRequired", "getTitle", "()Lio/adn/sdk/internal/data/dto/NativeAdTitleDto;", "getImg", "()Lio/adn/sdk/internal/data/dto/NativeAdImageDto;", "getData", "()Lio/adn/sdk/internal/data/dto/NativeAdDataDto;", "getVideo", "()Lio/adn/sdk/internal/data/dto/NativeAdVideoDto;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class NativeAdAssetDto {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final NativeAdDataDto data;
    private final int id;
    private final NativeAdImageDto img;
    private final int required;
    private final NativeAdTitleDto title;
    private final NativeAdVideoDto video;

    public static /* synthetic */ NativeAdAssetDto copy$default(NativeAdAssetDto nativeAdAssetDto, int i, int i2, NativeAdTitleDto nativeAdTitleDto, NativeAdImageDto nativeAdImageDto, NativeAdDataDto nativeAdDataDto, NativeAdVideoDto nativeAdVideoDto, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = nativeAdAssetDto.id;
        }
        if ((i3 & 2) != 0) {
            i2 = nativeAdAssetDto.required;
        }
        if ((i3 & 4) != 0) {
            nativeAdTitleDto = nativeAdAssetDto.title;
        }
        if ((i3 & 8) != 0) {
            nativeAdImageDto = nativeAdAssetDto.img;
        }
        if ((i3 & 16) != 0) {
            nativeAdDataDto = nativeAdAssetDto.data;
        }
        if ((i3 & 32) != 0) {
            nativeAdVideoDto = nativeAdAssetDto.video;
        }
        NativeAdDataDto nativeAdDataDto2 = nativeAdDataDto;
        NativeAdVideoDto nativeAdVideoDto2 = nativeAdVideoDto;
        return nativeAdAssetDto.copy(i, i2, nativeAdTitleDto, nativeAdImageDto, nativeAdDataDto2, nativeAdVideoDto2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getRequired() {
        return this.required;
    }

    /* renamed from: component3, reason: from getter */
    public final NativeAdTitleDto getTitle() {
        return this.title;
    }

    /* renamed from: component4, reason: from getter */
    public final NativeAdImageDto getImg() {
        return this.img;
    }

    /* renamed from: component5, reason: from getter */
    public final NativeAdDataDto getData() {
        return this.data;
    }

    /* renamed from: component6, reason: from getter */
    public final NativeAdVideoDto getVideo() {
        return this.video;
    }

    public final NativeAdAssetDto copy(int id, int required, NativeAdTitleDto title, NativeAdImageDto img, NativeAdDataDto data, NativeAdVideoDto video) {
        return new NativeAdAssetDto(id, required, title, img, data, video);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeAdAssetDto)) {
            return false;
        }
        NativeAdAssetDto nativeAdAssetDto = (NativeAdAssetDto) other;
        return this.id == nativeAdAssetDto.id && this.required == nativeAdAssetDto.required && Intrinsics.areEqual(this.title, nativeAdAssetDto.title) && Intrinsics.areEqual(this.img, nativeAdAssetDto.img) && Intrinsics.areEqual(this.data, nativeAdAssetDto.data) && Intrinsics.areEqual(this.video, nativeAdAssetDto.video);
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.required)) * 31;
        NativeAdTitleDto nativeAdTitleDto = this.title;
        int hashCode2 = (hashCode + (nativeAdTitleDto == null ? 0 : nativeAdTitleDto.hashCode())) * 31;
        NativeAdImageDto nativeAdImageDto = this.img;
        int hashCode3 = (hashCode2 + (nativeAdImageDto == null ? 0 : nativeAdImageDto.hashCode())) * 31;
        NativeAdDataDto nativeAdDataDto = this.data;
        int hashCode4 = (hashCode3 + (nativeAdDataDto == null ? 0 : nativeAdDataDto.hashCode())) * 31;
        NativeAdVideoDto nativeAdVideoDto = this.video;
        return hashCode4 + (nativeAdVideoDto != null ? nativeAdVideoDto.hashCode() : 0);
    }

    public String toString() {
        return "NativeAdAssetDto(id=" + this.id + ", required=" + this.required + ", title=" + this.title + ", img=" + this.img + ", data=" + this.data + ", video=" + this.video + ')';
    }

    /* compiled from: NativeAdDto.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/NativeAdAssetDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/NativeAdAssetDto;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NativeAdAssetDto> serializer() {
            return NativeAdAssetDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NativeAdAssetDto(int i, int i2, int i3, NativeAdTitleDto nativeAdTitleDto, NativeAdImageDto nativeAdImageDto, NativeAdDataDto nativeAdDataDto, NativeAdVideoDto nativeAdVideoDto, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, NativeAdAssetDto$$serializer.INSTANCE.getDescriptor());
        }
        this.id = i2;
        this.required = i3;
        if ((i & 4) == 0) {
            this.title = null;
        } else {
            this.title = nativeAdTitleDto;
        }
        if ((i & 8) == 0) {
            this.img = null;
        } else {
            this.img = nativeAdImageDto;
        }
        if ((i & 16) == 0) {
            this.data = null;
        } else {
            this.data = nativeAdDataDto;
        }
        if ((i & 32) == 0) {
            this.video = null;
        } else {
            this.video = nativeAdVideoDto;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$adn_sdk_release(NativeAdAssetDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.id);
        output.encodeIntElement(serialDesc, 1, self.required);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.title != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, NativeAdTitleDto$$serializer.INSTANCE, self.title);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.img != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, NativeAdImageDto$$serializer.INSTANCE, self.img);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 4) || self.data != null) {
            output.encodeNullableSerializableElement(serialDesc, 4, NativeAdDataDto$$serializer.INSTANCE, self.data);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 5) && self.video == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 5, NativeAdVideoDto$$serializer.INSTANCE, self.video);
    }

    public NativeAdAssetDto(int i, int i2, NativeAdTitleDto nativeAdTitleDto, NativeAdImageDto nativeAdImageDto, NativeAdDataDto nativeAdDataDto, NativeAdVideoDto nativeAdVideoDto) {
        this.id = i;
        this.required = i2;
        this.title = nativeAdTitleDto;
        this.img = nativeAdImageDto;
        this.data = nativeAdDataDto;
        this.video = nativeAdVideoDto;
    }

    public /* synthetic */ NativeAdAssetDto(int i, int i2, NativeAdTitleDto nativeAdTitleDto, NativeAdImageDto nativeAdImageDto, NativeAdDataDto nativeAdDataDto, NativeAdVideoDto nativeAdVideoDto, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, (i3 & 4) != 0 ? null : nativeAdTitleDto, (i3 & 8) != 0 ? null : nativeAdImageDto, (i3 & 16) != 0 ? null : nativeAdDataDto, (i3 & 32) != 0 ? null : nativeAdVideoDto);
    }

    public final int getId() {
        return this.id;
    }

    public final int getRequired() {
        return this.required;
    }

    public final NativeAdTitleDto getTitle() {
        return this.title;
    }

    public final NativeAdImageDto getImg() {
        return this.img;
    }

    public final NativeAdDataDto getData() {
        return this.data;
    }

    public final NativeAdVideoDto getVideo() {
        return this.video;
    }
}
