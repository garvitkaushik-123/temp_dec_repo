package com.inmobi.media;

import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class S7 extends AbstractC2669gc {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ T7 f2427a;

    public S7(T7 t7) {
        this.f2427a = t7;
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void a(HashMap params) {
        Intrinsics.checkNotNullParameter(params, "params");
        P0 p0 = this.f2427a.w;
        if (p0 != null) {
            p0.a();
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void c() {
        P0 p0 = this.f2427a.w;
        if (p0 != null) {
            p0.c();
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void d(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        P0 p0 = this.f2427a.w;
        if (p0 != null) {
            p0.b();
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void e(GestureDetectorOnGestureListenerC2634ec renderView) {
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        P0 p0 = this.f2427a.w;
        if (p0 != null) {
            p0.d();
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc, com.inmobi.media.Fe
    public final void a() {
        P0 p0 = this.f2427a.w;
        if (p0 != null) {
            p0.g();
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void d() {
        P0 p0;
        T7 t7 = this.f2427a;
        if (t7.f2437a != 0 || (p0 = t7.w) == null) {
            return;
        }
        p0.e();
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void a(Yd telemetryOnAdImpression) {
        Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "telemetryOnAdImpression");
        P0 p0 = this.f2427a.w;
        if (p0 != null) {
            Intrinsics.checkNotNullParameter(telemetryOnAdImpression, "telemetryOnAdImpression");
            telemetryOnAdImpression.getClass();
            Intrinsics.checkNotNullParameter("nativeBeacon", "<set-?>");
            telemetryOnAdImpression.e = "nativeBeacon";
            if (p0.f2390a.Z()) {
                telemetryOnAdImpression.b();
            } else {
                p0.f2390a.D.a(telemetryOnAdImpression);
            }
        }
    }

    @Override // com.inmobi.media.AbstractC2669gc
    public final void a(String log) {
        Intrinsics.checkNotNullParameter(log, "log");
        P0 p0 = this.f2427a.w;
        if (p0 != null) {
            Intrinsics.checkNotNullParameter(log, "log");
            InterfaceC2971z5 interfaceC2971z5 = p0.f2390a.j;
            if (interfaceC2971z5 != null) {
                String e = S0.e();
                Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
                ((A5) interfaceC2971z5).a(e, "onImraidLog");
            }
            if (p0.f2390a.Z()) {
                return;
            }
            F0 f0 = (F0) p0.b.get();
            if (f0 != null) {
                f0.a(log);
                return;
            }
            InterfaceC2971z5 interfaceC2971z52 = p0.f2390a.j;
            if (interfaceC2971z52 != null) {
                String e2 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                ((A5) interfaceC2971z52).b(e2, "listener is null");
            }
        }
    }
}
