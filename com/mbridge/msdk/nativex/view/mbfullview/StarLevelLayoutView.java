package com.mbridge.msdk.nativex.view.mbfullview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mbridge.msdk.foundation.tools.h0;
import com.mbridge.msdk.foundation.tools.u0;

/* loaded from: classes6.dex */
public class StarLevelLayoutView extends LinearLayout {
    public StarLevelLayoutView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setRating(int i) {
        removeAllViews();
        if (i == 0) {
            i = 5;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            View imageView = new ImageView(getContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i2 < i) {
                imageView.setBackgroundResource(h0.a(getContext(), "mbridge_demo_star_sel", "drawable"));
            } else {
                imageView.setBackgroundResource(h0.a(getContext(), "mbridge_demo_star_nor", "drawable"));
            }
            layoutParams.leftMargin = u0.a(getContext(), 7.0f);
            addView(imageView, layoutParams);
        }
    }

    public StarLevelLayoutView(Context context) {
        super(context);
    }

    public StarLevelLayoutView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
