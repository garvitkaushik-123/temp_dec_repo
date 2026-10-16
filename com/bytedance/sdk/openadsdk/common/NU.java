package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.widget.eli.MGA;

/* loaded from: classes3.dex */
public class NU {
    private RelativeLayout DbA;
    private final String MGA;
    private final Context Os;
    private com.bytedance.sdk.component.FC.MGA aGH;
    private final ev eli;
    private nGm kb;
    private ImageView ui;
    private aqO wC;

    public NU(Context context, ev evVar, String str) {
        this.Os = context;
        this.eli = evVar;
        this.MGA = str;
        MGA();
    }

    private static RelativeLayout eli(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.addView(new FC(context));
        com.bytedance.sdk.component.FC.MGA mga = new com.bytedance.sdk.component.FC.MGA(context);
        mga.setId(com.bytedance.sdk.openadsdk.utils.aqO.ikX);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(12);
        layoutParams.addRule(3, com.bytedance.sdk.openadsdk.utils.aqO.gHb);
        relativeLayout.addView(mga, layoutParams);
        wC wCVar = new wC(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(wCVar.getLayoutParams());
        layoutParams2.addRule(12);
        relativeLayout.addView(wCVar, layoutParams2);
        return relativeLayout;
    }

    private void MGA() {
        RelativeLayout eli = eli(this.Os);
        this.DbA = eli;
        this.aGH = (com.bytedance.sdk.component.FC.MGA) eli.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.ikX);
        nGm ngm = new nGm(this.Os, (RelativeLayout) this.DbA.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.gHb), this.eli);
        this.kb = ngm;
        this.ui = ngm.Os();
        this.wC = new aqO(this.Os, (LinearLayout) this.DbA.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.eEH), this.aGH, this.eli, this.MGA);
    }

    public void eli() {
        nGm ngm = this.kb;
        if (ngm != null) {
            ngm.eli();
        }
        aqO aqo = this.wC;
        if (aqo != null) {
            aqo.eli();
        }
    }

    public void DbA() {
        nGm ngm = this.kb;
        if (ngm != null) {
            ngm.DbA();
        }
        aqO aqo = this.wC;
        if (aqo != null) {
            aqo.DbA();
        }
    }

    public ImageView Os() {
        return this.ui;
    }

    public com.bytedance.sdk.component.FC.MGA aGH() {
        return this.aGH;
    }

    public View ui() {
        return this.DbA;
    }

    public void eli(WebView webView, int i, MGA.eli eliVar) {
        nGm ngm = this.kb;
        if (ngm != null) {
            ngm.eli(i);
        }
        aqO aqo = this.wC;
        if (aqo != null) {
            aqo.eli(webView, eliVar);
        }
    }
}
