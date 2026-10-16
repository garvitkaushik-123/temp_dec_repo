package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentStatus;
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

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class USNatConsentStatus$$serializer implements GeneratedSerializer<USNatConsentStatus> {
    public static final USNatConsentStatus$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        USNatConsentStatus$$serializer uSNatConsentStatus$$serializer = new USNatConsentStatus$$serializer();
        INSTANCE = uSNatConsentStatus$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentStatus", uSNatConsentStatus$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("rejectedAny", false);
        pluginGeneratedSerialDescriptor.addElement("consentedToAll", false);
        pluginGeneratedSerialDescriptor.addElement("consentedToAny", false);
        pluginGeneratedSerialDescriptor.addElement("granularStatus", false);
        pluginGeneratedSerialDescriptor.addElement("hasConsentData", false);
        pluginGeneratedSerialDescriptor.addElement("vendorListAdditions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private USNatConsentStatus$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(USNatConsentStatus$USNatGranularStatus$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public USNatConsentStatus deserialize(Decoder decoder) {
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        USNatConsentStatus.USNatGranularStatus uSNatGranularStatus;
        Boolean bool4;
        Boolean bool5;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 5;
        Boolean bool6 = null;
        if (beginStructure.decodeSequentially()) {
            Boolean bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Boolean bool8 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            Boolean bool9 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, null);
            USNatConsentStatus.USNatGranularStatus uSNatGranularStatus2 = (USNatConsentStatus.USNatGranularStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 3, USNatConsentStatus$USNatGranularStatus$$serializer.INSTANCE, null);
            Boolean bool10 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, null);
            bool4 = bool7;
            bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, null);
            uSNatGranularStatus = uSNatGranularStatus2;
            bool = bool10;
            bool3 = bool9;
            bool5 = bool8;
            i = 63;
        } else {
            boolean z = true;
            int i3 = 0;
            Boolean bool11 = null;
            Boolean bool12 = null;
            USNatConsentStatus.USNatGranularStatus uSNatGranularStatus3 = null;
            Boolean bool13 = null;
            Boolean bool14 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 5;
                    case 0:
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool6);
                        i3 |= 1;
                        i2 = 5;
                    case 1:
                        bool11 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool11);
                        i3 |= 2;
                    case 2:
                        bool12 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, bool12);
                        i3 |= 4;
                    case 3:
                        uSNatGranularStatus3 = (USNatConsentStatus.USNatGranularStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 3, USNatConsentStatus$USNatGranularStatus$$serializer.INSTANCE, uSNatGranularStatus3);
                        i3 |= 8;
                    case 4:
                        bool13 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, bool13);
                        i3 |= 16;
                    case 5:
                        bool14 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, i2, BooleanSerializer.INSTANCE, bool14);
                        i3 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            bool = bool13;
            bool2 = bool14;
            bool3 = bool12;
            uSNatGranularStatus = uSNatGranularStatus3;
            bool4 = bool6;
            bool5 = bool11;
            i = i3;
        }
        beginStructure.endStructure(descriptor2);
        return new USNatConsentStatus(i, bool4, bool5, bool3, uSNatGranularStatus, bool, bool2, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, USNatConsentStatus value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        USNatConsentStatus.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
