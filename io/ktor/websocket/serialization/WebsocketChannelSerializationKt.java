package io.ktor.websocket.serialization;

import io.ktor.serialization.WebsocketContentConverter;
import io.ktor.serialization.WebsocketDeserializeException;
import io.ktor.util.InternalAPI;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.websocket.Frame;
import io.ktor.websocket.WebSocketSession;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;

/* compiled from: WebsocketChannelSerialization.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\t\u001a3\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a;\u0010\r\u001a\u00020\u000e\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a;\u0010\r\u001a\u00020\u000e*\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"receiveDeserializedBase", "", "T", "Lio/ktor/websocket/WebSocketSession;", "converter", "Lio/ktor/serialization/WebsocketContentConverter;", "charset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "typeInfo", "Lio/ktor/util/reflect/TypeInfo;", "(Lio/ktor/websocket/WebSocketSession;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendSerializedBase", "", "data", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/websocket/WebSocketSession;Ljava/lang/Object;Lio/ktor/util/reflect/TypeInfo;Lio/ktor/serialization/WebsocketContentConverter;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-websocket-serialization"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class WebsocketChannelSerializationKt {
    @InternalAPI
    public static final /* synthetic */ <T> Object sendSerializedBase(WebSocketSession webSocketSession, Object obj, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<? super Unit> continuation) {
        Intrinsics.reifiedOperationMarker(6, "T");
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, "T");
        sendSerializedBase(webSocketSession, obj, TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), null), websocketContentConverter, charset, continuation);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005a, code lost:
    
        if (r5.send((io.ktor.websocket.Frame) r10, r0) != r1) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005c, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
    
        if (r10 == r1) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object sendSerializedBase(WebSocketSession webSocketSession, Object obj, TypeInfo typeInfo, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<? super Unit> continuation) {
        WebsocketChannelSerializationKt$sendSerializedBase$2 websocketChannelSerializationKt$sendSerializedBase$2;
        int i;
        if (continuation instanceof WebsocketChannelSerializationKt$sendSerializedBase$2) {
            websocketChannelSerializationKt$sendSerializedBase$2 = (WebsocketChannelSerializationKt$sendSerializedBase$2) continuation;
            if ((websocketChannelSerializationKt$sendSerializedBase$2.label & Integer.MIN_VALUE) != 0) {
                websocketChannelSerializationKt$sendSerializedBase$2.label -= Integer.MIN_VALUE;
                Object obj2 = websocketChannelSerializationKt$sendSerializedBase$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = websocketChannelSerializationKt$sendSerializedBase$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    websocketChannelSerializationKt$sendSerializedBase$2.L$0 = webSocketSession;
                    websocketChannelSerializationKt$sendSerializedBase$2.label = 1;
                    obj2 = websocketContentConverter.serializeNullable(charset, typeInfo, obj, websocketChannelSerializationKt$sendSerializedBase$2);
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj2);
                        return Unit.INSTANCE;
                    }
                    webSocketSession = (WebSocketSession) websocketChannelSerializationKt$sendSerializedBase$2.L$0;
                    ResultKt.throwOnFailure(obj2);
                }
                SendChannel<Frame> outgoing = webSocketSession.getOutgoing();
                websocketChannelSerializationKt$sendSerializedBase$2.L$0 = null;
                websocketChannelSerializationKt$sendSerializedBase$2.label = 2;
            }
        }
        websocketChannelSerializationKt$sendSerializedBase$2 = new WebsocketChannelSerializationKt$sendSerializedBase$2(continuation);
        Object obj22 = websocketChannelSerializationKt$sendSerializedBase$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = websocketChannelSerializationKt$sendSerializedBase$2.label;
        if (i != 0) {
        }
        SendChannel<Frame> outgoing2 = webSocketSession.getOutgoing();
        websocketChannelSerializationKt$sendSerializedBase$2.L$0 = null;
        websocketChannelSerializationKt$sendSerializedBase$2.label = 2;
    }

    @InternalAPI
    public static final /* synthetic */ <T> Object receiveDeserializedBase(WebSocketSession webSocketSession, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<Object> continuation) {
        Intrinsics.reifiedOperationMarker(6, "T");
        Type javaType = TypesJVMKt.getJavaType((KType) null);
        Intrinsics.reifiedOperationMarker(4, "T");
        return receiveDeserializedBase(webSocketSession, TypeInfoJvmKt.typeInfoImpl(javaType, Reflection.getOrCreateKotlinClass(Object.class), null), websocketContentConverter, charset, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x006d, code lost:
    
        if (r0 == r2) goto L23;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    @InternalAPI
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object receiveDeserializedBase(WebSocketSession webSocketSession, TypeInfo typeInfo, WebsocketContentConverter websocketContentConverter, Charset charset, Continuation<Object> continuation) {
        WebsocketChannelSerializationKt$receiveDeserializedBase$2 websocketChannelSerializationKt$receiveDeserializedBase$2;
        int i;
        TypeInfo typeInfo2;
        WebsocketContentConverter websocketContentConverter2;
        Charset charset2;
        Frame frame;
        TypeInfo typeInfo3;
        Frame frame2;
        if (continuation instanceof WebsocketChannelSerializationKt$receiveDeserializedBase$2) {
            websocketChannelSerializationKt$receiveDeserializedBase$2 = (WebsocketChannelSerializationKt$receiveDeserializedBase$2) continuation;
            if ((websocketChannelSerializationKt$receiveDeserializedBase$2.label & Integer.MIN_VALUE) != 0) {
                websocketChannelSerializationKt$receiveDeserializedBase$2.label -= Integer.MIN_VALUE;
                Object obj = websocketChannelSerializationKt$receiveDeserializedBase$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = websocketChannelSerializationKt$receiveDeserializedBase$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    ReceiveChannel<Frame> incoming = webSocketSession.getIncoming();
                    typeInfo2 = typeInfo;
                    websocketChannelSerializationKt$receiveDeserializedBase$2.L$0 = typeInfo2;
                    websocketContentConverter2 = websocketContentConverter;
                    websocketChannelSerializationKt$receiveDeserializedBase$2.L$1 = websocketContentConverter2;
                    charset2 = charset;
                    websocketChannelSerializationKt$receiveDeserializedBase$2.L$2 = charset2;
                    websocketChannelSerializationKt$receiveDeserializedBase$2.label = 1;
                    obj = incoming.receive(websocketChannelSerializationKt$receiveDeserializedBase$2);
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        Frame frame3 = (Frame) websocketChannelSerializationKt$receiveDeserializedBase$2.L$1;
                        typeInfo3 = (TypeInfo) websocketChannelSerializationKt$receiveDeserializedBase$2.L$0;
                        ResultKt.throwOnFailure(obj);
                        frame2 = frame3;
                        if (!typeInfo3.getType().isInstance(obj)) {
                            return obj;
                        }
                        if (obj == null) {
                            KType kotlinType = typeInfo3.getKotlinType();
                            if (kotlinType == null || !kotlinType.isMarkedNullable()) {
                                throw new WebsocketDeserializeException("Frame has null content", null, frame2, 2, null);
                            }
                            return null;
                        }
                        throw new WebsocketDeserializeException("Can't deserialize value: expected value of type " + typeInfo3.getType().getSimpleName() + ", got " + Reflection.getOrCreateKotlinClass(obj.getClass()).getSimpleName(), null, frame2, 2, null);
                    }
                    Charset charset3 = (Charset) websocketChannelSerializationKt$receiveDeserializedBase$2.L$2;
                    websocketContentConverter2 = (WebsocketContentConverter) websocketChannelSerializationKt$receiveDeserializedBase$2.L$1;
                    TypeInfo typeInfo4 = (TypeInfo) websocketChannelSerializationKt$receiveDeserializedBase$2.L$0;
                    ResultKt.throwOnFailure(obj);
                    charset2 = charset3;
                    typeInfo2 = typeInfo4;
                }
                frame = (Frame) obj;
                if (websocketContentConverter2.isApplicable(frame)) {
                    throw new WebsocketDeserializeException("Converter doesn't support frame type " + frame.getFrameType().name(), null, frame, 2, null);
                }
                websocketChannelSerializationKt$receiveDeserializedBase$2.L$0 = typeInfo2;
                websocketChannelSerializationKt$receiveDeserializedBase$2.L$1 = frame;
                websocketChannelSerializationKt$receiveDeserializedBase$2.L$2 = null;
                websocketChannelSerializationKt$receiveDeserializedBase$2.label = 2;
                obj = websocketContentConverter2.deserialize(charset2, typeInfo2, frame, websocketChannelSerializationKt$receiveDeserializedBase$2);
                if (obj != coroutine_suspended) {
                    typeInfo3 = typeInfo2;
                    frame2 = frame;
                    if (!typeInfo3.getType().isInstance(obj)) {
                    }
                }
                return coroutine_suspended;
            }
        }
        websocketChannelSerializationKt$receiveDeserializedBase$2 = new WebsocketChannelSerializationKt$receiveDeserializedBase$2(continuation);
        Object obj2 = websocketChannelSerializationKt$receiveDeserializedBase$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = websocketChannelSerializationKt$receiveDeserializedBase$2.label;
        if (i != 0) {
        }
        frame = (Frame) obj2;
        if (websocketContentConverter2.isApplicable(frame)) {
        }
    }
}
