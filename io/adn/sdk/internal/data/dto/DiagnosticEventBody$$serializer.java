package io.adn.sdk.internal.data.dto;

import io.adn.sdk.internal.data.repository.BidTokenRepositoryKt;
import java.util.Map;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DiagnosticEventBody.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0005\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006H\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0007R\u0016\u0010\u0011\u001a\u00020\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"io/adn/sdk/internal/data/dto/DiagnosticEventBody.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lio/adn/sdk/internal/data/dto/DiagnosticEventBody;", "<init>", "()V", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "adn-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
/* loaded from: classes7.dex */
public /* synthetic */ class DiagnosticEventBody$$serializer implements GeneratedSerializer<DiagnosticEventBody> {
    public static final int $stable;
    public static final DiagnosticEventBody$$serializer INSTANCE;
    private static final SerialDescriptor descriptor;

    private DiagnosticEventBody$$serializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public final SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DiagnosticEventBody$$serializer diagnosticEventBody$$serializer = new DiagnosticEventBody$$serializer();
        INSTANCE = diagnosticEventBody$$serializer;
        $stable = 8;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("io.adn.sdk.internal.data.dto.DiagnosticEventBody", diagnosticEventBody$$serializer, 19);
        pluginGeneratedSerialDescriptor.addElement("id", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("schema_id", false);
        pluginGeneratedSerialDescriptor.addElement("created_at", false);
        pluginGeneratedSerialDescriptor.addElement("event_type", false);
        pluginGeneratedSerialDescriptor.addElement(BidTokenRepositoryKt.DEVICE_MODEL, false);
        pluginGeneratedSerialDescriptor.addElement(BidTokenRepositoryKt.APP_VERSION, false);
        pluginGeneratedSerialDescriptor.addElement("bundle_id", false);
        pluginGeneratedSerialDescriptor.addElement(BidTokenRepositoryKt.SDK_VERSION, false);
        pluginGeneratedSerialDescriptor.addElement("os_version", false);
        pluginGeneratedSerialDescriptor.addElement("os_name", false);
        pluginGeneratedSerialDescriptor.addElement("os_sdk_version", false);
        pluginGeneratedSerialDescriptor.addElement("is_simulator", false);
        pluginGeneratedSerialDescriptor.addElement("bid_id", false);
        pluginGeneratedSerialDescriptor.addElement("init_started", false);
        pluginGeneratedSerialDescriptor.addElement("session_id", false);
        pluginGeneratedSerialDescriptor.addElement("ad_type", false);
        pluginGeneratedSerialDescriptor.addElement("mediation", false);
        pluginGeneratedSerialDescriptor.addElement("tags", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public final KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = DiagnosticEventBody.$childSerializers;
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), kSerializerArr[18]};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public final DiagnosticEventBody deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
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
        boolean z;
        String str13;
        String str14;
        String str15;
        String str16;
        Map map;
        String str17;
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
        kSerializerArr = DiagnosticEventBody.$childSerializers;
        int i3 = 8;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(serialDescriptor, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(serialDescriptor, 2);
            String decodeStringElement4 = beginStructure.decodeStringElement(serialDescriptor, 3);
            String decodeStringElement5 = beginStructure.decodeStringElement(serialDescriptor, 4);
            String decodeStringElement6 = beginStructure.decodeStringElement(serialDescriptor, 5);
            String decodeStringElement7 = beginStructure.decodeStringElement(serialDescriptor, 6);
            String decodeStringElement8 = beginStructure.decodeStringElement(serialDescriptor, 7);
            String decodeStringElement9 = beginStructure.decodeStringElement(serialDescriptor, 8);
            String decodeStringElement10 = beginStructure.decodeStringElement(serialDescriptor, 9);
            String decodeStringElement11 = beginStructure.decodeStringElement(serialDescriptor, 10);
            String decodeStringElement12 = beginStructure.decodeStringElement(serialDescriptor, 11);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 12);
            str4 = decodeStringElement4;
            String str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, null);
            String str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, null);
            String str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, null);
            String str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, null);
            str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, null);
            map = (Map) beginStructure.decodeSerializableElement(serialDescriptor, 18, kSerializerArr[18], null);
            str9 = decodeStringElement9;
            str5 = decodeStringElement5;
            z = decodeBooleanElement;
            str11 = decodeStringElement11;
            str10 = decodeStringElement10;
            str8 = decodeStringElement8;
            str12 = decodeStringElement12;
            str17 = str21;
            str16 = str20;
            str13 = str19;
            str = decodeStringElement;
            str14 = str18;
            str2 = decodeStringElement2;
            str3 = decodeStringElement3;
            i = 524287;
            str7 = decodeStringElement7;
            str6 = decodeStringElement6;
        } else {
            int i4 = 18;
            boolean z2 = true;
            boolean z3 = false;
            String str22 = null;
            String str23 = null;
            String str24 = null;
            String str25 = null;
            Map map2 = null;
            String str26 = null;
            String str27 = null;
            String str28 = null;
            String str29 = null;
            String str30 = null;
            String str31 = null;
            String str32 = null;
            String str33 = null;
            String str34 = null;
            String str35 = null;
            String str36 = null;
            String str37 = null;
            int i5 = 0;
            String str38 = null;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                switch (decodeElementIndex) {
                    case -1:
                        z2 = false;
                    case 0:
                        i5 |= 1;
                        str25 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i3 = 8;
                        i4 = 18;
                    case 1:
                        str27 = beginStructure.decodeStringElement(serialDescriptor, 1);
                        i5 |= 2;
                        i3 = 8;
                        i4 = 18;
                    case 2:
                        str28 = beginStructure.decodeStringElement(serialDescriptor, 2);
                        i5 |= 4;
                        i3 = 8;
                        i4 = 18;
                    case 3:
                        str29 = beginStructure.decodeStringElement(serialDescriptor, 3);
                        i5 |= 8;
                        i3 = 8;
                        i4 = 18;
                    case 4:
                        str30 = beginStructure.decodeStringElement(serialDescriptor, 4);
                        i5 |= 16;
                        i3 = 8;
                        i4 = 18;
                    case 5:
                        str31 = beginStructure.decodeStringElement(serialDescriptor, 5);
                        i5 |= 32;
                        i3 = 8;
                        i4 = 18;
                    case 6:
                        str32 = beginStructure.decodeStringElement(serialDescriptor, 6);
                        i5 |= 64;
                        i3 = 8;
                        i4 = 18;
                    case 7:
                        str33 = beginStructure.decodeStringElement(serialDescriptor, 7);
                        i5 |= 128;
                        i4 = 18;
                    case 8:
                        str34 = beginStructure.decodeStringElement(serialDescriptor, i3);
                        i5 |= 256;
                        i4 = 18;
                    case 9:
                        str35 = beginStructure.decodeStringElement(serialDescriptor, 9);
                        i5 |= 512;
                        i4 = 18;
                    case 10:
                        str36 = beginStructure.decodeStringElement(serialDescriptor, 10);
                        i5 |= 1024;
                        i4 = 18;
                    case 11:
                        str37 = beginStructure.decodeStringElement(serialDescriptor, 11);
                        i5 |= 2048;
                        i4 = 18;
                    case 12:
                        z3 = beginStructure.decodeBooleanElement(serialDescriptor, 12);
                        i5 |= 4096;
                        i4 = 18;
                    case 13:
                        str38 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 13, StringSerializer.INSTANCE, str38);
                        i5 |= 8192;
                        i4 = 18;
                    case 14:
                        str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 14, StringSerializer.INSTANCE, str22);
                        i5 |= 16384;
                        i4 = 18;
                    case 15:
                        str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 15, StringSerializer.INSTANCE, str24);
                        i2 = 32768;
                        i5 |= i2;
                        i4 = 18;
                    case 16:
                        str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 16, StringSerializer.INSTANCE, str26);
                        i2 = 65536;
                        i5 |= i2;
                        i4 = 18;
                    case 17:
                        str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 17, StringSerializer.INSTANCE, str23);
                        i2 = 131072;
                        i5 |= i2;
                        i4 = 18;
                    case 18:
                        map2 = (Map) beginStructure.decodeSerializableElement(serialDescriptor, i4, kSerializerArr[i4], map2);
                        i5 |= 262144;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str25;
            str2 = str27;
            str3 = str28;
            str4 = str29;
            str5 = str30;
            str6 = str31;
            str7 = str32;
            str8 = str33;
            str9 = str34;
            str10 = str35;
            str11 = str36;
            str12 = str37;
            z = z3;
            str13 = str22;
            str14 = str38;
            str15 = str23;
            str16 = str24;
            map = map2;
            str17 = str26;
            i = i5;
        }
        beginStructure.endStructure(serialDescriptor);
        return new DiagnosticEventBody(i, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, z, str14, str13, str16, str17, str15, map, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public final void serialize(Encoder encoder, DiagnosticEventBody value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor serialDescriptor = descriptor;
        CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
        DiagnosticEventBody.write$Self$adn_sdk_release(value, beginStructure, serialDescriptor);
        beginStructure.endStructure(serialDescriptor);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
