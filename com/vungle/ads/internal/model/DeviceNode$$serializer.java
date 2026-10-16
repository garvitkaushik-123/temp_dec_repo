package com.vungle.ads.internal.model;

import com.ironsource.N6;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: DeviceNode.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/DeviceNode.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/DeviceNode;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes7.dex */
public final class DeviceNode$$serializer implements GeneratedSerializer<DeviceNode> {
    public static final DeviceNode$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        DeviceNode$$serializer deviceNode$$serializer = new DeviceNode$$serializer();
        INSTANCE = deviceNode$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.DeviceNode", deviceNode$$serializer, 11);
        pluginGeneratedSerialDescriptor.addElement(N6.t, false);
        pluginGeneratedSerialDescriptor.addElement(N6.B, false);
        pluginGeneratedSerialDescriptor.addElement("osv", false);
        pluginGeneratedSerialDescriptor.addElement(N6.P0, true);
        pluginGeneratedSerialDescriptor.addElement(N6.F, false);
        pluginGeneratedSerialDescriptor.addElement("w", false);
        pluginGeneratedSerialDescriptor.addElement("h", false);
        pluginGeneratedSerialDescriptor.addElement(N6.d0, true);
        pluginGeneratedSerialDescriptor.addElement("ifa", true);
        pluginGeneratedSerialDescriptor.addElement("lmt", true);
        pluginGeneratedSerialDescriptor.addElement("ext", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private DeviceNode$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE, StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DeviceNode$VungleExt$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public DeviceNode deserialize(Decoder decoder) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        int i;
        String str;
        String str2;
        String str3;
        int i2;
        int i3;
        String str4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i4 = 10;
        int i5 = 9;
        if (beginStructure.decodeSequentially()) {
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 0);
            String decodeStringElement2 = beginStructure.decodeStringElement(descriptor2, 1);
            String decodeStringElement3 = beginStructure.decodeStringElement(descriptor2, 2);
            obj5 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            String decodeStringElement4 = beginStructure.decodeStringElement(descriptor2, 4);
            int decodeIntElement = beginStructure.decodeIntElement(descriptor2, 5);
            int decodeIntElement2 = beginStructure.decodeIntElement(descriptor2, 6);
            obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, null);
            obj = beginStructure.decodeNullableSerializableElement(descriptor2, 9, IntSerializer.INSTANCE, null);
            obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 10, DeviceNode$VungleExt$$serializer.INSTANCE, null);
            i = 2047;
            str3 = decodeStringElement3;
            str2 = decodeStringElement2;
            i2 = decodeIntElement2;
            i3 = decodeIntElement;
            str4 = decodeStringElement4;
            str = decodeStringElement;
        } else {
            boolean z = true;
            int i6 = 0;
            int i7 = 0;
            Object obj6 = null;
            Object obj7 = null;
            Object obj8 = null;
            Object obj9 = null;
            String str5 = null;
            String str6 = null;
            String str7 = null;
            String str8 = null;
            int i8 = 0;
            Object obj10 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i4 = 10;
                    case 0:
                        str5 = beginStructure.decodeStringElement(descriptor2, 0);
                        i7 |= 1;
                        i4 = 10;
                        i5 = 9;
                    case 1:
                        str6 = beginStructure.decodeStringElement(descriptor2, 1);
                        i7 |= 2;
                        i4 = 10;
                        i5 = 9;
                    case 2:
                        str7 = beginStructure.decodeStringElement(descriptor2, 2);
                        i7 |= 4;
                        i4 = 10;
                        i5 = 9;
                    case 3:
                        obj10 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, obj10);
                        i7 |= 8;
                        i4 = 10;
                        i5 = 9;
                    case 4:
                        str8 = beginStructure.decodeStringElement(descriptor2, 4);
                        i7 |= 16;
                        i4 = 10;
                    case 5:
                        i8 = beginStructure.decodeIntElement(descriptor2, 5);
                        i7 |= 32;
                    case 6:
                        i6 = beginStructure.decodeIntElement(descriptor2, 6);
                        i7 |= 64;
                    case 7:
                        obj9 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, obj9);
                        i7 |= 128;
                    case 8:
                        obj8 = beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, obj8);
                        i7 |= 256;
                    case 9:
                        obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, i5, IntSerializer.INSTANCE, obj6);
                        i7 |= 512;
                    case 10:
                        obj7 = beginStructure.decodeNullableSerializableElement(descriptor2, i4, DeviceNode$VungleExt$$serializer.INSTANCE, obj7);
                        i7 |= 1024;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            obj = obj6;
            obj2 = obj7;
            obj3 = obj8;
            obj4 = obj9;
            obj5 = obj10;
            i = i7;
            str = str5;
            str2 = str6;
            str3 = str7;
            i2 = i6;
            i3 = i8;
            str4 = str8;
        }
        beginStructure.endStructure(descriptor2);
        return new DeviceNode(i, str, str2, str3, (String) obj5, str4, i3, i2, (String) obj4, (String) obj3, (Integer) obj, (DeviceNode.VungleExt) obj2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, DeviceNode value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        DeviceNode.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
