package com.sourcepoint.cmplibrary.data.network.model.optimized;

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
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

/* compiled from: MessagesApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/Campaigns.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/Campaigns;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class Campaigns$$serializer implements GeneratedSerializer<Campaigns> {
    public static final Campaigns$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        Campaigns$$serializer campaigns$$serializer = new Campaigns$$serializer();
        INSTANCE = campaigns$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.Campaigns", campaigns$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("CCPA", false);
        pluginGeneratedSerialDescriptor.addElement("GDPR", false);
        pluginGeneratedSerialDescriptor.addElement("usnat", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private Campaigns$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(CCPA$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(GDPR$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(USNatConsentData$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public Campaigns deserialize(Decoder decoder) {
        int i;
        CCPA ccpa;
        GDPR gdpr;
        USNatConsentData uSNatConsentData;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        CCPA ccpa2 = null;
        if (beginStructure.decodeSequentially()) {
            CCPA ccpa3 = (CCPA) beginStructure.decodeNullableSerializableElement(descriptor2, 0, CCPA$$serializer.INSTANCE, null);
            GDPR gdpr2 = (GDPR) beginStructure.decodeNullableSerializableElement(descriptor2, 1, GDPR$$serializer.INSTANCE, null);
            ccpa = ccpa3;
            uSNatConsentData = (USNatConsentData) beginStructure.decodeNullableSerializableElement(descriptor2, 2, USNatConsentData$$serializer.INSTANCE, null);
            gdpr = gdpr2;
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            GDPR gdpr3 = null;
            USNatConsentData uSNatConsentData2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    ccpa2 = (CCPA) beginStructure.decodeNullableSerializableElement(descriptor2, 0, CCPA$$serializer.INSTANCE, ccpa2);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    gdpr3 = (GDPR) beginStructure.decodeNullableSerializableElement(descriptor2, 1, GDPR$$serializer.INSTANCE, gdpr3);
                    i2 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    uSNatConsentData2 = (USNatConsentData) beginStructure.decodeNullableSerializableElement(descriptor2, 2, USNatConsentData$$serializer.INSTANCE, uSNatConsentData2);
                    i2 |= 4;
                }
            }
            i = i2;
            ccpa = ccpa2;
            gdpr = gdpr3;
            uSNatConsentData = uSNatConsentData2;
        }
        beginStructure.endStructure(descriptor2);
        return new Campaigns(i, ccpa, gdpr, uSNatConsentData, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, Campaigns value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        Campaigns.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
