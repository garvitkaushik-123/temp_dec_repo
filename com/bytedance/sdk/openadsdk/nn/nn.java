package com.bytedance.sdk.openadsdk.nn;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;

/* loaded from: classes3.dex */
public class nn extends com.bytedance.sdk.openadsdk.core.ui.kb {
    public nn(Context context) {
        this(context, null);
    }

    public nn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public nn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        eli(context);
    }

    private void eli(Context context) {
        setBackgroundColor(Color.parseColor("#000000"));
        setId(520093726);
        int DbA = SSo.DbA(context, 60.0f);
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(context);
        os.setId(aqO.QMZ);
        os.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        os.setBackgroundColor(0);
        addView(os);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh.setId(aqO.OJ);
        agh.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        agh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        os.addView(agh);
        com.bytedance.sdk.openadsdk.core.ui.MGA mga = new com.bytedance.sdk.openadsdk.core.ui.MGA(context);
        mga.setId(aqO.Ib);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(DbA, DbA);
        layoutParams.gravity = 17;
        mga.setLayoutParams(layoutParams);
        mga.setIndeterminateDrawable(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_video_loading_progress_bar"));
        os.addView(mga);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh2 = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        agh2.setId(aqO.XlF);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        agh2.setLayoutParams(layoutParams2);
        agh2.setScaleType(ImageView.ScaleType.CENTER);
        agh2.setImageDrawable(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_play_movebar_textpage"));
        agh2.setVisibility(8);
        addView(agh2);
        nlS nls = new nlS(context);
        nls.setId(aqO.Tju);
        nls.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(nls);
    }
}
