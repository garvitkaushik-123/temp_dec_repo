package com.mbridge.msdk.video.module.listener.impl;

import android.os.Handler;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.r0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.video.module.MBridgeContainerView;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: VideoViewDefaultListener.java */
/* loaded from: classes6.dex */
public class m extends o {
    private Timer A;
    private Handler B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private int G;
    private MBridgeVideoView.u H;
    private MBridgeVideoView x;
    private MBridgeContainerView y;
    private int z;

    /* compiled from: VideoViewDefaultListener.java */
    class a extends TimerTask {

        /* compiled from: VideoViewDefaultListener.java */
        /* renamed from: com.mbridge.msdk.video.module.listener.impl.m$a$a, reason: collision with other inner class name */
        class RunnableC0417a implements Runnable {
            RunnableC0417a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                m.this.y.showVideoClickView(-1);
                m.this.x.soundOperate(0, 2);
            }
        }

        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                m.this.B.post(new RunnableC0417a());
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }

    public m(MBridgeVideoView mBridgeVideoView, MBridgeContainerView mBridgeContainerView, CampaignEx campaignEx, com.mbridge.msdk.videocommon.entity.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, int i, int i2, com.mbridge.msdk.video.module.listener.a aVar2, int i3, boolean z, int i4) {
        super(campaignEx, cVar, aVar, str, str2, aVar2, i3, z);
        this.B = new Handler();
        this.C = false;
        this.D = false;
        this.E = false;
        this.x = mBridgeVideoView;
        this.y = mBridgeContainerView;
        this.G = i;
        this.z = i2;
        this.F = i4;
        if (mBridgeVideoView != null) {
            this.C = mBridgeVideoView.getVideoSkipTime() == 0;
        }
        if (mBridgeVideoView == null || mBridgeContainerView == null) {
            this.f5152a = false;
        }
    }

    private void n() {
        try {
            Timer timer = this.A;
            if (timer != null) {
                timer.cancel();
                this.A = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void o() {
        CampaignEx campaignEx;
        CampaignEx campaignEx2 = this.b;
        if (campaignEx2 == null || campaignEx2.getDynamicTempCode() != 5) {
            return;
        }
        MBridgeVideoView mBridgeVideoView = this.x;
        if (mBridgeVideoView != null && mBridgeVideoView.mCampOrderViewData != null) {
            int i = 0;
            int i2 = 0;
            while (true) {
                if (i2 < this.x.mCampOrderViewData.size()) {
                    if (this.x.mCampOrderViewData.get(i2) != null && this.x.mCampOrderViewData.get(i2).getId() == this.b.getId()) {
                        i = i2 - 1;
                        break;
                    }
                    i2++;
                } else {
                    break;
                }
            }
            if (i >= 0 && this.x.mCampOrderViewData.get(i) != null) {
                campaignEx = this.x.mCampOrderViewData.get(i);
                if (campaignEx == null) {
                    MBridgeVideoView mBridgeVideoView2 = this.x;
                    if (mBridgeVideoView2 != null) {
                        mBridgeVideoView2.setCampaign(campaignEx);
                    }
                    MBridgeContainerView mBridgeContainerView = this.y;
                    if (mBridgeContainerView != null) {
                        mBridgeContainerView.setCampaign(campaignEx);
                    }
                    a(campaignEx);
                    return;
                }
                return;
            }
        }
        campaignEx = null;
        if (campaignEx == null) {
        }
    }

    private void p() {
        try {
            n();
            this.A = new Timer();
            this.A.schedule(new a(), 3000L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.o, com.mbridge.msdk.video.module.listener.impl.k, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i, Object obj) {
        int i2;
        String str;
        int i3;
        if (this.f5152a) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 5) {
                        if (i != 6) {
                            if (i == 8) {
                                MBridgeContainerView mBridgeContainerView = this.y;
                                if (mBridgeContainerView == null) {
                                    MBridgeVideoView mBridgeVideoView = this.x;
                                    if (mBridgeVideoView != null) {
                                        mBridgeVideoView.showAlertView();
                                    }
                                } else if (mBridgeContainerView.showAlertWebView()) {
                                    MBridgeVideoView mBridgeVideoView2 = this.x;
                                    if (mBridgeVideoView2 != null) {
                                        mBridgeVideoView2.alertWebViewShowed();
                                    }
                                } else {
                                    MBridgeVideoView mBridgeVideoView3 = this.x;
                                    if (mBridgeVideoView3 != null) {
                                        mBridgeVideoView3.showAlertView();
                                    }
                                }
                            } else if (i != 20) {
                                switch (i) {
                                    case 10:
                                        this.D = true;
                                        this.x.soundOperate(0, 2);
                                        this.x.progressOperate(0, 2);
                                        break;
                                    case 11:
                                        this.x.videoOperate(3);
                                        this.x.dismissAllAlert();
                                        CampaignEx campaignEx = this.b;
                                        if (campaignEx == null || campaignEx.getVideo_end_type() == 3 || this.b.getRewardTemplateMode() == null || this.b.getRewardTemplateMode().f() == 5002010) {
                                            this.x.setVisibility(0);
                                        } else if (this.b.getAdSpaceT() != 2) {
                                            this.x.setVisibility(8);
                                        }
                                        CampaignEx campaignEx2 = this.b;
                                        if (campaignEx2 != null && campaignEx2.getDynamicTempCode() == 5) {
                                            MBridgeVideoView mBridgeVideoView4 = this.x;
                                            if (mBridgeVideoView4.mCurrPlayNum == mBridgeVideoView4.mCampaignSize) {
                                                MBridgeContainerView mBridgeContainerView2 = this.y;
                                                if (mBridgeContainerView2 != null) {
                                                    mBridgeContainerView2.setRewardStatus(true);
                                                    this.y.showOrderCampView();
                                                    break;
                                                }
                                            }
                                        }
                                        CampaignEx campaignEx3 = this.b;
                                        if (campaignEx3 == null || campaignEx3.getRewardTemplateMode() == null || this.b.getRewardTemplateMode().f() != 5002010) {
                                            if (this.b.getAdSpaceT() != 2) {
                                                this.y.showEndcard(this.b.getVideo_end_type());
                                                break;
                                            } else {
                                                this.y.showVideoEndCover();
                                                break;
                                            }
                                        }
                                        break;
                                    case 12:
                                        k();
                                        this.x.videoOperate(3);
                                        this.x.dismissAllAlert();
                                        if (this.b.getVideo_end_type() != 3) {
                                            this.x.setVisibility(8);
                                        } else {
                                            this.x.setVisibility(0);
                                        }
                                        if (this.D || this.F != 0) {
                                            if (this.b.isDynamicView() && this.b.getDynamicTempCode() == 5 && TextUtils.isEmpty(this.b.getendcard_url())) {
                                                o();
                                                this.F = 0;
                                            }
                                            if (!this.D && this.F == 1) {
                                                j();
                                                h();
                                                i();
                                                if (r0.a().a("i_l_s_t_r_i", false) && !this.E) {
                                                    this.E = true;
                                                    MBridgeVideoView.u uVar = this.H;
                                                    if (uVar != null) {
                                                        uVar.a();
                                                    }
                                                }
                                            }
                                            if (this.b.getAdSpaceT() == 2) {
                                                this.y.showVideoEndCover();
                                                break;
                                            } else {
                                                this.y.showEndcard(this.b.getVideo_end_type());
                                                break;
                                            }
                                        }
                                        break;
                                    case 13:
                                        MBridgeVideoView mBridgeVideoView5 = this.x;
                                        if (mBridgeVideoView5 != null) {
                                            mBridgeVideoView5.closeVideoOperate(0, 2);
                                            str = this.x.getPlayURL();
                                            i2 = this.x.getBufferTimeout();
                                        } else {
                                            i2 = -1;
                                            str = "";
                                        }
                                        CampaignEx campaignEx4 = this.b;
                                        String videoUrlEncode = campaignEx4 != null ? campaignEx4.getVideoUrlEncode() : "";
                                        com.mbridge.msdk.foundation.same.report.metrics.e eVar = new com.mbridge.msdk.foundation.same.report.metrics.e();
                                        eVar.a("play_url", str);
                                        eVar.a("video_url", videoUrlEncode);
                                        eVar.a("timeout", Integer.valueOf(i2));
                                        com.mbridge.msdk.foundation.same.report.metrics.d.b().a("m_video_buffer_timeout", this.b, eVar);
                                        break;
                                    case 14:
                                        if (!this.C) {
                                            this.x.closeVideoOperate(0, 1);
                                            break;
                                        }
                                        break;
                                    case 15:
                                        if (obj != null && (obj instanceof MBridgeVideoView.v)) {
                                            MBridgeVideoView.v vVar = (MBridgeVideoView.v) obj;
                                            int videoInteractiveType = this.y.getVideoInteractiveType();
                                            if (this.b.getAdSpaceT() == 2) {
                                                SoundImageView soundImageView = this.x.mSoundImageView;
                                                if (soundImageView != null && (soundImageView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                                                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.x.mSoundImageView.getLayoutParams();
                                                    layoutParams.setMargins(u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 5.0f), 0, 0, u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 85.0f));
                                                    this.x.mSoundImageView.setLayoutParams(layoutParams);
                                                }
                                                TextView textView = this.x.tvFlag;
                                                if (textView != null && (textView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
                                                    FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.x.tvFlag.getLayoutParams();
                                                    layoutParams2.setMargins(u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 5.0f), 0, 0, u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 85.0f));
                                                    this.x.tvFlag.setVisibility(0);
                                                    this.x.tvFlag.setLayoutParams(layoutParams2);
                                                }
                                                this.y.showVideoClickView(1);
                                            } else if (videoInteractiveType >= 0 && vVar.f5146a >= videoInteractiveType) {
                                                this.y.showVideoClickView(1);
                                                this.x.soundOperate(0, 1);
                                            }
                                            this.C = vVar.c;
                                            if (this.b.getDynamicTempCode() != 5) {
                                                int i4 = this.z;
                                                if (((i4 >= 0 && ((i3 = vVar.f5146a) >= i4 || i3 == vVar.b)) || (this.b.getVideoCompleteTime() > 0 && (vVar.f5146a > this.b.getVideoCompleteTime() || vVar.f5146a == vVar.b))) && !this.C) {
                                                    this.x.closeVideoOperate(0, 2);
                                                    this.C = true;
                                                    break;
                                                }
                                            } else {
                                                a(vVar.f5146a, vVar.b);
                                                break;
                                            }
                                        }
                                        break;
                                }
                            } else if (r0.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.u)) {
                                this.H = (MBridgeVideoView.u) obj;
                            }
                        }
                    } else if (obj != null && (obj instanceof Integer)) {
                        this.x.soundOperate((((Integer) obj).intValue() == 1 ? 2 : 1).intValue(), -1);
                    }
                }
                this.x.dismissAllAlert();
                this.x.videoOperate(3);
                CampaignEx campaignEx5 = this.b;
                if (campaignEx5 != null && campaignEx5.isDynamicView() && this.b.getDynamicTempCode() == 5) {
                    if (this.y != null) {
                        MBridgeVideoView mBridgeVideoView6 = this.x;
                        if (mBridgeVideoView6.mCurrPlayNum == mBridgeVideoView6.mCampaignSize) {
                            if (this.b.getAdSpaceT() != 2) {
                                this.y.setRewardStatus(true);
                                this.y.showOrderCampView();
                            }
                            i = 16;
                        }
                    }
                    com.mbridge.msdk.video.bt.module.orglistener.f.a(this.b, this.g, this.x.mCurrentPlayProgressTime);
                }
                if (this.G == 2 && !this.y.endCardShowing() && this.b.getAdSpaceT() != 2) {
                    this.y.showEndcard(this.b.getVideo_end_type());
                }
                i = 16;
            } else if (!this.y.endCardShowing()) {
                int videoInteractiveType2 = this.y.getVideoInteractiveType();
                if (videoInteractiveType2 != -2) {
                    if (videoInteractiveType2 == -1) {
                        if (this.y.isLast()) {
                            this.y.showVideoClickView(1);
                            this.x.soundOperate(0, 1);
                            p();
                        } else {
                            this.y.showVideoClickView(-1);
                            this.x.soundOperate(0, 2);
                            n();
                        }
                    }
                } else if (this.y.miniCardLoaded()) {
                    this.y.showVideoClickView(2);
                }
            }
        }
        super.a(i, obj);
    }

    private void a(int i, int i2) {
        CampaignEx campaignEx;
        if (this.C || this.x == null || (campaignEx = this.b) == null) {
            return;
        }
        int i3 = this.z;
        int i4 = (i3 < 0 || i < i3) ? 1 : 2;
        if (i4 != 2 && (campaignEx.getVideoCompleteTime() != 0 ? i > this.b.getVideoCompleteTime() : this.x.mCurrPlayNum > 1)) {
            i4 = 2;
        }
        if (i4 != 2 && this.x.mCurrPlayNum > 1 && i == i2) {
            i4 = 2;
        }
        if (i4 == 2) {
            this.x.closeVideoOperate(0, i4);
            this.C = true;
        }
    }
}
