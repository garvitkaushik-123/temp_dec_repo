package com.moloco.sdk.internal.ortb.model;

import androidx.compose.ui.graphics.Color;
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
public final class q {
    public static final b Companion = new b(null);
    public static final int e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f5470a;
    public final l b;
    public final v c;
    public final long d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<q> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5471a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5471a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.ProgressBar", aVar, 4);
            pluginGeneratedSerialDescriptor.addElement(VastAttributes.PADDING, false);
            pluginGeneratedSerialDescriptor.addElement("horizontal_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final q deserialize(Decoder decoder) {
            int i;
            UInt uInt;
            l lVar;
            v vVar;
            Color color;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            UInt uInt2 = null;
            if (beginStructure.decodeSequentially()) {
                UInt uInt3 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, null);
                l lVar2 = (l) beginStructure.decodeSerializableElement(serialDescriptor, 1, l.a.f5461a, null);
                v vVar2 = (v) beginStructure.decodeSerializableElement(serialDescriptor, 2, v.a.f5481a, null);
                uInt = uInt3;
                color = (Color) beginStructure.decodeSerializableElement(serialDescriptor, 3, h.f5453a, null);
                vVar = vVar2;
                lVar = lVar2;
                i = 15;
            } else {
                boolean z = true;
                int i2 = 0;
                l lVar3 = null;
                v vVar3 = null;
                Color color2 = null;
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
                    } else if (decodeElementIndex == 2) {
                        vVar3 = (v) beginStructure.decodeSerializableElement(serialDescriptor, 2, v.a.f5481a, vVar3);
                        i2 |= 4;
                    } else {
                        if (decodeElementIndex != 3) {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                        color2 = (Color) beginStructure.decodeSerializableElement(serialDescriptor, 3, h.f5453a, color2);
                        i2 |= 8;
                    }
                }
                i = i2;
                uInt = uInt2;
                lVar = lVar3;
                vVar = vVar3;
                color = color2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new q(i, uInt, lVar, vVar, color, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{UIntSerializer.INSTANCE, l.a.f5461a, v.a.f5481a, h.f5453a};
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
        public final void serialize(Encoder encoder, q value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            q.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<q> serializer() {
            return a.f5471a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ q(int i, l lVar, v vVar, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, lVar, vVar, j);
    }

    @JvmStatic
    public static final /* synthetic */ void a(q qVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, UInt.m10330boximpl(qVar.f5470a));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, l.a.f5461a, qVar.b);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, v.a.f5481a, qVar.c);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, h.f5453a, Color.m4053boximpl(qVar.d));
    }

    @SerialName("foreground_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void b() {
    }

    @SerialName("horizontal_alignment")
    public static /* synthetic */ void d() {
    }

    @SerialName(VastAttributes.PADDING)
    public static /* synthetic */ void f() {
    }

    @SerialName("vertical_alignment")
    public static /* synthetic */ void h() {
    }

    public final l c() {
        return this.b;
    }

    public final int e() {
        return this.f5470a;
    }

    public final v g() {
        return this.c;
    }

    public /* synthetic */ q(int i, UInt uInt, l lVar, v vVar, Color color, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, uInt, lVar, vVar, color, serializationConstructorMarker);
    }

    public final long a() {
        return this.d;
    }

    public /* synthetic */ q(int i, UInt uInt, l lVar, v vVar, Color color, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, a.f5471a.getDescriptor());
        }
        this.f5470a = uInt.getData();
        this.b = lVar;
        this.c = vVar;
        this.d = color.m4073unboximpl();
    }

    public q(int i, l horizontalAlignment, v verticalAlignment, long j) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.f5470a = i;
        this.b = horizontalAlignment;
        this.c = verticalAlignment;
        this.d = j;
    }
}
