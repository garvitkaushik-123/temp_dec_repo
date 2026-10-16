package com.bytedance.sdk.openadsdk.common;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.widget.eli.MGA;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aqO {
    private final com.bytedance.sdk.component.FC.MGA DbA;
    private ImageView MGA;
    private final ev Os;
    private final String aGH;
    private final LinearLayout eli;
    private ImageView kb;
    private final Context ui;
    private MGA.eli wC;

    public aqO(Context context, LinearLayout linearLayout, com.bytedance.sdk.component.FC.MGA mga, ev evVar, String str) {
        this.ui = context;
        this.eli = linearLayout;
        this.DbA = mga;
        this.Os = evVar;
        this.aGH = str;
        Os();
    }

    private void Os() {
        this.MGA = (ImageView) this.eli.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.PfW);
        this.kb = (ImageView) this.eli.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.Ca);
        ImageView imageView = (ImageView) this.eli.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.yKf);
        ImageView imageView2 = (ImageView) this.eli.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.rn);
        this.MGA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.aqO.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aqO.this.DbA == null || !aqO.this.DbA.FC()) {
                    return;
                }
                if (aqO.this.wC != null) {
                    aqO.this.wC.eli();
                }
                aqO.this.eli(ToolBar.BACKWARD);
                aqO.this.DbA.aAs();
            }
        });
        this.kb.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.aqO.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aqO.this.DbA == null || !aqO.this.DbA.du()) {
                    return;
                }
                aqO.this.eli(ToolBar.FORWARD);
                aqO.this.DbA.nlS();
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.aqO.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aqO.this.DbA != null) {
                    aqO.this.DbA(ToolBar.REFRESH);
                    aqO.this.DbA.wC();
                }
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.aqO.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aqO.this.DbA != null) {
                    aqO.this.DbA("external_btn_click");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    String url = aqO.this.DbA.getUrl();
                    if (TextUtils.isEmpty(url)) {
                        return;
                    }
                    intent.setData(Uri.parse(url));
                    com.bytedance.sdk.component.utils.DbA.eli(aqO.this.ui, intent, null);
                }
            }
        });
        this.eli.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.common.aqO.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.MGA.setClickable(false);
        this.kb.setClickable(false);
        this.MGA.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
        this.kb.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
    }

    public void eli(WebView webView, MGA.eli eliVar) {
        this.wC = eliVar;
        try {
            if (this.MGA != null) {
                if (webView.canGoBack()) {
                    this.MGA.setClickable(true);
                    this.MGA.clearColorFilter();
                } else {
                    this.MGA.setClickable(false);
                    this.MGA.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
                }
            }
            if (this.kb != null) {
                if (webView.canGoForward()) {
                    this.kb.setClickable(true);
                    this.kb.clearColorFilter();
                } else {
                    this.kb.setClickable(false);
                    this.kb.setColorFilter(Color.parseColor("#A8FFFFFF"), PorterDuff.Mode.ADD);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void eli() {
        if (this.eli.getAlpha() == 0.0f) {
            ObjectAnimator.ofFloat(this.eli, "alpha", 0.0f, 1.0f).setDuration(300L).start();
        }
    }

    public void DbA() {
        if (this.eli.getAlpha() == 1.0f) {
            ObjectAnimator.ofFloat(this.eli, "alpha", 1.0f, 0.0f).setDuration(300L).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(String str) {
        WebBackForwardList copyBackForwardList;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.DbA.getWebView() != null && (copyBackForwardList = this.DbA.getWebView().copyBackForwardList()) != null) {
                int currentIndex = copyBackForwardList.getCurrentIndex();
                String url = copyBackForwardList.getItemAtIndex(currentIndex).getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = this.DbA.getUrl();
                }
                String str2 = "";
                if (str.equals(ToolBar.BACKWARD)) {
                    str2 = copyBackForwardList.getItemAtIndex(currentIndex - 1).getUrl();
                }
                int i = 1;
                if (str.equals(ToolBar.FORWARD)) {
                    str2 = copyBackForwardList.getItemAtIndex(currentIndex + 1).getUrl();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("url", url);
                jSONObject2.putOpt("next_url", str2);
                if (copyBackForwardList.getCurrentIndex() != 0) {
                    i = 0;
                }
                jSONObject2.putOpt("first_page", Integer.valueOf(i));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), this.Os, this.aGH, str, jSONObject, (com.bytedance.sdk.openadsdk.aGH.kb) null, (com.bytedance.sdk.openadsdk.aGH.DbA.eli) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DbA(String str) {
        WebBackForwardList copyBackForwardList;
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.DbA.getWebView() != null && (copyBackForwardList = this.DbA.getWebView().copyBackForwardList()) != null) {
                String url = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex()).getUrl();
                if (TextUtils.isEmpty(url)) {
                    url = this.DbA.getUrl();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.putOpt("url", url);
                jSONObject2.putOpt("first_page", Integer.valueOf(copyBackForwardList.getCurrentIndex() == 0 ? 1 : 0));
                jSONObject.put("ad_extra_data", jSONObject2.toString());
            }
        } catch (Exception unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.eli(System.currentTimeMillis(), this.Os, this.aGH, str, jSONObject, (com.bytedance.sdk.openadsdk.aGH.kb) null, (com.bytedance.sdk.openadsdk.aGH.DbA.eli) null);
    }
}
