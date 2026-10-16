package com.mbridge.msdk.activity;

import android.os.Bundle;
import com.mbridge.msdk.foundation.webview.BrowserView;
import com.mbridge.msdk.foundation.webview.b;

/* loaded from: classes6.dex */
public class MBCommonActivity extends DomainMBCommonActivity {
    public static final /* synthetic */ int e = 0;
    private boolean d = false;

    @Override // android.app.Activity
    public void finish() {
        BrowserView browserView = this.browserView;
        if (browserView != null) {
            browserView.setListener(null);
            this.browserView.destroy();
        }
        BrowserView remove = b.f4404a.remove(this.f3972a);
        if (remove != null) {
            remove.setListener(null);
            remove.destroy();
        }
        this.d = true;
        super.finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (this.d) {
            return;
        }
        BrowserView browserView = this.browserView;
        if (browserView != null) {
            browserView.setListener(null);
            this.browserView.destroy();
        }
        BrowserView remove = b.f4404a.remove(this.f3972a);
        if (remove != null) {
            remove.setListener(null);
            remove.destroy();
        }
    }

    @Override // com.mbridge.msdk.activity.DomainMBCommonActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setRequestedOrientation(1);
        super.onCreate(bundle);
    }
}
