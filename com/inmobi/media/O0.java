package com.inmobi.media;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class O0 extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S0 f2378a;
    public final /* synthetic */ byte[] b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public O0(S0 s0, byte[] bArr) {
        super(0);
        this.f2378a = s0;
        this.b = bArr;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        this.f2378a.d((byte) 1);
        InterfaceC2971z5 interfaceC2971z5 = this.f2378a.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            ((A5) interfaceC2971z5).d(e, H6.a(e, "<get-TAG>(...)", "AdUnit ").append(this.f2378a).append(" state - LOADING").toString());
        }
        InterfaceC2971z5 interfaceC2971z52 = this.f2378a.j;
        if (interfaceC2971z52 != null) {
            String e2 = S0.e();
            Intrinsics.checkNotNullExpressionValue(e2, "<get-TAG>(...)");
            ((A5) interfaceC2971z52).c(e2, "starting load with response worker");
        }
        A v = this.f2378a.v();
        int hashCode = this.f2378a.hashCode();
        S0 s0 = this.f2378a;
        C2598ca H = s0.H();
        Intrinsics.checkNotNull(H);
        V6 v6 = new V6(s0, H, this.b, this.f2378a.j);
        v.getClass();
        A.a(hashCode, v6);
        return Unit.INSTANCE;
    }
}
