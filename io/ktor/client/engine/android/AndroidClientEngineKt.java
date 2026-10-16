package io.ktor.client.engine.android;

import io.ktor.client.call.UnsupportedContentTypeException;
import io.ktor.http.HttpMethod;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.jvm.javaio.WritingKt;
import java.io.Closeable;
import java.io.OutputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* compiled from: AndroidClientEngine.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a%\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\n\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"METHODS_WITHOUT_BODY", "", "Lio/ktor/http/HttpMethod;", "writeTo", "", "Lio/ktor/http/content/OutgoingContent;", "stream", "Ljava/io/OutputStream;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "(Lio/ktor/http/content/OutgoingContent;Ljava/io/OutputStream;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-android"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AndroidClientEngineKt {
    private static final List<HttpMethod> METHODS_WITHOUT_BODY = CollectionsKt.listOf((Object[]) new HttpMethod[]{HttpMethod.INSTANCE.getGet(), HttpMethod.INSTANCE.getHead()});

    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b3, code lost:
    
        if (io.ktor.utils.io.jvm.javaio.WritingKt.copyTo$default(r0, r4, 0, r7, 2, null) == r2) goto L38;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object writeTo(OutgoingContent outgoingContent, OutputStream outputStream, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
        AndroidClientEngineKt$writeTo$1 androidClientEngineKt$writeTo$1;
        int i;
        Object obj;
        try {
            if (continuation instanceof AndroidClientEngineKt$writeTo$1) {
                androidClientEngineKt$writeTo$1 = (AndroidClientEngineKt$writeTo$1) continuation;
                if ((androidClientEngineKt$writeTo$1.label & Integer.MIN_VALUE) != 0) {
                    androidClientEngineKt$writeTo$1.label -= Integer.MIN_VALUE;
                    AndroidClientEngineKt$writeTo$1 androidClientEngineKt$writeTo$12 = androidClientEngineKt$writeTo$1;
                    Object obj2 = androidClientEngineKt$writeTo$12.result;
                    ?? coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = androidClientEngineKt$writeTo$12.label;
                    if (i == 0) {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Closeable closeable = (Closeable) androidClientEngineKt$writeTo$12.L$0;
                            ResultKt.throwOnFailure(obj2);
                            coroutine_suspended = closeable;
                            Unit unit = Unit.INSTANCE;
                            CloseableKt.closeFinally(coroutine_suspended, null);
                            return Unit.INSTANCE;
                        }
                        Object obj3 = (Closeable) androidClientEngineKt$writeTo$12.L$0;
                        ResultKt.throwOnFailure(obj2);
                        obj = obj3;
                        ((Number) obj2).longValue();
                        coroutine_suspended = obj;
                        Unit unit2 = Unit.INSTANCE;
                        CloseableKt.closeFinally(coroutine_suspended, null);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj2);
                    OutputStream outputStream2 = outputStream;
                    try {
                        OutputStream outputStream3 = outputStream2;
                        if (!(outgoingContent instanceof OutgoingContent.ByteArrayContent)) {
                            if (outgoingContent instanceof OutgoingContent.ReadChannelContent) {
                                ByteReadChannel readFrom = ((OutgoingContent.ReadChannelContent) outgoingContent).readFrom();
                                androidClientEngineKt$writeTo$12.L$0 = outputStream2;
                                androidClientEngineKt$writeTo$12.label = 1;
                                Object copyTo$default = WritingKt.copyTo$default(readFrom, outputStream3, 0L, androidClientEngineKt$writeTo$12, 2, null);
                                if (copyTo$default != coroutine_suspended) {
                                    obj = outputStream2;
                                    obj2 = copyTo$default;
                                    ((Number) obj2).longValue();
                                    coroutine_suspended = obj;
                                    Unit unit22 = Unit.INSTANCE;
                                    CloseableKt.closeFinally(coroutine_suspended, null);
                                    return Unit.INSTANCE;
                                }
                            } else if (outgoingContent instanceof OutgoingContent.WriteChannelContent) {
                                ByteReadChannel channel = CoroutinesKt.writer$default((CoroutineScope) GlobalScope.INSTANCE, coroutineContext, false, (Function2) new AndroidClientEngineKt$writeTo$2$channel$1(outgoingContent, null), 2, (Object) null).getChannel();
                                androidClientEngineKt$writeTo$12.L$0 = outputStream2;
                                androidClientEngineKt$writeTo$12.label = 2;
                            } else if (!(outgoingContent instanceof OutgoingContent.NoContent)) {
                                throw new UnsupportedContentTypeException(outgoingContent);
                            }
                            return coroutine_suspended;
                        }
                        outputStream3.write(((OutgoingContent.ByteArrayContent) outgoingContent).getBytes());
                        coroutine_suspended = outputStream2;
                        Unit unit222 = Unit.INSTANCE;
                        CloseableKt.closeFinally(coroutine_suspended, null);
                        return Unit.INSTANCE;
                    } catch (Throwable th) {
                        th = th;
                        coroutine_suspended = outputStream2;
                        Throwable th2 = th;
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            CloseableKt.closeFinally(coroutine_suspended, th2);
                            throw th3;
                        }
                    }
                }
            }
            if (i == 0) {
            }
        } catch (Throwable th4) {
            th = th4;
        }
        androidClientEngineKt$writeTo$1 = new AndroidClientEngineKt$writeTo$1(continuation);
        AndroidClientEngineKt$writeTo$1 androidClientEngineKt$writeTo$122 = androidClientEngineKt$writeTo$1;
        Object obj22 = androidClientEngineKt$writeTo$122.result;
        ?? coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidClientEngineKt$writeTo$122.label;
    }
}
