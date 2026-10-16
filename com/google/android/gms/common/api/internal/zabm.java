package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zabm implements Runnable {
    final /* synthetic */ zabn zaa;

    zabm(zabn zabnVar) {
        this.zaa = zabnVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Api.Client client;
        Api.Client client2;
        zabo zaboVar = this.zaa.zaa;
        client = zaboVar.zac;
        client2 = zaboVar.zac;
        client.disconnect(String.valueOf(client2.getClass().getName()).concat(" disconnecting because it was signed out."));
    }
}
