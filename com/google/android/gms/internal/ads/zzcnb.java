package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcnb implements zzgdj {
    final /* synthetic */ String zza;
    final /* synthetic */ zzcnc zzb;

    zzcnb(zzcnc zzcncVar, String str) {
        this.zza = str;
        Objects.requireNonNull(zzcncVar);
        this.zzb = zzcncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
        zzfdi zzfdiVar;
        zzfju zzfjuVar;
        zzfcn zzfcnVar;
        zzfca zzfcaVar;
        List zzx;
        zzcuu zzcuuVar;
        String str = this.zza;
        zzcnc zzcncVar = this.zzb;
        zzfdiVar = zzcncVar.zzh;
        zzfjuVar = zzcncVar.zzg;
        zzfcnVar = zzcncVar.zze;
        zzfcaVar = zzcncVar.zzf;
        zzx = zzcncVar.zzx();
        zzcuuVar = zzcncVar.zzo;
        zzfdiVar.zza(zzfjuVar.zze(zzfcnVar, zzfcaVar, false, str, null, zzx, zzcuuVar), null);
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfdi zzfdiVar;
        zzfju zzfjuVar;
        zzfcn zzfcnVar;
        zzfca zzfcaVar;
        List zzx;
        zzcuu zzcuuVar;
        zzcyi zzcyiVar;
        zzcnc zzcncVar = this.zzb;
        String str = this.zza;
        String str2 = (String) obj;
        zzfdiVar = zzcncVar.zzh;
        zzfjuVar = zzcncVar.zzg;
        zzfcnVar = zzcncVar.zze;
        zzfcaVar = zzcncVar.zzf;
        zzx = zzcncVar.zzx();
        zzcuuVar = zzcncVar.zzo;
        List zze = zzfjuVar.zze(zzfcnVar, zzfcaVar, false, str, str2, zzx, zzcuuVar);
        zzcyiVar = zzcncVar.zzn;
        zzfdiVar.zza(zze, zzcyiVar);
    }
}
