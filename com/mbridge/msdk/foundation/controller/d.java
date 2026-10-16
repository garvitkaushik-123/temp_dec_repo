package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.foundation.controller.a;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.f;
import com.mbridge.msdk.foundation.tools.j0;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler;
import com.mbridge.msdk.out.MBRewardVideoHandler;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.j;
import com.unity3d.services.core.fid.Constants;
import java.util.List;
import java.util.Map;

/* compiled from: SDKController.java */
/* loaded from: classes6.dex */
public class d {
    private static volatile d l;

    /* renamed from: a, reason: collision with root package name */
    private int f4208a;
    private Map<String, Object> b;
    private FastKV c;
    private boolean d = false;
    private String e;
    private String f;
    private String g;
    private Context h;
    private String i;
    private com.mbridge.msdk.preload.a j;
    private String k;

    /* compiled from: SDKController.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f4209a;

        a(Context context) {
            this.f4209a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            l0.h(this.f4209a);
        }
    }

    /* compiled from: SDKController.java */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Looper.prepare();
            d.this.g();
            d.this.d();
            Looper.loop();
        }
    }

    /* compiled from: SDKController.java */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar = d.this;
            dVar.a(dVar.e);
            new h(d.this.h).a();
        }
    }

    /* compiled from: SDKController.java */
    /* renamed from: com.mbridge.msdk.foundation.controller.d$d, reason: collision with other inner class name */
    class C0331d implements a.e {
        C0331d() {
        }
    }

    /* compiled from: SDKController.java */
    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4213a;

        e(String str) {
            this.f4213a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(350L);
            } catch (InterruptedException e) {
                p0.b("SDKController", e.getMessage());
            }
            new j().b(d.this.h, this.f4213a, d.this.f);
        }
    }

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            com.mbridge.msdk.timer.b.class.getDeclaredMethod("start", new Class[0]).invoke(com.mbridge.msdk.timer.b.class.getMethod(Constants.GET_INSTANCE, new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Throwable th) {
            p0.b("SDKController", th.getMessage(), th);
        }
    }

    public boolean e() {
        return true;
    }

    public void f() {
    }

    private void c() {
        com.mbridge.msdk.foundation.controller.c.m().b(this.h);
        com.mbridge.msdk.foundation.controller.c.m().e(this.e);
        com.mbridge.msdk.foundation.controller.c.m().f(this.f);
        com.mbridge.msdk.foundation.controller.c.m().d(this.k);
        com.mbridge.msdk.foundation.controller.c.m().b(this.g);
        com.mbridge.msdk.foundation.controller.c.m().c(new C0331d());
        try {
            com.mbridge.msdk.foundation.same.net.utils.d.h().j();
        } catch (Throwable th) {
            p0.b("SDKController", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        List<com.mbridge.msdk.foundation.entity.a> g;
        Object newInstance;
        Object newInstance2;
        try {
            g d = com.mbridge.msdk.setting.h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
            if (d == null || (g = d.g()) == null || g.size() <= 0) {
                return;
            }
            for (com.mbridge.msdk.foundation.entity.a aVar : g) {
                if (aVar.a() == 287) {
                    if (this.h != null && (newInstance = MBInterstitialVideoHandler.class.getConstructor(String.class, String.class).newInstance("", aVar.b())) != null) {
                        MBInterstitialVideoHandler.class.getMethod("loadFormSelfFilling", new Class[0]).invoke(newInstance, new Object[0]);
                    }
                } else if (aVar.a() == 94 && (newInstance2 = MBRewardVideoHandler.class.getConstructor(String.class, String.class).newInstance("", aVar.b())) != null) {
                    MBRewardVideoHandler.class.getMethod("loadFormSelfFilling", new Class[0]).invoke(newInstance2, new Object[0]);
                }
            }
        } catch (Throwable th) {
            p0.b("SDKController", th.getMessage());
        }
    }

    public void b() {
        a(this.h.getApplicationContext());
        try {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new b());
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new c());
            com.mbridge.msdk.foundation.same.report.j.b();
        } catch (Exception unused) {
            p0.b("SDKController", "get app setting failed");
        }
        this.d = true;
    }

    public static d a() {
        if (l == null) {
            synchronized (d.class) {
                if (l == null) {
                    l = new d();
                }
            }
        }
        return l;
    }

    public void a(Map map, Context context) {
        Object obj;
        if (context != null) {
            if (!TextUtils.isEmpty(MBridgeConstans.DEVELOPER_CUSTOM_PACKAGE)) {
                com.mbridge.msdk.foundation.controller.c.m().c(MBridgeConstans.DEVELOPER_CUSTOM_PACKAGE);
            } else if (map.containsKey(MBridgeConstans.KEY_MBRIDGE_CUSTOM_PACKAGE_NAME) && (obj = map.get(MBridgeConstans.KEY_MBRIDGE_CUSTOM_PACKAGE_NAME)) != null) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    com.mbridge.msdk.foundation.controller.c.m().c(str);
                }
            }
            if (map != null) {
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPID)) {
                    this.e = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPKEY)) {
                    this.f = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPKEY);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_WX_APPID)) {
                    this.k = (String) map.get(MBridgeConstans.ID_MBRIDGE_WX_APPID);
                }
                if (map.containsKey(MBridgeConstans.PACKAGE_NAME_MANIFEST)) {
                    this.g = (String) map.get(MBridgeConstans.PACKAGE_NAME_MANIFEST);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH)) {
                    this.i = (String) map.get(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH);
                }
            }
            this.h = context.getApplicationContext();
            c();
            if (this.d) {
                return;
            }
            b();
            l0.l(context);
            long x0 = com.mbridge.msdk.setting.h.b().b(this.e).x0();
            if (x0 != 1300) {
                new Handler(Looper.getMainLooper()).postDelayed(new a(context), x0);
            }
        }
    }

    public void b(String str) {
        if (this.j == null) {
            this.j = new com.mbridge.msdk.preload.a();
        }
        try {
            Map<String, Object> map = this.b;
            if (map == null || map.size() <= 0 || !this.b.containsKey(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)) {
                return;
            }
            int intValue = ((Integer) this.b.get(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)).intValue();
            if (intValue == 0) {
                this.j.a(this.b, this.f4208a);
                return;
            }
            if (1 == intValue) {
                this.j.a(this.b);
            } else if (2 == intValue) {
                this.j.b(this.b);
            } else {
                p0.b("SDKController", "unknow layout type in preload");
            }
        } catch (Exception e2) {
            p0.b("SDKController", e2.getMessage());
        }
    }

    private void a(Context context) {
        String str;
        try {
            if (e() && this.c == null) {
                try {
                    this.c = new FastKV.Builder(com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_CONFIG), j0.a("H+tU+FeXHM==")).build();
                } catch (Exception unused) {
                    this.c = null;
                }
            }
            FastKV fastKV = this.c;
            String str2 = "";
            if (fastKV != null) {
                String string = fastKV.getString(j0.a("H+tU+bfPhM=="), "");
                String string2 = this.c.getString(j0.a("H+tU+Fz8"), "");
                if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                    com.mbridge.msdk.foundation.same.a.V = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                    com.mbridge.msdk.foundation.same.a.g = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c");
                }
                if (TextUtils.isEmpty(string) && TextUtils.isEmpty(string2)) {
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                        return;
                    }
                    this.c.putString(j0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                    this.c.putString(j0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                    return;
                }
                com.mbridge.msdk.foundation.same.a.V = string;
                com.mbridge.msdk.foundation.same.a.g = string2;
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
                com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c", com.mbridge.msdk.foundation.same.a.g);
                return;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(j0.a("H+tU+FeXHM=="), 0);
            if (sharedPreferences != null) {
                str2 = sharedPreferences.getString(j0.a("H+tU+bfPhM=="), "");
                str = sharedPreferences.getString(j0.a("H+tU+Fz8"), "");
            } else {
                str = "";
            }
            if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) {
                com.mbridge.msdk.foundation.same.a.V = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                com.mbridge.msdk.foundation.same.a.g = com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c");
            }
            if (TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                if ((TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.V) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.g)) || sharedPreferences == null) {
                    return;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(j0.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.V);
                edit.putString(j0.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.g);
                edit.apply();
                return;
            }
            com.mbridge.msdk.foundation.same.a.V = str2;
            com.mbridge.msdk.foundation.same.a.g = str;
            com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.V);
            com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("c", com.mbridge.msdk.foundation.same.a.g);
        } catch (Throwable th) {
            p0.b("SDKController", th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (com.mbridge.msdk.setting.h.b() == null) {
            return;
        }
        com.mbridge.msdk.setting.h b2 = com.mbridge.msdk.setting.h.b();
        if (b2 != null) {
            g d = b2.d(str);
            if (d != null) {
                MBridgeConstans.OMID_JS_SERVICE_URL = d.U();
                MBridgeConstans.OMID_JS_H5_URL = d.T();
                if (!TextUtils.isEmpty(d.u())) {
                    com.mbridge.msdk.foundation.same.net.utils.d.h().i = d.u();
                    com.mbridge.msdk.foundation.same.net.utils.d.h().e();
                }
                if (!TextUtils.isEmpty(d.v())) {
                    com.mbridge.msdk.foundation.same.net.utils.d.h().m = d.v();
                    com.mbridge.msdk.foundation.same.net.utils.d.h().f();
                }
            } else {
                MBridgeConstans.OMID_JS_SERVICE_URL = com.mbridge.msdk.setting.net.b.b;
                MBridgeConstans.OMID_JS_H5_URL = com.mbridge.msdk.setting.net.b.f4707a;
            }
        }
        if (com.mbridge.msdk.setting.h.b().f(str) && com.mbridge.msdk.setting.h.b().a(str, 1, (String) null)) {
            if (com.mbridge.msdk.foundation.buffer.sharedperference.a.b().a("is_first_init", 0) == 0) {
                try {
                    com.mbridge.msdk.foundation.buffer.sharedperference.a.b().b("is_first_init", 1);
                    if (TextUtils.isEmpty(f.d())) {
                        com.mbridge.msdk.foundation.same.threadpool.a.b().execute(new e(str));
                        return;
                    } else {
                        new j().b(this.h, str, this.f);
                        return;
                    }
                } catch (Throwable unused) {
                    new j().b(this.h, str, this.f);
                    return;
                }
            }
            new j().b(this.h, str, this.f);
        }
    }

    public void a(Map<String, Object> map, int i) {
        if (MBridgeSDKFactory.getMBridgeSDK().getStatus() != MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            p0.b("SDKController", "preloaad failed,sdk do not inited");
            return;
        }
        this.b = map;
        this.f4208a = i;
        String b2 = com.mbridge.msdk.foundation.controller.c.m().b();
        if (map != null) {
            b(b2);
        }
    }
}
