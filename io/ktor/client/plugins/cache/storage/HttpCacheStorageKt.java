package io.ktor.client.plugins.cache.storage;

import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.call.SavedHttpCall;
import io.ktor.client.plugins.cache.HttpCacheEntry;
import io.ktor.client.plugins.cache.HttpCacheEntryKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.Headers;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.Url;
import io.ktor.util.InternalAPI;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCacheStorage.kt */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001d\u0010\t\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0001H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\f\u001a1\u0010\t\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a;\u0010\t\u001a\u00020\u0002*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001a-\u0010\t\u001a\u00020\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0012H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"createResponse", "Lio/ktor/client/statement/HttpResponse;", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "client", "Lio/ktor/client/HttpClient;", AdActivity.REQUEST_KEY_EXTRA, "Lio/ktor/client/request/HttpRequest;", "responseContext", "Lkotlin/coroutines/CoroutineContext;", C3040d4.h.U, "Lio/ktor/client/plugins/cache/storage/CacheStorage;", C3337ue.n, "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "varyKeys", "", "", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/statement/HttpResponse;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isShared", "", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/statement/HttpResponse;Ljava/util/Map;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lio/ktor/client/plugins/cache/HttpCacheEntry;", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "url", "Lio/ktor/http/Url;", "value", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/http/Url;Lio/ktor/client/statement/HttpResponse;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HttpCacheStorageKt {
    /* JADX WARN: Removed duplicated region for block: B:15:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object store(HttpCacheStorage httpCacheStorage, Url url, HttpResponse httpResponse, boolean z, Continuation<? super HttpCacheEntry> continuation) {
        HttpCacheStorageKt$store$1 httpCacheStorageKt$store$1;
        int i;
        if (continuation instanceof HttpCacheStorageKt$store$1) {
            httpCacheStorageKt$store$1 = (HttpCacheStorageKt$store$1) continuation;
            if ((httpCacheStorageKt$store$1.label & Integer.MIN_VALUE) != 0) {
                httpCacheStorageKt$store$1.label -= Integer.MIN_VALUE;
                Object obj = httpCacheStorageKt$store$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpCacheStorageKt$store$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    httpCacheStorageKt$store$1.L$0 = httpCacheStorage;
                    httpCacheStorageKt$store$1.L$1 = url;
                    httpCacheStorageKt$store$1.label = 1;
                    obj = HttpCacheEntryKt.HttpCacheEntry(z, httpResponse, httpCacheStorageKt$store$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    url = (Url) httpCacheStorageKt$store$1.L$1;
                    httpCacheStorage = (HttpCacheStorage) httpCacheStorageKt$store$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                HttpCacheEntry httpCacheEntry = (HttpCacheEntry) obj;
                httpCacheStorage.store(url, httpCacheEntry);
                return httpCacheEntry;
            }
        }
        httpCacheStorageKt$store$1 = new HttpCacheStorageKt$store$1(continuation);
        Object obj2 = httpCacheStorageKt$store$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpCacheStorageKt$store$1.label;
        if (i != 0) {
        }
        HttpCacheEntry httpCacheEntry2 = (HttpCacheEntry) obj2;
        httpCacheStorage.store(url, httpCacheEntry2);
        return httpCacheEntry2;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Please use method with `response.varyKeys()` and `isShared` arguments", replaceWith = @ReplaceWith(expression = "store(response, response.varyKeys(), isShared)", imports = {}))
    public static final Object store(CacheStorage cacheStorage, HttpResponse httpResponse, Continuation<? super CachedResponseData> continuation) {
        return store$default(cacheStorage, httpResponse, HttpCacheEntryKt.varyKeys(httpResponse), false, continuation, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x00d2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object store(CacheStorage cacheStorage, HttpResponse httpResponse, Map<String, String> map, boolean z, Continuation<? super CachedResponseData> continuation) {
        HttpCacheStorageKt$store$4 httpCacheStorageKt$store$4;
        int i;
        HttpResponse httpResponse2;
        boolean z2;
        Url url;
        CacheStorage cacheStorage2;
        Map<String, String> map2;
        if (continuation instanceof HttpCacheStorageKt$store$4) {
            httpCacheStorageKt$store$4 = (HttpCacheStorageKt$store$4) continuation;
            if ((httpCacheStorageKt$store$4.label & Integer.MIN_VALUE) != 0) {
                httpCacheStorageKt$store$4.label -= Integer.MIN_VALUE;
                HttpCacheStorageKt$store$4 httpCacheStorageKt$store$42 = httpCacheStorageKt$store$4;
                Object obj = httpCacheStorageKt$store$42.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpCacheStorageKt$store$42.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Url url2 = httpResponse.getCall().getRequest().getUrl();
                    ByteReadChannel content = httpResponse.getContent();
                    httpCacheStorageKt$store$42.L$0 = cacheStorage;
                    httpResponse2 = httpResponse;
                    httpCacheStorageKt$store$42.L$1 = httpResponse2;
                    httpCacheStorageKt$store$42.L$2 = map;
                    httpCacheStorageKt$store$42.L$3 = url2;
                    z2 = z;
                    httpCacheStorageKt$store$42.Z$0 = z2;
                    httpCacheStorageKt$store$42.label = 1;
                    Object readRemaining$default = ByteReadChannel.DefaultImpls.readRemaining$default(content, 0L, httpCacheStorageKt$store$42, 1, null);
                    if (readRemaining$default != coroutine_suspended) {
                        url = url2;
                        obj = readRemaining$default;
                        cacheStorage2 = cacheStorage;
                        map2 = map;
                    }
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    CachedResponseData cachedResponseData = (CachedResponseData) httpCacheStorageKt$store$42.L$0;
                    ResultKt.throwOnFailure(obj);
                    return cachedResponseData;
                }
                boolean z3 = httpCacheStorageKt$store$42.Z$0;
                url = (Url) httpCacheStorageKt$store$42.L$3;
                Map<String, String> map3 = (Map) httpCacheStorageKt$store$42.L$2;
                HttpResponse httpResponse3 = (HttpResponse) httpCacheStorageKt$store$42.L$1;
                cacheStorage2 = (CacheStorage) httpCacheStorageKt$store$42.L$0;
                ResultKt.throwOnFailure(obj);
                z2 = z3;
                map2 = map3;
                httpResponse2 = httpResponse3;
                byte[] readBytes$default = StringsKt.readBytes$default((ByteReadPacket) obj, 0, 1, null);
                HttpResponseKt.complete(httpResponse2);
                CachedResponseData cachedResponseData2 = new CachedResponseData(httpResponse2.getCall().getRequest().getUrl(), httpResponse2.getStatus(), httpResponse2.getRequestTime(), httpResponse2.getResponseTime(), httpResponse2.getVersion(), HttpCacheEntryKt.cacheExpires$default(httpResponse2, z2, null, 2, null), httpResponse2.getHeaders(), map2, readBytes$default);
                httpCacheStorageKt$store$42.L$0 = cachedResponseData2;
                httpCacheStorageKt$store$42.L$1 = null;
                httpCacheStorageKt$store$42.L$2 = null;
                httpCacheStorageKt$store$42.L$3 = null;
                httpCacheStorageKt$store$42.label = 2;
                return cacheStorage2.store(url, cachedResponseData2, httpCacheStorageKt$store$42) != coroutine_suspended ? coroutine_suspended : cachedResponseData2;
            }
        }
        httpCacheStorageKt$store$4 = new HttpCacheStorageKt$store$4(continuation);
        HttpCacheStorageKt$store$4 httpCacheStorageKt$store$422 = httpCacheStorageKt$store$4;
        Object obj2 = httpCacheStorageKt$store$422.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpCacheStorageKt$store$422.label;
        if (i != 0) {
        }
        byte[] readBytes$default2 = StringsKt.readBytes$default((ByteReadPacket) obj2, 0, 1, null);
        HttpResponseKt.complete(httpResponse2);
        CachedResponseData cachedResponseData22 = new CachedResponseData(httpResponse2.getCall().getRequest().getUrl(), httpResponse2.getStatus(), httpResponse2.getRequestTime(), httpResponse2.getResponseTime(), httpResponse2.getVersion(), HttpCacheEntryKt.cacheExpires$default(httpResponse2, z2, null, 2, null), httpResponse2.getHeaders(), map2, readBytes$default2);
        httpCacheStorageKt$store$422.L$0 = cachedResponseData22;
        httpCacheStorageKt$store$422.L$1 = null;
        httpCacheStorageKt$store$422.L$2 = null;
        httpCacheStorageKt$store$422.L$3 = null;
        httpCacheStorageKt$store$422.label = 2;
        if (cacheStorage2.store(url, cachedResponseData22, httpCacheStorageKt$store$422) != coroutine_suspended2) {
        }
    }

    public static /* synthetic */ Object store$default(CacheStorage cacheStorage, HttpResponse httpResponse, Map map, boolean z, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return store(cacheStorage, httpResponse, (Map<String, String>) map, z, (Continuation<? super CachedResponseData>) continuation);
    }

    public static final HttpResponse createResponse(final CachedResponseData cachedResponseData, HttpClient client, HttpRequest request, final CoroutineContext responseContext) {
        Intrinsics.checkNotNullParameter(cachedResponseData, "<this>");
        Intrinsics.checkNotNullParameter(client, "client");
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(responseContext, "responseContext");
        return new SavedHttpCall(client, request, new HttpResponse(cachedResponseData, responseContext) { // from class: io.ktor.client.plugins.cache.storage.HttpCacheStorageKt$createResponse$response$1
            private final CoroutineContext coroutineContext;
            private final Headers headers;
            private final GMTDate requestTime;
            private final GMTDate responseTime;
            private final HttpStatusCode status;
            private final HttpProtocolVersion version;

            @InternalAPI
            public static /* synthetic */ void getContent$annotations() {
            }

            {
                this.status = cachedResponseData.getStatusCode();
                this.version = cachedResponseData.getVersion();
                this.requestTime = cachedResponseData.getRequestTime();
                this.responseTime = cachedResponseData.getResponseTime();
                this.headers = cachedResponseData.getHeaders();
                this.coroutineContext = responseContext;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public HttpClientCall getCall() {
                throw new IllegalStateException("This is a fake response");
            }

            @Override // io.ktor.client.statement.HttpResponse
            public HttpStatusCode getStatus() {
                return this.status;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public HttpProtocolVersion getVersion() {
                return this.version;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public GMTDate getRequestTime() {
                return this.requestTime;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public GMTDate getResponseTime() {
                return this.responseTime;
            }

            @Override // io.ktor.client.statement.HttpResponse
            public ByteReadChannel getContent() {
                throw new IllegalStateException("This is a fake response");
            }

            @Override // io.ktor.http.HttpMessage
            public Headers getHeaders() {
                return this.headers;
            }

            @Override // kotlinx.coroutines.CoroutineScope
            public CoroutineContext getCoroutineContext() {
                return this.coroutineContext;
            }
        }, cachedResponseData.getBody()).getResponse();
    }
}
