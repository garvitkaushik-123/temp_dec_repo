package com.sourcepoint.cmplibrary.data.network.converter;

import com.sourcepoint.cmplibrary.model.exposed.CcpaStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* compiled from: CcpaStatusSerializer.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/sourcepoint/cmplibrary/data/network/converter/CcpaStatusSerializer;", "Lkotlinx/serialization/KSerializer;", "Lcom/sourcepoint/cmplibrary/model/exposed/CcpaStatus;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "cmplibrary_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CcpaStatusSerializer implements KSerializer<CcpaStatus> {
    public static final CcpaStatusSerializer INSTANCE = new CcpaStatusSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.PrimitiveSerialDescriptor("CcpaStatus", PrimitiveKind.STRING.INSTANCE);

    private CcpaStatusSerializer() {
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public CcpaStatus deserialize(Decoder decoder) {
        CcpaStatus ccpaStatus;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        String decodeString = decoder.decodeString();
        CcpaStatus[] values = CcpaStatus.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                ccpaStatus = null;
                break;
            }
            ccpaStatus = values[i];
            if (Intrinsics.areEqual(ccpaStatus.name(), decodeString)) {
                break;
            }
            i++;
        }
        return ccpaStatus == null ? CcpaStatus.unknown : ccpaStatus;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, CcpaStatus value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        encoder.encodeString(value.name());
    }
}
