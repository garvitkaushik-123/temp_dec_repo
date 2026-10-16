package com.fyber.inneractive.sdk.activities;

import android.R;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.util.IAlog;

/* loaded from: classes4.dex */
public class InneractiveBaseActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    public b f1004a;

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.content);
        if (frameLayout != null && Build.VERSION.SDK_INT >= 35) {
            frameLayout.setOnApplyWindowInsetsListener(new com.fyber.inneractive.sdk.util.m());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            this.f1004a = new b(this);
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.f1004a);
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT >= 33) {
            try {
                if (this.f1004a != null) {
                    getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.f1004a);
                    this.f1004a = null;
                }
            } catch (Exception e) {
                IAlog.f("failed to unregisterOnBackInvokedCallback with error: %s", e.getMessage());
            }
        }
    }
}
