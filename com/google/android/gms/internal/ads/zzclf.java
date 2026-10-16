package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@24.5.0 */
/* loaded from: classes5.dex */
public final class zzclf implements zzhgr {
    private final zzhha zza;
    private final zzhha zzb;

    private zzclf(zzhha zzhhaVar, zzhha zzhhaVar2) {
        this.zza = zzhhaVar;
        this.zzb = zzhhaVar2;
    }

    public static zzclf zzc(zzhha zzhhaVar, zzhha zzhhaVar2) {
        return new zzclf(zzhhaVar, zzhhaVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzhhg, com.google.android.gms.internal.ads.zzhhf
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcle zzb() {
        return new zzcle(((zzhgv) this.zza).zzb(), ((zzhgv) this.zzb).zzb());
    }
}
