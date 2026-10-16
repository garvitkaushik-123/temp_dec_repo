package com.moloco.sdk.internal.ortb.model;

import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import com.moloco.sdk.internal.ortb.model.v;
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
public final class v {
    public static final b Companion;

    /* renamed from: a, reason: collision with root package name */
    public static final Lazy<KSerializer<Object>> f5480a;

    @SerialName("top")
    public static final v b = new v("Top", 0);

    @SerialName("center")
    public static final v c = new v(AndroidBridgeConstants.BANNER_POSITION_CENTER, 1);

    @SerialName("bottom")
    public static final v d = new v("Bottom", 2);
    public static final /* synthetic */ v[] e;
    public static final /* synthetic */ EnumEntries f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements GeneratedSerializer<v> {
        public static final SerialDescriptor b;

        /* renamed from: a, reason: collision with root package name */
        public static final a f5481a = new a();
        public static final int c = 8;

        static {
            EnumDescriptor enumDescriptor = new EnumDescriptor("com.moloco.sdk.internal.ortb.model.VerticalAlignment", 3);
            enumDescriptor.addElement("top", false);
            enumDescriptor.addElement("center", false);
            enumDescriptor.addElement("bottom", false);
            b = enumDescriptor;
        }

        @Override // kotlinx.serialization.DeserializationStrategy
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final v deserialize(Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            return v.values()[decoder.decodeEnum(b)];
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
        public final void serialize(Encoder encoder, v value) {
            Intrinsics.checkNotNullParameter(encoder, "encoder");
            Intrinsics.checkNotNullParameter(value, "value");
            encoder.encodeEnum(b, value.ordinal());
        }
    }

    public static final class b {
        public b() {
        }

        public final /* synthetic */ KSerializer a() {
            return (KSerializer) v.f5480a.getValue();
        }

        public final KSerializer<v> serializer() {
            return a();
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        v[] a2 = a();
        e = a2;
        f = EnumEntriesKt.enumEntries(a2);
        Companion = new b(null);
        f5480a = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: com.moloco.sdk.internal.ortb.model.v$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer kSerializer;
                kSerializer = v.a.f5481a;
                return kSerializer;
            }
        });
    }

    public v(String str, int i) {
    }

    public static final /* synthetic */ v[] a() {
        return new v[]{b, c, d};
    }

    public static EnumEntries<v> d() {
        return f;
    }

    public static v valueOf(String str) {
        return (v) Enum.valueOf(v.class, str);
    }

    public static v[] values() {
        return (v[]) e.clone();
    }
}
