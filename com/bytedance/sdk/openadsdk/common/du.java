package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class du {
    protected Context DbA;
    private com.bytedance.sdk.openadsdk.core.widget.wC Os;
    private com.bytedance.sdk.openadsdk.core.widget.dV aGH;
    protected View eli = ui();
    private com.bytedance.sdk.openadsdk.core.ui.wC ui;

    public du(Context context) {
        this.DbA = context;
    }

    public View eli() {
        return this.eli;
    }

    public com.bytedance.sdk.openadsdk.core.widget.dV DbA() {
        return this.aGH;
    }

    public com.bytedance.sdk.openadsdk.core.ui.wC Os() {
        return this.ui;
    }

    private View ui() {
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(this.DbA);
        uiVar.setGravity(1);
        uiVar.setOrientation(1);
        com.bytedance.sdk.openadsdk.core.widget.dV dVVar = new com.bytedance.sdk.openadsdk.core.widget.dV(this.DbA);
        this.aGH = dVVar;
        dVVar.setId(520093745);
        int DbA = SSo.DbA(this.DbA, 64.0f);
        uiVar.addView(this.aGH, new LinearLayout.LayoutParams(DbA, DbA));
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(this.DbA);
        this.ui = wCVar;
        wCVar.setId(520093746);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(SSo.DbA(this.DbA, 219.0f), -2);
        layoutParams.topMargin = SSo.DbA(this.DbA, 16.0f);
        this.ui.setLayoutParams(layoutParams);
        this.ui.setEllipsize(TextUtils.TruncateAt.END);
        this.ui.setGravity(17);
        this.ui.setMaxWidth(SSo.DbA(this.DbA, 150.0f));
        this.ui.setMaxLines(2);
        this.ui.setTextColor(-1);
        this.ui.setTextSize(1, 16.0f);
        uiVar.addView(this.ui);
        this.Os = new com.bytedance.sdk.openadsdk.core.widget.wC(this.DbA);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(SSo.DbA(this.DbA, 219.0f), SSo.DbA(this.DbA, 6.0f));
        layoutParams2.topMargin = SSo.DbA(this.DbA, 32.0f);
        uiVar.addView(this.Os, layoutParams2);
        return uiVar;
    }

    public void eli(int i) {
        this.Os.setProgress(i);
    }

    public void aGH() {
        this.eli = null;
        this.DbA = null;
    }
}
