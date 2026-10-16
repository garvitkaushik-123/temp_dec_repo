package io.ktor.client.plugins.cache.storage;

import com.ironsource.C3040d4;
import io.ktor.http.Url;
import io.ktor.util.collections.ConcurrentMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FileCacheStorage.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J/\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u001f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\n\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J!\u0010\u0004\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lio/ktor/client/plugins/cache/storage/CachingCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "delegate", "(Lio/ktor/client/plugins/cache/storage/CacheStorage;)V", C3040d4.h.U, "Lio/ktor/util/collections/ConcurrentMap;", "Lio/ktor/http/Url;", "", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "find", "url", "varyKeys", "", "", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findAll", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "data", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class CachingCacheStorage implements CacheStorage {
    private final CacheStorage delegate;
    private final ConcurrentMap<Url, Set<CachedResponseData>> store;

    public CachingCacheStorage(CacheStorage delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        this.store = new ConcurrentMap<>(0, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object store(Url url, CachedResponseData cachedResponseData, Continuation<? super Unit> continuation) {
        CachingCacheStorage$store$1 cachingCacheStorage$store$1;
        Object coroutine_suspended;
        int i;
        CachingCacheStorage cachingCacheStorage;
        Object findAll;
        Map map;
        if (continuation instanceof CachingCacheStorage$store$1) {
            cachingCacheStorage$store$1 = (CachingCacheStorage$store$1) continuation;
            if ((cachingCacheStorage$store$1.label & Integer.MIN_VALUE) != 0) {
                cachingCacheStorage$store$1.label -= Integer.MIN_VALUE;
                Object obj = cachingCacheStorage$store$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cachingCacheStorage$store$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    CacheStorage cacheStorage = this.delegate;
                    cachingCacheStorage$store$1.L$0 = this;
                    cachingCacheStorage$store$1.L$1 = url;
                    cachingCacheStorage$store$1.label = 1;
                    if (cacheStorage.store(url, cachedResponseData, cachingCacheStorage$store$1) != coroutine_suspended) {
                        cachingCacheStorage = this;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    url = (Url) cachingCacheStorage$store$1.L$1;
                    map = (Map) cachingCacheStorage$store$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    map.put(url, obj);
                    return Unit.INSTANCE;
                }
                url = (Url) cachingCacheStorage$store$1.L$1;
                cachingCacheStorage = (CachingCacheStorage) cachingCacheStorage$store$1.L$0;
                ResultKt.throwOnFailure(obj);
                ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = cachingCacheStorage.store;
                CacheStorage cacheStorage2 = cachingCacheStorage.delegate;
                cachingCacheStorage$store$1.L$0 = concurrentMap;
                cachingCacheStorage$store$1.L$1 = url;
                cachingCacheStorage$store$1.label = 2;
                findAll = cacheStorage2.findAll(url, cachingCacheStorage$store$1);
                if (findAll != coroutine_suspended) {
                    obj = findAll;
                    map = concurrentMap;
                    map.put(url, obj);
                    return Unit.INSTANCE;
                }
                return coroutine_suspended;
            }
        }
        cachingCacheStorage$store$1 = new CachingCacheStorage$store$1(this, continuation);
        Object obj2 = cachingCacheStorage$store$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cachingCacheStorage$store$1.label;
        if (i != 0) {
        }
        ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap2 = cachingCacheStorage.store;
        CacheStorage cacheStorage22 = cachingCacheStorage.delegate;
        cachingCacheStorage$store$1.L$0 = concurrentMap2;
        cachingCacheStorage$store$1.L$1 = url;
        cachingCacheStorage$store$1.label = 2;
        findAll = cacheStorage22.findAll(url, cachingCacheStorage$store$1);
        if (findAll != coroutine_suspended) {
        }
        return coroutine_suspended;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object find(Url url, Map<String, String> map, Continuation<? super CachedResponseData> continuation) {
        CachingCacheStorage$find$1 cachingCacheStorage$find$1;
        int i;
        CachingCacheStorage cachingCacheStorage;
        Url url2;
        Map<String, String> map2;
        Map map3;
        if (continuation instanceof CachingCacheStorage$find$1) {
            cachingCacheStorage$find$1 = (CachingCacheStorage$find$1) continuation;
            if ((cachingCacheStorage$find$1.label & Integer.MIN_VALUE) != 0) {
                cachingCacheStorage$find$1.label -= Integer.MIN_VALUE;
                Object obj = cachingCacheStorage$find$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cachingCacheStorage$find$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.store.containsKey(url)) {
                        ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = this.store;
                        CacheStorage cacheStorage = this.delegate;
                        cachingCacheStorage$find$1.L$0 = this;
                        cachingCacheStorage$find$1.L$1 = url;
                        cachingCacheStorage$find$1.L$2 = map;
                        cachingCacheStorage$find$1.L$3 = concurrentMap;
                        cachingCacheStorage$find$1.L$4 = url;
                        cachingCacheStorage$find$1.label = 1;
                        Object findAll = cacheStorage.findAll(url, cachingCacheStorage$find$1);
                        if (findAll == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url2 = url;
                        map2 = map;
                        map3 = concurrentMap;
                        obj = findAll;
                        cachingCacheStorage = this;
                    } else {
                        cachingCacheStorage = this;
                        for (Object obj2 : (Set) MapsKt.getValue(cachingCacheStorage.store, url)) {
                            CachedResponseData cachedResponseData = (CachedResponseData) obj2;
                            if (map.isEmpty()) {
                                return obj2;
                            }
                            for (Map.Entry<String, String> entry : map.entrySet()) {
                                if (!Intrinsics.areEqual(cachedResponseData.getVaryKeys().get(entry.getKey()), entry.getValue())) {
                                    break;
                                }
                            }
                            return obj2;
                        }
                        return null;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    url = (Url) cachingCacheStorage$find$1.L$4;
                    map3 = (Map) cachingCacheStorage$find$1.L$3;
                    map2 = (Map) cachingCacheStorage$find$1.L$2;
                    url2 = (Url) cachingCacheStorage$find$1.L$1;
                    cachingCacheStorage = (CachingCacheStorage) cachingCacheStorage$find$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                map3.put(url, obj);
                map = map2;
                url = url2;
                while (r6.hasNext()) {
                }
                return null;
            }
        }
        cachingCacheStorage$find$1 = new CachingCacheStorage$find$1(this, continuation);
        Object obj3 = cachingCacheStorage$find$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cachingCacheStorage$find$1.label;
        if (i != 0) {
        }
        map3.put(url, obj3);
        map = map2;
        url = url2;
        while (r6.hasNext()) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object findAll(Url url, Continuation<? super Set<CachedResponseData>> continuation) {
        CachingCacheStorage$findAll$1 cachingCacheStorage$findAll$1;
        int i;
        CachingCacheStorage cachingCacheStorage;
        Url url2;
        Map map;
        if (continuation instanceof CachingCacheStorage$findAll$1) {
            cachingCacheStorage$findAll$1 = (CachingCacheStorage$findAll$1) continuation;
            if ((cachingCacheStorage$findAll$1.label & Integer.MIN_VALUE) != 0) {
                cachingCacheStorage$findAll$1.label -= Integer.MIN_VALUE;
                Object obj = cachingCacheStorage$findAll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cachingCacheStorage$findAll$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.store.containsKey(url)) {
                        ConcurrentMap<Url, Set<CachedResponseData>> concurrentMap = this.store;
                        CacheStorage cacheStorage = this.delegate;
                        cachingCacheStorage$findAll$1.L$0 = this;
                        cachingCacheStorage$findAll$1.L$1 = url;
                        cachingCacheStorage$findAll$1.L$2 = concurrentMap;
                        cachingCacheStorage$findAll$1.L$3 = url;
                        cachingCacheStorage$findAll$1.label = 1;
                        Object findAll = cacheStorage.findAll(url, cachingCacheStorage$findAll$1);
                        if (findAll == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        url2 = url;
                        map = concurrentMap;
                        obj = findAll;
                        cachingCacheStorage = this;
                    } else {
                        cachingCacheStorage = this;
                        return MapsKt.getValue(cachingCacheStorage.store, url);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    url = (Url) cachingCacheStorage$findAll$1.L$3;
                    map = (Map) cachingCacheStorage$findAll$1.L$2;
                    url2 = (Url) cachingCacheStorage$findAll$1.L$1;
                    cachingCacheStorage = (CachingCacheStorage) cachingCacheStorage$findAll$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                map.put(url, obj);
                url = url2;
                return MapsKt.getValue(cachingCacheStorage.store, url);
            }
        }
        cachingCacheStorage$findAll$1 = new CachingCacheStorage$findAll$1(this, continuation);
        Object obj2 = cachingCacheStorage$findAll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cachingCacheStorage$findAll$1.label;
        if (i != 0) {
        }
        map.put(url, obj2);
        url = url2;
        return MapsKt.getValue(cachingCacheStorage.store, url);
    }
}
