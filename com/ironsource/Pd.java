package com.ironsource;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class Pd implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final a f2996a = new a(null);

    public static final class a {

        /* renamed from: com.ironsource.Pd$a$a, reason: collision with other inner class name */
        public static final class C0281a extends Pd {
            final /* synthetic */ Function0<Unit> b;

            C0281a(Function0<Unit> function0) {
                this.b = function0;
            }

            @Override // com.ironsource.Pd
            public void a() {
                this.b.invoke();
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Pd a(Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            return new C0281a(block);
        }

        private a() {
        }
    }

    public abstract void a() throws Exception;

    public void a(Throwable t) {
        Intrinsics.checkNotNullParameter(t, "t");
        C3051df.a(t);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a();
        } catch (Throwable th) {
            C3260q4.d().a(th);
            try {
                a(th);
            } catch (Throwable th2) {
                C3260q4.d().a(th2);
            }
        }
    }
}
