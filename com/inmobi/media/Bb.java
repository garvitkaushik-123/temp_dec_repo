package com.inmobi.media;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes4.dex */
public final class Bb extends Lambda implements Function1 {

    /* renamed from: a, reason: collision with root package name */
    public static final Bb f2245a = new Bb();

    public Bb() {
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
                case 151:
                case 152:
                    Map map = it.c;
                    if (map != null && map.containsKey("data")) {
                        Object obj2 = it.c.get("data");
                        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.inmobi.commons.core.incident.IncidentEvent");
                        T5 incident = (T5) obj2;
                        EnumC2560a7 enumC2560a7 = Cb.f2253a;
                        Intrinsics.checkNotNullParameter(incident, "incident");
                        boolean z = incident instanceof C2757m3;
                        if (!z && !(incident instanceof mf)) {
                            if (Cb.e.getAnr().getAppExitReason().getReportToLogs() && (incident instanceof C2606d1)) {
                                new C2559a6(Cb.e.getAnr().getAppExitReason().getIncompleteLogThresholdTime()).a(incident.f2446a, incident.a(), ((C2606d1) incident).g, incident.b);
                                break;
                            }
                        } else {
                            Iterator it2 = D5.a().iterator();
                            while (it2.hasNext()) {
                                Fc fc = (Fc) it2.next();
                                EnumC2560a7 logLevel = EnumC2560a7.c;
                                String message = "TYPE - " + incident.f2446a + ", TIMESTAMP - " + incident.b + ", PAYLOAD - " + incident.a();
                                fc.getClass();
                                Intrinsics.checkNotNullParameter(logLevel, "logLevel");
                                Intrinsics.checkNotNullParameter("LOGGER CRASH", "tag");
                                Intrinsics.checkNotNullParameter(message, "message");
                                fc.f2286a.a(logLevel, "LOGGER CRASH", message);
                                if (z) {
                                    fc.f2286a.b();
                                }
                            }
                            break;
                        }
                    }
                    break;
            }
        } else {
            EnumC2560a7 enumC2560a72 = Cb.f2253a;
            Iterator it3 = D5.a().iterator();
            while (it3.hasNext()) {
                Fc fc2 = (Fc) it3.next();
                EnumC2560a7 logLevel2 = EnumC2560a7.c;
                String message2 = "SYSTEM SHUTDOWN RECEIVED - " + i;
                fc2.getClass();
                Intrinsics.checkNotNullParameter(logLevel2, "logLevel");
                Intrinsics.checkNotNullParameter("LOGGER CRASH", "tag");
                Intrinsics.checkNotNullParameter(message2, "message");
                fc2.f2286a.a(logLevel2, "LOGGER CRASH", message2);
                fc2.f2286a.b();
            }
            AtomicBoolean atomicBoolean = Cb.c;
            atomicBoolean.set(false);
            H7 f = Uc.f();
            Bb bb = Cb.g;
            f.a(bb);
            Cb.b = null;
            EnumC2560a7 enumC2560a73 = Cb.f2253a;
            atomicBoolean.set(false);
            Uc.f().a(bb);
            Cb.b = null;
        }
        return Unit.INSTANCE;
    }
}
