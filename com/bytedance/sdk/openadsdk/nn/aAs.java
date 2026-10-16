package com.bytedance.sdk.openadsdk.nn;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.dV;

/* loaded from: classes3.dex */
public abstract class aAs extends com.bytedance.sdk.openadsdk.core.ui.Os {
    protected com.bytedance.sdk.openadsdk.core.ui.aGH DbA;
    protected com.bytedance.sdk.openadsdk.core.ui.wC MGA;
    protected dV Os;
    protected com.bytedance.sdk.openadsdk.core.ui.wC aGH;
    protected com.bytedance.sdk.openadsdk.core.ui.Os eli;
    protected com.bytedance.sdk.openadsdk.core.ui.wC ui;

    protected abstract void eli(Context context);

    public aAs(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        eli(context);
    }

    public FrameLayout getTtAdContainer() {
        return this.eli;
    }

    public ImageView getTtFullImg() {
        return this.DbA;
    }

    public dV getTtFullAdIcon() {
        return this.Os;
    }

    public TextView getTtFullAdAppName() {
        return this.aGH;
    }

    public TextView getTtFullAdDesc() {
        return this.ui;
    }

    public TextView getTtFullAdDownload() {
        return this.MGA;
    }

    protected com.bytedance.sdk.openadsdk.core.ui.Os ui(Context context) {
        return new com.bytedance.sdk.openadsdk.core.ui.Os(context);
    }

    protected com.bytedance.sdk.openadsdk.core.ui.aGH MGA(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return agh;
    }

    protected dV kb(Context context) {
        dV dVVar = new dV(context);
        dVVar.setScaleType(ImageView.ScaleType.FIT_XY);
        dVVar.setBackgroundColor(0);
        return dVVar;
    }

    protected com.bytedance.sdk.openadsdk.core.ui.wC DbA(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        wCVar.setMaxLines(1);
        wCVar.setTextColor(Color.parseColor("#FF999999"));
        wCVar.setTextSize(2, 16.0f);
        return wCVar;
    }

    protected com.bytedance.sdk.openadsdk.core.ui.wC Os(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar.setEllipsize(TextUtils.TruncateAt.END);
        wCVar.setMaxLines(1);
        wCVar.setSingleLine();
        wCVar.setTextColor(Color.parseColor("#FF999999"));
        wCVar.setTextSize(2, 12.0f);
        return wCVar;
    }

    protected com.bytedance.sdk.openadsdk.core.ui.wC aGH(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_backup_btn_1"));
        wCVar.setGravity(17);
        wCVar.setText(ev.eli(context, "tt_video_download_apk"));
        wCVar.setTextColor(-1);
        wCVar.setTextSize(2, 14.0f);
        return wCVar;
    }

    protected PAGLogoView wC(Context context) {
        PAGLogoView pAGLogoView = new PAGLogoView(context);
        pAGLogoView.setId(520093739);
        return pAGLogoView;
    }
}
