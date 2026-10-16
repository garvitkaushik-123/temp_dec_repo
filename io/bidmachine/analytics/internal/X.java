package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.Struct;
import io.bidmachine.analytics.MonitorConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes7.dex */
public final class X {
    public static final a g = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final b f6676a;
    private final V b;
    private final String c;
    private final CoroutineScope d;
    private Job e;
    private final AtomicBoolean f = new AtomicBoolean(false);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final MonitorConfig f6677a;
        private final String b;
        private final Struct c;

        public b(MonitorConfig monitorConfig, String str, Struct struct) {
            this.f6677a = monitorConfig;
            this.b = str;
            this.c = struct;
        }

        public final Struct a() {
            return this.c;
        }

        public final MonitorConfig b() {
            return this.f6677a;
        }

        public final String c() {
            return this.b;
        }
    }

    static final class c extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        int f6678a;
        final /* synthetic */ List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(List list, Continuation continuation) {
            super(2, continuation);
            this.c = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return X.this.new c(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6678a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                X x = X.this;
                List list = this.c;
                this.f6678a = 1;
                if (x.a(list, this) == coroutine_suspended) {
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

    static final class d extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        int f6679a;

        d(Continuation continuation) {
            super(2, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return X.this.new d(continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0046, code lost:
        
            if (r7.a(0, r6) == r0) goto L15;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0048, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x003a, code lost:
        
            if (kotlinx.coroutines.DelayKt.delay(r4, r6) == r0) goto L15;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6679a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long interval = X.this.f6676a.b().getInterval();
                this.f6679a = 1;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    ((Result) obj).getValue();
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            X x = X.this;
            this.f6679a = 2;
        }
    }

    static final class e extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f6680a;
        Object b;
        /* synthetic */ Object c;
        int e;

        e(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return X.this.a((List) null, this);
        }
    }

    static final class f extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        int f6681a;
        final /* synthetic */ List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(List list, Continuation continuation) {
            super(2, continuation);
            this.c = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((f) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return X.this.new f(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object a2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6681a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                P p = new P(X.this.f6676a.b().getUrl(), X.this.f6676a.b().getName(), X.this.f6676a.a(), this.c, null, 16, null);
                this.f6681a = 1;
                a2 = p.a(this);
                if (a2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                a2 = ((Result) obj).getValue();
            }
            X x = X.this;
            List list = this.c;
            if (Result.m10248isSuccessimpl(a2)) {
                x.b.b(list);
            }
            X x2 = X.this;
            List list2 = this.c;
            if (Result.m10244exceptionOrNullimpl(a2) != null) {
                x2.b.c(list2);
            }
            return Result.m10240boximpl(a2);
        }
    }

    static final class g extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f6682a;
        Object b;
        /* synthetic */ Object c;
        int e;

        g(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            Object a2 = X.this.a(0, this);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Result.m10240boximpl(a2);
        }
    }

    static final class h extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        int f6683a;
        final /* synthetic */ Q c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(Q q, Continuation continuation) {
            super(2, continuation);
            this.c = q;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((h) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return X.this.new h(this.c, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
        
            if (r5.a(r1, r4) == r0) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
        
            if (r5.a(r1, r4) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6683a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (Result.m10248isSuccessimpl(X.this.a(this.c))) {
                    X x = X.this;
                    int batchSize = x.f6676a.b().getBatchSize();
                    this.f6683a = 1;
                } else {
                    X x2 = X.this;
                    List listOf = CollectionsKt.listOf(this.c);
                    this.f6683a = 2;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public X(p0 p0Var, b bVar, V v) {
        this.f6676a = bVar;
        this.b = v;
        this.c = bVar.b().getName();
        this.d = CoroutineScopeKt.CoroutineScope(new CoroutineName("AnalyticsMonitor: " + bVar.b().getName()).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(p0Var.c()));
    }

    public final String b() {
        return this.c;
    }

    public final void b(Q q) {
        if (this.f.get()) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new h(q, null), 3, null);
    }

    public final void a() {
        if (this.f.compareAndSet(false, true)) {
            Object a2 = this.b.a(this.f6676a.b().getName(), this.f6676a.c());
            if (Result.m10248isSuccessimpl(a2)) {
                BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new c((List) a2, null), 3, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(Q q) {
        try {
            Result.Companion companion = Result.INSTANCE;
            return this.b.a(q);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008b A[Catch: all -> 0x0097, TryCatch #0 {all -> 0x0097, blocks: (B:11:0x002d, B:12:0x0085, B:14:0x008b, B:15:0x008e, B:22:0x003c, B:24:0x0064, B:26:0x006d, B:28:0x0073, B:31:0x0080), top: B:7:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(int i, Continuation continuation) {
        g gVar;
        int i2;
        X x;
        Object obj;
        try {
            if (continuation instanceof g) {
                gVar = (g) continuation;
                int i3 = gVar.e;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    gVar.e = i3 - Integer.MIN_VALUE;
                    Object obj2 = gVar.c;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = gVar.e;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Result.Companion companion = Result.INSTANCE;
                        Object a2 = this.b.a(this.f6676a.b().getName(), this.f6676a.c(), this.f6676a.b().getBatchSize());
                        if (Result.m10248isSuccessimpl(a2)) {
                            List list = (List) a2;
                            if (!list.isEmpty() && list.size() >= i) {
                                gVar.f6682a = this;
                                gVar.b = a2;
                                gVar.e = 1;
                                if (a(list, gVar) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                a(this, false, 1, null);
                            }
                        }
                        x = this;
                        obj = a2;
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        obj = gVar.b;
                        x = (X) gVar.f6682a;
                        ResultKt.throwOnFailure(obj2);
                    }
                    if (Result.m10244exceptionOrNullimpl(obj) != null) {
                        a(x, false, 1, null);
                    }
                    return Result.m10241constructorimpl(Result.m10240boximpl(obj));
                }
            }
            if (i2 != 0) {
            }
            if (Result.m10244exceptionOrNullimpl(obj) != null) {
            }
            return Result.m10241constructorimpl(Result.m10240boximpl(obj));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        gVar = new g(continuation);
        Object obj22 = gVar.c;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = gVar.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(List list, Continuation continuation) {
        e eVar;
        int i;
        Object a2;
        X x;
        Object obj;
        Deferred async$default;
        if (continuation instanceof e) {
            eVar = (e) continuation;
            int i2 = eVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                eVar.e = i2 - Integer.MIN_VALUE;
                Object obj2 = eVar.c;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = eVar.e;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    a2 = this.b.a(list);
                    if (Result.m10248isSuccessimpl(a2)) {
                        List chunked = CollectionsKt.chunked(list, this.f6676a.b().getBatchSize());
                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(chunked, 10));
                        Iterator it = chunked.iterator();
                        while (it.hasNext()) {
                            async$default = BuildersKt__Builders_commonKt.async$default(this.d, null, null, new f((List) it.next(), null), 3, null);
                            arrayList.add(async$default);
                        }
                        eVar.f6680a = this;
                        eVar.b = a2;
                        eVar.e = 1;
                        if (AwaitKt.awaitAll(arrayList, eVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        x = this;
                        obj = a2;
                    } else {
                        x = this;
                        if (Result.m10244exceptionOrNullimpl(a2) != null) {
                            x.a(true);
                        }
                        return Unit.INSTANCE;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj = eVar.b;
                    x = (X) eVar.f6680a;
                    ResultKt.throwOnFailure(obj2);
                }
                x.a(true);
                a2 = obj;
                if (Result.m10244exceptionOrNullimpl(a2) != null) {
                }
                return Unit.INSTANCE;
            }
        }
        eVar = new e(continuation);
        Object obj22 = eVar.c;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = eVar.e;
        if (i != 0) {
        }
        x.a(true);
        a2 = obj;
        if (Result.m10244exceptionOrNullimpl(a2) != null) {
        }
        return Unit.INSTANCE;
    }

    static /* synthetic */ void a(X x, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        x.a(z);
    }

    private final void a(boolean z) {
        Job launch$default;
        Job job;
        if (this.f.get()) {
            return;
        }
        if (z || (job = this.e) == null || !job.isActive()) {
            Job job2 = this.e;
            if (job2 != null) {
                Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
            }
            launch$default = BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new d(null), 3, null);
            this.e = launch$default;
        }
    }
}
