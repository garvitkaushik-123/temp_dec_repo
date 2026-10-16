package com.sourcepoint.cmplibrary.data.network.model.optimized.choice;

import com.ironsource.D5;
import com.ironsource.adapters.inmobi.InMobiAdapter;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg$$serializer;
import com.sourcepoint.cmplibrary.data.network.util.Env;
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
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: GetChoiceParamReq.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/choice/GetChoiceParamReq.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/choice/GetChoiceParamReq;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class GetChoiceParamReq$$serializer implements GeneratedSerializer<GetChoiceParamReq> {
    public static final GetChoiceParamReq$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GetChoiceParamReq$$serializer getChoiceParamReq$$serializer = new GetChoiceParamReq$$serializer();
        INSTANCE = getChoiceParamReq$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.choice.GetChoiceParamReq", getChoiceParamReq$$serializer, 9);
        pluginGeneratedSerialDescriptor.addElement(D5.o, false);
        pluginGeneratedSerialDescriptor.addElement("choiceType", false);
        pluginGeneratedSerialDescriptor.addElement("metadataArg", false);
        pluginGeneratedSerialDescriptor.addElement("propertyId", false);
        pluginGeneratedSerialDescriptor.addElement(InMobiAdapter.ACCOUNT_ID, false);
        pluginGeneratedSerialDescriptor.addElement("includeData", false);
        pluginGeneratedSerialDescriptor.addElement("hasCsp", true);
        pluginGeneratedSerialDescriptor.addElement("includeCustomVendorsRes", true);
        pluginGeneratedSerialDescriptor.addElement("withSiteActions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GetChoiceParamReq$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = GetChoiceParamReq.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], kSerializerArr[1], BuiltinSerializersKt.getNullable(MetaDataArg$$serializer.INSTANCE), LongSerializer.INSTANCE, LongSerializer.INSTANCE, JsonObjectSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE, BooleanSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public GetChoiceParamReq deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        MetaDataArg metaDataArg;
        ChoiceTypeParam choiceTypeParam;
        boolean z;
        boolean z2;
        boolean z3;
        int i;
        long j;
        long j2;
        JsonObject jsonObject;
        Env env;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = GetChoiceParamReq.$childSerializers;
        int i2 = 7;
        int i3 = 6;
        int i4 = 5;
        if (beginStructure.decodeSequentially()) {
            Env env2 = (Env) beginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            ChoiceTypeParam choiceTypeParam2 = (ChoiceTypeParam) beginStructure.decodeSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            MetaDataArg metaDataArg2 = (MetaDataArg) beginStructure.decodeNullableSerializableElement(descriptor2, 2, MetaDataArg$$serializer.INSTANCE, null);
            long decodeLongElement = beginStructure.decodeLongElement(descriptor2, 3);
            long decodeLongElement2 = beginStructure.decodeLongElement(descriptor2, 4);
            JsonObject jsonObject2 = (JsonObject) beginStructure.decodeSerializableElement(descriptor2, 5, JsonObjectSerializer.INSTANCE, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(descriptor2, 6);
            z = beginStructure.decodeBooleanElement(descriptor2, 7);
            z2 = decodeBooleanElement;
            jsonObject = jsonObject2;
            z3 = beginStructure.decodeBooleanElement(descriptor2, 8);
            i = 511;
            j2 = decodeLongElement2;
            j = decodeLongElement;
            choiceTypeParam = choiceTypeParam2;
            metaDataArg = metaDataArg2;
            env = env2;
        } else {
            int i5 = 1;
            boolean z4 = true;
            boolean z5 = false;
            JsonObject jsonObject3 = null;
            MetaDataArg metaDataArg3 = null;
            Env env3 = null;
            long j3 = 0;
            long j4 = 0;
            boolean z6 = false;
            boolean z7 = false;
            int i6 = 0;
            ChoiceTypeParam choiceTypeParam3 = null;
            while (z4) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z4 = false;
                        i3 = 6;
                        i4 = 5;
                        i5 = 1;
                    case 0:
                        env3 = (Env) beginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], env3);
                        i6 |= 1;
                        i2 = 7;
                        i3 = 6;
                        i4 = 5;
                        i5 = 1;
                    case 1:
                        choiceTypeParam3 = (ChoiceTypeParam) beginStructure.decodeSerializableElement(descriptor2, i5, kSerializerArr[i5], choiceTypeParam3);
                        i6 |= 2;
                        i2 = 7;
                        i3 = 6;
                    case 2:
                        metaDataArg3 = (MetaDataArg) beginStructure.decodeNullableSerializableElement(descriptor2, 2, MetaDataArg$$serializer.INSTANCE, metaDataArg3);
                        i6 |= 4;
                        i2 = 7;
                        i3 = 6;
                    case 3:
                        j3 = beginStructure.decodeLongElement(descriptor2, 3);
                        i6 |= 8;
                    case 4:
                        j4 = beginStructure.decodeLongElement(descriptor2, 4);
                        i6 |= 16;
                    case 5:
                        jsonObject3 = (JsonObject) beginStructure.decodeSerializableElement(descriptor2, i4, JsonObjectSerializer.INSTANCE, jsonObject3);
                        i6 |= 32;
                    case 6:
                        z6 = beginStructure.decodeBooleanElement(descriptor2, i3);
                        i6 |= 64;
                    case 7:
                        z5 = beginStructure.decodeBooleanElement(descriptor2, i2);
                        i6 |= 128;
                    case 8:
                        z7 = beginStructure.decodeBooleanElement(descriptor2, 8);
                        i6 |= 256;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            Env env4 = env3;
            ChoiceTypeParam choiceTypeParam4 = choiceTypeParam3;
            metaDataArg = metaDataArg3;
            choiceTypeParam = choiceTypeParam4;
            z = z5;
            z2 = z6;
            z3 = z7;
            i = i6;
            j = j3;
            j2 = j4;
            jsonObject = jsonObject3;
            env = env4;
        }
        beginStructure.endStructure(descriptor2);
        return new GetChoiceParamReq(i, env, choiceTypeParam, metaDataArg, j, j2, jsonObject, z2, z, z3, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GetChoiceParamReq value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        GetChoiceParamReq.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
