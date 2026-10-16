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
import kotlinx.serialization.builtins.BuiltinSerializersKt;
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
public final class t {
    public static final b Companion = new b(null);
    public static final int h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f5476a;
    public final int b;
    public final int c;
    public final l d;
    public final v e;
    public final long f;
    public final Color g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<t> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5477a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5477a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.SkipClose", aVar, 7);
            pluginGeneratedSerialDescriptor.addElement("delay_seconds", false);
            pluginGeneratedSerialDescriptor.addElement(VastAttributes.PADDING, false);
            pluginGeneratedSerialDescriptor.addElement("control_size", false);
            pluginGeneratedSerialDescriptor.addElement("horizontal_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", false);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final t deserialize(Decoder decoder) {
            Color color;
            Color color2;
            v vVar;
            l lVar;
            UInt uInt;
            UInt uInt2;
            UInt uInt3;
            int i;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 6;
            UInt uInt4 = null;
            if (beginStructure.decodeSequentially()) {
                UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
                UInt uInt5 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 0, uIntSerializer, null);
                UInt uInt6 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 1, uIntSerializer, null);
                UInt uInt7 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 2, uIntSerializer, null);
                l lVar2 = (l) beginStructure.decodeSerializableElement(serialDescriptor, 3, l.a.f5461a, null);
                v vVar2 = (v) beginStructure.decodeSerializableElement(serialDescriptor, 4, v.a.f5481a, null);
                h hVar = h.f5453a;
                Color color3 = (Color) beginStructure.decodeSerializableElement(serialDescriptor, 5, hVar, null);
                uInt = uInt7;
                color = (Color) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, hVar, null);
                color2 = color3;
                lVar = lVar2;
                vVar = vVar2;
                i = 127;
                uInt2 = uInt6;
                uInt3 = uInt5;
            } else {
                boolean z = true;
                int i3 = 0;
                Color color4 = null;
                UInt uInt8 = null;
                UInt uInt9 = null;
                l lVar3 = null;
                v vVar3 = null;
                Color color5 = null;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 6;
                        case 0:
                            uInt4 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 0, UIntSerializer.INSTANCE, uInt4);
                            i3 |= 1;
                            i2 = 6;
                        case 1:
                            uInt8 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 1, UIntSerializer.INSTANCE, uInt8);
                            i3 |= 2;
                            i2 = 6;
                        case 2:
                            uInt9 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, uInt9);
                            i3 |= 4;
                        case 3:
                            lVar3 = (l) beginStructure.decodeSerializableElement(serialDescriptor, 3, l.a.f5461a, lVar3);
                            i3 |= 8;
                        case 4:
                            vVar3 = (v) beginStructure.decodeSerializableElement(serialDescriptor, 4, v.a.f5481a, vVar3);
                            i3 |= 16;
                        case 5:
                            color5 = (Color) beginStructure.decodeSerializableElement(serialDescriptor, 5, h.f5453a, color5);
                            i3 |= 32;
                        case 6:
                            color4 = (Color) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, h.f5453a, color4);
                            i3 |= 64;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                color = color4;
                color2 = color5;
                vVar = vVar3;
                lVar = lVar3;
                uInt = uInt9;
                uInt2 = uInt8;
                uInt3 = uInt4;
                i = i3;
            }
            beginStructure.endStructure(serialDescriptor);
            return new t(i, uInt3, uInt2, uInt, lVar, vVar, color2, color, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            h hVar = h.f5453a;
            KSerializer<?> nullable = BuiltinSerializersKt.getNullable(hVar);
            UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
            return new KSerializer[]{uIntSerializer, uIntSerializer, uIntSerializer, l.a.f5461a, v.a.f5481a, hVar, nullable};
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
        public final void serialize(Encoder encoder, t value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            t.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<t> serializer() {
            return a.f5477a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ t(int i, int i2, int i3, l lVar, v vVar, long j, Color color, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, lVar, vVar, j, color);
    }

    @JvmStatic
    public static final /* synthetic */ void a(t tVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, uIntSerializer, UInt.m10330boximpl(tVar.f5476a));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, uIntSerializer, UInt.m10330boximpl(tVar.b));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, uIntSerializer, UInt.m10330boximpl(tVar.c));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, l.a.f5461a, tVar.d);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 4, v.a.f5481a, tVar.e);
        h hVar = h.f5453a;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 5, hVar, Color.m4053boximpl(tVar.f));
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) && tVar.g == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, hVar, tVar.g);
    }

    @SerialName("background_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void b() {
    }

    @SerialName("control_size")
    public static /* synthetic */ void d() {
    }

    @SerialName("delay_seconds")
    public static /* synthetic */ void f() {
    }

    @SerialName("foreground_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void h() {
    }

    @SerialName("horizontal_alignment")
    public static /* synthetic */ void j() {
    }

    @SerialName(VastAttributes.PADDING)
    public static /* synthetic */ void l() {
    }

    @SerialName("vertical_alignment")
    public static /* synthetic */ void n() {
    }

    public final int c() {
        return this.c;
    }

    public final int e() {
        return this.f5476a;
    }

    public final long g() {
        return this.f;
    }

    public final l i() {
        return this.d;
    }

    public final int k() {
        return this.b;
    }

    public final v m() {
        return this.e;
    }

    public /* synthetic */ t(int i, UInt uInt, UInt uInt2, UInt uInt3, l lVar, v vVar, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, uInt, uInt2, uInt3, lVar, vVar, color, color2, serializationConstructorMarker);
    }

    public final Color a() {
        return this.g;
    }

    public /* synthetic */ t(int i, UInt uInt, UInt uInt2, UInt uInt3, l lVar, v vVar, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i, 63, a.f5477a.getDescriptor());
        }
        this.f5476a = uInt.getData();
        this.b = uInt2.getData();
        this.c = uInt3.getData();
        this.d = lVar;
        this.e = vVar;
        this.f = color.m4073unboximpl();
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = color2;
        }
    }

    public t(int i, int i2, int i3, l horizontalAlignment, v verticalAlignment, long j, Color color) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.f5476a = i;
        this.b = i2;
        this.c = i3;
        this.d = horizontalAlignment;
        this.e = verticalAlignment;
        this.f = j;
        this.g = color;
    }

    public /* synthetic */ t(int i, int i2, int i3, l lVar, v vVar, long j, Color color, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, lVar, vVar, j, (i4 & 64) != 0 ? null : color, null);
    }
}
