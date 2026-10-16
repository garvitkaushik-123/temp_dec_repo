package com.bytedance.sdk.openadsdk.core.widget.eli;

import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.BuildConfig;
import com.bytedance.sdk.openadsdk.core.dV;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.utils.QX;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class DbA implements eli {
    private com.bytedance.sdk.component.FC.MGA DbA;
    private final AtomicInteger Os;
    private final MessageQueue aGH;
    qj eli;
    private final boolean ui;

    public DbA(int i, boolean z, MessageQueue messageQueue) {
        this.Os = new AtomicInteger(i);
        this.ui = z;
        this.aGH = messageQueue;
    }

    public void DbA() {
        if (this.Os.get() <= 0) {
            return;
        }
        new StringBuilder("preload start ,isV3 = ").append(this.ui).append(",preloadSize = ").append(this.Os);
        String aGH = com.bytedance.sdk.component.adexpress.eli.DbA.DbA.aGH(null);
        if (this.ui) {
            String aGH2 = com.bytedance.sdk.component.adexpress.eli.DbA.DbA.aGH("v3");
            if (aGH != null && aGH.equals(aGH2)) {
                return;
            } else {
                aGH = aGH2;
            }
        }
        if (TextUtils.isEmpty(aGH)) {
            return;
        }
        try {
            com.bytedance.sdk.component.FC.MGA mga = new com.bytedance.sdk.component.FC.MGA(new MutableContextWrapper(dV.eli()));
            this.DbA = mga;
            if (mga.getWebView() == null) {
                return;
            }
            this.DbA.setWebViewClient(new WebViewClient() { // from class: com.bytedance.sdk.openadsdk.core.widget.eli.DbA.1
                @Override // android.webkit.WebViewClient
                public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
                    return true;
                }
            });
            eli(this.DbA);
            Uri build = Uri.parse(aGH).buildUpon().appendQueryParameter("isPreLoad", "1").build();
            qj qjVar = new qj(this.DbA.getContext());
            this.eli = qjVar;
            qjVar.DbA(this.DbA).eli(this).eli(this.DbA);
            com.bytedance.sdk.component.adexpress.ui.ui.eli().eli(this.DbA, this.eli);
            this.DbA.a_(build.toString());
        } catch (Exception unused) {
        }
    }

    private void eli(com.bytedance.sdk.component.FC.MGA mga) {
        if (mga == null || mga.getWebView() == null) {
            return;
        }
        try {
            Os.eli(dV.eli()).eli(false).eli(mga.getWebView());
            mga.setVerticalScrollBarEnabled(false);
            mga.setHorizontalScrollBarEnabled(false);
            Os.eli(mga);
            mga.nn();
            mga.setUserAgentString(QX.eli(mga.getWebView(), BuildConfig.VERSION_CODE));
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
        } catch (Throwable th) {
            Xb.Os("WebViewPool", th.toString());
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.eli.eli
    public void eli() {
        MessageQueue messageQueue;
        if (this.ui) {
            com.bytedance.sdk.component.adexpress.ui.ui.eli().DbA(this.DbA);
        } else {
            com.bytedance.sdk.component.adexpress.ui.ui.eli().Os(this.DbA);
        }
        try {
            new Object[]{"preload finish ", Integer.valueOf(this.Os.get()), "isV3 ?? ", Boolean.valueOf(this.ui)};
            this.Os.decrementAndGet();
            if (this.Os.get() <= 0 || (messageQueue = this.aGH) == null) {
                return;
            }
            messageQueue.addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.bytedance.sdk.openadsdk.core.widget.eli.DbA.2
                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    new DbA(DbA.this.Os.get(), DbA.this.ui, DbA.this.aGH).DbA();
                    return false;
                }
            });
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
