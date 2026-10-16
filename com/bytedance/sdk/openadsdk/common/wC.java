package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class wC extends LinearLayout {
    public wC(Context context) {
        super(context);
        eli();
    }

    private static ImageView eli(Context context, float f, float f2, float f3, float f4) {
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh.setClickable(true);
        agh.setFocusable(true);
        agh.setPadding(SSo.DbA(context, f3), SSo.DbA(context, f4), SSo.DbA(context, f3), SSo.DbA(context, f4));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(SSo.DbA(context, 40.0f), SSo.DbA(context, 44.0f));
        if (f > 0.0f) {
            layoutParams.leftMargin = SSo.DbA(context, f);
        }
        if (f2 > 0.0f) {
            layoutParams.rightMargin = SSo.DbA(context, f2);
        }
        agh.setLayoutParams(layoutParams);
        return agh;
    }

    private void eli() {
        Context context = getContext();
        setId(com.bytedance.sdk.openadsdk.utils.aqO.eEH);
        setLayoutParams(new ViewGroup.LayoutParams(-1, SSo.DbA(context, 44.5f)));
        setBackgroundColor(-1);
        setClickable(true);
        setFocusable(true);
        setOrientation(1);
        View view = new View(context);
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        addView(view, new LinearLayout.LayoutParams(-1, SSo.DbA(context, 0.5f)));
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setOrientation(0);
        addView(uiVar, new LinearLayout.LayoutParams(-1, SSo.DbA(context, 44.0f)));
        ImageView eli = eli(context, 16.0f, 0.0f, 14.75f, 12.5f);
        eli.setId(com.bytedance.sdk.openadsdk.utils.aqO.PfW);
        eli.setImageResource(ev.aGH(context, "tt_ad_arrow_backward"));
        uiVar.addView(eli);
        View view2 = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, 0);
        layoutParams.weight = 1.0f;
        uiVar.addView(view2, layoutParams);
        ImageView eli2 = eli(context, 8.0f, 0.0f, 14.75f, 12.5f);
        eli2.setId(com.bytedance.sdk.openadsdk.utils.aqO.Ca);
        eli2.setImageResource(ev.aGH(context, "tt_ad_arrow_forward"));
        uiVar.addView(eli2);
        View view3 = new View(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, 0);
        layoutParams2.weight = 1.0f;
        uiVar.addView(view3, layoutParams2);
        ImageView eli3 = eli(context, 8.0f, 0.0f, 10.0f, 12.0f);
        eli3.setId(com.bytedance.sdk.openadsdk.utils.aqO.yKf);
        eli3.setImageResource(ev.aGH(context, "tt_ad_refresh"));
        uiVar.addView(eli3);
        View view4 = new View(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(0, 0);
        layoutParams3.weight = 1.0f;
        uiVar.addView(view4, layoutParams3);
        ImageView eli4 = eli(context, 0.0f, 16.0f, 9.0f, 11.0f);
        eli4.setId(com.bytedance.sdk.openadsdk.utils.aqO.rn);
        eli4.setImageResource(ev.aGH(context, "tt_ad_link"));
        uiVar.addView(eli4);
    }
}
