package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class NU {
    com.bytedance.sdk.component.adexpress.dynamic.aGH DbA;
    private boolean MGA;
    private final Activity Os;
    private final eli aGH;
    com.bytedance.sdk.openadsdk.component.reward.top.Os eli;
    private boolean ui = false;

    public NU(eli eliVar) {
        this.Os = eliVar.SSo;
        this.aGH = eliVar;
    }

    public void eli() {
        if (this.ui) {
            return;
        }
        this.ui = true;
        if (this.aGH.Ca != null) {
            this.eli = this.aGH.Ca;
            this.MGA = true;
        } else {
            this.eli = (com.bytedance.sdk.openadsdk.component.reward.top.Os) this.aGH.dZ.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.nW);
        }
        com.bytedance.sdk.openadsdk.component.reward.top.Os os = this.eli;
        if (os != null) {
            os.eli(this.aGH.DbA);
            if (this.aGH.DbA.Kv()) {
                eli(false);
            } else {
                eli(this.aGH.DbA.iiz());
            }
        }
    }

    public void eli(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os;
        if (this.MGA || (os = this.eli) == null) {
            return;
        }
        os.setShowDislike(z);
    }

    public void DbA(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os = this.eli;
        if (os != null) {
            os.setSoundMute(z);
        }
        com.bytedance.sdk.component.adexpress.dynamic.aGH agh = this.DbA;
        if (agh != null) {
            agh.setSoundMute(z);
        }
    }

    public void Os(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os;
        if (this.MGA || (os = this.eli) == null) {
            return;
        }
        os.setShowSound(z);
    }

    public void aGH(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os;
        if (this.MGA || (os = this.eli) == null) {
            return;
        }
        os.setShowSkip(z);
    }

    public void eli(String str, CharSequence charSequence) {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os;
        if (this.MGA || (os = this.eli) == null) {
            return;
        }
        os.setTime(String.valueOf(str), charSequence);
    }

    public void eli(CharSequence charSequence) {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os;
        if (this.MGA || (os = this.eli) == null) {
            return;
        }
        os.setSkipText(charSequence);
    }

    public void DbA() {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os;
        if (this.MGA || (os = this.eli) == null) {
            return;
        }
        os.showCountDownText();
    }

    public void ui(boolean z) {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os;
        if (this.MGA || (os = this.eli) == null) {
            return;
        }
        os.setSkipEnable(z);
    }

    public void Os() {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os;
        if (this.MGA || (os = this.eli) == null) {
            return;
        }
        os.showSkipButton();
    }

    public void aGH() {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os = this.eli;
        if (os != null) {
            os.clickSkip();
        }
    }

    public void eli(String str) {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os = this.eli;
        if (os != null) {
            os.clickSound(str);
        }
    }

    public void ui() {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os;
        if (this.MGA || (os = this.eli) == null) {
            return;
        }
        os.setSkipInvisiable();
    }

    public void eli(com.bytedance.sdk.openadsdk.component.reward.top.DbA dbA) {
        com.bytedance.sdk.openadsdk.component.reward.top.Os os = this.eli;
        if (os != null) {
            os.setListener(dbA);
        }
    }

    public void eli(com.bytedance.sdk.component.adexpress.dynamic.aGH agh) {
        this.DbA = agh;
    }

    public void eli(int i) {
        View findViewById;
        com.bytedance.sdk.openadsdk.component.reward.top.Os os = this.eli;
        if (os == null || os.getITopLayout() == null || i == 0 || (findViewById = this.eli.getITopLayout().findViewById(520093713)) == null || !(findViewById.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) || findViewById.getWidth() <= 0 || findViewById.getVisibility() != 0) {
            return;
        }
        int[] iArr = new int[2];
        findViewById.getLocationOnScreen(iArr);
        int width = i - (iArr[0] + findViewById.getWidth());
        if (width < SSo.DbA(this.Os, 16.0f)) {
            ((ViewGroup.MarginLayoutParams) findViewById.getLayoutParams()).rightMargin += SSo.DbA(this.Os, 16.0f) - width;
            findViewById.requestLayout();
        }
    }
}
