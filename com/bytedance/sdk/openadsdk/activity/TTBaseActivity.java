package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.window.OnBackInvokedCallback;
import com.bytedance.sdk.component.utils.Xb;
import com.bytedance.sdk.openadsdk.utils.ev;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* loaded from: classes3.dex */
public class TTBaseActivity extends Activity {
    private OnBackInvokedCallback eli;
    protected boolean wC = false;

    protected boolean eli() {
        return false;
    }

    private static class eli implements OnBackInvokedCallback {
        private final WeakReference<TTBaseActivity> eli;

        eli(TTBaseActivity tTBaseActivity) {
            this.eli = new WeakReference<>(tTBaseActivity);
        }

        @Override // android.window.OnBackInvokedCallback
        public void onBackInvoked() {
            TTBaseActivity tTBaseActivity = this.eli.get();
            if (tTBaseActivity != null) {
                tTBaseActivity.DbA();
            }
        }
    }

    protected void DbA() {
        onBackPressed();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (eli() && ev.eli()) {
            this.eli = new eli(this);
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.eli);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                super.onResume();
                return;
            } catch (IllegalArgumentException e) {
                Xb.eli("TTBaseActivity", "super.onResume() run fail", e);
                try {
                    Field declaredField = Activity.class.getDeclaredField("mCalled");
                    declaredField.setAccessible(true);
                    declaredField.set(this, Boolean.TRUE);
                    return;
                } catch (Exception e2) {
                    Xb.eli("TTBaseActivity", "onResume set mCalled fail", e2);
                    return;
                }
            }
        }
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onPause() {
        if (Build.VERSION.SDK_INT >= 33) {
            try {
                try {
                    super.onPause();
                    return;
                } catch (Exception unused) {
                    return;
                }
            } catch (IllegalArgumentException unused2) {
                Field declaredField = Activity.class.getDeclaredField("mCalled");
                declaredField.setAccessible(true);
                declaredField.set(this, Boolean.TRUE);
                return;
            }
        }
        super.onPause();
    }

    public void Os(boolean z) {
        this.wC = z;
    }

    @Override // android.app.Activity
    public void finish() {
        try {
            super.finish();
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (!ev.eli() || this.eli == null) {
            return;
        }
        getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.eli);
        this.eli = null;
    }
}
