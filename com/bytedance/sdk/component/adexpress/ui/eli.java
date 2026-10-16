package com.bytedance.sdk.component.adexpress.ui;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.FC.MGA;
import com.bytedance.sdk.component.adexpress.DbA.NU;
import com.bytedance.sdk.component.adexpress.DbA.du;
import com.bytedance.sdk.component.adexpress.DbA.kb;
import com.bytedance.sdk.component.adexpress.DbA.wC;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.nn;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public abstract class eli implements com.bytedance.sdk.component.adexpress.DbA.aGH<MGA>, du, com.bytedance.sdk.component.adexpress.eli, com.bytedance.sdk.component.adexpress.theme.eli {
    protected boolean DbA;
    private String FC;
    private boolean NU;
    protected boolean Os;
    private volatile kb aAs;
    protected MGA aGH;
    private wC du;
    protected JSONObject eli;
    private Context kb;
    private NU nlS;
    private int nn;
    private String wC;
    protected int ui = 8;
    protected AtomicBoolean MGA = new AtomicBoolean(false);

    protected void FC() {
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
    public int Os() {
        return 0;
    }

    protected void aAs() {
    }

    public abstract void eli(int i);

    public abstract void kb();

    public eli(Context context, NU nu, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        this.DbA = false;
        this.kb = context;
        this.nlS = nu;
        this.wC = nu.aGH();
        themeStatusBroadcastReceiver.eli(this);
        if (com.bytedance.sdk.component.adexpress.aGH.DbA()) {
            nlS();
            return;
        }
        MGA NU = NU();
        this.aGH = NU;
        if (NU == null) {
            Log.d("WebViewRender", "initWebView: create WebView");
            if (com.bytedance.sdk.component.adexpress.aGH.eli() != null) {
                this.aGH = new MGA(com.bytedance.sdk.component.adexpress.aGH.eli());
                return;
            }
            return;
        }
        this.DbA = true;
        Log.d("WebViewRender", "initWebView: reuse WebView");
    }

    private void nlS() {
        if (this.kb == null && com.bytedance.sdk.component.adexpress.aGH.eli() != null) {
            this.kb = com.bytedance.sdk.component.adexpress.aGH.eli();
        }
        if (this.kb != null) {
            MGA NU = NU();
            this.aGH = NU;
            if (NU == null) {
                Log.d("WebViewRender", "initWebView: create WebView by act");
                this.aGH = new MGA(new MutableContextWrapper(this.kb.getApplicationContext()));
            } else {
                this.DbA = true;
                Log.d("WebViewRender", "initWebView: reuse WebView");
            }
        }
    }

    private MGA NU() {
        if (this.nlS.ev()) {
            return ui.eli().eli(this.kb, this.wC);
        }
        return ui.eli().DbA(this.kb, this.wC);
    }

    private void nn() {
        if (this.nlS.ev()) {
            ui.eli().DbA(this.aGH);
        } else {
            ui.eli().Os(this.aGH);
        }
    }

    public void eli(String str) {
        this.FC = str;
    }

    public MGA eli() {
        return this.aGH;
    }

    public void eli(wC wCVar) {
        this.du = wCVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
    public void eli(kb kbVar) {
        String str;
        this.aAs = kbVar;
        if (eli() == null || eli().getWebView() == null) {
            this.aAs.eli(102, "SSWebview null is " + (eli() == null) + " or Webview is null");
            return;
        }
        if (TextUtils.isEmpty(this.FC)) {
            this.aAs.eli(102, "url is empty");
            return;
        }
        if (!this.nlS.ev()) {
            if (!com.bytedance.sdk.component.adexpress.eli.DbA.DbA.eli(this.eli)) {
                this.aAs.eli(103, "data null is " + (this.eli == null));
                return;
            }
        } else if (Os() == 9 && !com.bytedance.sdk.component.adexpress.eli.DbA.DbA.DbA(this.eli)) {
            this.aAs.eli(103, "data null is " + (this.eli == null));
            return;
        }
        this.nlS.ui().eli(this.DbA);
        if (this.DbA) {
            try {
                int gG = this.nlS.gG();
                if (this.nlS.ev() && gG == 1) {
                    new Object[]{"trigger SDK_INJECT_DATA in reuse, templateInfo is：", this.nlS.Os()};
                    str = "javascript:window.SDK_RESET_RENDER();" + ("window.SDK_INJECT_DATA=" + this.nlS.Os() + ";") + "window.SDK_TRIGGER_RENDER();";
                } else {
                    str = "javascript:window.SDK_RESET_RENDER();window.SDK_TRIGGER_RENDER();";
                }
                this.aGH.dV();
                this.nlS.ui();
                nn.eli(this.aGH.getWebView(), str);
                return;
            } catch (Exception e) {
                ui.eli().ui(this.aGH);
                this.aAs.eli(102, "load exception is " + e.getMessage());
                return;
            }
        }
        MGA eli = eli();
        eli.dV();
        this.nlS.ui();
        eli.a_(this.FC);
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.aGH
    /* renamed from: DbA, reason: merged with bridge method [inline-methods] */
    public MGA ui() {
        return eli();
    }

    public void aGH() {
        if (this.MGA.get()) {
            return;
        }
        this.MGA.set(true);
        kb();
        if (this.aGH.getParent() != null) {
            ((ViewGroup) this.aGH.getParent()).removeView(this.aGH);
        }
        if (this.Os) {
            nn();
        } else {
            ui.eli().ui(this.aGH);
        }
    }

    public void MGA() {
        if (eli() == null) {
            return;
        }
        try {
            eli().getWebView().resumeTimers();
        } catch (Exception unused) {
        }
    }

    public void eli(boolean z) {
        this.NU = z;
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.du
    public void eli(final com.bytedance.sdk.component.adexpress.DbA.nn nnVar) {
        if (nnVar == null) {
            if (this.aAs != null) {
                this.aAs.eli(105, "renderResult is null");
                return;
            }
            return;
        }
        boolean DbA = nnVar.DbA();
        final float Os = (float) nnVar.Os();
        final float aGH = (float) nnVar.aGH();
        if (Os() == 0 && (Os <= 0.0f || aGH <= 0.0f)) {
            if (this.aAs != null) {
                this.aAs.eli(105, "width is " + Os + "height is " + aGH);
            }
        } else {
            this.Os = DbA;
            if (Looper.myLooper() == Looper.getMainLooper()) {
                eli(nnVar, Os, aGH);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.ui.eli.1
                    @Override // java.lang.Runnable
                    public void run() {
                        eli.this.eli(nnVar, Os, aGH);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eli(com.bytedance.sdk.component.adexpress.DbA.nn nnVar, float f, float f2) {
        nnVar.aAs();
        boolean z = this.Os;
        if (z && !this.NU) {
            eli(f, f2);
            eli(this.ui);
            if (this.aAs != null) {
                this.aAs.eli(eli(), nnVar);
                return;
            }
            return;
        }
        if (!z) {
            ui.eli().ui(this.aGH);
        }
        eli(nnVar.aAs(), nnVar.FC());
    }

    @Override // com.bytedance.sdk.component.adexpress.DbA.du
    public void eli(View view, int i, com.bytedance.sdk.component.adexpress.Os os) {
        wC wCVar = this.du;
        if (wCVar != null) {
            wCVar.eli(view, i, os);
        }
    }

    private void eli(float f, float f2) {
        this.nlS.ui().ui();
        if (Os() == 9) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) eli().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(-1, -1);
            }
            layoutParams.width = -1;
            layoutParams.height = -1;
            eli().setLayoutParams(layoutParams);
            return;
        }
        int eli = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.kb, f);
        int eli2 = (int) com.bytedance.sdk.component.adexpress.aGH.kb.eli(this.kb, f2);
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) eli().getLayoutParams();
        if (layoutParams2 == null) {
            layoutParams2 = new FrameLayout.LayoutParams(eli, eli2);
        }
        layoutParams2.width = eli;
        layoutParams2.height = eli2;
        eli().setLayoutParams(layoutParams2);
    }

    private void eli(int i, String str) {
        if (this.aAs != null) {
            this.aAs.eli(i, str);
        }
    }

    private int DbA(Activity activity) {
        return activity.hashCode();
    }

    public void wC() {
        FC();
        Activity eli = com.bytedance.sdk.component.utils.DbA.eli(this.aGH);
        if (eli != null) {
            this.nn = DbA(eli);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.eli
    public void eli(Activity activity) {
        if (this.nn == 0 || activity == null || activity.hashCode() != this.nn) {
            return;
        }
        aGH();
        aAs();
    }

    public void eli(JSONObject jSONObject) {
        this.eli = jSONObject;
    }

    public NU du() {
        return this.nlS;
    }
}
