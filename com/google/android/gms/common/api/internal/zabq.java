package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zabq implements Runnable {
    final /* synthetic */ ConnectionResult zaa;
    final /* synthetic */ zabr zab;

    zabq(zabr zabrVar, ConnectionResult connectionResult) {
        this.zaa = connectionResult;
        this.zab = zabrVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Map map;
        ApiKey apiKey;
        Api.Client client;
        Api.Client client2;
        Api.Client client3;
        Api.Client client4;
        zabr zabrVar = this.zab;
        map = zabrVar.zaa.zao;
        apiKey = zabrVar.zac;
        zabo zaboVar = (zabo) map.get(apiKey);
        if (zaboVar == null) {
            return;
        }
        if (!this.zaa.isSuccess()) {
            zaboVar.zar(this.zaa, null);
            return;
        }
        this.zab.zaf = true;
        client = this.zab.zab;
        if (client.requiresSignIn()) {
            this.zab.zah();
            return;
        }
        try {
            zabr zabrVar2 = this.zab;
            client3 = zabrVar2.zab;
            client4 = zabrVar2.zab;
            client3.getRemoteService(null, client4.getScopesForConnectionlessNonSignIn());
        } catch (SecurityException e) {
            Log.e("GoogleApiManager", "Failed to get service from broker. ", e);
            client2 = this.zab.zab;
            client2.disconnect("Failed to get service from broker.");
            zaboVar.zar(new ConnectionResult(10), null);
        }
    }
}
