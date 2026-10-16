package io.ktor.client.plugins.cache;

import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.ironsource.N6;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.UtilsKt;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaderValueParserKt;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.date.GMTDate;
import io.ktor.util.pipeline.PipelineContext;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCacheLegacy.kt */
@Metadata(d1 = {"\u0000`\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0001H\u0002\u001a:\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a\u001e\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a9\u0010\u0015\u001a\u00020\u0016*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u00172\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001a9\u0010\u001c\u001a\u00020\u0016*\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001aH\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a1\u0010\u001f\u001a\u00020\u0016*\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0019\u001a\u00020\u001aH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"cacheResponse", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/plugins/cache/HttpCache;", C3337ue.n, "(Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findAndRefresh", AdActivity.REQUEST_KEY_EXTRA, "Lio/ktor/client/request/HttpRequest;", "findResponse", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", C3040d4.a.k, "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "varyKeys", "", "", "url", "Lio/ktor/http/Url;", "context", "Lio/ktor/client/request/HttpRequestBuilder;", "content", "Lio/ktor/http/content/OutgoingContent;", "interceptReceiveLegacy", "", "Lio/ktor/util/pipeline/PipelineContext;", N6.L, "scope", "Lio/ktor/client/HttpClient;", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/statement/HttpResponse;Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "interceptSendLegacy", "", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/plugins/cache/HttpCache;Lio/ktor/http/content/OutgoingContent;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedWithWarning", "cachedCall", "Lio/ktor/client/call/HttpClientCall;", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/call/HttpClientCall;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HttpCacheLegacyKt {
    public static final Object interceptSendLegacy(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpCache httpCache, OutgoingContent outgoingContent, HttpClient httpClient, Continuation<? super Unit> continuation) {
        Object proceedWithMissingCache$ktor_client_core;
        HttpCacheEntry findResponse = findResponse(httpCache, pipelineContext.getContext(), outgoingContent);
        if (findResponse == null) {
            return (HttpHeaderValueParserKt.parseHeaderValue(pipelineContext.getContext().getHeaders().get(HttpHeaders.INSTANCE.getCacheControl())).contains(CacheControl.INSTANCE.getONLY_IF_CACHED$ktor_client_core()) && (proceedWithMissingCache$ktor_client_core = HttpCache.INSTANCE.proceedWithMissingCache$ktor_client_core(pipelineContext, httpClient, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? proceedWithMissingCache$ktor_client_core : Unit.INSTANCE;
        }
        HttpClientCall call = findResponse.produceResponse$ktor_client_core().getCall();
        ValidateStatus shouldValidate = HttpCacheEntryKt.shouldValidate(findResponse.getExpires(), findResponse.getResponse().getHeaders(), pipelineContext.getContext());
        if (shouldValidate == ValidateStatus.ShouldNotValidate) {
            Object proceedWithCache$ktor_client_core = HttpCache.INSTANCE.proceedWithCache$ktor_client_core(pipelineContext, httpClient, call, continuation);
            return proceedWithCache$ktor_client_core == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceedWithCache$ktor_client_core : Unit.INSTANCE;
        }
        if (shouldValidate == ValidateStatus.ShouldWarn) {
            Object proceedWithWarning = proceedWithWarning(pipelineContext, call, httpClient, continuation);
            return proceedWithWarning == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceedWithWarning : Unit.INSTANCE;
        }
        String str = findResponse.getResponseHeaders().get(HttpHeaders.INSTANCE.getETag());
        if (str != null) {
            UtilsKt.header(pipelineContext.getContext(), HttpHeaders.INSTANCE.getIfNoneMatch(), str);
        }
        String str2 = findResponse.getResponseHeaders().get(HttpHeaders.INSTANCE.getLastModified());
        if (str2 != null) {
            UtilsKt.header(pipelineContext.getContext(), HttpHeaders.INSTANCE.getIfModifiedSince(), str2);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0068, code lost:
    
        if (r6.proceedWith((io.ktor.client.statement.HttpResponse) r10, r0) == r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
    
        if (r10 == r1) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00a2, code lost:
    
        if (r6.proceedWith(r8, r0) == r1) goto L34;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object interceptReceiveLegacy(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, HttpCache httpCache, HttpClient httpClient, Continuation<? super Unit> continuation) {
        HttpCacheLegacyKt$interceptReceiveLegacy$1 httpCacheLegacyKt$interceptReceiveLegacy$1;
        int i;
        if (continuation instanceof HttpCacheLegacyKt$interceptReceiveLegacy$1) {
            httpCacheLegacyKt$interceptReceiveLegacy$1 = (HttpCacheLegacyKt$interceptReceiveLegacy$1) continuation;
            if ((httpCacheLegacyKt$interceptReceiveLegacy$1.label & Integer.MIN_VALUE) != 0) {
                httpCacheLegacyKt$interceptReceiveLegacy$1.label -= Integer.MIN_VALUE;
                Object obj = httpCacheLegacyKt$interceptReceiveLegacy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpCacheLegacyKt$interceptReceiveLegacy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                        httpCacheLegacyKt$interceptReceiveLegacy$1.L$0 = pipelineContext;
                        httpCacheLegacyKt$interceptReceiveLegacy$1.label = 1;
                        obj = cacheResponse(httpCache, httpResponse, httpCacheLegacyKt$interceptReceiveLegacy$1);
                    } else if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getNotModified())) {
                        HttpResponseKt.complete(httpResponse);
                        HttpResponse findAndRefresh = findAndRefresh(httpCache, httpResponse.getCall().getRequest(), httpResponse);
                        if (findAndRefresh == null) {
                            throw new InvalidCacheStateException(httpResponse.getCall().getRequest().getUrl());
                        }
                        httpClient.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), findAndRefresh);
                        httpCacheLegacyKt$interceptReceiveLegacy$1.label = 3;
                    } else {
                        return Unit.INSTANCE;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                pipelineContext = (PipelineContext) httpCacheLegacyKt$interceptReceiveLegacy$1.L$0;
                ResultKt.throwOnFailure(obj);
                httpCacheLegacyKt$interceptReceiveLegacy$1.L$0 = null;
                httpCacheLegacyKt$interceptReceiveLegacy$1.label = 2;
            }
        }
        httpCacheLegacyKt$interceptReceiveLegacy$1 = new HttpCacheLegacyKt$interceptReceiveLegacy$1(continuation);
        Object obj2 = httpCacheLegacyKt$interceptReceiveLegacy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpCacheLegacyKt$interceptReceiveLegacy$1.label;
        if (i != 0) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object proceedWithWarning(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClientCall httpClientCall, HttpClient httpClient, Continuation<? super Unit> continuation) {
        HttpRequestData build = pipelineContext.getContext().build();
        HttpStatusCode status = httpClientCall.getResponse().getStatus();
        GMTDate requestTime = httpClientCall.getResponse().getRequestTime();
        Headers.Companion companion = Headers.INSTANCE;
        HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
        headersBuilder.appendAll(httpClientCall.getResponse().getHeaders());
        headersBuilder.append(HttpHeaders.INSTANCE.getWarning(), "110");
        Unit unit = Unit.INSTANCE;
        HttpClientCall httpClientCall2 = new HttpClientCall(httpClient, build, new HttpResponseData(status, requestTime, headersBuilder.build(), httpClientCall.getResponse().getVersion(), httpClientCall.getResponse().getContent(), httpClientCall.getResponse().getCoroutineContext()));
        pipelineContext.finish();
        httpClient.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpClientCall2.getResponse());
        Object proceedWith = pipelineContext.proceedWith(httpClientCall2, continuation);
        return proceedWith == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceedWith : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object cacheResponse(HttpCache httpCache, HttpResponse httpResponse, Continuation<? super HttpResponse> continuation) {
        HttpCacheLegacyKt$cacheResponse$1 httpCacheLegacyKt$cacheResponse$1;
        int i;
        if (continuation instanceof HttpCacheLegacyKt$cacheResponse$1) {
            httpCacheLegacyKt$cacheResponse$1 = (HttpCacheLegacyKt$cacheResponse$1) continuation;
            if ((httpCacheLegacyKt$cacheResponse$1.label & Integer.MIN_VALUE) != 0) {
                httpCacheLegacyKt$cacheResponse$1.label -= Integer.MIN_VALUE;
                Object obj = httpCacheLegacyKt$cacheResponse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpCacheLegacyKt$cacheResponse$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    HttpRequest request = httpResponse.getCall().getRequest();
                    List<HeaderValue> cacheControl = HttpMessagePropertiesKt.cacheControl(httpResponse);
                    List<HeaderValue> cacheControl2 = HttpMessagePropertiesKt.cacheControl(request);
                    HttpCacheStorage privateStorage = cacheControl.contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core()) ? httpCache.getPrivateStorage() : httpCache.getPublicStorage();
                    if (cacheControl.contains(CacheControl.INSTANCE.getNO_STORE$ktor_client_core()) || cacheControl2.contains(CacheControl.INSTANCE.getNO_STORE$ktor_client_core())) {
                        return httpResponse;
                    }
                    Url url = request.getUrl();
                    boolean isSharedClient = httpCache.getIsSharedClient();
                    httpCacheLegacyKt$cacheResponse$1.label = 1;
                    obj = HttpCacheStorageKt.store(privateStorage, url, httpResponse, isSharedClient, httpCacheLegacyKt$cacheResponse$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ((HttpCacheEntry) obj).produceResponse$ktor_client_core();
            }
        }
        httpCacheLegacyKt$cacheResponse$1 = new HttpCacheLegacyKt$cacheResponse$1(continuation);
        Object obj2 = httpCacheLegacyKt$cacheResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpCacheLegacyKt$cacheResponse$1.label;
        if (i != 0) {
        }
        return ((HttpCacheEntry) obj2).produceResponse$ktor_client_core();
    }

    private static final HttpResponse findAndRefresh(HttpCache httpCache, HttpRequest httpRequest, HttpResponse httpResponse) {
        Url url = httpResponse.getCall().getRequest().getUrl();
        HttpCacheStorage privateStorage = HttpMessagePropertiesKt.cacheControl(httpResponse).contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core()) ? httpCache.getPrivateStorage() : httpCache.getPublicStorage();
        Map<String, String> varyKeys = HttpCacheEntryKt.varyKeys(httpResponse);
        HttpCacheEntry findResponse = findResponse(httpCache, privateStorage, varyKeys, url, httpRequest);
        if (findResponse == null) {
            return null;
        }
        if (varyKeys.isEmpty()) {
            varyKeys = findResponse.getVaryKeys();
        }
        privateStorage.store(url, new HttpCacheEntry(HttpCacheEntryKt.cacheExpires$default(httpResponse, httpCache.getIsSharedClient(), null, 2, null), varyKeys, findResponse.getResponse(), findResponse.getBody()));
        return findResponse.produceResponse$ktor_client_core();
    }

    private static final HttpCacheEntry findResponse(HttpCache httpCache, HttpCacheStorage httpCacheStorage, Map<String, String> map, Url url, HttpRequest httpRequest) {
        Object obj;
        if (!map.isEmpty()) {
            return httpCacheStorage.find(url, map);
        }
        Function1<String, String> mergedHeadersLookup = HttpCacheKt.mergedHeadersLookup(httpRequest.getContent(), new HttpCacheLegacyKt$findResponse$requestHeaders$1(httpRequest.getHeaders()), new HttpCacheLegacyKt$findResponse$requestHeaders$2(httpRequest.getHeaders()));
        Iterator it = CollectionsKt.sortedWith(httpCacheStorage.findByUrl(url), new Comparator() { // from class: io.ktor.client.plugins.cache.HttpCacheLegacyKt$findResponse$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((HttpCacheEntry) t2).getResponse().getResponseTime(), ((HttpCacheEntry) t).getResponse().getResponseTime());
            }
        }).iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Map<String, String> varyKeys = ((HttpCacheEntry) obj).getVaryKeys();
            if (!varyKeys.isEmpty()) {
                for (Map.Entry<String, String> entry : varyKeys.entrySet()) {
                    String key = entry.getKey();
                    if (!Intrinsics.areEqual(mergedHeadersLookup.invoke(key), entry.getValue())) {
                        break;
                    }
                }
                break loop0;
            }
            break;
        }
        return (HttpCacheEntry) obj;
    }

    private static final HttpCacheEntry findResponse(HttpCache httpCache, HttpRequestBuilder httpRequestBuilder, OutgoingContent outgoingContent) {
        Url Url = URLUtilsKt.Url(httpRequestBuilder.getUrl());
        Function1<String, String> mergedHeadersLookup = HttpCacheKt.mergedHeadersLookup(outgoingContent, new HttpCacheLegacyKt$findResponse$lookup$1(httpRequestBuilder.getHeaders()), new HttpCacheLegacyKt$findResponse$lookup$2(httpRequestBuilder.getHeaders()));
        for (HttpCacheEntry httpCacheEntry : SetsKt.plus((Set) httpCache.getPrivateStorage().findByUrl(Url), (Iterable) httpCache.getPublicStorage().findByUrl(Url))) {
            Map<String, String> varyKeys = httpCacheEntry.getVaryKeys();
            if (varyKeys.isEmpty() || varyKeys.isEmpty()) {
                return httpCacheEntry;
            }
            for (Map.Entry<String, String> entry : varyKeys.entrySet()) {
                String key = entry.getKey();
                if (!Intrinsics.areEqual(mergedHeadersLookup.invoke(key), entry.getValue())) {
                    break;
                }
            }
            return httpCacheEntry;
        }
        return null;
    }
}
