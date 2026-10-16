package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.sourcepoint.cmplibrary.data.network.converter.CampaignTypeSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.GrantsSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.JsonMapSerializer;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
import com.sourcepoint.cmplibrary.exception.CampaignType;
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
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/GDPR.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GDPR;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class GDPR$$serializer implements GeneratedSerializer<GDPR> {
    public static final GDPR$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GDPR$$serializer gDPR$$serializer = new GDPR$$serializer();
        INSTANCE = gDPR$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.GDPR", gDPR$$serializer, 16);
        pluginGeneratedSerialDescriptor.addElement("addtlConsent", false);
        pluginGeneratedSerialDescriptor.addElement("childPmId", false);
        pluginGeneratedSerialDescriptor.addElement("consentStatus", false);
        pluginGeneratedSerialDescriptor.addElement("customVendorsResponse", false);
        pluginGeneratedSerialDescriptor.addElement("dateCreated", false);
        pluginGeneratedSerialDescriptor.addElement("euconsent", false);
        pluginGeneratedSerialDescriptor.addElement("grants", false);
        pluginGeneratedSerialDescriptor.addElement("hasLocalData", false);
        pluginGeneratedSerialDescriptor.addElement(PglCryptUtils.KEY_MESSAGE, false);
        pluginGeneratedSerialDescriptor.addElement("messageMetaData", false);
        pluginGeneratedSerialDescriptor.addElement("TCData", false);
        pluginGeneratedSerialDescriptor.addElement("type", false);
        pluginGeneratedSerialDescriptor.addElement("url", false);
        pluginGeneratedSerialDescriptor.addElement("expirationDate", false);
        pluginGeneratedSerialDescriptor.addElement("webConsentPayload", false);
        pluginGeneratedSerialDescriptor.addElement("gcmStatus", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GDPR$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ConsentStatus$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(GdprCS$CustomVendorsResponse$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GrantsSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonElementSerializer.INSTANCE), BuiltinSerializersKt.getNullable(MessageMetaData$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonMapSerializer.INSTANCE), CampaignTypeSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GoogleConsentMode$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public GDPR deserialize(Decoder decoder) {
        int i;
        String str;
        String str2;
        Map map;
        GoogleConsentMode googleConsentMode;
        JsonObject jsonObject;
        String str3;
        CampaignType campaignType;
        JsonElement jsonElement;
        MessageMetaData messageMetaData;
        String str4;
        ConsentStatus consentStatus;
        Map map2;
        String str5;
        String str6;
        Boolean bool;
        GdprCS.CustomVendorsResponse customVendorsResponse;
        GoogleConsentMode googleConsentMode2;
        String str7;
        GdprCS.CustomVendorsResponse customVendorsResponse2;
        GoogleConsentMode googleConsentMode3;
        ConsentStatus consentStatus2;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            String str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            ConsentStatus consentStatus3 = (ConsentStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 2, ConsentStatus$$serializer.INSTANCE, null);
            GdprCS.CustomVendorsResponse customVendorsResponse3 = (GdprCS.CustomVendorsResponse) beginStructure.decodeNullableSerializableElement(descriptor2, 3, GdprCS$CustomVendorsResponse$$serializer.INSTANCE, null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            Map map3 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 6, GrantsSerializer.INSTANCE, null);
            Boolean bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 7, BooleanSerializer.INSTANCE, null);
            JsonElement jsonElement2 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 8, JsonElementSerializer.INSTANCE, null);
            MessageMetaData messageMetaData2 = (MessageMetaData) beginStructure.decodeNullableSerializableElement(descriptor2, 9, MessageMetaData$$serializer.INSTANCE, null);
            Map map4 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 10, JsonMapSerializer.INSTANCE, null);
            CampaignType campaignType2 = (CampaignType) beginStructure.decodeSerializableElement(descriptor2, 11, CampaignTypeSerializer.INSTANCE, null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, null);
            String str13 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, null);
            i = 65535;
            map2 = map3;
            customVendorsResponse = customVendorsResponse3;
            jsonElement = jsonElement2;
            str6 = str11;
            str5 = str10;
            jsonObject = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, 14, JsonObjectSerializer.INSTANCE, null);
            googleConsentMode = (GoogleConsentMode) beginStructure.decodeNullableSerializableElement(descriptor2, 15, GoogleConsentMode$$serializer.INSTANCE, null);
            bool = bool2;
            str = str13;
            str2 = str12;
            consentStatus = consentStatus3;
            map = map4;
            messageMetaData = messageMetaData2;
            str4 = str8;
            str3 = str9;
            campaignType = campaignType2;
        } else {
            boolean z = true;
            GdprCS.CustomVendorsResponse customVendorsResponse4 = null;
            ConsentStatus consentStatus4 = null;
            String str14 = null;
            CampaignType campaignType3 = null;
            Map map5 = null;
            JsonElement jsonElement3 = null;
            Boolean bool3 = null;
            Map map6 = null;
            String str15 = null;
            MessageMetaData messageMetaData3 = null;
            String str16 = null;
            String str17 = null;
            String str18 = null;
            JsonObject jsonObject2 = null;
            String str19 = null;
            i = 0;
            GoogleConsentMode googleConsentMode4 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        googleConsentMode2 = googleConsentMode4;
                        str7 = str19;
                        customVendorsResponse2 = customVendorsResponse4;
                        z = false;
                        googleConsentMode4 = googleConsentMode2;
                        customVendorsResponse4 = customVendorsResponse2;
                        str19 = str7;
                    case 0:
                        googleConsentMode2 = googleConsentMode4;
                        String str20 = str19;
                        customVendorsResponse2 = customVendorsResponse4;
                        str7 = str20;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 0, StringSerializer.INSTANCE, str17);
                        i |= 1;
                        googleConsentMode4 = googleConsentMode2;
                        customVendorsResponse4 = customVendorsResponse2;
                        str19 = str7;
                    case 1:
                        i |= 2;
                        customVendorsResponse4 = customVendorsResponse4;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str19);
                        googleConsentMode4 = googleConsentMode4;
                    case 2:
                        consentStatus4 = (ConsentStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 2, ConsentStatus$$serializer.INSTANCE, consentStatus4);
                        i |= 4;
                        googleConsentMode4 = googleConsentMode4;
                        str18 = str18;
                    case 3:
                        googleConsentMode3 = googleConsentMode4;
                        consentStatus2 = consentStatus4;
                        customVendorsResponse4 = (GdprCS.CustomVendorsResponse) beginStructure.decodeNullableSerializableElement(descriptor2, 3, GdprCS$CustomVendorsResponse$$serializer.INSTANCE, customVendorsResponse4);
                        i |= 8;
                        googleConsentMode4 = googleConsentMode3;
                        consentStatus4 = consentStatus2;
                    case 4:
                        googleConsentMode3 = googleConsentMode4;
                        consentStatus2 = consentStatus4;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, str15);
                        i |= 16;
                        googleConsentMode4 = googleConsentMode3;
                        consentStatus4 = consentStatus2;
                    case 5:
                        googleConsentMode3 = googleConsentMode4;
                        consentStatus2 = consentStatus4;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str16);
                        i |= 32;
                        googleConsentMode4 = googleConsentMode3;
                        consentStatus4 = consentStatus2;
                    case 6:
                        googleConsentMode3 = googleConsentMode4;
                        consentStatus2 = consentStatus4;
                        map6 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 6, GrantsSerializer.INSTANCE, map6);
                        i |= 64;
                        googleConsentMode4 = googleConsentMode3;
                        consentStatus4 = consentStatus2;
                    case 7:
                        googleConsentMode3 = googleConsentMode4;
                        consentStatus2 = consentStatus4;
                        bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 7, BooleanSerializer.INSTANCE, bool3);
                        i |= 128;
                        googleConsentMode4 = googleConsentMode3;
                        consentStatus4 = consentStatus2;
                    case 8:
                        googleConsentMode3 = googleConsentMode4;
                        consentStatus2 = consentStatus4;
                        jsonElement3 = (JsonElement) beginStructure.decodeNullableSerializableElement(descriptor2, 8, JsonElementSerializer.INSTANCE, jsonElement3);
                        i |= 256;
                        googleConsentMode4 = googleConsentMode3;
                        consentStatus4 = consentStatus2;
                    case 9:
                        googleConsentMode3 = googleConsentMode4;
                        consentStatus2 = consentStatus4;
                        messageMetaData3 = (MessageMetaData) beginStructure.decodeNullableSerializableElement(descriptor2, 9, MessageMetaData$$serializer.INSTANCE, messageMetaData3);
                        i |= 512;
                        googleConsentMode4 = googleConsentMode3;
                        consentStatus4 = consentStatus2;
                    case 10:
                        googleConsentMode3 = googleConsentMode4;
                        consentStatus2 = consentStatus4;
                        map5 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 10, JsonMapSerializer.INSTANCE, map5);
                        i |= 1024;
                        googleConsentMode4 = googleConsentMode3;
                        consentStatus4 = consentStatus2;
                    case 11:
                        googleConsentMode3 = googleConsentMode4;
                        consentStatus2 = consentStatus4;
                        campaignType3 = (CampaignType) beginStructure.decodeSerializableElement(descriptor2, 11, CampaignTypeSerializer.INSTANCE, campaignType3);
                        i |= 2048;
                        googleConsentMode4 = googleConsentMode3;
                        consentStatus4 = consentStatus2;
                    case 12:
                        googleConsentMode3 = googleConsentMode4;
                        consentStatus2 = consentStatus4;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str14);
                        i |= 4096;
                        googleConsentMode4 = googleConsentMode3;
                        consentStatus4 = consentStatus2;
                    case 13:
                        consentStatus2 = consentStatus4;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 13, StringSerializer.INSTANCE, str18);
                        i |= 8192;
                        googleConsentMode4 = googleConsentMode4;
                        jsonObject2 = jsonObject2;
                        consentStatus4 = consentStatus2;
                    case 14:
                        consentStatus2 = consentStatus4;
                        googleConsentMode3 = googleConsentMode4;
                        jsonObject2 = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, 14, JsonObjectSerializer.INSTANCE, jsonObject2);
                        i |= 16384;
                        googleConsentMode4 = googleConsentMode3;
                        consentStatus4 = consentStatus2;
                    case 15:
                        googleConsentMode4 = (GoogleConsentMode) beginStructure.decodeNullableSerializableElement(descriptor2, 15, GoogleConsentMode$$serializer.INSTANCE, googleConsentMode4);
                        i |= 32768;
                        consentStatus4 = consentStatus4;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str18;
            String str21 = str19;
            GdprCS.CustomVendorsResponse customVendorsResponse5 = customVendorsResponse4;
            String str22 = str17;
            str2 = str14;
            map = map5;
            googleConsentMode = googleConsentMode4;
            jsonObject = jsonObject2;
            str3 = str21;
            campaignType = campaignType3;
            jsonElement = jsonElement3;
            messageMetaData = messageMetaData3;
            str4 = str22;
            consentStatus = consentStatus4;
            map2 = map6;
            str5 = str15;
            str6 = str16;
            bool = bool3;
            customVendorsResponse = customVendorsResponse5;
        }
        beginStructure.endStructure(descriptor2);
        return new GDPR(i, str4, str3, consentStatus, customVendorsResponse, str5, str6, map2, bool, jsonElement, messageMetaData, map, campaignType, str2, str, jsonObject, googleConsentMode, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GDPR value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        GDPR.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
