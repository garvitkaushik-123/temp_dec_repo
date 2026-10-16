package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.l6, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2744l6 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2760m6 f2630a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2744l6(C2760m6 c2760m6) {
        super(1);
        this.f2630a = c2760m6;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        EnumC2790o4 it = (EnumC2790o4) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f2630a.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE), true, AbstractC2568ae.a(it));
        return Unit.INSTANCE;
    }
}
