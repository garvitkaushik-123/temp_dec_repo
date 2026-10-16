package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.sourcepoint.cmplibrary.data.network.converter.SpConsentStatusSerializer;
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
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/GoogleConsentMode;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class GoogleConsentMode$$serializer implements GeneratedSerializer<GoogleConsentMode> {
    public static final GoogleConsentMode$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        GoogleConsentMode$$serializer googleConsentMode$$serializer = new GoogleConsentMode$$serializer();
        INSTANCE = googleConsentMode$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.GoogleConsentMode", googleConsentMode$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement("ad_storage", false);
        pluginGeneratedSerialDescriptor.addElement("analytics_storage", false);
        pluginGeneratedSerialDescriptor.addElement("ad_user_data", false);
        pluginGeneratedSerialDescriptor.addElement("ad_personalization", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private GoogleConsentMode$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(SpConsentStatusSerializer.INSTANCE), BuiltinSerializersKt.getNullable(SpConsentStatusSerializer.INSTANCE), BuiltinSerializersKt.getNullable(SpConsentStatusSerializer.INSTANCE), BuiltinSerializersKt.getNullable(SpConsentStatusSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public GoogleConsentMode deserialize(Decoder decoder) {
        int i;
        GCMStatus gCMStatus;
        GCMStatus gCMStatus2;
        GCMStatus gCMStatus3;
        GCMStatus gCMStatus4;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        GCMStatus gCMStatus5 = null;
        if (beginStructure.decodeSequentially()) {
            GCMStatus gCMStatus6 = (GCMStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 0, SpConsentStatusSerializer.INSTANCE, null);
            GCMStatus gCMStatus7 = (GCMStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 1, SpConsentStatusSerializer.INSTANCE, null);
            GCMStatus gCMStatus8 = (GCMStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 2, SpConsentStatusSerializer.INSTANCE, null);
            gCMStatus = gCMStatus6;
            gCMStatus4 = (GCMStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 3, SpConsentStatusSerializer.INSTANCE, null);
            gCMStatus3 = gCMStatus8;
            gCMStatus2 = gCMStatus7;
            i = 15;
        } else {
            boolean z = true;
            int i2 = 0;
            GCMStatus gCMStatus9 = null;
            GCMStatus gCMStatus10 = null;
            GCMStatus gCMStatus11 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                if (decodeElementIndex == -1) {
                    z = false;
                } else if (decodeElementIndex == 0) {
                    gCMStatus5 = (GCMStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 0, SpConsentStatusSerializer.INSTANCE, gCMStatus5);
                    i2 |= 1;
                } else if (decodeElementIndex == 1) {
                    gCMStatus9 = (GCMStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 1, SpConsentStatusSerializer.INSTANCE, gCMStatus9);
                    i2 |= 2;
                } else if (decodeElementIndex == 2) {
                    gCMStatus10 = (GCMStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 2, SpConsentStatusSerializer.INSTANCE, gCMStatus10);
                    i2 |= 4;
                } else {
                    if (decodeElementIndex != 3) {
                        throw new UnknownFieldException(decodeElementIndex);
                    }
                    gCMStatus11 = (GCMStatus) beginStructure.decodeNullableSerializableElement(descriptor2, 3, SpConsentStatusSerializer.INSTANCE, gCMStatus11);
                    i2 |= 8;
                }
            }
            i = i2;
            gCMStatus = gCMStatus5;
            gCMStatus2 = gCMStatus9;
            gCMStatus3 = gCMStatus10;
            gCMStatus4 = gCMStatus11;
        }
        beginStructure.endStructure(descriptor2);
        return new GoogleConsentMode(i, gCMStatus, gCMStatus2, gCMStatus3, gCMStatus4, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, GoogleConsentMode value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        GoogleConsentMode.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
