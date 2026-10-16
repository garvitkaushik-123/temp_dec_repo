package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.util.reflect.TypeInfo;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialFormat;

/* compiled from: KotlinxSerializationBase.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\u0010\b\u001a\u00060\tj\u0002`\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u0018\u0010\b\u001a\u00060\tj\u0002`\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lio/ktor/serialization/kotlinx/SerializationNegotiationParameters;", "Lio/ktor/serialization/kotlinx/SerializationParameters;", "format", "Lkotlinx/serialization/SerialFormat;", "value", "", "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "contentType", "Lio/ktor/http/ContentType;", "(Lkotlinx/serialization/SerialFormat;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Ljava/nio/charset/Charset;Lio/ktor/http/ContentType;)V", "getCharset", "()Ljava/nio/charset/Charset;", "getContentType", "()Lio/ktor/http/ContentType;", "getFormat", "()Lkotlinx/serialization/SerialFormat;", "getTypeInfo", "()Lio/ktor/util/reflect/TypeInfo;", "getValue", "()Ljava/lang/Object;", "ktor-serialization-kotlinx"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class SerializationNegotiationParameters extends SerializationParameters {
    private final Charset charset;
    private final ContentType contentType;
    private final SerialFormat format;
    private final TypeInfo typeInfo;
    private final Object value;

    @Override // io.ktor.serialization.kotlinx.SerializationParameters
    public SerialFormat getFormat() {
        return this.format;
    }

    @Override // io.ktor.serialization.kotlinx.SerializationParameters
    public Object getValue() {
        return this.value;
    }

    @Override // io.ktor.serialization.kotlinx.SerializationParameters
    public TypeInfo getTypeInfo() {
        return this.typeInfo;
    }

    @Override // io.ktor.serialization.kotlinx.SerializationParameters
    public Charset getCharset() {
        return this.charset;
    }

    public final ContentType getContentType() {
        return this.contentType;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SerializationNegotiationParameters(SerialFormat format, Object obj, TypeInfo typeInfo, Charset charset, ContentType contentType) {
        super(format, obj, typeInfo, charset);
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(typeInfo, "typeInfo");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.format = format;
        this.value = obj;
        this.typeInfo = typeInfo;
        this.charset = charset;
        this.contentType = contentType;
    }
}
