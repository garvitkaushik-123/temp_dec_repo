package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.activity.DbA;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.bytedance.sdk.openadsdk.nn.du;
import com.bytedance.sdk.openadsdk.utils.FC;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.nn;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class FC extends Os {
    private wC Dfc;
    private com.bytedance.sdk.openadsdk.core.ui.Os FC;
    private final List<wC> MGA;
    private int NU;
    private com.bytedance.sdk.openadsdk.core.ui.Os aAs;
    private int aqO;
    private com.bytedance.sdk.openadsdk.core.ui.wC du;
    private com.bytedance.sdk.openadsdk.component.reward.top.Os kb;
    private DbA.AbstractC0166DbA nlS;
    private ui nn;
    public nn ui;
    private du wC;

    public FC(Activity activity, ev evVar, DbA dbA) {
        super(activity, evVar, dbA);
        this.MGA = new ArrayList();
        this.FC = new com.bytedance.sdk.openadsdk.core.ui.Os(activity);
        if (Build.VERSION.SDK_INT >= 35) {
            this.FC.setFitsSystemWindows(true);
        }
        activity.setContentView(this.FC);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli() {
        super.eli();
        Xb();
    }

    private void Xb() {
        boolean NU = NU.nY().NU(String.valueOf(this.DbA.RTg()));
        int DbA = this.aGH.Os() ? DbA(0, NU) : 0;
        if (this.MGA.isEmpty() && !KM.Os(this.DbA)) {
            int i = DbA + 1;
            this.MGA.add(eli(this.aGH, this.DbA, DbA, i, true));
            DbA = i;
        }
        eli(DbA, NU);
    }

    private static wC eli(DbA dbA, ev evVar, int i, int i2, boolean z) {
        boolean Txb = evVar.Txb();
        AdSlot XU = evVar.XU();
        if (XU != null) {
            Txb = XU.getDurationSlotType() == 7;
        }
        if (Txb) {
            return new kb(dbA, evVar, i, i2, z);
        }
        return new MGA(dbA, evVar, i, i2, z);
    }

    private void eli(int i, boolean z) {
        if (Dfc() == null && this.aGH.Os()) {
            bf();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int DbA(int i, boolean z) {
        int i2;
        int i3;
        List<ev> ro = this.DbA.ro();
        if (ro.isEmpty()) {
            return i;
        }
        int size = ro.size();
        this.NU = size;
        int i4 = i;
        int i5 = 0;
        while (i5 < size) {
            boolean z2 = i5 == size + (-1);
            ev evVar = ro.get(i5);
            if (KM.DbA(evVar)) {
                if (KM.Os(evVar)) {
                    List<wC> list = this.MGA;
                    i2 = i4 + 1;
                    ui uiVar = new ui(this.aGH, evVar, i4, i5, true, z2, false);
                    evVar = evVar;
                    list.add(uiVar);
                } else {
                    this.MGA.add(eli(this.aGH, evVar, i4, i5, z2));
                    this.MGA.add(new ui(this.aGH, evVar, i4 + 1, i5, true, z2, false));
                    i3 = i4 + 2;
                    if (z) {
                        boolean eli = this.aGH.eli(evVar);
                        if (!z2) {
                            if (this.aGH.DbA() && eli) {
                                this.MGA.add(new ui(this.aGH, evVar, i3, i5, false, z2, false));
                                i4 = i3 + 1;
                            }
                        } else {
                            if (this.aGH.eli() && eli && !KM.DbA(evVar)) {
                                this.MGA.add(new ui(this.aGH, evVar, i3, i5, false, z2, false));
                                i3++;
                            }
                            if (!TextUtils.isEmpty(this.DbA.MGA())) {
                                ui uiVar2 = new ui(this.aGH, evVar, i3, i5, false, z2, true);
                                this.nn = uiVar2;
                                this.MGA.add(uiVar2);
                                i4 = i3 + 1;
                            }
                        }
                        i5++;
                    }
                    i4 = i3;
                    i5++;
                }
            } else {
                i2 = i4 + 1;
                this.MGA.add(eli(this.aGH, evVar, i4, i5, z2));
            }
            i3 = i2;
            if (z) {
            }
            i4 = i3;
            i5++;
        }
        return i4;
    }

    private void bf() {
        this.ui = com.bytedance.sdk.openadsdk.utils.FC.eli(this.eli, new FC.eli() { // from class: com.bytedance.sdk.openadsdk.activity.FC.1
            @Override // com.bytedance.sdk.openadsdk.utils.FC.eli
            public View eli() {
                if (FC.this.kb != null) {
                    return FC.this.kb.getCloseButton();
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.utils.FC.eli
            public void DbA() {
                if (FC.this.kb != null) {
                    FC.this.kb.setSkipInvisiable();
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(Bundle bundle) {
        super.eli(bundle);
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(this.eli);
        this.aAs = os;
        this.FC.addView(os, new FrameLayout.LayoutParams(-1, -1));
        this.wC = new du(this.eli);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, SSo.DbA(this.eli, 2.0f));
        layoutParams.gravity = 80;
        this.FC.addView(this.wC, layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(this.eli);
        this.du = wCVar;
        wCVar.setTextColor(-1);
        this.du.setTextSize(15.0f);
        this.du.setShadowLayer(1.0f, 0.0f, 1.0f, -16777216);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = SSo.DbA(this.eli, 60.0f);
        layoutParams2.rightMargin = SSo.DbA(this.eli, 16.0f);
        layoutParams2.gravity = 8388661;
        this.FC.addView(this.du, layoutParams2);
        com.bytedance.sdk.openadsdk.component.reward.top.Os os2 = new com.bytedance.sdk.openadsdk.component.reward.top.Os(this.eli);
        this.kb = os2;
        this.FC.addView(os2, new FrameLayout.LayoutParams(-1, -2));
        this.kb.eli(this.DbA);
        this.kb.setShowDislike(true);
        eli(null, null, new DbA.ui(1, null));
    }

    public int QX() {
        wC wCVar = this.Dfc;
        if (wCVar != null) {
            return wCVar.du;
        }
        return -1;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(wC wCVar, wC wCVar2, DbA.ui uiVar) {
        wC wCVar3 = this.Dfc;
        if ((wCVar3 == null || wCVar3 == wCVar) && !com.bytedance.sdk.component.utils.DbA.eli(this.eli)) {
            QX();
            if (wCVar2 == null) {
                wC wCVar4 = this.Dfc;
                int i = wCVar4 != null ? wCVar4.du + 1 : 0;
                if (i < this.MGA.size()) {
                    wCVar2 = this.MGA.get(i);
                }
                if (wCVar2 == null) {
                    this.aGH.aGH();
                    return;
                }
            }
            wC wCVar5 = this.Dfc;
            if (wCVar5 != null) {
                if (wCVar5 == wCVar2) {
                    return;
                }
                wCVar5.NU();
                this.Dfc.aGH();
                com.bytedance.sdk.openadsdk.component.reward.view.FC eli = this.Dfc.eli();
                if (eli != null) {
                    this.aAs.removeView(eli);
                }
                this.Dfc.Xb();
                this.Dfc.NU = false;
                if (this.aGH.DbA()) {
                    wC wCVar6 = this.Dfc;
                    if (wCVar6 instanceof eli) {
                        int i2 = wCVar6.du + 1;
                        wC wCVar7 = i2 < this.MGA.size() ? this.MGA.get(i2) : null;
                        if ((wCVar7 instanceof ui) && wCVar7 != wCVar2) {
                            com.bytedance.sdk.openadsdk.component.reward.view.FC eli2 = wCVar7.eli();
                            if (eli2 != null && eli2.getParent() != null && (eli2.getParent() instanceof ViewGroup)) {
                                ((ViewGroup) eli2.getParent()).removeView(eli2);
                            }
                            wCVar7.Xb();
                        }
                    }
                }
            }
            wCVar2.NU = true;
            wC wCVar8 = this.Dfc;
            this.Dfc = wCVar2;
            DbA(wCVar8, wCVar2, uiVar);
            wCVar2.DbA(this.eli, uiVar);
            com.bytedance.sdk.openadsdk.component.reward.view.FC eli3 = wCVar2.eli();
            if (eli3 != null) {
                ViewParent parent = eli3.getParent();
                if (parent != null) {
                    if (parent == this.aAs) {
                        eli3.setVisibility(0);
                    } else if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(eli3);
                    }
                }
                if (eli3.getParent() == null) {
                    this.aAs.addView(eli3, new ViewGroup.LayoutParams(-1, -1));
                }
            }
            for (int i3 = wCVar8 != null ? wCVar8.du : 0; i3 < this.MGA.size(); i3++) {
                this.MGA.get(i3).eli(wCVar8, this.Dfc, uiVar);
            }
            this.aGH.DbA(this.Dfc);
        }
    }

    private void DbA(wC wCVar, wC wCVar2, DbA.ui uiVar) {
        if (this.nlS == null) {
            if (wCVar2 instanceof MGA) {
                this.nlS = new DbA.eli(this.aGH, this.DbA, this.kb);
            } else {
                this.nlS = new DbA.aGH(this.aGH, this.DbA, this.kb);
            }
        }
        this.nlS.DbA();
        int i = 0;
        for (int i2 = wCVar2.du; i2 < this.MGA.size(); i2++) {
            wC wCVar3 = this.MGA.get(i2);
            boolean z = wCVar3.dV;
            if (wCVar3.eU() && !z) {
                break;
            }
            if (wCVar3 instanceof eli) {
                com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY = wCVar3.FC.nY();
                i = nY != null ? (int) (i + nY.MGA()) : (int) (i + 10);
            } else if (wCVar3 instanceof ui) {
                if (z) {
                    i += KM.ev(wCVar3.FC) + KM.Ue(wCVar3.FC);
                } else if (this.aGH.DbA() && wCVar3.FC != null && !wCVar3.FC.OI()) {
                    i += wCVar3.FC.ke().Os();
                }
            }
        }
        boolean z2 = wCVar2 instanceof ui;
        if (z2 && !((ui) wCVar2).eli && !wCVar2.dV && wCVar2.FC != null && wCVar2.FC.OI()) {
            this.nlS.aGH();
        } else {
            this.nlS.eli(i, wCVar2.FC);
            if (z2) {
                if (wCVar2.eU() && !wCVar2.dV) {
                    Os(wCVar);
                } else if (!wCVar2.dV) {
                    this.nlS.Os(wCVar2.FC.ke().Os());
                } else {
                    this.nlS.eli(wCVar2.FC, wCVar2.nGm);
                }
            }
        }
        nn nnVar = this.ui;
        if (nnVar != null && wCVar == null) {
            nnVar.eli(i * 1000);
        }
        if (wCVar2 instanceof eli) {
            this.aqO++;
            eli(0.0f);
            DbA(wCVar2);
        } else if (z2) {
            if (wCVar2.dV) {
                this.du.setVisibility(8);
                int i3 = wCVar2.nlS;
                int i4 = this.aqO;
                if (i3 >= i4) {
                    this.aqO = i4 + 1;
                    return;
                }
                return;
            }
            if (!((ui) wCVar2).eli) {
                DbA(wCVar2);
            } else {
                this.du.setVisibility(8);
            }
        }
    }

    private void DbA(wC wCVar) {
        try {
            this.du.setText(this.eli.getString(com.bytedance.sdk.component.utils.ev.DbA(dV.eli(), "tt_multiple_ad_indicator"), new Object[]{Integer.valueOf(wCVar.nlS + 1), Integer.valueOf(this.NU)}));
            this.du.setVisibility(0);
        } catch (Throwable th) {
            Xb.eli("SeqSwitchLayoutManager", "updateCurrentAdIndex: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(int i, int i2) {
        super.eli(i, i2);
        if (i >= 0) {
            if (TextUtils.isEmpty(this.Os)) {
                this.du.setText(this.eli.getString(com.bytedance.sdk.component.utils.ev.DbA(dV.eli(), "tt_multiple_playable_wait_tips"), new Object[]{Integer.valueOf(i)}));
            } else {
                this.du.setText(String.format(this.Os, Integer.valueOf(i)));
            }
            this.du.setVisibility(0);
            return;
        }
        this.du.setVisibility(8);
    }

    private void Os(wC wCVar) {
        du duVar = this.wC;
        if (duVar != null) {
            SSo.kb(duVar);
            this.wC = null;
        }
        com.bytedance.sdk.openadsdk.component.reward.top.Os os = this.kb;
        if (os != null) {
            SSo.kb(os);
            SSo.kb(this.kb.getITopLayout());
            this.kb = null;
        }
        DbA.AbstractC0166DbA abstractC0166DbA = this.nlS;
        if (abstractC0166DbA != null) {
            abstractC0166DbA.Os();
        }
        if (wCVar instanceof kb) {
            ((kb) wCVar).ikX();
        }
        nn nnVar = this.ui;
        if (nnVar != null) {
            nnVar.Os();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void DbA() {
        super.DbA();
        wC wCVar = this.Dfc;
        if (wCVar != null) {
            wCVar.Os();
        }
        DbA.AbstractC0166DbA abstractC0166DbA = this.nlS;
        if (abstractC0166DbA != null) {
            abstractC0166DbA.DbA(-1);
        }
        nn nnVar = this.ui;
        if (nnVar != null) {
            nnVar.eli();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void Os() {
        super.Os();
        wC wCVar = this.Dfc;
        if (wCVar != null) {
            wCVar.NU();
        }
        DbA.AbstractC0166DbA abstractC0166DbA = this.nlS;
        if (abstractC0166DbA != null) {
            abstractC0166DbA.eli(-1);
        }
        nn nnVar = this.ui;
        if (nnVar != null) {
            nnVar.DbA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void aGH() {
        super.aGH();
        wC wCVar = this.Dfc;
        if (wCVar != null) {
            wCVar.FS();
        }
        int QX = QX();
        for (wC wCVar2 : this.MGA) {
            if (wCVar2.du >= QX) {
                wCVar2.Xb();
            }
        }
        DbA.AbstractC0166DbA abstractC0166DbA = this.nlS;
        if (abstractC0166DbA != null) {
            abstractC0166DbA.Os();
        }
        nn nnVar = this.ui;
        if (nnVar != null) {
            nnVar.Os();
        }
        wC wCVar3 = this.Dfc;
        if (wCVar3 != null && !wCVar3.ev() && !this.DbA.JF()) {
            com.bytedance.sdk.openadsdk.core.nn.DbA().post(new DbA.Os(this.DbA));
        }
        this.Dfc = null;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public ui Dfc() {
        ui uiVar = this.nn;
        if (uiVar != null) {
            return uiVar;
        }
        wC wCVar = this.Dfc;
        int i = wCVar != null ? wCVar.du : -1;
        int size = this.MGA.size() - 1;
        while (true) {
            if (size <= i) {
                break;
            }
            wC wCVar2 = this.MGA.get(size);
            if (wCVar2 instanceof ui) {
                ui uiVar2 = (ui) wCVar2;
                if (uiVar2.eli) {
                    this.nn = uiVar2;
                    break;
                }
            }
            size--;
        }
        return this.nn;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public wC nn() {
        wC wCVar;
        wC wCVar2 = this.Dfc;
        if (wCVar2 == null) {
            return null;
        }
        int i = wCVar2.du;
        while (true) {
            i++;
            if (i >= this.MGA.size()) {
                return null;
            }
            wCVar = this.MGA.get(i);
            if (!(wCVar instanceof eli) && (!(wCVar instanceof ui) || !KM.Os(wCVar.FC) || !wCVar.dV)) {
            }
        }
        return wCVar;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(float f) {
        du duVar = this.wC;
        if (duVar == null) {
            return;
        }
        duVar.setProgress(f);
        if (f == 0.0f && this.wC.getVisibility() == 0) {
            this.wC.setVisibility(4);
        } else {
            if (f <= 0.0f || this.wC.getVisibility() == 0) {
                return;
            }
            this.wC.setVisibility(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public com.bytedance.sdk.openadsdk.component.reward.top.Os NU() {
        return this.kb;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public int FC() {
        DbA.AbstractC0166DbA abstractC0166DbA = this.nlS;
        if (abstractC0166DbA != null) {
            return abstractC0166DbA.eli();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void DbA(wC wCVar, int i) {
        DbA.AbstractC0166DbA abstractC0166DbA = this.nlS;
        if (abstractC0166DbA == null) {
            return;
        }
        if (i == 2) {
            abstractC0166DbA.eli(i);
            nn nnVar = this.ui;
            if (nnVar != null) {
                nnVar.DbA();
                return;
            }
            return;
        }
        if (i == 1) {
            abstractC0166DbA.DbA(i);
            nn nnVar2 = this.ui;
            if (nnVar2 != null) {
                nnVar2.eli();
                return;
            }
            return;
        }
        if (i == 3 || i == 4) {
            try {
                this.Dfc.ujq().ev.GB();
            } catch (Throwable th) {
                Xb.Os("SeqSwitchLayoutManager", th);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(wC wCVar, DbA.ui uiVar) {
        wC wCVar2 = this.Dfc;
        if (wCVar2 == null || wCVar2 == wCVar) {
            if (wCVar2 != null && (wCVar2 instanceof eli)) {
                final long NU = (wCVar2.ujq() == null || this.Dfc.ujq().ev == null) ? 0L : this.Dfc.ujq().ev.NU();
                final int i = this.Dfc.nlS + 1;
                com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), this.Dfc.FC, this.Dfc.b_(), "dislike_skip", new com.bytedance.sdk.openadsdk.Dfc.Os.eli() { // from class: com.bytedance.sdk.openadsdk.activity.FC.2
                    @Override // com.bytedance.sdk.openadsdk.Dfc.Os.eli
                    public JSONObject eli() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("duration", NU);
                            JSONObject jSONObject2 = new JSONObject();
                            com.bytedance.sdk.openadsdk.aGH.Os.eli(i, jSONObject2);
                            jSONObject.put("ad_extra_data", jSONObject2.toString());
                            return jSONObject;
                        } catch (Throwable th) {
                            th.getMessage();
                            return jSONObject;
                        }
                    }
                });
            }
            wC nn = nn();
            if (nn == null) {
                nn = Dfc();
            }
            eli(this.Dfc, nn, uiVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(wC wCVar, boolean z, boolean z2, boolean z3, int i) {
        ui Dfc;
        wC wCVar2 = this.Dfc;
        if ((wCVar2 == null || wCVar2 == wCVar) && (Dfc = Dfc()) != null) {
            DbA.ui uiVar = new DbA.ui(i, wCVar != null ? wCVar.ujq() : null);
            uiVar.eli.putBoolean("isSkip", z);
            uiVar.eli.putBoolean("force", z2);
            uiVar.eli.putBoolean("isFromLandingPage", z3);
            eli(this.Dfc, Dfc, uiVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public boolean ui() {
        if (this.MGA.isEmpty()) {
            return false;
        }
        List<wC> list = this.MGA;
        wC wCVar = list.get(list.size() - 1);
        return (wCVar instanceof ui) && ((ui) wCVar).eli;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(eli eliVar, boolean z) {
        DbA.AbstractC0166DbA abstractC0166DbA;
        super.eli(eliVar, z);
        if (eliVar == null || eliVar != this.Dfc || (abstractC0166DbA = this.nlS) == null) {
            return;
        }
        abstractC0166DbA.DbA(z);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(wC wCVar) {
        DbA.AbstractC0166DbA abstractC0166DbA;
        super.eli(wCVar);
        if (wCVar == null) {
            return;
        }
        Xb.eli("SeqSwitchLayoutManager", "onPlayableLoadingDismiss [scene=]" + wCVar + ",isActive=" + wCVar.NU);
        if (wCVar.NU && (abstractC0166DbA = this.nlS) != null) {
            abstractC0166DbA.MGA();
        }
        wC nn = nn();
        if (nn instanceof eli) {
            ((eli) nn).CMM();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(wC wCVar, boolean z) {
        DbA.AbstractC0166DbA abstractC0166DbA;
        super.eli(wCVar, z);
        if (wCVar == null) {
            return;
        }
        Xb.eli("SeqSwitchLayoutManager", "setIsHappenInteraction [scene=]" + wCVar + ",isActive=" + wCVar.NU + ",isHappenInteraction=" + z);
        if (!wCVar.NU || (abstractC0166DbA = this.nlS) == null) {
            return;
        }
        abstractC0166DbA.eli(z);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(View view) {
        super.eli(view);
        if (view.getParent() != null) {
            return;
        }
        view.setVisibility(4);
        this.aAs.addView(view, 0);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(View view, boolean z) {
        super.eli(view, z);
        if (view.getParent() == null && this.aAs != null) {
            view.setVisibility(4);
            int childCount = this.aAs.getChildCount();
            if (z) {
                this.aAs.addView(view, 0);
            } else {
                this.aAs.addView(view, childCount - 1);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public boolean eli(wC wCVar, int i) {
        return i == this.MGA.size() - 1 && this.MGA.get(i) != null && (this.MGA.get(i) instanceof ui);
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void kb() {
        super.kb();
        wC wCVar = this.Dfc;
        if (wCVar != null) {
            wCVar.nlS();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(boolean z) {
        super.eli(z);
        wC wCVar = this.Dfc;
        if (wCVar != null) {
            wCVar.Os(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void wC() {
        super.wC();
        wC wCVar = this.Dfc;
        if (wCVar != null) {
            wCVar.aGH();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void eli(Activity activity) {
        super.eli(activity);
        wC wCVar = this.Dfc;
        if (wCVar != null) {
            wCVar.eli(activity);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public void aAs() {
        super.aAs();
        wC wCVar = this.Dfc;
        if (wCVar != null) {
            wCVar.bf();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public int du() {
        return this.aqO;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public wC nlS() {
        return this.Dfc;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.Os
    public List<ev> aqO() {
        return this.DbA.ro();
    }
}
