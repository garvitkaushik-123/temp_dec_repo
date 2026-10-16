package com.bytedance.sdk.openadsdk.Os;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.Os.aAs;
import com.bytedance.sdk.openadsdk.utils.SSo;

/* loaded from: classes3.dex */
public class ui extends com.bytedance.sdk.openadsdk.core.ui.ui implements View.OnClickListener, aAs.Os {
    private StateListDrawable MGA;
    private final aAs aGH;
    private final int kb;
    private FilterWord ui;
    public static FilterWord eli = new FilterWord("100:1", "GOOD");
    public static FilterWord DbA = new FilterWord("100:2", "NOT_BAD");
    public static FilterWord Os = new FilterWord("100:3", "BAD");

    public ui(Context context, int i, aAs aas) {
        super(context);
        this.kb = i;
        this.aGH = aas;
        if (aas != null) {
            aas.eli(this);
        }
        eli(i);
        eli();
        DbA();
    }

    private void eli(int i) {
        if (i == 1) {
            this.ui = eli;
        } else if (i == 2) {
            this.ui = DbA;
        } else {
            if (i != 3) {
                return;
            }
            this.ui = Os;
        }
    }

    private void eli() {
        if (this.MGA == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(SSo.DbA(getContext(), 12.0f));
            gradientDrawable.setColor(Color.parseColor("#F8F8F8"));
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setStroke(SSo.DbA(getContext(), 2.0f), Color.parseColor("#FE2C55"));
            gradientDrawable2.setCornerRadius(SSo.DbA(getContext(), 12.0f));
            gradientDrawable2.setColor(Color.parseColor("#12FE2C55"));
            StateListDrawable stateListDrawable = new StateListDrawable();
            this.MGA = stateListDrawable;
            stateListDrawable.addState(new int[]{R.attr.state_selected}, gradientDrawable2);
            this.MGA.addState(new int[0], gradientDrawable);
        }
        setBackground(this.MGA);
        setSelected(false);
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2);
        layoutParams.weight = 1.0f;
        setLayoutParams(layoutParams);
        setOnClickListener(this);
    }

    private void DbA() {
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(getContext());
        wCVar.setTextSize(this.aGH.FC() ? 40 : 30);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.setMargins(0, SSo.DbA(getContext(), 12.0f), 0, SSo.DbA(getContext(), this.aGH.FC() ? 8.0f : 4.0f));
        addView(wCVar, layoutParams);
        eli eliVar = new eli(getContext());
        eliVar.setTextSize(this.aGH.FC() ? 17 : 12);
        eliVar.setTextColor(-16777216);
        eliVar.setMaxLines(1);
        eliVar.setSingleLine();
        eliVar.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.setMargins(0, 0, 0, SSo.DbA(getContext(), 12.0f));
        addView(eliVar, layoutParams2);
        int i = this.kb;
        if (i == 1) {
            wCVar.setText("😍");
            eliVar.setText(ev.eli(getContext(), "tt_good"));
        } else if (i == 2) {
            eliVar.setText(ev.eli(getContext(), "tt_not_bad"));
            wCVar.setText("😐");
        } else {
            if (i != 3) {
                return;
            }
            eliVar.setText(ev.eli(getContext(), "tt_bad"));
            wCVar.setText("😡");
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (isSelected()) {
            this.aGH.eli(aAs.eli);
        } else {
            this.aGH.eli(this.ui);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.Os.aAs.Os
    public void eli(FilterWord filterWord) {
        FilterWord filterWord2;
        if (filterWord == null || (filterWord2 = this.ui) == null) {
            return;
        }
        setSelected(filterWord.equals(filterWord2));
    }
}
