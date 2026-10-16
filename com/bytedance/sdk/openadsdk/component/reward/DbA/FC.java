package com.bytedance.sdk.openadsdk.component.reward.DbA;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.model.KM;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;

/* loaded from: classes3.dex */
public class FC extends DbA {
    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public boolean MGA() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void eli(FrameLayout frameLayout) {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void kb() {
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public boolean ui() {
        return true;
    }

    public FC(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        super(eliVar);
    }

    public static boolean eli(ev evVar) {
        return KM.kb(evVar) || KM.dV(evVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void dV() {
        if (KM.wC(this.DbA) && this.eli.qj.dZ() && !this.eli.qj.FS()) {
            nGm();
        }
        if (KM.kb(this.eli.DbA)) {
            if (DeviceUtils.kb() == 0) {
                this.eli.tGZ = true;
            }
            if (this.eli.tGZ) {
                this.eli.Cp.DbA(true);
                this.eli.gG.ui(true);
            }
        }
        this.eli.GMY.eli();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void QX() {
        if (this.eli.gG.wC(com.bytedance.sdk.openadsdk.component.reward.eli.wC.Os) && KM.dV(this.eli.DbA)) {
            this.eli.gG.Os("return_foreground");
            if ((this.NU == null || !this.NU.isShowing()) && this.eli.gG.DbA() >= 0.0f) {
                this.eli.gG.ui(0);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void Xb() {
        super.Xb();
        if (KM.dV(this.eli.DbA)) {
            this.aAs.removeMessages(600);
            this.eli.gG.Os("go_background");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void bf() {
        super.bf();
        if (KM.dV(this.eli.DbA)) {
            this.aAs.removeMessages(600);
            this.eli.gG.Os("go_background");
        }
    }
}
