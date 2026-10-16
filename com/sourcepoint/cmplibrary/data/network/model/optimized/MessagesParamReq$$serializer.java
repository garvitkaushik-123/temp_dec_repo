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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesParamReq;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class MessagesParamReq$$serializer implements GeneratedSerializer<MessagesParamReq> {
    public static final MessagesParamReq$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        MessagesParamReq$$serializer messagesParamReq$$serializer = new MessagesParamReq$$serializer();
        INSTANCE = messagesParamReq$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesParamReq", messagesParamReq$$serializer, 10);
        pluginGeneratedSerialDescriptor.addElement(InMobiAdapter.ACCOUNT_ID, false);
        pluginGeneratedSerialDescriptor.addElement("propertyId", false);
        pluginGeneratedSerialDescriptor.addElement("authId", false);
        pluginGeneratedSerialDescriptor.addElement("propertyHref", false);
        pluginGeneratedSerialDescriptor.addElement(D5.o, false);
        pluginGeneratedSerialDescriptor.addElement("metadataArg", false);
        pluginGeneratedSerialDescriptor.addElement("body", false);
        pluginGeneratedSerialDescriptor.addElement("nonKeyedLocalState", true);
        pluginGeneratedSerialDescriptor.addElement("pubData", true);
        pluginGeneratedSerialDescriptor.addElement("localState", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MessagesParamReq$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = MessagesParamReq.$childSerializers;
        return new KSerializer[]{LongSerializer.INSTANCE, LongSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), StringSerializer.INSTANCE, kSerializerArr[4], BuiltinSerializersKt.getNullable(MetaDataArg$$serializer.INSTANCE), StringSerializer.INSTANCE, BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE), JsonObjectSerializer.INSTANCE, BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public MessagesParamReq deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i;
        JsonObject jsonObject;
        JsonObject jsonObject2;
        String str;
        JsonObject jsonObject3;
        long j;
        MetaDataArg metaDataArg;
        Env env;
        long j2;
        String str2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = MessagesParamReq.$childSerializers;
        int i2 = 9;
        int i3 = 7;
        String str3 = null;
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(descriptor2, 0);
            j2 = beginStructure.decodeLongElement(descriptor2, 1);
            String str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            String decodeStringElement = beginStructure.decodeStringElement(descriptor2, 3);
            Env env2 = (Env) beginStructure.decodeSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            MetaDataArg metaDataArg2 = (MetaDataArg) beginStructure.decodeNullableSerializableElement(descriptor2, 5, MetaDataArg$$serializer.INSTANCE, null);
            String decodeStringElement2 = beginStructure.decodeStringElement(descriptor2, 6);
            JsonObject jsonObject4 = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, 7, JsonObjectSerializer.INSTANCE, null);
            JsonObject jsonObject5 = (JsonObject) beginStructure.decodeSerializableElement(descriptor2, 8, JsonObjectSerializer.INSTANCE, null);
            str3 = str4;
            jsonObject2 = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, 9, JsonObjectSerializer.INSTANCE, null);
            jsonObject3 = jsonObject4;
            str = decodeStringElement2;
            metaDataArg = metaDataArg2;
            jsonObject = jsonObject5;
            i = 1023;
            j = decodeLongElement;
            env = env2;
            str2 = decodeStringElement;
        } else {
            long j3 = 0;
            int i4 = 4;
            boolean z = true;
            int i5 = 0;
            JsonObject jsonObject6 = null;
            JsonObject jsonObject7 = null;
            JsonObject jsonObject8 = null;
            MetaDataArg metaDataArg3 = null;
            Env env3 = null;
            String str5 = null;
            String str6 = null;
            long j4 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 9;
                        i4 = 4;
                    case 0:
                        j4 = beginStructure.decodeLongElement(descriptor2, 0);
                        i5 |= 1;
                        i2 = 9;
                        i3 = 7;
                        i4 = 4;
                    case 1:
                        j3 = beginStructure.decodeLongElement(descriptor2, 1);
                        i5 |= 2;
                        i2 = 9;
                        i3 = 7;
                        i4 = 4;
                    case 2:
                        str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str3);
                        i5 |= 4;
                        i2 = 9;
                        i3 = 7;
                        i4 = 4;
                    case 3:
                        str5 = beginStructure.decodeStringElement(descriptor2, 3);
                        i5 |= 8;
                        i2 = 9;
                    case 4:
                        env3 = (Env) beginStructure.decodeSerializableElement(descriptor2, i4, kSerializerArr[i4], env3);
                        i5 |= 16;
                        i2 = 9;
                    case 5:
                        metaDataArg3 = (MetaDataArg) beginStructure.decodeNullableSerializableElement(descriptor2, 5, MetaDataArg$$serializer.INSTANCE, metaDataArg3);
                        i5 |= 32;
                        i2 = 9;
                    case 6:
                        str6 = beginStructure.decodeStringElement(descriptor2, 6);
                        i5 |= 64;
                    case 7:
                        jsonObject7 = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, i3, JsonObjectSerializer.INSTANCE, jsonObject7);
                        i5 |= 128;
                    case 8:
                        jsonObject6 = (JsonObject) beginStructure.decodeSerializableElement(descriptor2, 8, JsonObjectSerializer.INSTANCE, jsonObject6);
                        i5 |= 256;
                    case 9:
                        jsonObject8 = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, i2, JsonObjectSerializer.INSTANCE, jsonObject8);
                        i5 |= 512;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            i = i5;
            jsonObject = jsonObject6;
            jsonObject2 = jsonObject8;
            str = str6;
            jsonObject3 = jsonObject7;
            j = j4;
            String str7 = str5;
            metaDataArg = metaDataArg3;
            env = env3;
            j2 = j3;
            str2 = str7;
        }
        beginStructure.endStructure(descriptor2);
        return new MessagesParamReq(i, j, j2, str3, str2, env, metaDataArg, str, jsonObject3, jsonObject, jsonObject2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, MessagesParamReq value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        MessagesParamReq.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
