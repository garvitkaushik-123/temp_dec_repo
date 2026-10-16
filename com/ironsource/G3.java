package com.ironsource;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class G3 implements InterfaceC3212n7 {

    /* renamed from: a, reason: collision with root package name */
    private final Boolean f2879a;
    private final Integer b;
    private final O3 c;

    public G3(Boolean bool, Integer num, O3 o3) {
        this.f2879a = bool;
        this.b = num;
        this.c = o3;
    }

    private final Object a(O3 o3) {
        return new H3(this.f2879a, this.b, o3).a();
    }

    @Override // com.ironsource.InterfaceC3212n7
    public Object b() {
        O3 o3 = O3.Second;
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a(o3));
        if (m10244exceptionOrNullimpl != null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
        }
        Gc gc = (!Intrinsics.areEqual(this.f2879a, Boolean.TRUE) || this.b == null) ? null : new Gc(o3.a(this.b), null, 2, null);
        Result.Companion companion2 = Result.INSTANCE;
        return Result.m10241constructorimpl(gc);
    }

    @Override // com.ironsource.InterfaceC3212n7
    public Object c() {
        Re re;
        Integer num;
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a(this.c));
        if (m10244exceptionOrNullimpl != null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
        }
        if (Intrinsics.areEqual(this.f2879a, Boolean.TRUE) && (num = this.b) != null) {
            int intValue = num.intValue();
            O3 o3 = this.c;
            if (o3 != null) {
                re = new Re(intValue, o3);
                Result.Companion companion2 = Result.INSTANCE;
                return Result.m10241constructorimpl(re);
            }
        }
        re = null;
        Result.Companion companion22 = Result.INSTANCE;
        return Result.m10241constructorimpl(re);
    }

    public final Boolean d() {
        return this.f2879a;
    }

    public final Integer e() {
        return this.b;
    }

    public final O3 f() {
        return this.c;
    }

    @Override // com.ironsource.InterfaceC3212n7
    public Object a() {
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(new P4(this.f2879a).a());
        if (m10244exceptionOrNullimpl != null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m10241constructorimpl(ResultKt.createFailure(m10244exceptionOrNullimpl));
        }
        Result.Companion companion2 = Result.INSTANCE;
        Boolean bool = this.f2879a;
        return Result.m10241constructorimpl(bool != null ? new O4(bool.booleanValue()) : null);
    }

    public /* synthetic */ G3(Boolean bool, Integer num, O3 o3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bool, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : o3);
    }
}
