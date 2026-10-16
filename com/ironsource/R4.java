package com.ironsource;

import com.ironsource.InterfaceC3246p7;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class R4 implements InterfaceC3246p7, InterfaceC3246p7.a {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<String, O4> f3022a = new ConcurrentHashMap<>();

    @Override // com.ironsource.InterfaceC3246p7
    public N3 a(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        O4 o4 = this.f3022a.get(identifier);
        return (o4 == null || o4.a()) ? new N3(false, null, 2, null) : new N3(true, P3.Delivery);
    }

    @Override // com.ironsource.InterfaceC3246p7.a
    public void b(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
    }

    @Override // com.ironsource.InterfaceC3246p7.a
    public Object a(String identifier, P3 cappingType, InterfaceC3212n7 cappingConfig) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(cappingType, "cappingType");
        Intrinsics.checkNotNullParameter(cappingConfig, "cappingConfig");
        Object a2 = cappingConfig.a();
        if (Result.m10248isSuccessimpl(a2)) {
            O4 o4 = (O4) a2;
            if (o4 != null) {
                this.f3022a.put(identifier, o4);
            }
            Result.Companion companion = Result.INSTANCE;
            return Result.m10241constructorimpl(Unit.INSTANCE);
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a2);
        if (m10244exceptionOrNullimpl != null) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
        }
        Result.Companion companion3 = Result.INSTANCE;
        return Result.m10241constructorimpl(Unit.INSTANCE);
    }
}
