package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
final class zzcjp implements com.google.android.gms.ads.nonagon.signalgeneration.zzab {
    private final zzcio zza;
    private zzcvh zzb;
    private com.google.android.gms.ads.nonagon.signalgeneration.zzaz zzc;

    /* synthetic */ zzcjp(zzcio zzcioVar, zzcjs zzcjsVar) {
        this.zza = zzcioVar;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzab
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzab zza(zzcvh zzcvhVar) {
        this.zzb = zzcvhVar;
        return this;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzab
    public final /* bridge */ /* synthetic */ com.google.android.gms.ads.nonagon.signalgeneration.zzab zzb(com.google.android.gms.ads.nonagon.signalgeneration.zzaz zzazVar) {
        this.zzc = zzazVar;
        return this;
    }

    @Override // com.google.android.gms.ads.nonagon.signalgeneration.zzab
    public final com.google.android.gms.ads.nonagon.signalgeneration.zzac zzc() {
        zzhgz.zzc(this.zzb, zzcvh.class);
        zzhgz.zzc(this.zzc, com.google.android.gms.ads.nonagon.signalgeneration.zzaz.class);
        return new zzcjq(this.zza, this.zzc, new zzcsg(), new zzcuh(), new zzdsy(), this.zzb, null, null);
    }
}
