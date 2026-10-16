package com.moloco.sdk.internal.utils;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.sync.Mutex;

/* loaded from: classes6.dex */
public final class a {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @DebugMetadata(c = "com.moloco.sdk.internal.utils.CoroutineUtilsKt$withReentrantLock$2", f = "CoroutineUtils.kt", i = {0, 1}, l = {54, 37}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
    /* renamed from: com.moloco.sdk.internal.utils.a$a, reason: collision with other inner class name */
    public static final class C0462a<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public Object f5741a;
        public Object b;
        public int c;
        public final /* synthetic */ Mutex d;
        public final /* synthetic */ Function1<Continuation<? super T>, Object> e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C0462a(Mutex mutex, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super C0462a> continuation) {
            super(2, continuation);
            this.d = mutex;
            this.e = function1;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((C0462a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C0462a(this.d, this.e, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
        
            if (r7.lock(null, r6) == r0) goto L19;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Mutex mutex;
            Function1<Continuation<? super T>, Object> function1;
            Mutex mutex2;
            Throwable th;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.c;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    mutex = this.d;
                    function1 = this.e;
                    this.f5741a = mutex;
                    this.b = function1;
                    this.c = 1;
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        mutex2 = (Mutex) this.f5741a;
                        try {
                            ResultKt.throwOnFailure(obj);
                            mutex2.unlock(null);
                            return obj;
                        } catch (Throwable th2) {
                            th = th2;
                            mutex2.unlock(null);
                            throw th;
                        }
                    }
                    function1 = (Function1) this.b;
                    Mutex mutex3 = (Mutex) this.f5741a;
                    ResultKt.throwOnFailure(obj);
                    mutex = mutex3;
                }
                this.f5741a = mutex;
                this.b = null;
                this.c = 2;
                Object invoke = function1.invoke(this);
                if (invoke != coroutine_suspended) {
                    mutex2 = mutex;
                    obj = invoke;
                    mutex2.unlock(null);
                    return obj;
                }
                return coroutine_suspended;
            } catch (Throwable th3) {
                mutex2 = mutex;
                th = th3;
                mutex2.unlock(null);
                throw th;
            }
        }
    }

    public static /* synthetic */ void a(CoroutineScope coroutineScope, CoroutineContext context, CoroutineStart start, Function2 block, int i, Object obj) {
        if ((i & 1) != 0) {
            context = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            start = CoroutineStart.DEFAULT;
        }
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        BuildersKt.launch(coroutineScope, context, start, block);
    }

    public static final void a(CoroutineScope coroutineScope, CoroutineContext context, CoroutineStart start, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(start, "start");
        Intrinsics.checkNotNullParameter(block, "block");
        BuildersKt.launch(coroutineScope, context, start, block);
    }

    public static final <T> Object a(Mutex mutex, Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        d dVar = new d(mutex);
        return continuation.getContext().get(dVar) != null ? function1.invoke(continuation) : BuildersKt.withContext(new c(dVar), new C0462a(mutex, function1, null), continuation);
    }
}
