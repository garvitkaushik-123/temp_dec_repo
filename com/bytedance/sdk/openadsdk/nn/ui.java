package com.bytedance.sdk.openadsdk.nn;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public class ui extends aAs {
    private com.bytedance.sdk.openadsdk.core.ui.aGH kb;
    private com.bytedance.sdk.openadsdk.core.ui.wC wC;

    public ui(Context context) {
        this(context, null);
    }

    public ui(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ui(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // com.bytedance.sdk.openadsdk.nn.aAs
    protected void eli(Context context) {
        int DbA = SSo.DbA(context, 6.0f);
        setPadding(DbA, DbA, DbA, DbA);
        this.eli = ui(context);
        this.eli.setId(aqO.QW);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        int DbA2 = SSo.DbA(context, 26.0f);
        layoutParams.topMargin = DbA2;
        this.eli.setLayoutParams(layoutParams);
        addView(this.eli);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        this.kb = agh;
        agh.setId(aqO.nY);
        this.kb.setScaleType(ImageView.ScaleType.FIT_CENTER);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.topMargin = DbA2;
        this.kb.setLayoutParams(layoutParams2);
        addView(this.kb);
        PAGLogoView wC = wC(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 80;
        int DbA3 = SSo.DbA(context, 10.0f);
        layoutParams3.leftMargin = DbA3;
        layoutParams3.topMargin = DbA3;
        layoutParams3.bottomMargin = DbA3;
        wC.setLayoutParams(layoutParams3);
        addView(wC);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        uiVar.setOrientation(0);
        uiVar.setGravity(17);
        addView(uiVar);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.wC = wCVar;
        wCVar.setId(aqO.kEI);
        this.wC.setEllipsize(TextUtils.TruncateAt.END);
        this.wC.setMaxLines(1);
        this.wC.setTextColor(-1);
        this.wC.setTextSize(2, 12.0f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(0, -2);
        layoutParams4.weight = 1.0f;
        this.wC.setLayoutParams(layoutParams4);
        uiVar.addView(this.wC);
    }

    public com.bytedance.sdk.openadsdk.core.ui.aGH getTtBuImg() {
        return this.kb;
    }

    public com.bytedance.sdk.openadsdk.core.ui.wC getTtBuDescTV() {
        return this.wC;
    }
}
