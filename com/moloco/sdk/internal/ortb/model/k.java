package com.moloco.sdk.internal.ortb.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.UInt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.UIntSerializer;

@Serializable
/* loaded from: classes6.dex */
public final class k {
    public static final b Companion = new b(null);
    public static final int b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final UInt f5458a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<k> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5459a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5459a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.DECSkipClose", aVar, 1);
            pluginGeneratedSerialDescriptor.addElement("delay_seconds", true);
            b = pluginGeneratedSerialDescriptor;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final k deserialize(Decoder decoder) {
            UInt uInt;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            int i = 1;
            SerializationConstructorMarker serializationConstructorMarker = null;
            Object[] objArr = 0;
            if (beginStructure.decodeSequentially()) {
                uInt = (UInt) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, null);
            } else {
                Object[] objArr2 = true;
                int i2 = 0;
                uInt = null;
                while (objArr2 != false) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex == -1) {
                        objArr2 = false;
                    } else {
                        if (decodeElementIndex != 0) {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                        uInt = (UInt) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, uInt);
                        i2 = 1;
                    }
                }
                i = i2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new k(i, uInt, serializationConstructorMarker, objArr == true ? 1 : 0);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(UIntSerializer.INSTANCE)};
        }

        @Override // kotlinx.serialization.KSerializer, kotlinx.serialization.SerializationStrategy, kotlinx.serialization.DeserializationStrategy
        public final SerialDescriptor getDescriptor() {
            return b;
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public KSerializer<?>[] typeParametersSerializers() {
            return GeneratedSerializer.DefaultImpls.typeParametersSerializers(this);
        }

        @Override // kotlinx.serialization.SerializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void serialize(Encoder encoder, k value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            k.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<k> serializer() {
            return a.f5459a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ k(int i, UInt uInt, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, uInt, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void a(k kVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && kVar.f5458a == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, kVar.f5458a);
    }

    @SerialName("delay_seconds")
    public static /* synthetic */ void b() {
    }

    public /* synthetic */ k(UInt uInt, DefaultConstructorMarker defaultConstructorMarker) {
        this(uInt);
    }

    public final UInt a() {
        return this.f5458a;
    }

    public /* synthetic */ k(int i, UInt uInt, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.f5458a = null;
        } else {
            this.f5458a = uInt;
        }
    }

    public k(UInt uInt) {
        this.f5458a = uInt;
    }

    public /* synthetic */ k(UInt uInt, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : uInt, null);
    }
}
