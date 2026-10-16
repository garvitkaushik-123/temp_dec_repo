package com.moloco.sdk.internal.ortb.model;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.moloco.sdk.internal.ortb.model.a;
import com.moloco.sdk.internal.ortb.model.g;
import com.moloco.sdk.internal.ortb.model.i;
import com.moloco.sdk.internal.ortb.model.j;
import com.moloco.sdk.internal.ortb.model.o;
import com.moloco.sdk.internal.ortb.model.q;
import com.moloco.sdk.internal.ortb.model.t;
import com.moloco.sdk.internal.ortb.model.u;
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

@Serializable
/* loaded from: classes6.dex */
public final class p {
    public static final b Companion = new b(null);
    public static final int k = 0;

    /* renamed from: a, reason: collision with root package name */
    public final t f5468a;
    public final t b;
    public final q c;
    public final o d;
    public final g e;
    public final boolean f;
    public final com.moloco.sdk.internal.ortb.model.a g;
    public final u h;
    public final j i;
    public final i j;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<p> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f5469a;
        public static final SerialDescriptor b;
        public static final int c;

        static {
            a aVar = new a();
            f5469a = aVar;
            c = 8;
            PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ortb.model.Player", aVar, 10);
            pluginGeneratedSerialDescriptor.addElement("skip", true);
            pluginGeneratedSerialDescriptor.addElement("close", false);
            pluginGeneratedSerialDescriptor.addElement("progress_bar", true);
            pluginGeneratedSerialDescriptor.addElement(CampaignEx.JSON_NATIVE_VIDEO_MUTE, false);
            pluginGeneratedSerialDescriptor.addElement("cta", true);
            pluginGeneratedSerialDescriptor.addElement("is_all_area_clickable", false);
            pluginGeneratedSerialDescriptor.addElement("auto_store", true);
            pluginGeneratedSerialDescriptor.addElement("vast_privacy_icon", true);
            pluginGeneratedSerialDescriptor.addElement("dec", true);
            pluginGeneratedSerialDescriptor.addElement("countdown_timer", true);
            b = pluginGeneratedSerialDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final p deserialize(Decoder decoder) {
            g gVar;
            o oVar;
            i iVar;
            t tVar;
            j jVar;
            int i;
            com.moloco.sdk.internal.ortb.model.a aVar;
            t tVar2;
            u uVar;
            q qVar;
            boolean z;
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            SerialDescriptor serialDescriptor = b;
            CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
            int i2 = 9;
            int i3 = 8;
            if (beginStructure.decodeSequentially()) {
                t.a aVar2 = t.a.f5477a;
                t tVar3 = (t) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, aVar2, null);
                t tVar4 = (t) beginStructure.decodeSerializableElement(serialDescriptor, 1, aVar2, null);
                q qVar2 = (q) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, q.a.f5471a, null);
                o oVar2 = (o) beginStructure.decodeSerializableElement(serialDescriptor, 3, o.a.f5467a, null);
                g gVar2 = (g) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, g.a.f5452a, null);
                boolean decodeBooleanElement = beginStructure.decodeBooleanElement(serialDescriptor, 5);
                com.moloco.sdk.internal.ortb.model.a aVar3 = (com.moloco.sdk.internal.ortb.model.a) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, a.C0437a.f5442a, null);
                u uVar2 = (u) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, u.a.f5479a, null);
                j jVar2 = (j) beginStructure.decodeNullableSerializableElement(serialDescriptor, 8, j.a.f5457a, null);
                z = decodeBooleanElement;
                i = 1023;
                gVar = gVar2;
                qVar = qVar2;
                oVar = oVar2;
                tVar2 = tVar3;
                iVar = (i) beginStructure.decodeNullableSerializableElement(serialDescriptor, 9, i.a.f5455a, null);
                uVar = uVar2;
                aVar = aVar3;
                jVar = jVar2;
                tVar = tVar4;
            } else {
                boolean z2 = true;
                boolean z3 = false;
                i iVar2 = null;
                j jVar3 = null;
                com.moloco.sdk.internal.ortb.model.a aVar4 = null;
                u uVar3 = null;
                g gVar3 = null;
                o oVar3 = null;
                t tVar5 = null;
                t tVar6 = null;
                int i4 = 0;
                q qVar3 = null;
                while (z2) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                    switch (decodeElementIndex) {
                        case -1:
                            z2 = false;
                            i3 = 8;
                        case 0:
                            tVar5 = (t) beginStructure.decodeNullableSerializableElement(serialDescriptor, 0, t.a.f5477a, tVar5);
                            i4 |= 1;
                            i2 = 9;
                            i3 = 8;
                        case 1:
                            tVar6 = (t) beginStructure.decodeSerializableElement(serialDescriptor, 1, t.a.f5477a, tVar6);
                            i4 |= 2;
                            i2 = 9;
                            i3 = 8;
                        case 2:
                            qVar3 = (q) beginStructure.decodeNullableSerializableElement(serialDescriptor, 2, q.a.f5471a, qVar3);
                            i4 |= 4;
                            i2 = 9;
                            i3 = 8;
                        case 3:
                            oVar3 = (o) beginStructure.decodeSerializableElement(serialDescriptor, 3, o.a.f5467a, oVar3);
                            i4 |= 8;
                            i2 = 9;
                            i3 = 8;
                        case 4:
                            gVar3 = (g) beginStructure.decodeNullableSerializableElement(serialDescriptor, 4, g.a.f5452a, gVar3);
                            i4 |= 16;
                            i2 = 9;
                            i3 = 8;
                        case 5:
                            z3 = beginStructure.decodeBooleanElement(serialDescriptor, 5);
                            i4 |= 32;
                            i2 = 9;
                        case 6:
                            aVar4 = (com.moloco.sdk.internal.ortb.model.a) beginStructure.decodeNullableSerializableElement(serialDescriptor, 6, a.C0437a.f5442a, aVar4);
                            i4 |= 64;
                            i2 = 9;
                        case 7:
                            uVar3 = (u) beginStructure.decodeNullableSerializableElement(serialDescriptor, 7, u.a.f5479a, uVar3);
                            i4 |= 128;
                            i2 = 9;
                        case 8:
                            jVar3 = (j) beginStructure.decodeNullableSerializableElement(serialDescriptor, i3, j.a.f5457a, jVar3);
                            i4 |= 256;
                        case 9:
                            iVar2 = (i) beginStructure.decodeNullableSerializableElement(serialDescriptor, i2, i.a.f5455a, iVar2);
                            i4 |= 512;
                        default:
                            throw new UnknownFieldException(decodeElementIndex);
                    }
                }
                o oVar4 = oVar3;
                gVar = gVar3;
                oVar = oVar4;
                iVar = iVar2;
                tVar = tVar6;
                jVar = jVar3;
                i = i4;
                aVar = aVar4;
                tVar2 = tVar5;
                uVar = uVar3;
                qVar = qVar3;
                z = z3;
            }
            beginStructure.endStructure(serialDescriptor);
            return new p(i, tVar2, tVar, qVar, oVar, gVar, z, aVar, uVar, jVar, iVar, (SerializationConstructorMarker) null);
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            t.a aVar = t.a.f5477a;
            return new KSerializer[]{BuiltinSerializersKt.getNullable(aVar), aVar, BuiltinSerializersKt.getNullable(q.a.f5471a), o.a.f5467a, BuiltinSerializersKt.getNullable(g.a.f5452a), BooleanSerializer.INSTANCE, BuiltinSerializersKt.getNullable(a.C0437a.f5442a), BuiltinSerializersKt.getNullable(u.a.f5479a), BuiltinSerializersKt.getNullable(j.a.f5457a), BuiltinSerializersKt.getNullable(i.a.f5455a)};
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
        public final void serialize(Encoder encoder, p value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            SerialDescriptor serialDescriptor = b;
            CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
            p.a(value, beginStructure, serialDescriptor);
            beginStructure.endStructure(serialDescriptor);
        }
    }

    public static final class b {
        public b() {
        }

        public final KSerializer<p> serializer() {
            return a.f5469a;
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ p(int i, t tVar, t tVar2, q qVar, o oVar, g gVar, boolean z, com.moloco.sdk.internal.ortb.model.a aVar, u uVar, j jVar, i iVar, SerializationConstructorMarker serializationConstructorMarker) {
        if (42 != (i & 42)) {
            PluginExceptionsKt.throwMissingFieldException(i, 42, a.f5469a.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.f5468a = null;
        } else {
            this.f5468a = tVar;
        }
        this.b = tVar2;
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = qVar;
        }
        this.d = oVar;
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = gVar;
        }
        this.f = z;
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = aVar;
        }
        if ((i & 128) == 0) {
            this.h = null;
        } else {
            this.h = uVar;
        }
        if ((i & 256) == 0) {
            this.i = null;
        } else {
            this.i = jVar;
        }
        if ((i & 512) == 0) {
            this.j = null;
        } else {
            this.j = iVar;
        }
    }

    @JvmStatic
    public static final /* synthetic */ void a(p pVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 0) || pVar.f5468a != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 0, t.a.f5477a, pVar.f5468a);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 1, t.a.f5477a, pVar.b);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 2) || pVar.c != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, q.a.f5471a, pVar.c);
        }
        compositeEncoder.encodeSerializableElement(serialDescriptor, 3, o.a.f5467a, pVar.d);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) || pVar.e != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, g.a.f5452a, pVar.e);
        }
        compositeEncoder.encodeBooleanElement(serialDescriptor, 5, pVar.f);
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 6) || pVar.g != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, a.C0437a.f5442a, pVar.g);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 7) || pVar.h != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 7, u.a.f5479a, pVar.h);
        }
        if (compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 8) || pVar.i != null) {
            compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 8, j.a.f5457a, pVar.i);
        }
        if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 9) && pVar.j == null) {
            return;
        }
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 9, i.a.f5455a, pVar.j);
    }

    @SerialName("auto_store")
    public static /* synthetic */ void b() {
    }

    @SerialName("close")
    public static /* synthetic */ void d() {
    }

    @SerialName("countdown_timer")
    public static /* synthetic */ void f() {
    }

    @SerialName("cta")
    public static /* synthetic */ void h() {
    }

    @SerialName("dec")
    public static /* synthetic */ void j() {
    }

    @SerialName(CampaignEx.JSON_NATIVE_VIDEO_MUTE)
    public static /* synthetic */ void l() {
    }

    @SerialName("progress_bar")
    public static /* synthetic */ void n() {
    }

    @SerialName("skip")
    public static /* synthetic */ void p() {
    }

    @SerialName("vast_privacy_icon")
    public static /* synthetic */ void r() {
    }

    @SerialName("is_all_area_clickable")
    public static /* synthetic */ void t() {
    }

    public final t c() {
        return this.b;
    }

    public final i e() {
        return this.j;
    }

    public final g g() {
        return this.e;
    }

    public final j i() {
        return this.i;
    }

    public final o k() {
        return this.d;
    }

    public final q m() {
        return this.c;
    }

    public final t o() {
        return this.f5468a;
    }

    public final u q() {
        return this.h;
    }

    public final boolean s() {
        return this.f;
    }

    public final com.moloco.sdk.internal.ortb.model.a a() {
        return this.g;
    }

    public p(t tVar, t close, q qVar, o mute, g gVar, boolean z, com.moloco.sdk.internal.ortb.model.a aVar, u uVar, j jVar, i iVar) {
        Intrinsics.checkNotNullParameter(close, "close");
        Intrinsics.checkNotNullParameter(mute, "mute");
        this.f5468a = tVar;
        this.b = close;
        this.c = qVar;
        this.d = mute;
        this.e = gVar;
        this.f = z;
        this.g = aVar;
        this.h = uVar;
        this.i = jVar;
        this.j = iVar;
    }

    public /* synthetic */ p(t tVar, t tVar2, q qVar, o oVar, g gVar, boolean z, com.moloco.sdk.internal.ortb.model.a aVar, u uVar, j jVar, i iVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : tVar, tVar2, (i & 4) != 0 ? null : qVar, oVar, (i & 16) != 0 ? null : gVar, z, (i & 64) != 0 ? null : aVar, (i & 128) != 0 ? null : uVar, (i & 256) != 0 ? null : jVar, (i & 512) != 0 ? null : iVar);
    }
}
