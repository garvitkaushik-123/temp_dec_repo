package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.v;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c;
import java.io.File;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes6.dex */
public final class j implements i {
    public static final a k = new a(null);
    public static final int l = 8;
    public static final String m = "MediaCacheRepository";
    public static final String n = "TEMP";

    /* renamed from: a, reason: collision with root package name */
    public final l f5863a;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d b;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a c;
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f d;
    public final CoroutineScope e;
    public final ConcurrentHashMap<String, Mutex> f;
    public final HashSet<String> g;
    public final ConcurrentHashMap<String, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b> h;
    public final CoroutineScope i;
    public Job j;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }

        public final String a(String str) {
            return str + j.n;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$getMediaFile$2", f = "MediaCacheRepository.kt", i = {0, 1, 1, 1}, l = {373, 161}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "dstFile", "tmpFile"}, s = {"L$0", "L$0", "L$2", "L$3"})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super i.a>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5864a;
        public Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ j g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, j jVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f = str;
            this.g = jVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super i.a> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.f, this.g, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:12:0x01a2 A[Catch: all -> 0x0034, Exception -> 0x0037, TryCatch #1 {all -> 0x0034, blocks: (B:8:0x002b, B:10:0x019c, B:12:0x01a2, B:14:0x01b9, B:18:0x01df, B:26:0x01f9), top: B:2:0x0015 }] */
        /* JADX WARN: Removed duplicated region for block: B:21:0x01e8  */
        /* JADX WARN: Type inference failed for: r11v0 */
        /* JADX WARN: Type inference failed for: r11v1, types: [kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.Object, kotlinx.coroutines.sync.Mutex] */
        /* JADX WARN: Type inference failed for: r11v8 */
        /* JADX WARN: Type inference failed for: r11v9 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            ?? r11;
            j jVar;
            String str;
            Object putIfAbsent;
            Mutex mutex;
            File file;
            File file2;
            Object a2;
            Object obj2;
            i.a aVar;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            try {
            } catch (Throwable th) {
                th = th;
                r11 = coroutine_suspended;
            }
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.f.length() == 0) {
                        return i.a.AbstractC0479a.k.c;
                    }
                    ConcurrentHashMap concurrentHashMap = this.g.f;
                    String str2 = this.f;
                    Object obj3 = concurrentHashMap.get(str2);
                    if (obj3 == null && (putIfAbsent = concurrentHashMap.putIfAbsent(str2, (obj3 = MutexKt.Mutex$default(false, 1, null)))) != null) {
                        obj3 = putIfAbsent;
                    }
                    Mutex mutex2 = (Mutex) obj3;
                    Intrinsics.checkNotNull(mutex2);
                    j jVar2 = this.g;
                    String str3 = this.f;
                    this.f5864a = mutex2;
                    this.b = jVar2;
                    this.c = str3;
                    this.e = 1;
                    if (mutex2.lock(null, this) != coroutine_suspended) {
                        jVar = jVar2;
                        str = str3;
                        r11 = mutex2;
                    }
                    return coroutine_suspended;
                }
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    File file3 = (File) this.d;
                    File file4 = (File) this.c;
                    String str4 = (String) this.b;
                    mutex = (Mutex) this.f5864a;
                    try {
                        ResultKt.throwOnFailure(obj);
                        file = file4;
                        file2 = file3;
                        a2 = obj;
                        aVar = (i.a) a2;
                        if (aVar instanceof i.a.b) {
                            mutex.unlock(null);
                            return aVar;
                        }
                        MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                        MolocoLogger.debug$default(molocoLogger, j.m, "Renaming tmp file to dst file", false, 4, null);
                        if (file2.renameTo(file)) {
                            i.a.b bVar = new i.a.b(file);
                            mutex.unlock(null);
                            return bVar;
                        }
                        MolocoLogger.info$default(molocoLogger, j.m, "Renaming to dst file failed, dstFile exists: " + file.exists(), null, false, 12, null);
                        i.a.AbstractC0479a.p pVar = i.a.AbstractC0479a.p.c;
                        mutex.unlock(null);
                        return pVar;
                    } catch (Exception e) {
                        e = e;
                        str = str4;
                        Exception exc = e;
                        MolocoLogger.error$default(MolocoLogger.INSTANCE, j.m, "Failed to fetch media from url: " + str, exc, false, 8, null);
                        i.a.AbstractC0479a a3 = o.a(exc);
                        mutex.unlock(null);
                        return a3;
                    }
                }
                str = (String) this.c;
                jVar = (j) this.b;
                Mutex mutex3 = (Mutex) this.f5864a;
                ResultKt.throwOnFailure(obj);
                r11 = mutex3;
                v<File, com.moloco.sdk.internal.m> d = jVar.d();
                if (d instanceof v.a) {
                    MolocoLogger.warn$default(MolocoLogger.INSTANCE, j.m, "Failed to retrieve storageDir with error code: " + ((com.moloco.sdk.internal.m) ((v.a) d).a()).b(), null, false, 12, null);
                    switch (((com.moloco.sdk.internal.m) ((v.a) d).a()).b()) {
                        case 100:
                            obj2 = i.a.AbstractC0479a.c.c;
                            break;
                        case 101:
                            obj2 = i.a.AbstractC0479a.b.c;
                            break;
                        case 102:
                            obj2 = i.a.AbstractC0479a.C0480a.c;
                            break;
                        default:
                            obj2 = i.a.AbstractC0479a.d.c;
                            break;
                    }
                    r11.unlock(null);
                    return obj2;
                }
                if (!(d instanceof v.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                File file5 = (File) ((v.b) d).a();
                String b = C.b(str);
                file = new File(file5, b);
                if (file.exists()) {
                    if (!jVar.c.a(file)) {
                        MolocoLogger.info$default(MolocoLogger.INSTANCE, j.m, "Found asset in cache: " + str, null, false, 12, null);
                        i.a.b bVar2 = new i.a.b(file);
                        r11.unlock(null);
                        return bVar2;
                    }
                    MolocoLogger.info$default(MolocoLogger.INSTANCE, j.m, "Media file was partially downloaded by ChunkedMediaDownloader. Deleting the file and redownloading", null, false, 12, null);
                    file.delete();
                }
                file2 = new File(file5, j.k.a(b));
                MolocoLogger.debug$default(MolocoLogger.INSTANCE, j.m, "Asset not found in cache. Downloading to tmp file[already exists == " + file2.exists() + AbstractJsonLexerKt.END_LIST, false, 4, null);
                if (file2.exists()) {
                    file2.delete();
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d dVar = jVar.b;
                this.f5864a = r11;
                this.b = str;
                this.c = file;
                this.d = file2;
                this.e = 2;
                a2 = dVar.a(str, file2, this);
                if (a2 != coroutine_suspended) {
                    mutex = r11;
                    aVar = (i.a) a2;
                    if (aVar instanceof i.a.b) {
                    }
                }
                return coroutine_suspended;
            } catch (Exception e2) {
                e = e2;
                mutex = r11;
                Exception exc2 = e;
                MolocoLogger.error$default(MolocoLogger.INSTANCE, j.m, "Failed to fetch media from url: " + str, exc2, false, 8, null);
                i.a.AbstractC0479a a32 = o.a(exc2);
                mutex.unlock(null);
                return a32;
            } catch (Throwable th2) {
                th = th2;
                r11.unlock(null);
                throw th;
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFile$2", f = "MediaCacheRepository.kt", i = {0}, l = {373}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5865a;
        public Object b;
        public Object c;
        public Object d;
        public int e;
        public final /* synthetic */ String f;
        public final /* synthetic */ j g;
        public final /* synthetic */ String h;

        @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFile$2$1$1", f = "MediaCacheRepository.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
        public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

            /* renamed from: a, reason: collision with root package name */
            public int f5866a;
            public final /* synthetic */ j b;
            public final /* synthetic */ String c;
            public final /* synthetic */ File d;
            public final /* synthetic */ String e;
            public final /* synthetic */ com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(j jVar, String str, File file, String str2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.b = jVar;
                this.c = str;
                this.d = file;
                this.e = str2;
                this.f = bVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new a(this.b, this.c, this.d, this.e, this.f, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                a aVar;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f5866a;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a aVar2 = this.b.c;
                    String str = this.c;
                    File file = this.d;
                    String str2 = this.e;
                    com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = this.f;
                    this.f5866a = 1;
                    aVar = this;
                    if (aVar2.a(str, file, str2, bVar, aVar) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    aVar = this;
                }
                aVar.b.g.remove(aVar.c);
                aVar.b.h.remove(aVar.c);
                return Unit.INSTANCE;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str, j jVar, String str2, Continuation<? super c> continuation) {
            super(2, continuation);
            this.f = str;
            this.g = jVar;
            this.h = str2;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new c(this.f, this.g, this.h, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            j jVar;
            String str;
            String str2;
            Object putIfAbsent;
            Object putIfAbsent2;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c c0482c;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.e;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                MolocoLogger.info$default(MolocoLogger.INSTANCE, j.m, "Streaming media for: " + this.f, null, false, 12, null);
                if (this.f.length() == 0) {
                    return new c.b(i.a.AbstractC0479a.k.c);
                }
                ConcurrentHashMap concurrentHashMap = this.g.f;
                String str3 = this.f;
                Object obj2 = concurrentHashMap.get(str3);
                if (obj2 == null && (putIfAbsent = concurrentHashMap.putIfAbsent(str3, (obj2 = MutexKt.Mutex$default(false, 1, null)))) != null) {
                    obj2 = putIfAbsent;
                }
                mutex = (Mutex) obj2;
                Intrinsics.checkNotNull(mutex);
                j jVar2 = this.g;
                String str4 = this.f;
                String str5 = this.h;
                this.f5865a = mutex;
                this.b = jVar2;
                this.c = str4;
                this.d = str5;
                this.e = 1;
                if (mutex.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                jVar = jVar2;
                str = str4;
                str2 = str5;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                String str6 = (String) this.d;
                String str7 = (String) this.c;
                j jVar3 = (j) this.b;
                mutex = (Mutex) this.f5865a;
                ResultKt.throwOnFailure(obj);
                str2 = str6;
                str = str7;
                jVar = jVar3;
            }
            try {
                v c = jVar.c();
                if (c instanceof v.a) {
                    return ((v.a) c).a();
                }
                if (!(c instanceof v.b)) {
                    throw new NoWhenBranchMatchedException();
                }
                File a2 = jVar.a(str, (File) ((v.b) c).a());
                MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
                MolocoLogger.info$default(molocoLogger, j.m, "Going to download the media file to location: " + a2.getAbsolutePath(), null, false, 12, null);
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b) jVar.h.get(str);
                if (jVar.g.contains(str)) {
                    MolocoLogger.info$default(molocoLogger, j.m, "Media file is already being downloaded, so returning in progress status for url: " + str, null, false, 12, null);
                    if (bVar == null || (c0482c = bVar.a()) == null) {
                        c0482c = new c.C0482c(a2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a());
                    }
                    return c0482c;
                }
                if (jVar.c.b(a2)) {
                    return new c.a(a2);
                }
                MolocoLogger.info$default(molocoLogger, j.m, "Media file needs to be downloaded: " + str, null, false, 12, null);
                jVar.g.add(str);
                ConcurrentHashMap concurrentHashMap2 = jVar.h;
                Object obj3 = concurrentHashMap2.get(str);
                if (obj3 == null && (putIfAbsent2 = concurrentHashMap2.putIfAbsent(str, (obj3 = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b(new c.C0482c(a2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a()))))) != null) {
                    obj3 = putIfAbsent2;
                }
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar2 = (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b) obj3;
                BuildersKt__Builders_commonKt.launch$default(jVar.e, null, null, new a(jVar, str, a2, str2, bVar2, null), 3, null);
                return bVar2.a();
            } finally {
                mutex.unlock(null);
            }
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFileStatus$1", f = "MediaCacheRepository.kt", i = {}, l = {249}, m = "invokeSuspend", n = {}, s = {})
    public static final class d extends SuspendLambda implements Function2<FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5867a;
        public /* synthetic */ Object b;
        public final /* synthetic */ File c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(File file, Continuation<? super d> continuation) {
            super(2, continuation);
            this.c = file;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> flowCollector, Continuation<? super Unit> continuation) {
            return ((d) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            d dVar = new d(this.c, continuation);
            dVar.b = obj;
            return dVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f5867a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                FlowCollector flowCollector = (FlowCollector) this.b;
                c.a aVar = new c.a(this.c);
                this.f5867a = 1;
                if (flowCollector.emit(aVar, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$streamMediaFileStatus$cacheDir$1", f = "MediaCacheRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class e extends SuspendLambda implements Function2<FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c>, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5868a;
        public final /* synthetic */ v<File, c.b> b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(v<File, c.b> vVar, Continuation<? super e> continuation) {
            super(2, continuation);
            this.b = vVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> flowCollector, Continuation<? super Unit> continuation) {
            return ((e) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new e(this.b, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5868a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ((v.a) this.b).a();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.MediaCacheRepositoryImpl$tryCleanup$newCleanUpJob$1", f = "MediaCacheRepository.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class f extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5869a;

        public f(Continuation<? super f> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return j.this.new f(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5869a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            v<File, com.moloco.sdk.internal.m> a2 = j.this.d.a();
            if (a2 instanceof v.b) {
                j.this.a((File) ((v.b) a2).a());
            } else {
                if (!(a2 instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                MolocoLogger.error$default(MolocoLogger.INSTANCE, j.m, "Failed to cleanup external cache directory", null, false, 12, null);
            }
            v<File, com.moloco.sdk.internal.m> b = j.this.d.b();
            if (b instanceof v.b) {
                j.this.a((File) ((v.b) b).a());
            } else {
                if (!(b instanceof v.a)) {
                    throw new NoWhenBranchMatchedException();
                }
                MolocoLogger.error$default(MolocoLogger.INSTANCE, j.m, "Failed to cleanup internal cache directory", null, false, 12, null);
            }
            return Unit.INSTANCE;
        }
    }

    public j(l mediaConfig, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.d legacyMediaDownloader, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.a chunkedMediaDownloader, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f mediaCacheLocationProvider) {
        Intrinsics.checkNotNullParameter(mediaConfig, "mediaConfig");
        Intrinsics.checkNotNullParameter(legacyMediaDownloader, "legacyMediaDownloader");
        Intrinsics.checkNotNullParameter(chunkedMediaDownloader, "chunkedMediaDownloader");
        Intrinsics.checkNotNullParameter(mediaCacheLocationProvider, "mediaCacheLocationProvider");
        this.f5863a = mediaConfig;
        this.b = legacyMediaDownloader;
        this.c = chunkedMediaDownloader;
        this.d = mediaCacheLocationProvider;
        this.e = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getIo());
        this.f = new ConcurrentHashMap<>();
        this.g = new HashSet<>();
        this.h = new ConcurrentHashMap<>();
        this.i = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getIo());
    }

    public final v<File, c.b> c() {
        v<File, com.moloco.sdk.internal.m> d2 = d();
        if (!(d2 instanceof v.a)) {
            if (d2 instanceof v.b) {
                return new v.b(((v.b) d2).a());
            }
            throw new NoWhenBranchMatchedException();
        }
        v.a aVar = (v.a) d2;
        MolocoLogger.warn$default(MolocoLogger.INSTANCE, m, "Failed to retrieve storageDir with error code: " + ((com.moloco.sdk.internal.m) aVar.a()).b(), null, false, 12, null);
        switch (((com.moloco.sdk.internal.m) aVar.a()).b()) {
            case 100:
                return new v.a(new c.b(i.a.AbstractC0479a.c.c));
            case 101:
                return new v.a(new c.b(i.a.AbstractC0479a.b.c));
            case 102:
                return new v.a(new c.b(i.a.AbstractC0479a.C0480a.c));
            default:
                return new v.a(new c.b(i.a.AbstractC0479a.d.c));
        }
    }

    public final v<File, com.moloco.sdk.internal.m> d() {
        v<File, com.moloco.sdk.internal.m> a2 = this.d.a();
        if (a2 instanceof v.a) {
            return this.d.b();
        }
        if (a2 instanceof v.b) {
            return a2;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public Flow<com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> b(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        v<File, c.b> c2 = c();
        if (c2 instanceof v.a) {
            return FlowKt.flow(new e(c2, null));
        }
        if (c2 instanceof v.b) {
            File file = (File) ((v.b) c2).a();
            MolocoLogger molocoLogger = MolocoLogger.INSTANCE;
            String str = m;
            MolocoLogger.info$default(molocoLogger, str, "Collecting status for media file: " + url, null, false, 12, null);
            File a2 = a(url, file);
            if (a2.exists() && this.c.b(a2)) {
                return FlowKt.flow(new d(a2, null));
            }
            MolocoLogger.info$default(molocoLogger, str, "Media file needs to be downloaded: " + url, null, false, 12, null);
            ConcurrentHashMap<String, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b> concurrentHashMap = this.h;
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = concurrentHashMap.get(url);
            if (bVar == null) {
                MolocoLogger.info$default(molocoLogger, str, "Download has not yet started for: " + url, null, false, 12, null);
                bVar = new com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b(new c.C0482c(a2, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a()));
                com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b putIfAbsent = concurrentHashMap.putIfAbsent(url, bVar);
                if (putIfAbsent != null) {
                    bVar = putIfAbsent;
                }
            }
            return bVar.b();
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public Object a(String str, Continuation<? super i.a> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new b(str, this, null), continuation);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public Object a(String str, String str2, Continuation<? super com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c> continuation) {
        return BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getIo(), new c(str, this, str2, null), continuation);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c a(String url) {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c a2;
        Intrinsics.checkNotNullParameter(url, "url");
        v<File, c.b> c2 = c();
        if (c2 instanceof v.a) {
            return (com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.c) ((v.a) c2).a();
        }
        if (c2 instanceof v.b) {
            File a3 = a(url, (File) ((v.b) c2).a());
            if (a3.exists() && this.c.b(a3)) {
                return new c.a(a3);
            }
            com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.b bVar = this.h.get(url);
            return (bVar == null || (a2 = bVar.a()) == null) ? new c.C0482c(a3, com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.stream.d.a()) : a2;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final File a(String str, File file) {
        return new File(file, C.b(str));
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.i
    public Job a() {
        Job launch$default;
        Job job = this.j;
        if (job != null && job.isActive()) {
            return job;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.i, null, null, new f(null), 3, null);
        this.j = launch$default;
        return launch$default;
    }

    public final void a(File file) {
        try {
            if (SequencesKt.sumOfLong(SequencesKt.map(FilesKt.walkTopDown(file), new Function1() { // from class: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.j$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Long.valueOf(j.b((File) obj));
                }
            })) < this.f5863a.f()) {
                return;
            }
            try {
                FilesKt.deleteRecursively(file);
            } catch (Exception e2) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, m, e2.toString(), e2, false, 8, null);
            }
        } catch (Exception e3) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, m, e3.toString(), e3, false, 8, null);
        }
    }

    public static final long b(File it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.length();
    }
}
