package com.bytedance.sdk.openadsdk.nn;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public class Dfc extends com.bytedance.sdk.openadsdk.core.ui.kb {
    public Dfc(Context context) {
        this(context, null);
    }

    public Dfc(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Dfc(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        eli(context);
    }

    private void eli(Context context) {
        setId(aqO.Eh);
        setBackgroundColor(Color.parseColor("#00000000"));
        setGravity(16);
        setVisibility(8);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar.setId(aqO.eu);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        wCVar.setLayoutParams(layoutParams);
        wCVar.setIncludeFontPadding(false);
        wCVar.setText(ev.eli(context, "tt_video_without_wifi_tips"));
        wCVar.setTextColor(Color.parseColor("#cacaca"));
        wCVar.setTextSize(2, 14.0f);
        addView(wCVar);
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(context);
        kbVar.setId(aqO.GR);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, aqO.eu);
        layoutParams2.addRule(13);
        kbVar.setLayoutParams(layoutParams2);
        addView(kbVar);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh.setId(aqO.mS);
        int DbA = SSo.DbA(context, 44.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DbA, DbA);
        layoutParams3.addRule(15);
        agh.setLayoutParams(layoutParams3);
        agh.setImageDrawable(ev.Os(context, "tt_new_play_video"));
        agh.setScaleType(ImageView.ScaleType.FIT_XY);
        kbVar.addView(agh);
    }
}
