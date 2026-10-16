package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.ironsource.D5;
import com.ironsource.adapters.inmobi.InMobiAdapter;
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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: ConsentStatusApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusParamReq.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusParamReq;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class ConsentStatusParamReq$$serializer implements GeneratedSerializer<ConsentStatusParamReq> {
    public static final ConsentStatusParamReq$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ConsentStatusParamReq$$serializer consentStatusParamReq$$serializer = new ConsentStatusParamReq$$serializer();
        INSTANCE = consentStatusParamReq$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusParamReq", consentStatusParamReq$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement(D5.o, false);
        pluginGeneratedSerialDescriptor.addElement("metadata", false);
        pluginGeneratedSerialDescriptor.addElement("propertyId", false);
        pluginGeneratedSerialDescriptor.addElement(InMobiAdapter.ACCOUNT_ID, false);
        pluginGeneratedSerialDescriptor.addElement("authId", false);
        pluginGeneratedSerialDescriptor.addElement("localState", false);
        pluginGeneratedSerialDescriptor.addElement("includeData", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConsentStatusParamReq$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = ConsentStatusParamReq.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], StringSerializer.INSTANCE, LongSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE), JsonObjectSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ConsentStatusParamReq deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        String str;
        long j;
        String str2;
        long j2;
        JsonObject jsonObject;
        JsonElement jsonElement;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = ConsentStatusParamReq.$childSerializers;
        int i2 = 6;
        int i3 = 5;
        Env env = null;
        if (beginStructure.decodeSequentially()) {
            Env env2 = (Env) beginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 1);
            long decodeLongElement = beginStructure.decodeLongElement(descriptor2, 2);
            long decodeLongElement2 = beginStructure.decodeLongElement(descriptor2, 3);
            String str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            JsonElement jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 5, JsonElementSerializer.INSTANCE, null);
            env = env2;
            jsonObject = (JsonObject) beginStructure.decodeSerializableElement(descriptor2, 6, JsonObjectSerializer.INSTANCE, null);
            jsonElement = jsonElement2;
            str = str3;
            i = 127;
            j = decodeLongElement2;
            str2 = decodeStringElement;
            j2 = decodeLongElement;
        } else {
            long j3 = 0;
            boolean z = true;
            int i4 = 0;
            JsonObject jsonObject2 = null;
            JsonElement jsonElement3 = null;
            String str4 = null;
            String str5 = null;
            long j4 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i3 = 5;
                    case 0:
                        env = (Env) beginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], env);
                        i4 |= 1;
                        i2 = 6;
                        i3 = 5;
                    case 1:
                        i4 |= 2;
                        str4 = beginStructure.decodeStringElement(descriptor2, 1);
                    case 2:
                        j3 = beginStructure.decodeLongElement(descriptor2, 2);
                        i4 |= 4;
                    case 3:
                        j4 = beginStructure.decodeLongElement(descriptor2, 3);
                        i4 |= 8;
                    case 4:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str5);
                        i4 |= 16;
                    case 5:
                        jsonElement3 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, i3, JsonElementSerializer.INSTANCE, jsonElement3);
                        i4 |= 32;
                    case 6:
                        jsonObject2 = (JsonObject) beginStructure.decodeSerializableElement(descriptor2, i2, JsonObjectSerializer.INSTANCE, jsonObject2);
                        i4 |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            long j5 = j4;
            str = str5;
            j = j5;
            long j6 = j3;
            str2 = str4;
            j2 = j6;
            jsonObject = jsonObject2;
            jsonElement = jsonElement3;
            i = i4;
        }
        beginStructure.endStructure(descriptor2);
        return new ConsentStatusParamReq(i, env, str2, j2, j, str, jsonElement, jsonObject, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ConsentStatusParamReq value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ConsentStatusParamReq.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
