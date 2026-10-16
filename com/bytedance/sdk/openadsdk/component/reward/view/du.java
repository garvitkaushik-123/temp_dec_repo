package com.bytedance.sdk.openadsdk.component.reward.view;

import android.graphics.Color;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public class du extends nlS {
    @Override // com.bytedance.sdk.openadsdk.component.reward.view.nlS
    protected boolean eli() {
        return false;
    }

    public du(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        super(eliVar);
    }

    @Override // com.bytedance.sdk.openadsdk.component.reward.view.nlS
    public void eli(int i, int i2) {
        super.eli(i, i2);
        if (ev.ui(this.aGH) && this.aGH.Ca() == 3 && this.aGH.rn() == 0) {
            try {
                FrameLayout frameLayout = (FrameLayout) this.Os.dZ.findViewById(aqO.aAs);
                frameLayout.setBackgroundColor(Color.parseColor("#000000"));
                if (this.aGH.WO() == 1) {
                    int DbA = SSo.DbA(dV.eli(), 90.0f);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout.getLayoutParams();
                    layoutParams.bottomMargin = DbA;
                    frameLayout.setLayoutParams(layoutParams);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
