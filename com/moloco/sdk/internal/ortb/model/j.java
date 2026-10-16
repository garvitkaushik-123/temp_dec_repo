package com.moloco.sdk.internal.ortb.model;

import com.moloco.sdk.internal.ortb.model.k;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
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
import kotlinx.serialization.internal.StringSerializer;

@Serializable
/* loaded from: classes6.dex */
public final class j {
    public static final b Companion = new b(null);
    public static final int i = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f5456a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final k h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<j> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5457a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5457a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.DEC", aVar, 8);
            pluginGeneratedSerialDescriptor.addElement("app_icon_url", true);
            pluginGeneratedSerialDescriptor.addElement("app_name", true);
            pluginGeneratedSerialDescriptor.addElement("imp_link", true);
            pluginGeneratedSerialDescriptor.addElement("click_through", true);
            pluginGeneratedSerialDescriptor.addElement("click_tracking", true);
            pluginGeneratedSerialDescriptor.addElement("cta_text", true);
            pluginGeneratedSerialDescriptor.addElement("skip_event", true);
            pluginGeneratedSerialDescriptor.addElement("close", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final j deserialize(Decoder decoder) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            k kVar;
            int i;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 7;
            String str8 = null;
            if (beginStructure.decodeSequentially()) {
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                String str9 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
                String str10 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
                String str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
                String str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
                String str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
                String str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
                str6 = str10;
                str2 = str9;
                str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
                kVar = (k) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, k.a.f5459a, null);
                str5 = str14;
                str7 = str12;
                str4 = str13;
                str3 = str11;
                i = 255;
            } else {
                boolean z = true;
                int i3 = 0;
                k kVar2 = null;
                String str15 = null;
                String str16 = null;
                String str17 = null;
                String str18 = null;
                String str19 = null;
                String str20 = null;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 7;
                        case 0:
                            str8 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str8);
                            i3 |= 1;
                            i2 = 7;
                        case 1:
                            str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str17);
                            i3 |= 2;
                            i2 = 7;
                        case 2:
                            str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str18);
                            i3 |= 4;
                            i2 = 7;
                        case 3:
                            str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str19);
                            i3 |= 8;
                            i2 = 7;
                        case 4:
                            str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str20);
                            i3 |= 16;
                        case 5:
                            str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str16);
                            i3 |= 32;
                        case 6:
                            str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str15);
                            i3 |= 64;
                        case 7:
                            kVar2 = (k) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, k.a.f5459a, kVar2);
                            i3 |= 128;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                String str21 = str20;
                str = str15;
                str2 = str8;
                str3 = str18;
                str4 = str21;
                String str22 = str19;
                str5 = str16;
                str6 = str17;
                str7 = str22;
                kVar = kVar2;
                i = i3;
            }
            beginStructure.endStructure(serialDescriptor);
            return new j(i, str2, str6, str3, str7, str4, str5, str, kVar, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(k.a.f5459a)};
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
        public final void serialize(Encoder encoder, j value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            j.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<j> serializer() {
            return a.f5457a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public j() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (k) null, 255, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final /* synthetic */ void a(j jVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || jVar.f5456a != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, jVar.f5456a);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || jVar.b != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, jVar.b);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || jVar.c != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, jVar.c);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || jVar.d != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, jVar.d);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || jVar.e != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, jVar.e);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || jVar.f != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, jVar.f);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || jVar.g != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, jVar.g);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) && jVar.h == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, k.a.f5459a, jVar.h);
    }

    @SerialName("app_icon_url")
    public static /* synthetic */ void b() {
    }

    @SerialName("app_name")
    public static /* synthetic */ void d() {
    }

    @SerialName("close")
    public static /* synthetic */ void f() {
    }

    @SerialName("cta_text")
    public static /* synthetic */ void h() {
    }

    @SerialName("click_tracking")
    public static /* synthetic */ void j() {
    }

    @SerialName("click_through")
    public static /* synthetic */ void l() {
    }

    @SerialName("imp_link")
    public static /* synthetic */ void n() {
    }

    @SerialName("skip_event")
    public static /* synthetic */ void p() {
    }

    public final String c() {
        return this.b;
    }

    public final k e() {
        return this.h;
    }

    public final String g() {
        return this.f;
    }

    public final String i() {
        return this.e;
    }

    public final String k() {
        return this.d;
    }

    public final String m() {
        return this.c;
    }

    public final String o() {
        return this.g;
    }

    public /* synthetic */ j(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, k kVar, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i2 & 1) == 0) {
            this.f5456a = null;
        } else {
            this.f5456a = str;
        }
        if ((i2 & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
        if ((i2 & 4) == 0) {
            this.c = null;
        } else {
            this.c = str3;
        }
        if ((i2 & 8) == 0) {
            this.d = null;
        } else {
            this.d = str4;
        }
        if ((i2 & 16) == 0) {
            this.e = null;
        } else {
            this.e = str5;
        }
        if ((i2 & 32) == 0) {
            this.f = null;
        } else {
            this.f = str6;
        }
        if ((i2 & 64) == 0) {
            this.g = null;
        } else {
            this.g = str7;
        }
        if ((i2 & 128) == 0) {
            this.h = null;
        } else {
            this.h = kVar;
        }
    }

    public final String a() {
        return this.f5456a;
    }

    public j(String str, String str2, String str3, String str4, String str5, String str6, String str7, k kVar) {
        this.f5456a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = kVar;
    }

    public /* synthetic */ j(String str, String str2, String str3, String str4, String str5, String str6, String str7, k kVar, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? null : str7, (i2 & 128) != 0 ? null : kVar);
    }
}
