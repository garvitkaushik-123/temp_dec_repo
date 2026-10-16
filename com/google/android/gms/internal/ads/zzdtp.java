package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.ironsource.C3355vf;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdtp {
    private final zzble zza;

    zzdtp(zzble zzbleVar) {
        this.zza = zzbleVar;
    }

    private final void zzs(zzdtn zzdtnVar) throws RemoteException {
        String zza = zzdtn.zza(zzdtnVar);
        String concat = "Dispatching AFMA event on publisher webview: ".concat(zza);
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi(concat);
        this.zza.zzb(zza);
    }

    public final void zza() throws RemoteException {
        zzs(new zzdtn(MobileAdsBridgeBase.initializeMethodName, null));
    }

    public final void zzb(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("interstitial", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = C3355vf.f;
        this.zza.zzb(zzdtn.zza(zzdtnVar));
    }

    public final void zzc(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("interstitial", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = C3355vf.g;
        zzs(zzdtnVar);
    }

    public final void zzd(long j, int i) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("interstitial", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onAdFailedToLoad";
        zzdtnVar.zzd = Integer.valueOf(i);
        zzs(zzdtnVar);
    }

    public final void zze(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("interstitial", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = C3355vf.j;
        zzs(zzdtnVar);
    }

    public final void zzf(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("interstitial", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdtnVar);
    }

    public final void zzg(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("interstitial", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = C3355vf.c;
        zzs(zzdtnVar);
    }

    public final void zzh(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("creation", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "nativeObjectCreated";
        zzs(zzdtnVar);
    }

    public final void zzi(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("creation", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "nativeObjectNotCreated";
        zzs(zzdtnVar);
    }

    public final void zzj(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = C3355vf.f;
        zzs(zzdtnVar);
    }

    public final void zzk(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onRewardedAdClosed";
        zzs(zzdtnVar);
    }

    public final void zzl(long j, zzbws zzbwsVar) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onUserEarnedReward";
        zzdtnVar.zze = zzbwsVar.zzf();
        zzdtnVar.zzf = Integer.valueOf(zzbwsVar.zze());
        zzs(zzdtnVar);
    }

    public final void zzm(long j, int i) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onRewardedAdFailedToLoad";
        zzdtnVar.zzd = Integer.valueOf(i);
        zzs(zzdtnVar);
    }

    public final void zzn(long j, int i) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onRewardedAdFailedToShow";
        zzdtnVar.zzd = Integer.valueOf(i);
        zzs(zzdtnVar);
    }

    public final void zzo(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onAdImpression";
        zzs(zzdtnVar);
    }

    public final void zzp(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onRewardedAdLoaded";
        zzs(zzdtnVar);
    }

    public final void zzq(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onNativeAdObjectNotAvailable";
        zzs(zzdtnVar);
    }

    public final void zzr(long j) throws RemoteException {
        zzdtn zzdtnVar = new zzdtn("rewarded", null);
        zzdtnVar.zza = Long.valueOf(j);
        zzdtnVar.zzc = "onRewardedAdOpened";
        zzs(zzdtnVar);
    }
}
