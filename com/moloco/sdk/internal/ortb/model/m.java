package com.moloco.sdk.internal.ortb.model;

import com.moloco.sdk.internal.ortb.model.b;
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

@Serializable
/* loaded from: classes6.dex */
public final class m {
    public static final b Companion = new b(null);
    public static final int b = 0;

    /* renamed from: a, reason: collision with root package name */
    public final com.moloco.sdk.internal.ortb.model.b f5462a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<m> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5463a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5463a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.MolocoSDKClickMetaData", aVar, 1);
            pluginGeneratedSerialDescriptor.addElement("banner", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m deserialize(Decoder decoder) {
            com.moloco.sdk.internal.ortb.model.b bVar;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            int i = 1;
            SerializationConstructorMarker serializationConstructorMarker = null;
            if (beginStructure.decodeSequentially()) {
                bVar = (com.moloco.sdk.internal.ortb.model.b) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, b.a.f5444a, null);
            } else {
                boolean z = true;
                int i2 = 0;
                bVar = null;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex == -1) {
                        z = false;
                    } else {
                        if (decodeElementIndex != 0) {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                        bVar = (com.moloco.sdk.internal.ortb.model.b) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, b.a.f5444a, bVar);
                        i2 = 1;
                    }
                }
                i = i2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new m(i, bVar, serializationConstructorMarker);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(b.a.f5444a)};
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
        public final void serialize(Encoder encoder, m value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            m.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<m> serializer() {
            return a.f5463a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m() {
        this((com.moloco.sdk.internal.ortb.model.b) null, 1, (DefaultConstructorMarker) (0 == true ? 1 : 0));
    }

    @JvmStatic
    public static final /* synthetic */ void a(m mVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) && mVar.f5462a == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, b.a.f5444a, mVar.f5462a);
    }

    @SerialName("banner")
    public static /* synthetic */ void b() {
    }

    public /* synthetic */ m(int i, com.moloco.sdk.internal.ortb.model.b bVar, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.f5462a = null;
        } else {
            this.f5462a = bVar;
        }
    }

    public final com.moloco.sdk.internal.ortb.model.b a() {
        return this.f5462a;
    }

    public m(com.moloco.sdk.internal.ortb.model.b bVar) {
        this.f5462a = bVar;
    }

    public /* synthetic */ m(com.moloco.sdk.internal.ortb.model.b bVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bVar);
    }
}
