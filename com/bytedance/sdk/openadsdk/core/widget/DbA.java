package com.bytedance.sdk.openadsdk.core.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.window.OnBackInvokedCallback;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.component.utils.ev;
import com.bytedance.sdk.openadsdk.utils.SSo;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class DbA extends Dialog {
    private com.bytedance.sdk.openadsdk.core.ui.aGH DbA;
    private boolean Dfc;
    private String FC;
    private com.bytedance.sdk.openadsdk.core.ui.eli MGA;
    private int NU;
    private com.bytedance.sdk.openadsdk.core.ui.wC Os;
    private String aAs;
    private com.bytedance.sdk.openadsdk.core.ui.wC aGH;
    private String du;
    public InterfaceC0204DbA eli;
    private View kb;
    private String nlS;
    private OnBackInvokedCallback nn;
    private com.bytedance.sdk.openadsdk.core.ui.eli ui;
    private final Context wC;

    /* renamed from: com.bytedance.sdk.openadsdk.core.widget.DbA$DbA, reason: collision with other inner class name */
    public interface InterfaceC0204DbA {
        void DbA();

        void eli();
    }

    private static class eli implements OnBackInvokedCallback {
        private final WeakReference<DbA> eli;

        eli(DbA dbA) {
            this.eli = new WeakReference<>(dbA);
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            DbA dbA = this.eli.get();
            if (dbA != null) {
                Xb.eli("CustomCommonDialog", "onBackInvoked");
                dbA.onBackPressed();
            }
        }
    }

    public DbA(Context context) {
        super(context, ev.MGA(context, "tt_custom_dialog"));
        this.NU = -1;
        this.Dfc = false;
        this.wC = context;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(eli(this.wC));
        if (com.bytedance.sdk.openadsdk.utils.ev.eli()) {
            Xb.eli("CustomCommonDialog", "isAtLeastT registerOnBackInvokedCallback");
            this.nn = new eli(this);
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.nn);
        }
        setCanceledOnTouchOutside(false);
        DbA();
        eli();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Xb.eli("CustomCommonDialog", "onBackPressed");
    }

    private void eli() {
        this.MGA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.DbA.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DbA.this.eli != null) {
                    DbA.this.eli.eli();
                }
            }
        });
        this.ui.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.DbA.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DbA.this.eli != null) {
                    DbA.this.eli.DbA();
                }
            }
        });
    }

    private void DbA() {
        if (!TextUtils.isEmpty(this.aAs)) {
            this.Os.setText(this.aAs);
            this.Os.setVisibility(0);
        } else {
            this.Os.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.FC)) {
            this.aGH.setText(this.FC);
        }
        if (!TextUtils.isEmpty(this.du)) {
            this.MGA.setText(this.du);
        } else {
            this.MGA.setText(ev.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), "tt_postive_txt"));
        }
        if (!TextUtils.isEmpty(this.nlS)) {
            this.ui.setText(this.nlS);
        } else {
            this.ui.setText(ev.eli(com.bytedance.sdk.openadsdk.core.dV.eli(), "tt_negtive_txt"));
        }
        int i = this.NU;
        if (i != -1) {
            this.DbA.setImageResource(i);
            this.DbA.setVisibility(0);
        } else {
            this.DbA.setVisibility(8);
        }
        if (this.Dfc) {
            this.kb.setVisibility(8);
            this.ui.setVisibility(8);
        } else {
            this.ui.setVisibility(0);
            this.kb.setVisibility(0);
        }
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        DbA();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        Os();
    }

    private void Os() {
        if (this.nn == null || !com.bytedance.sdk.openadsdk.utils.ev.eli()) {
            return;
        }
        Xb.eli("CustomCommonDialog", "isAtLeastT unregisterOnBackInvokedCallback");
        getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.nn);
    }

    private View eli(Context context) {
        com.bytedance.sdk.openadsdk.core.ui.kb kbVar = new com.bytedance.sdk.openadsdk.core.ui.kb(context);
        kbVar.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        uiVar.setMinimumWidth(eli(260.0f));
        uiVar.setPadding(0, eli(32.0f), 0, 0);
        uiVar.setBackground(com.bytedance.sdk.openadsdk.utils.du.eli(context, "tt_custom_dialog_bg"));
        uiVar.setOrientation(1);
        uiVar.setLayoutParams(layoutParams);
        this.Os = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 17;
        layoutParams2.leftMargin = eli(16.0f);
        layoutParams2.rightMargin = eli(16.0f);
        layoutParams2.bottomMargin = eli(16.0f);
        this.Os.setGravity(17);
        this.Os.setVisibility(0);
        this.Os.setTextColor(Color.parseColor("#333333"));
        this.Os.setTextSize(18.0f);
        this.Os.setLayoutParams(layoutParams2);
        this.DbA = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        layoutParams3.leftMargin = eli(16.0f);
        layoutParams3.rightMargin = eli(16.0f);
        layoutParams3.bottomMargin = eli(10.0f);
        this.DbA.setMaxHeight(eli(150.0f));
        this.DbA.setMaxWidth(eli(150.0f));
        this.DbA.setVisibility(0);
        this.DbA.setLayoutParams(layoutParams3);
        this.aGH = new com.bytedance.sdk.openadsdk.core.ui.wC(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.leftMargin = eli(20.0f);
        layoutParams4.rightMargin = eli(20.0f);
        this.aGH.setGravity(17);
        this.aGH.setLineSpacing(eli(3.0f), 1.2f);
        this.aGH.setTextSize(18.0f);
        this.aGH.setTextColor(Color.parseColor("#000000"));
        this.aGH.setLayoutParams(layoutParams4);
        View view = new View(context);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, 1);
        layoutParams5.topMargin = eli(32.0f);
        view.setBackgroundColor(Color.parseColor("#E4E4E4"));
        view.setLayoutParams(layoutParams5);
        com.bytedance.sdk.openadsdk.core.ui.ui uiVar2 = new com.bytedance.sdk.openadsdk.core.ui.ui(context);
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-1, -2);
        uiVar2.setOrientation(0);
        uiVar2.setLayoutParams(layoutParams6);
        com.bytedance.sdk.openadsdk.core.ui.eli eliVar = new com.bytedance.sdk.openadsdk.core.ui.eli(context);
        this.ui = eliVar;
        eliVar.setId(520093718);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(0, -2);
        layoutParams7.leftMargin = eli(10.0f);
        layoutParams7.weight = 1.0f;
        this.ui.setPadding(0, eli(16.0f), 0, eli(16.0f));
        this.ui.setBackground(null);
        this.ui.setGravity(17);
        this.ui.setSingleLine(true);
        this.ui.setTextColor(Color.parseColor("#999999"));
        this.ui.setTextSize(16.0f);
        this.ui.setLayoutParams(layoutParams7);
        this.kb = new View(context);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(1, -1);
        this.kb.setBackgroundColor(Color.parseColor("#E4E4E4"));
        this.kb.setLayoutParams(layoutParams8);
        this.MGA = new com.bytedance.sdk.openadsdk.core.ui.eli(context);
        this.ui.setId(520093719);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(0, -2);
        layoutParams9.rightMargin = eli(10.0f);
        layoutParams9.weight = 1.0f;
        this.MGA.setPadding(0, eli(16.0f), 0, eli(16.0f));
        this.MGA.setBackground(null);
        this.MGA.setGravity(17);
        this.MGA.setSingleLine(true);
        this.MGA.setTextColor(Color.parseColor("#38ADFF"));
        this.MGA.setTextSize(16.0f);
        this.MGA.setLayoutParams(layoutParams9);
        kbVar.addView(uiVar);
        uiVar.addView(this.Os);
        uiVar.addView(this.DbA);
        uiVar.addView(this.aGH);
        uiVar.addView(view);
        uiVar.addView(uiVar2);
        uiVar2.addView(this.ui);
        uiVar2.addView(this.kb);
        uiVar2.addView(this.MGA);
        return kbVar;
    }

    private int eli(float f) {
        return SSo.DbA(getContext(), f);
    }

    public DbA eli(InterfaceC0204DbA interfaceC0204DbA) {
        this.eli = interfaceC0204DbA;
        return this;
    }

    public DbA eli(String str) {
        this.FC = str;
        return this;
    }

    public DbA DbA(String str) {
        this.du = str;
        return this;
    }

    public DbA Os(String str) {
        this.nlS = str;
        return this;
    }
}
