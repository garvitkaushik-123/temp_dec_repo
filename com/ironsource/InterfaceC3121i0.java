package com.ironsource;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.i0, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public interface InterfaceC3121i0 {

    /* renamed from: com.ironsource.i0$a */
    public static final class a implements InterfaceC3121i0 {
        public static final C0288a c = new C0288a(null);

        /* renamed from: a, reason: collision with root package name */
        private final String f3346a;
        private final boolean b;

        /* renamed from: com.ironsource.i0$a$a, reason: collision with other inner class name */
        public static final class C0288a {
            public /* synthetic */ C0288a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final a a(String str) {
                return new a(str);
            }

            private C0288a() {
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final a a(String str) {
            return new a(str);
        }

        public final String b() {
            return this.f3346a;
        }

        public final String c() {
            return this.f3346a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.f3346a, ((a) obj).f3346a);
        }

        public int hashCode() {
            String str = this.f3346a;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "NotReady(reason=" + this.f3346a + ")";
        }

        public a(String str) {
            this.f3346a = str;
        }

        public static /* synthetic */ a a(a aVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aVar.f3346a;
            }
            return aVar.a(str);
        }

        public /* synthetic */ a(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str);
        }

        @Override // com.ironsource.InterfaceC3121i0
        public boolean a() {
            return this.b;
        }
    }

    /* renamed from: com.ironsource.i0$b */
    public static final class b implements InterfaceC3121i0 {

        /* renamed from: a, reason: collision with root package name */
        public static final b f3347a = new b();
        private static final boolean b = true;

        private b() {
        }

        @Override // com.ironsource.InterfaceC3121i0
        public boolean a() {
            return b;
        }
    }

    boolean a();
}
