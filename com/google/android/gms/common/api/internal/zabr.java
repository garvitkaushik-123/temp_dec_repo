package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-base@@18.6.0 */
/* loaded from: classes4.dex */
final class zabr implements BaseGmsClient.ConnectionProgressReportCallbacks, zacp {
    final /* synthetic */ GoogleApiManager zaa;
    private final Api.Client zab;
    private final ApiKey zac;
    private IAccountAccessor zad = null;
    private Set zae = null;
    private boolean zaf = false;

    public zabr(GoogleApiManager googleApiManager, Api.Client client, ApiKey apiKey) {
        this.zaa = googleApiManager;
        this.zab = client;
        this.zac = apiKey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zah() {
        IAccountAccessor iAccountAccessor;
        if (!this.zaf || (iAccountAccessor = this.zad) == null) {
            return;
        }
        this.zab.getRemoteService(iAccountAccessor, this.zae);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
    public final void onReportServiceBinding(ConnectionResult connectionResult) {
        this.zaa.zas.post(new zabq(this, connectionResult));
    }

    @Override // com.google.android.gms.common.api.internal.zacp
    public final void zae(ConnectionResult connectionResult) {
        Map map;
        map = this.zaa.zao;
        zabo zaboVar = (zabo) map.get(this.zac);
        if (zaboVar != null) {
            zaboVar.zas(connectionResult);
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacp
    public final void zag(int i) {
        Map map;
        boolean z;
        map = this.zaa.zao;
        zabo zaboVar = (zabo) map.get(this.zac);
        if (zaboVar != null) {
            z = zaboVar.zaj;
            if (z) {
                zaboVar.zas(new ConnectionResult(17));
            } else {
                zaboVar.onConnectionSuspended(i);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.zacp
    public final void zaf(IAccountAccessor iAccountAccessor, Set set) {
        if (iAccountAccessor == null || set == null) {
            Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
            zae(new ConnectionResult(4));
        } else {
            this.zad = iAccountAccessor;
            this.zae = set;
            zah();
        }
    }
}
