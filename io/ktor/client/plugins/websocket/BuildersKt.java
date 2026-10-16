package io.ktor.client.plugins.websocket;

import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPluginKt;
import io.ktor.client.plugins.websocket.WebSockets;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpStatement;
import io.ktor.client.utils.ExceptionUtilsJvmKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.URLBuilder;
import io.ktor.http.URLParserKt;
import io.ktor.http.URLProtocol;
import io.ktor.util.reflect.TypeInfo;
import io.ktor.util.reflect.TypeInfoJvmKt;
import io.ktor.websocket.WebSocketSessionKt;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.TypesJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* compiled from: builders.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u001a'\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0017\u0010\u0003\u001a\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006\u001aW\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0087\u0001\u0010\u0007\u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010\u0007\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001a.\u0010\u001b\u001a\u00020\r*\u00020\b2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a^\u0010\u001b\u001a\u00020\r*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a8\u0010\u001b\u001a\u00020\r*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aW\u0010\u001f\u001a\u00020\u0001*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0087\u0001\u0010\u001f\u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010\u001f\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u001aW\u0010 \u001a\u00020\u0001*\u00020\b2\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u0087\u0001\u0010 \u001a\u00020\u0001*\u00020\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aa\u0010 \u001a\u00020\u0001*\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00142\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\u0002\b\u00062'\u0010\u000b\u001a#\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\f¢\u0006\u0002\b\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"WebSockets", "", "Lio/ktor/client/HttpClientConfig;", "config", "Lkotlin/Function1;", "Lio/ktor/client/plugins/websocket/WebSockets$Config;", "Lkotlin/ExtensionFunctionType;", "webSocket", "Lio/ktor/client/HttpClient;", AdActivity.REQUEST_KEY_EXTRA, "Lio/ktor/client/request/HttpRequestBuilder;", "block", "Lkotlin/Function2;", "Lio/ktor/client/plugins/websocket/DefaultClientWebSocketSession;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "method", "Lio/ktor/http/HttpMethod;", "host", "", "port", "", "path", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlString", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "webSocketSession", "(Lio/ktor/client/HttpClient;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Lio/ktor/http/HttpMethod;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lio/ktor/client/HttpClient;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ws", "wss", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BuildersKt {
    public static final void WebSockets(HttpClientConfig<?> httpClientConfig, final Function1<? super WebSockets.Config, Unit> config) {
        Intrinsics.checkNotNullParameter(httpClientConfig, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        httpClientConfig.install(WebSockets.INSTANCE, new Function1<WebSockets.Config, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$WebSockets$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WebSockets.Config config2) {
                invoke2(config2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WebSockets.Config install) {
                Intrinsics.checkNotNullParameter(install, "$this$install");
                config.invoke(install);
            }
        });
    }

    public static final Object webSocketSession(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        HttpClientPluginKt.plugin(httpClient, WebSockets.INSTANCE);
        CompletableDeferred CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
        httpRequestBuilder.url(new Function2<URLBuilder, URLBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$statement$1$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
                invoke2(uRLBuilder, uRLBuilder2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(URLBuilder url, URLBuilder it) {
                Intrinsics.checkNotNullParameter(url, "$this$url");
                Intrinsics.checkNotNullParameter(it, "it");
                url.setProtocol(URLProtocol.INSTANCE.getWS());
                url.setPort(url.getProtocol().getDefaultPort());
            }
        });
        function1.invoke(httpRequestBuilder);
        BuildersKt__Builders_commonKt.launch$default(httpClient, null, null, new BuildersKt$webSocketSession$2(new HttpStatement(httpRequestBuilder, httpClient), CompletableDeferred$default, null), 3, null);
        return CompletableDeferred$default.await(continuation);
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = HttpMethod.INSTANCE.getGet();
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return webSocketSession(httpClient, httpMethod, str, num, str2, function1, continuation);
    }

    public static final Object webSocketSession(HttpClient httpClient, final HttpMethod httpMethod, final String str, final Integer num, final String str2, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        return webSocketSession(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocketSession) {
                Intrinsics.checkNotNullParameter(webSocketSession, "$this$webSocketSession");
                webSocketSession.setMethod(HttpMethod.this);
                HttpRequestKt.url$default(webSocketSession, "ws", str, num, str2, null, 16, null);
                function1.invoke(webSocketSession);
            }
        }, continuation);
    }

    public static /* synthetic */ Object webSocketSession$default(HttpClient httpClient, String str, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$7
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return webSocketSession(httpClient, str, function1, continuation);
    }

    public static final Object webSocketSession(HttpClient httpClient, final String str, final Function1<? super HttpRequestBuilder, Unit> function1, Continuation<? super DefaultClientWebSocketSession> continuation) {
        return webSocketSession(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocketSession$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocketSession) {
                Intrinsics.checkNotNullParameter(webSocketSession, "$this$webSocketSession");
                URLParserKt.takeFrom(webSocketSession.getUrl(), str);
                function1.invoke(webSocketSession);
            }
        }, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(3:(2:3|(4:5|6|7|8))|7|8) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0144, code lost:
    
        if (r2.cleanup(r10, r0) == r1) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0183, code lost:
    
        if (r2.cleanup(r10, r0) != r1) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0095, code lost:
    
        r8 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0104 A[Catch: all -> 0x0095, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0095, blocks: (B:20:0x0050, B:21:0x0161, B:22:0x0168, B:24:0x0063, B:25:0x012e, B:33:0x011b, B:39:0x014c, B:43:0x0090, B:45:0x0104, B:53:0x0169, B:54:0x0170), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0169 A[Catch: all -> 0x0095, TryCatch #1 {all -> 0x0095, blocks: (B:20:0x0050, B:21:0x0161, B:22:0x0168, B:24:0x0063, B:25:0x012e, B:33:0x011b, B:39:0x014c, B:43:0x0090, B:45:0x0104, B:53:0x0169, B:54:0x0170), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Object, kotlin.jvm.functions.Function2<? super io.ktor.client.plugins.websocket.DefaultClientWebSocketSession, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>] */
    /* JADX WARN: Type inference failed for: r10v1, types: [io.ktor.client.statement.HttpResponse] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [io.ktor.client.statement.HttpStatement] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object webSocket(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        BuildersKt$webSocket$1 buildersKt$webSocket$1;
        ?? r2;
        Function2 function22;
        HttpResponse httpResponse;
        HttpResponse httpResponse2;
        Function2 function23;
        HttpStatement httpStatement;
        DefaultClientWebSocketSession defaultClientWebSocketSession;
        DefaultClientWebSocketSession defaultClientWebSocketSession2;
        HttpStatement httpStatement2;
        HttpStatement httpStatement3;
        HttpStatement httpStatement4;
        try {
            if (continuation instanceof BuildersKt$webSocket$1) {
                buildersKt$webSocket$1 = (BuildersKt$webSocket$1) continuation;
                if ((buildersKt$webSocket$1.label & Integer.MIN_VALUE) != 0) {
                    buildersKt$webSocket$1.label -= Integer.MIN_VALUE;
                    Object obj = buildersKt$webSocket$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r2 = buildersKt$webSocket$1.label;
                    switch (r2) {
                        case 0:
                            ResultKt.throwOnFailure(obj);
                            HttpClientPluginKt.plugin(httpClient, WebSockets.INSTANCE);
                            HttpRequestBuilder httpRequestBuilder = new HttpRequestBuilder();
                            httpRequestBuilder.url(new Function2<URLBuilder, URLBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocket$session$1$1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(URLBuilder uRLBuilder, URLBuilder uRLBuilder2) {
                                    invoke2(uRLBuilder, uRLBuilder2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(URLBuilder url, URLBuilder it) {
                                    Intrinsics.checkNotNullParameter(url, "$this$url");
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    url.setProtocol(URLProtocol.INSTANCE.getWS());
                                }
                            });
                            function1.invoke(httpRequestBuilder);
                            HttpStatement httpStatement5 = new HttpStatement(httpRequestBuilder, httpClient);
                            buildersKt$webSocket$1.L$0 = function2;
                            buildersKt$webSocket$1.L$1 = httpStatement5;
                            buildersKt$webSocket$1.label = 1;
                            obj = httpStatement5.executeUnsafe(buildersKt$webSocket$1);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            r2 = httpStatement5;
                            function22 = function2;
                            httpResponse = (HttpResponse) obj;
                            try {
                                HttpClientCall call = httpResponse.getCall();
                                KType typeOf = Reflection.typeOf(DefaultClientWebSocketSession.class);
                                TypeInfo typeInfoImpl = TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf), Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class), typeOf);
                                buildersKt$webSocket$1.L$0 = function22;
                                buildersKt$webSocket$1.L$1 = r2;
                                buildersKt$webSocket$1.L$2 = httpResponse;
                                buildersKt$webSocket$1.label = 2;
                                obj = call.bodyNullable(typeInfoImpl, buildersKt$webSocket$1);
                                if (obj != coroutine_suspended) {
                                    Function2 function24 = function22;
                                    httpResponse2 = httpResponse;
                                    function23 = function24;
                                    httpStatement = r2;
                                    if (obj != null) {
                                        throw new NullPointerException("null cannot be cast to non-null type io.ktor.client.plugins.websocket.DefaultClientWebSocketSession");
                                    }
                                    DefaultClientWebSocketSession defaultClientWebSocketSession3 = (DefaultClientWebSocketSession) obj;
                                    BuildersKt$webSocket$1 buildersKt$webSocket$12 = buildersKt$webSocket$1;
                                    try {
                                        buildersKt$webSocket$1.L$0 = httpStatement;
                                        buildersKt$webSocket$1.L$1 = httpResponse2;
                                        buildersKt$webSocket$1.L$2 = defaultClientWebSocketSession3;
                                        buildersKt$webSocket$1.label = 3;
                                        if (function23.invoke(defaultClientWebSocketSession3, buildersKt$webSocket$1) != coroutine_suspended) {
                                            defaultClientWebSocketSession2 = defaultClientWebSocketSession3;
                                            httpStatement3 = httpStatement;
                                            buildersKt$webSocket$1.L$0 = httpStatement3;
                                            buildersKt$webSocket$1.L$1 = httpResponse2;
                                            buildersKt$webSocket$1.L$2 = defaultClientWebSocketSession2;
                                            buildersKt$webSocket$1.label = 4;
                                            httpStatement4 = httpStatement3;
                                            if (WebSocketSessionKt.close$default(defaultClientWebSocketSession2, null, buildersKt$webSocket$1, 1, null) == coroutine_suspended) {
                                            }
                                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession2.getIncoming(), (CancellationException) null, 1, (Object) null);
                                            buildersKt$webSocket$1.L$0 = Unit.INSTANCE;
                                            buildersKt$webSocket$1.L$1 = null;
                                            buildersKt$webSocket$1.L$2 = null;
                                            buildersKt$webSocket$1.label = 6;
                                            break;
                                        }
                                    } catch (Throwable th) {
                                        th = th;
                                        defaultClientWebSocketSession = defaultClientWebSocketSession3;
                                        httpStatement2 = httpStatement;
                                        buildersKt$webSocket$1.L$0 = httpStatement2;
                                        buildersKt$webSocket$1.L$1 = httpResponse2;
                                        buildersKt$webSocket$1.L$2 = defaultClientWebSocketSession;
                                        buildersKt$webSocket$1.L$3 = th;
                                        buildersKt$webSocket$1.label = 5;
                                        if (WebSocketSessionKt.close$default(defaultClientWebSocketSession, null, buildersKt$webSocket$1, 1, null) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession.getIncoming(), (CancellationException) null, 1, (Object) null);
                                        throw th;
                                    }
                                }
                            } catch (Throwable th2) {
                                function2 = httpResponse;
                                th = th2;
                                buildersKt$webSocket$1.L$0 = th;
                                buildersKt$webSocket$1.L$1 = null;
                                buildersKt$webSocket$1.L$2 = null;
                                buildersKt$webSocket$1.L$3 = null;
                                buildersKt$webSocket$1.label = 7;
                                break;
                            }
                            return coroutine_suspended;
                        case 1:
                            HttpStatement httpStatement6 = (HttpStatement) buildersKt$webSocket$1.L$1;
                            Function2 function25 = (Function2) buildersKt$webSocket$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            r2 = httpStatement6;
                            function22 = function25;
                            httpResponse = (HttpResponse) obj;
                            HttpClientCall call2 = httpResponse.getCall();
                            KType typeOf2 = Reflection.typeOf(DefaultClientWebSocketSession.class);
                            TypeInfo typeInfoImpl2 = TypeInfoJvmKt.typeInfoImpl(TypesJVMKt.getJavaType(typeOf2), Reflection.getOrCreateKotlinClass(DefaultClientWebSocketSession.class), typeOf2);
                            buildersKt$webSocket$1.L$0 = function22;
                            buildersKt$webSocket$1.L$1 = r2;
                            buildersKt$webSocket$1.L$2 = httpResponse;
                            buildersKt$webSocket$1.label = 2;
                            obj = call2.bodyNullable(typeInfoImpl2, buildersKt$webSocket$1);
                            if (obj != coroutine_suspended) {
                            }
                            return coroutine_suspended;
                        case 2:
                            httpResponse2 = (HttpResponse) buildersKt$webSocket$1.L$2;
                            HttpStatement httpStatement7 = (HttpStatement) buildersKt$webSocket$1.L$1;
                            function23 = (Function2) buildersKt$webSocket$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            httpStatement = httpStatement7;
                            if (obj != null) {
                            }
                            break;
                        case 3:
                            defaultClientWebSocketSession2 = (DefaultClientWebSocketSession) buildersKt$webSocket$1.L$2;
                            HttpResponse httpResponse3 = (HttpResponse) buildersKt$webSocket$1.L$1;
                            HttpStatement httpStatement8 = (HttpStatement) buildersKt$webSocket$1.L$0;
                            try {
                                ResultKt.throwOnFailure(obj);
                                httpStatement3 = httpStatement8;
                                httpResponse2 = httpResponse3;
                                buildersKt$webSocket$1.L$0 = httpStatement3;
                                buildersKt$webSocket$1.L$1 = httpResponse2;
                                buildersKt$webSocket$1.L$2 = defaultClientWebSocketSession2;
                                buildersKt$webSocket$1.label = 4;
                                httpStatement4 = httpStatement3;
                                if (WebSocketSessionKt.close$default(defaultClientWebSocketSession2, null, buildersKt$webSocket$1, 1, null) == coroutine_suspended) {
                                }
                                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession2.getIncoming(), (CancellationException) null, 1, (Object) null);
                                buildersKt$webSocket$1.L$0 = Unit.INSTANCE;
                                buildersKt$webSocket$1.L$1 = null;
                                buildersKt$webSocket$1.L$2 = null;
                                buildersKt$webSocket$1.label = 6;
                                break;
                            } catch (Throwable th3) {
                                httpStatement2 = httpStatement8;
                                httpResponse2 = httpResponse3;
                                defaultClientWebSocketSession = defaultClientWebSocketSession2;
                                th = th3;
                                buildersKt$webSocket$1.L$0 = httpStatement2;
                                buildersKt$webSocket$1.L$1 = httpResponse2;
                                buildersKt$webSocket$1.L$2 = defaultClientWebSocketSession;
                                buildersKt$webSocket$1.L$3 = th;
                                buildersKt$webSocket$1.label = 5;
                                if (WebSocketSessionKt.close$default(defaultClientWebSocketSession, null, buildersKt$webSocket$1, 1, null) == coroutine_suspended) {
                                }
                                ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession.getIncoming(), (CancellationException) null, 1, (Object) null);
                                throw th;
                            }
                            break;
                        case 4:
                            defaultClientWebSocketSession2 = (DefaultClientWebSocketSession) buildersKt$webSocket$1.L$2;
                            httpResponse2 = (HttpResponse) buildersKt$webSocket$1.L$1;
                            HttpStatement httpStatement9 = (HttpStatement) buildersKt$webSocket$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            httpStatement4 = httpStatement9;
                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession2.getIncoming(), (CancellationException) null, 1, (Object) null);
                            buildersKt$webSocket$1.L$0 = Unit.INSTANCE;
                            buildersKt$webSocket$1.L$1 = null;
                            buildersKt$webSocket$1.L$2 = null;
                            buildersKt$webSocket$1.label = 6;
                            break;
                        case 5:
                            th = (Throwable) buildersKt$webSocket$1.L$3;
                            defaultClientWebSocketSession = (DefaultClientWebSocketSession) buildersKt$webSocket$1.L$2;
                            ResultKt.throwOnFailure(obj);
                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) defaultClientWebSocketSession.getIncoming(), (CancellationException) null, 1, (Object) null);
                            throw th;
                        case 6:
                            ResultKt.throwOnFailure(obj);
                            return Unit.INSTANCE;
                        case 7:
                            th = (Throwable) buildersKt$webSocket$1.L$0;
                            ResultKt.throwOnFailure(obj);
                            throw th;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            switch (r2) {
            }
        } catch (CancellationException e) {
            throw ExceptionUtilsJvmKt.unwrapCancellationException(e);
        }
        buildersKt$webSocket$1 = new BuildersKt$webSocket$1(continuation);
        Object obj2 = buildersKt$webSocket$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = buildersKt$webSocket$1.label;
    }

    public static /* synthetic */ Object webSocket$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = HttpMethod.INSTANCE.getGet();
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocket$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        Function1 function12 = function1;
        return webSocket(httpClient, httpMethod, str, num, str2, function12, function2, continuation);
    }

    public static final Object webSocket(HttpClient httpClient, final HttpMethod httpMethod, final String str, final Integer num, final String str2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocket$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocket2) {
                Intrinsics.checkNotNullParameter(webSocket2, "$this$webSocket");
                webSocket2.setMethod(HttpMethod.this);
                HttpRequestKt.url$default(webSocket2, "ws", str, num, str2, null, 16, null);
                function1.invoke(webSocket2);
            }
        }, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object webSocket$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocket$7
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return webSocket(httpClient, str, function1, function2, continuation);
    }

    public static final Object webSocket(HttpClient httpClient, final String str, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, HttpMethod.INSTANCE.getGet(), null, null, null, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$webSocket$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocket2) {
                Intrinsics.checkNotNullParameter(webSocket2, "$this$webSocket");
                webSocket2.getUrl().setProtocol(URLProtocol.INSTANCE.getWS());
                webSocket2.getUrl().setPort(UtilsKt.getPort(webSocket2));
                URLParserKt.takeFrom(webSocket2.getUrl(), str);
                function1.invoke(webSocket2);
            }
        }, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object ws$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = HttpMethod.INSTANCE.getGet();
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$ws$2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        Function1 function12 = function1;
        return ws(httpClient, httpMethod, str, num, str2, function12, function2, continuation);
    }

    public static final Object ws(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, httpMethod, str, num, str2, function1, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static final Object ws(HttpClient httpClient, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, function1, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object ws$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$ws$5
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return ws(httpClient, str, function1, function2, continuation);
    }

    public static final Object ws(HttpClient httpClient, String str, Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, str, function1, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static final Object wss(HttpClient httpClient, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$wss$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocket2) {
                Intrinsics.checkNotNullParameter(webSocket2, "$this$webSocket");
                webSocket2.getUrl().setProtocol(URLProtocol.INSTANCE.getWSS());
                webSocket2.getUrl().setPort(webSocket2.getUrl().getProtocol().getDefaultPort());
                function1.invoke(webSocket2);
            }
        }, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }

    public static /* synthetic */ Object wss$default(HttpClient httpClient, String str, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$wss$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        return wss(httpClient, str, function1, function2, continuation);
    }

    public static final Object wss(HttpClient httpClient, final String str, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object wss = wss(httpClient, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$wss$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder wss2) {
                Intrinsics.checkNotNullParameter(wss2, "$this$wss");
                URLParserKt.takeFrom(wss2.getUrl(), str);
                function1.invoke(wss2);
            }
        }, function2, continuation);
        return wss == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? wss : Unit.INSTANCE;
    }

    public static /* synthetic */ Object wss$default(HttpClient httpClient, HttpMethod httpMethod, String str, Integer num, String str2, Function1 function1, Function2 function2, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            httpMethod = HttpMethod.INSTANCE.getGet();
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            num = null;
        }
        if ((i & 8) != 0) {
            str2 = null;
        }
        if ((i & 16) != 0) {
            function1 = new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$wss$7
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpRequestBuilder httpRequestBuilder) {
                    Intrinsics.checkNotNullParameter(httpRequestBuilder, "$this$null");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                    invoke2(httpRequestBuilder);
                    return Unit.INSTANCE;
                }
            };
        }
        Function1 function12 = function1;
        return wss(httpClient, httpMethod, str, num, str2, function12, function2, continuation);
    }

    public static final Object wss(HttpClient httpClient, HttpMethod httpMethod, String str, final Integer num, String str2, final Function1<? super HttpRequestBuilder, Unit> function1, Function2<? super DefaultClientWebSocketSession, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        Object webSocket = webSocket(httpClient, httpMethod, str, num, str2, new Function1<HttpRequestBuilder, Unit>() { // from class: io.ktor.client.plugins.websocket.BuildersKt$wss$8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(HttpRequestBuilder httpRequestBuilder) {
                invoke2(httpRequestBuilder);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(HttpRequestBuilder webSocket2) {
                Intrinsics.checkNotNullParameter(webSocket2, "$this$webSocket");
                webSocket2.getUrl().setProtocol(URLProtocol.INSTANCE.getWSS());
                if (num != null) {
                    webSocket2.getUrl().setPort(num.intValue());
                }
                function1.invoke(webSocket2);
            }
        }, function2, continuation);
        return webSocket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? webSocket : Unit.INSTANCE;
    }
}
