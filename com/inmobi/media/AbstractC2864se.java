package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.se, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC2864se extends G1 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC2864se(S0 obj, byte b) {
        super(obj);
        Intrinsics.checkNotNullParameter(obj, "obj");
    }

    public static final void a(AbstractC2864se this$0, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a(obj);
    }

    public abstract void a(Object obj);

    public final void b(final Object obj) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.inmobi.media.se$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AbstractC2864se.a(AbstractC2864se.this, obj);
            }
        });
    }
}
