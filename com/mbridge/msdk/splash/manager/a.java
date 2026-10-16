package com.mbridge.msdk.splash.manager;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.y;
import com.mbridge.msdk.splash.view.MBSplashNativeView;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseNativeViewRenderManager.java */
/* loaded from: classes6.dex */
public class a {

    /* compiled from: BaseNativeViewRenderManager.java */
    /* renamed from: com.mbridge.msdk.splash.manager.a$a, reason: collision with other inner class name */
    class C0388a implements com.mbridge.msdk.foundation.feedback.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.splash.middle.a f4720a;
        final /* synthetic */ int b;

        C0388a(com.mbridge.msdk.splash.middle.a aVar, int i) {
            this.f4720a = aVar;
            this.b = i;
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            this.f4720a.a(2, this.b);
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            this.f4720a.a(2, this.b);
        }
    }

    public void a(MBSplashView mBSplashView, com.mbridge.msdk.splash.common.c cVar, com.mbridge.msdk.splash.inter.a aVar) {
        Context context = mBSplashView.getContext();
        if (context == null) {
            context = com.mbridge.msdk.foundation.controller.c.m().d();
        }
        if (cVar == null && aVar != null) {
            aVar.onError("The render parameters is unavailable.");
            return;
        }
        String a2 = (cVar == null || cVar.b() == null) ? "" : y.a(cVar.b().getAdZip());
        if (TextUtils.isEmpty(a2)) {
            a(context, mBSplashView, cVar, aVar);
            return;
        }
        if (cVar == null || cVar.b() == null) {
            return;
        }
        if (TextUtils.isEmpty(cVar.b().getAdZip())) {
            a(context, mBSplashView, cVar, aVar);
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a2);
            a(arrayList, mBSplashView, cVar, aVar);
        } catch (Exception unused) {
            a(context, mBSplashView, cVar, aVar);
        }
    }

    protected void a(List<String> list, MBSplashView mBSplashView, com.mbridge.msdk.splash.common.c cVar, com.mbridge.msdk.splash.inter.a aVar) {
        throw null;
    }

    protected void a(com.mbridge.msdk.splash.middle.a aVar, CampaignEx campaignEx, com.mbridge.msdk.dycreator.viewdata.base.a aVar2) {
        if (campaignEx != null) {
            String campaignUnitId = campaignEx.getCampaignUnitId();
            String requestId = campaignEx.getRequestId();
            int currentCountDown = aVar2 != null ? aVar2.getEffectData().getCurrentCountDown() : 0;
            aVar.a(1, currentCountDown);
            com.mbridge.msdk.foundation.feedback.bean.a b = com.mbridge.msdk.foundation.feedback.b.b().b(campaignUnitId + "_" + requestId);
            if (b != null) {
                b.a(campaignEx);
                com.mbridge.msdk.foundation.feedback.b.b().a(campaignUnitId + "_" + requestId, new C0388a(aVar, currentCountDown));
                b.p();
            }
        }
    }

    protected void a(com.mbridge.msdk.dycreator.viewdata.base.a aVar, com.mbridge.msdk.splash.middle.a aVar2, CampaignEx campaignEx) {
        float f;
        int i;
        float f2;
        if (aVar == null || !(aVar instanceof MBSplashData)) {
            f = 0.0f;
            i = 0;
            f2 = 0.0f;
        } else {
            MBSplashData mBSplashData = (MBSplashData) aVar;
            f = mBSplashData.getxInScreen();
            f2 = mBSplashData.getyInScreen();
            i = mBSplashData.getClickType();
        }
        if (aVar2 != null) {
            try {
                aVar2.a(com.mbridge.msdk.splash.common.util.a.a(com.mbridge.msdk.splash.common.util.a.a(i, f, f2), campaignEx));
            } catch (Throwable th) {
                th.printStackTrace();
                aVar2.a(campaignEx);
            }
        }
    }

    protected void a(Context context, MBSplashView mBSplashView, com.mbridge.msdk.splash.common.c cVar, com.mbridge.msdk.splash.inter.a aVar) {
        try {
            MBSplashNativeView mBSplashNativeView = new MBSplashNativeView(context, mBSplashView, cVar);
            if (aVar != null) {
                aVar.a(mBSplashNativeView);
            }
        } catch (Throwable unused) {
            if (aVar != null) {
                aVar.onError("View render error.");
            }
        }
    }
}
