package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcjb implements zzdtl {
    private final zzcio zza;
    private final zzcje zzb;
    private Long zzc;
    private String zzd;

    /* synthetic */ zzcjb(zzcio zzcioVar, zzcje zzcjeVar, zzcjs zzcjsVar) {
        this.zza = zzcioVar;
        this.zzb = zzcjeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdtl
    public final /* bridge */ /* synthetic */ zzdtl zzb(long j) {
        this.zzc = Long.valueOf(j);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdtl
    public final zzdtm zzc() {
        zzhgz.zzc(this.zzc, Long.class);
        zzhgz.zzc(this.zzd, String.class);
        return new zzcjc(this.zza, this.zzb, this.zzc, this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzdtl
    public final /* bridge */ /* synthetic */ zzdtl zza(String str) {
        str.getClass();
        this.zzd = str;
        return this;
    }
}
