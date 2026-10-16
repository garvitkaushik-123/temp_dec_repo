package com.bytedance.sdk.openadsdk.nn;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public class nlS extends com.bytedance.sdk.openadsdk.core.ui.kb {
    public nlS(Context context) {
        this(context, null);
    }

    public nlS(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public nlS(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        eli(context);
    }

    private void eli(Context context) {
        setId(aqO.Tju);
        setVisibility(8);
        setBackgroundColor(Color.parseColor("#7f000000"));
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(getContext());
        agh.setId(aqO.CH);
        agh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        agh.setImageTintMode(PorterDuff.Mode.SRC_OVER);
        agh.setImageTintList(ColorStateList.valueOf(Color.parseColor("#7f000000")));
        agh.setBackgroundColor(Color.parseColor("#7f000000"));
        agh.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(agh);
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(context);
        kbVar.setId(aqO.yw);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        kbVar.setLayoutParams(layoutParams);
        addView(kbVar);
        int DbA = SSo.DbA(context, 44.0f);
        com.bytedance.sdk.openadsdk.core.widget.eli eliVar = new com.bytedance.sdk.openadsdk.core.widget.eli(context);
        eliVar.setId(aqO.Uv);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(DbA, DbA);
        layoutParams2.addRule(14);
        eliVar.setLayoutParams(layoutParams2);
        eliVar.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        kbVar.addView(eliVar);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar.setId(aqO.FS);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(DbA, DbA);
        layoutParams3.addRule(8, aqO.Uv);
        layoutParams3.addRule(19, aqO.Uv);
        layoutParams3.addRule(5, aqO.Uv);
        layoutParams3.addRule(7, aqO.Uv);
        layoutParams3.addRule(18, aqO.Uv);
        layoutParams3.addRule(6, aqO.Uv);
        layoutParams3.addRule(14);
        wCVar.setLayoutParams(layoutParams3);
        wCVar.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_circle_solid_mian"));
        wCVar.setGravity(17);
        wCVar.setTextColor(-1);
        wCVar.setTextSize(2, 19.0f);
        wCVar.setTypeface(Typeface.defaultFromStyle(1));
        wCVar.setVisibility(8);
        kbVar.addView(wCVar);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar2 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar2.setId(aqO.jh);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(3, aqO.Uv);
        layoutParams4.addRule(14);
        layoutParams4.topMargin = SSo.DbA(context, 6.0f);
        wCVar2.setLayoutParams(layoutParams4);
        wCVar2.setEllipsize(TextUtils.TruncateAt.END);
        wCVar2.setMaxLines(1);
        wCVar2.setTextColor(-1);
        wCVar2.setTextSize(2, 12.0f);
        kbVar.addView(wCVar2);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar3 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        wCVar3.setId(aqO.Za);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(SSo.DbA(context, 100.0f), SSo.DbA(context, 28.0f));
        layoutParams5.addRule(14);
        layoutParams5.addRule(3, aqO.jh);
        layoutParams5.topMargin = SSo.DbA(context, 20.0f);
        wCVar3.setLayoutParams(layoutParams5);
        wCVar3.setMinWidth(SSo.DbA(context, 72.0f));
        wCVar3.setMaxLines(1);
        wCVar3.setEllipsize(TextUtils.TruncateAt.END);
        wCVar3.setTextColor(-1);
        wCVar3.setTextSize(2, 14.0f);
        wCVar3.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_ad_cover_btn_begin_bg"));
        wCVar3.setGravity(17);
        int DbA2 = SSo.DbA(context, 10.0f);
        int DbA3 = SSo.DbA(context, 2.0f);
        wCVar3.setPadding(DbA2, DbA3, DbA2, DbA3);
        wCVar3.setVisibility(8);
        kbVar.addView(wCVar3);
    }
}
