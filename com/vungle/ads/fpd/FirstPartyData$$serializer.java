package com.vungle.ads.fpd;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: FirstPartyData.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/fpd/FirstPartyData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/fpd/FirstPartyData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes7.dex */
public final class FirstPartyData$$serializer implements GeneratedSerializer<FirstPartyData> {
    public static final FirstPartyData$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FirstPartyData$$serializer firstPartyData$$serializer = new FirstPartyData$$serializer();
        INSTANCE = firstPartyData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.FirstPartyData", firstPartyData$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("session_context", true);
        pluginGeneratedSerialDescriptor.addElement("demographic", true);
        pluginGeneratedSerialDescriptor.addElement(FirebaseAnalytics.Param.LOCATION, true);
        pluginGeneratedSerialDescriptor.addElement("revenue", true);
        pluginGeneratedSerialDescriptor.addElement("custom_data", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FirstPartyData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(SessionContext$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Demographic$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Location$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(Revenue$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE))};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public FirstPartyData deserialize(Decoder decoder) {
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        boolean z = false;
        Object obj6 = null;
        if (beginStructure.decodeSequentially()) {
            obj = beginStructure.decodeNullableSerializableElement(descriptor2, 0, SessionContext$$serializer.INSTANCE, null);
            obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, Demographic$$serializer.INSTANCE, null);
            obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, Location$$serializer.INSTANCE, null);
            obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, Revenue$$serializer.INSTANCE, null);
            obj5 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), null);
            i = 31;
        } else {
            boolean z2 = true;
            int i2 = 0;
            Object obj7 = null;
            Object obj8 = null;
            Object obj9 = null;
            Object obj10 = null;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z2 = z;
                } else if (decodeElementIndex != 0) {
                    if (decodeElementIndex == 1) {
                        obj7 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, Demographic$$serializer.INSTANCE, obj7);
                        i2 |= 2;
                    } else if (decodeElementIndex == 2) {
                        obj8 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, Location$$serializer.INSTANCE, obj8);
                        i2 |= 4;
                    } else if (decodeElementIndex == 3) {
                        obj9 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, Revenue$$serializer.INSTANCE, obj9);
                        i2 |= 8;
                    } else {
                        if (decodeElementIndex != 4) {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                        obj10 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), obj10);
                        i2 |= 16;
                    }
                    z = false;
                } else {
                    obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, 0, SessionContext$$serializer.INSTANCE, obj6);
                    i2 |= 1;
                    z = false;
                }
            }
            Object obj11 = obj6;
            i = i2;
            obj = obj11;
            obj2 = obj7;
            obj3 = obj8;
            obj4 = obj9;
            obj5 = obj10;
        }
        beginStructure.endStructure(descriptor2);
        return new FirstPartyData(i, (SessionContext) obj, (Demographic) obj2, (Location) obj3, (Revenue) obj4, (Map) obj5, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, FirstPartyData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        FirstPartyData.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
