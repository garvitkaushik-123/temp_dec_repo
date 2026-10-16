package com.bytedance.sdk.openadsdk.core.aAs.DbA.aGH;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;

/* loaded from: classes3.dex */
public class eli extends com.bytedance.adsdk.ugeno.FC.DbA.eli {
    private final com.bytedance.adsdk.ugeno.FC.DbA.eli DbA;
    private final com.bytedance.adsdk.ugeno.FC.DbA.eli eli;

    public eli(Context context) {
        super(context);
        com.bytedance.adsdk.ugeno.FC.DbA.eli eliVar = new com.bytedance.adsdk.ugeno.FC.DbA.eli(context);
        this.eli = eliVar;
        addView(eliVar, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.adsdk.ugeno.FC.DbA.eli eliVar2 = new com.bytedance.adsdk.ugeno.FC.DbA.eli(context);
        this.DbA = eliVar2;
        eliVar2.setBackgroundColor(0);
        addView(eliVar2, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.DbA.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.DbA.setOnTouchListener(onTouchListener);
    }

    public com.bytedance.adsdk.ugeno.FC.DbA.eli getVideoView() {
        return this.eli;
    }
}
