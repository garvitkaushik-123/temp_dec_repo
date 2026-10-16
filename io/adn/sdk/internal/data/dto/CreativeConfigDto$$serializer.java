package io.adn.sdk.internal.data.dto;

import com.mbridge.msdk.foundation.entity.CampaignEx;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: BidResponseDto.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0007R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"io/adn/sdk/internal/data/dto/CreativeConfigDto.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/adn/sdk/internal/data/dto/CreativeConfigDto;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes7.dex */
public /* synthetic */ class CreativeConfigDto$$serializer implements GeneratedSerializer<CreativeConfigDto> {
    public static final int $stable;
    public static final CreativeConfigDto$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private CreativeConfigDto$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CreativeConfigDto$$serializer creativeConfigDto$$serializer = new CreativeConfigDto$$serializer();
        INSTANCE = creativeConfigDto$$serializer;
        $stable = 8;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.adn.sdk.internal.data.dto.CreativeConfigDto", creativeConfigDto$$serializer, 27);
        pluginGeneratedSerialDescriptor.addElement("cbc", false);
        pluginGeneratedSerialDescriptor.addElement("cbcr", false);
        pluginGeneratedSerialDescriptor.addElement("cbde", false);
        pluginGeneratedSerialDescriptor.addElement("cbp", false);
        pluginGeneratedSerialDescriptor.addElement("cbt", false);
        pluginGeneratedSerialDescriptor.addElement("cbs", false);
        pluginGeneratedSerialDescriptor.addElement("prbc", false);
        pluginGeneratedSerialDescriptor.addElement("prbp", false);
        pluginGeneratedSerialDescriptor.addElement("prbs", false);
        pluginGeneratedSerialDescriptor.addElement("ctabc", false);
        pluginGeneratedSerialDescriptor.addElement("ctabe", false);
        pluginGeneratedSerialDescriptor.addElement("ctabp", false);
        pluginGeneratedSerialDescriptor.addElement("ctabs", false);
        pluginGeneratedSerialDescriptor.addElement("ctatc", false);
        pluginGeneratedSerialDescriptor.addElement("mbc", false);
        pluginGeneratedSerialDescriptor.addElement("mbp", false);
        pluginGeneratedSerialDescriptor.addElement("mbs", false);
        pluginGeneratedSerialDescriptor.addElement("pbc", false);
        pluginGeneratedSerialDescriptor.addElement("pbe", false);
        pluginGeneratedSerialDescriptor.addElement("pbp", false);
        pluginGeneratedSerialDescriptor.addElement(CampaignEx.KEY_ACTIVITY_PATH_AND_NAME, false);
        pluginGeneratedSerialDescriptor.addElement("skbdd", false);
        pluginGeneratedSerialDescriptor.addElement("skbs", false);
        pluginGeneratedSerialDescriptor.addElement("rd", false);
        pluginGeneratedSerialDescriptor.addElement("rs", false);
        pluginGeneratedSerialDescriptor.addElement("als", false);
        pluginGeneratedSerialDescriptor.addElement("lce", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final CreativeConfigDto deserialize(Decoder decoder) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        int i;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        int i2;
        int i3;
        int i4;
        String str30;
        String str31;
        int i5;
        String str32;
        int i6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        if (beginStructure.decodeSequentially()) {
            String str33 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
            String str34 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
            String str35 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
            String str36 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, null);
            String str37 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, null);
            String str38 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, null);
            String str39 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, null);
            String str40 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, null);
            String str41 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, null);
            String str42 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, null);
            String str43 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, null);
            String str44 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, null);
            String str45 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, null);
            String str46 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, null);
            String str47 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, null);
            String str48 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, null);
            String str49 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, null);
            String str50 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, null);
            String str51 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, null);
            String str52 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, null);
            String str53 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, null);
            String str54 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, null);
            String str55 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, StringSerializer.INSTANCE, null);
            String str56 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 23, StringSerializer.INSTANCE, null);
            String str57 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 24, StringSerializer.INSTANCE, null);
            String str58 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 25, StringSerializer.INSTANCE, null);
            str21 = str53;
            str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 26, StringSerializer.INSTANCE, null);
            str23 = str35;
            str22 = str52;
            str26 = str51;
            str18 = str50;
            str = str54;
            str27 = str55;
            str7 = str56;
            str6 = str57;
            str5 = str58;
            str10 = str38;
            str8 = str36;
            str9 = str37;
            str14 = str49;
            str15 = str48;
            str17 = str47;
            str16 = str46;
            str25 = str45;
            str24 = str41;
            str11 = str39;
            str20 = str43;
            str19 = str42;
            str12 = str40;
            str13 = str33;
            str2 = str34;
            i = 134217727;
            str3 = str44;
        } else {
            boolean z = true;
            String str59 = null;
            String str60 = null;
            String str61 = null;
            String str62 = null;
            String str63 = null;
            String str64 = null;
            String str65 = null;
            String str66 = null;
            String str67 = null;
            String str68 = null;
            String str69 = null;
            String str70 = null;
            String str71 = null;
            String str72 = null;
            String str73 = null;
            String str74 = null;
            String str75 = null;
            String str76 = null;
            String str77 = null;
            String str78 = null;
            String str79 = null;
            String str80 = null;
            String str81 = null;
            String str82 = null;
            String str83 = null;
            String str84 = null;
            int i7 = 0;
            String str85 = null;
            while (z) {
                int i8 = i7;
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        str30 = str85;
                        z = false;
                        str61 = str61;
                        str59 = str59;
                        i7 = i8;
                        str85 = str30;
                    case 0:
                        str31 = str59;
                        str71 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str71);
                        i5 = i8 | 1;
                        str60 = str60;
                        str85 = str85;
                        str61 = str61;
                        str72 = str72;
                        i7 = i5;
                        str59 = str31;
                    case 1:
                        str32 = str60;
                        str72 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str72);
                        i6 = i8 | 2;
                        str59 = str59;
                        str85 = str85;
                        str61 = str61;
                        str73 = str73;
                        i7 = i6;
                        str60 = str32;
                    case 2:
                        str31 = str59;
                        str73 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str73);
                        i5 = i8 | 4;
                        str60 = str60;
                        str85 = str85;
                        str61 = str61;
                        str74 = str74;
                        i7 = i5;
                        str59 = str31;
                    case 3:
                        str32 = str60;
                        str74 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str74);
                        i6 = i8 | 8;
                        str59 = str59;
                        str85 = str85;
                        str61 = str61;
                        str75 = str75;
                        i7 = i6;
                        str60 = str32;
                    case 4:
                        str31 = str59;
                        str75 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str75);
                        i5 = i8 | 16;
                        str60 = str60;
                        str85 = str85;
                        str61 = str61;
                        str76 = str76;
                        i7 = i5;
                        str59 = str31;
                    case 5:
                        str32 = str60;
                        str76 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str76);
                        i6 = i8 | 32;
                        str59 = str59;
                        str85 = str85;
                        str61 = str61;
                        str77 = str77;
                        i7 = i6;
                        str60 = str32;
                    case 6:
                        str31 = str59;
                        str77 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str77);
                        i5 = i8 | 64;
                        str60 = str60;
                        str85 = str85;
                        str61 = str61;
                        str78 = str78;
                        i7 = i5;
                        str59 = str31;
                    case 7:
                        str32 = str60;
                        str78 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str78);
                        i6 = i8 | 128;
                        str59 = str59;
                        str85 = str85;
                        str61 = str61;
                        str79 = str79;
                        i7 = i6;
                        str60 = str32;
                    case 8:
                        str31 = str59;
                        str79 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str79);
                        i5 = i8 | 256;
                        str60 = str60;
                        str85 = str85;
                        str61 = str61;
                        str80 = str80;
                        i7 = i5;
                        str59 = str31;
                    case 9:
                        str32 = str60;
                        str80 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, str80);
                        i6 = i8 | 512;
                        str59 = str59;
                        str85 = str85;
                        str61 = str61;
                        str81 = str81;
                        i7 = i6;
                        str60 = str32;
                    case 10:
                        str31 = str59;
                        str81 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 10, StringSerializer.INSTANCE, str81);
                        i5 = i8 | 1024;
                        str60 = str60;
                        str85 = str85;
                        str61 = str61;
                        str82 = str82;
                        i7 = i5;
                        str59 = str31;
                    case 11:
                        str32 = str60;
                        str82 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 11, StringSerializer.INSTANCE, str82);
                        i6 = i8 | 2048;
                        str59 = str59;
                        str85 = str85;
                        str61 = str61;
                        str83 = str83;
                        i7 = i6;
                        str60 = str32;
                    case 12:
                        str31 = str59;
                        str83 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 12, StringSerializer.INSTANCE, str83);
                        i5 = i8 | 4096;
                        str60 = str60;
                        str85 = str85;
                        str61 = str61;
                        i7 = i5;
                        str59 = str31;
                    case 13:
                        str30 = str85;
                        str84 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str84);
                        i7 = i8 | 8192;
                        str59 = str59;
                        str60 = str60;
                        str85 = str30;
                    case 14:
                        str31 = str59;
                        str85 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str85);
                        i7 = i8 | 16384;
                        str60 = str60;
                        str59 = str31;
                    case 15:
                        str28 = str59;
                        str29 = str85;
                        str65 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str65);
                        i2 = 32768;
                        i3 = i8 | i2;
                        str59 = str28;
                        i7 = i3;
                        str85 = str29;
                    case 16:
                        str28 = str59;
                        str29 = str85;
                        str64 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str64);
                        i2 = 65536;
                        i3 = i8 | i2;
                        str59 = str28;
                        i7 = i3;
                        str85 = str29;
                    case 17:
                        str28 = str59;
                        str29 = str85;
                        str61 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str61);
                        i2 = 131072;
                        i3 = i8 | i2;
                        str59 = str28;
                        i7 = i3;
                        str85 = str29;
                    case 18:
                        str28 = str59;
                        str29 = str85;
                        str62 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 18, StringSerializer.INSTANCE, str62);
                        i2 = 262144;
                        i3 = i8 | i2;
                        str59 = str28;
                        i7 = i3;
                        str85 = str29;
                    case 19:
                        str29 = str85;
                        str28 = str59;
                        str60 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 19, StringSerializer.INSTANCE, str60);
                        i2 = 524288;
                        i3 = i8 | i2;
                        str59 = str28;
                        i7 = i3;
                        str85 = str29;
                    case 20:
                        str29 = str85;
                        str70 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 20, StringSerializer.INSTANCE, str70);
                        i3 = i8 | 1048576;
                        i7 = i3;
                        str85 = str29;
                    case 21:
                        str29 = str85;
                        str69 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 21, StringSerializer.INSTANCE, str69);
                        i4 = 2097152;
                        i7 = i8 | i4;
                        str85 = str29;
                    case 22:
                        str29 = str85;
                        str63 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 22, StringSerializer.INSTANCE, str63);
                        i4 = 4194304;
                        i7 = i8 | i4;
                        str85 = str29;
                    case 23:
                        str29 = str85;
                        str68 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 23, StringSerializer.INSTANCE, str68);
                        i4 = 8388608;
                        i7 = i8 | i4;
                        str85 = str29;
                    case 24:
                        str29 = str85;
                        str67 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 24, StringSerializer.INSTANCE, str67);
                        i4 = 16777216;
                        i7 = i8 | i4;
                        str85 = str29;
                    case 25:
                        str29 = str85;
                        str66 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 25, StringSerializer.INSTANCE, str66);
                        i4 = 33554432;
                        i7 = i8 | i4;
                        str85 = str29;
                    case 26:
                        str29 = str85;
                        str59 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 26, StringSerializer.INSTANCE, str59);
                        i4 = 67108864;
                        i7 = i8 | i4;
                        str85 = str29;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str86 = str59;
            String str87 = str71;
            String str88 = str73;
            String str89 = str74;
            str = str69;
            str2 = str72;
            str3 = str82;
            str4 = str86;
            str5 = str66;
            str6 = str67;
            str7 = str68;
            str8 = str89;
            str9 = str75;
            str10 = str76;
            str11 = str77;
            str12 = str78;
            str13 = str87;
            str14 = str64;
            str15 = str65;
            i = i7;
            str16 = str84;
            str17 = str85;
            str18 = str61;
            str19 = str80;
            str20 = str81;
            str21 = str70;
            str22 = str60;
            str23 = str88;
            str24 = str79;
            str25 = str83;
            str26 = str62;
            str27 = str63;
        }
        beginStructure.endStructure(serialDescriptor);
        return new CreativeConfigDto(i, str13, str2, str23, str8, str9, str10, str11, str12, str24, str19, str20, str3, str25, str16, str17, str15, str14, str18, str26, str22, str21, str, str27, str7, str6, str5, str4, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, CreativeConfigDto value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        CreativeConfigDto.write$Self$adn_sdk_release(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
