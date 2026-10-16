package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzeid implements zzdgn {
    private final Context zza;
    private final zzdpj zzb;
    private final zzfcw zzc;
    private final VersionInfoParcel zzd;
    private final zzfca zze;
    private final ListenableFuture zzf;
    private final zzcfg zzg;
    private final zzbki zzh;
    private final boolean zzi;
    private final zzecl zzj;
    private final zzdsd zzk;
    private final zzdsj zzl;

    zzeid(Context context, zzdpj zzdpjVar, zzfcw zzfcwVar, VersionInfoParcel versionInfoParcel, zzfca zzfcaVar, ListenableFuture listenableFuture, zzcfg zzcfgVar, zzbki zzbkiVar, boolean z, zzecl zzeclVar, zzdsd zzdsdVar, zzdsj zzdsjVar) {
        this.zza = context;
        this.zzb = zzdpjVar;
        this.zzc = zzfcwVar;
        this.zzd = versionInfoParcel;
        this.zze = zzfcaVar;
        this.zzf = listenableFuture;
        this.zzg = zzcfgVar;
        this.zzh = zzbkiVar;
        this.zzi = z;
        this.zzj = zzeclVar;
        this.zzk = zzdsdVar;
        this.zzl = zzdsjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final zzfca zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzdgn
    public final void zzb(boolean z, Context context, zzcwl zzcwlVar) {
        zzdoo zzdooVar = (zzdoo) zzgdn.zzq(this.zzf);
        try {
            zzfca zzfcaVar = this.zze;
            final zzcfg zzcfgVar = this.zzg;
            if (zzcfgVar.zzaG()) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zzbb)).booleanValue()) {
                    zzcfgVar = this.zzb.zza(this.zzc.zze, null, null);
                    zzbkx.zzb(zzcfgVar, zzdooVar.zzg());
                    final zzdpn zzdpnVar = new zzdpn();
                    zzdpnVar.zza(this.zza, zzcfgVar.zzF());
                    zzdooVar.zzl().zzi(zzcfgVar, true, this.zzi ? this.zzh : null, this.zzk.zza());
                    zzcfgVar.zzN().zzC(new zzcgw() { // from class: com.google.android.gms.internal.ads.zzeib
                        @Override // com.google.android.gms.internal.ads.zzcgw
                        public final void zza(boolean z2, int i, String str, String str2) {
                            zzdpn.this.zzb();
                            zzcfg zzcfgVar2 = zzcfgVar;
                            zzcfgVar2.zzab();
                            zzcfgVar2.zzN().zzs();
                        }
                    });
                    zzcgy zzN = zzcfgVar.zzN();
                    Objects.requireNonNull(zzcfgVar);
                    zzN.zzK(new zzcgx() { // from class: com.google.android.gms.internal.ads.zzeic
                        @Override // com.google.android.gms.internal.ads.zzcgx
                        public final void zza() {
                            zzcfg.this.zzaa();
                        }
                    });
                    zzfcf zzfcfVar = zzfcaVar.zzs;
                    zzcfgVar.zzae(zzfcfVar.zzb, zzfcfVar.zza, null);
                }
            }
            zzcfg zzcfgVar2 = zzcfgVar;
            zzcfgVar2.zzaq(true);
            boolean z2 = this.zzi;
            boolean z3 = false;
            boolean zze = z2 ? this.zzh.zze(false) : false;
            com.google.android.gms.ads.internal.zzv.zzr();
            boolean zzJ = com.google.android.gms.ads.internal.util.zzs.zzJ(this.zza);
            if (z2 && this.zzh.zzd()) {
                z3 = true;
            }
            float zza = z2 ? this.zzh.zza() : 0.0f;
            zzfca zzfcaVar2 = this.zze;
            com.google.android.gms.ads.internal.zzl zzlVar = new com.google.android.gms.ads.internal.zzl(zze, zzJ, z3, zza, -1, z, zzfcaVar2.zzO, zzfcaVar2.zzP);
            if (zzcwlVar != null) {
                zzcwlVar.zzf();
            }
            com.google.android.gms.ads.internal.zzv.zzj();
            zzdgc zzh = zzdooVar.zzh();
            int i = zzfcaVar2.zzQ;
            VersionInfoParcel versionInfoParcel = this.zzd;
            String str = zzfcaVar2.zzB;
            zzfcf zzfcfVar2 = zzfcaVar2.zzs;
            com.google.android.gms.ads.internal.overlay.zzn.zza(context, new AdOverlayInfoParcel(null, zzh, null, zzcfgVar2, i, versionInfoParcel, str, zzlVar, zzfcfVar2.zzb, zzfcfVar2.zza, this.zzc.zzf, zzcwlVar, zzfcaVar2.zzb() ? this.zzj : null, zzcfgVar2.zzr()), true, this.zzl);
        } catch (zzcfs e) {
            int i2 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("", e);
        }
    }
}
