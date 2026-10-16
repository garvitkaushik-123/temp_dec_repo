package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class PAGLogoView extends LinearLayout {
    protected int containerHeight;
    private com.bytedance.sdk.openadsdk.core.ui.aGH mAdLogo;
    private com.bytedance.sdk.openadsdk.core.ui.wC mAdText;

    public PAGLogoView(Context context) {
        this(context, null);
    }

    public PAGLogoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PAGLogoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initView(context);
    }

    public PAGLogoView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        initView(context);
    }

    private void initView(Context context) {
        int DbA = SSo.DbA(context, 2.0f);
        this.containerHeight = SSo.DbA(getContext(), 12.0f);
        this.mAdLogo = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(SSo.DbA(context, 14.0f), SSo.DbA(context, 6.0f));
        layoutParams.leftMargin = DbA;
        this.mAdLogo.setLayoutParams(layoutParams);
        this.mAdLogo.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.mAdText = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, this.containerHeight);
        layoutParams2.leftMargin = DbA;
        layoutParams2.rightMargin = DbA;
        this.mAdText.setLayoutParams(layoutParams2);
        this.mAdText.setTextSize(1, 8.0f);
        this.mAdText.setGravity(17);
        this.mAdText.setTextColor(Color.parseColor("#BFFFFFFF"));
        addView(this.mAdLogo);
        addView(this.mAdText);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.parseColor("#26000000"));
        gradientDrawable.setCornerRadius(DbA);
        setBackground(gradientDrawable);
        setGravity(16);
    }

    public static PAGLogoView createPAGLogoViewByMaterial(Context context, ev evVar) {
        PAGLogoView pAGLogoView = new PAGLogoView(context);
        pAGLogoView.initData(evVar);
        return pAGLogoView;
    }

    public void initData(ev evVar) {
        if (evVar == null) {
            return;
        }
        initData(evVar.EM());
    }

    public void initData(com.bytedance.sdk.openadsdk.core.model.DbA dbA) {
        if (dbA == null) {
            return;
        }
        if (dbA.ui()) {
            this.mAdLogo.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(com.bytedance.sdk.openadsdk.core.dV.eli(), "tt_ad_logo"));
        } else {
            String eli = dbA.eli();
            if (TextUtils.isEmpty(eli)) {
                this.mAdLogo.setVisibility(8);
            } else {
                if (eli.contains("logo")) {
                    this.mAdLogo.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(com.bytedance.sdk.openadsdk.core.dV.eli(), "tt_ad_logo"));
                } else {
                    com.bytedance.sdk.openadsdk.FC.aGH.eli(eli).Os(1).eli(this.mAdLogo);
                }
                this.mAdLogo.setVisibility(0);
            }
        }
        String DbA = dbA.DbA();
        if (dbA.ui()) {
            this.mAdText.setText(com.bytedance.sdk.component.utils.ev.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), "tt_logo_en"));
        } else if (TextUtils.isEmpty(DbA)) {
            this.mAdText.setVisibility(8);
        } else {
            this.mAdText.setText(DbA);
            this.mAdText.setVisibility(0);
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.height = this.containerHeight;
        super.setLayoutParams(com.bytedance.sdk.openadsdk.core.ui.FC.eli(this, layoutParams));
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
