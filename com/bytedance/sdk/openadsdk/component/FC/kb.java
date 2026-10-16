package com.bytedance.sdk.openadsdk.component.FC;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class kb extends com.bytedance.sdk.openadsdk.core.ui.kb {
    private final com.bytedance.sdk.openadsdk.core.ui.aGH DbA;
    private final com.bytedance.sdk.openadsdk.core.ui.wC Os;
    private final com.bytedance.sdk.openadsdk.core.ui.aGH eli;

    public kb(Context context) {
        super(context);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int DbA = SSo.DbA(context, 12.0f);
        int DbA2 = SSo.DbA(context, 16.0f);
        int DbA3 = SSo.DbA(context, 20.0f);
        int DbA4 = SSo.DbA(context, 24.0f);
        int DbA5 = SSo.DbA(context, 28.0f);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        this.eli = agh;
        agh.setId(520093713);
        int DbA6 = SSo.DbA(getContext(), 5.0f);
        agh.setPadding(DbA6, DbA6, DbA6, DbA6);
        agh.setScaleType(ImageView.ScaleType.CENTER);
        agh.setBackground(com.bytedance.sdk.openadsdk.core.widget.aGH.eli());
        agh.setImageResource(ev.aGH(dV.eli(), "tt_reward_full_feedback"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DbA5, DbA5);
        layoutParams.topMargin = DbA3;
        layoutParams.leftMargin = DbA2;
        layoutParams.setMarginStart(DbA2);
        agh.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh2 = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        this.DbA = agh2;
        agh2.setId(520093714);
        agh2.setPadding(DbA6, DbA6, DbA6, DbA6);
        agh2.setScaleType(ImageView.ScaleType.CENTER);
        agh2.setBackground(com.bytedance.sdk.openadsdk.core.widget.aGH.eli());
        agh2.setImageResource(ev.aGH(dV.eli(), "tt_close_btn"));
        if (agh2.getDrawable() != null) {
            agh2.getDrawable().setAutoMirrored(true);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DbA5, DbA5);
        layoutParams2.topMargin = DbA3;
        layoutParams2.rightMargin = DbA2;
        layoutParams2.setMarginEnd(DbA2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(21);
        agh2.setLayoutParams(layoutParams2);
        agh2.setVisibility(4);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        this.Os = wCVar;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, DbA4);
        layoutParams3.topMargin = DbA3;
        layoutParams3.rightMargin = DbA2;
        layoutParams3.addRule(11);
        layoutParams3.setMarginEnd(DbA2);
        layoutParams3.addRule(21);
        wCVar.setLayoutParams(layoutParams3);
        wCVar.setBackground(com.bytedance.sdk.openadsdk.core.widget.aGH.DbA());
        wCVar.setGravity(17);
        wCVar.setPadding(DbA, 0, DbA, 0);
        wCVar.setTextColor(-1);
        wCVar.setTextSize(1, 14.0f);
        wCVar.setVisibility(4);
        addView(agh);
        addView(wCVar);
        addView(agh2);
    }

    public View getTopDislike() {
        return this.eli;
    }

    public com.bytedance.sdk.openadsdk.core.ui.aGH getTopSkip() {
        return this.DbA;
    }

    public com.bytedance.sdk.openadsdk.core.ui.wC getTopCountDown() {
        return this.Os;
    }
}
