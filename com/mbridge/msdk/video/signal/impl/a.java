package com.mbridge.msdk.video.signal.impl;

import android.app.Activity;
import com.iab.omid.library.mmadbridge.adsession.AdEvents;
import com.iab.omid.library.mmadbridge.adsession.AdSession;
import com.iab.omid.library.mmadbridge.adsession.media.MediaEvents;
import com.ironsource.C3040d4;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.video.signal.a;

/* compiled from: BaseDefaultJSCommon.java */
/* loaded from: classes6.dex */
public abstract class a implements com.mbridge.msdk.video.signal.d {
    protected String j;
    protected com.mbridge.msdk.videocommon.setting.c k;
    protected com.mbridge.msdk.click.a l;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f5255a = false;
    protected boolean b = false;
    protected int c = 0;
    protected int d = 0;
    protected int e = 0;
    protected int f = 0;
    protected int g = 0;
    protected int h = 1;
    protected int i = -1;
    public a.InterfaceC0418a m = new C0419a();
    protected int n = 2;
    protected int o = 2;
    private AdSession p = null;
    private MediaEvents q = null;
    private AdEvents r = null;

    /* compiled from: BaseDefaultJSCommon.java */
    /* renamed from: com.mbridge.msdk.video.signal.impl.a$a, reason: collision with other inner class name */
    public static class C0419a implements a.InterfaceC0418a {
        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0418a
        public void a(boolean z) {
            p0.a("DefaultJSCommon", "onStartInstall");
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDismissLoading(Campaign campaign) {
            p0.a("DefaultJSCommon", "onDismissLoading,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadFinish(Campaign campaign) {
            p0.a("DefaultJSCommon", "onDownloadFinish,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadProgress(int i) {
            p0.a("DefaultJSCommon", "onDownloadProgress,progress:" + i);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadStart(Campaign campaign) {
            p0.a("DefaultJSCommon", "onDownloadStart,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            p0.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0418a
        public void onInitSuccess() {
            p0.a("DefaultJSCommon", "onInitSuccess");
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public boolean onInterceptDefaultLoadingDialog() {
            p0.a("DefaultJSCommon", "onInterceptDefaultLoadingDialog");
            return false;
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            p0.a("DefaultJSCommon", "onFinishRedirection,campaign:" + campaign + ",url:" + str);
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onShowLoading(Campaign campaign) {
            p0.a("DefaultJSCommon", "onShowLoading,campaign:" + campaign);
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            p0.a("DefaultJSCommon", "onStartRedirection,campaign:" + campaign + ",url:" + str);
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0418a
        public void a(int i, String str) {
            p0.a("DefaultJSCommon", "onH5Error,code:" + i + "，msg:" + str);
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0418a
        public void a() {
            p0.a("DefaultJSCommon", "videoLocationReady");
        }
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(boolean z) {
        p0.a("DefaultJSCommon", "setIsShowingTransparent:" + z);
        this.b = z;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void b(int i) {
        this.c = i;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void c(int i) {
        this.e = i;
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void click(int i, String str) {
        p0.a("DefaultJSCommon", "click:type" + i + ",pt:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void d(int i) {
        p0.a("DefaultJSCommon", "setAlertDialogRole " + i);
        this.h = i;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void e(int i) {
        this.d = i;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String f(int i) {
        p0.a("DefaultJSCommon", "getSDKInfo");
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void g(int i) {
        this.n = i;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void h() {
    }

    @Override // com.mbridge.msdk.video.signal.e
    public void handlerH5Exception(int i, String str) {
        p0.a("DefaultJSCommon", "handlerH5Exception,code=" + i + ",msg:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public int i() {
        return this.i;
    }

    public AdEvents j() {
        return this.r;
    }

    public AdSession k() {
        return this.p;
    }

    public int l() {
        if (this.c == 0 && this.b) {
            this.c = 1;
        }
        return this.c;
    }

    public int m() {
        if (this.d == 0 && this.b) {
            this.d = 1;
        }
        return this.d;
    }

    public int n() {
        if (this.e == 0 && this.b) {
            this.e = 1;
        }
        return this.e;
    }

    public MediaEvents o() {
        return this.q;
    }

    public boolean p() {
        return this.b;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void release() {
        p0.a("DefaultJSCommon", "release");
        com.mbridge.msdk.click.a aVar = this.l;
        if (aVar != null) {
            aVar.a(false);
            this.l.a((NativeListener.NativeTrackingListener) null);
            this.l.c();
        }
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setActivity(Activity activity) {
        p0.a("DefaultJSCommon", "setActivity ");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setAdEvents(AdEvents adEvents) {
        this.r = adEvents;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setAdSession(AdSession adSession) {
        this.p = adSession;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setRewardUnitSetting(com.mbridge.msdk.videocommon.setting.c cVar) {
        p0.a("DefaultJSCommon", "setSetting:" + cVar);
        this.k = cVar;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setUnitId(String str) {
        p0.a("DefaultJSCommon", "setUnitId:" + str);
        this.j = str;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setVideoEvents(MediaEvents mediaEvents) {
        this.q = mediaEvents;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void setWebViewFront(int i) {
        this.g = i;
    }

    /* compiled from: BaseDefaultJSCommon.java */
    public static class b implements a.InterfaceC0418a {

        /* renamed from: a, reason: collision with root package name */
        private com.mbridge.msdk.video.signal.d f5256a;
        private a.InterfaceC0418a b;

        public b(com.mbridge.msdk.video.signal.d dVar, a.InterfaceC0418a interfaceC0418a) {
            this.f5256a = dVar;
            this.b = interfaceC0418a;
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0418a
        public void a(boolean z) {
            a.InterfaceC0418a interfaceC0418a = this.b;
            if (interfaceC0418a != null) {
                interfaceC0418a.a(z);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDismissLoading(Campaign campaign) {
            a.InterfaceC0418a interfaceC0418a = this.b;
            if (interfaceC0418a != null) {
                interfaceC0418a.onDismissLoading(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadFinish(Campaign campaign) {
            a.InterfaceC0418a interfaceC0418a = this.b;
            if (interfaceC0418a != null) {
                interfaceC0418a.onDownloadFinish(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadProgress(int i) {
            a.InterfaceC0418a interfaceC0418a = this.b;
            if (interfaceC0418a != null) {
                interfaceC0418a.onDownloadProgress(i);
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onDownloadStart(Campaign campaign) {
            a.InterfaceC0418a interfaceC0418a = this.b;
            if (interfaceC0418a != null) {
                interfaceC0418a.onDownloadStart(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onFinishRedirection(Campaign campaign, String str) {
            a.InterfaceC0418a interfaceC0418a = this.b;
            if (interfaceC0418a != null) {
                interfaceC0418a.onFinishRedirection(campaign, str);
            }
            com.mbridge.msdk.video.signal.d dVar = this.f5256a;
            if (dVar != null) {
                dVar.f();
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0418a
        public void onInitSuccess() {
            a.InterfaceC0418a interfaceC0418a = this.b;
            if (interfaceC0418a != null) {
                interfaceC0418a.onInitSuccess();
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public boolean onInterceptDefaultLoadingDialog() {
            a.InterfaceC0418a interfaceC0418a = this.b;
            return interfaceC0418a != null && interfaceC0418a.onInterceptDefaultLoadingDialog();
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onRedirectionFailed(Campaign campaign, String str) {
            a.InterfaceC0418a interfaceC0418a = this.b;
            if (interfaceC0418a != null) {
                interfaceC0418a.onRedirectionFailed(campaign, str);
            }
            com.mbridge.msdk.video.signal.d dVar = this.f5256a;
            if (dVar != null) {
                dVar.f();
            }
        }

        @Override // com.mbridge.msdk.out.NativeListener.NativeTrackingListener
        public void onShowLoading(Campaign campaign) {
            a.InterfaceC0418a interfaceC0418a = this.b;
            if (interfaceC0418a != null) {
                interfaceC0418a.onShowLoading(campaign);
            }
        }

        @Override // com.mbridge.msdk.out.BaseTrackingListener
        public void onStartRedirection(Campaign campaign, String str) {
            a.InterfaceC0418a interfaceC0418a = this.b;
            if (interfaceC0418a != null) {
                interfaceC0418a.onStartRedirection(campaign, str);
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0418a
        public void a(int i, String str) {
            a.InterfaceC0418a interfaceC0418a = this.b;
            if (interfaceC0418a != null) {
                interfaceC0418a.a(i, str);
            }
        }

        @Override // com.mbridge.msdk.video.signal.a.InterfaceC0418a
        public void a() {
            a.InterfaceC0418a interfaceC0418a = this.b;
            if (interfaceC0418a != null) {
                interfaceC0418a.a();
            }
        }
    }

    @Override // com.mbridge.msdk.video.signal.a
    public int b() {
        return this.g;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String c() {
        p0.a("DefaultJSCommon", C3040d4.a.f);
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String e() {
        p0.a("DefaultJSCommon", "getNotchArea");
        return null;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public String g() {
        return "{}";
    }

    @Override // com.mbridge.msdk.video.signal.a
    public boolean a() {
        return this.f5255a;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void b(boolean z) {
        this.f5255a = z;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public int d() {
        p0.a("DefaultJSCommon", "getAlertDialogRole " + this.h);
        return this.h;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void f() {
        p0.a("DefaultJSCommon", "finish");
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(a.InterfaceC0418a interfaceC0418a) {
        p0.a("DefaultJSCommon", "setTrackingListener:" + interfaceC0418a);
        this.m = interfaceC0418a;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(int i, String str) {
        p0.a("DefaultJSCommon", "statistics,type:" + i + ",json:" + str);
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(int i) {
        this.i = i;
    }

    @Override // com.mbridge.msdk.video.signal.a
    public void a(String str) {
        p0.a("DefaultJSCommon", "setNotchArea");
    }
}
