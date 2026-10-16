package com.ironsource;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* renamed from: com.ironsource.l2, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3173l2 implements InterfaceC3190m2 {

    /* renamed from: a, reason: collision with root package name */
    private final String f3441a;
    private final InterfaceC3100gd b;

    public C3173l2(String encryptedAuctionResponse, InterfaceC3100gd providerName) {
        Intrinsics.checkNotNullParameter(encryptedAuctionResponse, "encryptedAuctionResponse");
        Intrinsics.checkNotNullParameter(providerName, "providerName");
        this.f3441a = encryptedAuctionResponse;
        this.b = providerName;
    }

    @Override // com.ironsource.InterfaceC3190m2
    public Object a() {
        Object m10241constructorimpl;
        String c = C3193m5.b().c();
        Intrinsics.checkNotNullExpressionValue(c, "getInstance().mediationKey");
        C3046da c3046da = new C3046da(new I4(this.f3441a, c));
        try {
            Result.Companion companion = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(c3046da.a());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            m10241constructorimpl = Result.m10241constructorimpl(ResultKt.createFailure(th));
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(m10241constructorimpl);
        if (m10244exceptionOrNullimpl == null) {
            return C3139j2.h.a((JSONObject) m10241constructorimpl, this.b.value());
        }
        C3260q4.d().a(m10244exceptionOrNullimpl);
        if (m10244exceptionOrNullimpl instanceof IllegalArgumentException) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(new C2990a8(C3362w5.f3920a.d())));
        }
        Result.Companion companion4 = Result.INSTANCE;
        return Result.m10241constructorimpl(ResultKt.createFailure(new C2990a8(C3362w5.f3920a.h())));
    }
}
