package com.bytedance.sdk.openadsdk.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.aGH.nlS;
import com.bytedance.sdk.openadsdk.core.Ue;
import com.bytedance.sdk.openadsdk.core.model.QX;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.core.nn;
import com.bytedance.sdk.openadsdk.core.qj;
import com.bytedance.sdk.openadsdk.core.widget.eli.MGA;
import com.bytedance.sdk.openadsdk.utils.SSo;
import com.bytedance.sdk.openadsdk.utils.bf;
import com.bytedance.sdk.openadsdk.utils.dZ;

/* loaded from: classes3.dex */
public class TTCeilingLandingPageActivity extends TTBaseLandingPageActivity {
    private ev DbA;
    private nlS FC;
    private int MGA;
    private qj Os;
    private com.bytedance.sdk.openadsdk.common.aGH aAs;
    private String aGH;
    private com.bytedance.sdk.component.FC.MGA du;
    eli eli;
    private String kb;
    private String ui;

    public interface eli {
        void eli();
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!nn.ui()) {
            finish();
            return;
        }
        Intent intent = getIntent();
        this.MGA = intent.getIntExtra("source", -1);
        ev eli2 = Ue.eli().eli(Ue.eli(intent));
        this.DbA = eli2;
        if (eli2 == null) {
            finish();
            return;
        }
        this.kb = eli2.wC();
        this.aGH = this.DbA.umh();
        this.ui = this.DbA.eu();
        this.MGA = this.DbA.XU().getDurationSlotType() != 7 ? 5 : 7;
        com.bytedance.sdk.openadsdk.core.ui.Os os = new com.bytedance.sdk.openadsdk.core.ui.Os(this);
        eli(this, os);
        setContentView(os);
        Os();
    }

    private void eli(Context context, FrameLayout frameLayout) {
        com.bytedance.sdk.openadsdk.core.ui.aGH agh;
        this.du = new com.bytedance.sdk.component.FC.MGA(context);
        frameLayout.addView(this.du, new FrameLayout.LayoutParams(-1, -1));
        com.bytedance.sdk.openadsdk.core.ui.aGH DbA = com.bytedance.sdk.openadsdk.core.widget.MGA.DbA(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 8388661;
        layoutParams.topMargin = SSo.DbA(context, 18.0f);
        layoutParams.rightMargin = SSo.DbA(context, 18.0f);
        frameLayout.addView(DbA, layoutParams);
        final int kb = this.DbA.bf().kb();
        if (kb != 3) {
            agh = new com.bytedance.sdk.openadsdk.core.ui.aGH(context);
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(SSo.DbA(context, 28.0f), SSo.DbA(context, 28.0f));
            layoutParams2.gravity = 8388659;
            layoutParams2.topMargin = SSo.DbA(context, 18.0f);
            layoutParams2.leftMargin = SSo.DbA(context, 18.0f);
            int DbA2 = SSo.DbA(context, 5.0f);
            agh.setPadding(DbA2, DbA2, DbA2, DbA2);
            agh.setScaleType(ImageView.ScaleType.FIT_XY);
            agh.setBackground(com.bytedance.sdk.openadsdk.core.widget.aGH.eli());
            agh.setImageDrawable(com.bytedance.sdk.component.utils.ev.Os(context, "tt_white_lefterbackicon_titlebar"));
            frameLayout.addView(agh, layoutParams2);
        } else {
            agh = null;
        }
        bf.eli(this.du, this.kb);
        final WebView webView = this.du.getWebView();
        DbA.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TTCeilingLandingPageActivity.this.finish();
            }
        });
        nlS nls = new nlS(this.DbA, webView, true);
        this.FC = nls;
        nls.eli("landingpage_split_ceiling");
        final MGA.eli eliVar = this.FC.eli;
        if (agh != null) {
            agh.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i = kb;
                    if (i == 1) {
                        TTCeilingLandingPageActivity.this.finish();
                    } else if (i != 2) {
                        return;
                    }
                    WebView webView2 = webView;
                    if (webView2 != null && webView2.canGoBack()) {
                        webView.goBack();
                        MGA.eli eliVar2 = eliVar;
                        if (eliVar2 != null) {
                            eliVar2.eli();
                            return;
                        }
                        return;
                    }
                    TTCeilingLandingPageActivity.this.finish();
                }
            });
        }
        com.bytedance.sdk.openadsdk.common.aGH eli2 = dZ.eli(this.DbA, this.du, this, "landingpage_split_ceiling");
        this.aAs = eli2;
        if (eli2 != null) {
            eli2.eli("landingpage_split_ceiling");
            this.aAs.eli();
        }
        dZ.eli(this.DbA, this.du, true);
        this.eli = new eli() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.3
            @Override // com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.eli
            public void eli() {
                if (TTCeilingLandingPageActivity.this.DbA.bf().wC() == QX.DbA) {
                    TTCeilingLandingPageActivity.this.finish();
                }
            }
        };
        com.bytedance.sdk.openadsdk.core.widget.eli.ui uiVar = new com.bytedance.sdk.openadsdk.core.widget.eli.ui(this, this.Os, this.aGH, this.aAs, this.FC, true, true, this.eli) { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.4
            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.ui, android.webkit.WebViewClient
            public void onPageFinished(WebView webView2, String str) {
                super.onPageFinished(webView2, str);
            }
        };
        uiVar.eli(this.DbA);
        com.bytedance.sdk.openadsdk.core.widget.eli.aGH agh2 = new com.bytedance.sdk.openadsdk.core.widget.eli.aGH(this.Os, this.FC, this.aAs) { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.5
            @Override // com.bytedance.sdk.openadsdk.core.widget.eli.aGH, android.webkit.WebChromeClient
            public void onProgressChanged(WebView webView2, int i) {
                super.onProgressChanged(webView2, i);
            }
        };
        com.bytedance.sdk.component.FC.MGA mga = this.du;
        if (mga != null) {
            mga.setWebViewClient(uiVar);
            this.du.setWebChromeClient(agh2);
        }
        if (webView != null) {
            webView.setOnTouchListener(new View.OnTouchListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.6
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    if (TTCeilingLandingPageActivity.this.FC == null) {
                        return false;
                    }
                    TTCeilingLandingPageActivity.this.FC.eli(motionEvent);
                    return false;
                }
            });
            webView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.bytedance.sdk.openadsdk.activity.TTCeilingLandingPageActivity.7
                @Override // android.view.View.OnScrollChangeListener
                public void onScrollChange(View view, int i, int i2, int i3, int i4) {
                    if (TTCeilingLandingPageActivity.this.FC != null) {
                        TTCeilingLandingPageActivity.this.FC.DbA(i2);
                    }
                }
            });
        }
    }

    private void Os() {
        qj qjVar = new qj(this);
        this.Os = qjVar;
        qjVar.DbA(this.du).Os(this.aGH).aGH(this.ui).eli(this.DbA).DbA(this.MGA).eli(this.DbA.ND()).ui(this.DbA.WA()).eli(this.du).DbA("landingpage_split_ceiling");
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        nlS nls = this.FC;
        if (nls != null) {
            nls.wC();
        }
    }
}
