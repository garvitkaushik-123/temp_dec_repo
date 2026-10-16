package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.inmobi.sdk.InMobiSdk;
import com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg;
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

/* compiled from: MetaDataApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataArg;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class MetaDataArg$$serializer implements GeneratedSerializer<MetaDataArg> {
    public static final MetaDataArg$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        MetaDataArg$$serializer metaDataArg$$serializer = new MetaDataArg$$serializer();
        INSTANCE = metaDataArg$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataArg", metaDataArg$$serializer, 3);
        pluginGeneratedSerialDescriptor.addElement("ccpa", false);
        pluginGeneratedSerialDescriptor.addElement(InMobiSdk.IM_GDPR_CONSENT_GDPR_APPLIES, false);
        pluginGeneratedSerialDescriptor.addElement("usnat", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MetaDataArg$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(MetaDataArg$CcpaArg$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(MetaDataArg$GdprArg$$serializer.INSTANCE), BuiltinSerializersKt.getNullable(MetaDataArg$UsNatArg$$serializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public MetaDataArg deserialize(Decoder decoder) {
        int i;
        MetaDataArg.CcpaArg ccpaArg;
        MetaDataArg.GdprArg gdprArg;
        MetaDataArg.UsNatArg usNatArg;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        MetaDataArg.CcpaArg ccpaArg2 = null;
        if (beginStructure.decodeSequentially()) {
            MetaDataArg.CcpaArg ccpaArg3 = (MetaDataArg.CcpaArg) beginStructure.decodeNullableSerializableElement(descriptor2, 0, MetaDataArg$CcpaArg$$serializer.INSTANCE, null);
            MetaDataArg.GdprArg gdprArg2 = (MetaDataArg.GdprArg) beginStructure.decodeNullableSerializableElement(descriptor2, 1, MetaDataArg$GdprArg$$serializer.INSTANCE, null);
            ccpaArg = ccpaArg3;
            usNatArg = (MetaDataArg.UsNatArg) beginStructure.decodeNullableSerializableElement(descriptor2, 2, MetaDataArg$UsNatArg$$serializer.INSTANCE, null);
            gdprArg = gdprArg2;
            i = 7;
        } else {
            boolean z = true;
            int i2 = 0;
            MetaDataArg.GdprArg gdprArg3 = null;
            MetaDataArg.UsNatArg usNatArg2 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    ccpaArg2 = (MetaDataArg.CcpaArg) beginStructure.decodeNullableSerializableElement(descriptor2, 0, MetaDataArg$CcpaArg$$serializer.INSTANCE, ccpaArg2);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    gdprArg3 = (MetaDataArg.GdprArg) beginStructure.decodeNullableSerializableElement(descriptor2, 1, MetaDataArg$GdprArg$$serializer.INSTANCE, gdprArg3);
                    i2 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    usNatArg2 = (MetaDataArg.UsNatArg) beginStructure.decodeNullableSerializableElement(descriptor2, 2, MetaDataArg$UsNatArg$$serializer.INSTANCE, usNatArg2);
                    i2 |= 4;
                }
            }
            i = i2;
            ccpaArg = ccpaArg2;
            gdprArg = gdprArg3;
            usNatArg = usNatArg2;
        }
        beginStructure.endStructure(descriptor2);
        return new MetaDataArg(i, ccpaArg, gdprArg, usNatArg, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, MetaDataArg value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        MetaDataArg.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
