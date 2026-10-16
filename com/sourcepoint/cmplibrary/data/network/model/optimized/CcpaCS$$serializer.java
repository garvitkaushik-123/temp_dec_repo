package com.sourcepoint.cmplibrary.data.network.model.optimized;

import androidx.compose.ui.layout.LayoutKt;
import com.sourcepoint.cmplibrary.data.network.converter.CcpaStatusSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.JsonMapSerializer;
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
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: ConsentStatusApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/CcpaCS;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class CcpaCS$$serializer implements GeneratedSerializer<CcpaCS> {
    public static final CcpaCS$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        CcpaCS$$serializer ccpaCS$$serializer = new CcpaCS$$serializer();
        INSTANCE = ccpaCS$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.CcpaCS", ccpaCS$$serializer, 15);
        pluginGeneratedSerialDescriptor.addElement("applies", false);
        pluginGeneratedSerialDescriptor.addElement("consentedAll", false);
        pluginGeneratedSerialDescriptor.addElement("dateCreated", false);
        pluginGeneratedSerialDescriptor.addElement("gpcEnabled", false);
        pluginGeneratedSerialDescriptor.addElement("newUser", false);
        pluginGeneratedSerialDescriptor.addElement("rejectedAll", false);
        pluginGeneratedSerialDescriptor.addElement("rejectedCategories", false);
        pluginGeneratedSerialDescriptor.addElement("rejectedVendors", false);
        pluginGeneratedSerialDescriptor.addElement("signedLspa", false);
        pluginGeneratedSerialDescriptor.addElement("uspstring", true);
        pluginGeneratedSerialDescriptor.addElement("status", false);
        pluginGeneratedSerialDescriptor.addElement("GPPData", true);
        pluginGeneratedSerialDescriptor.addElement("uuid", false);
        pluginGeneratedSerialDescriptor.addElement("webConsentPayload", true);
        pluginGeneratedSerialDescriptor.addElement("expirationDate", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CcpaCS$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = CcpaCS.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[6]), BuiltinSerializersKt.getNullable(kSerializerArr[7]), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(CcpaStatusSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonMapSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CcpaCS deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i;
        String str;
        Boolean bool;
        String str2;
        JsonObject jsonObject;
        String str3;
        List list;
        Map map;
        Boolean bool2;
        Boolean bool3;
        List list2;
        Boolean bool4;
        Boolean bool5;
        String str4;
        CcpaStatus ccpaStatus;
        Boolean bool6;
        String str5;
        Boolean bool7;
        Boolean bool8;
        String str6;
        Boolean bool9;
        String str7;
        Boolean bool10;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = CcpaCS.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            Boolean bool11 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Boolean bool12 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            Boolean bool13 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, null);
            bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, null);
            Boolean bool14 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, null);
            List list3 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 6, kSerializerArr[6], null);
            List list4 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 7, kSerializerArr[7], null);
            Boolean bool15 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 8, BooleanSerializer.INSTANCE, null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, null);
            CcpaStatus ccpaStatus2 = (CcpaStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 10, CcpaStatusSerializer.INSTANCE, null);
            Map map2 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 11, JsonMapSerializer.INSTANCE, null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, null);
            JsonObject jsonObject2 = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, 13, JsonObjectSerializer.INSTANCE, null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, null);
            i = LayoutKt.LargeDimension;
            jsonObject = jsonObject2;
            list2 = list3;
            str2 = str11;
            ccpaStatus = ccpaStatus2;
            map = map2;
            str3 = str10;
            bool2 = bool14;
            bool3 = bool15;
            bool5 = bool12;
            bool = bool13;
            str4 = str8;
            list = list4;
            str = str9;
            bool6 = bool11;
        } else {
            int i2 = 6;
            boolean z = true;
            String str12 = null;
            List list5 = null;
            String str13 = null;
            Map map3 = null;
            CcpaStatus ccpaStatus3 = null;
            List list6 = null;
            Boolean bool16 = null;
            String str14 = null;
            Boolean bool17 = null;
            Boolean bool18 = null;
            Boolean bool19 = null;
            String str15 = null;
            JsonObject jsonObject3 = null;
            int i3 = 7;
            i = 0;
            Boolean bool20 = null;
            Boolean bool21 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        str5 = str12;
                        bool7 = bool19;
                        bool8 = bool20;
                        z = false;
                        bool20 = bool8;
                        i2 = 6;
                        i3 = 7;
                        bool19 = bool7;
                        str12 = str5;
                    case 0:
                        str5 = str12;
                        Boolean bool22 = bool19;
                        bool8 = bool20;
                        bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool22);
                        i |= 1;
                        bool20 = bool8;
                        i2 = 6;
                        i3 = 7;
                        bool19 = bool7;
                        str12 = str5;
                    case 1:
                        bool20 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool20);
                        i |= 2;
                        str12 = str12;
                        str15 = str15;
                        i2 = 6;
                        i3 = 7;
                    case 2:
                        str6 = str12;
                        bool9 = bool20;
                        str13 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str13);
                        i |= 4;
                        str12 = str6;
                        bool20 = bool9;
                        i2 = 6;
                        i3 = 7;
                    case 3:
                        str6 = str12;
                        bool9 = bool20;
                        bool18 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, bool18);
                        i |= 8;
                        str12 = str6;
                        bool20 = bool9;
                        i2 = 6;
                        i3 = 7;
                    case 4:
                        str6 = str12;
                        bool9 = bool20;
                        bool16 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, bool16);
                        i |= 16;
                        str12 = str6;
                        bool20 = bool9;
                        i2 = 6;
                        i3 = 7;
                    case 5:
                        str6 = str12;
                        bool9 = bool20;
                        bool17 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, bool17);
                        i |= 32;
                        str12 = str6;
                        bool20 = bool9;
                        i2 = 6;
                        i3 = 7;
                    case 6:
                        list6 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, i2, kSerializerArr[i2], list6);
                        i |= 64;
                        str12 = str12;
                        bool20 = bool20;
                        i3 = 7;
                    case 7:
                        str7 = str12;
                        bool10 = bool20;
                        list5 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, i3, kSerializerArr[i3], list5);
                        i |= 128;
                        str12 = str7;
                        bool20 = bool10;
                    case 8:
                        str7 = str12;
                        bool10 = bool20;
                        bool21 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 8, BooleanSerializer.INSTANCE, bool21);
                        i |= 256;
                        str12 = str7;
                        bool20 = bool10;
                    case 9:
                        str7 = str12;
                        bool10 = bool20;
                        str14 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 9, StringSerializer.INSTANCE, str14);
                        i |= 512;
                        str12 = str7;
                        bool20 = bool10;
                    case 10:
                        str7 = str12;
                        bool10 = bool20;
                        ccpaStatus3 = (CcpaStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 10, CcpaStatusSerializer.INSTANCE, ccpaStatus3);
                        i |= 1024;
                        str12 = str7;
                        bool20 = bool10;
                    case 11:
                        str7 = str12;
                        bool10 = bool20;
                        map3 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 11, JsonMapSerializer.INSTANCE, map3);
                        i |= 2048;
                        str12 = str7;
                        bool20 = bool10;
                    case 12:
                        bool10 = bool20;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 12, StringSerializer.INSTANCE, str15);
                        i |= 4096;
                        str12 = str12;
                        jsonObject3 = jsonObject3;
                        bool20 = bool10;
                    case 13:
                        bool10 = bool20;
                        str7 = str12;
                        jsonObject3 = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, 13, JsonObjectSerializer.INSTANCE, jsonObject3);
                        i |= 8192;
                        str12 = str7;
                        bool20 = bool10;
                    case 14:
                        str12 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, str12);
                        i |= 16384;
                        bool20 = bool20;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str16 = str12;
            Boolean bool23 = bool19;
            str = str14;
            bool = bool18;
            str2 = str16;
            jsonObject = jsonObject3;
            str3 = str15;
            list = list5;
            map = map3;
            bool2 = bool17;
            bool3 = bool21;
            list2 = list6;
            bool4 = bool16;
            bool5 = bool20;
            str4 = str13;
            ccpaStatus = ccpaStatus3;
            bool6 = bool23;
        }
        beginStructure.endStructure(descriptor2);
        return new CcpaCS(i, bool6, bool5, str4, bool, bool4, bool2, list2, list, bool3, str, ccpaStatus, map, str3, jsonObject, str2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CcpaCS value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        CcpaCS.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
