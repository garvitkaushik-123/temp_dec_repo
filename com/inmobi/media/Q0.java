package com.inmobi.media;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class Q0 extends G1 {
    public final /* synthetic */ S0 d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Q0(S0 s0, String str, String str2) {
        super(s0);
        this.d = s0;
        this.e = str;
        this.f = str2;
    }

    @Override // com.inmobi.media.G1
    public final void a() {
        S0 s0 = (S0) this.b.get();
        if (s0 != null) {
            C2672h m = s0.m();
            if (m == null || !Intrinsics.areEqual(m.s(), this.e)) {
                InterfaceC2971z5 interfaceC2971z5 = this.d.j;
                if (interfaceC2971z5 != null) {
                    String e = S0.e();
                    Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
                    ((A5) interfaceC2971z5).b(e, "Impression ID is null for saveBlob");
                    return;
                }
                return;
            }
            S0.a(s0, m, this.f);
            InterfaceC2971z5 interfaceC2971z52 = this.d.j;
            if (interfaceC2971z52 != null) {
                String e2 = S0.e();
                ((A5) interfaceC2971z52).c(e2, H6.a(e2, "<get-TAG>(...)", "Updated blob ").append(this.f).toString());
            }
        }
    }
}
