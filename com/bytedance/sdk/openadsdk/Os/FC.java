package com.bytedance.sdk.openadsdk.Os;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.Os.aAs;
import com.bytedance.sdk.openadsdk.core.settings.NU;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.aqO;
import java.util.List;

/* loaded from: classes3.dex */
public class FC extends com.bytedance.sdk.openadsdk.core.ui.Os implements aAs.DbA, aAs.Os, aAs.aGH, aAs.eli {
    private int DbA;
    private View FC;
    private TextView MGA;
    private int NU;
    private int Os;
    private com.bytedance.sdk.openadsdk.core.ui.aGH aAs;
    private final aAs aGH;
    private com.bytedance.sdk.openadsdk.core.ui.wC du;
    MGA eli;
    private du kb;
    private int nlS;
    private FilterWord nn;
    private com.bytedance.sdk.openadsdk.core.ui.wC ui;
    private View wC;

    public FC(Context context, aAs aas) {
        this(context, aas, null);
    }

    public FC(Context context, aAs aas, List<FilterWord> list) {
        super(context);
        this.aGH = aas;
        aas.eli((aAs.Os) this);
        aas.eli((aAs.DbA) this);
        aas.eli((aAs.aGH) this);
        aas.eli((aAs.eli) this);
        Os();
        eli(context);
        if (list == null || list.isEmpty()) {
            return;
        }
        DbA(list);
    }

    private void Os() {
        if (this.nlS > 0) {
            return;
        }
        this.nlS = SSo.Os(getContext());
        int ui = SSo.ui(getContext());
        this.NU = ui;
        this.aGH.eli(this.nlS, ui);
    }

    @Override // com.bytedance.sdk.openadsdk.core.ui.Os, android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams != null) {
            if (this.nlS == 0) {
                Os();
            }
            layoutParams.width = Math.min(this.nlS, this.NU) - (SSo.DbA(getContext(), 16.0f) * 2);
        }
    }

    private void eli(Context context) {
        this.Os = SSo.DbA(context, 8.0f);
        this.DbA = SSo.DbA(context, 20.0f);
        int DbA = SSo.DbA(context, 56.0f);
        int DbA2 = SSo.DbA(context, 30.0f);
        int DbA3 = SSo.DbA(context, 12.0f);
        if (aGH()) {
            DbA3 = this.DbA;
        }
        if (!aGH()) {
            DbA = DbA2;
        }
        View view = new View(getContext());
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, SSo.DbA(getContext(), 98.0f));
        view.setBackground(ev.Os(context, "tt_ad_bg_header_gradient"));
        addView(view, layoutParams);
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.Os);
        gradientDrawable.setColor(-1);
        setBackground(gradientDrawable);
        setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        int DbA4 = SSo.DbA(context, 24.0f);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(DbA4, DbA4);
        layoutParams3.setMargins(0, DbA3, DbA3, 0);
        layoutParams3.gravity = 8388661;
        agh.setImageDrawable(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_titlebar_close_seletor"));
        addView(agh, layoutParams3);
        agh.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.Os.FC.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FC.this.aGH.ui();
            }
        });
        com.bytedance.sdk.openadsdk.core.ui.aGH agh2 = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        this.aAs = agh2;
        agh2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.Os.FC.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                FC.this.DbA();
            }
        });
        this.aAs.setVisibility(8);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(DbA4, DbA4);
        layoutParams4.setMargins(DbA3, DbA3, 0, 0);
        layoutParams4.gravity = 8388659;
        Drawable eli = com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_leftbackicon_selector");
        eli.setAutoMirrored(true);
        this.aAs.setImageDrawable(eli);
        addView(this.aAs, layoutParams4);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, -2);
        layoutParams5.setMargins(DbA3, DbA, DbA3, DbA3);
        uiVar.setOrientation(1);
        addView(uiVar, layoutParams5);
        View Os = Os(context);
        this.wC = Os;
        uiVar.addView(Os);
        View aGH = aGH(context);
        this.FC = aGH;
        uiVar.addView(aGH);
        com.bytedance.sdk.openadsdk.core.ui.wC DbA5 = DbA(context);
        this.ui = DbA5;
        uiVar.addView(DbA5);
    }

    private com.bytedance.sdk.openadsdk.core.ui.wC DbA(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = aGH() ? this.DbA : SSo.DbA(context, 12.0f);
        layoutParams.gravity = 80;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.Os);
        int rgb = Color.rgb(254, 44, 85);
        gradientDrawable.setColor(rgb);
        gradientDrawable.setAlpha(102);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(this.Os);
        gradientDrawable2.setColor(rgb);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        int i = this.Os;
        wCVar.setPadding(0, i, 0, i);
        wCVar.setGravity(17);
        wCVar.setBackground(stateListDrawable);
        wCVar.setTextColor(-1);
        wCVar.setTextSize(16.0f);
        wCVar.setText(ev.eli(context, "tt_suggestion_commit"));
        wCVar.setEnabled(false);
        wCVar.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.Os.FC.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FC.this.aGH.aGH();
            }
        });
        wCVar.setLayoutParams(layoutParams);
        return wCVar;
    }

    private View Os(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        uiVar.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText(ev.eli(context, "tt_like_this_ad"));
        textView.setTextSize(aGH() ? 23 : 16);
        textView.setGravity(1);
        textView.setTextColor(Color.parseColor("#161823"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        uiVar.addView(textView, layoutParams);
        TextView textView2 = new TextView(context);
        textView2.setText(ev.eli(context, "tt_feel_hint"));
        textView2.setTextSize(aGH() ? 14 : 10);
        textView2.setAlpha(0.5f);
        textView2.setTextColor(Color.parseColor("#161823"));
        textView2.setGravity(17);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        if (aGH()) {
            layoutParams2.topMargin = SSo.DbA(context, 4.0f);
        }
        uiVar.addView(textView2, layoutParams2);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar2.setOrientation(0);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int DbA = SSo.DbA(context, 16.0f);
        int DbA2 = SSo.DbA(context, 12.0f);
        int DbA3 = SSo.DbA(context, 8.0f);
        if (aGH()) {
            layoutParams3.topMargin = DbA;
            layoutParams3.bottomMargin = DbA;
        } else {
            layoutParams3.topMargin = DbA2;
            layoutParams3.bottomMargin = DbA3;
        }
        uiVar.addView(uiVar2, layoutParams3);
        uiVar2.addView(new ui(context, 1, this.aGH));
        ui uiVar3 = new ui(context, 2, this.aGH);
        ViewGroup.LayoutParams layoutParams4 = uiVar3.getLayoutParams();
        boolean z = layoutParams4 instanceof LinearLayout.LayoutParams;
        ViewGroup.LayoutParams layoutParams5 = layoutParams4;
        if (!z) {
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(0, -2);
            layoutParams6.weight = 1.0f;
            layoutParams5 = layoutParams6;
        }
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) layoutParams5;
        layoutParams7.leftMargin = DbA;
        layoutParams7.rightMargin = DbA;
        uiVar2.addView(uiVar3, layoutParams5);
        uiVar2.addView(new ui(context, 3, this.aGH));
        du duVar = new du(context);
        this.kb = duVar;
        uiVar.addView(duVar);
        this.MGA = new TextView(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        if (!aGH()) {
            DbA = DbA3;
        }
        layoutParams8.topMargin = DbA;
        this.MGA.setTextColor(-16777216);
        this.MGA.setPadding(DbA2, DbA3, DbA2, DbA3);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(DbA3);
        gradientDrawable.setColor(Color.parseColor("#F8F8F8"));
        this.MGA.setBackground(gradientDrawable);
        this.MGA.setText(ev.eli(context, "tt_report_this_ad"));
        this.MGA.setTextSize(aGH() ? 14 : 12);
        Drawable Os = ev.Os(context, "tt_report_ad_arrow");
        Os.setBounds(0, 0, DbA2, DbA2);
        this.MGA.setCompoundDrawables(null, null, Os, null);
        this.MGA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.Os.FC.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                FC.this.eli();
            }
        });
        uiVar.addView(this.MGA, layoutParams8);
        return uiVar;
    }

    private boolean aGH() {
        if (this.nlS == 0) {
            Os();
        }
        return this.nlS < this.NU;
    }

    private View aGH(Context context) {
        int DbA;
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setOrientation(1);
        if (!aGH()) {
            DbA = SSo.DbA(context, 200.0f);
        } else {
            DbA = SSo.DbA(context, 358.0f);
        }
        uiVar.setLayoutParams(new LinearLayout.LayoutParams(-1, DbA));
        TextView textView = new TextView(context);
        textView.setText(ev.eli(context, "tt_select_reason"));
        textView.setTextSize(aGH() ? 23 : 16);
        textView.setGravity(1);
        textView.setTextColor(Color.parseColor("#161823"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = SSo.DbA(context, aGH() ? 24.0f : 4.0f);
        uiVar.addView(textView, layoutParams);
        MGA mga = new MGA(context, this.aGH);
        this.eli = mga;
        uiVar.addView(mga);
        if (NU.nY().jh()) {
            com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
            this.du = wCVar;
            wCVar.setId(aqO.CSp);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.topMargin = aGH() ? this.DbA : SSo.DbA(context, 6.0f);
            layoutParams2.gravity = 17;
            this.du.setLayoutParams(layoutParams2);
            this.du.setFocusable(false);
            this.du.setHint(ev.eli(context, "tt_add_bad_reason"));
            this.du.setHintTextColor(Color.parseColor("#57000000"));
            this.du.setTextColor(Color.rgb(22, 24, 35));
            this.du.setTextSize(15.0f);
            this.du.setGravity(GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK);
            this.du.setVisibility(0);
            this.du.setPadding(0, SSo.DbA(context, 15.0f), 0, SSo.DbA(context, 14.0f));
            this.du.setEllipsize(TextUtils.TruncateAt.END);
            this.du.setSingleLine();
            this.du.setMaxLines(1);
            this.du.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.Os.FC.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FC.this.aGH.MGA();
                }
            });
            uiVar.addView(this.du, layoutParams2);
            uiVar.addView(new du(context, Color.argb(128, 0, 0, 0)));
        }
        uiVar.setVisibility(8);
        return uiVar;
    }

    private void DbA(List<FilterWord> list) {
        this.eli.eli(list);
    }

    public void eli() {
        View view = this.FC;
        if (view != null) {
            view.setVisibility(0);
        }
        View view2 = this.wC;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = this.aAs;
        if (agh != null) {
            agh.setVisibility(0);
        }
        aAs aas = this.aGH;
        if (aas == null || !aas.Os()) {
            return;
        }
        this.nn = this.aGH.DbA();
    }

    public void DbA() {
        View view = this.FC;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.wC;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        com.bytedance.sdk.openadsdk.core.ui.aGH agh = this.aAs;
        if (agh != null) {
            agh.setVisibility(8);
        }
        aAs aas = this.aGH;
        if (aas != null) {
            FilterWord filterWord = this.nn;
            if (filterWord != null) {
                aas.eli(filterWord);
            } else {
                aas.eli(aAs.eli);
            }
            this.aGH.Os(null);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.Os.aAs.Os
    public void eli(FilterWord filterWord) {
        if (filterWord == null) {
            return;
        }
        if (this.ui != null && TextUtils.isEmpty(this.aGH.kb())) {
            this.ui.setEnabled(!aAs.eli.equals(filterWord));
        }
        if (ui.eli.equals(filterWord) || ui.DbA.equals(filterWord)) {
            this.MGA.setVisibility(8);
            this.kb.setVisibility(8);
        }
        if (ui.Os.equals(filterWord) || aAs.eli.equals(filterWord)) {
            this.MGA.setVisibility(0);
            this.kb.setVisibility(0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.Os.aAs.DbA
    public void eli(int i) {
        if (aAs.Os == i) {
            this.nn = null;
            DbA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.Os.aAs.aGH
    public void eli(String str) {
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar;
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar2 = this.du;
        if (wCVar2 != null) {
            wCVar2.setText(str);
        }
        if (TextUtils.isEmpty(str)) {
            aAs aas = this.aGH;
            if (aas == null || (wCVar = this.ui) == null) {
                return;
            }
            wCVar.setEnabled(aas.Os());
            return;
        }
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar3 = this.ui;
        if (wCVar3 != null) {
            wCVar3.setEnabled(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.Os.aAs.eli
    public void eli(List<FilterWord> list) {
        DbA(list);
    }
}
