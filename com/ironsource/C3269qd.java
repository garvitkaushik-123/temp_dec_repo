package com.ironsource;

import com.ironsource.C3288s;
import com.ironsource.O7;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: com.ironsource.qd, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public final class C3269qd {

    /* renamed from: a, reason: collision with root package name */
    private final C3047db f3658a;
    private final Map<String, C3288s.d> b;
    private final Map<String, C3288s.d> c;

    public C3269qd(C3047db tools, Map<String, C3288s.d> map, Map<String, C3288s.d> map2) {
        Intrinsics.checkNotNullParameter(tools, "tools");
        this.f3658a = tools;
        this.b = map;
        this.c = map2;
    }

    private final void b(O7.a aVar, String str, String str2, Integer num) {
        Object a2 = a(str2, num);
        if (Result.m10248isSuccessimpl(a2)) {
            Intrinsics.checkNotNull(str2);
            Intrinsics.checkNotNull(num);
            aVar.a(str, str2, num.intValue());
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a2);
        if (m10244exceptionOrNullimpl != null) {
            this.f3658a.b(str, 3004, m10244exceptionOrNullimpl.getMessage());
        }
    }

    public final void a(O7.a rewardService) {
        Intrinsics.checkNotNullParameter(rewardService, "rewardService");
        Map<String, C3288s.d> map = this.c;
        if (map != null && (r0 = map.entrySet().iterator()) != null) {
            for (Map.Entry<String, C3288s.d> entry : map.entrySet()) {
                String key = entry.getKey();
                C3235od f = entry.getValue().f();
                if (f != null) {
                    b(rewardService, key, f.b(), f.a());
                }
            }
        }
        Map<String, C3288s.d> map2 = this.b;
        if (map2 == null || (r0 = map2.entrySet().iterator()) == null) {
            return;
        }
        for (Map.Entry<String, C3288s.d> entry2 : map2.entrySet()) {
            String key2 = entry2.getKey();
            C3235od a2 = entry2.getValue().a();
            if (a2 != null) {
                a(rewardService, key2, a2.b(), a2.a());
            }
        }
    }

    private final void a(O7.a aVar, String str, String str2, Integer num) {
        Object a2 = a(str2, num);
        if (Result.m10248isSuccessimpl(a2)) {
            Intrinsics.checkNotNull(str2);
            Intrinsics.checkNotNull(num);
            aVar.b(str, str2, num.intValue());
        }
        Throwable m10244exceptionOrNullimpl = Result.m10244exceptionOrNullimpl(a2);
        if (m10244exceptionOrNullimpl != null) {
            this.f3658a.b(str, 3004, m10244exceptionOrNullimpl.getMessage());
        }
    }

    private final Object a(String str, Integer num) {
        if (str != null && num != null) {
            Result.Companion companion = Result.INSTANCE;
            return Result.m10241constructorimpl(Unit.INSTANCE);
        }
        Result.Companion companion2 = Result.INSTANCE;
        return Result.m10241constructorimpl(ResultKt.createFailure(new Exception("name - " + str + " or amount - " + num + " is not provided or invalid")));
    }
}
