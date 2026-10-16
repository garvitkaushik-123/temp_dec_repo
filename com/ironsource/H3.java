package com.ironsource;

import kotlin.Result;
import kotlin.ResultKt;

/* loaded from: classes6.dex */
public final class H3 implements InterfaceC3229o7 {

    /* renamed from: a, reason: collision with root package name */
    private final Boolean f2893a;
    private final Integer b;
    private final O3 c;

    public H3(Boolean bool, Integer num, O3 o3) {
        this.f2893a = bool;
        this.b = num;
        this.c = o3;
    }

    @Override // com.ironsource.InterfaceC3229o7
    public Object a() {
        Boolean bool = this.f2893a;
        if (bool == null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(new Exception("enabled flag is not provided or invalid")));
        }
        if (!bool.booleanValue()) {
            Result.Companion companion2 = Result.INSTANCE;
            return Result.m10241constructorimpl(Boolean.FALSE);
        }
        Integer num = this.b;
        if (num == null || num.intValue() <= 0) {
            Result.Companion companion3 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(new Exception("limit flag is not provided or invalid")));
        }
        if (this.c == null) {
            Result.Companion companion4 = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(new Exception("unit flag is not provided or invalid")));
        }
        Result.Companion companion5 = Result.INSTANCE;
        return Result.m10241constructorimpl(Boolean.TRUE);
    }
}
