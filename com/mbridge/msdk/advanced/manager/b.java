package com.mbridge.msdk.advanced.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import androidx.core.app.NotificationCompat;
import com.iab.omid.library.mmadbridge.ScriptInjector;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
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
import com.mbridge.msdk.foundation.tools.z0;
import com.mbridge.msdk.out.MBridgeIds;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: NativeAdvancedLoadManager.java */
/* loaded from: classes6.dex */
public class b {
    private static String z = "NativeAdvancedLoadManager";

    /* renamed from: a, reason: collision with root package name */
    private String f3987a;
    private String b;
    private long c;
    private com.mbridge.msdk.advanced.middle.b d;
    private MBNativeAdvancedView f;
    private com.mbridge.msdk.setting.l g;
    private List<CampaignEx> h;
    private CampaignEx i;
    private int j;
    private int k;
    private int l;
    private int m;
    private String n;
    private int o;
    private boolean p;
    private volatile boolean q;
    private com.mbridge.msdk.videocommon.listener.a r;
    private H5DownLoadManager.ZipDownloadListener s;
    private H5DownLoadManager.ZipDownloadListener t;
    private String u;
    private int v;
    private String w = "";
    private Handler x = new e(Looper.getMainLooper());
    private Runnable y = new f();
    private Context e = com.mbridge.msdk.foundation.controller.c.m().d();

    /* compiled from: NativeAdvancedLoadManager.java */
    class a implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f3988a;
        final /* synthetic */ int b;

        a(CampaignEx campaignEx, int i) {
            this.f3988a = campaignEx;
            this.b = i;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            p0.a(b.z, "zip 下载失败： " + str2 + " " + str);
            Message obtain = Message.obtain();
            obtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f3988a);
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
            bundle.putInt("type", 3);
            obtain.obj = bundle;
            b.this.x.sendMessage(obtain);
            b.this.a(this.f3988a, str2, false, str);
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            p0.a(b.z, "zip 下载成功： " + str);
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = this.f3988a;
            obtain.arg1 = this.b;
            b.this.x.sendMessage(obtain);
            if (z) {
                return;
            }
            b.this.a(this.f3988a, str, true, "");
        }
    }

    /* compiled from: NativeAdvancedLoadManager.java */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MBNativeAdvancedWebview f3990a;
        final /* synthetic */ String b;

        c(MBNativeAdvancedWebview mBNativeAdvancedWebview, String str) {
            this.f3990a = mBNativeAdvancedWebview;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f3990a.loadUrl(this.b);
        }
    }

    /* compiled from: NativeAdvancedLoadManager.java */
    class e extends Handler {
        e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj;
            super.handleMessage(message);
            int i = message.what;
            if (i == 1) {
                Object obj2 = message.obj;
                int i2 = message.arg1;
                if (obj2 == null || !(obj2 instanceof CampaignEx)) {
                    return;
                }
                CampaignEx campaignEx = (CampaignEx) obj2;
                b.this.a(H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip()), campaignEx, i2);
                return;
            }
            if (i == 2) {
                Object obj3 = message.obj;
                try {
                    if (obj3 instanceof Bundle) {
                        int i3 = ((Bundle) obj3).getInt("type");
                        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(i3 == 1 ? 880004 : i3 == 2 ? 880007 : i3 == 3 ? 880006 : 880024);
                        String string = ((Bundle) obj3).getString(NotificationCompat.CATEGORY_MESSAGE);
                        CampaignEx campaignEx2 = (CampaignEx) ((Bundle) obj3).getSerializable("campaignex");
                        bVar.c(string);
                        bVar.a(campaignEx2);
                        b bVar2 = b.this;
                        bVar2.a(bVar, bVar2.n, b.this.o, campaignEx2);
                        return;
                    }
                    return;
                } catch (Exception e) {
                    com.mbridge.msdk.foundation.error.b bVar3 = new com.mbridge.msdk.foundation.error.b(880000);
                    bVar3.a((Throwable) e);
                    b bVar4 = b.this;
                    bVar4.a(bVar3, bVar4.n, b.this.o, (CampaignEx) null);
                    return;
                }
            }
            if (i == 3) {
                Object obj4 = message.obj;
                if (obj4 == null || !(obj4 instanceof CampaignEx)) {
                    return;
                }
                b bVar5 = b.this;
                bVar5.i((CampaignEx) obj4, bVar5.o);
                return;
            }
            if (i != 4) {
                if (i == 5 && (obj = message.obj) != null && (obj instanceof CampaignEx)) {
                    if (b.this.f != null) {
                        b.this.f.setVideoReady(true);
                    }
                    b bVar6 = b.this;
                    bVar6.i((CampaignEx) obj, bVar6.o);
                    return;
                }
                return;
            }
            Object obj5 = message.obj;
            if (obj5 == null || !(obj5 instanceof CampaignEx)) {
                return;
            }
            if (b.this.f != null) {
                b.this.f.setEndCardReady(true);
            }
            b bVar7 = b.this;
            bVar7.i((CampaignEx) obj5, bVar7.o);
        }
    }

    /* compiled from: NativeAdvancedLoadManager.java */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880010);
            b bVar2 = b.this;
            bVar2.a(bVar, bVar2.n, b.this.o, (CampaignEx) null);
        }
    }

    /* compiled from: NativeAdvancedLoadManager.java */
    class g extends com.mbridge.msdk.advanced.request.b {
        final /* synthetic */ String e;
        final /* synthetic */ int f;

        /* compiled from: NativeAdvancedLoadManager.java */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Exception f3994a;
            final /* synthetic */ int b;
            final /* synthetic */ CampaignUnit c;

            a(Exception exc, int i, CampaignUnit campaignUnit) {
                this.f3994a = exc;
                this.b = i;
                this.c = campaignUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880003);
                bVar.a((Throwable) this.f3994a);
                g gVar = g.this;
                b bVar2 = b.this;
                String str = gVar.e;
                int i = this.b;
                CampaignUnit campaignUnit = this.c;
                bVar2.a(bVar, str, i, (campaignUnit == null || campaignUnit.getAds() == null || this.c.getAds().size() == 0) ? null : this.c.getAds().get(0));
            }
        }

        /* compiled from: NativeAdvancedLoadManager.java */
        /* renamed from: com.mbridge.msdk.advanced.manager.b$g$b, reason: collision with other inner class name */
        class RunnableC0316b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f3995a;

            RunnableC0316b(String str) {
                this.f3995a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880002);
                bVar.c(this.f3995a);
                g gVar = g.this;
                b.this.a(bVar, gVar.e, gVar.f, (CampaignEx) null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(int i, String str, int i2) {
            super(i);
            this.e = str;
            this.f = i2;
        }

        @Override // com.mbridge.msdk.advanced.request.b
        public void a(CampaignUnit campaignUnit, int i) {
            try {
                b bVar = b.this;
                bVar.a(campaignUnit, i, bVar.f3987a, this.e);
                b.this.w = campaignUnit.getRequestId();
                b.this.h = campaignUnit.getAds();
            } catch (Exception e) {
                p0.b(b.z, e.getMessage());
                p0.c(b.z, "onLoadCompaginSuccess 数据刚请求失败");
                if (b.this.x != null) {
                    b.this.x.post(new a(e, i, campaignUnit));
                }
                b.this.f();
            }
        }

        @Override // com.mbridge.msdk.advanced.request.b
        public void b(int i, String str) {
            p0.b(b.z, str);
            p0.c(b.z, "onLoadCompaginFailed load failed errorCode:" + i + " msg:" + str);
            if (b.this.x != null) {
                b.this.x.post(new RunnableC0316b(str));
            }
            b.this.f();
        }
    }

    /* compiled from: NativeAdvancedLoadManager.java */
    class h extends c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f3996a;

        h(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            this.f3996a = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.c.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            com.mbridge.msdk.advanced.report.a.a(str, cVar, this.f3996a, b.this.e, null);
        }
    }

    /* compiled from: NativeAdvancedLoadManager.java */
    class i implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f3997a;

        i(CampaignEx campaignEx) {
            this.f3997a = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(b.this.e)).a();
            x.a(b.this.e, this.f3997a);
        }
    }

    /* compiled from: NativeAdvancedLoadManager.java */
    class j implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f3998a;
        final /* synthetic */ int b;

        /* compiled from: NativeAdvancedLoadManager.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j jVar = j.this;
                b.this.i(jVar.f3998a, jVar.b);
            }
        }

        /* compiled from: NativeAdvancedLoadManager.java */
        /* renamed from: com.mbridge.msdk.advanced.manager.b$j$b, reason: collision with other inner class name */
        class RunnableC0317b implements Runnable {
            RunnableC0317b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j jVar = j.this;
                b.this.i(jVar.f3998a, jVar.b);
            }
        }

        j(CampaignEx campaignEx, int i) {
            this.f3998a = campaignEx;
            this.b = i;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            p0.a(b.z, "gifurl 下载失败： " + str2);
            if (b.this.x != null) {
                b.this.x.post(new RunnableC0317b());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            p0.a(b.z, "giturl 下载成功： " + str);
            if (b.this.x != null) {
                b.this.x.post(new a());
            }
        }
    }

    /* compiled from: NativeAdvancedLoadManager.java */
    class k implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4001a;
        final /* synthetic */ int b;

        k(CampaignEx campaignEx, int i) {
            this.f4001a = campaignEx;
            this.b = i;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            p0.a(b.z, "endcard 下载失败： " + str2);
            if (b.this.f != null) {
                b.this.f.setEndCardReady(false);
            }
            Message obtain = Message.obtain();
            obtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f4001a);
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
            bundle.putInt("type", 2);
            obtain.obj = bundle;
            b.this.x.sendMessage(obtain);
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            p0.a(b.z, "endcard 下载成功： " + str);
            if (b.this.x != null) {
                Message obtain = Message.obtain();
                obtain.what = 4;
                obtain.obj = this.f4001a;
                obtain.arg1 = this.b;
                b.this.x.sendMessage(obtain);
            }
        }
    }

    /* compiled from: NativeAdvancedLoadManager.java */
    class l implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4002a;
        final /* synthetic */ int b;

        /* compiled from: NativeAdvancedLoadManager.java */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar = l.this;
                b.this.i(lVar.f4002a, lVar.b);
            }
        }

        /* compiled from: NativeAdvancedLoadManager.java */
        /* renamed from: com.mbridge.msdk.advanced.manager.b$l$b, reason: collision with other inner class name */
        class RunnableC0318b implements Runnable {
            RunnableC0318b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                l lVar = l.this;
                b.this.i(lVar.f4002a, lVar.b);
            }
        }

        l(CampaignEx campaignEx, int i) {
            this.f4002a = campaignEx;
            this.b = i;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            p0.a(b.z, "image 下载失败： " + str2);
            if (b.this.x != null) {
                b.this.x.post(new RunnableC0318b());
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            p0.a(b.z, "image 下载成功： " + str);
            if (b.this.x != null) {
                b.this.x.post(new a());
            }
        }
    }

    /* compiled from: NativeAdvancedLoadManager.java */
    class m implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f4005a;
        final /* synthetic */ CampaignEx b;
        final /* synthetic */ int c;

        m(File file, CampaignEx campaignEx, int i) {
            this.f4005a = file;
            this.b = campaignEx;
            this.c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a("file:////" + this.f4005a.getAbsolutePath(), this.b, this.c);
        }
    }

    public b(String str, String str2, long j2) {
        this.b = str;
        this.f3987a = str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(CampaignEx campaignEx, int i2) {
        if (!com.mbridge.msdk.advanced.manager.d.a(this.f, campaignEx, this.b, this.f3987a) || this.q) {
            return;
        }
        b();
        com.mbridge.msdk.advanced.manager.d.a(campaignEx, this.f3987a);
        this.q = true;
        com.mbridge.msdk.advanced.middle.b bVar = this.d;
        if (bVar != null) {
            bVar.a(campaignEx, i2);
        }
    }

    private void j(CampaignEx campaignEx, int i2) {
        this.i = campaignEx;
        if (com.mbridge.msdk.advanced.manager.d.a(this.f, campaignEx, this.b, this.f3987a)) {
            i(campaignEx, i2);
        } else {
            e(campaignEx, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.v = 0;
    }

    private void g() {
        try {
            int i2 = this.v + 1;
            this.v = i2;
            com.mbridge.msdk.setting.l lVar = this.g;
            if (lVar == null || i2 > lVar.y()) {
                p0.c(z, "onload 重置offset为0");
                this.v = 0;
            }
            p0.c(z, "onload 算出 下次的offset是:" + this.v);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CampaignEx campaignEx, int i2) {
        if (this.f.isH5Ready()) {
            i(campaignEx, i2);
            com.mbridge.msdk.advanced.report.a.a(1, "", this.f3987a, campaignEx);
        }
    }

    public String c() {
        return com.mbridge.msdk.foundation.same.c.b(this.h);
    }

    public String d() {
        return this.w;
    }

    public void e() {
        if (this.d != null) {
            this.d = null;
        }
        if (this.r != null) {
            this.r = null;
        }
        if (this.s != null) {
            this.s = null;
        }
    }

    private void c(CampaignEx campaignEx, int i2) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getImageUrl(), new l(campaignEx, i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c7 A[Catch: Exception -> 0x011f, all -> 0x013a, TRY_ENTER, TryCatch #6 {Exception -> 0x011f, blocks: (B:30:0x00c7, B:32:0x00cb, B:34:0x00d1, B:36:0x00d7, B:38:0x00dd, B:40:0x00ef, B:48:0x00f8, B:73:0x00a6), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d1 A[Catch: Exception -> 0x011f, all -> 0x013a, TryCatch #6 {Exception -> 0x011f, blocks: (B:30:0x00c7, B:32:0x00cb, B:34:0x00d1, B:36:0x00d7, B:38:0x00dd, B:40:0x00ef, B:48:0x00f8, B:73:0x00a6), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0110 A[Catch: IOException -> 0x012f, TRY_ENTER, TRY_LEAVE, TryCatch #3 {IOException -> 0x012f, blocks: (B:57:0x012b, B:42:0x0110), top: B:3:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r9v0, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(CampaignEx campaignEx, int i2) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        ?? r9;
        FileOutputStream fileOutputStream3;
        FileOutputStream fileOutputStream4 = null;
        try {
            try {
                try {
                    try {
                        com.mbridge.msdk.foundation.same.report.g.a("m_download_start", campaignEx, "", this.f3987a, "8");
                        ?? r7 = new File(campaignEx.getAdHtml());
                        try {
                            if (r7.exists()) {
                                fileOutputStream3 = r7;
                            } else {
                                String b = com.mbridge.msdk.foundation.same.directory.e.b(com.mbridge.msdk.foundation.same.directory.c.MBRIDGE_700_HTML);
                                String md5 = SameMD5.getMD5(b1.b(campaignEx.getAdHtml()));
                                if (TextUtils.isEmpty(md5)) {
                                    md5 = String.valueOf(System.currentTimeMillis());
                                }
                                ?? file = new File(b, md5.concat(".html"));
                                try {
                                    boolean exists = file.exists();
                                    fileOutputStream3 = file;
                                    if (!exists) {
                                        fileOutputStream = new FileOutputStream((File) file);
                                        try {
                                            StringBuilder sb = new StringBuilder("<script>");
                                            sb.append(com.mbridge.msdk.setting.util.a.a().b()).append("</script>");
                                            sb.append(campaignEx.getAdHtml());
                                            String injectScriptContentIntoHtml = ScriptInjector.injectScriptContentIntoHtml(MBridgeConstans.OMID_JS_SERVICE_CONTENT, sb.toString());
                                            if (campaignEx.isActiveOm()) {
                                                injectScriptContentIntoHtml = com.mbridge.msdk.omsdk.b.a(injectScriptContentIntoHtml);
                                            }
                                            fileOutputStream.write(injectScriptContentIntoHtml.getBytes());
                                            fileOutputStream.flush();
                                            fileOutputStream4 = fileOutputStream;
                                            fileOutputStream3 = file;
                                        } catch (Exception e2) {
                                            e = e2;
                                            fileOutputStream4 = fileOutputStream;
                                            r7 = file;
                                            e.printStackTrace();
                                            campaignEx.setMraid("");
                                            com.mbridge.msdk.foundation.same.report.g.a("m_download_end", campaignEx, e.getMessage(), this.f3987a, "8");
                                            if (fileOutputStream4 != null) {
                                            }
                                            r9 = r7;
                                            if (!r9.exists()) {
                                            }
                                            p0.a(z, "渲染 HTML 失败： html file write failed");
                                            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880013);
                                            a(bVar, this.n, i2, campaignEx);
                                            a(bVar, this.n, i2, campaignEx);
                                            if (fileOutputStream4 != null) {
                                            }
                                        } catch (Throwable th) {
                                            th = th;
                                            if (fileOutputStream != null) {
                                                try {
                                                    fileOutputStream.close();
                                                } catch (Exception unused) {
                                                    fileOutputStream4 = fileOutputStream;
                                                    a(new com.mbridge.msdk.foundation.error.b(880013), this.n, i2, campaignEx);
                                                    if (fileOutputStream4 != null) {
                                                        fileOutputStream4.close();
                                                    }
                                                    return;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    fileOutputStream4 = fileOutputStream;
                                                    if (fileOutputStream4 != null) {
                                                    }
                                                    throw th;
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                } catch (Exception e3) {
                                    e = e3;
                                }
                            }
                        } catch (Exception e4) {
                            e = e4;
                        }
                        try {
                            com.mbridge.msdk.foundation.same.report.g.a("m_download_end", campaignEx, "", this.f3987a, "8");
                            r9 = fileOutputStream3;
                            if (fileOutputStream4 != null) {
                                fileOutputStream4.close();
                                r9 = fileOutputStream3;
                            }
                        } catch (Exception e5) {
                            e = e5;
                            fileOutputStream2 = fileOutputStream4;
                            fileOutputStream4 = fileOutputStream3;
                            r7 = fileOutputStream4;
                            fileOutputStream4 = fileOutputStream2;
                            e.printStackTrace();
                            campaignEx.setMraid("");
                            com.mbridge.msdk.foundation.same.report.g.a("m_download_end", campaignEx, e.getMessage(), this.f3987a, "8");
                            if (fileOutputStream4 != null) {
                                fileOutputStream4.close();
                            }
                            r9 = r7;
                            if (!r9.exists()) {
                            }
                            p0.a(z, "渲染 HTML 失败： html file write failed");
                            com.mbridge.msdk.foundation.error.b bVar2 = new com.mbridge.msdk.foundation.error.b(880013);
                            a(bVar2, this.n, i2, campaignEx);
                            a(bVar2, this.n, i2, campaignEx);
                            if (fileOutputStream4 != null) {
                            }
                        }
                    } catch (IOException e6) {
                        p0.b(z, e6.getMessage());
                        return;
                    }
                } catch (Exception e7) {
                    e = e7;
                    fileOutputStream2 = null;
                }
                if (!r9.exists() && r9.isFile() && r9.canRead()) {
                    campaignEx.setAdHtml(r9.getAbsolutePath());
                    p0.a(z, "开始渲染 HTML： ");
                    Handler handler = this.x;
                    if (handler != null) {
                        handler.post(new m(r9, campaignEx, i2));
                    }
                } else {
                    p0.a(z, "渲染 HTML 失败： html file write failed");
                    com.mbridge.msdk.foundation.error.b bVar22 = new com.mbridge.msdk.foundation.error.b(880013);
                    a(bVar22, this.n, i2, campaignEx);
                    a(bVar22, this.n, i2, campaignEx);
                }
                if (fileOutputStream4 != null) {
                    fileOutputStream4.close();
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream = fileOutputStream4;
            }
        } catch (Throwable th4) {
            th = th4;
            if (fileOutputStream4 != null) {
                try {
                    fileOutputStream4.close();
                } catch (IOException e8) {
                    p0.b(z, e8.getMessage());
                }
            }
            throw th;
        }
    }

    private void f(CampaignEx campaignEx, int i2) {
        this.r = new d(campaignEx);
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.e, this.f3987a, copyOnWriteArrayList, 298, this.r);
        if (!com.mbridge.msdk.videocommon.download.b.getInstance().b(298, this.f3987a, campaignEx.isBidCampaign())) {
            p0.a(z, " load Video");
            com.mbridge.msdk.videocommon.download.b.getInstance().load(this.f3987a);
        } else {
            p0.a(z, " load Video isReady true");
            this.f.setVideoReady(true);
            i(campaignEx, i2);
        }
    }

    public void b(String str, int i2) {
        String str2;
        CampaignEx a2;
        this.q = false;
        this.n = str;
        this.o = i2;
        this.i = null;
        if (this.f == null) {
            a(new com.mbridge.msdk.foundation.error.b(880030), str, i2, (CampaignEx) null);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            a2 = com.mbridge.msdk.advanced.manager.d.a(this.f, this.b, this.f3987a, str, this.j, false, false);
            str2 = str;
        } else {
            str2 = str;
            a2 = com.mbridge.msdk.advanced.manager.d.a(this.f, this.b, this.f3987a, str2, this.j, false, true);
        }
        long timestamp = a2 != null ? a2.getTimestamp() : 0L;
        com.mbridge.msdk.setting.l lVar = this.g;
        if (lVar != null && lVar.t() == 1 && this.f != null && a2 != null) {
            j(a2, i2);
            return;
        }
        this.p = false;
        com.mbridge.msdk.setting.l lVar2 = this.g;
        if (lVar2 != null) {
            List<Integer> c2 = lVar2.c();
            if (c2 != null && c2.size() > 0) {
                this.c = c2.get(0).intValue() * 1000;
            } else {
                this.c = 30000L;
            }
        } else {
            this.c = 30000L;
        }
        p0.a(z, "开始从V3请求新的 offer，超时 ：" + this.c);
        if (this.g == null || timestamp <= 0 || !TextUtils.isEmpty(str2)) {
            a(this.c);
            a(this.e, str2, i2);
            return;
        }
        if (System.currentTimeMillis() - timestamp > this.g.v() * 1000) {
            a(this.c);
            a(this.e, str2, i2);
        } else {
            j(a2, i2);
        }
    }

    /* compiled from: NativeAdvancedLoadManager.java */
    class d implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f3991a;

        d(CampaignEx campaignEx) {
            this.f3991a = campaignEx;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            p0.a(b.z, "Video 下载成功： " + str);
            Message obtain = Message.obtain();
            obtain.obj = this.f3991a;
            obtain.what = 5;
            b.this.x.sendMessage(obtain);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            p0.a(b.z, "Video 下载失败： " + str);
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f3991a);
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
            bundle.putInt("type", 1);
            obtain.obj = bundle;
            obtain.what = 2;
            b.this.x.sendMessage(obtain);
        }
    }

    /* compiled from: NativeAdvancedLoadManager.java */
    /* renamed from: com.mbridge.msdk.advanced.manager.b$b, reason: collision with other inner class name */
    class C0315b extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f3989a;
        final /* synthetic */ int b;
        final /* synthetic */ long c;

        C0315b(CampaignEx campaignEx, int i, long j) {
            this.f3989a = campaignEx;
            this.b = i;
            this.c = j;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i) {
            super.a(webView, i);
            p0.b("NativeAdvancedLoadManager", "=========readyState: " + i);
            if (i != 1) {
                b.this.a(this.f3989a, "readyState 2", this.b);
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f3989a, b.this.f3987a, "readyState 2", this.c, 3);
            } else {
                b.this.f.setH5Ready(true);
                com.mbridge.msdk.advanced.common.c.a(b.this.b + b.this.f3987a + this.f3989a.getRequestId(), true);
                b.this.h(this.f3989a, this.b);
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f3989a, b.this.f3987a, "", this.c, 1);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) {
            super.a(webView, i, str, str2);
            p0.b("NativeAdvancedLoadManager", "onReceivedError： " + i + "  " + str + "  " + str2);
            b.this.a(this.f3989a, str, this.b);
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f3989a, b.this.f3987a, "error code:" + i + str, this.c, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            p0.b("NativeAdvancedLoadManager", "onReceivedSslError: " + sslError.getPrimaryError());
            b.this.a(this.f3989a, "onReceivedSslError:" + sslError.getUrl(), this.b);
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f3989a, b.this.f3987a, "error url:" + sslError.getUrl(), this.c, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            super.a(webView, str);
            p0.b("NativeAdvancedLoadManager", "onPageFinished");
            if (!this.f3989a.isHasMBTplMark()) {
                b.this.f.setH5Ready(true);
                p0.b("NativeAdvancedLoadManager", "=======onPageFinished OK");
                com.mbridge.msdk.advanced.common.c.a(b.this.b + b.this.f3987a + this.f3989a.getRequestId(), true);
                b.this.h(this.f3989a, this.b);
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f3989a, b.this.f3987a, "", this.c, 1);
            }
            com.mbridge.msdk.advanced.signal.a.a(webView);
        }
    }

    private void g(CampaignEx campaignEx, int i2) {
        String str;
        this.s = new a(campaignEx, i2);
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        cVar.a(campaignEx);
        if (campaignEx == null) {
            str = "";
        } else {
            r0 = campaignEx.getAabEntity() != null ? campaignEx.getAabEntity().h3c : 0;
            str = campaignEx.getAdZip();
        }
        cVar.f(r0);
        cVar.e(2);
        H5DownLoadManager.getInstance().downloadH5Res(cVar, str, this.s);
    }

    public void a(com.mbridge.msdk.setting.l lVar) {
        this.g = lVar;
    }

    private void e(CampaignEx campaignEx, int i2) {
        MBNativeAdvancedView mBNativeAdvancedView = this.f;
        if (mBNativeAdvancedView != null) {
            mBNativeAdvancedView.clearResState();
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            p0.a(z, "开始下载zip： " + campaignEx.getAdZip());
            g(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            p0.a(z, "开始下载HTML： " + campaignEx.getAdHtml());
            d(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            p0.a(z, "开始下载Video： " + campaignEx.getVideoUrlEncode());
            f(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getImageUrl())) {
            p0.a(z, "开始下载image： " + campaignEx.getImageUrl());
            c(campaignEx, i2);
        }
        if (!TextUtils.isEmpty(campaignEx.getendcard_url())) {
            p0.a(z, "开始下载EndCard： " + campaignEx.getendcard_url());
            a(campaignEx, i2);
        }
        if (TextUtils.isEmpty(campaignEx.getGifUrl())) {
            return;
        }
        p0.a(z, "开始下载gitUrl： " + campaignEx.getGifUrl());
        b(campaignEx, i2);
    }

    public void a(MBNativeAdvancedView mBNativeAdvancedView) {
        this.f = mBNativeAdvancedView;
    }

    public void a(int i2) {
        this.j = i2;
    }

    public void a(int i2, int i3) {
        this.m = i2;
        this.l = i3;
    }

    private void a(long j2) {
        this.x.postDelayed(this.y, j2);
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
                if (z0.a(this.f3987a)) {
                    a(new com.mbridge.msdk.foundation.error.b(880032), str, i2, (CampaignEx) null);
                    return;
                }
                try {
                    com.mbridge.msdk.advanced.manager.d.b(this.f3987a);
                } catch (Throwable th) {
                    p0.b(z, th.getMessage());
                }
                p0.c(z, "load 开始准备请求参数");
                MBridgeIds mBridgeIds = new MBridgeIds(this.b, this.f3987a);
                com.mbridge.msdk.advanced.request.f fVar = new com.mbridge.msdk.advanced.request.f();
                fVar.d(i2);
                fVar.c(this.v);
                fVar.a(this.u);
                fVar.b(this.m);
                fVar.a(this.l);
                com.mbridge.msdk.foundation.same.net.wrapper.e b = com.mbridge.msdk.advanced.request.e.b(context, mBridgeIds, fVar);
                if (b == null) {
                    p0.c(z, "load 请求参数为空 load失败");
                    a(new com.mbridge.msdk.foundation.error.b(880001), str, i2, (CampaignEx) null);
                    return;
                }
                if (!TextUtils.isEmpty(str)) {
                    b.a("token", str);
                }
                String d2 = u0.d(this.f3987a);
                if (!TextUtils.isEmpty(d2)) {
                    b.a(com.mbridge.msdk.foundation.same.report.j.b, d2);
                }
                str2 = str;
                try {
                    new com.mbridge.msdk.advanced.request.c(context).choiceV3OrV5BySetting(1, b, a(str, i2), str2, com.mbridge.msdk.foundation.same.c.a(this.c, 30000L));
                } catch (Exception e2) {
                    e = e2;
                    exc = e;
                    p0.b(z, exc.getMessage());
                    com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880020);
                    bVar.a((Throwable) exc);
                    a(bVar, str2, i2, (CampaignEx) null);
                    f();
                }
            } catch (Exception e3) {
                e = e3;
                str2 = str;
                exc = e;
                p0.b(z, exc.getMessage());
                com.mbridge.msdk.foundation.error.b bVar2 = new com.mbridge.msdk.foundation.error.b(880020);
                bVar2.a((Throwable) exc);
                a(bVar2, str2, i2, (CampaignEx) null);
                f();
            }
        } catch (Exception e4) {
            exc = e4;
            str2 = str;
        }
    }

    private void b() {
        this.x.removeCallbacks(this.y);
    }

    private void b(CampaignEx campaignEx, int i2) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getGifUrl(), new j(campaignEx, i2));
    }

    private com.mbridge.msdk.advanced.request.b a(String str, int i2) {
        g gVar = new g(i2, str, i2);
        gVar.a(str);
        gVar.setUnitId(this.f3987a);
        gVar.setPlacementId(this.b);
        gVar.setAdType(298);
        return gVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignUnit campaignUnit, int i2, String str, String str2) {
        String str3;
        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
        eVar.a("adtp", 298);
        if (!TextUtils.isEmpty(str2)) {
            eVar.a(CampaignEx.JSON_KEY_HB, 1);
        } else {
            eVar.a(CampaignEx.JSON_KEY_HB, 0);
        }
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            str3 = str2;
        } else {
            str3 = str2;
            campaignUnit.setLocalRequestId(com.mbridge.msdk.foundation.same.report.metrics.d.b().a(i2 == 1, str3, eVar, campaignUnit.getAds().get(0), str).o());
        }
        List<CampaignEx> a2 = a(campaignUnit);
        if (a2 != null && a2.size() > 0) {
            g();
            p0.c(z, "onload load成功 size:" + a2.size());
            CampaignEx campaignEx = a2.get(0);
            if (TextUtils.isEmpty(campaignEx.getAdZip()) && (TextUtils.isEmpty(campaignEx.getAdHtml()) || !campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
                campaignEx.setHasMBTplMark(false);
                campaignEx.setIsMraid(true);
            } else {
                campaignEx.setHasMBTplMark(true);
                campaignEx.setIsMraid(false);
            }
            j(campaignEx, i2);
            return;
        }
        p0.c(z, "onload load失败 返回的compaign没有可以用的");
        a(new com.mbridge.msdk.foundation.error.b(880033), str3, i2, (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() == 0) ? null : campaignUnit.getAds().get(0));
    }

    private List<CampaignEx> a(CampaignUnit campaignUnit) {
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        CampaignEx campaignEx = campaignUnit.getAds().get(0);
        campaignEx.setLocalRequestId(campaignUnit.getLocalRequestId());
        campaignEx.setCampaignUnitId(this.f3987a);
        a(campaignEx);
        this.u = campaignUnit.getSessionId();
        if (campaignEx.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx.getAdZip()) || !TextUtils.isEmpty(campaignEx.getAdHtml()))) {
            if (u0.c(campaignEx)) {
                campaignEx.setRtinsType(u0.c(this.e, campaignEx.getPackageName()) ? 1 : 2);
            }
            if (com.mbridge.msdk.foundation.same.c.b(this.e, campaignEx)) {
                arrayList.add(campaignEx);
            } else {
                u0.a(this.f3987a, campaignEx, com.mbridge.msdk.foundation.same.a.x);
            }
            a(campaignEx, (com.mbridge.msdk.foundation.same.report.metrics.c) null, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
        }
        return arrayList;
    }

    private void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        try {
            com.mbridge.msdk.foundation.same.c.a(campaignEx, this.e, cVar, new h(campaignEx, aVar));
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
        }
    }

    private void a(CampaignEx campaignEx) {
        new Thread(new i(campaignEx)).start();
    }

    public void a(com.mbridge.msdk.advanced.middle.b bVar) {
        this.d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.error.b bVar, String str, int i2, CampaignEx campaignEx) {
        if (this.p) {
            this.p = false;
            a(bVar, i2, str);
        } else {
            if (bVar != null) {
                bVar.a(campaignEx);
            }
            a(bVar, i2, campaignEx);
        }
    }

    private void a(com.mbridge.msdk.foundation.error.b bVar, int i2, String str) {
        CampaignEx a2 = com.mbridge.msdk.advanced.manager.d.a(this.f, this.b, this.f3987a, str, this.j, true, true);
        if (a2 != null) {
            p0.b(z, "load failed cache ");
            j(a2, i2);
        } else {
            a(bVar, i2, a2);
        }
    }

    private void a(com.mbridge.msdk.foundation.error.b bVar, int i2, CampaignEx campaignEx) {
        if (this.q) {
            return;
        }
        b();
        if (bVar != null) {
            p0.b(z, "real failed: " + bVar.g());
        }
        this.q = true;
        com.mbridge.msdk.advanced.middle.b bVar2 = this.d;
        if (bVar2 != null) {
            bVar2.a(bVar, i2);
        }
    }

    private void a(CampaignEx campaignEx, int i2) {
        String str;
        this.t = new k(campaignEx, i2);
        if (campaignEx == null) {
            str = "";
        } else {
            r4 = campaignEx.getAabEntity() != null ? campaignEx.getAabEntity().h3c : 0;
            str = campaignEx.getendcard_url();
        }
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        cVar.a(campaignEx);
        cVar.f(r4);
        H5DownLoadManager.getInstance().downloadH5Res(cVar, str, this.t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, CampaignEx campaignEx, int i2) {
        MBNativeAdvancedView mBNativeAdvancedView = this.f;
        if (mBNativeAdvancedView == null || mBNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        com.mbridge.msdk.advanced.report.a.b(this.f3987a, campaignEx);
        com.mbridge.msdk.advanced.signal.b bVar = new com.mbridge.msdk.advanced.signal.b(this.f.getContext(), this.b, this.f3987a);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        bVar.a(arrayList);
        bVar.a(this.j);
        bVar.b(this.k);
        this.f.setAdvancedNativeSignalCommunicationImpl(bVar);
        long currentTimeMillis = System.currentTimeMillis();
        MBNativeAdvancedWebview advancedNativeWebview = this.f.getAdvancedNativeWebview();
        if (advancedNativeWebview == null) {
            a(campaignEx, "webview is null", i2);
            return;
        }
        if (advancedNativeWebview.isDestoryed()) {
            a(campaignEx, "webview is destroyed", i2);
            return;
        }
        advancedNativeWebview.setWebViewListener(new C0315b(campaignEx, i2, currentTimeMillis));
        if (!advancedNativeWebview.isDestoryed()) {
            p0.b(z, "=======开始渲染: " + str);
            Handler handler = this.x;
            if (handler != null) {
                handler.post(new c(advancedNativeWebview, str));
                return;
            }
            return;
        }
        a(new com.mbridge.msdk.foundation.error.b(880031), this.n, i2, campaignEx);
        com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx, this.f3987a, "webview had destory", currentTimeMillis, 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, String str, int i2) {
        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880009);
        bVar.c(str);
        a(bVar, this.n, i2, campaignEx);
        com.mbridge.msdk.advanced.report.a.a(2, str, this.f3987a, campaignEx);
    }

    public String a(String str) {
        int j2;
        if (this.i != null) {
            try {
                com.mbridge.msdk.videocommon.download.a a2 = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f3987a, this.i.getId() + this.i.getVideoUrlEncode() + this.i.getBidToken());
                if (a2 != null && (j2 = a2.j()) == 5) {
                    String k2 = a2.k();
                    if (new File(k2).exists()) {
                        p0.b(z, "本地已下载完 拿本地播放地址：" + k2 + " state：" + j2);
                        return k2;
                    }
                }
            } catch (Exception e2) {
                p0.b(z, e2.getMessage());
            }
            return str;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, String str, boolean z2, String str2) {
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
            if (z2) {
                nVar.d(1);
            } else {
                nVar.d(3);
                nVar.m(str2);
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(nVar, campaignEx);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                p0.b(z, e2.getMessage());
            }
        }
    }
}
