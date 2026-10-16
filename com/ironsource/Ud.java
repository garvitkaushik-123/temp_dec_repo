package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Ud {
    public static final a c = new a(null);
    public static final int d = 2070;
    public static final int e = 2080;
    public static final int f = 2090;
    public static final int g = 2100;
    public static final int h = 2110;

    /* renamed from: a, reason: collision with root package name */
    private final int f3080a;
    private final String b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public Ud(int i, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        this.f3080a = i;
        this.b = errorMessage;
    }

    public final int a() {
        return this.f3080a;
    }

    public final String b() {
        return this.b;
    }

    public final int c() {
        return this.f3080a;
    }

    public final String d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ud)) {
            return false;
        }
        Ud ud = (Ud) obj;
        return this.f3080a == ud.f3080a && Intrinsics.areEqual(this.b, ud.b);
    }

    public int hashCode() {
        return (Integer.hashCode(this.f3080a) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "SdkError(errorCode=" + this.f3080a + ", errorMessage=" + this.b + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Ud(IronSourceError error) {
        this(r0, r3);
        Intrinsics.checkNotNullParameter(error, "error");
        int errorCode = error.getErrorCode();
        String errorMessage = error.getErrorMessage();
        Intrinsics.checkNotNullExpressionValue(errorMessage, "error.errorMessage");
    }

    public final Ud a(int i, String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        return new Ud(i, errorMessage);
    }

    public static /* synthetic */ Ud a(Ud ud, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ud.f3080a;
        }
        if ((i2 & 2) != 0) {
            str = ud.b;
        }
        return ud.a(i, str);
    }
}
