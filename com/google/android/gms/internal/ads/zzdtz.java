package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdtz extends zzbwx {
    final /* synthetic */ zzdua zza;

    zzdtz(zzdua zzduaVar) {
        Objects.requireNonNull(zzduaVar);
        this.zza = zzduaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zze() throws RemoteException {
        zzdtp zzdtpVar;
        long j;
        zzdua zzduaVar = this.zza;
        zzdtpVar = zzduaVar.zzb;
        j = zzduaVar.zza;
        zzdtpVar.zzj(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzf() throws RemoteException {
        zzdtp zzdtpVar;
        long j;
        zzdua zzduaVar = this.zza;
        zzdtpVar = zzduaVar.zzb;
        j = zzduaVar.zza;
        zzdtpVar.zzo(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzg() throws RemoteException {
        zzdtp zzdtpVar;
        long j;
        zzdua zzduaVar = this.zza;
        zzdtpVar = zzduaVar.zzb;
        j = zzduaVar.zza;
        zzdtpVar.zzk(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzh(int i) throws RemoteException {
        zzdtp zzdtpVar;
        long j;
        zzdua zzduaVar = this.zza;
        zzdtpVar = zzduaVar.zzb;
        j = zzduaVar.zza;
        zzdtpVar.zzn(j, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzi(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdtp zzdtpVar;
        long j;
        zzdua zzduaVar = this.zza;
        zzdtpVar = zzduaVar.zzb;
        j = zzduaVar.zza;
        zzdtpVar.zzn(j, zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzj() throws RemoteException {
        zzdtp zzdtpVar;
        long j;
        zzdua zzduaVar = this.zza;
        zzdtpVar = zzduaVar.zzb;
        j = zzduaVar.zza;
        zzdtpVar.zzr(j);
    }

    @Override // com.google.android.gms.internal.ads.zzbwy
    public final void zzk(zzbws zzbwsVar) throws RemoteException {
        zzdtp zzdtpVar;
        long j;
        zzdua zzduaVar = this.zza;
        zzdtpVar = zzduaVar.zzb;
        j = zzduaVar.zza;
        zzdtpVar.zzl(j, zzbwsVar);
    }
}
