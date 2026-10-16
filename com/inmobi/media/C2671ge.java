package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.ge, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2671ge {

    /* renamed from: a, reason: collision with root package name */
    public final S0 f2582a;
    public final HashMap b;

    public C2671ge(S0 timeOutInformer) {
        Intrinsics.checkNotNullParameter(timeOutInformer, "timeOutInformer");
        this.f2582a = timeOutInformer;
        this.b = new HashMap();
    }

    public final void a(final byte b) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.ge$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2671ge.a(C2671ge.this, b);
            }
        });
    }

    public static final void a(C2671ge this$0, byte b) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f2582a.a(b);
    }
}
