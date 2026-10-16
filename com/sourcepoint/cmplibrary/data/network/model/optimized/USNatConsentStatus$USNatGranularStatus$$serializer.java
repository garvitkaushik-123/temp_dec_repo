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
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus.USNatGranularStatus.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/USNatConsentStatus$USNatGranularStatus;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class USNatConsentStatus$USNatGranularStatus$$serializer implements GeneratedSerializer<USNatConsentStatus.USNatGranularStatus> {
    public static final USNatConsentStatus$USNatGranularStatus$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        USNatConsentStatus$USNatGranularStatus$$serializer uSNatConsentStatus$USNatGranularStatus$$serializer = new USNatConsentStatus$USNatGranularStatus$$serializer();
        INSTANCE = uSNatConsentStatus$USNatGranularStatus$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.USNatConsentStatus.USNatGranularStatus", uSNatConsentStatus$USNatGranularStatus$$serializer, 7);
        pluginGeneratedSerialDescriptor.addElement("sellStatus", false);
        pluginGeneratedSerialDescriptor.addElement("shareStatus", false);
        pluginGeneratedSerialDescriptor.addElement("sensitiveDataStatus", false);
        pluginGeneratedSerialDescriptor.addElement("gpcStatus", false);
        pluginGeneratedSerialDescriptor.addElement("defaultConsent", false);
        pluginGeneratedSerialDescriptor.addElement("previousOptInAll", false);
        pluginGeneratedSerialDescriptor.addElement("purposeConsent", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private USNatConsentStatus$USNatGranularStatus$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public USNatConsentStatus.USNatGranularStatus deserialize(Decoder decoder) {
        String str;
        Boolean bool;
        Boolean bool2;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5;
        Boolean bool6;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 6;
        Boolean bool7 = null;
        if (beginStructure.decodeSequentially()) {
            Boolean bool8 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Boolean bool9 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            Boolean bool10 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, null);
            Boolean bool11 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, null);
            Boolean bool12 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, null);
            Boolean bool13 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, null);
            bool6 = bool8;
            str = (String) beginStructure.decodeNullableSerializableElement(descriptor2, 6, StringSerializer.INSTANCE, null);
            bool = bool13;
            bool3 = bool11;
            bool2 = bool12;
            bool4 = bool10;
            bool5 = bool9;
            i = 127;
        } else {
            boolean z = true;
            int i3 = 0;
            String str2 = null;
            Boolean bool14 = null;
            Boolean bool15 = null;
            Boolean bool16 = null;
            Boolean bool17 = null;
            Boolean bool18 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 6;
                    case 0:
                        bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool7);
                        i3 |= 1;
                        i2 = 6;
                    case 1:
                        bool14 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool14);
                        i3 |= 2;
                        i2 = 6;
                    case 2:
                        bool15 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 2, BooleanSerializer.INSTANCE, bool15);
                        i3 |= 4;
                    case 3:
                        bool16 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, bool16);
                        i3 |= 8;
                    case 4:
                        bool17 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, bool17);
                        i3 |= 16;
                    case 5:
                        bool18 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, bool18);
                        i3 |= 32;
                    case 6:
                        str2 = (String) beginStructure.decodeNullableSerializableElement(descriptor2, i2, StringSerializer.INSTANCE, str2);
                        i3 |= 64;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            str = str2;
            bool = bool18;
            bool2 = bool17;
            bool3 = bool16;
            bool4 = bool15;
            bool5 = bool14;
            bool6 = bool7;
            i = i3;
        }
        beginStructure.endStructure(descriptor2);
        return new USNatConsentStatus.USNatGranularStatus(i, bool6, bool5, bool4, bool3, bool2, bool, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, USNatConsentStatus.USNatGranularStatus value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        USNatConsentStatus.USNatGranularStatus.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
