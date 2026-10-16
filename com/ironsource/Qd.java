package com.ironsource;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class Qd extends ScheduledThreadPoolExecutor {

    /* renamed from: a, reason: collision with root package name */
    private final Function1<Throwable, Unit> f3015a;
    private final Function1<String, Unit> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class a extends Lambda implements Function1<Throwable, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f3016a = new a();

        a() {
            super(1);
        }

        public final void a(Throwable th) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            a(th);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final class b extends Lambda implements Function1<String, Unit> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3017a = new b();

        b() {
            super(1);
        }

        public final void a(String it) {
            Intrinsics.checkNotNullParameter(it, "it");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            a(str);
            return Unit.INSTANCE;
        }
    }

    public Qd() {
        this(0, null, null, 7, null);
    }

    private final String a(String str) {
        return Qd.class.getName() + " RuntimeException caught: " + str;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    protected void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (th != null) {
            this.b.invoke(a(th.toString()));
            this.f3015a.invoke(th);
            return;
        }
        if ((runnable instanceof Future) && ((Future) runnable).isDone()) {
            try {
                ((Future) runnable).get();
            } catch (InterruptedException e) {
                C3260q4.d().a(e);
                this.b.invoke(a(e.toString()));
                Thread.currentThread().interrupt();
            } catch (CancellationException e2) {
                C3260q4.d().a(e2);
                this.b.invoke(a(e2.toString()));
                this.f3015a.invoke(e2);
            } catch (ExecutionException e3) {
                C3260q4.d().a(e3);
                this.b.invoke(a(e3.toString()));
                this.f3015a.invoke(e3.getCause());
            }
        }
    }

    public /* synthetic */ Qd(int i, Function1 function1, Function1 function12, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? Rd.f3033a : i, (i2 & 2) != 0 ? a.f3016a : function1, (i2 & 4) != 0 ? b.f3017a : function12);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Qd(int i, Function1<? super Throwable, Unit> report, Function1<? super String, Unit> log) {
        super(i, new S9());
        Intrinsics.checkNotNullParameter(report, "report");
        Intrinsics.checkNotNullParameter(log, "log");
        this.f3015a = report;
        this.b = log;
    }
}
