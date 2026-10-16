package com.ironsource;

import kotlin.Result;
import kotlin.ResultKt;

/* loaded from: classes6.dex */
public final class P4 implements InterfaceC3229o7 {

    /* renamed from: a, reason: collision with root package name */
    private final Boolean f2990a;

    public P4(Boolean bool) {
        this.f2990a = bool;
    }

    @Override // com.ironsource.InterfaceC3229o7
    public Object a() {
        Boolean bool = this.f2990a;
        if (bool == null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(new Exception("enabled flag is not provided or invalid")));
        }
        Result.Companion companion2 = Result.INSTANCE;
        return Result.m10241constructorimpl(bool);
    }
}
