package com.moloco.sdk.internal.ortb.model;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;

/* loaded from: classes6.dex */
public final class h implements KSerializer<Color> {

    /* renamed from: a, reason: collision with root package name */
    public static final h f5453a = new h();
    public static final SerialDescriptor b = SerialDescriptorsKt.PrimitiveSerialDescriptor("Color", PrimitiveKind.STRING.INSTANCE);

    public long a(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return ColorKt.Color(android.graphics.Color.parseColor(decoder.decodeString()));
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public /* bridge */ /* synthetic */ Object deserialize(Decoder decoder) {
        return Color.m4053boximpl(a(decoder));
    }

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return b;
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public /* bridge */ /* synthetic */ void serialize(Encoder encoder, Object obj) {
        a(encoder, ((Color) obj).m4073unboximpl());
    }

    public void a(Encoder encoder, long j) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        throw new NotImplementedError("Color encoding is not supported");
    }
}
