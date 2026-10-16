package com.bytedance.sdk.openadsdk.common;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.ApmHelper;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.dZ;
import com.moloco.sdk.acm.b;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class dV extends Dialog {
    private static final String[] DbA = {"SDK version", "App", "App version", b.d, "Device", "Creative info"};
    private ImageView MGA;
    private String Os;
    private TextView aGH;
    private final Handler eli;
    private Button ui;

    public dV(Context context) {
        super(context, ev.MGA(context, "tt_privacy_dialog_theme_ad_report"));
        this.eli = new Handler(Looper.getMainLooper());
        this.Os = "";
    }

    public void eli(String str, com.bytedance.sdk.openadsdk.core.model.ev evVar) {
        JSONObject QYI;
        try {
            if (!TextUtils.isEmpty(str)) {
                QYI = new JSONObject(str);
            } else {
                QYI = evVar.QYI();
            }
            this.Os = com.bytedance.sdk.component.utils.eli.eli(QYI).toString();
        } catch (JSONException e) {
            Xb.Os("TTPrivacyAdReportDialog", e.getMessage());
        }
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(eli(getContext()), new ViewGroup.LayoutParams(SSo.Os(getContext()), (int) (SSo.ui(getContext()) * 0.9d)));
        DbA();
        if (getWindow() != null) {
            getWindow().setGravity(80);
        }
    }

    private void DbA() {
        final String MGA = dZ.MGA();
        final String wC = dZ.wC();
        final String str = "Android " + Build.VERSION.RELEASE;
        final String str2 = Build.BRAND + " " + Build.MODEL;
        this.ui.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.dV.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ClipboardManager clipboardManager = (ClipboardManager) dV.this.getContext().getSystemService("clipboard");
                if (clipboardManager != null) {
                    StringBuilder sb = new StringBuilder();
                    String[] strArr = {BuildConfig.VERSION_NAME, MGA, wC, str, str2, dV.this.Os};
                    for (int i = 0; i < dV.DbA.length; i++) {
                        sb.append(dV.DbA[i]).append(": ").append(strArr[i]).append("\n");
                    }
                    try {
                        clipboardManager.setPrimaryClip(ClipData.newPlainText("pangle sdk build info", sb));
                    } catch (Throwable unused) {
                    }
                }
            }
        });
        this.MGA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.dV.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                dV.this.aGH.setText("loading ...");
                dV.this.cancel();
            }
        });
    }

    @Override // android.app.Dialog
    public void show() {
        try {
            super.show();
            this.eli.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.dV.3
                @Override // java.lang.Runnable
                public void run() {
                    dV.this.aGH.setText(dV.this.Os);
                }
            }, 1000L);
        } catch (Exception e) {
            ApmHelper.reportCustomError("showPrivacyAdReportDialogError", "showPrivacyAdReportDialogError", e);
        }
    }

    private View eli(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        uiVar.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_ad_report_info_bg"));
        uiVar.setOrientation(1);
        uiVar.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(context);
        kbVar.setLayoutParams(new ViewGroup.LayoutParams(-1, eli(44.0f)));
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(eli(191.0f), eli(24.0f));
        layoutParams2.addRule(13);
        wCVar.setGravity(17);
        wCVar.setText("Ad Report");
        wCVar.setTextColor(Color.parseColor("#161823"));
        wCVar.setTextSize(1, 17.0f);
        wCVar.setLayoutParams(layoutParams2);
        this.MGA = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(eli(40.0f), eli(44.0f));
        layoutParams3.addRule(11);
        layoutParams3.addRule(15);
        layoutParams3.rightMargin = eli(8.0f);
        this.MGA.setPadding(eli(12.0f), eli(14.0f), eli(12.0f), eli(14.0f));
        this.MGA.setImageResource(ev.aGH(context, "tt_ad_xmark"));
        this.MGA.setLayoutParams(layoutParams3);
        View view = new View(context);
        ViewGroup.LayoutParams layoutParams4 = new ViewGroup.LayoutParams(-1, eli(0.5f));
        view.setBackgroundColor(Color.parseColor("#1F161823"));
        view.setLayoutParams(layoutParams4);
        ScrollView scrollView = new ScrollView(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams5.leftMargin = eli(16.0f);
        layoutParams5.rightMargin = eli(16.0f);
        layoutParams5.weight = 1.0f;
        layoutParams5.setMarginStart(eli(16.0f));
        layoutParams5.setMarginEnd(eli(16.0f));
        scrollView.setLayoutParams(layoutParams5);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        ViewGroup.LayoutParams layoutParams6 = new ViewGroup.LayoutParams(-1, -1);
        uiVar2.setOrientation(1);
        uiVar2.setLayoutParams(layoutParams6);
        String MGA = dZ.MGA();
        String wC = dZ.wC();
        String str = "Android " + Build.VERSION.RELEASE;
        String str2 = Build.BRAND + " " + Build.MODEL;
        com.bytedance.sdk.openadsdk.core.ui.ui eli = eli(context, "SDK version", BuildConfig.VERSION_NAME);
        com.bytedance.sdk.openadsdk.core.ui.ui eli2 = eli(context, "App", MGA);
        com.bytedance.sdk.openadsdk.core.ui.ui eli3 = eli(context, "App version", wC);
        com.bytedance.sdk.openadsdk.core.ui.ui eli4 = eli(context, b.d, str);
        com.bytedance.sdk.openadsdk.core.ui.ui eli5 = eli(context, "Device", str2);
        com.bytedance.sdk.openadsdk.core.ui.ui eli6 = eli(context, "Creative info", "loading ...");
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar3 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, eli(76.0f));
        uiVar3.setBackgroundColor(-1);
        uiVar3.setLayoutParams(layoutParams7);
        this.ui = new Button(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -1);
        int eli7 = eli(16.0f);
        layoutParams8.setMargins(eli7, eli7, eli7, eli7);
        this.ui.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_ad_report_info_button_bg"));
        this.ui.setText("copy all");
        this.ui.setTextColor(Color.parseColor("#333333"));
        this.ui.setTextSize(14.0f);
        this.ui.setLayoutParams(layoutParams8);
        uiVar.addView(kbVar);
        kbVar.addView(wCVar);
        kbVar.addView(this.MGA);
        uiVar.addView(view);
        uiVar.addView(scrollView);
        scrollView.addView(uiVar2);
        uiVar2.addView(eli);
        uiVar2.addView(eli2);
        uiVar2.addView(eli3);
        uiVar2.addView(eli4);
        uiVar2.addView(eli5);
        uiVar2.addView(eli6);
        uiVar.addView(uiVar3);
        uiVar3.addView(this.ui);
        return uiVar;
    }

    private com.bytedance.sdk.openadsdk.core.ui.ui eli(Context context, String str, String str2) {
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, str.equals("Creative info") ? -2 : eli(74.0f));
        uiVar.setOrientation(1);
        uiVar.setPadding(0, eli(16.0f), 0, eli(16.0f));
        uiVar.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.bottomMargin = eli(7.0f);
        wCVar.setIncludeFontPadding(false);
        wCVar.setText(str);
        wCVar.setTextColor(Color.parseColor("#333333"));
        wCVar.setTextSize(16.0f);
        wCVar.setTypeface(Typeface.defaultFromStyle(1));
        wCVar.setLayoutParams(layoutParams2);
        uiVar.addView(wCVar);
        com.bytedance.sdk.openadsdk.core.ui.wC wCVar2 = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        if (str.equals("Creative info")) {
            this.aGH = wCVar2;
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        wCVar2.setIncludeFontPadding(false);
        wCVar2.setTextColor(Color.parseColor("#666666"));
        wCVar2.setText(str2);
        wCVar2.setTextSize(14.0f);
        wCVar2.setLayoutParams(layoutParams3);
        uiVar.addView(wCVar2);
        return uiVar;
    }

    private int eli(float f) {
        return SSo.DbA(getContext(), f);
    }
}
