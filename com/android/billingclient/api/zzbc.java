package com.android.billingclient.api;

import java.util.Objects;

/* compiled from: com.android.billingclient:billing@@8.0.0 */
/* loaded from: classes2.dex */
final class zzbc implements BillingClientStateListener {
    final /* synthetic */ com.google.android.gms.internal.play_billing.zzp zza;
    final /* synthetic */ BillingClientImpl zzb;

    zzbc(BillingClientImpl billingClientImpl, com.google.android.gms.internal.play_billing.zzp zzpVar) {
        this.zza = zzpVar;
        Objects.requireNonNull(billingClientImpl);
        this.zzb = billingClientImpl;
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingServiceDisconnected() {
        BillingClientStateListener billingClientStateListener;
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Reconnection attempt failed.");
        try {
            this.zza.zzb(zzcj.zzj);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception setting completer.", th);
        }
        BillingClientImpl billingClientImpl = this.zzb;
        billingClientStateListener = billingClientImpl.zzG;
        if (billingClientStateListener != null) {
            billingClientImpl.zzag(new Runnable() { // from class: com.android.billingclient.api.zzba
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientStateListener billingClientStateListener2;
                    try {
                        billingClientStateListener2 = zzbc.this.zzb.zzG;
                        billingClientStateListener2.onBillingServiceDisconnected();
                    } catch (Throwable th2) {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception calling onBillingServiceDisconnected.", th2);
                    }
                }
            });
        }
    }

    @Override // com.android.billingclient.api.BillingClientStateListener
    public final void onBillingSetupFinished(final BillingResult billingResult) {
        BillingClientStateListener billingClientStateListener;
        com.google.android.gms.internal.play_billing.zzc.zzm("BillingClient", "Reconnection finished with result: " + billingResult.getResponseCode());
        try {
            this.zza.zzb(billingResult);
        } catch (Throwable th) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception setting completer.", th);
        }
        BillingClientImpl billingClientImpl = this.zzb;
        billingClientStateListener = billingClientImpl.zzG;
        if (billingClientStateListener != null) {
            billingClientImpl.zzag(new Runnable() { // from class: com.android.billingclient.api.zzbb
                @Override // java.lang.Runnable
                public final void run() {
                    BillingClientStateListener billingClientStateListener2;
                    zzbc zzbcVar = zzbc.this;
                    BillingResult billingResult2 = billingResult;
                    try {
                        billingClientStateListener2 = zzbcVar.zzb.zzG;
                        billingClientStateListener2.onBillingSetupFinished(billingResult2);
                    } catch (Throwable th2) {
                        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Exception calling onBillingSetupFinished.", th2);
                    }
                }
            });
        }
    }
}
