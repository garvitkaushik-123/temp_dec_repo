package com.moloco.sdk.internal.ortb.model;

import com.moloco.sdk.internal.ortb.model.c;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;

@Serializable
/* loaded from: classes6.dex */
public final class s {
    public static final b Companion = new b(null);
    public static final int b = 8;
    public static final KSerializer<Object>[] c = {new ArrayListSerializer(c.a.f5446a)};

    /* renamed from: a, reason: collision with root package name */
    public final List<c> f5474a;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<s> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5475a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5475a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.SeatBid", aVar, 1);
            pluginGeneratedSerialDescriptor.addElement("bid", false);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final s deserialize(Decoder decoder) {
            List list;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            KSerializer[] kSerializerArr = s.c;
            int i = 1;
            SerializationConstructorMarker serializationConstructorMarker = null;
            if (beginStructure.decodeSequentially()) {
                list = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], null);
            } else {
                boolean z = true;
                int i2 = 0;
                List list2 = null;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex == -1) {
                        z = false;
                    } else {
                        if (decodeElementIndex != 0) {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                        list2 = (List) beginStructure.decodeSerializableElement(serialDescriptor, 0, kSerializerArr[0], list2);
                        i2 = 1;
                    }
                }
                list = list2;
                i = i2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new s(i, list, serializationConstructorMarker);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{s.c[0]};
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
        public final void serialize(Encoder encoder, s value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            s.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<s> serializer() {
            return a.f5475a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ s(int i, List list, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, a.f5475a.getDescriptor());
        }
        this.f5474a = list;
    }

    @SerialName("bid")
    public static /* synthetic */ void c() {
    }

    public final List<c> b() {
        return this.f5474a;
    }

    public s(List<c> bid) {
        Intrinsics.checkNotNullParameter(bid, "bid");
        this.f5474a = bid;
    }

    @JvmStatic
    public static final /* synthetic */ void a(s sVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, c[0], sVar.f5474a);
    }
}
