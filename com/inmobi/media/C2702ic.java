package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.ic, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2702ic {

    /* renamed from: a, reason: collision with root package name */
    public GestureDetectorOnGestureListenerC2634ec f2601a;
    public final long b;

    public C2702ic(GestureDetectorOnGestureListenerC2634ec view, long j) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.f2601a = view;
        this.b = j;
    }

    public final void a() {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.inmobi.media.ic$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                C2702ic.a(C2702ic.this);
            }
        }, this.b);
    }

    public static final void a(C2702ic this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = this$0.f2601a;
        if (gestureDetectorOnGestureListenerC2634ec != null) {
            gestureDetectorOnGestureListenerC2634ec.g();
        }
        this$0.f2601a = null;
    }
}
