package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzenh implements zzhgr {
    private final zzhha zza;

    private zzenh(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar2;
    }

    public static zzenh zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzenh(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzenf zzb() {
        return new zzenf(zzffu.zzc(), ((zzchl) this.zza).zza());
    }
}
