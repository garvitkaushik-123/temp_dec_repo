package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
final class zzbg extends com.google.android.gms.internal.play_billing.zzw {
    final AlternativeBillingOnlyReportingDetailsListener zza;
    final zzch zzb;
    final int zzc;

    /* synthetic */ zzbg(AlternativeBillingOnlyReportingDetailsListener alternativeBillingOnlyReportingDetailsListener, zzch zzchVar, int i, zzbp zzbpVar) {
        this.zza = alternativeBillingOnlyReportingDetailsListener;
        this.zzb = zzchVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzx
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            zzch zzchVar = this.zzb;
            zzie zzieVar = zzie.NULL_BUNDLE_FROM_CREATE_ALTERNATIVE_BILLING_ONLY_TOKEN_SERVICE_CALL;
            BillingResult billingResult = zzcj.zzh;
            int i = zzcg.zza;
            zzchVar.zzb(zzcg.zzb(zzieVar, 15, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(billingResult, null);
            return;
        }
        int zzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        BillingResult zza = zzcj.zza(zzb, com.google.android.gms.internal.play_billing.zzc.zzj(bundle, "BillingClient"));
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "createAlternativeBillingOnlyReportingDetailsAsync() failed. Response code: " + zzb);
            zzch zzchVar2 = this.zzb;
            zzie zzieVar2 = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i2 = zzcg.zza;
            zzchVar2.zzb(zzcg.zzb(zzieVar2, 15, zza, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(zza, null);
            return;
        }
        try {
            this.zza.onAlternativeBillingOnlyTokenResponse(zza, new AlternativeBillingOnlyReportingDetails(bundle.getString("CREATE_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS")));
        } catch (JSONException e) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Error when parsing invalid alternative billing only reporting details. \n Exception: ", e);
            zzch zzchVar3 = this.zzb;
            zzie zzieVar3 = zzie.ERROR_DECODING_ALTERNATIVE_BILLING_ONLY_REPORTING_DETAILS;
            BillingResult billingResult2 = zzcj.zzh;
            int i3 = zzcg.zza;
            zzchVar3.zzb(zzcg.zzb(zzieVar3, 15, billingResult2, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onAlternativeBillingOnlyTokenResponse(billingResult2, null);
        }
    }
}
