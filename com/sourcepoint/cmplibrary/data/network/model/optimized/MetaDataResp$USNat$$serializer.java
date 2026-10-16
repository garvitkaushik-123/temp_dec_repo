package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp;
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
import kotlinx.serialization.internal.DoubleSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: MetaDataApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp.USNat.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$USNat;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class MetaDataResp$USNat$$serializer implements GeneratedSerializer<MetaDataResp.USNat> {
    public static final MetaDataResp$USNat$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        MetaDataResp$USNat$$serializer metaDataResp$USNat$$serializer = new MetaDataResp$USNat$$serializer();
        INSTANCE = metaDataResp$USNat$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp.USNat", metaDataResp$USNat$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("_id", true);
        pluginGeneratedSerialDescriptor.addElement("additionsChangeDate", true);
        pluginGeneratedSerialDescriptor.addElement("applies", true);
        pluginGeneratedSerialDescriptor.addElement("sampleRate", true);
        pluginGeneratedSerialDescriptor.addElement("applicableSections", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MetaDataResp$USNat$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public MetaDataResp.USNat deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        Boolean bool;
        Double d;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        String str3 = null;
        if (beginStructure.decodeSequentially()) {
            String str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            String str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            Boolean bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, null);
            str = str4;
            d = (Double) beginStructure.decodeNullableSerializableElement(descriptor2, 3, DoubleSerializer.INSTANCE, null);
            jsonElement = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 4, JsonElementSerializer.INSTANCE, null);
            bool = bool2;
            str2 = str5;
            i = 31;
        } else {
            boolean z = true;
            int i2 = 0;
            String str6 = null;
            Boolean bool3 = null;
            Double d2 = null;
            JsonElement jsonElement2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str3);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str6);
                    i2 |= 2;
                } else if (decodeElementIndex == 2) {
                    bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, bool3);
                    i2 |= 4;
                } else if (decodeElementIndex == 3) {
                    d2 = (Double) beginStructure.decodeNullableSerializableElement(descriptor2, 3, DoubleSerializer.INSTANCE, d2);
                    i2 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 4, JsonElementSerializer.INSTANCE, jsonElement2);
                    i2 |= 16;
                }
            }
            i = i2;
            str = str3;
            str2 = str6;
            bool = bool3;
            d = d2;
            jsonElement = jsonElement2;
        }
        beginStructure.endStructure(descriptor2);
        return new MetaDataResp.USNat(i, str, str2, bool, d, jsonElement, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, MetaDataResp.USNat value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        MetaDataResp.USNat.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
