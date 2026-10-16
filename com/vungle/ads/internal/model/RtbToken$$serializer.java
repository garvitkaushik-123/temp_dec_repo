package com.vungle.ads.internal.model;

import com.ironsource.C3040d4;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.ui.AdActivity;
import io.adn.sdk.internal.domain.constants.AnalyticsConstants;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: RtbToken.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/internal/model/RtbToken.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/internal/model/RtbToken;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes7.dex */
public final class RtbToken$$serializer implements GeneratedSerializer<RtbToken> {
    public static final RtbToken$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        RtbToken$$serializer rtbToken$$serializer = new RtbToken$$serializer();
        INSTANCE = rtbToken$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.internal.model.RtbToken", rtbToken$$serializer, 5);
        pluginGeneratedSerialDescriptor.addElement(C3040d4.h.G, false);
        pluginGeneratedSerialDescriptor.addElement(AnalyticsConstants.SOURCE_USER_TYPE, true);
        pluginGeneratedSerialDescriptor.addElement("ext", true);
        pluginGeneratedSerialDescriptor.addElement(AdActivity.REQUEST_KEY_EXTRA, true);
        pluginGeneratedSerialDescriptor.addElement("ordinal_view", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private RtbToken$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{DeviceNode$$serializer.INSTANCE, BuiltinSerializersKt.getNullable(CommonRequestBody$User$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(CommonRequestBody$RequestExt$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(RtbRequest$$serializer.INSTANCE), IntSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public RtbToken deserialize(Decoder decoder) {
        int i;
        Object obj;
        Object obj2;
        Object obj3;
        int i2;
        Object obj4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        if (beginStructure.decodeSequentially()) {
            obj4 = beginStructure.decodeSerializableElement(descriptor2, 0, DeviceNode$$serializer.INSTANCE, null);
            obj = beginStructure.decodeNullableSerializableElement(descriptor2, 1, CommonRequestBody$User$$serializer.INSTANCE, null);
            obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, CommonRequestBody$RequestExt$$serializer.INSTANCE, null);
            obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, RtbRequest$$serializer.INSTANCE, null);
            i = 31;
            i2 = beginStructure.decodeIntElement(descriptor2, 4);
        } else {
            boolean z = true;
            int i3 = 0;
            Object obj5 = null;
            Object obj6 = null;
            Object obj7 = null;
            Object obj8 = null;
            int i4 = 0;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    obj5 = beginStructure.decodeSerializableElement(descriptor2, 0, DeviceNode$$serializer.INSTANCE, obj5);
                    i4 |= 1;
                } else if (decodeElementIndex == 1) {
                    obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, CommonRequestBody$User$$serializer.INSTANCE, obj6);
                    i4 |= 2;
                } else if (decodeElementIndex == 2) {
                    obj7 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, CommonRequestBody$RequestExt$$serializer.INSTANCE, obj7);
                    i4 |= 4;
                } else if (decodeElementIndex == 3) {
                    obj8 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, RtbRequest$$serializer.INSTANCE, obj8);
                    i4 |= 8;
                } else {
                    if (decodeElementIndex != 4) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    i3 = beginStructure.decodeIntElement(descriptor2, 4);
                    i4 |= 16;
                }
            }
            i = i4;
            obj = obj6;
            obj2 = obj7;
            obj3 = obj8;
            i2 = i3;
            obj4 = obj5;
        }
        beginStructure.endStructure(descriptor2);
        return new RtbToken(i, (DeviceNode) obj4, (CommonRequestBody.User) obj, (CommonRequestBody.RequestExt) obj2, (RtbRequest) obj3, i2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, RtbToken value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        RtbToken.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
