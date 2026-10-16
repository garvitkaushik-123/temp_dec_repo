package com.ironsource;

import android.os.Handler;
import com.ironsource.T6;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class U6 {

    public static final class a implements T6.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Handler f3073a;

        a(Handler handler) {
            this.f3073a = handler;
        }

        @Override // com.ironsource.T6.a
        public void a(Runnable runnable, long j) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.f3073a.postDelayed(runnable, j);
        }
    }

    public static final T6.a a(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<this>");
        return new a(handler);
    }
}
