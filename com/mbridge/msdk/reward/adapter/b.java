package com.mbridge.msdk.reward.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.pglcrypt.PglCryptUtils;
import com.ironsource.C3040d4;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.download.download.ResDownloadCheckManager;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.b1;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.video.bt.module.MBridgeBTLayout;
import com.mbridge.msdk.video.bt.module.MBridgeBTRootLayout;
import com.mbridge.msdk.videocommon.a;
import com.vungle.ads.internal.protos.Sdk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* compiled from: RewardCampaignsResourceManager.java */
/* loaded from: classes6.dex */
public final class b {
    private static ConcurrentHashMap<String, f> g;

    /* renamed from: a, reason: collision with root package name */
    private final m f4624a;
    private boolean b;
    private final String c;
    private final String d;
    private final String e;
    private volatile List<WindVaneWebView> f;

    /* compiled from: RewardCampaignsResourceManager.java */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CopyOnWriteArrayList f4625a;
        final /* synthetic */ Context b;
        final /* synthetic */ String c;
        final /* synthetic */ int d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ n h;

        a(CopyOnWriteArrayList copyOnWriteArrayList, Context context, String str, int i, String str2, String str3, String str4, n nVar) {
            this.f4625a = copyOnWriteArrayList;
            this.b = context;
            this.c = str;
            this.d = i;
            this.e = str2;
            this.f = str3;
            this.g = str4;
            this.h = nVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:131:0x02b9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:146:0x0282 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:187:0x0198  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x01fa  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0260  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x02e8  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            Iterator it;
            CharSequence charSequence;
            String str2;
            CampaignEx.c cVar;
            String str3;
            String str4;
            String iconUrl;
            String imageUrl;
            List<String> list;
            CampaignEx campaignEx;
            int i;
            n nVar;
            CopyOnWriteArrayList copyOnWriteArrayList;
            String str5 = "_";
            CopyOnWriteArrayList copyOnWriteArrayList2 = this.f4625a;
            if (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) {
                return;
            }
            try {
                ResDownloadCheckManager.getInstance().setCampaignList(this.f4625a);
                com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.b, this.c, this.f4625a, this.d, new k(b.this.f4624a, this.e, this.c, this.f, this.g));
                com.mbridge.msdk.videocommon.download.b.getInstance().load(this.c);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                }
            }
            Iterator it2 = this.f4625a.iterator();
            while (it2.hasNext()) {
                CampaignEx campaignEx2 = (CampaignEx) it2.next();
                if (campaignEx2 != null) {
                    try {
                        Message obtain = Message.obtain();
                        obtain.what = 106;
                        Bundle bundle = new Bundle();
                        bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                        bundle.putString(MBridgeConstans.PLACEMENT_ID, this.e);
                        bundle.putString("request_id", this.f);
                        bundle.putString(C3040d4.h.W, this.c + str5 + this.f + str5 + campaignEx2.getSecondRequestIndex());
                        obtain.setData(bundle);
                        b.this.f4624a.sendMessage(obtain);
                    } catch (Exception unused) {
                    }
                    CampaignEx.c rewardTemplateMode = campaignEx2.getRewardTemplateMode();
                    if (rewardTemplateMode != null) {
                        String e2 = rewardTemplateMode.e();
                        int f = rewardTemplateMode.f();
                        if (campaignEx2.isDynamicView() && u0.a(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, e2)) {
                            b.this.a(1, campaignEx2, f + "", e2);
                        } else if (!TextUtils.isEmpty(e2) && !e2.contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                            com.mbridge.msdk.foundation.same.report.metrics.c a2 = b.this.a(campaignEx2, 2);
                            if (e2.contains(".zip")) {
                                try {
                                    H5DownLoadManager h5DownLoadManager = H5DownLoadManager.getInstance();
                                    try {
                                        Context context = this.b;
                                        String str6 = this.e;
                                        try {
                                            String str7 = this.c;
                                            try {
                                                String str8 = this.f;
                                                m mVar = b.this.f4624a;
                                                charSequence = ".zip";
                                                try {
                                                    nVar = this.h;
                                                    copyOnWriteArrayList = this.f4625a;
                                                    cVar = rewardTemplateMode;
                                                    str3 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                                    str2 = "";
                                                    str = str5;
                                                    it = it2;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    cVar = rewardTemplateMode;
                                                    str3 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                                    str2 = "";
                                                    str = str5;
                                                    it = it2;
                                                }
                                                try {
                                                    h5DownLoadManager.downloadH5Res(a2, e2, new l(context, str6, str7, str8, campaignEx2, 859, mVar, nVar, copyOnWriteArrayList));
                                                } catch (Exception e4) {
                                                    e = e4;
                                                    if (MBridgeConstans.DEBUG) {
                                                        p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                                    }
                                                    str4 = campaignEx2.getendcard_url();
                                                    boolean isDynamicView = campaignEx2.isDynamicView();
                                                    boolean l = u0.l(str4);
                                                    if (!TextUtils.isEmpty(str4)) {
                                                    }
                                                    if (!TextUtils.isEmpty(campaignEx2.getEndScreenUrl())) {
                                                    }
                                                    iconUrl = campaignEx2.getIconUrl();
                                                    if (!TextUtils.isEmpty(iconUrl)) {
                                                    }
                                                    imageUrl = campaignEx2.getImageUrl();
                                                    if (!TextUtils.isEmpty(imageUrl)) {
                                                    }
                                                    if (cVar != null) {
                                                    }
                                                    it2 = it;
                                                    str5 = str;
                                                }
                                            } catch (Exception e5) {
                                                e = e5;
                                                cVar = rewardTemplateMode;
                                                str3 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                                str2 = "";
                                                str = str5;
                                                it = it2;
                                                charSequence = ".zip";
                                            }
                                        } catch (Exception e6) {
                                            e = e6;
                                            str = str5;
                                            it = it2;
                                            charSequence = ".zip";
                                            str2 = "";
                                            cVar = rewardTemplateMode;
                                            str3 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                            if (MBridgeConstans.DEBUG) {
                                            }
                                            str4 = campaignEx2.getendcard_url();
                                            boolean isDynamicView2 = campaignEx2.isDynamicView();
                                            boolean l2 = u0.l(str4);
                                            if (!TextUtils.isEmpty(str4)) {
                                            }
                                            if (!TextUtils.isEmpty(campaignEx2.getEndScreenUrl())) {
                                            }
                                            iconUrl = campaignEx2.getIconUrl();
                                            if (!TextUtils.isEmpty(iconUrl)) {
                                            }
                                            imageUrl = campaignEx2.getImageUrl();
                                            if (!TextUtils.isEmpty(imageUrl)) {
                                            }
                                            if (cVar != null) {
                                            }
                                            it2 = it;
                                            str5 = str;
                                        }
                                    } catch (Exception e7) {
                                        e = e7;
                                        str = str5;
                                        it = it2;
                                        str2 = "";
                                        charSequence = ".zip";
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                    str = str5;
                                    it = it2;
                                    charSequence = ".zip";
                                    str2 = "";
                                }
                            } else {
                                str = str5;
                                it = it2;
                                charSequence = ".zip";
                                str2 = "";
                                cVar = rewardTemplateMode;
                                str3 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                                p0.a("RewardCampaignsResourceManager", "开始下载 html 类型的 template");
                                try {
                                    H5DownLoadManager.getInstance().downloadH5Res(a2, e2, new i(859, this.e, this.c, this.f, campaignEx2, this.h, b.this.f4624a, this.f4625a));
                                } catch (Exception e9) {
                                    if (MBridgeConstans.DEBUG) {
                                        p0.b("RewardCampaignsResourceManager", e9.getLocalizedMessage());
                                    }
                                }
                            }
                            str4 = campaignEx2.getendcard_url();
                            boolean isDynamicView22 = campaignEx2.isDynamicView();
                            boolean l22 = u0.l(str4);
                            if (!TextUtils.isEmpty(str4)) {
                                if (!isDynamicView22) {
                                    b.this.a(this.b, this.e, this.c, this.f, campaignEx2, str4, this.h, (CopyOnWriteArrayList<CampaignEx>) this.f4625a);
                                } else if (l22) {
                                    b.this.a(this.b, this.e, this.c, this.f, campaignEx2, str4, this.h, (CopyOnWriteArrayList<CampaignEx>) this.f4625a);
                                } else if (u0.a(str3, str4)) {
                                    try {
                                        i = Integer.parseInt(b1.a(str4, "ecid"));
                                    } catch (Throwable th) {
                                        p0.b("RewardCampaignsResourceManager", th.getMessage());
                                        i = 404;
                                    }
                                    b.this.a(2, campaignEx2, i + str2, str4);
                                }
                            }
                            if (!TextUtils.isEmpty(campaignEx2.getEndScreenUrl()) && !campaignEx2.isDynamicView()) {
                                H5DownLoadManager.getInstance().download(b.this.a(campaignEx2, 6), campaignEx2.getEndScreenUrl());
                            }
                            iconUrl = campaignEx2.getIconUrl();
                            if (!TextUtils.isEmpty(iconUrl)) {
                                try {
                                    com.mbridge.msdk.foundation.same.image.b a3 = com.mbridge.msdk.foundation.same.image.b.a(this.b);
                                    try {
                                        j jVar = new j(b.this.f4624a, 0, this.e, this.c, this.f, campaignEx2);
                                        campaignEx2 = campaignEx2;
                                        a3.a(iconUrl, jVar);
                                    } catch (Exception e10) {
                                        e = e10;
                                        campaignEx2 = campaignEx2;
                                        if (MBridgeConstans.DEBUG) {
                                            p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                        }
                                        imageUrl = campaignEx2.getImageUrl();
                                        if (!TextUtils.isEmpty(imageUrl)) {
                                        }
                                        if (cVar != null) {
                                        }
                                        it2 = it;
                                        str5 = str;
                                    }
                                } catch (Exception e11) {
                                    e = e11;
                                }
                            }
                            imageUrl = campaignEx2.getImageUrl();
                            if (!TextUtils.isEmpty(imageUrl)) {
                                try {
                                    CampaignEx campaignEx3 = campaignEx2;
                                    try {
                                        campaignEx2 = campaignEx3;
                                        com.mbridge.msdk.foundation.same.image.b.a(this.b).a(imageUrl, new j(b.this.f4624a, 0, this.e, this.c, this.f, campaignEx3));
                                    } catch (Exception e12) {
                                        e = e12;
                                        campaignEx2 = campaignEx3;
                                        if (MBridgeConstans.DEBUG) {
                                            p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                        }
                                        if (cVar != null) {
                                        }
                                        it2 = it;
                                        str5 = str;
                                    }
                                } catch (Exception e13) {
                                    e = e13;
                                }
                            }
                            if (cVar != null) {
                                String c = cVar.c();
                                if (!TextUtils.isEmpty(c) && !campaignEx2.isDynamicView()) {
                                    int i2 = campaignEx2.getAabEntity() != null ? campaignEx2.getAabEntity().h3c : 0;
                                    com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = new com.mbridge.msdk.foundation.same.report.metrics.c(true);
                                    cVar2.f(i2);
                                    if (c.contains(charSequence)) {
                                        p0.a("RewardCampaignsResourceManager", "开始下载 zip 类型的 pause");
                                        try {
                                            H5DownLoadManager.getInstance().downloadH5Res(cVar2, c, new l(this.b, this.e, this.c, this.f, campaignEx2, Sdk.SDKError.Reason.EVALUATE_JAVASCRIPT_FAILED_VALUE, b.this.f4624a, this.h, this.f4625a));
                                        } catch (Exception e14) {
                                            if (MBridgeConstans.DEBUG) {
                                                p0.b("RewardCampaignsResourceManager", e14.getLocalizedMessage());
                                            }
                                        }
                                    } else {
                                        try {
                                            H5DownLoadManager.getInstance().downloadH5Res(cVar2, c, new i(Sdk.SDKError.Reason.EVALUATE_JAVASCRIPT_FAILED_VALUE, this.e, this.c, this.f, campaignEx2, this.h, b.this.f4624a, this.f4625a));
                                        } catch (Exception e15) {
                                            if (MBridgeConstans.DEBUG) {
                                                p0.b("RewardCampaignsResourceManager", e15.getLocalizedMessage());
                                            }
                                        }
                                    }
                                }
                                List<CampaignEx.c.a> a4 = cVar.a();
                                if (a4 != null && a4.size() > 0) {
                                    for (CampaignEx.c.a aVar : a4) {
                                        if (aVar != null && (list = aVar.f4236a) != null && list.size() > 0) {
                                            for (String str9 : aVar.f4236a) {
                                                if (!TextUtils.isEmpty(str9)) {
                                                    try {
                                                        campaignEx = campaignEx2;
                                                    } catch (Exception e16) {
                                                        e = e16;
                                                    }
                                                    try {
                                                        campaignEx2 = campaignEx;
                                                        com.mbridge.msdk.foundation.same.image.b.a(this.b).a(str9, new j(b.this.f4624a, 1, this.e, this.c, this.f, campaignEx));
                                                    } catch (Exception e17) {
                                                        e = e17;
                                                        campaignEx2 = campaignEx;
                                                        if (MBridgeConstans.DEBUG) {
                                                            p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            it2 = it;
                            str5 = str;
                        }
                    }
                    str = str5;
                    it = it2;
                    charSequence = ".zip";
                    str2 = "";
                    cVar = rewardTemplateMode;
                    str3 = MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW;
                    str4 = campaignEx2.getendcard_url();
                    boolean isDynamicView222 = campaignEx2.isDynamicView();
                    boolean l222 = u0.l(str4);
                    if (!TextUtils.isEmpty(str4)) {
                    }
                    if (!TextUtils.isEmpty(campaignEx2.getEndScreenUrl())) {
                        H5DownLoadManager.getInstance().download(b.this.a(campaignEx2, 6), campaignEx2.getEndScreenUrl());
                    }
                    iconUrl = campaignEx2.getIconUrl();
                    if (!TextUtils.isEmpty(iconUrl)) {
                    }
                    imageUrl = campaignEx2.getImageUrl();
                    if (!TextUtils.isEmpty(imageUrl)) {
                    }
                    if (cVar != null) {
                    }
                    it2 = it;
                    str5 = str;
                }
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    class c implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f4627a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ CampaignEx d;
        final /* synthetic */ n e;
        final /* synthetic */ Context f;

        c(String str, String str2, String str3, CampaignEx campaignEx, n nVar, Context context) {
            this.f4627a = str;
            this.b = str2;
            this.c = str3;
            this.d = campaignEx;
            this.e = nVar;
            this.f = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0171 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onFailed(String str, String str2) {
            String str3;
            String str4;
            String str5;
            String str6;
            boolean z;
            Exception exc;
            String str7;
            char c;
            b bVar;
            try {
                ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, false);
                Message obtain = Message.obtain();
                obtain.what = 205;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f4627a);
                try {
                    bundle.putString(MBridgeConstans.PLACEMENT_ID, this.b);
                    bundle.putString("request_id", this.c);
                    bundle.putString("url", str2);
                    bundle.putString(C3040d4.h.W, this.f4627a + "_" + this.c + "_" + this.d.getSecondRequestIndex());
                    bundle.putString(PglCryptUtils.KEY_MESSAGE, str);
                    obtain.setData(bundle);
                    b.this.f4624a.sendMessage(obtain);
                    if (this.e != null) {
                        try {
                            c = 28037;
                        } catch (Exception e) {
                            e = e;
                            c = 28037;
                        }
                        try {
                            this.e.a(str2, this.c, b.b(880005, new MBridgeIds(this.b, this.f4627a, this.c), "", null, null));
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                p0.b("RewardCampaignsResourceManager", e.getMessage());
                                bVar = b.this;
                                Context context = this.f;
                                CampaignEx campaignEx = this.d;
                                try {
                                    String str8 = this.f4627a;
                                    str4 = "";
                                    str5 = PglCryptUtils.KEY_MESSAGE;
                                    str6 = "_";
                                    str3 = "RewardCampaignsResourceManager";
                                    z = false;
                                } catch (Exception e3) {
                                    e = e3;
                                    str3 = "RewardCampaignsResourceManager";
                                    str4 = "";
                                    str5 = PglCryptUtils.KEY_MESSAGE;
                                    str6 = "_";
                                    z = false;
                                }
                                try {
                                    bVar.a(context, 3, campaignEx, str2, str, str8, "");
                                } catch (Exception e4) {
                                    e = e4;
                                    exc = e;
                                    ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, z);
                                    Message obtain2 = Message.obtain();
                                    obtain2.what = 105;
                                    Bundle bundle2 = new Bundle();
                                    bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f4627a);
                                    bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.b);
                                    bundle2.putString("request_id", this.c);
                                    bundle2.putString(C3040d4.h.W, this.f4627a + str6 + this.c + str6 + this.d.getSecondRequestIndex());
                                    bundle2.putString("url", str2);
                                    bundle2.putString(str5, exc.getMessage());
                                    obtain2.setData(bundle2);
                                    b.this.f4624a.sendMessage(obtain2);
                                    if (this.e != null) {
                                    }
                                    str7 = str3;
                                    p0.b(str7, exc.getLocalizedMessage());
                                }
                            } catch (Exception e5) {
                                str3 = "RewardCampaignsResourceManager";
                                str4 = "";
                                str5 = PglCryptUtils.KEY_MESSAGE;
                                z = false;
                                exc = e5;
                                str6 = "_";
                                ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, z);
                                Message obtain22 = Message.obtain();
                                obtain22.what = 105;
                                Bundle bundle22 = new Bundle();
                                bundle22.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f4627a);
                                bundle22.putString(MBridgeConstans.PLACEMENT_ID, this.b);
                                bundle22.putString("request_id", this.c);
                                bundle22.putString(C3040d4.h.W, this.f4627a + str6 + this.c + str6 + this.d.getSecondRequestIndex());
                                bundle22.putString("url", str2);
                                bundle22.putString(str5, exc.getMessage());
                                obtain22.setData(bundle22);
                                b.this.f4624a.sendMessage(obtain22);
                                if (this.e != null) {
                                }
                                str7 = str3;
                                p0.b(str7, exc.getLocalizedMessage());
                            }
                        }
                    } else {
                        c = 28037;
                    }
                    try {
                        bVar = b.this;
                        try {
                            Context context2 = this.f;
                            CampaignEx campaignEx2 = this.d;
                            String str82 = this.f4627a;
                            str4 = "";
                            str5 = PglCryptUtils.KEY_MESSAGE;
                            str6 = "_";
                            str3 = "RewardCampaignsResourceManager";
                            z = false;
                            bVar.a(context2, 3, campaignEx2, str2, str, str82, "");
                        } catch (Exception e6) {
                            e = e6;
                            str3 = "RewardCampaignsResourceManager";
                            str4 = "";
                            str5 = PglCryptUtils.KEY_MESSAGE;
                            z = false;
                            str6 = "_";
                        }
                    } catch (Exception e7) {
                        e = e7;
                        str3 = "RewardCampaignsResourceManager";
                        str4 = "";
                        str5 = PglCryptUtils.KEY_MESSAGE;
                        z = false;
                        str6 = "_";
                        exc = e;
                        ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, z);
                        Message obtain222 = Message.obtain();
                        obtain222.what = 105;
                        Bundle bundle222 = new Bundle();
                        bundle222.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f4627a);
                        bundle222.putString(MBridgeConstans.PLACEMENT_ID, this.b);
                        bundle222.putString("request_id", this.c);
                        bundle222.putString(C3040d4.h.W, this.f4627a + str6 + this.c + str6 + this.d.getSecondRequestIndex());
                        bundle222.putString("url", str2);
                        bundle222.putString(str5, exc.getMessage());
                        obtain222.setData(bundle222);
                        b.this.f4624a.sendMessage(obtain222);
                        if (this.e != null) {
                            try {
                                this.e.a(str2, this.c, b.b(880005, new MBridgeIds(this.b, this.f4627a, this.c), str4, exc, null));
                            } catch (Exception e8) {
                                str7 = str3;
                                p0.b(str7, e8.getMessage());
                                p0.b(str7, exc.getLocalizedMessage());
                            }
                        }
                        str7 = str3;
                        p0.b(str7, exc.getLocalizedMessage());
                    }
                } catch (Exception e9) {
                    e = e9;
                    str3 = "RewardCampaignsResourceManager";
                }
            } catch (Exception e10) {
                e = e10;
                str3 = "RewardCampaignsResourceManager";
                str4 = "";
                str5 = PglCryptUtils.KEY_MESSAGE;
                str6 = "_";
                z = false;
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            try {
                p0.a("RewardCampaignsResourceManager", "zip btl template download success");
                ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
                Message obtain = Message.obtain();
                obtain.what = 105;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f4627a);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.b);
                bundle.putString("request_id", this.c);
                bundle.putString(C3040d4.h.W, this.f4627a + "_" + this.c + "_" + this.d.getSecondRequestIndex());
                bundle.putString("url", str);
                obtain.setData(bundle);
                b.this.f4624a.sendMessage(obtain);
                n nVar = this.e;
                if (nVar != null) {
                    nVar.a(this.b, this.f4627a, this.c, str);
                }
                if (z) {
                    return;
                }
                b.this.a(this.f, 1, this.d, str, "", this.f4627a, str2);
            } catch (Exception e) {
                ResDownloadCheckManager.getInstance().setZipDownloadDone(str, false);
                Message obtain2 = Message.obtain();
                obtain2.what = 205;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.f4627a);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.b);
                bundle2.putString("request_id", this.c);
                bundle2.putString(C3040d4.h.W, this.f4627a + "_" + this.c + "_" + this.d.getSecondRequestIndex());
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                b.this.f4624a.sendMessage(obtain2);
                if (this.e != null) {
                    try {
                        this.e.a(str, this.c, b.b(880005, new MBridgeIds(this.b, this.f4627a, this.c), "", e, null));
                    } catch (Exception e2) {
                        p0.b("RewardCampaignsResourceManager", e2.getMessage());
                    }
                }
                b.this.a(this.f, 3, this.d, str, e.getLocalizedMessage(), this.f4627a, str2);
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                }
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f4628a;
        final /* synthetic */ Context b;
        final /* synthetic */ int c;
        final /* synthetic */ String d;
        final /* synthetic */ String e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;

        d(CampaignEx campaignEx, Context context, int i, String str, String str2, String str3, String str4) {
            this.f4628a = campaignEx;
            this.b = context;
            this.c = i;
            this.d = str;
            this.e = str2;
            this.f = str3;
            this.g = str4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f4628a == null || this.b == null) {
                return;
            }
            try {
                com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n();
                nVar.j("m_download_end");
                Context context = this.b;
                if (context != null) {
                    nVar.c(l0.s(context.getApplicationContext()));
                }
                nVar.d(this.c);
                CampaignEx campaignEx = this.f4628a;
                if (campaignEx != null) {
                    nVar.b(campaignEx.getId());
                    nVar.n(this.f4628a.getRequestId());
                    nVar.k(this.f4628a.getCurrentLocalRid());
                    nVar.o(this.f4628a.getRequestIdNotice());
                }
                nVar.b("url", this.d);
                nVar.t(this.d);
                nVar.m(this.e);
                nVar.u(this.f);
                if (!TextUtils.isEmpty(this.g)) {
                    nVar.q(this.g);
                }
                nVar.e(1);
                nVar.b("scenes", "1");
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(nVar, this.f4628a);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                }
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    class e implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f4629a;
        final /* synthetic */ WindVaneWebView b;
        final /* synthetic */ CampaignEx c;
        final /* synthetic */ CopyOnWriteArrayList d;
        final /* synthetic */ String e;
        final /* synthetic */ com.mbridge.msdk.videocommon.setting.c f;
        final /* synthetic */ String g;

        e(boolean z, WindVaneWebView windVaneWebView, CampaignEx campaignEx, CopyOnWriteArrayList copyOnWriteArrayList, String str, com.mbridge.msdk.videocommon.setting.c cVar, String str2) {
            this.f4629a = z;
            this.b = windVaneWebView;
            this.c = campaignEx;
            this.d = copyOnWriteArrayList;
            this.e = str;
            this.f = cVar;
            this.g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(this.f4629a, this.b, this.c.getRewardTemplateMode().e(), 0, this.c, (CopyOnWriteArrayList<CampaignEx>) this.d, H5DownLoadManager.getInstance().getH5ResAddress(this.c.getRewardTemplateMode().e()), this.e, this.f, this.g, b.this.b);
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    private static class f {

        /* renamed from: a, reason: collision with root package name */
        boolean f4630a;
        boolean b;
        int c;
        int d;
        String e;
        String f;
        int g;
        CopyOnWriteArrayList<CampaignEx> h;
        CopyOnWriteArrayList<CampaignEx> i;

        public f(boolean z, boolean z2, int i, int i2, String str, String str2, int i3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.f4630a = z;
            this.b = z2;
            this.c = i;
            this.d = i2;
            this.e = str;
            this.f = str2;
            this.g = i3;
            this.h = copyOnWriteArrayList;
            this.i = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    public interface h {
        void a(String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList);

        void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.foundation.error.b bVar);
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    private static final class i implements H5DownLoadManager.IH5SourceDownloadListener {
        private int b;
        private final String c;
        private final String d;
        private final String e;
        private CampaignEx f;
        private n g;
        private Handler h;
        private CopyOnWriteArrayList<CampaignEx> i;

        /* renamed from: a, reason: collision with root package name */
        private boolean f4632a = false;
        private final long j = System.currentTimeMillis();

        /* compiled from: RewardCampaignsResourceManager.java */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f4633a;
            final /* synthetic */ long b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;

            a(int i, long j, String str, String str2, String str3) {
                this.f4633a = i;
                this.b = j;
                this.c = str;
                this.d = str2;
                this.e = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (i.this.f == null) {
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n("m_download_end", this.f4633a, this.b + "", this.c, i.this.f.getId(), i.this.d, this.d, "2");
                    nVar.n(i.this.f.getRequestId());
                    nVar.k(i.this.f.getCurrentLocalRid());
                    nVar.o(i.this.f.getRequestIdNotice());
                    nVar.b(i.this.f.getId());
                    nVar.a(i.this.f.getAdSpaceT());
                    nVar.b("scenes", "1");
                    nVar.b("url", this.c);
                    if (i.this.f.getAdType() == 287) {
                        nVar.a("3");
                    } else if (i.this.f.getAdType() == 94) {
                        nVar.a("1");
                    }
                    if (!TextUtils.isEmpty(this.e)) {
                        nVar.q(this.e);
                    }
                    b.b(nVar, i.this.f);
                    com.mbridge.msdk.foundation.same.report.g.a(nVar, i.this.d, i.this.f);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                }
            }
        }

        public i(int i, String str, String str2, String str3, CampaignEx campaignEx, n nVar, Handler handler, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.b = i;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = nVar;
            this.h = handler;
            this.i = copyOnWriteArrayList;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, false);
            int i = this.b;
            if (i == 313) {
                Message obtain = Message.obtain();
                obtain.what = 201;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle.putString("request_id", this.e);
                bundle.putString(C3040d4.h.W, this.d + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle.putString("url", str);
                bundle.putString(PglCryptUtils.KEY_MESSAGE, str2);
                obtain.setData(bundle);
                this.h.sendMessage(obtain);
                return;
            }
            if (i == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle2.putString("request_id", this.e);
                bundle2.putString(C3040d4.h.W, this.d + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle2.putString("url", str);
                bundle2.putString(PglCryptUtils.KEY_MESSAGE, str2);
                obtain2.setData(bundle2);
                this.h.sendMessage(obtain2);
                if (this.f4632a) {
                    a(3, System.currentTimeMillis() - this.j, str, "url download failed", "");
                }
            } else if (i == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 205;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle3.putString("request_id", this.e);
                bundle3.putString(C3040d4.h.W, this.d + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle3.putString(PglCryptUtils.KEY_MESSAGE, str2);
                obtain3.setData(bundle3);
                this.h.sendMessage(obtain3);
                if (this.g != null) {
                    try {
                        this.g.a(str, this.e, b.b(880006, new MBridgeIds(this.c, this.d, this.e), str2, null, null));
                    } catch (Exception e) {
                        p0.b("RewardCampaignsResourceManager", e.getMessage());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            int i = this.b;
            if (i == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle.putString("request_id", this.e);
                bundle.putString(C3040d4.h.W, this.d + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.h.sendMessage(obtain);
                return;
            }
            if (i == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle2.putString("request_id", this.e);
                bundle2.putString(C3040d4.h.W, this.d + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.h.sendMessage(obtain2);
                if (this.f4632a) {
                    a(1, System.currentTimeMillis() - this.j, str, "", str2);
                }
            } else if (i == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 105;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.d);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.c);
                bundle3.putString("request_id", this.e);
                bundle3.putString(C3040d4.h.W, this.d + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                obtain3.setData(bundle3);
                this.h.sendMessage(obtain3);
                n nVar = this.g;
                if (nVar != null) {
                    nVar.a(this.c, this.d, this.e, str);
                }
            }
        }

        public void a(boolean z) {
            this.f4632a = z;
        }

        private void a(int i, long j, String str, String str2, String str3) {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new a(i, j, str, str2, str3));
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    private static final class j implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        private Handler f4634a;
        private int b;
        private String c;
        private String d;
        private String e;
        private CampaignEx f;

        /* compiled from: RewardCampaignsResourceManager.java */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f4635a;

            a(String str) {
                this.f4635a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f != null) {
                    try {
                        com.mbridge.msdk.foundation.db.n a2 = com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                        p0.a("RewardCampaignsResourceManager", "campaign is null");
                        com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n();
                        nVar.j("2000044");
                        nVar.c(l0.s(com.mbridge.msdk.foundation.controller.c.m().d()));
                        nVar.b(j.this.f.getId());
                        nVar.i(j.this.f.getImageUrl());
                        nVar.n(j.this.f.getRequestId());
                        nVar.k(j.this.f.getCurrentLocalRid());
                        nVar.o(j.this.f.getRequestIdNotice());
                        nVar.u(j.this.c);
                        nVar.m(this.f4635a);
                        nVar.b("scenes", "1");
                        a2.a(nVar);
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                        }
                    }
                }
            }
        }

        public j(Handler handler, int i, String str, String str2, String str3, CampaignEx campaignEx) {
            this.f4634a = handler;
            this.b = i;
            this.d = str;
            this.c = str2;
            this.e = str3;
            this.f = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            Message obtain = Message.obtain();
            obtain.what = this.b == 0 ? 202 : 204;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle.putString("request_id", this.e);
            bundle.putString(C3040d4.h.W, this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
            obtain.setData(bundle);
            this.f4634a.sendMessage(obtain);
            a aVar = new a(str);
            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
            } else {
                aVar.run();
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            ResDownloadCheckManager.getInstance().setImageDownloadDone(str, true);
            Message obtain = Message.obtain();
            obtain.what = this.b == 0 ? 102 : 104;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle.putString("request_id", this.e);
            bundle.putString(C3040d4.h.W, this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
            obtain.setData(bundle);
            this.f4634a.sendMessage(obtain);
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    private static final class l implements H5DownLoadManager.ZipDownloadListener {
        private Context b;
        private String c;
        private String d;
        private String e;
        private CampaignEx f;
        private int g;
        private Handler h;
        private n i;
        private CopyOnWriteArrayList<CampaignEx> j;

        /* renamed from: a, reason: collision with root package name */
        private boolean f4637a = false;
        private long k = System.currentTimeMillis();

        /* compiled from: RewardCampaignsResourceManager.java */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f4638a;
            final /* synthetic */ String b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;

            a(int i, String str, String str2, String str3) {
                this.f4638a = i;
                this.b = str;
                this.c = str2;
                this.d = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l.this.f == null || l.this.b == null) {
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n();
                    nVar.j("m_download_end");
                    if (l.this.b != null) {
                        nVar.c(l0.s(l.this.b.getApplicationContext()));
                    }
                    nVar.d(this.f4638a);
                    if (l.this.f != null) {
                        nVar.b(l.this.f.getId());
                        nVar.n(l.this.f.getRequestId());
                        nVar.k(l.this.f.getCurrentLocalRid());
                        nVar.o(l.this.f.getRequestIdNotice());
                    }
                    nVar.t(this.b);
                    nVar.m(this.c);
                    nVar.u(l.this.c);
                    if (!TextUtils.isEmpty(this.d)) {
                        nVar.q(this.d);
                    }
                    nVar.e(2);
                    nVar.b("scenes", "1");
                    nVar.b("url", this.b);
                    b.b(nVar, l.this.f);
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a(nVar, l.this.f);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                }
            }
        }

        /* compiled from: RewardCampaignsResourceManager.java */
        /* renamed from: com.mbridge.msdk.reward.adapter.b$l$b, reason: collision with other inner class name */
        class RunnableC0369b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f4639a;
            final /* synthetic */ long b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;

            RunnableC0369b(int i, long j, String str, String str2, String str3) {
                this.f4639a = i;
                this.b = j;
                this.c = str;
                this.d = str2;
                this.e = str3;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (l.this.f == null) {
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n("m_download_end", this.f4639a, this.b + "", this.c, l.this.f.getId(), l.this.c, this.d, "1");
                    nVar.n(l.this.f.getRequestId());
                    nVar.k(l.this.f.getCurrentLocalRid());
                    nVar.o(l.this.f.getRequestIdNotice());
                    nVar.b(l.this.f.getId());
                    nVar.a(l.this.f.getAdSpaceT());
                    nVar.q(this.e);
                    nVar.b("scenes", "1");
                    if (l.this.f.getAdType() == 287) {
                        nVar.a("3");
                    } else if (l.this.f.getAdType() == 94) {
                        nVar.a("1");
                    }
                    nVar.b("url", this.c);
                    nVar.e(3);
                    b.b(nVar, l.this.f);
                    com.mbridge.msdk.foundation.same.report.g.a(nVar, l.this.c, l.this.f);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                    }
                }
            }
        }

        public l(Context context, String str, String str2, String str3, CampaignEx campaignEx, int i, Handler handler, n nVar, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.b = context;
            this.d = str;
            this.c = str2;
            this.e = str3;
            this.f = campaignEx;
            this.g = i;
            this.h = handler;
            this.i = nVar;
            this.j = copyOnWriteArrayList;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str2, false);
            long currentTimeMillis = System.currentTimeMillis() - this.k;
            int i = this.g;
            if (i == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle.putString("request_id", this.e);
                bundle.putString(C3040d4.h.W, this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle.putString("url", str2);
                bundle.putString(PglCryptUtils.KEY_MESSAGE, str);
                obtain.setData(bundle);
                this.h.sendMessage(obtain);
                return;
            }
            if (i == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 201;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle2.putString("request_id", this.e);
                bundle2.putString("url", str2);
                bundle2.putString(C3040d4.h.W, this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle2.putString(PglCryptUtils.KEY_MESSAGE, str);
                obtain2.setData(bundle2);
                this.h.sendMessage(obtain2);
                if (this.f4637a) {
                    a(3, currentTimeMillis, str2, "zip download failed", "");
                }
            } else if (i == 859) {
                Message obtain3 = Message.obtain();
                obtain3.what = 203;
                Bundle bundle3 = new Bundle();
                bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle3.putString("request_id", this.e);
                bundle3.putString("url", str2);
                bundle3.putString(C3040d4.h.W, this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle3.putString(PglCryptUtils.KEY_MESSAGE, str);
                obtain3.setData(bundle3);
                this.h.sendMessage(obtain3);
                if (this.i != null) {
                    try {
                        this.i.a(str2, this.e, b.b(880006, new MBridgeIds(this.d, this.c, this.e), "", null, null));
                    } catch (Exception e) {
                        p0.b("RewardCampaignsResourceManager", e.getMessage());
                    }
                }
                a(3, str2, str, "");
            }
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z) {
            ResDownloadCheckManager.getInstance().setZipDownloadDone(str, true);
            long currentTimeMillis = System.currentTimeMillis() - this.k;
            int i = this.g;
            if (i == 313) {
                Message obtain = Message.obtain();
                obtain.what = 101;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle.putString("request_id", this.e);
                bundle.putString(C3040d4.h.W, this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle.putString("url", str);
                obtain.setData(bundle);
                this.h.sendMessage(obtain);
                return;
            }
            if (i == 497) {
                Message obtain2 = Message.obtain();
                obtain2.what = 101;
                Bundle bundle2 = new Bundle();
                bundle2.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
                bundle2.putString(MBridgeConstans.PLACEMENT_ID, this.d);
                bundle2.putString("request_id", this.e);
                bundle2.putString(C3040d4.h.W, this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
                bundle2.putString("url", str);
                obtain2.setData(bundle2);
                this.h.sendMessage(obtain2);
                if (this.f4637a) {
                    a(1, currentTimeMillis, str, "", str2);
                    return;
                }
                return;
            }
            if (i != 859) {
                return;
            }
            Message obtain3 = Message.obtain();
            obtain3.what = 103;
            Bundle bundle3 = new Bundle();
            bundle3.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.c);
            bundle3.putString(MBridgeConstans.PLACEMENT_ID, this.d);
            bundle3.putString("request_id", this.e);
            bundle3.putString(C3040d4.h.W, this.c + "_" + this.e + "_" + this.f.getSecondRequestIndex());
            obtain3.setData(bundle3);
            this.h.sendMessage(obtain3);
            n nVar = this.i;
            if (nVar != null) {
                nVar.a(this.d, this.c, this.e, str);
            }
            if (z) {
                return;
            }
            a(1, str, "", str2);
        }

        public void a(boolean z) {
            this.f4637a = z;
        }

        private void a(int i, String str, String str2, String str3) {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new a(i, str, str2, str3));
        }

        private void a(int i, long j, String str, String str2, String str3) {
            com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new RunnableC0369b(i, j, str, str2, str3));
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    private static final class m extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private Context f4640a;
        private ConcurrentHashMap<String, h> b;
        private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> c;

        public m(Looper looper) {
            super(looper);
            this.b = new ConcurrentHashMap<>();
            this.c = new ConcurrentHashMap<>();
        }

        public void a(String str, h hVar) {
            this.b.put(str, hVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:60:0x017e, code lost:
        
            if (r18.getRsIgnoreCheckRule().contains(0) != false) goto L263;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:279:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:281:? A[ADDED_TO_REGION, REMOVE, RETURN, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r10v22, types: [com.mbridge.msdk.videocommon.download.b] */
        /* JADX WARN: Type inference failed for: r10v8, types: [com.mbridge.msdk.videocommon.download.b] */
        /* JADX WARN: Type inference failed for: r11v10 */
        /* JADX WARN: Type inference failed for: r11v13 */
        /* JADX WARN: Type inference failed for: r11v16 */
        /* JADX WARN: Type inference failed for: r11v25 */
        /* JADX WARN: Type inference failed for: r11v30 */
        /* JADX WARN: Type inference failed for: r11v31 */
        /* JADX WARN: Type inference failed for: r11v32 */
        /* JADX WARN: Type inference failed for: r11v34 */
        /* JADX WARN: Type inference failed for: r11v35 */
        /* JADX WARN: Type inference failed for: r11v36 */
        /* JADX WARN: Type inference failed for: r11v37 */
        /* JADX WARN: Type inference failed for: r11v38 */
        /* JADX WARN: Type inference failed for: r11v39 */
        /* JADX WARN: Type inference failed for: r11v9, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r13v10 */
        /* JADX WARN: Type inference failed for: r13v11 */
        /* JADX WARN: Type inference failed for: r13v12 */
        /* JADX WARN: Type inference failed for: r13v13 */
        /* JADX WARN: Type inference failed for: r13v14, types: [boolean] */
        /* JADX WARN: Type inference failed for: r13v16 */
        /* JADX WARN: Type inference failed for: r13v17 */
        /* JADX WARN: Type inference failed for: r13v18 */
        /* JADX WARN: Type inference failed for: r13v19 */
        /* JADX WARN: Type inference failed for: r13v2, types: [int] */
        /* JADX WARN: Type inference failed for: r13v20 */
        /* JADX WARN: Type inference failed for: r13v21 */
        /* JADX WARN: Type inference failed for: r13v22 */
        /* JADX WARN: Type inference failed for: r13v23 */
        /* JADX WARN: Type inference failed for: r13v24 */
        /* JADX WARN: Type inference failed for: r13v25 */
        /* JADX WARN: Type inference failed for: r13v26 */
        /* JADX WARN: Type inference failed for: r13v27 */
        /* JADX WARN: Type inference failed for: r13v28 */
        /* JADX WARN: Type inference failed for: r13v29 */
        /* JADX WARN: Type inference failed for: r13v3 */
        /* JADX WARN: Type inference failed for: r13v30 */
        /* JADX WARN: Type inference failed for: r13v31 */
        /* JADX WARN: Type inference failed for: r13v32 */
        /* JADX WARN: Type inference failed for: r13v4 */
        /* JADX WARN: Type inference failed for: r13v5 */
        /* JADX WARN: Type inference failed for: r13v6 */
        /* JADX WARN: Type inference failed for: r13v7 */
        /* JADX WARN: Type inference failed for: r13v8 */
        /* JADX WARN: Type inference failed for: r13v9, types: [boolean] */
        /* JADX WARN: Type inference failed for: r3v5, types: [java.util.concurrent.CopyOnWriteArrayList, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>] */
        /* JADX WARN: Type inference failed for: r8v2, types: [com.mbridge.msdk.reward.adapter.b$h] */
        /* JADX WARN: Type inference failed for: r9v51 */
        /* JADX WARN: Type inference failed for: r9v52 */
        /* JADX WARN: Type inference failed for: r9v53 */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:119:0x0479 -> B:69:0x047a). Please report as a decompilation issue!!! */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            boolean z;
            boolean z2;
            String str;
            int i;
            CampaignEx campaignEx;
            String str2;
            ?? r9;
            Bundle data = message.getData();
            String string = data.getString(MBridgeConstans.PLACEMENT_ID);
            String string2 = data.getString(MBridgeConstans.PROPERTIES_UNIT_ID);
            String string3 = data.getString("request_id");
            String string4 = data.getString(C3040d4.h.W);
            f fVar = (f) b.g.get(string4);
            h hVar = this.b.get(string4);
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.c.get(string4);
            int i2 = message.what;
            switch (i2) {
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                    break;
                default:
                    switch (i2) {
                        case 200:
                        case 201:
                        case 203:
                        case 205:
                            if (fVar != null && hVar != 0) {
                                String string5 = data.getString(PglCryptUtils.KEY_MESSAGE);
                                if (string5 == null) {
                                    string5 = "";
                                }
                                ?? c = b.c(message.what);
                                ?? r11 = "resource download failed " + b.d(message.what) + " " + string5;
                                CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = fVar.h;
                                CampaignEx campaignEx2 = (copyOnWriteArrayList2 == null || copyOnWriteArrayList2.size() <= 0) ? null : fVar.h.get(0);
                                try {
                                } catch (Exception e) {
                                    e = e;
                                    str = r11;
                                    i = c == true ? 1 : 0;
                                    string = string;
                                    c = c;
                                }
                                if (!fVar.f4630a || fVar.i == null) {
                                    i = c;
                                    campaignEx = null;
                                    campaignEx = null;
                                    c = r11;
                                    try {
                                        ?? bVar = com.mbridge.msdk.videocommon.download.b.getInstance();
                                        String str3 = fVar.e;
                                        try {
                                            c = fVar.b;
                                            try {
                                                r11 = 94;
                                                r11 = 94;
                                                r11 = 94;
                                                r11 = 94;
                                                try {
                                                    if (bVar.a(94, str3, c, fVar.d, fVar.f4630a, fVar.c, copyOnWriteArrayList)) {
                                                        hVar.a(string, string2, string3, fVar.h);
                                                        str = c;
                                                        campaignEx = null;
                                                    } else {
                                                        if (campaignEx2 != null && campaignEx2.getRsIgnoreCheckRule() != null && campaignEx2.getRsIgnoreCheckRule().size() > 0) {
                                                            int i3 = message.what;
                                                            if (i3 != 200) {
                                                                if (i3 != 201) {
                                                                    if (i3 != 203) {
                                                                        if (i3 == 205 && campaignEx2.getRsIgnoreCheckRule().contains(3)) {
                                                                            string = string;
                                                                            c = c;
                                                                        }
                                                                    } else if (campaignEx2.getRsIgnoreCheckRule().contains(1)) {
                                                                        string = string;
                                                                        c = c;
                                                                    }
                                                                } else if (campaignEx2.getRsIgnoreCheckRule().contains(2)) {
                                                                    string = string;
                                                                    c = c;
                                                                }
                                                            } else if (campaignEx2.getRsIgnoreCheckRule().contains(0)) {
                                                                string = string;
                                                                c = c;
                                                            }
                                                        }
                                                        str = c;
                                                        campaignEx = null;
                                                        campaignEx = null;
                                                        try {
                                                            hVar.a(fVar.h, b.b(i, new MBridgeIds(string, string2, string3), str, null, null));
                                                        } catch (Exception e2) {
                                                            e = e2;
                                                        }
                                                    }
                                                    this.b.remove(string4);
                                                    b.g.remove(string4);
                                                    this.c.remove(string4);
                                                    break;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    str = c;
                                                    string = string;
                                                    c = c;
                                                }
                                            } catch (Exception e4) {
                                                e = e4;
                                                str = c;
                                                string = string;
                                                c = c;
                                            }
                                        } catch (Exception e5) {
                                            e = e5;
                                            str = c;
                                        }
                                    } catch (Exception e6) {
                                        e = e6;
                                        str = c;
                                    }
                                } else {
                                    try {
                                    } catch (Exception e7) {
                                        e = e7;
                                        str2 = r11;
                                        i = c;
                                    }
                                    if (fVar.c == 1) {
                                        if (campaignEx2 != null && campaignEx2.getRsIgnoreCheckRule() != null && campaignEx2.getRsIgnoreCheckRule().size() > 0) {
                                            int i4 = message.what;
                                            if (i4 == 200) {
                                                string = string;
                                                r11 = r11;
                                                c = c;
                                                break;
                                            } else if (i4 != 201) {
                                                if (i4 != 203) {
                                                    if (i4 == 205) {
                                                        if (campaignEx2.getRsIgnoreCheckRule().contains(3)) {
                                                            string = string;
                                                            r11 = r11;
                                                            c = c;
                                                        } else {
                                                            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList3 = fVar.h;
                                                            if (copyOnWriteArrayList3 != null && copyOnWriteArrayList3.size() > 0) {
                                                                CampaignEx campaignEx3 = fVar.h.get(0);
                                                                if (campaignEx3.getCMPTEntryUrl().equals(campaignEx3.getendcard_url()) && campaignEx2.getRsIgnoreCheckRule().contains(2)) {
                                                                    string = string;
                                                                    r11 = r11;
                                                                    c = c;
                                                                }
                                                            }
                                                        }
                                                    }
                                                } else if (campaignEx2.getRsIgnoreCheckRule().contains(1)) {
                                                    string = string;
                                                    r11 = r11;
                                                    c = c;
                                                }
                                            } else if (campaignEx2.getRsIgnoreCheckRule().contains(2)) {
                                                string = string;
                                                r11 = r11;
                                                c = c;
                                            }
                                            e = e;
                                            str = r11;
                                            i = c == true ? 1 : 0;
                                            string = string;
                                            c = c;
                                            campaignEx = null;
                                            MBridgeIds mBridgeIds = new MBridgeIds(string, string2, string3);
                                            ?? r3 = fVar.h;
                                            hVar.a(r3, b.b(i, mBridgeIds, str, e, campaignEx));
                                            string = r3;
                                            r11 = campaignEx;
                                            c = c;
                                        }
                                        try {
                                            r9 = null;
                                        } catch (Exception e8) {
                                            e = e8;
                                            r9 = null;
                                        }
                                        try {
                                            hVar.a(fVar.h, b.b(c, new MBridgeIds(string, string2, string3), r11, null, null));
                                            this.b.remove(string4);
                                            b.g.remove(string4);
                                            this.c.remove(string4);
                                            break;
                                        } catch (Exception e9) {
                                            e = e9;
                                            str = r11;
                                            i = c;
                                            campaignEx = r9;
                                            MBridgeIds mBridgeIds2 = new MBridgeIds(string, string2, string3);
                                            ?? r32 = fVar.h;
                                            hVar.a(r32, b.b(i, mBridgeIds2, str, e, campaignEx));
                                            string = r32;
                                            r11 = campaignEx;
                                            c = c;
                                            return;
                                        }
                                    } else {
                                        try {
                                            String string6 = data.getString("url");
                                            int i5 = message.what;
                                            try {
                                                if (i5 == 200) {
                                                    if (campaignEx2 != null && campaignEx2.getRsIgnoreCheckRule() != null && campaignEx2.getRsIgnoreCheckRule().size() > 0 && campaignEx2.getRsIgnoreCheckRule().contains(0)) {
                                                        p0.c("RewardCampaignsResourceManager", "Is TPL but  video download fail but hit ignoreCheckRule");
                                                        break;
                                                    } else {
                                                        for (int i6 = 0; i6 < fVar.i.size(); i6++) {
                                                            if (fVar.i.get(i6).getVideoUrlEncode().equals(string6)) {
                                                                fVar.i.remove(i6);
                                                            }
                                                        }
                                                        b.g.remove(string4);
                                                        b.g.put(string4, fVar);
                                                    }
                                                } else if (i5 == 201) {
                                                    if (campaignEx2 != null && campaignEx2.getRsIgnoreCheckRule() != null && campaignEx2.getRsIgnoreCheckRule().size() > 0 && campaignEx2.getRsIgnoreCheckRule().contains(2)) {
                                                        p0.c("RewardCampaignsResourceManager", "Is TPL but download endcard fail but hit ignoreCheckRule");
                                                        break;
                                                    } else {
                                                        for (int i7 = 0; i7 < fVar.i.size(); i7++) {
                                                            CampaignEx campaignEx4 = fVar.i.get(i7);
                                                            if (campaignEx4.getRewardTemplateMode() != null && campaignEx4.getRewardTemplateMode().c().equals(string6)) {
                                                                fVar.i.remove(i7);
                                                            }
                                                            if (!TextUtils.isEmpty(campaignEx4.getendcard_url()) && campaignEx4.getendcard_url().equals(string6)) {
                                                                fVar.i.remove(i7);
                                                            }
                                                        }
                                                        b.g.remove(string4);
                                                        b.g.put(string4, fVar);
                                                    }
                                                } else if (i5 == 203) {
                                                    if (campaignEx2 != null && campaignEx2.getRsIgnoreCheckRule() != null && campaignEx2.getRsIgnoreCheckRule().size() > 0 && campaignEx2.getRsIgnoreCheckRule().contains(1)) {
                                                        p0.c("RewardCampaignsResourceManager", "Is TPL but download template fail but hit ignoreCheckRule");
                                                        break;
                                                    } else {
                                                        for (int i8 = 0; i8 < fVar.i.size(); i8++) {
                                                            CampaignEx campaignEx5 = fVar.i.get(i8);
                                                            if (campaignEx5.getRewardTemplateMode() != null && campaignEx5.getRewardTemplateMode().e().equals(string6)) {
                                                                fVar.i.remove(i8);
                                                            }
                                                        }
                                                        b.g.remove(string4);
                                                        b.g.put(string4, fVar);
                                                    }
                                                } else if (i5 == 205) {
                                                    if (campaignEx2 != null && campaignEx2.getRsIgnoreCheckRule() != null && campaignEx2.getRsIgnoreCheckRule().size() > 0 && campaignEx2.getRsIgnoreCheckRule().contains(3)) {
                                                        p0.c("RewardCampaignsResourceManager", "Is TPL but download BTL Template fail but hit ignoreCheckRule");
                                                        break;
                                                    } else {
                                                        fVar.i.clear();
                                                        b.g.remove(string4);
                                                        b.g.put(string4, fVar);
                                                    }
                                                }
                                                ?? bVar2 = com.mbridge.msdk.videocommon.download.b.getInstance();
                                                String str4 = fVar.e;
                                                i = c;
                                                try {
                                                    c = fVar.b;
                                                    str2 = r11;
                                                    r11 = 94;
                                                } catch (Exception e10) {
                                                    e = e10;
                                                    str2 = r11;
                                                    c = c;
                                                    campaignEx = null;
                                                    str = str2;
                                                    MBridgeIds mBridgeIds22 = new MBridgeIds(string, string2, string3);
                                                    ?? r322 = fVar.h;
                                                    hVar.a(r322, b.b(i, mBridgeIds22, str, e, campaignEx));
                                                    string = r322;
                                                    r11 = campaignEx;
                                                    c = c;
                                                    return;
                                                }
                                                try {
                                                    if (bVar2.a(94, str4, c, fVar.d, fVar.f4630a, fVar.c, copyOnWriteArrayList)) {
                                                        try {
                                                            hVar.a(string, string2, string3, fVar.h);
                                                            this.b.remove(string4);
                                                            b.g.remove(string4);
                                                            this.c.remove(string4);
                                                            break;
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                            str = str2;
                                                            string = string;
                                                            c = c;
                                                        }
                                                    } else {
                                                        string = string;
                                                        c = c;
                                                        if (fVar.i.size() == 0) {
                                                            campaignEx = null;
                                                            try {
                                                                hVar.a(fVar.h, b.b(i, new MBridgeIds(string, string2, string3), str2, null, null));
                                                                this.b.remove(string4);
                                                                b.g.remove(string4);
                                                                this.c.remove(string4);
                                                                break;
                                                            } catch (Exception e12) {
                                                                e = e12;
                                                                str = str2;
                                                                MBridgeIds mBridgeIds222 = new MBridgeIds(string, string2, string3);
                                                                ?? r3222 = fVar.h;
                                                                hVar.a(r3222, b.b(i, mBridgeIds222, str, e, campaignEx));
                                                                string = r3222;
                                                                r11 = campaignEx;
                                                                c = c;
                                                                return;
                                                            }
                                                        }
                                                    }
                                                } catch (Exception e13) {
                                                    e = e13;
                                                    campaignEx = null;
                                                    str = str2;
                                                    MBridgeIds mBridgeIds2222 = new MBridgeIds(string, string2, string3);
                                                    ?? r32222 = fVar.h;
                                                    hVar.a(r32222, b.b(i, mBridgeIds2222, str, e, campaignEx));
                                                    string = r32222;
                                                    r11 = campaignEx;
                                                    c = c;
                                                    return;
                                                }
                                            } catch (Exception e14) {
                                                e = e14;
                                                str = r11;
                                                i = c;
                                                campaignEx = null;
                                            }
                                        } catch (Exception e15) {
                                            e = e15;
                                            str2 = r11;
                                            i = c;
                                            c = c;
                                        }
                                    }
                                }
                            }
                            break;
                    }
                    return;
            }
            if (fVar == null || hVar == 0) {
                return;
            }
            try {
                z = false;
            } catch (Exception e16) {
                e = e16;
                z = false;
            }
            try {
                z2 = com.mbridge.msdk.videocommon.download.b.getInstance().a(94, fVar.e, fVar.b, fVar.d, fVar.f4630a, fVar.c, copyOnWriteArrayList);
            } catch (Exception e17) {
                e = e17;
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                }
                z2 = z;
                if (z2) {
                }
            }
            if (z2) {
                return;
            }
            hVar.a(string, string2, string3, fVar.h);
            this.b.remove(string4);
            b.g.remove(string4);
            this.c.remove(string4);
        }

        public void a(Context context) {
            this.f4640a = context;
        }

        public void a(String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
            this.c.put(str, copyOnWriteArrayList);
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    public interface n {
        void a(String str, String str2, com.mbridge.msdk.foundation.error.b bVar);

        void a(String str, String str2, String str3, String str4);
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    public interface o {
        void a(String str, String str2, String str3, a.C0420a c0420a, com.mbridge.msdk.foundation.error.b bVar);

        void a(String str, String str2, String str3, String str4, String str5, a.C0420a c0420a);
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    private static final class r {

        /* renamed from: a, reason: collision with root package name */
        private static final b f4645a = new b(null);
    }

    /* synthetic */ b(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(int i2) {
        if (i2 == 200) {
            return 880004;
        }
        if (i2 == 201) {
            return 880007;
        }
        if (i2 != 203) {
            return i2 != 205 ? 880024 : 880005;
        }
        return 880006;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static synchronized String d(int i2) {
        synchronized (b.class) {
            return i2 != 200 ? i2 != 201 ? i2 != 203 ? i2 != 205 ? "unknown" : "tpl" : "temp" : "zip/html" : "video";
        }
    }

    public void c() {
    }

    private b() {
        this.c = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
        this.d = "down_type";
        this.e = "h3c";
        this.f = new ArrayList(6);
        HandlerThread handlerThread = new HandlerThread("mb-reward-load-thread");
        g = new ConcurrentHashMap<>();
        handlerThread.start();
        this.f4624a = new m(handlerThread.getLooper());
    }

    public static b b() {
        return r.f4645a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(com.mbridge.msdk.foundation.entity.n nVar, CampaignEx campaignEx) {
        try {
            com.mbridge.msdk.videocommon.setting.c c2 = com.mbridge.msdk.videocommon.setting.b.b().c(com.mbridge.msdk.foundation.controller.c.m().b(), campaignEx.getCampaignUnitId());
            if (c2 != null) {
                nVar.s(c2.x());
            }
            com.mbridge.msdk.videocommon.setting.a c3 = com.mbridge.msdk.videocommon.setting.b.b().c();
            if (c3 != null) {
                nVar.r(c3.f());
            }
        } catch (Exception e2) {
            p0.b("RewardCampaignsResourceManager", e2.getMessage());
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    private static final class k implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        private Handler f4636a;
        private final String b;
        private final String c;
        private final String d;
        private final String e;

        public k(Handler handler, String str, String str2, String str3, String str4) {
            this.f4636a = handler;
            this.c = str;
            this.b = str2;
            this.d = str3;
            this.e = str4;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str, true);
            Message obtain = Message.obtain();
            obtain.what = 100;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle.putString("request_id", this.d);
            bundle.putString(C3040d4.h.W, this.e);
            bundle.putString("url", str);
            obtain.setData(bundle);
            this.f4636a.sendMessage(obtain);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            ResDownloadCheckManager.getInstance().setVideoDownloadDone(str2, false);
            Message obtain = Message.obtain();
            obtain.what = 200;
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, this.b);
            bundle.putString(MBridgeConstans.PLACEMENT_ID, this.c);
            bundle.putString("request_id", this.d);
            bundle.putString("url", str2);
            bundle.putString(C3040d4.h.W, this.e);
            bundle.putString(PglCryptUtils.KEY_MESSAGE, str);
            obtain.setData(bundle);
            this.f4636a.sendMessage(obtain);
        }
    }

    public synchronized void a(Context context, boolean z, int i2, boolean z2, int i3, String str, String str2, String str3, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, h hVar, n nVar) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
        String str4 = str2 + "_" + str3 + "_" + copyOnWriteArrayList2.get(0).getSecondRequestIndex();
        g.put(str4, new f(z, z2, i2, copyOnWriteArrayList2.size(), str2, str3, i3, copyOnWriteArrayList2));
        this.f4624a.a(str4, hVar);
        this.f4624a.a(context);
        this.f4624a.a(str4, copyOnWriteArrayList2);
        this.f4624a.post(new a(copyOnWriteArrayList2, context, str2, i3, str, str3, str4, nVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.mbridge.msdk.foundation.error.b b(int i2, MBridgeIds mBridgeIds, String str, Throwable th, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(i2);
        bVar.a(mBridgeIds);
        bVar.a(th);
        bVar.c(str);
        bVar.a(campaignEx);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i2, CampaignEx campaignEx, String str, String str2) {
        y.a(i2, str, str2, new C0368b(i2, campaignEx), campaignEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, String str, String str2, String str3, CampaignEx campaignEx, String str4, n nVar, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        if (TextUtils.isEmpty(str4) || campaignEx.isMraid()) {
            return;
        }
        com.mbridge.msdk.foundation.same.report.metrics.c a2 = a(campaignEx, 3);
        if (str4.contains(".zip") && str4.contains(ResourceManager.KEY_MD5FILENAME)) {
            boolean isEmpty = TextUtils.isEmpty(H5DownLoadManager.getInstance().getH5ResAddress(str4));
            try {
                l lVar = new l(context, str, str2, str3, campaignEx, 497, this.f4624a, nVar, copyOnWriteArrayList);
                lVar.a(isEmpty);
                H5DownLoadManager.getInstance().downloadH5Res(a2, str4, lVar);
                return;
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                    return;
                }
                return;
            }
        }
        boolean isEmpty2 = TextUtils.isEmpty(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str4));
        try {
            i iVar = new i(497, str, str2, str3, campaignEx, nVar, this.f4624a, copyOnWriteArrayList);
            iVar.a(isEmpty2);
            H5DownLoadManager.getInstance().downloadH5Res(a2, str4, iVar);
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardCampaignsResourceManager", e3.getLocalizedMessage());
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    private static class g extends com.mbridge.msdk.mbsignalcommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        private final Handler f4631a;
        private final Runnable b;
        private final boolean c;
        private final boolean d;
        private int e;
        private String f;
        private String g;
        private String h;
        private String i;
        private a.C0420a j;
        private CampaignEx k;
        private CopyOnWriteArrayList<CampaignEx> l;
        private com.mbridge.msdk.videocommon.setting.c m;
        private final o n;
        private boolean o;
        private boolean p;
        private boolean q;
        private int r = 0;
        private boolean s;
        private long t;

        public g(boolean z, Handler handler, Runnable runnable, boolean z2, boolean z3, int i, String str, String str2, String str3, String str4, a.C0420a c0420a, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.videocommon.setting.c cVar, o oVar, boolean z4, long j) {
            this.f4631a = handler;
            this.b = runnable;
            this.c = z2;
            this.d = z3;
            this.e = i;
            this.f = str;
            this.h = str2;
            this.g = str3;
            this.i = str4;
            this.j = c0420a;
            this.k = campaignEx;
            this.l = copyOnWriteArrayList;
            this.m = cVar;
            this.n = oVar;
            this.o = z4;
            this.s = z;
            this.t = j;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i) {
            Runnable runnable;
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 1);
                eVar.a("result", Integer.valueOf(i));
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", this.k, eVar);
            } catch (Throwable th) {
                p0.b("RVWindVaneWebView", th.getMessage());
            }
            if (this.q) {
                return;
            }
            String str = this.g + "_" + this.f;
            if (i == 1) {
                if (this.o) {
                    com.mbridge.msdk.videocommon.a.d(this.g + "_" + this.i);
                } else {
                    com.mbridge.msdk.videocommon.a.c(this.g + "_" + this.i);
                }
                com.mbridge.msdk.videocommon.a.a(this.g + "_" + this.i + "_" + this.f, this.j, true, this.o);
                Handler handler = this.f4631a;
                if (handler != null && (runnable = this.b) != null) {
                    handler.removeCallbacks(runnable);
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.g + "_" + this.i + "_" + this.f, true);
                a.C0420a c0420a = this.j;
                if (c0420a != null) {
                    c0420a.a(true);
                }
                o oVar = this.n;
                if (oVar != null) {
                    oVar.a(str, this.h, this.g, this.i, this.f, this.j);
                }
            } else {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.g + "_" + this.i + "_" + this.f, false);
                a.C0420a c0420a2 = this.j;
                if (c0420a2 != null) {
                    c0420a2.a(false);
                }
                if (this.n != null) {
                    this.n.a(str, this.i, this.f, this.j, b.b(880008, new MBridgeIds(this.h, this.g, this.i), "readyState:" + i, null, this.k));
                }
            }
            this.q = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a
        public void a(WebView webView, String str, String str2, int i, int i2) {
            boolean z = true;
            if (i == 1) {
                try {
                    com.mbridge.msdk.reward.controller.a aVar = new com.mbridge.msdk.reward.controller.a();
                    aVar.e(false);
                    if (i2 != 2) {
                        z = false;
                    }
                    aVar.d(z);
                    aVar.c(str, str2);
                    aVar.a(new com.mbridge.msdk.video.bt.module.orglistener.a(null));
                    aVar.a(false, com.mbridge.msdk.foundation.same.report.metrics.d.b().a(0, i2, str2, true, 1));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("RVWindVaneWebView", e.getMessage());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a
        public void a(Object obj, String str) {
            if (obj != null) {
                try {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    String optString = new JSONObject(str).optString("id");
                    com.mbridge.msdk.video.bt.component.d.c().b(obj, optString);
                    String f = com.mbridge.msdk.video.bt.component.d.c().f(optString);
                    CampaignEx c = com.mbridge.msdk.video.bt.component.d.c().c(optString);
                    com.mbridge.msdk.videocommon.setting.c d = com.mbridge.msdk.video.bt.component.d.c().d(optString);
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    copyOnWriteArrayList.add(c);
                    WindVaneWebView windVaneWebView = ((com.mbridge.msdk.mbsignalcommon.windvane.a) obj).b;
                    if (windVaneWebView != null) {
                        b.b().a(this.s, windVaneWebView, c, (CopyOnWriteArrayList<CampaignEx>) copyOnWriteArrayList, d, f, optString, this.r == 0 ? 3 : 6);
                        this.r++;
                    }
                } catch (Throwable th) {
                    p0.b("RVWindVaneWebView", th.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            Runnable runnable;
            super.a(webView, str);
            if (this.p) {
                return;
            }
            String str2 = this.g + "_" + this.f;
            if (!str.contains("wfr=1")) {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.g + "_" + this.i + "_" + this.f, true);
                Handler handler = this.f4631a;
                if (handler != null && (runnable = this.b) != null) {
                    handler.removeCallbacks(runnable);
                }
                a.C0420a c0420a = this.j;
                if (c0420a != null) {
                    c0420a.a(true);
                }
                o oVar = this.n;
                if (oVar != null) {
                    oVar.a(str2, this.h, this.g, this.i, this.f, this.j);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(webView);
            this.p = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) {
            super.a(webView, i, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.g + "_" + this.i + "_" + this.f, false);
            if (this.n != null) {
                String str3 = this.g + "_" + this.f;
                a.C0420a c0420a = this.j;
                if (c0420a != null) {
                    c0420a.a(false);
                }
                this.n.a(str3, this.i, this.f, this.j, b.b(880008, new MBridgeIds(this.h, this.g, this.i), "onReceivedError： " + i + "  " + str, null, this.k));
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.a, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView) {
            if (webView != null) {
                try {
                    com.mbridge.msdk.video.bt.component.d.c().c(this.g, this.i);
                } catch (Throwable th) {
                    p0.b("RVWindVaneWebView", th.getMessage());
                }
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    /* renamed from: com.mbridge.msdk.reward.adapter.b$b, reason: collision with other inner class name */
    class C0368b implements y.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f4626a;
        final /* synthetic */ CampaignEx b;

        C0368b(int i, CampaignEx campaignEx) {
            this.f4626a = i;
            this.b = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.tools.y.c
        public void a(String str, String str2, String str3, String str4, boolean z) {
            if (z) {
                return;
            }
            try {
                com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n();
                int i = this.f4626a;
                if (i == 0) {
                    nVar.e(1);
                    nVar.d(1);
                    nVar.j("m_download_end");
                } else if (i == 1) {
                    nVar.e(2);
                    nVar.d(1);
                    nVar.j("m_download_end");
                } else if (i == 2) {
                    nVar.e(3);
                    nVar.d(1);
                    nVar.j("m_download_end");
                    nVar.b(this.b.isMraid() ? com.mbridge.msdk.foundation.entity.n.N : com.mbridge.msdk.foundation.entity.n.O);
                    nVar.f("1");
                }
                nVar.o(this.b.getRequestIdNotice());
                nVar.b("url", str);
                nVar.b("scenes", "1");
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a(nVar, this.b);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardCampaignsResourceManager", e.getMessage());
                }
            }
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
            com.mbridge.msdk.foundation.entity.n nVar = new com.mbridge.msdk.foundation.entity.n();
            int i = this.f4626a;
            if (i == 0) {
                nVar.e(1);
                nVar.d(3);
                nVar.j("m_download_end");
            } else if (i == 1) {
                nVar.e(2);
                nVar.d(3);
                nVar.j("m_download_end");
            } else if (i == 2) {
                nVar.e(3);
                nVar.d(3);
                nVar.j("m_download_end");
                nVar.b(this.b.isMraid() ? com.mbridge.msdk.foundation.entity.n.N : com.mbridge.msdk.foundation.entity.n.O);
                nVar.f("1");
            }
            b.b(nVar, this.b);
            nVar.o(this.b.getRequestIdNotice());
            nVar.m(str2);
            nVar.b("scenes", "1");
            nVar.b("url", str);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(nVar, this.b);
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    private static class q extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* renamed from: a, reason: collision with root package name */
        private String f4644a;
        private final boolean b;
        private final WindVaneWebView c;
        private final String d;
        private final String e;
        private final a.C0420a f;
        private final CampaignEx g;
        private boolean h;
        private String i;
        private boolean j;
        private boolean k;

        public q(String str, boolean z, WindVaneWebView windVaneWebView, String str2, String str3, a.C0420a c0420a, CampaignEx campaignEx, boolean z2, String str4) {
            this.b = z;
            this.c = windVaneWebView;
            this.d = str2;
            this.e = str3;
            this.f = c0420a;
            this.g = campaignEx;
            this.f4644a = str;
            this.h = z2;
            this.i = str4;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i) {
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 2);
                eVar.a("result", Integer.valueOf(i));
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", this.g, eVar);
            } catch (Throwable th) {
                p0.b("WindVaneWebView", th.getMessage());
            }
            if (this.k) {
                return;
            }
            if (this.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f4644a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", i);
                    jSONObject2.put("error", "");
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("WindVaneWebView", e.getLocalizedMessage());
                    }
                }
            }
            String str = this.e + "_" + this.g.getId() + "_" + this.g.getRequestId() + "_" + this.d;
            if (i == 1) {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.e + "_" + this.i + "_" + this.d, true);
                a.C0420a c0420a = this.f;
                if (c0420a != null) {
                    c0420a.a(true);
                }
                if (this.b) {
                    if (this.g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                    }
                } else if (this.g.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                } else {
                    com.mbridge.msdk.videocommon.a.a(str, this.f, false, this.h);
                }
            } else {
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.e + "_" + this.i + "_" + this.d, false);
                a.C0420a c0420a2 = this.f;
                if (c0420a2 != null) {
                    c0420a2.a(false);
                }
            }
            this.k = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) {
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.e + "_" + this.i + "_" + this.d, false);
            a.C0420a c0420a = this.f;
            if (c0420a != null) {
                c0420a.a(false);
            }
            if (this.c != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", this.f4644a);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("result", 2);
                    jSONObject2.put("error", str);
                    jSONObject.put("data", jSONObject2);
                    com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.c, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("WindVaneWebView", e.getLocalizedMessage());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            if (this.j) {
                return;
            }
            if (!str.contains("wfr=1")) {
                if (this.c != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", this.f4644a);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put("error", "");
                        jSONObject.put("data", jSONObject2);
                        com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) this.c, "componentReact", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("WindVaneWebView", e.getLocalizedMessage());
                        }
                    }
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.e + "_" + this.i + "_" + this.d, true);
                a.C0420a c0420a = this.f;
                if (c0420a != null) {
                    c0420a.a(true);
                }
                String str2 = this.e + "_" + this.g.getId() + "_" + this.g.getRequestId() + "_" + this.d;
                if (this.b) {
                    if (this.g.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.g.getRequestIdNotice(), this.f);
                    } else {
                        com.mbridge.msdk.videocommon.a.a(str2, this.f, false, this.h);
                    }
                } else if (this.g.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(94, this.g.getRequestIdNotice(), this.f);
                } else {
                    com.mbridge.msdk.videocommon.a.a(str2, this.f, false, this.h);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(webView);
            this.j = true;
        }
    }

    public synchronized void a(Context context, CampaignEx campaignEx, String str, String str2, String str3, n nVar) {
        this.f4624a.a(context);
        if (campaignEx != null) {
            String cMPTEntryUrl = campaignEx.getCMPTEntryUrl();
            if (campaignEx.isDynamicView()) {
                if (u0.a(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW, cMPTEntryUrl)) {
                    a(0, campaignEx, campaignEx.getMof_tplid() + "", cMPTEntryUrl);
                }
                ResDownloadCheckManager.getInstance().setZipDownloadDone(cMPTEntryUrl, true);
                Message obtain = Message.obtain();
                obtain.what = 105;
                Bundle bundle = new Bundle();
                bundle.putString(MBridgeConstans.PROPERTIES_UNIT_ID, str2);
                bundle.putString(MBridgeConstans.PLACEMENT_ID, str);
                bundle.putString("request_id", str3);
                bundle.putString(C3040d4.h.W, str2 + "_" + str3 + "_" + campaignEx.getSecondRequestIndex());
                bundle.putString("url", cMPTEntryUrl);
                obtain.setData(bundle);
                this.f4624a.sendMessage(obtain);
                if (nVar != null) {
                    nVar.a(str, str2, str3, cMPTEntryUrl);
                }
                return;
            }
        }
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getCMPTEntryUrl())) {
            try {
                com.mbridge.msdk.foundation.same.report.metrics.c b = com.mbridge.msdk.foundation.same.report.metrics.d.b().b(campaignEx.getCurrentLocalRid());
                if (b == null) {
                    b = new com.mbridge.msdk.foundation.same.report.metrics.c();
                }
                com.mbridge.msdk.foundation.same.report.metrics.c cVar = b;
                cVar.a(campaignEx);
                cVar.e(1);
                cVar.f(a(campaignEx));
                H5DownLoadManager.getInstance().downloadH5Res(cVar, campaignEx.getCMPTEntryUrl(), new c(str2, str, str3, campaignEx, nVar, context));
            } catch (Exception e2) {
                p0.b("RewardCampaignsResourceManager", e2.getLocalizedMessage());
            }
        }
    }

    /* compiled from: RewardCampaignsResourceManager.java */
    private static class p extends com.mbridge.msdk.mbsignalcommon.listener.b {

        /* renamed from: a, reason: collision with root package name */
        private Handler f4641a;
        private Runnable b;
        private final boolean c;
        private final boolean d;
        private String e;
        private final o f;
        private final WindVaneWebView g;
        private final String h;
        private final String i;
        private final String j;
        private final a.C0420a k;
        private final CampaignEx l;
        private CopyOnWriteArrayList<CampaignEx> m;
        private long n;
        private boolean o;
        private boolean p;
        private final Runnable q;
        private final Runnable r;

        /* compiled from: RewardCampaignsResourceManager.java */
        class a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f4642a;
            final /* synthetic */ a.C0420a b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;
            final /* synthetic */ String f;

            a(o oVar, a.C0420a c0420a, String str, String str2, String str3, String str4) {
                this.f4642a = oVar;
                this.b = c0420a;
                this.c = str;
                this.d = str2;
                this.e = str3;
                this.f = str4;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindVaneWebView b;
                a.C0420a c0420a;
                if (this.f4642a != null && (c0420a = this.b) != null) {
                    c0420a.a(true);
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.c + "_" + this.d + "_" + this.e, true);
                    this.f4642a.a(this.c + "_" + this.e, this.f, this.c, this.d, this.e, this.b);
                }
                a.C0420a c0420a2 = this.b;
                if (c0420a2 == null || (b = c0420a2.b()) == null) {
                    return;
                }
                try {
                    b.release();
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("WindVaneWebView", e.getMessage());
                    }
                }
            }
        }

        /* compiled from: RewardCampaignsResourceManager.java */
        /* renamed from: com.mbridge.msdk.reward.adapter.b$p$b, reason: collision with other inner class name */
        class RunnableC0370b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ o f4643a;
            final /* synthetic */ a.C0420a b;
            final /* synthetic */ String c;
            final /* synthetic */ String d;
            final /* synthetic */ String e;
            final /* synthetic */ String f;

            RunnableC0370b(o oVar, a.C0420a c0420a, String str, String str2, String str3, String str4) {
                this.f4643a = oVar;
                this.b = c0420a;
                this.c = str;
                this.d = str2;
                this.e = str3;
                this.f = str4;
            }

            @Override // java.lang.Runnable
            public void run() {
                WindVaneWebView b;
                a.C0420a c0420a;
                if (this.f4643a != null && (c0420a = this.b) != null) {
                    c0420a.a(true);
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.c + "_" + this.d + "_" + this.e, true);
                    this.f4643a.a(this.c + "_" + this.e, this.f, this.c, this.d, this.e, this.b);
                }
                a.C0420a c0420a2 = this.b;
                if (c0420a2 == null || (b = c0420a2.b()) == null) {
                    return;
                }
                try {
                    b.release();
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        p0.b("WindVaneWebView", e.getMessage());
                    }
                }
            }
        }

        public p(Handler handler, Runnable runnable, boolean z, boolean z2, String str, o oVar, WindVaneWebView windVaneWebView, String str2, String str3, String str4, a.C0420a c0420a, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, long j) {
            this.f4641a = handler;
            this.b = runnable;
            this.c = z;
            this.d = z2;
            this.e = str;
            this.f = oVar;
            this.g = windVaneWebView;
            this.h = str2;
            this.i = str4;
            this.j = str3;
            this.k = c0420a;
            this.l = campaignEx;
            this.m = copyOnWriteArrayList;
            this.n = j;
            a aVar = new a(oVar, c0420a, str4, str, str2, str3);
            this.r = aVar;
            this.q = new RunnableC0370b(oVar, c0420a, str4, str, str2, str3);
            if (handler != null) {
                handler.postDelayed(aVar, 5000L);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i) {
            Handler handler;
            Runnable runnable;
            Runnable runnable2;
            super.a(webView, i);
            Handler handler2 = this.f4641a;
            if (handler2 != null && (runnable2 = this.q) != null) {
                handler2.removeCallbacks(runnable2);
            }
            Handler handler3 = this.f4641a;
            if (handler3 != null && (runnable = this.r) != null) {
                handler3.removeCallbacks(runnable);
            }
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 2);
                eVar.a("result", Integer.valueOf(i));
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000155", this.l, eVar);
            } catch (Throwable th) {
                p0.b("WindVaneWebView", th.getMessage());
            }
            if (this.p) {
                return;
            }
            String str = this.i + "_" + this.h;
            if (i == 1) {
                Runnable runnable3 = this.b;
                if (runnable3 != null && (handler = this.f4641a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.i + "_" + this.e + "_" + this.h, true);
                a.C0420a c0420a = this.k;
                if (c0420a != null) {
                    c0420a.a(true);
                }
                if (this.c) {
                    if (this.d) {
                        com.mbridge.msdk.videocommon.a.a(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.l.getRequestIdNotice(), this.k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.l.getRequestIdNotice(), this.k);
                    }
                } else if (this.d) {
                    com.mbridge.msdk.videocommon.a.a(94, this.l.getRequestIdNotice(), this.k);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.l.getRequestIdNotice(), this.k);
                }
                o oVar = this.f;
                if (oVar != null) {
                    oVar.a(str, this.j, this.i, this.e, this.h, this.k);
                }
            } else if (this.f != null) {
                this.f.a(str, this.e, this.h, this.k, b.b(880009, new MBridgeIds(this.j, this.i, this.e), "readyState:" + i, null, this.l));
            }
            this.p = true;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, int i, String str, String str2) {
            super.a(webView, i, str, str2);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.i + "_" + this.e + "_" + this.h, false);
            Handler handler = this.f4641a;
            if (handler != null) {
                if (this.q != null) {
                    handler.removeCallbacks(this.r);
                }
                Runnable runnable = this.q;
                if (runnable != null) {
                    this.f4641a.removeCallbacks(runnable);
                }
            }
            try {
                String str3 = this.i + "_" + this.h;
                a.C0420a c0420a = this.k;
                if (c0420a != null) {
                    c0420a.a(false);
                }
                if (this.f != null) {
                    this.f.a(str3, this.e, str2, this.k, b.b(880009, new MBridgeIds(this.j, this.i, this.e), i + "#" + str, null, this.l));
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("WindVaneWebView", e.getLocalizedMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.a(webView, sslErrorHandler, sslError);
            ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.i + "_" + this.e + "_" + this.h, false);
            Handler handler = this.f4641a;
            if (handler != null) {
                if (this.q != null) {
                    handler.removeCallbacks(this.r);
                }
                Runnable runnable = this.q;
                if (runnable != null) {
                    this.f4641a.removeCallbacks(runnable);
                }
            }
            try {
                String str = this.i + "_" + this.h;
                a.C0420a c0420a = this.k;
                if (c0420a != null) {
                    c0420a.a(false);
                }
                if (this.f != null) {
                    this.f.a(str, this.e, this.h, this.k, b.b(880009, new MBridgeIds(this.j, this.i, this.e), "onReceivedSslError:" + (sslError == null ? "" : Integer.valueOf(sslError.getPrimaryError())), null, this.l));
                }
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("WindVaneWebView", e.getLocalizedMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            Runnable runnable;
            Handler handler;
            Runnable runnable2;
            super.a(webView, str);
            Handler handler2 = this.f4641a;
            if (handler2 != null && (runnable2 = this.r) != null) {
                handler2.removeCallbacks(runnable2);
            }
            if (this.o) {
                return;
            }
            if (!str.contains("wfr=1")) {
                String str2 = this.i + "_" + this.h;
                ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(this.i + "_" + this.e + "_" + this.h, true);
                Runnable runnable3 = this.b;
                if (runnable3 != null && (handler = this.f4641a) != null) {
                    handler.removeCallbacks(runnable3);
                }
                a.C0420a c0420a = this.k;
                if (c0420a != null) {
                    c0420a.a(true);
                }
                if (this.c) {
                    if (this.l.isBidCampaign()) {
                        com.mbridge.msdk.videocommon.a.a(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.l.getRequestIdNotice(), this.k);
                    } else {
                        com.mbridge.msdk.videocommon.a.b(MBSupportMuteAdType.INTERSTITIAL_VIDEO, this.l.getRequestIdNotice(), this.k);
                    }
                } else if (this.l.isBidCampaign()) {
                    com.mbridge.msdk.videocommon.a.a(94, this.l.getRequestIdNotice(), this.k);
                } else {
                    com.mbridge.msdk.videocommon.a.b(94, this.l.getRequestIdNotice(), this.k);
                }
                o oVar = this.f;
                if (oVar != null) {
                    oVar.a(str2, this.j, this.i, this.e, this.h, this.k);
                }
            } else {
                Handler handler3 = this.f4641a;
                if (handler3 != null && (runnable = this.q) != null) {
                    handler3.postDelayed(runnable, 5000L);
                }
            }
            com.mbridge.msdk.mbsignalcommon.windvane.f.a().a(webView);
            this.o = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Context context, int i2, CampaignEx campaignEx, String str, String str2, String str3, String str4) {
        com.mbridge.msdk.foundation.same.threadpool.a.e().execute(new d(campaignEx, context, i2, str, str2, str3, str4));
    }

    public synchronized void a(boolean z, Handler handler, boolean z2, boolean z3, WindVaneWebView windVaneWebView, String str, int i2, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str2, String str3, String str4, String str5, String str6, com.mbridge.msdk.videocommon.setting.c cVar, o oVar) {
        String str7;
        String str8;
        a.C0420a c0420a;
        com.mbridge.msdk.video.signal.impl.k kVar;
        String str9 = str4;
        synchronized (this) {
            String str10 = str9 + "_" + str;
            long currentTimeMillis = System.currentTimeMillis();
            try {
            } catch (Exception e2) {
                e = e2;
                str7 = str5;
                str8 = str10;
            }
            if (u0.i(str)) {
                if (oVar != null) {
                    try {
                        oVar.a(str10, str3, str9, str5, str, null);
                    } catch (Exception e3) {
                        e = e3;
                        str8 = str10;
                    }
                }
                return;
            }
            str8 = str10;
            try {
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 2);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000154", campaignEx, eVar);
                c0420a = new a.C0420a();
            } catch (Exception e4) {
                e = e4;
            }
            try {
                try {
                    WindVaneWebView windVaneWebView2 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().d());
                    if (campaignEx != null) {
                        windVaneWebView2.setLocalRequestId(campaignEx.getCurrentLocalRid());
                    }
                    windVaneWebView2.setTempTypeForMetrics(2);
                    try {
                        c0420a.a(windVaneWebView2);
                        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                            kVar = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx, copyOnWriteArrayList);
                        } else {
                            kVar = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx);
                        }
                        com.mbridge.msdk.video.signal.impl.k kVar2 = kVar;
                        kVar2.g(i2);
                        kVar2.setUnitId(str9);
                        kVar2.setRewardUnitSetting(cVar);
                        kVar2.d(z);
                        str7 = str5;
                        try {
                            windVaneWebView2.setWebViewListener(new p(handler, null, z2, z3, str7, oVar, windVaneWebView, str, str3, str9, c0420a, campaignEx, copyOnWriteArrayList, currentTimeMillis));
                            windVaneWebView2.setObject(kVar2);
                            windVaneWebView2.loadUrl(str2);
                            windVaneWebView2.setRid(str7);
                        } catch (Exception e5) {
                            e = e5;
                            str9 = str9;
                        }
                    } catch (Exception e6) {
                        e = e6;
                    }
                } catch (Exception e7) {
                    e = e7;
                }
            } catch (Exception unused) {
                if (oVar != null) {
                    c0420a.a(true);
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str9 + "_" + str5 + "_" + str, true);
                    oVar.a(str9 + "_" + str, str3, str9, str5, str, c0420a);
                    return;
                }
                return;
            } catch (Throwable unused2) {
                if (oVar != null) {
                    c0420a.a(true);
                    ResDownloadCheckManager.getInstance().setTemplatePreLoadDone(str9 + "_" + str5 + "_" + str, true);
                    oVar.a(str9 + "_" + str, str3, str9, str5, str, c0420a);
                    return;
                }
                return;
            }
            str7 = str5;
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
            }
            if (oVar != null) {
                oVar.a(str8, str7, str, null, b(880009, new MBridgeIds(str3, str9, str7), "", e, campaignEx));
            }
        }
    }

    public synchronized void a(boolean z, Handler handler, boolean z2, boolean z3, String str, String str2, String str3, String str4, String str5, int i2, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str6, String str7, com.mbridge.msdk.videocommon.setting.c cVar, o oVar, boolean z4) {
        String str8;
        a.C0420a c0420a;
        WindVaneWebView windVaneWebView;
        String b;
        String b2;
        com.mbridge.msdk.video.signal.impl.k kVar;
        com.mbridge.msdk.video.signal.impl.k kVar2;
        String str9 = str4;
        synchronized (this) {
            this.b = z4;
            long currentTimeMillis = System.currentTimeMillis();
            String str10 = str9 + "_" + str5;
            this.b = z4;
            if (u0.i(str5)) {
                if (oVar != null) {
                    oVar.a(str10, str3, str9, str, str5, null);
                }
                return;
            }
            try {
                p0.a("RewardCampaignsResourceManager", "开始预加载大模板资源");
                com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                eVar.a("type", 1);
                com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000154", campaignEx, eVar);
                c0420a = new a.C0420a();
                windVaneWebView = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().d());
                if (campaignEx != null) {
                    windVaneWebView.setLocalRequestId(campaignEx.getCurrentLocalRid());
                }
                windVaneWebView.setTempTypeForMetrics(1);
                c0420a.a(windVaneWebView);
                b = com.mbridge.msdk.video.bt.component.d.c().b();
                b2 = com.mbridge.msdk.video.bt.component.d.c().b();
                c0420a.a(b2);
                if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                    CopyOnWriteArrayList<CampaignEx> b3 = com.mbridge.msdk.videocommon.download.b.getInstance().b(str9);
                    if (b3 != null && b3.size() > 0) {
                        for (int i3 = 0; i3 < copyOnWriteArrayList.size(); i3++) {
                            CampaignEx campaignEx2 = copyOnWriteArrayList.get(i3);
                            for (CampaignEx campaignEx3 : b3) {
                                if (campaignEx3.getId().equals(campaignEx2.getId()) && campaignEx3.getRequestId().equals(campaignEx2.getRequestId())) {
                                    campaignEx2.setReady(true);
                                    copyOnWriteArrayList.set(i3, campaignEx2);
                                }
                            }
                        }
                    }
                    kVar = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx, copyOnWriteArrayList);
                } else {
                    kVar = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx);
                }
                kVar.g(i2);
                kVar.setUnitId(str7);
                kVar.c(b2);
                kVar.d(b);
                kVar.c(true);
                kVar.setRewardUnitSetting(cVar);
                kVar.d(z);
                kVar2 = kVar;
                try {
                    str9 = str4;
                    str8 = str;
                } catch (Exception e2) {
                    e = e2;
                    str9 = str4;
                    str8 = str;
                }
            } catch (Exception e3) {
                e = e3;
                str8 = str;
            }
            try {
                windVaneWebView.setWebViewListener(new g(z, handler, null, z2, z3, i2, str5, str3, str4, str, c0420a, campaignEx, copyOnWriteArrayList, cVar, oVar, z4, currentTimeMillis));
                windVaneWebView.setObject(kVar2);
                windVaneWebView.loadUrl(str6);
                windVaneWebView.setRid(str8);
                MBridgeBTRootLayout mBridgeBTRootLayout = new MBridgeBTRootLayout(com.mbridge.msdk.foundation.controller.c.m().d());
                mBridgeBTRootLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                mBridgeBTRootLayout.setInstanceId(b);
                mBridgeBTRootLayout.setUnitId(str9);
                MBridgeBTLayout mBridgeBTLayout = new MBridgeBTLayout(com.mbridge.msdk.foundation.controller.c.m().d());
                mBridgeBTLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                mBridgeBTLayout.setInstanceId(b2);
                mBridgeBTLayout.setUnitId(str9);
                mBridgeBTLayout.setWebView(windVaneWebView);
                LinkedHashMap<String, View> b4 = com.mbridge.msdk.video.bt.component.d.c().b(str9, str8);
                b4.put(b2, mBridgeBTLayout);
                b4.put(b, mBridgeBTRootLayout);
                mBridgeBTRootLayout.addView(mBridgeBTLayout, new FrameLayout.LayoutParams(-1, -1));
            } catch (Exception e4) {
                e = e4;
                if (oVar != null) {
                    oVar.a(str10, str8, str5, null, b(880008, new MBridgeIds(str3, str9, str8), "", e, campaignEx));
                }
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardCampaignsResourceManager", e.getLocalizedMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, WindVaneWebView windVaneWebView, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, com.mbridge.msdk.videocommon.setting.c cVar, String str, String str2, int i2) {
        if (windVaneWebView != null) {
            if (campaignEx != null && cVar != null && campaignEx.getRewardTemplateMode() != null && !TextUtils.isEmpty(str)) {
                if (TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("id", str2);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("result", 1);
                        jSONObject2.put("error", "data is null");
                        jSONObject.put("data", jSONObject2);
                        com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                        return;
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            p0.b("RewardCampaignsResourceManager", e2.getLocalizedMessage());
                            return;
                        }
                        return;
                    }
                }
                if (!TextUtils.isEmpty(campaignEx.getRewardTemplateMode().e()) && campaignEx.getRewardTemplateMode().e().contains(CampaignEx.KEY_IS_CMPT_ENTRY)) {
                    p0.a("RewardCampaignsResourceManager", "getTeamplateUrl contains cmpt=1");
                    return;
                } else {
                    new Handler(Looper.getMainLooper()).postDelayed(new e(z, windVaneWebView, campaignEx, copyOnWriteArrayList, str, cVar, str2), i2 * 1000);
                    return;
                }
            }
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("id", str2);
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("result", 2);
                jSONObject4.put("error", "data is null");
                jSONObject3.put("data", jSONObject4);
                com.mbridge.msdk.mbsignalcommon.windvane.f.a().a((WebView) windVaneWebView, "onSubPlayTemplateViewLoad", Base64.encodeToString(jSONObject3.toString().getBytes(), 2));
            } catch (Exception e3) {
                if (MBridgeConstans.DEBUG) {
                    p0.b("RewardCampaignsResourceManager", e3.getLocalizedMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, WindVaneWebView windVaneWebView, String str, int i2, CampaignEx campaignEx, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, String str2, String str3, com.mbridge.msdk.videocommon.setting.c cVar, String str4, boolean z2) {
        com.mbridge.msdk.video.signal.impl.k kVar;
        String str5;
        try {
            com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
            eVar.a("type", 2);
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000154", campaignEx, eVar);
            a.C0420a c0420a = new a.C0420a();
            WindVaneWebView windVaneWebView2 = new WindVaneWebView(com.mbridge.msdk.foundation.controller.c.m().d());
            if (campaignEx != null) {
                windVaneWebView2.setLocalRequestId(campaignEx.getCurrentLocalRid());
            }
            windVaneWebView2.setTempTypeForMetrics(2);
            c0420a.a(windVaneWebView2);
            String str6 = "";
            if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0) {
                CopyOnWriteArrayList<CampaignEx> b = com.mbridge.msdk.videocommon.download.b.getInstance().b(str3);
                if (b != null && b.size() > 0) {
                    for (int i3 = 0; i3 < copyOnWriteArrayList.size(); i3++) {
                        CampaignEx campaignEx2 = copyOnWriteArrayList.get(i3);
                        for (CampaignEx campaignEx3 : b) {
                            if (campaignEx3.getId().equals(campaignEx2.getId()) && campaignEx3.getRequestId().equals(campaignEx2.getRequestId())) {
                                campaignEx2.setReady(true);
                                copyOnWriteArrayList.set(i3, campaignEx2);
                            }
                        }
                    }
                }
                com.mbridge.msdk.video.signal.impl.k kVar2 = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx, copyOnWriteArrayList);
                str5 = copyOnWriteArrayList.get(0).getRequestId();
                kVar = kVar2;
            } else {
                com.mbridge.msdk.video.signal.impl.k kVar3 = new com.mbridge.msdk.video.signal.impl.k(null, campaignEx);
                if (campaignEx != null) {
                    str6 = campaignEx.getRequestId();
                }
                kVar = kVar3;
                str5 = str6;
            }
            kVar.g(i2);
            kVar.setUnitId(str3);
            kVar.c(str4);
            kVar.setRewardUnitSetting(cVar);
            kVar.d(z);
            windVaneWebView2.setWebViewListener(new q(str4, false, windVaneWebView, str, str3, c0420a, campaignEx, z2, str5));
            windVaneWebView2.setObject(kVar);
            windVaneWebView2.loadUrl(str2);
            windVaneWebView2.setRid(str5);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                p0.b("RewardCampaignsResourceManager", e2.getLocalizedMessage());
            }
        }
    }

    private int a(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 0;
        }
        try {
            if (campaignEx.getAabEntity() != null) {
                return campaignEx.getAabEntity().h3c;
            }
            return 0;
        } catch (Throwable th) {
            p0.b("RewardCampaignsResourceManager", th.getMessage());
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.mbridge.msdk.foundation.same.report.metrics.c a(CampaignEx campaignEx, int i2) {
        com.mbridge.msdk.foundation.same.report.metrics.c b = campaignEx != null ? com.mbridge.msdk.foundation.same.report.metrics.d.b().b(campaignEx.getCurrentLocalRid()) : null;
        if (b == null) {
            b = new com.mbridge.msdk.foundation.same.report.metrics.c();
        }
        b.a(campaignEx);
        b.f(a(campaignEx));
        b.e(i2);
        return b;
    }
}
