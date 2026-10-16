package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzejz extends com.google.android.gms.ads.internal.client.zzbw {
    private final Context zza;
    private final com.google.android.gms.ads.internal.client.zzbk zzb;
    private final zzfcw zzc;
    private final zzcos zzd;
    private final ViewGroup zze;
    private final zzdsj zzf;

    public zzejz(Context context, com.google.android.gms.ads.internal.client.zzbk zzbkVar, zzfcw zzfcwVar, zzcos zzcosVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = zzbkVar;
        this.zzc = zzfcwVar;
        this.zzd = zzcosVar;
        this.zzf = zzdsjVar;
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.removeAllViews();
        View zzd = zzcosVar.zzd();
        com.google.android.gms.ads.internal.zzv.zzr();
        frameLayout.addView(zzd, new ViewGroup.LayoutParams(-1, -1));
        frameLayout.setMinimumHeight(zzh().zzc);
        frameLayout.setMinimumWidth(zzh().zzf);
        this.zze = frameLayout;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzA() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzn().zzb(null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzB() throws RemoteException {
        this.zzd.zzh();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzC() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzn().zzc(null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzD(com.google.android.gms.ads.internal.client.zzbh zzbhVar) throws RemoteException {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("setAdClickListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzE(com.google.android.gms.ads.internal.client.zzbk zzbkVar) throws RemoteException {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("setAdListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzF(com.google.android.gms.ads.internal.client.zzcb zzcbVar) throws RemoteException {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("setAdMetadataListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzG(com.google.android.gms.ads.internal.client.zzr zzrVar) throws RemoteException {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzcos zzcosVar = this.zzd;
        if (zzcosVar != null) {
            zzcosVar.zzi(this.zze, zzrVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzH(com.google.android.gms.ads.internal.client.zzco zzcoVar) throws RemoteException {
        zzeky zzekyVar = this.zzc.zzc;
        if (zzekyVar != null) {
            zzekyVar.zzm(zzcoVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzI(zzbaz zzbazVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzJ(com.google.android.gms.ads.internal.client.zzx zzxVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzK(com.google.android.gms.ads.internal.client.zzcv zzcvVar) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzL(com.google.android.gms.ads.internal.client.zzeh zzehVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzM(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzN(zzbtz zzbtzVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzO(boolean z) throws RemoteException {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("setManualImpressionsEnabled is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzP(zzbdz zzbdzVar) throws RemoteException {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("setOnCustomRenderedAdLoadedListener is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzQ(com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzlX)).booleanValue()) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzi("setOnPaidEventListener is not supported in Ad Manager AdView returned by AdLoader.");
            return;
        }
        zzeky zzekyVar = this.zzc.zzc;
        if (zzekyVar != null) {
            try {
                if (!zzdtVar.zzf()) {
                    this.zzf.zze();
                }
            } catch (RemoteException e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzf("Error in making CSI ping for reporting paid event callback", e);
            }
            zzekyVar.zzl(zzdtVar);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzR(long j) {
        zzcos zzcosVar = this.zzd;
        if (zzcosVar.zzl() != null) {
            zzcosVar.zzl().zzb(j);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzS(zzbuc zzbucVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzT(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzU(zzbwi zzbwiVar) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzV(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzW(com.google.android.gms.ads.internal.client.zzgc zzgcVar) throws RemoteException {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("setVideoOptions is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzY(IObjectWrapper iObjectWrapper) {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzZ() throws RemoteException {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzaa() throws RemoteException {
        zzcos zzcosVar = this.zzd;
        return zzcosVar != null && zzcosVar.zzs();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzab() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzac() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final boolean zzad(com.google.android.gms.ads.internal.client.zzm zzmVar) throws RemoteException {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("loadAd is not supported for an Ad Manager AdView returned from AdLoader.");
        return false;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzae(com.google.android.gms.ads.internal.client.zzcs zzcsVar) throws RemoteException {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("setCorrelationIdProvider is not supported in Ad Manager AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final long zzc() {
        zzcos zzcosVar = this.zzd;
        if (zzcosVar == null || zzcosVar.zzl() == null) {
            return 0L;
        }
        return zzcosVar.zzl().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final Bundle zze() throws RemoteException {
        int i = com.google.android.gms.ads.internal.util.zze.zza;
        com.google.android.gms.ads.internal.util.client.zzo.zzi("getAdMetadata is not supported in Ad Manager AdView returned by AdLoader.");
        return new Bundle();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzr zzh() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzfdc.zza(this.zza, Collections.singletonList(this.zzd.zzf()));
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzbk zzj() throws RemoteException {
        return this.zzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzco zzk() throws RemoteException {
        return this.zzc.zzn;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzea zzl() {
        return this.zzd.zzm();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final com.google.android.gms.ads.internal.client.zzed zzm() throws RemoteException {
        return this.zzd.zze();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final IObjectWrapper zzo() throws RemoteException {
        return ObjectWrapper.wrap(this.zze);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzs() throws RemoteException {
        return this.zzc.zzf;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzt() throws RemoteException {
        zzcos zzcosVar = this.zzd;
        if (zzcosVar.zzm() != null) {
            return zzcosVar.zzm().zzg();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final String zzu() throws RemoteException {
        zzcos zzcosVar = this.zzd;
        if (zzcosVar.zzm() != null) {
            return zzcosVar.zzm().zzg();
        }
        return null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzd.zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzbx
    public final void zzz(com.google.android.gms.ads.internal.client.zzm zzmVar, com.google.android.gms.ads.internal.client.zzbn zzbnVar) {
    }
}
