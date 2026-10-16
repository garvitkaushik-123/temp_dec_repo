package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.room.RoomMasterTable;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.k;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.n0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.nativex.view.MBMediaView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.PreloadListener;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.setting.j;
import com.mbridge.msdk.setting.l;
import com.mbridge.msdk.tracker.network.g;
import com.unity3d.services.core.fid.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: NativePreloadController.java */
/* loaded from: classes6.dex */
public class d extends com.mbridge.msdk.mbnative.controller.b {
    private static final String r = "d";
    private static Map<String, Map<Long, Object>> s = new HashMap();
    private static Map<String, Boolean> t = new HashMap();
    private static Map<String, k> u = new HashMap();
    private static Map<String, Integer> v = new HashMap();
    private static Map<String, Integer> w = new HashMap();
    private static d x = null;
    private static int y = -1;
    private static int z = -2;
    private j b;
    private com.mbridge.msdk.click.a c;
    private l d;
    private String e;
    private Map<String, Object> i;
    private List<Integer> j;
    protected List<Integer> k;
    private List<Integer> l;
    private boolean m;
    private boolean n;
    private int o;
    private int p;
    Queue<Integer> f = null;
    Queue<Long> g = null;
    private int h = 0;
    private com.mbridge.msdk.foundation.same.task.b q = new com.mbridge.msdk.foundation.same.task.b(com.mbridge.msdk.foundation.controller.c.m().d());

    /* compiled from: NativePreloadController.java */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
        }
    }

    /* compiled from: NativePreloadController.java */
    public class b extends com.mbridge.msdk.mbnative.service.net.b implements com.mbridge.msdk.foundation.same.task.d {
        private int c;
        private int d;
        private int e;
        private int f;
        private int g;
        private Runnable j;
        private com.mbridge.msdk.preload.listenter.a l;
        private List<String> h = null;
        private boolean i = false;
        private boolean k = true;

        /* compiled from: NativePreloadController.java */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignUnit f4515a;

            a(CampaignUnit campaignUnit) {
                this.f4515a = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD && Looper.myLooper() == null) {
                    Looper.prepare();
                    z = true;
                } else {
                    z = false;
                }
                if (b.this.j != null) {
                    b bVar = b.this;
                    d.this.f4509a.removeCallbacks(bVar.j);
                }
                if (com.mbridge.msdk.util.b.a()) {
                    d.this.a(this.f4515a);
                }
                if (d.s.containsKey("0_" + b.this.unitId)) {
                    d.s.remove("0_" + b.this.unitId);
                }
                if (b.this.g > 0) {
                    if (this.f4515a.ads.size() > b.this.g) {
                        b bVar2 = b.this;
                        bVar2.d = bVar2.g;
                    } else {
                        b.this.d = this.f4515a.ads.size();
                    }
                } else if (b.this.g == -1) {
                    b.this.d = 0;
                } else if (b.this.g == -3) {
                    b.this.d = this.f4515a.ads.size();
                } else if (b.this.g == -2) {
                    if (this.f4515a.getTemplate() == 3) {
                        if (b.this.f != 0) {
                            b bVar3 = b.this;
                            bVar3.d = bVar3.f;
                        }
                    } else if (b.this.e != 0) {
                        b bVar4 = b.this;
                        bVar4.d = bVar4.e;
                    }
                    if (b.this.d <= 0) {
                        b.this.d = ((Integer) d.v.get(b.this.unitId)).intValue();
                    }
                }
                if (this.f4515a.ads.size() < b.this.d) {
                    b.this.d = this.f4515a.ads.size();
                }
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("adtp", 42);
                if (TextUtils.isEmpty(b.this.b())) {
                    eVar.a(CampaignEx.JSON_KEY_HB, 0);
                } else {
                    eVar.a(CampaignEx.JSON_KEY_HB, 1);
                }
                com.mbridge.msdk.foundation.same.report.metrics.c a2 = com.mbridge.msdk.foundation.same.report.metrics.d.b().a(true, b.this.b(), eVar, this.f4515a.getAds().get(0), b.this.unitId);
                for (int i = 0; i < this.f4515a.ads.size(); i++) {
                    CampaignEx campaignEx = this.f4515a.ads.get(i);
                    campaignEx.setLocalRequestId(a2.o());
                    campaignEx.setCampaignUnitId(b.this.unitId);
                    boolean c = u0.c(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx.getPackageName());
                    d.this.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx);
                    if (arrayList.size() < b.this.d && campaignEx.getOfferType() != 99) {
                        if (u0.c(campaignEx)) {
                            campaignEx.setRtinsType(c ? 1 : 2);
                        }
                        if (com.mbridge.msdk.foundation.same.c.b(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx)) {
                            arrayList.add(campaignEx);
                            if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                arrayList2.add(campaignEx);
                            }
                        } else {
                            u0.a(b.this.unitId, campaignEx, com.mbridge.msdk.foundation.same.a.x);
                        }
                        b.this.a(campaignEx, null, null);
                    }
                    d dVar = d.this;
                    dVar.a(dVar.m, campaignEx);
                }
                b bVar5 = b.this;
                d.this.a(arrayList2, bVar5.unitId);
                com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a3 = com.mbridge.msdk.mbnative.cache.c.a(this.f4515a.getAds().get(0) != null ? this.f4515a.getAds().get(0).getType() : 1);
                if (a3 != null) {
                    a3.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) b.this.unitId, (String) arrayList);
                }
                d.a(b.this.c, b.this.unitId);
                if (Looper.myLooper() != null && z) {
                    Looper.loop();
                }
                if (this.f4515a.getAds().get(0) != null) {
                    com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f4515a.getAds().get(0).getMaitve(), this.f4515a.getAds().get(0).getMaitve_src());
                }
            }
        }

        /* compiled from: NativePreloadController.java */
        /* renamed from: com.mbridge.msdk.mbnative.controller.d$b$b, reason: collision with other inner class name */
        class C0357b extends c.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ CampaignEx f4516a;
            final /* synthetic */ Context b;

            C0357b(CampaignEx campaignEx, Context context, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
                this.f4516a = campaignEx;
                this.b = context;
            }

            @Override // com.mbridge.msdk.foundation.same.c.a
            public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
                com.mbridge.msdk.mbnative.report.a.a(str, cVar, this.f4516a, this.b, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
            }
        }

        /* compiled from: NativePreloadController.java */
        class c implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4517a;
            final /* synthetic */ int b;

            c(String str, int i) {
                this.f4517a = str;
                this.b = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD && Looper.myLooper() == null) {
                    Looper.prepare();
                    z = true;
                } else {
                    z = false;
                }
                if (!b.this.i) {
                    if (b.this.j != null) {
                        b bVar = b.this;
                        d.this.f4509a.removeCallbacks(bVar.j);
                    }
                    if (b.this.a() == 1 || b.this.k) {
                        b bVar2 = b.this;
                        d dVar = d.this;
                        String str = this.f4517a;
                        int a2 = bVar2.a();
                        b bVar3 = b.this;
                        dVar.a(str, a2, bVar3.unitId, bVar3.placementId, bVar3.l);
                    }
                } else if (b.this.k) {
                    b bVar4 = b.this;
                    d dVar2 = d.this;
                    String str2 = this.f4517a;
                    int a3 = bVar4.a();
                    b bVar5 = b.this;
                    dVar2.a(str2, a3, bVar5.unitId, bVar5.placementId, bVar5.l);
                }
                if (this.b == -1) {
                    d.b(b.this.c, b.this.unitId);
                }
                if (Looper.myLooper() == null || !z) {
                    return;
                }
                Looper.loop();
            }
        }

        /* compiled from: NativePreloadController.java */
        /* renamed from: com.mbridge.msdk.mbnative.controller.d$b$d, reason: collision with other inner class name */
        class RunnableC0358d implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ List f4518a;

            RunnableC0358d(List list) {
                this.f4518a = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD && Looper.myLooper() == null) {
                    Looper.prepare();
                    z = true;
                } else {
                    z = false;
                }
                if (!b.this.i && b.this.j != null) {
                    b bVar = b.this;
                    d.this.f4509a.removeCallbacks(bVar.j);
                }
                List list = this.f4518a;
                if (list != null && list.size() > 0) {
                    Iterator it = this.f4518a.iterator();
                    while (it.hasNext()) {
                        for (CampaignEx campaignEx : ((Frame) it.next()).getCampaigns()) {
                            d dVar = d.this;
                            dVar.a(dVar.m, campaignEx);
                        }
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put(Long.valueOf(System.currentTimeMillis()), this.f4518a);
                    if (d.s.containsKey("1_" + b.this.unitId)) {
                        d.s.remove("1_" + b.this.unitId);
                    }
                    d.s.put("1_" + b.this.unitId, hashMap);
                }
                if (Looper.myLooper() == null || !z) {
                    return;
                }
                Looper.loop();
            }
        }

        public b(int i) {
            this.c = i;
        }

        public void b(List<String> list) {
            this.h = list;
        }

        public void c(int i) {
            this.e = i;
        }

        public void d(int i) {
            this.d = i;
        }

        public void e(int i) {
            this.f = i;
        }

        public void b(int i) {
            this.g = i;
        }

        public void a(com.mbridge.msdk.preload.listenter.a aVar) {
            this.l = aVar;
        }

        public void b(boolean z) {
            this.k = z;
        }

        @Override // com.mbridge.msdk.foundation.same.task.d
        public void a(boolean z) {
            this.i = z;
        }

        @Override // com.mbridge.msdk.mbnative.service.net.b
        public void a(List<g> list, CampaignUnit campaignUnit) {
            d.this.n = true;
            d.this.a(true, this.l, (String) null);
            d.this.a(new Thread(new a(campaignUnit)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            try {
                Context d = com.mbridge.msdk.foundation.controller.c.m().d();
                com.mbridge.msdk.foundation.same.c.a(campaignEx, d, cVar, new C0357b(campaignEx, d, aVar));
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    e.printStackTrace();
                }
            }
        }

        @Override // com.mbridge.msdk.mbnative.service.net.b
        public void a(int i, String str) {
            d.this.a(new Thread(new c(str, i)));
        }

        public void a(Runnable runnable) {
            this.j = runnable;
        }

        @Override // com.mbridge.msdk.mbnative.service.net.b
        public void a(List<Frame> list) {
            d.this.a(new Thread(new RunnableC0358d(list)));
        }
    }

    /* compiled from: NativePreloadController.java */
    public class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        private int f4519a;
        private com.mbridge.msdk.foundation.same.task.d b;
        private int c;
        private String d;
        private String e;
        private com.mbridge.msdk.preload.listenter.a f;
        private boolean g = false;

        public c(int i, com.mbridge.msdk.foundation.same.task.d dVar, int i2, String str, String str2) {
            this.f4519a = i;
            this.b = dVar;
            this.c = i2;
            this.d = str;
            this.e = str2;
        }

        public void a(boolean z) {
            this.g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.a(true);
            int i = this.f4519a;
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                d.this.a("REQUEST_TIMEOUT", this.c, this.d, this.e, this.f);
            } else {
                d.this.n = true;
                if (this.g || this.c == 1) {
                    d.this.a("REQUEST_TIMEOUT", this.c, this.d, this.e, this.f);
                }
            }
        }

        public void a(com.mbridge.msdk.preload.listenter.a aVar) {
            this.f = aVar;
        }

        public void a(String str) {
            this.d = str;
        }
    }

    public d() {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.f4509a = new a();
    }

    public static Map<String, Integer> c() {
        return v;
    }

    public static Map<String, Integer> d() {
        return w;
    }

    public static Map<String, k> e() {
        return u;
    }

    public static Map<String, Map<Long, Object>> f() {
        return s;
    }

    public static Map<String, Boolean> g() {
        return t;
    }

    public static void b(int i, String str) {
        if (u.containsKey(str)) {
            k kVar = u.get(str);
            if (i == 1) {
                kVar.a(0);
            } else if (i == 2) {
                kVar.b(0);
            }
            u.put(str, kVar);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x01f6, code lost:
    
        if (android.text.TextUtils.isEmpty(r3) != false) goto L76;
     */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02cf A[Catch: Exception -> 0x03c1, TryCatch #5 {Exception -> 0x03c1, blocks: (B:3:0x001a, B:8:0x0027, B:10:0x0050, B:14:0x006f, B:18:0x0077, B:20:0x007d, B:21:0x0089, B:23:0x008d, B:24:0x00a0, B:26:0x00a6, B:27:0x00b2, B:29:0x00b8, B:30:0x00c0, B:32:0x00c9, B:34:0x00d7, B:36:0x0108, B:38:0x010e, B:40:0x0122, B:41:0x012a, B:43:0x013b, B:47:0x0143, B:58:0x0172, B:60:0x0184, B:62:0x018a, B:63:0x0193, B:65:0x01a9, B:67:0x01af, B:69:0x01b7, B:70:0x01c5, B:72:0x01d4, B:73:0x01da, B:75:0x01e2, B:77:0x01ea, B:80:0x01fb, B:82:0x0217, B:84:0x021d, B:85:0x022a, B:87:0x0230, B:89:0x023c, B:91:0x0240, B:93:0x0246, B:94:0x0253, B:96:0x0259, B:98:0x0270, B:118:0x02c1, B:120:0x02cf, B:121:0x02d8, B:152:0x03b0, B:163:0x03bb, B:168:0x016b, B:169:0x009d, B:123:0x02e3, B:125:0x02f9, B:127:0x0312, B:128:0x031a, B:130:0x0320, B:131:0x0322, B:133:0x0328, B:134:0x032e, B:136:0x0334, B:138:0x0344, B:140:0x0347, B:143:0x034a, B:145:0x0350, B:49:0x014c, B:51:0x0152, B:53:0x0160, B:54:0x0162, B:56:0x0168), top: B:2:0x001a, inners: #0, #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02f9 A[Catch: all -> 0x03b0, TryCatch #0 {all -> 0x03b0, blocks: (B:123:0x02e3, B:125:0x02f9, B:127:0x0312, B:128:0x031a, B:130:0x0320, B:131:0x0322, B:133:0x0328, B:134:0x032e, B:136:0x0334, B:138:0x0344, B:140:0x0347, B:143:0x034a, B:145:0x0350), top: B:122:0x02e3, outer: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:151:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Map<String, Object> map, int i) {
        String str;
        String str2;
        com.mbridge.msdk.preload.listenter.a aVar;
        String str3;
        List<Campaign> a2;
        Object obj;
        try {
            this.i = map;
            this.n = false;
            if (map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                String str4 = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
                if ((!s.containsKey(((i + 1) % 2) + "_" + str4) || s.containsKey(i + "_" + str4)) && !TextUtils.isEmpty(str4)) {
                    if (map.containsKey(MBridgeConstans.PREIMAGE)) {
                        this.m = ((Boolean) map.get(MBridgeConstans.PREIMAGE)).booleanValue();
                    }
                    com.mbridge.msdk.click.a aVar2 = this.c;
                    if (aVar2 == null) {
                        this.c = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().d(), str4);
                    } else {
                        aVar2.a(str4);
                    }
                    if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)) {
                        this.h = ((Integer) map.get(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)).intValue();
                    }
                    if (map.containsKey(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY)) {
                        this.e = (String) map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY);
                    }
                    if (t.containsKey(str4) && t.get(str4).booleanValue()) {
                        Map<String, Map<Long, Object>> f = f();
                        Map<Long, Object> map2 = f.get(i + "_" + str4);
                        com.mbridge.msdk.setting.g d = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
                        if (map2 != null && map2.size() > 0) {
                            Long next = map2.keySet().iterator().next();
                            long currentTimeMillis = System.currentTimeMillis();
                            if (d == null) {
                                d = h.b().a();
                            }
                            if (currentTimeMillis - next.longValue() >= d.Z() * 1000) {
                                f.remove(str4);
                            } else if (i == 1) {
                                return;
                            }
                        }
                    }
                    t.put(str4, Boolean.TRUE);
                    this.p = 1;
                    try {
                        if (map.containsKey("ad_num")) {
                            int intValue = ((Integer) map.get("ad_num")).intValue();
                            this.p = intValue;
                            if (intValue < 1) {
                                this.p = 1;
                            }
                            if (this.p > 10) {
                                this.p = 10;
                            }
                        }
                    } catch (Exception unused) {
                        p0.b(r, "ADNUM MUST BE INTEGER");
                    }
                    v.put(str4, Integer.valueOf(this.p));
                    com.mbridge.msdk.preload.listenter.a aVar3 = (!map.containsKey(MBridgeConstans.PRELOAD_RESULT_LISTENER) || (obj = map.get(MBridgeConstans.PRELOAD_RESULT_LISTENER)) == null) ? null : new com.mbridge.msdk.preload.listenter.a((PreloadListener) obj);
                    String b2 = com.mbridge.msdk.foundation.controller.c.m().b();
                    String c2 = com.mbridge.msdk.foundation.controller.c.m().c();
                    if (map.containsKey(MBridgeConstans.APP_ID) && map.containsKey(MBridgeConstans.APP_KEY) && map.containsKey(MBridgeConstans.KEY_WORD)) {
                        b2 = (String) map.get(MBridgeConstans.APP_ID);
                        c2 = (String) map.get(MBridgeConstans.APP_KEY);
                    }
                    a(b2, c2, str4);
                    l e = h.b().e(b2, str4);
                    this.d = e;
                    if (e == null) {
                        this.d = l.i(str4);
                    }
                    if (map.containsKey(MBridgeConstans.PLACEMENT_ID) && map.get(MBridgeConstans.PLACEMENT_ID) != null) {
                        str = (String) map.get(MBridgeConstans.PLACEMENT_ID);
                    }
                    str = "";
                    String str5 = str;
                    this.j = this.d.b();
                    this.k = this.d.c();
                    this.l = this.d.c();
                    List<Integer> list = this.j;
                    if (list == null || list.size() <= 0) {
                        com.mbridge.msdk.preload.listenter.a aVar4 = aVar3;
                        if (aVar4 != null) {
                            aVar4.onPreloadFaild("do not have sorceList");
                            return;
                        }
                        return;
                    }
                    this.f = new LinkedList();
                    Iterator<Integer> it = this.j.iterator();
                    while (it.hasNext()) {
                        this.f.add(it.next());
                    }
                    List<Integer> list2 = this.l;
                    if (list2 != null && list2.size() > 0) {
                        this.g = new LinkedList();
                        Iterator<Integer> it2 = this.l.iterator();
                        while (it2.hasNext()) {
                            this.g.add(Long.valueOf(it2.next().intValue() * 1000));
                        }
                    }
                    try {
                        if (this.j.contains(1) && i == 0) {
                            try {
                                str2 = str4;
                                aVar = aVar3;
                                try {
                                    try {
                                        a(1, this.k.get(this.j.indexOf(1)).intValue() * 1000, i, this.d, str2, str5, false, aVar);
                                        str5 = str5;
                                        com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a3 = com.mbridge.msdk.mbnative.cache.c.a(1);
                                        if (a3 != null && (a2 = a3.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) str2, 0)) != null && a2.size() > 0) {
                                            a(true, aVar, (String) null);
                                        }
                                    } catch (Exception unused2) {
                                        str5 = str5;
                                    }
                                } catch (Exception unused3) {
                                }
                            } catch (Exception unused4) {
                            }
                            str3 = str2;
                            a(i, this.d, str3, str5, aVar);
                            l lVar = this.d;
                            d().put(str3, Integer.valueOf(lVar == null ? lVar.y() * this.p : 1));
                            int i2 = MBMediaView.p0;
                            e.a(com.mbridge.msdk.foundation.controller.c.m().d(), str3);
                            n0.a();
                            if (TextUtils.isEmpty(str3)) {
                                com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).a();
                                int a4 = a(map.containsKey(MBridgeConstans.NATIVE_INFO) ? (String) map.get(MBridgeConstans.NATIVE_INFO) : null);
                                if (a4 <= 0) {
                                    a4 = this.p;
                                }
                                List<Campaign> a5 = a(str3, a4);
                                if (a5 != null) {
                                    ArrayList arrayList = new ArrayList();
                                    for (int i3 = 0; i3 < a5.size(); i3++) {
                                        CampaignEx campaignEx = (CampaignEx) a5.get(i3);
                                        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                            arrayList.add(campaignEx);
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        Object invoke = com.mbridge.msdk.videocommon.download.b.class.getMethod(Constants.GET_INSTANCE, new Class[0]).invoke(null, new Object[0]);
                                        com.mbridge.msdk.videocommon.download.b.class.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, com.mbridge.msdk.videocommon.listener.a.class).invoke(invoke, com.mbridge.msdk.foundation.controller.c.m().d(), str3, new CopyOnWriteArrayList(arrayList), 1, null);
                                        com.mbridge.msdk.videocommon.download.b.class.getMethod("load", String.class).invoke(invoke, str3);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        int i22 = MBMediaView.p0;
                        e.a(com.mbridge.msdk.foundation.controller.c.m().d(), str3);
                        n0.a();
                        if (TextUtils.isEmpty(str3)) {
                        }
                    } catch (Throwable unused5) {
                        p0.b(r, "init cam cache failed");
                        return;
                    }
                    str2 = str4;
                    aVar = aVar3;
                    str3 = str2;
                    a(i, this.d, str3, str5, aVar);
                    l lVar2 = this.d;
                    d().put(str3, Integer.valueOf(lVar2 == null ? lVar2.y() * this.p : 1));
                }
            }
        } catch (Exception e2) {
            p0.b(r, com.mbridge.msdk.mbnative.common.a.a(e2));
        }
    }

    private int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i);
                    if (2 == jSONObject.optInt("id", 0)) {
                        return jSONObject.optInt("ad_num");
                    }
                }
            }
        } catch (Exception e) {
            p0.b(r, com.mbridge.msdk.mbnative.common.a.a(e));
        }
        return 0;
    }

    public List<Campaign> a(String str, int i) {
        com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a2;
        l e = h.b().e("", str);
        this.d = e;
        if (e == null) {
            this.d = l.i(str);
        }
        List<Integer> b2 = this.d.b();
        this.j = b2;
        if (b2 == null || b2.size() <= 0 || !this.j.contains(1) || (a2 = com.mbridge.msdk.mbnative.cache.c.a(1)) == null) {
            return null;
        }
        return a2.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) str, i);
    }

    public void a(int i, l lVar, String str, String str2, com.mbridge.msdk.preload.listenter.a aVar) {
        Queue<Integer> queue = this.f;
        if (queue == null || queue.size() <= 0) {
            return;
        }
        try {
            int intValue = this.f.poll().intValue();
            long j = MBridgeConstans.REQUEST_TIME_OUT;
            Queue<Long> queue2 = this.g;
            if (queue2 != null && queue2.size() > 0) {
                j = this.g.poll().longValue();
            }
            p0.c(r, "preload start queue adsource = " + intValue);
            a(intValue, j, str, str2, this.i, i, lVar, aVar);
        } catch (Throwable unused) {
            p0.b(r, "queue poll exception");
        }
    }

    public void a(int i, long j, String str, String str2, Map<String, Object> map, int i2, l lVar, com.mbridge.msdk.preload.listenter.a aVar) {
        com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a2;
        List<Campaign> a3;
        if (i != 1 && (a2 = com.mbridge.msdk.mbnative.cache.c.a(i)) != null && (a3 = a2.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) str, this.p)) != null && a3.size() > 0) {
            a(true, aVar, (String) null);
            return;
        }
        if (i == 1) {
            a(i, j, i2, lVar, str, str2, true, aVar);
        } else if (i != 2) {
            a(i, j, i2, lVar, str, str2, aVar, false);
        } else {
            a(2, j, i2, lVar, str, str2, aVar, false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x0293 A[Catch: Exception -> 0x0478, TryCatch #1 {Exception -> 0x0478, blocks: (B:3:0x0018, B:6:0x0063, B:8:0x0069, B:10:0x0071, B:12:0x0079, B:14:0x0081, B:16:0x008b, B:17:0x0095, B:19:0x009f, B:20:0x00a9, B:22:0x00b3, B:23:0x00bd, B:25:0x00c3, B:27:0x00cc, B:29:0x00e5, B:30:0x00ec, B:32:0x00f2, B:33:0x00f7, B:35:0x0120, B:36:0x0125, B:43:0x013e, B:46:0x0146, B:48:0x014e, B:50:0x0154, B:53:0x0159, B:55:0x015d, B:61:0x016a, B:63:0x0172, B:65:0x0178, B:69:0x0184, B:70:0x0198, B:72:0x019c, B:73:0x01b9, B:75:0x01c1, B:77:0x01d0, B:79:0x01e2, B:84:0x01f3, B:86:0x01f9, B:88:0x020d, B:90:0x0213, B:96:0x021a, B:98:0x0220, B:106:0x0231, B:108:0x0254, B:110:0x0268, B:112:0x0293, B:113:0x029a, B:115:0x02a2, B:117:0x02b4, B:118:0x02bd, B:120:0x02c8, B:126:0x02d8, B:128:0x02e9, B:133:0x02f6, B:134:0x0326, B:136:0x0365, B:137:0x036a, B:139:0x0372, B:141:0x037c, B:142:0x039e, B:144:0x03a6, B:146:0x03b0, B:147:0x03d2, B:150:0x0406, B:152:0x0432, B:153:0x0466, B:157:0x044f, B:158:0x0403, B:160:0x0310, B:162:0x02dd, B:163:0x02e2, B:168:0x0249, B:176:0x0258, B:182:0x046c), top: B:2:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02a2 A[Catch: Exception -> 0x0478, TryCatch #1 {Exception -> 0x0478, blocks: (B:3:0x0018, B:6:0x0063, B:8:0x0069, B:10:0x0071, B:12:0x0079, B:14:0x0081, B:16:0x008b, B:17:0x0095, B:19:0x009f, B:20:0x00a9, B:22:0x00b3, B:23:0x00bd, B:25:0x00c3, B:27:0x00cc, B:29:0x00e5, B:30:0x00ec, B:32:0x00f2, B:33:0x00f7, B:35:0x0120, B:36:0x0125, B:43:0x013e, B:46:0x0146, B:48:0x014e, B:50:0x0154, B:53:0x0159, B:55:0x015d, B:61:0x016a, B:63:0x0172, B:65:0x0178, B:69:0x0184, B:70:0x0198, B:72:0x019c, B:73:0x01b9, B:75:0x01c1, B:77:0x01d0, B:79:0x01e2, B:84:0x01f3, B:86:0x01f9, B:88:0x020d, B:90:0x0213, B:96:0x021a, B:98:0x0220, B:106:0x0231, B:108:0x0254, B:110:0x0268, B:112:0x0293, B:113:0x029a, B:115:0x02a2, B:117:0x02b4, B:118:0x02bd, B:120:0x02c8, B:126:0x02d8, B:128:0x02e9, B:133:0x02f6, B:134:0x0326, B:136:0x0365, B:137:0x036a, B:139:0x0372, B:141:0x037c, B:142:0x039e, B:144:0x03a6, B:146:0x03b0, B:147:0x03d2, B:150:0x0406, B:152:0x0432, B:153:0x0466, B:157:0x044f, B:158:0x0403, B:160:0x0310, B:162:0x02dd, B:163:0x02e2, B:168:0x0249, B:176:0x0258, B:182:0x046c), top: B:2:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02c8 A[Catch: Exception -> 0x0478, TryCatch #1 {Exception -> 0x0478, blocks: (B:3:0x0018, B:6:0x0063, B:8:0x0069, B:10:0x0071, B:12:0x0079, B:14:0x0081, B:16:0x008b, B:17:0x0095, B:19:0x009f, B:20:0x00a9, B:22:0x00b3, B:23:0x00bd, B:25:0x00c3, B:27:0x00cc, B:29:0x00e5, B:30:0x00ec, B:32:0x00f2, B:33:0x00f7, B:35:0x0120, B:36:0x0125, B:43:0x013e, B:46:0x0146, B:48:0x014e, B:50:0x0154, B:53:0x0159, B:55:0x015d, B:61:0x016a, B:63:0x0172, B:65:0x0178, B:69:0x0184, B:70:0x0198, B:72:0x019c, B:73:0x01b9, B:75:0x01c1, B:77:0x01d0, B:79:0x01e2, B:84:0x01f3, B:86:0x01f9, B:88:0x020d, B:90:0x0213, B:96:0x021a, B:98:0x0220, B:106:0x0231, B:108:0x0254, B:110:0x0268, B:112:0x0293, B:113:0x029a, B:115:0x02a2, B:117:0x02b4, B:118:0x02bd, B:120:0x02c8, B:126:0x02d8, B:128:0x02e9, B:133:0x02f6, B:134:0x0326, B:136:0x0365, B:137:0x036a, B:139:0x0372, B:141:0x037c, B:142:0x039e, B:144:0x03a6, B:146:0x03b0, B:147:0x03d2, B:150:0x0406, B:152:0x0432, B:153:0x0466, B:157:0x044f, B:158:0x0403, B:160:0x0310, B:162:0x02dd, B:163:0x02e2, B:168:0x0249, B:176:0x0258, B:182:0x046c), top: B:2:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0365 A[Catch: Exception -> 0x0478, TryCatch #1 {Exception -> 0x0478, blocks: (B:3:0x0018, B:6:0x0063, B:8:0x0069, B:10:0x0071, B:12:0x0079, B:14:0x0081, B:16:0x008b, B:17:0x0095, B:19:0x009f, B:20:0x00a9, B:22:0x00b3, B:23:0x00bd, B:25:0x00c3, B:27:0x00cc, B:29:0x00e5, B:30:0x00ec, B:32:0x00f2, B:33:0x00f7, B:35:0x0120, B:36:0x0125, B:43:0x013e, B:46:0x0146, B:48:0x014e, B:50:0x0154, B:53:0x0159, B:55:0x015d, B:61:0x016a, B:63:0x0172, B:65:0x0178, B:69:0x0184, B:70:0x0198, B:72:0x019c, B:73:0x01b9, B:75:0x01c1, B:77:0x01d0, B:79:0x01e2, B:84:0x01f3, B:86:0x01f9, B:88:0x020d, B:90:0x0213, B:96:0x021a, B:98:0x0220, B:106:0x0231, B:108:0x0254, B:110:0x0268, B:112:0x0293, B:113:0x029a, B:115:0x02a2, B:117:0x02b4, B:118:0x02bd, B:120:0x02c8, B:126:0x02d8, B:128:0x02e9, B:133:0x02f6, B:134:0x0326, B:136:0x0365, B:137:0x036a, B:139:0x0372, B:141:0x037c, B:142:0x039e, B:144:0x03a6, B:146:0x03b0, B:147:0x03d2, B:150:0x0406, B:152:0x0432, B:153:0x0466, B:157:0x044f, B:158:0x0403, B:160:0x0310, B:162:0x02dd, B:163:0x02e2, B:168:0x0249, B:176:0x0258, B:182:0x046c), top: B:2:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0372 A[Catch: Exception -> 0x0478, TryCatch #1 {Exception -> 0x0478, blocks: (B:3:0x0018, B:6:0x0063, B:8:0x0069, B:10:0x0071, B:12:0x0079, B:14:0x0081, B:16:0x008b, B:17:0x0095, B:19:0x009f, B:20:0x00a9, B:22:0x00b3, B:23:0x00bd, B:25:0x00c3, B:27:0x00cc, B:29:0x00e5, B:30:0x00ec, B:32:0x00f2, B:33:0x00f7, B:35:0x0120, B:36:0x0125, B:43:0x013e, B:46:0x0146, B:48:0x014e, B:50:0x0154, B:53:0x0159, B:55:0x015d, B:61:0x016a, B:63:0x0172, B:65:0x0178, B:69:0x0184, B:70:0x0198, B:72:0x019c, B:73:0x01b9, B:75:0x01c1, B:77:0x01d0, B:79:0x01e2, B:84:0x01f3, B:86:0x01f9, B:88:0x020d, B:90:0x0213, B:96:0x021a, B:98:0x0220, B:106:0x0231, B:108:0x0254, B:110:0x0268, B:112:0x0293, B:113:0x029a, B:115:0x02a2, B:117:0x02b4, B:118:0x02bd, B:120:0x02c8, B:126:0x02d8, B:128:0x02e9, B:133:0x02f6, B:134:0x0326, B:136:0x0365, B:137:0x036a, B:139:0x0372, B:141:0x037c, B:142:0x039e, B:144:0x03a6, B:146:0x03b0, B:147:0x03d2, B:150:0x0406, B:152:0x0432, B:153:0x0466, B:157:0x044f, B:158:0x0403, B:160:0x0310, B:162:0x02dd, B:163:0x02e2, B:168:0x0249, B:176:0x0258, B:182:0x046c), top: B:2:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x03a6 A[Catch: Exception -> 0x0478, TryCatch #1 {Exception -> 0x0478, blocks: (B:3:0x0018, B:6:0x0063, B:8:0x0069, B:10:0x0071, B:12:0x0079, B:14:0x0081, B:16:0x008b, B:17:0x0095, B:19:0x009f, B:20:0x00a9, B:22:0x00b3, B:23:0x00bd, B:25:0x00c3, B:27:0x00cc, B:29:0x00e5, B:30:0x00ec, B:32:0x00f2, B:33:0x00f7, B:35:0x0120, B:36:0x0125, B:43:0x013e, B:46:0x0146, B:48:0x014e, B:50:0x0154, B:53:0x0159, B:55:0x015d, B:61:0x016a, B:63:0x0172, B:65:0x0178, B:69:0x0184, B:70:0x0198, B:72:0x019c, B:73:0x01b9, B:75:0x01c1, B:77:0x01d0, B:79:0x01e2, B:84:0x01f3, B:86:0x01f9, B:88:0x020d, B:90:0x0213, B:96:0x021a, B:98:0x0220, B:106:0x0231, B:108:0x0254, B:110:0x0268, B:112:0x0293, B:113:0x029a, B:115:0x02a2, B:117:0x02b4, B:118:0x02bd, B:120:0x02c8, B:126:0x02d8, B:128:0x02e9, B:133:0x02f6, B:134:0x0326, B:136:0x0365, B:137:0x036a, B:139:0x0372, B:141:0x037c, B:142:0x039e, B:144:0x03a6, B:146:0x03b0, B:147:0x03d2, B:150:0x0406, B:152:0x0432, B:153:0x0466, B:157:0x044f, B:158:0x0403, B:160:0x0310, B:162:0x02dd, B:163:0x02e2, B:168:0x0249, B:176:0x0258, B:182:0x046c), top: B:2:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0401 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0432 A[Catch: Exception -> 0x0478, TryCatch #1 {Exception -> 0x0478, blocks: (B:3:0x0018, B:6:0x0063, B:8:0x0069, B:10:0x0071, B:12:0x0079, B:14:0x0081, B:16:0x008b, B:17:0x0095, B:19:0x009f, B:20:0x00a9, B:22:0x00b3, B:23:0x00bd, B:25:0x00c3, B:27:0x00cc, B:29:0x00e5, B:30:0x00ec, B:32:0x00f2, B:33:0x00f7, B:35:0x0120, B:36:0x0125, B:43:0x013e, B:46:0x0146, B:48:0x014e, B:50:0x0154, B:53:0x0159, B:55:0x015d, B:61:0x016a, B:63:0x0172, B:65:0x0178, B:69:0x0184, B:70:0x0198, B:72:0x019c, B:73:0x01b9, B:75:0x01c1, B:77:0x01d0, B:79:0x01e2, B:84:0x01f3, B:86:0x01f9, B:88:0x020d, B:90:0x0213, B:96:0x021a, B:98:0x0220, B:106:0x0231, B:108:0x0254, B:110:0x0268, B:112:0x0293, B:113:0x029a, B:115:0x02a2, B:117:0x02b4, B:118:0x02bd, B:120:0x02c8, B:126:0x02d8, B:128:0x02e9, B:133:0x02f6, B:134:0x0326, B:136:0x0365, B:137:0x036a, B:139:0x0372, B:141:0x037c, B:142:0x039e, B:144:0x03a6, B:146:0x03b0, B:147:0x03d2, B:150:0x0406, B:152:0x0432, B:153:0x0466, B:157:0x044f, B:158:0x0403, B:160:0x0310, B:162:0x02dd, B:163:0x02e2, B:168:0x0249, B:176:0x0258, B:182:0x046c), top: B:2:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0310 A[Catch: Exception -> 0x0478, TryCatch #1 {Exception -> 0x0478, blocks: (B:3:0x0018, B:6:0x0063, B:8:0x0069, B:10:0x0071, B:12:0x0079, B:14:0x0081, B:16:0x008b, B:17:0x0095, B:19:0x009f, B:20:0x00a9, B:22:0x00b3, B:23:0x00bd, B:25:0x00c3, B:27:0x00cc, B:29:0x00e5, B:30:0x00ec, B:32:0x00f2, B:33:0x00f7, B:35:0x0120, B:36:0x0125, B:43:0x013e, B:46:0x0146, B:48:0x014e, B:50:0x0154, B:53:0x0159, B:55:0x015d, B:61:0x016a, B:63:0x0172, B:65:0x0178, B:69:0x0184, B:70:0x0198, B:72:0x019c, B:73:0x01b9, B:75:0x01c1, B:77:0x01d0, B:79:0x01e2, B:84:0x01f3, B:86:0x01f9, B:88:0x020d, B:90:0x0213, B:96:0x021a, B:98:0x0220, B:106:0x0231, B:108:0x0254, B:110:0x0268, B:112:0x0293, B:113:0x029a, B:115:0x02a2, B:117:0x02b4, B:118:0x02bd, B:120:0x02c8, B:126:0x02d8, B:128:0x02e9, B:133:0x02f6, B:134:0x0326, B:136:0x0365, B:137:0x036a, B:139:0x0372, B:141:0x037c, B:142:0x039e, B:144:0x03a6, B:146:0x03b0, B:147:0x03d2, B:150:0x0406, B:152:0x0432, B:153:0x0466, B:157:0x044f, B:158:0x0403, B:160:0x0310, B:162:0x02dd, B:163:0x02e2, B:168:0x0249, B:176:0x0258, B:182:0x046c), top: B:2:0x0018 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x030d  */
    @Override // com.mbridge.msdk.mbnative.controller.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(int i, long j, int i2, l lVar, String str, String str2, com.mbridge.msdk.preload.listenter.a aVar, boolean z2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        String a2;
        b bVar;
        long j2;
        k kVar;
        int a3;
        String str3;
        String str4;
        int i9;
        JSONArray jSONArray;
        List<Campaign> a4;
        List<Campaign> a5;
        try {
            com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d())).a();
            int f = this.d.f();
            int e = this.d.e();
            com.mbridge.msdk.mbnative.service.net.a aVar2 = new com.mbridge.msdk.mbnative.service.net.a(com.mbridge.msdk.foundation.controller.c.m().d());
            com.mbridge.msdk.foundation.same.net.wrapper.e eVar = new com.mbridge.msdk.foundation.same.net.wrapper.e();
            String b2 = com.mbridge.msdk.foundation.controller.c.m().b();
            String c2 = com.mbridge.msdk.foundation.controller.c.m().c();
            Map<String, Object> map = this.i;
            if (map != null && map.containsKey(MBridgeConstans.APP_ID) && this.i.containsKey(MBridgeConstans.APP_KEY) && this.i.containsKey(MBridgeConstans.KEY_WORD) && this.i.get(MBridgeConstans.KEY_WORD) != null) {
                if (this.i.get(MBridgeConstans.APP_ID) instanceof String) {
                    b2 = (String) this.i.get(MBridgeConstans.APP_ID);
                }
                if (this.i.get(MBridgeConstans.APP_KEY) instanceof String) {
                    c2 = (String) this.i.get(MBridgeConstans.APP_KEY);
                }
                String str5 = this.i.get(MBridgeConstans.KEY_WORD) instanceof String ? (String) this.i.get(MBridgeConstans.KEY_WORD) : null;
                if (!TextUtils.isEmpty(str5)) {
                    eVar.a("smart", j0.b(str5));
                }
            }
            String str6 = b2;
            String str7 = c2;
            eVar.a(MBridgeConstans.APP_ID, str6);
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            eVar.a("req_type", "1");
            if (!TextUtils.isEmpty(this.e)) {
                eVar.a("category", this.e);
            }
            if (!TextUtils.isEmpty(str2)) {
                eVar.a(MBridgeConstans.PLACEMENT_ID, str2);
            }
            eVar.a("sign", SameMD5.getMD5(str6 + str7));
            eVar.a("only_impression", "1");
            String d = u0.d(str);
            if (!TextUtils.isEmpty(d)) {
                eVar.a(com.mbridge.msdk.foundation.same.report.j.b, d);
            }
            int intValue = v.get(str).intValue();
            if (f != y && f != 0 && intValue != 0) {
                if (i2 == 0) {
                    com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>> a6 = com.mbridge.msdk.mbnative.cache.c.a(i);
                    if (z2) {
                        if (a6 != null && (a5 = a6.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) str, intValue)) != null && a5.size() > 0) {
                            a(true, aVar, (String) null);
                            return;
                        } else {
                            if (this.n) {
                                a("", i2, str, str2, aVar);
                                return;
                            }
                            return;
                        }
                    }
                    if (i != 1 && a6 != null && (a4 = a6.a((com.mbridge.msdk.mbnative.cache.b<String, List<Campaign>>) str, intValue)) != null && a4.size() > 0) {
                        a(true, aVar, (String) null);
                        return;
                    }
                }
                if (intValue != 0) {
                    eVar.a("ad_num", intValue + "");
                }
                if (this.h != 0) {
                    i3 = intValue;
                    eVar.a("frame_num", this.h + "");
                } else {
                    i3 = intValue;
                }
                if (this.i.containsKey(MBridgeConstans.NATIVE_INFO)) {
                    String str8 = (String) this.i.get(MBridgeConstans.NATIVE_INFO);
                    if (!TextUtils.isEmpty(str8)) {
                        p0.b(r, "nativeinfo" + str8);
                        try {
                            JSONArray jSONArray2 = new JSONArray(str8);
                            str3 = str8;
                            if (jSONArray2.length() > 0) {
                                int i10 = 0;
                                i5 = 0;
                                i6 = 0;
                                while (i10 < jSONArray2.length()) {
                                    try {
                                        JSONObject jSONObject = (JSONObject) jSONArray2.opt(i10);
                                        JSONArray jSONArray3 = jSONArray2;
                                        int i11 = i10;
                                        int optInt = jSONObject.optInt("id", 0);
                                        if (2 == optInt) {
                                            i5 = jSONObject.optInt("ad_num");
                                            if (f > 0) {
                                                jSONObject.put("ad_num", f);
                                            }
                                        } else if (3 == optInt) {
                                            i6 = jSONObject.optInt("ad_num");
                                            if (f > 0) {
                                                jSONObject.put("ad_num", f);
                                            }
                                        }
                                        i10 = i11 + 1;
                                        jSONArray2 = jSONArray3;
                                    } catch (JSONException e2) {
                                        e = e2;
                                        p0.b(r, com.mbridge.msdk.mbnative.common.a.a(e));
                                        str4 = str3;
                                        eVar.a(MBridgeConstans.NATIVE_INFO, str4);
                                        f = i3;
                                        i4 = i6;
                                        eVar.a("ad_num", f + "");
                                        eVar.a("ping_mode", "1");
                                        if (h.b().d(com.mbridge.msdk.foundation.controller.c.m().b()) == null) {
                                        }
                                        if (!NativeController.b(this.i)) {
                                        }
                                        a(eVar, i);
                                        if (u.containsKey(str)) {
                                        }
                                        i7 = 0;
                                        if (this.i.containsKey(MBridgeConstans.NATIVE_INFO)) {
                                        }
                                        if (i == i8) {
                                        }
                                        eVar.a("offset", i7 + "");
                                        eVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
                                        eVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i + "");
                                        a2 = com.mbridge.msdk.foundation.same.buffer.b.a(str, "native");
                                        if (!TextUtils.isEmpty(a2)) {
                                        }
                                        if (this.i.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH)) {
                                        }
                                        if (this.i.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT)) {
                                        }
                                        eVar.a("video_version", "2.0");
                                        bVar = new b(i);
                                        bVar.setUnitId(str);
                                        bVar.setPlacementId(str2);
                                        bVar.setAdType(42);
                                        bVar.d(i3);
                                        bVar.c(i5);
                                        bVar.e(i4);
                                        bVar.b(e);
                                        bVar.a(aVar);
                                        if (i == 1) {
                                        }
                                        bVar.b(true);
                                        bVar.b(NativeController.a(this.i));
                                        c cVar = new c(1, bVar, i2, str, str2);
                                        bVar.a(cVar);
                                        bVar.a(i2);
                                        cVar.a(aVar);
                                        cVar.a(z2);
                                        cVar.a(str);
                                        if (i2 != 0) {
                                        }
                                        this.f4509a.postDelayed(cVar, j2);
                                        return;
                                    }
                                }
                                i9 = i6;
                            } else {
                                i9 = 0;
                                i5 = 0;
                            }
                            jSONArray = jSONArray2;
                        } catch (JSONException e3) {
                            e = e3;
                            str3 = str8;
                            i5 = 0;
                            i6 = 0;
                        }
                        try {
                            this.o = Math.max(i5, i9);
                            i6 = i9;
                            str4 = jSONArray.toString();
                        } catch (JSONException e4) {
                            e = e4;
                            i6 = i9;
                            p0.b(r, com.mbridge.msdk.mbnative.common.a.a(e));
                            str4 = str3;
                            eVar.a(MBridgeConstans.NATIVE_INFO, str4);
                            f = i3;
                            i4 = i6;
                            eVar.a("ad_num", f + "");
                            eVar.a("ping_mode", "1");
                            if (h.b().d(com.mbridge.msdk.foundation.controller.c.m().b()) == null) {
                            }
                            if (!NativeController.b(this.i)) {
                            }
                            a(eVar, i);
                            if (u.containsKey(str)) {
                            }
                            i7 = 0;
                            if (this.i.containsKey(MBridgeConstans.NATIVE_INFO)) {
                            }
                            if (i == i8) {
                            }
                            eVar.a("offset", i7 + "");
                            eVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
                            eVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i + "");
                            a2 = com.mbridge.msdk.foundation.same.buffer.b.a(str, "native");
                            if (!TextUtils.isEmpty(a2)) {
                            }
                            if (this.i.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH)) {
                            }
                            if (this.i.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT)) {
                            }
                            eVar.a("video_version", "2.0");
                            bVar = new b(i);
                            bVar.setUnitId(str);
                            bVar.setPlacementId(str2);
                            bVar.setAdType(42);
                            bVar.d(i3);
                            bVar.c(i5);
                            bVar.e(i4);
                            bVar.b(e);
                            bVar.a(aVar);
                            if (i == 1) {
                            }
                            bVar.b(true);
                            bVar.b(NativeController.a(this.i));
                            c cVar2 = new c(1, bVar, i2, str, str2);
                            bVar.a(cVar2);
                            bVar.a(i2);
                            cVar2.a(aVar);
                            cVar2.a(z2);
                            cVar2.a(str);
                            if (i2 != 0) {
                            }
                            this.f4509a.postDelayed(cVar2, j2);
                            return;
                        }
                        eVar.a(MBridgeConstans.NATIVE_INFO, str4);
                        f = i3;
                        i4 = i6;
                        eVar.a("ad_num", f + "");
                        eVar.a("ping_mode", "1");
                        if (h.b().d(com.mbridge.msdk.foundation.controller.c.m().b()) == null) {
                            h.b().a();
                        }
                        if (!NativeController.b(this.i)) {
                            JSONArray b3 = u0.b(com.mbridge.msdk.foundation.controller.c.m().d(), str);
                            if (b3.length() > 0) {
                                eVar.a(com.mbridge.msdk.foundation.same.net.wrapper.e.h, u0.a(b3));
                            }
                        }
                        a(eVar, i);
                        if (u.containsKey(str) || (kVar = u.get(str)) == null) {
                            i7 = 0;
                        } else {
                            if (i == 1) {
                                a3 = kVar.a();
                            } else if (i != 2) {
                                a3 = kVar.a();
                            } else {
                                a3 = kVar.b();
                            }
                            i7 = a3;
                        }
                        if (this.i.containsKey(MBridgeConstans.NATIVE_INFO)) {
                            i8 = 1;
                            if (i == 1) {
                                eVar.a("tnum", this.o + "");
                                eVar.a("offset", i7 + "");
                                eVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
                                eVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i + "");
                                a2 = com.mbridge.msdk.foundation.same.buffer.b.a(str, "native");
                                if (!TextUtils.isEmpty(a2)) {
                                    eVar.a(com.mbridge.msdk.foundation.same.net.wrapper.e.g, a2);
                                }
                                if (this.i.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) && (this.i.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) instanceof Integer)) {
                                    eVar.a("video_width", ((Integer) this.i.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
                                }
                                if (this.i.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) && (this.i.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) instanceof Integer)) {
                                    eVar.a("video_height", ((Integer) this.i.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
                                }
                                eVar.a("video_version", "2.0");
                                bVar = new b(i);
                                bVar.setUnitId(str);
                                bVar.setPlacementId(str2);
                                bVar.setAdType(42);
                                bVar.d(i3);
                                bVar.c(i5);
                                bVar.e(i4);
                                bVar.b(e);
                                bVar.a(aVar);
                                if (i == 1 || z2) {
                                    bVar.b(true);
                                }
                                bVar.b(NativeController.a(this.i));
                                c cVar22 = new c(1, bVar, i2, str, str2);
                                bVar.a(cVar22);
                                bVar.a(i2);
                                cVar22.a(aVar);
                                cVar22.a(z2);
                                cVar22.a(str);
                                if (i2 != 0) {
                                    j2 = j;
                                    aVar2.choiceV3OrV5BySetting(1, eVar, bVar, "", com.mbridge.msdk.foundation.same.c.a(j2, 30000L));
                                } else {
                                    j2 = j;
                                    if (i2 == 1) {
                                        aVar2.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.utils.d.h().b0, eVar, bVar, "campaign", com.mbridge.msdk.foundation.same.c.a(j2, 30000L));
                                    }
                                }
                                this.f4509a.postDelayed(cVar22, j2);
                                return;
                            }
                        } else {
                            i8 = 1;
                        }
                        if (i == i8) {
                            eVar.a("tnum", this.p + "");
                        }
                        eVar.a("offset", i7 + "");
                        eVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
                        eVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i + "");
                        a2 = com.mbridge.msdk.foundation.same.buffer.b.a(str, "native");
                        if (!TextUtils.isEmpty(a2)) {
                        }
                        if (this.i.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH)) {
                            eVar.a("video_width", ((Integer) this.i.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
                        }
                        if (this.i.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT)) {
                            eVar.a("video_height", ((Integer) this.i.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
                        }
                        eVar.a("video_version", "2.0");
                        bVar = new b(i);
                        bVar.setUnitId(str);
                        bVar.setPlacementId(str2);
                        bVar.setAdType(42);
                        bVar.d(i3);
                        bVar.c(i5);
                        bVar.e(i4);
                        bVar.b(e);
                        bVar.a(aVar);
                        if (i == 1) {
                        }
                        bVar.b(true);
                        bVar.b(NativeController.a(this.i));
                        c cVar222 = new c(1, bVar, i2, str, str2);
                        bVar.a(cVar222);
                        bVar.a(i2);
                        cVar222.a(aVar);
                        cVar222.a(z2);
                        cVar222.a(str);
                        if (i2 != 0) {
                        }
                        this.f4509a.postDelayed(cVar222, j2);
                        return;
                    }
                } else if (f != z && f != 0) {
                    i4 = 0;
                    i5 = 0;
                    eVar.a("ad_num", f + "");
                    eVar.a("ping_mode", "1");
                    if (h.b().d(com.mbridge.msdk.foundation.controller.c.m().b()) == null) {
                    }
                    if (!NativeController.b(this.i)) {
                    }
                    a(eVar, i);
                    if (u.containsKey(str)) {
                    }
                    i7 = 0;
                    if (this.i.containsKey(MBridgeConstans.NATIVE_INFO)) {
                    }
                    if (i == i8) {
                    }
                    eVar.a("offset", i7 + "");
                    eVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
                    eVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i + "");
                    a2 = com.mbridge.msdk.foundation.same.buffer.b.a(str, "native");
                    if (!TextUtils.isEmpty(a2)) {
                    }
                    if (this.i.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH)) {
                    }
                    if (this.i.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT)) {
                    }
                    eVar.a("video_version", "2.0");
                    bVar = new b(i);
                    bVar.setUnitId(str);
                    bVar.setPlacementId(str2);
                    bVar.setAdType(42);
                    bVar.d(i3);
                    bVar.c(i5);
                    bVar.e(i4);
                    bVar.b(e);
                    bVar.a(aVar);
                    if (i == 1) {
                    }
                    bVar.b(true);
                    bVar.b(NativeController.a(this.i));
                    c cVar2222 = new c(1, bVar, i2, str, str2);
                    bVar.a(cVar2222);
                    bVar.a(i2);
                    cVar2222.a(aVar);
                    cVar2222.a(z2);
                    cVar2222.a(str);
                    if (i2 != 0) {
                    }
                    this.f4509a.postDelayed(cVar2222, j2);
                    return;
                }
                i5 = 0;
                i6 = 0;
                f = i3;
                i4 = i6;
                eVar.a("ad_num", f + "");
                eVar.a("ping_mode", "1");
                if (h.b().d(com.mbridge.msdk.foundation.controller.c.m().b()) == null) {
                }
                if (!NativeController.b(this.i)) {
                }
                a(eVar, i);
                if (u.containsKey(str)) {
                }
                i7 = 0;
                if (this.i.containsKey(MBridgeConstans.NATIVE_INFO)) {
                }
                if (i == i8) {
                }
                eVar.a("offset", i7 + "");
                eVar.a("ad_type", RoomMasterTable.DEFAULT_ID);
                eVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i + "");
                a2 = com.mbridge.msdk.foundation.same.buffer.b.a(str, "native");
                if (!TextUtils.isEmpty(a2)) {
                }
                if (this.i.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH)) {
                }
                if (this.i.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT)) {
                }
                eVar.a("video_version", "2.0");
                bVar = new b(i);
                bVar.setUnitId(str);
                bVar.setPlacementId(str2);
                bVar.setAdType(42);
                bVar.d(i3);
                bVar.c(i5);
                bVar.e(i4);
                bVar.b(e);
                bVar.a(aVar);
                if (i == 1) {
                }
                bVar.b(true);
                bVar.b(NativeController.a(this.i));
                c cVar22222 = new c(1, bVar, i2, str, str2);
                bVar.a(cVar22222);
                bVar.a(i2);
                cVar22222.a(aVar);
                cVar22222.a(z2);
                cVar22222.a(str);
                if (i2 != 0) {
                }
                this.f4509a.postDelayed(cVar22222, j2);
                return;
            }
            a("The request was refused", i2, str, str2, aVar);
        } catch (Exception e5) {
            String str9 = r;
            p0.b(str9, com.mbridge.msdk.mbnative.common.a.a(e5));
            p0.b(str9, e5.getMessage());
        }
    }

    public static void a(int i, String str) {
        k kVar;
        if (u.containsKey(str)) {
            kVar = u.get(str);
        } else {
            kVar = new k();
        }
        int intValue = v.get(str).intValue();
        int intValue2 = d().containsKey(str) ? d().get(str).intValue() : 1;
        if (i == 1) {
            int a2 = intValue + kVar.a();
            kVar.a(a2 <= intValue2 ? a2 : 0);
        } else if (i == 2) {
            int b2 = intValue + kVar.b();
            kVar.b(b2 <= intValue2 ? b2 : 0);
        }
        u.put(str, kVar);
    }

    public void a(String str, int i, String str2, String str3, com.mbridge.msdk.preload.listenter.a aVar) {
        Log.e(r, str);
        try {
            Queue<Integer> queue = this.f;
            if ((queue != null && queue.size() <= 0) || this.f == null) {
                a(false, aVar, str);
            } else {
                a(i, this.d, str2, str3, aVar);
            }
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    public void a(String str, String str2, String str3) {
        if (this.b == null) {
            this.b = new j();
        }
        this.b.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, str2, str3);
    }

    public void a(boolean z2, com.mbridge.msdk.preload.listenter.a aVar, String str) {
        if (z2) {
            if (aVar == null || aVar.a()) {
                return;
            }
            aVar.a(true);
            aVar.onPreloadSucceed();
            return;
        }
        if (aVar == null || aVar.a()) {
            return;
        }
        aVar.a(true);
        aVar.onPreloadFaild(str);
    }

    public void a(boolean z2, Campaign campaign) {
        if (campaign == null) {
            return;
        }
        if (z2 && campaign.getIconDrawable() == null) {
            campaign.loadIconUrlAsyncWithBlock(null);
        }
        if (z2 && campaign.getBigDrawable() == null) {
            campaign.loadImageUrlAsyncWithBlock(null);
        }
    }

    public void a(Thread thread) {
        if (!MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD) {
            thread.run();
        } else {
            thread.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<CampaignEx> list, String str) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    try {
                        int i = MBMediaView.p0;
                        Object invoke = com.mbridge.msdk.videocommon.download.b.class.getMethod(Constants.GET_INSTANCE, new Class[0]).invoke(null, new Object[0]);
                        if (invoke != null) {
                            com.mbridge.msdk.videocommon.download.b.class.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, com.mbridge.msdk.videocommon.listener.a.class).invoke(invoke, com.mbridge.msdk.foundation.controller.c.m().d(), str, new CopyOnWriteArrayList(list), 1, null);
                            com.mbridge.msdk.videocommon.download.b.class.getMethod("load", String.class).invoke(invoke, str);
                        }
                    } catch (Exception unused) {
                        p0.b(r, "please import the videocommon aar");
                    }
                }
            } catch (Exception e) {
                p0.b(r, com.mbridge.msdk.mbnative.common.a.a(e));
            }
        }
    }
}
