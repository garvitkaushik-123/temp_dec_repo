package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class A8 implements InterfaceC2666g9 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ D8 f2233a;
    public final /* synthetic */ C2597c9 b;

    public A8(D8 d8, C2597c9 c2597c9) {
        this.f2233a = d8;
        this.b = c2597c9;
    }

    public final void a(byte b) {
        T7 t7 = this.f2233a.b;
        if (t7.t || !(t7 instanceof C2562a9) || b == 4) {
            return;
        }
        try {
            if (b == 0) {
                We we = ((C2562a9) t7).p;
                if (we != null) {
                    we.a((byte) 5);
                    return;
                }
                return;
            }
            if (b == 1) {
                ((C2562a9) t7).g(this.b);
                return;
            }
            if (b == 2) {
                ((C2562a9) t7).f(this.b);
            } else if (b == 3) {
                ((C2562a9) t7).h(this.b);
            } else if (b == 5) {
                ((C2562a9) t7).d(this.b);
            }
        } catch (Exception e) {
            D8 d8 = this.f2233a;
            InterfaceC2971z5 interfaceC2971z5 = d8.f;
            if (interfaceC2971z5 != null) {
                String str = d8.g;
                Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
                ((A5) interfaceC2971z5).b(str, rf.a(e, new StringBuilder("SDK encountered unexpected error in handling (").append((int) b).append(") event; ")));
            }
            S5 s5 = S5.f2425a;
            S5.d.a(AbstractC2920w5.a(e, "event"));
        }
    }
}
