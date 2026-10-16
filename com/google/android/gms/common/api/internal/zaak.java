package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zaak implements BaseGmsClient.ConnectionProgressReportCallbacks {
    private final WeakReference zaa;
    private final Api zab;
    private final boolean zac;

    public zaak(zaau zaauVar, Api api, boolean z) {
        this.zaa = new WeakReference(zaauVar);
        this.zab = api;
        this.zac = z;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        zabg zabgVar;
        Lock lock;
        Lock lock2;
        boolean zaG;
        boolean zaH;
        zaau zaauVar = (zaau) this.zaa.get();
        if (zaauVar == null) {
            return;
        }
        Looper myLooper = Looper.myLooper();
        zabgVar = zaauVar.zaa;
        Preconditions.checkState(myLooper == zabgVar.zag.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
        lock = zaauVar.zab;
        lock.lock();
        try {
            zaG = zaauVar.zaG(0);
            if (zaG) {
                if (!connectionResult.isSuccess()) {
                    zaauVar.zaE(connectionResult, this.zab, this.zac);
                }
                zaH = zaauVar.zaH();
                if (zaH) {
                    zaauVar.zaF();
                }
            }
        } finally {
            lock2 = zaauVar.zab;
            lock2.unlock();
        }
    }
}
