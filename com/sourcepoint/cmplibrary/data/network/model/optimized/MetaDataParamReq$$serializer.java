package com.sourcepoint.cmplibrary.data.network.model.optimized;

import com.ironsource.D5;
import com.ironsource.adapters.inmobi.InMobiAdapter;
import com.sourcepoint.cmplibrary.data.network.util.Env;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: MetaDataApiModel.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataParamReq.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/sourcepoint/cmplibrary/data/network/model/optimized/MetaDataParamReq;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes4.dex */
public final class MetaDataParamReq$$serializer implements GeneratedSerializer<MetaDataParamReq> {
    public static final MetaDataParamReq$$serializer INSTANCE;
    private static final /* synthetic */ PluginGeneratedSerialDescriptor descriptor;

    static {
        MetaDataParamReq$$serializer metaDataParamReq$$serializer = new MetaDataParamReq$$serializer();
        INSTANCE = metaDataParamReq$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.sourcepoint.cmplibrary.data.network.model.optimized.MetaDataParamReq", metaDataParamReq$$serializer, 4);
        pluginGeneratedSerialDescriptor.addElement(D5.o, false);
        pluginGeneratedSerialDescriptor.addElement("propertyId", false);
        pluginGeneratedSerialDescriptor.addElement(InMobiAdapter.ACCOUNT_ID, false);
        pluginGeneratedSerialDescriptor.addElement("metadata", false);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private MetaDataParamReq$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        KSerializer<?>[] kSerializerArr;
        kSerializerArr = MetaDataParamReq.$childSerializers;
        return new KSerializer[]{kSerializerArr[0], LongSerializer.INSTANCE, LongSerializer.INSTANCE, StringSerializer.INSTANCE};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public MetaDataParamReq deserialize(Decoder decoder) {
        KSerializer[] kSerializerArr;
        int i;
        Env env;
        long j;
        long j2;
        String str;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        kSerializerArr = MetaDataParamReq.$childSerializers;
        int i2 = 0;
        Env env2 = null;
        if (beginStructure.decodeSequentially()) {
            Env env3 = (Env) beginStructure.decodeSerializableElement(descriptor2, 0, kSerializerArr[0], null);
            long decodeLongElement = beginStructure.decodeLongElement(descriptor2, 1);
            long decodeLongElement2 = beginStructure.decodeLongElement(descriptor2, 2);
            env = env3;
            str = beginStructure.decodeStringElement(descriptor2, 3);
            i = 15;
            j = decodeLongElement;
            j2 = decodeLongElement2;
        } else {
            long j3 = 0;
            int i3 = 1;
            int i4 = 0;
            String str2 = null;
            long j4 = 0;
            while (i3 != 0) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                int i5 = i2;
                if (decodeElementIndex == -1) {
                    i2 = i5;
                    i3 = i2;
                } else if (decodeElementIndex != 0) {
                    if (decodeElementIndex == 1) {
                        j3 = beginStructure.decodeLongElement(descriptor2, 1);
                        i4 |= 2;
                    } else if (decodeElementIndex == 2) {
                        j4 = beginStructure.decodeLongElement(descriptor2, 2);
                        i4 |= 4;
                    } else {
                        if (decodeElementIndex != 3) {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                        str2 = beginStructure.decodeStringElement(descriptor2, 3);
                        i4 |= 8;
                    }
                    i2 = i5;
                } else {
                    env2 = (Env) beginStructure.decodeSerializableElement(descriptor2, i5, kSerializerArr[i5], env2);
                    i4 |= 1;
                    i2 = i5;
                }
            }
            i = i4;
            env = env2;
            j = j3;
            j2 = j4;
            str = str2;
        }
        beginStructure.endStructure(descriptor2);
        return new MetaDataParamReq(i, env, j, j2, str, null);
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, MetaDataParamReq value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        MetaDataParamReq.write$Self$cmplibrary_release(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
