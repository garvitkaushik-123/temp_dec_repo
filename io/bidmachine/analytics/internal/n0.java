package io.bidmachine.analytics.internal;

import com.explorestack.protobuf.Struct;
import io.bidmachine.analytics.ReaderConfig;
import io.bidmachine.analytics.internal.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* loaded from: classes7.dex */
public final class n0 {

    /* renamed from: a, reason: collision with root package name */
    private final a f6727a;
    private final l0 b;
    private final String c;
    private final CoroutineScope d;

    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final ReaderConfig f6728a;
        private final String b;
        private final Struct c;
        private final g0.a d;

        public a(ReaderConfig readerConfig, String str, Struct struct, g0.a aVar) {
            this.f6728a = readerConfig;
            this.b = str;
            this.c = struct;
            this.d = aVar;
        }

        public final g0.a a() {
            return this.d;
        }

        public final Struct b() {
            return this.c;
        }

        public final ReaderConfig c() {
            return this.f6728a;
        }
    }

    static final class b extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f6729a;
        /* synthetic */ Object b;
        int d;

        b(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            Object a2 = n0.this.a((String) null, this);
            return a2 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? a2 : Result.m10240boximpl(a2);
        }
    }

    static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f6730a;
        /* synthetic */ Object b;
        int d;

        c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return n0.this.a((List) null, this);
        }
    }

    static final class d extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        int f6731a;
        final /* synthetic */ List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(List list, Continuation continuation) {
            super(2, continuation);
            this.c = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return n0.this.new d(this.c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object a2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6731a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                g0 g0Var = new g0(n0.this.f6727a.c().getUrl(), n0.this.f6727a.c().getName(), n0.this.f6727a.b(), this.c, n0.this.f6727a.a(), null, 32, null);
                this.f6731a = 1;
                a2 = g0Var.a(this);
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
            n0 n0Var = n0.this;
            List list = this.c;
            if (Result.m10248isSuccessimpl(a2)) {
                l0 l0Var = n0Var.b;
                ArrayList arrayList = new ArrayList();
                for (Object obj2 : list) {
                    if (((h0) obj2).b() != null) {
                        arrayList.add(obj2);
                    }
                }
                l0Var.b(arrayList);
                ArrayList arrayList2 = new ArrayList();
                for (Object obj3 : list) {
                    if (((h0) obj3).b() == null) {
                        arrayList2.add(obj3);
                    }
                }
                n0Var.b.c(arrayList2);
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    n0Var.a((h0) it.next());
                }
            }
            n0 n0Var2 = n0.this;
            List list2 = this.c;
            if (Result.m10244exceptionOrNullimpl(a2) != null) {
                n0Var2.b.c(list2);
            }
            return Result.m10240boximpl(a2);
        }
    }

    static final class e extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        Object f6732a;
        int b;
        final /* synthetic */ String d;
        final /* synthetic */ List e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str, List list, Continuation continuation) {
            super(2, continuation);
            this.d = str;
            this.e = list;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((e) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return n0.this.new e(this.d, this.e, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x009b, code lost:
        
            if (r10.a(r1, r9) == r0) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x009d, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0087, code lost:
        
            if (r10.a(r4, r9) == r0) goto L29;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            List arrayList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                arrayList = new ArrayList();
                n0 n0Var = n0.this;
                String str = this.d;
                List list = this.e;
                ArrayList arrayList2 = new ArrayList();
                for (Object obj2 : list) {
                    if (((h0) obj2).b() != null) {
                        arrayList2.add(obj2);
                    }
                }
                n0Var.a(str, arrayList2);
                List<h0> list2 = this.e;
                n0 n0Var2 = n0.this;
                for (h0 h0Var : list2) {
                    if (Result.m10247isFailureimpl(n0Var2.a(h0Var))) {
                        arrayList.add(h0Var);
                    }
                }
                n0 n0Var3 = n0.this;
                String str2 = this.d;
                this.f6732a = arrayList;
                this.b = 1;
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                arrayList = (List) this.f6732a;
                ResultKt.throwOnFailure(obj);
                ((Result) obj).getValue();
            }
            if (!arrayList.isEmpty()) {
                n0 n0Var4 = n0.this;
                this.f6732a = null;
                this.b = 2;
            }
            return Unit.INSTANCE;
        }
    }

    public n0(p0 p0Var, a aVar, l0 l0Var) {
        this.f6727a = aVar;
        this.b = l0Var;
        this.c = aVar.c().getName();
        this.d = CoroutineScopeKt.CoroutineScope(new CoroutineName("AnalyticsMonitor: " + aVar.c().getName()).plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(p0Var.c()));
    }

    public final void b(String str, List list) {
        BuildersKt__Builders_commonKt.launch$default(this.d, null, null, new e(str, list, null), 3, null);
    }

    public final String a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(String str, List list) {
        try {
            Result.Companion companion = Result.INSTANCE;
            l0 l0Var = this.b;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((h0) it.next()).e());
            }
            return Result.m10241constructorimpl(Result.m10240boximpl(l0Var.a(str, arrayList)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(String str, Continuation continuation) {
        b bVar;
        int i;
        Object a2;
        try {
            if (continuation instanceof b) {
                bVar = (b) continuation;
                int i2 = bVar.d;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    bVar.d = i2 - Integer.MIN_VALUE;
                    Object obj = bVar.b;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = bVar.d;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Result.Companion companion = Result.INSTANCE;
                        a2 = this.b.a(str);
                        if (Result.m10248isSuccessimpl(a2)) {
                            List list = (List) a2;
                            if (!list.isEmpty()) {
                                bVar.f6729a = a2;
                                bVar.d = 1;
                                if (a(list, bVar) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        a2 = bVar.f6729a;
                        ResultKt.throwOnFailure(obj);
                    }
                    return Result.m10241constructorimpl(Result.m10240boximpl(a2));
                }
            }
            if (i != 0) {
            }
            return Result.m10241constructorimpl(Result.m10240boximpl(a2));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        bVar = new b(continuation);
        Object obj2 = bVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bVar.d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object a(h0 h0Var) {
        boolean z;
        try {
            Result.Companion companion = Result.INSTANCE;
            if (h0Var.b() != null) {
                return this.b.b(h0Var);
            }
            Object a2 = this.b.a(h0Var.d(), h0Var.e());
            if (Result.m10247isFailureimpl(a2)) {
                a2 = null;
            }
            h0 h0Var2 = (h0) a2;
            if (h0Var2 == null) {
                return this.b.b(h0Var);
            }
            if (this.f6727a.c().getUniqueOnly() && Intrinsics.areEqual(h0Var.a(), h0Var2.a())) {
                z = false;
                return this.b.a(h0.a(h0Var, h0Var2.c(), null, 0L, null, null, null, z, 62, null));
            }
            z = true;
            return this.b.a(h0.a(h0Var, h0Var2.c(), null, 0L, null, null, null, z, 62, null));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(List list, Continuation continuation) {
        c cVar;
        int i;
        Deferred async$default;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i2 = cVar.d;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.d = i2 - Integer.MIN_VALUE;
                Object obj = cVar.b;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cVar.d;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Object a2 = this.b.a(list);
                    if (Result.m10248isSuccessimpl(a2)) {
                        async$default = BuildersKt__Builders_commonKt.async$default(this.d, null, null, new d(list, null), 3, null);
                        cVar.f6730a = a2;
                        cVar.d = 1;
                        if (async$default.await(cVar) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
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
        cVar = new c(continuation);
        Object obj2 = cVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cVar.d;
        if (i != 0) {
        }
        return Unit.INSTANCE;
    }
}
