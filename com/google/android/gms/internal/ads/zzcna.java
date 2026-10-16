package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcna implements zzgdj {
    final /* synthetic */ zzcnc zza;

    zzcna(zzcnc zzcncVar) {
        Objects.requireNonNull(zzcncVar);
        this.zza = zzcncVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final void zza(Throwable th) {
    }

    @Override // com.google.android.gms.internal.ads.zzgdj
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzfdi zzfdiVar;
        zzfju zzfjuVar;
        zzfcn zzfcnVar;
        zzfca zzfcaVar;
        zzfca zzfcaVar2;
        Context context;
        String str = (String) obj;
        zzcnc zzcncVar = this.zza;
        zzfdiVar = zzcncVar.zzh;
        zzfjuVar = zzcncVar.zzg;
        zzfcnVar = zzcncVar.zze;
        zzfcaVar = zzcncVar.zzf;
        zzfcaVar2 = zzcncVar.zzf;
        List zze = zzfjuVar.zze(zzfcnVar, zzfcaVar, false, "", str, zzfcaVar2.zzc, null);
        zzbzs zzp = com.google.android.gms.ads.internal.zzv.zzp();
        context = zzcncVar.zza;
        zzfdiVar.zzc(zze, true == zzp.zzA(context) ? 2 : 1);
    }
}
