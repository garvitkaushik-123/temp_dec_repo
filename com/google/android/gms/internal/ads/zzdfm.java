package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdfm implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;
    private final zzhha zzc;
    private final zzhha zzd;

    private zzdfm(zzdff zzdffVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
        this.zzc = zzhhaVar3;
        this.zzd = zzhhaVar4;
    }

    public static zzdfm zza(zzdff zzdffVar, zzhha zzhhaVar, zzhha zzhhaVar2, zzhha zzhhaVar3, zzhha zzhhaVar4) {
        return new zzdfm(zzdffVar, zzhhaVar, zzhhaVar2, zzhhaVar3, zzhhaVar4);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    public final /* bridge */ /* synthetic */ Object zzb() {
        final Context context = (Context) this.zza.zzb();
        final VersionInfoParcel zza = ((zzchz) this.zzb).zza();
        final zzfca zzc = ((zzcrr) this.zzc).zzc();
        final zzfcw zzc2 = ((zzcvp) this.zzd).zzc();
        return new zzddv(new zzcxm() { // from class: com.google.android.gms.internal.ads.zzdfd
            @Override // com.google.android.gms.internal.ads.zzcxm
            public final void zzu() {
                com.google.android.gms.ads.internal.util.zzay zzu = com.google.android.gms.ads.internal.zzv.zzu();
                Context context2 = context;
                zzfcw zzfcwVar = zzc2;
                zzu.zzn(context2, zza.afmaVersion, zzc.zzC.toString(), zzfcwVar.zzf);
            }
        }, zzcaf.zzg);
    }
}
