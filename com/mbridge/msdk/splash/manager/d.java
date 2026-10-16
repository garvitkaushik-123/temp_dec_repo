package com.mbridge.msdk.splash.manager;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.splash.manager.g;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ResManager.java */
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static int f4735a = 1;
    public static com.mbridge.msdk.foundation.db.e b = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));

    /* compiled from: ResManager.java */
    class a implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MBSplashView f4736a;

        a(MBSplashView mBSplashView) {
            this.f4736a = mBSplashView;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            this.f4736a.setVideoReady(true);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            this.f4736a.setVideoReady(false);
        }
    }

    /* compiled from: ResManager.java */
    class b implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.splash.view.nativeview.a f4737a;
        final /* synthetic */ MBSplashView b;

        b(com.mbridge.msdk.splash.view.nativeview.a aVar, MBSplashView mBSplashView) {
            this.f4737a = aVar;
            this.b = mBSplashView;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            com.mbridge.msdk.splash.view.nativeview.a aVar = this.f4737a;
            if (aVar != null) {
                aVar.b();
            }
            MBSplashView mBSplashView = this.b;
            if (mBSplashView != null) {
                mBSplashView.setImageReady(false);
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            com.mbridge.msdk.splash.view.nativeview.a aVar = this.f4737a;
            if (aVar != null) {
                aVar.a();
            }
            MBSplashView mBSplashView = this.b;
            if (mBSplashView != null) {
                mBSplashView.setImageReady(true);
            }
        }
    }

    /* compiled from: ResManager.java */
    class c implements com.mbridge.msdk.foundation.same.image.c {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
        }
    }

    public static CampaignEx a(MBSplashView mBSplashView, String str, String str2, String str3, boolean z, int i, boolean z2, boolean z3) {
        if (b == null) {
            b = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        com.mbridge.msdk.setting.g d = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d == null) {
            d = h.b().a();
        }
        long Z = d.Z() * 1000;
        long a0 = d.a0() * 1000;
        a(a0, str2);
        List<CampaignEx> a2 = b.a(str2, 0, 0, f4735a, !TextUtils.isEmpty(str3));
        if (a2 != null && a2.size() > 0) {
            CampaignEx campaignEx = a2.get(0);
            if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = currentTimeMillis - Z;
            if (z2) {
                if ((campaignEx.getPlct() <= 0 || (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() < currentTimeMillis) && (campaignEx.getPlct() > 0 || campaignEx.getTimestamp() < j)) {
                    if (a(mBSplashView, campaignEx, str, str2, z, i, z3) && campaignEx.isSpareOffer(Z, a0)) {
                        return a(campaignEx);
                    }
                } else if (a(mBSplashView, campaignEx, str, str2, z, i, z3)) {
                    return a(campaignEx);
                }
            } else if (((campaignEx.getPlct() > 0 && (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() >= currentTimeMillis) || (campaignEx.getPlct() <= 0 && campaignEx.getTimestamp() >= j)) && a(mBSplashView, campaignEx, str, str2, z, i, z3)) {
                return a(campaignEx);
            }
        }
        return null;
    }

    public static void b(String str) {
        if (b == null) {
            b = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        b.a(str, 0, f4735a);
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

    public static boolean a(MBSplashView mBSplashView, CampaignEx campaignEx, String str, String str2, boolean z, int i, boolean z2) {
        boolean z3;
        if (campaignEx != null) {
            mBSplashView.clearResState();
            if (TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                z3 = true;
            } else {
                boolean z4 = mBSplashView.isVideoReady() || com.mbridge.msdk.videocommon.download.b.getInstance().b(297, str2, campaignEx.isBidCampaign());
                if (!z4) {
                    a(mBSplashView, campaignEx, str2);
                } else {
                    mBSplashView.setVideoReady(true);
                }
                z3 = z4;
            }
            if (!TextUtils.isEmpty(campaignEx.getAdZip()) && !mBSplashView.isH5Ready()) {
                String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip());
                if (TextUtils.isEmpty(h5ResAddress)) {
                    z3 = false;
                } else if (!z2) {
                    a(mBSplashView, h5ResAddress, campaignEx, str, str2, z, i);
                }
            }
            if (TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml()) && !mBSplashView.isH5Ready()) {
                String a2 = a(campaignEx.getAdHtml());
                if (TextUtils.isEmpty(a2)) {
                    z3 = false;
                } else if (!z2) {
                    a(mBSplashView, a2, campaignEx, str, str2, z, i);
                }
            }
            if (!campaignEx.isDynamicView()) {
                return z3;
            }
            if (!TextUtils.isEmpty(campaignEx.getImageUrl()) && !mBSplashView.isImageReady()) {
                if (!com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).c(campaignEx.getImageUrl())) {
                    a(mBSplashView, campaignEx, (com.mbridge.msdk.splash.view.nativeview.a) null);
                    return z3;
                }
                mBSplashView.setImageReady(true);
                return true;
            }
        }
        return false;
    }

    private static void a(MBSplashView mBSplashView, CampaignEx campaignEx, String str) {
        a aVar = new a(mBSplashView);
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(com.mbridge.msdk.foundation.controller.c.m().d(), str, copyOnWriteArrayList, 297, aVar);
        if (!com.mbridge.msdk.videocommon.download.b.getInstance().b(297, str, campaignEx.isBidCampaign())) {
            com.mbridge.msdk.videocommon.download.b.getInstance().load(str);
        } else {
            mBSplashView.setVideoReady(true);
        }
    }

    public static void a(MBSplashView mBSplashView, CampaignEx campaignEx, com.mbridge.msdk.splash.view.nativeview.a aVar) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getImageUrl(), new b(aVar, mBSplashView));
        if (TextUtils.isEmpty(campaignEx.getIconUrl())) {
            return;
        }
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getIconUrl(), new c());
    }

    private static void a(MBSplashView mBSplashView, String str, CampaignEx campaignEx, String str2, String str3, boolean z, int i) {
        g.d dVar = new g.d();
        dVar.c(str3);
        dVar.b(str2);
        dVar.a(campaignEx);
        dVar.a(str);
        dVar.a(z);
        dVar.a(i);
        g.a().a(mBSplashView, dVar, null);
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

    public static boolean a(MBSplashView mBSplashView, CampaignEx campaignEx) {
        if (mBSplashView == null) {
            return false;
        }
        boolean isVideoReady = !TextUtils.isEmpty(campaignEx.getVideoUrlEncode()) ? mBSplashView.isVideoReady() : true;
        if (isVideoReady && !TextUtils.isEmpty(campaignEx.getAdZip())) {
            isVideoReady = mBSplashView.isH5Ready();
        }
        if (isVideoReady && TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            isVideoReady = mBSplashView.isH5Ready();
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            isVideoReady = false;
        }
        if (!campaignEx.isDynamicView()) {
            return isVideoReady;
        }
        if (TextUtils.isEmpty(campaignEx.getImageUrl())) {
            return false;
        }
        return mBSplashView.isImageReady();
    }

    public static void a(CampaignEx campaignEx, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        if (b == null) {
            b = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        b.a(arrayList, str);
    }

    public static void a(long j, String str) {
        if (b == null) {
            b = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        b.a(j, str);
    }
}
