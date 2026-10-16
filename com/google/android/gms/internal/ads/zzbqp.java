package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads-api@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbqp implements MediationAdLoadCallback {
    final /* synthetic */ zzbpw zza;
    final /* synthetic */ zzbqr zzb;

    zzbqp(zzbqr zzbqrVar, zzbpw zzbpwVar) {
        this.zza = zzbpwVar;
        Objects.requireNonNull(zzbqrVar);
        this.zzb = zzbqrVar;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(AdError adError) {
        Object obj;
        try {
            obj = this.zzb.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze(obj.getClass().getCanonicalName() + "failed to load mediation ad: ErrorCode = " + adError.getCode() + ". ErrorMessage = " + adError.getMessage() + ". ErrorDomain = " + adError.getDomain());
            zzbpw zzbpwVar = this.zza;
            zzbpwVar.zzh(adError.zza());
            zzbpwVar.zzi(adError.getCode(), adError.getMessage());
            zzbpwVar.zzg(adError.getCode());
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final /* bridge */ /* synthetic */ Object onSuccess(Object obj) {
        try {
            this.zzb.zzi = (MediationRewardedAd) obj;
            this.zza.zzo();
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
        return new zzbxl(this.zza);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        Object obj;
        try {
            obj = this.zzb.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze(obj.getClass().getCanonicalName() + "failed to loaded mediation ad: " + str);
            zzbpw zzbpwVar = this.zza;
            zzbpwVar.zzi(0, str);
            zzbpwVar.zzg(0);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }
}
