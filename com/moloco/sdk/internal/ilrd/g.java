package com.moloco.sdk.internal.ilrd;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5425a = 0;

    public static final class a extends g {
        public static final int c = 0;
        public final String b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String reason) {
            super(null);
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.b = reason;
        }

        public final String a() {
            return this.b;
        }

        public final String b() {
            return this.b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.areEqual(this.b, ((a) obj).b);
        }

        public int hashCode() {
            return this.b.hashCode();
        }

        public String toString() {
            return "Error(reason=" + this.b + ')';
        }

        public final a a(String reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new a(reason);
        }

        public static /* synthetic */ a a(a aVar, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = aVar.b;
            }
            return aVar.a(str);
        }
    }

    public static final class b extends g {
        public static final b b = new b();
        public static final int c = 0;

        public b() {
            super(null);
        }
    }

    public static final class c extends g {
        public static final c b = new c();
        public static final int c = 0;

        public c() {
            super(null);
        }
    }

    public /* synthetic */ g(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public g() {
    }
}
