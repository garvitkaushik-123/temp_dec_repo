package com.ironsource;

import android.util.Log;
import com.ironsource.Md;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.ironsource.v8, reason: case insensitive filesystem */
/* loaded from: classes6.dex */
public class C3348v8 {
    private static C3348v8 b;

    /* renamed from: a, reason: collision with root package name */
    private L5 f3911a;

    private C3348v8() {
    }

    private static C3348v8 a() {
        if (b == null) {
            b = new C3348v8();
        }
        return b;
    }

    public static void a(F5 f5, C3314t8 c3314t8) {
        if (f5 != null) {
            try {
                a().f3911a = new L5(f5, c3314t8);
            } catch (Exception e) {
                C3260q4.d().a(e);
                IronLog.INTERNAL.error(e.toString());
            }
        }
    }

    public static void a(Md.a aVar) {
        a(aVar, new HashMap());
    }

    public static void a(Md.a aVar, Map<String, Object> map) {
        L5 l5 = a().f3911a;
        if (l5 == null) {
            Log.d(D5.f2825a, D5.U);
            return;
        }
        if (map != null) {
            map.put("eventid", Integer.valueOf(aVar.b));
        }
        l5.a(aVar.f2954a, map);
    }
}
