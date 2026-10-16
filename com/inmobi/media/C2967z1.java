package com.inmobi.media;

import android.content.Context;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.ironsource.C3040d4;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.inmobi.media.z1, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2967z1 extends M1 {
    public final B1 S;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2967z1(Context context, Z placement, F0 f0) {
        super(context, placement, f0);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(placement, "placement");
        this.S = new B1();
    }

    @Override // com.inmobi.media.M1
    public final boolean D0() {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).c(e, "canProceedToLoad");
        }
        if (f0()) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                String e2 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                ((A5) interfaceC2971z52).b(e2, "Some of the dependency libraries for Banner not found");
            }
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.MISSING_REQUIRED_DEPENDENCIES), true, (short) 2007);
            return false;
        }
        if (1 == Q() || 2 == Q()) {
            String e3 = S0.e();
            Intrinsics.checkNotNullExpressionValue(e3, "<get-TAG>(...)");
            AbstractC2680h7.a((byte) 1, e3, "An ad load is already in progress. Please wait for the load to complete before requesting for another ad");
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                String e4 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e4, "<get-TAG>(...)");
                ((A5) interfaceC2971z53).b(e4, "ad load in progress. ignore load");
            }
            a((short) 53);
            return false;
        }
        if (7 == Q()) {
            b(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.AD_ACTIVE), false, (short) 15);
            AbstractC2680h7.a((byte) 1, "InMobi", AbstractC2929we.j + I().l());
            InterfaceC2971z5 interfaceC2971z54 = this.j;
            if (interfaceC2971z54 != null) {
                String e5 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e5, "<get-TAG>(...)");
                ((A5) interfaceC2971z54).b(e5, "Ad is active. ignore load");
            }
            return false;
        }
        if (Q() == 4) {
            if (!W()) {
                InterfaceC2971z5 interfaceC2971z55 = this.j;
                if (interfaceC2971z55 != null) {
                    String e6 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e6, "<get-TAG>(...)");
                    ((A5) interfaceC2971z55).c(e6, "signalCanShowForStateReady");
                }
                InterfaceC2971z5 interfaceC2971z56 = this.j;
                if (interfaceC2971z56 != null) {
                    String e7 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e7, "<get-TAG>(...)");
                    ((A5) interfaceC2971z56).a(e7, "An ad is ready with the ad unit. Signaling ad load success ...");
                }
                F0 r = r();
                if (r == null) {
                    AbstractC2680h7.a((byte) 2, "InMobi", "Listener was garbage collected. Unable to give callback");
                    InterfaceC2971z5 interfaceC2971z57 = this.j;
                    if (interfaceC2971z57 != null) {
                        String e8 = S0.e();
                        Intrinsics.checkNotNullExpressionValue(e8, "<get-TAG>(...)");
                        ((A5) interfaceC2971z57).b(e8, "listener is null. load show callback missed");
                    }
                } else {
                    InterfaceC2971z5 interfaceC2971z58 = this.j;
                    if (interfaceC2971z58 != null) {
                        String e9 = S0.e();
                        Intrinsics.checkNotNullExpressionValue(e9, "<get-TAG>(...)");
                        ((A5) interfaceC2971z58).a(e9, "callback - onLoadSuccess");
                    }
                    f(r);
                }
                return false;
            }
            InterfaceC2971z5 interfaceC2971z59 = this.j;
            if (interfaceC2971z59 != null) {
                String e10 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e10, "<get-TAG>(...)");
                ((A5) interfaceC2971z59).b(e10, "ad is expired, clearing");
            }
            g();
        }
        e0();
        return true;
    }

    @Override // com.inmobi.media.M1, com.inmobi.media.AbstractC2669gc
    public final void a(D1 audioStatusInternal) {
        Intrinsics.checkNotNullParameter(audioStatusInternal, "audioStatusInternal");
        F0 r = r();
        if (r != null) {
            r.a(audioStatusInternal);
        }
        B1 b1 = this.S;
        b1.getClass();
        Intrinsics.checkNotNullParameter(audioStatusInternal, "audioStatusInternal");
        if (!b1.f2240a && audioStatusInternal == D1.e) {
            b1.f2240a = true;
            C2839r5 c2839r5 = C2839r5.c;
            c2839r5.f2421a = System.currentTimeMillis();
            c2839r5.b++;
        }
    }

    public final void d(short s) {
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).c(e, "onShowFailure");
        }
        F0 r = r();
        if (r == null) {
            AbstractC2680h7.a((byte) 2, "InMobi", "Listener was garbage collected. Unable to give callback");
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                String e2 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                ((A5) interfaceC2971z52).b(e2, "listener is null. show fail callback missed. ");
            }
        } else {
            InterfaceC2971z5 interfaceC2971z53 = this.j;
            if (interfaceC2971z53 != null) {
                String e3 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e3, "<get-TAG>(...)");
                ((A5) interfaceC2971z53).b(e3, "callback - onAdShowFailed");
            }
            r.d();
        }
        if (s != 0) {
            InterfaceC2971z5 interfaceC2971z54 = this.j;
            if (interfaceC2971z54 != null) {
                String e4 = S0.e();
                ((A5) interfaceC2971z54).b(e4, X8.a(e4, "<get-TAG>(...)", "show failed - ", s));
            }
            c(s);
        }
    }

    @Override // com.inmobi.media.M1, com.inmobi.media.S0, com.inmobi.media.AbstractC2669gc
    public final void i(GestureDetectorOnGestureListenerC2634ec renderView) {
        F0 r;
        Intrinsics.checkNotNullParameter(renderView, "renderView");
        InterfaceC2971z5 interfaceC2971z5 = this.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).c(e, "onRenderViewVisible");
        }
        if (Q() == 4 && (r = r()) != null) {
            InterfaceC2971z5 interfaceC2971z52 = this.j;
            if (interfaceC2971z52 != null) {
                String e2 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                ((A5) interfaceC2971z52).a(e2, "callback - onAdDisplayed");
            }
            d(r);
        }
        super.i(renderView);
    }

    @Override // com.inmobi.media.M1, com.inmobi.media.S0
    public final String q() {
        return "audio";
    }

    @Override // com.inmobi.media.M1, com.inmobi.media.AbstractC2669gc
    public final void a(boolean z) {
        Context d = Uc.d();
        if (d == null) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = C6.b;
        C6 a2 = B6.a(d, "audio_pref_file");
        Intrinsics.checkNotNullParameter("user_mute_count", C3040d4.h.W);
        int i = a2.f2249a.getInt("user_mute_count", 0);
        C6.a(a2, "user_mute_count", z ? Math.max(0, i - 1) : i + 1, false, 4, (Object) null);
    }
}
