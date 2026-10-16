package com.inmobi.media;

import android.os.Handler;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class P0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S0 f2390a;
    public final /* synthetic */ WeakReference b;

    public P0(S0 s0, WeakReference weakReference) {
        this.f2390a = s0;
        this.b = weakReference;
    }

    public static final void b(S0 this$0, WeakReference listenerWeakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listenerWeakReference, "$listenerWeakReference");
        InterfaceC2971z5 interfaceC2971z5 = this$0.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).a(e, "callback- onAdDisplayed");
        }
        this$0.b((F0) listenerWeakReference.get());
    }

    public final void a() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2390a.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            ((A5) interfaceC2971z5).a(e, H6.a(e, "<get-TAG>(...)", "Ad interaction for placement id: ").append(this.f2390a.I()).toString());
        }
        if (this.f2390a.Z()) {
            InterfaceC2971z5 interfaceC2971z52 = this.f2390a.j;
            if (interfaceC2971z52 != null) {
                String e2 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                ((A5) interfaceC2971z52).b(e2, "ad unit is destroyed");
                return;
            }
            return;
        }
        F0 f0 = (F0) this.b.get();
        if (f0 != null) {
            InterfaceC2971z5 interfaceC2971z53 = this.f2390a.j;
            if (interfaceC2971z53 != null) {
                String e3 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e3, "<get-TAG>(...)");
                ((A5) interfaceC2971z53).a(e3, "callback - onAdInteraction");
            }
            f0.a(new HashMap());
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.f2390a.j;
        if (interfaceC2971z54 != null) {
            String e4 = S0.e();
            Intrinsics.checkNotNullExpressionValue(e4, "<get-TAG>(...)");
            ((A5) interfaceC2971z54).b(e4, "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void c() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2390a.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).a(e, "onAdDisplayFailed native interaction callback");
        }
        if (this.f2390a.Z()) {
            InterfaceC2971z5 interfaceC2971z52 = this.f2390a.j;
            if (interfaceC2971z52 != null) {
                String e2 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                ((A5) interfaceC2971z52).b(e2, "callback onAdDisplayFailed failed. already destroyed.");
                return;
            }
            return;
        }
        F0 f0 = (F0) this.b.get();
        if (f0 != null) {
            InterfaceC2971z5 interfaceC2971z53 = this.f2390a.j;
            if (interfaceC2971z53 != null) {
                String e3 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e3, "<get-TAG>(...)");
                ((A5) interfaceC2971z53).a(e3, "callback - onAdShowFailed");
            }
            this.f2390a.a(f0, (short) 91);
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.f2390a.j;
        if (interfaceC2971z54 != null) {
            String e4 = S0.e();
            Intrinsics.checkNotNullExpressionValue(e4, "<get-TAG>(...)");
            ((A5) interfaceC2971z54).b(e4, "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void d() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2390a.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).c(e, "onAdDisplay ");
        }
        this.f2390a.b((byte) 4);
        if (this.f2390a.Z()) {
            InterfaceC2971z5 interfaceC2971z52 = this.f2390a.j;
            if (interfaceC2971z52 != null) {
                String e2 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                ((A5) interfaceC2971z52).b(e2, "onAdDisplay callback failed. adunit destroyed.");
                return;
            }
            return;
        }
        Handler D = this.f2390a.D();
        if (D != null) {
            final S0 s0 = this.f2390a;
            final WeakReference weakReference = this.b;
            D.post(new Runnable() { // from class: com.inmobi.media.P0$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    P0.b(S0.this, weakReference);
                }
            });
        }
    }

    public final void e() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2390a.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).c(e, "onAdFullScreenWillDisplay");
        }
        if (this.f2390a.Z()) {
            InterfaceC2971z5 interfaceC2971z52 = this.f2390a.j;
            if (interfaceC2971z52 != null) {
                String e2 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                ((A5) interfaceC2971z52).a(e2, "onAdFullScreenWillDisplay callback failed. adunit destroyed");
                return;
            }
            return;
        }
        F0 f0 = (F0) this.b.get();
        if (f0 != null) {
            InterfaceC2971z5 interfaceC2971z53 = this.f2390a.j;
            if (interfaceC2971z53 != null) {
                String e3 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e3, "<get-TAG>(...)");
                ((A5) interfaceC2971z53).a(e3, "callback - onAdScreenWillDisplay");
            }
            f0.e();
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.f2390a.j;
        if (interfaceC2971z54 != null) {
            String e4 = S0.e();
            Intrinsics.checkNotNullExpressionValue(e4, "<get-TAG>(...)");
            ((A5) interfaceC2971z54).b(e4, "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void f() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2390a.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            ((A5) interfaceC2971z5).a(e, H6.a(e, "<get-TAG>(...)", "Successfully impressed ad for placement id: ").append(this.f2390a.I()).toString());
        }
        if (this.f2390a.Z()) {
            InterfaceC2971z5 interfaceC2971z52 = this.f2390a.j;
            if (interfaceC2971z52 != null) {
                String e2 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                ((A5) interfaceC2971z52).b(e2, "ad unit is destroyed");
                return;
            }
            return;
        }
        F0 f0 = (F0) this.b.get();
        if (f0 != null) {
            InterfaceC2971z5 interfaceC2971z53 = this.f2390a.j;
            if (interfaceC2971z53 != null) {
                String e3 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e3, "<get-TAG>(...)");
                ((A5) interfaceC2971z53).a(e3, "callback - onAdImpressed");
            }
            f0.c();
            return;
        }
        InterfaceC2971z5 interfaceC2971z54 = this.f2390a.j;
        if (interfaceC2971z54 != null) {
            String e4 = S0.e();
            Intrinsics.checkNotNullExpressionValue(e4, "<get-TAG>(...)");
            ((A5) interfaceC2971z54).b(e4, "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void g() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2390a.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).a(e, "onUserLeftApplication");
        }
        if (this.f2390a.Z()) {
            return;
        }
        F0 f0 = (F0) this.b.get();
        if (f0 != null) {
            f0.h();
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.f2390a.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).b("InMobi", "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void h() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2390a.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).a(e, "onUserSkippedMedia");
        }
        if (this.f2390a.Z()) {
            return;
        }
        F0 f0 = (F0) this.b.get();
        if (f0 != null) {
            f0.i();
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.f2390a.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).b("InMobi", "Listener was garbage collected.Unable to give callback");
        }
    }

    public final void b() {
        InterfaceC2971z5 interfaceC2971z5 = this.f2390a.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).a(e, "onAdDismissed");
        }
        if (this.f2390a.Z()) {
            return;
        }
        InterfaceC2971z5 interfaceC2971z52 = this.f2390a.j;
        if (interfaceC2971z52 != null) {
            ((A5) interfaceC2971z52).a("InMobi", "Ad dismissed for placement id: " + this.f2390a.I());
        }
        Handler D = this.f2390a.D();
        if (D != null) {
            final S0 s0 = this.f2390a;
            final WeakReference weakReference = this.b;
            D.post(new Runnable() { // from class: com.inmobi.media.P0$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    P0.a(S0.this, weakReference);
                }
            });
        }
    }

    public static final void a(S0 this$0, WeakReference listenerWeakReference) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(listenerWeakReference, "$listenerWeakReference");
        this$0.a((F0) listenerWeakReference.get());
    }
}
