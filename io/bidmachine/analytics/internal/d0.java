package io.bidmachine.analytics.internal;

import android.content.Context;
import io.bidmachine.analytics.ReaderConfig;
import io.bidmachine.analytics.internal.AbstractC3569i;
import io.bidmachine.analytics.internal.t0;
import java.io.FileNotFoundException;
import java.util.List;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;

/* loaded from: classes7.dex */
public final class d0 extends AbstractC3569i {
    public static final b l = new b(null);
    private final e0 g;
    private final Function1 h;
    private Context i;
    private C3575o j;
    private final String k;

    static final class a extends Lambda implements Function1 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f6692a = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final C3575o invoke(Context context) {
            return new C3575o(context);
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private b() {
        }
    }

    static final class c extends ContinuationImpl {

        /* renamed from: a, reason: collision with root package name */
        Object f6693a;
        /* synthetic */ Object b;
        int d;

        c(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.b = obj;
            this.d |= Integer.MIN_VALUE;
            return d0.this.a(null, this);
        }
    }

    public /* synthetic */ d0(e0 e0Var, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(e0Var, (i & 2) != 0 ? a.f6692a : function1);
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public String a() {
        return this.k;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3570j
    public void d(Context context) {
        this.i = context;
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3569i, io.bidmachine.analytics.internal.AbstractC3570j
    public void e(Context context) {
        super.e(context);
        C3575o c3575o = this.j;
        if (c3575o != null) {
            c3575o.j();
        }
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3569i, io.bidmachine.analytics.internal.AbstractC3570j
    public void f(Context context) {
        C3575o c3575o = this.j;
        if (c3575o != null) {
            c3575o.i();
        }
        super.f(context);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // io.bidmachine.analytics.internal.AbstractC3569i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(ReaderConfig.Rule rule, Continuation continuation) {
        c cVar;
        int i;
        d0 d0Var;
        C3574n c3574n;
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
                    C3575o c3575o = this.j;
                    if (c3575o == null) {
                        throw new IllegalArgumentException("Not configured");
                    }
                    Duration.Companion companion = Duration.INSTANCE;
                    long m11585getInWholeMillisecondsimpl = Duration.m11585getInWholeMillisecondsimpl(DurationKt.toDuration(10, DurationUnit.SECONDS));
                    cVar.f6693a = this;
                    cVar.d = 1;
                    obj = c3575o.a(m11585getInWholeMillisecondsimpl, cVar);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    d0Var = this;
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d0Var = (d0) cVar.f6693a;
                    ResultKt.throwOnFailure(obj);
                }
                c3574n = (C3574n) obj;
                d0Var.g.a(c3574n);
                if (c3574n != null) {
                    throw new FileNotFoundException("Data not received yet");
                }
                if (c3574n.f()) {
                    throw new FileNotFoundException("Data is empty");
                }
                return c3574n.b();
            }
        }
        cVar = new c(continuation);
        Object obj2 = cVar.b;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = cVar.d;
        if (i != 0) {
        }
        c3574n = (C3574n) obj2;
        d0Var.g.a(c3574n);
        if (c3574n != null) {
        }
    }

    public d0(e0 e0Var, Function1 function1) {
        this.g = e0Var;
        this.h = function1;
        this.k = "apur";
    }

    @Override // io.bidmachine.analytics.internal.AbstractC3569i, io.bidmachine.analytics.internal.AbstractC3570j
    /* renamed from: a */
    public void b(AbstractC3569i.a aVar) {
        super.b(aVar);
        Context context = this.i;
        if (context != null) {
            if (aVar.c().size() == 1) {
                List split$default = StringsKt.split$default((CharSequence) s0.b(((ReaderConfig.Rule) CollectionsKt.first(aVar.c())).getPath()), new String[]{"-"}, false, 0, 6, (Object) null);
                if (split$default.size() == 2) {
                    t0.a aVar2 = t0.d;
                    t0 a2 = aVar2.a(StringsKt.trim((CharSequence) split$default.get(0)).toString());
                    if (a2 != null) {
                        t0 a3 = aVar2.a(StringsKt.trim((CharSequence) split$default.get(1)).toString());
                        if (a3 != null) {
                            C3575o c3575o = this.j;
                            if (c3575o == null) {
                                c3575o = (C3575o) this.h.invoke(context);
                            }
                            this.j = c3575o;
                            t0 l2 = c3575o.l();
                            if (l2 != null) {
                                if (l2.compareTo(a2) >= 0 && l2.compareTo(a3) <= 0) {
                                    if (c3575o.u()) {
                                        if (!c3575o.t()) {
                                            throw new IllegalStateException("No permission");
                                        }
                                        return;
                                    }
                                    throw new IllegalStateException("No host found");
                                }
                                throw new IllegalStateException(("Version " + l2 + " not supported by config").toString());
                            }
                            throw new IllegalStateException("Version not found");
                        }
                        throw new IllegalStateException("Max version not found");
                    }
                    throw new IllegalStateException("Min version not found");
                }
                throw new IllegalStateException("Path should contains min and max value");
            }
            throw new IllegalStateException(("Reader " + a() + " should contains only one rule, received " + aVar.c().size()).toString());
        }
        throw new IllegalArgumentException("Context is null");
    }
}
