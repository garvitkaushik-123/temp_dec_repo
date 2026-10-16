package io.ktor.client.plugins.cache.storage;

import io.ktor.client.plugins.cache.HttpCacheKt;
import io.ktor.util.collections.ConcurrentMap;
import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.ByteChannelKt;
import io.ktor.utils.io.jvm.javaio.WritingKt;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: FileCacheStorage.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2", f = "FileCacheStorage.kt", i = {0, 0, 1, 1, 1}, l = {202, 102}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$use$iv", "closed$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "I$0"})
/* loaded from: classes8.dex */
final class FileCacheStorage$writeCache$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ List<CachedResponseData> $caches;
    final /* synthetic */ String $urlHex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ FileCacheStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FileCacheStorage$writeCache$2(FileCacheStorage fileCacheStorage, String str, List<CachedResponseData> list, Continuation<? super FileCacheStorage$writeCache$2> continuation) {
        super(2, continuation);
        this.this$0 = fileCacheStorage;
        this.$urlHex = str;
        this.$caches = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FileCacheStorage$writeCache$2 fileCacheStorage$writeCache$2 = new FileCacheStorage$writeCache$2(this.this$0, this.$urlHex, this.$caches, continuation);
        fileCacheStorage$writeCache$2.L$0 = obj;
        return fileCacheStorage$writeCache$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, (Continuation<Object>) continuation);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((FileCacheStorage$writeCache$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|1|(1:2)|(1:(1:(8:6|7|8|9|10|11|12|13)(2:28|29))(1:30))(3:62|(1:64)|45)|31|32|33|34|35|(1:37)(1:54)|38|39|40|41|42|43|(5:46|10|11|12|13)|45|(2:(1:25)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0107, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0129, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Mutex mutex;
        Object obj2;
        Mutex mutex2;
        ConcurrentMap concurrentMap;
        FileCacheStorage fileCacheStorage;
        String str;
        CoroutineScope coroutineScope;
        List<CachedResponseData> list;
        ByteChannel ByteChannel$default;
        File file;
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2;
        Throwable th;
        ByteChannel byteChannel;
        BufferedOutputStream bufferedOutputStream3;
        Object copyTo$default;
        Mutex mutex3;
        ?? r1;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        ?? r2 = 1;
        r2 = 1;
        try {
            try {
                try {
                } catch (Exception e) {
                    e = e;
                    mutex = r2;
                    HttpCacheKt.getLOGGER().trace("Exception during saving a cache to a file: " + ExceptionsKt.stackTraceToString(e));
                    obj2 = Unit.INSTANCE;
                    mutex2 = mutex;
                    mutex2.unlock(null);
                    return obj2;
                } catch (Throwable th2) {
                    th = th2;
                    mutex = r2;
                    mutex.unlock(null);
                    throw th;
                }
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
                    concurrentMap = this.this$0.mutexes;
                    Mutex mutex4 = (Mutex) concurrentMap.computeIfAbsent((ConcurrentMap) this.$urlHex, (Function0) new Function0<Mutex>() { // from class: io.ktor.client.plugins.cache.storage.FileCacheStorage$writeCache$2$mutex$1
                        @Override // kotlin.jvm.functions.Function0
                        public final Mutex invoke() {
                            return MutexKt.Mutex$default(false, 1, null);
                        }
                    });
                    fileCacheStorage = this.this$0;
                    str = this.$urlHex;
                    List<CachedResponseData> list2 = this.$caches;
                    this.L$0 = coroutineScope2;
                    this.L$1 = mutex4;
                    this.L$2 = fileCacheStorage;
                    this.L$3 = str;
                    this.L$4 = list2;
                    this.label = 1;
                    if (mutex4.lock(null, this) != coroutine_suspended) {
                        coroutineScope = coroutineScope2;
                        mutex = mutex4;
                        list = list2;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    r1 = (Closeable) this.L$1;
                    mutex3 = (Mutex) this.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        copyTo$default = obj;
                        r1 = r1;
                        mutex3 = mutex3;
                        obj2 = Boxing.boxLong(((Number) copyTo$default).longValue());
                        r1.close();
                        mutex2 = mutex3;
                        mutex2.unlock(null);
                        return obj2;
                    } catch (Throwable th3) {
                        bufferedOutputStream2 = r1;
                        th = th3;
                        r2 = mutex3;
                        try {
                            bufferedOutputStream2.close();
                            throw th;
                        } finally {
                            throw th;
                        }
                    }
                }
                list = (List) this.L$4;
                str = (String) this.L$3;
                fileCacheStorage = (FileCacheStorage) this.L$2;
                Mutex mutex5 = (Mutex) this.L$1;
                CoroutineScope coroutineScope3 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope = coroutineScope3;
                mutex = mutex5;
                copyTo$default = WritingKt.copyTo$default(byteChannel, bufferedOutputStream3, 0L, this, 2, null);
                if (copyTo$default != coroutine_suspended) {
                    mutex3 = mutex;
                    r1 = bufferedOutputStream2;
                    obj2 = Boxing.boxLong(((Number) copyTo$default).longValue());
                    r1.close();
                    mutex2 = mutex3;
                    mutex2.unlock(null);
                    return obj2;
                }
                return coroutine_suspended;
            } catch (Throwable th4) {
                th = th4;
                th = th;
                r2 = mutex;
                bufferedOutputStream2.close();
                throw th;
            }
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new FileCacheStorage$writeCache$2$1$1$1(ByteChannel$default, list, fileCacheStorage, null), 3, null);
            byteChannel = ByteChannel$default;
            bufferedOutputStream3 = bufferedOutputStream;
            this.L$0 = mutex;
            this.L$1 = bufferedOutputStream;
            this.L$2 = null;
            this.L$3 = null;
            this.L$4 = null;
            this.I$0 = 0;
            this.label = 2;
            bufferedOutputStream2 = bufferedOutputStream;
        } catch (Throwable th5) {
            th = th5;
            bufferedOutputStream2 = bufferedOutputStream;
        }
        ByteChannel$default = ByteChannelKt.ByteChannel$default(false, 1, null);
        file = fileCacheStorage.directory;
        OutputStream fileOutputStream = new FileOutputStream(new File(file, str));
        bufferedOutputStream = fileOutputStream instanceof BufferedOutputStream ? (BufferedOutputStream) fileOutputStream : new BufferedOutputStream(fileOutputStream, 8192);
    }
}
