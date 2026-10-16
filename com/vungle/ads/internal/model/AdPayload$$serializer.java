package com.vungle.ads.internal.model;

import com.mbridge.msdk.foundation.entity.b;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.ContextualSerializer;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: AdPayload.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/AdPayload.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/AdPayload;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes7.dex */
public final class AdPayload$$serializer implements GeneratedSerializer<AdPayload> {
    public static final AdPayload$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        AdPayload$$serializer adPayload$$serializer = new AdPayload$$serializer();
        INSTANCE = adPayload$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.AdPayload", adPayload$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement(b.JSON_KEY_ADS, true);
        pluginGeneratedSerialDescriptor.addElement("config", true);
        pluginGeneratedSerialDescriptor.addElement("mraidFiles", true);
        pluginGeneratedSerialDescriptor.addElement("incentivizedTextSettings", true);
        pluginGeneratedSerialDescriptor.addElement("assetsFullyDownloaded", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private AdPayload$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(new ArrayListSerializer(AdPayload$PlacementAdUnit$$serializer.INSTANCE)), BuiltinSerializersKt.getNullable(ConfigPayload$$serializer.INSTANCE), new ContextualSerializer(Reflection.getOrCreateKotlinClass(ConcurrentHashMap.class), null, new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE}), new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public AdPayload deserialize(Decoder decoder) {
        boolean z;
        Object obj;
        Object obj2;
        Object obj3;
        int i;
        Object obj4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 4;
        int i3 = 0;
        if (beginStructure.decodeSequentially()) {
            obj = beginStructure.decodeNullableSerializableElement(descriptor2, 0, new ArrayListSerializer(AdPayload$PlacementAdUnit$$serializer.INSTANCE), null);
            obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, ConfigPayload$$serializer.INSTANCE, null);
            obj3 = beginStructure.decodeSerializableElement(descriptor2, 2, new ContextualSerializer(Reflection.getOrCreateKotlinClass(ConcurrentHashMap.class), null, new KSerializer[]{StringSerializer.INSTANCE, StringSerializer.INSTANCE}), null);
            obj2 = beginStructure.decodeSerializableElement(descriptor2, 3, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), null);
            i = 31;
            z = beginStructure.decodeBooleanElement(descriptor2, 4);
        } else {
            int i4 = 1;
            z = false;
            int i5 = 0;
            obj = null;
            Object obj5 = null;
            Object obj6 = null;
            Object obj7 = null;
            while (i4 != 0) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                int i6 = i3;
                if (decodeElementIndex != -1) {
                    if (decodeElementIndex != 0) {
                        if (decodeElementIndex == 1) {
                            obj7 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, ConfigPayload$$serializer.INSTANCE, obj7);
                            i5 |= 2;
                        } else if (decodeElementIndex == 2) {
                            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ConcurrentHashMap.class);
                            KSerializer[] kSerializerArr = new KSerializer[2];
                            kSerializerArr[i6] = StringSerializer.INSTANCE;
                            kSerializerArr[1] = StringSerializer.INSTANCE;
                            obj6 = beginStructure.decodeSerializableElement(descriptor2, 2, new ContextualSerializer(orCreateKotlinClass, null, kSerializerArr), obj6);
                            i5 |= 4;
                        } else if (decodeElementIndex == 3) {
                            obj5 = beginStructure.decodeSerializableElement(descriptor2, 3, new LinkedHashMapSerializer(StringSerializer.INSTANCE, StringSerializer.INSTANCE), obj5);
                            i5 |= 8;
                        } else {
                            if (decodeElementIndex != i2) {
                                throw new UnknownFieldException(decodeElementIndex);
                            }
                            z = beginStructure.decodeBooleanElement(descriptor2, i2);
                            i5 |= 16;
                            i3 = i6;
                        }
                        i3 = i6;
                    } else {
                        i3 = i6;
                        obj = beginStructure.decodeNullableSerializableElement(descriptor2, i3, new ArrayListSerializer(AdPayload$PlacementAdUnit$$serializer.INSTANCE), obj);
                        i5 |= 1;
                    }
                    i2 = 4;
                } else {
                    i3 = i6;
                    i4 = i3;
                }
            }
            obj2 = obj5;
            obj3 = obj6;
            i = i5;
            obj4 = obj7;
        }
        beginStructure.endStructure(descriptor2);
        return new AdPayload(i, (List) obj, (ConfigPayload) obj4, (ConcurrentHashMap) obj3, (Map) obj2, z, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, AdPayload value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        AdPayload.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
