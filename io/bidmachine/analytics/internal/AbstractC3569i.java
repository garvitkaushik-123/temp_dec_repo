package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.ReaderConfig;
import io.bidmachine.analytics.internal.InterfaceC3568h;
import io.bidmachine.analytics.internal.q0;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* renamed from: io.bidmachine.analytics.internal.i, reason: case insensitive filesystem */
/* loaded from: classes7.dex */
public abstract class AbstractC3569i extends AbstractC3570j {
    private final Lazy d = LazyKt.lazy(d.f6705a);
    private Job e;
    private a f;

    /* renamed from: io.bidmachine.analytics.internal.i$a */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f6702a;
        private final List b;
        private final InterfaceC3568h c;

        public a(long j, List list, InterfaceC3568h interfaceC3568h) {
            this.f6702a = j;
            this.b = list;
            this.c = interfaceC3568h;
        }

        public final InterfaceC3568h a() {
            return this.c;
        }

        public final long b() {
            return this.f6702a;
        }

        public final List c() {
            return this.b;
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.i$b */
    static final class b extends SuspendLambda implements Function2 {

        /* renamed from: a, reason: collision with root package name */
        Object f6703a;
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ a f;
        final /* synthetic */ AbstractC3569i g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(a aVar, AbstractC3569i abstractC3569i, Continuation continuation) {
            super(2, continuation);
            this.f = aVar;
            this.g = abstractC3569i;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            b bVar = new b(this.f, this.g, continuation);
            bVar.e = obj;
            return bVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
        
            r11 = r7;
         */
        /* JADX WARN: Removed duplicated region for block: B:11:0x0064  */
        /* JADX WARN: Removed duplicated region for block: B:16:0x0084  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0089  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x008e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b0 -> B:6:0x0041). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            AbstractC3569i abstractC3569i;
            Collection collection;
            Iterator it;
            CoroutineScope coroutineScope2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.d;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.e;
            } else {
                if (i == 1) {
                    it = (Iterator) this.c;
                    collection = (Collection) this.b;
                    abstractC3569i = (AbstractC3569i) this.f6703a;
                    CoroutineScope coroutineScope3 = (CoroutineScope) this.e;
                    ResultKt.throwOnFailure(obj);
                    Object obj2 = ((Result) obj).getValue();
                    if (Result.m10247isFailureimpl(obj2)) {
                        obj2 = null;
                    }
                    InterfaceC3568h.a aVar = (InterfaceC3568h.a) obj2;
                    if (aVar != null) {
                        collection.add(aVar);
                    }
                    coroutineScope2 = coroutineScope3;
                    if (it.hasNext()) {
                        ReaderConfig.Rule rule = (ReaderConfig.Rule) it.next();
                        this.e = coroutineScope2;
                        this.f6703a = abstractC3569i;
                        this.b = collection;
                        this.c = it;
                        this.d = 1;
                        Object b = abstractC3569i.b(rule, this);
                        if (b != coroutine_suspended) {
                            coroutineScope3 = coroutineScope2;
                            obj2 = b;
                            if (Result.m10247isFailureimpl(obj2)) {
                            }
                            InterfaceC3568h.a aVar2 = (InterfaceC3568h.a) obj2;
                            if (aVar2 != null) {
                            }
                            coroutineScope2 = coroutineScope3;
                            if (it.hasNext()) {
                                this.f.a().a((List) collection);
                                long b2 = this.f.b();
                                this.e = coroutineScope2;
                                this.f6703a = null;
                                this.b = null;
                                this.c = null;
                                this.d = 2;
                                if (DelayKt.delay(b2, this) != coroutine_suspended) {
                                    coroutineScope = coroutineScope2;
                                }
                            }
                        }
                    }
                    return coroutine_suspended;
                }
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.e;
                ResultKt.throwOnFailure(obj);
            }
            if (!CoroutineScopeKt.isActive(coroutineScope)) {
                return Unit.INSTANCE;
            }
            List c = this.f.c();
            AbstractC3569i abstractC3569i2 = this.g;
            ArrayList arrayList = new ArrayList();
            CoroutineScope coroutineScope4 = coroutineScope;
            it = c.iterator();
            coroutineScope2 = coroutineScope4;
            abstractC3569i = abstractC3569i2;
            collection = arrayList;
            if (it.hasNext()) {
            }
            return coroutine_suspended;
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.i$c */
    static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f6704a;
        Object b;
        /* synthetic */ Object c;
        int e;

        c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            Object b = AbstractC3569i.this.b(null, this);
            return b == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? b : Result.m10240boximpl(b);
        }
    }

    /* renamed from: io.bidmachine.analytics.internal.i$d */
    static final class d extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final d f6705a = new d();

        d() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final CoroutineScope invoke() {
            return CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(p0.g.a().c()));
        }
    }

    public abstract Object a(ReaderConfig.Rule rule, Continuation continuation);

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public void e(Context context) {
        Job job = this.e;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public void f(Context context) {
        Job launch$default;
        Job job = this.e;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        a aVar = this.f;
        if (aVar == null) {
            return;
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(b(), null, null, new b(aVar, this, null), 3, null);
        this.e = launch$default;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(a aVar) {
        this.f = aVar;
    }

    public final CoroutineScope b() {
        return (CoroutineScope) this.d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(ReaderConfig.Rule rule, Continuation continuation) {
        c cVar;
        int i;
        Throwable th;
        AbstractC3569i abstractC3569i;
        Object m10241constructorimpl;
        String str;
        q0.a aVar;
        String str2;
        if (continuation instanceof c) {
            cVar = (c) continuation;
            int i2 = cVar.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                cVar.e = i2 - Integer.MIN_VALUE;
                Object obj = cVar.c;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = cVar.e;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        cVar.f6704a = this;
                        cVar.b = rule;
                        cVar.e = 1;
                        obj = a(rule, cVar);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        abstractC3569i = this;
                    } catch (Throwable th2) {
                        th = th2;
                        abstractC3569i = this;
                        Result.Companion companion2 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        ReaderConfig.Rule rule2 = rule;
                        str = (String) (!Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
                        if (str == null) {
                        }
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    rule = (ReaderConfig.Rule) cVar.b;
                    abstractC3569i = (AbstractC3569i) cVar.f6704a;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        Result.Companion companion22 = Result.INSTANCE;
                        m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
                        ReaderConfig.Rule rule22 = rule;
                        str = (String) (!Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
                        if (str == null) {
                        }
                    }
                }
                m10241constructorimpl = Result.m10241constructorimpl((String) obj);
                ReaderConfig.Rule rule222 = rule;
                str = (String) (!Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
                if (str == null) {
                    Result.Companion companion3 = Result.INSTANCE;
                    return Result.m10241constructorimpl(new InterfaceC3568h.a(rule222, str, null, 4, null));
                }
                Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
                if (!(m10244exceptionOrNullimpl instanceof CancellationException)) {
                    if (m10244exceptionOrNullimpl instanceof FileNotFoundException) {
                        aVar = q0.a.READER_NO_CONTENT;
                    } else {
                        aVar = m10244exceptionOrNullimpl instanceof SecurityException ? q0.a.READER_NO_ACCESS : q0.a.READER_INVALID;
                    }
                    if (m10244exceptionOrNullimpl == null || (str2 = s0.a(m10244exceptionOrNullimpl)) == null) {
                        str2 = "";
                    }
                    Result.Companion companion4 = Result.INSTANCE;
                    return Result.m10241constructorimpl(new InterfaceC3568h.a(rule222, null, new q0(abstractC3569i.a(), aVar, str2), 2, null));
                }
                throw m10244exceptionOrNullimpl;
            }
        }
        cVar = new c(continuation);
        Object obj2 = cVar.c;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cVar.e;
        if (i != 0) {
        }
        m10241constructorimpl = Result.m10241constructorimpl((String) obj2);
        ReaderConfig.Rule rule2222 = rule;
        str = (String) (!Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
        if (str == null) {
        }
    }
}
