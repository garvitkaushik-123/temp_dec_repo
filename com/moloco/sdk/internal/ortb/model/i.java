package com.moloco.sdk.internal.ortb.model;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
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
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.UIntSerializer;

@Serializable
/* loaded from: classes6.dex */
public final class i {
    public static final b Companion = new b(null);
    public static final int i = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f5454a;
    public final boolean b;
    public final int c;
    public final Integer d;
    public final l e;
    public final v f;
    public final long g;
    public final long h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<i> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5455a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5455a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.CountDownTimer", aVar, 8);
            pluginGeneratedSerialDescriptor.addElement("custom_timer_desc", true);
            pluginGeneratedSerialDescriptor.addElement("is_default_timer", true);
            pluginGeneratedSerialDescriptor.addElement("control_size", true);
            pluginGeneratedSerialDescriptor.addElement(VastAttributes.PADDING, true);
            pluginGeneratedSerialDescriptor.addElement("horizontal_alignment", true);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", true);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", true);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final i deserialize(Decoder decoder) {
            Color color;
            int i;
            UInt uInt;
            l lVar;
            Color color2;
            String str;
            Integer num;
            v vVar;
            boolean z;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 7;
            int i3 = 6;
            if (beginStructure.decodeSequentially()) {
                String str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, null);
                boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                UInt uInt2 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, null);
                Integer num2 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, null);
                l lVar2 = (l) beginStructure.decodeSerializableElement(serialDescriptor, 4, l.a.f5461a, null);
                v vVar2 = (v) beginStructure.decodeSerializableElement(serialDescriptor, 5, v.a.f5481a, null);
                h hVar = h.f5453a;
                Color color3 = (Color) beginStructure.decodeSerializableElement(serialDescriptor, 6, hVar, null);
                color = (Color) beginStructure.decodeSerializableElement(serialDescriptor, 7, hVar, null);
                color2 = color3;
                vVar = vVar2;
                num = num2;
                lVar = lVar2;
                uInt = uInt2;
                i = 255;
                z = decodeBooleanElement;
                str = str2;
            } else {
                boolean z2 = true;
                boolean z3 = false;
                Color color4 = null;
                Color color5 = null;
                String str3 = null;
                UInt uInt3 = null;
                Integer num3 = null;
                l lVar3 = null;
                int i4 = 0;
                v vVar3 = null;
                while (z2) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            z2 = false;
                            i3 = 6;
                        case 0:
                            str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str3);
                            i4 |= 1;
                            i2 = 7;
                            i3 = 6;
                        case 1:
                            z3 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                            i4 |= 2;
                            i2 = 7;
                        case 2:
                            uInt3 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, uInt3);
                            i4 |= 4;
                            i2 = 7;
                        case 3:
                            num3 = (Integer) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, num3);
                            i4 |= 8;
                            i2 = 7;
                        case 4:
                            lVar3 = (l) beginStructure.decodeSerializableElement(serialDescriptor, 4, l.a.f5461a, lVar3);
                            i4 |= 16;
                        case 5:
                            vVar3 = (v) beginStructure.decodeSerializableElement(serialDescriptor, 5, v.a.f5481a, vVar3);
                            i4 |= 32;
                        case 6:
                            color5 = (Color) beginStructure.decodeSerializableElement(serialDescriptor, i3, h.f5453a, color5);
                            i4 |= 64;
                        case 7:
                            color4 = (Color) beginStructure.decodeSerializableElement(serialDescriptor, i2, h.f5453a, color4);
                            i4 |= 128;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                color = color4;
                i = i4;
                uInt = uInt3;
                lVar = lVar3;
                color2 = color5;
                str = str3;
                num = num3;
                vVar = vVar3;
                z = z3;
            }
            beginStructure.endStructure(serialDescriptor);
            return new i(i, str, z, uInt, num, lVar, vVar, color2, color, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?> nullable = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            KSerializer<?> nullable2 = BuiltinSerializersKt.getNullable(IntSerializer.INSTANCE);
            h hVar = h.f5453a;
            return new KSerializer[]{nullable, BooleanSerializer.INSTANCE, UIntSerializer.INSTANCE, nullable2, l.a.f5461a, v.a.f5481a, hVar, hVar};
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
        public final void serialize(Encoder encoder, i value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            i.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<i> serializer() {
            return a.f5455a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ i(int i2, String str, boolean z, UInt uInt, Integer num, l lVar, v vVar, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, str, z, uInt, num, lVar, vVar, color, color2, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void a(i iVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || iVar.f5454a != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, iVar.f5454a);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || !iVar.b) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 1, iVar.b);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || iVar.c != 30) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, UInt.m10330boximpl(iVar.c));
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || iVar.d != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, IntSerializer.INSTANCE, iVar.d);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || iVar.e != l.f) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 4, l.a.f5461a, iVar.e);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || iVar.f != v.b) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 5, v.a.f5481a, iVar.f);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || !Color.m4064equalsimpl0(iVar.g, ColorKt.Color(android.graphics.Color.parseColor("#FF4285f4")))) {
            compositeEncoder.encodeSerializableElement(serialDescriptor, 6, h.f5453a, Color.m4053boximpl(iVar.g));
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) && Color.m4064equalsimpl0(iVar.h, ColorKt.Color(android.graphics.Color.parseColor("#FFFFFFFF")))) {
            return;
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 7, h.f5453a, Color.m4053boximpl(iVar.h));
    }

    @SerialName("background_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void b() {
    }

    @SerialName("control_size")
    public static /* synthetic */ void d() {
    }

    @SerialName("custom_timer_desc")
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

    @SerialName("is_default_timer")
    public static /* synthetic */ void p() {
    }

    public final int c() {
        return this.c;
    }

    public final String e() {
        return this.f5454a;
    }

    public final long g() {
        return this.g;
    }

    public final l i() {
        return this.e;
    }

    public final Integer k() {
        return this.d;
    }

    public final v m() {
        return this.f;
    }

    public final boolean o() {
        return this.b;
    }

    public /* synthetic */ i(String str, boolean z, int i2, Integer num, l lVar, v vVar, long j, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, i2, num, lVar, vVar, j, j2);
    }

    public /* synthetic */ i(int i2, String str, boolean z, UInt uInt, Integer num, l lVar, v vVar, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker) {
        long m4073unboximpl;
        if ((i2 & 1) == 0) {
            this.f5454a = null;
        } else {
            this.f5454a = str;
        }
        if ((i2 & 2) == 0) {
            this.b = true;
        } else {
            this.b = z;
        }
        this.c = (i2 & 4) == 0 ? 30 : uInt.getData();
        if ((i2 & 8) == 0) {
            this.d = null;
        } else {
            this.d = num;
        }
        if ((i2 & 16) == 0) {
            this.e = l.f;
        } else {
            this.e = lVar;
        }
        if ((i2 & 32) == 0) {
            this.f = v.b;
        } else {
            this.f = vVar;
        }
        if ((i2 & 64) == 0) {
            m4073unboximpl = ColorKt.Color(android.graphics.Color.parseColor("#FF4285f4"));
        } else {
            m4073unboximpl = color.m4073unboximpl();
        }
        this.g = m4073unboximpl;
        this.h = (i2 & 128) == 0 ? ColorKt.Color(android.graphics.Color.parseColor("#FFFFFFFF")) : color2.m4073unboximpl();
    }

    public final long a() {
        return this.h;
    }

    public i(String str, boolean z, int i2, Integer num, l horizontalAlignment, v verticalAlignment, long j, long j2) {
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.f5454a = str;
        this.b = z;
        this.c = i2;
        this.d = num;
        this.e = horizontalAlignment;
        this.f = verticalAlignment;
        this.g = j;
        this.h = j2;
    }

    public /* synthetic */ i(String str, boolean z, int i2, Integer num, l lVar, v vVar, long j, long j2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str, (i3 & 2) != 0 ? true : z, (i3 & 4) != 0 ? 30 : i2, (i3 & 8) != 0 ? null : num, (i3 & 16) != 0 ? l.f : lVar, (i3 & 32) != 0 ? v.b : vVar, (i3 & 64) != 0 ? ColorKt.Color(android.graphics.Color.parseColor("#FF4285f4")) : j, (i3 & 128) != 0 ? ColorKt.Color(android.graphics.Color.parseColor("#FFFFFFFF")) : j2, null);
    }
}
