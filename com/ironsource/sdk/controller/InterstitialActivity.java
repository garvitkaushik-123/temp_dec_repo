package com.ironsource.sdk.controller;

import android.os.Bundle;
import com.ironsource.C3040d4;
import com.ironsource.sdk.utils.Logger;

/* loaded from: classes6.dex */
public class InterstitialActivity extends ControllerActivity {
    private static final String r = "InterstitialActivity";

    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Logger.i(r, "onCreate");
    }

    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        Logger.i(r, C3040d4.h.t0);
    }

    @Override // com.ironsource.sdk.controller.ControllerActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        Logger.i(r, C3040d4.h.u0);
    }
}
