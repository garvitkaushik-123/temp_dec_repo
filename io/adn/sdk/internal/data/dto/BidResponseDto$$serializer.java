package io.adn.sdk.internal.data.dto;

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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: BidResponseDto.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0007R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"io/adn/sdk/internal/data/dto/BidResponseDto.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/adn/sdk/internal/data/dto/BidResponseDto;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes7.dex */
public /* synthetic */ class BidResponseDto$$serializer implements GeneratedSerializer<BidResponseDto> {
    public static final int $stable;
    public static final BidResponseDto$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private BidResponseDto$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        BidResponseDto$$serializer bidResponseDto$$serializer = new BidResponseDto$$serializer();
        INSTANCE = bidResponseDto$$serializer;
        $stable = 8;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.adn.sdk.internal.data.dto.BidResponseDto", bidResponseDto$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement("adm", false);
        pluginGeneratedSerialDescriptor.addElement("sor", false);
        pluginGeneratedSerialDescriptor.addElement("adc", false);
        pluginGeneratedSerialDescriptor.addElement("promotedApp", false);
        pluginGeneratedSerialDescriptor.addElement("bi", false);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("price", false);
        pluginGeneratedSerialDescriptor.addElement("crid", false);
        pluginGeneratedSerialDescriptor.addElement("cid", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(AdConfigDto$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(PromotedAppDto$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), DoubleSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final BidResponseDto deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        AdConfigDto adConfigDto;
        PromotedAppDto promotedAppDto;
        String str4;
        double d;
        int i;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        int i2 = 7;
        String str7 = null;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            AdConfigDto adConfigDto2 = (AdConfigDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, AdConfigDto$$serializer.INSTANCE, null);
            PromotedAppDto promotedAppDto2 = (PromotedAppDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, PromotedAppDto$$serializer.INSTANCE, null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, null);
            double decodeDoubleElement = beginStructure.decodeDoubleElement(serialDescriptor, 6);
            str2 = decodeStringElement;
            str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, null);
            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, null);
            str4 = str10;
            str = str9;
            str3 = str8;
            d = decodeDoubleElement;
            promotedAppDto = promotedAppDto2;
            i = 511;
            adConfigDto = adConfigDto2;
        } else {
            boolean z = true;
            int i3 = 0;
            String str11 = null;
            String str12 = null;
            String str13 = null;
            String str14 = null;
            PromotedAppDto promotedAppDto3 = null;
            double d2 = 0.0d;
            String str15 = null;
            AdConfigDto adConfigDto3 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                    case 0:
                        str7 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i3 |= 1;
                        i2 = 7;
                    case 1:
                        str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str15);
                        i3 |= 2;
                        i2 = 7;
                    case 2:
                        adConfigDto3 = (AdConfigDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, AdConfigDto$$serializer.INSTANCE, adConfigDto3);
                        i3 |= 4;
                        i2 = 7;
                    case 3:
                        promotedAppDto3 = (PromotedAppDto) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, PromotedAppDto$$serializer.INSTANCE, promotedAppDto3);
                        i3 |= 8;
                        i2 = 7;
                    case 4:
                        str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str14);
                        i3 |= 16;
                        i2 = 7;
                    case 5:
                        str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str13);
                        i3 |= 32;
                    case 6:
                        d2 = beginStructure.decodeDoubleElement(serialDescriptor, 6);
                        i3 |= 64;
                    case 7:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str12);
                        i3 |= 128;
                    case 8:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str11);
                        i3 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            PromotedAppDto promotedAppDto4 = promotedAppDto3;
            str = str14;
            str2 = str7;
            str3 = str15;
            adConfigDto = adConfigDto3;
            promotedAppDto = promotedAppDto4;
            str4 = str13;
            d = d2;
            i = i3;
            str5 = str11;
            str6 = str12;
        }
        beginStructure.endStructure(serialDescriptor);
        return new BidResponseDto(i, str2, str3, adConfigDto, promotedAppDto, str, str4, d, str6, str5, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, BidResponseDto value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        BidResponseDto.write$Self$adn_sdk_release(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
