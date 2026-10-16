package io.ktor.client.statement;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.request.HttpRequest;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.util.InternalAPI;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.charsets.EncodingKt;
import io.ktor.utils.io.core.ByteReadPacket;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlin.text.Charsets;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.Job;

/* compiled from: HttpResponse.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a#\u0010\b\u001a\u00020\t*\u00020\u00022\f\b\u0002\u0010\n\u001a\u00060\u000bj\u0002`\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0001\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {AdActivity.REQUEST_KEY_EXTRA, "Lio/ktor/client/request/HttpRequest;", "Lio/ktor/client/statement/HttpResponse;", "getRequest", "(Lio/ktor/client/statement/HttpResponse;)Lio/ktor/client/request/HttpRequest;", "bodyAsChannel", "Lio/ktor/utils/io/ByteReadChannel;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bodyAsText", "", "fallbackCharset", "Ljava/nio/charset/Charset;", "Lio/ktor/utils/io/charsets/Charset;", "(Lio/ktor/client/statement/HttpResponse;Ljava/nio/charset/Charset;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", CampaignEx.JSON_NATIVE_VIDEO_COMPLETE, "", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HttpResponseKt {
    public static final HttpRequest getRequest(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        return httpResponse.getCall().getRequest();
    }

    @InternalAPI
    public static final void complete(HttpResponse httpResponse) {
        Intrinsics.checkNotNullParameter(httpResponse, "<this>");
        CoroutineContext.Element element = httpResponse.getCoroutineContext().get(Job.INSTANCE);
        Intrinsics.checkNotNull(element);
        ((CompletableJob) element).complete();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object bodyAsText(HttpResponse httpResponse, Charset charset, Continuation<? super String> continuation) {
        HttpResponseKt$bodyAsText$1 httpResponseKt$bodyAsText$1;
        Object obj;
        int i;
        CharsetDecoder decoder;
        if (continuation instanceof HttpResponseKt$bodyAsText$1) {
            httpResponseKt$bodyAsText$1 = (HttpResponseKt$bodyAsText$1) continuation;
            if ((httpResponseKt$bodyAsText$1.label & Integer.MIN_VALUE) != 0) {
                httpResponseKt$bodyAsText$1.label -= Integer.MIN_VALUE;
                obj = httpResponseKt$bodyAsText$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpResponseKt$bodyAsText$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Charset charset2 = HttpMessagePropertiesKt.charset(httpResponse);
                    if (charset2 != null) {
                        charset = charset2;
                    }
                    CharsetDecoder newDecoder = charset.newDecoder();
                    HttpClientCall call = httpResponse.getCall();
                    KType typeOf = Reflection.typeOf(ByteReadPacket.class);
                    TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(ByteReadPacket.class), typeOf);
                    httpResponseKt$bodyAsText$1.L$0 = newDecoder;
                    httpResponseKt$bodyAsText$1.label = 1;
                    obj = call.bodyNullable(typeInfoImpl, httpResponseKt$bodyAsText$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    decoder = newDecoder;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    decoder = (CharsetDecoder) httpResponseKt$bodyAsText$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (obj == null) {
                    Intrinsics.checkNotNullExpressionValue(decoder, "decoder");
                    return EncodingKt.decode$default(decoder, (ByteReadPacket) obj, 0, 2, null);
                }
                throw new NullPointerException("null cannot be cast to non-null type io.ktor.utils.io.core.ByteReadPacket");
            }
        }
        httpResponseKt$bodyAsText$1 = new HttpResponseKt$bodyAsText$1(continuation);
        obj = httpResponseKt$bodyAsText$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpResponseKt$bodyAsText$1.label;
        if (i != 0) {
        }
        if (obj == null) {
        }
    }

    public static /* synthetic */ Object bodyAsText$default(HttpResponse httpResponse, Charset charset, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return bodyAsText(httpResponse, charset, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object bodyAsChannel(HttpResponse httpResponse, Continuation<? super ByteReadChannel> continuation) {
        HttpResponseKt$bodyAsChannel$1 httpResponseKt$bodyAsChannel$1;
        Object obj;
        int i;
        if (continuation instanceof HttpResponseKt$bodyAsChannel$1) {
            httpResponseKt$bodyAsChannel$1 = (HttpResponseKt$bodyAsChannel$1) continuation;
            if ((httpResponseKt$bodyAsChannel$1.label & Integer.MIN_VALUE) != 0) {
                httpResponseKt$bodyAsChannel$1.label -= Integer.MIN_VALUE;
                obj = httpResponseKt$bodyAsChannel$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpResponseKt$bodyAsChannel$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HttpClientCall call = httpResponse.getCall();
                    KType typeOf = Reflection.typeOf(ByteReadChannel.class);
                    TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(ByteReadChannel.class), typeOf);
                    httpResponseKt$bodyAsChannel$1.label = 1;
                    obj = call.bodyNullable(typeInfoImpl, httpResponseKt$bodyAsChannel$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                if (obj == null) {
                    return (ByteReadChannel) obj;
                }
                throw new NullPointerException("null cannot be cast to non-null type io.ktor.utils.io.ByteReadChannel");
            }
        }
        httpResponseKt$bodyAsChannel$1 = new HttpResponseKt$bodyAsChannel$1(continuation);
        obj = httpResponseKt$bodyAsChannel$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpResponseKt$bodyAsChannel$1.label;
        if (i != 0) {
        }
        if (obj == null) {
        }
    }
}
