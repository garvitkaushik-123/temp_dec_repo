package com.moloco.sdk.internal.ilrd;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.ilrd.c;
import com.moloco.sdk.internal.services.I;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.UnknownFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.GeneratedSerializer;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.LongSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import kotlinx.serialization.json.Json;

/* loaded from: classes6.dex */
public final class a {
    public static final C0429a g = new C0429a(null);
    public static final int h = 8;
    public static final String i = "IlrdActiveSession";

    /* renamed from: a, reason: collision with root package name */
    public final I f5411a;
    public final Lazy b;
    public final Lazy c;
    public final Lazy d;
    public final AtomicReference<b> e;
    public boolean f;

    /* renamed from: com.moloco.sdk.internal.ilrd.a$a, reason: collision with other inner class name */
    public static final class C0429a {
        public /* synthetic */ C0429a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public C0429a() {
        }
    }

    @Serializable
    public static final class b {
        public static final C0431b Companion = new C0431b(null);
        public static final int g = 0;

        /* renamed from: a, reason: collision with root package name */
        public final long f5412a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        /* renamed from: com.moloco.sdk.internal.ilrd.a$b$a, reason: collision with other inner class name */
        public /* synthetic */ class C0430a implements GeneratedSerializer<b> {

            /* renamed from: a, reason: collision with root package name */
            public static final C0430a f5413a;
            public static final SerialDescriptor b;
            public static final int c;

            static {
                C0430a c0430a = new C0430a();
                f5413a = c0430a;
                c = 8;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ilrd.IlrdActiveSession.ImpressionCounts", c0430a, 6);
                pluginGeneratedSerialDescriptor.addElement("lastEventReceivedTs", false);
                pluginGeneratedSerialDescriptor.addElement("banner", false);
                pluginGeneratedSerialDescriptor.addElement("mrec", false);
                pluginGeneratedSerialDescriptor.addElement("native", false);
                pluginGeneratedSerialDescriptor.addElement("interstitial", false);
                pluginGeneratedSerialDescriptor.addElement("rewarded", false);
                b = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final b deserialize(Decoder decoder) {
                int i;
                int i2;
                int i3;
                int i4;
                int i5;
                int i6;
                long j;
                Intrinsics.checkNotNullParameter(decoder, "decoder");
                SerialDescriptor serialDescriptor = b;
                CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
                if (beginStructure.decodeSequentially()) {
                    long decodeLongElement = beginStructure.decodeLongElement(serialDescriptor, 0);
                    i = beginStructure.decodeIntElement(serialDescriptor, 1);
                    int decodeIntElement = beginStructure.decodeIntElement(serialDescriptor, 2);
                    int decodeIntElement2 = beginStructure.decodeIntElement(serialDescriptor, 3);
                    int decodeIntElement3 = beginStructure.decodeIntElement(serialDescriptor, 4);
                    i2 = beginStructure.decodeIntElement(serialDescriptor, 5);
                    i4 = decodeIntElement2;
                    i3 = decodeIntElement3;
                    i5 = decodeIntElement;
                    i6 = 63;
                    j = decodeLongElement;
                } else {
                    boolean z = true;
                    i = 0;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    long j2 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    while (z) {
                        int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                        switch (decodeElementIndex) {
                            case -1:
                                z = false;
                                continue;
                            case 0:
                                j2 = beginStructure.decodeLongElement(serialDescriptor, 0);
                                i9 |= 1;
                                continue;
                            case 1:
                                i = beginStructure.decodeIntElement(serialDescriptor, 1);
                                i9 |= 2;
                                break;
                            case 2:
                                i8 = beginStructure.decodeIntElement(serialDescriptor, 2);
                                i9 |= 4;
                                break;
                            case 3:
                                i11 = beginStructure.decodeIntElement(serialDescriptor, 3);
                                i9 |= 8;
                                break;
                            case 4:
                                i7 = beginStructure.decodeIntElement(serialDescriptor, 4);
                                i9 |= 16;
                                break;
                            case 5:
                                i10 = beginStructure.decodeIntElement(serialDescriptor, 5);
                                i9 |= 32;
                                break;
                            default:
                                throw new UnknownFieldException(decodeElementIndex);
                        }
                    }
                    i2 = i10;
                    i3 = i7;
                    long j3 = j2;
                    i4 = i11;
                    i5 = i8;
                    i6 = i9;
                    j = j3;
                }
                int i12 = i;
                beginStructure.endStructure(serialDescriptor);
                return new b(i6, j, i12, i5, i4, i3, i2, null);
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                IntSerializer intSerializer = IntSerializer.INSTANCE;
                return new KSerializer[]{LongSerializer.INSTANCE, intSerializer, intSerializer, intSerializer, intSerializer, intSerializer};
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
            public final void serialize(Encoder encoder, b value) {
                Intrinsics.checkNotNullParameter(encoder, "encoder");
                Intrinsics.checkNotNullParameter(value, "value");
                SerialDescriptor serialDescriptor = b;
                CompositeEncoder beginStructure = encoder.beginStructure(serialDescriptor);
                b.a(value, beginStructure, serialDescriptor);
                beginStructure.endStructure(serialDescriptor);
            }
        }

        /* renamed from: com.moloco.sdk.internal.ilrd.a$b$b, reason: collision with other inner class name */
        public static final class C0431b {
            public C0431b() {
            }

            public final KSerializer<b> serializer() {
                return C0430a.f5413a;
            }

            public /* synthetic */ C0431b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ b(int i, long j, int i2, int i3, int i4, int i5, int i6, SerializationConstructorMarker serializationConstructorMarker) {
            if (63 != (i & 63)) {
                PluginExceptionsKt.throwMissingFieldException(i, 63, C0430a.f5413a.getDescriptor());
            }
            this.f5412a = j;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }

        public final long a() {
            return this.f5412a;
        }

        public final int b() {
            return this.b;
        }

        public final int c() {
            return this.c;
        }

        public final int d() {
            return this.d;
        }

        public final int e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f5412a == bVar.f5412a && this.b == bVar.b && this.c == bVar.c && this.d == bVar.d && this.e == bVar.e && this.f == bVar.f;
        }

        public final int f() {
            return this.f;
        }

        public final int g() {
            return this.b;
        }

        public final int h() {
            return this.e;
        }

        public int hashCode() {
            return (((((((((Long.hashCode(this.f5412a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c)) * 31) + Integer.hashCode(this.d)) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f);
        }

        public final long i() {
            return this.f5412a;
        }

        public final int j() {
            return this.c;
        }

        public final int k() {
            return this.d;
        }

        public final int l() {
            return this.f;
        }

        public String toString() {
            return "ImpressionCounts(lastEventReceivedTs=" + this.f5412a + ", banner=" + this.b + ", mrec=" + this.c + ", native=" + this.d + ", interstitial=" + this.e + ", rewarded=" + this.f + ')';
        }

        public b(long j, int i, int i2, int i3, int i4, int i5) {
            this.f5412a = j;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
        }

        public final b a(long j, int i, int i2, int i3, int i4, int i5) {
            return new b(j, i, i2, i3, i4, i5);
        }

        public static /* synthetic */ b a(b bVar, long j, int i, int i2, int i3, int i4, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                j = bVar.f5412a;
            }
            long j2 = j;
            if ((i6 & 2) != 0) {
                i = bVar.b;
            }
            int i7 = i;
            if ((i6 & 4) != 0) {
                i2 = bVar.c;
            }
            int i8 = i2;
            if ((i6 & 8) != 0) {
                i3 = bVar.d;
            }
            int i9 = i3;
            if ((i6 & 16) != 0) {
                i4 = bVar.e;
            }
            int i10 = i4;
            if ((i6 & 32) != 0) {
                i5 = bVar.f;
            }
            return bVar.a(j2, i7, i8, i9, i10, i5);
        }

        @JvmStatic
        public static final /* synthetic */ void a(b bVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.encodeLongElement(serialDescriptor, 0, bVar.f5412a);
            compositeEncoder.encodeIntElement(serialDescriptor, 1, bVar.b);
            compositeEncoder.encodeIntElement(serialDescriptor, 2, bVar.c);
            compositeEncoder.encodeIntElement(serialDescriptor, 3, bVar.d);
            compositeEncoder.encodeIntElement(serialDescriptor, 4, bVar.e);
            compositeEncoder.encodeIntElement(serialDescriptor, 5, bVar.f);
        }
    }

    @Serializable
    public static final class c {
        public static final b Companion = new b(null);

        /* renamed from: a, reason: collision with root package name */
        public final String f5414a;
        public final b b;
        public final boolean c;
        public final long d;

        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
        /* renamed from: com.moloco.sdk.internal.ilrd.a$c$a, reason: collision with other inner class name */
        public /* synthetic */ class C0432a implements GeneratedSerializer<c> {

            /* renamed from: a, reason: collision with root package name */
            public static final C0432a f5415a;
            public static final SerialDescriptor b;
            public static final int c;

            static {
                C0432a c0432a = new C0432a();
                f5415a = c0432a;
                c = 8;
                PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.moloco.sdk.internal.ilrd.IlrdActiveSession.SessionData", c0432a, 4);
                pluginGeneratedSerialDescriptor.addElement(JsonStorageKeyNames.SESSION_ID_KEY, false);
                pluginGeneratedSerialDescriptor.addElement("impressionCounts", false);
                pluginGeneratedSerialDescriptor.addElement("isExpired", false);
                pluginGeneratedSerialDescriptor.addElement("sessionStartTs", false);
                b = pluginGeneratedSerialDescriptor;
            }

            @Override // kotlinx.serialization.DeserializationStrategy
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final c deserialize(Decoder decoder) {
                int i;
                boolean z;
                long j;
                String str;
                b bVar;
                Intrinsics.checkNotNullParameter(decoder, "decoder");
                SerialDescriptor serialDescriptor = b;
                CompositeDecoder beginStructure = decoder.beginStructure(serialDescriptor);
                if (beginStructure.decodeSequentially()) {
                    String decodeStringElement = beginStructure.decodeStringElement(serialDescriptor, 0);
                    b bVar2 = (b) beginStructure.decodeSerializableElement(serialDescriptor, 1, b.C0430a.f5413a, null);
                    str = decodeStringElement;
                    i = 15;
                    z = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                    bVar = bVar2;
                    j = beginStructure.decodeLongElement(serialDescriptor, 3);
                } else {
                    long j2 = 0;
                    boolean z2 = true;
                    int i2 = 0;
                    String str2 = null;
                    b bVar3 = null;
                    boolean z3 = false;
                    while (z2) {
                        int decodeElementIndex = beginStructure.decodeElementIndex(serialDescriptor);
                        if (decodeElementIndex == -1) {
                            z2 = false;
                        } else if (decodeElementIndex == 0) {
                            str2 = beginStructure.decodeStringElement(serialDescriptor, 0);
                            i2 |= 1;
                        } else if (decodeElementIndex == 1) {
                            bVar3 = (b) beginStructure.decodeSerializableElement(serialDescriptor, 1, b.C0430a.f5413a, bVar3);
                            i2 |= 2;
                        } else if (decodeElementIndex == 2) {
                            z3 = beginStructure.decodeBooleanElement(serialDescriptor, 2);
                            i2 |= 4;
                        } else {
                            if (decodeElementIndex != 3) {
                                throw new UnknownFieldException(decodeElementIndex);
                            }
                            j2 = beginStructure.decodeLongElement(serialDescriptor, 3);
                            i2 |= 8;
                        }
                    }
                    i = i2;
                    z = z3;
                    j = j2;
                    str = str2;
                    bVar = bVar3;
                }
                beginStructure.endStructure(serialDescriptor);
                return new c(i, str, bVar, z, j, null);
            }

            @Override // kotlinx.serialization.internal.GeneratedSerializer
            public final KSerializer<?>[] childSerializers() {
                return new KSerializer[]{StringSerializer.INSTANCE, b.C0430a.f5413a, BooleanSerializer.INSTANCE, LongSerializer.INSTANCE};
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
                return C0432a.f5415a;
            }

            public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public /* synthetic */ c(int i, String str, b bVar, boolean z, long j, SerializationConstructorMarker serializationConstructorMarker) {
            if (15 != (i & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i, 15, C0432a.f5415a.getDescriptor());
            }
            this.f5414a = str;
            this.b = bVar;
            this.c = z;
            this.d = j;
        }

        public final String a() {
            return this.f5414a;
        }

        public final b b() {
            return this.b;
        }

        public final boolean c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public final b e() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return Intrinsics.areEqual(this.f5414a, cVar.f5414a) && Intrinsics.areEqual(this.b, cVar.b) && this.c == cVar.c && this.d == cVar.d;
        }

        public final String f() {
            return this.f5414a;
        }

        public final long g() {
            return this.d;
        }

        public final boolean h() {
            return this.c;
        }

        public int hashCode() {
            return (((((this.f5414a.hashCode() * 31) + this.b.hashCode()) * 31) + Boolean.hashCode(this.c)) * 31) + Long.hashCode(this.d);
        }

        public String toString() {
            return "SessionData(sessionId=" + this.f5414a + ", impressionCounts=" + this.b + ", isExpired=" + this.c + ", sessionStartTs=" + this.d + ')';
        }

        public c(String sessionId, b impressionCounts, boolean z, long j) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(impressionCounts, "impressionCounts");
            this.f5414a = sessionId;
            this.b = impressionCounts;
            this.c = z;
            this.d = j;
        }

        public final c a(String sessionId, b impressionCounts, boolean z, long j) {
            Intrinsics.checkNotNullParameter(sessionId, "sessionId");
            Intrinsics.checkNotNullParameter(impressionCounts, "impressionCounts");
            return new c(sessionId, impressionCounts, z, j);
        }

        public static /* synthetic */ c a(c cVar, String str, b bVar, boolean z, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = cVar.f5414a;
            }
            if ((i & 2) != 0) {
                bVar = cVar.b;
            }
            if ((i & 4) != 0) {
                z = cVar.c;
            }
            if ((i & 8) != 0) {
                j = cVar.d;
            }
            boolean z2 = z;
            return cVar.a(str, bVar, z2, j);
        }

        @JvmStatic
        public static final /* synthetic */ void a(c cVar, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
            compositeEncoder.encodeStringElement(serialDescriptor, 0, cVar.f5414a);
            compositeEncoder.encodeSerializableElement(serialDescriptor, 1, b.C0430a.f5413a, cVar.b);
            compositeEncoder.encodeBooleanElement(serialDescriptor, 2, cVar.c);
            compositeEncoder.encodeLongElement(serialDescriptor, 3, cVar.d);
        }
    }

    public a(I timeProvider, final String str) {
        b e;
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        this.f5411a = timeProvider;
        this.b = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.ilrd.a$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.a(a.this);
            }
        });
        this.c = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.ilrd.a$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Long.valueOf(a.b(a.this));
            }
        });
        this.d = LazyKt.lazy(new Function0() { // from class: com.moloco.sdk.internal.ilrd.a$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return a.a(str);
            }
        });
        c c2 = c();
        this.e = new AtomicReference<>((c2 == null || (e = c2.e()) == null) ? new b(-1L, 0, 0, 0, 0, 0) : e);
        c c3 = c();
        this.f = c3 != null ? c3.h() : false;
    }

    public static final String a(a aVar) {
        String f;
        c c2 = aVar.c();
        if (c2 != null && (f = c2.f()) != null) {
            return f;
        }
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "toString(...)");
        return uuid;
    }

    public final b b() {
        b bVar = this.e.get();
        Intrinsics.checkNotNullExpressionValue(bVar, "get(...)");
        return bVar;
    }

    public final c c() {
        return (c) this.d.getValue();
    }

    public final String d() {
        return (String) this.b.getValue();
    }

    public final long e() {
        return ((Number) this.c.getValue()).longValue();
    }

    public final boolean f() {
        return this.f;
    }

    public final String g() {
        return Json.INSTANCE.encodeToString(c.Companion.serializer(), new c(d(), b(), f(), e()));
    }

    public String toString() {
        b b2 = b();
        return "IlrdActiveSession(id=" + d() + ", startTs=" + e() + ", expired=" + f() + ", impressions=" + (b2.g() + b2.j() + b2.k() + b2.h() + b2.l()) + " [banner=" + b2.g() + ", mrec=" + b2.j() + ", native=" + b2.k() + ", interstitial=" + b2.h() + ", rewarded=" + b2.l() + "])";
    }

    public static final c a(String str) {
        if (str != null) {
            try {
                Json.Companion companion = Json.INSTANCE;
                KSerializer<Object> serializer = SerializersKt.serializer(companion.getSerializersModule(), Reflection.typeOf(c.class));
                Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                return (c) companion.decodeFromString(serializer, str);
            } catch (Exception e) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, i, "Error deserializing session data", e, false, 8, null);
            }
        }
        return null;
    }

    public static final long b(a aVar) {
        c c2 = aVar.c();
        return c2 != null ? c2.g() : aVar.f5411a.a();
    }

    public /* synthetic */ a(I i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i2, (i3 & 2) != 0 ? null : str);
    }

    public final void a(c.a ilrdData) {
        Intrinsics.checkNotNullParameter(ilrdData, "ilrdData");
        if (ilrdData instanceof c.a.b) {
            String adFormat = ((c.a.b) ilrdData).b().getAdFormat();
            Intrinsics.checkNotNullExpressionValue(adFormat, "getAdFormat(...)");
            String upperCase = adFormat.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            a(upperCase, "Applovin");
            return;
        }
        if (ilrdData instanceof c.a.C0433a) {
            String adFormat2 = ((c.a.C0433a) ilrdData).b().getAdFormat();
            Intrinsics.checkNotNullExpressionValue(adFormat2, "getAdFormat(...)");
            String upperCase2 = adFormat2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "toUpperCase(...)");
            a(upperCase2, "Ironsource");
            return;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean a(String str, String str2) {
        b a2;
        long a3 = this.f5411a.a();
        b bVar = this.e.get();
        if (StringsKt.contains$default((CharSequence) str, (CharSequence) "BANNER", false, 2, (Object) null)) {
            a2 = b.a(bVar, a3, bVar.g() + 1, 0, 0, 0, 0, 60, null);
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "MREC", false, 2, (Object) null)) {
            a2 = b.a(bVar, a3, 0, bVar.j() + 1, 0, 0, 0, 58, null);
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "NATIVE", false, 2, (Object) null)) {
            a2 = b.a(bVar, a3, 0, 0, bVar.k() + 1, 0, 0, 54, null);
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "INTER", false, 2, (Object) null)) {
            a2 = b.a(bVar, a3, 0, 0, 0, bVar.h() + 1, 0, 46, null);
        } else if (StringsKt.contains$default((CharSequence) str, (CharSequence) "REWARD", false, 2, (Object) null)) {
            a2 = b.a(bVar, a3, 0, 0, 0, 0, bVar.l() + 1, 30, null);
        } else {
            MolocoLogger.warn$default(MolocoLogger.INSTANCE, i, "Unknown ad format for " + str2 + ": " + str, null, false, 12, null);
            return false;
        }
        this.e.set(a2);
        return true;
    }

    public final void a() {
        this.f = true;
    }
}
