package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzedz implements zzdgn {
    private final VersionInfoParcel zza;
    private final ListenableFuture zzb;
    private final zzfca zzc;
    private final zzcfg zzd;
    private final zzfcw zze;
    private final zzbki zzf;
    private final boolean zzg;
    private final zzecl zzh;
    private final zzdsj zzi;

    zzedz(VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfca zzfcaVar, zzcfg zzcfgVar, zzfcw zzfcwVar, boolean z, zzbki zzbkiVar, zzecl zzeclVar, zzdsj zzdsjVar) {
        this.zza = versionInfoParcel;
        this.zzb = listenableFuture;
        this.zzc = zzfcaVar;
        this.zzd = zzcfgVar;
        this.zze = zzfcwVar;
        this.zzg = z;
        this.zzf = zzbkiVar;
        this.zzh = zzeclVar;
        this.zzi = zzdsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final zzfca zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final void zzb(boolean z, Context context, zzcwl zzcwlVar) {
        zzcod zzcodVar = (zzcod) zzgdn.zzq(this.zzb);
        zzcfg zzcfgVar = this.zzd;
        zzcfgVar.zzaq(true);
        boolean z2 = this.zzg;
        boolean zze = z2 ? this.zzf.zze(true) : true;
        boolean z3 = z2 && this.zzf.zzd();
        float zza = z2 ? this.zzf.zza() : 0.0f;
        zzfca zzfcaVar = this.zzc;
        com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zze, true, z3, zza, -1, z, zzfcaVar.zzO, false);
        if (zzcwlVar != null) {
            zzcwlVar.zzf();
        }
        com.google.android.gms.ads.internal.zzv.zzj();
        zzdgc zzg = zzcodVar.zzg();
        int i = zzfcaVar.zzQ;
        if (i == -1) {
            com.google.android.gms.ads.internal.client.zzx zzxVar = this.zze.zzj;
            if (zzxVar != null) {
                int i2 = zzxVar.zza;
                if (i2 == 1) {
                    i = 7;
                } else if (i2 == 2) {
                    i = 6;
                }
            }
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zze("Error setting app open orientation; no targeting orientation available.");
        }
        VersionInfoParcel versionInfoParcel = this.zza;
        String str = zzfcaVar.zzB;
        zzfcf zzfcfVar = zzfcaVar.zzs;
        String str2 = zzfcfVar.zzb;
        String str3 = zzfcfVar.zza;
        zzfcw zzfcwVar = this.zze;
        com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel(null, zzg, null, zzcfgVar, i, versionInfoParcel, str, zzlVar, str2, str3, zzfcwVar.zzf, zzcwlVar, zzfcaVar.zzb() ? this.zzh : null, zzcfgVar.zzr()), true, this.zzi);
    }
}
