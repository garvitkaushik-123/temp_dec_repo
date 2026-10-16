package com.mbridge.msdk.splash.manager;

import android.content.Context;
import android.view.View;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;
import com.mbridge.msdk.dycreator.listener.DyCountDownListener;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.wrapper.DyAdType;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewCreator;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.util.List;

/* compiled from: NativeViewRenderManager.java */
/* loaded from: classes6.dex */
class c extends com.mbridge.msdk.splash.manager.a {

    /* compiled from: NativeViewRenderManager.java */
    class a implements DyCountDownListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DyOption f4731a;

        a(DyOption dyOption) {
            this.f4731a = dyOption;
        }

        @Override // com.mbridge.msdk.dycreator.listener.DyCountDownListener
        public void getCountDownValue(int i) {
            this.f4731a.setDyCountDownListener(i);
        }
    }

    /* compiled from: NativeViewRenderManager.java */
    class b implements DynamicViewBackListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.splash.inter.a f4732a;
        final /* synthetic */ MBSplashView b;
        final /* synthetic */ com.mbridge.msdk.splash.common.c c;
        final /* synthetic */ DyOption d;

        b(com.mbridge.msdk.splash.inter.a aVar, MBSplashView mBSplashView, com.mbridge.msdk.splash.common.c cVar, DyOption dyOption) {
            this.f4732a = aVar;
            this.b = mBSplashView;
            this.c = cVar;
            this.d = dyOption;
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener
        public void viewClicked(BaseRespData baseRespData) {
            com.mbridge.msdk.splash.signal.b splashSignalCommunicationImpl;
            MBSplashView mBSplashView = this.b;
            com.mbridge.msdk.splash.middle.a a2 = (mBSplashView == null || (splashSignalCommunicationImpl = mBSplashView.getSplashSignalCommunicationImpl()) == null) ? null : splashSignalCommunicationImpl.a();
            DyOption dyOption = this.d;
            CampaignEx campaignEx = dyOption != null ? dyOption.getCampaignEx() : null;
            boolean z = baseRespData instanceof SplashResData;
            EAction eAction = z ? ((SplashResData) baseRespData).geteAction() : null;
            if (eAction != null) {
                int i = C0390c.f4733a[eAction.ordinal()];
                if (i == 1) {
                    if (a2 != null) {
                        if (baseRespData == null) {
                            a2.a(campaignEx);
                            return;
                        } else {
                            if (z) {
                                SplashResData splashResData = (SplashResData) baseRespData;
                                if (splashResData.getBaseViewData() != null) {
                                    c.this.a(splashResData.getBaseViewData(), a2, campaignEx);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (i == 2) {
                    if (a2 != null) {
                        a2.close();
                    }
                } else if (i == 3) {
                    if (this.d != null) {
                        com.mbridge.msdk.click.c.e(com.mbridge.msdk.foundation.controller.c.m().d(), this.d.getAdChoiceLink());
                    }
                } else if (i == 4 && baseRespData != null && z) {
                    SplashResData splashResData2 = (SplashResData) baseRespData;
                    if (splashResData2.getBaseViewData() != null) {
                        c.this.a(a2, campaignEx, splashResData2.getBaseViewData());
                    }
                }
            }
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener
        public void viewCreateFail(com.mbridge.msdk.dycreator.error.a aVar) {
            MBSplashView mBSplashView = this.b;
            if (mBSplashView != null) {
                Context context = mBSplashView.getContext();
                if (context == null) {
                    context = com.mbridge.msdk.foundation.controller.c.m().d();
                }
                c.this.a(context, this.b, this.c, this.f4732a);
            }
        }

        @Override // com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener
        public void viewCreatedSuccess(View view) {
            com.mbridge.msdk.splash.inter.a aVar = this.f4732a;
            if (aVar != null) {
                if (view != null) {
                    aVar.a(view);
                } else {
                    aVar.onError("View render error.");
                }
            }
        }
    }

    /* compiled from: NativeViewRenderManager.java */
    /* renamed from: com.mbridge.msdk.splash.manager.c$c, reason: collision with other inner class name */
    static /* synthetic */ class C0390c {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f4733a;

        static {
            int[] iArr = new int[EAction.values().length];
            f4733a = iArr;
            try {
                iArr[EAction.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4733a[EAction.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4733a[EAction.NOTICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4733a[EAction.FEEDBACK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: NativeViewRenderManager.java */
    static class d {

        /* renamed from: a, reason: collision with root package name */
        private static final c f4734a = new c(null);
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    public static c a() {
        return d.f4734a;
    }

    private c() {
    }

    @Override // com.mbridge.msdk.splash.manager.a
    protected void a(List<String> list, MBSplashView mBSplashView, com.mbridge.msdk.splash.common.c cVar, com.mbridge.msdk.splash.inter.a aVar) {
        h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        DyOption build = new DyOption.Builder().campaignEx(cVar.b()).fileDirs(list).dyAdType(DyAdType.SPLASH).canSkip(cVar.m()).isScreenClick(cVar.f() == 1).isClickButtonVisible(cVar.c() == 0).isShakeVisible(cVar.i() == 1).isApkInfoVisible(cVar.a() == 0).isLogoVisible(cVar.e() == 1).shakeStrenght(cVar.j()).shakeTime(cVar.k()).orientation(cVar.g()).countDownTime(cVar.d()).adChoiceLink(u0.a(cVar.b())).build();
        mBSplashView.setDyCountDownListener(new a(build));
        DynamicViewCreator.getInstance().createDynamicView(build, new b(aVar, mBSplashView, cVar, build));
    }
}
