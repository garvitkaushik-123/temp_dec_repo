package io.ktor.client.plugins.cache;

import com.ironsource.C3040d4;
import com.ironsource.C3337ue;
import com.ironsource.N6;
import com.vungle.ads.internal.ui.AdActivity;
import io.ktor.client.HttpClient;
import io.ktor.client.call.HttpClientCall;
import io.ktor.client.plugins.HttpClientPlugin;
import io.ktor.client.plugins.cache.storage.CacheStorage;
import io.ktor.client.plugins.cache.storage.CachedResponseData;
import io.ktor.client.plugins.cache.storage.HttpCacheStorage;
import io.ktor.client.plugins.cache.storage.HttpCacheStorageKt;
import io.ktor.client.request.HttpRequest;
import io.ktor.client.request.HttpRequestBuilder;
import io.ktor.client.request.HttpRequestData;
import io.ktor.client.request.HttpResponseData;
import io.ktor.client.request.HttpSendPipeline;
import io.ktor.client.statement.HttpReceivePipeline;
import io.ktor.client.statement.HttpResponse;
import io.ktor.events.EventDefinition;
import io.ktor.http.HeaderValue;
import io.ktor.http.Headers;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpHeaders;
import io.ktor.http.HttpMessagePropertiesKt;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.http.content.OutgoingContent;
import io.ktor.util.AttributeKey;
import io.ktor.util.KtorDsl;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.util.pipeline.PipelineContext;
import io.ktor.util.pipeline.PipelinePhase;
import io.ktor.utils.io.ByteChannelCtorKt;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpCache.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 *2\u00020\u0001:\u0002*+B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J#\u0010\u0019\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ?\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001e\u001a\u00020\u00062\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010$J#\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010)R\u0014\u0010\n\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006,"}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache;", "", "publicStorage", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "privateStorage", "publicStorageNew", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "privateStorageNew", "useOldStorage", "", "isSharedClient", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;Lio/ktor/client/plugins/cache/storage/CacheStorage;Lio/ktor/client/plugins/cache/storage/CacheStorage;ZZ)V", "isSharedClient$ktor_client_core", "()Z", "getPrivateStorage$annotations", "()V", "getPrivateStorage", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "getPublicStorage$annotations", "getPublicStorage", "cacheResponse", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", C3337ue.n, "Lio/ktor/client/statement/HttpResponse;", "(Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findAndRefresh", AdActivity.REQUEST_KEY_EXTRA, "Lio/ktor/client/request/HttpRequest;", "(Lio/ktor/client/request/HttpRequest;Lio/ktor/client/statement/HttpResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findResponse", C3040d4.a.k, "varyKeys", "", "", "url", "Lio/ktor/http/Url;", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;Ljava/util/Map;Lio/ktor/http/Url;Lio/ktor/client/request/HttpRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "context", "Lio/ktor/client/request/HttpRequestBuilder;", "content", "Lio/ktor/http/content/OutgoingContent;", "(Lio/ktor/client/request/HttpRequestBuilder;Lio/ktor/http/content/OutgoingContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "Config", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class HttpCache {
    private final boolean isSharedClient;
    private final HttpCacheStorage privateStorage;
    private final CacheStorage privateStorageNew;
    private final HttpCacheStorage publicStorage;
    private final CacheStorage publicStorageNew;
    private final boolean useOldStorage;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AttributeKey<HttpCache> key = new AttributeKey<>("HttpCache");
    private static final EventDefinition<HttpResponse> HttpResponseFromCache = new EventDefinition<>();

    public /* synthetic */ HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2, CacheStorage cacheStorage, CacheStorage cacheStorage2, boolean z, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpCacheStorage, httpCacheStorage2, cacheStorage, cacheStorage2, z, z2);
    }

    @Deprecated(message = "This will become internal")
    public static /* synthetic */ void getPrivateStorage$annotations() {
    }

    @Deprecated(message = "This will become internal")
    public static /* synthetic */ void getPublicStorage$annotations() {
    }

    private HttpCache(HttpCacheStorage httpCacheStorage, HttpCacheStorage httpCacheStorage2, CacheStorage cacheStorage, CacheStorage cacheStorage2, boolean z, boolean z2) {
        this.publicStorage = httpCacheStorage;
        this.privateStorage = httpCacheStorage2;
        this.publicStorageNew = cacheStorage;
        this.privateStorageNew = cacheStorage2;
        this.useOldStorage = z;
        this.isSharedClient = z2;
    }

    public final HttpCacheStorage getPublicStorage() {
        return this.publicStorage;
    }

    public final HttpCacheStorage getPrivateStorage() {
        return this.privateStorage;
    }

    /* renamed from: isSharedClient$ktor_client_core, reason: from getter */
    public final boolean getIsSharedClient() {
        return this.isSharedClient;
    }

    /* compiled from: HttpCache.kt */
    @KtorDsl
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0011J\u000e\u0010\u0016\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0011R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R,\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R,\u0010\u0016\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0002\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000fR\u001a\u0010\u001a\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015R\u001a\u0010\u001d\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0005\"\u0004\b\u001f\u0010\u0007¨\u0006\""}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache$Config;", "", "()V", "isShared", "", "()Z", "setShared", "(Z)V", "value", "Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "privateStorage", "getPrivateStorage$annotations", "getPrivateStorage", "()Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;", "setPrivateStorage", "(Lio/ktor/client/plugins/cache/storage/HttpCacheStorage;)V", "privateStorageNew", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "getPrivateStorageNew$ktor_client_core", "()Lio/ktor/client/plugins/cache/storage/CacheStorage;", "setPrivateStorageNew$ktor_client_core", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;)V", "publicStorage", "getPublicStorage$annotations", "getPublicStorage", "setPublicStorage", "publicStorageNew", "getPublicStorageNew$ktor_client_core", "setPublicStorageNew$ktor_client_core", "useOldStorage", "getUseOldStorage$ktor_client_core", "setUseOldStorage$ktor_client_core", "", C3040d4.a.k, "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Config {
        private boolean isShared;
        private boolean useOldStorage;
        private CacheStorage publicStorageNew = CacheStorage.INSTANCE.getUnlimited().invoke();
        private CacheStorage privateStorageNew = CacheStorage.INSTANCE.getUnlimited().invoke();
        private HttpCacheStorage publicStorage = HttpCacheStorage.INSTANCE.getUnlimited().invoke();
        private HttpCacheStorage privateStorage = HttpCacheStorage.INSTANCE.getUnlimited().invoke();

        @Deprecated(message = "This will become internal. Use setter method instead with new storage interface")
        public static /* synthetic */ void getPrivateStorage$annotations() {
        }

        @Deprecated(message = "This will become internal. Use setter method instead with new storage interface")
        public static /* synthetic */ void getPublicStorage$annotations() {
        }

        /* renamed from: getPublicStorageNew$ktor_client_core, reason: from getter */
        public final CacheStorage getPublicStorageNew() {
            return this.publicStorageNew;
        }

        public final void setPublicStorageNew$ktor_client_core(CacheStorage cacheStorage) {
            Intrinsics.checkNotNullParameter(cacheStorage, "<set-?>");
            this.publicStorageNew = cacheStorage;
        }

        /* renamed from: getPrivateStorageNew$ktor_client_core, reason: from getter */
        public final CacheStorage getPrivateStorageNew() {
            return this.privateStorageNew;
        }

        public final void setPrivateStorageNew$ktor_client_core(CacheStorage cacheStorage) {
            Intrinsics.checkNotNullParameter(cacheStorage, "<set-?>");
            this.privateStorageNew = cacheStorage;
        }

        /* renamed from: getUseOldStorage$ktor_client_core, reason: from getter */
        public final boolean getUseOldStorage() {
            return this.useOldStorage;
        }

        public final void setUseOldStorage$ktor_client_core(boolean z) {
            this.useOldStorage = z;
        }

        /* renamed from: isShared, reason: from getter */
        public final boolean getIsShared() {
            return this.isShared;
        }

        public final void setShared(boolean z) {
            this.isShared = z;
        }

        public final HttpCacheStorage getPublicStorage() {
            return this.publicStorage;
        }

        public final void setPublicStorage(HttpCacheStorage value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.useOldStorage = true;
            this.publicStorage = value;
        }

        public final HttpCacheStorage getPrivateStorage() {
            return this.privateStorage;
        }

        public final void setPrivateStorage(HttpCacheStorage value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.useOldStorage = true;
            this.privateStorage = value;
        }

        public final void publicStorage(CacheStorage storage) {
            Intrinsics.checkNotNullParameter(storage, "storage");
            this.publicStorageNew = storage;
        }

        public final void privateStorage(CacheStorage storage) {
            Intrinsics.checkNotNullParameter(storage, "storage");
            this.privateStorageNew = storage;
        }
    }

    /* compiled from: HttpCache.kt */
    @Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J!\u0010\u0013\u001a\u00020\u00032\u0017\u0010\u0014\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000f0\u0015¢\u0006\u0002\b\u0016H\u0016J3\u0010\u0017\u001a\u00020\u000f*\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u001cH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ+\u0010\u001f\u001a\u00020\u000f*\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010\u0011\u001a\u00020\u0012H\u0080@ø\u0001\u0000¢\u0006\u0004\b \u0010!J9\u0010\"\u001a\u00020\u000f*\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00182\u0006\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010%\u001a\u00020&H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lio/ktor/client/plugins/cache/HttpCache$Companion;", "Lio/ktor/client/plugins/HttpClientPlugin;", "Lio/ktor/client/plugins/cache/HttpCache$Config;", "Lio/ktor/client/plugins/cache/HttpCache;", "()V", "HttpResponseFromCache", "Lio/ktor/events/EventDefinition;", "Lio/ktor/client/statement/HttpResponse;", "getHttpResponseFromCache", "()Lio/ktor/events/EventDefinition;", C3040d4.h.W, "Lio/ktor/util/AttributeKey;", "getKey", "()Lio/ktor/util/AttributeKey;", "install", "", N6.L, "scope", "Lio/ktor/client/HttpClient;", "prepare", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "proceedWithCache", "Lio/ktor/util/pipeline/PipelineContext;", "", "Lio/ktor/client/request/HttpRequestBuilder;", "cachedCall", "Lio/ktor/client/call/HttpClientCall;", "proceedWithCache$ktor_client_core", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/HttpClient;Lio/ktor/client/call/HttpClientCall;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedWithMissingCache", "proceedWithMissingCache$ktor_client_core", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/HttpClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "proceedWithWarning", "cachedResponse", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "callContext", "Lkotlin/coroutines/CoroutineContext;", "(Lio/ktor/util/pipeline/PipelineContext;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lio/ktor/client/HttpClient;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion implements HttpClientPlugin<Config, HttpCache> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public AttributeKey<HttpCache> getKey() {
            return HttpCache.key;
        }

        public final EventDefinition<HttpResponse> getHttpResponseFromCache() {
            return HttpCache.HttpResponseFromCache;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.ktor.client.plugins.HttpClientPlugin
        public HttpCache prepare(Function1<? super Config, Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            Config config = new Config();
            block.invoke(config);
            return new HttpCache(config.getPublicStorage(), config.getPrivateStorage(), config.getPublicStorageNew(), config.getPrivateStorageNew(), config.getUseOldStorage(), config.getIsShared(), null);
        }

        @Override // io.ktor.client.plugins.HttpClientPlugin
        public void install(HttpCache plugin, HttpClient scope) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            Intrinsics.checkNotNullParameter(scope, "scope");
            PipelinePhase pipelinePhase = new PipelinePhase("Cache");
            scope.getSendPipeline().insertPhaseAfter(HttpSendPipeline.INSTANCE.getState(), pipelinePhase);
            scope.getSendPipeline().intercept(pipelinePhase, new HttpCache$Companion$install$1(plugin, scope, null));
            scope.getReceivePipeline().intercept(HttpReceivePipeline.INSTANCE.getState(), new HttpCache$Companion$install$2(plugin, scope, null));
        }

        public final Object proceedWithCache$ktor_client_core(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClient httpClient, HttpClientCall httpClientCall, Continuation<? super Unit> continuation) {
            pipelineContext.finish();
            httpClient.getMonitor().raise(getHttpResponseFromCache(), httpClientCall.getResponse());
            Object proceedWith = pipelineContext.proceedWith(httpClientCall, continuation);
            return proceedWith == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceedWith : Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object proceedWithWarning(PipelineContext<Object, HttpRequestBuilder> pipelineContext, CachedResponseData cachedResponseData, HttpClient httpClient, CoroutineContext coroutineContext, Continuation<? super Unit> continuation) {
            HttpRequestData build = pipelineContext.getContext().build();
            HttpStatusCode statusCode = cachedResponseData.getStatusCode();
            GMTDate requestTime = cachedResponseData.getRequestTime();
            Headers.Companion companion = Headers.INSTANCE;
            HeadersBuilder headersBuilder = new HeadersBuilder(0, 1, null);
            headersBuilder.appendAll(cachedResponseData.getHeaders());
            headersBuilder.append(HttpHeaders.INSTANCE.getWarning(), "110");
            Unit unit = Unit.INSTANCE;
            HttpClientCall httpClientCall = new HttpClientCall(httpClient, build, new HttpResponseData(statusCode, requestTime, headersBuilder.build(), cachedResponseData.getVersion(), ByteChannelCtorKt.ByteReadChannel(cachedResponseData.getBody()), coroutineContext));
            pipelineContext.finish();
            httpClient.getMonitor().raise(getHttpResponseFromCache(), httpClientCall.getResponse());
            Object proceedWith = pipelineContext.proceedWith(httpClientCall, continuation);
            return proceedWith == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceedWith : Unit.INSTANCE;
        }

        public final Object proceedWithMissingCache$ktor_client_core(PipelineContext<Object, HttpRequestBuilder> pipelineContext, HttpClient httpClient, Continuation<? super Unit> continuation) {
            pipelineContext.finish();
            HttpRequestData build = pipelineContext.getContext().build();
            Object proceedWith = pipelineContext.proceedWith(new HttpClientCall(httpClient, build, new HttpResponseData(HttpStatusCode.INSTANCE.getGatewayTimeout(), DateJvmKt.GMTDate$default(null, 1, null), Headers.INSTANCE.getEmpty(), HttpProtocolVersion.INSTANCE.getHTTP_1_1(), ByteChannelCtorKt.ByteReadChannel(new byte[0]), build.getExecutionContext())), continuation);
            return proceedWith == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? proceedWith : Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object cacheResponse(HttpResponse httpResponse, Continuation<? super CachedResponseData> continuation) {
        CacheStorage cacheStorage;
        HttpRequest request = httpResponse.getCall().getRequest();
        List<HeaderValue> cacheControl = HttpMessagePropertiesKt.cacheControl(httpResponse);
        List<HeaderValue> cacheControl2 = HttpMessagePropertiesKt.cacheControl(request);
        boolean contains = cacheControl.contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core());
        if (contains && this.isSharedClient) {
            return null;
        }
        if (contains) {
            cacheStorage = this.privateStorageNew;
        } else {
            cacheStorage = this.publicStorageNew;
        }
        if (cacheControl.contains(CacheControl.INSTANCE.getNO_STORE$ktor_client_core()) || cacheControl2.contains(CacheControl.INSTANCE.getNO_STORE$ktor_client_core())) {
            return null;
        }
        return HttpCacheStorageKt.store(cacheStorage, httpResponse, HttpCacheEntryKt.varyKeys(httpResponse), this.isSharedClient, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object findAndRefresh(HttpRequest httpRequest, HttpResponse httpResponse, Continuation<? super HttpResponse> continuation) {
        HttpCache$findAndRefresh$1 httpCache$findAndRefresh$1;
        int i;
        CacheStorage cacheStorage;
        HttpResponse httpResponse2;
        CacheStorage cacheStorage2;
        Map<String, String> map;
        HttpRequest httpRequest2;
        HttpCache httpCache;
        CachedResponseData cachedResponseData;
        CachedResponseData cachedResponseData2;
        HttpResponse httpResponse3;
        HttpRequest httpRequest3;
        if (continuation instanceof HttpCache$findAndRefresh$1) {
            httpCache$findAndRefresh$1 = (HttpCache$findAndRefresh$1) continuation;
            if ((httpCache$findAndRefresh$1.label & Integer.MIN_VALUE) != 0) {
                httpCache$findAndRefresh$1.label -= Integer.MIN_VALUE;
                HttpCache$findAndRefresh$1 httpCache$findAndRefresh$12 = httpCache$findAndRefresh$1;
                Object obj = httpCache$findAndRefresh$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpCache$findAndRefresh$12.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Url url = httpResponse.getCall().getRequest().getUrl();
                    boolean contains = HttpMessagePropertiesKt.cacheControl(httpResponse).contains(CacheControl.INSTANCE.getPRIVATE$ktor_client_core());
                    if (contains && this.isSharedClient) {
                        return null;
                    }
                    if (contains) {
                        cacheStorage = this.privateStorageNew;
                    } else {
                        cacheStorage = this.publicStorageNew;
                    }
                    Map<String, String> varyKeys = HttpCacheEntryKt.varyKeys(httpResponse);
                    httpCache$findAndRefresh$12.L$0 = this;
                    httpCache$findAndRefresh$12.L$1 = httpRequest;
                    httpCache$findAndRefresh$12.L$2 = httpResponse;
                    httpCache$findAndRefresh$12.L$3 = cacheStorage;
                    httpCache$findAndRefresh$12.L$4 = varyKeys;
                    httpCache$findAndRefresh$12.label = 1;
                    CacheStorage cacheStorage3 = cacheStorage;
                    obj = findResponse(cacheStorage3, varyKeys, url, httpRequest, httpCache$findAndRefresh$12);
                    if (obj != coroutine_suspended) {
                        httpResponse2 = httpResponse;
                        cacheStorage2 = cacheStorage3;
                        map = varyKeys;
                        httpRequest2 = httpRequest;
                        httpCache = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cachedResponseData2 = (CachedResponseData) httpCache$findAndRefresh$12.L$2;
                    httpResponse3 = (HttpResponse) httpCache$findAndRefresh$12.L$1;
                    httpRequest3 = (HttpRequest) httpCache$findAndRefresh$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    return HttpCacheStorageKt.createResponse(cachedResponseData2, httpRequest3.getCall().getClient(), httpRequest3, httpResponse3.getCoroutineContext());
                }
                map = (Map) httpCache$findAndRefresh$12.L$4;
                cacheStorage2 = (CacheStorage) httpCache$findAndRefresh$12.L$3;
                httpResponse2 = (HttpResponse) httpCache$findAndRefresh$12.L$2;
                httpRequest2 = (HttpRequest) httpCache$findAndRefresh$12.L$1;
                httpCache = (HttpCache) httpCache$findAndRefresh$12.L$0;
                ResultKt.throwOnFailure(obj);
                cachedResponseData = (CachedResponseData) obj;
                if (cachedResponseData != null) {
                    return null;
                }
                if (map.isEmpty()) {
                    map = cachedResponseData.getVaryKeys();
                }
                Url url2 = httpRequest2.getUrl();
                CachedResponseData copy$ktor_client_core = cachedResponseData.copy$ktor_client_core(map, HttpCacheEntryKt.cacheExpires$default(httpResponse2, httpCache.isSharedClient, null, 2, null));
                httpCache$findAndRefresh$12.L$0 = httpRequest2;
                httpCache$findAndRefresh$12.L$1 = httpResponse2;
                httpCache$findAndRefresh$12.L$2 = cachedResponseData;
                httpCache$findAndRefresh$12.L$3 = null;
                httpCache$findAndRefresh$12.L$4 = null;
                httpCache$findAndRefresh$12.label = 2;
                if (cacheStorage2.store(url2, copy$ktor_client_core, httpCache$findAndRefresh$12) != coroutine_suspended) {
                    cachedResponseData2 = cachedResponseData;
                    httpResponse3 = httpResponse2;
                    httpRequest3 = httpRequest2;
                    return HttpCacheStorageKt.createResponse(cachedResponseData2, httpRequest3.getCall().getClient(), httpRequest3, httpResponse3.getCoroutineContext());
                }
                return coroutine_suspended;
            }
        }
        httpCache$findAndRefresh$1 = new HttpCache$findAndRefresh$1(this, continuation);
        HttpCache$findAndRefresh$1 httpCache$findAndRefresh$122 = httpCache$findAndRefresh$1;
        Object obj2 = httpCache$findAndRefresh$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpCache$findAndRefresh$122.label;
        if (i != 0) {
        }
        cachedResponseData = (CachedResponseData) obj2;
        if (cachedResponseData != null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object findResponse(CacheStorage cacheStorage, Map<String, String> map, Url url, HttpRequest httpRequest, Continuation<? super CachedResponseData> continuation) {
        HttpCache$findResponse$1 httpCache$findResponse$1;
        int i;
        Function1<String, String> function1;
        Iterator it;
        Object obj;
        if (continuation instanceof HttpCache$findResponse$1) {
            httpCache$findResponse$1 = (HttpCache$findResponse$1) continuation;
            if ((httpCache$findResponse$1.label & Integer.MIN_VALUE) != 0) {
                httpCache$findResponse$1.label -= Integer.MIN_VALUE;
                Object obj2 = httpCache$findResponse$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpCache$findResponse$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    if (!map.isEmpty()) {
                        httpCache$findResponse$1.label = 1;
                        Object find = cacheStorage.find(url, map, httpCache$findResponse$1);
                        if (find != coroutine_suspended) {
                            return find;
                        }
                    } else {
                        Function1<String, String> mergedHeadersLookup = HttpCacheKt.mergedHeadersLookup(httpRequest.getContent(), new HttpCache$findResponse$requestHeaders$1(httpRequest.getHeaders()), new HttpCache$findResponse$requestHeaders$2(httpRequest.getHeaders()));
                        httpCache$findResponse$1.L$0 = mergedHeadersLookup;
                        httpCache$findResponse$1.label = 2;
                        obj2 = cacheStorage.findAll(url, httpCache$findResponse$1);
                        if (obj2 != coroutine_suspended) {
                            function1 = mergedHeadersLookup;
                        }
                    }
                    return coroutine_suspended;
                }
                if (i == 1) {
                    ResultKt.throwOnFailure(obj2);
                    return obj2;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                function1 = (Function1) httpCache$findResponse$1.L$0;
                ResultKt.throwOnFailure(obj2);
                it = CollectionsKt.sortedWith((Iterable) obj2, new Comparator() { // from class: io.ktor.client.plugins.cache.HttpCache$findResponse$$inlined$sortedByDescending$1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.util.Comparator
                    public final int compare(T t, T t2) {
                        return ComparisonsKt.compareValues(((CachedResponseData) t2).getResponseTime(), ((CachedResponseData) t).getResponseTime());
                    }
                }).iterator();
                loop0: while (true) {
                    if (!it.hasNext()) {
                        obj = it.next();
                        Map<String, String> varyKeys = ((CachedResponseData) obj).getVaryKeys();
                        if (!varyKeys.isEmpty()) {
                            for (Map.Entry<String, String> entry : varyKeys.entrySet()) {
                                if (!Intrinsics.areEqual(function1.invoke(entry.getKey()), entry.getValue())) {
                                    break;
                                }
                            }
                            break loop0;
                        }
                        break;
                    }
                    obj = null;
                    break;
                }
                return (CachedResponseData) obj;
            }
        }
        httpCache$findResponse$1 = new HttpCache$findResponse$1(this, continuation);
        Object obj22 = httpCache$findResponse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpCache$findResponse$1.label;
        if (i != 0) {
        }
        it = CollectionsKt.sortedWith((Iterable) obj22, new Comparator() { // from class: io.ktor.client.plugins.cache.HttpCache$findResponse$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(((CachedResponseData) t2).getResponseTime(), ((CachedResponseData) t).getResponseTime());
            }
        }).iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
            }
        }
        return (CachedResponseData) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object findResponse(HttpRequestBuilder httpRequestBuilder, OutgoingContent outgoingContent, Continuation<? super CachedResponseData> continuation) {
        HttpCache$findResponse$4 httpCache$findResponse$4;
        Object coroutine_suspended;
        int i;
        Function1<String, String> mergedHeadersLookup;
        Url url;
        HttpCache httpCache;
        Object findAll;
        Function1<String, String> function1;
        Set set;
        if (continuation instanceof HttpCache$findResponse$4) {
            httpCache$findResponse$4 = (HttpCache$findResponse$4) continuation;
            if ((httpCache$findResponse$4.label & Integer.MIN_VALUE) != 0) {
                httpCache$findResponse$4.label -= Integer.MIN_VALUE;
                Object obj = httpCache$findResponse$4.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = httpCache$findResponse$4.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Url Url = URLUtilsKt.Url(httpRequestBuilder.getUrl());
                    mergedHeadersLookup = HttpCacheKt.mergedHeadersLookup(outgoingContent, new HttpCache$findResponse$lookup$1(httpRequestBuilder.getHeaders()), new HttpCache$findResponse$lookup$2(httpRequestBuilder.getHeaders()));
                    CacheStorage cacheStorage = this.privateStorageNew;
                    httpCache$findResponse$4.L$0 = this;
                    httpCache$findResponse$4.L$1 = Url;
                    httpCache$findResponse$4.L$2 = mergedHeadersLookup;
                    httpCache$findResponse$4.label = 1;
                    Object findAll2 = cacheStorage.findAll(Url, httpCache$findResponse$4);
                    if (findAll2 != coroutine_suspended) {
                        obj = findAll2;
                        url = Url;
                        httpCache = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    set = (Set) httpCache$findResponse$4.L$1;
                    function1 = (Function1) httpCache$findResponse$4.L$0;
                    ResultKt.throwOnFailure(obj);
                    for (CachedResponseData cachedResponseData : SetsKt.plus(set, (Iterable) obj)) {
                        Map<String, String> varyKeys = cachedResponseData.getVaryKeys();
                        if (varyKeys.isEmpty() || varyKeys.isEmpty()) {
                            return cachedResponseData;
                        }
                        for (Map.Entry<String, String> entry : varyKeys.entrySet()) {
                            if (!Intrinsics.areEqual(function1.invoke(entry.getKey()), entry.getValue())) {
                                break;
                            }
                        }
                        return cachedResponseData;
                    }
                    return null;
                }
                mergedHeadersLookup = (Function1) httpCache$findResponse$4.L$2;
                url = (Url) httpCache$findResponse$4.L$1;
                httpCache = (HttpCache) httpCache$findResponse$4.L$0;
                ResultKt.throwOnFailure(obj);
                Set set2 = (Set) obj;
                CacheStorage cacheStorage2 = httpCache.publicStorageNew;
                httpCache$findResponse$4.L$0 = mergedHeadersLookup;
                httpCache$findResponse$4.L$1 = set2;
                httpCache$findResponse$4.L$2 = null;
                httpCache$findResponse$4.label = 2;
                findAll = cacheStorage2.findAll(url, httpCache$findResponse$4);
                if (findAll != coroutine_suspended) {
                    function1 = mergedHeadersLookup;
                    set = set2;
                    obj = findAll;
                    while (r9.hasNext()) {
                    }
                    return null;
                }
                return coroutine_suspended;
            }
        }
        httpCache$findResponse$4 = new HttpCache$findResponse$4(this, continuation);
        Object obj2 = httpCache$findResponse$4.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = httpCache$findResponse$4.label;
        if (i != 0) {
        }
        Set set22 = (Set) obj2;
        CacheStorage cacheStorage22 = httpCache.publicStorageNew;
        httpCache$findResponse$4.L$0 = mergedHeadersLookup;
        httpCache$findResponse$4.L$1 = set22;
        httpCache$findResponse$4.L$2 = null;
        httpCache$findResponse$4.label = 2;
        findAll = cacheStorage22.findAll(url, httpCache$findResponse$4);
        if (findAll != coroutine_suspended) {
        }
        return coroutine_suspended;
    }
}
