package com.ironsource;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* renamed from: com.ironsource.p4, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3243p4 {

    /* renamed from: a, reason: collision with root package name */
    private final Throwable f3634a;
    private final String b;
    private final boolean c;

    public C3243p4(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        this.f3634a = throwable;
        StringBuilder sb = new StringBuilder();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        Intrinsics.checkNotNullExpressionValue(stackTrace, "throwable.stackTrace");
        sb.append(throwable.toString());
        sb.append(System.lineSeparator());
        boolean z = false;
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb.append(stackTraceElement.toString());
            sb.append(";" + System.lineSeparator());
            String stackTraceElement2 = stackTraceElement.toString();
            Intrinsics.checkNotNullExpressionValue(stackTraceElement2, "elem.toString()");
            String e = C3260q4.d().e();
            Intrinsics.checkNotNullExpressionValue(e, "getInstance().keyword");
            if (StringsKt.contains$default((CharSequence) stackTraceElement2, (CharSequence) e, false, 2, (Object) null)) {
                z = true;
            }
        }
        Throwable cause = this.f3634a.getCause();
        if (cause != null) {
            sb.append("--CAUSE");
            sb.append(System.lineSeparator());
            sb.append(cause.toString());
            sb.append(System.lineSeparator());
            StackTraceElement[] stackTrace2 = cause.getStackTrace();
            Intrinsics.checkNotNullExpressionValue(stackTrace2, "cause.stackTrace");
            for (StackTraceElement stackTraceElement3 : stackTrace2) {
                sb.append(stackTraceElement3.toString());
                sb.append(";" + System.lineSeparator());
                String stackTraceElement4 = stackTraceElement3.toString();
                Intrinsics.checkNotNullExpressionValue(stackTraceElement4, "elem.toString()");
                String e2 = C3260q4.d().e();
                Intrinsics.checkNotNullExpressionValue(e2, "getInstance().keyword");
                if (StringsKt.contains$default((CharSequence) stackTraceElement4, (CharSequence) e2, false, 2, (Object) null)) {
                    z = true;
                }
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "builder.toString()");
        this.b = sb2;
        this.c = z;
    }

    public final Throwable a() {
        return this.f3634a;
    }

    public final String b() {
        return this.b;
    }

    public final Throwable c() {
        return this.f3634a;
    }

    public final boolean d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C3243p4) && Intrinsics.areEqual(this.f3634a, ((C3243p4) obj).f3634a);
    }

    public int hashCode() {
        return this.f3634a.hashCode();
    }

    public String toString() {
        return "CrashReportWrapper(throwable=" + this.f3634a + ")";
    }

    public final C3243p4 a(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        return new C3243p4(throwable);
    }

    public static /* synthetic */ C3243p4 a(C3243p4 c3243p4, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = c3243p4.f3634a;
        }
        return c3243p4.a(th);
    }
}
