package com.ironsource;

import com.ironsource.InterfaceC3246p7;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class Hc implements InterfaceC3246p7, InterfaceC3246p7.a {

    /* renamed from: a, reason: collision with root package name */
    private final InterfaceC3293s4 f2900a;
    private final I7 b;
    private final Map<String, Gc> c;

    public Hc(InterfaceC3293s4 currentTimeProvider, I7 repository) {
        Intrinsics.checkNotNullParameter(currentTimeProvider, "currentTimeProvider");
        Intrinsics.checkNotNullParameter(repository, "repository");
        this.f2900a = currentTimeProvider;
        this.b = repository;
        this.c = new LinkedHashMap();
    }

    public final Map<String, Gc> a() {
        return this.c;
    }

    @Override // com.ironsource.InterfaceC3246p7.a
    public void b(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        if (this.c.get(identifier) == null) {
            return;
        }
        this.b.a(this.f2900a.a(), identifier);
    }

    private final boolean a(Gc gc, String str) {
        Long a2 = this.b.a(str);
        return a2 != null && this.f2900a.a() - a2.longValue() < gc.a();
    }

    @Override // com.ironsource.InterfaceC3246p7
    public N3 a(String identifier) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Gc gc = this.c.get(identifier);
        if (gc == null) {
            return new N3(false, null, 2, null);
        }
        if (a(gc, identifier)) {
            return new N3(true, P3.Pacing);
        }
        return new N3(false, null, 2, null);
    }

    @Override // com.ironsource.InterfaceC3246p7.a
    public Object a(String identifier, P3 cappingType, InterfaceC3212n7 cappingConfig) {
        Intrinsics.checkNotNullParameter(identifier, "identifier");
        Intrinsics.checkNotNullParameter(cappingType, "cappingType");
        Intrinsics.checkNotNullParameter(cappingConfig, "cappingConfig");
        Object b = cappingConfig.b();
        if (Result.m10248isSuccessimpl(b)) {
            Gc gc = (Gc) b;
            if (gc != null) {
                this.c.put(identifier, gc);
            }
            Result.Companion companion = Result.INSTANCE;
            return Result.m10241constructorimpl(Unit.INSTANCE);
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(b);
        if (m10244exceptionOrNullimpl != null) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
        }
        Result.Companion companion3 = Result.INSTANCE;
        return Result.m10241constructorimpl(Unit.INSTANCE);
    }
}
