package io.ktor.client.engine;

import io.ktor.client.HttpClient;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.util.InternalAPI;
import java.io.Closeable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

/* compiled from: HttpClientEngine.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00060\u0002j\u0002`\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0016H§@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0014\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016H\u0082@ø\u0001\u0000J\u0010\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0017R\u000b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00100\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lio/ktor/client/engine/HttpClientEngine;", "Lkotlinx/coroutines/CoroutineScope;", "Ljava/io/Closeable;", "Lio/ktor/utils/io/core/Closeable;", "closed", "", "config", "Lio/ktor/client/engine/HttpClientEngineConfig;", "getConfig", "()Lio/ktor/client/engine/HttpClientEngineConfig;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "supportedCapabilities", "", "Lio/ktor/client/engine/HttpClientEngineCapability;", "getSupportedCapabilities", "()Ljava/util/Set;", "checkExtensions", "", "requestData", "Lio/ktor/client/request/HttpRequestData;", "execute", "Lio/ktor/client/request/HttpResponseData;", "data", "(Lio/ktor/client/request/HttpRequestData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeWithinCallContext", "install", "client", "Lio/ktor/client/HttpClient;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public interface HttpClientEngine extends CoroutineScope, Closeable {
    @InternalAPI
    Object execute(HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation);

    HttpClientEngineConfig getConfig();

    CoroutineDispatcher getDispatcher();

    Set<HttpClientEngineCapability<?>> getSupportedCapabilities();

    @InternalAPI
    void install(HttpClient client);

    /* compiled from: HttpClientEngine.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Set<HttpClientEngineCapability<?>> getSupportedCapabilities(HttpClientEngine httpClientEngine) {
            return SetsKt.emptySet();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean getClosed(HttpClientEngine httpClientEngine) {
            return !(((Job) httpClientEngine.getCoroutineContext().get(Job.INSTANCE)) != null ? r1.isActive() : false);
        }

        @InternalAPI
        public static void install(HttpClientEngine httpClientEngine, HttpClient client) {
            Intrinsics.checkNotNullParameter(client, "client");
            client.getSendPipeline().intercept(HttpSendPipeline.INSTANCE.getEngine(), new HttpClientEngine$install$1(client, httpClientEngine, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0053, code lost:
        
            if (r12 == r1) goto L22;
         */
        /* JADX WARN: Removed duplicated region for block: B:18:0x0082 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0083 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Object executeWithinCallContext(HttpClientEngine httpClientEngine, HttpRequestData httpRequestData, Continuation<? super HttpResponseData> continuation) {
            HttpClientEngine$executeWithinCallContext$1 httpClientEngine$executeWithinCallContext$1;
            int i;
            Deferred async$default;
            if (continuation instanceof HttpClientEngine$executeWithinCallContext$1) {
                httpClientEngine$executeWithinCallContext$1 = (HttpClientEngine$executeWithinCallContext$1) continuation;
                if ((httpClientEngine$executeWithinCallContext$1.label & Integer.MIN_VALUE) != 0) {
                    httpClientEngine$executeWithinCallContext$1.label -= Integer.MIN_VALUE;
                    Object obj = httpClientEngine$executeWithinCallContext$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = httpClientEngine$executeWithinCallContext$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Job executionContext = httpRequestData.getExecutionContext();
                        httpClientEngine$executeWithinCallContext$1.L$0 = httpClientEngine;
                        httpClientEngine$executeWithinCallContext$1.L$1 = httpRequestData;
                        httpClientEngine$executeWithinCallContext$1.label = 1;
                        obj = HttpClientEngineKt.createCallContext(httpClientEngine, executionContext, httpClientEngine$executeWithinCallContext$1);
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        httpRequestData = (HttpRequestData) httpClientEngine$executeWithinCallContext$1.L$1;
                        httpClientEngine = (HttpClientEngine) httpClientEngine$executeWithinCallContext$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    }
                    CoroutineContext coroutineContext = (CoroutineContext) obj;
                    async$default = BuildersKt__Builders_commonKt.async$default(httpClientEngine, coroutineContext.plus(new KtorCallContextElement(coroutineContext)), null, new HttpClientEngine$executeWithinCallContext$2(httpClientEngine, httpRequestData, null), 2, null);
                    httpClientEngine$executeWithinCallContext$1.L$0 = null;
                    httpClientEngine$executeWithinCallContext$1.L$1 = null;
                    httpClientEngine$executeWithinCallContext$1.label = 2;
                    Object await = async$default.await(httpClientEngine$executeWithinCallContext$1);
                    return await != coroutine_suspended ? coroutine_suspended : await;
                }
            }
            httpClientEngine$executeWithinCallContext$1 = new HttpClientEngine$executeWithinCallContext$1(continuation);
            Object obj2 = httpClientEngine$executeWithinCallContext$1.result;
            Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            i = httpClientEngine$executeWithinCallContext$1.label;
            if (i != 0) {
            }
            CoroutineContext coroutineContext2 = (CoroutineContext) obj2;
            async$default = BuildersKt__Builders_commonKt.async$default(httpClientEngine, coroutineContext2.plus(new KtorCallContextElement(coroutineContext2)), null, new HttpClientEngine$executeWithinCallContext$2(httpClientEngine, httpRequestData, null), 2, null);
            httpClientEngine$executeWithinCallContext$1.L$0 = null;
            httpClientEngine$executeWithinCallContext$1.L$1 = null;
            httpClientEngine$executeWithinCallContext$1.label = 2;
            Object await2 = async$default.await(httpClientEngine$executeWithinCallContext$1);
            if (await2 != coroutine_suspended2) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void checkExtensions(HttpClientEngine httpClientEngine, HttpRequestData httpRequestData) {
            for (HttpClientEngineCapability<?> httpClientEngineCapability : httpRequestData.getRequiredCapabilities$ktor_client_core()) {
                if (!httpClientEngine.getSupportedCapabilities().contains(httpClientEngineCapability)) {
                    throw new IllegalArgumentException(("Engine doesn't support " + httpClientEngineCapability).toString());
                }
            }
        }
    }
}
