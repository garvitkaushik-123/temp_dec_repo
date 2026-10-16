package com.vungle.ads.fpd;

import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: Revenue.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/fpd/Revenue.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/fpd/Revenue;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes7.dex */
public final class Revenue$$serializer implements GeneratedSerializer<Revenue> {
    public static final Revenue$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        Revenue$$serializer revenue$$serializer = new Revenue$$serializer();
        INSTANCE = revenue$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.Revenue", revenue$$serializer, 17);
        pluginGeneratedSerialDescriptor.addElement("total_earnings_usd", true);
        pluginGeneratedSerialDescriptor.addElement("earnings_by_placement_usd", true);
        pluginGeneratedSerialDescriptor.addElement("top_n_adomain", true);
        pluginGeneratedSerialDescriptor.addElement("is_user_a_purchaser", true);
        pluginGeneratedSerialDescriptor.addElement("is_user_a_subscriber", true);
        pluginGeneratedSerialDescriptor.addElement("last_7_days_total_spend_usd", true);
        pluginGeneratedSerialDescriptor.addElement("last_7_days_median_spend_usd", true);
        pluginGeneratedSerialDescriptor.addElement("last_7_days_mean_spend_usd", true);
        pluginGeneratedSerialDescriptor.addElement("last_30_days_total_spend_usd", true);
        pluginGeneratedSerialDescriptor.addElement("last_30_days_median_spend_usd", true);
        pluginGeneratedSerialDescriptor.addElement("last_30_days_mean_spend_usd", true);
        pluginGeneratedSerialDescriptor.addElement("last_7_days_user_pltv_usd", true);
        pluginGeneratedSerialDescriptor.addElement("last_7_days_user_ltv_usd", true);
        pluginGeneratedSerialDescriptor.addElement("last_30_days_user_pltv_usd", true);
        pluginGeneratedSerialDescriptor.addElement("last_30_days_user_ltv_usd", true);
        pluginGeneratedSerialDescriptor.addElement("last_7_days_placement_fill_rate", true);
        pluginGeneratedSerialDescriptor.addElement("last_30_days_placement_fill_rate", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Revenue$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE)), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Revenue deserialize(Decoder decoder) {
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
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Object obj14;
        Object obj15;
        Object obj16;
        Object obj17;
        Object obj18;
        Object obj19;
        Object obj20;
        Object obj21;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            Object decodeNullableSerializableElement = beginStructure.decodeNullableSerializableElement(descriptor2, 0, FloatSerializer.INSTANCE, null);
            Object decodeNullableSerializableElement2 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, FloatSerializer.INSTANCE, null);
            Object decodeNullableSerializableElement3 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, new ArrayListSerializer(StringSerializer.INSTANCE), null);
            Object decodeNullableSerializableElement4 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, null);
            obj10 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, null);
            obj14 = beginStructure.decodeNullableSerializableElement(descriptor2, 5, FloatSerializer.INSTANCE, null);
            obj13 = beginStructure.decodeNullableSerializableElement(descriptor2, 6, FloatSerializer.INSTANCE, null);
            obj12 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, FloatSerializer.INSTANCE, null);
            obj11 = beginStructure.decodeNullableSerializableElement(descriptor2, 8, FloatSerializer.INSTANCE, null);
            obj17 = beginStructure.decodeNullableSerializableElement(descriptor2, 9, FloatSerializer.INSTANCE, null);
            obj16 = beginStructure.decodeNullableSerializableElement(descriptor2, 10, FloatSerializer.INSTANCE, null);
            obj15 = beginStructure.decodeNullableSerializableElement(descriptor2, 11, FloatSerializer.INSTANCE, null);
            obj9 = beginStructure.decodeNullableSerializableElement(descriptor2, 12, FloatSerializer.INSTANCE, null);
            obj7 = beginStructure.decodeNullableSerializableElement(descriptor2, 13, FloatSerializer.INSTANCE, null);
            obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, 14, FloatSerializer.INSTANCE, null);
            Object decodeNullableSerializableElement5 = beginStructure.decodeNullableSerializableElement(descriptor2, 15, FloatSerializer.INSTANCE, null);
            i = 131071;
            obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 16, FloatSerializer.INSTANCE, null);
            obj8 = decodeNullableSerializableElement4;
            obj2 = decodeNullableSerializableElement2;
            obj = decodeNullableSerializableElement3;
            obj5 = decodeNullableSerializableElement5;
            obj4 = decodeNullableSerializableElement;
        } else {
            boolean z = true;
            Object obj22 = null;
            obj = null;
            Object obj23 = null;
            Object obj24 = null;
            Object obj25 = null;
            Object obj26 = null;
            Object obj27 = null;
            Object obj28 = null;
            Object obj29 = null;
            Object obj30 = null;
            Object obj31 = null;
            Object obj32 = null;
            Object obj33 = null;
            Object obj34 = null;
            Object obj35 = null;
            Object obj36 = null;
            i = 0;
            Object obj37 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        obj18 = obj37;
                        obj19 = obj22;
                        obj20 = obj23;
                        z = false;
                        obj23 = obj20;
                        obj22 = obj19;
                        obj37 = obj18;
                    case 0:
                        obj19 = obj22;
                        obj20 = obj23;
                        obj18 = obj37;
                        obj36 = beginStructure.decodeNullableSerializableElement(descriptor2, 0, FloatSerializer.INSTANCE, obj36);
                        i |= 1;
                        obj23 = obj20;
                        obj22 = obj19;
                        obj37 = obj18;
                    case 1:
                        obj37 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, FloatSerializer.INSTANCE, obj37);
                        i |= 2;
                        obj23 = obj23;
                        obj22 = obj22;
                    case 2:
                        obj18 = obj37;
                        obj21 = obj23;
                        obj = beginStructure.decodeNullableSerializableElement(descriptor2, 2, new ArrayListSerializer(StringSerializer.INSTANCE), obj);
                        i |= 4;
                        obj23 = obj21;
                        obj37 = obj18;
                    case 3:
                        obj18 = obj37;
                        obj21 = obj23;
                        obj22 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, obj22);
                        i |= 8;
                        obj23 = obj21;
                        obj37 = obj18;
                    case 4:
                        obj18 = obj37;
                        obj21 = obj23;
                        obj29 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, obj29);
                        i |= 16;
                        obj23 = obj21;
                        obj37 = obj18;
                    case 5:
                        obj18 = obj37;
                        obj21 = obj23;
                        obj30 = beginStructure.decodeNullableSerializableElement(descriptor2, 5, FloatSerializer.INSTANCE, obj30);
                        i |= 32;
                        obj23 = obj21;
                        obj37 = obj18;
                    case 6:
                        obj18 = obj37;
                        obj21 = obj23;
                        obj28 = beginStructure.decodeNullableSerializableElement(descriptor2, 6, FloatSerializer.INSTANCE, obj28);
                        i |= 64;
                        obj23 = obj21;
                        obj37 = obj18;
                    case 7:
                        obj18 = obj37;
                        obj21 = obj23;
                        obj27 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, FloatSerializer.INSTANCE, obj27);
                        i |= 128;
                        obj23 = obj21;
                        obj37 = obj18;
                    case 8:
                        obj18 = obj37;
                        obj21 = obj23;
                        obj26 = beginStructure.decodeNullableSerializableElement(descriptor2, 8, FloatSerializer.INSTANCE, obj26);
                        i |= 256;
                        obj23 = obj21;
                        obj37 = obj18;
                    case 9:
                        obj18 = obj37;
                        obj21 = obj23;
                        obj31 = beginStructure.decodeNullableSerializableElement(descriptor2, 9, FloatSerializer.INSTANCE, obj31);
                        i |= 512;
                        obj23 = obj21;
                        obj37 = obj18;
                    case 10:
                        obj18 = obj37;
                        obj21 = obj23;
                        obj25 = beginStructure.decodeNullableSerializableElement(descriptor2, 10, FloatSerializer.INSTANCE, obj25);
                        i |= 1024;
                        obj23 = obj21;
                        obj37 = obj18;
                    case 11:
                        obj18 = obj37;
                        obj21 = obj23;
                        obj24 = beginStructure.decodeNullableSerializableElement(descriptor2, 11, FloatSerializer.INSTANCE, obj24);
                        i |= 2048;
                        obj23 = obj21;
                        obj37 = obj18;
                    case 12:
                        obj18 = obj37;
                        obj32 = beginStructure.decodeNullableSerializableElement(descriptor2, 12, FloatSerializer.INSTANCE, obj32);
                        i |= 4096;
                        obj23 = obj23;
                        obj33 = obj33;
                        obj37 = obj18;
                    case 13:
                        obj18 = obj37;
                        obj33 = beginStructure.decodeNullableSerializableElement(descriptor2, 13, FloatSerializer.INSTANCE, obj33);
                        i |= 8192;
                        obj23 = obj23;
                        obj34 = obj34;
                        obj37 = obj18;
                    case 14:
                        obj18 = obj37;
                        obj34 = beginStructure.decodeNullableSerializableElement(descriptor2, 14, FloatSerializer.INSTANCE, obj34);
                        i |= 16384;
                        obj23 = obj23;
                        obj35 = obj35;
                        obj37 = obj18;
                    case 15:
                        obj18 = obj37;
                        obj21 = obj23;
                        obj35 = beginStructure.decodeNullableSerializableElement(descriptor2, 15, FloatSerializer.INSTANCE, obj35);
                        i |= 32768;
                        obj23 = obj21;
                        obj37 = obj18;
                    case 16:
                        obj23 = beginStructure.decodeNullableSerializableElement(descriptor2, 16, FloatSerializer.INSTANCE, obj23);
                        i |= 65536;
                        obj37 = obj37;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            obj2 = obj37;
            Object obj38 = obj22;
            obj3 = obj23;
            obj4 = obj36;
            obj5 = obj35;
            obj6 = obj34;
            obj7 = obj33;
            obj8 = obj38;
            obj9 = obj32;
            obj10 = obj29;
            obj11 = obj26;
            obj12 = obj27;
            obj13 = obj28;
            obj14 = obj30;
            obj15 = obj24;
            obj16 = obj25;
            obj17 = obj31;
        }
        beginStructure.endStructure(descriptor2);
        return new Revenue(i, (Float) obj4, (Float) obj2, (List) obj, (Boolean) obj8, (Boolean) obj10, (Float) obj14, (Float) obj13, (Float) obj12, (Float) obj11, (Float) obj17, (Float) obj16, (Float) obj15, (Float) obj9, (Float) obj7, (Float) obj6, (Float) obj5, (Float) obj3, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Revenue value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Revenue.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
