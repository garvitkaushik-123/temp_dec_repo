package com.google.android.gms.internal.ads;

import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzfkz implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ com.google.android.gms.ads.internal.client.zzea zzb;
    final /* synthetic */ zzfld zzc;

    zzfkz(zzfld zzfldVar, long j, com.google.android.gms.ads.internal.client.zzea zzeaVar) {
        this.zza = j;
        this.zzb = zzeaVar;
        Objects.requireNonNull(zzfldVar);
        this.zzc = zzfldVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzfkl zzfklVar;
        zzfkl zzfklVar2;
        String zzO;
        zzfkt zzfktVar;
        String zzD;
        zzfld zzfldVar = this.zzc;
        zzfklVar = zzfldVar.zzp;
        if (zzfklVar != null) {
            zzfklVar2 = zzfldVar.zzp;
            long j = this.zza;
            zzO = zzfld.zzO(this.zzb);
            zzfktVar = zzfldVar.zzr;
            int i = zzfldVar.zze.zzd;
            int zzd = zzfldVar.zzd();
            zzD = zzfldVar.zzD();
            zzfklVar2.zzi(j, zzO, zzfktVar, i, zzd, zzD);
        }
    }
}
