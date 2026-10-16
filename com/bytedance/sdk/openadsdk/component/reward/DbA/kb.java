package com.bytedance.sdk.openadsdk.component.reward.DbA;

import android.app.Activity;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.datastore.preferences.protobuf.DescriptorProtos;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.model.nGm;
import com.bytedance.sdk.openadsdk.utils.aqO;
import com.bytedance.sdk.openadsdk.utils.dZ;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes3.dex */
public class kb extends DbA {
    private final int Dfc;
    private ViewGroup aqO;
    private com.bytedance.sdk.openadsdk.component.reward.view.kb dV;
    private String nGm;

    public kb(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        super(eliVar);
        this.nGm = "fullscreen_interstitial_ad";
        this.Dfc = this.DbA.GR();
    }

    private void VM() {
        FrameLayout.LayoutParams layoutParams;
        FrameLayout frameLayout = new FrameLayout(this.eli.SSo);
        this.aqO = frameLayout;
        frameLayout.setId(aqO.f983io);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        this.aqO.setLayoutParams(layoutParams2);
        View du = this.eli.eU.du();
        if (du != null) {
            layoutParams2.bottomMargin = du.getHeight();
        }
        com.bytedance.sdk.openadsdk.component.reward.view.kb kbVar = new com.bytedance.sdk.openadsdk.component.reward.view.kb(this.eli.SSo);
        this.dV = kbVar;
        kbVar.setId(aqO.ND);
        if (this.eli.DbA.WO() == 1) {
            layoutParams = new FrameLayout.LayoutParams(-1, -2);
        } else {
            layoutParams = new FrameLayout.LayoutParams(-2, -1);
        }
        layoutParams.gravity = 17;
        this.dV.setLayoutParams(layoutParams);
        this.aqO.addView(this.dV);
        GB();
    }

    private void GB() {
        if (this.aqO == null) {
            return;
        }
        eli((View) this.dV);
    }

    private void DbA(ev evVar) {
        if (evVar == null || this.dV == null) {
            return;
        }
        oWW();
        eli((ImageView) this.dV);
    }

    private void oWW() {
        nGm ngm;
        List<nGm> an = this.DbA.an();
        if (an == null || an.size() <= 0 || (ngm = an.get(0)) == null) {
            return;
        }
        try {
            int DbA = ngm.DbA();
            int Os = ngm.Os();
            if (DbA != 0 && Os != 0) {
                this.dV.setRatio(DbA / Os);
                return;
            }
            int i = this.Dfc;
            if (i == 33) {
                this.dV.setRatio(1.0f);
            } else if (i == 3) {
                this.dV.setRatio(1.91f);
            } else {
                this.dV.setRatio(0.56f);
            }
        } catch (Exception e) {
            Xb.Os("TTAD.RFTI", e.getMessage());
        }
    }

    private void eli(ImageView imageView) {
        List<nGm> an;
        nGm ngm;
        if (this.DbA == null || (an = this.DbA.an()) == null || an.size() <= 0 || (ngm = an.get(0)) == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.FC.aGH.eli(an.get(0)).Os(1).eli(com.bytedance.sdk.openadsdk.FC.Os.eli(this.DbA, ngm.eli(), imageView));
    }

    protected void eli(View view) {
        com.bytedance.sdk.openadsdk.core.DbA.DbA dbA;
        if (view == null || this.eli.SSo == null || this.DbA == null) {
            return;
        }
        if (this.nlS == null) {
            Activity activity = this.eli.SSo;
            ev evVar = this.DbA;
            String str = this.nGm;
            dbA = new com.bytedance.sdk.openadsdk.core.DbA.eli(activity, evVar, str, dZ.eli(str));
            dbA.eli(Os(this.DbA));
            HashMap hashMap = new HashMap();
            if (KM.dV(this.DbA)) {
                hashMap.put("click_scence", 3);
            } else {
                hashMap.put("click_scence", 1);
            }
            dbA.eli(hashMap);
        } else {
            dbA = this.nlS;
        }
        if (this.eli.SSo != null) {
            dbA.eli(this.eli.SSo);
        }
        view.setOnTouchListener(dbA);
        view.setOnClickListener(dbA);
    }

    private com.bytedance.sdk.openadsdk.QX.eli.eli.MGA Os(ev evVar) {
        if (evVar.yw() == 4) {
            return new com.bytedance.sdk.openadsdk.QX.eli.eli.aGH(dV.eli(), this.nGm);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void eli(FrameLayout frameLayout) {
        try {
            VM();
            DbA(this.DbA);
            frameLayout.addView(this.aqO);
        } catch (Exception e) {
            Log.e("TTAD.RFTI", "bindAd: ", e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void eli(com.bytedance.sdk.openadsdk.component.reward.view.FC fc) {
        if (com.bytedance.sdk.openadsdk.core.model.Xb.DbA(this.DbA)) {
            aGH.eli(fc, this.DbA);
            this.eli.GMY.eli((long) (this.eli.ev.cyF() * 1000.0d));
        } else if (com.bytedance.sdk.openadsdk.core.model.Xb.aGH(this.DbA) || com.bytedance.sdk.openadsdk.core.model.Xb.ui(this.DbA)) {
            aGH.DbA(fc, this.DbA);
            this.eli.GMY.eli((long) (this.eli.ev.cyF() * 1000.0d));
        } else {
            super.eli(fc);
        }
    }

    public static boolean eli(ev evVar) {
        return !ev.ui(evVar) && evVar.Nvn() == 100.0f;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public boolean ui() {
        return qj() || KM.kb(this.DbA);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public boolean MGA() {
        return qj();
    }

    private boolean qj() {
        return this.DbA != null && this.DbA.BDs() == 2;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void kb() {
        if (com.bytedance.sdk.openadsdk.core.model.Xb.DbA(this.DbA)) {
            this.MGA.DbA(8);
        }
        this.wC.Os(false);
        this.wC.aGH(false);
        if (this.DbA.BDs() == 2) {
            this.wC.eli(false);
            this.MGA.MGA(8);
            return;
        }
        this.wC.eli(this.DbA.iiz());
        if (this.eli.DE) {
            Message obtain = Message.obtain();
            obtain.what = DescriptorProtos.Edition.EDITION_LEGACY_VALUE;
            com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar = this.eli;
            int cyF = (int) (this.eli.ev.cyF() * 1000.0d);
            eliVar.FC = cyF;
            obtain.arg1 = cyF;
            this.eli.jh.sendMessage(obtain);
        }
    }
}
