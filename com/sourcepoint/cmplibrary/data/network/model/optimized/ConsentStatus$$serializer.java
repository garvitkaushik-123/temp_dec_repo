package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus;
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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class ConsentStatus$$serializer implements GeneratedSerializer<ConsentStatus> {
    public static final ConsentStatus$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ConsentStatus$$serializer consentStatus$$serializer = new ConsentStatus$$serializer();
        INSTANCE = consentStatus$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus", consentStatus$$serializer, 8);
        pluginGeneratedSerialDescriptor.addElement("consentedAll", false);
        pluginGeneratedSerialDescriptor.addElement("consentedToAny", false);
        pluginGeneratedSerialDescriptor.addElement("granularStatus", false);
        pluginGeneratedSerialDescriptor.addElement("hasConsentData", false);
        pluginGeneratedSerialDescriptor.addElement("rejectedAny", false);
        pluginGeneratedSerialDescriptor.addElement("rejectedLI", false);
        pluginGeneratedSerialDescriptor.addElement("legalBasisChanges", true);
        pluginGeneratedSerialDescriptor.addElement("vendorListAdditions", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConsentStatus$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(ConsentStatus$GranularStatus$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ConsentStatus deserialize(Decoder decoder) {
        Boolean bool;
        Boolean bool2;
        ConsentStatus.GranularStatus granularStatus;
        Boolean bool3;
        Boolean bool4;
        Boolean bool5;
        Boolean bool6;
        Boolean bool7;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 7;
        Boolean bool8 = null;
        if (beginStructure.decodeSequentially()) {
            Boolean bool9 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Boolean bool10 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            ConsentStatus.GranularStatus granularStatus2 = (ConsentStatus.GranularStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 2, ConsentStatus$GranularStatus$$serializer.INSTANCE, null);
            Boolean bool11 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, null);
            Boolean bool12 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, null);
            Boolean bool13 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, null);
            Boolean bool14 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 6, BooleanSerializer.INSTANCE, null);
            bool7 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 7, BooleanSerializer.INSTANCE, null);
            bool = bool14;
            bool4 = bool13;
            bool6 = bool11;
            bool3 = bool12;
            granularStatus = granularStatus2;
            i = 255;
            bool5 = bool10;
            bool2 = bool9;
        } else {
            boolean z = true;
            int i3 = 0;
            Boolean bool15 = null;
            Boolean bool16 = null;
            Boolean bool17 = null;
            Boolean bool18 = null;
            ConsentStatus.GranularStatus granularStatus3 = null;
            Boolean bool19 = null;
            Boolean bool20 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 7;
                    case 0:
                        bool8 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool8);
                        i3 |= 1;
                        i2 = 7;
                    case 1:
                        bool18 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool18);
                        i3 |= 2;
                        i2 = 7;
                    case 2:
                        granularStatus3 = (ConsentStatus.GranularStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 2, ConsentStatus$GranularStatus$$serializer.INSTANCE, granularStatus3);
                        i3 |= 4;
                        i2 = 7;
                    case 3:
                        bool19 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 3, BooleanSerializer.INSTANCE, bool19);
                        i3 |= 8;
                        i2 = 7;
                    case 4:
                        bool20 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 4, BooleanSerializer.INSTANCE, bool20);
                        i3 |= 16;
                    case 5:
                        bool17 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 5, BooleanSerializer.INSTANCE, bool17);
                        i3 |= 32;
                    case 6:
                        bool16 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 6, BooleanSerializer.INSTANCE, bool16);
                        i3 |= 64;
                    case 7:
                        bool15 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, i2, BooleanSerializer.INSTANCE, bool15);
                        i3 |= 128;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            Boolean bool21 = bool20;
            bool = bool16;
            bool2 = bool8;
            granularStatus = granularStatus3;
            bool3 = bool21;
            Boolean bool22 = bool19;
            bool4 = bool17;
            bool5 = bool18;
            bool6 = bool22;
            bool7 = bool15;
            i = i3;
        }
        beginStructure.endStructure(descriptor2);
        return new ConsentStatus(i, bool2, bool5, granularStatus, bool6, bool3, bool4, bool, bool7, (SerializationConstructorMarker) null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ConsentStatus value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ConsentStatus.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
