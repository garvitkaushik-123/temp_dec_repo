package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcpu implements zzcws {
    private final zzcfg zza;
    private final zzdsj zzb;
    private final zzfca zzc;

    zzcpu(zzcfg zzcfgVar, zzdsj zzdsjVar, zzfca zzfcaVar) {
        this.zza = zzcfgVar;
        this.zzb = zzdsjVar;
        this.zzc = zzfcaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcws
    public final void zzt() {
        zzcfg zzcfgVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzb(zzbde.zznn)).booleanValue() || (zzcfgVar = this.zza) == null) {
            return;
        }
        String str = true != com.google.android.gms.ads.internal.util.zzac.zza(zzcfgVar.zzF()) ? "0" : "1";
        zzdsi zza = this.zzb.zza();
        zza.zzb("action", "hcp");
        zza.zzb("hcp", str);
        zza.zzc(this.zzc);
        zza.zzj();
    }
}
