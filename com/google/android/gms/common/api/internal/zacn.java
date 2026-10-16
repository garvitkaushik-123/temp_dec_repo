package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zacn implements Runnable {
    final /* synthetic */ zacq zaa;

    zacn(zacq zacqVar) {
        this.zaa = zacqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zacp zacpVar;
        zacpVar = this.zaa.zah;
        zacpVar.zae(new ConnectionResult(4));
    }
}
