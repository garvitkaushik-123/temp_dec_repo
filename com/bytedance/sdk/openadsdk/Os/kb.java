package com.bytedance.sdk.openadsdk.Os;

import android.content.Context;
import android.graphics.Color;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class kb extends LinearLayout {
    private wC DbA;
    private final aAs Os;
    private final FilterWord eli;

    public kb(Context context, FilterWord filterWord, aAs aas) {
        super(context);
        setOrientation(1);
        this.eli = filterWord;
        this.Os = aas;
        eli();
    }

    private void eli() {
        Os();
        DbA();
    }

    private void DbA() {
        this.DbA = new wC(getContext(), this.Os);
        new LinearLayout.LayoutParams(-1, -2);
        this.DbA.eli(this.eli.getOptions());
        addView(this.DbA);
    }

    private void Os() {
        String name = this.eli.getName();
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.bottomMargin = SSo.DbA(getContext(), 12.0f);
        layoutParams.gravity = 17;
        wCVar.setGravity(17);
        wCVar.setText(name);
        wCVar.setTextColor(Color.argb(85, 22, 24, 35));
        wCVar.setTextSize(this.Os.FC() ? 14 : 10);
        addView(wCVar, layoutParams);
    }
}
