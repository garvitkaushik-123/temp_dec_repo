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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg.UsNatArg.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg$UsNatArg;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class MetaDataArg$UsNatArg$$serializer implements GeneratedSerializer<MetaDataArg.UsNatArg> {
    public static final MetaDataArg$UsNatArg$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        MetaDataArg$UsNatArg$$serializer metaDataArg$UsNatArg$$serializer = new MetaDataArg$UsNatArg$$serializer();
        INSTANCE = metaDataArg$UsNatArg$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg.UsNatArg", metaDataArg$UsNatArg$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("applies", false);
        pluginGeneratedSerialDescriptor.addElement("hasLocalData", true);
        pluginGeneratedSerialDescriptor.addElement("groupPmId", true);
        pluginGeneratedSerialDescriptor.addElement("targetingParams", true);
        pluginGeneratedSerialDescriptor.addElement("uuid", true);
        pluginGeneratedSerialDescriptor.addElement("dateCreated", true);
        pluginGeneratedSerialDescriptor.addElement("transitionCCPAAuth", true);
        pluginGeneratedSerialDescriptor.addElement("optedOut", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MetaDataArg$UsNatArg$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public MetaDataArg.UsNatArg deserialize(Decoder decoder) {
        Boolean bool;
        Boolean bool2;
        String str;
        String str2;
        String str3;
        Boolean bool3;
        JsonElement jsonElement;
        Boolean bool4;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 7;
        Boolean bool5 = null;
        if (beginStructure.decodeSequentially()) {
            Boolean bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Boolean bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            String str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            JsonElement jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 3, JsonElementSerializer.INSTANCE, null);
            String str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            String str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            Boolean bool8 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 6, BooleanSerializer.INSTANCE, null);
            bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 7, BooleanSerializer.INSTANCE, null);
            bool = bool8;
            str3 = str6;
            jsonElement = jsonElement2;
            str2 = str5;
            str = str4;
            i = 255;
            bool3 = bool7;
            bool2 = bool6;
        } else {
            boolean z = true;
            int i3 = 0;
            Boolean bool9 = null;
            Boolean bool10 = null;
            String str7 = null;
            Boolean bool11 = null;
            String str8 = null;
            JsonElement jsonElement3 = null;
            String str9 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                    case 0:
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool5);
                        i3 |= 1;
                        i2 = 7;
                    case 1:
                        bool11 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool11);
                        i3 |= 2;
                        i2 = 7;
                    case 2:
                        str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str8);
                        i3 |= 4;
                        i2 = 7;
                    case 3:
                        jsonElement3 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 3, JsonElementSerializer.INSTANCE, jsonElement3);
                        i3 |= 8;
                        i2 = 7;
                    case 4:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str9);
                        i3 |= 16;
                    case 5:
                        str7 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str7);
                        i3 |= 32;
                    case 6:
                        bool10 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 6, BooleanSerializer.INSTANCE, bool10);
                        i3 |= 64;
                    case 7:
                        bool9 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, i2, BooleanSerializer.INSTANCE, bool9);
                        i3 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str10 = str9;
            bool = bool10;
            bool2 = bool5;
            str = str8;
            str2 = str10;
            JsonElement jsonElement4 = jsonElement3;
            str3 = str7;
            bool3 = bool11;
            jsonElement = jsonElement4;
            bool4 = bool9;
            i = i3;
        }
        beginStructure.endStructure(descriptor2);
        return new MetaDataArg.UsNatArg(i, bool2, bool3, str, jsonElement, str2, str3, bool, bool4, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, MetaDataArg.UsNatArg value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        MetaDataArg.UsNatArg.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
