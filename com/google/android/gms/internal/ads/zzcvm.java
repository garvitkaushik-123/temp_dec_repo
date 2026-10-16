package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzcvm implements zzhgr {
    private final zzhha zza;

    private zzcvm(zzcvh zzcvhVar, zzhha zzhhaVar) {
        this.zza = zzhhaVar;
    }

    public static zzcvm zza(zzcvh zzcvhVar, zzhha zzhhaVar) {
        return new zzcvm(zzcvhVar, zzhhaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zzb() {
        String zzg = ((zzcsq) this.zza.zzb()).zzg();
        zzhgz.zzb(zzg);
        return zzg;
    }
}
