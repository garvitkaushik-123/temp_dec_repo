package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzdty extends zzbxb {
    final /* synthetic */ zzdua zza;

    zzdty(zzdua zzduaVar) {
        Objects.requireNonNull(zzduaVar);
        this.zza = zzduaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zze(int i) throws RemoteException {
        zzdtp zzdtpVar;
        long j;
        zzdua zzduaVar = this.zza;
        zzdtpVar = zzduaVar.zzb;
        j = zzduaVar.zza;
        zzdtpVar.zzm(j, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdtp zzdtpVar;
        long j;
        zzdua zzduaVar = this.zza;
        zzdtpVar = zzduaVar.zzb;
        j = zzduaVar.zza;
        zzdtpVar.zzm(j, zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbxc
    public final void zzg() throws RemoteException {
        zzdtp zzdtpVar;
        long j;
        zzdua zzduaVar = this.zza;
        zzdtpVar = zzduaVar.zzb;
        j = zzduaVar.zza;
        zzdtpVar.zzp(j);
    }
}
