package com.inmobi.media;

import android.os.Handler;
import android.os.Looper;
import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class K0 extends AbstractC2669gc {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S0 f2331a;

    public K0(S0 s0) {
        this.f2331a = s0;
    }

    public static final void a(S0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR), true, (short) 43);
    }

    public static final void b(S0 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.q = true;
        this$0.f();
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void f(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (2 == this.f2331a.Q()) {
            this.f2331a.q0();
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void g(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        Handler handler = new Handler(Looper.getMainLooper());
        final S0 s0 = this.f2331a;
        handler.post(new Runnable() { // from class: com.inmobi.media.K0$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                K0.a(S0.this);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void h(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        if (2 == this.f2331a.Q()) {
            Handler handler = new Handler(Looper.getMainLooper());
            final S0 s0 = this.f2331a;
            handler.post(new Runnable() { // from class: com.inmobi.media.K0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    K0.b(S0.this);
                }
            });
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void a(Yd telemetryOnAdImpression) {
        Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "telemetryOnAdImpression");
        this.f2331a.a(telemetryOnAdImpression);
    }
}
