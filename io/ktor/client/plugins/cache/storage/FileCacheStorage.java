package io.ktor.client.plugins.cache.storage;

import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.tools.SameMD5;
import io.ktor.client.plugins.cache.HttpCacheKt;
import io.ktor.http.HeadersBuilder;
import io.ktor.http.HttpProtocolVersion;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.URLUtilsKt;
import io.ktor.http.Url;
import io.ktor.util.CryptoKt;
import io.ktor.util.StringValuesKt;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.util.date.DateJvmKt;
import io.ktor.util.date.GMTDate;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.ByteReadChannelKt;
import io.ktor.utils.io.ByteWriteChannel;
import io.ktor.utils.io.ByteWriteChannelKt;
import io.ktor.utils.io.core.CloseableJVMKt;
import io.ktor.utils.io.jvm.javaio.ReadingKt;
import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: FileCacheStorage.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J/\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u0010H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\r\u001a\u00020\u000eH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0019\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u001f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\u0006\u0010\u001a\u001a\u00020\tH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ!\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\fH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u00020\u001d2\u0006\u0010\u0017\u001a\u00020!2\u0006\u0010\"\u001a\u00020\fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010#J'\u0010 \u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\t2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\f0&H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010'R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006("}, d2 = {"Lio/ktor/client/plugins/cache/storage/FileCacheStorage;", "Lio/ktor/client/plugins/cache/storage/CacheStorage;", "directory", "Ljava/io/File;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Ljava/io/File;Lkotlinx/coroutines/CoroutineDispatcher;)V", "mutexes", "Lio/ktor/util/collections/ConcurrentMap;", "", "Lkotlinx/coroutines/sync/Mutex;", "find", "Lio/ktor/client/plugins/cache/storage/CachedResponseData;", "url", "Lio/ktor/http/Url;", "varyKeys", "", "(Lio/ktor/http/Url;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findAll", "", "(Lio/ktor/http/Url;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", C3040d4.h.W, "readCache", "channel", "Lio/ktor/utils/io/ByteReadChannel;", "(Lio/ktor/utils/io/ByteReadChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "urlHex", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", C3040d4.h.U, "", "data", "(Lio/ktor/http/Url;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeCache", "Lio/ktor/utils/io/ByteChannel;", "cache", "(Lio/ktor/utils/io/ByteChannel;Lio/ktor/client/plugins/cache/storage/CachedResponseData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "caches", "", "(Ljava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-client-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes8.dex */
final class FileCacheStorage implements CacheStorage {
    private final File directory;
    private final CoroutineDispatcher dispatcher;
    private final ConcurrentMap<String, Mutex> mutexes;

    public FileCacheStorage(File directory, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.directory = directory;
        this.dispatcher = dispatcher;
        this.mutexes = new ConcurrentMap<>(0, 1, null);
        directory.mkdirs();
    }

    public /* synthetic */ FileCacheStorage(File file, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }

    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    public Object store(Url url, CachedResponseData cachedResponseData, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.dispatcher, new FileCacheStorage$store$2(this, url, cachedResponseData, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object findAll(Url url, Continuation<? super Set<CachedResponseData>> continuation) {
        FileCacheStorage$findAll$1 fileCacheStorage$findAll$1;
        int i;
        if (continuation instanceof FileCacheStorage$findAll$1) {
            fileCacheStorage$findAll$1 = (FileCacheStorage$findAll$1) continuation;
            if ((fileCacheStorage$findAll$1.label & Integer.MIN_VALUE) != 0) {
                fileCacheStorage$findAll$1.label -= Integer.MIN_VALUE;
                Object obj = fileCacheStorage$findAll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fileCacheStorage$findAll$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String key = key(url);
                    fileCacheStorage$findAll$1.label = 1;
                    obj = readCache(key, fileCacheStorage$findAll$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return CollectionsKt.toSet((Iterable) obj);
            }
        }
        fileCacheStorage$findAll$1 = new FileCacheStorage$findAll$1(this, continuation);
        Object obj2 = fileCacheStorage$findAll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fileCacheStorage$findAll$1.label;
        if (i != 0) {
        }
        return CollectionsKt.toSet((Iterable) obj2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // io.ktor.client.plugins.cache.storage.CacheStorage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object find(Url url, Map<String, String> map, Continuation<? super CachedResponseData> continuation) {
        FileCacheStorage$find$1 fileCacheStorage$find$1;
        int i;
        if (continuation instanceof FileCacheStorage$find$1) {
            fileCacheStorage$find$1 = (FileCacheStorage$find$1) continuation;
            if ((fileCacheStorage$find$1.label & Integer.MIN_VALUE) != 0) {
                fileCacheStorage$find$1.label -= Integer.MIN_VALUE;
                Object obj = fileCacheStorage$find$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = fileCacheStorage$find$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    String key = key(url);
                    fileCacheStorage$find$1.L$0 = map;
                    fileCacheStorage$find$1.label = 1;
                    obj = readCache(key, fileCacheStorage$find$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    map = (Map) fileCacheStorage$find$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                for (Object obj2 : (Set) obj) {
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
        }
        fileCacheStorage$find$1 = new FileCacheStorage$find$1(this, continuation);
        Object obj3 = fileCacheStorage$find$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fileCacheStorage$find$1.label;
        if (i != 0) {
        }
        while (r6.hasNext()) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String key(Url url) {
        byte[] digest = MessageDigest.getInstance(SameMD5.TAG).digest(StringsKt.encodeToByteArray(url.getUrlString()));
        Intrinsics.checkNotNullExpressionValue(digest, "getInstance(\"MD5\").diges…ng().encodeToByteArray())");
        return CryptoKt.hex(digest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object writeCache(String str, List<CachedResponseData> list, Continuation<Object> continuation) {
        return CoroutineScopeKt.coroutineScope(new FileCacheStorage$writeCache$2(this, str, list, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0178 A[Catch: all -> 0x01a0, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x01a0, blocks: (B:51:0x013e, B:43:0x0178), top: B:50:0x013e }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x013e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00e8 A[Catch: all -> 0x01e4, TRY_LEAVE, TryCatch #3 {all -> 0x01e4, blocks: (B:95:0x01bc, B:75:0x00db, B:77:0x00e8, B:81:0x00f0, B:83:0x00fb, B:84:0x0106, B:93:0x00fe), top: B:7:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00f0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002f  */
    /* JADX WARN: Type inference failed for: r14v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v27 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v35 */
    /* JADX WARN: Type inference failed for: r2v4, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v5, types: [kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.io.Closeable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0159 -> B:38:0x0163). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readCache(String str, Continuation<? super Set<CachedResponseData>> continuation) {
        FileCacheStorage$readCache$1 fileCacheStorage$readCache$1;
        ?? r2;
        int i;
        ?? r22;
        FileCacheStorage fileCacheStorage;
        File file;
        BufferedInputStream bufferedInputStream;
        Closeable closeable;
        Mutex mutex;
        Object obj;
        ByteReadChannel byteReadChannel;
        int i2;
        Throwable th;
        int intValue;
        int i3;
        Set linkedHashSet;
        ByteReadChannel byteReadChannel2;
        Object obj2;
        Object obj3;
        BufferedInputStream bufferedInputStream2;
        Object obj4;
        FileCacheStorage fileCacheStorage2;
        Mutex mutex2;
        String str2 = str;
        try {
            try {
                if (continuation instanceof FileCacheStorage$readCache$1) {
                    fileCacheStorage$readCache$1 = (FileCacheStorage$readCache$1) continuation;
                    if ((fileCacheStorage$readCache$1.label & Integer.MIN_VALUE) != 0) {
                        fileCacheStorage$readCache$1.label -= Integer.MIN_VALUE;
                        r2 = fileCacheStorage$readCache$1.result;
                        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        i = fileCacheStorage$readCache$1.label;
                        int i4 = 0;
                        Object obj5 = null;
                        if (i != 0) {
                            ResultKt.throwOnFailure(r2);
                            Mutex computeIfAbsent = this.mutexes.computeIfAbsent((ConcurrentMap<String, Mutex>) str2, (Function0<? extends Mutex>) new Function0<Mutex>() { // from class: io.ktor.client.plugins.cache.storage.FileCacheStorage$readCache$mutex$1
                                @Override // kotlin.jvm.functions.Function0
                                public final Mutex invoke() {
                                    return MutexKt.Mutex$default(false, 1, null);
                                }
                            });
                            fileCacheStorage$readCache$1.L$0 = this;
                            fileCacheStorage$readCache$1.L$1 = str2;
                            fileCacheStorage$readCache$1.L$2 = computeIfAbsent;
                            fileCacheStorage$readCache$1.label = 1;
                            if (computeIfAbsent.lock(null, fileCacheStorage$readCache$1) != coroutine_suspended) {
                                fileCacheStorage = this;
                                r22 = computeIfAbsent;
                            }
                            return coroutine_suspended;
                        }
                        if (i == 1) {
                            Mutex mutex3 = (Mutex) fileCacheStorage$readCache$1.L$2;
                            String str3 = (String) fileCacheStorage$readCache$1.L$1;
                            FileCacheStorage fileCacheStorage3 = (FileCacheStorage) fileCacheStorage$readCache$1.L$0;
                            ResultKt.throwOnFailure(r2);
                            r22 = mutex3;
                            str2 = str3;
                            fileCacheStorage = fileCacheStorage3;
                        } else if (i == 2) {
                            i2 = fileCacheStorage$readCache$1.I$0;
                            ByteReadChannel byteReadChannel3 = (ByteReadChannel) fileCacheStorage$readCache$1.L$3;
                            ?? r7 = (Closeable) fileCacheStorage$readCache$1.L$2;
                            mutex = (Mutex) fileCacheStorage$readCache$1.L$1;
                            fileCacheStorage = (FileCacheStorage) fileCacheStorage$readCache$1.L$0;
                            try {
                                ResultKt.throwOnFailure(r2);
                                byteReadChannel = byteReadChannel3;
                                bufferedInputStream = r7;
                                obj = r2;
                            } catch (Throwable th2) {
                                th = th2;
                                closeable = r7;
                                closeable.close();
                                throw th;
                            }
                            try {
                                intValue = ((Number) obj).intValue();
                                ByteReadChannel byteReadChannel4 = byteReadChannel;
                                i3 = i2;
                                linkedHashSet = new LinkedHashSet();
                                byteReadChannel2 = byteReadChannel4;
                                obj2 = null;
                                if (i4 >= intValue) {
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                closeable = bufferedInputStream;
                                closeable.close();
                                throw th;
                            }
                        } else {
                            if (i != 3) {
                                if (i != 4) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                int i5 = fileCacheStorage$readCache$1.I$0;
                                linkedHashSet = (Set) fileCacheStorage$readCache$1.L$2;
                                closeable = (Closeable) fileCacheStorage$readCache$1.L$1;
                                mutex2 = (Mutex) fileCacheStorage$readCache$1.L$0;
                                try {
                                    ResultKt.throwOnFailure(r2);
                                    closeable.close();
                                    mutex2.unlock(obj5);
                                    return linkedHashSet;
                                } catch (Throwable th4) {
                                    th = th4;
                                    th = th;
                                    try {
                                        closeable.close();
                                        throw th;
                                    } catch (Throwable th5) {
                                        CloseableJVMKt.addSuppressedInternal(th, th5);
                                        throw th;
                                    }
                                }
                            }
                            int i6 = fileCacheStorage$readCache$1.I$2;
                            int i7 = fileCacheStorage$readCache$1.I$1;
                            int i8 = fileCacheStorage$readCache$1.I$0;
                            Set set = (Set) fileCacheStorage$readCache$1.L$5;
                            Set set2 = (Set) fileCacheStorage$readCache$1.L$4;
                            byteReadChannel2 = (ByteReadChannel) fileCacheStorage$readCache$1.L$3;
                            ?? r14 = (Closeable) fileCacheStorage$readCache$1.L$2;
                            Mutex mutex4 = (Mutex) fileCacheStorage$readCache$1.L$1;
                            FileCacheStorage fileCacheStorage4 = (FileCacheStorage) fileCacheStorage$readCache$1.L$0;
                            try {
                                ResultKt.throwOnFailure(r2);
                                i3 = i8;
                                fileCacheStorage2 = fileCacheStorage4;
                                obj3 = null;
                                obj4 = r2;
                                bufferedInputStream2 = r14;
                            } catch (Throwable th6) {
                                th = th6;
                                closeable = r14;
                                closeable.close();
                                throw th;
                            }
                            try {
                                set.add(obj4);
                                FileCacheStorage fileCacheStorage5 = fileCacheStorage2;
                                i4 = i6 + 1;
                                linkedHashSet = set2;
                                fileCacheStorage = fileCacheStorage5;
                                intValue = i7;
                                bufferedInputStream = bufferedInputStream2;
                                mutex = mutex4;
                                obj2 = obj3;
                                if (i4 >= intValue) {
                                    try {
                                        fileCacheStorage$readCache$1.L$0 = fileCacheStorage;
                                        fileCacheStorage$readCache$1.L$1 = mutex;
                                        fileCacheStorage$readCache$1.L$2 = bufferedInputStream;
                                        fileCacheStorage$readCache$1.L$3 = byteReadChannel2;
                                        fileCacheStorage$readCache$1.L$4 = linkedHashSet;
                                        fileCacheStorage$readCache$1.L$5 = linkedHashSet;
                                        fileCacheStorage$readCache$1.I$0 = i3;
                                        fileCacheStorage$readCache$1.I$1 = intValue;
                                        fileCacheStorage$readCache$1.I$2 = i4;
                                        fileCacheStorage$readCache$1.label = 3;
                                        Object readCache = fileCacheStorage.readCache(byteReadChannel2, fileCacheStorage$readCache$1);
                                        if (readCache != coroutine_suspended) {
                                            obj3 = obj2;
                                            bufferedInputStream2 = bufferedInputStream;
                                            i7 = intValue;
                                            obj4 = readCache;
                                            mutex4 = mutex;
                                            set = linkedHashSet;
                                            i6 = i4;
                                            fileCacheStorage2 = fileCacheStorage;
                                            set2 = set;
                                            set.add(obj4);
                                            FileCacheStorage fileCacheStorage52 = fileCacheStorage2;
                                            i4 = i6 + 1;
                                            linkedHashSet = set2;
                                            fileCacheStorage = fileCacheStorage52;
                                            intValue = i7;
                                            bufferedInputStream = bufferedInputStream2;
                                            mutex = mutex4;
                                            obj2 = obj3;
                                            if (i4 >= intValue) {
                                                fileCacheStorage$readCache$1.L$0 = mutex;
                                                fileCacheStorage$readCache$1.L$1 = bufferedInputStream;
                                                fileCacheStorage$readCache$1.L$2 = linkedHashSet;
                                                fileCacheStorage$readCache$1.L$3 = null;
                                                fileCacheStorage$readCache$1.L$4 = null;
                                                fileCacheStorage$readCache$1.L$5 = null;
                                                fileCacheStorage$readCache$1.I$0 = i3;
                                                fileCacheStorage$readCache$1.label = 4;
                                                if (ByteReadChannelKt.discard(byteReadChannel2, fileCacheStorage$readCache$1) != coroutine_suspended) {
                                                    closeable = bufferedInputStream;
                                                    mutex2 = mutex;
                                                    obj5 = obj2;
                                                    closeable.close();
                                                    mutex2.unlock(obj5);
                                                    return linkedHashSet;
                                                }
                                            }
                                        }
                                        return coroutine_suspended;
                                    } catch (Throwable th7) {
                                        th = th7;
                                        closeable = bufferedInputStream;
                                        closeable.close();
                                        throw th;
                                    }
                                }
                            } catch (Throwable th8) {
                                th = th8;
                                closeable = bufferedInputStream2;
                                closeable.close();
                                throw th;
                            }
                        }
                        file = new File(fileCacheStorage.directory, str2);
                        if (!file.exists()) {
                            try {
                                InputStream fileInputStream = new FileInputStream(file);
                                bufferedInputStream = fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 8192);
                                try {
                                    ByteReadChannel byteReadChannelWithArrayPool$default = ReadingKt.toByteReadChannelWithArrayPool$default(bufferedInputStream, null, null, 3, null);
                                    fileCacheStorage$readCache$1.L$0 = fileCacheStorage;
                                    fileCacheStorage$readCache$1.L$1 = r22;
                                    fileCacheStorage$readCache$1.L$2 = bufferedInputStream;
                                    fileCacheStorage$readCache$1.L$3 = byteReadChannelWithArrayPool$default;
                                    fileCacheStorage$readCache$1.I$0 = 0;
                                    fileCacheStorage$readCache$1.label = 2;
                                    Object readInt = byteReadChannelWithArrayPool$default.readInt(fileCacheStorage$readCache$1);
                                    if (readInt != coroutine_suspended) {
                                        mutex = r22;
                                        obj = readInt;
                                        byteReadChannel = byteReadChannelWithArrayPool$default;
                                        i2 = 0;
                                        intValue = ((Number) obj).intValue();
                                        ByteReadChannel byteReadChannel42 = byteReadChannel;
                                        i3 = i2;
                                        linkedHashSet = new LinkedHashSet();
                                        byteReadChannel2 = byteReadChannel42;
                                        obj2 = null;
                                        if (i4 >= intValue) {
                                        }
                                    }
                                    return coroutine_suspended;
                                } catch (Throwable th9) {
                                    th = th9;
                                    closeable = bufferedInputStream;
                                    th = th;
                                    closeable.close();
                                    throw th;
                                }
                            } catch (Exception e) {
                                e = e;
                                HttpCacheKt.getLOGGER().trace("Exception during cache lookup in a file: " + ExceptionsKt.stackTraceToString(e));
                                Set emptySet = SetsKt.emptySet();
                                r22.unlock(null);
                                return emptySet;
                            }
                        }
                        Set emptySet2 = SetsKt.emptySet();
                        r22.unlock(null);
                        return emptySet2;
                    }
                }
                if (i != 0) {
                }
                file = new File(fileCacheStorage.directory, str2);
                if (!file.exists()) {
                }
            } catch (Throwable th10) {
                th = th10;
                r2.unlock(null);
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            r22 = fileCacheStorage$readCache$1;
        } catch (Throwable th11) {
            th = th11;
            r2 = fileCacheStorage$readCache$1;
            r2.unlock(null);
            throw th;
        }
        fileCacheStorage$readCache$1 = new FileCacheStorage$readCache$1(this, continuation);
        r2 = fileCacheStorage$readCache$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = fileCacheStorage$readCache$1.label;
        int i42 = 0;
        Object obj52 = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0336, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelKt.writeFully(r11, r10, r0) == r1) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0321, code lost:
    
        if (r11.writeInt(r12, r0) == r1) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x028f, code lost:
    
        if (r11.writeInt(r12, r0) == r1) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0277, code lost:
    
        if (r11.writeLong(r5, r0) == r1) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0261, code lost:
    
        if (r11.writeLong(r5, r0) != r1) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01bb, code lost:
    
        if (r2.writeInt(r12, r0) == r1) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x019c, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelKt.writeStringUtf8((io.ktor.utils.io.ByteWriteChannel) r11, r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0) == r1) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0175, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelKt.writeStringUtf8((io.ktor.utils.io.ByteWriteChannel) r11, r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0) != r1) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0130, code lost:
    
        if (io.ktor.utils.io.ByteWriteChannelKt.writeStringUtf8((io.ktor.utils.io.ByteWriteChannel) r10, r2, (kotlin.coroutines.Continuation<? super kotlin.Unit>) r0) == r1) goto L84;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x030a -> B:19:0x029f). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x022d -> B:42:0x01c3). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object writeCache(ByteChannel byteChannel, CachedResponseData cachedResponseData, Continuation<? super Unit> continuation) {
        FileCacheStorage$writeCache$3 fileCacheStorage$writeCache$3;
        ByteChannel byteChannel2;
        CachedResponseData cachedResponseData2;
        ByteChannel byteChannel3;
        CachedResponseData cachedResponseData3;
        List<Pair<String, String>> flattenEntries;
        Iterator<Pair<String, String>> it;
        String str;
        Iterator<Pair<String, String>> it2;
        CachedResponseData cachedResponseData4;
        ByteChannel byteChannel4;
        String str2;
        CachedResponseData cachedResponseData5;
        ByteChannel byteChannel5;
        Iterator<Map.Entry<String, String>> it3;
        String str3;
        Iterator<Map.Entry<String, String>> it4;
        CachedResponseData cachedResponseData6;
        ByteChannel byteChannel6;
        String str4;
        if (continuation instanceof FileCacheStorage$writeCache$3) {
            fileCacheStorage$writeCache$3 = (FileCacheStorage$writeCache$3) continuation;
            if ((fileCacheStorage$writeCache$3.label & Integer.MIN_VALUE) != 0) {
                fileCacheStorage$writeCache$3.label -= Integer.MIN_VALUE;
                Object obj = fileCacheStorage$writeCache$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (fileCacheStorage$writeCache$3.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj);
                        String sb = new StringBuilder().append(cachedResponseData.getUrl()).append('\n').toString();
                        fileCacheStorage$writeCache$3.L$0 = byteChannel;
                        fileCacheStorage$writeCache$3.L$1 = cachedResponseData;
                        fileCacheStorage$writeCache$3.label = 1;
                        break;
                    case 1:
                        cachedResponseData = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        int value = cachedResponseData.getStatusCode().getValue();
                        fileCacheStorage$writeCache$3.L$0 = byteChannel;
                        fileCacheStorage$writeCache$3.L$1 = cachedResponseData;
                        fileCacheStorage$writeCache$3.label = 2;
                        if (byteChannel.writeInt(value, fileCacheStorage$writeCache$3) != coroutine_suspended) {
                            CachedResponseData cachedResponseData7 = cachedResponseData;
                            byteChannel2 = byteChannel;
                            cachedResponseData2 = cachedResponseData7;
                            String str5 = cachedResponseData2.getStatusCode().getDescription() + '\n';
                            fileCacheStorage$writeCache$3.L$0 = byteChannel2;
                            fileCacheStorage$writeCache$3.L$1 = cachedResponseData2;
                            fileCacheStorage$writeCache$3.label = 3;
                            break;
                        }
                        return coroutine_suspended;
                    case 2:
                        cachedResponseData2 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel2 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        String str52 = cachedResponseData2.getStatusCode().getDescription() + '\n';
                        fileCacheStorage$writeCache$3.L$0 = byteChannel2;
                        fileCacheStorage$writeCache$3.L$1 = cachedResponseData2;
                        fileCacheStorage$writeCache$3.label = 3;
                        break;
                    case 3:
                        cachedResponseData2 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel2 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        String sb2 = new StringBuilder().append(cachedResponseData2.getVersion()).append('\n').toString();
                        fileCacheStorage$writeCache$3.L$0 = byteChannel2;
                        fileCacheStorage$writeCache$3.L$1 = cachedResponseData2;
                        fileCacheStorage$writeCache$3.label = 4;
                        break;
                    case 4:
                        cachedResponseData2 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel2 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        byteChannel3 = byteChannel2;
                        cachedResponseData3 = cachedResponseData2;
                        flattenEntries = StringValuesKt.flattenEntries(cachedResponseData3.getHeaders());
                        int size = flattenEntries.size();
                        fileCacheStorage$writeCache$3.L$0 = byteChannel3;
                        fileCacheStorage$writeCache$3.L$1 = cachedResponseData3;
                        fileCacheStorage$writeCache$3.L$2 = flattenEntries;
                        fileCacheStorage$writeCache$3.label = 5;
                        break;
                    case 5:
                        flattenEntries = (List) fileCacheStorage$writeCache$3.L$2;
                        cachedResponseData3 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel3 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        it = flattenEntries.iterator();
                        if (it.hasNext()) {
                            Pair<String, String> next = it.next();
                            String component1 = next.component1();
                            String component2 = next.component2();
                            String str6 = component1 + '\n';
                            fileCacheStorage$writeCache$3.L$0 = byteChannel3;
                            fileCacheStorage$writeCache$3.L$1 = cachedResponseData3;
                            fileCacheStorage$writeCache$3.L$2 = it;
                            fileCacheStorage$writeCache$3.L$3 = component2;
                            fileCacheStorage$writeCache$3.label = 6;
                            if (ByteWriteChannelKt.writeStringUtf8((ByteWriteChannel) byteChannel3, str6, (Continuation<? super Unit>) fileCacheStorage$writeCache$3) != coroutine_suspended) {
                                byteChannel4 = byteChannel3;
                                cachedResponseData4 = cachedResponseData3;
                                it2 = it;
                                str = component2;
                                str2 = str + '\n';
                                fileCacheStorage$writeCache$3.L$0 = byteChannel4;
                                fileCacheStorage$writeCache$3.L$1 = cachedResponseData4;
                                fileCacheStorage$writeCache$3.L$2 = it2;
                                fileCacheStorage$writeCache$3.L$3 = null;
                                fileCacheStorage$writeCache$3.label = 7;
                                if (ByteWriteChannelKt.writeStringUtf8((ByteWriteChannel) byteChannel4, str2, (Continuation<? super Unit>) fileCacheStorage$writeCache$3) != coroutine_suspended) {
                                    it = it2;
                                    cachedResponseData3 = cachedResponseData4;
                                    byteChannel3 = byteChannel4;
                                    if (it.hasNext()) {
                                        long timestamp = cachedResponseData3.getRequestTime().getTimestamp();
                                        fileCacheStorage$writeCache$3.L$0 = byteChannel3;
                                        fileCacheStorage$writeCache$3.L$1 = cachedResponseData3;
                                        fileCacheStorage$writeCache$3.L$2 = null;
                                        fileCacheStorage$writeCache$3.label = 8;
                                        if (byteChannel3.writeLong(timestamp, fileCacheStorage$writeCache$3) != coroutine_suspended) {
                                            cachedResponseData5 = cachedResponseData3;
                                            byteChannel5 = byteChannel3;
                                            long timestamp2 = cachedResponseData5.getResponseTime().getTimestamp();
                                            fileCacheStorage$writeCache$3.L$0 = byteChannel5;
                                            fileCacheStorage$writeCache$3.L$1 = cachedResponseData5;
                                            fileCacheStorage$writeCache$3.label = 9;
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 6:
                        str = (String) fileCacheStorage$writeCache$3.L$3;
                        it2 = (Iterator) fileCacheStorage$writeCache$3.L$2;
                        cachedResponseData4 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel4 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        str2 = str + '\n';
                        fileCacheStorage$writeCache$3.L$0 = byteChannel4;
                        fileCacheStorage$writeCache$3.L$1 = cachedResponseData4;
                        fileCacheStorage$writeCache$3.L$2 = it2;
                        fileCacheStorage$writeCache$3.L$3 = null;
                        fileCacheStorage$writeCache$3.label = 7;
                        if (ByteWriteChannelKt.writeStringUtf8((ByteWriteChannel) byteChannel4, str2, (Continuation<? super Unit>) fileCacheStorage$writeCache$3) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 7:
                        it = (Iterator) fileCacheStorage$writeCache$3.L$2;
                        cachedResponseData3 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel3 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (it.hasNext()) {
                        }
                        return coroutine_suspended;
                    case 8:
                        cachedResponseData5 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel5 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        long timestamp22 = cachedResponseData5.getResponseTime().getTimestamp();
                        fileCacheStorage$writeCache$3.L$0 = byteChannel5;
                        fileCacheStorage$writeCache$3.L$1 = cachedResponseData5;
                        fileCacheStorage$writeCache$3.label = 9;
                        break;
                    case 9:
                        cachedResponseData5 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel5 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        long timestamp3 = cachedResponseData5.getExpires().getTimestamp();
                        fileCacheStorage$writeCache$3.L$0 = byteChannel5;
                        fileCacheStorage$writeCache$3.L$1 = cachedResponseData5;
                        fileCacheStorage$writeCache$3.label = 10;
                        break;
                    case 10:
                        cachedResponseData5 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel5 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        int size2 = cachedResponseData5.getVaryKeys().size();
                        fileCacheStorage$writeCache$3.L$0 = byteChannel5;
                        fileCacheStorage$writeCache$3.L$1 = cachedResponseData5;
                        fileCacheStorage$writeCache$3.label = 11;
                        break;
                    case 11:
                        cachedResponseData5 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel5 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        it3 = cachedResponseData5.getVaryKeys().entrySet().iterator();
                        if (it3.hasNext()) {
                            Map.Entry<String, String> next2 = it3.next();
                            String key = next2.getKey();
                            String value2 = next2.getValue();
                            String str7 = key + '\n';
                            fileCacheStorage$writeCache$3.L$0 = byteChannel5;
                            fileCacheStorage$writeCache$3.L$1 = cachedResponseData5;
                            fileCacheStorage$writeCache$3.L$2 = it3;
                            fileCacheStorage$writeCache$3.L$3 = value2;
                            fileCacheStorage$writeCache$3.label = 12;
                            if (ByteWriteChannelKt.writeStringUtf8((ByteWriteChannel) byteChannel5, str7, (Continuation<? super Unit>) fileCacheStorage$writeCache$3) != coroutine_suspended) {
                                cachedResponseData6 = cachedResponseData5;
                                str3 = value2;
                                byteChannel6 = byteChannel5;
                                it4 = it3;
                                str4 = str3 + '\n';
                                fileCacheStorage$writeCache$3.L$0 = byteChannel6;
                                fileCacheStorage$writeCache$3.L$1 = cachedResponseData6;
                                fileCacheStorage$writeCache$3.L$2 = it4;
                                fileCacheStorage$writeCache$3.L$3 = null;
                                fileCacheStorage$writeCache$3.label = 13;
                                if (ByteWriteChannelKt.writeStringUtf8((ByteWriteChannel) byteChannel6, str4, (Continuation<? super Unit>) fileCacheStorage$writeCache$3) != coroutine_suspended) {
                                    it3 = it4;
                                    cachedResponseData5 = cachedResponseData6;
                                    byteChannel5 = byteChannel6;
                                    if (it3.hasNext()) {
                                        int length = cachedResponseData5.getBody().length;
                                        fileCacheStorage$writeCache$3.L$0 = byteChannel5;
                                        fileCacheStorage$writeCache$3.L$1 = cachedResponseData5;
                                        fileCacheStorage$writeCache$3.L$2 = null;
                                        fileCacheStorage$writeCache$3.label = 14;
                                        break;
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 12:
                        str3 = (String) fileCacheStorage$writeCache$3.L$3;
                        it4 = (Iterator) fileCacheStorage$writeCache$3.L$2;
                        cachedResponseData6 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel6 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        str4 = str3 + '\n';
                        fileCacheStorage$writeCache$3.L$0 = byteChannel6;
                        fileCacheStorage$writeCache$3.L$1 = cachedResponseData6;
                        fileCacheStorage$writeCache$3.L$2 = it4;
                        fileCacheStorage$writeCache$3.L$3 = null;
                        fileCacheStorage$writeCache$3.label = 13;
                        if (ByteWriteChannelKt.writeStringUtf8((ByteWriteChannel) byteChannel6, str4, (Continuation<? super Unit>) fileCacheStorage$writeCache$3) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 13:
                        Iterator<Map.Entry<String, String>> it5 = (Iterator) fileCacheStorage$writeCache$3.L$2;
                        CachedResponseData cachedResponseData8 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        ByteChannel byteChannel7 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        it3 = it5;
                        cachedResponseData5 = cachedResponseData8;
                        byteChannel5 = byteChannel7;
                        if (it3.hasNext()) {
                        }
                        return coroutine_suspended;
                    case 14:
                        cachedResponseData5 = (CachedResponseData) fileCacheStorage$writeCache$3.L$1;
                        byteChannel5 = (ByteChannel) fileCacheStorage$writeCache$3.L$0;
                        ResultKt.throwOnFailure(obj);
                        byte[] body = cachedResponseData5.getBody();
                        fileCacheStorage$writeCache$3.L$0 = null;
                        fileCacheStorage$writeCache$3.L$1 = null;
                        fileCacheStorage$writeCache$3.label = 15;
                        break;
                    case 15:
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        fileCacheStorage$writeCache$3 = new FileCacheStorage$writeCache$3(this, continuation);
        Object obj2 = fileCacheStorage$writeCache$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (fileCacheStorage$writeCache$3.label) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x03a2, code lost:
    
        if (r1 != r4) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0358, code lost:
    
        if (r1 != r4) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0308, code lost:
    
        if (r1 != r4) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x02b4, code lost:
    
        if (r1 != r4) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0273, code lost:
    
        if (r1 != r4) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0244, code lost:
    
        if (r1 == r4) goto L88;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x011a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0416 -> B:21:0x00c8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0308 -> B:47:0x01c1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object readCache(ByteReadChannel byteReadChannel, Continuation<? super CachedResponseData> continuation) {
        FileCacheStorage$readCache$3 fileCacheStorage$readCache$3;
        String str;
        ByteReadChannel byteReadChannel2;
        int intValue;
        HttpProtocolVersion.Companion companion;
        String str2;
        HttpStatusCode httpStatusCode;
        ByteReadChannel byteReadChannel3;
        HttpProtocolVersion parse;
        int intValue2;
        HeadersBuilder headersBuilder;
        Object obj;
        int i;
        int i2;
        int i3;
        ByteReadChannel byteReadChannel4;
        String str3;
        HttpStatusCode httpStatusCode2;
        HttpProtocolVersion httpProtocolVersion;
        HeadersBuilder headersBuilder2;
        String str4;
        ByteReadChannel byteReadChannel5;
        HttpStatusCode httpStatusCode3;
        HeadersBuilder headersBuilder3;
        String str5;
        HttpProtocolVersion httpProtocolVersion2;
        GMTDate GMTDate;
        ByteReadChannel byteReadChannel6;
        HttpStatusCode httpStatusCode4;
        HeadersBuilder headersBuilder4;
        GMTDate gMTDate;
        String str6;
        HttpProtocolVersion httpProtocolVersion3;
        GMTDate gMTDate2;
        GMTDate GMTDate2;
        int intValue3;
        Map createMapBuilder;
        Map map;
        int i4;
        ByteReadChannel byteReadChannel7;
        HttpProtocolVersion httpProtocolVersion4;
        GMTDate gMTDate3;
        Map map2;
        Map map3;
        String str7;
        HeadersBuilder headersBuilder5;
        GMTDate gMTDate4;
        HttpStatusCode httpStatusCode5;
        GMTDate gMTDate5;
        String str8;
        int i5;
        GMTDate gMTDate6;
        Map map4;
        GMTDate gMTDate7;
        byte[] bArr;
        Map map5;
        byte[] bArr2;
        String str9;
        ByteReadChannel byteReadChannel8 = byteReadChannel;
        if (continuation instanceof FileCacheStorage$readCache$3) {
            fileCacheStorage$readCache$3 = (FileCacheStorage$readCache$3) continuation;
            if ((fileCacheStorage$readCache$3.label & Integer.MIN_VALUE) != 0) {
                fileCacheStorage$readCache$3.label -= Integer.MIN_VALUE;
                Object obj2 = fileCacheStorage$readCache$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i6 = 0;
                switch (fileCacheStorage$readCache$3.label) {
                    case 0:
                        ResultKt.throwOnFailure(obj2);
                        fileCacheStorage$readCache$3.L$0 = byteReadChannel8;
                        fileCacheStorage$readCache$3.label = 1;
                        obj2 = ByteReadChannelKt.readUTF8Line(byteReadChannel8, fileCacheStorage$readCache$3);
                        break;
                    case 1:
                        byteReadChannel8 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        Intrinsics.checkNotNull(obj2);
                        String str10 = (String) obj2;
                        fileCacheStorage$readCache$3.L$0 = byteReadChannel8;
                        fileCacheStorage$readCache$3.L$1 = str10;
                        fileCacheStorage$readCache$3.label = 2;
                        Object readInt = byteReadChannel8.readInt(fileCacheStorage$readCache$3);
                        if (readInt != coroutine_suspended) {
                            str = str10;
                            obj2 = readInt;
                            byteReadChannel2 = byteReadChannel8;
                            intValue = ((Number) obj2).intValue();
                            fileCacheStorage$readCache$3.L$0 = byteReadChannel2;
                            fileCacheStorage$readCache$3.L$1 = str;
                            fileCacheStorage$readCache$3.I$0 = intValue;
                            fileCacheStorage$readCache$3.label = 3;
                            obj2 = ByteReadChannelKt.readUTF8Line(byteReadChannel2, fileCacheStorage$readCache$3);
                            break;
                        }
                        return coroutine_suspended;
                    case 2:
                        String str11 = (String) fileCacheStorage$readCache$3.L$1;
                        ByteReadChannel byteReadChannel9 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        byteReadChannel2 = byteReadChannel9;
                        str = str11;
                        intValue = ((Number) obj2).intValue();
                        fileCacheStorage$readCache$3.L$0 = byteReadChannel2;
                        fileCacheStorage$readCache$3.L$1 = str;
                        fileCacheStorage$readCache$3.I$0 = intValue;
                        fileCacheStorage$readCache$3.label = 3;
                        obj2 = ByteReadChannelKt.readUTF8Line(byteReadChannel2, fileCacheStorage$readCache$3);
                        break;
                    case 3:
                        intValue = fileCacheStorage$readCache$3.I$0;
                        str = (String) fileCacheStorage$readCache$3.L$1;
                        byteReadChannel2 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        Intrinsics.checkNotNull(obj2);
                        HttpStatusCode httpStatusCode6 = new HttpStatusCode(intValue, (String) obj2);
                        companion = HttpProtocolVersion.INSTANCE;
                        fileCacheStorage$readCache$3.L$0 = byteReadChannel2;
                        fileCacheStorage$readCache$3.L$1 = str;
                        fileCacheStorage$readCache$3.L$2 = httpStatusCode6;
                        fileCacheStorage$readCache$3.L$3 = companion;
                        fileCacheStorage$readCache$3.label = 4;
                        obj2 = ByteReadChannelKt.readUTF8Line(byteReadChannel2, fileCacheStorage$readCache$3);
                        if (obj2 != coroutine_suspended) {
                            ByteReadChannel byteReadChannel10 = byteReadChannel2;
                            str2 = str;
                            httpStatusCode = httpStatusCode6;
                            byteReadChannel3 = byteReadChannel10;
                            Intrinsics.checkNotNull(obj2);
                            parse = companion.parse((CharSequence) obj2);
                            fileCacheStorage$readCache$3.L$0 = byteReadChannel3;
                            fileCacheStorage$readCache$3.L$1 = str2;
                            fileCacheStorage$readCache$3.L$2 = httpStatusCode;
                            fileCacheStorage$readCache$3.L$3 = parse;
                            fileCacheStorage$readCache$3.label = 5;
                            obj2 = byteReadChannel3.readInt(fileCacheStorage$readCache$3);
                            break;
                        }
                        return coroutine_suspended;
                    case 4:
                        companion = (HttpProtocolVersion.Companion) fileCacheStorage$readCache$3.L$3;
                        httpStatusCode = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        str2 = (String) fileCacheStorage$readCache$3.L$1;
                        byteReadChannel3 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        Intrinsics.checkNotNull(obj2);
                        parse = companion.parse((CharSequence) obj2);
                        fileCacheStorage$readCache$3.L$0 = byteReadChannel3;
                        fileCacheStorage$readCache$3.L$1 = str2;
                        fileCacheStorage$readCache$3.L$2 = httpStatusCode;
                        fileCacheStorage$readCache$3.L$3 = parse;
                        fileCacheStorage$readCache$3.label = 5;
                        obj2 = byteReadChannel3.readInt(fileCacheStorage$readCache$3);
                        break;
                    case 5:
                        parse = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        httpStatusCode = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        str2 = (String) fileCacheStorage$readCache$3.L$1;
                        byteReadChannel3 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        intValue2 = ((Number) obj2).intValue();
                        obj = null;
                        headersBuilder = new HeadersBuilder(0, 1, null);
                        i = 0;
                        if (i >= intValue2) {
                            fileCacheStorage$readCache$3.L$0 = byteReadChannel3;
                            fileCacheStorage$readCache$3.L$1 = str2;
                            fileCacheStorage$readCache$3.L$2 = httpStatusCode;
                            fileCacheStorage$readCache$3.L$3 = parse;
                            fileCacheStorage$readCache$3.L$4 = headersBuilder;
                            fileCacheStorage$readCache$3.L$5 = obj;
                            fileCacheStorage$readCache$3.I$0 = intValue2;
                            fileCacheStorage$readCache$3.I$1 = i;
                            fileCacheStorage$readCache$3.label = 6;
                            Object readUTF8Line = ByteReadChannelKt.readUTF8Line(byteReadChannel3, fileCacheStorage$readCache$3);
                            if (readUTF8Line != coroutine_suspended) {
                                byteReadChannel4 = byteReadChannel3;
                                headersBuilder2 = headersBuilder;
                                httpProtocolVersion = parse;
                                i2 = i;
                                httpStatusCode2 = httpStatusCode;
                                i3 = intValue2;
                                obj2 = readUTF8Line;
                                str3 = str2;
                                Intrinsics.checkNotNull(obj2);
                                str4 = (String) obj2;
                                fileCacheStorage$readCache$3.L$0 = byteReadChannel4;
                                fileCacheStorage$readCache$3.L$1 = str3;
                                fileCacheStorage$readCache$3.L$2 = httpStatusCode2;
                                fileCacheStorage$readCache$3.L$3 = httpProtocolVersion;
                                fileCacheStorage$readCache$3.L$4 = headersBuilder2;
                                fileCacheStorage$readCache$3.L$5 = str4;
                                fileCacheStorage$readCache$3.I$0 = i3;
                                fileCacheStorage$readCache$3.I$1 = i2;
                                fileCacheStorage$readCache$3.label = 7;
                                obj2 = ByteReadChannelKt.readUTF8Line(byteReadChannel4, fileCacheStorage$readCache$3);
                                break;
                            }
                        } else {
                            fileCacheStorage$readCache$3.L$0 = byteReadChannel3;
                            fileCacheStorage$readCache$3.L$1 = str2;
                            fileCacheStorage$readCache$3.L$2 = httpStatusCode;
                            fileCacheStorage$readCache$3.L$3 = parse;
                            fileCacheStorage$readCache$3.L$4 = headersBuilder;
                            fileCacheStorage$readCache$3.L$5 = null;
                            fileCacheStorage$readCache$3.label = 8;
                            obj2 = byteReadChannel3.readLong(fileCacheStorage$readCache$3);
                            if (obj2 != coroutine_suspended) {
                                byteReadChannel5 = byteReadChannel3;
                                httpStatusCode3 = httpStatusCode;
                                headersBuilder3 = headersBuilder;
                                str5 = str2;
                                httpProtocolVersion2 = parse;
                                GMTDate = DateJvmKt.GMTDate((Long) obj2);
                                fileCacheStorage$readCache$3.L$0 = byteReadChannel5;
                                fileCacheStorage$readCache$3.L$1 = str5;
                                fileCacheStorage$readCache$3.L$2 = httpStatusCode3;
                                fileCacheStorage$readCache$3.L$3 = httpProtocolVersion2;
                                fileCacheStorage$readCache$3.L$4 = headersBuilder3;
                                fileCacheStorage$readCache$3.L$5 = GMTDate;
                                fileCacheStorage$readCache$3.label = 9;
                                obj2 = byteReadChannel5.readLong(fileCacheStorage$readCache$3);
                                break;
                            }
                        }
                        return coroutine_suspended;
                    case 6:
                        i2 = fileCacheStorage$readCache$3.I$1;
                        i3 = fileCacheStorage$readCache$3.I$0;
                        HeadersBuilder headersBuilder6 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        HttpProtocolVersion httpProtocolVersion5 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        HttpStatusCode httpStatusCode7 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        String str12 = (String) fileCacheStorage$readCache$3.L$1;
                        ByteReadChannel byteReadChannel11 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        byteReadChannel4 = byteReadChannel11;
                        str3 = str12;
                        httpStatusCode2 = httpStatusCode7;
                        httpProtocolVersion = httpProtocolVersion5;
                        headersBuilder2 = headersBuilder6;
                        Intrinsics.checkNotNull(obj2);
                        str4 = (String) obj2;
                        fileCacheStorage$readCache$3.L$0 = byteReadChannel4;
                        fileCacheStorage$readCache$3.L$1 = str3;
                        fileCacheStorage$readCache$3.L$2 = httpStatusCode2;
                        fileCacheStorage$readCache$3.L$3 = httpProtocolVersion;
                        fileCacheStorage$readCache$3.L$4 = headersBuilder2;
                        fileCacheStorage$readCache$3.L$5 = str4;
                        fileCacheStorage$readCache$3.I$0 = i3;
                        fileCacheStorage$readCache$3.I$1 = i2;
                        fileCacheStorage$readCache$3.label = 7;
                        obj2 = ByteReadChannelKt.readUTF8Line(byteReadChannel4, fileCacheStorage$readCache$3);
                        break;
                    case 7:
                        i2 = fileCacheStorage$readCache$3.I$1;
                        i3 = fileCacheStorage$readCache$3.I$0;
                        str4 = (String) fileCacheStorage$readCache$3.L$5;
                        headersBuilder2 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        httpProtocolVersion = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        httpStatusCode2 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        str3 = (String) fileCacheStorage$readCache$3.L$1;
                        byteReadChannel4 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        ByteReadChannel byteReadChannel12 = byteReadChannel4;
                        HeadersBuilder headersBuilder7 = headersBuilder2;
                        byteReadChannel3 = byteReadChannel12;
                        Intrinsics.checkNotNull(obj2);
                        headersBuilder7.append(str4, (String) obj2);
                        intValue2 = i3;
                        httpStatusCode = httpStatusCode2;
                        str2 = str3;
                        obj = null;
                        i = i2 + 1;
                        parse = httpProtocolVersion;
                        headersBuilder = headersBuilder7;
                        if (i >= intValue2) {
                        }
                        return coroutine_suspended;
                    case 8:
                        HeadersBuilder headersBuilder8 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        HttpProtocolVersion httpProtocolVersion6 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        HttpStatusCode httpStatusCode8 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        String str13 = (String) fileCacheStorage$readCache$3.L$1;
                        ByteReadChannel byteReadChannel13 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        byteReadChannel5 = byteReadChannel13;
                        str5 = str13;
                        httpStatusCode3 = httpStatusCode8;
                        httpProtocolVersion2 = httpProtocolVersion6;
                        headersBuilder3 = headersBuilder8;
                        GMTDate = DateJvmKt.GMTDate((Long) obj2);
                        fileCacheStorage$readCache$3.L$0 = byteReadChannel5;
                        fileCacheStorage$readCache$3.L$1 = str5;
                        fileCacheStorage$readCache$3.L$2 = httpStatusCode3;
                        fileCacheStorage$readCache$3.L$3 = httpProtocolVersion2;
                        fileCacheStorage$readCache$3.L$4 = headersBuilder3;
                        fileCacheStorage$readCache$3.L$5 = GMTDate;
                        fileCacheStorage$readCache$3.label = 9;
                        obj2 = byteReadChannel5.readLong(fileCacheStorage$readCache$3);
                        break;
                    case 9:
                        GMTDate = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        headersBuilder3 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        httpProtocolVersion2 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        httpStatusCode3 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        str5 = (String) fileCacheStorage$readCache$3.L$1;
                        byteReadChannel5 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        GMTDate GMTDate3 = DateJvmKt.GMTDate((Long) obj2);
                        fileCacheStorage$readCache$3.L$0 = byteReadChannel5;
                        fileCacheStorage$readCache$3.L$1 = str5;
                        fileCacheStorage$readCache$3.L$2 = httpStatusCode3;
                        fileCacheStorage$readCache$3.L$3 = httpProtocolVersion2;
                        fileCacheStorage$readCache$3.L$4 = headersBuilder3;
                        fileCacheStorage$readCache$3.L$5 = GMTDate;
                        fileCacheStorage$readCache$3.L$6 = GMTDate3;
                        fileCacheStorage$readCache$3.label = 10;
                        Object readLong = byteReadChannel5.readLong(fileCacheStorage$readCache$3);
                        if (readLong != coroutine_suspended) {
                            byteReadChannel6 = byteReadChannel5;
                            httpStatusCode4 = httpStatusCode3;
                            headersBuilder4 = headersBuilder3;
                            gMTDate = GMTDate3;
                            obj2 = readLong;
                            str6 = str5;
                            httpProtocolVersion3 = httpProtocolVersion2;
                            gMTDate2 = GMTDate;
                            GMTDate2 = DateJvmKt.GMTDate((Long) obj2);
                            fileCacheStorage$readCache$3.L$0 = byteReadChannel6;
                            fileCacheStorage$readCache$3.L$1 = str6;
                            fileCacheStorage$readCache$3.L$2 = httpStatusCode4;
                            fileCacheStorage$readCache$3.L$3 = httpProtocolVersion3;
                            fileCacheStorage$readCache$3.L$4 = headersBuilder4;
                            fileCacheStorage$readCache$3.L$5 = gMTDate2;
                            fileCacheStorage$readCache$3.L$6 = gMTDate;
                            fileCacheStorage$readCache$3.L$7 = GMTDate2;
                            fileCacheStorage$readCache$3.label = 11;
                            obj2 = byteReadChannel6.readInt(fileCacheStorage$readCache$3);
                            break;
                        }
                        return coroutine_suspended;
                    case 10:
                        GMTDate gMTDate8 = (GMTDate) fileCacheStorage$readCache$3.L$6;
                        GMTDate gMTDate9 = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        HeadersBuilder headersBuilder9 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        HttpProtocolVersion httpProtocolVersion7 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        HttpStatusCode httpStatusCode9 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        String str14 = (String) fileCacheStorage$readCache$3.L$1;
                        ByteReadChannel byteReadChannel14 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        byteReadChannel6 = byteReadChannel14;
                        str6 = str14;
                        httpStatusCode4 = httpStatusCode9;
                        httpProtocolVersion3 = httpProtocolVersion7;
                        headersBuilder4 = headersBuilder9;
                        gMTDate2 = gMTDate9;
                        gMTDate = gMTDate8;
                        GMTDate2 = DateJvmKt.GMTDate((Long) obj2);
                        fileCacheStorage$readCache$3.L$0 = byteReadChannel6;
                        fileCacheStorage$readCache$3.L$1 = str6;
                        fileCacheStorage$readCache$3.L$2 = httpStatusCode4;
                        fileCacheStorage$readCache$3.L$3 = httpProtocolVersion3;
                        fileCacheStorage$readCache$3.L$4 = headersBuilder4;
                        fileCacheStorage$readCache$3.L$5 = gMTDate2;
                        fileCacheStorage$readCache$3.L$6 = gMTDate;
                        fileCacheStorage$readCache$3.L$7 = GMTDate2;
                        fileCacheStorage$readCache$3.label = 11;
                        obj2 = byteReadChannel6.readInt(fileCacheStorage$readCache$3);
                        break;
                    case 11:
                        GMTDate2 = (GMTDate) fileCacheStorage$readCache$3.L$7;
                        gMTDate = (GMTDate) fileCacheStorage$readCache$3.L$6;
                        gMTDate2 = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        headersBuilder4 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        httpProtocolVersion3 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        httpStatusCode4 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        str6 = (String) fileCacheStorage$readCache$3.L$1;
                        byteReadChannel6 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        intValue3 = ((Number) obj2).intValue();
                        createMapBuilder = MapsKt.createMapBuilder();
                        map = createMapBuilder;
                        if (i6 < intValue3) {
                            fileCacheStorage$readCache$3.L$0 = byteReadChannel6;
                            fileCacheStorage$readCache$3.L$1 = str6;
                            fileCacheStorage$readCache$3.L$2 = httpStatusCode4;
                            fileCacheStorage$readCache$3.L$3 = httpProtocolVersion3;
                            fileCacheStorage$readCache$3.L$4 = headersBuilder4;
                            fileCacheStorage$readCache$3.L$5 = gMTDate2;
                            fileCacheStorage$readCache$3.L$6 = gMTDate;
                            fileCacheStorage$readCache$3.L$7 = GMTDate2;
                            fileCacheStorage$readCache$3.L$8 = createMapBuilder;
                            fileCacheStorage$readCache$3.L$9 = map;
                            fileCacheStorage$readCache$3.L$10 = null;
                            fileCacheStorage$readCache$3.I$0 = intValue3;
                            fileCacheStorage$readCache$3.I$1 = i6;
                            fileCacheStorage$readCache$3.label = 12;
                            Object readUTF8Line2 = ByteReadChannelKt.readUTF8Line(byteReadChannel6, fileCacheStorage$readCache$3);
                            if (readUTF8Line2 != coroutine_suspended) {
                                String str15 = str6;
                                gMTDate4 = GMTDate2;
                                byteReadChannel7 = byteReadChannel6;
                                gMTDate3 = gMTDate;
                                i4 = intValue3;
                                obj2 = readUTF8Line2;
                                httpProtocolVersion4 = httpProtocolVersion3;
                                map2 = map;
                                headersBuilder5 = headersBuilder4;
                                httpStatusCode5 = httpStatusCode4;
                                map3 = createMapBuilder;
                                gMTDate5 = gMTDate2;
                                str7 = str15;
                                Intrinsics.checkNotNull(obj2);
                                String str16 = (String) obj2;
                                fileCacheStorage$readCache$3.L$0 = byteReadChannel7;
                                fileCacheStorage$readCache$3.L$1 = str7;
                                fileCacheStorage$readCache$3.L$2 = httpStatusCode5;
                                fileCacheStorage$readCache$3.L$3 = httpProtocolVersion4;
                                fileCacheStorage$readCache$3.L$4 = headersBuilder5;
                                fileCacheStorage$readCache$3.L$5 = gMTDate5;
                                fileCacheStorage$readCache$3.L$6 = gMTDate3;
                                fileCacheStorage$readCache$3.L$7 = gMTDate4;
                                fileCacheStorage$readCache$3.L$8 = map3;
                                fileCacheStorage$readCache$3.L$9 = map2;
                                fileCacheStorage$readCache$3.L$10 = str16;
                                fileCacheStorage$readCache$3.I$0 = i4;
                                fileCacheStorage$readCache$3.I$1 = i6;
                                fileCacheStorage$readCache$3.label = 13;
                                obj2 = ByteReadChannelKt.readUTF8Line(byteReadChannel7, fileCacheStorage$readCache$3);
                                if (obj2 != coroutine_suspended) {
                                    int i7 = i6;
                                    str8 = str16;
                                    i5 = i7;
                                    HeadersBuilder headersBuilder10 = headersBuilder5;
                                    ByteReadChannel byteReadChannel15 = byteReadChannel7;
                                    Map map6 = map2;
                                    httpProtocolVersion3 = httpProtocolVersion4;
                                    Map map7 = map3;
                                    httpStatusCode4 = httpStatusCode5;
                                    headersBuilder4 = headersBuilder10;
                                    GMTDate gMTDate10 = gMTDate5;
                                    String str17 = str7;
                                    gMTDate2 = gMTDate10;
                                    Intrinsics.checkNotNull(obj2);
                                    map6.put(str8, (String) obj2);
                                    i6 = i5 + 1;
                                    intValue3 = i4;
                                    gMTDate = gMTDate3;
                                    byteReadChannel6 = byteReadChannel15;
                                    map = map6;
                                    GMTDate2 = gMTDate4;
                                    str6 = str17;
                                    createMapBuilder = map7;
                                    if (i6 < intValue3) {
                                        Map build = MapsKt.build(createMapBuilder);
                                        fileCacheStorage$readCache$3.L$0 = byteReadChannel6;
                                        fileCacheStorage$readCache$3.L$1 = str6;
                                        fileCacheStorage$readCache$3.L$2 = httpStatusCode4;
                                        fileCacheStorage$readCache$3.L$3 = httpProtocolVersion3;
                                        fileCacheStorage$readCache$3.L$4 = headersBuilder4;
                                        fileCacheStorage$readCache$3.L$5 = gMTDate2;
                                        fileCacheStorage$readCache$3.L$6 = gMTDate;
                                        fileCacheStorage$readCache$3.L$7 = GMTDate2;
                                        fileCacheStorage$readCache$3.L$8 = build;
                                        fileCacheStorage$readCache$3.L$9 = null;
                                        fileCacheStorage$readCache$3.L$10 = null;
                                        fileCacheStorage$readCache$3.label = 14;
                                        Object readInt2 = byteReadChannel6.readInt(fileCacheStorage$readCache$3);
                                        if (readInt2 != coroutine_suspended) {
                                            GMTDate gMTDate11 = gMTDate;
                                            gMTDate6 = GMTDate2;
                                            map4 = build;
                                            obj2 = readInt2;
                                            gMTDate7 = gMTDate11;
                                            bArr = new byte[((Number) obj2).intValue()];
                                            fileCacheStorage$readCache$3.L$0 = str6;
                                            fileCacheStorage$readCache$3.L$1 = httpStatusCode4;
                                            fileCacheStorage$readCache$3.L$2 = httpProtocolVersion3;
                                            fileCacheStorage$readCache$3.L$3 = headersBuilder4;
                                            fileCacheStorage$readCache$3.L$4 = gMTDate2;
                                            fileCacheStorage$readCache$3.L$5 = gMTDate7;
                                            fileCacheStorage$readCache$3.L$6 = gMTDate6;
                                            fileCacheStorage$readCache$3.L$7 = map4;
                                            fileCacheStorage$readCache$3.L$8 = bArr;
                                            fileCacheStorage$readCache$3.label = 15;
                                            if (ByteReadChannelKt.readFully(byteReadChannel6, bArr, fileCacheStorage$readCache$3) != coroutine_suspended) {
                                                map5 = map4;
                                                bArr2 = bArr;
                                                str9 = str6;
                                                return new CachedResponseData(URLUtilsKt.Url(str9), httpStatusCode4, gMTDate2, gMTDate7, httpProtocolVersion3, gMTDate6, headersBuilder4.build(), map5, bArr2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return coroutine_suspended;
                    case 12:
                        int i8 = fileCacheStorage$readCache$3.I$1;
                        i4 = fileCacheStorage$readCache$3.I$0;
                        Map map8 = (Map) fileCacheStorage$readCache$3.L$9;
                        Map map9 = (Map) fileCacheStorage$readCache$3.L$8;
                        GMTDate gMTDate12 = (GMTDate) fileCacheStorage$readCache$3.L$7;
                        GMTDate gMTDate13 = (GMTDate) fileCacheStorage$readCache$3.L$6;
                        GMTDate gMTDate14 = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        HeadersBuilder headersBuilder11 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        HttpProtocolVersion httpProtocolVersion8 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        HttpStatusCode httpStatusCode10 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        String str18 = (String) fileCacheStorage$readCache$3.L$1;
                        ByteReadChannel byteReadChannel16 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        i6 = i8;
                        byteReadChannel7 = byteReadChannel16;
                        httpProtocolVersion4 = httpProtocolVersion8;
                        gMTDate3 = gMTDate13;
                        map2 = map8;
                        map3 = map9;
                        str7 = str18;
                        headersBuilder5 = headersBuilder11;
                        gMTDate4 = gMTDate12;
                        httpStatusCode5 = httpStatusCode10;
                        gMTDate5 = gMTDate14;
                        Intrinsics.checkNotNull(obj2);
                        String str162 = (String) obj2;
                        fileCacheStorage$readCache$3.L$0 = byteReadChannel7;
                        fileCacheStorage$readCache$3.L$1 = str7;
                        fileCacheStorage$readCache$3.L$2 = httpStatusCode5;
                        fileCacheStorage$readCache$3.L$3 = httpProtocolVersion4;
                        fileCacheStorage$readCache$3.L$4 = headersBuilder5;
                        fileCacheStorage$readCache$3.L$5 = gMTDate5;
                        fileCacheStorage$readCache$3.L$6 = gMTDate3;
                        fileCacheStorage$readCache$3.L$7 = gMTDate4;
                        fileCacheStorage$readCache$3.L$8 = map3;
                        fileCacheStorage$readCache$3.L$9 = map2;
                        fileCacheStorage$readCache$3.L$10 = str162;
                        fileCacheStorage$readCache$3.I$0 = i4;
                        fileCacheStorage$readCache$3.I$1 = i6;
                        fileCacheStorage$readCache$3.label = 13;
                        obj2 = ByteReadChannelKt.readUTF8Line(byteReadChannel7, fileCacheStorage$readCache$3);
                        if (obj2 != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 13:
                        int i9 = fileCacheStorage$readCache$3.I$1;
                        i4 = fileCacheStorage$readCache$3.I$0;
                        str8 = (String) fileCacheStorage$readCache$3.L$10;
                        map2 = (Map) fileCacheStorage$readCache$3.L$9;
                        map3 = (Map) fileCacheStorage$readCache$3.L$8;
                        gMTDate4 = (GMTDate) fileCacheStorage$readCache$3.L$7;
                        gMTDate3 = (GMTDate) fileCacheStorage$readCache$3.L$6;
                        gMTDate5 = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        headersBuilder5 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        httpProtocolVersion4 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        httpStatusCode5 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        str7 = (String) fileCacheStorage$readCache$3.L$1;
                        i5 = i9;
                        byteReadChannel7 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        HeadersBuilder headersBuilder102 = headersBuilder5;
                        ByteReadChannel byteReadChannel152 = byteReadChannel7;
                        Map map62 = map2;
                        httpProtocolVersion3 = httpProtocolVersion4;
                        Map map72 = map3;
                        httpStatusCode4 = httpStatusCode5;
                        headersBuilder4 = headersBuilder102;
                        GMTDate gMTDate102 = gMTDate5;
                        String str172 = str7;
                        gMTDate2 = gMTDate102;
                        Intrinsics.checkNotNull(obj2);
                        map62.put(str8, (String) obj2);
                        i6 = i5 + 1;
                        intValue3 = i4;
                        gMTDate = gMTDate3;
                        byteReadChannel6 = byteReadChannel152;
                        map = map62;
                        GMTDate2 = gMTDate4;
                        str6 = str172;
                        createMapBuilder = map72;
                        if (i6 < intValue3) {
                        }
                        return coroutine_suspended;
                    case 14:
                        map4 = (Map) fileCacheStorage$readCache$3.L$8;
                        gMTDate6 = (GMTDate) fileCacheStorage$readCache$3.L$7;
                        gMTDate7 = (GMTDate) fileCacheStorage$readCache$3.L$6;
                        gMTDate2 = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        headersBuilder4 = (HeadersBuilder) fileCacheStorage$readCache$3.L$4;
                        httpProtocolVersion3 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$3;
                        httpStatusCode4 = (HttpStatusCode) fileCacheStorage$readCache$3.L$2;
                        str6 = (String) fileCacheStorage$readCache$3.L$1;
                        byteReadChannel6 = (ByteReadChannel) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        bArr = new byte[((Number) obj2).intValue()];
                        fileCacheStorage$readCache$3.L$0 = str6;
                        fileCacheStorage$readCache$3.L$1 = httpStatusCode4;
                        fileCacheStorage$readCache$3.L$2 = httpProtocolVersion3;
                        fileCacheStorage$readCache$3.L$3 = headersBuilder4;
                        fileCacheStorage$readCache$3.L$4 = gMTDate2;
                        fileCacheStorage$readCache$3.L$5 = gMTDate7;
                        fileCacheStorage$readCache$3.L$6 = gMTDate6;
                        fileCacheStorage$readCache$3.L$7 = map4;
                        fileCacheStorage$readCache$3.L$8 = bArr;
                        fileCacheStorage$readCache$3.label = 15;
                        if (ByteReadChannelKt.readFully(byteReadChannel6, bArr, fileCacheStorage$readCache$3) != coroutine_suspended) {
                        }
                        return coroutine_suspended;
                    case 15:
                        byte[] bArr3 = (byte[]) fileCacheStorage$readCache$3.L$8;
                        Map map10 = (Map) fileCacheStorage$readCache$3.L$7;
                        gMTDate6 = (GMTDate) fileCacheStorage$readCache$3.L$6;
                        gMTDate7 = (GMTDate) fileCacheStorage$readCache$3.L$5;
                        gMTDate2 = (GMTDate) fileCacheStorage$readCache$3.L$4;
                        headersBuilder4 = (HeadersBuilder) fileCacheStorage$readCache$3.L$3;
                        httpProtocolVersion3 = (HttpProtocolVersion) fileCacheStorage$readCache$3.L$2;
                        httpStatusCode4 = (HttpStatusCode) fileCacheStorage$readCache$3.L$1;
                        str9 = (String) fileCacheStorage$readCache$3.L$0;
                        ResultKt.throwOnFailure(obj2);
                        bArr2 = bArr3;
                        map5 = map10;
                        return new CachedResponseData(URLUtilsKt.Url(str9), httpStatusCode4, gMTDate2, gMTDate7, httpProtocolVersion3, gMTDate6, headersBuilder4.build(), map5, bArr2);
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        fileCacheStorage$readCache$3 = new FileCacheStorage$readCache$3(this, continuation);
        Object obj22 = fileCacheStorage$readCache$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i62 = 0;
        switch (fileCacheStorage$readCache$3.label) {
        }
    }
}
