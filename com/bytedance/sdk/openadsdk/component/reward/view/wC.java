package com.bytedance.sdk.openadsdk.component.reward.view;

import android.view.View;
import com.bytedance.sdk.openadsdk.component.reward.eli.nGm;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public class wC {
    private RFEndCardBackUpLayout DbA;
    private boolean Os;
    private nGm aGH;
    private final com.bytedance.sdk.openadsdk.component.reward.eli.eli eli;
    private boolean ui;

    public wC(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        this.eli = eliVar;
    }

    public void eli() {
        if (this.Os) {
            return;
        }
        this.Os = true;
        RFEndCardBackUpLayout rFEndCardBackUpLayout = (RFEndCardBackUpLayout) this.eli.dZ.findViewById(aqO.MQ);
        this.DbA = rFEndCardBackUpLayout;
        if (rFEndCardBackUpLayout != null) {
            rFEndCardBackUpLayout.init(this.eli);
        }
        if (this.eli.DbA.Kv()) {
            this.aGH = new nGm(this.eli);
        }
    }

    public void eli(com.bytedance.sdk.openadsdk.core.DbA.ui uiVar) {
        RFEndCardBackUpLayout rFEndCardBackUpLayout = this.DbA;
        if (rFEndCardBackUpLayout == null) {
            return;
        }
        SSo.eli(rFEndCardBackUpLayout, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.reward.view.wC.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "TTBaseVideoActivity#mFLEndCardBackupContainer");
        nGm ngm = this.aGH;
        if (ngm != null) {
            ngm.eli(uiVar);
        }
    }

    public void DbA() {
        this.ui = true;
        SSo.eli((View) this.DbA, 0);
    }

    public boolean eli(com.bytedance.sdk.openadsdk.component.reward.eli.aqO aqo) {
        this.ui = true;
        nGm ngm = this.aGH;
        if (ngm == null || !ngm.eli(aqo)) {
            return false;
        }
        SSo.eli((View) this.DbA, 0);
        return true;
    }

    public void Os() {
        nGm ngm = this.aGH;
        if (ngm != null) {
            ngm.eli();
        }
    }

    public void aGH() {
        nGm ngm = this.aGH;
        if (ngm != null) {
            ngm.DbA();
        }
    }

    public void eli(int i) {
        RFEndCardBackUpLayout rFEndCardBackUpLayout = this.DbA;
        if (rFEndCardBackUpLayout == null) {
            return;
        }
        rFEndCardBackUpLayout.setShownAdCount(i);
    }

    public boolean ui() {
        return this.ui;
    }
}
