package com.mbridge.msdk.splash.signal;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.AdError;
import com.ironsource.C3040d4;
import com.ironsource.D5;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.a1;
import com.mbridge.msdk.foundation.tools.l0;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.u0;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;
import com.mbridge.msdk.widget.MBAdChoice;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public class SplashExpandDialog extends Dialog {

    /* renamed from: a, reason: collision with root package name */
    private final String f4761a;
    private String b;
    private boolean c;
    private FrameLayout d;
    private WindVaneWebView e;
    private TextView f;
    private String g;
    private List<CampaignEx> h;
    private com.mbridge.msdk.splash.middle.a i;
    private com.mbridge.msdk.mbsignalcommon.mraid.b j;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SplashExpandDialog.this.dismiss();
        }
    }

    class b extends com.mbridge.msdk.mbsignalcommon.listener.b {

        class a implements ValueCallback<String> {
            a() {
            }

            @Override // android.webkit.ValueCallback
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(String str) {
            }
        }

        b() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.listener.b, com.mbridge.msdk.mbsignalcommon.windvane.c
        public void a(WebView webView, String str) {
            super.a(webView, str);
            webView.evaluateJavascript("javascript:" + com.mbridge.msdk.setting.util.a.a().b(), new a());
            SplashExpandDialog.this.c();
        }
    }

    class c implements com.mbridge.msdk.foundation.feedback.a {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            SplashExpandDialog.this.a();
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            SplashExpandDialog.this.a();
        }
    }

    class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (SplashExpandDialog.this.i != null) {
                SplashExpandDialog.this.i.a(false);
                SplashExpandDialog.this.i.close();
            }
            SplashExpandDialog.this.e.loadDataWithBaseURL(null, "", "text/html", D5.N, null);
            SplashExpandDialog.this.d.removeView(SplashExpandDialog.this.e);
            SplashExpandDialog.this.e.release();
            SplashExpandDialog.this.e = null;
            SplashExpandDialog.this.i = null;
        }
    }

    class e implements com.mbridge.msdk.mbsignalcommon.mraid.b {
        e() {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void close() {
            SplashExpandDialog.this.dismiss();
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void expand(String str, boolean z) {
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public CampaignEx getMraidCampaign() {
            return null;
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void open(String str) {
            try {
                if (SplashExpandDialog.this.e == null || System.currentTimeMillis() - SplashExpandDialog.this.e.lastTouchTime <= com.mbridge.msdk.click.utils.a.d || !com.mbridge.msdk.click.utils.a.a((CampaignEx) SplashExpandDialog.this.h.get(0), SplashExpandDialog.this.e.getUrl(), com.mbridge.msdk.click.utils.a.f4062a)) {
                    p0.b("SplashExpandDialog", str);
                    if (SplashExpandDialog.this.h.size() > 1) {
                        com.mbridge.msdk.foundation.controller.c.m().d().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                        str = null;
                    }
                    if (SplashExpandDialog.this.i != null) {
                        SplashExpandDialog.this.i.a(true, str);
                    }
                }
            } catch (Throwable th) {
                p0.b("SplashExpandDialog", "open", th);
            }
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void unload() {
            close();
        }

        @Override // com.mbridge.msdk.mbsignalcommon.mraid.b
        public void useCustomClose(boolean z) {
            try {
                SplashExpandDialog.this.f.setVisibility(z ? 4 : 0);
            } catch (Throwable th) {
                p0.b("SplashExpandDialog", "useCustomClose", th);
            }
        }
    }

    public SplashExpandDialog(Context context, Bundle bundle, com.mbridge.msdk.splash.middle.a aVar) {
        super(context);
        this.f4761a = "SplashExpandDialog";
        this.j = new e();
        if (bundle != null) {
            this.b = bundle.getString("url");
            this.c = bundle.getBoolean("shouldUseCustomClose");
        }
        this.i = aVar;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setCanceledOnTouchOutside(false);
        setCancelable(true);
        b();
    }

    public void setCampaignList(String str, List<CampaignEx> list) {
        this.g = str;
        this.h = list;
    }

    private void b() {
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.d = frameLayout;
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        WindVaneWebView windVaneWebView = new WindVaneWebView(getContext().getApplicationContext());
        this.e = windVaneWebView;
        windVaneWebView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.d.addView(this.e);
        TextView textView = new TextView(getContext());
        this.f = textView;
        textView.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(96, 96);
        layoutParams.gravity = 8388661;
        layoutParams.setMargins(30, 30, 30, 30);
        this.f.setLayoutParams(layoutParams);
        this.f.setVisibility(this.c ? 4 : 0);
        this.f.setOnClickListener(new a());
        this.d.addView(this.f);
        setContentView(this.d);
        a();
        this.e.setWebViewListener(new b());
        this.e.setObject(this.j);
        this.e.loadUrl(this.b);
        List<CampaignEx> list = this.h;
        if (list != null && !list.isEmpty()) {
            CampaignEx campaignEx = this.h.get(0);
            if (campaignEx != null) {
                a1.a(this.e, campaignEx.getLocalRequestId(), campaignEx.getLocalAllowTrackClick());
            }
            if (campaignEx != null && campaignEx.getPrivacyButtonTemplateVisibility() != 0) {
                MBAdChoice mBAdChoice = new MBAdChoice(com.mbridge.msdk.foundation.controller.c.m().d());
                mBAdChoice.setCampaign(campaignEx);
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f), u0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 12.0f));
                layoutParams2.gravity = 85;
                layoutParams2.bottomMargin = layoutParams.topMargin;
                layoutParams2.rightMargin = layoutParams.rightMargin;
                mBAdChoice.setFeedbackDialogEventListener(new c());
                this.d.addView(mBAdChoice, layoutParams2);
            }
        }
        BitmapDrawable a2 = com.mbridge.msdk.foundation.controller.c.m().a(this.g, 297);
        if (a2 != null) {
            ImageView imageView = new ImageView(com.mbridge.msdk.foundation.controller.c.m().d());
            u0.a(imageView, a2, this.d.getResources().getDisplayMetrics());
            this.d.addView(imageView, new ViewGroup.LayoutParams(-1, -1));
        }
        setOnDismissListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            int i = com.mbridge.msdk.foundation.controller.c.m().d().getResources().getConfiguration().orientation;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("orientation", i == 2 ? C3040d4.h.C : i == 1 ? C3040d4.h.D : AdError.UNDEFINED_DOMAIN);
            jSONObject.put("locked", "true");
            float n = l0.n(com.mbridge.msdk.foundation.controller.c.m().d());
            float m = l0.m(com.mbridge.msdk.foundation.controller.c.m().d());
            HashMap v = l0.v(com.mbridge.msdk.foundation.controller.c.m().d());
            int intValue = ((Integer) v.get("width")).intValue();
            int intValue2 = ((Integer) v.get("height")).intValue();
            HashMap hashMap = new HashMap();
            hashMap.put("placementType", "Interstitial");
            hashMap.put("state", "expanded");
            hashMap.put("viewable", "true");
            hashMap.put("currentAppOrientation", jSONObject);
            this.e.getLocationInWindow(new int[2]);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.e, r0[0], r0[1], r11.getWidth(), this.e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.e, r0[0], r0[1], r5.getWidth(), this.e.getHeight());
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().b(this.e, n, m);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.e, intValue, intValue2);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.e, hashMap);
            com.mbridge.msdk.mbsignalcommon.mraid.a.a().a(this.e);
        } catch (Throwable th) {
            p0.b("SplashExpandDialog", "notifyMraid", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (getWindow() != null) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
            getWindow().getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -1;
            getWindow().setAttributes(attributes);
            getWindow().getDecorView().setSystemUiVisibility(4615);
        }
    }
}
