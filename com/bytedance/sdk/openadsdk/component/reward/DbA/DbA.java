package com.bytedance.sdk.openadsdk.component.reward.DbA;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.aGH.DbA;
import com.bytedance.sdk.openadsdk.activity.DbA;
import com.bytedance.sdk.openadsdk.activity.TTRewardVideoActivity;
import com.bytedance.sdk.openadsdk.common.NU;
import com.bytedance.sdk.openadsdk.component.reward.view.RFEndCardBackUpLayout;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.nGm;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aAs;
import com.bytedance.sdk.openadsdk.core.widget.du;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class DbA extends com.bytedance.sdk.openadsdk.component.reward.DbA.eli {
    private com.bytedance.sdk.openadsdk.nlS.MGA Dfc;
    public com.bytedance.sdk.openadsdk.core.widget.DbA NU;
    protected String du;
    protected com.bytedance.sdk.openadsdk.core.DbA.ui nlS;
    public LinearLayout nn;

    public interface eli {
        void eli(boolean z);
    }

    protected boolean KM() {
        return true;
    }

    public abstract boolean MGA();

    public void NU() {
    }

    public void QX() {
    }

    public eli aGH() {
        return null;
    }

    public abstract void eli(FrameLayout frameLayout);

    public abstract void kb();

    public abstract boolean ui();

    public DbA(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        super(eliVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.eli
    public void eli(com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA dbA, Ue ue) {
        super.eli(dbA, ue);
        if (this.eli.DbA.ui() && this.eli.DE) {
            this.eli.qj.eli(false);
        }
        if (KM.dV(this.eli.DbA)) {
            this.eli.gG.nlS();
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.component.reward.view.FC fc) {
        eli(fc, this.eli);
    }

    public RFEndCardBackUpLayout wC() {
        return new RFEndCardBackUpLayout(this.eli.FS);
    }

    public View FC() {
        PAGLogoView createPAGLogoViewByMaterial;
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(this.eli.SSo);
        os.setId(aqO.Jt);
        com.bytedance.sdk.openadsdk.core.ui.aGH DbA = com.bytedance.sdk.openadsdk.core.widget.MGA.DbA(this.eli.SSo);
        DbA.setId(520093708);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = SSo.DbA(this.eli.SSo, 20.0f);
        layoutParams.rightMargin = SSo.DbA(this.eli.SSo, 16.0f);
        DbA.setLayoutParams(layoutParams);
        DbA.setContentDescription(ev.eli(this.eli.SSo, "tt_ad_close_text"));
        DbA.setVisibility(8);
        if (this.eli.yKf == null || !this.eli.yKf.dZ().bf()) {
            createPAGLogoViewByMaterial = PAGLogoView.createPAGLogoViewByMaterial(this.eli.SSo, this.eli.DbA);
            createPAGLogoViewByMaterial.setId(520093757);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, SSo.DbA(this.eli.SSo, 14.0f));
            layoutParams2.gravity = 8388691;
            createPAGLogoViewByMaterial.setLayoutParams(layoutParams2);
        } else {
            createPAGLogoViewByMaterial = null;
        }
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(this.eli.SSo);
        agh.setId(aqO.Zo);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(SSo.DbA(this.eli.SSo, 32.0f), SSo.DbA(this.eli.SSo, 14.0f));
        layoutParams3.gravity = 8388693;
        agh.setLayoutParams(layoutParams3);
        agh.setPadding(SSo.DbA(this.eli.SSo, 9.0f), 0, SSo.DbA(this.eli.SSo, 9.0f), 0);
        agh.setScaleType(ImageView.ScaleType.FIT_CENTER);
        aAs aas = new aAs(this.eli.SSo);
        aas.setId(aqO.FYe);
        aas.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        aas.setClickable(true);
        aas.setFocusable(true);
        if (createPAGLogoViewByMaterial != null) {
            os.addView(createPAGLogoViewByMaterial);
        }
        os.addView(agh);
        os.addView(aas);
        if (!this.eli.DbA.dZ() || !this.eli.rH || this.eli.eli != 1) {
            com.bytedance.sdk.openadsdk.component.reward.top.Os os2 = new com.bytedance.sdk.openadsdk.component.reward.top.Os(this.eli.SSo);
            os2.setId(aqO.nW);
            os2.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
            os.addView(os2);
        }
        os.addView(DbA);
        return os;
    }

    public View aAs() {
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar;
        if (this.DbA.rn() != 5) {
            kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(this.eli.SSo);
            kbVar.setId(aqO.Mkx);
        } else {
            kbVar = null;
        }
        new StringBuilder("getLoadingFrameView").append(kbVar);
        return kbVar;
    }

    public void du() {
        this.eli.Ue.eli(this.eli.aGH);
        this.eli.eU.DbA();
        this.eli.cyF.eli();
        if (!this.eli.DbA.Kv()) {
            if (this.eli.kb && TextUtils.isEmpty(com.bytedance.sdk.openadsdk.core.model.ev.eli(this.eli.FS, this.DbA))) {
                nlS();
            }
            this.eli.qj.eli();
            this.eli.nro.eli();
        }
        this.eli.gG.Dfc();
        this.eli.Cp.eli();
        if (KM.MGA(this.eli.DbA)) {
            this.eli.eU.aGH();
            SSo.eli((View) this.eli.qj.aAs(), 4);
        }
        if (Xb.aGH(this.eli.DbA) || Xb.DbA(this.eli.DbA) || Xb.ui(this.eli.DbA)) {
            return;
        }
        this.eli.eU.eli(SSo.DbA(this.eli.FS, this.eli.oc), SSo.DbA(this.eli.FS, this.eli.rQ));
        this.eli.Vy.eli();
        if (KM.dV(this.eli.DbA)) {
            this.eli.qj.eli(true);
            this.eli.qj.ui();
            eli(false, false, false, DbA.C0161DbA.Os);
        } else if (this.eli.gHb) {
            this.eli.eU.eli(0);
        }
    }

    public void nlS() {
        LinearLayout linearLayout = (LinearLayout) this.eli.dZ.findViewById(aqO.NU);
        this.nn = linearLayout;
        SSo.eli((View) linearLayout, 8);
        this.eli.tLO = new NU(this.eli.SSo, this.eli.DbA, "landingpage_endcard");
        this.eli.tLO.Os().setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.DbA.DbA.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DbA.this.eli.eU.aAs().performClick();
            }
        });
        this.nn.addView(this.eli.tLO.ui(), new LinearLayout.LayoutParams(-1, -1));
        this.eli.qj.eli(this.eli.tLO);
    }

    public void eli(boolean z, boolean z2, boolean z3, int i) {
        this.eli.cyF.eli(z, z2, z3, this, i);
    }

    public void nn() {
        com.bytedance.sdk.openadsdk.core.widget.DbA dbA = this.NU;
        if (dbA == null || !dbA.isShowing()) {
            return;
        }
        this.NU.dismiss();
    }

    public void Dfc() {
        if (!this.eli.kb && this.eli.aGH()) {
            this.eli.Cp.ui();
            if (this.eli.rH && (this.eli.yKf instanceof com.bytedance.sdk.openadsdk.activity.eli)) {
                return;
            }
            this.eli.eU.MGA(0);
        }
    }

    public void aqO() {
        this.aAs.removeMessages(300);
    }

    public void dV() {
        if (this.eli.yKf != null || ((!KM.DbA(this.DbA) && !KM.Os(this.DbA)) || (KM.aAs(this.DbA) && this.eli.qj.dZ() && !this.eli.qj.FS()))) {
            nGm();
        }
        if (this.eli == null) {
            return;
        }
        if (this.eli.GMY != null) {
            this.eli.GMY.eli();
        }
        this.eli.eli();
    }

    protected void nGm() {
        if (this.eli.aAs.get() && !this.eli.kb && this.eli.bf.getAndSet(false) && (this.eli.wC >= 0 || this.eli.wC == -1)) {
            Message obtain = Message.obtain();
            obtain.what = IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
            obtain.arg1 = this.eli.wC;
            this.eli.jh.sendMessage(obtain);
        }
        if (this.eli.FC <= 0 || !this.eli.CMM.getAndSet(false)) {
            return;
        }
        Message obtain2 = Message.obtain();
        obtain2.what = DescriptorProtos.Edition.EDITION_LEGACY_VALUE;
        obtain2.arg1 = this.eli.FC;
        this.eli.jh.sendMessage(obtain2);
    }

    public void Xb() {
        if (this.eli == null) {
            return;
        }
        this.eli.WfR = false;
        boolean z = this.eli.WfR;
        boolean z2 = this.eli.tGZ;
        if (!this.eli.du.get()) {
            this.eli.ev.Dfc();
        }
        aqO();
        this.eli.qj.bf();
        this.eli.gG.aqO();
        this.eli.CMM.set(true);
        if (this.eli.aAs.get()) {
            this.eli.bf.set(true);
        }
        if (this.eli.GMY != null) {
            this.eli.GMY.DbA();
        }
        this.eli.DbA();
    }

    public void bf() {
        if (this.eli == null) {
            return;
        }
        if (this.eli.eU != null) {
            this.eli.eU.aqO();
        }
        boolean z = this.eli.tGZ;
        this.eli.oWW.eli();
        DeviceUtils.kb();
        this.eli.qj.Xb();
        if (this.eli.tGZ) {
            this.eli.SSo.runOnUiThread(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.reward.DbA.DbA.2
                @Override // java.lang.Runnable
                public void run() {
                    if (DbA.this.eli.oWW.eli() > 0) {
                        DbA.this.eli.oWW.eli(false);
                    }
                }
            });
        }
    }

    public void CMM() {
        if (this.eli.ujq != null) {
            this.eli.ujq.MGA();
        }
        if (this.eli.eU != null) {
            this.eli.eU.nn();
        }
        this.eli.ev.qj();
        if (!ui()) {
            this.eli.aAs.get();
        }
        if (this.eli.qj != null) {
            this.eli.qj.aqO();
        }
        if (this.eli.gG != null) {
            this.eli.gG.kb(com.bytedance.sdk.openadsdk.component.reward.eli.wC.eli);
        }
        if (this.eli.eU != null) {
            this.eli.eU.nlS();
        }
        if (this.eli.cyF != null) {
            this.eli.cyF.Os();
        }
        if (this.eli.GMY != null) {
            this.eli.GMY.Os();
        }
    }

    public void ev() {
        int Fxk;
        if (dV.aGH().Xb(String.valueOf(this.eli.MGA)) == 1) {
            if (this.eli.aGH) {
                if (KM.Os(this.eli.DbA)) {
                    Fxk = dV.aGH().eli(String.valueOf(this.eli.MGA), true);
                } else {
                    Fxk = this.eli.DbA.YO();
                }
            } else if (KM.Os(this.eli.DbA)) {
                Fxk = dV.aGH().eli(String.valueOf(this.eli.MGA), false);
            } else {
                Fxk = this.eli.DbA.Fxk();
            }
            if (this.eli.eU != null && this.eli.eU.FC()) {
                if (this.eli.eU != null) {
                    this.eli.eU.aAs().performClick();
                }
            } else if ((!this.eli.aAs.get() || KM.Os(this.eli.DbA)) && Fxk != -1) {
                if (((this.eli.ev == null || this.eli.ev.NU() < Fxk * 1000) && (this.eli.gG == null || !this.eli.gG.aGH(Fxk))) || this.eli.Cp == null) {
                    return;
                }
                this.eli.Cp.aGH();
            }
        }
    }

    public void Vy() {
        this.eli.Cp.Os();
        this.eli.Cp.ui(true);
    }

    public void gG() {
        this.nlS = this.eli.KM.Os();
    }

    public void ujq() {
        if (!MGA() && ((this instanceof kb) || (this instanceof wC))) {
            this.eli.KM.DbA();
            return;
        }
        if (!this.FC.eli(this.ui.nn(), false)) {
            this.aAs.removeMessages(300);
            if (this.eli.rH && (this.eli.yKf instanceof com.bytedance.sdk.openadsdk.activity.eli)) {
                ((com.bytedance.sdk.openadsdk.activity.eli) this.eli.yKf).gG();
            } else {
                eli(DbA.C0161DbA.eli);
                this.ui.eli(!this.ui.Cp() ? 1 : 0, 4);
            }
        }
        if (this.eli == null || this.eli.DbA == null || this.eli.GMY == null || !this.eli.DbA.nie()) {
            return;
        }
        this.eli.GMY.eli(this.eli.ev.ujq());
    }

    public void eli(int i) {
        this.ui.QX();
        eli(false, true, false, i);
        if (this.eli.aGH) {
            this.FC.eli(10000);
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.nlS.MGA mga) {
        this.Dfc = mga;
        Os();
        if (!this.eli.DbA.Kv() && KM()) {
            Ue();
        }
        if (KM()) {
            this.eli.cyF.DbA();
        }
        if (Xb.aGH(this.eli.DbA) || Xb.ui(this.eli.DbA)) {
            this.aAs.sendEmptyMessageDelayed(500, 100L);
        }
        this.eli.eU.eli(this.eli.mm == 100.0f);
        gG();
        kb();
    }

    public final void Ue() {
        if (this.eli.SSo.isFinishing()) {
            return;
        }
        this.eli.qj.Dfc();
        String str = this.eli.aGH ? "reward_endcard" : "fullscreen_endcard";
        this.eli.qj.eli(this.Dfc, str, this.eli.Uv);
        if (this.eli.Gjg) {
            this.eli.gG.eli(this.Dfc, this.eli.tGZ);
        }
        this.eli.qj.eli(str, this.eli.Uv);
        this.eli.qj.ui();
    }

    public void eli(Message message) {
        com.bytedance.sdk.openadsdk.core.du.aGH eli2;
        int i = message.what;
        int i2 = message.what;
        if (i2 == 1) {
            Vy();
            return;
        }
        if (i2 == 300) {
            if (this.eli.rH && (this.eli.yKf instanceof com.bytedance.sdk.openadsdk.activity.eli)) {
                ((com.bytedance.sdk.openadsdk.activity.eli) this.eli.yKf).gG();
            } else {
                eli(DbA.C0161DbA.DbA);
                this.eli.ev.eli(!this.eli.ev.Cp() ? 1 : 0, 1 ^ (this.eli.ev.Cp() ? 1 : 0));
            }
            com.bytedance.sdk.openadsdk.core.model.aGH UCq = this.eli.DbA.UCq();
            if (UCq != null && (eli2 = UCq.eli()) != null) {
                eli2.eli(com.bytedance.sdk.openadsdk.core.du.eli.eli.GENERAL_LINEAR_AD_ERROR);
            }
            if (this.eli.eU == null || this.eli.eU.Dfc == null) {
                return;
            }
            this.eli.eU.Dfc.aAs();
            return;
        }
        if (i2 == 400) {
            this.eli.ev.QX();
            eli(false, true, false, 3);
            return;
        }
        if (i2 == 500) {
            if (!KM.kb(this.eli.DbA)) {
                this.eli.Cp.Os(false);
            }
            com.bytedance.sdk.component.FC.MGA aAs = this.eli.qj.aAs();
            if (aAs != null && aAs.getWebView() != null) {
                aAs.NU();
                aAs.getWebView().resumeTimers();
            }
            if (this.eli.qj.aAs() != null) {
                this.eli.qj.eli(1.0f);
                this.eli.eU.eli(1.0f);
            }
            if (!this.eli.DbA.Txb() && this.eli.ev.MGA() && this.eli.nGm.get()) {
                this.eli.ev.QX();
                return;
            }
            return;
        }
        if (i2 == 600) {
            Dfc();
            return;
        }
        if (i2 == 700) {
            int i3 = message.arg1;
            if (this.eli.bf.get()) {
                return;
            }
            if (i3 > 0) {
                this.eli.Cp.DbA();
                this.eli.Cp.eli((CharSequence) ((i3 / 1000) + "s"));
                this.eli.Cp.ui(false);
                Message obtain = Message.obtain();
                obtain.what = IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED;
                obtain.arg1 = i3 - 1000;
                com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.eli;
                eliVar.wC -= 1000;
                this.aAs.sendMessageDelayed(obtain, 1000L);
                return;
            }
            this.aAs.removeMessages(IronSourceError.ERROR_NT_LOAD_AFTER_INIT_FAILED);
            if (KM.FC(this.DbA)) {
                if (this.eli.gG.kb() || !this.eli.qj.nGm()) {
                    Dfc();
                    return;
                } else {
                    Vy();
                    return;
                }
            }
            Dfc();
            return;
        }
        if (i2 == 800) {
            if (!KM.kb(this.eli.DbA)) {
                this.eli.Cp.Os(false);
            }
            this.eli.eU.eli(1.0f);
            if (!this.eli.DbA.Txb() && this.eli.ev.MGA() && this.eli.nGm.get()) {
                this.eli.ev.QX();
                return;
            }
            return;
        }
        if (i2 == 900 && !this.eli.CMM.get()) {
            int i4 = message.arg1;
            double cyF = this.eli.ev.cyF();
            eli(i4, (long) (1000.0d * cyF));
            if (i4 > 0) {
                this.eli.Cp.DbA();
                this.eli.Cp.eli((CharSequence) ((i4 / 1000) + "s"));
                this.eli.Cp.ui(false);
                Message obtain2 = Message.obtain();
                obtain2.what = DescriptorProtos.Edition.EDITION_LEGACY_VALUE;
                obtain2.arg1 = i4 - 1000;
                this.eli.FC = obtain2.arg1;
                this.aAs.sendMessageDelayed(obtain2, 1000L);
                if (this.eli.rH && (this.eli.yKf instanceof com.bytedance.sdk.openadsdk.activity.eli) && cyF > 0.0d) {
                    ((com.bytedance.sdk.openadsdk.activity.eli) this.eli.yKf).eli((float) (1.0d - ((i4 / 1000.0f) / cyF)));
                    return;
                }
                return;
            }
            this.aAs.removeMessages(DescriptorProtos.Edition.EDITION_LEGACY_VALUE);
            Dfc();
            com.bytedance.sdk.openadsdk.activity.wC wCVar = this.eli.yKf;
            if (this.eli.rH && (wCVar instanceof com.bytedance.sdk.openadsdk.activity.eli)) {
                wCVar.dZ().eli(wCVar, new DbA.ui(5, this.eli));
            }
        }
    }

    private void eli(long j, long j2) {
        long j3 = j2 - j;
        if (this.eli.SSo instanceof TTRewardVideoActivity) {
            ((TTRewardVideoActivity) this.eli.SSo).DbA(j3, j2);
        } else if (this.eli.Uv instanceof com.bytedance.sdk.openadsdk.activity.kb) {
            ((com.bytedance.sdk.openadsdk.activity.kb) this.eli.Uv).eli(j3, j2);
        }
    }

    static void eli(FrameLayout frameLayout, final com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        final com.bytedance.sdk.openadsdk.core.ui.aGH agh;
        Context context = frameLayout.getContext();
        if (eliVar.DE) {
            com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
            os.setId(aqO.aAs);
            frameLayout.addView(os, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout eli2 = eli(context);
            String str = "";
            if (com.bytedance.sdk.openadsdk.core.model.ev.ui(eliVar.DbA)) {
                com.bykv.vk.openvk.eli.eli.eli.Os.DbA nY = eliVar.DbA.nY();
                if (nY != null) {
                    str = nY.aAs();
                }
            } else {
                List<nGm> an = eliVar.DbA.an();
                if (an != null && !an.isEmpty()) {
                    str = an.get(0).eli();
                }
            }
            if (TextUtils.isEmpty(str)) {
                agh = null;
            } else {
                agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
                agh.setId(aqO.cmk);
                agh.setTag(aqO.cmk, str);
                agh.setScaleType(ImageView.ScaleType.CENTER_CROP);
                eli2.addView(agh);
            }
            os.addView(eli2);
            os.addView(new du(context), new FrameLayout.LayoutParams(-1, -1));
            com.bytedance.sdk.openadsdk.component.reward.view.ui uiVar = new com.bytedance.sdk.openadsdk.component.reward.view.ui(context);
            uiVar.setId(aqO.nlS);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 80;
            frameLayout.addView(uiVar, layoutParams);
            uiVar.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.DbA.DbA.3
                @Override // android.view.View.OnLayoutChangeListener
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    int height = view.getHeight();
                    if (height <= 0) {
                        return;
                    }
                    View findViewById = com.bytedance.sdk.openadsdk.component.reward.eli.eli.this.dZ.findViewById(520093757);
                    if (findViewById != null) {
                        ViewGroup.LayoutParams layoutParams2 = findViewById.getLayoutParams();
                        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams2).bottomMargin = height;
                        }
                    }
                    View findViewById2 = com.bytedance.sdk.openadsdk.component.reward.eli.eli.this.dZ.findViewById(aqO.Zo);
                    if (findViewById2 != null) {
                        ViewGroup.LayoutParams layoutParams3 = findViewById2.getLayoutParams();
                        if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams3).bottomMargin = height;
                        }
                    }
                    View findViewById3 = com.bytedance.sdk.openadsdk.component.reward.eli.eli.this.dZ.findViewById(aqO.f983io);
                    if (findViewById3 != null) {
                        ViewGroup.LayoutParams layoutParams4 = findViewById3.getLayoutParams();
                        if (layoutParams4 instanceof FrameLayout.LayoutParams) {
                            ((FrameLayout.LayoutParams) layoutParams4).bottomMargin = height;
                        }
                    }
                    com.bytedance.sdk.openadsdk.core.ui.aGH agh2 = agh;
                    if (agh2 != null) {
                        ViewGroup.LayoutParams layoutParams5 = agh2.getLayoutParams();
                        if (layoutParams5 instanceof ViewGroup.MarginLayoutParams) {
                            ((ViewGroup.MarginLayoutParams) layoutParams5).bottomMargin = height;
                            agh.setLayoutParams(layoutParams5);
                        }
                    }
                }
            });
            com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
            uiVar2.setId(aqO.NU);
            uiVar2.setOrientation(1);
            uiVar2.setVisibility(8);
            frameLayout.addView(uiVar2, new FrameLayout.LayoutParams(-1, -1));
        }
        if (eliVar.Za) {
            com.bytedance.sdk.component.FC.MGA mga = new com.bytedance.sdk.component.FC.MGA(context, true);
            mga.setId(aqO.nn);
            mga.setLayerType(2, null);
            mga.setVisibility(4);
            frameLayout.addView(mga, new FrameLayout.LayoutParams(-1, -1));
            FrameLayout frameLayout2 = new FrameLayout(context);
            frameLayout2.setId(aqO.Dfc);
            frameLayout2.setVisibility(4);
            frameLayout.addView(frameLayout2, new FrameLayout.LayoutParams(-1, -1));
            if (KM.DbA(eliVar.DbA)) {
                com.bytedance.sdk.openadsdk.core.ui.Os os2 = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
                os2.setId(aqO.OPT);
                os2.setVisibility(4);
                frameLayout.addView(os2, new FrameLayout.LayoutParams(-1, -1));
            }
        }
        com.bytedance.sdk.component.FC.MGA mga2 = new com.bytedance.sdk.component.FC.MGA(context, true);
        mga2.setId(aqO.aqO);
        mga2.setVisibility(8);
        frameLayout.addView(mga2, new FrameLayout.LayoutParams(-1, -1));
    }

    protected static FrameLayout eli(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os.setId(aqO.du);
        os.setBackgroundColor(-16777216);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        os.setLayoutParams(layoutParams);
        return os;
    }
}
