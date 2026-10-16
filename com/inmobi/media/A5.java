package com.inmobi.media;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.ExceptionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class A5 implements InterfaceC2971z5 {

    /* renamed from: a, reason: collision with root package name */
    public Ab f2231a;
    public final Kd b;

    public A5(Context context, double d, EnumC2560a7 logLevel, boolean z, boolean z2, int i, long j, boolean z3) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        if (!z2) {
            this.b = new Kd();
        }
        if (z) {
            return;
        }
        Ab logger = new Ab(context, d, logLevel, j, i, z3);
        this.f2231a = logger;
        CopyOnWriteArrayList copyOnWriteArrayList = AbstractC2713j7.f2611a;
        Intrinsics.checkNotNull(logger);
        Intrinsics.checkNotNullParameter(logger, "logger");
        Objects.toString(logger);
        AbstractC2713j7.f2611a.add(new WeakReference(logger));
    }

    public final void a(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Ab ab = this.f2231a;
        if (ab != null) {
            ab.a(EnumC2560a7.b, tag, message);
        }
        if (this.b != null) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    public final void b(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Ab ab = this.f2231a;
        if (ab != null) {
            ab.a(EnumC2560a7.c, tag, message);
        }
        if (this.b != null) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    public final void c(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Ab ab = this.f2231a;
        if (ab != null) {
            ab.a(EnumC2560a7.f2517a, tag, message);
        }
        if (this.b != null) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
        }
    }

    public final void d(String tag, String message) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Ab ab = this.f2231a;
        if (ab != null) {
            ab.a(EnumC2560a7.d, tag, message);
        }
        if (this.b != null) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter("STATE_CHANGE: " + message, "message");
        }
    }

    public final void e(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        Ab ab = this.f2231a;
        if (ab != null) {
            Intrinsics.checkNotNullParameter(key, "key");
            Intrinsics.checkNotNullParameter(value, "value");
            Objects.toString(ab.i);
            if (ab.i.get()) {
                return;
            }
            ab.h.put(key, value);
        }
    }

    public final void a(String tag, String message, Exception error) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(error, "error");
        Ab ab = this.f2231a;
        if (ab != null) {
            ab.a(EnumC2560a7.c, tag, message + "\nError: " + ExceptionsKt.stackTraceToString(error));
        }
        if (this.b != null) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(message, "message");
            Intrinsics.checkNotNullParameter(error, "error");
        }
    }

    public final void b() {
        Ab ab = this.f2231a;
        if (ab != null) {
            ab.a();
        }
    }

    public final void a(boolean z) {
        Ab ab = this.f2231a;
        if (ab != null) {
            Objects.toString(ab.i);
            if (!ab.i.get()) {
                ab.d = z;
            }
        }
        if (z) {
            return;
        }
        Ab ab2 = this.f2231a;
        if (ab2 == null || !ab2.f.a()) {
            CopyOnWriteArrayList copyOnWriteArrayList = AbstractC2713j7.f2611a;
            AbstractC2696i7.a(this.f2231a);
            this.f2231a = null;
        }
    }

    public final void a() {
        Ab ab = this.f2231a;
        if (ab != null) {
            ab.b();
        }
        CopyOnWriteArrayList copyOnWriteArrayList = AbstractC2713j7.f2611a;
        AbstractC2696i7.a(this.f2231a);
    }
}
