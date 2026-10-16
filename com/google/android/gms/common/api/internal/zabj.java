package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zabj implements BackgroundDetector.BackgroundStateChangeListener {
    final /* synthetic */ GoogleApiManager zaa;

    zabj(GoogleApiManager googleApiManager) {
        this.zaa = googleApiManager;
    }

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        GoogleApiManager googleApiManager = this.zaa;
        googleApiManager.zas.sendMessage(googleApiManager.zas.obtainMessage(1, Boolean.valueOf(z)));
    }
}
