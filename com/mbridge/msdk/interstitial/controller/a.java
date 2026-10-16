package com.mbridge.msdk.interstitial.controller;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.interstitial.view.MBInterstitialActivity;
import com.mbridge.msdk.out.InterstitialListener;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.j;
import com.mbridge.msdk.setting.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: InterstitialController.java */
/* loaded from: classes6.dex */
public class a {
    public static String o;
    public static Map<String, Integer> p = new HashMap();
    public static Map<String, Integer> q = new HashMap();
    public static Map<String, d> r = new HashMap();
    private Context b;
    private String c;
    private String d;
    private String e;
    private MBridgeIds f;
    private Handler g;
    private l h;
    private InterstitialListener i;

    /* renamed from: a, reason: collision with root package name */
    private String f4410a = "InterstitialController";
    public boolean j = false;
    private String k = "";
    private String l = "";
    private String m = "";
    private boolean n = false;

    /* compiled from: InterstitialController.java */
    /* renamed from: com.mbridge.msdk.interstitial.controller.a$a, reason: collision with other inner class name */
    class HandlerC0346a extends Handler {
        HandlerC0346a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message == null) {
                return;
            }
            int i = message.what;
            if (i == 1) {
                if (a.this.i != null) {
                    a.this.i.onInterstitialLoadSuccess(a.this.f);
                    return;
                }
                return;
            }
            String str = "";
            if (i == 2) {
                if (a.this.i != null) {
                    Object obj = message.obj;
                    if (obj != null && (obj instanceof String)) {
                        str = (String) obj;
                    }
                    a.this.i.onInterstitialLoadFail(a.this.f, TextUtils.isEmpty(str) ? "can't show because unknow error" : str);
                    return;
                }
                return;
            }
            if (i == 3) {
                a aVar = a.this;
                aVar.j = true;
                if (aVar.i != null) {
                    a.this.i.onInterstitialShowSuccess(a.this.f);
                    return;
                }
                return;
            }
            if (i == 4) {
                if (a.this.i != null) {
                    Object obj2 = message.obj;
                    if (obj2 != null && (obj2 instanceof String)) {
                        str = (String) obj2;
                    }
                    a.this.i.onInterstitialShowFail(a.this.f, TextUtils.isEmpty(str) ? "can't show because unknow error" : str);
                    return;
                }
                return;
            }
            if (i == 6) {
                if (a.this.i != null) {
                    a.this.i.onInterstitialAdClick(a.this.f);
                }
            } else {
                if (i != 7) {
                    return;
                }
                a aVar2 = a.this;
                aVar2.j = false;
                if (aVar2.i != null) {
                    a.this.i.onInterstitialClosed(a.this.f);
                }
            }
        }
    }

    /* compiled from: InterstitialController.java */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.interstitial.adapter.a f4412a;
        private c b;

        public b(com.mbridge.msdk.interstitial.adapter.a aVar, c cVar) {
            this.f4412a = aVar;
            this.b = cVar;
        }

        public void a(boolean z, String str) {
            try {
                com.mbridge.msdk.interstitial.adapter.a aVar = this.f4412a;
                if (aVar != null) {
                    aVar.a((b) null);
                    this.f4412a = null;
                }
                if (this.b != null) {
                    if (a.this.g != null) {
                        a.this.g.removeCallbacks(this.b);
                    }
                    if (z) {
                        if (a.this.i != null) {
                            a.this.c(str);
                        }
                    } else if (a.this.i != null) {
                        a.this.b(str);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void b(boolean z, String str) {
            try {
                a.this.k = str;
                try {
                    ArrayList arrayList = new ArrayList();
                    com.mbridge.msdk.interstitial.adapter.a aVar = this.f4412a;
                    if (aVar != null && aVar.d() != null) {
                        arrayList.add(this.f4412a.d());
                    }
                    a.this.l = com.mbridge.msdk.foundation.same.c.b(arrayList);
                } catch (Exception e) {
                    p0.b(a.this.f4410a, e.getMessage());
                }
                if (this.b != null) {
                    if (a.this.g != null) {
                        a.this.g.removeCallbacks(this.b);
                    }
                    if (z) {
                        a.this.b(false);
                    } else if (a.this.i != null) {
                        a.this.h();
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* compiled from: InterstitialController.java */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.interstitial.adapter.a f4413a;

        public c(com.mbridge.msdk.interstitial.adapter.a aVar) {
            this.f4413a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.interstitial.adapter.a aVar = this.f4413a;
                if (aVar != null) {
                    if (aVar.f()) {
                        a.this.c("load timeout");
                    } else if (a.this.i != null) {
                        a.this.b("load timeout");
                    }
                    this.f4413a.a((b) null);
                    this.f4413a = null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public a() {
        try {
            c();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        Handler handler = this.g;
        if (handler != null) {
            handler.sendEmptyMessage(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        Handler handler = this.g;
        if (handler != null) {
            handler.sendEmptyMessage(3);
        }
    }

    public void g() {
        try {
            new j().a(this.b, (String) null, (String) null, this.c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void j() {
        try {
            if (this.b == null) {
                c("context is null");
                return;
            }
            if (TextUtils.isEmpty(this.c)) {
                c("unitid is null");
            } else if (!this.n) {
                c("init error");
            } else {
                e();
                b(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
            c("can't show because unknow error");
        }
    }

    private void e() {
        try {
            g();
            l e = h.b().e(com.mbridge.msdk.foundation.controller.c.m().b(), this.c);
            this.h = e;
            if (e == null) {
                this.h = l.h(this.c);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void f() {
        try {
            if (this.b == null) {
                b("context is null");
                return;
            }
            if (TextUtils.isEmpty(this.c)) {
                b("unitid is null");
            } else {
                if (!this.n) {
                    b("init error");
                    return;
                }
                e();
                d();
                a(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            b("can't show because unknow error");
        }
    }

    /* compiled from: InterstitialController.java */
    public class d {
        public d() {
        }

        public void a(String str) {
            try {
                a.this.c(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void b() {
            try {
                if (a.this.g != null) {
                    a.this.g.sendEmptyMessage(7);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void c() {
            try {
                a.this.i();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void a() {
            try {
                if (a.this.g != null) {
                    a.this.g.sendEmptyMessage(6);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void c() {
        try {
            this.g = new HandlerC0346a(Looper.getMainLooper());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void d() {
        try {
            l lVar = this.h;
            if (lVar != null) {
                int e = lVar.e();
                int y = this.h.y();
                if (e <= 0) {
                    e = 1;
                }
                if (y <= 0) {
                    y = 1;
                }
                int i = y * e;
                if (q == null || TextUtils.isEmpty(this.c)) {
                    return;
                }
                q.put(this.c, Integer.valueOf(i));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String b() {
        if (this.j) {
            return this.m;
        }
        return this.k;
    }

    public static void a(String str, int i) {
        try {
            if (p == null || TextUtils.isEmpty(str)) {
                return;
            }
            p.put(str, Integer.valueOf(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        try {
            CampaignEx d2 = new com.mbridge.msdk.interstitial.adapter.a(this.b, this.c, this.d, this.e, true).d();
            if (d2 != null) {
                a(d2);
            } else if (z) {
                a(true);
            } else {
                c("no ads available can show");
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (this.i != null) {
                c("can't show because unknow error");
            }
        }
    }

    public static int a(String str) {
        Map<String, Integer> map;
        Integer num;
        try {
            if (TextUtils.isEmpty(str) || (map = p) == null || !map.containsKey(str) || (num = p.get(str)) == null) {
                return 0;
            }
            return num.intValue();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void a(InterstitialListener interstitialListener) {
        this.i = interstitialListener;
    }

    public boolean a(Context context, Map<String, Object> map) {
        try {
            this.n = false;
        } catch (Exception e) {
            e.printStackTrace();
            this.n = false;
        }
        if (map != null && context != null && map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID) && (map.get(MBridgeConstans.PROPERTIES_UNIT_ID) instanceof String)) {
            if (map.containsKey(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY) && (map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY) instanceof String)) {
                this.e = (String) map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY);
            }
            this.c = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
            this.b = context;
            if (map.containsKey(MBridgeConstans.PLACEMENT_ID) && map.get(MBridgeConstans.PLACEMENT_ID) != null) {
                this.d = (String) map.get(MBridgeConstans.PLACEMENT_ID);
            }
            this.f = new MBridgeIds(this.d, this.c);
            this.n = true;
            return this.n;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str) {
        try {
            if (this.g != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 2;
                this.g.sendMessage(obtain);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String a() {
        return this.l;
    }

    public void a(boolean z) {
        boolean z2;
        try {
            z2 = z;
        } catch (Exception e) {
            e = e;
            z2 = z;
        }
        try {
            com.mbridge.msdk.interstitial.adapter.a aVar = new com.mbridge.msdk.interstitial.adapter.a(this.b, this.c, this.d, this.e, z2);
            c cVar = new c(aVar);
            aVar.a(new b(aVar, cVar));
            Handler handler = this.g;
            if (handler != null) {
                handler.postDelayed(cVar, 30000L);
            }
            aVar.j();
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            if (z2) {
                return;
            }
            b("can't show because unknow error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        try {
            if (this.g != null) {
                Message obtain = Message.obtain();
                obtain.obj = str;
                obtain.what = 4;
                this.g.sendMessage(obtain);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void a(CampaignEx campaignEx) {
        d dVar = new d();
        if (r != null && !TextUtils.isEmpty(this.c)) {
            r.put(this.c, dVar);
        }
        Intent intent = new Intent(this.b, (Class<?>) MBInterstitialActivity.class);
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        if (!TextUtils.isEmpty(this.c)) {
            intent.putExtra("unitId", this.c);
        }
        if (campaignEx != null) {
            this.m = campaignEx.getRequestId();
            intent.putExtra("campaign", campaignEx);
        }
        Context context = this.b;
        if (context != null) {
            context.startActivity(intent);
        }
    }
}
