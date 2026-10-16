package io.ktor.serialization.kotlinx;

import io.ktor.http.ContentType;
import io.ktor.http.ContentTypesKt;
import io.ktor.http.content.ByteArrayContent;
import io.ktor.http.content.OutgoingContent;
import io.ktor.http.content.TextContent;
import io.ktor.serialization.ContentConverter;
import io.ktor.serialization.JsonConvertException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.InputKt;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.StringFormat;

/* compiled from: KotlinxSerializationConverter.kt */
@Metadata(d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J/\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J5\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\tH\u0097@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J:\u0010\u0018\u001a\u00020\u00192\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0002J7\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"Lio/ktor/serialization/kotlinx/KotlinxSerializationConverter;", "Lio/ktor/serialization/ContentConverter;", "format", "Lkotlinx/serialization/SerialFormat;", "(Lkotlinx/serialization/SerialFormat;)V", "serializationBase", "io/ktor/serialization/kotlinx/KotlinxSerializationConverter$serializationBase$1", "Lio/ktor/serialization/kotlinx/KotlinxSerializationConverter$serializationBase$1;", "deserialize", "", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "content", "Lio/ktor/utils/io/ByteReadChannel;", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serialize", "Lio/ktor/http/content/OutgoingContent;", "contentType", "Lio/ktor/http/ContentType;", "value", "(Lio/ktor/http/ContentType;Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "serializeContent", "Lio/ktor/http/content/OutgoingContent$ByteArrayContent;", "serializer", "Lkotlinx/serialization/KSerializer;", "serializeNullable", "ktor-serialization-kotlinx"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class KotlinxSerializationConverter implements ContentConverter {
    private final SerialFormat format;
    private final KotlinxSerializationConverter$serializationBase$1 serializationBase;

    /* JADX WARN: Type inference failed for: r0v2, types: [io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializationBase$1] */
    public KotlinxSerializationConverter(final SerialFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        if (!(format instanceof BinaryFormat) && !(format instanceof StringFormat)) {
            throw new IllegalArgumentException(("Only binary and string formats are supported, " + format + " is not supported.").toString());
        }
        this.serializationBase = new KotlinxSerializationBase<OutgoingContent.ByteArrayContent>(format) { // from class: io.ktor.serialization.kotlinx.KotlinxSerializationConverter$serializationBase$1
            @Override // io.ktor.serialization.kotlinx.KotlinxSerializationBase
            public Object serializeContent$ktor_serialization_kotlinx(SerializationParameters serializationParameters, Continuation<? super OutgoingContent.ByteArrayContent> continuation) {
                OutgoingContent.ByteArrayContent serializeContent;
                if (serializationParameters instanceof SerializationNegotiationParameters) {
                    serializeContent = KotlinxSerializationConverter.this.serializeContent(serializationParameters.getSerializer(), serializationParameters.getFormat(), serializationParameters.getValue(), ((SerializationNegotiationParameters) serializationParameters).getContentType(), serializationParameters.getCharset());
                    return serializeContent;
                }
                throw new IllegalStateException(("parameters type is " + Reflection.getOrCreateKotlinClass(serializationParameters.getClass()).getSimpleName() + ", but expected " + Reflection.getOrCreateKotlinClass(SerializationNegotiationParameters.class).getSimpleName()).toString());
            }
        };
    }

    @Override // io.ktor.serialization.ContentConverter
    @Deprecated(level = DeprecationLevel.WARNING, message = "Please override and use serializeNullable instead", replaceWith = @ReplaceWith(expression = "serializeNullable(charset, typeInfo, contentType, value)", imports = {}))
    public Object serialize(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super OutgoingContent> continuation) {
        return serializeNullable(contentType, charset, typeInfo, obj, continuation);
    }

    @Override // io.ktor.serialization.ContentConverter
    public Object serializeNullable(ContentType contentType, Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super OutgoingContent> continuation) {
        return serialize$ktor_serialization_kotlinx(new SerializationNegotiationParameters(this.format, obj, typeInfo, charset, contentType), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070 A[Catch: all -> 0x00af, TryCatch #0 {all -> 0x00af, blocks: (B:12:0x0068, B:14:0x0070, B:17:0x0080, B:19:0x0084, B:21:0x0091, B:22:0x00ae), top: B:11:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0080 A[Catch: all -> 0x00af, TryCatch #0 {all -> 0x00af, blocks: (B:12:0x0068, B:14:0x0070, B:17:0x0080, B:19:0x0084, B:21:0x0091, B:22:0x00ae), top: B:11:0x0068 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // io.ktor.serialization.ContentConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object deserialize(Charset charset, TypeInfo typeInfo, ByteReadChannel byteReadChannel, Continuation<Object> continuation) {
        KotlinxSerializationConverter$deserialize$1 kotlinxSerializationConverter$deserialize$1;
        int i;
        Charset charset2;
        KSerializer<?> kSerializer;
        KotlinxSerializationConverter kotlinxSerializationConverter;
        SerialFormat serialFormat;
        try {
            if (continuation instanceof KotlinxSerializationConverter$deserialize$1) {
                kotlinxSerializationConverter$deserialize$1 = (KotlinxSerializationConverter$deserialize$1) continuation;
                if ((kotlinxSerializationConverter$deserialize$1.label & Integer.MIN_VALUE) != 0) {
                    kotlinxSerializationConverter$deserialize$1.label -= Integer.MIN_VALUE;
                    KotlinxSerializationConverter$deserialize$1 kotlinxSerializationConverter$deserialize$12 = kotlinxSerializationConverter$deserialize$1;
                    Object obj = kotlinxSerializationConverter$deserialize$12.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = kotlinxSerializationConverter$deserialize$12.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        KSerializer<?> serializerFromTypeInfo = SerializerLookupKt.serializerFromTypeInfo(typeInfo, this.format.getSerializersModule());
                        kotlinxSerializationConverter$deserialize$12.L$0 = this;
                        kotlinxSerializationConverter$deserialize$12.L$1 = charset;
                        kotlinxSerializationConverter$deserialize$12.L$2 = serializerFromTypeInfo;
                        kotlinxSerializationConverter$deserialize$12.label = 1;
                        obj = ByteReadChannel.DefaultImpls.readRemaining$default(byteReadChannel, 0L, kotlinxSerializationConverter$deserialize$12, 1, null);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        charset2 = charset;
                        kSerializer = serializerFromTypeInfo;
                        kotlinxSerializationConverter = this;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        kSerializer = (KSerializer) kotlinxSerializationConverter$deserialize$12.L$2;
                        charset2 = (Charset) kotlinxSerializationConverter$deserialize$12.L$1;
                        kotlinxSerializationConverter = (KotlinxSerializationConverter) kotlinxSerializationConverter$deserialize$12.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    ByteReadPacket byteReadPacket = (ByteReadPacket) obj;
                    serialFormat = kotlinxSerializationConverter.format;
                    if (!(serialFormat instanceof StringFormat)) {
                        return ((StringFormat) serialFormat).decodeFromString(kSerializer, StringsKt.readText$default(byteReadPacket, charset2, 0, 2, (Object) null));
                    }
                    if (serialFormat instanceof BinaryFormat) {
                        return ((BinaryFormat) serialFormat).decodeFromByteArray(kSerializer, StringsKt.readBytes$default(byteReadPacket, 0, 1, null));
                    }
                    InputKt.discard(byteReadPacket);
                    throw new IllegalStateException(("Unsupported format " + kotlinxSerializationConverter.format).toString());
                }
            }
            serialFormat = kotlinxSerializationConverter.format;
            if (!(serialFormat instanceof StringFormat)) {
            }
        } catch (Throwable th) {
            throw new JsonConvertException("Illegal input", th);
        }
        kotlinxSerializationConverter$deserialize$1 = new KotlinxSerializationConverter$deserialize$1(this, continuation);
        KotlinxSerializationConverter$deserialize$1 kotlinxSerializationConverter$deserialize$122 = kotlinxSerializationConverter$deserialize$1;
        Object obj2 = kotlinxSerializationConverter$deserialize$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = kotlinxSerializationConverter$deserialize$122.label;
        if (i != 0) {
        }
        ByteReadPacket byteReadPacket2 = (ByteReadPacket) obj2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OutgoingContent.ByteArrayContent serializeContent(KSerializer<?> serializer, SerialFormat format, Object value, ContentType contentType, Charset charset) {
        if (format instanceof StringFormat) {
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            return new TextContent(((StringFormat) format).encodeToString(serializer, value), ContentTypesKt.withCharsetIfNeeded(contentType, charset), null, 4, null);
        }
        if (format instanceof BinaryFormat) {
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            return new ByteArrayContent(((BinaryFormat) format).encodeToByteArray(serializer, value), contentType, null, 4, null);
        }
        throw new IllegalStateException(("Unsupported format " + format).toString());
    }
}
