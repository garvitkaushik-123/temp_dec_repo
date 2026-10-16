package com.vungle.ads.internal.model;

import com.vungle.ads.internal.model.DeviceNode;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DeviceNode.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/DeviceNode.VungleExt.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/DeviceNode$VungleExt;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes7.dex */
public final class DeviceNode$VungleExt$$serializer implements GeneratedSerializer<DeviceNode.VungleExt> {
    public static final DeviceNode$VungleExt$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DeviceNode$VungleExt$$serializer deviceNode$VungleExt$$serializer = new DeviceNode$VungleExt$$serializer();
        INSTANCE = deviceNode$VungleExt$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.DeviceNode.VungleExt", deviceNode$VungleExt$$serializer, 22);
        pluginGeneratedSerialDescriptor.addElement("is_google_play_services_available", true);
        pluginGeneratedSerialDescriptor.addElement("app_set_id", true);
        pluginGeneratedSerialDescriptor.addElement("app_set_id_scope", true);
        pluginGeneratedSerialDescriptor.addElement("battery_level", true);
        pluginGeneratedSerialDescriptor.addElement("battery_state", true);
        pluginGeneratedSerialDescriptor.addElement("battery_saver_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("connection_type", true);
        pluginGeneratedSerialDescriptor.addElement("connection_type_detail", true);
        pluginGeneratedSerialDescriptor.addElement("locale", true);
        pluginGeneratedSerialDescriptor.addElement("language", true);
        pluginGeneratedSerialDescriptor.addElement("time_zone", true);
        pluginGeneratedSerialDescriptor.addElement("volume_level", true);
        pluginGeneratedSerialDescriptor.addElement("sound_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("is_tv", true);
        pluginGeneratedSerialDescriptor.addElement("sd_card_available", true);
        pluginGeneratedSerialDescriptor.addElement("is_sideload_enabled", true);
        pluginGeneratedSerialDescriptor.addElement("gaid", true);
        pluginGeneratedSerialDescriptor.addElement("amazon_advertising_id", true);
        pluginGeneratedSerialDescriptor.addElement("sit", true);
        pluginGeneratedSerialDescriptor.addElement("oit", true);
        pluginGeneratedSerialDescriptor.addElement("ort", true);
        pluginGeneratedSerialDescriptor.addElement("obt", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeviceNode$VungleExt$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), FloatSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), FloatSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, IntSerializer.INSTANCE, BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DeviceNode.VungleExt deserialize(Decoder decoder) {
        Object obj;
        int i;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        float f;
        boolean z;
        int i2;
        float f2;
        int i3;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        boolean z2;
        int i4;
        boolean z3;
        Object obj14;
        Object obj15;
        Object obj16;
        int i5;
        int i6;
        Object obj17;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(descriptor2, 0);
            Object decodeNullableSerializableElement = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, null);
            float decodeFloatElement = beginStructure.decodeFloatElement(descriptor2, 3);
            Object decodeNullableSerializableElement2 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            int decodeIntElement = beginStructure.decodeIntElement(descriptor2, 5);
            Object decodeNullableSerializableElement3 = beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            Object decodeNullableSerializableElement4 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            obj13 = beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, null);
            obj9 = beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, null);
            obj8 = beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, null);
            float decodeFloatElement2 = beginStructure.decodeFloatElement(descriptor2, 11);
            int decodeIntElement2 = beginStructure.decodeIntElement(descriptor2, 12);
            boolean decodeBooleanElement2 = beginStructure.decodeBooleanElement(descriptor2, 13);
            int decodeIntElement3 = beginStructure.decodeIntElement(descriptor2, 14);
            boolean decodeBooleanElement3 = beginStructure.decodeBooleanElement(descriptor2, 15);
            Object decodeNullableSerializableElement5 = beginStructure.decodeNullableSerializableElement(descriptor2, 16, StringSerializer.INSTANCE, null);
            obj7 = beginStructure.decodeNullableSerializableElement(descriptor2, 17, StringSerializer.INSTANCE, null);
            obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, 18, LongSerializer.INSTANCE, null);
            Object decodeNullableSerializableElement6 = beginStructure.decodeNullableSerializableElement(descriptor2, 19, LongSerializer.INSTANCE, null);
            Object decodeNullableSerializableElement7 = beginStructure.decodeNullableSerializableElement(descriptor2, 20, LongSerializer.INSTANCE, null);
            obj = beginStructure.decodeNullableSerializableElement(descriptor2, 21, LongSerializer.INSTANCE, null);
            obj12 = decodeNullableSerializableElement5;
            z3 = decodeBooleanElement2;
            f2 = decodeFloatElement2;
            z = decodeBooleanElement;
            i = 4194303;
            obj10 = decodeNullableSerializableElement;
            obj2 = decodeNullableSerializableElement3;
            z2 = decodeBooleanElement3;
            obj5 = decodeNullableSerializableElement6;
            obj3 = decodeNullableSerializableElement2;
            obj11 = decodeNullableSerializableElement4;
            i3 = decodeIntElement2;
            i4 = decodeIntElement;
            f = decodeFloatElement;
            obj14 = decodeNullableSerializableElement7;
            i2 = decodeIntElement3;
        } else {
            int i7 = 0;
            Object obj18 = null;
            boolean z4 = false;
            int i8 = 0;
            boolean z5 = false;
            boolean z6 = false;
            int i9 = 0;
            int i10 = 0;
            boolean z7 = true;
            Object obj19 = null;
            Object obj20 = null;
            Object obj21 = null;
            Object obj22 = null;
            Object obj23 = null;
            Object obj24 = null;
            Object obj25 = null;
            Object obj26 = null;
            Object obj27 = null;
            Object obj28 = null;
            Object obj29 = null;
            Object obj30 = null;
            float f3 = 0.0f;
            float f4 = 0.0f;
            obj = null;
            while (z7) {
                Object obj31 = obj23;
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z7 = false;
                        obj22 = obj22;
                        obj23 = obj31;
                        obj18 = obj18;
                        obj30 = obj30;
                        i7 = i7;
                    case 0:
                        z6 = beginStructure.decodeBooleanElement(descriptor2, 0);
                        obj22 = obj22;
                        obj23 = obj31;
                        obj19 = obj19;
                        obj18 = obj18;
                        obj30 = obj30;
                        i7 |= 1;
                    case 1:
                        obj17 = obj18;
                        obj19 = obj19;
                        obj30 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, obj30);
                        i7 |= 2;
                        obj22 = obj22;
                        obj23 = obj31;
                        obj18 = obj17;
                    case 2:
                        obj17 = obj18;
                        obj23 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, obj31);
                        obj22 = obj22;
                        i7 |= 4;
                        obj18 = obj17;
                    case 3:
                        f3 = beginStructure.decodeFloatElement(descriptor2, 3);
                        i7 |= 8;
                        obj18 = obj18;
                        obj22 = obj22;
                        obj23 = obj31;
                    case 4:
                        obj22 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, obj22);
                        i7 |= 16;
                        obj18 = obj18;
                        obj23 = obj31;
                    case 5:
                        obj15 = obj22;
                        obj16 = obj18;
                        i8 = beginStructure.decodeIntElement(descriptor2, 5);
                        i7 |= 32;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 6:
                        obj15 = obj22;
                        obj16 = obj18;
                        obj19 = beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, obj19);
                        i7 |= 64;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 7:
                        obj15 = obj22;
                        obj16 = obj18;
                        obj20 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, obj20);
                        i7 |= 128;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 8:
                        obj15 = obj22;
                        obj16 = obj18;
                        obj29 = beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, obj29);
                        i7 |= 256;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 9:
                        obj15 = obj22;
                        obj16 = obj18;
                        obj28 = beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, obj28);
                        i7 |= 512;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 10:
                        obj15 = obj22;
                        obj16 = obj18;
                        obj27 = beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, obj27);
                        i7 |= 1024;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 11:
                        obj15 = obj22;
                        obj16 = obj18;
                        f4 = beginStructure.decodeFloatElement(descriptor2, 11);
                        i7 |= 2048;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 12:
                        obj15 = obj22;
                        obj16 = obj18;
                        i10 = beginStructure.decodeIntElement(descriptor2, 12);
                        i7 |= 4096;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 13:
                        obj15 = obj22;
                        obj16 = obj18;
                        z5 = beginStructure.decodeBooleanElement(descriptor2, 13);
                        i7 |= 8192;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 14:
                        obj15 = obj22;
                        obj16 = obj18;
                        i9 = beginStructure.decodeIntElement(descriptor2, 14);
                        i7 |= 16384;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 15:
                        obj15 = obj22;
                        obj16 = obj18;
                        z4 = beginStructure.decodeBooleanElement(descriptor2, 15);
                        i7 |= 32768;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 16:
                        obj15 = obj22;
                        obj16 = obj18;
                        obj21 = beginStructure.decodeNullableSerializableElement(descriptor2, 16, StringSerializer.INSTANCE, obj21);
                        i5 = 65536;
                        i7 |= i5;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 17:
                        obj15 = obj22;
                        obj16 = obj18;
                        obj26 = beginStructure.decodeNullableSerializableElement(descriptor2, 17, StringSerializer.INSTANCE, obj26);
                        i5 = 131072;
                        i7 |= i5;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 18:
                        obj15 = obj22;
                        obj16 = obj18;
                        obj25 = beginStructure.decodeNullableSerializableElement(descriptor2, 18, LongSerializer.INSTANCE, obj25);
                        i5 = 262144;
                        i7 |= i5;
                        obj18 = obj16;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 19:
                        obj15 = obj22;
                        obj24 = beginStructure.decodeNullableSerializableElement(descriptor2, 19, LongSerializer.INSTANCE, obj24);
                        i6 = 524288;
                        i7 |= i6;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 20:
                        obj15 = obj22;
                        obj18 = beginStructure.decodeNullableSerializableElement(descriptor2, 20, LongSerializer.INSTANCE, obj18);
                        i6 = 1048576;
                        i7 |= i6;
                        obj23 = obj31;
                        obj22 = obj15;
                    case 21:
                        obj15 = obj22;
                        obj = beginStructure.decodeNullableSerializableElement(descriptor2, 21, LongSerializer.INSTANCE, obj);
                        i6 = 2097152;
                        i7 |= i6;
                        obj23 = obj31;
                        obj22 = obj15;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i7;
            Object obj32 = obj18;
            Object obj33 = obj30;
            obj2 = obj19;
            Object obj34 = obj23;
            obj3 = obj22;
            obj4 = obj34;
            obj5 = obj24;
            obj6 = obj25;
            obj7 = obj26;
            obj8 = obj27;
            obj9 = obj28;
            f = f3;
            z = z6;
            i2 = i9;
            f2 = f4;
            i3 = i10;
            obj10 = obj33;
            obj11 = obj20;
            obj12 = obj21;
            obj13 = obj29;
            z2 = z4;
            i4 = i8;
            z3 = z5;
            obj14 = obj32;
        }
        beginStructure.endStructure(descriptor2);
        return new DeviceNode.VungleExt(i, z, (String) obj10, (Integer) obj4, f, (String) obj3, i4, (String) obj2, (String) obj11, (String) obj13, (String) obj9, (String) obj8, f2, i3, z3, i2, z2, (String) obj12, (String) obj7, (Long) obj6, (Long) obj5, (Long) obj14, (Long) obj, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DeviceNode.VungleExt value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        DeviceNode.VungleExt.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
