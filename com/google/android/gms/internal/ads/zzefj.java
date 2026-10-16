package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzefj implements zzdgn {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final ListenableFuture zzc;
    private final zzfca zzd;
    private final zzcfg zze;
    private final zzfcw zzf;
    private final zzbki zzg;
    private final boolean zzh;
    private final zzecl zzi;
    private final zzdsj zzj;

    zzefj(Context context, VersionInfoParcel versionInfoParcel, ListenableFuture listenableFuture, zzfca zzfcaVar, zzcfg zzcfgVar, zzfcw zzfcwVar, boolean z, zzbki zzbkiVar, zzecl zzeclVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = listenableFuture;
        this.zzd = zzfcaVar;
        this.zze = zzcfgVar;
        this.zzf = zzfcwVar;
        this.zzg = zzbkiVar;
        this.zzh = z;
        this.zzi = zzeclVar;
        this.zzj = zzdsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final zzfca zza() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final void zzb(boolean z, Context context, zzcwl zzcwlVar) {
        zzdfc zzdfcVar = (zzdfc) zzgdn.zzq(this.zzc);
        zzcfg zzcfgVar = this.zze;
        zzcfgVar.zzaq(true);
        boolean z2 = this.zzh;
        boolean zze = z2 ? this.zzg.zze(false) : false;
        com.google.android.gms.ads.internal.zzv.zzr();
        boolean zzJ = com.google.android.gms.ads.internal.util.zzs.zzJ(this.zza);
        boolean z3 = z2 && this.zzg.zzd();
        float zza = z2 ? this.zzg.zza() : 0.0f;
        zzfca zzfcaVar = this.zzd;
        com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zze, zzJ, z3, zza, -1, z, zzfcaVar.zzO, false);
        if (zzcwlVar != null) {
            zzcwlVar.zzf();
        }
        com.google.android.gms.ads.internal.zzv.zzj();
        zzdgc zzh = zzdfcVar.zzh();
        int i = zzfcaVar.zzQ;
        VersionInfoParcel versionInfoParcel = this.zzb;
        String str = zzfcaVar.zzB;
        zzfcf zzfcfVar = zzfcaVar.zzs;
        String str2 = zzfcfVar.zzb;
        String str3 = zzfcfVar.zza;
        zzfcw zzfcwVar = this.zzf;
        com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel(null, zzh, null, zzcfgVar, i, versionInfoParcel, str, zzlVar, str2, str3, zzfcwVar.zzf, zzcwlVar, zzfcaVar.zzb() ? this.zzi : null, zzcfgVar.zzr()), true, this.zzj);
    }
}
