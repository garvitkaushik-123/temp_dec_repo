package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.KM;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class kb extends com.bytedance.sdk.openadsdk.core.ui.kb {
    private com.bytedance.sdk.openadsdk.core.ui.wC DbA;
    private boolean MGA;
    private wC Os;
    private com.bytedance.sdk.openadsdk.core.ui.wC aGH;
    private dV eli;
    private boolean ui;

    protected boolean eli() {
        return true;
    }

    public kb(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (eli()) {
            DbA();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void eli(ev evVar, int i) {
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar;
        if (!this.ui || evVar == null || this.MGA) {
            return;
        }
        this.MGA = true;
        boolean OJ = evVar.OJ();
        if (!OJ && evVar.SjY() != null && !TextUtils.isEmpty(evVar.SjY().eli())) {
            try {
                com.bytedance.sdk.openadsdk.FC.aGH.eli(evVar.SjY()).Os(1).eli(new com.bytedance.sdk.openadsdk.FC.DbA(evVar, evVar.SjY().eli(), new KM(this.eli)));
            } catch (Throwable unused) {
            }
            if (!OJ) {
                this.DbA.setText("Loading");
            } else if (!TextUtils.isEmpty(evVar.Pf())) {
                this.DbA.setText(evVar.Pf());
            } else {
                this.DbA.setVisibility(8);
            }
            wCVar = this.aGH;
            if (wCVar == null) {
                wCVar.setText(evVar.GMu());
                return;
            }
            return;
        }
        this.eli.setVisibility(8);
        if (!OJ) {
        }
        wCVar = this.aGH;
        if (wCVar == null) {
        }
    }

    public void DbA() {
        if (this.ui) {
            return;
        }
        this.ui = true;
        Context context = getContext();
        setBackgroundColor(Color.parseColor("#2E2E2E"));
        LinearLayout linearLayout = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        dV dVVar = new dV(context);
        this.eli = dVVar;
        dVVar.setId(520093745);
        int DbA = SSo.DbA(context, 64.0f);
        this.eli.setLayoutParams(new RelativeLayout.LayoutParams(DbA, DbA));
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.DbA = wCVar;
        wCVar.setId(520093746);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(SSo.DbA(context, 219.0f), -2);
        layoutParams2.topMargin = SSo.DbA(context, 16.0f);
        this.DbA.setLayoutParams(layoutParams2);
        this.DbA.setEllipsize(TextUtils.TruncateAt.END);
        this.DbA.setGravity(17);
        this.DbA.setMaxWidth(SSo.DbA(context, 150.0f));
        this.DbA.setMaxLines(2);
        this.DbA.setTextColor(-1);
        this.DbA.setTextSize(1, 16.0f);
        wC wCVar2 = new wC(context);
        this.Os = wCVar2;
        wCVar2.setId(520093748);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(SSo.DbA(context, 219.0f), SSo.DbA(context, 6.0f));
        layoutParams3.topMargin = SSo.DbA(context, 24.0f);
        this.Os.setLayoutParams(layoutParams3);
        this.aGH = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(SSo.DbA(context, 138.0f), SSo.DbA(context, 42.0f));
        layoutParams4.topMargin = SSo.DbA(context, 48.0f);
        this.aGH.setLayoutParams(layoutParams4);
        this.aGH.setTextColor(-1);
        this.aGH.setTextSize(16.0f);
        this.aGH.setGravity(17);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setStroke(2, -1);
        gradientDrawable.setCornerRadius(layoutParams4.height / 2);
        this.aGH.setBackground(gradientDrawable);
        linearLayout.addView(this.eli);
        linearLayout.addView(this.DbA);
        linearLayout.addView(this.Os);
        linearLayout.addView(this.aGH);
        addView(linearLayout);
    }

    public wC getLoadingProgressBar() {
        return this.Os;
    }

    public com.bytedance.sdk.openadsdk.core.ui.wC getDownloadButton() {
        return this.aGH;
    }

    public void setProgress(int i) {
        wC wCVar = this.Os;
        if (wCVar != null) {
            wCVar.setProgress(i);
        }
    }
}
