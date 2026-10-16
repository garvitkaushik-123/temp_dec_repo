package io.ktor.client.engine.android;

import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.http.HeadersImpl;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: AndroidClientEngine.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lio/ktor/client/engine/android/AndroidClientEngine;", "Lio/ktor/client/engine/HttpClientEngineBase;", "config", "Lio/ktor/client/engine/android/AndroidEngineConfig;", "(Lio/ktor/client/engine/android/AndroidEngineConfig;)V", "getConfig", "()Lio/ktor/client/engine/android/AndroidEngineConfig;", "supportedCapabilities", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getSupportedCapabilities", "()Ljava/util/Set;", "execute", "Lio/ktor/client/request/HttpResponseData;", "data", "Lio/ktor/client/request/HttpRequestData;", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getProxyAwareConnection", "Ljava/net/HttpURLConnection;", "urlString", "", "ktor-client-android"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AndroidClientEngine extends HttpClientEngineBase {
    private final AndroidEngineConfig config;
    private final Set<HttpClientEngineCapability<?>> supportedCapabilities;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidClientEngine(AndroidEngineConfig config) {
        super("ktor-android");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.supportedCapabilities = SetsKt.setOf(HttpTimeout.INSTANCE);
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public AndroidEngineConfig getConfig() {
        return this.config;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return this.supportedCapabilities;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x019f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x01a0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002b  */
    @Override // io.ktor.client.engine.HttpClientEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object execute(HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation) {
        AndroidClientEngine$execute$1 androidClientEngine$execute$1;
        int i;
        final HttpRequestData httpRequestData2;
        Object callContext;
        AndroidClientEngine androidClientEngine;
        final CoroutineContext coroutineContext;
        final GMTDate GMTDate$default;
        final HttpURLConnection proxyAwareConnection;
        List list;
        Unit unit;
        HttpRequestData httpRequestData3;
        CoroutineContext coroutineContext2;
        GMTDate gMTDate;
        HttpURLConnection httpURLConnection;
        if (continuation instanceof AndroidClientEngine$execute$1) {
            androidClientEngine$execute$1 = (AndroidClientEngine$execute$1) continuation;
            if ((androidClientEngine$execute$1.label & Integer.MIN_VALUE) != 0) {
                androidClientEngine$execute$1.label -= Integer.MIN_VALUE;
                Object obj = androidClientEngine$execute$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = androidClientEngine$execute$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    androidClientEngine$execute$1.L$0 = this;
                    httpRequestData2 = httpRequestData;
                    androidClientEngine$execute$1.L$1 = httpRequestData2;
                    androidClientEngine$execute$1.label = 1;
                    callContext = UtilsKt.callContext(androidClientEngine$execute$1);
                    if (callContext != coroutine_suspended) {
                        androidClientEngine = this;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    httpURLConnection = (HttpURLConnection) androidClientEngine$execute$1.L$3;
                    gMTDate = (GMTDate) androidClientEngine$execute$1.L$2;
                    coroutineContext2 = (CoroutineContext) androidClientEngine$execute$1.L$1;
                    httpRequestData3 = (HttpRequestData) androidClientEngine$execute$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    proxyAwareConnection = httpURLConnection;
                    GMTDate$default = gMTDate;
                    coroutineContext = coroutineContext2;
                    httpRequestData2 = httpRequestData3;
                    Function1<HttpURLConnection, HttpResponseData> function1 = new Function1<HttpURLConnection, HttpResponseData>() { // from class: io.ktor.client.engine.android.AndroidClientEngine$execute$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final HttpResponseData invoke(HttpURLConnection current) {
                            HttpStatusCode fromValue;
                            String str;
                            Intrinsics.checkNotNullParameter(current, "current");
                            int responseCode = current.getResponseCode();
                            String responseMessage = current.getResponseMessage();
                            if (responseMessage != null) {
                                fromValue = new HttpStatusCode(responseCode, responseMessage);
                            } else {
                                fromValue = HttpStatusCode.INSTANCE.fromValue(responseCode);
                            }
                            HttpStatusCode httpStatusCode = fromValue;
                            ByteReadChannel content = AndroidURLConnectionUtilsKt.content(current, CoroutineContext.this, httpRequestData2);
                            Map<String, List<String>> headerFields = current.getHeaderFields();
                            Intrinsics.checkNotNullExpressionValue(headerFields, "current.headerFields");
                            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(headerFields.size()));
                            Iterator<T> it = headerFields.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                String key = (String) entry.getKey();
                                if (key != null) {
                                    Intrinsics.checkNotNullExpressionValue(key, "key");
                                    Locale locale = Locale.getDefault();
                                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                                    str = key.toLowerCase(locale);
                                    Intrinsics.checkNotNullExpressionValue(str, "this as java.lang.String).toLowerCase(locale)");
                                    if (str != null) {
                                        linkedHashMap.put(str, entry.getValue());
                                    }
                                }
                                str = "";
                                linkedHashMap.put(str, entry.getValue());
                            }
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                                if (!StringsKt.isBlank((CharSequence) entry2.getKey())) {
                                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                                }
                            }
                            HttpProtocolVersion http_1_1 = HttpProtocolVersion.INSTANCE.getHTTP_1_1();
                            return new HttpResponseData(httpStatusCode, GMTDate$default, new HeadersImpl(linkedHashMap2), http_1_1, content, CoroutineContext.this);
                        }
                    };
                    androidClientEngine$execute$1.L$0 = null;
                    androidClientEngine$execute$1.L$1 = null;
                    androidClientEngine$execute$1.L$2 = null;
                    androidClientEngine$execute$1.L$3 = null;
                    androidClientEngine$execute$1.label = 3;
                    Object timeoutAwareConnection = AndroidURLConnectionUtilsKt.timeoutAwareConnection(proxyAwareConnection, httpRequestData2, function1, androidClientEngine$execute$1);
                    return timeoutAwareConnection == coroutine_suspended ? coroutine_suspended : timeoutAwareConnection;
                }
                HttpRequestData httpRequestData4 = (HttpRequestData) androidClientEngine$execute$1.L$1;
                androidClientEngine = (AndroidClientEngine) androidClientEngine$execute$1.L$0;
                ResultKt.throwOnFailure(obj);
                callContext = obj;
                httpRequestData2 = httpRequestData4;
                coroutineContext = (CoroutineContext) callContext;
                GMTDate$default = DateJvmKt.GMTDate$default(null, 1, null);
                String urlString = httpRequestData2.getUrl().getUrlString();
                OutgoingContent body = httpRequestData2.getBody();
                String str = httpRequestData2.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
                Long boxLong = str == null ? Boxing.boxLong(Long.parseLong(str)) : body.getContentLength();
                proxyAwareConnection = androidClientEngine.getProxyAwareConnection(urlString);
                proxyAwareConnection.setConnectTimeout(androidClientEngine.getConfig().getConnectTimeout());
                proxyAwareConnection.setReadTimeout(androidClientEngine.getConfig().getSocketTimeout());
                AndroidURLConnectionUtilsKt.setupTimeoutAttributes(proxyAwareConnection, httpRequestData2);
                if (proxyAwareConnection instanceof HttpsURLConnection) {
                    androidClientEngine.getConfig().getSslManager().invoke(proxyAwareConnection);
                }
                proxyAwareConnection.setRequestMethod(httpRequestData2.getMethod().getValue());
                proxyAwareConnection.setUseCaches(false);
                proxyAwareConnection.setInstanceFollowRedirects(false);
                UtilsKt.mergeHeaders(httpRequestData2.getHeaders(), body, new Function2<String, String, Unit>() { // from class: io.ktor.client.engine.android.AndroidClientEngine$execute$connection$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str2, String str3) {
                        invoke2(str2, str3);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String key, String value) {
                        Intrinsics.checkNotNullParameter(key, "key");
                        Intrinsics.checkNotNullParameter(value, "value");
                        proxyAwareConnection.addRequestProperty(key, value);
                    }
                });
                androidClientEngine.getConfig().getRequestConfig().invoke(proxyAwareConnection);
                list = AndroidClientEngineKt.METHODS_WITHOUT_BODY;
                if (!list.contains(httpRequestData2.getMethod())) {
                    if (!(body instanceof OutgoingContent.NoContent)) {
                        throw new IllegalStateException(("Request of type " + httpRequestData2.getMethod() + " couldn't send a body with the [Android] engine.").toString());
                    }
                    Function1<HttpURLConnection, HttpResponseData> function12 = new Function1<HttpURLConnection, HttpResponseData>() { // from class: io.ktor.client.engine.android.AndroidClientEngine$execute$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final HttpResponseData invoke(HttpURLConnection current) {
                            HttpStatusCode fromValue;
                            String str2;
                            Intrinsics.checkNotNullParameter(current, "current");
                            int responseCode = current.getResponseCode();
                            String responseMessage = current.getResponseMessage();
                            if (responseMessage != null) {
                                fromValue = new HttpStatusCode(responseCode, responseMessage);
                            } else {
                                fromValue = HttpStatusCode.INSTANCE.fromValue(responseCode);
                            }
                            HttpStatusCode httpStatusCode = fromValue;
                            ByteReadChannel content = AndroidURLConnectionUtilsKt.content(current, CoroutineContext.this, httpRequestData2);
                            Map<String, List<String>> headerFields = current.getHeaderFields();
                            Intrinsics.checkNotNullExpressionValue(headerFields, "current.headerFields");
                            LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(headerFields.size()));
                            Iterator<T> it = headerFields.entrySet().iterator();
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                String key = (String) entry.getKey();
                                if (key != null) {
                                    Intrinsics.checkNotNullExpressionValue(key, "key");
                                    Locale locale = Locale.getDefault();
                                    Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                                    str2 = key.toLowerCase(locale);
                                    Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(locale)");
                                    if (str2 != null) {
                                        linkedHashMap.put(str2, entry.getValue());
                                    }
                                }
                                str2 = "";
                                linkedHashMap.put(str2, entry.getValue());
                            }
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                                if (!StringsKt.isBlank((CharSequence) entry2.getKey())) {
                                    linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                                }
                            }
                            HttpProtocolVersion http_1_1 = HttpProtocolVersion.INSTANCE.getHTTP_1_1();
                            return new HttpResponseData(httpStatusCode, GMTDate$default, new HeadersImpl(linkedHashMap2), http_1_1, content, CoroutineContext.this);
                        }
                    };
                    androidClientEngine$execute$1.L$0 = null;
                    androidClientEngine$execute$1.L$1 = null;
                    androidClientEngine$execute$1.L$2 = null;
                    androidClientEngine$execute$1.L$3 = null;
                    androidClientEngine$execute$1.label = 3;
                    Object timeoutAwareConnection2 = AndroidURLConnectionUtilsKt.timeoutAwareConnection(proxyAwareConnection, httpRequestData2, function12, androidClientEngine$execute$1);
                    if (timeoutAwareConnection2 == coroutine_suspended) {
                    }
                } else {
                    if (boxLong == null && proxyAwareConnection.getRequestProperty(HttpHeaders.INSTANCE.getTransferEncoding()) == null) {
                        proxyAwareConnection.addRequestProperty(HttpHeaders.INSTANCE.getTransferEncoding(), "chunked");
                    }
                    if (boxLong != null) {
                        proxyAwareConnection.setFixedLengthStreamingMode(boxLong.longValue());
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        proxyAwareConnection.setChunkedStreamingMode(0);
                    }
                    proxyAwareConnection.setDoOutput(true);
                    OutputStream outputStream = proxyAwareConnection.getOutputStream();
                    Intrinsics.checkNotNullExpressionValue(outputStream, "outputStream");
                    androidClientEngine$execute$1.L$0 = httpRequestData2;
                    androidClientEngine$execute$1.L$1 = coroutineContext;
                    androidClientEngine$execute$1.L$2 = GMTDate$default;
                    androidClientEngine$execute$1.L$3 = proxyAwareConnection;
                    androidClientEngine$execute$1.label = 2;
                    if (AndroidClientEngineKt.writeTo(body, outputStream, coroutineContext, androidClientEngine$execute$1) != coroutine_suspended) {
                        httpRequestData3 = httpRequestData2;
                        coroutineContext2 = coroutineContext;
                        gMTDate = GMTDate$default;
                        httpURLConnection = proxyAwareConnection;
                        proxyAwareConnection = httpURLConnection;
                        GMTDate$default = gMTDate;
                        coroutineContext = coroutineContext2;
                        httpRequestData2 = httpRequestData3;
                        Function1<HttpURLConnection, HttpResponseData> function122 = new Function1<HttpURLConnection, HttpResponseData>() { // from class: io.ktor.client.engine.android.AndroidClientEngine$execute$2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final HttpResponseData invoke(HttpURLConnection current) {
                                HttpStatusCode fromValue;
                                String str2;
                                Intrinsics.checkNotNullParameter(current, "current");
                                int responseCode = current.getResponseCode();
                                String responseMessage = current.getResponseMessage();
                                if (responseMessage != null) {
                                    fromValue = new HttpStatusCode(responseCode, responseMessage);
                                } else {
                                    fromValue = HttpStatusCode.INSTANCE.fromValue(responseCode);
                                }
                                HttpStatusCode httpStatusCode = fromValue;
                                ByteReadChannel content = AndroidURLConnectionUtilsKt.content(current, CoroutineContext.this, httpRequestData2);
                                Map<String, List<String>> headerFields = current.getHeaderFields();
                                Intrinsics.checkNotNullExpressionValue(headerFields, "current.headerFields");
                                LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(headerFields.size()));
                                Iterator<T> it = headerFields.entrySet().iterator();
                                while (it.hasNext()) {
                                    Map.Entry entry = (Map.Entry) it.next();
                                    String key = (String) entry.getKey();
                                    if (key != null) {
                                        Intrinsics.checkNotNullExpressionValue(key, "key");
                                        Locale locale = Locale.getDefault();
                                        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
                                        str2 = key.toLowerCase(locale);
                                        Intrinsics.checkNotNullExpressionValue(str2, "this as java.lang.String).toLowerCase(locale)");
                                        if (str2 != null) {
                                            linkedHashMap.put(str2, entry.getValue());
                                        }
                                    }
                                    str2 = "";
                                    linkedHashMap.put(str2, entry.getValue());
                                }
                                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                                    if (!StringsKt.isBlank((CharSequence) entry2.getKey())) {
                                        linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                                    }
                                }
                                HttpProtocolVersion http_1_1 = HttpProtocolVersion.INSTANCE.getHTTP_1_1();
                                return new HttpResponseData(httpStatusCode, GMTDate$default, new HeadersImpl(linkedHashMap2), http_1_1, content, CoroutineContext.this);
                            }
                        };
                        androidClientEngine$execute$1.L$0 = null;
                        androidClientEngine$execute$1.L$1 = null;
                        androidClientEngine$execute$1.L$2 = null;
                        androidClientEngine$execute$1.L$3 = null;
                        androidClientEngine$execute$1.label = 3;
                        Object timeoutAwareConnection22 = AndroidURLConnectionUtilsKt.timeoutAwareConnection(proxyAwareConnection, httpRequestData2, function122, androidClientEngine$execute$1);
                        if (timeoutAwareConnection22 == coroutine_suspended) {
                        }
                    }
                }
            }
        }
        androidClientEngine$execute$1 = new AndroidClientEngine$execute$1(this, continuation);
        Object obj2 = androidClientEngine$execute$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = androidClientEngine$execute$1.label;
        if (i != 0) {
        }
        coroutineContext = (CoroutineContext) callContext;
        GMTDate$default = DateJvmKt.GMTDate$default(null, 1, null);
        String urlString2 = httpRequestData2.getUrl().getUrlString();
        OutgoingContent body2 = httpRequestData2.getBody();
        String str2 = httpRequestData2.getHeaders().get(HttpHeaders.INSTANCE.getContentLength());
        if (str2 == null) {
        }
        proxyAwareConnection = androidClientEngine.getProxyAwareConnection(urlString2);
        proxyAwareConnection.setConnectTimeout(androidClientEngine.getConfig().getConnectTimeout());
        proxyAwareConnection.setReadTimeout(androidClientEngine.getConfig().getSocketTimeout());
        AndroidURLConnectionUtilsKt.setupTimeoutAttributes(proxyAwareConnection, httpRequestData2);
        if (proxyAwareConnection instanceof HttpsURLConnection) {
        }
        proxyAwareConnection.setRequestMethod(httpRequestData2.getMethod().getValue());
        proxyAwareConnection.setUseCaches(false);
        proxyAwareConnection.setInstanceFollowRedirects(false);
        UtilsKt.mergeHeaders(httpRequestData2.getHeaders(), body2, new Function2<String, String, Unit>() { // from class: io.ktor.client.engine.android.AndroidClientEngine$execute$connection$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str22, String str3) {
                invoke2(str22, str3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String key, String value) {
                Intrinsics.checkNotNullParameter(key, "key");
                Intrinsics.checkNotNullParameter(value, "value");
                proxyAwareConnection.addRequestProperty(key, value);
            }
        });
        androidClientEngine.getConfig().getRequestConfig().invoke(proxyAwareConnection);
        list = AndroidClientEngineKt.METHODS_WITHOUT_BODY;
        if (!list.contains(httpRequestData2.getMethod())) {
        }
    }

    private final HttpURLConnection getProxyAwareConnection(String urlString) {
        URL url = new URL(urlString);
        Proxy proxy = getConfig().getProxy();
        URLConnection openConnection = proxy != null ? url.openConnection(proxy) : null;
        if (openConnection == null) {
            openConnection = url.openConnection();
            Intrinsics.checkNotNullExpressionValue(openConnection, "url.openConnection()");
        }
        return (HttpURLConnection) openConnection;
    }
}
