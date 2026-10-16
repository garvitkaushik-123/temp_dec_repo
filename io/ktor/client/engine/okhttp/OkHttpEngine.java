package io.ktor.client.engine.okhttp;

import com.ironsource.C3337ue;
import io.ktor.client.engine.HttpClientEngineBase;
import io.ktor.client.engine.HttpClientEngineCapability;
import io.ktor.client.engine.UtilsKt;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.plugins.websocket.WebSocketCapability;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpRequestKt;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.utils.CoroutineDispatcherUtilsKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.util.CacheKt;
import io.ktor.util.CoroutinesUtilsKt;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import java.io.Closeable;
import java.net.Proxy;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: OkHttpEngine.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 42\u00020\u0001:\u00014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\fH\u0002J\b\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010\u0007H\u0002J\u0019\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010+J1\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/2\u0006\u0010#\u001a\u00020\f2\u0006\u00100\u001a\u00020*H\u0082@ø\u0001\u0000¢\u0006\u0002\u00101J)\u00102\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\b2\u0006\u0010.\u001a\u00020/2\u0006\u0010#\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u00103R\u001c\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00180\u0017X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpEngine;", "Lio/ktor/client/engine/HttpClientEngineBase;", "config", "Lio/ktor/client/engine/okhttp/OkHttpConfig;", "(Lio/ktor/client/engine/okhttp/OkHttpConfig;)V", "clientCache", "", "Lio/ktor/client/plugins/HttpTimeout$HttpTimeoutCapabilityConfiguration;", "Lokhttp3/OkHttpClient;", "getConfig", "()Lio/ktor/client/engine/okhttp/OkHttpConfig;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher$delegate", "Lkotlin/Lazy;", "requestsJob", "supportedCapabilities", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getSupportedCapabilities", "()Ljava/util/Set;", "buildResponseData", "Lio/ktor/client/request/HttpResponseData;", C3337ue.n, "Lokhttp3/Response;", "requestTime", "Lio/ktor/util/date/GMTDate;", "body", "", "callContext", "close", "", "createOkHttpClient", "timeoutExtension", "execute", "data", "Lio/ktor/client/request/HttpRequestData;", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeHttpRequest", "engine", "engineRequest", "Lokhttp3/Request;", "requestData", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeWebSocketRequest", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "ktor-client-okhttp"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes8.dex */
public final class OkHttpEngine extends HttpClientEngineBase {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    private static final Lazy<OkHttpClient> okHttpClientPrototype$delegate = LazyKt.lazy(new Function0<OkHttpClient>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$Companion$okHttpClientPrototype$2
        @Override // kotlin.jvm.functions.Function0
        public final OkHttpClient invoke() {
            return new OkHttpClient.Builder().build();
        }
    });
    private final Map<HttpTimeout.HttpTimeoutCapabilityConfiguration, OkHttpClient> clientCache;
    private final OkHttpConfig config;
    private final CoroutineContext coroutineContext;

    /* renamed from: dispatcher$delegate, reason: from kotlin metadata */
    private final Lazy dispatcher;
    private final CoroutineContext requestsJob;
    private final Set<HttpClientEngineCapability<?>> supportedCapabilities;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkHttpEngine(OkHttpConfig config) {
        super("ktor-okhttp");
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.dispatcher = LazyKt.lazy(new Function0<CoroutineDispatcher>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$dispatcher$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineDispatcher invoke() {
                return CoroutineDispatcherUtilsKt.clientDispatcher(Dispatchers.INSTANCE, OkHttpEngine.this.getConfig().getThreadsCount(), "ktor-okhttp-dispatcher");
            }
        });
        this.supportedCapabilities = SetsKt.setOf((Object[]) new HttpClientEngineCapability[]{HttpTimeout.INSTANCE, WebSocketCapability.INSTANCE});
        this.clientCache = CacheKt.createLRUCache(new OkHttpEngine$clientCache$1(this), new Function1<OkHttpClient, Unit>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$clientCache$2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(OkHttpClient it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(OkHttpClient okHttpClient) {
                invoke2(okHttpClient);
                return Unit.INSTANCE;
            }
        }, getConfig().getClientCacheSize());
        CoroutineContext.Element element = super.getCoroutineContext().get(Job.INSTANCE);
        Intrinsics.checkNotNull(element);
        CoroutineContext SilentSupervisor = CoroutinesUtilsKt.SilentSupervisor((Job) element);
        this.requestsJob = SilentSupervisor;
        this.coroutineContext = super.getCoroutineContext().plus(SilentSupervisor);
        BuildersKt.launch(GlobalScope.INSTANCE, super.getCoroutineContext(), CoroutineStart.ATOMIC, new AnonymousClass1(null));
    }

    @Override // io.ktor.client.engine.HttpClientEngine
    public OkHttpConfig getConfig() {
        return this.config;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public CoroutineDispatcher getDispatcher() {
        return (CoroutineDispatcher) this.dispatcher.getValue();
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, io.ktor.client.engine.HttpClientEngine
    public Set<HttpClientEngineCapability<?>> getSupportedCapabilities() {
        return this.supportedCapabilities;
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    /* compiled from: OkHttpEngine.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "io.ktor.client.engine.okhttp.OkHttpEngine$1", f = "OkHttpEngine.kt", i = {}, l = {59}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: io.ktor.client.engine.okhttp.OkHttpEngine$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return OkHttpEngine.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineContext.Element element = OkHttpEngine.this.requestsJob.get(Job.INSTANCE);
                    Intrinsics.checkNotNull(element);
                    this.label = 1;
                    if (((Job) element).join(this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                while (it.hasNext()) {
                    OkHttpClient okHttpClient = (OkHttpClient) ((Map.Entry) it.next()).getValue();
                    okHttpClient.connectionPool().evictAll();
                    okHttpClient.dispatcher().executorService().shutdown();
                }
                CoroutineContext.Element dispatcher = OkHttpEngine.this.getDispatcher();
                Intrinsics.checkNotNull(dispatcher, "null cannot be cast to non-null type java.io.Closeable");
                ((Closeable) dispatcher).close();
                return Unit.INSTANCE;
            } finally {
                it = OkHttpEngine.this.clientCache.entrySet().iterator();
                while (it.hasNext()) {
                    OkHttpClient okHttpClient2 = (OkHttpClient) ((Map.Entry) it.next()).getValue();
                    okHttpClient2.connectionPool().evictAll();
                    okHttpClient2.dispatcher().executorService().shutdown();
                }
                CoroutineContext.Element dispatcher2 = OkHttpEngine.this.getDispatcher();
                Intrinsics.checkNotNull(dispatcher2, "null cannot be cast to non-null type java.io.Closeable");
                ((Closeable) dispatcher2).close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // io.ktor.client.engine.HttpClientEngine
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object execute(HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation) {
        OkHttpEngine$execute$1 okHttpEngine$execute$1;
        int i;
        OkHttpEngine okHttpEngine;
        Request convertToOkHttpRequest;
        OkHttpClient okHttpClient;
        if (continuation instanceof OkHttpEngine$execute$1) {
            okHttpEngine$execute$1 = (OkHttpEngine$execute$1) continuation;
            if ((okHttpEngine$execute$1.label & Integer.MIN_VALUE) != 0) {
                okHttpEngine$execute$1.label -= Integer.MIN_VALUE;
                OkHttpEngine$execute$1 okHttpEngine$execute$12 = okHttpEngine$execute$1;
                Object obj = okHttpEngine$execute$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = okHttpEngine$execute$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    okHttpEngine$execute$12.L$0 = this;
                    okHttpEngine$execute$12.L$1 = httpRequestData;
                    okHttpEngine$execute$12.label = 1;
                    obj = UtilsKt.callContext(okHttpEngine$execute$12);
                    if (obj != coroutine_suspended) {
                        okHttpEngine = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return obj;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return obj;
                }
                httpRequestData = (HttpRequestData) okHttpEngine$execute$12.L$1;
                okHttpEngine = (OkHttpEngine) okHttpEngine$execute$12.L$0;
                ResultKt.throwOnFailure(obj);
                HttpRequestData httpRequestData2 = httpRequestData;
                CoroutineContext coroutineContext = (CoroutineContext) obj;
                convertToOkHttpRequest = OkHttpEngineKt.convertToOkHttpRequest(httpRequestData2, coroutineContext);
                okHttpClient = okHttpEngine.clientCache.get(httpRequestData2.getCapabilityOrNull(HttpTimeout.INSTANCE));
                if (okHttpClient != null) {
                    throw new IllegalStateException("OkHttpClient can't be constructed because HttpTimeout plugin is not installed".toString());
                }
                if (HttpRequestKt.isUpgradeRequest(httpRequestData2)) {
                    okHttpEngine$execute$12.L$0 = null;
                    okHttpEngine$execute$12.L$1 = null;
                    okHttpEngine$execute$12.label = 2;
                    Object executeWebSocketRequest = okHttpEngine.executeWebSocketRequest(okHttpClient, convertToOkHttpRequest, coroutineContext, okHttpEngine$execute$12);
                    if (executeWebSocketRequest != coroutine_suspended) {
                        return executeWebSocketRequest;
                    }
                } else {
                    okHttpEngine$execute$12.L$0 = null;
                    okHttpEngine$execute$12.L$1 = null;
                    okHttpEngine$execute$12.label = 3;
                    Object executeHttpRequest = okHttpEngine.executeHttpRequest(okHttpClient, convertToOkHttpRequest, coroutineContext, httpRequestData2, okHttpEngine$execute$12);
                    if (executeHttpRequest != coroutine_suspended) {
                        return executeHttpRequest;
                    }
                }
                return coroutine_suspended;
            }
        }
        okHttpEngine$execute$1 = new OkHttpEngine$execute$1(this, continuation);
        OkHttpEngine$execute$1 okHttpEngine$execute$122 = okHttpEngine$execute$1;
        Object obj2 = okHttpEngine$execute$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = okHttpEngine$execute$122.label;
        if (i != 0) {
        }
        HttpRequestData httpRequestData22 = httpRequestData;
        CoroutineContext coroutineContext2 = (CoroutineContext) obj2;
        convertToOkHttpRequest = OkHttpEngineKt.convertToOkHttpRequest(httpRequestData22, coroutineContext2);
        okHttpClient = okHttpEngine.clientCache.get(httpRequestData22.getCapabilityOrNull(HttpTimeout.INSTANCE));
        if (okHttpClient != null) {
        }
    }

    @Override // io.ktor.client.engine.HttpClientEngineBase, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        CoroutineContext.Element element = this.requestsJob.get(Job.INSTANCE);
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type kotlinx.coroutines.CompletableJob");
        ((CompletableJob) element).complete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeWebSocketRequest(OkHttpClient okHttpClient, Request request, CoroutineContext coroutineContext, Continuation<? super HttpResponseData> continuation) {
        OkHttpEngine$executeWebSocketRequest$1 okHttpEngine$executeWebSocketRequest$1;
        int i;
        OkHttpEngine okHttpEngine;
        GMTDate gMTDate;
        OkHttpWebsocketSession okHttpWebsocketSession;
        if (continuation instanceof OkHttpEngine$executeWebSocketRequest$1) {
            okHttpEngine$executeWebSocketRequest$1 = (OkHttpEngine$executeWebSocketRequest$1) continuation;
            if ((okHttpEngine$executeWebSocketRequest$1.label & Integer.MIN_VALUE) != 0) {
                okHttpEngine$executeWebSocketRequest$1.label -= Integer.MIN_VALUE;
                Object obj = okHttpEngine$executeWebSocketRequest$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = okHttpEngine$executeWebSocketRequest$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    GMTDate GMTDate$default = DateJvmKt.GMTDate$default(null, 1, null);
                    OkHttpClient webSocketFactory = getConfig().getWebSocketFactory();
                    if (webSocketFactory == null) {
                        webSocketFactory = okHttpClient;
                    }
                    OkHttpWebsocketSession okHttpWebsocketSession2 = new OkHttpWebsocketSession(okHttpClient, webSocketFactory, request, coroutineContext);
                    okHttpWebsocketSession2.start();
                    CompletableDeferred<Response> originResponse$ktor_client_okhttp = okHttpWebsocketSession2.getOriginResponse$ktor_client_okhttp();
                    okHttpEngine$executeWebSocketRequest$1.L$0 = this;
                    okHttpEngine$executeWebSocketRequest$1.L$1 = coroutineContext;
                    okHttpEngine$executeWebSocketRequest$1.L$2 = GMTDate$default;
                    okHttpEngine$executeWebSocketRequest$1.L$3 = okHttpWebsocketSession2;
                    okHttpEngine$executeWebSocketRequest$1.label = 1;
                    Object await = originResponse$ktor_client_okhttp.await(okHttpEngine$executeWebSocketRequest$1);
                    if (await == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    okHttpEngine = this;
                    gMTDate = GMTDate$default;
                    obj = await;
                    okHttpWebsocketSession = okHttpWebsocketSession2;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    okHttpWebsocketSession = (OkHttpWebsocketSession) okHttpEngine$executeWebSocketRequest$1.L$3;
                    gMTDate = (GMTDate) okHttpEngine$executeWebSocketRequest$1.L$2;
                    coroutineContext = (CoroutineContext) okHttpEngine$executeWebSocketRequest$1.L$1;
                    okHttpEngine = (OkHttpEngine) okHttpEngine$executeWebSocketRequest$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return okHttpEngine.buildResponseData((Response) obj, gMTDate, okHttpWebsocketSession, coroutineContext);
            }
        }
        okHttpEngine$executeWebSocketRequest$1 = new OkHttpEngine$executeWebSocketRequest$1(this, continuation);
        Object obj2 = okHttpEngine$executeWebSocketRequest$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = okHttpEngine$executeWebSocketRequest$1.label;
        if (i != 0) {
        }
        return okHttpEngine.buildResponseData((Response) obj2, gMTDate, okHttpWebsocketSession, coroutineContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0086, code lost:
    
        r8 = io.ktor.client.engine.okhttp.OkHttpEngineKt.toChannel(r0, r7, r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object executeHttpRequest(OkHttpClient okHttpClient, Request request, CoroutineContext coroutineContext, HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation) {
        OkHttpEngine$executeHttpRequest$1 okHttpEngine$executeHttpRequest$1;
        int i;
        GMTDate gMTDate;
        OkHttpEngine okHttpEngine;
        final ResponseBody body;
        ByteReadChannel empty;
        if (continuation instanceof OkHttpEngine$executeHttpRequest$1) {
            okHttpEngine$executeHttpRequest$1 = (OkHttpEngine$executeHttpRequest$1) continuation;
            if ((okHttpEngine$executeHttpRequest$1.label & Integer.MIN_VALUE) != 0) {
                okHttpEngine$executeHttpRequest$1.label -= Integer.MIN_VALUE;
                Object obj = okHttpEngine$executeHttpRequest$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = okHttpEngine$executeHttpRequest$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    GMTDate GMTDate$default = DateJvmKt.GMTDate$default(null, 1, null);
                    okHttpEngine$executeHttpRequest$1.L$0 = this;
                    okHttpEngine$executeHttpRequest$1.L$1 = coroutineContext;
                    okHttpEngine$executeHttpRequest$1.L$2 = httpRequestData;
                    okHttpEngine$executeHttpRequest$1.L$3 = GMTDate$default;
                    okHttpEngine$executeHttpRequest$1.label = 1;
                    Object execute = OkUtilsKt.execute(okHttpClient, request, httpRequestData, okHttpEngine$executeHttpRequest$1);
                    if (execute == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = execute;
                    gMTDate = GMTDate$default;
                    okHttpEngine = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    gMTDate = (GMTDate) okHttpEngine$executeHttpRequest$1.L$3;
                    httpRequestData = (HttpRequestData) okHttpEngine$executeHttpRequest$1.L$2;
                    coroutineContext = (CoroutineContext) okHttpEngine$executeHttpRequest$1.L$1;
                    okHttpEngine = (OkHttpEngine) okHttpEngine$executeHttpRequest$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Response response = (Response) obj;
                body = response.body();
                CoroutineContext.Element element = coroutineContext.get(Job.INSTANCE);
                Intrinsics.checkNotNull(element);
                ((Job) element).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$2
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                        invoke2(th);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Throwable th) {
                        ResponseBody responseBody = ResponseBody.this;
                        if (responseBody != null) {
                            responseBody.close();
                        }
                    }
                });
                if (body != null || (r0 = body.getBodySource()) == null || empty == null) {
                    empty = ByteReadChannel.INSTANCE.getEmpty();
                }
                return okHttpEngine.buildResponseData(response, gMTDate, empty, coroutineContext);
            }
        }
        okHttpEngine$executeHttpRequest$1 = new OkHttpEngine$executeHttpRequest$1(this, continuation);
        Object obj2 = okHttpEngine$executeHttpRequest$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = okHttpEngine$executeHttpRequest$1.label;
        if (i != 0) {
        }
        Response response2 = (Response) obj2;
        body = response2.body();
        CoroutineContext.Element element2 = coroutineContext.get(Job.INSTANCE);
        Intrinsics.checkNotNull(element2);
        ((Job) element2).invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: io.ktor.client.engine.okhttp.OkHttpEngine$executeHttpRequest$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ResponseBody responseBody = ResponseBody.this;
                if (responseBody != null) {
                    responseBody.close();
                }
            }
        });
        if (body != null) {
        }
        empty = ByteReadChannel.INSTANCE.getEmpty();
        return okHttpEngine.buildResponseData(response2, gMTDate, empty, coroutineContext);
    }

    private final HttpResponseData buildResponseData(Response response, GMTDate requestTime, Object body, CoroutineContext callContext) {
        return new HttpResponseData(new HttpStatusCode(response.code(), response.message()), requestTime, OkUtilsKt.fromOkHttp(response.headers()), OkUtilsKt.fromOkHttp(response.protocol()), body, callContext);
    }

    /* compiled from: OkHttpEngine.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lio/ktor/client/engine/okhttp/OkHttpEngine$Companion;", "", "()V", "okHttpClientPrototype", "Lokhttp3/OkHttpClient;", "getOkHttpClientPrototype", "()Lokhttp3/OkHttpClient;", "okHttpClientPrototype$delegate", "Lkotlin/Lazy;", "ktor-client-okhttp"}, k = 1, mv = {1, 7, 1}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final OkHttpClient getOkHttpClientPrototype() {
            return (OkHttpClient) OkHttpEngine.okHttpClientPrototype$delegate.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final OkHttpClient createOkHttpClient(HttpTimeout.HttpTimeoutCapabilityConfiguration timeoutExtension) {
        OkHttpClient preconfigured = getConfig().getPreconfigured();
        if (preconfigured == null) {
            preconfigured = Companion.getOkHttpClientPrototype();
        }
        OkHttpClient.Builder newBuilder = preconfigured.newBuilder();
        newBuilder.dispatcher(new Dispatcher());
        getConfig().getConfig$ktor_client_okhttp().invoke(newBuilder);
        Proxy proxy = getConfig().getProxy();
        if (proxy != null) {
            newBuilder.proxy(proxy);
        }
        if (timeoutExtension != null) {
            OkHttpEngineKt.setupTimeoutAttributes(newBuilder, timeoutExtension);
        }
        return newBuilder.build();
    }
}
