package com.bytedance.sdk.openadsdk.Os;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.utils.SSo;
import java.util.Locale;

/* loaded from: classes3.dex */
public class nlS extends Dialog {
    private eli DbA;
    private com.bytedance.sdk.openadsdk.core.ui.aGH MGA;
    private com.bytedance.sdk.openadsdk.core.ui.DbA Os;
    private com.bytedance.sdk.openadsdk.core.ui.wC aGH;
    private com.bytedance.sdk.openadsdk.core.ui.ui eli;
    private final aAs kb;
    private com.bytedance.sdk.openadsdk.core.ui.wC ui;

    public interface eli {
        void DbA();

        void Os();

        void eli();

        void eli(int i, FilterWord filterWord, String str);
    }

    public nlS(Context context, aAs aas) {
        super(context, ev.MGA(context, "tt_quick_option_dialog"));
        setCanceledOnTouchOutside(false);
        this.kb = aas;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.core.ui.ui eli2 = eli(dV.eli());
        this.eli = eli2;
        setContentView(eli2);
        eli(this.eli);
        Os();
        eli();
        aGH();
    }

    private void eli(View view) {
        eli((EditText) this.Os);
        aAs aas = this.kb;
        if (aas != null) {
            String kb = aas.kb();
            if (!TextUtils.isEmpty(kb)) {
                this.Os.setText(kb);
                this.aGH.setText(String.format(Locale.getDefault(), "%d%s", Integer.valueOf(kb.length()), "/200"));
            }
            this.ui.setEnabled(!TextUtils.isEmpty(kb));
        }
        this.ui.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.Os.nlS.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String obj = nlS.this.Os.getText().toString();
                if (nlS.this.DbA != null) {
                    nlS.this.DbA.eli(4, aAs.eli, obj);
                }
                nlS.this.dismiss();
            }
        });
        this.MGA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.Os.nlS.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (nlS.this.DbA != null) {
                    nlS.this.DbA.DbA();
                }
                nlS.this.dismiss();
            }
        });
        this.Os.addTextChangedListener(new TextWatcher() { // from class: com.bytedance.sdk.openadsdk.Os.nlS.3
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                com.bytedance.sdk.openadsdk.core.ui.wC wCVar;
                int round = Math.round(charSequence.length());
                nlS.this.aGH.setText(round + "/200");
                boolean z = true;
                if (round > 0) {
                    if (nlS.this.ui.isEnabled()) {
                        return;
                    } else {
                        wCVar = nlS.this.ui;
                    }
                } else {
                    wCVar = nlS.this.ui;
                    if (nlS.this.kb == null || TextUtils.isEmpty(nlS.this.kb.kb())) {
                        z = false;
                    }
                }
                wCVar.setEnabled(z);
            }
        });
    }

    public static void eli(EditText editText) {
        editText.setFilters(new InputFilter[]{new InputFilter() { // from class: com.bytedance.sdk.openadsdk.Os.nlS.4
            @Override // android.text.InputFilter
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                while (i < i2) {
                    int type = Character.getType(charSequence.charAt(i));
                    if (type == 19 || type == 28) {
                        return "";
                    }
                    i++;
                }
                return null;
            }
        }, new InputFilter.LengthFilter(200)});
    }

    private void Os() {
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        Window window = getWindow();
        if (window != null) {
            if (window.getDecorView() != null) {
                window.getDecorView().setPadding(0, 0, 0, 0);
            }
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
            window.setGravity(80);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        eli eliVar = this.DbA;
        if (eliVar != null) {
            eliVar.eli();
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        DbA();
        super.dismiss();
    }

    public void eli(eli eliVar) {
        this.DbA = eliVar;
    }

    public void eli() {
        com.bytedance.sdk.openadsdk.core.ui.DbA dbA = this.Os;
        if (dbA == null) {
            return;
        }
        dbA.requestFocus();
        Window window = getWindow();
        if (window != null) {
            window.setSoftInputMode(5);
        }
    }

    public void DbA() {
        InputMethodManager inputMethodManager;
        com.bytedance.sdk.openadsdk.core.ui.DbA dbA = this.Os;
        if (dbA == null || (inputMethodManager = (InputMethodManager) dbA.getContext().getSystemService("input_method")) == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(this.eli.getWindowToken(), 0);
    }

    private void aGH() {
        setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.bytedance.sdk.openadsdk.Os.nlS.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                if (nlS.this.DbA != null) {
                    nlS.this.DbA.Os();
                }
            }
        });
    }

    public void eli(String str, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        aAs aas = this.kb;
        if (aas != null) {
            aas.eli(str, evVar);
        }
    }

    private com.bytedance.sdk.openadsdk.core.ui.ui eli(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        uiVar.setOrientation(1);
        uiVar.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_dislike_dialog_bg"));
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(context);
        kbVar.setLayoutParams(new LinearLayout.LayoutParams(-1, SSo.DbA(context, 48.0f)));
        this.MGA = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        int DbA = SSo.DbA(context, 24.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(DbA, DbA);
        layoutParams.addRule(16);
        layoutParams.addRule(11);
        int DbA2 = SSo.DbA(context, 10.0f);
        layoutParams.topMargin = DbA2;
        layoutParams.rightMargin = DbA2;
        this.MGA.setLayoutParams(layoutParams);
        this.MGA.setClickable(true);
        this.MGA.setFocusable(true);
        this.MGA.setImageDrawable(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_titlebar_close_seletor"));
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(16);
        layoutParams2.topMargin = SSo.DbA(context, 12.0f);
        wCVar.setLayoutParams(layoutParams2);
        wCVar.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        wCVar.setGravity(17);
        wCVar.setSingleLine(true);
        wCVar.setText(ev.eli(context, "tt_other_reason"));
        wCVar.setTextColor(Color.parseColor("#161823"));
        wCVar.setTextSize(15.0f);
        wCVar.setTypeface(Typeface.defaultFromStyle(0));
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, SSo.DbA(context, 0.5f)));
        view.setBackgroundColor(Color.argb(51, 22, 24, 35));
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        uiVar2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        uiVar2.setOrientation(1);
        com.bytedance.sdk.openadsdk.core.ui.DbA dbA = new com.bytedance.sdk.openadsdk.core.ui.DbA(context);
        this.Os = dbA;
        dbA.setFilters(new InputFilter[]{new InputFilter.LengthFilter(200), new InputFilter.AllCaps()});
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.leftMargin = SSo.DbA(context, 16.0f);
        layoutParams3.rightMargin = SSo.DbA(context, 16.0f);
        layoutParams3.topMargin = SSo.DbA(context, 11.5f);
        this.Os.setLayoutParams(layoutParams3);
        this.Os.setLines(4);
        this.Os.setGravity(48);
        this.Os.setTextSize(15.0f);
        this.Os.setTextColor(Color.rgb(22, 24, 35));
        this.Os.setHintTextColor(Color.parseColor("#57161823"));
        this.Os.setBackground(null);
        this.Os.setImeOptions(268435456);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar3 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        int DbA3 = SSo.DbA(context, 16.0f);
        int DbA4 = SSo.DbA(context, 17.0f);
        uiVar3.setPadding(DbA3, DbA4, DbA3, DbA4);
        uiVar3.setLayoutParams(layoutParams4);
        uiVar3.setOrientation(0);
        this.aGH = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(0, -2);
        layoutParams5.weight = 1.0f;
        layoutParams5.gravity = GravityCompat.START;
        this.aGH.setLayoutParams(layoutParams5);
        this.aGH.setText(String.format("0%s", "/200"));
        this.aGH.setGravity(GravityCompat.START);
        this.aGH.setTextColor(Color.parseColor("#57161823"));
        this.aGH.setTextSize(15.0f);
        this.ui = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams6.gravity = GravityCompat.END;
        this.ui.setLayoutParams(layoutParams6);
        this.ui.setTextSize(14.0f);
        this.ui.setTextColor(-1);
        this.ui.setVisibility(0);
        this.ui.setSingleLine(true);
        int DbA5 = SSo.DbA(context, 27.0f);
        int DbA6 = SSo.DbA(context, 5.0f);
        this.ui.setPadding(DbA5, DbA6, DbA5, DbA6);
        int DbA7 = SSo.DbA(context, 6.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f = DbA7;
        gradientDrawable.setCornerRadius(f);
        int rgb = Color.rgb(254, 44, 85);
        gradientDrawable.setColor(rgb);
        gradientDrawable.setAlpha(102);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setCornerRadius(f);
        gradientDrawable2.setColor(rgb);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        this.ui.setBackground(stateListDrawable);
        this.ui.setText(ev.eli(context, "tt_done"));
        this.ui.setEnabled(false);
        uiVar.addView(kbVar);
        uiVar.addView(view);
        uiVar.addView(uiVar2);
        kbVar.addView(this.MGA);
        kbVar.addView(wCVar);
        uiVar2.addView(this.Os);
        uiVar2.addView(uiVar3);
        uiVar3.addView(this.aGH);
        uiVar3.addView(this.ui);
        return uiVar;
    }
}
