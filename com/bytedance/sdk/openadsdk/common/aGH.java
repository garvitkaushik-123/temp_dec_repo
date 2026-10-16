package com.bytedance.sdk.openadsdk.common;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import com.bytedance.sdk.component.utils.Ue;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.cyF;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class aGH implements Ue.eli {
    private final boolean DbA;
    private long Dfc;
    private int FC;
    private int NU;
    private WebView Os;
    private int QX;
    private String Xb;
    private long aAs;
    private final com.bytedance.sdk.component.FC.MGA aGH;
    private boolean aqO;
    private final ev eli;
    private boolean nn;
    private Os ui;
    private float wC;
    private String MGA = "landingpage";
    private final Handler kb = new Ue(com.bytedance.sdk.openadsdk.core.nn.DbA().getLooper(), this);
    private final AtomicBoolean du = new AtomicBoolean(false);
    private Pattern nlS = null;
    private long nGm = -1;
    private final List<Integer> dV = new ArrayList();

    public aGH(ev evVar, com.bytedance.sdk.component.FC.MGA mga, String str, boolean z) {
        this.eli = evVar;
        this.aGH = mga;
        this.DbA = z;
        DbA();
    }

    public void eli(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.MGA = str;
    }

    private void DbA() {
        com.bytedance.sdk.component.FC.MGA mga = this.aGH;
        if (mga != null) {
            this.Os = mga.getWebView();
            View arbitrageLoadingView = this.aGH.getArbitrageLoadingView();
            if (arbitrageLoadingView instanceof Os) {
                this.ui = (Os) arbitrageLoadingView;
            }
        }
        this.FC = com.bytedance.sdk.openadsdk.core.settings.NU.nY().Kp();
        this.wC = com.bytedance.sdk.openadsdk.core.settings.NU.nY().MQ();
    }

    public void eli(WebView webView, String str, boolean z) {
        if (z && MGA()) {
            eli();
        }
    }

    public void eli(WebView webView, String str) {
        ev evVar = this.eli;
        if (evVar == null || !com.bytedance.sdk.component.FC.DbA.eli(evVar.Xb().DbA(), str)) {
            return;
        }
        this.NU++;
        com.bytedance.sdk.component.utils.FC.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.aGH.1
            @Override // java.lang.Runnable
            public void run() {
                if (aGH.this.MGA()) {
                    aGH.this.eli();
                }
            }
        });
    }

    public void eli(WebView webView, int i) {
        Os os = this.ui;
        if (os != null) {
            os.eli(i);
        }
        if (this.aqO) {
            if (eli(i, 30)) {
                eli(30, webView);
            }
            if (eli(i, 50)) {
                eli(50, webView);
            }
            if (eli(i, 70)) {
                eli(70, webView);
            }
        }
        if (this.ui == null || i != 100) {
            return;
        }
        eli(1);
    }

    public void DbA(WebView webView, String str, boolean z) {
        if (!z || this.ui == null) {
            return;
        }
        eli(1);
    }

    public void Os(WebView webView, String str, boolean z) {
        this.dV.clear();
        this.aqO = z;
        if (z) {
            this.nn = true;
        }
        this.QX = kb();
    }

    private void Os() {
        Handler handler = this.kb;
        if (handler != null) {
            handler.sendEmptyMessageDelayed(1, this.FC);
        }
    }

    private void aGH() {
        Handler handler = this.kb;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    public void eli() {
        if (cyF.MGA()) {
            ui();
        } else {
            com.bytedance.sdk.component.utils.FC.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.aGH.2
                @Override // java.lang.Runnable
                public void run() {
                    aGH.this.ui();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ui() {
        this.nn = false;
        if (this.du.getAndSet(true)) {
            return;
        }
        this.aAs = SystemClock.elapsedRealtime();
        this.Dfc = System.currentTimeMillis();
        wC();
        if (this.ui == null) {
            return;
        }
        WebView webView = this.Os;
        if (webView != null) {
            String url = webView.getUrl();
            this.Xb = url;
            new Object[]{"showLoadingUrl is:", url};
        }
        this.ui.setVisibility(0);
        this.ui.eli(this.eli);
        this.ui.eli();
        this.ui.setAlpha(this.wC);
        this.ui.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.common.aGH.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        aGH();
        Os();
    }

    private void eli(final int i) {
        WebView webView = this.Os;
        if (webView != null && i == 1) {
            String url = webView.getUrl();
            new Object[]{"destroyLoadingUrl is:", url};
            if (TextUtils.isEmpty(url) || url.equals(this.Xb)) {
                return;
            }
        }
        com.bytedance.sdk.component.utils.FC.DbA().post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.common.aGH.4
            @Override // java.lang.Runnable
            public void run() {
                if (aGH.this.ui != null) {
                    aGH.this.du.set(false);
                    aGH.this.ui.eli(aGH.this.eli, aGH.this.MGA, i, aGH.this.Xb, aGH.this.aAs, aGH.this.nn, aGH.this.NU, aGH.this.Dfc);
                    aGH.this.NU = 0;
                }
            }
        });
        aGH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean MGA() {
        return kb() > 0 && !this.du.get();
    }

    private int kb() {
        try {
            return this.Os.copyBackForwardList().getCurrentIndex() + 1;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.component.utils.Ue.eli
    public void eli(Message message) {
        if (message.what == 1) {
            eli(0);
        }
    }

    public void eli(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.nGm = SystemClock.elapsedRealtime();
        }
    }

    private boolean eli(int i, int i2) {
        if (i < i2 || this.dV.contains(Integer.valueOf(i2)) || this.QX < 2) {
            return false;
        }
        this.dV.add(Integer.valueOf(i2));
        return true;
    }

    private void eli(int i, WebView webView) {
        new Object[]{Integer.valueOf(i)};
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_progress", i);
            jSONObject.put("progress_timestamp", System.currentTimeMillis());
            jSONObject.put("arbi_current_url", webView.getUrl());
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.Os(this.eli, this.MGA, jSONObject);
    }

    private void wC() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("loading_show_interval", SystemClock.elapsedRealtime() - this.nGm);
            jSONObject.put("loading_show_timestamp", this.Dfc);
            WebView webView = this.Os;
            jSONObject.put("arbi_current_url", webView != null ? webView.getUrl() : "");
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.aGH.Os.DbA(this.eli, this.MGA, jSONObject);
    }
}
