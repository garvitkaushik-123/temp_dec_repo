package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class L1 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M1 f2346a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L1(M1 m1) {
        super(1);
        this.f2346a = m1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        String str;
        EnumC2790o4 it = (EnumC2790o4) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        M1 m1 = this.f2346a;
        InterfaceC2971z5 interfaceC2971z5 = m1.j;
        if (interfaceC2971z5 != null) {
            str = m1.N;
            Intrinsics.checkNotNullExpressionValue(str, "access$getTAG$p(...)");
            ((A5) interfaceC2971z5).b(str, "loadWithRetry error - " + it);
        }
        this.f2346a.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE), true, AbstractC2568ae.a(it));
        return Unit.INSTANCE;
    }
}
