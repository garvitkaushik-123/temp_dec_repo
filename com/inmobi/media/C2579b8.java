package com.inmobi.media;

import com.inmobi.ads.InMobiAdRequestStatus;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* renamed from: com.inmobi.media.b8, reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C2579b8 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C2596c8 f2525a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2579b8(C2596c8 c2596c8) {
        super(1);
        this.f2525a = c2596c8;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        EnumC2790o4 it = (EnumC2790o4) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        this.f2525a.a(new InMobiAdRequestStatus(InMobiAdRequestStatus.StatusCode.NETWORK_UNREACHABLE), true, AbstractC2568ae.a(it));
        return Unit.INSTANCE;
    }
}
