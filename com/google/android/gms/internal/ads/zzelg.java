package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzelg extends com.google.android.gms.ads.internal.client.zzbw {
    private final com.google.android.gms.ads.internal.client.zzr zza;
    private final Context zzb;
    private final zzfad zzc;
    private final String zzd;
    private final VersionInfoParcel zze;
    private final zzeky zzf;
    private final zzfbd zzg;
    private final zzavu zzh;
    private final zzdsj zzi;
    private zzdfb zzj;
    private boolean zzk = ((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzaS)).booleanValue();

    public zzelg(Context context, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzfad zzfadVar, zzeky zzekyVar, zzfbd zzfbdVar, VersionInfoParcel versionInfoParcel, zzavu zzavuVar, zzdsj zzdsjVar) {
        this.zza = zzrVar;
        this.zzd = str;
        this.zzb = context;
        this.zzc = zzfadVar;
        this.zzf = zzekyVar;
        this.zzg = zzfbdVar;
        this.zze = versionInfoParcel;
        this.zzh = zzavuVar;
        this.zzi = zzdsjVar;
    }

    private final synchronized boolean zzf() {
        zzdfb zzdfbVar = this.zzj;
        if (zzdfbVar != null) {
            if (!zzdfbVar.zza()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzA() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzdfb zzdfbVar = this.zzj;
        if (zzdfbVar != null) {
            zzdfbVar.zzn().zzb(null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzB() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzC() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzdfb zzdfbVar = this.zzj;
        if (zzdfbVar != null) {
            zzdfbVar.zzn().zzc(null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzD(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzE(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        this.zzf.zzj(zzbkVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzF(com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzG(com.google.android.gms.ads.internal.client.zzr zzrVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzH(com.google.android.gms.ads.internal.client.zzco zzcoVar) {
        Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        this.zzf.zzm(zzcoVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzI(zzbaz zzbazVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzJ(com.google.android.gms.ads.internal.client.zzx zzxVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzK(com.google.android.gms.ads.internal.client.zzcv zzcvVar) {
        this.zzf.zzn(zzcvVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzL(com.google.android.gms.ads.internal.client.zzeh zzehVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzM(boolean z) {
        Preconditions.checkMainThread("setImmersiveMode must be called on the main UI thread.");
        this.zzk = z;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzN(zzbtz zzbtzVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzO(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzP(zzbdz zzbdzVar) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzc.zzi(zzbdzVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzQ(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        try {
            if (!zzdtVar.zzf()) {
                this.zzi.zze();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzf.zzl(zzdtVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzR(long j) {
        zzdfb zzdfbVar = this.zzj;
        if (zzdfbVar == null || zzdfbVar.zzl() == null) {
            return;
        }
        zzdfbVar.zzl().zzb(j);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzS(zzbuc zzbucVar, String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzT(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzU(zzbwi zzbwiVar) {
        this.zzg.zzm(zzbwiVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzV(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzW(com.google.android.gms.ads.internal.client.zzgc zzgcVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzY(IObjectWrapper iObjectWrapper) {
        if (this.zzj == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Interstitial can not be shown before loaded.");
            this.zzf.zzs(zzfdx.zzd(9, null, null));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdd)).booleanValue()) {
                this.zzh.zzc().zzn(new Throwable().getStackTrace());
            }
            this.zzj.zzc(this.zzk, (Activity) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzZ() {
        Preconditions.checkMainThread("showInterstitial must be called on the main UI thread.");
        if (this.zzj == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Interstitial can not be shown before loaded.");
            this.zzf.zzs(zzfdx.zzd(9, null, null));
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzdd)).booleanValue()) {
                this.zzh.zzc().zzn(new Throwable().getStackTrace());
            }
            this.zzj.zzc(this.zzk, null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzaa() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzab() {
        return this.zzc.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzac() {
        Preconditions.checkMainThread("isLoaded must be called on the main UI thread.");
        return zzf();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzad(com.google.android.gms.ads.internal.client.zzm zzmVar) {
        boolean z;
        if (!zzmVar.zzb()) {
            if (((Boolean) zzbfc.zzi.zze()).booleanValue()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlE)).booleanValue()) {
                    z = true;
                    if (this.zze.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlF)).intValue() || !z) {
                        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
                    }
                }
            }
            z = false;
            if (this.zze.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlF)).intValue()) {
            }
            Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        }
        com.google.android.gms.ads.internal.zzv.zzr();
        Context context = this.zzb;
        if (com.google.android.gms.ads.internal.util.zzs.zzI(context) && zzmVar.zzs == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to load the ad because app ID is missing.");
            zzeky zzekyVar = this.zzf;
            if (zzekyVar != null) {
                zzekyVar.zzdD(zzfdx.zzd(4, null, null));
            }
        } else if (!zzf()) {
            zzfdt.zza(context, zzmVar.zzf);
            this.zzj = null;
            return this.zzc.zzb(zzmVar, this.zzd, new zzezw(this.zza), new zzelf(this));
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzae(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized long zzc() {
        zzdfb zzdfbVar = this.zzj;
        if (zzdfbVar == null || zzdfbVar.zzl() == null) {
            return 0L;
        }
        return zzdfbVar.zzl().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zze() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzr zzh() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzbk zzj() {
        return this.zzf.zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzco zzk() {
        return this.zzf.zzi();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzea zzl() {
        zzdfb zzdfbVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgW)).booleanValue() && (zzdfbVar = this.zzj) != null) {
            return zzdfbVar.zzm();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzed zzm() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzo() {
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzs() {
        return this.zzd;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzt() {
        zzdfb zzdfbVar = this.zzj;
        if (zzdfbVar == null || zzdfbVar.zzm() == null) {
            return null;
        }
        return zzdfbVar.zzm().zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzu() {
        zzdfb zzdfbVar = this.zzj;
        if (zzdfbVar == null || zzdfbVar.zzm() == null) {
            return null;
        }
        return zzdfbVar.zzm().zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzdfb zzdfbVar = this.zzj;
        if (zzdfbVar != null) {
            zzdfbVar.zzn().zza(null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzz(com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzbn zzbnVar) {
        this.zzf.zzk(zzbnVar);
        zzad(zzmVar);
    }
}
