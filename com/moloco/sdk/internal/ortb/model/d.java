package com.moloco.sdk.internal.ortb.model;

import com.moloco.sdk.internal.ortb.model.m;
import com.moloco.sdk.internal.ortb.model.n;
import com.moloco.sdk.internal.ortb.model.p;
import com.moloco.sdk.internal.ortb.model.r;
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
public final class d {
    public static final b Companion = new b(null);
    public static final int f = 0;

    /* renamed from: a, reason: collision with root package name */
    public final p f5447a;
    public final String b;
    public final n c;
    public final r d;
    public final m e;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<d> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5448a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5448a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.BidExt", aVar, 5);
            pluginGeneratedSerialDescriptor.addElement("player", true);
            pluginGeneratedSerialDescriptor.addElement("mtid", true);
            pluginGeneratedSerialDescriptor.addElement("moloco_sdk_configs", true);
            pluginGeneratedSerialDescriptor.addElement("moloco_sdk_events", true);
            pluginGeneratedSerialDescriptor.addElement("moloco_sdk_click_metadata", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final d deserialize(Decoder decoder) {
            int i;
            p pVar;
            String str;
            n nVar;
            r rVar;
            m mVar;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            p pVar2 = null;
            if (beginStructure.decodeSequentially()) {
                p pVar3 = (p) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, p.a.f5469a, null);
                String str2 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, null);
                n nVar2 = (n) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, n.a.f5465a, null);
                pVar = pVar3;
                rVar = (r) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, r.a.f5473a, null);
                mVar = (m) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, m.a.f5463a, null);
                nVar = nVar2;
                str = str2;
                i = 31;
            } else {
                boolean z = true;
                int i2 = 0;
                String str3 = null;
                n nVar3 = null;
                r rVar2 = null;
                m mVar2 = null;
                while (z) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    if (decodeElementIndex == -1) {
                        z = false;
                    } else if (decodeElementIndex == 0) {
                        pVar2 = (p) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, p.a.f5469a, pVar2);
                        i2 |= 1;
                    } else if (decodeElementIndex == 1) {
                        str3 = (String) beginStructure.decodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, str3);
                        i2 |= 2;
                    } else if (decodeElementIndex == 2) {
                        nVar3 = (n) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, n.a.f5465a, nVar3);
                        i2 |= 4;
                    } else if (decodeElementIndex == 3) {
                        rVar2 = (r) beginStructure.decodeNullableSerializableElement(serialDescriptor, 3, r.a.f5473a, rVar2);
                        i2 |= 8;
                    } else {
                        if (decodeElementIndex != 4) {
                            throw new UnknownFieldException(decodeElementIndex);
                        }
                        mVar2 = (m) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, m.a.f5463a, mVar2);
                        i2 |= 16;
                    }
                }
                i = i2;
                pVar = pVar2;
                str = str3;
                nVar = nVar3;
                rVar = rVar2;
                mVar = mVar2;
            }
            beginStructure.endStructure(serialDescriptor);
            return new d(i, pVar, str, nVar, rVar, mVar, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[]{BuiltinSerializersKt.getNullable(p.a.f5469a), BuiltinSerializersKt.getNullable(StringSerializer.INSTANCE), BuiltinSerializersKt.getNullable(n.a.f5465a), BuiltinSerializersKt.getNullable(r.a.f5473a), BuiltinSerializersKt.getNullable(m.a.f5463a)};
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
        public final void serialize(Encoder encoder, d value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            d.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<d> serializer() {
            return a.f5448a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d() {
        this((p) null, (String) null, (n) null, (r) null, (m) null, 31, (DefaultConstructorMarker) null);
    }

    @JvmStatic
    public static final /* synthetic */ void a(d dVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || dVar.f5447a != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, p.a.f5469a, dVar.f5447a);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 1) || dVar.b != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, StringSerializer.INSTANCE, dVar.b);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || dVar.c != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, n.a.f5465a, dVar.c);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 3) || dVar.d != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, r.a.f5473a, dVar.d);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) && dVar.e == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, m.a.f5463a, dVar.e);
    }

    @SerialName("moloco_sdk_configs")
    public static /* synthetic */ void b() {
    }

    @SerialName("moloco_sdk_click_metadata")
    public static /* synthetic */ void d() {
    }

    @SerialName("mtid")
    public static /* synthetic */ void f() {
    }

    @SerialName("player")
    public static /* synthetic */ void h() {
    }

    @SerialName("moloco_sdk_events")
    public static /* synthetic */ void j() {
    }

    public final m c() {
        return this.e;
    }

    public final String e() {
        return this.b;
    }

    public final p g() {
        return this.f5447a;
    }

    public final r i() {
        return this.d;
    }

    public /* synthetic */ d(int i, p pVar, String str, n nVar, r rVar, m mVar, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i & 1) == 0) {
            this.f5447a = null;
        } else {
            this.f5447a = pVar;
        }
        if ((i & 2) == 0) {
            this.b = null;
        } else {
            this.b = str;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = nVar;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = rVar;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = mVar;
        }
    }

    public final n a() {
        return this.c;
    }

    public d(p pVar, String str, n nVar, r rVar, m mVar) {
        this.f5447a = pVar;
        this.b = str;
        this.c = nVar;
        this.d = rVar;
        this.e = mVar;
    }

    public /* synthetic */ d(p pVar, String str, n nVar, r rVar, m mVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : pVar, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : nVar, (i & 8) != 0 ? null : rVar, (i & 16) != 0 ? null : mVar);
    }
}
