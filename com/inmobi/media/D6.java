package com.inmobi.media;

import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class D6 extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ E6 f2260a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public D6(E6 e6) {
        super(1);
        this.f2260a = e6;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C2607d2 it = (C2607d2) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        int i = it.f2542a;
        if (i != 1 && i != 2) {
            switch (i) {
                case 150:
                case 151:
                case 152:
                    Map map = it.c;
                    if (map != null && map.containsKey("data")) {
                        Object obj2 = it.c.get("data");
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.inmobi.commons.core.incident.IncidentEvent");
                        this.f2260a.b((T5) obj2);
                        break;
                    }
                    break;
            }
        } else {
            E6 e6 = this.f2260a;
            C2871t4 c2871t4 = e6.b;
            if (c2871t4 != null) {
                ScheduledExecutorService scheduledExecutorService = c2871t4.h;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
                c2871t4.h = null;
                c2871t4.e.set(false);
                c2871t4.f.set(true);
                c2871t4.g.clear();
                c2871t4.i = null;
            }
            e6.b = null;
            Uc.f().a(e6.d);
        }
        return Unit.INSTANCE;
    }
}
