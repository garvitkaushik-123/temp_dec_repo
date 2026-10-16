package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zaaz implements ResultCallback {
    final /* synthetic */ StatusPendingResult zaa;
    final /* synthetic */ boolean zab;
    final /* synthetic */ GoogleApiClient zac;
    final /* synthetic */ zabc zad;

    zaaz(zabc zabcVar, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.zaa = statusPendingResult;
        this.zab = z;
        this.zac = googleApiClient;
        this.zad = zabcVar;
    }

    @Override // com.google.android.gms.common.api.ResultCallback
    public final /* bridge */ /* synthetic */ void onResult(Result result) {
        Context context;
        Status status = (Status) result;
        context = this.zad.zan;
        Storage.getInstance(context).zac();
        if (status.isSuccess() && this.zad.isConnected()) {
            zabc zabcVar = this.zad;
            zabcVar.disconnect();
            zabcVar.connect();
        }
        this.zaa.setResult(status);
        if (this.zab) {
            this.zac.disconnect();
        }
    }
}
