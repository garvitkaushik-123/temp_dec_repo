package io.bidmachine.analytics.internal;

import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes7.dex */
public final class t0 implements Comparable {
    public static final a d = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f6787a;
    private final int b;
    private final int c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t0 a(String str) {
            Object m10241constructorimpl;
            try {
                Result.Companion companion = Result.INSTANCE;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.INSTANCE;
                m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
            }
            if (StringsKt.isBlank(str)) {
                return null;
            }
            List split$default = StringsKt.split$default((CharSequence) str, new String[]{"."}, false, 0, 6, (Object) null);
            if (split$default.isEmpty()) {
                return null;
            }
            int size = split$default.size();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (i < size && i <= 6) {
                if (i == 0) {
                    i2 = Integer.parseInt((String) split$default.get(0));
                } else if (i != 1) {
                    i4 = i != 2 ? (i4 * 100) + Integer.parseInt((String) split$default.get(i)) : Integer.parseInt((String) split$default.get(2));
                } else {
                    i3 = Integer.parseInt((String) split$default.get(1));
                }
                i++;
            }
            m10241constructorimpl = Result.m10241constructorimpl(new t0(i2, i3, i4));
            return (t0) (Result.m10247isFailureimpl(m10241constructorimpl) ? null : m10241constructorimpl);
        }

        private a() {
        }
    }

    public t0(int i, int i2, int i3) {
        this.f6787a = i;
        this.b = i2;
        this.c = i3;
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(t0 t0Var) {
        int compare = Intrinsics.compare(this.f6787a, t0Var.f6787a);
        if (compare != 0) {
            return compare;
        }
        int compare2 = Intrinsics.compare(this.b, t0Var.b);
        return compare2 != 0 ? compare2 : Intrinsics.compare(this.c, t0Var.c);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        return this.f6787a == t0Var.f6787a && this.b == t0Var.b && this.c == t0Var.c;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.f6787a) * 31) + Integer.hashCode(this.b)) * 31) + Integer.hashCode(this.c);
    }

    public String toString() {
        return new StringBuilder().append(this.f6787a).append('.').append(this.b).append('.').append(this.c).toString();
    }
}
