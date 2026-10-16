package com.bytedance.sdk.openadsdk.component.reward.eli;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.FC.MGA;
import com.bytedance.sdk.openadsdk.core.cyF;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.DeviceUtils;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.ironsource.unity.androidbridge.AndroidBridgeConstants;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class nGm implements com.bytedance.sdk.openadsdk.nlS.wC {
    private final ev DbA;
    private final com.bytedance.sdk.openadsdk.component.reward.eli.eli FC;
    private com.bytedance.sdk.openadsdk.core.DbA.kb MGA;
    private com.bytedance.sdk.component.FC.MGA Os;
    private int aAs;
    private ImageView aGH;
    private final Activity eli;
    private final AtomicBoolean kb = new AtomicBoolean(false);
    private boolean ui;
    private volatile boolean wC;

    public nGm(com.bytedance.sdk.openadsdk.component.reward.eli.eli eliVar) {
        this.FC = eliVar;
        this.DbA = eliVar.DbA;
        this.eli = eliVar.SSo;
    }

    public void eli() {
        DeviceUtils.AudioInfoReceiver.eli(this);
        this.aAs = DeviceUtils.kb();
        if (this.DbA.io() != null) {
            this.MGA = new com.bytedance.sdk.openadsdk.core.DbA.kb("VAST_END_CARD", this.DbA.io()) { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.nGm.1
            };
            com.bytedance.sdk.openadsdk.core.du.Os Os = this.DbA.io().Os();
            if (Os != null) {
                String ui = Os.ui();
                if (!TextUtils.isEmpty(ui)) {
                    this.ui = true;
                    this.aGH = (ImageView) this.FC.dZ.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.wC);
                    eli(Os.DbA(), Os.Os());
                    com.bytedance.sdk.openadsdk.FC.aGH.eli(ui).eli(Os.DbA()).DbA(Os.Os()).ui(SSo.ui(com.bytedance.sdk.openadsdk.core.dV.eli())).aGH(SSo.Os(com.bytedance.sdk.openadsdk.core.dV.eli())).Os(1).eli(new com.bytedance.sdk.openadsdk.FC.DbA(this.DbA, ui, new eli(this.aGH, ui, this, this.kb)));
                    return;
                }
                com.bytedance.sdk.component.FC.MGA mga = (com.bytedance.sdk.component.FC.MGA) this.FC.dZ.findViewById(com.bytedance.sdk.openadsdk.utils.aqO.FC);
                this.Os = mga;
                if (mga == null) {
                    return;
                }
                aGH();
                String aGH = Os.aGH();
                if (aGH != null) {
                    this.ui = true;
                    if (aGH.startsWith("http")) {
                        this.Os.a_(aGH);
                        return;
                    }
                    String eli2 = com.bytedance.sdk.openadsdk.core.du.ui.eli(aGH);
                    String str = TextUtils.isEmpty(eli2) ? aGH : eli2;
                    this.Os.setDefaultTextEncodingName("UTF -8");
                    this.Os.eli(null, str, "text/html", "UTF-8", null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Os() {
        eli(Integer.MAX_VALUE, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(final int i, final String str) {
        if (this.wC) {
            return;
        }
        this.wC = true;
        if (i == Integer.MAX_VALUE) {
            ev evVar = this.DbA;
            com.bytedance.sdk.openadsdk.aGH.Os.DbA(evVar, evVar.aGH(), "load_vast_endcard_success", (JSONObject) null);
        } else {
            com.bytedance.sdk.openadsdk.aGH.Os.eli(new com.bytedance.sdk.component.wC.wC("load_vast_endcard_fail") { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.nGm.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("reason_code", i);
                        jSONObject.put(AndroidBridgeConstants.ERROR_CODE, i);
                        String str2 = str;
                        if (str2 != null) {
                            jSONObject.put("url", str2);
                        }
                        com.bytedance.sdk.openadsdk.aGH.Os.DbA(nGm.this.DbA, nGm.this.DbA.aGH(), "load_vast_endcard_fail", jSONObject);
                    } catch (Exception unused) {
                    }
                }
            });
        }
    }

    private void aGH() {
        this.Os.ui();
        eli(this.Os);
        this.Os.setDisplayZoomControls(false);
        this.Os.setWebChromeClient(new WebChromeClient() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.nGm.3
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView, int i) {
                super.onProgressChanged(webView, i);
                if (i == 100) {
                    nGm.this.Os();
                }
            }
        });
        this.Os.setWebViewClient(new MGA.eli() { // from class: com.bytedance.sdk.openadsdk.component.reward.eli.nGm.4
            @Override // android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                if (nGm.this.eli(str)) {
                    return true;
                }
                return super.shouldOverrideUrlLoading(webView, str);
            }

            @Override // android.webkit.WebViewClient
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                if (webResourceRequest.isForMainFrame()) {
                    nGm.this.eli(webResourceResponse.getStatusCode(), webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : null);
                }
            }

            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView webView, String str) {
                super.onPageFinished(webView, str);
                nGm.this.Os();
            }
        });
    }

    private void eli(com.bytedance.sdk.component.FC.MGA mga) {
        mga.setVerticalScrollBarEnabled(false);
        mga.setHorizontalScrollBarEnabled(false);
        mga.setMixedContentMode(0);
        mga.setJavaScriptEnabled(true);
        mga.setJavaScriptCanOpenWindowsAutomatically(true);
        mga.setDomStorageEnabled(true);
        mga.setDatabaseEnabled(true);
        mga.setCacheMode(-1);
        mga.setAllowFileAccess(false);
        mga.setSupportZoom(true);
        mga.setBuiltInZoomControls(true);
        mga.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        mga.setUseWideViewPort(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eli(String str) {
        ev evVar;
        if (str == null || (evVar = this.DbA) == null || evVar.io() == null || this.MGA == null) {
            return false;
        }
        this.DbA.io().MGA(str);
        this.MGA.onClick(this.Os);
        return true;
    }

    private void eli(int i, int i2) {
        if (i == 0 || i2 == 0 || this.aGH == null) {
            return;
        }
        int Os = SSo.Os((Context) this.eli);
        int ui = SSo.ui(this.eli);
        if (i / i2 <= Os / ui) {
            Os = (int) Math.ceil(r5 * r4);
        } else {
            ui = (int) Math.ceil(r5 / r4);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.aGH.getLayoutParams();
        layoutParams.width = Os;
        layoutParams.height = ui;
        layoutParams.gravity = 17;
        this.aGH.setLayoutParams(layoutParams);
        this.aGH.setOnClickListener(this.MGA);
        this.aGH.setOnTouchListener(this.MGA);
    }

    public boolean eli(aqO aqo) {
        com.bytedance.sdk.openadsdk.core.du.Os Os;
        if (!this.ui) {
            return false;
        }
        if (this.aGH != null && this.kb.get()) {
            this.aGH.setVisibility(0);
        } else {
            com.bytedance.sdk.component.FC.MGA mga = this.Os;
            if (mga != null) {
                mga.setVisibility(0);
                if (this.Os.getWebView() != null) {
                    this.Os.getWebView().setOnTouchListener(this.MGA);
                }
            }
        }
        ev evVar = this.DbA;
        if (evVar == null || evVar.io() == null || (Os = this.DbA.io().Os()) == null) {
            return true;
        }
        Os.DbA(aqo != null ? aqo.nlS() : -1L);
        return true;
    }

    public void eli(com.bytedance.sdk.openadsdk.core.DbA.ui uiVar) {
        com.bytedance.sdk.openadsdk.core.DbA.kb kbVar = this.MGA;
        if (kbVar != null) {
            kbVar.eli(uiVar);
        }
    }

    public void DbA() {
        DeviceUtils.AudioInfoReceiver.DbA(this);
        com.bytedance.sdk.component.FC.MGA mga = this.Os;
        if (mga != null) {
            cyF.eli(mga.getWebView());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.nlS.wC
    public void DbA(int i) {
        int i2 = this.aAs;
        if (i2 == 0 && i > 0) {
            this.DbA.io().eli().FC(this.FC.ev.nlS());
        } else if (i2 > 0 && i == 0) {
            this.DbA.io().eli().wC(this.FC.ev.nlS());
        }
        this.aAs = i;
    }

    private static class eli implements com.bytedance.sdk.component.ui.aqO {
        private final String DbA;
        private final WeakReference<nGm> Os;
        private final AtomicBoolean aGH;
        private final WeakReference<ImageView> eli;

        public eli(ImageView imageView, String str, nGm ngm, AtomicBoolean atomicBoolean) {
            this.eli = new WeakReference<>(imageView);
            this.DbA = str;
            this.Os = new WeakReference<>(ngm);
            this.aGH = atomicBoolean;
        }

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(com.bytedance.sdk.component.ui.du duVar) {
            nGm ngm;
            ImageView imageView = this.eli.get();
            if (imageView == null || (ngm = this.Os.get()) == null || duVar == null) {
                return;
            }
            Object DbA = duVar.DbA();
            if (DbA == null) {
                ngm.eli(-1, this.DbA);
                return;
            }
            if (DbA instanceof Bitmap) {
                imageView.setImageBitmap((Bitmap) DbA);
            } else if (DbA instanceof Drawable) {
                if (DbA instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) DbA).start();
                }
                imageView.setImageDrawable((Drawable) DbA);
            }
            this.aGH.set(true);
            ngm.Os();
        }

        @Override // com.bytedance.sdk.component.ui.aqO
        public void eli(int i, String str, Throwable th) {
            nGm ngm;
            ImageView imageView = this.eli.get();
            if (imageView == null || (ngm = this.Os.get()) == null) {
                return;
            }
            imageView.setVisibility(8);
            ngm.eli(-2, this.DbA);
        }
    }
}
