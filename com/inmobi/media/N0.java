package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class N0 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S0 f2368a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public N0(S0 s0) {
        super(1);
        this.f2368a = s0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        EnumC2790o4 it = (EnumC2790o4) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        InterfaceC2971z5 interfaceC2971z5 = this.f2368a.j;
        if (interfaceC2971z5 != null) {
            String e = S0.e();
            Intrinsics.checkNotNullExpressionValue(e, "<get-TAG>(...)");
            ((A5) interfaceC2971z5).b(e, "load with retry failed - max retry reached - No network");
        }
        this.f2368a.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE), true, AbstractC2568ae.a(it));
        return Unit.INSTANCE;
    }
}
