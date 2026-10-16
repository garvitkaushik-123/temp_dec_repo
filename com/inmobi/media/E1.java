package com.inmobi.media;

import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.inmobi.ads.AdMetaInfo;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiAudio;
import com.inmobi.ads.controllers.PublisherCallbacks;
import com.ironsource.C3355vf;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class E1 extends AbstractC2929we {
    public C2967z1 o;
    public C2967z1 p;
    public C2967z1 q;
    public C2967z1 r;

    public E1(InMobiAudio.a callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
        b(callbacks);
    }

    @Override // com.inmobi.media.AbstractC2929we
    public final void a(byte[] bArr, PublisherCallbacks callbacks) {
        Intrinsics.checkNotNullParameter(callbacks, "callbacks");
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public final void b(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).c(str, "onAdFetchSuccess " + this);
        }
        C2967z1 c2967z1 = this.r;
        if ((c2967z1 != null ? c2967z1.m() : null) == null) {
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                String str2 = F1.f2278a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((A5) p2).b(str2, "adObject is null, fetch failed");
            }
            a((S0) null, new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.INTERNAL_ERROR));
            return;
        }
        InterfaceC2971z5 p3 = p();
        if (p3 != null) {
            String str3 = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) p3).a(str3, "Ad fetch successful, calling loadIntoView()");
        }
        super.b(info);
        s().post(new Runnable() { // from class: com.inmobi.media.E1$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                E1.a(E1.this, info);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public final void c(final AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).c(str, "onAdLoadSucceeded " + this);
        }
        super.c(info);
        a((byte) 0);
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            String str2 = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) p2).d(str2, "AdManager state - CREATED");
        }
        InterfaceC2971z5 p3 = p();
        if (p3 != null) {
            String str3 = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
            ((A5) p3).a(str3, "Ad load successful, providing callback");
        }
        s().post(new Runnable() { // from class: com.inmobi.media.E1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                E1.b(E1.this, info);
            }
        });
    }

    @Override // com.inmobi.media.F0
    public final void d() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).a(str, "onAdShowFailed " + this);
        }
        s().post(new Runnable() { // from class: com.inmobi.media.E1$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                E1.a(E1.this);
            }
        });
    }

    @Override // com.inmobi.media.AbstractC2929we
    public final S0 j() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).c(str, "shouldUseForegroundUnit " + this);
        }
        C2967z1 c2967z1 = this.q;
        Byte valueOf = c2967z1 != null ? Byte.valueOf(c2967z1.Q()) : null;
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            String str2 = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) p2).d(str2, "State - " + valueOf);
        }
        return ((valueOf == null || valueOf.byteValue() != 4) && (valueOf == null || valueOf.byteValue() != 7) && (valueOf == null || valueOf.byteValue() != 6)) ? this.r : this.q;
    }

    @Override // com.inmobi.media.AbstractC2929we
    public final void w() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).a(str, "submitAdLoadCalled " + this);
        }
        C2967z1 c2967z1 = this.r;
        if (c2967z1 != null) {
            c2967z1.t0();
        }
    }

    public final void x() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).c(str, "registerLifeCycleCallbacks " + this);
        }
        C2967z1 c2967z1 = this.o;
        if (c2967z1 != null) {
            c2967z1.H0();
        }
        C2967z1 c2967z12 = this.p;
        if (c2967z12 != null) {
            c2967z12.H0();
        }
    }

    public final void y() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).a(str, "loadIntoView " + this);
        }
        C2967z1 c2967z1 = this.r;
        if (c2967z1 == null) {
            throw new IllegalStateException(AbstractC2929we.m);
        }
        if (c2967z1 == null || !a("InMobi", c2967z1.I().toString())) {
            return;
        }
        a((byte) 8);
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            String str2 = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) p2).d(str2, "AdManager state - LOADING_INTO_VIEW");
        }
        c2967z1.j0();
    }

    public static final void a(E1 this$0, AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onAdFetchSuccessful(info);
        }
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public final void a(S0 s0, InMobiAdRequestStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).b(str, C3355vf.b);
        }
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            ((A5) p2).a();
        }
    }

    public static final void a(E1 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InterfaceC2971z5 p = this$0.p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).a(str, "callback - onAdDisplayFailed");
        }
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onAdDisplayFailed();
        }
        InterfaceC2971z5 p2 = this$0.p();
        if (p2 != null) {
            ((A5) p2).a();
        }
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public final void a(AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).a(str, "onAdDisplayed");
        }
        super.a(info);
        S0 j = j();
        if (j != null) {
            j.x0();
        }
    }

    public final void a(final InMobiAudio audio) {
        Intrinsics.checkNotNullParameter(audio, "audio");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).a(str, "show called");
        }
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                a((RelativeLayout) audio);
            } else {
                s().post(new Runnable() { // from class: com.inmobi.media.E1$$ExternalSyntheticLambda2
                    @Override // java.lang.Runnable
                    public final void run() {
                        E1.a(E1.this, audio);
                    }
                });
            }
        } catch (Exception e) {
            C2967z1 c2967z1 = this.r;
            if (c2967z1 != null) {
                c2967z1.d((short) 26);
            }
            String str2 = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            AbstractC2680h7.a((byte) 1, str2, "Unable to show ad; SDK encountered an unexpected error");
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                ((A5) p2).b(str2, rf.a(e, H6.a(str2, "access$getTAG$p(...)", "Show failed with unexpected error: ")));
            }
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }

    public static final void b(E1 this$0, AdMetaInfo info) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(info, "$info");
        PublisherCallbacks l = this$0.l();
        if (l != null) {
            l.onAdLoadSucceeded(info);
        }
    }

    @Override // com.inmobi.media.AbstractC2929we, com.inmobi.media.F0
    public final void b() {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).a(str, "onAdDismissed " + this);
        }
        a((byte) 0);
        InterfaceC2971z5 p2 = p();
        if (p2 != null) {
            String str2 = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            ((A5) p2).d(str2, "AdManager state - CREATED");
        }
        InterfaceC2971z5 p3 = p();
        if (p3 != null) {
            ((A5) p3).a();
        }
        super.b();
    }

    public final void b(String adSize) {
        Intrinsics.checkNotNullParameter(adSize, "adSize");
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).a(str, "load 1 " + this);
        }
        C2967z1 c2967z1 = this.r;
        if (c2967z1 != null && a("InMobi", c2967z1.I().toString(), l()) && c2967z1.e((byte) 1)) {
            a((byte) 1);
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                String str2 = F1.f2278a;
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((A5) p2).d(str2, "AdManager state - LOADING");
            }
            d(null);
            c2967z1.e(adSize);
            c2967z1.e(false);
        }
    }

    public static final void a(E1 this$0, RelativeLayout audio) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(audio, "$audio");
        this$0.a(audio);
    }

    public final void a(RelativeLayout relativeLayout) {
        InterfaceC2930x k;
        Z I;
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).a(str, "showAudioAd");
        }
        C2967z1 c2967z1 = this.q;
        if (c2967z1 != null ? c2967z1.E0() : false) {
            String str2 = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
            AbstractC2680h7.a((byte) 1, str2, "An ad is currently being viewed by the user. Please wait for the user to close the ad before showing another ad.");
            InterfaceC2971z5 p2 = p();
            if (p2 != null) {
                Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$p(...)");
                ((A5) p2).b(str2, "ad is active");
            }
            C2967z1 c2967z12 = this.r;
            if (c2967z12 != null) {
                c2967z12.d((short) 15);
                return;
            }
            return;
        }
        C2967z1 c2967z13 = this.r;
        if (c2967z13 != null) {
            InterfaceC2971z5 interfaceC2971z5 = c2967z13.j;
            if (interfaceC2971z5 != null) {
                String e = S0.e();
                Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
                ((A5) interfaceC2971z5).c(e, "canProceedToShow");
            }
            if (c2967z13.W()) {
                String e2 = S0.e();
                Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
                AbstractC2680h7.a((byte) 1, e2, "Ad Show has failed because current ad is expired. Please call load() again.");
                InterfaceC2971z5 interfaceC2971z52 = c2967z13.j;
                if (interfaceC2971z52 != null) {
                    String e3 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e3, "<get-TAG>(...)");
                    ((A5) interfaceC2971z52).b(e3, "ad is expired");
                }
                InterfaceC2971z5 interfaceC2971z53 = c2967z13.j;
                if (interfaceC2971z53 != null) {
                    String e4 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e4, "<get-TAG>(...)");
                    ((A5) interfaceC2971z53).d(e4, "AdUnit " + c2967z13 + " state - CREATED");
                }
                c2967z13.d((byte) 0);
                c2967z13.d((short) 2153);
                return;
            }
            byte Q = c2967z13.Q();
            if (Q == 1 || Q == 2) {
                AbstractC2680h7.a((byte) 1, "InMobi", "Ad Load is not complete. Please wait for the Ad to be in a ready state before calling show.");
                InterfaceC2971z5 interfaceC2971z54 = c2967z13.j;
                if (interfaceC2971z54 != null) {
                    String e5 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e5, "<get-TAG>(...)");
                    ((A5) interfaceC2971z54).b(e5, "ad is not ready");
                }
                InterfaceC2971z5 interfaceC2971z55 = c2967z13.j;
                if (interfaceC2971z55 != null) {
                    String e6 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e6, "<get-TAG>(...)");
                    ((A5) interfaceC2971z55).a(e6, "callback - onShowFailure");
                }
                c2967z13.d((short) 2152);
                return;
            }
            if (Q == 3) {
                AbstractC2680h7.a((byte) 1, "InMobi", "Ad Load has Failed. Please call load() again.");
                c2967z13.d((short) 0);
                InterfaceC2971z5 interfaceC2971z56 = c2967z13.j;
                if (interfaceC2971z56 != null) {
                    String e7 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e7, "<get-TAG>(...)");
                    ((A5) interfaceC2971z56).a(e7, "callback - onShowFailure");
                }
                InterfaceC2971z5 interfaceC2971z57 = c2967z13.j;
                if (interfaceC2971z57 != null) {
                    String e8 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e8, "<get-TAG>(...)");
                    ((A5) interfaceC2971z57).b(e8, "ad is failed");
                    return;
                }
                return;
            }
            if (Q == 8) {
                AbstractC2680h7.a((byte) 1, "InMobi", "Ad Load has Failed. Please call load() again.");
                c2967z13.d((short) 0);
                InterfaceC2971z5 interfaceC2971z58 = c2967z13.j;
                if (interfaceC2971z58 != null) {
                    String e9 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e9, "<get-TAG>(...)");
                    ((A5) interfaceC2971z58).a(e9, "callback - onShowFailure");
                }
                InterfaceC2971z5 interfaceC2971z59 = c2967z13.j;
                if (interfaceC2971z59 != null) {
                    String e10 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e10, "<get-TAG>(...)");
                    ((A5) interfaceC2971z59).b(e10, "ad is unloaded");
                    return;
                }
                return;
            }
            if (Q == 0) {
                AbstractC2680h7.a((byte) 1, "InMobi", "Ad Show has Failed. Please call load() before calling show().");
                c2967z13.d((short) 0);
                InterfaceC2971z5 interfaceC2971z510 = c2967z13.j;
                if (interfaceC2971z510 != null) {
                    String e11 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e11, "<get-TAG>(...)");
                    ((A5) interfaceC2971z510).a(e11, "callback - onShowFailure");
                }
                InterfaceC2971z5 interfaceC2971z511 = c2967z13.j;
                if (interfaceC2971z511 != null) {
                    String e12 = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e12, "<get-TAG>(...)");
                    ((A5) interfaceC2971z511).b(e12, "show called before load");
                    return;
                }
                return;
            }
            InterfaceC2971z5 p3 = p();
            if (p3 != null) {
                String str3 = F1.f2278a;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$p(...)");
                ((A5) p3).a(str3, "swapAdUnits " + this);
            }
            C2967z1 c2967z14 = this.q;
            if (Intrinsics.areEqual(c2967z14, this.o)) {
                this.q = this.p;
                this.r = this.o;
            } else if (Intrinsics.areEqual(c2967z14, this.p) || c2967z14 == null) {
                this.q = this.o;
                this.r = this.p;
            }
            InterfaceC2971z5 p4 = p();
            if (p4 != null) {
                String str4 = F1.f2278a;
                Intrinsics.checkNotNullExpressionValue(str4, "access$getTAG$p(...)");
                ((A5) p4).a(str4, "displayAd " + this);
            }
            C2967z1 c2967z15 = this.q;
            if (c2967z15 == null || (k = c2967z15.k()) == null) {
                return;
            }
            GestureDetectorOnGestureListenerC2634ec gestureDetectorOnGestureListenerC2634ec = (GestureDetectorOnGestureListenerC2634ec) k;
            Xe viewableAd = gestureDetectorOnGestureListenerC2634ec.getViewableAd();
            C2967z1 c2967z16 = this.q;
            if (c2967z16 != null && (I = c2967z16.I()) != null && I.p()) {
                gestureDetectorOnGestureListenerC2634ec.e();
            }
            ViewParent parent = gestureDetectorOnGestureListenerC2634ec.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            View d = viewableAd.d();
            viewableAd.a((Map) null);
            C2967z1 c2967z17 = this.r;
            if (c2967z17 != null) {
                c2967z17.F0();
            }
            if (viewGroup == null) {
                relativeLayout.addView(d, layoutParams);
            } else {
                viewGroup.removeAllViews();
                viewGroup.addView(d, layoutParams);
            }
            C2967z1 c2967z18 = this.r;
            if (c2967z18 != null) {
                c2967z18.g();
            }
        }
    }

    @Override // com.inmobi.media.AbstractC2929we
    public final void a(short s) {
        InterfaceC2971z5 p = p();
        if (p != null) {
            String str = F1.f2278a;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) p).b(str, "submitAdLoadDroppedAtSDK " + this);
        }
        C2967z1 c2967z1 = this.r;
        if (c2967z1 != null) {
            c2967z1.a(s);
        }
    }
}
