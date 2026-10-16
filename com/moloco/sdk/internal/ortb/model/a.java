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
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

@Serializable
/* loaded from: classes6.dex */
public final class a {
    public static final b Companion = new b(null);
    public static final int d = 0;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f5441a;
    public final boolean b;
    public final String c;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    /* renamed from: com.moloco.sdk.internal.ortb.model.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C0437a implements GeneratedSerializer<a> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0437a f5442a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            C0437a c0437a = new C0437a();
            f5442a = c0437a;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.AutoStore", c0437a, 3);
            pluginGeneratedSerialDescriptor.addElement("enabled", false);
            pluginGeneratedSerialDescriptor.addElement("on_skip", true);
            pluginGeneratedSerialDescriptor.addElement("event_link", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final a deserialize(Decoder decoder) {
            boolean z;
            boolean z2;
            int i;
            String str;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            if (beginStructure.decodeSequentially()) {
                z = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                str = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, null);
                z2 = decodeBooleanElement;
                i = 7;
            } else {
                boolean z3 = true;
                z = false;
                int i2 = 0;
                String str2 = null;
                boolean z4 = false;
                while (z3) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex == -1) {
                        z3 = false;
                    } else if (decodeElementIndex == 0) {
                        z = beginStructure.decodeBooleanElement(serialDescriptor, 0);
                        i2 |= 1;
                    } else if (decodeElementIndex == 1) {
                        z4 = beginStructure.decodeBooleanElement(serialDescriptor, 1);
                        i2 |= 2;
                    } else {
                        if (decodeElementIndex != 2) {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                        str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, str2);
                        i2 |= 4;
                    }
                }
                z2 = z4;
                i = i2;
                str = str2;
            }
            boolean z5 = z;
            beginStructure.endStructure(serialDescriptor);
            return new a(i, z5, z2, str, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            KSerializer<?> nullable = BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE);
            BooleanSerializer booleanSerializer = BooleanSerializer.INSTANCE;
            return new KSerializer[]{booleanSerializer, booleanSerializer, nullable};
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
        public final void serialize(Encoder encoder, a value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            a.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<a> serializer() {
            return C0437a.f5442a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ a(int i, boolean z, boolean z2, String str, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, C0437a.f5442a.getDescriptor());
        }
        this.f5441a = z;
        if ((i & 2) == 0) {
            this.b = true;
        } else {
            this.b = z2;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void a(a aVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeBooleanElement(serialDescriptor, 0, aVar.f5441a);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || !aVar.b) {
            compositeEncoder.encodeBooleanElement(serialDescriptor, 1, aVar.b);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) && aVar.c == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, StringSerializer.INSTANCE, aVar.c);
    }

    @SerialName("enabled")
    public static /* synthetic */ void b() {
    }

    @SerialName("event_link")
    public static /* synthetic */ void d() {
    }

    @SerialName("on_skip")
    public static /* synthetic */ void f() {
    }

    public final String c() {
        return this.c;
    }

    public final boolean e() {
        return this.b;
    }

    public final boolean a() {
        return this.f5441a;
    }

    public a(boolean z, boolean z2, String str) {
        this.f5441a = z;
        this.b = z2;
        this.c = str;
    }

    public /* synthetic */ a(boolean z, boolean z2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? null : str);
    }
}
