package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: MetaDataApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg.CcpaArg.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$CcpaArg;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class MetaDataArg$CcpaArg$$serializer implements GeneratedSerializer<MetaDataArg.CcpaArg> {
    public static final MetaDataArg$CcpaArg$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        MetaDataArg$CcpaArg$$serializer metaDataArg$CcpaArg$$serializer = new MetaDataArg$CcpaArg$$serializer();
        INSTANCE = metaDataArg$CcpaArg$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg.CcpaArg", metaDataArg$CcpaArg$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("applies", false);
        pluginGeneratedSerialDescriptor.addElement("hasLocalData", true);
        pluginGeneratedSerialDescriptor.addElement("groupPmId", true);
        pluginGeneratedSerialDescriptor.addElement("targetingParams", true);
        pluginGeneratedSerialDescriptor.addElement("uuid", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MetaDataArg$CcpaArg$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public MetaDataArg.CcpaArg deserialize(Decoder decoder) {
        int i;
        Boolean bool;
        Boolean bool2;
        String str;
        JsonElement jsonElement;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        Boolean bool3 = null;
        if (beginStructure.decodeSequentially()) {
            Boolean bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Boolean bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            String str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            bool = bool4;
            jsonElement = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 3, JsonElementSerializer.INSTANCE, null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            str = str3;
            bool2 = bool5;
            i = 31;
        } else {
            boolean z = true;
            int i2 = 0;
            Boolean bool6 = null;
            String str4 = null;
            JsonElement jsonElement2 = null;
            String str5 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool3);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool6);
                    i2 |= 2;
                } else if (decodeElementIndex == 2) {
                    str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str4);
                    i2 |= 4;
                } else if (decodeElementIndex == 3) {
                    jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 3, JsonElementSerializer.INSTANCE, jsonElement2);
                    i2 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str5);
                    i2 |= 16;
                }
            }
            i = i2;
            bool = bool3;
            bool2 = bool6;
            str = str4;
            jsonElement = jsonElement2;
            str2 = str5;
        }
        beginStructure.endStructure(descriptor2);
        return new MetaDataArg.CcpaArg(i, bool, bool2, str, jsonElement, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, MetaDataArg.CcpaArg value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        MetaDataArg.CcpaArg.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
