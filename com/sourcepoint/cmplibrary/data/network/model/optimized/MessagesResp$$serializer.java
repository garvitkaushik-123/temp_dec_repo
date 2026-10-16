package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.unity3d.ads.core.domain.HandleInvocationsFromAdViewer;
import java.util.List;
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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessagesResp;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class MessagesResp$$serializer implements GeneratedSerializer<MessagesResp> {
    public static final MessagesResp$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        MessagesResp$$serializer messagesResp$$serializer = new MessagesResp$$serializer();
        INSTANCE = messagesResp$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.MessagesResp", messagesResp$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement("campaigns", false);
        pluginGeneratedSerialDescriptor.addElement("localState", false);
        pluginGeneratedSerialDescriptor.addElement("nonKeyedLocalState", false);
        pluginGeneratedSerialDescriptor.addElement(HandleInvocationsFromAdViewer.KEY_DOWNLOAD_PRIORITY, false);
        pluginGeneratedSerialDescriptor.addElement("propertyId", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MessagesResp$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = MessagesResp.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(Campaigns$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE), kSerializerArr[3], BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public MessagesResp deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i;
        Campaigns campaigns;
        JsonElement jsonElement;
        JsonElement jsonElement2;
        List list;
        Integer num;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = MessagesResp.$childSerializers;
        Campaigns campaigns2 = null;
        if (beginStructure.decodeSequentially()) {
            Campaigns campaigns3 = (Campaigns) beginStructure.decodeNullableSerializableElement(descriptor2, 0, Campaigns$$serializer.INSTANCE, null);
            JsonElement jsonElement3 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 1, JsonElementSerializer.INSTANCE, null);
            JsonElement jsonElement4 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 2, JsonElementSerializer.INSTANCE, null);
            list = (List) beginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], null);
            campaigns = campaigns3;
            num = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, null);
            jsonElement2 = jsonElement4;
            i = 31;
            jsonElement = jsonElement3;
        } else {
            boolean z = true;
            int i2 = 0;
            JsonElement jsonElement5 = null;
            JsonElement jsonElement6 = null;
            List list2 = null;
            Integer num2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    campaigns2 = (Campaigns) beginStructure.decodeNullableSerializableElement(descriptor2, 0, Campaigns$$serializer.INSTANCE, campaigns2);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    jsonElement5 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 1, JsonElementSerializer.INSTANCE, jsonElement5);
                    i2 |= 2;
                } else if (decodeElementIndex == 2) {
                    jsonElement6 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 2, JsonElementSerializer.INSTANCE, jsonElement6);
                    i2 |= 4;
                } else if (decodeElementIndex == 3) {
                    list2 = (List) beginStructure.decodeSerializableElement(descriptor2, 3, kSerializerArr[3], list2);
                    i2 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    num2 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 4, IntSerializer.INSTANCE, num2);
                    i2 |= 16;
                }
            }
            i = i2;
            campaigns = campaigns2;
            jsonElement = jsonElement5;
            jsonElement2 = jsonElement6;
            list = list2;
            num = num2;
        }
        beginStructure.endStructure(descriptor2);
        return new MessagesResp(i, campaigns, jsonElement, jsonElement2, list, num, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, MessagesResp value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        MessagesResp.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
