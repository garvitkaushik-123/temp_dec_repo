package com.sourcepoint.cmplibrary.data.network.model.optimized;

import androidx.core.view.ViewCompat;
import com.sourcepoint.cmplibrary.data.network.converter.GrantsSerializer;
import com.sourcepoint.cmplibrary.data.network.converter.JsonMapSerializer;
import com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonObjectSerializer;

/* compiled from: ConsentStatusApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GdprCS;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class GdprCS$$serializer implements GeneratedSerializer<GdprCS> {
    public static final GdprCS$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GdprCS$$serializer gdprCS$$serializer = new GdprCS$$serializer();
        INSTANCE = gdprCS$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.GdprCS", gdprCS$$serializer, 24);
        pluginGeneratedSerialDescriptor.addElement("applies", false);
        pluginGeneratedSerialDescriptor.addElement("categories", false);
        pluginGeneratedSerialDescriptor.addElement("consentAllRef", false);
        pluginGeneratedSerialDescriptor.addElement("consentedToAll", false);
        pluginGeneratedSerialDescriptor.addElement("legIntCategories", false);
        pluginGeneratedSerialDescriptor.addElement("legIntVendors", false);
        pluginGeneratedSerialDescriptor.addElement("postPayload", false);
        pluginGeneratedSerialDescriptor.addElement("rejectedAny", false);
        pluginGeneratedSerialDescriptor.addElement("specialFeatures", false);
        pluginGeneratedSerialDescriptor.addElement("vendors", false);
        pluginGeneratedSerialDescriptor.addElement("addtlConsent", false);
        pluginGeneratedSerialDescriptor.addElement("consentStatus", false);
        pluginGeneratedSerialDescriptor.addElement("cookieExpirationDays", false);
        pluginGeneratedSerialDescriptor.addElement("customVendorsResponse", false);
        pluginGeneratedSerialDescriptor.addElement("dateCreated", false);
        pluginGeneratedSerialDescriptor.addElement("euconsent", false);
        pluginGeneratedSerialDescriptor.addElement("grants", false);
        pluginGeneratedSerialDescriptor.addElement("TCData", false);
        pluginGeneratedSerialDescriptor.addElement("localDataCurrent", false);
        pluginGeneratedSerialDescriptor.addElement("uuid", false);
        pluginGeneratedSerialDescriptor.addElement("vendorListId", false);
        pluginGeneratedSerialDescriptor.addElement("webConsentPayload", true);
        pluginGeneratedSerialDescriptor.addElement("expirationDate", false);
        pluginGeneratedSerialDescriptor.addElement("gcmStatus", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GdprCS$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer[] kSerializerArr;
        kSerializerArr = GdprCS.$childSerializers;
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[1]), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[4]), BuiltinSerializersKt.getNullable(kSerializerArr[5]), BuiltinSerializersKt.getNullable(GdprCS$PostPayload$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(kSerializerArr[8]), BuiltinSerializersKt.getNullable(kSerializerArr[9]), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ConsentStatus$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GdprCS$CustomVendorsResponse$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GrantsSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonMapSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(JsonObjectSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GoogleConsentMode$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public GdprCS deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i;
        GoogleConsentMode googleConsentMode;
        List list;
        Boolean bool;
        String str;
        JsonObject jsonObject;
        String str2;
        String str3;
        Boolean bool2;
        List list2;
        List list3;
        GdprCS.PostPayload postPayload;
        List list4;
        String str4;
        ConsentStatus consentStatus;
        String str5;
        Integer num;
        Boolean bool3;
        String str6;
        GdprCS.CustomVendorsResponse customVendorsResponse;
        Map map;
        Boolean bool4;
        List list5;
        Map map2;
        String str7;
        Integer num2;
        GoogleConsentMode googleConsentMode2;
        int i2;
        int i3;
        GdprCS.CustomVendorsResponse customVendorsResponse2;
        Map map3;
        GoogleConsentMode googleConsentMode3;
        ConsentStatus consentStatus2;
        Map map4;
        ConsentStatus consentStatus3;
        GdprCS.CustomVendorsResponse customVendorsResponse3;
        ConsentStatus consentStatus4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = GdprCS.$childSerializers;
        if (beginStructure.decodeSequentially()) {
            Boolean bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            List list6 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 1, kSerializerArr[1], null);
            String str8 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, null);
            Boolean bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, null);
            List list7 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 4, kSerializerArr[4], null);
            List list8 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 5, kSerializerArr[5], null);
            GdprCS.PostPayload postPayload2 = (GdprCS.PostPayload) beginStructure.decodeNullableSerializableElement(descriptor2, 6, GdprCS$PostPayload$$serializer.INSTANCE, null);
            Boolean bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 7, BooleanSerializer.INSTANCE, null);
            List list9 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 8, kSerializerArr[8], null);
            List list10 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, 9, kSerializerArr[9], null);
            String str9 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, null);
            ConsentStatus consentStatus5 = (ConsentStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 11, ConsentStatus$$serializer.INSTANCE, null);
            Integer num3 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 12, IntSerializer.INSTANCE, null);
            GdprCS.CustomVendorsResponse customVendorsResponse4 = (GdprCS.CustomVendorsResponse) beginStructure.decodeNullableSerializableElement(descriptor2, 13, GdprCS$CustomVendorsResponse$$serializer.INSTANCE, null);
            String str10 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, null);
            String str11 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, null);
            Map map5 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 16, GrantsSerializer.INSTANCE, null);
            Map map6 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 17, JsonMapSerializer.INSTANCE, null);
            Boolean bool8 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 18, BooleanSerializer.INSTANCE, null);
            String str12 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 19, StringSerializer.INSTANCE, null);
            String str13 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 20, StringSerializer.INSTANCE, null);
            JsonObject jsonObject2 = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, 21, JsonObjectSerializer.INSTANCE, null);
            String str14 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 22, StringSerializer.INSTANCE, null);
            GoogleConsentMode googleConsentMode4 = (GoogleConsentMode) beginStructure.decodeNullableSerializableElement(descriptor2, 23, GoogleConsentMode$$serializer.INSTANCE, null);
            i = ViewCompat.MEASURED_SIZE_MASK;
            str2 = str13;
            googleConsentMode = googleConsentMode4;
            consentStatus = consentStatus5;
            str5 = str12;
            bool3 = bool8;
            map = map6;
            map2 = map5;
            str7 = str11;
            str6 = str10;
            customVendorsResponse = customVendorsResponse4;
            num = num3;
            jsonObject = jsonObject2;
            str = str14;
            bool = bool5;
            bool2 = bool6;
            list3 = list8;
            str3 = str8;
            str4 = str9;
            list2 = list7;
            list = list6;
            postPayload = postPayload2;
            bool4 = bool7;
            list4 = list10;
            list5 = list9;
        } else {
            int i4 = 5;
            int i5 = 9;
            int i6 = 8;
            int i7 = 4;
            int i8 = 1;
            boolean z = true;
            Integer num4 = null;
            GdprCS.CustomVendorsResponse customVendorsResponse5 = null;
            Map map7 = null;
            String str15 = null;
            Map map8 = null;
            GoogleConsentMode googleConsentMode5 = null;
            String str16 = null;
            Boolean bool9 = null;
            String str17 = null;
            ConsentStatus consentStatus6 = null;
            JsonObject jsonObject3 = null;
            String str18 = null;
            Boolean bool10 = null;
            List list11 = null;
            String str19 = null;
            Boolean bool11 = null;
            List list12 = null;
            List list13 = null;
            GdprCS.PostPayload postPayload3 = null;
            Boolean bool12 = null;
            List list14 = null;
            List list15 = null;
            String str20 = null;
            i = 0;
            String str21 = null;
            while (z) {
                ConsentStatus consentStatus7 = consentStatus6;
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        customVendorsResponse2 = customVendorsResponse5;
                        map3 = map7;
                        googleConsentMode3 = googleConsentMode5;
                        consentStatus2 = consentStatus7;
                        z = false;
                        customVendorsResponse5 = customVendorsResponse2;
                        map7 = map3;
                        consentStatus6 = consentStatus2;
                        i8 = 1;
                        i7 = 4;
                        i4 = 5;
                        i6 = 8;
                        i5 = 9;
                        googleConsentMode5 = googleConsentMode3;
                    case 0:
                        customVendorsResponse2 = customVendorsResponse5;
                        map3 = map7;
                        googleConsentMode3 = googleConsentMode5;
                        consentStatus2 = consentStatus7;
                        bool10 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool10);
                        i |= 1;
                        num4 = num4;
                        customVendorsResponse5 = customVendorsResponse2;
                        map7 = map3;
                        consentStatus6 = consentStatus2;
                        i8 = 1;
                        i7 = 4;
                        i4 = 5;
                        i6 = 8;
                        i5 = 9;
                        googleConsentMode5 = googleConsentMode3;
                    case 1:
                        GdprCS.CustomVendorsResponse customVendorsResponse6 = customVendorsResponse5;
                        map4 = map7;
                        int i9 = i8;
                        list11 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, i9, kSerializerArr[i8], list11);
                        i |= 2;
                        num4 = num4;
                        customVendorsResponse5 = customVendorsResponse6;
                        str19 = str19;
                        consentStatus6 = consentStatus7;
                        i7 = 4;
                        i4 = 5;
                        i6 = 8;
                        i5 = 9;
                        googleConsentMode5 = googleConsentMode5;
                        i8 = i9;
                        map7 = map4;
                    case 2:
                        googleConsentMode3 = googleConsentMode5;
                        consentStatus3 = consentStatus7;
                        str19 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 2, StringSerializer.INSTANCE, str19);
                        i |= 4;
                        num4 = num4;
                        customVendorsResponse5 = customVendorsResponse5;
                        map7 = map7;
                        bool11 = bool11;
                        consentStatus6 = consentStatus3;
                        i7 = 4;
                        i4 = 5;
                        i6 = 8;
                        i5 = 9;
                        googleConsentMode5 = googleConsentMode3;
                    case 3:
                        googleConsentMode3 = googleConsentMode5;
                        consentStatus3 = consentStatus7;
                        bool11 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, bool11);
                        i |= 8;
                        num4 = num4;
                        customVendorsResponse5 = customVendorsResponse5;
                        map7 = map7;
                        list12 = list12;
                        consentStatus6 = consentStatus3;
                        i7 = 4;
                        i4 = 5;
                        i6 = 8;
                        i5 = 9;
                        googleConsentMode5 = googleConsentMode3;
                    case 4:
                        customVendorsResponse3 = customVendorsResponse5;
                        Map map9 = map7;
                        int i10 = i7;
                        list12 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, i10, kSerializerArr[i7], list12);
                        i |= 16;
                        num4 = num4;
                        map7 = map9;
                        list13 = list13;
                        consentStatus6 = consentStatus7;
                        i4 = 5;
                        i6 = 8;
                        i5 = 9;
                        googleConsentMode5 = googleConsentMode5;
                        i7 = i10;
                        customVendorsResponse5 = customVendorsResponse3;
                    case 5:
                        GdprCS.CustomVendorsResponse customVendorsResponse7 = customVendorsResponse5;
                        map4 = map7;
                        int i11 = i4;
                        list13 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, i11, kSerializerArr[i4], list13);
                        i |= 32;
                        num4 = num4;
                        customVendorsResponse5 = customVendorsResponse7;
                        postPayload3 = postPayload3;
                        consentStatus6 = consentStatus7;
                        i6 = 8;
                        i5 = 9;
                        googleConsentMode5 = googleConsentMode5;
                        i4 = i11;
                        map7 = map4;
                    case 6:
                        googleConsentMode3 = googleConsentMode5;
                        consentStatus4 = consentStatus7;
                        postPayload3 = (GdprCS.PostPayload) beginStructure.decodeNullableSerializableElement(descriptor2, 6, GdprCS$PostPayload$$serializer.INSTANCE, postPayload3);
                        i |= 64;
                        num4 = num4;
                        customVendorsResponse5 = customVendorsResponse5;
                        map7 = map7;
                        bool12 = bool12;
                        consentStatus6 = consentStatus4;
                        i6 = 8;
                        i5 = 9;
                        googleConsentMode5 = googleConsentMode3;
                    case 7:
                        googleConsentMode3 = googleConsentMode5;
                        consentStatus4 = consentStatus7;
                        bool12 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 7, BooleanSerializer.INSTANCE, bool12);
                        i |= 128;
                        num4 = num4;
                        customVendorsResponse5 = customVendorsResponse5;
                        map7 = map7;
                        list14 = list14;
                        consentStatus6 = consentStatus4;
                        i6 = 8;
                        i5 = 9;
                        googleConsentMode5 = googleConsentMode3;
                    case 8:
                        customVendorsResponse3 = customVendorsResponse5;
                        Map map10 = map7;
                        int i12 = i6;
                        list14 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, i12, kSerializerArr[i6], list14);
                        i |= 256;
                        num4 = num4;
                        map7 = map10;
                        list15 = list15;
                        consentStatus6 = consentStatus7;
                        i5 = 9;
                        googleConsentMode5 = googleConsentMode5;
                        i6 = i12;
                        customVendorsResponse5 = customVendorsResponse3;
                    case 9:
                        GdprCS.CustomVendorsResponse customVendorsResponse8 = customVendorsResponse5;
                        map4 = map7;
                        int i13 = i5;
                        list15 = (List) beginStructure.decodeNullableSerializableElement(descriptor2, i13, kSerializerArr[i5], list15);
                        i |= 512;
                        num4 = num4;
                        customVendorsResponse5 = customVendorsResponse8;
                        str20 = str20;
                        consentStatus6 = consentStatus7;
                        googleConsentMode5 = googleConsentMode5;
                        i5 = i13;
                        map7 = map4;
                    case 10:
                        googleConsentMode3 = googleConsentMode5;
                        str20 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 10, StringSerializer.INSTANCE, str20);
                        i |= 1024;
                        num4 = num4;
                        customVendorsResponse5 = customVendorsResponse5;
                        map7 = map7;
                        consentStatus6 = consentStatus7;
                        googleConsentMode5 = googleConsentMode3;
                    case 11:
                        googleConsentMode3 = googleConsentMode5;
                        i |= 2048;
                        consentStatus6 = (ConsentStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 11, ConsentStatus$$serializer.INSTANCE, consentStatus7);
                        num4 = num4;
                        customVendorsResponse5 = customVendorsResponse5;
                        map7 = map7;
                        googleConsentMode5 = googleConsentMode3;
                    case 12:
                        num4 = (Integer) beginStructure.decodeNullableSerializableElement(descriptor2, 12, IntSerializer.INSTANCE, num4);
                        i |= 4096;
                        googleConsentMode5 = googleConsentMode5;
                        customVendorsResponse5 = customVendorsResponse5;
                        consentStatus6 = consentStatus7;
                    case 13:
                        num2 = num4;
                        googleConsentMode2 = googleConsentMode5;
                        customVendorsResponse5 = (GdprCS.CustomVendorsResponse) beginStructure.decodeNullableSerializableElement(descriptor2, 13, GdprCS$CustomVendorsResponse$$serializer.INSTANCE, customVendorsResponse5);
                        i |= 8192;
                        googleConsentMode5 = googleConsentMode2;
                        consentStatus6 = consentStatus7;
                        num4 = num2;
                    case 14:
                        num2 = num4;
                        googleConsentMode2 = googleConsentMode5;
                        str21 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 14, StringSerializer.INSTANCE, str21);
                        i |= 16384;
                        googleConsentMode5 = googleConsentMode2;
                        consentStatus6 = consentStatus7;
                        num4 = num2;
                    case 15:
                        num2 = num4;
                        googleConsentMode2 = googleConsentMode5;
                        str17 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 15, StringSerializer.INSTANCE, str17);
                        i2 = 32768;
                        i |= i2;
                        googleConsentMode5 = googleConsentMode2;
                        consentStatus6 = consentStatus7;
                        num4 = num2;
                    case 16:
                        num2 = num4;
                        googleConsentMode2 = googleConsentMode5;
                        map8 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 16, GrantsSerializer.INSTANCE, map8);
                        i2 = 65536;
                        i |= i2;
                        googleConsentMode5 = googleConsentMode2;
                        consentStatus6 = consentStatus7;
                        num4 = num2;
                    case 17:
                        num2 = num4;
                        googleConsentMode2 = googleConsentMode5;
                        map7 = (Map) beginStructure.decodeNullableSerializableElement(descriptor2, 17, JsonMapSerializer.INSTANCE, map7);
                        i2 = 131072;
                        i |= i2;
                        googleConsentMode5 = googleConsentMode2;
                        consentStatus6 = consentStatus7;
                        num4 = num2;
                    case 18:
                        num2 = num4;
                        googleConsentMode2 = googleConsentMode5;
                        bool9 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 18, BooleanSerializer.INSTANCE, bool9);
                        i2 = 262144;
                        i |= i2;
                        googleConsentMode5 = googleConsentMode2;
                        consentStatus6 = consentStatus7;
                        num4 = num2;
                    case 19:
                        num2 = num4;
                        googleConsentMode2 = googleConsentMode5;
                        str15 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 19, StringSerializer.INSTANCE, str15);
                        i2 = 524288;
                        i |= i2;
                        googleConsentMode5 = googleConsentMode2;
                        consentStatus6 = consentStatus7;
                        num4 = num2;
                    case 20:
                        num2 = num4;
                        str18 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 20, StringSerializer.INSTANCE, str18);
                        i3 = 1048576;
                        i |= i3;
                        consentStatus6 = consentStatus7;
                        num4 = num2;
                    case 21:
                        num2 = num4;
                        jsonObject3 = (JsonObject) beginStructure.decodeNullableSerializableElement(descriptor2, 21, JsonObjectSerializer.INSTANCE, jsonObject3);
                        i3 = 2097152;
                        i |= i3;
                        consentStatus6 = consentStatus7;
                        num4 = num2;
                    case 22:
                        num2 = num4;
                        str16 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 22, StringSerializer.INSTANCE, str16);
                        i3 = 4194304;
                        i |= i3;
                        consentStatus6 = consentStatus7;
                        num4 = num2;
                    case 23:
                        num2 = num4;
                        googleConsentMode5 = (GoogleConsentMode) beginStructure.decodeNullableSerializableElement(descriptor2, 23, GoogleConsentMode$$serializer.INSTANCE, googleConsentMode5);
                        i3 = 8388608;
                        i |= i3;
                        consentStatus6 = consentStatus7;
                        num4 = num2;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            String str22 = str19;
            googleConsentMode = googleConsentMode5;
            list = list11;
            bool = bool10;
            str = str16;
            jsonObject = jsonObject3;
            str2 = str18;
            str3 = str22;
            bool2 = bool11;
            list2 = list12;
            list3 = list13;
            postPayload = postPayload3;
            list4 = list15;
            str4 = str20;
            consentStatus = consentStatus6;
            str5 = str15;
            num = num4;
            bool3 = bool9;
            str6 = str21;
            customVendorsResponse = customVendorsResponse5;
            map = map7;
            bool4 = bool12;
            list5 = list14;
            map2 = map8;
            str7 = str17;
        }
        beginStructure.endStructure(descriptor2);
        return new GdprCS(i, bool, list, str3, bool2, list2, list3, postPayload, bool4, list5, list4, str4, consentStatus, num, customVendorsResponse, str6, str7, map2, map, bool3, str5, str2, jsonObject, str, googleConsentMode, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GdprCS value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        GdprCS.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
