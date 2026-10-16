package com.moloco.sdk.internal.ortb.model;

import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.moloco.sdk.internal.ortb.model.l;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.internal.EnumDescriptor;
import kotlinx.serialization.internal.GeneratedSerializer;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Serializable
/* loaded from: classes6.dex */
public final class l {
    public static final b Companion;

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy<KSerializer<Object>> f5460a;

    @SerialName("start")
    public static final l b = new l("Start", 0);

    @SerialName("center")
    public static final l c = new l(AndroidBridgeConstants.BANNER_POSITION_CENTER, 1);

    @SerialName("end")
    public static final l d = new l("End", 2);

    @SerialName("left")
    public static final l e = new l("Left", 3);

    @SerialName("right")
    public static final l f = new l("Right", 4);
    public static final /* synthetic */ l[] g;
    public static final /* synthetic */ EnumEntries h;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<l> {
        public static final SerialDescriptor b;

        /* renamed from: a, reason: collision with root package name */
        public static final a f5461a = new a();
        public static final int c = 8;

        static {
            EnumDescriptor enumDescriptor = new EnumDescriptor("com.moloco.sdk.internal.ortb.model.HorizontalAlignment", 5);
            enumDescriptor.addElement("start", false);
            enumDescriptor.addElement("center", false);
            enumDescriptor.addElement("end", false);
            enumDescriptor.addElement("left", false);
            enumDescriptor.addElement("right", false);
            b = enumDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final l deserialize(Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            return l.values()[decoder.decodeEnum(b)];
        }

        @Override // kotlinx.serialization.internal.GeneratedSerializer
        public final KSerializer<?>[] childSerializers() {
            return new KSerializer[0];
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
        public final void serialize(Encoder encoder, l value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            encoder.encodeEnum(b, value.ordinal());
        }
    }

    public static final class b {
        public b() {
        }

        public final /* synthetic */ KSerializer a() {
            return (KSerializer) l.f5460a.getValue();
        }

        public final KSerializer<l> serializer() {
            return a();
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        l[] a2 = a();
        g = a2;
        h = EnumEntriesKt.enumEntries(a2);
        Companion = new b(null);
        f5460a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.moloco.sdk.internal.ortb.model.l$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer kSerializer;
                kSerializer = l.a.f5461a;
                return kSerializer;
            }
        });
    }

    public l(String str, int i) {
    }

    public static final /* synthetic */ l[] a() {
        return new l[]{b, c, d, e, f};
    }

    public static EnumEntries<l> d() {
        return h;
    }

    public static l valueOf(String str) {
        return (l) Enum.valueOf(l.class, str);
    }

    public static l[] values() {
        return (l[]) g.clone();
    }
}
