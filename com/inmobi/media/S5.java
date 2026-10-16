package com.inmobi.media;

import android.content.Context;
import com.inmobi.commons.core.configs.Config;
import com.inmobi.commons.core.configs.CrashConfig;
import com.ironsource.C3040d4;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class S5 implements N2 {

    /* renamed from: a, reason: collision with root package name */
    public static final S5 f2425a;
    public static final CrashConfig b;
    public static final H3 c;
    public static final E6 d;

    static {
        S5 s5 = new S5();
        f2425a = s5;
        LinkedHashMap linkedHashMap = O2.f2380a;
        Config a2 = M2.a("crashReporting", Uc.b(), s5);
        Intrinsics.checkNotNull(a2, "null cannot be cast to non-null type com.inmobi.commons.core.configs.CrashConfig");
        CrashConfig crashConfig = (CrashConfig) a2;
        b = crashConfig;
        long currentTimeMillis = System.currentTimeMillis();
        d = new E6(crashConfig);
        Context d2 = Uc.d();
        if (d2 != null) {
            c = new H3(d2, crashConfig, Uc.f());
        }
        if (crashConfig.getCrashConfig().getReportSessionInfo()) {
            C2789o3 type = C2789o3.d;
            Intrinsics.checkNotNullParameter(type, "type");
            C6 a3 = V5.a();
            if (a3 != null) {
                a3.a(type.f2678a, currentTimeMillis, true);
            }
            C6 a4 = V5.a();
            if (a4 != null) {
                C6.a(a4, "s-cnt", 0, false, 4, (Object) null);
            }
        }
        if (AbstractC2632ea.f2562a.getCrashConfig().getReportOOMInfo()) {
            for (AbstractC2822q3 type2 : CollectionsKt.listOf((Object[]) new AbstractC2822q3[]{C2806p3.d, C2773n3.d})) {
                Intrinsics.checkNotNullParameter(type2, "type");
                C6 a5 = V5.a();
                if (a5 != null) {
                    a5.a(type2.f2678a, currentTimeMillis, true);
                }
            }
        }
    }

    public static void a(JSONObject payload, boolean z, long j) {
        Intrinsics.checkNotNullParameter(payload, "payload");
        if (b.getCrashConfig().getReportSessionInfo() && z) {
            C2789o3 crashType = C2789o3.d;
            Intrinsics.checkNotNullParameter(crashType, "crashType");
            C6 a2 = V5.a();
            if (a2 != null) {
                String key = crashType.f2678a;
                Intrinsics.checkNotNullParameter(key, "key");
                long j2 = a2.f2249a.getLong(key, 0L);
                String str = crashType.b;
                if (j2 == 0) {
                    a2.a(str, j, true);
                } else {
                    a2.a(str, j - j2, true);
                }
            }
            payload.put("crashFreeSessionLength", V5.a(crashType));
            C6 a3 = V5.a();
            int i = 0;
            if (a3 != null) {
                Intrinsics.checkNotNullParameter("s-cnt", C3040d4.h.W);
                i = a3.f2249a.getInt("s-cnt", 0);
            }
            payload.put("crashFreeSessionCount", i);
        }
    }

    public final void a() {
        C6 a2;
        if (b.getCrashConfig().getReportSessionInfo() && (a2 = V5.a()) != null) {
            Intrinsics.checkNotNullParameter("s-cnt", C3040d4.h.W);
            C6.a(a2, "s-cnt", a2.f2249a.getInt("s-cnt", 0) + 1, false, 4, (Object) null);
        }
        H3 h3 = c;
        if (h3 != null) {
            Iterator it = h3.c.iterator();
            while (it.hasNext()) {
                ((G3) it.next()).a();
            }
        }
        d.c();
    }

    @Override // com.inmobi.media.N2
    public final void a(Config config) {
        Intrinsics.checkNotNullParameter(config, "config");
        if (config instanceof CrashConfig) {
            E6 e6 = d;
            CrashConfig crashConfig = (CrashConfig) config;
            e6.getClass();
            Intrinsics.checkNotNullParameter(crashConfig, "crashConfig");
            e6.f2272a = crashConfig;
            U5 u5 = e6.c;
            u5.getClass();
            Intrinsics.checkNotNullParameter(crashConfig, "config");
            u5.f2449a.f2400a = crashConfig.getCrashConfig().getSamplingPercent();
            u5.b.f2400a = crashConfig.getCatchConfig().getSamplingPercent();
            u5.c.f2400a = crashConfig.getAnr().getWatchdog().getSamplingPercent();
            u5.d.f2400a = crashConfig.getAnr().getAppExitReason().getSamplingPercent();
            C2871t4 c2871t4 = e6.b;
            if (c2871t4 != null) {
                C2823q4 eventConfig = crashConfig.getEventConfig();
                Intrinsics.checkNotNullParameter(eventConfig, "eventConfig");
                c2871t4.i = eventConfig;
            }
            H3 h3 = c;
            if (h3 != null) {
                Intrinsics.checkNotNullParameter(crashConfig, "crashConfig");
                h3.f2302a = crashConfig;
            }
        }
    }
}
