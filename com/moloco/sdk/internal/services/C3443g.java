package com.moloco.sdk.internal.services;

import androidx.lifecycle.Lifecycle;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* renamed from: com.moloco.sdk.internal.services.g, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3443g implements InterfaceC3442f {
    public static final a e = new a(null);
    public static final int f = 8;
    public static final String g = "AnalyticsApplicationLifecycleTrackerImpl";

    /* renamed from: a, reason: collision with root package name */
    public final Lifecycle f5684a;
    public final SingleObserverBackgroundThenForegroundAnalyticsListener b;
    public final CoroutineScope c;
    public boolean d;

    /* renamed from: com.moloco.sdk.internal.services.g$a */
    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public a() {
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.AnalyticsApplicationLifecycleTrackerImpl$startObserving$1", f = "AnalyticsApplicationLifecycleTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.internal.services.g$b */
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5685a;

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
            return C3443g.this.new b(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5685a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            C3443g.this.c();
            return Unit.INSTANCE;
        }
    }

    @DebugMetadata(c = "com.moloco.sdk.internal.services.AnalyticsApplicationLifecycleTrackerImpl$trackNextBackgroundForeground$1", f = "AnalyticsApplicationLifecycleTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.moloco.sdk.internal.services.g$c */
    public static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: a, reason: collision with root package name */
        public int f5686a;

        public c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return C3443g.this.new c(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f5686a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            MolocoLogger.debug$default(MolocoLogger.INSTANCE, C3443g.g, "Tracking next bg / fg of the application", false, 4, null);
            C3443g.this.c();
            C3443g.this.b.a();
            return Unit.INSTANCE;
        }
    }

    public C3443g(Lifecycle lifecycle, SingleObserverBackgroundThenForegroundAnalyticsListener fgBgListener) {
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(fgBgListener, "fgBgListener");
        this.f5684a = lifecycle;
        this.b = fgBgListener;
        this.c = CoroutineScopeKt.CoroutineScope(com.moloco.sdk.internal.scheduling.b.a().getMainImmediate());
    }

    public final void c() {
        if (this.d) {
            return;
        }
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, g, "Observing application lifecycle events", false, 4, null);
        this.f5684a.addObserver(this.b);
        this.d = true;
    }

    @Override // com.moloco.sdk.internal.services.InterfaceC3442f
    public void a() {
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, g, "Start observing application lifecycle events", false, 4, null);
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new b(null), 3, null);
    }

    @Override // com.moloco.sdk.internal.services.InterfaceC3442f
    public void b() {
        BuildersKt__Builders_commonKt.launch$default(this.c, null, null, new c(null), 3, null);
    }
}
