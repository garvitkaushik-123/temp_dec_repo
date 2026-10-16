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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MetaDataApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp.Gdpr.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataResp$Gdpr;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class MetaDataResp$Gdpr$$serializer implements GeneratedSerializer<MetaDataResp.Gdpr> {
    public static final MetaDataResp$Gdpr$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        MetaDataResp$Gdpr$$serializer metaDataResp$Gdpr$$serializer = new MetaDataResp$Gdpr$$serializer();
        INSTANCE = metaDataResp$Gdpr$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataResp.Gdpr", metaDataResp$Gdpr$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("additionsChangeDate", false);
        pluginGeneratedSerialDescriptor.addElement("applies", false);
        pluginGeneratedSerialDescriptor.addElement("getMessageAlways", false);
        pluginGeneratedSerialDescriptor.addElement("_id", false);
        pluginGeneratedSerialDescriptor.addElement("legalBasisChangeDate", false);
        pluginGeneratedSerialDescriptor.addElement("version", false);
        pluginGeneratedSerialDescriptor.addElement("sampleRate", false);
        pluginGeneratedSerialDescriptor.addElement("childPmId", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MetaDataResp$Gdpr$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(DoubleSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public MetaDataResp.Gdpr deserialize(Decoder decoder) {
        Double d;
        String str;
        Boolean bool;
        String str2;
        Integer num;
        Boolean bool2;
        String str3;
        String str4;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 7;
        String str5 = null;
        if (beginStructure.decodeSequentially()) {
            String str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            Boolean bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            Boolean bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, null);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            Integer num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, null);
            Double d2 = (Double) beginStructure.decodeNullableSerializableElement(descriptor2, 6, DoubleSerializer.INSTANCE, null);
            str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            d = d2;
            num = num2;
            str3 = str7;
            str2 = str8;
            bool = bool4;
            i = 255;
            bool2 = bool3;
            str = str6;
        } else {
            boolean z = true;
            int i3 = 0;
            String str9 = null;
            Double d3 = null;
            Integer num3 = null;
            Boolean bool5 = null;
            Boolean bool6 = null;
            String str10 = null;
            String str11 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                    case 0:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str5);
                        i3 |= 1;
                        i2 = 7;
                    case 1:
                        bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool5);
                        i3 |= 2;
                        i2 = 7;
                    case 2:
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, bool6);
                        i3 |= 4;
                        i2 = 7;
                    case 3:
                        str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str10);
                        i3 |= 8;
                        i2 = 7;
                    case 4:
                        str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str11);
                        i3 |= 16;
                    case 5:
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 5, IntSerializer.INSTANCE, num3);
                        i3 |= 32;
                    case 6:
                        d3 = (Double) beginStructure.decodeNullableSerializableElement(descriptor2, 6, DoubleSerializer.INSTANCE, d3);
                        i3 |= 64;
                    case 7:
                        str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, i2, StringSerializer.INSTANCE, str9);
                        i3 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str12 = str11;
            d = d3;
            str = str5;
            bool = bool6;
            str2 = str12;
            String str13 = str10;
            num = num3;
            bool2 = bool5;
            str3 = str13;
            str4 = str9;
            i = i3;
        }
        beginStructure.endStructure(descriptor2);
        return new MetaDataResp.Gdpr(i, str, bool2, bool, str3, str2, num, d, str4, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, MetaDataResp.Gdpr value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        MetaDataResp.Gdpr.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
