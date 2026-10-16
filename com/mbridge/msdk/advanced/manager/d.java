package com.mbridge.msdk.advanced.manager;

import android.net.http.SslError;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedView;
import com.mbridge.msdk.advanced.view.MBNativeAdvancedWebview;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.setting.h;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* compiled from: ResManager.java */
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static String f4007a = "ResManager";
    private static int b = 1;
    public static e c = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));

    /* compiled from: ResManager.java */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MBNativeAdvancedWebview f4009a;
        final /* synthetic */ String b;

        b(MBNativeAdvancedWebview mBNativeAdvancedWebview, String str) {
            this.f4009a = mBNativeAdvancedWebview;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4009a.loadUrl(this.b);
        }
    }

    public static CampaignEx a(MBNativeAdvancedView mBNativeAdvancedView, String str, String str2, String str3, int i, boolean z, boolean z2) {
        com.mbridge.msdk.setting.g d = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d == null) {
            d = h.b().a();
        }
        long Z = d.Z() * 1000;
        long a0 = d.a0() * 1000;
        a(a0, str2);
        List<CampaignEx> a2 = a(str2, str3);
        if (a2 != null && a2.size() > 0) {
            CampaignEx campaignEx = a2.get(0);
            if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - Z;
            if (z) {
                if ((campaignEx.getPlct() <= 0 || (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() < currentTimeMillis) && (campaignEx.getPlct() > 0 || campaignEx.getTimestamp() < j)) {
                    if (a(mBNativeAdvancedView, campaignEx, str, str2, i, z2) && campaignEx.isSpareOffer(Z, a0)) {
                        return a(campaignEx);
                    }
                    if (!campaignEx.isSpareOffer(Z, a0) && mBNativeAdvancedView != null) {
                        mBNativeAdvancedView.setVisibility(8);
                    }
                } else if (a(mBNativeAdvancedView, campaignEx, str, str2, i, z2)) {
                    p0.b(f4007a, "cache campain is picked:" + campaignEx.getAppName());
                    return a(campaignEx);
                }
            } else if ((campaignEx.getPlct() <= 0 || (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() < currentTimeMillis) && (campaignEx.getPlct() > 0 || campaignEx.getTimestamp() < j)) {
                p0.a(f4007a, "========已经超了缓存时间");
                if (!campaignEx.isSpareOffer(Z, a0) && mBNativeAdvancedView != null) {
                    mBNativeAdvancedView.setVisibility(8);
                    return null;
                }
            } else if (a(mBNativeAdvancedView, campaignEx, str, str2, i, z2)) {
                p0.b(f4007a, "cache campain is picked:" + campaignEx.getAppName());
                return a(campaignEx);
            }
        }
        return null;
    }

    public static void b(String str) {
        if (c == null) {
            c = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        c.a(str, 0, b);
    }

    /* compiled from: ResManager.java */
    class a extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4008a;
        final /* synthetic */ String b;
        final /* synthetic */ CampaignEx c;
        final /* synthetic */ MBNativeAdvancedView d;
        final /* synthetic */ long e;

        a(String str, String str2, CampaignEx campaignEx, MBNativeAdvancedView mBNativeAdvancedView, long j) {
            this.f4008a = str;
            this.b = str2;
            this.c = campaignEx;
            this.d = mBNativeAdvancedView;
            this.e = j;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i) {
            super.a(webView, i);
            if (i != 1) {
                this.d.setH5Ready(false);
                p0.a("WindVaneWebView", "======渲染失败");
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.c, this.b, "readyState 2", this.e, 3);
            } else {
                com.mbridge.msdk.advanced.common.c.a(this.f4008a + this.b + this.c.getRequestId(), true);
                this.d.setH5Ready(true);
                p0.a("WindVaneWebView", "======渲染成功：ready");
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.c, this.b, "", this.e, 1);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) {
            super.a(webView, i, str, str2);
            this.d.setH5Ready(false);
            p0.a("WindVaneWebView", "======渲染失败");
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.c, this.b, "error code:" + i + str, this.e, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            this.d.setH5Ready(false);
            p0.a("WindVaneWebView", "======渲染失败");
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.c, this.b, "error url:" + sslError.getUrl(), this.e, 3);
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            super.a(webView, str);
            if (!this.c.isHasMBTplMark()) {
                com.mbridge.msdk.advanced.common.c.a(this.f4008a + this.b + this.c.getRequestId(), true);
                this.d.setH5Ready(true);
                p0.a("WindVaneWebView", "======渲染成功：finish");
                com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.c, this.b, "", this.e, 1);
            }
            com.mbridge.msdk.advanced.signal.a.a(webView);
        }
    }

    private static List<CampaignEx> a(String str, String str2) {
        if (c == null) {
            c = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        return c.b(str, 0, 0, b);
    }

    private static CampaignEx a(CampaignEx campaignEx) {
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && (TextUtils.isEmpty(campaignEx.getAdHtml()) || !campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx.setHasMBTplMark(false);
            campaignEx.setIsMraid(true);
            return campaignEx;
        }
        campaignEx.setHasMBTplMark(true);
        campaignEx.setIsMraid(false);
        return campaignEx;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x009c, code lost:
    
        if (r14 == false) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(MBNativeAdvancedView mBNativeAdvancedView, CampaignEx campaignEx, String str, String str2, int i, boolean z) {
        boolean z2;
        if (campaignEx == null) {
            return false;
        }
        mBNativeAdvancedView.clearResState();
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            boolean b2 = com.mbridge.msdk.videocommon.download.b.getInstance().b(298, str2, campaignEx.isBidCampaign());
            if (b2) {
                mBNativeAdvancedView.setVideoReady(true);
            }
            z2 = b2;
        } else {
            mBNativeAdvancedView.setVideoReady(true);
            z2 = true;
        }
        if (!TextUtils.isEmpty(campaignEx.getendcard_url()) && !mBNativeAdvancedView.isEndCardReady() && !TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getendcard_url()))) {
            mBNativeAdvancedView.setEndCardReady(true);
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) && !mBNativeAdvancedView.isH5Ready()) {
            String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip());
            if (!TextUtils.isEmpty(h5ResAddress)) {
                if (com.mbridge.msdk.advanced.common.c.a(str + str2 + campaignEx.getRequestId())) {
                    mBNativeAdvancedView.setH5Ready(true);
                } else {
                    a(mBNativeAdvancedView, h5ResAddress, campaignEx, str, str2, i);
                }
            }
            z2 = false;
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml()) && !mBNativeAdvancedView.isH5Ready()) {
            String a2 = a(campaignEx.getAdHtml());
            if (!TextUtils.isEmpty(a2)) {
                if (com.mbridge.msdk.advanced.common.c.a(str + str2 + campaignEx.getRequestId())) {
                    mBNativeAdvancedView.setH5Ready(true);
                    if (campaignEx.isMraid()) {
                        mBNativeAdvancedView.setVideoReady(true);
                    }
                    return true;
                }
                a(mBNativeAdvancedView, a2, campaignEx, str, str2, i);
                if (!z) {
                }
            }
            return false;
        }
        return z2;
    }

    private static void a(MBNativeAdvancedView mBNativeAdvancedView, String str, CampaignEx campaignEx, String str2, String str3, int i) {
        if (mBNativeAdvancedView == null || mBNativeAdvancedView.getAdvancedNativeWebview() == null) {
            return;
        }
        com.mbridge.msdk.advanced.report.a.b(str3, campaignEx);
        com.mbridge.msdk.advanced.signal.b bVar = new com.mbridge.msdk.advanced.signal.b(mBNativeAdvancedView.getContext(), str2, str3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        bVar.a(arrayList);
        bVar.a(i);
        mBNativeAdvancedView.setAdvancedNativeSignalCommunicationImpl(bVar);
        MBNativeAdvancedWebview advancedNativeWebview = mBNativeAdvancedView.getAdvancedNativeWebview();
        long currentTimeMillis = System.currentTimeMillis();
        advancedNativeWebview.setWebViewListener(new a(str2, str3, campaignEx, mBNativeAdvancedView, currentTimeMillis));
        if (!advancedNativeWebview.isDestoryed()) {
            p0.a(f4007a, "======开始渲染：" + str);
            new Handler(Looper.getMainLooper()).post(new b(advancedNativeWebview, str));
        } else {
            mBNativeAdvancedView.setH5Ready(false);
            com.mbridge.msdk.advanced.report.a.a(com.mbridge.msdk.foundation.controller.c.m().d(), campaignEx, str3, "webview had destory", currentTimeMillis, 3);
        }
    }

    private static String a(String str) {
        try {
            File file = new File(str);
            return file.exists() ? "file:///" + file.getAbsolutePath() : "";
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Exception e) {
                e.getMessage();
                return "";
            }
        }
    }

    public static boolean a(MBNativeAdvancedView mBNativeAdvancedView, CampaignEx campaignEx, String str, String str2) {
        boolean z;
        boolean z2 = false;
        if (mBNativeAdvancedView == null) {
            p0.b(f4007a, "mbAdvancedNativeView  is null");
            return false;
        }
        if (TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            z = true;
        } else {
            z = mBNativeAdvancedView.isVideoReady();
            p0.b(f4007a, "======isReady isVideoReady:" + z);
        }
        if (z && !TextUtils.isEmpty(campaignEx.getAdZip())) {
            z = com.mbridge.msdk.advanced.common.c.a(str + str2 + campaignEx.getRequestId());
            p0.b(f4007a, "======isReady getAdZip:" + z);
        }
        if (z && TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            z = com.mbridge.msdk.advanced.common.c.a(str + str2 + campaignEx.getRequestId());
            p0.b(f4007a, "======isReady getAdHtml:" + z);
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            p0.b(f4007a, "======isReady getAdHtml  getAdZip all are empty");
        } else {
            z2 = z;
        }
        if (!z2 || TextUtils.isEmpty(campaignEx.getendcard_url())) {
            return z2;
        }
        boolean isEndCardReady = mBNativeAdvancedView.isEndCardReady();
        p0.b(f4007a, "======isReady isEndCardReady:" + isEndCardReady);
        return isEndCardReady;
    }

    public static void a(CampaignEx campaignEx, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        if (c == null) {
            c = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        c.a(arrayList, str);
    }

    public static void a(long j, String str) {
        if (c == null) {
            c = e.a(g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        c.a(j, str);
    }
}
