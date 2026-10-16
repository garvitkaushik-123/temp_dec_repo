package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class MGA extends com.bytedance.sdk.openadsdk.core.ui.aGH {
    private int DbA;
    private float eli;

    public MGA(Context context) {
        super(context);
        this.eli = 2.25f;
        this.DbA = 12;
        eli();
    }

    public MGA(Context context, int i, float f) {
        super(context);
        this.eli = f;
        this.DbA = i;
        eli();
    }

    private void eli() {
        setBackground(aGH.eli());
        setImageResource(ev.aGH(getContext(), "tt_close_btn"));
        int DbA = SSo.DbA(getContext(), this.eli);
        setPadding(DbA, DbA, DbA, DbA);
        setScaleType(ImageView.ScaleType.FIT_XY);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ui.aGH, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            int DbA = SSo.DbA(getContext(), this.DbA);
            layoutParams.width = DbA;
            layoutParams.height = DbA;
        }
        super.setLayoutParams(layoutParams);
    }

    public static com.bytedance.sdk.openadsdk.core.ui.aGH eli(Context context) {
        return new MGA(context);
    }

    public static com.bytedance.sdk.openadsdk.core.ui.aGH DbA(Context context) {
        return new MGA(context, 28, 5.0f);
    }
}
