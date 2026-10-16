package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzeke extends com.google.android.gms.ads.internal.client.zzbw implements zzcyp {
    private final Context zza;
    private final zzeym zzb;
    private final String zzc;
    private final zzeky zzd;
    private com.google.android.gms.ads.internal.client.zzr zze;
    private final zzfcu zzf;
    private final VersionInfoParcel zzg;
    private final zzdsj zzh;
    private zzcos zzi;

    public zzeke(Context context, com.google.android.gms.ads.internal.client.zzr zzrVar, String str, zzeym zzeymVar, zzeky zzekyVar, VersionInfoParcel versionInfoParcel, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = zzeymVar;
        this.zze = zzrVar;
        this.zzc = str;
        this.zzd = zzekyVar;
        this.zzf = zzeymVar.zzf();
        this.zzg = versionInfoParcel;
        this.zzh = zzdsjVar;
        zzeymVar.zzo(this);
    }

    private final synchronized void zzg(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        zzfcu zzfcuVar = this.zzf;
        zzfcuVar.zzt(zzrVar);
        zzfcuVar.zzz(this.zze.zzn);
    }

    private final synchronized boolean zzi(com.google.android.gms.ads.internal.client.zzm zzmVar) throws RemoteException {
        if (zzn()) {
            Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        }
        com.google.android.gms.ads.internal.zzv.zzr();
        Context context = this.zza;
        if (!com.google.android.gms.ads.internal.util.zzs.zzI(context) || zzmVar.zzs != null) {
            zzfdt.zza(context, zzmVar.zzf);
            return this.zzb.zzb(zzmVar, this.zzc, null, new zzekd(this));
        }
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to load the ad because app ID is missing.");
        zzeky zzekyVar = this.zzd;
        if (zzekyVar != null) {
            zzekyVar.zzdD(zzfdx.zzd(4, null, null));
        }
        return false;
    }

    private final boolean zzn() {
        boolean z;
        if (((Boolean) zzbfc.zzf.zze()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlE)).booleanValue()) {
                z = true;
                return this.zzg.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlF)).intValue() || !z;
            }
        }
        z = false;
        if (this.zzg.clientJarVersion >= ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlF)).intValue()) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        if (r3.zzg.clientJarVersion < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzlG)).intValue()) goto L9;
     */
    @Override // com.google.android.gms.ads.internal.client.zzbx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzA() {
        if (((Boolean) zzbfc.zzg.zze()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlC)).booleanValue()) {
            }
        }
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
        zzcos zzcosVar = this.zzi;
        if (zzcosVar != null) {
            zzcosVar.zzn().zzb(null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzB() {
        Preconditions.checkMainThread("recordManualImpression must be called on the main UI thread.");
        zzcos zzcosVar = this.zzi;
        if (zzcosVar != null) {
            zzcosVar.zzh();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        if (r3.zzg.clientJarVersion < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzlG)).intValue()) goto L9;
     */
    @Override // com.google.android.gms.ads.internal.client.zzbx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzC() {
        if (((Boolean) zzbfc.zzh.zze()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlA)).booleanValue()) {
            }
        }
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
        zzcos zzcosVar = this.zzi;
        if (zzcosVar != null) {
            zzcosVar.zzn().zzc(null);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzD(com.google.android.gms.ads.internal.client.zzbh zzbhVar) {
        if (zzn()) {
            Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        }
        this.zzb.zzn(zzbhVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzE(com.google.android.gms.ads.internal.client.zzbk zzbkVar) {
        if (zzn()) {
            Preconditions.checkMainThread("setAdListener must be called on the main UI thread.");
        }
        this.zzd.zzj(zzbkVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzF(com.google.android.gms.ads.internal.client.zzcb zzcbVar) {
        Preconditions.checkMainThread("setAdMetadataListener must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzG(com.google.android.gms.ads.internal.client.zzr zzrVar) {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        this.zzf.zzt(zzrVar);
        this.zze = zzrVar;
        zzcos zzcosVar = this.zzi;
        if (zzcosVar != null) {
            zzcosVar.zzi(this.zzb.zzc(), zzrVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzH(com.google.android.gms.ads.internal.client.zzco zzcoVar) {
        if (zzn()) {
            Preconditions.checkMainThread("setAppEventListener must be called on the main UI thread.");
        }
        this.zzd.zzm(zzcoVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzI(zzbaz zzbazVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzJ(com.google.android.gms.ads.internal.client.zzx zzxVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzK(com.google.android.gms.ads.internal.client.zzcv zzcvVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzL(com.google.android.gms.ads.internal.client.zzeh zzehVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzM(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzN(zzbtz zzbtzVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzO(boolean z) {
        if (zzn()) {
            Preconditions.checkMainThread("setManualImpressionsEnabled must be called from the main thread.");
        }
        this.zzf.zzC(z);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzP(zzbdz zzbdzVar) {
        Preconditions.checkMainThread("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        this.zzb.zzp(zzbdzVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzQ(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        if (zzn()) {
            Preconditions.checkMainThread("setPaidEventListener must be called on the main UI thread.");
        }
        try {
            if (!zzdtVar.zzf()) {
                this.zzh.zze();
            }
        } catch (RemoteException e) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Error in making CSI ping for reporting paid event callback", e);
        }
        this.zzd.zzl(zzdtVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzR(long j) {
        this.zzf.zzH(j);
        zzcos zzcosVar = this.zzi;
        if (zzcosVar == null || zzcosVar.zzl() == null) {
            return;
        }
        zzcosVar.zzl().zzb(j);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzS(zzbuc zzbucVar, String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzT(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzU(zzbwi zzbwiVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzV(String str) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzW(com.google.android.gms.ads.internal.client.zzgc zzgcVar) {
        if (zzn()) {
            Preconditions.checkMainThread("setVideoOptions must be called on the main UI thread.");
        }
        this.zzf.zzK(zzgcVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzY(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzZ() {
    }

    @Override // com.google.android.gms.internal.ads.zzcyp
    public final synchronized void zza() {
        if (!this.zzb.zzs()) {
            this.zzb.zzl();
            return;
        }
        zzfcu zzfcuVar = this.zzf;
        com.google.android.gms.ads.internal.client.zzr zzi = zzfcuVar.zzi();
        if (this.zzi != null && zzfcuVar.zzW()) {
            zzi = zzfdc.zza(this.zza, Collections.singletonList(this.zzi.zzg()));
        }
        zzg(zzi);
        zzfcuVar.zzy(true);
        try {
            zzi(zzfcuVar.zzg());
        } catch (RemoteException unused) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzj("Failed to refresh the banner ad.");
        }
        this.zzf.zzy(false);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzaa() {
        zzcos zzcosVar = this.zzi;
        if (zzcosVar != null) {
            if (zzcosVar.zzs()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzab() {
        return this.zzb.zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzac() {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized boolean zzad(com.google.android.gms.ads.internal.client.zzm zzmVar) throws RemoteException {
        zzg(this.zze);
        return zzi(zzmVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized void zzae(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        Preconditions.checkMainThread("setCorrelationIdProvider must be called on the main UI thread");
        this.zzf.zzY(zzcsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzcyp
    public final synchronized void zzb() throws ExecutionException, InterruptedException {
        zzeym zzeymVar = this.zzb;
        if (zzeymVar.zzs()) {
            zzeymVar.zzq();
        } else {
            zzeymVar.zzm();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zze() {
        Preconditions.checkMainThread("getAdMetadata must be called on the main UI thread.");
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzr zzh() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        zzcos zzcosVar = this.zzi;
        if (zzcosVar != null) {
            return zzfdc.zza(this.zza, Collections.singletonList(zzcosVar.zzf()));
        }
        return this.zzf.zzi();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzbk zzj() {
        return this.zzd.zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzco zzk() {
        return this.zzd.zzi();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzea zzl() {
        zzcos zzcosVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzgW)).booleanValue() && (zzcosVar = this.zzi) != null) {
            return zzcosVar.zzm();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized com.google.android.gms.ads.internal.client.zzed zzm() {
        Preconditions.checkMainThread("getVideoController must be called from the main thread.");
        zzcos zzcosVar = this.zzi;
        if (zzcosVar == null) {
            return null;
        }
        return zzcosVar.zze();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzo() {
        if (zzn()) {
            Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        }
        return ObjectWrapper.wrap(this.zzb.zzc());
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzs() {
        return this.zzc;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzt() {
        zzcos zzcosVar = this.zzi;
        if (zzcosVar == null || zzcosVar.zzm() == null) {
            return null;
        }
        return zzcosVar.zzm().zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized String zzu() {
        zzcos zzcosVar = this.zzi;
        if (zzcosVar == null || zzcosVar.zzm() == null) {
            return null;
        }
        return zzcosVar.zzm().zzg();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0035, code lost:
    
        if (r3.zzg.clientJarVersion < ((java.lang.Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(com.google.android.gms.internal.ads.zzbde.zzlG)).intValue()) goto L9;
     */
    @Override // com.google.android.gms.ads.internal.client.zzbx
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void zzy() {
        if (((Boolean) zzbfc.zze.zze()).booleanValue()) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlB)).booleanValue()) {
            }
        }
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        zzcos zzcosVar = this.zzi;
        if (zzcosVar != null) {
            zzcosVar.zzb();
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzz(com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzbn zzbnVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final synchronized long zzc() {
        zzcos zzcosVar = this.zzi;
        if (zzcosVar == null || zzcosVar.zzl() == null) {
            return this.zzf.zzb();
        }
        return zzcosVar.zzl().zza();
    }
}
