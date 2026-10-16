package io.adn.sdk.internal.data.dto;

import java.util.List;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: NativeAdDto.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0007R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"io/adn/sdk/internal/data/dto/NativeAdContentDto.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/adn/sdk/internal/data/dto/NativeAdContentDto;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes7.dex */
public /* synthetic */ class NativeAdContentDto$$serializer implements GeneratedSerializer<NativeAdContentDto> {
    public static final int $stable;
    public static final NativeAdContentDto$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private NativeAdContentDto$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        NativeAdContentDto$$serializer nativeAdContentDto$$serializer = new NativeAdContentDto$$serializer();
        INSTANCE = nativeAdContentDto$$serializer;
        $stable = 8;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.adn.sdk.internal.data.dto.NativeAdContentDto", nativeAdContentDto$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("assets", false);
        pluginGeneratedSerialDescriptor.addElement("link", false);
        pluginGeneratedSerialDescriptor.addElement("imptrackers", false);
        pluginGeneratedSerialDescriptor.addElement("eventtrackers", false);
        pluginGeneratedSerialDescriptor.addElement("ext", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = NativeAdContentDto.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], NativeAdLinkDto$$serializer.INSTANCE, kSerializerArr[2], BuiltinSerializersKt.getNullable(kSerializerArr[3]), BuiltinSerializersKt.getNullable(NativeAdExtDto$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final NativeAdContentDto deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i;
        List list;
        NativeAdLinkDto nativeAdLinkDto;
        List list2;
        List list3;
        NativeAdExtDto nativeAdExtDto;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = NativeAdContentDto.$childSerializers;
        int i2 = 0;
        List list4 = null;
        if (beginStructure.decodeSequentially()) {
            List list5 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            NativeAdLinkDto nativeAdLinkDto2 = (NativeAdLinkDto) beginStructure.decodeSerializableElement(serialDescriptor, 1, NativeAdLinkDto$$serializer.INSTANCE, null);
            List list6 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], null);
            list3 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, kSerializerArr[3], null);
            list = list5;
            nativeAdExtDto = (NativeAdExtDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, NativeAdExtDto$$serializer.INSTANCE, null);
            i = 31;
            list2 = list6;
            nativeAdLinkDto = nativeAdLinkDto2;
        } else {
            int i3 = 1;
            int i4 = 0;
            NativeAdLinkDto nativeAdLinkDto3 = null;
            List list7 = null;
            List list8 = null;
            NativeAdExtDto nativeAdExtDto2 = null;
            while (i3 != 0) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                int i5 = i2;
                if (decodeElementIndex == -1) {
                    i2 = i5;
                    i3 = i2;
                } else if (decodeElementIndex != 0) {
                    if (decodeElementIndex == 1) {
                        nativeAdLinkDto3 = (NativeAdLinkDto) beginStructure.decodeSerializableElement(serialDescriptor, 1, NativeAdLinkDto$$serializer.INSTANCE, nativeAdLinkDto3);
                        i4 |= 2;
                    } else if (decodeElementIndex == 2) {
                        list7 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 2, kSerializerArr[2], list7);
                        i4 |= 4;
                    } else if (decodeElementIndex == 3) {
                        list8 = (List) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, kSerializerArr[3], list8);
                        i4 |= 8;
                    } else {
                        if (decodeElementIndex != 4) {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                        nativeAdExtDto2 = (NativeAdExtDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, NativeAdExtDto$$serializer.INSTANCE, nativeAdExtDto2);
                        i4 |= 16;
                    }
                    i2 = i5;
                } else {
                    list4 = (List) beginStructure.decodeSerializableElement(serialDescriptor, i5, kSerializerArr[i5], list4);
                    i4 |= 1;
                    i2 = i5;
                }
            }
            i = i4;
            list = list4;
            nativeAdLinkDto = nativeAdLinkDto3;
            list2 = list7;
            list3 = list8;
            nativeAdExtDto = nativeAdExtDto2;
        }
        beginStructure.endStructure(serialDescriptor);
        return new NativeAdContentDto(i, list, nativeAdLinkDto, list2, list3, nativeAdExtDto, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, NativeAdContentDto value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        NativeAdContentDto.write$Self$adn_sdk_release(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
