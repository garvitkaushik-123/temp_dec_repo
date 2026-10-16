package com.moloco.sdk.internal.ortb.model;

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
public final class r {
    public static final b Companion = new b(null);
    public static final int k = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f5472a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final String j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<r> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5473a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5473a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.SdkEvents", aVar, 10);
            pluginGeneratedSerialDescriptor.addElement("on_ad_load_start", true);
            pluginGeneratedSerialDescriptor.addElement("on_ad_load_failed", true);
            pluginGeneratedSerialDescriptor.addElement("on_ad_load_success", true);
            pluginGeneratedSerialDescriptor.addElement("on_ad_show_failed", true);
            pluginGeneratedSerialDescriptor.addElement("on_ad_show_success", true);
            pluginGeneratedSerialDescriptor.addElement("on_ad_clicked", true);
            pluginGeneratedSerialDescriptor.addElement("on_ad_hidden", true);
            pluginGeneratedSerialDescriptor.addElement("on_user_rewarded", true);
            pluginGeneratedSerialDescriptor.addElement("on_rewarded_video_started", true);
            pluginGeneratedSerialDescriptor.addElement("on_rewarded_video_completed", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final r deserialize(Decoder decoder) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            int i;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 9;
            String str11 = null;
            if (beginStructure.decodeSequentially()) {
                StringSerializer stringSerializer = StringSerializer.INSTANCE;
                String str12 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, stringSerializer, null);
                String str13 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, null);
                String str14 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, null);
                String str15 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, null);
                String str16 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, null);
                String str17 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, null);
                String str18 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, null);
                String str19 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, stringSerializer, null);
                String str20 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, stringSerializer, null);
                str6 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, stringSerializer, null);
                str8 = str19;
                str2 = str18;
                str10 = str20;
                str7 = str13;
                str = str16;
                str9 = str14;
                str5 = str15;
                str3 = str12;
                str4 = str17;
                i = 1023;
            } else {
                boolean z = true;
                int i3 = 0;
                String str21 = null;
                String str22 = null;
                String str23 = null;
                String str24 = null;
                String str25 = null;
                str = null;
                String str26 = null;
                String str27 = null;
                String str28 = null;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            z = false;
                            i2 = 9;
                        case 0:
                            str11 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, str11);
                            i3 |= 1;
                            i2 = 9;
                        case 1:
                            str27 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str27);
                            i3 |= 2;
                            i2 = 9;
                        case 2:
                            str28 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str28);
                            i3 |= 4;
                            i2 = 9;
                        case 3:
                            str26 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, str26);
                            i3 |= 8;
                            i2 = 9;
                        case 4:
                            str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, str);
                            i3 |= 16;
                            i2 = 9;
                        case 5:
                            str25 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, str25);
                            i3 |= 32;
                            i2 = 9;
                        case 6:
                            str23 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, str23);
                            i3 |= 64;
                            i2 = 9;
                        case 7:
                            str24 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, str24);
                            i3 |= 128;
                            i2 = 9;
                        case 8:
                            str22 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, str22);
                            i3 |= 256;
                        case 9:
                            str21 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, StringSerializer.INSTANCE, str21);
                            i3 |= 512;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                String str29 = str11;
                str2 = str23;
                str3 = str29;
                String str30 = str26;
                str4 = str25;
                str5 = str30;
                str6 = str21;
                str7 = str27;
                str8 = str24;
                str9 = str28;
                str10 = str22;
                i = i3;
            }
            beginStructure.endStructure(serialDescriptor);
            return new r(i, str3, str7, str9, str5, str, str4, str2, str8, str10, str6, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer), BuiltinSerializersKt.getNullable(stringSerializer)};
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
        public final void serialize(Encoder encoder, r value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            r.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<r> serializer() {
            return a.f5473a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public r() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 1023, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final /* synthetic */ void a(r rVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || rVar.f5472a != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, StringSerializer.INSTANCE, rVar.f5472a);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || rVar.b != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, rVar.b);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || rVar.c != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, rVar.c);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || rVar.d != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, StringSerializer.INSTANCE, rVar.d);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || rVar.e != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, StringSerializer.INSTANCE, rVar.e);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 5) || rVar.f != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, StringSerializer.INSTANCE, rVar.f);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || rVar.g != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, StringSerializer.INSTANCE, rVar.g);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || rVar.h != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, StringSerializer.INSTANCE, rVar.h);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || rVar.i != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, StringSerializer.INSTANCE, rVar.i);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) && rVar.j == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, StringSerializer.INSTANCE, rVar.j);
    }

    @SerialName("on_ad_clicked")
    public static /* synthetic */ void b() {
    }

    @SerialName("on_ad_hidden")
    public static /* synthetic */ void d() {
    }

    @SerialName("on_ad_load_failed")
    public static /* synthetic */ void f() {
    }

    @SerialName("on_ad_load_start")
    public static /* synthetic */ void h() {
    }

    @SerialName("on_ad_load_success")
    public static /* synthetic */ void j() {
    }

    @SerialName("on_ad_show_failed")
    public static /* synthetic */ void l() {
    }

    @SerialName("on_ad_show_success")
    public static /* synthetic */ void n() {
    }

    @SerialName("on_rewarded_video_completed")
    public static /* synthetic */ void p() {
    }

    @SerialName("on_rewarded_video_started")
    public static /* synthetic */ void r() {
    }

    @SerialName("on_user_rewarded")
    public static /* synthetic */ void t() {
    }

    public final String c() {
        return this.g;
    }

    public final String e() {
        return this.b;
    }

    public final String g() {
        return this.f5472a;
    }

    public final String i() {
        return this.c;
    }

    public final String k() {
        return this.d;
    }

    public final String m() {
        return this.e;
    }

    public final String o() {
        return this.j;
    }

    public final String q() {
        return this.i;
    }

    public final String s() {
        return this.h;
    }

    public /* synthetic */ r(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.f5472a = null;
        } else {
            this.f5472a = str;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str2;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str3;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = str4;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = str5;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = str6;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = str7;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = str8;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = str9;
        }
        if ((i & 512) == 0) {
            this.j = null;
        } else {
            this.j = str10;
        }
    }

    public final String a() {
        return this.f;
    }

    public r(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.f5472a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = str7;
        this.h = str8;
        this.i = str9;
        this.j = str10;
    }

    public /* synthetic */ r(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6, (i & 64) != 0 ? null : str7, (i & 128) != 0 ? null : str8, (i & 256) != 0 ? null : str9, (i & 512) != 0 ? null : str10);
    }
}
