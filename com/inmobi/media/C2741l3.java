package com.inmobi.media;

import java.lang.Thread;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.l3, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2741l3 extends G3 implements Thread.UncaughtExceptionHandler {
    public final Thread.UncaughtExceptionHandler b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2741l3(Thread.UncaughtExceptionHandler uncaughtExceptionHandler, H3 listener) {
        super(listener);
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.b = uncaughtExceptionHandler;
    }

    @Override // com.inmobi.media.G3
    public final void a() {
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override // com.inmobi.media.G3
    public final void b() {
        Thread.setDefaultUncaughtExceptionHandler(this.b);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread t, Throwable e) {
        Intrinsics.checkNotNullParameter(t, "t");
        Intrinsics.checkNotNullParameter(e, "e");
        this.f2290a.a(new C2757m3(t, e));
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(t, e);
        }
    }
}
