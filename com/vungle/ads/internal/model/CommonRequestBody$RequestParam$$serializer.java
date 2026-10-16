package com.vungle.ads.internal.model;

import com.ironsource.C2995ad;
import com.mbridge.msdk.MBridgeConstans;
import com.vungle.ads.internal.model.CommonRequestBody;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: CommonRequestBody.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/CommonRequestBody.RequestParam.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/CommonRequestBody$RequestParam;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes7.dex */
public final class CommonRequestBody$RequestParam$$serializer implements GeneratedSerializer<CommonRequestBody.RequestParam> {
    public static final CommonRequestBody$RequestParam$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        CommonRequestBody$RequestParam$$serializer commonRequestBody$RequestParam$$serializer = new CommonRequestBody$RequestParam$$serializer();
        INSTANCE = commonRequestBody$RequestParam$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.CommonRequestBody.RequestParam", commonRequestBody$RequestParam$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement(C2995ad.c, true);
        pluginGeneratedSerialDescriptor.addElement("ad_size", true);
        pluginGeneratedSerialDescriptor.addElement("ad_start_time", true);
        pluginGeneratedSerialDescriptor.addElement(MBridgeConstans.APP_ID, true);
        pluginGeneratedSerialDescriptor.addElement("placement_reference_id", true);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.SOURCE_USER_TYPE, true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private CommonRequestBody$RequestParam$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE)), BuiltinSerializersKt.getNullable(CommonRequestBody$AdSizeParam$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(LongSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CommonRequestBody.RequestParam deserialize(Decoder decoder) {
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 5;
        Object obj7 = null;
        if (beginStructure.decodeSequentially()) {
            obj = beginStructure.decodeNullableSerializableElement(descriptor2, 0, new ArrayListSerializer(StringSerializer.INSTANCE), null);
            obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, CommonRequestBody$AdSizeParam$$serializer.INSTANCE, null);
            obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, LongSerializer.INSTANCE, null);
            obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, null);
            obj5 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, null);
            obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            i = 63;
        } else {
            boolean z = true;
            int i3 = 0;
            Object obj8 = null;
            Object obj9 = null;
            Object obj10 = null;
            Object obj11 = null;
            Object obj12 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 5;
                    case 0:
                        obj7 = beginStructure.decodeNullableSerializableElement(descriptor2, 0, new ArrayListSerializer(StringSerializer.INSTANCE), obj7);
                        i3 |= 1;
                        i2 = 5;
                    case 1:
                        obj8 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, CommonRequestBody$AdSizeParam$$serializer.INSTANCE, obj8);
                        i3 |= 2;
                    case 2:
                        obj9 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, LongSerializer.INSTANCE, obj9);
                        i3 |= 4;
                    case 3:
                        obj10 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, StringSerializer.INSTANCE, obj10);
                        i3 |= 8;
                    case 4:
                        obj11 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, StringSerializer.INSTANCE, obj11);
                        i3 |= 16;
                    case 5:
                        obj12 = beginStructure.decodeNullableSerializableElement(descriptor2, i2, StringSerializer.INSTANCE, obj12);
                        i3 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            Object obj13 = obj7;
            i = i3;
            obj = obj13;
            obj2 = obj8;
            obj3 = obj9;
            obj4 = obj10;
            obj5 = obj11;
            obj6 = obj12;
        }
        beginStructure.endStructure(descriptor2);
        return new CommonRequestBody.RequestParam(i, (List) obj, (CommonRequestBody.AdSizeParam) obj2, (Long) obj3, (String) obj4, (String) obj5, (String) obj6, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CommonRequestBody.RequestParam value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        CommonRequestBody.RequestParam.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
