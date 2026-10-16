package io.adn.sdk.internal.data.dto;

import io.bidmachine.iab.vast.tags.VastAttributes;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: NativeAdDto.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0007R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"io/adn/sdk/internal/data/dto/NativeAdAssetDto.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/adn/sdk/internal/data/dto/NativeAdAssetDto;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes7.dex */
public /* synthetic */ class NativeAdAssetDto$$serializer implements GeneratedSerializer<NativeAdAssetDto> {
    public static final int $stable;
    public static final NativeAdAssetDto$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private NativeAdAssetDto$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        NativeAdAssetDto$$serializer nativeAdAssetDto$$serializer = new NativeAdAssetDto$$serializer();
        INSTANCE = nativeAdAssetDto$$serializer;
        $stable = 8;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.adn.sdk.internal.data.dto.NativeAdAssetDto", nativeAdAssetDto$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement(VastAttributes.REQUIRED, false);
        pluginGeneratedSerialDescriptor.addElement("title", true);
        pluginGeneratedSerialDescriptor.addElement("img", true);
        pluginGeneratedSerialDescriptor.addElement("data", true);
        pluginGeneratedSerialDescriptor.addElement("video", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(NativeAdTitleDto$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(NativeAdImageDto$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(NativeAdDataDto$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(NativeAdVideoDto$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final NativeAdAssetDto deserialize(Decoder decoder) {
        int i;
        int i2;
        NativeAdDataDto nativeAdDataDto;
        NativeAdVideoDto nativeAdVideoDto;
        NativeAdTitleDto nativeAdTitleDto;
        NativeAdImageDto nativeAdImageDto;
        int i3;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            i = beginStructure.decodeIntElement(serialDescriptor, 0);
            int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 1);
            NativeAdTitleDto nativeAdTitleDto2 = (NativeAdTitleDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, NativeAdTitleDto$$serializer.INSTANCE, null);
            NativeAdImageDto nativeAdImageDto2 = (NativeAdImageDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, NativeAdImageDto$$serializer.INSTANCE, null);
            NativeAdDataDto nativeAdDataDto2 = (NativeAdDataDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, NativeAdDataDto$$serializer.INSTANCE, null);
            nativeAdVideoDto = (NativeAdVideoDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, NativeAdVideoDto$$serializer.INSTANCE, null);
            nativeAdImageDto = nativeAdImageDto2;
            nativeAdDataDto = nativeAdDataDto2;
            nativeAdTitleDto = nativeAdTitleDto2;
            i3 = decodeIntElement;
            i2 = 63;
        } else {
            boolean z = true;
            i = 0;
            i2 = 0;
            NativeAdTitleDto nativeAdTitleDto3 = null;
            NativeAdImageDto nativeAdImageDto3 = null;
            NativeAdDataDto nativeAdDataDto3 = null;
            NativeAdVideoDto nativeAdVideoDto2 = null;
            int i4 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        continue;
                    case 0:
                        i = beginStructure.decodeIntElement(serialDescriptor, 0);
                        i2 |= 1;
                        continue;
                    case 1:
                        i4 = beginStructure.decodeIntElement(serialDescriptor, 1);
                        i2 |= 2;
                        break;
                    case 2:
                        nativeAdTitleDto3 = (NativeAdTitleDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, NativeAdTitleDto$$serializer.INSTANCE, nativeAdTitleDto3);
                        i2 |= 4;
                        break;
                    case 3:
                        nativeAdImageDto3 = (NativeAdImageDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, NativeAdImageDto$$serializer.INSTANCE, nativeAdImageDto3);
                        i2 |= 8;
                        break;
                    case 4:
                        nativeAdDataDto3 = (NativeAdDataDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, NativeAdDataDto$$serializer.INSTANCE, nativeAdDataDto3);
                        i2 |= 16;
                        break;
                    case 5:
                        nativeAdVideoDto2 = (NativeAdVideoDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, NativeAdVideoDto$$serializer.INSTANCE, nativeAdVideoDto2);
                        i2 |= 32;
                        break;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            nativeAdDataDto = nativeAdDataDto3;
            nativeAdVideoDto = nativeAdVideoDto2;
            nativeAdTitleDto = nativeAdTitleDto3;
            nativeAdImageDto = nativeAdImageDto3;
            i3 = i4;
        }
        beginStructure.endStructure(serialDescriptor);
        return new NativeAdAssetDto(i2, i, i3, nativeAdTitleDto, nativeAdImageDto, nativeAdDataDto, nativeAdVideoDto, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, NativeAdAssetDto value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        NativeAdAssetDto.write$Self$adn_sdk_release(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
