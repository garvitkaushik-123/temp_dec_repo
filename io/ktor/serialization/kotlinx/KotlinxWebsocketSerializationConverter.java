package io.ktor.serialization.kotlinx;

import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketConverterNotFoundException;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.websocket.Frame;
import io.ktor.websocket.FrameCommonKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.BinaryFormat;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialFormat;
import kotlinx.serialization.StringFormat;

/* compiled from: KotlinxWebsocketSerializationConverter.kt */
@Metadata(d1 = {"\u0000G\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J/\u0010\b\u001a\u0004\u0018\u00010\t2\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010H\u0016J&\u0010\u0015\u001a\u00020\u00102\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0002J/\u0010\u0019\u001a\u00020\u00102\n\u0010\n\u001a\u00060\u000bj\u0002`\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lio/ktor/serialization/kotlinx/KotlinxWebsocketSerializationConverter;", "Lio/ktor/serialization/WebsocketContentConverter;", "format", "Lkotlinx/serialization/SerialFormat;", "(Lkotlinx/serialization/SerialFormat;)V", "serializationBase", "io/ktor/serialization/kotlinx/KotlinxWebsocketSerializationConverter$serializationBase$1", "Lio/ktor/serialization/kotlinx/KotlinxWebsocketSerializationConverter$serializationBase$1;", "deserialize", "", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "content", "Lio/ktor/websocket/Frame;", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/websocket/Frame;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isApplicable", "", "frame", "serializeContent", "serializer", "Lkotlinx/serialization/KSerializer;", "value", "serializeNullable", "(Ljava/nio/charset/Charset;Lio/ktor/util/reflect/TypeInfo;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-serialization-kotlinx"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class KotlinxWebsocketSerializationConverter implements WebsocketContentConverter {
    private final SerialFormat format;
    private final KotlinxWebsocketSerializationConverter$serializationBase$1 serializationBase;

    /* JADX WARN: Type inference failed for: r0v2, types: [io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter$serializationBase$1] */
    public KotlinxWebsocketSerializationConverter(final SerialFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.format = format;
        if (!(format instanceof BinaryFormat) && !(format instanceof StringFormat)) {
            throw new IllegalArgumentException(("Only binary and string formats are supported, " + format + " is not supported.").toString());
        }
        this.serializationBase = new KotlinxSerializationBase<Frame>(format) { // from class: io.ktor.serialization.kotlinx.KotlinxWebsocketSerializationConverter$serializationBase$1
            @Override // io.ktor.serialization.kotlinx.KotlinxSerializationBase
            public Object serializeContent$ktor_serialization_kotlinx(SerializationParameters serializationParameters, Continuation<? super Frame> continuation) {
                Frame serializeContent;
                serializeContent = KotlinxWebsocketSerializationConverter.this.serializeContent(serializationParameters.getSerializer(), serializationParameters.getFormat(), serializationParameters.getValue());
                return serializeContent;
            }
        };
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public Object serialize(Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super Frame> continuation) {
        return WebsocketContentConverter.DefaultImpls.serialize(this, charset, typeInfo, obj, continuation);
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public Object serializeNullable(Charset charset, TypeInfo typeInfo, Object obj, Continuation<? super Frame> continuation) {
        return serialize$ktor_serialization_kotlinx(new SerializationParameters(this.format, obj, typeInfo, charset), continuation);
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public Object deserialize(Charset charset, TypeInfo typeInfo, Frame frame, Continuation<Object> continuation) {
        if (!isApplicable(frame)) {
            throw new WebsocketConverterNotFoundException("Unsupported frame " + frame.getFrameType().name(), null, 2, null);
        }
        KSerializer<?> serializerFromTypeInfo = SerializerLookupKt.serializerFromTypeInfo(typeInfo, this.format.getSerializersModule());
        SerialFormat serialFormat = this.format;
        if (serialFormat instanceof StringFormat) {
            if (frame instanceof Frame.Text) {
                return ((StringFormat) serialFormat).decodeFromString(serializerFromTypeInfo, FrameCommonKt.readText((Frame.Text) frame));
            }
            throw new WebsocketDeserializeException("Unsupported format " + this.format + " for " + frame.getFrameType().name(), null, frame, 2, null);
        }
        if (serialFormat instanceof BinaryFormat) {
            if (frame instanceof Frame.Binary) {
                return ((BinaryFormat) serialFormat).decodeFromByteArray(serializerFromTypeInfo, FrameCommonKt.readBytes(frame));
            }
            throw new WebsocketDeserializeException("Unsupported format " + this.format + " for " + frame.getFrameType().name(), null, frame, 2, null);
        }
        throw new IllegalStateException(("Unsupported format " + this.format).toString());
    }

    @Override // io.ktor.serialization.WebsocketContentConverter
    public boolean isApplicable(Frame frame) {
        Intrinsics.checkNotNullParameter(frame, "frame");
        return (frame instanceof Frame.Text) || (frame instanceof Frame.Binary);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Frame serializeContent(KSerializer<?> serializer, SerialFormat format, Object value) {
        if (format instanceof StringFormat) {
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            return new Frame.Text(((StringFormat) format).encodeToString(serializer, value));
        }
        if (format instanceof BinaryFormat) {
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any?>");
            return new Frame.Binary(true, ((BinaryFormat) format).encodeToByteArray(serializer, value));
        }
        throw new IllegalStateException(("Unsupported format " + format).toString());
    }
}
