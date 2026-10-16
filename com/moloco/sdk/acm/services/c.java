package com.moloco.sdk.acm.services;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* loaded from: classes6.dex */
public final class c implements com.moloco.sdk.acm.services.b {
    public static final a d = new a(null);
    public static final String e = "ApplicationLifecycleTrackerServiceImpl";

    /* renamed from: a, reason: collision with root package name */
    public final Lifecycle f5356a;
    public final ApplicationLifecycleObserver b;
    public AtomicBoolean c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.acm.services.ApplicationLifecycleTrackerImpl$startObserving$2", f = "ApplicationLifecycleTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5357a;

        public b(Continuation<? super b> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return c.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5357a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (c.this.c.compareAndSet(false, true)) {
                e.a(e.f5359a, c.e, "Start observing application lifecycle events", false, 4, null);
                c.this.f5356a.addObserver(c.this.b);
            }
            return Unit.INSTANCE;
        }
    }

    public c(Lifecycle lifecycle, ApplicationLifecycleObserver bgListener) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(bgListener, "bgListener");
        this.f5356a = lifecycle;
        this.b = bgListener;
        this.c = new AtomicBoolean(false);
    }

    @Override // com.moloco.sdk.acm.services.b
    public Object a(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new b(null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public final void a() {
        this.b.onStop(ProcessLifecycleOwner.INSTANCE.get());
    }
}
