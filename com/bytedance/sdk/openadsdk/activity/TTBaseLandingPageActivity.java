package com.bytedance.sdk.openadsdk.activity;

import android.os.SystemClock;

/* loaded from: classes3.dex */
public class TTBaseLandingPageActivity extends TTBaseActivity {
    private long DbA;
    private long eli;

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        if (com.bytedance.sdk.openadsdk.utils.ui.Os()) {
            this.DbA = SystemClock.elapsedRealtime();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        if (this.DbA > 0) {
            this.eli += SystemClock.elapsedRealtime() - this.DbA;
            this.DbA = 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        long j = this.eli;
        if (j > 0) {
            com.bytedance.sdk.openadsdk.utils.ui.eli(j);
        }
    }
}
