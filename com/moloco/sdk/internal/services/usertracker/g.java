package com.moloco.sdk.internal.services.usertracker;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* loaded from: classes6.dex */
public final class g implements f {
    public static final int d = 8;

    /* renamed from: a, reason: collision with root package name */
    public final e f5725a;
    public final com.moloco.sdk.internal.services.usertracker.b b;
    public final Mutex c;

    @DebugMetadata(c = "com.moloco.sdk.internal.services.usertracker.UserTrackerServiceImpl", f = "UserTrackerService.kt", i = {0, 0, 1}, l = {48, 29}, m = "clear", n = {"this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0"})
    public static final class a extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5726a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public a(Continuation<? super a> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return g.this.a(this);
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.usertracker.UserTrackerServiceImpl", f = "UserTrackerService.kt", i = {0, 0, 1, 1, 2, 2}, l = {48, 33, 36}, m = "getIdentifier", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "currentId"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    public static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        public Object f5727a;
        public Object b;
        public /* synthetic */ Object c;
        public int e;

        public b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return g.this.b(this);
        }
    }

    public g(e idGenerator, com.moloco.sdk.internal.services.usertracker.b idRepository) {
        Intrinsics.checkNotNullParameter(idGenerator, "idGenerator");
        Intrinsics.checkNotNullParameter(idRepository, "idRepository");
        this.f5725a = idGenerator;
        this.b = idRepository;
        this.c = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // com.moloco.sdk.internal.services.usertracker.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(Continuation<? super Unit> continuation) {
        a aVar;
        Object coroutine_suspended;
        int i;
        Mutex mutex;
        g gVar;
        com.moloco.sdk.internal.services.usertracker.b bVar;
        Mutex mutex2;
        try {
            if (continuation instanceof a) {
                aVar = (a) continuation;
                int i2 = aVar.e;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    aVar.e = i2 - Integer.MIN_VALUE;
                    Object obj = aVar.c;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = aVar.e;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.c;
                        aVar.f5726a = this;
                        aVar.b = mutex;
                        aVar.e = 1;
                        if (mutex.lock(null, aVar) != coroutine_suspended) {
                            gVar = this;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex2 = (Mutex) aVar.f5726a;
                        try {
                            ResultKt.throwOnFailure(obj);
                            Unit unit = Unit.INSTANCE;
                            mutex2.unlock(null);
                            return unit;
                        } catch (Throwable th) {
                            th = th;
                            mutex = mutex2;
                            mutex.unlock(null);
                            throw th;
                        }
                    }
                    mutex = (Mutex) aVar.b;
                    gVar = (g) aVar.f5726a;
                    ResultKt.throwOnFailure(obj);
                    bVar = gVar.b;
                    aVar.f5726a = mutex;
                    aVar.b = null;
                    aVar.e = 2;
                    if (bVar.a(aVar) != coroutine_suspended) {
                        mutex2 = mutex;
                        Unit unit2 = Unit.INSTANCE;
                        mutex2.unlock(null);
                        return unit2;
                    }
                    return coroutine_suspended;
                }
            }
            bVar = gVar.b;
            aVar.f5726a = mutex;
            aVar.b = null;
            aVar.e = 2;
            if (bVar.a(aVar) != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th2) {
            th = th2;
            mutex.unlock(null);
            throw th;
        }
        aVar = new a(continuation);
        Object obj2 = aVar.c;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = aVar.e;
        if (i != 0) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009b, code lost:
    
        if (r4.a(r9, r0) == r1) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0089 A[Catch: all -> 0x0050, TRY_LEAVE, TryCatch #0 {all -> 0x0050, blocks: (B:26:0x004c, B:27:0x0085, B:29:0x0089), top: B:25:0x004c }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    @Override // com.moloco.sdk.internal.services.usertracker.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object b(Continuation<? super String> continuation) {
        b bVar;
        Object coroutine_suspended;
        int i;
        Mutex mutex;
        g gVar;
        Mutex mutex2;
        Throwable th;
        Object b2;
        Mutex mutex3;
        g gVar2;
        String str;
        String str2;
        try {
            if (continuation instanceof b) {
                bVar = (b) continuation;
                int i2 = bVar.e;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    bVar.e = i2 - Integer.MIN_VALUE;
                    Object obj = bVar.c;
                    coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = bVar.e;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        mutex = this.c;
                        bVar.f5727a = this;
                        bVar.b = mutex;
                        bVar.e = 1;
                        if (mutex.lock(null, bVar) != coroutine_suspended) {
                            gVar = this;
                        }
                        return coroutine_suspended;
                    }
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            str2 = (String) bVar.b;
                            mutex2 = (Mutex) bVar.f5727a;
                            try {
                                ResultKt.throwOnFailure(obj);
                                mutex2.unlock(null);
                                return str2;
                            } catch (Throwable th2) {
                                th = th2;
                                mutex3 = mutex2;
                                mutex3.unlock(null);
                                throw th;
                            }
                        }
                        mutex3 = (Mutex) bVar.b;
                        gVar2 = (g) bVar.f5727a;
                        try {
                            ResultKt.throwOnFailure(obj);
                            str = (String) obj;
                            if (str == null) {
                                str = gVar2.f5725a.a();
                                com.moloco.sdk.internal.services.usertracker.b bVar2 = gVar2.b;
                                bVar.f5727a = mutex3;
                                bVar.b = str;
                                bVar.e = 3;
                            }
                            str2 = str;
                            mutex2 = mutex3;
                            mutex2.unlock(null);
                            return str2;
                        } catch (Throwable th3) {
                            th = th3;
                            mutex3.unlock(null);
                            throw th;
                        }
                    }
                    Mutex mutex4 = (Mutex) bVar.b;
                    gVar = (g) bVar.f5727a;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex4;
                    com.moloco.sdk.internal.services.usertracker.b bVar3 = gVar.b;
                    bVar.f5727a = gVar;
                    bVar.b = mutex;
                    bVar.e = 2;
                    b2 = bVar3.b(bVar);
                    if (b2 != coroutine_suspended) {
                        mutex3 = mutex;
                        obj = b2;
                        gVar2 = gVar;
                        str = (String) obj;
                        if (str == null) {
                        }
                        str2 = str;
                        mutex2 = mutex3;
                        mutex2.unlock(null);
                        return str2;
                    }
                    return coroutine_suspended;
                }
            }
            com.moloco.sdk.internal.services.usertracker.b bVar32 = gVar.b;
            bVar.f5727a = gVar;
            bVar.b = mutex;
            bVar.e = 2;
            b2 = bVar32.b(bVar);
            if (b2 != coroutine_suspended) {
            }
            return coroutine_suspended;
        } catch (Throwable th4) {
            mutex2 = mutex;
            th = th4;
            mutex3 = mutex2;
            mutex3.unlock(null);
            throw th;
        }
        bVar = new b(continuation);
        Object obj2 = bVar.c;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bVar.e;
        if (i != 0) {
        }
    }
}
