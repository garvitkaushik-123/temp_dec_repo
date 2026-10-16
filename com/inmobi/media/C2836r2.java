package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.r2, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2836r2 {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC2869t2 f2690a;
    public final InterfaceC2971z5 b;

    public C2836r2(InterfaceC2869t2 mEventHandler, InterfaceC2971z5 interfaceC2971z5) {
        Intrinsics.checkNotNullParameter(mEventHandler, "mEventHandler");
        this.f2690a = mEventHandler;
        this.b = interfaceC2971z5;
    }

    public final void a(final C2740l2 click) {
        Intrinsics.checkNotNullParameter(click, "click");
        click.i.set(false);
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.post(new Runnable() { // from class: com.inmobi.media.r2$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2836r2.a(C2740l2.this, this, handler);
            }
        });
    }

    public static final void a(C2740l2 click, C2836r2 this$0, Handler handler) {
        Intrinsics.checkNotNullParameter(click, "$click");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(handler, "$handler");
        N9 n9 = new N9(click.b, this$0.b);
        n9.x = false;
        n9.t = false;
        n9.u = false;
        HashMap a2 = C2933x2.a(C2933x2.f2748a, click);
        if (!a2.isEmpty()) {
            n9.i.putAll(a2);
        }
        new vf(n9, new C2821q2(click, this$0, handler)).a();
    }
}
