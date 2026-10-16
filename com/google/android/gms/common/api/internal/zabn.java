package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zabn implements BaseGmsClient.SignOutCallbacks {
    final /* synthetic */ zabo zaa;

    zabn(zabo zaboVar) {
        this.zaa = zaboVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void onSignOutComplete() {
        this.zaa.zaa.zas.post(new zabm(this));
    }
}
