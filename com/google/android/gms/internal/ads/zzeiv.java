package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public class zzeiv extends zzbpv {
    private final zzcvw zza;
    private final zzdeb zzb;
    private final zzcwq zzc;
    private final zzcxf zzd;
    private final zzcxk zze;
    private final zzdaz zzf;
    private final zzcye zzg;
    private final zzdey zzh;
    private final zzdav zzi;
    private final zzcwl zzj;

    public zzeiv(zzcvw zzcvwVar, zzdeb zzdebVar, zzcwq zzcwqVar, zzcxf zzcxfVar, zzcxk zzcxkVar, zzdaz zzdazVar, zzcye zzcyeVar, zzdey zzdeyVar, zzdav zzdavVar, zzcwl zzcwlVar) {
        this.zza = zzcvwVar;
        this.zzb = zzdebVar;
        this.zzc = zzcwqVar;
        this.zzd = zzcxfVar;
        this.zze = zzcxkVar;
        this.zzf = zzdazVar;
        this.zzg = zzcyeVar;
        this.zzh = zzdeyVar;
        this.zzi = zzdavVar;
        this.zzj = zzcwlVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zze() {
        this.zza.onAdClicked();
        this.zzb.zzdf();
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzf() {
        this.zzg.zzdw(4);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzg(int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzi(int i, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    @Deprecated
    public final void zzj(int i) throws RemoteException {
        zzk(new com.google.android.gms.ads.internal.client.zze(i, "", AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.zzj.zzc(zzfdx.zzc(8, zzeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzl(String str) {
        zzk(new com.google.android.gms.ads.internal.client.zze(0, str, AdError.UNDEFINED_DOMAIN, null, null));
    }

    public void zzm() {
        this.zzc.zza();
        this.zzi.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzn() {
        this.zzd.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzo() {
        this.zze.zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzp() {
        this.zzg.zzdt();
        this.zzi.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzq(String str, String str2) {
        this.zzf.zzb(str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzr(zzbhj zzbhjVar, String str) {
    }

    public void zzs(zzbwo zzbwoVar) {
    }

    public void zzt(zzbws zzbwsVar) throws RemoteException {
    }

    public void zzu() throws RemoteException {
    }

    public void zzv() throws RemoteException {
    }

    public void zzw() {
        this.zzh.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzx() {
        this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzy() throws RemoteException {
        this.zzh.zzc();
    }

    public void zzz() {
        this.zzh.zzd();
    }
}
