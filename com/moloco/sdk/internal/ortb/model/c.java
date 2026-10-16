package com.moloco.sdk.internal.ortb.model;

import com.ironsource.C3207n2;
import com.moloco.sdk.internal.ortb.model.d;
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
import kotlinx.serialization.internal.FloatSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Serializable
/* loaded from: classes6.dex */
public final class c {
    public static final b Companion = new b(null);
    public static final int e = 0;

    /* renamed from: a, reason: collision with root package name */
    public final String f5445a;
    public final float b;
    public final String c;
    public final d d;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<c> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5446a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5446a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.Bid", aVar, 4);
            pluginGeneratedSerialDescriptor.addElement("adm", false);
            pluginGeneratedSerialDescriptor.addElement("price", false);
            pluginGeneratedSerialDescriptor.addElement(C3207n2.y, true);
            pluginGeneratedSerialDescriptor.addElement("ext", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final c deserialize(Decoder decoder) {
            float f;
            int i;
            String str;
            String str2;
            d dVar;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            if (beginStructure.decodeSequentially()) {
                String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
                float decodeFloatElement = beginStructure.decodeFloatElement(serialDescriptor, 1);
                String str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
                str = decodeStringElement;
                dVar = (d) beginStructure.decodeSerializableElement(serialDescriptor, 3, d.a.f5448a, null);
                str2 = str3;
                f = decodeFloatElement;
                i = 15;
            } else {
                float f2 = 0.0f;
                boolean z = true;
                String str4 = null;
                String str5 = null;
                d dVar2 = null;
                int i2 = 0;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex == -1) {
                        z = false;
                    } else if (decodeElementIndex == 0) {
                        str4 = beginStructure.decodeStringElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else if (decodeElementIndex == 1) {
                        f2 = beginStructure.decodeFloatElement(serialDescriptor, 1);
                        i2 |= 2;
                    } else if (decodeElementIndex == 2) {
                        str5 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str5);
                        i2 |= 4;
                    } else {
                        if (decodeElementIndex != 3) {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                        dVar2 = (d) beginStructure.decodeSerializableElement(serialDescriptor, 3, d.a.f5448a, dVar2);
                        i2 |= 8;
                    }
                }
                f = f2;
                i = i2;
                str = str4;
                str2 = str5;
                dVar = dVar2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new c(i, str, f, str2, dVar, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            return new KSerializer[]{stringSerializer, FloatSerializer.INSTANCE, BuiltinSerializersKt.getNullable(stringSerializer), d.a.f5448a};
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
        public final void serialize(Encoder encoder, c value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            c.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<c> serializer() {
            return a.f5446a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ c(int i, String str, float f, String str2, d dVar, SerializationConstructorMarker serializationConstructorMarker) {
        if (11 != (i & 11)) {
            PluginExceptionsKt.throwMissingFieldException(i, 11, a.f5446a.getDescriptor());
        }
        this.f5445a = str;
        this.b = f;
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str2;
        }
        this.d = dVar;
    }

    @JvmStatic
    public static final /* synthetic */ void a(c cVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeStringElement(serialDescriptor, 0, cVar.f5445a);
        compositeEncoder.encodeFloatElement(serialDescriptor, 1, cVar.b);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || cVar.c != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, cVar.c);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, d.a.f5448a, cVar.d);
    }

    @SerialName("adm")
    public static /* synthetic */ void b() {
    }

    @SerialName(C3207n2.y)
    public static /* synthetic */ void d() {
    }

    @SerialName("ext")
    public static /* synthetic */ void f() {
    }

    @SerialName("price")
    public static /* synthetic */ void h() {
    }

    public final String c() {
        return this.c;
    }

    public final d e() {
        return this.d;
    }

    public final float g() {
        return this.b;
    }

    public final String a() {
        return this.f5445a;
    }

    public c(String adm, float f, String str, d ext) {
        Intrinsics.checkNotNullParameter(adm, "adm");
        Intrinsics.checkNotNullParameter(ext, "ext");
        this.f5445a = adm;
        this.b = f;
        this.c = str;
        this.d = ext;
    }

    public /* synthetic */ c(String str, float f, String str2, d dVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, f, (i & 4) != 0 ? null : str2, dVar);
    }
}
