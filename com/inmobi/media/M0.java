package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class M0 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ S0 f2358a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M0(S0 s0) {
        super(1);
        this.f2358a = s0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        short s;
        EnumC2790o4 errorCode = (EnumC2790o4) obj;
        Intrinsics.checkNotNullParameter(errorCode, "it");
        S0 s0 = this.f2358a;
        InMobiAdRequestStatus inMobiAdRequestStatus = new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE);
        Intrinsics.checkNotNullParameter(errorCode, "errorCode");
        int ordinal = errorCode.ordinal();
        if (ordinal != 0) {
            if (ordinal != 18) {
                switch (ordinal) {
                    case 12:
                        s = 2101;
                        break;
                    case 13:
                        s = 2102;
                        break;
                    case 14:
                        s = 2103;
                        break;
                    case 15:
                        s = 2104;
                        break;
                    case 16:
                        s = 2105;
                        break;
                }
            } else {
                s = 2228;
            }
            s0.a(inMobiAdRequestStatus, true, s);
            return Unit.INSTANCE;
        }
        s = 2100;
        s0.a(inMobiAdRequestStatus, true, s);
        return Unit.INSTANCE;
    }
}
