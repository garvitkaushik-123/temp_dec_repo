package com.bytedance.sdk.openadsdk.component.reward.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.DbA.nn;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.Vy.DbA.ui;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.wC.Dfc;
import com.bytedance.sdk.openadsdk.core.wC.Vy;
import com.bytedance.sdk.openadsdk.core.wC.Xb;
import com.bytedance.sdk.openadsdk.core.wC.dV;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH extends Xb {
    public static float eli = 100.0f;
    Dfc DbA;
    private float MGA;
    dV Os;
    public int aGH;
    private com.bytedance.sdk.openadsdk.Xb.eli.eli kb;
    private final com.bytedance.sdk.openadsdk.component.reward.eli.eli ui;

    public aGH(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar, AdSlot adSlot, String str) {
        super(eliVar.SSo, eliVar.DbA, adSlot, str, eliVar.tGZ, !eliVar.rH);
        this.aGH = 1;
        this.MGA = -1.0f;
        this.ui = eliVar;
        setVideoBusiness(eliVar.Uv);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
    protected void kb() {
        this.Dfc = true;
        this.NU = new FrameLayout(this.FC);
        if (!com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(this.nlS) && !com.bytedance.sdk.openadsdk.core.aAs.aGH.DbA(this.nlS)) {
            addView(this.NU, new FrameLayout.LayoutParams(-1, -1));
        }
        super.kb();
        com.bytedance.sdk.component.FC.MGA webView = getWebView();
        if (webView != null) {
            webView.setBackgroundColor(0);
        }
        NU();
        setVideoFrameChangeListener(new com.bytedance.sdk.openadsdk.nlS.kb() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.aGH.1
            @Override // com.bytedance.sdk.openadsdk.nlS.kb
            public void eli(nn nnVar) {
                aGH.this.eli(nnVar);
            }
        });
    }

    private void NU() {
        setBackupListener(new com.bytedance.sdk.component.adexpress.DbA.Os() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.aGH.2
            @Override // com.bytedance.sdk.component.adexpress.DbA.Os
            public boolean eli(ViewGroup viewGroup, int i) {
                try {
                    ((Xb) viewGroup).Xb();
                    aGH.this.Os = new dV(viewGroup.getContext());
                    aGH.this.Os.eli(aGH.this.nlS, (Xb) viewGroup, aGH.this.ui.dZ);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.component.adexpress.DbA.Dfc
    public void eli(com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh, nn nnVar) {
        this.KM = agh;
        if (this.nlS != null && this.nlS.nie()) {
            super.eli(agh, nnVar);
            return;
        }
        if (agh instanceof Vy) {
            Vy vy = (Vy) agh;
            if (vy.aqO() != null) {
                vy.aqO().eli((Dfc) this);
            }
        }
        if (nnVar != null && nnVar.DbA()) {
            eli(nnVar);
            int Os = agh.Os();
            this.aGH = Os;
            if (Os == 10 && KM.Os(this.nlS)) {
                Os(nnVar);
            }
        }
        super.eli(agh, nnVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
    protected boolean wC() {
        if (this.ui.yKf == null || !this.ui.yKf.dZ().bf()) {
            return true;
        }
        return this.ui.WfR;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
    protected boolean FC() {
        return this.ui.yKf == null || !this.ui.yKf.dZ().bf();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.component.adexpress.dynamic.aGH
    public void setSoundMute(boolean z) {
        super.setSoundMute(z);
        com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar = this.kb;
        if (eliVar != null) {
            eliVar.eli(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
    public void aAs() {
        super.aAs();
        if (this.kb != null) {
            if (this.ui.yKf != null && this.ui.yKf.dZ() != null) {
                this.kb.eli(this.ui.yKf.dZ().nGm());
            }
            this.kb.DbA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
    public void du() {
        super.du();
        if (this.kb != null) {
            if (this.ui.yKf != null && this.ui.yKf.dZ() != null) {
                this.kb.eli(true);
            }
            this.kb.Os();
        }
    }

    private void Os(nn nnVar) {
        FrameLayout aqO;
        boolean z;
        try {
            if (!(nnVar instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.DbA) || (aqO = ((com.bytedance.sdk.openadsdk.core.aAs.MGA.DbA) nnVar).aqO()) == null) {
                return;
            }
            boolean z2 = true;
            if (this.ui.yKf == null || this.ui.yKf.dZ() == null) {
                z = false;
            } else {
                z = this.ui.yKf.dZ().wC() == this.ui.yKf;
                if (!this.ui.yKf.dZ().nGm() && z) {
                    z2 = false;
                }
            }
            boolean z3 = z2;
            com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar = new com.bytedance.sdk.openadsdk.Xb.eli.eli(this.FC, this.nlS, this.ui.QI, z3, aqO);
            this.kb = eliVar;
            eliVar.eli(this.ui.Uv);
            this.kb.eli(false, (com.bytedance.sdk.openadsdk.nlS.MGA) null);
            this.kb.eli();
            com.bytedance.sdk.component.utils.Xb.eli("TTAD.FRExpressView", "initPlayable success mute = " + this.ui.tGZ + ",isCurrentScene->" + z + ",isMute = " + z3);
        } catch (Throwable th) {
            new Object[]{th};
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
    public void nlS() {
        try {
            com.bytedance.sdk.openadsdk.Xb.eli.eli eliVar = this.kb;
            if (eliVar != null) {
                eliVar.aGH();
            }
        } catch (Throwable th) {
            new Object[]{th};
        }
        super.nlS();
    }

    public void setExpressVideoListenerProxy(Dfc dfc) {
        this.DbA = dfc;
    }

    public void eli(final nn nnVar) {
        if (nnVar == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.aGH.3
            @Override // java.lang.Runnable
            public void run() {
                aGH.this.aGH(nnVar);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli(String str, JSONObject jSONObject) {
        super.eli(str, jSONObject);
        Dfc dfc = this.DbA;
        if (dfc != null) {
            dfc.eli(str, jSONObject);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0019, code lost:
    
        if (r1 != 1) goto L17;
     */
    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        nlS nls = this.ui.eU;
        if (nls != null && nls.Dfc != null) {
            com.bytedance.sdk.openadsdk.core.model.Xb xb = nls.Dfc;
            if (xb.FC()) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    this.MGA = motionEvent.getY();
                }
                if (SSo.eli(this.MGA, motionEvent.getY(), this.FC)) {
                    xb.eli(5);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGH(nn nnVar) {
        if (nnVar == null) {
            return;
        }
        double ui = nnVar.ui();
        double MGA = nnVar.MGA();
        double kb = nnVar.kb();
        double wC = nnVar.wC();
        int DbA = SSo.DbA(this.FC, (float) ui);
        int DbA2 = SSo.DbA(this.FC, (float) MGA);
        int DbA3 = SSo.DbA(this.FC, (float) kb);
        int DbA4 = SSo.DbA(this.FC, (float) wC);
        if ((wC != 0.0d && kb != 0.0d) || this.KM.Os() == 7 || this.KM.Os() == 10) {
            if ((this.KM.Os() == 7 || this.KM.Os() == 10) && (nnVar instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.DbA)) {
                FrameLayout Dfc = ((com.bytedance.sdk.openadsdk.core.aAs.MGA.DbA) nnVar).Dfc();
                if (Dfc != null) {
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    layoutParams.gravity = 17;
                    Dfc.addView(this.NU, layoutParams);
                    return;
                }
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.NU.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(DbA3, DbA4);
            }
            layoutParams2.width = DbA3;
            layoutParams2.height = DbA4;
            layoutParams2.topMargin = DbA2;
            layoutParams2.leftMargin = DbA;
            layoutParams2.setMarginStart(layoutParams2.leftMargin);
            layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            this.NU.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli(boolean z, String str) {
        Dfc dfc = this.DbA;
        if (dfc != null) {
            dfc.eli(z, str);
        }
        setSoundMute(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public boolean eli(JSONObject jSONObject) {
        new StringBuilder("setPlaybackSpeed,params:").append(jSONObject);
        Dfc dfc = this.DbA;
        if (dfc != null) {
            return dfc.eli(jSONObject);
        }
        return super.eli(jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public boolean DbA(JSONObject jSONObject) {
        return com.bytedance.sdk.openadsdk.component.reward.eli.eli(this.ui);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli() {
        Dfc dfc = this.DbA;
        if (dfc != null) {
            dfc.eli();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void DbA() {
        Dfc dfc = this.DbA;
        if (dfc != null) {
            dfc.DbA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli(int i) {
        Dfc dfc = this.DbA;
        if (dfc != null) {
            dfc.eli(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public long Os() {
        Dfc dfc = this.DbA;
        if (dfc != null) {
            return dfc.Os();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public long aGH() {
        Dfc dfc = this.DbA;
        if (dfc != null) {
            return dfc.aGH();
        }
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public int ui() {
        Dfc dfc = this.DbA;
        if (dfc == null) {
            return 0;
        }
        int ui = dfc.ui();
        kb(ui);
        return ui;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void MGA() {
        Dfc dfc = this.DbA;
        if (dfc != null) {
            dfc.MGA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli(int i, nn nnVar) {
        Dfc dfc = this.DbA;
        if (dfc != null) {
            dfc.eli(i, nnVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.component.adexpress.DbA.wC
    public void eli(View view, int i, com.bytedance.sdk.component.adexpress.Os os) {
        if (i != -1 && os != null && i == 3) {
            MGA();
        } else {
            super.eli(view, i, os);
        }
    }

    public FrameLayout getVideoFrameLayout() {
        if (bf()) {
            return this.Os.getVideoContainer();
        }
        return this.NU;
    }

    public View getBackupContainerBackgroundView() {
        if (bf()) {
            return this.Os.getBackupContainerBackgroundView();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void DbA(int i) {
        Dfc dfc = this.DbA;
        if (dfc != null) {
            dfc.DbA(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli(int i, String str) {
        Dfc dfc = this.DbA;
        if (dfc != null) {
            dfc.eli(i, str);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
    protected ui.eli Os(int i) {
        ui.eli Os = super.Os(i);
        if (this.ui.rH && this.ui.yKf != null) {
            Os.DbA = this.ui.yKf.nlS;
        }
        return Os;
    }

    public void eli(long j, long j2) {
        if (this.KM instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) {
            ((com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) this.KM).eli(j, j2);
        }
    }
}
