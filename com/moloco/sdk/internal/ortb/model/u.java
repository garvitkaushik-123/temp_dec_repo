package com.moloco.sdk.internal.ortb.model;

import com.moloco.sdk.internal.ortb.model.l;
import com.moloco.sdk.internal.ortb.model.v;
import io.bidmachine.iab.vast.tags.VastAttributes;
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
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.UIntSerializer;

@Serializable
/* loaded from: classes6.dex */
public final class u {
    public static final b Companion = new b(null);
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f5478a;
    public final l b;
    public final v c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<u> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5479a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5479a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.VastPrivacyIcon", aVar, 3);
            pluginGeneratedSerialDescriptor.addElement(VastAttributes.PADDING, false);
            pluginGeneratedSerialDescriptor.addElement("horizontal_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final u deserialize(Decoder decoder) {
            int i;
            UInt uInt;
            l lVar;
            v vVar;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            UInt uInt2 = null;
            if (beginStructure.decodeSequentially()) {
                UInt uInt3 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, null);
                l lVar2 = (l) beginStructure.decodeSerializableElement(serialDescriptor, 1, l.a.f5461a, null);
                uInt = uInt3;
                vVar = (v) beginStructure.decodeSerializableElement(serialDescriptor, 2, v.a.f5481a, null);
                lVar = lVar2;
                i = 7;
            } else {
                boolean z = true;
                int i2 = 0;
                l lVar3 = null;
                v vVar2 = null;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex == -1) {
                        z = false;
                    } else if (decodeElementIndex == 0) {
                        uInt2 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, uInt2);
                        i2 |= 1;
                    } else if (decodeElementIndex == 1) {
                        lVar3 = (l) beginStructure.decodeSerializableElement(serialDescriptor, 1, l.a.f5461a, lVar3);
                        i2 |= 2;
                    } else {
                        if (decodeElementIndex != 2) {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                        vVar2 = (v) beginStructure.decodeSerializableElement(serialDescriptor, 2, v.a.f5481a, vVar2);
                        i2 |= 4;
                    }
                }
                i = i2;
                uInt = uInt2;
                lVar = lVar3;
                vVar = vVar2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new u(i, uInt, lVar, vVar, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{UIntSerializer.INSTANCE, l.a.f5461a, v.a.f5481a};
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
        public final void serialize(Encoder encoder, u value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            u.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<u> serializer() {
            return a.f5479a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ u(int i, l lVar, v vVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, lVar, vVar);
    }

    @JvmStatic
    public static final /* synthetic */ void a(u uVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, UInt.m10330boximpl(uVar.f5478a));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, l.a.f5461a, uVar.b);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, v.a.f5481a, uVar.c);
    }

    @SerialName("horizontal_alignment")
    public static /* synthetic */ void b() {
    }

    @SerialName(VastAttributes.PADDING)
    public static /* synthetic */ void d() {
    }

    @SerialName("vertical_alignment")
    public static /* synthetic */ void f() {
    }

    public final int c() {
        return this.f5478a;
    }

    public final v e() {
        return this.c;
    }

    public /* synthetic */ u(int i, UInt uInt, l lVar, v vVar, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, uInt, lVar, vVar, serializationConstructorMarker);
    }

    public final l a() {
        return this.b;
    }

    public /* synthetic */ u(int i, UInt uInt, l lVar, v vVar, SerializationConstructorMarker serializationConstructorMarker) {
        if (7 != (i & 7)) {
            PluginExceptionsKt.throwMissingFieldException(i, 7, a.f5479a.getDescriptor());
        }
        this.f5478a = uInt.getData();
        this.b = lVar;
        this.c = vVar;
    }

    public u(int i, l horizontalAlignment, v verticalAlignment) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.f5478a = i;
        this.b = horizontalAlignment;
        this.c = verticalAlignment;
    }
}
