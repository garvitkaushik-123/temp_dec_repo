package com.sourcepoint.cmplibrary.model;

import com.sourcepoint.cmplibrary.data.network.converter.ActionTypeSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.CampaignTypeSerializer;
import com.sourcepoint.cmplibrary.exception.CampaignType;
import com.sourcepoint.cmplibrary.model.exposed.ActionType;
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
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: ConsentActionImplOptimized.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/model/ConsentActionImplOptimized.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/model/ConsentActionImplOptimized;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class ConsentActionImplOptimized$$serializer implements GeneratedSerializer<ConsentActionImplOptimized> {
    public static final ConsentActionImplOptimized$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ConsentActionImplOptimized$$serializer consentActionImplOptimized$$serializer = new ConsentActionImplOptimized$$serializer();
        INSTANCE = consentActionImplOptimized$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.model.ConsentActionImplOptimized", consentActionImplOptimized$$serializer, 13);
        pluginGeneratedSerialDescriptor.addElement("actionType", false);
        pluginGeneratedSerialDescriptor.addElement("choiceId", true);
        pluginGeneratedSerialDescriptor.addElement("consentLanguage", true);
        pluginGeneratedSerialDescriptor.addElement("customActionId", true);
        pluginGeneratedSerialDescriptor.addElement("legislation", false);
        pluginGeneratedSerialDescriptor.addElement("localPmId", false);
        pluginGeneratedSerialDescriptor.addElement("name", false);
        pluginGeneratedSerialDescriptor.addElement("pmId", false);
        pluginGeneratedSerialDescriptor.addElement("pmTab", true);
        pluginGeneratedSerialDescriptor.addElement("requestFromPm", false);
        pluginGeneratedSerialDescriptor.addElement("saveAndExitVariables", true);
        pluginGeneratedSerialDescriptor.addElement("pubData", true);
        pluginGeneratedSerialDescriptor.addElement("privacyManagerId", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConsentActionImplOptimized$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{ActionTypeSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), CampaignTypeSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BooleanSerializer.INSTANCE, JsonObjectSerializer.INSTANCE, JsonObjectSerializer.INSTANCE, BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ConsentActionImplOptimized deserialize(Decoder decoder) {
        boolean z;
        String str;
        int i;
        ActionType actionType;
        JsonObject jsonObject;
        String str2;
        String str3;
        CampaignType campaignType;
        JsonObject jsonObject2;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        ActionType actionType2;
        String str10;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        ActionType actionType3 = null;
        if (beginStructure.decodeSequentially()) {
            ActionType actionType4 = (ActionType) beginStructure.decodeSerializableElement(descriptor2, 0, ActionTypeSerializer.INSTANCE, null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            String str13 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            CampaignType campaignType2 = (CampaignType) beginStructure.decodeSerializableElement(descriptor2, 4, CampaignTypeSerializer.INSTANCE, null);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            String str15 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            String str16 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, null);
            String str17 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, null);
            boolean decodeBooleanElement = beginStructure.decodeBooleanElement(descriptor2, 9);
            JsonObject jsonObject3 = (JsonObject) beginStructure.decodeSerializableElement(descriptor2, 10, JsonObjectSerializer.INSTANCE, null);
            JsonObject jsonObject4 = (JsonObject) beginStructure.decodeSerializableElement(descriptor2, 11, JsonObjectSerializer.INSTANCE, null);
            actionType = actionType4;
            str7 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, null);
            jsonObject = jsonObject4;
            jsonObject2 = jsonObject3;
            z = decodeBooleanElement;
            str8 = str16;
            str3 = str15;
            str4 = str14;
            str5 = str13;
            str2 = str17;
            campaignType = campaignType2;
            str = str12;
            str6 = str11;
            i = 8191;
        } else {
            boolean z2 = true;
            String str18 = null;
            String str19 = null;
            JsonObject jsonObject5 = null;
            String str20 = null;
            String str21 = null;
            String str22 = null;
            CampaignType campaignType3 = null;
            JsonObject jsonObject6 = null;
            String str23 = null;
            String str24 = null;
            int i2 = 0;
            z = false;
            String str25 = null;
            while (z2) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        str9 = str19;
                        z2 = false;
                        str19 = str9;
                    case 0:
                        str9 = str19;
                        actionType3 = (ActionType) beginStructure.decodeSerializableElement(descriptor2, 0, ActionTypeSerializer.INSTANCE, actionType3);
                        i2 |= 1;
                        str19 = str9;
                    case 1:
                        actionType2 = actionType3;
                        str10 = str19;
                        str25 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, str25);
                        i2 |= 2;
                        str19 = str10;
                        actionType3 = actionType2;
                    case 2:
                        actionType2 = actionType3;
                        str10 = str19;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str18);
                        i2 |= 4;
                        str19 = str10;
                        actionType3 = actionType2;
                    case 3:
                        actionType2 = actionType3;
                        str10 = str19;
                        str24 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, str24);
                        i2 |= 8;
                        str19 = str10;
                        actionType3 = actionType2;
                    case 4:
                        actionType2 = actionType3;
                        str10 = str19;
                        campaignType3 = (CampaignType) beginStructure.decodeSerializableElement(descriptor2, 4, CampaignTypeSerializer.INSTANCE, campaignType3);
                        i2 |= 16;
                        str19 = str10;
                        actionType3 = actionType2;
                    case 5:
                        actionType2 = actionType3;
                        str10 = str19;
                        str23 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, str23);
                        i2 |= 32;
                        str19 = str10;
                        actionType3 = actionType2;
                    case 6:
                        actionType2 = actionType3;
                        str10 = str19;
                        str22 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, str22);
                        i2 |= 64;
                        str19 = str10;
                        actionType3 = actionType2;
                    case 7:
                        actionType2 = actionType3;
                        str10 = str19;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 7, StringSerializer.INSTANCE, str21);
                        i2 |= 128;
                        str19 = str10;
                        actionType3 = actionType2;
                    case 8:
                        actionType2 = actionType3;
                        str10 = str19;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 8, StringSerializer.INSTANCE, str20);
                        i2 |= 256;
                        str19 = str10;
                        actionType3 = actionType2;
                    case 9:
                        actionType2 = actionType3;
                        z = beginStructure.decodeBooleanElement(descriptor2, 9);
                        i2 |= 512;
                        actionType3 = actionType2;
                    case 10:
                        actionType2 = actionType3;
                        jsonObject6 = (JsonObject) beginStructure.decodeSerializableElement(descriptor2, 10, JsonObjectSerializer.INSTANCE, jsonObject6);
                        i2 |= 1024;
                        actionType3 = actionType2;
                    case 11:
                        actionType2 = actionType3;
                        jsonObject5 = (JsonObject) beginStructure.decodeSerializableElement(descriptor2, 11, JsonObjectSerializer.INSTANCE, jsonObject5);
                        i2 |= 2048;
                        actionType3 = actionType2;
                    case 12:
                        str19 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str19);
                        i2 |= 4096;
                        actionType3 = actionType3;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str18;
            i = i2;
            actionType = actionType3;
            jsonObject = jsonObject5;
            str2 = str20;
            str3 = str22;
            campaignType = campaignType3;
            jsonObject2 = jsonObject6;
            str4 = str23;
            str5 = str24;
            str6 = str25;
            str7 = str19;
            str8 = str21;
        }
        beginStructure.endStructure(descriptor2);
        return new ConsentActionImplOptimized(i, actionType, str6, str, str5, campaignType, str4, str3, str8, str2, z, jsonObject2, jsonObject, str7, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ConsentActionImplOptimized value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ConsentActionImplOptimized.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
