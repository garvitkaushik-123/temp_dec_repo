package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzgmz implements zzgfa {
    final String zza;
    final Class zzb;
    final zzgtz zzc;

    zzgmz(String str, Class cls, zzgtz zzgtzVar, zzhba zzhbaVar) {
        this.zza = str;
        this.zzb = cls;
        this.zzc = zzgtzVar;
    }

    public static zzgfa zzd(String str, Class cls, zzgtz zzgtzVar, zzhba zzhbaVar) {
        return new zzgmz(str, cls, zzgtzVar, zzhbaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final zzgub zza(zzgxz zzgxzVar) throws GeneralSecurityException {
        zzgud zza = zzguf.zza();
        zza.zzb(this.zza);
        zza.zzc(zzgxzVar);
        zza.zza(zzgvf.RAW);
        zzgox zzgoxVar = (zzgox) zzgny.zzc().zzd(zzgno.zzb().zza(zzgny.zzc().zzb(zzgoy.zza((zzguf) zza.zzbr())), null), zzgox.class, zzgey.zza());
        zzgty zza2 = zzgub.zza();
        zza2.zzb(zzgoxVar.zzg());
        zza2.zzc(zzgoxVar.zze());
        zza2.zza(zzgoxVar.zzb());
        return (zzgub) zza2.zzbr();
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final Class zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgfa
    public final Object zzc(zzgxz zzgxzVar) throws GeneralSecurityException {
        return zzgnv.zza().zzb(zzgny.zzc().zza(zzgox.zza(this.zza, zzgxzVar, this.zzc, zzgvf.RAW, null), zzgey.zza()), this.zzb);
    }
}
