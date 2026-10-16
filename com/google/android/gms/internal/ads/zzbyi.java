package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzbyi extends zzbyp {
    final zzhha zza;
    final zzhha zzb;
    final zzhha zzc;
    final zzhha zzd;
    final zzhha zze;
    final zzhha zzf;
    final zzhha zzg;
    final zzhha zzh;
    private final Clock zzj;

    zzbyi(Context context, Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbyo zzbyoVar) {
        this.zzj = clock;
        zzhgr zza = zzhgs.zza(context);
        this.zza = zza;
        zzhgr zza2 = zzhgs.zza(zzgVar);
        this.zzb = zza2;
        this.zzc = zzhgq.zzc(zzbyc.zza(zza, zza2));
        zzhgr zza3 = zzhgs.zza(clock);
        this.zzd = zza3;
        zzhgr zza4 = zzhgs.zza(zzbyoVar);
        this.zze = zza4;
        zzhha zzc = zzhgq.zzc(zzbye.zza(zza3, zza2, zza4));
        this.zzf = zzc;
        zzbyg zzc2 = zzbyg.zzc(zza3, zzc);
        this.zzg = zzc2;
        this.zzh = zzhgq.zzc(zzbyu.zza(zza, zzc2));
    }

    @Override // com.google.android.gms.internal.ads.zzbyp
    final zzbyf zza() {
        return new zzbyf(this.zzj, (zzbyd) this.zzf.zzb());
    }
}
