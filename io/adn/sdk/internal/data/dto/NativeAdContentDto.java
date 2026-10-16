package io.adn.sdk.internal.data.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: NativeAdDto.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0081\b\u0018\u0000 02\u00020\u0001:\u0002/0BE\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\r\u0010\u000eB_\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\r\u0010\u0013J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u0003HÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\fHÆ\u0003JQ\u0010!\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fHÇ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H×\u0003J\t\u0010%\u001a\u00020\u0010H×\u0001J\t\u0010&\u001a\u00020\bH×\u0001J%\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0001¢\u0006\u0002\b.R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u00061"}, d2 = {"Lio/adn/sdk/internal/data/dto/NativeAdContentDto;", "", "assets", "", "Lio/adn/sdk/internal/data/dto/NativeAdAssetDto;", "link", "Lio/adn/sdk/internal/data/dto/NativeAdLinkDto;", "imptrackers", "", "eventtrackers", "Lio/adn/sdk/internal/data/dto/EventTrackerDto;", "ext", "Lio/adn/sdk/internal/data/dto/NativeAdExtDto;", "<init>", "(Ljava/util/List;Lio/adn/sdk/internal/data/dto/NativeAdLinkDto;Ljava/util/List;Ljava/util/List;Lio/adn/sdk/internal/data/dto/NativeAdExtDto;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Lio/adn/sdk/internal/data/dto/NativeAdLinkDto;Ljava/util/List;Ljava/util/List;Lio/adn/sdk/internal/data/dto/NativeAdExtDto;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAssets", "()Ljava/util/List;", "getLink", "()Lio/adn/sdk/internal/data/dto/NativeAdLinkDto;", "getImptrackers", "getEventtrackers", "getExt", "()Lio/adn/sdk/internal/data/dto/NativeAdExtDto;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$adn_sdk_release", "$serializer", "Companion", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
/* loaded from: classes7.dex */
public final /* data */ class NativeAdContentDto {
    private final List<NativeAdAssetDto> assets;
    private final List<EventTrackerDto> eventtrackers;
    private final NativeAdExtDto ext;
    private final List<String> imptrackers;
    private final NativeAdLinkDto link;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(NativeAdAssetDto$$serializer.INSTANCE), null, new ArrayListSerializer(StringSerializer.INSTANCE), new ArrayListSerializer(EventTrackerDto$$serializer.INSTANCE), null};

    public static /* synthetic */ NativeAdContentDto copy$default(NativeAdContentDto nativeAdContentDto, List list, NativeAdLinkDto nativeAdLinkDto, List list2, List list3, NativeAdExtDto nativeAdExtDto, int i, Object obj) {
        if ((i & 1) != 0) {
            list = nativeAdContentDto.assets;
        }
        if ((i & 2) != 0) {
            nativeAdLinkDto = nativeAdContentDto.link;
        }
        if ((i & 4) != 0) {
            list2 = nativeAdContentDto.imptrackers;
        }
        if ((i & 8) != 0) {
            list3 = nativeAdContentDto.eventtrackers;
        }
        if ((i & 16) != 0) {
            nativeAdExtDto = nativeAdContentDto.ext;
        }
        NativeAdExtDto nativeAdExtDto2 = nativeAdExtDto;
        List list4 = list2;
        return nativeAdContentDto.copy(list, nativeAdLinkDto, list4, list3, nativeAdExtDto2);
    }

    public final List<NativeAdAssetDto> component1() {
        return this.assets;
    }

    /* renamed from: component2, reason: from getter */
    public final NativeAdLinkDto getLink() {
        return this.link;
    }

    public final List<String> component3() {
        return this.imptrackers;
    }

    public final List<EventTrackerDto> component4() {
        return this.eventtrackers;
    }

    /* renamed from: component5, reason: from getter */
    public final NativeAdExtDto getExt() {
        return this.ext;
    }

    public final NativeAdContentDto copy(List<NativeAdAssetDto> assets, NativeAdLinkDto link, List<String> imptrackers, List<EventTrackerDto> eventtrackers, NativeAdExtDto ext) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(imptrackers, "imptrackers");
        return new NativeAdContentDto(assets, link, imptrackers, eventtrackers, ext);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NativeAdContentDto)) {
            return false;
        }
        NativeAdContentDto nativeAdContentDto = (NativeAdContentDto) other;
        return Intrinsics.areEqual(this.assets, nativeAdContentDto.assets) && Intrinsics.areEqual(this.link, nativeAdContentDto.link) && Intrinsics.areEqual(this.imptrackers, nativeAdContentDto.imptrackers) && Intrinsics.areEqual(this.eventtrackers, nativeAdContentDto.eventtrackers) && Intrinsics.areEqual(this.ext, nativeAdContentDto.ext);
    }

    public int hashCode() {
        int hashCode = ((((this.assets.hashCode() * 31) + this.link.hashCode()) * 31) + this.imptrackers.hashCode()) * 31;
        List<EventTrackerDto> list = this.eventtrackers;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        NativeAdExtDto nativeAdExtDto = this.ext;
        return hashCode2 + (nativeAdExtDto != null ? nativeAdExtDto.hashCode() : 0);
    }

    public String toString() {
        return "NativeAdContentDto(assets=" + this.assets + ", link=" + this.link + ", imptrackers=" + this.imptrackers + ", eventtrackers=" + this.eventtrackers + ", ext=" + this.ext + ')';
    }

    /* compiled from: NativeAdDto.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¨\u0006\u0007"}, d2 = {"Lio/adn/sdk/internal/data/dto/NativeAdContentDto$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lio/adn/sdk/internal/data/dto/NativeAdContentDto;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer<NativeAdContentDto> serializer() {
            return NativeAdContentDto$$serializer.INSTANCE;
        }
    }

    public /* synthetic */ NativeAdContentDto(int i, List list, NativeAdLinkDto nativeAdLinkDto, List list2, List list3, NativeAdExtDto nativeAdExtDto, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, NativeAdContentDto$$serializer.INSTANCE.getDescriptor());
        }
        this.assets = list;
        this.link = nativeAdLinkDto;
        this.imptrackers = list2;
        this.eventtrackers = list3;
        this.ext = nativeAdExtDto;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$adn_sdk_release(NativeAdContentDto self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeSerializableElement(serialDesc, 0, kSerializerArr[0], self.assets);
        output.encodeSerializableElement(serialDesc, 1, NativeAdLinkDto$$serializer.INSTANCE, self.link);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.imptrackers);
        output.encodeNullableSerializableElement(serialDesc, 3, kSerializerArr[3], self.eventtrackers);
        output.encodeNullableSerializableElement(serialDesc, 4, NativeAdExtDto$$serializer.INSTANCE, self.ext);
    }

    public NativeAdContentDto(List<NativeAdAssetDto> assets, NativeAdLinkDto link, List<String> imptrackers, List<EventTrackerDto> list, NativeAdExtDto nativeAdExtDto) {
        Intrinsics.checkNotNullParameter(assets, "assets");
        Intrinsics.checkNotNullParameter(link, "link");
        Intrinsics.checkNotNullParameter(imptrackers, "imptrackers");
        this.assets = assets;
        this.link = link;
        this.imptrackers = imptrackers;
        this.eventtrackers = list;
        this.ext = nativeAdExtDto;
    }

    public final List<NativeAdAssetDto> getAssets() {
        return this.assets;
    }

    public final NativeAdLinkDto getLink() {
        return this.link;
    }

    public final List<String> getImptrackers() {
        return this.imptrackers;
    }

    public final List<EventTrackerDto> getEventtrackers() {
        return this.eventtrackers;
    }

    public final NativeAdExtDto getExt() {
        return this.ext;
    }
}
