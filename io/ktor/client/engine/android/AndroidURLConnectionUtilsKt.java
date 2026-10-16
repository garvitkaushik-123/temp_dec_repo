package io.ktor.client.engine.android;

import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.network.sockets.TimeoutExceptionsCommonKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.HttpTimeoutKt;
import io.ktor.client.request.HttpRequestData;
import io.ktor.util.cio.ByteBufferPoolKt;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.YieldKt;

/* compiled from: AndroidURLConnectionUtils.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u000b*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0000\u001a7\u0010\u0010\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0011*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00110\u0013H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"content", "Lio/ktor/utils/io/ByteReadChannel;", "Ljava/net/HttpURLConnection;", "callContext", "Lkotlin/coroutines/CoroutineContext;", AdActivity.REQUEST_KEY_EXTRA, "Lio/ktor/client/request/HttpRequestData;", "isTimeoutException", "", "", "setupRequestTimeoutAttributes", "", "timeoutAttributes", "Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration;", "setupTimeoutAttributes", "requestData", "timeoutAwareConnection", "T", "block", "Lkotlin/Function1;", "(Ljava/net/HttpURLConnection;Lio/ktor/client/request/HttpRequestData;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-android"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AndroidURLConnectionUtilsKt {
    public static final void setupTimeoutAttributes(HttpURLConnection httpURLConnection, HttpRequestData requestData) {
        Intrinsics.checkNotNullParameter(httpURLConnection, "<this>");
        Intrinsics.checkNotNullParameter(requestData, "requestData");
        HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) requestData.getCapabilityOrNull(HttpTimeout.INSTANCE);
        if (httpTimeoutCapabilityConfiguration != null) {
            Long l = httpTimeoutCapabilityConfiguration.get_connectTimeoutMillis();
            if (l != null) {
                httpURLConnection.setConnectTimeout(HttpTimeoutKt.convertLongTimeoutToIntWithInfiniteAsZero(l.longValue()));
            }
            Long l2 = httpTimeoutCapabilityConfiguration.get_socketTimeoutMillis();
            if (l2 != null) {
                httpURLConnection.setReadTimeout(HttpTimeoutKt.convertLongTimeoutToIntWithInfiniteAsZero(l2.longValue()));
            }
            setupRequestTimeoutAttributes(httpURLConnection, httpTimeoutCapabilityConfiguration);
        }
    }

    private static final void setupRequestTimeoutAttributes(HttpURLConnection httpURLConnection, HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
        Long l = httpTimeoutCapabilityConfiguration.get_requestTimeoutMillis();
        if (l != null) {
            long longValue = l.longValue();
            if (longValue != Long.MAX_VALUE) {
                if (httpURLConnection.getConnectTimeout() == 0 || httpURLConnection.getConnectTimeout() > longValue) {
                    httpURLConnection.setConnectTimeout(HttpTimeoutKt.convertLongTimeoutToIntWithInfiniteAsZero(longValue));
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object timeoutAwareConnection(HttpURLConnection httpURLConnection, HttpRequestData httpRequestData, Function1<? super HttpURLConnection, ? extends T> function1, Continuation<? super T> continuation) {
        AndroidURLConnectionUtilsKt$timeoutAwareConnection$1 androidURLConnectionUtilsKt$timeoutAwareConnection$1;
        int i;
        if (continuation instanceof AndroidURLConnectionUtilsKt$timeoutAwareConnection$1) {
            androidURLConnectionUtilsKt$timeoutAwareConnection$1 = (AndroidURLConnectionUtilsKt$timeoutAwareConnection$1) continuation;
            if ((androidURLConnectionUtilsKt$timeoutAwareConnection$1.label & Integer.MIN_VALUE) != 0) {
                androidURLConnectionUtilsKt$timeoutAwareConnection$1.label -= Integer.MIN_VALUE;
                Object obj = androidURLConnectionUtilsKt$timeoutAwareConnection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidURLConnectionUtilsKt$timeoutAwareConnection$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        return function1.invoke(httpURLConnection);
                    } catch (Throwable th) {
                        th = th;
                        androidURLConnectionUtilsKt$timeoutAwareConnection$1.L$0 = httpRequestData;
                        androidURLConnectionUtilsKt$timeoutAwareConnection$1.L$1 = th;
                        androidURLConnectionUtilsKt$timeoutAwareConnection$1.label = 1;
                        if (YieldKt.yield(androidURLConnectionUtilsKt$timeoutAwareConnection$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    th = (Throwable) androidURLConnectionUtilsKt$timeoutAwareConnection$1.L$1;
                    httpRequestData = (HttpRequestData) androidURLConnectionUtilsKt$timeoutAwareConnection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                if (!isTimeoutException(th)) {
                    throw HttpTimeoutKt.ConnectTimeoutException(httpRequestData, th);
                }
                throw th;
            }
        }
        androidURLConnectionUtilsKt$timeoutAwareConnection$1 = new AndroidURLConnectionUtilsKt$timeoutAwareConnection$1(continuation);
        Object obj2 = androidURLConnectionUtilsKt$timeoutAwareConnection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidURLConnectionUtilsKt$timeoutAwareConnection$1.label;
        if (i != 0) {
        }
        if (!isTimeoutException(th)) {
        }
    }

    public static final ByteReadChannel content(HttpURLConnection httpURLConnection, CoroutineContext callContext, HttpRequestData request) {
        ByteReadChannel byteReadChannel;
        ByteReadChannel mapEngineExceptions;
        Intrinsics.checkNotNullParameter(httpURLConnection, "<this>");
        Intrinsics.checkNotNullParameter(callContext, "callContext");
        Intrinsics.checkNotNullParameter(request, "request");
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            r1 = inputStream != null ? inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, 8192) : null;
        } catch (IOException unused) {
            InputStream errorStream = httpURLConnection.getErrorStream();
            if (errorStream != null) {
                r1 = errorStream instanceof BufferedInputStream ? (BufferedInputStream) errorStream : new BufferedInputStream(errorStream, 8192);
            }
        }
        return (r1 == null || (byteReadChannel = ReadingKt.toByteReadChannel(r1, callContext, ByteBufferPoolKt.getKtorDefaultPool())) == null || (mapEngineExceptions = TimeoutExceptionsCommonKt.mapEngineExceptions(CoroutineScopeKt.CoroutineScope(callContext), byteReadChannel, request)) == null) ? ByteReadChannel.INSTANCE.getEmpty() : mapEngineExceptions;
    }

    private static final boolean isTimeoutException(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        if (th instanceof ConnectException) {
            String message = th.getMessage();
            if (message != null ? StringsKt.contains$default((CharSequence) message, (CharSequence) "timed out", false, 2, (Object) null) : false) {
                return true;
            }
        }
        return false;
    }
}
