package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.inmobi.sdk.InMobiSdk;
import com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusResp;
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

/* compiled from: ConsentStatusApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp.ConsentStatusData.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/ConsentStatusResp$ConsentStatusData;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class ConsentStatusResp$ConsentStatusData$$serializer implements GeneratedSerializer<ConsentStatusResp.ConsentStatusData> {
    public static final ConsentStatusResp$ConsentStatusData$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        ConsentStatusResp$ConsentStatusData$$serializer consentStatusResp$ConsentStatusData$$serializer = new ConsentStatusResp$ConsentStatusData$$serializer();
        INSTANCE = consentStatusResp$ConsentStatusData$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.ConsentStatusResp.ConsentStatusData", consentStatusResp$ConsentStatusData$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("ccpa", false);
        pluginGeneratedSerialDescriptor.addElement(InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, false);
        pluginGeneratedSerialDescriptor.addElement("usnat", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private ConsentStatusResp$ConsentStatusData$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(CcpaCS$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(GdprCS$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(USNatConsentData$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public ConsentStatusResp.ConsentStatusData deserialize(Decoder decoder) {
        int i;
        CcpaCS ccpaCS;
        GdprCS gdprCS;
        USNatConsentData uSNatConsentData;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        CcpaCS ccpaCS2 = null;
        if (beginStructure.decodeSequentially()) {
            CcpaCS ccpaCS3 = (CcpaCS) beginStructure.decodeNullableSerializableElement(descriptor2, 0, CcpaCS$$serializer.INSTANCE, null);
            GdprCS gdprCS2 = (GdprCS) beginStructure.decodeNullableSerializableElement(descriptor2, 1, GdprCS$$serializer.INSTANCE, null);
            ccpaCS = ccpaCS3;
            uSNatConsentData = (USNatConsentData) beginStructure.decodeNullableSerializableElement(descriptor2, 2, USNatConsentData$$serializer.INSTANCE, null);
            gdprCS = gdprCS2;
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            GdprCS gdprCS3 = null;
            USNatConsentData uSNatConsentData2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    ccpaCS2 = (CcpaCS) beginStructure.decodeNullableSerializableElement(descriptor2, 0, CcpaCS$$serializer.INSTANCE, ccpaCS2);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    gdprCS3 = (GdprCS) beginStructure.decodeNullableSerializableElement(descriptor2, 1, GdprCS$$serializer.INSTANCE, gdprCS3);
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
            ccpaCS = ccpaCS2;
            gdprCS = gdprCS3;
            uSNatConsentData = uSNatConsentData2;
        }
        beginStructure.endStructure(descriptor2);
        return new ConsentStatusResp.ConsentStatusData(i, ccpaCS, gdprCS, uSNatConsentData, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, ConsentStatusResp.ConsentStatusData value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        ConsentStatusResp.ConsentStatusData.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
