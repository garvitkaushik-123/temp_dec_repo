package com.ironsource;

import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.b7, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3006b7 {

    /* renamed from: com.ironsource.b7$a */
    public static final class a implements InterfaceC3006b7 {

        /* renamed from: a, reason: collision with root package name */
        private final Y6 f3197a;

        public a(Y6 failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            this.f3197a = failure;
        }

        public final Y6 a() {
            return this.f3197a;
        }

        public final Y6 b() {
            return this.f3197a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f3197a, ((a) obj).f3197a);
        }

        public int hashCode() {
            return this.f3197a.hashCode();
        }

        public String toString() {
            return "Failure(failure=" + this.f3197a + ")";
        }

        public final a a(Y6 failure) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            return new a(failure);
        }

        public static /* synthetic */ a a(a aVar, Y6 y6, int i, Object obj) {
            if ((i & 1) != 0) {
                y6 = aVar.f3197a;
            }
            return aVar.a(y6);
        }

        @Override // com.ironsource.InterfaceC3006b7
        public void a(InterfaceC3023c7 handler) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            handler.a(this.f3197a);
        }
    }

    default void a(InterfaceC3023c7 handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
    }
}
