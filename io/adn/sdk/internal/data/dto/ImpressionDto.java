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

/* compiled from: AdRequestBody.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 +2\u00020\u0001:\u0002*+B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bBA\b\u0010\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u000fJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003J5\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÇ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010 \u001a\u00020\tH×\u0001J\t\u0010!\u001a\u00020\u0003H×\u0001J%\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00002\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0001¢\u0006\u0002\b)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006,"}, d2 = {"Lio/adn/sdk/internal/data/dto/ImpressionDto;", "", "id", "", "video", "Lio/adn/sdk/internal/data/dto/VideoDto;", "native", "Lio/adn/sdk/internal/data/dto/NativeDto;", "rwdd", "", "<init>", "(Ljava/lang/String;Lio/adn/sdk/internal/data/dto/VideoDto;Lio/adn/sdk/internal/data/dto/NativeDto;I)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lio/adn/sdk/internal/data/dto/VideoDto;Lio/adn/sdk/internal/data/dto/NativeDto;ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getId", "()Ljava/lang/String;", "getVideo", "()Lio/adn/sdk/internal/data/dto/VideoDto;", "getNative", "()Lio/adn/sdk/internal/data/dto/NativeDto;", "getRwdd", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class ImpressionDto {
    private final String id;
    private final NativeDto native;
    private final int rwdd;
    private final VideoDto video;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ ImpressionDto copy$default(ImpressionDto impressionDto, String str, VideoDto videoDto, NativeDto nativeDto, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = impressionDto.id;
        }
        if ((i2 & 2) != 0) {
            videoDto = impressionDto.video;
        }
        if ((i2 & 4) != 0) {
            nativeDto = impressionDto.native;
        }
        if ((i2 & 8) != 0) {
            i = impressionDto.rwdd;
        }
        return impressionDto.copy(str, videoDto, nativeDto, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final VideoDto getVideo() {
        return this.video;
    }

    /* renamed from: component3, reason: from getter */
    public final NativeDto getNative() {
        return this.native;
    }

    /* renamed from: component4, reason: from getter */
    public final int getRwdd() {
        return this.rwdd;
    }

    public final ImpressionDto copy(String id, VideoDto video, NativeDto r4, int rwdd) {
        Intrinsics.checkNotNullParameter(id, "id");
        return new ImpressionDto(id, video, r4, rwdd);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ImpressionDto)) {
            return false;
        }
        ImpressionDto impressionDto = (ImpressionDto) other;
        return Intrinsics.areEqual(this.id, impressionDto.id) && Intrinsics.areEqual(this.video, impressionDto.video) && Intrinsics.areEqual(this.native, impressionDto.native) && this.rwdd == impressionDto.rwdd;
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        VideoDto videoDto = this.video;
        int hashCode2 = (hashCode + (videoDto == null ? 0 : videoDto.hashCode())) * 31;
        NativeDto nativeDto = this.native;
        return ((hashCode2 + (nativeDto != null ? nativeDto.hashCode() : 0)) * 31) + Integer.hashCode(this.rwdd);
    }

    public String toString() {
        return "ImpressionDto(id=" + this.id + ", video=" + this.video + ", native=" + this.native + ", rwdd=" + this.rwdd + ')';
    }

    /* compiled from: AdRequestBody.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/ImpressionDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/ImpressionDto;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<ImpressionDto> serializer() {
            return ImpressionDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ ImpressionDto(int i, String str, VideoDto videoDto, NativeDto nativeDto, int i2, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, ImpressionDto$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.video = videoDto;
        this.native = nativeDto;
        this.rwdd = i2;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$adn_sdk_release(ImpressionDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeNullableSerializableElement(serialDesc, 1, VideoDto$$serializer.INSTANCE, self.video);
        output.encodeNullableSerializableElement(serialDesc, 2, NativeDto$$serializer.INSTANCE, self.native);
        output.encodeIntElement(serialDesc, 3, self.rwdd);
    }

    public ImpressionDto(String id, VideoDto videoDto, NativeDto nativeDto, int i) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
        this.video = videoDto;
        this.native = nativeDto;
        this.rwdd = i;
    }

    public final String getId() {
        return this.id;
    }

    public final VideoDto getVideo() {
        return this.video;
    }

    public final NativeDto getNative() {
        return this.native;
    }

    public final int getRwdd() {
        return this.rwdd;
    }
}
