package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.converter.MessageCategorySerializer;
import com.sourcepoint.cmplibrary.data.network.converter.MessageSubCategorySerializer;
import com.sourcepoint.cmplibrary.model.exposed.MessageCategory;
import com.sourcepoint.cmplibrary.model.exposed.MessageSubCategory;
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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MessageMetaData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class MessageMetaData$$serializer implements GeneratedSerializer<MessageMetaData> {
    public static final MessageMetaData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        MessageMetaData$$serializer messageMetaData$$serializer = new MessageMetaData$$serializer();
        INSTANCE = messageMetaData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.MessageMetaData", messageMetaData$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("bucket", false);
        pluginGeneratedSerialDescriptor.addElement("categoryId", false);
        pluginGeneratedSerialDescriptor.addElement("messageId", false);
        pluginGeneratedSerialDescriptor.addElement("msgDescription", false);
        pluginGeneratedSerialDescriptor.addElement("prtnUUID", false);
        pluginGeneratedSerialDescriptor.addElement("subCategoryId", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MessageMetaData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), MessageCategorySerializer.INSTANCE, BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), MessageSubCategorySerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public MessageMetaData deserialize(Decoder decoder) {
        String str;
        MessageSubCategory messageSubCategory;
        Integer num;
        String str2;
        Integer num2;
        MessageCategory messageCategory;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 5;
        Integer num3 = null;
        if (beginStructure.decodeSequentially()) {
            Integer num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, IntSerializer.INSTANCE, null);
            MessageCategory messageCategory2 = (MessageCategory) beginStructure.decodeSerializableElement(descriptor2, 1, MessageCategorySerializer.INSTANCE, null);
            Integer num5 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, null);
            String str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            String str4 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            num2 = num4;
            messageSubCategory = (MessageSubCategory) beginStructure.decodeSerializableElement(descriptor2, 5, MessageSubCategorySerializer.INSTANCE, null);
            str2 = str3;
            str = str4;
            num = num5;
            messageCategory = messageCategory2;
            i = 63;
        } else {
            boolean z = true;
            int i3 = 0;
            MessageCategory messageCategory3 = null;
            Integer num6 = null;
            String str5 = null;
            String str6 = null;
            MessageSubCategory messageSubCategory2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 5;
                    case 0:
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 0, IntSerializer.INSTANCE, num3);
                        i3 |= 1;
                        i2 = 5;
                    case 1:
                        messageCategory3 = (MessageCategory) beginStructure.decodeSerializableElement(descriptor2, 1, MessageCategorySerializer.INSTANCE, messageCategory3);
                        i3 |= 2;
                    case 2:
                        num6 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, num6);
                        i3 |= 4;
                    case 3:
                        str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str5);
                        i3 |= 8;
                    case 4:
                        str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str6);
                        i3 |= 16;
                    case 5:
                        messageSubCategory2 = (MessageSubCategory) beginStructure.decodeSerializableElement(descriptor2, i2, MessageSubCategorySerializer.INSTANCE, messageSubCategory2);
                        i3 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str6;
            messageSubCategory = messageSubCategory2;
            num = num6;
            str2 = str5;
            num2 = num3;
            messageCategory = messageCategory3;
            i = i3;
        }
        beginStructure.endStructure(descriptor2);
        return new MessageMetaData(i, num2, messageCategory, num, str2, str, messageSubCategory, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, MessageMetaData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        MessageMetaData.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
