package com.bytedance.sdk.openadsdk.component.FC;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.wC.ui;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.aqO;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class ui extends Os {
    eli NU;

    public interface eli {
        void eli(View view, int i);
    }

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public com.bytedance.sdk.openadsdk.core.ui.aGH getAdIconView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public com.bytedance.sdk.openadsdk.core.ui.wC getAdTitleTextView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public aqO getScoreBar() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.FC.Os
    public View getUserInfo() {
        return null;
    }

    public ui(Context context, ev evVar) {
        super(context);
        eli(context, evVar);
    }

    private void eli(Context context, ev evVar) {
        com.bytedance.sdk.openadsdk.core.wC.ui uiVar = new com.bytedance.sdk.openadsdk.core.wC.ui(context);
        com.bytedance.sdk.openadsdk.core.wC.aGH.eli().Os(uiVar);
        uiVar.eli(evVar, new ui.DbA() { // from class: com.bytedance.sdk.openadsdk.component.FC.ui.1
            @Override // com.bytedance.sdk.openadsdk.core.wC.ui.DbA
            public void eli(int i, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.ui.DbA
            public void k_() {
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.ui.DbA
            public View eli() {
                if (ui.this.wC != null) {
                    return ui.this.wC.getTopDislike();
                }
                return null;
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.ui.DbA
            public View DbA() {
                return ui.this;
            }

            @Override // com.bytedance.sdk.openadsdk.core.wC.ui.DbA
            public void eli(View view, int i) {
                if (ui.this.NU != null) {
                    ui.this.NU.eli(view, i);
                }
            }
        }, "open_ad");
        addView(uiVar, new ViewGroup.LayoutParams(-1, -1));
        uiVar.Xb();
        int DbA = SSo.DbA(context, 9.0f);
        int DbA2 = SSo.DbA(context, 10.0f);
        this.aGH = PAGLogoView.createPAGLogoViewByMaterial(context, evVar);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, SSo.DbA(context, 14.0f));
        layoutParams.leftMargin = DbA2;
        layoutParams.bottomMargin = DbA2;
        layoutParams.addRule(12);
        layoutParams.addRule(9);
        addView(this.aGH, layoutParams);
        this.nlS = new com.bytedance.sdk.openadsdk.core.widget.Os(context);
        this.nlS.setPadding(DbA, 0, DbA, 0);
        this.nlS.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(SSo.DbA(context, 32.0f), SSo.DbA(context, 14.0f));
        layoutParams2.addRule(12);
        layoutParams2.addRule(11);
        layoutParams2.setMargins(0, 0, DbA2, DbA2);
        addView(this.nlS, layoutParams2);
        if (this.wC != null) {
            addView(this.wC);
        }
    }

    public void setRenderListener(eli eliVar) {
        this.NU = eliVar;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.NU = null;
    }
}
