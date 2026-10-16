package io.ktor.client.plugins.cache;

import com.ironsource.C3337ue;
import io.ktor.client.HttpClient;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.statement.HttpResponse;
import io.ktor.client.statement.HttpResponseKt;
import io.ktor.http.HttpMethod;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.HttpStatusCodeKt;
import io.ktor.util.pipeline.PipelineContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCache.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/util/pipeline/PipelineContext;", "Lio/ktor/client/statement/HttpResponse;", C3337ue.n}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.HttpCache$Companion$install$2", f = "HttpCache.kt", i = {1, 1, 3, 3}, l = {188, 194, 198, 206, 210}, m = "invokeSuspend", n = {"$this$intercept", C3337ue.n, "$this$intercept", C3337ue.n}, s = {"L$0", "L$1", "L$0", "L$1"})
/* loaded from: classes8.dex */
final class HttpCache$Companion$install$2 extends SuspendLambda implements Function3<PipelineContext<HttpResponse, Unit>, HttpResponse, Continuation<? super Unit>, Object> {
    final /* synthetic */ HttpCache $plugin;
    final /* synthetic */ HttpClient $scope;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpCache$Companion$install$2(HttpCache httpCache, HttpClient httpClient, Continuation<? super HttpCache$Companion$install$2> continuation) {
        super(3, continuation);
        this.$plugin = httpCache;
        this.$scope = httpClient;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(PipelineContext<HttpResponse, Unit> pipelineContext, HttpResponse httpResponse, Continuation<? super Unit> continuation) {
        HttpCache$Companion$install$2 httpCache$Companion$install$2 = new HttpCache$Companion$install$2(this.$plugin, this.$scope, continuation);
        httpCache$Companion$install$2.L$0 = pipelineContext;
        httpCache$Companion$install$2.L$1 = httpResponse;
        return httpCache$Companion$install$2.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x016d, code lost:
    
        if (r3.proceedWith(r12, r11) == r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ed, code lost:
    
        if (r5.proceedWith(io.ktor.client.plugins.cache.storage.HttpCacheStorageKt.createResponse(r12, r11.$scope, io.ktor.client.statement.HttpResponseKt.getRequest(r1), r1.getCoroutineContext()), r11) == r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0085, code lost:
    
        if (io.ktor.client.plugins.cache.HttpCacheLegacyKt.interceptReceiveLegacy(r12, r1, r11.$plugin, r11.$scope, r11) == r0) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0105  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        PipelineContext pipelineContext;
        HttpResponse httpResponse;
        boolean z;
        Object cacheResponse;
        PipelineContext pipelineContext2;
        Object findAndRefresh;
        PipelineContext pipelineContext3;
        CachedResponseData cachedResponseData;
        HttpResponse httpResponse2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            pipelineContext = (PipelineContext) this.L$0;
            httpResponse = (HttpResponse) this.L$1;
            if (!Intrinsics.areEqual(httpResponse.getCall().getRequest().getMethod(), HttpMethod.INSTANCE.getGet())) {
                return Unit.INSTANCE;
            }
            z = this.$plugin.useOldStorage;
            if (z) {
                this.L$0 = null;
                this.label = 1;
            } else {
                if (HttpStatusCodeKt.isSuccess(httpResponse.getStatus())) {
                    HttpCacheKt.getLOGGER().trace("Caching response for " + httpResponse.getCall().getRequest().getUrl());
                    this.L$0 = pipelineContext;
                    this.L$1 = httpResponse;
                    this.label = 2;
                    cacheResponse = this.$plugin.cacheResponse(httpResponse, this);
                    if (cacheResponse != coroutine_suspended) {
                        pipelineContext2 = pipelineContext;
                        obj = cacheResponse;
                        cachedResponseData = (CachedResponseData) obj;
                        if (cachedResponseData == null) {
                        }
                    }
                }
                if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getNotModified())) {
                }
            }
            return coroutine_suspended;
        }
        if (i == 1) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        if (i == 2) {
            httpResponse = (HttpResponse) this.L$1;
            pipelineContext2 = (PipelineContext) this.L$0;
            ResultKt.throwOnFailure(obj);
            cachedResponseData = (CachedResponseData) obj;
            if (cachedResponseData == null) {
                this.L$0 = null;
                this.L$1 = null;
                this.label = 3;
            } else {
                pipelineContext = pipelineContext2;
                if (Intrinsics.areEqual(httpResponse.getStatus(), HttpStatusCode.INSTANCE.getNotModified())) {
                    HttpCacheKt.getLOGGER().trace("Not modified response for " + httpResponse.getCall().getRequest().getUrl() + ", replying from cache");
                    HttpResponseKt.complete(httpResponse);
                    this.L$0 = pipelineContext;
                    this.L$1 = httpResponse;
                    this.label = 4;
                    findAndRefresh = this.$plugin.findAndRefresh(httpResponse.getCall().getRequest(), httpResponse, this);
                    if (findAndRefresh != coroutine_suspended) {
                        pipelineContext3 = pipelineContext;
                        obj = findAndRefresh;
                        httpResponse2 = (HttpResponse) obj;
                        if (httpResponse2 != null) {
                        }
                    }
                    return coroutine_suspended;
                }
            }
        } else {
            if (i == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i == 4) {
                httpResponse = (HttpResponse) this.L$1;
                pipelineContext3 = (PipelineContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                httpResponse2 = (HttpResponse) obj;
                if (httpResponse2 != null) {
                    throw new InvalidCacheStateException(httpResponse.getCall().getRequest().getUrl());
                }
                this.$scope.getMonitor().raise(HttpCache.INSTANCE.getHttpResponseFromCache(), httpResponse2);
                this.L$0 = null;
                this.L$1 = null;
                this.label = 5;
            } else {
                if (i != 5) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
        }
        return Unit.INSTANCE;
    }
}
