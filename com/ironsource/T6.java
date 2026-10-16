package com.ironsource;

import android.os.Handler;
import android.os.Looper;
import com.ironsource.InterfaceC3034cf;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;

/* loaded from: classes6.dex */
public final class T6 implements InterfaceC3034cf {

    /* renamed from: a, reason: collision with root package name */
    private final a f3058a;

    public interface a {
        void a(Runnable runnable, long j);
    }

    public static final class b extends Pd {
        final /* synthetic */ InterfaceC3034cf.a b;
        final /* synthetic */ Runnable c;

        b(InterfaceC3034cf.a aVar, Runnable runnable) {
            this.b = aVar;
            this.c = runnable;
        }

        @Override // com.ironsource.Pd
        public void a() {
            if (this.b.b()) {
                return;
            }
            this.c.run();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T6() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.ironsource.InterfaceC3034cf
    public InterfaceC3034cf.a a(Runnable task, long j) {
        Intrinsics.checkNotNullParameter(task, "task");
        InterfaceC3034cf.a aVar = new InterfaceC3034cf.a();
        this.f3058a.a(a(aVar, task), Duration.m11585getInWholeMillisecondsimpl(j));
        return aVar;
    }

    public T6(a handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.f3058a = handler;
    }

    public /* synthetic */ T6(a aVar, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? U6.a(new Handler(Looper.getMainLooper())) : aVar);
    }

    private final Pd a(InterfaceC3034cf.a aVar, Runnable runnable) {
        return new b(aVar, runnable);
    }
}
