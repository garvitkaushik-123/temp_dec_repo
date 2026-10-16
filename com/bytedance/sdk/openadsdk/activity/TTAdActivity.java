package com.bytedance.sdk.openadsdk.activity;

import android.app.Activity;
import android.os.Bundle;
import com.bytedance.sdk.openadsdk.core.Ue;
import com.bytedance.sdk.openadsdk.core.model.ev;
import com.bytedance.sdk.openadsdk.utils.Dfc;

/* loaded from: classes3.dex */
public class TTAdActivity extends TTBaseActivity {
    private DbA eli;

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected boolean eli() {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.bytedance.sdk.openadsdk.eli.ui.eli DbA = Ue.eli().DbA();
        com.bytedance.sdk.openadsdk.eli.Os.DbA Os = Ue.eli().Os();
        ev eli = com.bytedance.sdk.openadsdk.component.reward.eli.DbA.eli(getIntent(), bundle, (com.bytedance.sdk.openadsdk.core.nlS.aGH.DbA) null);
        if (eli != null) {
            DbA dbA = new DbA(this, eli);
            this.eli = dbA;
            dbA.eli(this, bundle, DbA, Os);
            com.bytedance.sdk.openadsdk.utils.DbA.eli(eli);
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        DbA dbA = this.eli;
        if (dbA != null) {
            dbA.eli(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        DbA dbA = this.eli;
        if (dbA != null) {
            dbA.eli((Activity) this);
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        DbA dbA = this.eli;
        if (dbA != null) {
            dbA.aGH(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        DbA dbA = this.eli;
        if (dbA != null) {
            dbA.Os(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        DbA dbA = this.eli;
        if (dbA != null) {
            dbA.DbA(this);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        DbA dbA = this.eli;
        if (dbA != null) {
            dbA.eli(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        DbA dbA = this.eli;
        if (dbA != null) {
            dbA.ui(this);
        }
        Ue.eli().eli((com.bytedance.sdk.openadsdk.eli.ui.eli) null);
        Ue.eli().eli((com.bytedance.sdk.openadsdk.eli.Os.DbA) null);
        Dfc.eli();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        DbA dbA = this.eli;
        if (dbA != null) {
            dbA.eli(this, bundle);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        Os();
    }

    private void Os() {
        DbA dbA = this.eli;
        if (dbA == null) {
            super.onBackPressed();
        } else {
            dbA.MGA();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.activity.TTBaseActivity
    protected void DbA() {
        Os();
    }
}
