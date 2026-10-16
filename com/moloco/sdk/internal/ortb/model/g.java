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
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.internal.UIntSerializer;

@Serializable
/* loaded from: classes6.dex */
public final class g {
    public static final b Companion = new b(null);
    public static final int h = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f5451a;
    public final String b;
    public final int c;
    public final l d;
    public final v e;
    public final long f;
    public final Color g;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<g> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5452a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5452a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.CTA", aVar, 7);
            pluginGeneratedSerialDescriptor.addElement("text", false);
            pluginGeneratedSerialDescriptor.addElement(CampaignEx.JSON_KEY_IMAGE_URL, true);
            pluginGeneratedSerialDescriptor.addElement(VastAttributes.PADDING, false);
            pluginGeneratedSerialDescriptor.addElement("horizontal_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("vertical_alignment", false);
            pluginGeneratedSerialDescriptor.addElement("foreground_color", false);
            pluginGeneratedSerialDescriptor.addElement("background_color", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final g deserialize(Decoder decoder) {
            Color color;
            Color color2;
            v vVar;
            l lVar;
            UInt uInt;
            String str;
            String str2;
            int i;
            boolean z;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 6;
            String str3 = null;
            if (beginStructure.decodeSequentially()) {
                String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
                String str4 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
                UInt uInt2 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, null);
                l lVar2 = (l) beginStructure.decodeSerializableElement(serialDescriptor, 3, l.a.f5461a, null);
                v vVar2 = (v) beginStructure.decodeSerializableElement(serialDescriptor, 4, v.a.f5481a, null);
                h hVar = h.f5453a;
                Color color3 = (Color) beginStructure.decodeSerializableElement(serialDescriptor, 5, hVar, null);
                str2 = decodeStringElement;
                color = (Color) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, hVar, null);
                color2 = color3;
                lVar = lVar2;
                vVar = vVar2;
                uInt = uInt2;
                str = str4;
                i = 127;
            } else {
                boolean z2 = true;
                int i3 = 0;
                Color color4 = null;
                String str5 = null;
                UInt uInt3 = null;
                l lVar3 = null;
                v vVar3 = null;
                Color color5 = null;
                while (z2) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            z2 = false;
                        case 0:
                            z = true;
                            str3 = beginStructure.decodeStringElement(serialDescriptor, 0);
                            i3 |= 1;
                            i2 = 6;
                        case 1:
                            z = true;
                            str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str5);
                            i3 |= 2;
                            i2 = 6;
                        case 2:
                            uInt3 = (UInt) beginStructure.decodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, uInt3);
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
                uInt = uInt3;
                str = str5;
                str2 = str3;
                i = i3;
            }
            beginStructure.endStructure(serialDescriptor);
            return new g(i, str2, str, uInt, lVar, vVar, color2, color, null, null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            KSerializer<?> nullable = BuiltinSerializersKt.getNullable(stringSerializer);
            h hVar = h.f5453a;
            return new KSerializer[]{stringSerializer, nullable, UIntSerializer.INSTANCE, l.a.f5461a, v.a.f5481a, hVar, BuiltinSerializersKt.getNullable(hVar)};
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
        public final void serialize(Encoder encoder, g value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            g.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<g> serializer() {
            return a.f5452a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ g(int i, String str, String str2, UInt uInt, l lVar, v vVar, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, uInt, lVar, vVar, color, color2, serializationConstructorMarker);
    }

    @JvmStatic
    public static final /* synthetic */ void a(g gVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, gVar.f5451a);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || gVar.b != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, gVar.b);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 2, UIntSerializer.INSTANCE, UInt.m10330boximpl(gVar.c));
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, l.a.f5461a, gVar.d);
        compositeEncoder.encodeSerializableElement(serialDescriptor, 4, v.a.f5481a, gVar.e);
        h hVar = h.f5453a;
        compositeEncoder.encodeSerializableElement(serialDescriptor, 5, hVar, Color.m4053boximpl(gVar.f));
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) && gVar.g == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, hVar, gVar.g);
    }

    @SerialName("background_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void b() {
    }

    @SerialName("foreground_color")
    @Serializable(with = h.class)
    public static /* synthetic */ void d() {
    }

    @SerialName("horizontal_alignment")
    public static /* synthetic */ void f() {
    }

    @SerialName(CampaignEx.JSON_KEY_IMAGE_URL)
    public static /* synthetic */ void h() {
    }

    @SerialName(VastAttributes.PADDING)
    public static /* synthetic */ void j() {
    }

    @SerialName("text")
    public static /* synthetic */ void l() {
    }

    @SerialName("vertical_alignment")
    public static /* synthetic */ void n() {
    }

    public final long c() {
        return this.f;
    }

    public final l e() {
        return this.d;
    }

    public final String g() {
        return this.b;
    }

    public final int i() {
        return this.c;
    }

    public final String k() {
        return this.f5451a;
    }

    public final v m() {
        return this.e;
    }

    public /* synthetic */ g(String str, String str2, int i, l lVar, v vVar, long j, Color color, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, i, lVar, vVar, j, color);
    }

    public final Color a() {
        return this.g;
    }

    public /* synthetic */ g(int i, String str, String str2, UInt uInt, l lVar, v vVar, Color color, Color color2, SerializationConstructorMarker serializationConstructorMarker) {
        if (61 != (i & 61)) {
            PluginExceptionsKt.throwMissingFieldException(i, 61, a.f5452a.getDescriptor());
        }
        this.f5451a = str;
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
        this.c = uInt.getData();
        this.d = lVar;
        this.e = vVar;
        this.f = color.m4073unboximpl();
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = color2;
        }
    }

    public g(String text, String str, int i, l horizontalAlignment, v verticalAlignment, long j, Color color) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(horizontalAlignment, "horizontalAlignment");
        Intrinsics.checkNotNullParameter(verticalAlignment, "verticalAlignment");
        this.f5451a = text;
        this.b = str;
        this.c = i;
        this.d = horizontalAlignment;
        this.e = verticalAlignment;
        this.f = j;
        this.g = color;
    }

    public /* synthetic */ g(String str, String str2, int i, l lVar, v vVar, long j, Color color, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : str2, i, lVar, vVar, j, (i2 & 64) != 0 ? null : color, null);
    }
}
