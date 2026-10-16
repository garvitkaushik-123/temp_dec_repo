package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.converter.GranularStateSerializer;
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

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus.GranularStatus.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatus$GranularStatus;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class ConsentStatus$GranularStatus$$serializer implements GeneratedSerializer<ConsentStatus.GranularStatus> {
    public static final ConsentStatus$GranularStatus$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ConsentStatus$GranularStatus$$serializer consentStatus$GranularStatus$$serializer = new ConsentStatus$GranularStatus$$serializer();
        INSTANCE = consentStatus$GranularStatus$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatus.GranularStatus", consentStatus$GranularStatus$$serializer, 6);
        pluginGeneratedSerialDescriptor.addElement("defaultConsent", false);
        pluginGeneratedSerialDescriptor.addElement("previousOptInAll", false);
        pluginGeneratedSerialDescriptor.addElement("purposeConsent", false);
        pluginGeneratedSerialDescriptor.addElement("purposeLegInt", false);
        pluginGeneratedSerialDescriptor.addElement("vendorConsent", false);
        pluginGeneratedSerialDescriptor.addElement("vendorLegInt", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConsentStatus$GranularStatus$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(BooleanSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GranularStateSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GranularStateSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GranularStateSerializer.INSTANCE), BuiltinSerializersKt.getNullable(GranularStateSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ConsentStatus.GranularStatus deserialize(Decoder decoder) {
        GranularState granularState;
        GranularState granularState2;
        GranularState granularState3;
        GranularState granularState4;
        Boolean bool;
        Boolean bool2;
        int i;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        int i2 = 5;
        Boolean bool3 = null;
        if (beginStructure.decodeSequentially()) {
            Boolean bool4 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, null);
            Boolean bool5 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, null);
            GranularState granularState5 = (GranularState) beginStructure.decodeNullableSerializableElement(descriptor2, 2, GranularStateSerializer.INSTANCE, null);
            GranularState granularState6 = (GranularState) beginStructure.decodeNullableSerializableElement(descriptor2, 3, GranularStateSerializer.INSTANCE, null);
            GranularState granularState7 = (GranularState) beginStructure.decodeNullableSerializableElement(descriptor2, 4, GranularStateSerializer.INSTANCE, null);
            bool = bool4;
            granularState2 = (GranularState) beginStructure.decodeNullableSerializableElement(descriptor2, 5, GranularStateSerializer.INSTANCE, null);
            granularState4 = granularState6;
            granularState = granularState7;
            granularState3 = granularState5;
            bool2 = bool5;
            i = 63;
        } else {
            boolean z = true;
            int i3 = 0;
            Boolean bool6 = null;
            GranularState granularState8 = null;
            GranularState granularState9 = null;
            GranularState granularState10 = null;
            GranularState granularState11 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = 5;
                    case 0:
                        bool3 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 0, BooleanSerializer.INSTANCE, bool3);
                        i3 |= 1;
                        i2 = 5;
                    case 1:
                        bool6 = (Boolean) beginStructure.decodeNullableSerializableElement(descriptor2, 1, BooleanSerializer.INSTANCE, bool6);
                        i3 |= 2;
                    case 2:
                        granularState8 = (GranularState) beginStructure.decodeNullableSerializableElement(descriptor2, 2, GranularStateSerializer.INSTANCE, granularState8);
                        i3 |= 4;
                    case 3:
                        granularState9 = (GranularState) beginStructure.decodeNullableSerializableElement(descriptor2, 3, GranularStateSerializer.INSTANCE, granularState9);
                        i3 |= 8;
                    case 4:
                        granularState10 = (GranularState) beginStructure.decodeNullableSerializableElement(descriptor2, 4, GranularStateSerializer.INSTANCE, granularState10);
                        i3 |= 16;
                    case 5:
                        granularState11 = (GranularState) beginStructure.decodeNullableSerializableElement(descriptor2, i2, GranularStateSerializer.INSTANCE, granularState11);
                        i3 |= 32;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            granularState = granularState10;
            granularState2 = granularState11;
            granularState3 = granularState8;
            granularState4 = granularState9;
            bool = bool3;
            bool2 = bool6;
            i = i3;
        }
        beginStructure.endStructure(descriptor2);
        return new ConsentStatus.GranularStatus(i, bool, bool2, granularState3, granularState4, granularState, granularState2, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ConsentStatus.GranularStatus value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ConsentStatus.GranularStatus.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
