package io.ktor.serialization.kotlinx;

import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;

/* compiled from: KotlinxSerializationBase.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0010\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\u0010\u0007\u001a\u00060\bj\u0002`\t¢\u0006\u0002\u0010\nR\u0018\u0010\u0007\u001a\u00060\bj\u0002`\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0001X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lio/ktor/serialization/kotlinx/SerializationParameters;", "", "format", "Lkotlinx/serialization/SerialFormat;", "value", "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Lkotlinx/serialization/SerialFormat;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Ljava/nio/charset/Charset;)V", "getCharset", "()Ljava/nio/charset/Charset;", "getFormat", "()Lkotlinx/serialization/SerialFormat;", "serializer", "Lkotlinx/serialization/KSerializer;", "getSerializer", "()Lkotlinx/serialization/KSerializer;", "setSerializer", "(Lkotlinx/serialization/KSerializer;)V", "getTypeInfo", "()Lio/ktor/util/reflect/TypeInfo;", "getValue", "()Ljava/lang/Object;", "ktor-serialization-kotlinx"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public class SerializationParameters {
    private final Charset charset;
    private final SerialFormat format;
    public KSerializer<?> serializer;
    private final TypeInfo typeInfo;
    private final Object value;

    public SerializationParameters(SerialFormat format, Object obj, TypeInfo typeInfo, Charset charset) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(typeInfo, "typeInfo");
        Intrinsics.checkNotNullParameter(charset, "charset");
        this.format = format;
        this.value = obj;
        this.typeInfo = typeInfo;
        this.charset = charset;
    }

    public SerialFormat getFormat() {
        return this.format;
    }

    public Object getValue() {
        return this.value;
    }

    public TypeInfo getTypeInfo() {
        return this.typeInfo;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public final KSerializer<?> getSerializer() {
        KSerializer<?> kSerializer = this.serializer;
        if (kSerializer != null) {
            return kSerializer;
        }
        Intrinsics.throwUninitializedPropertyAccessException("serializer");
        return null;
    }

    public final void setSerializer(KSerializer<?> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<set-?>");
        this.serializer = kSerializer;
    }
}
