package com.mbridge.msdk.splash.manager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.iab.omid.library.mmadbridge.ScriptInjector;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.setting.l;
import com.mbridge.msdk.splash.common.c;
import com.mbridge.msdk.splash.manager.g;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: SplashLoadManager.java */
/* loaded from: classes6.dex */
public class e {
    private static String A = "SplashLoadManager";

    /* renamed from: a, reason: collision with root package name */
    private String f4738a;
    private String b;
    private long c;
    private long d;
    private com.mbridge.msdk.splash.middle.b e;
    private MBSplashView g;
    private l h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private String m;
    private int n;
    private boolean o;
    private volatile boolean p;
    private com.mbridge.msdk.videocommon.listener.a q;
    private H5DownLoadManager.ZipDownloadListener r;
    private String s;
    private int t;
    private int v;
    private List<CampaignEx> w;
    private String u = "";
    private String x = "";
    private Handler y = new c(Looper.getMainLooper());
    private Runnable z = new d();
    private Context f = com.mbridge.msdk.foundation.controller.c.m().d();

    /* compiled from: SplashLoadManager.java */
    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                Object obj = message.obj;
                int i2 = message.arg1;
                if (obj instanceof CampaignEx) {
                    CampaignEx campaignEx = (CampaignEx) obj;
                    e.this.a(H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip()), campaignEx, i2);
                    return;
                }
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                Object obj2 = message.obj;
                if (obj2 instanceof CampaignEx) {
                    e eVar = e.this;
                    eVar.h((CampaignEx) obj2, eVar.n);
                    return;
                }
                return;
            }
            Object obj3 = message.obj;
            try {
                if (obj3 instanceof Bundle) {
                    int i3 = ((Bundle) obj3).getInt("type");
                    String string = ((Bundle) obj3).getString(NotificationCompat.CATEGORY_MESSAGE);
                    CampaignEx campaignEx2 = (CampaignEx) ((Bundle) obj3).getSerializable("campaignex");
                    com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(i3 == 1 ? 880004 : i3 == 2 ? 880006 : 880027);
                    bVar.c(string);
                    e eVar2 = e.this;
                    eVar2.a(bVar, eVar2.m, e.this.n, campaignEx2);
                }
            } catch (Exception e) {
                com.mbridge.msdk.foundation.error.b bVar2 = new com.mbridge.msdk.foundation.error.b(880024);
                bVar2.a((Throwable) e);
                e eVar3 = e.this;
                eVar3.a(bVar2, eVar3.m, e.this.n, (CampaignEx) null);
            }
        }
    }

    /* compiled from: SplashLoadManager.java */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880010);
            e eVar = e.this;
            eVar.a(bVar, eVar.m, e.this.n, (CampaignEx) null);
        }
    }

    /* compiled from: SplashLoadManager.java */
    /* renamed from: com.mbridge.msdk.splash.manager.e$e, reason: collision with other inner class name */
    class C0391e extends com.mbridge.msdk.splash.request.b {
        final /* synthetic */ String e;
        final /* synthetic */ int f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0391e(int i, String str, int i2) {
            super(i);
            this.e = str;
            this.f = i2;
        }

        @Override // com.mbridge.msdk.splash.request.b
        public void a(CampaignUnit campaignUnit, int i) {
            try {
                e eVar = e.this;
                eVar.a(campaignUnit, i, eVar.f4738a, this.e);
                e.this.u = campaignUnit.getRequestId();
                e.this.w = campaignUnit.getAds();
            } catch (Exception e) {
                e.printStackTrace();
                com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880003);
                bVar.a((Throwable) e);
                e.this.a(bVar, this.e, i, (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() == 0) ? null : campaignUnit.getAds().get(0));
                e.this.f();
            }
        }

        @Override // com.mbridge.msdk.splash.request.b
        public void b(int i, String str) {
            p0.b(e.A, str);
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880002);
            bVar.c(str);
            e.this.a(bVar, this.e, this.f, (CampaignEx) null);
            e.this.f();
        }
    }

    /* compiled from: SplashLoadManager.java */
    class f extends c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4743a;

        f(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            this.f4743a = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.c.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            com.mbridge.msdk.splash.report.a.a(str, cVar, this.f4743a, e.this.f, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
        }
    }

    /* compiled from: SplashLoadManager.java */
    class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4744a;

        g(CampaignEx campaignEx) {
            this.f4744a = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(e.this.f)).a();
            x.a(e.this.f, this.f4744a);
        }
    }

    /* compiled from: SplashLoadManager.java */
    class h implements com.mbridge.msdk.splash.view.nativeview.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4745a;
        final /* synthetic */ int b;

        h(CampaignEx campaignEx, int i) {
            this.f4745a = campaignEx;
            this.b = i;
        }

        @Override // com.mbridge.msdk.splash.view.nativeview.a
        public void a() {
            if (this.f4745a.isDynamicView() && e.this.g != null) {
                e.this.g.setImageReady(true);
                e.this.f(this.f4745a, this.b);
            }
            e.this.h(this.f4745a, this.b);
        }

        @Override // com.mbridge.msdk.splash.view.nativeview.a
        public void b() {
            if (!this.f4745a.isDynamicView() || e.this.g == null) {
                return;
            }
            e.this.g.setImageReady(false);
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880027);
            e eVar = e.this;
            eVar.a(bVar, eVar.m, this.b, this.f4745a);
        }
    }

    /* compiled from: SplashLoadManager.java */
    class i implements y.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4746a;

        i(CampaignEx campaignEx) {
            this.f4746a = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.tools.y.c
        public void a(String str, String str2, String str3, String str4, boolean z) {
            if (z) {
                return;
            }
            e.this.a(this.f4746a, str, true, "");
        }

        @Override // com.mbridge.msdk.foundation.tools.y.c
        public void a(String str, DownloadError downloadError) {
            String str2 = "";
            if (downloadError != null) {
                try {
                    if (downloadError.getException() != null) {
                        str2 = downloadError.getException().getMessage();
                    }
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            e.this.a(this.f4746a, str, false, str2);
        }
    }

    /* compiled from: SplashLoadManager.java */
    class j implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4747a;
        final /* synthetic */ int b;

        j(CampaignEx campaignEx, int i) {
            this.f4747a = campaignEx;
            this.b = i;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880006);
            e eVar = e.this;
            eVar.a(bVar, eVar.m, this.b, this.f4747a);
            Message obtain = Message.obtain();
            obtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f4747a);
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
            bundle.putInt("type", 2);
            obtain.obj = bundle;
            e.this.y.sendMessage(obtain);
            e.this.a(this.f4747a, str2, false, str);
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = this.f4747a;
            obtain.arg1 = this.b;
            e.this.y.sendMessage(obtain);
            if (z) {
                return;
            }
            CampaignEx campaignEx = this.f4747a;
            e.this.a(this.f4747a, campaignEx != null ? campaignEx.getAdZip() : "", true, "");
        }
    }

    /* compiled from: SplashLoadManager.java */
    class k implements com.mbridge.msdk.splash.inter.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4748a;
        final /* synthetic */ int b;

        k(CampaignEx campaignEx, int i) {
            this.f4748a = campaignEx;
            this.b = i;
        }

        @Override // com.mbridge.msdk.splash.inter.a
        public void a(View view) {
            if (e.this.g != null) {
                e.this.g.setDynamicView(true);
                e.this.g.setSplashNativeView(view);
                e.this.h(this.f4748a, this.b);
            }
        }

        @Override // com.mbridge.msdk.splash.inter.a
        public void onError(String str) {
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880034);
            bVar.c(str);
            e eVar = e.this;
            eVar.a(bVar, eVar.m, this.b, this.f4748a);
        }
    }

    public e(String str, String str2, long j2) {
        this.b = str;
        this.f4738a = str2;
        this.d = j2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CampaignEx campaignEx, int i2) {
        if (!com.mbridge.msdk.splash.manager.d.a(this.g, campaignEx) || this.p) {
            return;
        }
        b();
        if (this.o) {
            com.mbridge.msdk.splash.manager.d.a(campaignEx, this.f4738a);
        }
        this.p = true;
        com.mbridge.msdk.splash.middle.b bVar = this.e;
        if (bVar != null) {
            bVar.a(campaignEx, i2);
        }
    }

    private void i(CampaignEx campaignEx, int i2) {
        MBSplashView mBSplashView = this.g;
        if (mBSplashView != null) {
            mBSplashView.setDynamicView(false);
        }
        if (campaignEx.isDynamicView()) {
            c(campaignEx, i2);
        } else {
            MBSplashView mBSplashView2 = this.g;
            if (mBSplashView2 != null) {
                mBSplashView2.setSplashWebView();
            }
        }
        if (com.mbridge.msdk.splash.manager.d.a(this.g, campaignEx)) {
            h(campaignEx, i2);
        } else {
            a(campaignEx, i2);
        }
    }

    /* compiled from: SplashLoadManager.java */
    class a implements g.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4739a;
        final /* synthetic */ int b;

        a(CampaignEx campaignEx, int i) {
            this.f4739a = campaignEx;
            this.b = i;
        }

        @Override // com.mbridge.msdk.splash.manager.g.c
        public void a() {
            if (this.f4739a.isHasMBTplMark()) {
                return;
            }
            e.this.g(this.f4739a, this.b);
        }

        @Override // com.mbridge.msdk.splash.manager.g.c
        public void onError(String str) {
            e.this.a(str, this.b, this.f4739a);
        }

        @Override // com.mbridge.msdk.splash.manager.g.c
        public void a(int i) {
            if (i == 1) {
                e.this.g(this.f4739a, this.b);
            } else {
                e.this.a("readyState 2", this.b, this.f4739a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.t = 0;
    }

    private void g() {
        try {
            int i2 = this.t + 1;
            this.t = i2;
            l lVar = this.h;
            if (lVar == null || i2 > lVar.y()) {
                this.t = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String d() {
        return this.u;
    }

    public void e() {
        if (this.e != null) {
            this.e = null;
        }
        if (this.q != null) {
            this.q = null;
        }
        if (this.r != null) {
            this.r = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c9 A[Catch: Exception -> 0x010d, TRY_ENTER, TryCatch #2 {Exception -> 0x010d, blocks: (B:45:0x0109, B:46:0x010c, B:30:0x00c9, B:32:0x00cd, B:34:0x00d3, B:36:0x00d9, B:38:0x00df, B:41:0x00fb, B:50:0x00a8), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d3 A[Catch: Exception -> 0x010d, TryCatch #2 {Exception -> 0x010d, blocks: (B:45:0x0109, B:46:0x010c, B:30:0x00c9, B:32:0x00cd, B:34:0x00d3, B:36:0x00d9, B:38:0x00df, B:41:0x00fb, B:50:0x00a8), top: B:2:0x000e }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v6, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(CampaignEx campaignEx, int i2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        ?? r10;
        FileOutputStream fileOutputStream3;
        FileOutputStream fileOutputStream4 = null;
        try {
            try {
                try {
                    com.mbridge.msdk.foundation.same.report.g.a("m_download_start", campaignEx, "", this.f4738a, "6");
                    ?? r8 = new File(campaignEx.getAdHtml());
                    try {
                        if (r8.exists()) {
                            fileOutputStream3 = r8;
                        } else {
                            String b2 = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_HTML);
                            String md5 = SameMD5.getMD5(b1.b(campaignEx.getAdHtml()));
                            if (TextUtils.isEmpty(md5)) {
                                md5 = String.valueOf(System.currentTimeMillis());
                            }
                            ?? file = new File(b2, md5.concat(".html"));
                            try {
                                boolean exists = file.exists();
                                fileOutputStream3 = file;
                                if (!exists) {
                                    fileOutputStream2 = new FileOutputStream((File) file);
                                    try {
                                        StringBuilder sb = new StringBuilder("<script>");
                                        sb.append(com.mbridge.msdk.setting.util.a.a().b()).append("</script>");
                                        sb.append(campaignEx.getAdHtml());
                                        String injectScriptContentIntoHtml = ScriptInjector.injectScriptContentIntoHtml(MBridgeConstans.OMID_JS_SERVICE_CONTENT, sb.toString());
                                        if (campaignEx.isActiveOm()) {
                                            injectScriptContentIntoHtml = com.mbridge.msdk.omsdk.b.a(injectScriptContentIntoHtml);
                                        }
                                        fileOutputStream2.write(injectScriptContentIntoHtml.getBytes());
                                        fileOutputStream2.flush();
                                        fileOutputStream4 = fileOutputStream2;
                                        fileOutputStream3 = file;
                                    } catch (Exception e) {
                                        e = e;
                                        fileOutputStream4 = fileOutputStream2;
                                        r8 = file;
                                        e.printStackTrace();
                                        campaignEx.setMraid("");
                                        com.mbridge.msdk.foundation.same.report.g.a("m_download_end", campaignEx, e.getMessage(), this.f4738a, "6");
                                        if (fileOutputStream4 != null) {
                                        }
                                        r10 = r8;
                                        if (!r10.exists()) {
                                        }
                                        a(new com.mbridge.msdk.foundation.error.b(880013), this.m, i2, campaignEx);
                                    } catch (Throwable th) {
                                        th = th;
                                        if (fileOutputStream2 != null) {
                                            fileOutputStream2.close();
                                        }
                                        throw th;
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                    }
                    try {
                        com.mbridge.msdk.foundation.same.report.g.a("m_download_end", campaignEx, "", this.f4738a, "6");
                        r10 = fileOutputStream3;
                        if (fileOutputStream4 != null) {
                            fileOutputStream4.close();
                            r10 = fileOutputStream3;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        fileOutputStream = fileOutputStream4;
                        fileOutputStream4 = fileOutputStream3;
                        r8 = fileOutputStream4;
                        fileOutputStream4 = fileOutputStream;
                        e.printStackTrace();
                        campaignEx.setMraid("");
                        com.mbridge.msdk.foundation.same.report.g.a("m_download_end", campaignEx, e.getMessage(), this.f4738a, "6");
                        if (fileOutputStream4 != null) {
                            fileOutputStream4.close();
                        }
                        r10 = r8;
                        if (!r10.exists()) {
                        }
                        a(new com.mbridge.msdk.foundation.error.b(880013), this.m, i2, campaignEx);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    fileOutputStream2 = null;
                }
            } catch (Exception e5) {
                e = e5;
                fileOutputStream = null;
            }
            if (!r10.exists() && r10.isFile() && r10.canRead()) {
                campaignEx.setAdHtml(r10.getAbsolutePath());
                a("file:////" + r10.getAbsolutePath(), campaignEx, i2);
            } else {
                a(new com.mbridge.msdk.foundation.error.b(880013), this.m, i2, campaignEx);
            }
        } catch (Exception unused) {
            a(new com.mbridge.msdk.foundation.error.b(880013), this.m, i2, campaignEx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CampaignEx campaignEx, int i2) {
        if (campaignEx.isDynamicView()) {
            c.a aVar = new c.a();
            aVar.b(this.f4738a).a(this.b).a(this.i).a(campaignEx).c(this.j).f(this.v);
            try {
                if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
                    Uri parse = Uri.parse(campaignEx.getAdZip());
                    String queryParameter = parse.getQueryParameter("hdbtn");
                    String queryParameter2 = parse.getQueryParameter("alecfc");
                    String queryParameter3 = parse.getQueryParameter("hdinfo");
                    String queryParameter4 = parse.getQueryParameter("shake_show");
                    String queryParameter5 = parse.getQueryParameter("shake_strength");
                    String queryParameter6 = parse.getQueryParameter("shake_time");
                    String queryParameter7 = parse.getQueryParameter("n_logo");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        aVar.b(Integer.parseInt(queryParameter));
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        aVar.e(Integer.parseInt(queryParameter2));
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        aVar.a(Integer.parseInt(queryParameter3));
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        aVar.g(Integer.parseInt(queryParameter4));
                    }
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        aVar.h(Integer.parseInt(queryParameter5));
                    }
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        aVar.i(Integer.parseInt(queryParameter6));
                    }
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        aVar.d(Integer.parseInt(queryParameter7) == 0 ? 0 : 1);
                    }
                }
            } catch (Throwable th) {
                p0.b(A, th.getMessage());
            }
            com.mbridge.msdk.splash.manager.c.a().a(this.g, aVar.a(), new k(campaignEx, i2));
        }
    }

    public void b(int i2) {
        this.v = i2;
    }

    public String c() {
        return com.mbridge.msdk.foundation.same.c.b(this.w);
    }

    private void b() {
        this.y.removeCallbacks(this.z);
    }

    private void c(CampaignEx campaignEx, int i2) {
        com.mbridge.msdk.splash.manager.d.a(this.g, campaignEx, new h(campaignEx, i2));
    }

    /* compiled from: SplashLoadManager.java */
    class b implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4740a;

        b(CampaignEx campaignEx) {
            this.f4740a = campaignEx;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            e.this.g.setVideoReady(true);
            Message obtain = Message.obtain();
            obtain.obj = this.f4740a;
            obtain.what = 3;
            e.this.y.sendMessage(obtain);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            e.this.g.setVideoReady(false);
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880004);
            bVar.c(str);
            e eVar = e.this;
            eVar.a(bVar, eVar.m, e.this.n, this.f4740a);
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f4740a);
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
            bundle.putInt("type", 1);
            obtain.obj = bundle;
            obtain.what = 2;
            e.this.y.sendMessage(obtain);
        }
    }

    private void b(CampaignEx campaignEx, int i2) {
        this.q = new b(campaignEx);
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.f, this.f4738a, copyOnWriteArrayList, 297, this.q);
        if (!com.mbridge.msdk.videocommon.download.b.getInstance().b(297, this.f4738a, campaignEx.isBidCampaign())) {
            com.mbridge.msdk.videocommon.download.b.getInstance().load(this.f4738a);
        } else {
            this.g.setVideoReady(true);
            h(campaignEx, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CampaignEx campaignEx, int i2) {
        if (this.g.isH5Ready()) {
            return;
        }
        this.g.setH5Ready(true);
        h(campaignEx, i2);
    }

    private void e(CampaignEx campaignEx, int i2) {
        if (campaignEx.isDynamicView()) {
            y.a(5, "", campaignEx.getAdZip(), new i(campaignEx), campaignEx);
            return;
        }
        this.r = new j(campaignEx, i2);
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        cVar.a(297);
        cVar.e(2);
        cVar.a(campaignEx);
        cVar.f(campaignEx.getAabEntity() != null ? campaignEx.getAabEntity().h3c : 0);
        H5DownLoadManager.getInstance().downloadH5Res(cVar, campaignEx.getAdZip(), this.r);
    }

    public void a(l lVar) {
        this.h = lVar;
    }

    public void a(MBSplashView mBSplashView) {
        this.g = mBSplashView;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public void a(int i2) {
        this.j = i2;
    }

    public void a(int i2, int i3) {
        this.l = i2;
        this.k = i3;
    }

    public void a(String str, int i2) {
        this.p = false;
        this.m = str;
        this.n = i2;
        CampaignEx a2 = com.mbridge.msdk.splash.manager.d.a(this.g, this.b, this.f4738a, str, this.i, this.j, false, false);
        long timestamp = a2 != null ? a2.getTimestamp() : 0L;
        if (this.h.t() == 1 && i2 != 1 && a2 != null) {
            i(a2, i2);
            return;
        }
        this.o = true;
        if (i2 == 1) {
            List<Integer> c2 = this.h.c();
            if (c2 != null && c2.size() > 0) {
                this.c = c2.get(0).intValue() * 1000;
            } else {
                this.c = 30000L;
            }
        } else {
            long j2 = this.d;
            if (j2 <= 0) {
                this.c = this.h.E();
            } else {
                this.c = j2;
            }
        }
        if (this.h == null || timestamp <= 0 || !TextUtils.isEmpty(str)) {
            a(this.c);
            a(this.f, str, i2);
            return;
        }
        if (System.currentTimeMillis() - timestamp > this.h.v() * 1000) {
            a(this.c);
            a(this.f, str, i2);
        } else {
            i(a2, i2);
        }
    }

    private void a(long j2) {
        this.y.postDelayed(this.z, j2);
    }

    private void a(Context context, String str, int i2) {
        Exception exc;
        String str2;
        try {
            if (context == null) {
                a(new com.mbridge.msdk.foundation.error.b(880025), str, i2, (CampaignEx) null);
                return;
            }
            try {
                if (z0.a(this.f4738a)) {
                    a(new com.mbridge.msdk.foundation.error.b(880032), str, i2, (CampaignEx) null);
                    return;
                }
                MBridgeIds mBridgeIds = new MBridgeIds(this.b, this.f4738a);
                com.mbridge.msdk.splash.request.f fVar = new com.mbridge.msdk.splash.request.f();
                fVar.d(i2);
                fVar.c(this.t);
                fVar.a(this.s);
                fVar.b(this.l);
                fVar.a(this.k);
                com.mbridge.msdk.foundation.same.net.wrapper.e b2 = com.mbridge.msdk.splash.request.e.b(context, mBridgeIds, fVar);
                if (b2 == null) {
                    a(new com.mbridge.msdk.foundation.error.b(880001), str, i2, (CampaignEx) null);
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    b2.a("token", str);
                }
                String d2 = u0.d(this.f4738a);
                if (!TextUtils.isEmpty(d2)) {
                    b2.a(com.mbridge.msdk.foundation.same.report.j.b, d2);
                }
                com.mbridge.msdk.splash.request.c cVar = new com.mbridge.msdk.splash.request.c(context);
                C0391e c0391e = new C0391e(i2, str, i2);
                c0391e.a(str);
                c0391e.setUnitId(this.f4738a);
                c0391e.setPlacementId(this.b);
                c0391e.setAdType(297);
                str2 = str;
                try {
                    cVar.choiceV3OrV5BySetting(1, b2, c0391e, str2, com.mbridge.msdk.foundation.same.c.a(this.c, 30000L));
                } catch (Exception e) {
                    e = e;
                    exc = e;
                    p0.b(A, exc.getMessage());
                    com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880020);
                    bVar.a((Throwable) exc);
                    a(bVar, str2, i2, (CampaignEx) null);
                    f();
                }
            } catch (Exception e2) {
                e = e2;
                str2 = str;
            }
        } catch (Exception e3) {
            exc = e3;
            str2 = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignUnit campaignUnit, int i2, String str, String str2) {
        com.mbridge.msdk.foundation.error.b bVar;
        List<CampaignEx> a2 = a(campaignUnit);
        if (a2 != null && a2.size() > 0) {
            g();
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("adtp", 297);
            if (!TextUtils.isEmpty(str2)) {
                eVar.a(CampaignEx.JSON_KEY_HB, 1);
            } else {
                eVar.a(CampaignEx.JSON_KEY_HB, 0);
            }
            CampaignEx campaignEx = a2.get(0);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(true, str2, eVar, campaignEx, str);
            if (TextUtils.isEmpty(campaignEx.getAdZip()) && (TextUtils.isEmpty(campaignEx.getAdHtml()) || !campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
                campaignEx.setHasMBTplMark(false);
                campaignEx.setIsMraid(true);
            } else {
                campaignEx.setHasMBTplMark(true);
                campaignEx.setIsMraid(false);
            }
            i(campaignEx, i2);
            return;
        }
        if (this.x.contains("INSTALLED")) {
            bVar = new com.mbridge.msdk.foundation.error.b(880021, "APP ALREADY INSTALLED");
        } else {
            bVar = new com.mbridge.msdk.foundation.error.b(880003);
        }
        a(bVar, str2, i2, (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() == 0) ? null : campaignUnit.getAds().get(0));
    }

    private List<CampaignEx> a(CampaignUnit campaignUnit) {
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        CampaignEx campaignEx = campaignUnit.getAds().get(0);
        campaignEx.setCampaignUnitId(this.f4738a);
        a(campaignEx);
        this.s = campaignUnit.getSessionId();
        if (campaignEx.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx.getAdZip()) || !TextUtils.isEmpty(campaignEx.getAdHtml()))) {
            if (u0.c(campaignEx)) {
                campaignEx.setRtinsType(u0.c(this.f, campaignEx.getPackageName()) ? 1 : 2);
            }
            if (com.mbridge.msdk.foundation.same.c.b(this.f, campaignEx)) {
                arrayList.add(campaignEx);
            } else {
                u0.a(this.f4738a, campaignEx, com.mbridge.msdk.foundation.same.a.x);
                this.x = "APP ALREADY INSTALLED";
            }
            a(campaignEx, (com.mbridge.msdk.foundation.same.report.metrics.c) null, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
        }
        return arrayList;
    }

    private void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        try {
            com.mbridge.msdk.foundation.same.c.a(campaignEx, this.f, cVar, new f(campaignEx, aVar));
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        }
    }

    private void a(CampaignEx campaignEx) {
        new Thread(new g(campaignEx)).start();
    }

    public void a(com.mbridge.msdk.splash.middle.b bVar) {
        this.e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.error.b bVar, String str, int i2, CampaignEx campaignEx) {
        if (this.o) {
            this.o = false;
            a(bVar, i2, str, campaignEx);
        } else {
            a(bVar, i2, campaignEx);
        }
    }

    private void a(com.mbridge.msdk.foundation.error.b bVar, int i2, String str, CampaignEx campaignEx) {
        CampaignEx a2 = com.mbridge.msdk.splash.manager.d.a(this.g, this.b, this.f4738a, str, this.i, this.j, true, false);
        if (a2 != null) {
            i(a2, i2);
        } else {
            a(bVar, i2, campaignEx);
        }
    }

    private void a(com.mbridge.msdk.foundation.error.b bVar, int i2, CampaignEx campaignEx) {
        if (this.p) {
            return;
        }
        b();
        this.p = true;
        if (bVar != null) {
            bVar.a(campaignEx);
        }
        com.mbridge.msdk.splash.middle.b bVar2 = this.e;
        if (bVar2 != null) {
            bVar2.a(bVar, i2);
        }
    }

    private void a(CampaignEx campaignEx, int i2) {
        this.g.clearResState();
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            e(campaignEx, i2);
        }
        if (campaignEx.isDynamicView()) {
            return;
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            d(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            b(campaignEx, i2);
        }
        if (TextUtils.isEmpty(campaignEx.getImageUrl())) {
            return;
        }
        c(campaignEx, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, CampaignEx campaignEx, int i2) {
        g.d dVar = new g.d();
        dVar.c(this.f4738a);
        dVar.b(this.b);
        dVar.a(campaignEx);
        dVar.a(str);
        dVar.a(this.i);
        dVar.a(this.j);
        com.mbridge.msdk.splash.manager.g.a().a(this.g, dVar, new a(campaignEx, i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i2, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880009);
        bVar.c(str);
        a(bVar, this.m, i2, campaignEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, String str, boolean z, String str2) {
        try {
            n nVar = new n();
            nVar.e(2);
            nVar.j("m_download_end");
            if (campaignEx != null) {
                nVar.b(campaignEx.isMraid() ? n.N : n.O);
                nVar.o(campaignEx.getRequestIdNotice());
            }
            nVar.b("url", str);
            nVar.b("scenes", "1");
            if (z) {
                nVar.d(1);
            } else {
                nVar.d(3);
                nVar.m(str2);
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(nVar, campaignEx);
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                p0.b(A, e.getMessage());
            }
        }
    }
}
