package com.inmobi.media;

import com.google.android.gms.measurement.AppMeasurement;
import com.inmobi.commons.core.configs.CrashConfig;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class E6 implements InterfaceC2909va {

    /* renamed from: a, reason: collision with root package name */
    public CrashConfig f2272a;
    public C2871t4 b;
    public final U5 c;
    public final D6 d;

    public E6(CrashConfig crashConfig) {
        Intrinsics.checkNotNullParameter(crashConfig, "crashConfig");
        this.f2272a = crashConfig;
        this.c = new U5(crashConfig);
        this.d = new D6(this);
    }

    public final void a(T5 t5) {
        R5 c = Nc.c();
        long eventTTL = this.f2272a.getEventTTL();
        c.getClass();
        c.a("ts<?", new String[]{String.valueOf(System.currentTimeMillis() - (eventTTL * 1000))});
        Intrinsics.checkNotNullExpressionValue("r4", "TAG");
        R5 c2 = Nc.c();
        c2.getClass();
        int a2 = (T1.a(c2, null, null, 63) + 1) - this.f2272a.getMaxEventsToPersist();
        if (a2 > 0) {
            Nc.c().a(a2);
        }
        Nc.c().a(t5);
    }

    public final void b(T5 incident) {
        Intrinsics.checkNotNullParameter(incident, "incident");
        if (Ie.a(incident)) {
            CrashConfig.ANRConfig anr = this.f2272a.getAnr();
            if ((incident instanceof C2606d1) && L3.f2348a.z() && anr.getAppExitReason().getUseForReporting() && this.c.d.a()) {
                Intrinsics.checkNotNullParameter("ANREvent", "<set-?>");
                incident.f2446a = "ANREvent";
                a(incident);
            } else if ((incident instanceof mf) && anr.getWatchdog().getUseForReporting() && this.c.c.a()) {
                a(incident);
            } else {
                if (!(incident instanceof C2757m3)) {
                    return;
                }
                if (this.f2272a.getCrashConfig().getEnabled() && this.c.f2449a.a()) {
                    a(incident);
                }
            }
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.E6$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    E6.b(E6.this);
                }
            };
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            Ie.f2319a.execute(runnable);
        }
    }

    public final void c() {
        Runnable runnable = new Runnable() { // from class: com.inmobi.media.E6$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                E6.a(E6.this);
            }
        };
        ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        Ie.f2319a.execute(runnable);
        Uc.f().a(new int[]{2, 1, 152, 150, 151}, this.d);
    }

    public static final void a(E6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b = new C2871t4(Nc.c(), this$0, this$0.f2272a.getEventConfig(), null);
        R5 c = Nc.c();
        c.getClass();
        if (T1.a(c, null, null, 63) > 0) {
            this$0.b();
        }
    }

    public final void a(final C2640f2 incident) {
        Intrinsics.checkNotNullParameter(incident, "incident");
        if (this.f2272a.getCatchConfig().getEnabled() && this.c.b.a()) {
            Runnable runnable = new Runnable() { // from class: com.inmobi.media.E6$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    E6.a(E6.this, incident);
                }
            };
            ScheduledExecutorService scheduledExecutorService = Ie.f2319a;
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            Ie.f2319a.execute(runnable);
        }
    }

    public static final void a(E6 this$0, C2640f2 incident) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(incident, "$incident");
        this$0.a((T5) incident);
        this$0.b();
    }

    @Override // com.inmobi.media.InterfaceC2909va
    public final C2854s4 a() {
        int a2;
        String str;
        int p = L3.f2348a.p();
        int i = 1;
        if (p == 0) {
            a2 = this.f2272a.getMobileConfig().a();
        } else if (p != 1) {
            a2 = this.f2272a.getMobileConfig().a();
        } else {
            a2 = this.f2272a.getWifiConfig().a();
        }
        ArrayList b = Nc.c().b(a2);
        if (b.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = b.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((T5) it.next()).c));
        }
        try {
            HashMap hashMap = new HashMap(L3.f2348a.a(false));
            hashMap.put("im-accid", Uc.b());
            hashMap.put("version", "2.0.0");
            hashMap.put("component", AppMeasurement.CRASH_ORIGIN);
            hashMap.put("mk-version", Vc.a());
            hashMap.putAll(C2623e1.e);
            hashMap.put("tp", Vc.d());
            String f = Vc.f();
            if (f == null) {
                f = "";
            }
            hashMap.put("tpVer", f);
            JSONObject jSONObject = new JSONObject(hashMap);
            JSONArray jSONArray = new JSONArray();
            Iterator it2 = b.iterator();
            while (it2.hasNext()) {
                T5 t5 = (T5) it2.next();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("eventId", t5.e);
                jSONObject2.put("eventType", t5.f2446a);
                String a3 = t5.a();
                int length = a3.length() - i;
                int i2 = 0;
                boolean z = false;
                while (i2 <= length) {
                    boolean z2 = Intrinsics.compare((int) a3.charAt(!z ? i2 : length), 32) <= 0;
                    if (z) {
                        if (!z2) {
                            break;
                        }
                        length--;
                    } else if (z2) {
                        i2++;
                    } else {
                        z = true;
                    }
                }
                if (a3.subSequence(i2, length + 1).toString().length() > 0) {
                    jSONObject2.put("crash_report", t5.a());
                }
                jSONObject2.put("ts", t5.b);
                jSONArray.put(jSONObject2);
                i = 1;
            }
            jSONObject.put(AppMeasurement.CRASH_ORIGIN, jSONArray);
            str = jSONObject.toString();
        } catch (JSONException unused) {
            str = null;
        }
        if (str != null) {
            return new C2854s4(arrayList, str);
        }
        return null;
    }

    public static final void b(E6 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.b();
    }

    public final void b() {
        Unit unit;
        C2823q4 eventConfig = this.f2272a.getEventConfig();
        eventConfig.k = this.f2272a.getUrl();
        C2871t4 c2871t4 = this.b;
        if (c2871t4 != null) {
            Intrinsics.checkNotNullParameter(eventConfig, "eventConfig");
            c2871t4.i = eventConfig;
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.b = new C2871t4(Nc.c(), this, eventConfig, null);
        }
        C2871t4 c2871t42 = this.b;
        if (c2871t42 != null) {
            C2823q4 c2823q4 = c2871t42.i;
            if (c2871t42.f.get() || c2823q4 == null) {
                return;
            }
            c2871t42.a(c2823q4.c, false);
        }
    }
}
