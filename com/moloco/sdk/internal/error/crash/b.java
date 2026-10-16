package com.moloco.sdk.internal.error.crash;

import com.moloco.sdk.internal.error.crash.b;
import java.lang.Thread;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* loaded from: classes6.dex */
public final class b implements com.moloco.sdk.internal.error.crash.a {
    public static final int c = 8;

    /* renamed from: a, reason: collision with root package name */
    public final c f5394a;
    public Thread.UncaughtExceptionHandler b;

    @DebugMetadata(c = "com.moloco.sdk.internal.error.crash.CrashDetectorServiceImpl$register$2", f = "CrashDetectorService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5395a;

        public a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return b.this.new a(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5395a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (b.this.b == null) {
                b.this.b = Thread.getDefaultUncaughtExceptionHandler();
                final b bVar = b.this;
                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.moloco.sdk.internal.error.crash.b$a$$ExternalSyntheticLambda0
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public final void uncaughtException(Thread thread, Throwable th) {
                        b.a.a(b.this, thread, th);
                    }
                });
            }
            return Unit.INSTANCE;
        }

        public static final void a(b bVar, Thread thread, Throwable th) {
            c cVar = bVar.f5394a;
            Intrinsics.checkNotNull(th);
            cVar.a(th);
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = bVar.b;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(thread, th);
            } else {
                System.exit(2);
                throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
            }
        }
    }

    public b(c crashHandler) {
        Intrinsics.checkNotNullParameter(crashHandler, "crashHandler");
        this.f5394a = crashHandler;
    }

    @Override // com.moloco.sdk.internal.error.crash.a
    public Object a(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(com.moloco.sdk.internal.scheduling.b.a().getMain(), new a(null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
