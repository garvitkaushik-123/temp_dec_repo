package com.bytedance.sdk.openadsdk.core.wC;

import android.content.Context;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class aqO extends com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA implements View.OnClickListener {
    private boolean dV;

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA
    protected void eli(boolean z) {
    }

    public aqO(Context context, com.bytedance.sdk.openadsdk.core.model.ev evVar, String str, com.bytedance.sdk.openadsdk.aGH.kb kbVar, boolean z) {
        super(context, evVar, false, str, false, false, kbVar);
        this.dV = false;
        setOnClickListener(this);
        setNeedNativeVideoPlayBtnVisible(false);
        setNeedSelfManagerVideo(!z);
    }

    public void eli(int i, int i2) {
        if (this.DbA != null) {
            this.DbA.DbA(i, i2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA
    protected void DbA() {
        if (!this.ui || !Vy.DbA(this.nlS)) {
            this.aGH = false;
        }
        super.DbA();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA
    protected void Os() {
        if (this.dV) {
            super.Os();
        }
    }

    public void setCanInterruptVideoPlay(boolean z) {
        this.dV = z;
    }

    public void setShouldCheckNetChange(boolean z) {
        if (this.DbA != null) {
            this.DbA.ui(z);
        }
    }

    public void aGH() {
        if (this.aAs != null) {
            SSo.eli((View) this.aAs, 8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        if (this.FC != null && this.FC.getVisibility() == 0) {
            QX();
        } else {
            super.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nlS.DbA.MGA, android.view.View
    public void onWindowFocusChanged(boolean z) {
        if (this.FC != null && this.FC.getVisibility() == 0) {
            QX();
        } else {
            super.onWindowFocusChanged(z);
        }
    }

    private void nGm() {
        SSo.eli((View) this.kb, 0);
        SSo.eli((View) this.wC, 0);
        SSo.eli((View) this.aAs, 8);
    }

    private void QX() {
        kb();
        if (this.kb != null) {
            if (this.kb.getVisibility() == 0) {
                return;
            } else {
                com.bytedance.sdk.openadsdk.nGm.DbA.DbA().eli(this.eli.nY().aAs(), this.eli.nY().Os(), this.eli.nY().DbA(), this.wC, this.eli);
            }
        }
        nGm();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.FC != null && this.FC.getVisibility() == 0) {
            SSo.ui(this.kb);
        }
        Os();
    }

    public void setShowAdInteractionView(boolean z) {
        com.bytedance.sdk.openadsdk.core.nlS.DbA.ui bf;
        if (this.DbA == null || (bf = this.DbA.nlS()) == null) {
            return;
        }
        bf.eli(z);
    }

    protected void ui() {
        kb();
        SSo.eli((View) this.kb, 0);
    }
}
