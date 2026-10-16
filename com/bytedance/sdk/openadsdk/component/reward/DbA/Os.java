package com.bytedance.sdk.openadsdk.component.reward.DbA;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.model.Xb;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public class Os extends DbA {
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
        return false;
    }

    public Os(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        super(eliVar);
    }

    public static boolean eli(ev evVar) {
        new Object[]{"match type:", Boolean.valueOf(Xb.Os(evVar))};
        return Xb.Os(evVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.DbA.DbA
    public void eli(com.bytedance.sdk.openadsdk.component.reward.view.FC fc) {
        DbA(fc);
    }

    private void DbA(com.bytedance.sdk.openadsdk.component.reward.view.FC fc) {
        if (fc == null) {
            return;
        }
        Context context = fc.getContext();
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setOrientation(1);
        fc.addView(uiVar, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os.setId(aqO.nro);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        layoutParams.weight = 100.0f;
        uiVar.addView(os, layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.Os os2 = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os2.setId(aqO.aAs);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        os.addView(os2, layoutParams2);
        os2.addView(eli(context));
        if (this.DbA.GR() != 3 && this.DbA.GR() != 5) {
            com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
            agh.setId(aqO.ikx);
            agh.setVisibility(8);
            agh.setBackground(com.bytedance.sdk.openadsdk.core.widget.aGH.eli());
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(SSo.DbA(context, 28.0f), SSo.DbA(context, 28.0f));
            layoutParams3.gravity = 8388693;
            layoutParams3.rightMargin = SSo.DbA(context, 20.0f);
            layoutParams3.bottomMargin = SSo.DbA(context, 10.0f);
            os.addView(agh, layoutParams3);
        }
        com.bytedance.sdk.openadsdk.core.ui.Os os3 = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os3.setId(aqO.Xb);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams4.weight = 0.0f;
        uiVar.addView(os3, layoutParams4);
        os3.addView(aGH.eli(context, this.eli.DbA));
        com.bytedance.sdk.openadsdk.component.reward.view.MGA.eli(os3, this.DbA);
        com.bytedance.sdk.openadsdk.component.reward.view.MGA.eli(os);
    }
}
