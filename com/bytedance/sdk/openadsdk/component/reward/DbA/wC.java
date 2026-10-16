package com.bytedance.sdk.openadsdk.component.reward.DbA;

import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.component.reward.DbA.DbA;
import com.bytedance.sdk.openadsdk.core.model.ev;

/* loaded from: classes3.dex */
public class wC extends DbA {
    private com.bytedance.sdk.openadsdk.component.reward.view.Os Dfc;

    public wC(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        super(eliVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void eli(FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.component.reward.view.Os os = new com.bytedance.sdk.openadsdk.component.reward.view.Os(this.eli.SSo, this.du);
        this.Dfc = os;
        os.setDownloadListener(this.nlS);
        this.Dfc.eli(this.DbA, this.eli.mm, this.eli.QI, this.Os, this.aGH);
        frameLayout.addView(this.Dfc.getInteractionStyleRootView());
    }

    public static boolean eli(ev evVar) {
        return (evVar.Txb() || evVar.Nvn() == 100.0f) ? false : true;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public DbA.eli aGH() {
        return new DbA.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.DbA.wC.1
            @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA.eli
            public void eli(boolean z) {
                if (wC.this.Dfc != null) {
                    wC.this.Dfc.setIsMute(z);
                }
            }
        };
    }

    public FrameLayout VM() {
        com.bytedance.sdk.openadsdk.component.reward.view.Os os = this.Dfc;
        if (os != null) {
            return os.getVideoContainer();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public boolean ui() {
        return GB();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public boolean MGA() {
        return GB();
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void kb() {
        this.MGA.aGH(8);
        this.MGA.DbA(8);
        if (this.DbA.BDs() == 2) {
            this.wC.eli(false);
            this.wC.Os(false);
            this.wC.aGH(false);
            this.MGA.MGA(8);
            return;
        }
        this.wC.eli(this.DbA.iiz());
        this.wC.Os(GB());
        this.wC.aGH(GB());
        if (GB()) {
            this.MGA.MGA(8);
        } else {
            this.wC.ui();
            this.MGA.MGA(0);
        }
    }

    private boolean GB() {
        return ev.ui(this.DbA);
    }
}
