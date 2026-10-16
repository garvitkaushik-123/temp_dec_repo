package com.bytedance.sdk.openadsdk.core.wC;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import com.bytedance.sdk.openadsdk.utils.dZ;

/* loaded from: classes3.dex */
public class QX extends Xb implements Os.InterfaceC0109Os, Os.aGH {
    private com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA Cp;
    int DbA;
    private long GB;
    boolean MGA;
    boolean Os;
    private com.bytedance.sdk.openadsdk.multipro.DbA.eli VM;
    boolean aGH;
    private aqO eli;
    boolean kb;
    private boolean nro;
    private long oWW;
    private com.bytedance.sdk.openadsdk.eli.DbA.Os qj;
    int ui;
    int wC;

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void DbA() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void MGA() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli() {
    }

    public QX(Context context, com.bytedance.sdk.openadsdk.core.model.ev evVar, AdSlot adSlot, String str, boolean z) {
        super(context, evVar, adSlot, str, false, true);
        this.DbA = 1;
        this.Os = false;
        this.aGH = true;
        this.MGA = true;
        this.kb = true;
        this.wC = -1;
        this.nro = z;
        nn();
    }

    public boolean NU() {
        return this.nro;
    }

    protected void nn() {
        this.NU = new FrameLayout(this.FC);
        int RTg = this.nlS != null ? this.nlS.RTg() : 0;
        this.ui = RTg;
        aGH(RTg);
        gG();
        addView(this.NU, new FrameLayout.LayoutParams(-1, -1));
        if (getWebView() != null) {
            getWebView().setBackgroundColor(0);
        }
        setVideoFrameChangeListener(new com.bytedance.sdk.openadsdk.nlS.kb() { // from class: com.bytedance.sdk.openadsdk.core.wC.QX.1
            @Override // com.bytedance.sdk.openadsdk.nlS.kb
            public void eli(final com.bytedance.sdk.component.adexpress.DbA.nn nnVar) {
                cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.QX.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QX.this.eli(nnVar, true);
                    }
                });
            }
        });
    }

    private void gG() {
        try {
            this.VM = new com.bytedance.sdk.openadsdk.multipro.DbA.eli();
            aqO aqo = new aqO(this.FC, this.nlS, this.aAs, this.gG, this.nro);
            this.eli = aqo;
            aqo.setShouldCheckNetChange(false);
            this.eli.setControllerStatusCallBack(new MGA.DbA() { // from class: com.bytedance.sdk.openadsdk.core.wC.QX.2
                @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.DbA
                public void eli(boolean z, long j, long j2, long j3, boolean z2) {
                    QX.this.VM.eli = z;
                    QX.this.VM.ui = j;
                    QX.this.VM.MGA = j2;
                    QX.this.VM.kb = j3;
                    QX.this.VM.aGH = z2;
                }
            });
            this.eli.setVideoAdLoadListener(this);
            this.eli.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.aAs)) {
                this.eli.setIsAutoPlay(this.Os ? this.du.isAutoPlay() : this.aGH);
            } else if ("open_ad".equals(this.aAs)) {
                this.eli.setIsAutoPlay(true);
            } else {
                this.eli.setIsAutoPlay(this.aGH);
            }
            if ("open_ad".equals(this.aAs)) {
                this.eli.eli(true, "initVideo");
            } else {
                this.CMM = com.bytedance.sdk.openadsdk.core.dV.aGH().DbA(String.valueOf(this.ui));
                this.eli.eli(this.CMM, "initVideo");
            }
            this.eli.aGH();
        } catch (Exception unused) {
            this.eli = null;
        }
    }

    void aGH(int i) {
        int DbA = com.bytedance.sdk.openadsdk.core.dV.aGH().DbA(i);
        if (3 == DbA) {
            this.Os = false;
            this.aGH = false;
        } else if (4 == DbA) {
            this.Os = true;
        } else {
            int Os = com.bytedance.sdk.component.utils.nGm.Os(com.bytedance.sdk.openadsdk.core.dV.eli());
            if (1 == DbA) {
                this.Os = false;
                this.aGH = dZ.aGH(Os);
            } else if (2 == DbA) {
                if (dZ.ui(Os) || dZ.aGH(Os) || dZ.MGA(Os)) {
                    this.Os = false;
                    this.aGH = true;
                }
            } else if (5 == DbA && (dZ.aGH(Os) || dZ.MGA(Os))) {
                this.Os = false;
                this.aGH = true;
            }
        }
        if (this.aGH) {
            return;
        }
        this.DbA = 3;
    }

    public com.bytedance.sdk.openadsdk.multipro.DbA.eli getVideoModel() {
        return this.VM;
    }

    private void setShowAdInteractionView(boolean z) {
        aqO aqo = this.eli;
        if (aqo != null) {
            aqo.setShowAdInteractionView(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.component.adexpress.DbA.Dfc
    public void eli(com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh, com.bytedance.sdk.component.adexpress.DbA.nn nnVar) {
        this.KM = agh;
        this.wC = agh.Os();
        if ((this.KM instanceof Vy) && ((Vy) this.KM).aqO() != null) {
            ((Vy) this.KM).aqO().eli((Dfc) this);
        }
        if (nnVar != null && nnVar.DbA()) {
            eli(nnVar);
        }
        super.eli(agh, nnVar);
    }

    private void eli(final com.bytedance.sdk.component.adexpress.DbA.nn nnVar) {
        if (nnVar == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.QX.3
            @Override // java.lang.Runnable
            public void run() {
                QX.this.Os(nnVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eli(com.bytedance.sdk.component.adexpress.DbA.nn nnVar, boolean z) {
        int i;
        double ui = nnVar.ui();
        double MGA = nnVar.MGA();
        double kb = nnVar.kb();
        double wC = nnVar.wC();
        if ((kb == 0.0d || wC == 0.0d) && (i = this.wC) != 7 && i != 10 && i != 9) {
            return false;
        }
        int DbA = SSo.DbA(this.FC, (float) ui);
        int DbA2 = SSo.DbA(this.FC, (float) MGA);
        int DbA3 = SSo.DbA(this.FC, (float) kb);
        int DbA4 = SSo.DbA(this.FC, (float) wC);
        float min = Math.min(Math.min(SSo.DbA(this.FC, nnVar.du()), SSo.DbA(this.FC, nnVar.nlS())), Math.min(SSo.DbA(this.FC, nnVar.NU()), SSo.DbA(this.FC, nnVar.nn())));
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.NU.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(DbA3, DbA4);
        }
        layoutParams.width = DbA3;
        layoutParams.height = DbA4;
        layoutParams.topMargin = DbA2;
        layoutParams.leftMargin = DbA;
        layoutParams.setMarginStart(layoutParams.leftMargin);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        this.NU.setLayoutParams(layoutParams);
        SSo.DbA(this.NU, min);
        aqO aqo = this.eli;
        if (aqo == null || !z) {
            return true;
        }
        aqo.eli(DbA3, DbA4);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os(com.bytedance.sdk.component.adexpress.DbA.nn nnVar) {
        if (eli(nnVar, false)) {
            this.NU.removeAllViews();
            if (this.eli != null) {
                int i = this.wC;
                if ((i == 7 || i == 10) && (nnVar instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.DbA)) {
                    FrameLayout Dfc = ((com.bytedance.sdk.openadsdk.core.aAs.MGA.DbA) nnVar).Dfc();
                    if (Dfc != null) {
                        Dfc.removeAllViews();
                        if (this.wC == 10) {
                            this.eli.setClickable(false);
                        }
                        Dfc.addView(this.eli, new FrameLayout.LayoutParams(-1, -1));
                    }
                } else if (nnVar.eli() != null) {
                    if (this.kb) {
                        nnVar.eli().setTag(com.bytedance.sdk.component.adexpress.dynamic.eli.MGA, 1);
                        ((FrameLayout) nnVar.eli()).removeAllViews();
                        ((FrameLayout) nnVar.eli()).addView(this.eli, new FrameLayout.LayoutParams(-1, -1));
                        this.kb = false;
                    }
                } else {
                    this.NU.addView(this.eli);
                }
                this.eli.eli(0L, true, false);
                aGH(this.ui);
                if (!com.bytedance.sdk.component.utils.nGm.aGH(this.FC) && !this.aGH && this.MGA) {
                    this.eli.ui();
                }
                if (TextUtils.equals("embeded_ad", this.aAs)) {
                    return;
                }
                setShowAdInteractionView(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli(boolean z, String str) {
        aqO aqo;
        new Object[]{"onMuteVideo,mute:", Boolean.valueOf(z), str};
        if (this.nlS.FtK() || (aqo = this.eli) == null) {
            return;
        }
        aqo.eli(z, str);
        setSoundMute(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli(int i) {
        aqO aqo = this.eli;
        if (aqo == null) {
            return;
        }
        if (i == 1) {
            aqo.eli(0L, true, false);
            return;
        }
        if (i == 2 || i == 3) {
            aqo.setCanInterruptVideoPlay(true);
            this.eli.performClick();
        } else if (i == 4) {
            aqo.getNativeVideoController().ui();
        } else {
            if (i != 5) {
                return;
            }
            aqo.eli(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.component.adexpress.DbA.wC
    public void eli(View view, int i, com.bytedance.sdk.component.adexpress.Os os) {
        if (i == -1 || os == null) {
            return;
        }
        if (i == 11) {
            try {
                aqO aqo = this.eli;
                if (aqo != null) {
                    aqo.setCanInterruptVideoPlay(true);
                    this.eli.performClick();
                    if (this.nn) {
                        this.eli.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.XlF).setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            } catch (Exception unused) {
                return;
            }
        }
        super.eli(view, i, os);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public long Os() {
        return this.GB;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public long aGH() {
        return this.GB;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public int ui() {
        aqO aqo;
        if (this.DbA == 3 && (aqo = this.eli) != null) {
            aqo.aGH();
        }
        aqO aqo2 = this.eli;
        if (aqo2 != null && aqo2.getNativeVideoController().nn()) {
            this.DbA = 1;
        }
        kb(this.DbA);
        return this.DbA;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void g_() {
        this.MGA = false;
        this.DbA = 2;
        com.bytedance.sdk.openadsdk.eli.DbA.Os os = this.qj;
        if (os != null) {
            os.eli(null);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void h_() {
        this.MGA = false;
        this.nn = true;
        this.DbA = 3;
        com.bytedance.sdk.openadsdk.eli.DbA.Os os = this.qj;
        if (os != null) {
            os.DbA(null);
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void i_() {
        this.MGA = false;
        this.nn = false;
        this.DbA = 2;
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void eli(long j, long j2) {
        this.MGA = false;
        int i = this.DbA;
        if (i != 5 && i != 3 && j > this.GB) {
            this.DbA = 2;
        }
        this.GB = j;
        this.oWW = j2;
        if (this.Ue != null && this.Ue.DbA() != null) {
            this.Ue.DbA().setTimeUpdate(((int) (j2 - j)) / 1000);
        }
        if (this.KM instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) {
            ((com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) this.KM).setTimeUpdate(((int) (j2 - j)) / 1000);
            ((com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) this.KM).eli(j, j2);
        }
        DbA(j, j2);
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.InterfaceC0109Os
    public void j_() {
        this.MGA = false;
        this.DbA = 5;
        if (this.Ue != null && this.Ue.DbA() != null) {
            this.Ue.DbA().onvideoComplate();
        }
        com.bytedance.sdk.openadsdk.eli.DbA.Os os = this.qj;
        if (os != null) {
            os.Os(null);
        }
        if (this.KM instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) {
            ((com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) this.KM).onvideoComplate();
        }
    }

    @Override // com.bykv.vk.openvk.eli.eli.eli.aGH.Os.aGH
    public void eli(int i, int i2) {
        this.GB = this.oWW;
        this.DbA = 4;
        com.bytedance.sdk.openadsdk.eli.DbA.Os os = this.qj;
        if (os != null) {
            os.eli(i, i2);
        }
    }

    public void setBackupVideoView(com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga) {
        this.Cp = mga;
    }

    public void Dfc() {
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga = this.Cp;
        if (mga != null) {
            mga.NU();
            return;
        }
        aqO aqo = this.eli;
        if (aqo != null) {
            aqo.NU();
        }
    }

    public void aqO() {
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga = this.Cp;
        if (mga != null) {
            mga.Dfc();
            return;
        }
        aqO aqo = this.eli;
        if (aqo != null) {
            aqo.Dfc();
        }
    }

    protected aqO getExpressVideoView() {
        return this.eli;
    }

    public com.bytedance.sdk.openadsdk.core.nlS.DbA.Os getVideoController() {
        aqO aqo = this.eli;
        if (aqo != null) {
            return aqo.getNativeVideoController();
        }
        return null;
    }

    public void dV() {
        com.bytedance.sdk.openadsdk.core.nlS.DbA.Os videoController = getVideoController();
        if (videoController instanceof com.bytedance.sdk.openadsdk.core.nlS.DbA.Os) {
            videoController.eli(3, true);
        }
    }

    public void setVideoAdListener(com.bytedance.sdk.openadsdk.eli.DbA.Os os) {
        this.qj = os;
    }

    public com.bytedance.sdk.openadsdk.eli.DbA.Os getVideoAdListener() {
        return this.qj;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli(int i, String str) {
        this.nGm = i;
        this.QX = str;
    }

    private void DbA(long j, long j2) {
        int abs = (int) Math.abs(this.nGm - j);
        if (this.nGm < 0 || abs > 500 || this.nGm > j2 || abs >= 500 || this.Xb.contains(this.QX)) {
            return;
        }
        if (this.nGm > j) {
            postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.wC.QX.4
                @Override // java.lang.Runnable
                public void run() {
                    QX.this.eli.setCanInterruptVideoPlay(true);
                    QX.this.eli.performClick();
                    QX qx = QX.this;
                    qx.DbA(qx.nGm, QX.this.QX);
                }
            }, abs);
        } else {
            this.eli.setCanInterruptVideoPlay(true);
            this.eli.performClick();
            DbA(this.nGm, this.QX);
        }
        this.Xb.add(this.QX);
    }
}
