package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.sourcepoint.cmplibrary.data.network.converter.CampaignTypeSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.CcpaStatusSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.JsonMapSerializer;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.CcpaStatus;
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

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/CCPA.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CCPA;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class CCPA$$serializer implements GeneratedSerializer<CCPA> {
    public static final CCPA$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CCPA$$serializer cCPA$$serializer = new CCPA$$serializer();
        INSTANCE = cCPA$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.CCPA", cCPA$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement("consentedAll", false);
        pluginGeneratedSerialDescriptor.addElement("dateCreated", false);
        pluginGeneratedSerialDescriptor.addElement(PglCryptUtils.KEY_MESSAGE, false);
        pluginGeneratedSerialDescriptor.addElement("messageMetaData", false);
        pluginGeneratedSerialDescriptor.addElement("newUser", false);
        pluginGeneratedSerialDescriptor.addElement("rejectedAll", false);
        pluginGeneratedSerialDescriptor.addElement("rejectedCategories", false);
        pluginGeneratedSerialDescriptor.addElement("rejectedVendors", false);
        pluginGeneratedSerialDescriptor.addElement("signedLspa", false);
        pluginGeneratedSerialDescriptor.addElement("uspstring", true);
        pluginGeneratedSerialDescriptor.addElement("GPPData", true);
        pluginGeneratedSerialDescriptor.addElement("status", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("url", false);
        pluginGeneratedSerialDescriptor.addElement("webConsentPayload", false);
        pluginGeneratedSerialDescriptor.addElement("expirationDate", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CCPA$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = CCPA.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE), BuiltinSerializersKt.getNullable(MessageMetaData$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[6]), BuiltinSerializersKt.getNullable(kSerializerArr[7]), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonMapSerializer.INSTANCE), BuiltinSerializersKt.getNullable(CcpaStatusSerializer.INSTANCE), CampaignTypeSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CCPA deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        Boolean bool;
        int i;
        Boolean bool2;
        String str;
        MessageMetaData messageMetaData;
        String str2;
        JsonObject jsonObject;
        String str3;
        CampaignType campaignType;
        List list;
        CcpaStatus ccpaStatus;
        List list2;
        Boolean bool3;
        String str4;
        Map map;
        Boolean bool4;
        JsonElement jsonElement;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = CCPA.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            JsonElement jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 2, JsonElementSerializer.INSTANCE, null);
            MessageMetaData messageMetaData2 = (MessageMetaData) beginStructure.decodeNullableSerializableElement(descriptor2, 3, MessageMetaData$$serializer.INSTANCE, null);
            bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, null);
            Boolean bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, null);
            List list3 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 6, kSerializerArr[6], null);
            List list4 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 7, kSerializerArr[7], null);
            bool = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 8, BooleanSerializer.INSTANCE, null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, null);
            Map map2 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 10, JsonMapSerializer.INSTANCE, null);
            CcpaStatus ccpaStatus2 = (CcpaStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 11, CcpaStatusSerializer.INSTANCE, null);
            CampaignType campaignType2 = (CampaignType) beginStructure.decodeSerializableElement(descriptor2, 12, CampaignTypeSerializer.INSTANCE, null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, null);
            i = 65535;
            jsonObject = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, 14, JsonObjectSerializer.INSTANCE, null);
            str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, null);
            map = map2;
            bool3 = bool5;
            ccpaStatus = ccpaStatus2;
            str3 = str12;
            campaignType = campaignType2;
            list = list4;
            str4 = str10;
            str = str11;
            messageMetaData = messageMetaData2;
            jsonElement = jsonElement2;
            list2 = list3;
        } else {
            int i2 = 7;
            int i3 = 6;
            boolean z = true;
            String str13 = null;
            bool = null;
            List list5 = null;
            JsonElement jsonElement3 = null;
            CcpaStatus ccpaStatus3 = null;
            Map map3 = null;
            List list6 = null;
            Boolean bool6 = null;
            String str14 = null;
            Boolean bool7 = null;
            MessageMetaData messageMetaData3 = null;
            Boolean bool8 = null;
            CampaignType campaignType3 = null;
            String str15 = null;
            JsonObject jsonObject2 = null;
            i = 0;
            String str16 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        str5 = str13;
                        bool8 = bool8;
                        str16 = str16;
                        z = false;
                        str13 = str5;
                        i3 = 6;
                        i2 = 7;
                    case 0:
                        str5 = str13;
                        i |= 1;
                        bool8 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool8);
                        str16 = str16;
                        str13 = str5;
                        i3 = 6;
                        i2 = 7;
                    case 1:
                        i |= 2;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str16);
                        str13 = str13;
                        campaignType3 = campaignType3;
                        i3 = 6;
                        i2 = 7;
                    case 2:
                        str6 = str13;
                        str7 = str16;
                        jsonElement3 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 2, JsonElementSerializer.INSTANCE, jsonElement3);
                        i |= 4;
                        str13 = str6;
                        str16 = str7;
                        i3 = 6;
                        i2 = 7;
                    case 3:
                        str6 = str13;
                        str7 = str16;
                        messageMetaData3 = (MessageMetaData) beginStructure.decodeNullableSerializableElement(descriptor2, 3, MessageMetaData$$serializer.INSTANCE, messageMetaData3);
                        i |= 8;
                        str13 = str6;
                        str16 = str7;
                        i3 = 6;
                        i2 = 7;
                    case 4:
                        str6 = str13;
                        str7 = str16;
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, bool6);
                        i |= 16;
                        str13 = str6;
                        str16 = str7;
                        i3 = 6;
                        i2 = 7;
                    case 5:
                        str6 = str13;
                        str7 = str16;
                        bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, bool7);
                        i |= 32;
                        str13 = str6;
                        str16 = str7;
                        i3 = 6;
                        i2 = 7;
                    case 6:
                        list6 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, i3, kSerializerArr[i3], list6);
                        i |= 64;
                        str13 = str13;
                        str16 = str16;
                        i2 = 7;
                    case 7:
                        str8 = str13;
                        str9 = str16;
                        list5 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, i2, kSerializerArr[i2], list5);
                        i |= 128;
                        str13 = str8;
                        str16 = str9;
                    case 8:
                        str8 = str13;
                        str9 = str16;
                        bool = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 8, BooleanSerializer.INSTANCE, bool);
                        i |= 256;
                        str13 = str8;
                        str16 = str9;
                    case 9:
                        str8 = str13;
                        str9 = str16;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, str14);
                        i |= 512;
                        str13 = str8;
                        str16 = str9;
                    case 10:
                        str8 = str13;
                        str9 = str16;
                        map3 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 10, JsonMapSerializer.INSTANCE, map3);
                        i |= 1024;
                        str13 = str8;
                        str16 = str9;
                    case 11:
                        str8 = str13;
                        str9 = str16;
                        ccpaStatus3 = (CcpaStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 11, CcpaStatusSerializer.INSTANCE, ccpaStatus3);
                        i |= 2048;
                        str13 = str8;
                        str16 = str9;
                    case 12:
                        str9 = str16;
                        campaignType3 = (CampaignType) beginStructure.decodeSerializableElement(descriptor2, 12, CampaignTypeSerializer.INSTANCE, campaignType3);
                        i |= 4096;
                        str13 = str13;
                        str15 = str15;
                        str16 = str9;
                    case 13:
                        str9 = str16;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, str15);
                        i |= 8192;
                        str13 = str13;
                        jsonObject2 = jsonObject2;
                        str16 = str9;
                    case 14:
                        str9 = str16;
                        str8 = str13;
                        jsonObject2 = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, 14, JsonObjectSerializer.INSTANCE, jsonObject2);
                        i |= 16384;
                        str13 = str8;
                        str16 = str9;
                    case 15:
                        str13 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, str13);
                        i |= 32768;
                        str16 = str16;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            Boolean bool9 = bool8;
            String str17 = str16;
            bool2 = bool9;
            str = str14;
            messageMetaData = messageMetaData3;
            str2 = str13;
            jsonObject = jsonObject2;
            str3 = str15;
            campaignType = campaignType3;
            list = list5;
            ccpaStatus = ccpaStatus3;
            list2 = list6;
            bool3 = bool7;
            str4 = str17;
            map = map3;
            bool4 = bool6;
            jsonElement = jsonElement3;
        }
        int i4 = i;
        Boolean bool10 = bool2;
        beginStructure.endStructure(descriptor2);
        return new CCPA(i4, bool10, str4, jsonElement, messageMetaData, bool4, bool3, list2, list, bool, str, map, ccpaStatus, campaignType, str3, jsonObject, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CCPA value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        CCPA.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
