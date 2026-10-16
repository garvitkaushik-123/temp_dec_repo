package com.mbridge.msdk.mbbanner.common.manager;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.l;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: BannerLoadManager.java */
/* loaded from: classes6.dex */
public class a {
    private static final String g = "a";
    private static volatile a h;

    /* renamed from: a, reason: collision with root package name */
    private Context f4447a = com.mbridge.msdk.foundation.controller.c.m().d();
    private com.mbridge.msdk.mbbanner.common.util.a b = new com.mbridge.msdk.mbbanner.common.util.a();
    private Map<String, com.mbridge.msdk.mbbanner.common.data.b> c = new ConcurrentHashMap();
    private Map<String, Boolean> d = new ConcurrentHashMap();
    private Map<String, Handler> e = new ConcurrentHashMap();
    private Map<String, Integer> f = new ConcurrentHashMap();

    /* compiled from: BannerLoadManager.java */
    /* renamed from: com.mbridge.msdk.mbbanner.common.manager.a$a, reason: collision with other inner class name */
    class C0347a implements com.mbridge.msdk.mbbanner.common.listener.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.data.a f4448a;

        C0347a(com.mbridge.msdk.mbbanner.common.data.a aVar) {
            this.f4448a = aVar;
        }

        @Override // com.mbridge.msdk.mbbanner.common.listener.d
        public void a(String str) {
            synchronized (a.b()) {
                this.f4448a.a("");
                a.this.d.put(str, Boolean.FALSE);
            }
        }
    }

    /* compiled from: BannerLoadManager.java */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4449a;
        final /* synthetic */ MBridgeIds b;
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b c;
        final /* synthetic */ String d;
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.data.a e;

        b(String str, MBridgeIds mBridgeIds, com.mbridge.msdk.mbbanner.common.listener.b bVar, String str2, com.mbridge.msdk.mbbanner.common.data.a aVar) {
            this.f4449a = str;
            this.b = mBridgeIds;
            this.c = bVar;
            this.d = str2;
            this.e = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Boolean bool;
            if (a.this.d == null || !a.this.d.containsKey(this.f4449a) || (bool = (Boolean) a.this.d.get(this.f4449a)) == null || !bool.booleanValue()) {
                if (a.this.f.containsKey(this.f4449a)) {
                    Integer num = (Integer) a.this.f.get(this.f4449a);
                    int intValue = num != null ? num.intValue() : 0;
                    if (intValue == 2 || intValue == 4) {
                        p0.b(a.g, "doUnitRotation: autoRotationStatus=" + intValue + " && unitId=" + this.f4449a);
                        if (a.this.b != null) {
                            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880026);
                            bVar.a(this.b);
                            a.this.b.a(this.c, bVar);
                            return;
                        }
                        return;
                    }
                }
                a.this.b(this.d, this.f4449a, this.e, this.c);
            }
        }
    }

    private a() {
    }

    public static a b() {
        if (h == null) {
            synchronized (a.class) {
                if (h == null) {
                    h = new a();
                }
            }
        }
        return h;
    }

    public void c() {
        Map<String, com.mbridge.msdk.mbbanner.common.data.b> map = this.c;
        if (map != null) {
            map.clear();
        }
        Map<String, Boolean> map2 = this.d;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, Handler> map3 = this.e;
        if (map3 != null) {
            for (Map.Entry<String, Handler> entry : map3.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().removeCallbacksAndMessages(null);
                }
            }
            this.e.clear();
        }
        Map<String, Integer> map4 = this.f;
        if (map4 != null) {
            map4.clear();
        }
    }

    private com.mbridge.msdk.mbbanner.common.data.b a(String str) {
        if (this.c.containsKey(str)) {
            return this.c.get(str);
        }
        l e = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), str);
        if (e == null) {
            e = l.i(str);
        }
        com.mbridge.msdk.mbbanner.common.data.b bVar = new com.mbridge.msdk.mbbanner.common.data.b(str, "", 0, e.y());
        this.c.put(str, bVar);
        return bVar;
    }

    public void b(String str, String str2, com.mbridge.msdk.mbbanner.common.data.a aVar, com.mbridge.msdk.mbbanner.common.listener.b bVar) {
        Boolean bool;
        MBridgeIds mBridgeIds = new MBridgeIds(str, str2);
        String b2 = aVar.b();
        com.mbridge.msdk.foundation.same.report.metrics.c a2 = com.mbridge.msdk.mbbanner.common.report.a.a(str2, b2);
        a2.h(!TextUtils.isEmpty(aVar.a()) ? "1" : "0");
        a2.g(aVar.a());
        a2.f(aVar.f() ? "1" : "2");
        a2.b(aVar.f() ? 1 : 2);
        a2.c(aVar.d());
        com.mbridge.msdk.mbbanner.common.report.a.a("2000123", a2, (e) null);
        if (this.f4447a == null) {
            com.mbridge.msdk.foundation.error.b bVar2 = new com.mbridge.msdk.foundation.error.b(880025);
            bVar2.a(mBridgeIds);
            bVar2.b(b2);
            this.b.a(bVar, bVar2);
            return;
        }
        if (bVar == null) {
            com.mbridge.msdk.foundation.error.b bVar3 = new com.mbridge.msdk.foundation.error.b(880001);
            bVar3.a(mBridgeIds);
            bVar3.b(b2);
            this.b.a(bVar, bVar3);
            return;
        }
        Map<String, Boolean> map = this.d;
        if (map != null && map.containsKey(str2) && (bool = this.d.get(str2)) != null && bool.booleanValue()) {
            com.mbridge.msdk.foundation.error.b bVar4 = new com.mbridge.msdk.foundation.error.b(880016, "Current unit is loading!");
            bVar4.a(mBridgeIds);
            bVar4.b(b2);
            this.b.a(bVar, bVar4);
            return;
        }
        this.d.put(str2, Boolean.TRUE);
        com.mbridge.msdk.mbbanner.common.data.b a3 = a(str2);
        a3.a(b2);
        new com.mbridge.msdk.mbbanner.common.manager.b(this.f4447a, a3, bVar, this.b).a(str, str2, aVar, new C0347a(aVar));
        com.mbridge.msdk.mbbanner.common.report.a.a("2000125", a2, (e) null);
    }

    public void a(String str, String str2, com.mbridge.msdk.mbbanner.common.data.a aVar, com.mbridge.msdk.mbbanner.common.listener.b bVar) {
        Handler handler;
        MBridgeIds mBridgeIds = new MBridgeIds(str, str2);
        if (aVar != null && aVar.d() > 0) {
            if (TextUtils.isEmpty(aVar.b())) {
                aVar.b(com.mbridge.msdk.mbbanner.common.report.a.b(""));
            }
            if (this.e.containsKey(str2)) {
                handler = this.e.get(str2);
            } else {
                handler = new Handler();
                this.e.put(str2, handler);
            }
            Handler handler2 = handler;
            b bVar2 = new b(str2, mBridgeIds, bVar, str, aVar);
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages(null);
                handler2.postDelayed(bVar2, aVar.d());
                return;
            }
            return;
        }
        p0.b(g, "doUnitRotation: Illegal banner request parameters! && unitId=" + str2);
    }

    public void a(int i, String str, String str2, com.mbridge.msdk.mbbanner.common.data.a aVar, com.mbridge.msdk.mbbanner.common.listener.b bVar) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Integer num;
        int intValue = (!this.f.containsKey(str2) || (num = this.f.get(str2)) == null) ? 0 : num.intValue();
        if (i == 1) {
            if (this.e.containsKey(str2) && (handler = this.e.get(str2)) != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f.put(str2, Integer.valueOf(i));
            return;
        }
        if (i == 2) {
            if (intValue == 1) {
                if (this.e.containsKey(str2) && (handler2 = this.e.get(str2)) != null) {
                    handler2.removeCallbacksAndMessages(null);
                }
                this.f.put(str2, Integer.valueOf(i));
                return;
            }
            return;
        }
        if (i == 3) {
            if (intValue == 2 || intValue == 4) {
                this.f.put(str2, 1);
                a(str, str2, aVar, bVar);
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        if (intValue == 0) {
            this.f.put(str2, 0);
            return;
        }
        if (this.e.containsKey(str2) && (handler3 = this.e.get(str2)) != null) {
            handler3.removeCallbacksAndMessages(null);
        }
        this.f.put(str2, Integer.valueOf(i));
    }

    public void b(String str) {
        if (this.e.containsKey(str)) {
            Handler handler = this.e.get(str);
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.e.remove(str);
        }
    }
}
