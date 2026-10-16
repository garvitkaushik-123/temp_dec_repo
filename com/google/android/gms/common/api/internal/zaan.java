package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zaan extends zaas {
    final /* synthetic */ zaau zaa;
    private final Map zac;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zaan(zaau zaauVar, Map map) {
        super(zaauVar, null);
        this.zaa = zaauVar;
        this.zac = map;
    }

    @Override // com.google.android.gms.common.api.internal.zaas
    public final void zaa() {
        GoogleApiAvailabilityLight googleApiAvailabilityLight;
        Context context;
        boolean z;
        Context context2;
        zabg zabgVar;
        com.google.android.gms.signin.zae zaeVar;
        com.google.android.gms.signin.zae zaeVar2;
        zabg zabgVar2;
        Context context3;
        boolean z2;
        googleApiAvailabilityLight = this.zaa.zad;
        com.google.android.gms.common.internal.zal zalVar = new com.google.android.gms.common.internal.zal(googleApiAvailabilityLight);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.zac.keySet()) {
            if (client.requiresGooglePlayServices()) {
                z2 = ((zaak) this.zac.get(client)).zac;
                if (!z2) {
                    arrayList.add(client);
                }
            }
            arrayList2.add(client);
        }
        int i = 0;
        int i2 = -1;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i < size) {
                Api.Client client2 = (Api.Client) arrayList.get(i);
                context = this.zaa.zac;
                i2 = zalVar.zab(context, client2);
                i++;
                if (i2 != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i < size2) {
                Api.Client client3 = (Api.Client) arrayList2.get(i);
                context3 = this.zaa.zac;
                i2 = zalVar.zab(context3, client3);
                i++;
                if (i2 == 0) {
                    break;
                }
            }
        }
        if (i2 != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i2, null);
            zaau zaauVar = this.zaa;
            zabgVar2 = zaauVar.zaa;
            zabgVar2.zal(new zaal(this, zaauVar, connectionResult));
            return;
        }
        zaau zaauVar2 = this.zaa;
        z = zaauVar2.zam;
        if (z) {
            zaeVar = zaauVar2.zak;
            if (zaeVar != null) {
                zaeVar2 = zaauVar2.zak;
                zaeVar2.zab();
            }
        }
        for (Api.Client client4 : this.zac.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks) this.zac.get(client4);
            if (client4.requiresGooglePlayServices()) {
                context2 = this.zaa.zac;
                if (zalVar.zab(context2, client4) != 0) {
                    zaau zaauVar3 = this.zaa;
                    zabgVar = zaauVar3.zaa;
                    zabgVar.zal(new zaam(this, zaauVar3, connectionProgressReportCallbacks));
                }
            }
            client4.connect(connectionProgressReportCallbacks);
        }
    }
}
