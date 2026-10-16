package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.sourcepoint.cmplibrary.data.network.converter.JsonMapSerializer;
import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import java.util.List;
import java.util.Map;
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
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: ConsentStatusApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class USNatConsentData$$serializer implements GeneratedSerializer<USNatConsentData> {
    public static final USNatConsentData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        USNatConsentData$$serializer uSNatConsentData$$serializer = new USNatConsentData$$serializer();
        INSTANCE = uSNatConsentData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentData", uSNatConsentData$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("applies", true);
        pluginGeneratedSerialDescriptor.addElement("consentStatus", true);
        pluginGeneratedSerialDescriptor.addElement("consentStrings", true);
        pluginGeneratedSerialDescriptor.addElement("dateCreated", true);
        pluginGeneratedSerialDescriptor.addElement("uuid", true);
        pluginGeneratedSerialDescriptor.addElement("webConsentPayload", true);
        pluginGeneratedSerialDescriptor.addElement(PglCryptUtils.KEY_MESSAGE, true);
        pluginGeneratedSerialDescriptor.addElement("GPPData", true);
        pluginGeneratedSerialDescriptor.addElement("messageMetaData", true);
        pluginGeneratedSerialDescriptor.addElement("type", true);
        pluginGeneratedSerialDescriptor.addElement("url", true);
        pluginGeneratedSerialDescriptor.addElement("expirationDate", true);
        pluginGeneratedSerialDescriptor.addElement("userConsents", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private USNatConsentData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = USNatConsentData.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(USNatConsentStatus$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[2]), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonMapSerializer.INSTANCE), BuiltinSerializersKt.getNullable(MessageMetaData$$serializer.INSTANCE), kSerializerArr[9], BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(USNatConsentData$UserConsents$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public USNatConsentData deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        JsonObject jsonObject;
        int i;
        CampaignType campaignType;
        USNatConsentData.UserConsents userConsents;
        String str;
        String str2;
        String str3;
        Map map;
        USNatConsentStatus uSNatConsentStatus;
        String str4;
        JsonElement jsonElement;
        List list;
        MessageMetaData messageMetaData;
        Boolean bool;
        USNatConsentData.UserConsents userConsents2;
        Boolean bool2;
        USNatConsentStatus uSNatConsentStatus2;
        USNatConsentStatus uSNatConsentStatus3;
        USNatConsentStatus uSNatConsentStatus4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = USNatConsentData.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            Boolean bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            USNatConsentStatus uSNatConsentStatus5 = (USNatConsentStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 1, USNatConsentStatus$$serializer.INSTANCE, null);
            List list2 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 2, kSerializerArr[2], null);
            str3 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            String str5 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            JsonObject jsonObject2 = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, 5, JsonObjectSerializer.INSTANCE, null);
            JsonElement jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 6, JsonElementSerializer.INSTANCE, null);
            Map map2 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 7, JsonMapSerializer.INSTANCE, null);
            MessageMetaData messageMetaData2 = (MessageMetaData) beginStructure.decodeNullableSerializableElement(descriptor2, 8, MessageMetaData$$serializer.INSTANCE, null);
            CampaignType campaignType2 = (CampaignType) beginStructure.decodeSerializableElement(descriptor2, 9, kSerializerArr[9], null);
            String str6 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, null);
            String str7 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, null);
            i = 8191;
            userConsents = (USNatConsentData.UserConsents) beginStructure.decodeNullableSerializableElement(descriptor2, 12, USNatConsentData$UserConsents$$serializer.INSTANCE, null);
            str4 = str6;
            messageMetaData = messageMetaData2;
            str2 = str5;
            str = str7;
            jsonElement = jsonElement2;
            jsonObject = jsonObject2;
            list = list2;
            uSNatConsentStatus = uSNatConsentStatus5;
            campaignType = campaignType2;
            map = map2;
            bool = bool3;
        } else {
            USNatConsentData.UserConsents userConsents3 = null;
            String str8 = null;
            MessageMetaData messageMetaData3 = null;
            Map map3 = null;
            JsonElement jsonElement3 = null;
            String str9 = null;
            CampaignType campaignType3 = null;
            jsonObject = null;
            Boolean bool4 = null;
            int i2 = 9;
            int i3 = 2;
            boolean z = true;
            i = 0;
            USNatConsentStatus uSNatConsentStatus6 = null;
            String str10 = null;
            String str11 = null;
            List list3 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        userConsents2 = userConsents3;
                        bool2 = bool4;
                        uSNatConsentStatus2 = uSNatConsentStatus6;
                        z = false;
                        uSNatConsentStatus6 = uSNatConsentStatus2;
                        i3 = 2;
                        i2 = 9;
                        bool4 = bool2;
                        userConsents3 = userConsents2;
                    case 0:
                        userConsents2 = userConsents3;
                        Boolean bool5 = bool4;
                        uSNatConsentStatus2 = uSNatConsentStatus6;
                        bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool5);
                        i |= 1;
                        uSNatConsentStatus6 = uSNatConsentStatus2;
                        i3 = 2;
                        i2 = 9;
                        bool4 = bool2;
                        userConsents3 = userConsents2;
                    case 1:
                        uSNatConsentStatus6 = (USNatConsentStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 1, USNatConsentStatus$$serializer.INSTANCE, uSNatConsentStatus6);
                        i |= 2;
                        userConsents3 = userConsents3;
                        i3 = 2;
                        i2 = 9;
                    case 2:
                        uSNatConsentStatus3 = uSNatConsentStatus6;
                        list3 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, i3, kSerializerArr[i3], list3);
                        i |= 4;
                        uSNatConsentStatus6 = uSNatConsentStatus3;
                        i2 = 9;
                    case 3:
                        uSNatConsentStatus3 = uSNatConsentStatus6;
                        str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str11);
                        i |= 8;
                        uSNatConsentStatus6 = uSNatConsentStatus3;
                        i2 = 9;
                    case 4:
                        uSNatConsentStatus3 = uSNatConsentStatus6;
                        str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str9);
                        i |= 16;
                        uSNatConsentStatus6 = uSNatConsentStatus3;
                        i2 = 9;
                    case 5:
                        uSNatConsentStatus3 = uSNatConsentStatus6;
                        jsonObject = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, 5, JsonObjectSerializer.INSTANCE, jsonObject);
                        i |= 32;
                        uSNatConsentStatus6 = uSNatConsentStatus3;
                        i2 = 9;
                    case 6:
                        uSNatConsentStatus3 = uSNatConsentStatus6;
                        jsonElement3 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 6, JsonElementSerializer.INSTANCE, jsonElement3);
                        i |= 64;
                        uSNatConsentStatus6 = uSNatConsentStatus3;
                        i2 = 9;
                    case 7:
                        uSNatConsentStatus3 = uSNatConsentStatus6;
                        map3 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 7, JsonMapSerializer.INSTANCE, map3);
                        i |= 128;
                        uSNatConsentStatus6 = uSNatConsentStatus3;
                        i2 = 9;
                    case 8:
                        uSNatConsentStatus3 = uSNatConsentStatus6;
                        messageMetaData3 = (MessageMetaData) beginStructure.decodeNullableSerializableElement(descriptor2, 8, MessageMetaData$$serializer.INSTANCE, messageMetaData3);
                        i |= 256;
                        uSNatConsentStatus6 = uSNatConsentStatus3;
                        i2 = 9;
                    case 9:
                        uSNatConsentStatus4 = uSNatConsentStatus6;
                        campaignType3 = (CampaignType) beginStructure.decodeSerializableElement(descriptor2, i2, kSerializerArr[i2], campaignType3);
                        i |= 512;
                        uSNatConsentStatus6 = uSNatConsentStatus4;
                    case 10:
                        uSNatConsentStatus4 = uSNatConsentStatus6;
                        str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, str10);
                        i |= 1024;
                        uSNatConsentStatus6 = uSNatConsentStatus4;
                    case 11:
                        uSNatConsentStatus4 = uSNatConsentStatus6;
                        str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 11, StringSerializer.INSTANCE, str8);
                        i |= 2048;
                        uSNatConsentStatus6 = uSNatConsentStatus4;
                    case 12:
                        userConsents3 = (USNatConsentData.UserConsents) beginStructure.decodeNullableSerializableElement(descriptor2, 12, USNatConsentData$UserConsents$$serializer.INSTANCE, userConsents3);
                        i |= 4096;
                        uSNatConsentStatus6 = uSNatConsentStatus6;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            USNatConsentData.UserConsents userConsents4 = userConsents3;
            Boolean bool6 = bool4;
            campaignType = campaignType3;
            userConsents = userConsents4;
            str = str8;
            str2 = str9;
            str3 = str11;
            map = map3;
            uSNatConsentStatus = uSNatConsentStatus6;
            str4 = str10;
            jsonElement = jsonElement3;
            list = list3;
            messageMetaData = messageMetaData3;
            bool = bool6;
        }
        beginStructure.endStructure(descriptor2);
        return new USNatConsentData(i, bool, uSNatConsentStatus, list, str3, str2, jsonObject, jsonElement, map, messageMetaData, campaignType, str4, str, userConsents, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, USNatConsentData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        USNatConsentData.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
