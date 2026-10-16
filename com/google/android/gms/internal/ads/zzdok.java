package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzdok implements zzbkw {
    private final zzcxf zza;
    private final zzbwo zzb;
    private final String zzc;
    private final String zzd;

    public zzdok(zzcxf zzcxfVar, zzfca zzfcaVar) {
        this.zza = zzcxfVar;
        this.zzb = zzfcaVar.zzl;
        this.zzc = zzfcaVar.zzj;
        this.zzd = zzfcaVar.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzbkw
    @ParametersAreNonnullByDefault
    public final void zza(zzbwo zzbwoVar) {
        int i;
        String str;
        zzbwo zzbwoVar2 = this.zzb;
        if (zzbwoVar2 != null) {
            zzbwoVar = zzbwoVar2;
        }
        if (zzbwoVar != null) {
            str = zzbwoVar.zza;
            i = zzbwoVar.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zzd(new zzbvz(str, i), this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzbkw
    public final void zzb() {
        this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzbkw
    public final void zzc() {
        this.zza.zzf();
    }
}
