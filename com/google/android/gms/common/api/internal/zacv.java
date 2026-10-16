package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zacv implements Runnable {
    final /* synthetic */ Result zaa;
    final /* synthetic */ zacx zab;

    zacv(zacx zacxVar, Result result) {
        this.zaa = result;
        this.zab = zacxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zacw zacwVar;
        zacw zacwVar2;
        WeakReference weakReference;
        GoogleApiClient googleApiClient;
        WeakReference weakReference2;
        ResultTransform resultTransform;
        zacw zacwVar3;
        zacw zacwVar4;
        WeakReference weakReference3;
        try {
            try {
                BasePendingResult.zaa.set(true);
                resultTransform = this.zab.zaa;
                PendingResult onSuccess = ((ResultTransform) Preconditions.checkNotNull(resultTransform)).onSuccess(this.zaa);
                zacx zacxVar = this.zab;
                zacwVar3 = zacxVar.zah;
                zacwVar4 = zacxVar.zah;
                zacwVar3.sendMessage(zacwVar4.obtainMessage(0, onSuccess));
                BasePendingResult.zaa.set(false);
                zacx zacxVar2 = this.zab;
                zacx.zan(this.zaa);
                weakReference3 = this.zab.zag;
                googleApiClient = (GoogleApiClient) weakReference3.get();
                if (googleApiClient == null) {
                    return;
                }
            } catch (RuntimeException e) {
                zacx zacxVar3 = this.zab;
                zacwVar = zacxVar3.zah;
                zacwVar2 = zacxVar3.zah;
                zacwVar.sendMessage(zacwVar2.obtainMessage(1, e));
                BasePendingResult.zaa.set(false);
                zacx zacxVar4 = this.zab;
                zacx.zan(this.zaa);
                weakReference = this.zab.zag;
                googleApiClient = (GoogleApiClient) weakReference.get();
                if (googleApiClient == null) {
                    return;
                }
            }
            googleApiClient.zap(this.zab);
        } catch (Throwable th) {
            BasePendingResult.zaa.set(false);
            zacx zacxVar5 = this.zab;
            zacx.zan(this.zaa);
            weakReference2 = this.zab.zag;
            GoogleApiClient googleApiClient2 = (GoogleApiClient) weakReference2.get();
            if (googleApiClient2 != null) {
                googleApiClient2.zap(this.zab);
            }
            throw th;
        }
    }
}
