package com.bytedance.sdk.openadsdk.core.wC;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.activity.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.KM;
import com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dZ;

/* loaded from: classes3.dex */
public abstract class eli extends com.bytedance.sdk.openadsdk.core.ui.Os {
    protected Context DbA;
    protected int FC;
    protected String MGA;
    protected com.bytedance.sdk.openadsdk.core.model.ev Os;
    protected boolean aAs;
    protected com.bytedance.sdk.openadsdk.Os.Os aGH;
    protected boolean du;
    private com.bytedance.sdk.openadsdk.aGH.kb eli;
    protected int kb;
    protected String nlS;
    protected TTDislikeDialogAbstract ui;
    protected int wC;

    protected abstract void eli(View view, int i, com.bytedance.sdk.openadsdk.core.model.aqO aqo);

    public eli(Context context) {
        super(context);
        this.MGA = "embeded_ad";
        this.aAs = true;
        this.du = true;
        setTag("tt_express_backup_fl_tag_26");
    }

    public eli(Context context, String str) {
        super(context);
        this.MGA = "embeded_ad";
        this.aAs = true;
        this.du = true;
        this.nlS = str;
        setTag("tt_express_backup_fl_tag_26");
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setDislikeInner(KM km) {
        if (km instanceof com.bytedance.sdk.openadsdk.Os.Os) {
            this.aGH = (com.bytedance.sdk.openadsdk.Os.Os) km;
        }
    }

    public void setDislikeOuter(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.sdk.openadsdk.core.model.ev evVar;
        if (tTDislikeDialogAbstract != null && (evVar = this.Os) != null) {
            tTDislikeDialogAbstract.setMaterialMeta(evVar.eu(), this.Os.mS());
        }
        this.ui = tTDislikeDialogAbstract;
    }

    public void eli() {
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.ui;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.show();
            return;
        }
        com.bytedance.sdk.openadsdk.Os.Os os = this.aGH;
        if (os != null) {
            os.eli();
        } else {
            TTDelegateActivity.eli(this.Os, (String) null);
        }
    }

    protected String getNameOrSource() {
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.Os;
        if (evVar == null) {
            return "";
        }
        if (evVar.pu() == null || TextUtils.isEmpty(this.Os.pu().DbA())) {
            return !TextUtils.isEmpty(this.Os.kEI()) ? this.Os.kEI() : "";
        }
        return this.Os.pu().DbA();
    }

    protected String getTitle() {
        if (this.Os.pu() != null && !TextUtils.isEmpty(this.Os.pu().DbA())) {
            return this.Os.pu().DbA();
        }
        if (!TextUtils.isEmpty(this.Os.kEI())) {
            return this.Os.kEI();
        }
        if (!TextUtils.isEmpty(this.Os.Pf())) {
            return this.Os.Pf();
        }
        return "";
    }

    protected String getDescription() {
        if (!TextUtils.isEmpty(this.Os.Pf())) {
            return this.Os.Pf();
        }
        if (!TextUtils.isEmpty(this.Os.bU())) {
            return this.Os.bU();
        }
        return "";
    }

    public float getRealWidth() {
        return SSo.Os(this.DbA, this.kb);
    }

    public float getRealHeight() {
        return SSo.Os(this.DbA, this.wC);
    }

    protected void eli(View view, boolean z) {
        com.bytedance.sdk.openadsdk.core.DbA.DbA dbA;
        if (view == null) {
            return;
        }
        if (z) {
            Context context = this.DbA;
            com.bytedance.sdk.openadsdk.core.model.ev evVar = this.Os;
            String str = this.MGA;
            dbA = new com.bytedance.sdk.openadsdk.core.DbA.eli(context, evVar, str, dZ.eli(str));
        } else {
            Context context2 = this.DbA;
            com.bytedance.sdk.openadsdk.core.model.ev evVar2 = this.Os;
            String str2 = this.MGA;
            dbA = new com.bytedance.sdk.openadsdk.core.DbA.DbA(context2, evVar2, str2, dZ.eli(str2));
        }
        view.setOnTouchListener(dbA);
        view.setOnClickListener(dbA);
        dbA.eli(new DbA() { // from class: com.bytedance.sdk.openadsdk.core.wC.eli.1
            @Override // com.bytedance.sdk.openadsdk.core.wC.DbA
            public void eli(View view2, int i, com.bytedance.sdk.openadsdk.core.model.aqO aqo) {
                eli.this.eli(view2, i, aqo);
            }
        });
    }

    protected com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA getVideoView() {
        com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA mga;
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.Os;
        if (evVar != null && this.DbA != null) {
            if (com.bytedance.sdk.openadsdk.core.model.ev.ui(evVar)) {
                try {
                    mga = new com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA(this.DbA, this.Os, this.MGA, true, false, this.eli);
                    mga.setVideoCacheUrl(this.nlS);
                    mga.setControllerStatusCallBack(new MGA.DbA() { // from class: com.bytedance.sdk.openadsdk.core.wC.eli.2
                        @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA.DbA
                        public void eli(boolean z, long j, long j2, long j3, boolean z2) {
                        }
                    });
                    mga.setIsAutoPlay(this.aAs);
                    mga.eli(this.du, "bannerGetVideoView");
                } catch (Throwable unused) {
                }
                if (!com.bytedance.sdk.openadsdk.core.model.ev.ui(this.Os) && mga != null && mga.eli(0L, true, false)) {
                    return mga;
                }
            }
            mga = null;
            if (!com.bytedance.sdk.openadsdk.core.model.ev.ui(this.Os)) {
            }
        }
        return null;
    }

    protected void eli(int i) {
        this.du = com.bytedance.sdk.openadsdk.core.dV.aGH().DbA(String.valueOf(this.FC));
        int DbA = com.bytedance.sdk.openadsdk.core.dV.aGH().DbA(i);
        if (3 == DbA) {
            this.aAs = false;
            return;
        }
        int Os = com.bytedance.sdk.component.utils.nGm.Os(com.bytedance.sdk.openadsdk.core.dV.eli());
        if (1 != DbA || !dZ.aGH(Os)) {
            if (2 == DbA) {
                if (dZ.ui(Os) || dZ.aGH(Os) || dZ.MGA(Os)) {
                    this.aAs = true;
                    return;
                }
                return;
            }
            if (5 != DbA) {
                return;
            }
            if (!dZ.aGH(Os) && !dZ.MGA(Os)) {
                return;
            }
        }
        this.aAs = true;
    }

    protected void eli(View view) {
        com.bytedance.sdk.openadsdk.core.model.ev evVar = this.Os;
        if (evVar == null || evVar.nY() == null || view == null) {
            return;
        }
        eli(view, this.Os.GMY() == 1 && this.aAs);
    }
}
