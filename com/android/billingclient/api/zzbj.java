package com.android.billingclient.api;

import android.os.Bundle;
import android.os.RemoteException;
import com.android.billingclient.api.BillingResult;
import com.google.android.gms.internal.play_billing.zzie;
import com.google.android.gms.internal.play_billing.zzil;
import org.json.JSONException;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
final class zzbj extends com.google.android.gms.internal.play_billing.zzac {
    final BillingConfigResponseListener zza;
    final zzch zzb;
    final int zzc;

    /* synthetic */ zzbj(BillingConfigResponseListener billingConfigResponseListener, zzch zzchVar, int i, zzbp zzbpVar) {
        this.zza = billingConfigResponseListener;
        this.zzb = zzchVar;
        this.zzc = i;
    }

    @Override // com.google.android.gms.internal.play_billing.zzad
    public final void zza(Bundle bundle) throws RemoteException {
        if (bundle == null) {
            zzch zzchVar = this.zzb;
            zzie zzieVar = zzie.NULL_BUNDLE_FROM_GET_BILLING_CONFIG_SERVICE_CALL;
            BillingResult billingResult = zzcj.zzh;
            int i = zzcg.zza;
            zzchVar.zzb(zzcg.zzb(zzieVar, 13, billingResult, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onBillingConfigResponse(billingResult, null);
            return;
        }
        int zzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        String zzj = com.google.android.gms.internal.play_billing.zzc.zzj(bundle, "BillingClient");
        BillingResult.Builder newBuilder = BillingResult.newBuilder();
        newBuilder.setResponseCode(zzb);
        newBuilder.setDebugMessage(zzj);
        if (zzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "getBillingConfig() failed. Response code: " + zzb);
            BillingResult build = newBuilder.build();
            zzch zzchVar2 = this.zzb;
            zzie zzieVar2 = zzie.BILLING_RESULT_RECEIVED_FROM_PHONESKY;
            int i2 = zzcg.zza;
            zzchVar2.zzb(zzcg.zzb(zzieVar2, 13, build, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onBillingConfigResponse(build, null);
            return;
        }
        if (!bundle.containsKey("BILLING_CONFIG")) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "getBillingConfig() returned a bundle with neither an error nor a billing config response");
            newBuilder.setResponseCode(6);
            BillingResult build2 = newBuilder.build();
            zzch zzchVar3 = this.zzb;
            zzie zzieVar3 = zzie.MISSING_BILLING_CONFIG_IN_GET_BILLING_CONFIG_RESPONSE;
            int i3 = zzcg.zza;
            zzchVar3.zzb(zzcg.zzb(zzieVar3, 13, build2, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onBillingConfigResponse(build2, null);
            return;
        }
        try {
            this.zza.onBillingConfigResponse(newBuilder.build(), new BillingConfig(bundle.getString("BILLING_CONFIG")));
        } catch (JSONException e) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Got a JSON exception trying to decode BillingConfig. \n Exception: ", e);
            zzch zzchVar4 = this.zzb;
            zzie zzieVar4 = zzie.ERROR_DECODING_BILLING_CONFIG_DATA;
            BillingResult billingResult2 = zzcj.zzh;
            int i4 = zzcg.zza;
            zzchVar4.zzb(zzcg.zzb(zzieVar4, 13, billingResult2, null, zzil.BROADCAST_ACTION_UNSPECIFIED), this.zzc);
            this.zza.onBillingConfigResponse(billingResult2, null);
        }
    }
}
