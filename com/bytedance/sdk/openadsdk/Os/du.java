package com.bytedance.sdk.openadsdk.Os;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class du extends View {
    private final int eli;

    public du(Context context) {
        this(context, Color.parseColor("#25000000"));
    }

    public du(Context context, int i) {
        super(context);
        setBackgroundColor(i);
        this.eli = SSo.DbA(getContext(), 0.66f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), this.eli);
    }
}
