package com.bytedance.sdk.openadsdk.core.aAs.Os;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import com.bytedance.sdk.component.FC.MGA;
import com.bytedance.sdk.component.adexpress.DbA.du;
import com.bytedance.sdk.component.adexpress.DbA.nn;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.model.dV;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.core.wC.Dfc;
import com.bytedance.sdk.openadsdk.core.widget.eli.ui;
import com.bytedance.sdk.openadsdk.utils.QX;
import com.bytedance.sdk.openadsdk.utils.Uv;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH implements du, Os<MGA> {
    private ev DbA;
    private eli MGA;
    private MGA Os;
    private qj aGH;
    private Context eli;
    private int kb;
    private String ui;

    @Override // com.bytedance.sdk.component.adexpress.DbA.du
    public void eli(View view, int i, com.bytedance.sdk.component.adexpress.Os os) {
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.du
    public void eli(nn nnVar) {
    }

    public aGH(Context context, ev evVar) {
        this.kb = 1;
        this.eli = context;
        this.DbA = evVar;
        this.kb = evVar.WO();
        this.ui = dV.DbA(this.DbA).eli(this.kb == 1);
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.Os.Os
    public void eli() {
        this.Os = new MGA(this.eli);
        kb();
        wC();
        Uv.eli(this.Os, false, this.DbA.bBQ(), false, new Uv.DbA() { // from class: com.bytedance.sdk.openadsdk.core.aAs.Os.aGH.1
            @Override // com.bytedance.sdk.openadsdk.utils.Uv.DbA
            public void eli(View view, boolean z) {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.Uv.DbA
            public void eli(boolean z) {
                aGH.this.eli(z);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.Uv.DbA
            public void eli() {
                aGH.this.eli(true);
            }

            @Override // com.bytedance.sdk.openadsdk.utils.Uv.DbA
            public void DbA() {
                aGH.this.eli(false);
            }
        }, null);
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.Os.Os
    public void DbA() {
        if (TextUtils.isEmpty(this.ui)) {
            this.Os.setVisibility(8);
        } else {
            this.Os.a_(this.ui);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.Os.Os
    public void eli(eli eliVar) {
        this.MGA = eliVar;
    }

    public qj ui() {
        return this.aGH;
    }

    private void kb() {
        this.Os.setBackgroundColor(0);
        this.Os.setBackgroundResource(R.color.transparent);
        this.Os.setVisibility(8);
        eli(this.Os);
        if (this.DbA != null) {
            this.Os.setWebViewClient(new ui(this.eli, this.aGH, this.DbA.umh(), null, false));
        }
        com.bytedance.sdk.component.adexpress.ui.ui.eli().eli(this.Os, this.aGH);
        this.Os.setWebChromeClient(new com.bytedance.sdk.openadsdk.core.widget.eli.aGH(this.aGH));
    }

    private void eli(MGA mga) {
        if (mga == null) {
            return;
        }
        try {
            com.bytedance.sdk.openadsdk.core.widget.eli.Os.eli(this.eli).eli(false).eli(mga.getWebView());
            mga.setVerticalScrollBarEnabled(false);
            mga.setHorizontalScrollBarEnabled(false);
            com.bytedance.sdk.openadsdk.core.widget.eli.Os.eli(mga);
            mga.nn();
            mga.setUserAgentString(QX.eli(mga.getWebView(), BuildConfig.VERSION_CODE));
            mga.setMixedContentMode(0);
            mga.setJavaScriptEnabled(true);
            mga.setJavaScriptCanOpenWindowsAutomatically(true);
            mga.setDomStorageEnabled(true);
            mga.setDatabaseEnabled(true);
            mga.setAllowFileAccess(false);
            mga.setSupportZoom(true);
            mga.setBuiltInZoomControls(true);
            mga.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
            mga.setUseWideViewPort(true);
            mga.setCacheMode(-1);
        } catch (Exception unused) {
        }
    }

    private void wC() {
        qj qjVar = new qj(this.eli);
        this.aGH = qjVar;
        qjVar.DbA(this.Os).eli(this.DbA).Os(this.DbA.umh()).aGH(this.DbA.eu()).ui(this.DbA.WA()).eli(com.bytedance.sdk.openadsdk.core.wC.eli.DbA.eli(0.0f, 0.0f, false, this.DbA, null, null)).eli(this).eli(this.Os);
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.Os.Os
    public void eli(Dfc dfc) {
        qj qjVar = this.aGH;
        if (qjVar != null) {
            qjVar.eli(dfc);
        }
    }

    public void eli(boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("visibleState", !z ? 1 : 0);
        } catch (Exception e) {
            e.getMessage();
        }
        this.aGH.eli("visibleStateChange", jSONObject);
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.Os.Os
    public void Os() {
        qj qjVar = this.aGH;
        if (qjVar != null) {
            qjVar.Os();
        }
        this.aGH = null;
        try {
            MGA mga = this.Os;
            if (mga != null) {
                ViewGroup viewGroup = (ViewGroup) mga.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(this.Os);
                }
                this.Os.aqO();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.aAs.Os.Os
    /* renamed from: MGA, reason: merged with bridge method [inline-methods] */
    public MGA aGH() {
        return this.Os;
    }
}
