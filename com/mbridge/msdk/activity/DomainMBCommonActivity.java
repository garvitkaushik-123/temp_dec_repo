package com.mbridge.msdk.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.Toast;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.e1;
import com.mbridge.msdk.foundation.tools.p0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.foundation.webview.b;

/* loaded from: classes6.dex */
public class DomainMBCommonActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    String f3972a = "";
    private final BrowserView.e b = new a();
    protected BrowserView browserView;
    private CampaignEx c;

    class a implements BrowserView.e {
        a() {
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
        public void a() {
            DomainMBCommonActivity.this.finish();
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
        public void a(WebView webView, int i, String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
        public boolean b(WebView webView, String str) {
            p0.b("MBCommonActivity", "shouldOverrideUrlLoading  " + str);
            if (t0.a.b(str) && t0.a.a(DomainMBCommonActivity.this, str, null)) {
                DomainMBCommonActivity.this.finish();
            }
            return DomainMBCommonActivity.this.a(webView, str);
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
        public void c(WebView webView, String str) {
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
        public void a(WebView webView, String str, Bitmap bitmap) {
            p0.b("MBCommonActivity", "onPageStarted  " + str);
        }

        @Override // com.mbridge.msdk.foundation.webview.BrowserView.e
        public void a(WebView webView, String str) {
            p0.b("MBCommonActivity", "onPageFinished  " + str);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
        } catch (Throwable th) {
            p0.b("MBCommonActivity", th.getMessage());
        }
        if (c.m().d() == null) {
            c.m().b(getApplicationContext());
        }
        c.m().a(this);
        a();
    }

    private void a() {
        String stringExtra = getIntent().getStringExtra("url");
        this.f3972a = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            Toast.makeText(this, "Error: no data", 0).show();
            return;
        }
        this.c = (CampaignEx) getIntent().getSerializableExtra("mvcommon");
        if (b.f4404a.containsKey(this.f3972a)) {
            BrowserView browserView = b.f4404a.get(this.f3972a);
            this.browserView = browserView;
            if (browserView != null) {
                browserView.setListener(this.b);
            }
        } else {
            BrowserView browserView2 = new BrowserView(this, this.c);
            this.browserView = browserView2;
            browserView2.setListener(this.b);
            this.browserView.loadUrl(this.f3972a);
        }
        BrowserView browserView3 = this.browserView;
        if (browserView3 != null) {
            e1.a(browserView3);
            setContentView(this.browserView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(WebView webView, String str) {
        Intent parseUri;
        String str2;
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            if (!parse.getScheme().equals("http") && !parse.getScheme().equals("https")) {
                if (parse.getScheme().equals("intent") || parse.getScheme().equals("android-app")) {
                    String str3 = null;
                    if (parse.getScheme().equals("intent")) {
                        parseUri = Intent.parseUri(str, 1);
                    } else {
                        parseUri = parse.getScheme().equals("android-app") ? Intent.parseUri(str, 2) : null;
                    }
                    if (parseUri != null) {
                        parseUri.setComponent(null);
                        parseUri.setSelector(null);
                    }
                    if (parseUri == null) {
                        str2 = "";
                    } else {
                        try {
                            str2 = parseUri.getPackage();
                        } catch (Throwable th) {
                            p0.b("MBCommonActivity", th.getMessage());
                        }
                    }
                    if (!TextUtils.isEmpty(str2) && getPackageManager().getLaunchIntentForPackage(str2) != null) {
                        if (parseUri != null) {
                            parseUri.setFlags(268435456);
                        }
                        startActivityForResult(parseUri, 0);
                        finish();
                        return true;
                    }
                    if (parseUri != null) {
                        try {
                            str3 = parseUri.getStringExtra("browser_fallback_url");
                        } catch (Throwable th2) {
                            p0.b("MBCommonActivity", th2.getMessage());
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        Uri parse2 = Uri.parse(str);
                        if (!parse2.getScheme().equals("http") && !parse2.getScheme().equals("https")) {
                            str = str3;
                        }
                        webView.loadUrl(str3);
                        return false;
                    }
                }
                if (com.mbridge.msdk.click.c.d(this, str)) {
                    p0.b("MBCommonActivity", "openDeepLink");
                    finish();
                    return true;
                }
                if (!TextUtils.isEmpty(str)) {
                    return !(str.startsWith("http") || str.startsWith("https"));
                }
            }
            return false;
        } catch (Throwable th3) {
            p0.b("MBCommonActivity", th3.getMessage());
            return false;
        }
    }
}
