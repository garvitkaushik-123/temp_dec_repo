package com.bytedance.sdk.openadsdk.component.FC;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.eli.eli.eli.aGH.Os;
import com.bytedance.sdk.component.adexpress.DbA.NU;
import com.bytedance.sdk.component.adexpress.DbA.nn;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.wC.Dfc;
import com.bytedance.sdk.openadsdk.core.wC.Vy;
import com.bytedance.sdk.openadsdk.core.wC.Xb;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.cyF;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class DbA extends Xb {
    boolean DbA;
    private FrameLayout GB;
    private final com.bytedance.sdk.openadsdk.component.MGA.DbA MGA;
    int Os;
    private com.bytedance.sdk.openadsdk.component.MGA.eli VM;
    float aGH;
    boolean eli;
    private final com.bytedance.sdk.openadsdk.component.wC.eli kb;
    private Os.eli oWW;
    private final com.bytedance.sdk.openadsdk.component.eli ui;
    private com.bytedance.sdk.openadsdk.component.wC.Os wC;

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli(int i, String str) {
    }

    public DbA(Context context, ev evVar, AdSlot adSlot, String str, com.bytedance.sdk.openadsdk.component.eli eliVar, com.bytedance.sdk.openadsdk.component.MGA.DbA dbA, com.bytedance.sdk.openadsdk.component.wC.eli eliVar2) {
        super(context, evVar, adSlot, str, true, true);
        this.eli = true;
        this.DbA = false;
        this.Os = 0;
        this.aGH = 1.0f;
        this.ui = eliVar;
        this.MGA = dbA;
        this.kb = eliVar2;
        if (evVar == null || evVar.CI() == null) {
            return;
        }
        this.Os = evVar.CI().DbA();
        this.aGH = evVar.CI().eli();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
    protected void kb() {
        this.Dfc = true;
        this.GB = new FrameLayout(this.FC);
        if (!com.bytedance.sdk.openadsdk.core.aAs.aGH.eli(this.nlS) && !com.bytedance.sdk.openadsdk.core.aAs.aGH.DbA(this.nlS)) {
            addView(this.GB, new FrameLayout.LayoutParams(-1, -1));
        }
        super.kb();
        setVideoFrameChangeListener(new com.bytedance.sdk.openadsdk.nlS.kb() { // from class: com.bytedance.sdk.openadsdk.component.FC.DbA.1
            @Override // com.bytedance.sdk.openadsdk.nlS.kb
            public void eli(nn nnVar) {
                DbA.this.eli(nnVar);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
    public int getDynamicShowType() {
        if (this.KM == null) {
            return 1;
        }
        return super.getDynamicShowType();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.component.adexpress.DbA.Dfc
    public void eli(com.bytedance.sdk.component.adexpress.DbA.aGH<? extends View> agh, nn nnVar) {
        this.KM = agh;
        if (agh instanceof Vy) {
            Vy vy = (Vy) agh;
            if (vy.aqO() != null) {
                vy.aqO().eli((Dfc) this);
            }
        }
        if (nnVar != null && nnVar.DbA()) {
            eli(nnVar);
        }
        super.eli(agh, nnVar);
    }

    public void eli(final nn nnVar) {
        if (nnVar == null) {
            return;
        }
        cyF.eli(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.FC.DbA.2
            @Override // java.lang.Runnable
            public void run() {
                DbA.this.Os(nnVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os(nn nnVar) {
        if (nnVar == null) {
            return;
        }
        if (nnVar.eli() != null) {
            if (this.eli) {
                nnVar.eli().setTag(com.bytedance.sdk.component.adexpress.dynamic.eli.MGA, 1);
                ((FrameLayout) nnVar.eli()).removeAllViews();
                FrameLayout frameLayout = (FrameLayout) nnVar.eli();
                this.GB = frameLayout;
                ((FrameLayout.LayoutParams) frameLayout.getLayoutParams()).gravity = 17;
                this.eli = false;
                return;
            }
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
                    Dfc.addView(this.GB, layoutParams);
                    return;
                }
                return;
            }
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.GB.getLayoutParams();
            if (layoutParams2 == null) {
                layoutParams2 = new FrameLayout.LayoutParams(DbA3, DbA4);
            }
            layoutParams2.width = DbA3;
            layoutParams2.height = DbA4;
            layoutParams2.topMargin = DbA2;
            layoutParams2.leftMargin = DbA;
            layoutParams2.setMarginStart(layoutParams2.leftMargin);
            layoutParams2.setMarginEnd(layoutParams2.rightMargin);
            this.GB.setLayoutParams(layoutParams2);
        }
    }

    public void setExpressVideoListenerProxy(Os.eli eliVar) {
        this.oWW = eliVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli() {
        com.bytedance.sdk.openadsdk.component.MGA.eli eliVar = this.VM;
        if (eliVar != null) {
            eliVar.eli(this);
        }
    }

    public void setVideoManager(com.bytedance.sdk.openadsdk.component.wC.Os os) {
        this.wC = os;
    }

    public void eli(long j, long j2) {
        if (this.KM instanceof com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) {
            ((com.bytedance.sdk.openadsdk.core.aAs.MGA.Os) this.KM).eli(j, j2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public boolean eli(JSONObject jSONObject) {
        if (jSONObject == null) {
            this.DbA = false;
            return false;
        }
        int i = this.Os;
        if (i != 1 && i != 2) {
            this.DbA = false;
            return false;
        }
        int optInt = jSONObject.optInt("switch", 0);
        float optDouble = (float) jSONObject.optDouble("speed", 0.0d);
        this.aGH = optDouble;
        if (optDouble <= 0.0f && this.nlS != null && this.nlS.CI() != null) {
            this.aGH = this.nlS.CI().eli();
        }
        boolean z = optInt == 1;
        this.DbA = z;
        com.bytedance.sdk.openadsdk.component.MGA.DbA dbA = this.MGA;
        if (dbA != null) {
            dbA.eli(this.Os, this.aGH, z);
            com.bytedance.sdk.openadsdk.component.wC.Os os = this.wC;
            if (os != null && os.DbA() != null && this.kb != null) {
                this.wC.DbA().eli(this.kb.eli());
                com.bytedance.sdk.component.utils.Xb.eli("PAGAppOpenAdExpressView", "isAccelerate =" + this.DbA + ",total duration = " + this.wC.DbA().dV());
            }
        }
        if (this.Os == 1) {
            return true;
        }
        if (!this.DbA) {
            this.aGH = 1.0f;
        }
        com.bytedance.sdk.openadsdk.component.wC.Os os2 = this.wC;
        if (os2 != null) {
            return os2.eli(this.aGH);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void DbA() {
        super.DbA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void eli(int i) {
        com.bytedance.sdk.openadsdk.component.wC.Os os = this.wC;
        if (os == null) {
            return;
        }
        if (i != 1) {
            if (i == 2) {
                os.wC();
                this.MGA.aGH();
                return;
            } else if (i == 3) {
                os.FC();
                this.MGA.Os();
                return;
            } else if (i == 4) {
                os.aAs();
                return;
            } else if (i != 5) {
                return;
            }
        }
        if (os.ui() || this.wC.MGA()) {
            return;
        }
        this.wC.eli(getVideoFrameLayout(), this.ui, this.nlS);
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public void MGA() {
        com.bytedance.sdk.openadsdk.component.MGA.eli eliVar = this.VM;
        if (eliVar != null) {
            eliVar.DbA(this);
        }
    }

    public void setTopListener(com.bytedance.sdk.openadsdk.component.MGA.eli eliVar) {
        this.VM = eliVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public int ui() {
        com.bytedance.sdk.openadsdk.component.wC.Os os = this.wC;
        if (os != null && os.kb()) {
            return 1;
        }
        com.bytedance.sdk.openadsdk.component.wC.Os os2 = this.wC;
        if (os2 != null && os2.MGA()) {
            return 3;
        }
        com.bytedance.sdk.openadsdk.component.wC.Os os3 = this.wC;
        if (os3 != null && os3.ui()) {
            return 2;
        }
        com.bytedance.sdk.openadsdk.component.wC.Os os4 = this.wC;
        if (os4 != null && os4.Os()) {
            kb(4);
            return 4;
        }
        com.bytedance.sdk.openadsdk.component.wC.Os os5 = this.wC;
        return (os5 == null || !os5.aGH()) ? 3 : 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public long Os() {
        return this.kb.Os();
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb, com.bytedance.sdk.openadsdk.core.wC.Dfc
    public long aGH() {
        return this.kb.Os();
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
        return this.GB;
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
    protected int getRenderTimeout() {
        return com.bytedance.sdk.openadsdk.component.kb.eli.eli(this.nlS, dV.aGH().MGA(String.valueOf(this.nlS.RTg())));
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
    protected void eli(NU.eli eliVar) {
        eliVar.ui(com.bytedance.sdk.openadsdk.component.kb.eli.eli());
    }

    @Override // com.bytedance.sdk.openadsdk.core.wC.Xb
    protected void Os(JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.component.kb.eli.eli(jSONObject, this.nlS != null ? this.nlS.RTg() : 0, this.nlS != null && this.nlS.rH() == 0);
    }
}
