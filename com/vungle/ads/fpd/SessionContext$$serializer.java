package com.vungle.ads.fpd;

import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: SessionContext.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\n0\tHÖ\u0001¢\u0006\u0002\u0010\u000bJ\u0011\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u00058VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"com/vungle/ads/fpd/SessionContext.$serializer", "Lkotlinx/serialization/internal/GeneratedSerializer;", "Lcom/vungle/ads/fpd/SessionContext;", "()V", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "childSerializers", "", "Lkotlinx/serialization/KSerializer;", "()[Lkotlinx/serialization/KSerializer;", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "serialize", "", "encoder", "Lkotlinx/serialization/encoding/Encoder;", "value", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
/* loaded from: classes7.dex */
public final class SessionContext$$serializer implements GeneratedSerializer<SessionContext> {
    public static final SessionContext$$serializer INSTANCE;
    public static final /* synthetic */ SerialDescriptor descriptor;

    @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    static {
        SessionContext$$serializer sessionContext$$serializer = new SessionContext$$serializer();
        INSTANCE = sessionContext$$serializer;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.vungle.ads.fpd.SessionContext", sessionContext$$serializer, 12);
        pluginGeneratedSerialDescriptor.addElement("level_percentile", true);
        pluginGeneratedSerialDescriptor.addElement("page", true);
        pluginGeneratedSerialDescriptor.addElement("time_spent", true);
        pluginGeneratedSerialDescriptor.addElement("signup_date", true);
        pluginGeneratedSerialDescriptor.addElement("user_score_percentile", true);
        pluginGeneratedSerialDescriptor.addElement("user_id", true);
        pluginGeneratedSerialDescriptor.addElement("friends", true);
        pluginGeneratedSerialDescriptor.addElement("user_level_percentile", true);
        pluginGeneratedSerialDescriptor.addElement("health_percentile", true);
        pluginGeneratedSerialDescriptor.addElement("session_start_time", true);
        pluginGeneratedSerialDescriptor.addElement("session_duration", true);
        pluginGeneratedSerialDescriptor.addElement("in_game_purchases_usd", true);
        descriptor = pluginGeneratedSerialDescriptor;
    }

    private SessionContext$$serializer() {
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] childSerializers() {
        return new KSerializer[]{BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(new ArrayListSerializer(StringSerializer.INSTANCE)), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE), BuiltinSerializersKt.getNullable(FloatSerializer.INSTANCE)};
    }

    @Override // kotlinx.serialization.DeserializationStrategy
    public SessionContext deserialize(Decoder decoder) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        Object obj6;
        Object obj7;
        Object obj8;
        int i;
        Object obj9;
        Object obj10;
        Object obj11;
        Object obj12;
        Object obj13;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeDecoder beginStructure = decoder.beginStructure(descriptor2);
        Object obj14 = null;
        if (beginStructure.decodeSequentially()) {
            obj8 = beginStructure.decodeNullableSerializableElement(descriptor2, 0, FloatSerializer.INSTANCE, null);
            obj12 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, null);
            obj11 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, null);
            obj10 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, null);
            obj9 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, FloatSerializer.INSTANCE, null);
            obj7 = beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, null);
            obj6 = beginStructure.decodeNullableSerializableElement(descriptor2, 6, new ArrayListSerializer(StringSerializer.INSTANCE), null);
            obj5 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, FloatSerializer.INSTANCE, null);
            obj4 = beginStructure.decodeNullableSerializableElement(descriptor2, 8, FloatSerializer.INSTANCE, null);
            obj3 = beginStructure.decodeNullableSerializableElement(descriptor2, 9, IntSerializer.INSTANCE, null);
            obj2 = beginStructure.decodeNullableSerializableElement(descriptor2, 10, IntSerializer.INSTANCE, null);
            obj = beginStructure.decodeNullableSerializableElement(descriptor2, 11, FloatSerializer.INSTANCE, null);
            i = 4095;
        } else {
            boolean z = true;
            int i2 = 0;
            Object obj15 = null;
            Object obj16 = null;
            Object obj17 = null;
            Object obj18 = null;
            Object obj19 = null;
            Object obj20 = null;
            Object obj21 = null;
            Object obj22 = null;
            Object obj23 = null;
            Object obj24 = null;
            Object obj25 = null;
            while (z) {
                int decodeElementIndex = beginStructure.decodeElementIndex(descriptor2);
                switch (decodeElementIndex) {
                    case -1:
                        z = false;
                        i2 = i2;
                    case 0:
                        obj14 = beginStructure.decodeNullableSerializableElement(descriptor2, 0, FloatSerializer.INSTANCE, obj14);
                        i2 |= 1;
                    case 1:
                        obj13 = obj14;
                        obj25 = beginStructure.decodeNullableSerializableElement(descriptor2, 1, StringSerializer.INSTANCE, obj25);
                        i2 |= 2;
                        obj14 = obj13;
                    case 2:
                        obj13 = obj14;
                        obj24 = beginStructure.decodeNullableSerializableElement(descriptor2, 2, IntSerializer.INSTANCE, obj24);
                        i2 |= 4;
                        obj14 = obj13;
                    case 3:
                        obj13 = obj14;
                        obj23 = beginStructure.decodeNullableSerializableElement(descriptor2, 3, IntSerializer.INSTANCE, obj23);
                        i2 |= 8;
                        obj14 = obj13;
                    case 4:
                        obj13 = obj14;
                        obj20 = beginStructure.decodeNullableSerializableElement(descriptor2, 4, FloatSerializer.INSTANCE, obj20);
                        i2 |= 16;
                        obj14 = obj13;
                    case 5:
                        obj13 = obj14;
                        obj22 = beginStructure.decodeNullableSerializableElement(descriptor2, 5, StringSerializer.INSTANCE, obj22);
                        i2 |= 32;
                        obj14 = obj13;
                    case 6:
                        obj13 = obj14;
                        obj19 = beginStructure.decodeNullableSerializableElement(descriptor2, 6, new ArrayListSerializer(StringSerializer.INSTANCE), obj19);
                        i2 |= 64;
                        obj14 = obj13;
                    case 7:
                        obj13 = obj14;
                        obj18 = beginStructure.decodeNullableSerializableElement(descriptor2, 7, FloatSerializer.INSTANCE, obj18);
                        i2 |= 128;
                        obj14 = obj13;
                    case 8:
                        obj13 = obj14;
                        obj17 = beginStructure.decodeNullableSerializableElement(descriptor2, 8, FloatSerializer.INSTANCE, obj17);
                        i2 |= 256;
                        obj14 = obj13;
                    case 9:
                        obj13 = obj14;
                        obj21 = beginStructure.decodeNullableSerializableElement(descriptor2, 9, IntSerializer.INSTANCE, obj21);
                        i2 |= 512;
                        obj14 = obj13;
                    case 10:
                        obj13 = obj14;
                        obj16 = beginStructure.decodeNullableSerializableElement(descriptor2, 10, IntSerializer.INSTANCE, obj16);
                        i2 |= 1024;
                        obj14 = obj13;
                    case 11:
                        obj15 = beginStructure.decodeNullableSerializableElement(descriptor2, 11, FloatSerializer.INSTANCE, obj15);
                        i2 |= 2048;
                        obj14 = obj14;
                    default:
                        throw new UnknownFieldException(decodeElementIndex);
                }
            }
            int i3 = i2;
            Object obj26 = obj21;
            obj = obj15;
            obj2 = obj16;
            obj3 = obj26;
            Object obj27 = obj18;
            obj4 = obj17;
            obj5 = obj27;
            obj6 = obj19;
            obj7 = obj22;
            obj8 = obj14;
            i = i3;
            obj9 = obj20;
            obj10 = obj23;
            obj11 = obj24;
            obj12 = obj25;
        }
        beginStructure.endStructure(descriptor2);
        return new SessionContext(i, (Float) obj8, (String) obj12, (Integer) obj11, (Integer) obj10, (Float) obj9, (String) obj7, (List) obj6, (Float) obj5, (Float) obj4, (Integer) obj3, (Integer) obj2, (Float) obj, null);
    }

    @Override // kotlinx.serialization.SerializationStrategy
    public void serialize(Encoder encoder, SessionContext value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor2 = getDescriptor();
        CompositeEncoder beginStructure = encoder.beginStructure(descriptor2);
        SessionContext.write$Self(value, beginStructure, descriptor2);
        beginStructure.endStructure(descriptor2);
    }

    @Override // kotlinx.serialization.internal.GeneratedSerializer
    public KSerializer<?>[] typeParametersSerializers() {
        return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
    }
}
