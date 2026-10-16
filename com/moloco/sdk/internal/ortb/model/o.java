package com.moloco.sdk.internal.ortb.model;

import androidx.compose.ui.graphics.Color;
import com.mbridge.msdk.foundation.entity.CampaignEx;
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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.UIntSerializer;

@Serializable
/* loaded from: classes6.dex */
public final class o {
    public static final b Companion = new b(null);
    public static final int h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5466a;
    public final int b;
    public final l c;
    public final v d;
    public final long e;
    public final UInt f;
    public final Color g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<o> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5467a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5467a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.Mute", aVar, 7);
            pluginGeneratedSerialDescriptor.addElement(CampaignEx.JSON_NATIVE_VIDEO_MUTE, false);
            pluginGeneratedSerialDescriptor.addElement(VastAttributes.PADDING, false);
            pluginGeneratedSerialDescriptor.addElement("horizontal_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", false);
            pluginGeneratedSerialDescriptor.addElement("control_size", true);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final o deserialize(Decoder decoder) {
            boolean z;
            int i;
            Color color;
            UInt uInt;
            Color color2;
            v vVar;
            l lVar;
            UInt uInt2;
            boolean z2;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 6;
            if (beginStructure.decodeSequentially()) {
                z = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
                UInt uInt3 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 1, uIntSerializer, null);
                l lVar2 = (l) beginStructure.decodeSerializableElement(serialDescriptor, 2, l.a.f5461a, null);
                v vVar2 = (v) beginStructure.decodeSerializableElement(serialDescriptor, 3, v.a.f5481a, null);
                h hVar = h.f5453a;
                Color color3 = (Color) beginStructure.decodeSerializableElement(serialDescriptor, 4, hVar, null);
                UInt uInt4 = (UInt) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, uIntSerializer, null);
                color = (Color) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, hVar, null);
                uInt = uInt4;
                vVar = vVar2;
                color2 = color3;
                lVar = lVar2;
                uInt2 = uInt3;
                i = 127;
            } else {
                boolean z3 = true;
                z = false;
                UInt uInt5 = null;
                l lVar3 = null;
                v vVar3 = null;
                Color color4 = null;
                UInt uInt6 = null;
                i = 0;
                Color color5 = null;
                while (z3) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            z3 = false;
                        case 0:
                            z2 = true;
                            z = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                            i |= 1;
                            i2 = 6;
                        case 1:
                            z2 = true;
                            uInt5 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 1, UIntSerializer.INSTANCE, uInt5);
                            i |= 2;
                            i2 = 6;
                        case 2:
                            lVar3 = (l) beginStructure.decodeSerializableElement(serialDescriptor, 2, l.a.f5461a, lVar3);
                            i |= 4;
                        case 3:
                            vVar3 = (v) beginStructure.decodeSerializableElement(serialDescriptor, 3, v.a.f5481a, vVar3);
                            i |= 8;
                        case 4:
                            color4 = (Color) beginStructure.decodeSerializableElement(serialDescriptor, 4, h.f5453a, color4);
                            i |= 16;
                        case 5:
                            uInt6 = (UInt) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, UIntSerializer.INSTANCE, uInt6);
                            i |= 32;
                        case 6:
                            color5 = (Color) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, h.f5453a, color5);
                            i |= 64;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                color = color5;
                uInt = uInt6;
                color2 = color4;
                vVar = vVar3;
                lVar = lVar3;
                uInt2 = uInt5;
            }
            boolean z4 = z;
            beginStructure.endStructure(serialDescriptor);
            return new o(i, z4, uInt2, lVar, vVar, color2, uInt, color, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
            h hVar = h.f5453a;
            return new KSerializer[]{BooleanSerializer.INSTANCE, uIntSerializer, l.a.f5461a, v.a.f5481a, hVar, BuiltinSerializersKt.getNullable(uIntSerializer), BuiltinSerializersKt.getNullable(hVar)};
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
        public final void serialize(Encoder encoder, o value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            o.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<o> serializer() {
            return a.f5467a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ o(int i, boolean z, UInt uInt, l lVar, v vVar, Color color, UInt uInt2, Color color2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z, uInt, lVar, vVar, color, uInt2, color2, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void a(o oVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeBooleanElement(serialDescriptor, 0, oVar.f5466a);
        UIntSerializer uIntSerializer = UIntSerializer.INSTANCE;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, uIntSerializer, UInt.m10330boximpl(oVar.b));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, l.a.f5461a, oVar.c);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, v.a.f5481a, oVar.d);
        h hVar = h.f5453a;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 4, hVar, Color.m4053boximpl(oVar.e));
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || oVar.f != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, uIntSerializer, oVar.f);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) && oVar.g == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, hVar, oVar.g);
    }

    @SerialName("background_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void b() {
    }

    @SerialName("control_size")
    public static /* synthetic */ void d() {
    }

    @SerialName("foreground_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void f() {
    }

    @SerialName("horizontal_alignment")
    public static /* synthetic */ void h() {
    }

    @SerialName(CampaignEx.JSON_NATIVE_VIDEO_MUTE)
    public static /* synthetic */ void j() {
    }

    @SerialName(VastAttributes.PADDING)
    public static /* synthetic */ void l() {
    }

    @SerialName("vertical_alignment")
    public static /* synthetic */ void n() {
    }

    public final UInt c() {
        return this.f;
    }

    public final long e() {
        return this.e;
    }

    public final l g() {
        return this.c;
    }

    public final boolean i() {
        return this.f5466a;
    }

    public final int k() {
        return this.b;
    }

    public final v m() {
        return this.d;
    }

    public /* synthetic */ o(boolean z, int i, l lVar, v vVar, long j, UInt uInt, Color color, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, lVar, vVar, j, uInt, color);
    }

    public final Color a() {
        return this.g;
    }

    public /* synthetic */ o(int i, boolean z, UInt uInt, l lVar, v vVar, Color color, UInt uInt2, Color color2, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i, 31, a.f5467a.getDescriptor());
        }
        this.f5466a = z;
        this.b = uInt.getData();
        this.c = lVar;
        this.d = vVar;
        this.e = color.m4073unboximpl();
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = uInt2;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = color2;
        }
    }

    public o(boolean z, int i, l horizontalAlignment, v verticalAlignment, long j, UInt uInt, Color color) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.f5466a = z;
        this.b = i;
        this.c = horizontalAlignment;
        this.d = verticalAlignment;
        this.e = j;
        this.f = uInt;
        this.g = color;
    }

    public /* synthetic */ o(boolean z, int i, l lVar, v vVar, long j, UInt uInt, Color color, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, i, lVar, vVar, j, (i2 & 32) != 0 ? null : uInt, (i2 & 64) != 0 ? null : color, null);
    }
}
