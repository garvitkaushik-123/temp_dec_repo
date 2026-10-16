package com.vungle.ads.internal.network;

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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: TpatSender.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/network/FailedTpat.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/network/FailedTpat;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes7.dex */
public final class FailedTpat$$serializer implements GeneratedSerializer<FailedTpat> {
    public static final FailedTpat$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        FailedTpat$$serializer failedTpat$$serializer = new FailedTpat$$serializer();
        INSTANCE = failedTpat$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.network.FailedTpat", failedTpat$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("method", true);
        pluginGeneratedSerialDescriptor.addElement("headers", true);
        pluginGeneratedSerialDescriptor.addElement("body", true);
        pluginGeneratedSerialDescriptor.addElement("retryAttempt", true);
        pluginGeneratedSerialDescriptor.addElement("retryCount", false);
        pluginGeneratedSerialDescriptor.addElement("tpatKey", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private FailedTpat$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{HttpMethod$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE)), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), IntSerializer.INSTANCE, IntSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public FailedTpat deserialize(Decoder decoder) {
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        int i2;
        int i3;
        Object obj4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i4 = 5;
        int i5 = 3;
        if (beginStructure.decodeSequentially()) {
            obj4 = beginStructure.decodeSerializableElement(descriptor2, 0, HttpMethod$$serializer.INSTANCE, null);
            obj = beginStructure.decodeNullableSerializableElement(descriptor2, 1, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), null);
            obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            int decodeIntElement = beginStructure.decodeIntElement(descriptor2, 3);
            int decodeIntElement2 = beginStructure.decodeIntElement(descriptor2, 4);
            obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            i3 = decodeIntElement;
            i2 = decodeIntElement2;
            i = 63;
        } else {
            boolean z = true;
            int i6 = 0;
            int i7 = 0;
            Object obj5 = null;
            Object obj6 = null;
            Object obj7 = null;
            Object obj8 = null;
            int i8 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i5 = 3;
                    case 0:
                        obj5 = beginStructure.decodeSerializableElement(descriptor2, 0, HttpMethod$$serializer.INSTANCE, obj5);
                        i7 |= 1;
                        i4 = 5;
                        i5 = 3;
                    case 1:
                        obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), obj6);
                        i7 |= 2;
                        i4 = 5;
                        i5 = 3;
                    case 2:
                        obj7 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, obj7);
                        i7 |= 4;
                    case 3:
                        i6 = beginStructure.decodeIntElement(descriptor2, i5);
                        i7 |= 8;
                    case 4:
                        i8 = beginStructure.decodeIntElement(descriptor2, 4);
                        i7 |= 16;
                    case 5:
                        obj8 = beginStructure.decodeNullableSerializableElement(descriptor2, i4, StringSerializer.INSTANCE, obj8);
                        i7 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i7;
            obj = obj6;
            obj2 = obj7;
            obj3 = obj8;
            i2 = i8;
            i3 = i6;
            obj4 = obj5;
        }
        beginStructure.endStructure(descriptor2);
        return new FailedTpat(i, (HttpMethod) obj4, (Map) obj, (String) obj2, i3, i2, (String) obj3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, FailedTpat value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        FailedTpat.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
