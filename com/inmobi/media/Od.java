package com.inmobi.media;

import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Od extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Od f2387a = new Od();

    public Od() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        C2607d2 it = (C2607d2) obj;
        Intrinsics.checkNotNullParameter(it, "it");
        int i = it.f2542a;
        if (i != 1 && i != 2) {
            switch (i) {
                case 150:
                    Xd xd = Pd.i;
                    if (xd != null) {
                        Map map = it.c;
                        Object obj2 = map != null ? map.get("data") : null;
                        xd.a("CrashEventOccurred", obj2 instanceof C2757m3 ? (C2757m3) obj2 : null);
                        break;
                    }
                    break;
                case 151:
                    Xd xd2 = Pd.i;
                    if (xd2 != null) {
                        Map map2 = it.c;
                        Object obj3 = map2 != null ? map2.get("data") : null;
                        mf mfVar = obj3 instanceof mf ? (mf) obj3 : null;
                        if (mfVar != null && Ie.a(mfVar) && !L3.f2348a.z()) {
                            xd2.a("MainThreadBlockedEvent", mfVar);
                            break;
                        }
                    }
                    break;
                case 152:
                    Xd xd3 = Pd.i;
                    if (xd3 != null) {
                        Map map3 = it.c;
                        Object obj4 = map3 != null ? map3.get("data") : null;
                        xd3.a(obj4 instanceof C2606d1 ? (C2606d1) obj4 : null);
                        break;
                    }
                    break;
                default:
                    Pd pd = Pd.f2401a;
                    break;
            }
        } else {
            Pd.d.set(false);
            C2871t4 c2871t4 = Pd.f;
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
            Pd.f = null;
            Pd.i = null;
            Uc.f().a(Pd.h);
        }
        return Unit.INSTANCE;
    }
}
